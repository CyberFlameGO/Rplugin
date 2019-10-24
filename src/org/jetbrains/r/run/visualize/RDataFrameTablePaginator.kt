/*
 * Copyright 2000-2019 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
 */

package org.jetbrains.r.run.visualize

import com.intellij.icons.AllIcons
import com.intellij.openapi.actionSystem.ActionPlaces
import com.intellij.openapi.actionSystem.ActionToolbar
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.impl.ActionButton
import com.intellij.openapi.ui.ComboBox
import java.awt.BorderLayout
import java.awt.FlowLayout
import javax.swing.*
import javax.swing.event.DocumentEvent
import javax.swing.event.DocumentListener
import javax.swing.event.RowSorterEvent
import javax.swing.event.RowSorterListener
import kotlin.math.max
import kotlin.math.min

class RDataFrameTablePaginator(private val rowSorter: RDataFrameRowSorter, parentPanel: JPanel) : JPanel(BorderLayout()) {
  private val pageSizeComponent = ComboBox<Int>(arrayOf(10, 15, 30, 100))
  private var currentPageComponent = JTextField()
  private val totalPagesComponent = JLabel()
  val label = JLabel()

  private lateinit var toFirst: ActionButton
  private lateinit var toPrevious: ActionButton
  private lateinit var toNext: ActionButton
  private lateinit var toLast: ActionButton

  private var currentPageIndex = 0
  private var currentPageSize = 10
  private var currentPageChanging = false

  private val rowSorterListener = RowSorterListener { if (it.type == RowSorterEvent.Type.SORTED) updateInfo() }
    .also { rowSorter.addRowSorterListener(it) }

  init {
    createActionButtons()

    currentPageComponent.document.addDocumentListener(object : DocumentListener {
      private fun updatePageOffset() {
        if (currentPageChanging) return
        currentPageIndex = currentPageComponent.text.toIntOrNull() ?: return
        updateInfo()
      }

      override fun changedUpdate(e: DocumentEvent?) = updatePageOffset()

      override fun insertUpdate(e: DocumentEvent?) = updatePageOffset()

      override fun removeUpdate(e: DocumentEvent?) = updatePageOffset()
    })

    pageSizeComponent.isEditable = true

    val editorComponent = pageSizeComponent.editor.editorComponent as? JComponent
    editorComponent?.putClientProperty("AuxEditorComponent", true)

    pageSizeComponent.addActionListener {
      if (pageSizeComponent.selectedItem is Int) {
        if (currentPageChanging) return@addActionListener
        val newPageSize = pageSizeComponent.selectedItem as Int
        currentPageIndex = currentPageIndex * currentPageSize / newPageSize
        currentPageSize = newPageSize
        updateInfo()
      }
    }

    val rightPanel = JPanel()
    rightPanel.add(pageSizeComponent)
    add(rightPanel, BorderLayout.LINE_END)

    val panel = JPanel(FlowLayout(FlowLayout.LEFT))
    panel.add(toFirst)
    panel.add(toPrevious)
    panel.add(JToolBar.Separator())
    panel.add(JLabel("Page"))
    currentPageComponent.putClientProperty("AuxEditorComponent", true)
    panel.add(currentPageComponent)
    panel.add(totalPagesComponent)
    panel.add(JToolBar.Separator())
    panel.add(toNext)
    panel.add(toLast)
    panel.add(JToolBar.Separator())
    panel.add(label)
    add(panel, BorderLayout.LINE_START)

    parentPanel.add(this, BorderLayout.SOUTH)
    parentPanel.revalidate()
    updateInfo()
  }

  fun cleanUp() {
    rowSorter.removeRowSorterListener(rowSorterListener)
    if (parent != null) {
      val capturedParent = parent
      capturedParent.remove(this)
      capturedParent.revalidate()
    }
    rowSorter.shownRange = null
  }

  private fun getPagesCount() = max(1, (rowSorter.modelRowCount + currentPageSize - 1) / currentPageSize)

  private fun updateInfo() {
    currentPageChanging = true
    val rowCount = rowSorter.modelRowCount
    val pagesCount = getPagesCount()
    if (currentPageIndex <= 0) {
      currentPageIndex = 0
      toFirst.isEnabled = false
      toPrevious.isEnabled = false
    } else {
      toFirst.isEnabled = true
      toPrevious.isEnabled = true
    }
    if (currentPageIndex >= pagesCount - 1) {
      currentPageIndex = pagesCount - 1
      toLast.isEnabled = false
      toNext.isEnabled = false
    } else {
      toLast.isEnabled = true
      toNext.isEnabled = true
    }
    currentPageSize = max(currentPageSize, 1)

    val start = currentPageIndex * currentPageSize
    val end = min((currentPageIndex + 1) * currentPageSize, rowCount)
    label.text = if (start == end) "" else "Displaying ${start + 1} to $end of $rowCount"
    currentPageComponent.text = (currentPageIndex + 1).toString()
    totalPagesComponent.text = "Of $pagesCount"
    pageSizeComponent.selectedItem = currentPageSize
    rowSorter.shownRange = Pair(start, end)

    currentPageChanging = false
  }

  private fun createActionButtons() {
    var action: AnAction = object : AnAction("First ", "Go to first page", AllIcons.Actions.Play_first) {
      override fun actionPerformed(e: AnActionEvent) {
        currentPageIndex = 0
        updateInfo()
      }
    }
    toFirst = ActionButton(action, action.templatePresentation, ActionPlaces.UNKNOWN, ActionToolbar.DEFAULT_MINIMUM_BUTTON_SIZE)

    action = object : AnAction("Previous", "Show previous page", AllIcons.Actions.Play_back) {
      override fun actionPerformed(e: AnActionEvent) {
        currentPageIndex--
        updateInfo()
      }
    }
    toPrevious = ActionButton(action, action.templatePresentation, ActionPlaces.UNKNOWN, ActionToolbar.DEFAULT_MINIMUM_BUTTON_SIZE)

    action = object : AnAction("Next", "Show next page", AllIcons.Actions.Play_forward) {
      override fun actionPerformed(e: AnActionEvent) {
        currentPageIndex++
        updateInfo()
      }
    }
    toNext = ActionButton(action, action.templatePresentation, ActionPlaces.UNKNOWN, ActionToolbar.DEFAULT_MINIMUM_BUTTON_SIZE)

    action = object : AnAction("Last", "Go to last page", AllIcons.Actions.Play_last) {
      override fun actionPerformed(e: AnActionEvent) {
        currentPageIndex = getPagesCount() - 1
        updateInfo()
      }
    }
    toLast = ActionButton(action, action.templatePresentation, ActionPlaces.UNKNOWN, ActionToolbar.DEFAULT_MINIMUM_BUTTON_SIZE)
  }
}
