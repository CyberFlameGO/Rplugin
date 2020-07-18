/*
 * Copyright 2000-2019 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
 */

package org.jetbrains.r.interpreter

import com.intellij.execution.configurations.GeneralCommandLine
import com.intellij.execution.process.BaseProcessHandler
import com.intellij.execution.process.ProcessHandler
import com.intellij.openapi.application.invokeLater
import com.intellij.openapi.fileEditor.FileDocumentManager
import com.intellij.openapi.project.Project
import com.intellij.openapi.ui.TextFieldWithBrowseButton
import com.intellij.openapi.util.io.FileUtil
import com.intellij.openapi.vfs.LocalFileSystem
import com.intellij.openapi.vfs.VfsUtil
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.psi.PsiFile
import org.jetbrains.concurrency.AsyncPromise
import org.jetbrains.concurrency.Promise
import org.jetbrains.r.RPluginUtil
import org.jetbrains.r.common.ExpiringList
import org.jetbrains.r.packages.RInstalledPackage
import org.jetbrains.r.rinterop.RInterop
import java.io.File
import java.nio.file.Paths

interface RInterpreter : RInterpreterInfo {
  val project: Project

  val isUpdating: Boolean

  val installedPackages: ExpiringList<RInstalledPackage>

  data class LibraryPath(val path: String, val isWritable: Boolean)
  val libraryPaths: List<LibraryPath>

  val userLibraryPath: String

  val interop: RInterop

  fun getPackageByName(name: String): RInstalledPackage?

  fun getLibraryPathByName(name: String): LibraryPath?

  /**
   * @return a system-dependant paths to the skeleton roots
   */
  val skeletonPaths: List<String>

  val skeletonRoots: Set<VirtualFile>

  val basePath: String

  val hostOS: OperatingSystem

  /** A place where all skeleton-related data will be stored */
  val skeletonsDirectory: String

  fun suggestConsoleName(workingDirectory: String): String {
    return "[ ${FileUtil.getLocationRelativeToUserHome(LocalFileSystem.getInstance().extractPresentableUrl(workingDirectory))} ]"
  }

  fun getFilePathAtHost(file: VirtualFile): String? {
    return if (file.isInLocalFileSystem) file.canonicalPath else null
  }
  
  fun findFileByPathAtHost(path: String): VirtualFile? {
    return LocalFileSystem.getInstance().findFileByPath(path)
  }

  fun downloadFileFromHost(path: String, localPath: String) {
    File(path).takeIf { it.exists() }?.copyTo(File(localPath))
  }

  fun getHelpersRootOnHost(): String = RPluginUtil.helpersPath

  fun getSkeletonFileByPackageName(name: String): PsiFile?

  fun updateState(): Promise<Unit>

  fun findLibraryPathBySkeletonPath(skeletonPath: String): String?

  fun createRInteropForProcess(process: ProcessHandler, port: Int): RInterop

  fun uploadFileToHostIfNeeded(file: VirtualFile, preserveName: Boolean = false): String

  fun createFileChooserForHost(value: String = "", selectFolder: Boolean = false): TextFieldWithBrowseButton

  fun showFileChooserDialogForHost(selectFolder: Boolean = false): String?

  fun createTempFileOnHost(name: String = "a", content: ByteArray? = null): String

  fun createTempDirOnHost(name: String = "a"): String

  // Note: returns pair of writable path and indicator whether new library path was created
  fun getGuaranteedWritableLibraryPath(libraryPaths: List<LibraryPath> = this.libraryPaths,
                                       userPath: String = userLibraryPath): Pair<String, Boolean>

  fun prepareForExecution(): Promise<Unit> {
    val promise = AsyncPromise<Unit>()
    invokeLater {
      FileDocumentManager.getInstance().saveAllDocuments()
      promise.setResult(Unit)
    }
    return promise
  }
}

data class LocalOrRemotePath(val path: String, val isRemote: Boolean)

fun RInterpreter.isLocal(): Boolean = interpreterLocation is RLocalInterpreterLocation

fun RInterpreter.runHelper(helper: File, args: List<String>, workingDirectory: String = basePath) =
  RInterpreterUtil.runHelper(interpreterLocation, helper, workingDirectory, args)

fun RInterpreter.uploadFileToHost(file: File, preserveName: Boolean = false) = interpreterLocation.uploadFileToHost(file, preserveName)

fun RInterpreter.runProcessOnHost(command: GeneralCommandLine, workingDirectory: String = basePath, isSilent: Boolean = false) =
  interpreterLocation.runProcessOnHost(command, workingDirectory, isSilent)

fun RInterpreter.runHelperProcess(script: String, args: List<String>, workingDirectory: String = basePath): BaseProcessHandler<*> {
  val interpreterArgs= RInterpreterUtil.getRunHelperArgs(script, args)
  return interpreterLocation.runInterpreterOnHost(interpreterArgs, workingDirectory)
}

fun RInterpreter.runMultiOutputHelper(helper: File, workingDirectory: String?, args: List<String>, processor: RMultiOutputProcessor) {
  return RInterpreterUtil.runMultiOutputHelper(interpreterLocation, helper, workingDirectory, args, processor)
}

fun RInterpreter.uploadFileToHostIfNeeded(path: LocalOrRemotePath, preserveName: Boolean = false): String {
  if (isLocal() || path.isRemote) return path.path
  return uploadFileToHost(File(path.path), preserveName)
}

fun VirtualFile.getLocalOrRemotePath(interpreter: RInterpreter): LocalOrRemotePath? {
  if (isInLocalFileSystem) return LocalOrRemotePath(path, false)
  return interpreter.getFilePathAtHost(this)?.let { LocalOrRemotePath(it, true) }
}

fun LocalOrRemotePath.findFile(interpreter: RInterpreter, refreshIfNeeded: Boolean = false): VirtualFile? {
  if (isRemote) return interpreter.findFileByPathAtHost(path)
  return VfsUtil.findFile(Paths.get(path), refreshIfNeeded)
}
