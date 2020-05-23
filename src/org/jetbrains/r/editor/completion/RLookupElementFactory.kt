/*
 * Copyright 2000-2020 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
 */

package org.jetbrains.r.editor.completion

import com.intellij.codeInsight.AutoPopupController
import com.intellij.codeInsight.completion.BasicInsertHandler
import com.intellij.codeInsight.completion.InsertHandler
import com.intellij.codeInsight.completion.PrioritizedLookupElement
import com.intellij.codeInsight.lookup.LookupElement
import com.intellij.codeInsight.lookup.LookupElementPresentation
import com.intellij.icons.AllIcons
import com.intellij.openapi.util.TextRange
import org.jetbrains.r.packages.RPackage
import org.jetbrains.r.psi.api.RAssignmentStatement
import org.jetbrains.r.refactoring.RNamesValidator
import javax.swing.Icon
import kotlin.math.min

const val TABLE_MANIPULATION_PRIORITY = 110.0
const val IMPORT_PACKAGE_PRIORITY = 110.0
const val NAMED_ARGUMENT_PRIORITY = 100.0
const val VARIABLE_GROUPING = 90
const val PACKAGE_PRIORITY = -1.0
const val GLOBAL_GROUPING = 0
const val NAMESPACE_NAME_GROUPING = -1

class RLookupElement(private val lookup: String,
                     private val bold: Boolean,
                     private val icon: Icon? = null,
                     private val packageName: String? = null,
                     private val tailText: String? = null,
                     private val itemText: String = lookup) : LookupElement() {

  override fun getLookupString() = lookup

  override fun renderElement(presentation: LookupElementPresentation) {
    presentation.itemText = itemText
    presentation.isItemTextBold = bold
    presentation.icon = icon
    presentation.typeText = packageName
    if (tailText != null) presentation.appendTailText(tailText, true)
  }
}

interface RLookupElementInsertHandler {
  fun getInsertHandlerForAssignment(assignment: RAssignmentStatement): InsertHandler<LookupElement>
}

class REmptyLookupElementInsertHandler : RLookupElementInsertHandler {
  override fun getInsertHandlerForAssignment(assignment: RAssignmentStatement) = BasicInsertHandler<LookupElement>()
}

