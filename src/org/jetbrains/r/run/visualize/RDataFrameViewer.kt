/*
 * Copyright 2000-2019 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
 */

package org.jetbrains.r.run.visualize

import com.intellij.openapi.Disposable
import org.jetbrains.concurrency.Promise
import org.jetbrains.r.rinterop.Service
import javax.swing.RowSorter
import kotlin.reflect.KClass

interface RDataFrameViewer : Disposable {
  val nColumns: Int

  val nRows: Int

  fun getColumnName(index: Int): String

  fun getColumnType(index: Int): KClass<*>

  fun isColumnSortable(index: Int): Boolean

  fun getValueAt(row: Int, col: Int): Any?

  fun ensureLoaded(row: Int, col: Int, onLoadCallback: (() -> Unit)? = null): Promise<Unit>?

  fun sortBy(sortKeys: List<RowSorter.SortKey>): RDataFrameViewer

  fun filter(f: Service.DataFrameFilterRequest.Filter): RDataFrameViewer

  override fun dispose() {
  }

  fun registerDisposable(parent: Disposable) {
  }
}
