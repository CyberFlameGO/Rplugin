/*
 * Copyright 2000-2019 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
 */

package org.jetbrains.r.intentions

import com.intellij.codeInspection.ProblemDescriptor
import com.intellij.openapi.project.Project
import org.jetbrains.r.RBundle
import org.jetbrains.r.inspections.MissingPackageInspection
import org.jetbrains.r.packages.RequiredPackage
import org.jetbrains.r.packages.RequiredPackageInstaller

class InstallAllFileLibraryFix : DependencyManagementFix() {

  override fun getName(): String {
    return RBundle.message("install.all.library.fix.name")
  }

  override fun applyFix(project: Project, descriptor: ProblemDescriptor) {
    val missing = findAllMissingPackages(project, descriptor)
    RequiredPackageInstaller.getInstance(project).installPackagesWithUserPermission(getName(), missing, false)
      .onError { showErrorNotification(project, it) }
  }

  private fun findAllMissingPackages(project: Project, descriptor: ProblemDescriptor): List<RequiredPackage> {
    val file = descriptor.psiElement.containingFile
    val packageNames = getAllPackagesWithSameQuickFix<InstallLibraryFix>(file, project, MissingPackageInspection())
    return packageNames.map { RequiredPackage(it) }
  }
}