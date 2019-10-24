/*
 * Copyright 2000-2019 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
 */

package org.jetbrains.r.settings

import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.util.indexing.IndexableSetContributor
import org.jetbrains.r.interpreter.RInterpreterManager

class RIndexableSetContributor : IndexableSetContributor() {
  override fun getAdditionalProjectRootsToIndex(project: Project): Set<VirtualFile> {
    return RInterpreterManager.getInterpreter(project)?.skeletonRoots ?: emptySet()
  }

  override fun getAdditionalRootsToIndex(): Set<VirtualFile> {
    return emptySet()
  }
}