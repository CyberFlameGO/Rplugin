/*
 * Copyright 2000-2020 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
 */

package org.jetbrains.r.ui

import com.intellij.openapi.actionSystem.ActionManager
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.DefaultActionGroup
import com.intellij.openapi.actionSystem.ex.ActionUtil
import com.intellij.util.ui.JBUI
import javax.swing.Icon
import javax.swing.JPanel

object RToolbarUtil {
  fun createToolbar(place: String, actionHolderGroups: List<List<ActionHolder>>, vararg additionalActions: AnAction): JPanel {
    val actionGroup = DefaultActionGroup().apply {
      for ((index, actionHoldersGroup) in actionHolderGroups.withIndex()) {
        if (index > 0) {
          addSeparator()
        }
        for (holder in actionHoldersGroup) {
          add(ToolbarAction(holder))
        }
      }
    }
    if (additionalActions.isNotEmpty()) {
      actionGroup.addSeparator()
      for (action in additionalActions) {
        actionGroup.add(action)
      }
    }
    val actionToolbar = ActionManager.getInstance().createActionToolbar(place, actionGroup, true)
    return JBUI.Panels.simplePanel(actionToolbar.component)
  }

  fun createActionHolder(id: String, onClick: () -> Unit): ActionHolder {
    return createActionHolder(id, { true }, onClick)
  }

  fun createActionHolder(id: String, canClick: () -> Boolean, onClick: () -> Unit) = object : ActionHolder {
    override val id = id

    override val canClick: Boolean
      get() = canClick()

    override fun onClick() {
      onClick()
    }
  }

  interface ActionHolder {
    val id: String
    val canClick: Boolean
    fun onClick()

    fun checkVisible(): Boolean {
      return true
    }

    fun getHintForDisabled(): String? {
      return null
    }

    fun getAlternativeEnabledIcon(): Icon? {
      return null
    }

    fun getAlternativeEnabledDescription(): String? {
      return null
    }
  }

  private class ToolbarAction(private val holder: ActionHolder) : AnAction() {
    private val fallbackDescription: String
    private val fallbackIcon: Icon

    init {
      ActionUtil.copyFrom(this, holder.id)
      fallbackDescription = templatePresentation.description
      fallbackIcon = templatePresentation.icon
    }

    override fun actionPerformed(e: AnActionEvent) {
      holder.onClick()
    }

    override fun update(e: AnActionEvent) {
      val isVisible = holder.checkVisible()
      e.presentation.isVisible = isVisible
      if (isVisible) {
        val isEnabled = holder.canClick
        e.presentation.isEnabled = isEnabled
        e.presentation.icon = createIcon(isEnabled)
        e.presentation.description = createDescription(isEnabled)
      }
    }

    override fun displayTextInToolbar(): Boolean {
      return true
    }

    private fun createIcon(isEnabled: Boolean): Icon {
      return holder.getAlternativeEnabledIcon()?.takeIf { isEnabled } ?: fallbackIcon
    }

    private fun createDescription(isEnabled: Boolean): String {
      return if (isEnabled) createEnabledDescription() else createDisabledDescription()
    }

    private fun createEnabledDescription(): String {
      return holder.getAlternativeEnabledDescription() ?: fallbackDescription
    }

    private fun createDisabledDescription(): String {
      return holder.getHintForDisabled()?.let { "$fallbackDescription ($it)" } ?: fallbackDescription
    }
  }
}
