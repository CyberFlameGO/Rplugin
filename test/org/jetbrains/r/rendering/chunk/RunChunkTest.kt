/*
 * Copyright 2000-2019 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
 */

package org.jetbrains.r.rendering.chunk

import com.intellij.openapi.editor.ex.EditorEx
import com.intellij.psi.impl.source.tree.LeafPsiElement
import com.intellij.psi.search.PsiElementProcessor
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.testFramework.PlatformTestUtil
import junit.framework.TestCase
import org.intellij.datavis.inlays.InlayOutput
import org.intellij.plugins.markdown.lang.MarkdownTokenTypes.FENCE_LANG
import org.jetbrains.concurrency.isPending
import org.jetbrains.concurrency.runAsync
import org.jetbrains.r.console.RConsoleBaseTestCase
import org.jetbrains.r.console.UpdateGraphicsHandler
import org.jetbrains.r.rmarkdown.R_FENCE_ELEMENT_TYPE
import org.jetbrains.r.run.graphics.RGraphicsUtils
import java.io.File

class RunChunkTest : RConsoleBaseTestCase() {

  fun testSimplePlot() {
    val runChunk = doRunChunk("""
      ```{r}
      plot(c(1,2),c(3,4))
      ```
    """.trimIndent())
    TestCase.assertTrue(runChunk.size == 1)
    TestCase.assertTrue(runChunk.all { it.type == "IMG" })
  }

  fun testDataOutput() {
    val runChunk = doRunChunk("""
      ```{r}
        cars
      ```
    """.trimIndent())
    assertTrue(runChunk.size == 1)
    assertTrue(runChunk.first().type == "TABLE")
  }

  fun testTextOutput() {
    val runChunk = doRunChunk("""
      ```{r}
        print("Hello world")
      ```
    """.trimIndent())
    assertTrue(runChunk.size == 1)
    assertTrue(runChunk.first().type == "Output")
  }

  fun testHtmlOutput() {
    UpdateGraphicsHandler(project, rInterop, RGraphicsUtils.createGraphicsState(
                          RGraphicsUtils.ScreenParameters(640, 480, null)))
    rInterop.executeCode("library(plotly)", true)
    val result = doRunChunk("""
      ```{r}
    p <- plot_ly(
      type = 'scatterpolar',
      mode = 'lines'
    ) %>%
    add_trace(
      r = c(0, 1.5, 1.5, 0, 2.5, 2.5, 0),
      theta = c(0, 10, 25, 0, 205, 215, 0),
      fill = 'toself',
      fillcolor = '#709Bff',
      line = list(
        color = 'black'
      )
    ) %>%
    add_trace(
      r = c(0, 3.5, 3.5, 0),
      theta = c(0, 55, 75, 0),
      fill = 'toself',
      fillcolor = '#E4FF87',
      line = list(
        color = 'black'
      )
    ) %>%
    add_trace(
      r = c(0, 4.5, 4.5, 0, 4.5, 4.5, 0),
      theta = c(0, 100, 120, 0, 305, 320, 0),
      fill = 'toself',
      fillcolor = '#FFAA70',
      line = list(
        color = 'black'
      )
    ) %>%
    add_trace(
      r = c(0, 4, 4, 0),
      theta = c(0, 165, 195, 0),
      fill = 'toself',
      fillcolor = '#FFDF70',
      line = list(
        color = 'black'
      )
    ) %>%
    add_trace(
      r = c(0, 3, 3, 0),
      theta = c(0, 262.5, 277.5, 0),
      fill = 'toself',
      fillcolor = '#B6FFB4',
      line = list(
        color = 'black'
      )
    ) %>%
    layout(
      polar = list(
        radialaxis = list(
          visible = T,
          range = c(0,5)
        )
      ),
      showlegend = F
    )
    p
    ```
    """.trimIndent())
    assertTrue(result.size == 1)
    if (result.first().type == "Output") {
      fail(File(result.first().data).readText())
    }
    assertTrue(result.first().type == "URL")
  }

  fun testDebugChunk() {
    val promise = runAsync {
      val debugger = console.debugger
      var iterations = 200
      while (!debugger.actionsEnabled) {
        iterations--
        TestCase.assertTrue(iterations > 0)
        Thread.sleep(20)
      }
      TestCase.assertEquals(5, debugger.stack[0].sourcePosition?.line)
      TestCase.assertEquals("10", rInterop.executeCode("cat(x)", true).stdout)
      debugger.stepOver().blockingGet(1000)
      TestCase.assertEquals(6, debugger.stack[0].sourcePosition?.line)
      TestCase.assertEquals("20", rInterop.executeCode("cat(x)", true).stdout)
      debugger.stepOver().blockingGet(1000)
      TestCase.assertFalse(debugger.isEnabled)
    }
    doRunChunk("""
      Text
      Text
      ```{r}
      x <- 10
      x
      x <- 20 # BREAKPOINT
      x
      ```
    """.trimIndent(), true)
    promise.blockingGet(1000)
  }

  private fun doRunChunk(text: String, debug: Boolean = false): List<InlayOutput> {
    loadFileWithBreakpointsFromText(text, name = "foo.Rmd")
    val fenceLang = PsiElementProcessor.FindFilteredElement<LeafPsiElement> {
      it.node.elementType == FENCE_LANG &&
      it.nextSibling?.nextSibling?.node?.elementType == R_FENCE_ELEMENT_TYPE
    }.apply { PsiTreeUtil.processElements(myFixture.file, this) }.foundElement
    TestCase.assertNotNull(fenceLang)
    val promise = RunChunkHandler.runHandlersAndExecuteChunk(console, fenceLang!!, myFixture.editor as EditorEx, debug)
    val time = System.currentTimeMillis()
    while (System.currentTimeMillis() - time < 10000 && promise.isPending) {
      PlatformTestUtil.dispatchAllEventsInIdeEventQueue()
    }
    TestCase.assertTrue(promise.isSucceeded)
    return RMarkdownInlayDescriptor(myFixture.file).getInlayOutputs(fenceLang)
  }
}