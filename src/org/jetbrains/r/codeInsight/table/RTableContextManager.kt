package org.jetbrains.r.codeInsight.table

import com.intellij.openapi.extensions.ExtensionPointName
import com.intellij.psi.PsiElement
import com.intellij.util.Processor
import org.jetbrains.r.psi.TableColumnInfo

interface RTableContextManager {
  companion object {
    val EP_NAME = ExtensionPointName.create<RTableContextManager>("org.jetbrains.r.tableContextProvider")

    fun processColumnsInContext(context: PsiElement, processor: Processor<TableColumnInfo>): Boolean {
      for (tableContextManager in EP_NAME.extensions) {
        if (!tableContextManager.processColumnsInContext(context, processor)) {
          return false
        }
      }
      return true
    }
  }

  fun processColumnsInContext(context: PsiElement, processor: Processor<TableColumnInfo>): Boolean
}