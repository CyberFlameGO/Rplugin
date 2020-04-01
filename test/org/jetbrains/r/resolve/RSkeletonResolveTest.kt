/*
 * Copyright 2000-2019 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
 */

package org.jetbrains.r.resolve

import com.intellij.openapi.fileEditor.FileDocumentManager
import com.intellij.psi.PsiElement
import com.intellij.testFramework.UsefulTestCase
import junit.framework.TestCase
import org.jetbrains.r.RFileType
import org.jetbrains.r.console.RConsoleBaseTestCase
import org.jetbrains.r.console.runtimeInfo
import org.jetbrains.r.packages.RPackage
import org.jetbrains.r.rinterop.RValueDataFrame
import org.jetbrains.r.rinterop.RValueFunction
import org.jetbrains.r.rinterop.RVar
import org.jetbrains.r.rinterop.getWithCheckCanceled
import org.jetbrains.r.skeleton.psi.RSkeletonAssignmentStatement

class RSkeletonResolveTest : RConsoleBaseTestCase() {
  override fun setUp() {
    super.setUp()
    addLibraries()
  }

  fun testResolveDplyrFilter() {
    val rVar = runTest("dplyr::fil<caret>ter()")
    val text = FileDocumentManager.getInstance().getDocument(rVar.ref.functionSourcePosition()!!.file)!!.text
    UsefulTestCase.assertInstanceOf(rVar.value, RValueFunction::class.java)
    TestCase.assertTrue(text.contains("UseMethod(\"filter\")"))
  }

  fun testResolveDataset() {
    val rValue = runTest("iri<caret>s").value
    UsefulTestCase.assertInstanceOf(rValue, RValueDataFrame::class.java)
    TestCase.assertEquals(5, (rValue as RValueDataFrame).cols)
  }

  fun testResolveDplyrInternal() {
    val resolveResult = resolve("dplyr::any_<caret>exprs")
    TestCase.assertTrue(resolveResult is RSkeletonAssignmentStatement)
    val assignment = resolveResult as RSkeletonAssignmentStatement
    TestCase.assertFalse(assignment.stub.exported)
    val rVar = assignment.createRVar(console)
    val text = FileDocumentManager.getInstance().getDocument(rVar.ref.functionSourcePosition()!!.file)!!.text
    UsefulTestCase.assertInstanceOf(rVar.value, RValueFunction::class.java)
    TestCase.assertTrue(text.contains("quote(`||`)"))
  }

  fun testResolveFilter() {
    val filterStats = resolve("fil<caret>ter()")
    TestCase.assertNotNull(filterStats)
    TestCase.assertEquals("stats", RPackage.getOrCreateRPackageBySkeletonFile(filterStats!!.containingFile)?.name)
    myFixture.file.runtimeInfo?.loadPackage("dplyr")
    val filterDplyr = resolve("fil<caret>ter()")
    TestCase.assertNotNull(filterDplyr)
    TestCase.assertEquals("dplyr", RPackage.getOrCreateRPackageBySkeletonFile(filterDplyr!!.containingFile)?.name)
    myFixture.file.runtimeInfo?.rInterop?.unloadLibrary("dplyr", false)?.getWithCheckCanceled()
    val filterStats2 = resolve("fil<caret>ter()")
    TestCase.assertNotNull(filterStats2)
    TestCase.assertEquals("stats", RPackage.getOrCreateRPackageBySkeletonFile(filterStats2!!.containingFile)?.name)
  }

  fun testDoNotResolveToSkeletons() {
    val resolveResult = resolve("""
      conflicts <- function(pkg) 1
      make.conflicts <- function()
          conf<caret>licts('pkg')
    """.trimIndent())
    TestCase.assertEquals(myFixture.file, resolveResult?.containingFile)
  }
  
  fun testDplyrPipeOperatorIsResolved() {
    rInterop.executeCode("library(dplyr)")
    val resolveResult = resolve("""
      starwars %><caret>% count(birth_year)
    """.trimIndent())
    val rPackage = RPackage.getOrCreateRPackageBySkeletonFile(resolveResult!!.containingFile)
    TestCase.assertEquals("dplyr", rPackage?.name)
  }

  private fun runTest(expression: String): RVar {
    val resolveResult = resolve(expression)
    TestCase.assertTrue(resolveResult is RSkeletonAssignmentStatement)
    return (resolveResult as RSkeletonAssignmentStatement).createRVar(console)
  }

  private fun resolve(expression: String): PsiElement? {
    myFixture.configureByText(RFileType, expression)
    val resolve = resolve()
    TestCase.assertEquals(1, resolve.size)
    return resolve[0].element
  }
}