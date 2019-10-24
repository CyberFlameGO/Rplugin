/*
 * Copyright 2000-2019 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
 */

package org.jetbrains.r.projectGenerator.panel

import com.intellij.ui.components.JBPanel
import org.jetbrains.r.R_LOGO_16
import javax.swing.Icon

abstract class RPanel : JBPanel<RPanel>() {

  abstract val panelName: String
  open val icon: Icon? = R_LOGO_16
  open val changeListeners = mutableListOf<Runnable>()

  open fun addChangeListener(listener: Runnable) {
    changeListeners.add(listener)
  }

  fun runListeners() {
    changeListeners.forEach { it.run() }
  }
}