class RLookupElementFactory(private val functionInsertHandler: RLookupElementInsertHandler = REmptyLookupElementInsertHandler(),
                            private val constantInsertHandler: RLookupElementInsertHandler = REmptyLookupElementInsertHandler()) {
  fun createGlobalLookupElement(assignment: RAssignmentStatement): LookupElement {
    return if (assignment.isFunctionDeclaration) {
      createFunctionLookupElement(assignment)
    }
    else {
      val name = assignment.name
      val packageName = RPackage.getOrCreateRPackageBySkeletonFile(assignment.containingFile)?.name
      val icon = AllIcons.Nodes.Constant
      createLookupElementWithGrouping(RLookupElement(name, false, icon, packageName),
                                      constantInsertHandler.getInsertHandlerForAssignment(assignment), GLOBAL_GROUPING)
    }
  }

  fun createFunctionLookupElement(functionAssignment: RAssignmentStatement, isLocal: Boolean = false): LookupElement {
    if (functionAssignment.name.startsWith("%")) return createOperatorLookupElement(functionAssignment, isLocal)
    val packageName = if (isLocal) null else RPackage.getOrCreateRPackageBySkeletonFile(functionAssignment.containingFile)?.name
    val icon = AllIcons.Nodes.Function
    val tailText = functionAssignment.functionParameters
    return createLookupElementWithGrouping(RLookupElement(functionAssignment.name, false, icon, packageName, tailText),
                                           functionInsertHandler.getInsertHandlerForAssignment(functionAssignment),
                                           if (isLocal) VARIABLE_GROUPING else GLOBAL_GROUPING)
  }

  fun createNamedArgumentLookupElement(lookupString: String): LookupElement {
    val icon = AllIcons.Nodes.Parameter
    val insertHandler = InsertHandler<LookupElement> { context, _ ->
      val document = context.document
      document.insertString(context.tailOffset, " = ")
      context.editor.caretModel.moveCaretRelatively(3, 0, false, false, false)
    }
    return createLookupElementWithPriority(RLookupElement(lookupString, true, icon, tailText = " = "),
                                           insertHandler, NAMED_ARGUMENT_PRIORITY)
  }

  fun createNamespaceAccess(lookupString: String): LookupElement {
    val insertHandler = InsertHandler<LookupElement> { context, _ ->
      val document = context.document
      document.replaceString(context.startOffset, context.tailOffset, RNamesValidator.quoteIfNeeded(lookupString))
      context.editor.caretModel.moveToOffset(context.tailOffset)
    }
    return createLookupElementWithGrouping(RLookupElement(lookupString, false, AllIcons.Nodes.Package),
                                           insertHandler, NAMESPACE_NAME_GROUPING)
  }

  fun createLocalVariableLookupElement(lookupString: String, isParameter: Boolean): LookupElement {
    val icon = if (isParameter) AllIcons.Nodes.Parameter else AllIcons.Nodes.Variable
    return PrioritizedLookupElement.withGrouping(RLookupElement(lookupString, true, icon), VARIABLE_GROUPING)
  }

  fun createPackageLookupElement(lookupString: String, inImport: Boolean): LookupElement {
    return if (inImport) {
      PrioritizedLookupElement.withPriority(RLookupElement(lookupString, true, AllIcons.Nodes.Package), IMPORT_PACKAGE_PRIORITY)
    }
    else {
      val insertHandler = InsertHandler<LookupElement> { context, _ ->
        val document = context.document
        document.insertString(context.tailOffset, "::")
        AutoPopupController.getInstance(context.project).scheduleAutoPopup(context.editor)
        context.editor.caretModel.moveCaretRelatively(2, 0, false, false, false)
      }
      createLookupElementWithPriority(RLookupElement(lookupString, true, AllIcons.Nodes.Package, tailText = "::"),
                                      insertHandler, PACKAGE_PRIORITY)
    }
  }

  private fun createOperatorLookupElement(functionAssignment: RAssignmentStatement, isLocal: Boolean): LookupElement {
    val packageName = if (isLocal) null else RPackage.getOrCreateRPackageBySkeletonFile(functionAssignment.containingFile)?.name
    val icon = AllIcons.Nodes.Function
    val insertHandler = InsertHandler<LookupElement> { context, _ ->
      val document = context.document
      val startOffset = context.tailOffset
      val endOffset = min(context.tailOffset + 1, document.textLength)
      if (endOffset <= startOffset) return@InsertHandler
      if (document.getText(TextRange(startOffset, endOffset)) == "%") {
        document.replaceString(startOffset, endOffset, "")
      }
    }
    return createLookupElementWithGrouping(RLookupElement(functionAssignment.name, false, icon, packageName),
                                           insertHandler, if (isLocal) VARIABLE_GROUPING else GLOBAL_GROUPING)
  }

  companion object {
    fun createLookupElementWithGrouping(lookupElement: LookupElement,
                                        insertHandler: InsertHandler<LookupElement>,
                                        grouping: Int): LookupElement {
      val lookupElementWithInsertHandler = PrioritizedLookupElement.withInsertHandler(lookupElement, insertHandler)
      return PrioritizedLookupElement.withGrouping(lookupElementWithInsertHandler, grouping)
    }

    fun createLookupElementWithPriority(lookupElement: LookupElement,
                                        insertHandler: InsertHandler<LookupElement>,
                                        priority: Double): LookupElement {
      val lookupElementWithInsertHandler = PrioritizedLookupElement.withInsertHandler(lookupElement, insertHandler)
      return PrioritizedLookupElement.withPriority(lookupElementWithInsertHandler, priority)
    }
  }
}