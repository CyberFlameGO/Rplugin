/*
 * Copyright 2000-2020 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
 */

package org.jetbrains.r.hints.parameterInfo

import com.intellij.codeInsight.hints.HintInfo
import com.intellij.codeInsight.hints.InlayInfo
import com.intellij.codeInsight.hints.InlayParameterHintsProvider
import com.intellij.codeInsight.hints.Option
import com.intellij.psi.PsiElement
import com.intellij.psi.util.PsiTreeUtil
import icons.org.jetbrains.r.RBundle
import org.jetbrains.r.packages.RSkeletonUtil
import org.jetbrains.r.psi.RPsiUtil
import org.jetbrains.r.psi.api.*
import org.jetbrains.r.skeleton.psi.RSkeletonAssignmentStatement

@Suppress("UnstableApiUsage")
class RInlayParameterHintsProvider : InlayParameterHintsProvider {

  override fun getSupportedOptions(): List<Option> = listOf(WRAP_DOTS_OPTION)

  override fun getDefaultBlackList(): Set<String> = setOf("(...)", "(x, ...)")

  override fun getParameterHints(element: PsiElement?): List<InlayInfo> {
    if (element !is RArgumentList) return emptyList()

    val isWrapDots = WRAP_DOTS_OPTION.isEnabled()
    val assignment = RPsiUtil.resolveCall(element.parent as RCallExpression).singleOrNull() ?: return emptyList()
    val result = mutableListOf<InlayInfo>()

    val parameterNames = assignment.parameterNameList
    val dotsArgIndex = parameterNames.indexOf(DOTS)
    var isLastDots = false

    lateinit var firstDotArg: RPsiElement
    lateinit var lastDotArg: RPsiElement
    val expressions = element.expressionList

    fun wrapDotsIfNeed() {
      if ((firstDotArg == expressions[0] || firstDotArg == lastDotArg)) return
      val startOffset = firstDotArg.textOffset
      if (!isWrapDots) {
        result.add(InlayInfo(DOTS, startOffset))
      }
      else {
        result.add(InlayInfo("$DOTS(", startOffset))
        result.add(InlayInfo(")", lastDotArg.textRange.endOffset))
      }
    }

    val permutation = RParameterInfoUtil.getArgumentsPermutation(parameterNames, element).first
    for (i in expressions.indices) {
      val parameterIndex = permutation[i]
      if (parameterIndex == -1) {
        if (isLastDots) {
          wrapDotsIfNeed()
          isLastDots = false
        }
        continue
      }

      val arg = expressions[i]
      if (parameterIndex == dotsArgIndex) {
        lastDotArg = arg
        if (isLastDots) continue

        firstDotArg = arg
        isLastDots = true
      }
      else {
        if (isMustProvideNameHint(arg)) {
          result.add(InlayInfo(parameterNames[parameterIndex], arg.textOffset))
        }
        else if (isLastDots) {
          wrapDotsIfNeed()
        }
        isLastDots = false
      }
    }

    if (isLastDots) {
      wrapDotsIfNeed()
    }
    return result
  }

  override fun getHintInfo(element: PsiElement): HintInfo? {
    if (element !is RArgumentList) return null
    val assignment = RPsiUtil.resolveCall(element.parent as RCallExpression).firstOrNull() ?: return null
    val fullName = if (assignment is RSkeletonAssignmentStatement) {
      RSkeletonUtil.parsePackageAndVersionFromSkeletonFilename(assignment.containingFile.name)!!.first + "::" + assignment.name
    }
    else assignment.name
    return HintInfo.MethodInfo(fullName, assignment.parameterNameList)
  }

  override fun getInlayPresentation(inlayText: String): String {
    return if (inlayText in listOf("...", "...(", ")")) inlayText else super.getInlayPresentation(inlayText)
  }

  override fun getBlacklistExplanationHTML(): String {
    return RBundle.message("inlay.hints.blacklist.pattern.explanation")
  }

  companion object {
    private val WRAP_DOTS_OPTION = Option("R_HINT_OPTION_WRAP_DOTS", RBundle.message("inlay.hints.wrap.dots.option.description"), true)

    private const val DOTS = "..."

    private fun isMustProvideNameHint(arg: PsiElement): Boolean {
      return PsiTreeUtil.instanceOf(arg, RStringLiteralExpression::class.java, RNumericLiteralExpression::class.java,
                                    RBooleanLiteral::class.java, RNullLiteral::class.java, RNaLiteral::class.java,
                                    RBoundaryLiteral::class.java)
             || arg is RIdentifierExpression && arg.name in listOf("T", "F")
    }
  }
}