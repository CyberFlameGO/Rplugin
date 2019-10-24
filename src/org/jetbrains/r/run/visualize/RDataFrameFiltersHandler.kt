/*
 * Copyright 2000-2019 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
 */

package icons.org.jetbrains.r.run.visualize

import org.intellij.datavis.inlays.table.filters.IFilter
import org.intellij.datavis.inlays.table.filters.IParser
import org.intellij.datavis.inlays.table.filters.gui.AbstractFiltersHandler
import org.intellij.datavis.inlays.table.filters.gui.ChoicesHandler
import org.intellij.datavis.inlays.table.filters.gui.IFilterEditor
import org.intellij.datavis.inlays.table.filters.gui.ParserModel
import org.intellij.datavis.inlays.table.filters.gui.editor.FilterEditor
import org.jetbrains.r.rinterop.Service.DataFrameFilterRequest.Filter
import org.jetbrains.r.run.visualize.RDataFrameRowSorter
import org.jetbrains.r.run.visualize.RFilterParser
import org.jetbrains.r.run.visualize.RRowFilter
import javax.swing.RowFilter
import javax.swing.table.TableModel

class RDataFrameFiltersHandler : AbstractFiltersHandler() {
  override var currentFilter: RowFilter<*, *>? = null
    set(value) {
      field = value
      (sorter as? RDataFrameRowSorter)?.rowFilter = (value as? RRowFilter)?.proto
    }
  override val choicesHandler: ChoicesHandler = MyChoicesHandler()
  override var isFilterOnUpdates = true
  override var isAdaptiveChoices = false

  init {
    parserModel = object : ParserModel() {
      override fun createParser(editor: IFilterEditor): IParser {
        return RFilterParser(editor.modelIndex)
      }
    }
  }

  private inner class MyChoicesHandler : ChoicesHandler(this) {
    override fun getRowFilter(): RRowFilter {
      val filters = this@RDataFrameFiltersHandler.filters.asSequence()
        .filterIsInstance<FilterEditor.EditorFilter>()
        .map { it.delegate }
        .filterIsInstance<RRowFilter>()
        .map { it.proto }
        .filter { !it.hasTrue() }
        .toList()
      val proto = Filter.newBuilder()
        .setComposed(Filter.ComposedFilter.newBuilder().setType(Filter.ComposedFilter.Type.AND).addAllFilters(filters)).build()
      return RRowFilter(proto)
    }

    override fun setInterrupted(interrupted: Boolean) = true
    override fun editorUpdated(editor: FilterEditor?) {}
    override fun filterUpdated(filter: IFilter?, retInfoRequired: Boolean) = true
    override fun filterOperation(start: Boolean) {}
    override fun filterEnabled(filter: IFilter?) {}
    override fun allFiltersDisabled() {}
    override fun consolidateFilterChanges(modelIndex: Int) {}
    override fun tableUpdated(model: TableModel?, eventType: Int, firstRow: Int, lastRow: Int, column: Int) {}
  }
}