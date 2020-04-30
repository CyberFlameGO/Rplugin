// Copyright (c) 2017, Holger Brandl, Ekaterina Tuzova
/*
 * Copyright 2000-2019 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
 */

package org.jetbrains.r.run.debug.stack

import com.intellij.icons.AllIcons
import com.intellij.openapi.Disposable
import com.intellij.openapi.application.invokeLater
import com.intellij.ui.ColoredTextContainer
import com.intellij.ui.SimpleTextAttributes
import com.intellij.xdebugger.XExpression
import com.intellij.xdebugger.XSourcePosition
import com.intellij.xdebugger.frame.*
import org.jetbrains.concurrency.Promise
import org.jetbrains.concurrency.rejectedPromise
import org.jetbrains.r.RBundle
import org.jetbrains.r.debugger.exception.RDebuggerException
import org.jetbrains.r.rinterop.RValueError
import org.jetbrains.r.rinterop.RValueUnevaluated
import org.jetbrains.r.rinterop.RVar
import org.jetbrains.r.rinterop.RVariableLoader
import kotlin.math.min

class RXStackFrame(val functionName: String,
                   private val position: XSourcePosition?,
                   val loader: RVariableLoader,
                   val grayAttributes: Boolean,
                   val variableViewSettings: RXVariableViewSettings,
                   private val equalityObject: Any? = null) : XStackFrame(), Disposable {
  private val evaluator = RXDebuggerEvaluator(this, this)
  internal val environment get() = loader.obj
  private val listBuilder = object : PartialChildrenListBuilder(this, loader, noFunctions = true) {
    override fun addTopChildren(result: XValueChildrenList) {
      addEnvironmentsGroup(result)
      result.addTopGroup(FunctionsGroup())
    }
  }

  override fun getEqualityObject() = equalityObject

  override fun getEvaluator() = evaluator

  override fun getSourcePosition() = position

  override fun customizePresentation(component: ColoredTextContainer) {
    val attributes = if (grayAttributes) SimpleTextAttributes.GRAYED_ATTRIBUTES else SimpleTextAttributes.REGULAR_ATTRIBUTES
    if (position == null) {
      component.append(functionName, attributes)
    } else {
      component.append("$functionName, ${position.file.name}:${position.line + 1}", attributes)
    }
    component.setIcon(AllIcons.Debugger.Frame)
  }

  override fun computeChildren(node: XCompositeNode) {
    listBuilder.computeChildren(node)
  }

  private fun addEnvironmentsGroup(result: XValueChildrenList) {
    val environments = object : XValueGroup(RBundle.message("variable.view.parent.environments")) {
      override fun computeChildren(node: XCompositeNode) {
        loader.parentEnvironments.getAsync().then {
          invokeLater {
            val children = XValueChildrenList()
            for (env in it) {
              val environment = RXEnvironment(env.name, env.ref.createVariableLoader())
              children.add(environment)
            }
            node.addChildren(children, true)
          }
        }.onError {
          node.setErrorMessage((it as? RDebuggerException)?.message.orEmpty())
        }
      }
    }
    result.addTopGroup(environments)
  }

  override fun dispose() {
  }

  private inner class RXEnvironment internal constructor(name: String, loader: RVariableLoader)
    : XNamedValue(name.takeIf { it.isNotEmpty() } ?: RBundle.message("rx.presentation.utils.environment.unnamed")) {
    private val listBuilder = PartialChildrenListBuilder(this@RXStackFrame, loader)

    override fun computePresentation(node: XValueNode, place: XValuePlace) {
      RXPresentationUtils.setEnvironmentPresentation(node)
    }

    override fun computeChildren(node: XCompositeNode) {
      listBuilder.computeChildren(node)
    }

    override fun calculateEvaluationExpression(): Promise<XExpression> {
      return rejectedPromise()
    }
  }

  private inner class FunctionsGroup : XValueGroup(RBundle.message("variable.view.functions")) {
    private val listBuilder = PartialChildrenListBuilder(this@RXStackFrame, loader, onlyFunctions = true)

    override fun computeChildren(node: XCompositeNode) {
      listBuilder.computeChildren(node)
    }
  }
}

internal open class PartialChildrenListBuilder(
  private val stackFrame: RXStackFrame, private val loader: RVariableLoader,
  private val noFunctions: Boolean = false, private val onlyFunctions: Boolean = false) {
  private var offset = 0L
  private var firstCall = true

  fun computeChildren(node: XCompositeNode) {
    val result = XValueChildrenList()
    if (firstCall) {
      addTopChildren(result)
      firstCall = false
    }
    val endOffset = offset + MAX_ITEMS
    val withHidden = stackFrame.variableViewSettings.showHiddenVariables
    loader.loadVariablesPartially(offset, endOffset,withHidden = withHidden,
                                  noFunctions = noFunctions, onlyFunctions = onlyFunctions).then { (vars, totalCount) ->
      invokeLater {
        addContents(result, vars, offset)
        node.addChildren(result, true)
        offset = min(endOffset, totalCount)
        if (offset != totalCount) {
          node.tooManyChildren((totalCount - offset).let { if (it > Int.MAX_VALUE) -1 else it.toInt() })
        }
      }
    }.onError {
      node.setErrorMessage((it as? RDebuggerException)?.message.orEmpty())
    }
  }

  protected open fun addTopChildren(result: XValueChildrenList) {
  }

  protected open fun addContents(result: XValueChildrenList, vars: List<RVar>, offset: Long) {
    addEnvironmentContents(result, vars, stackFrame)
  }
}


internal fun addEnvironmentContents(result: XValueChildrenList, vars: List<RVar>, stackFrame: RXStackFrame) {
  val rxVars = vars.map { RXVar(it, stackFrame) }
  rxVars.forEach { result.add(it) }
  setObjectSizes(rxVars, stackFrame)
}

internal fun setObjectSizes(rxVars: List<RXVar>, stackFrame: RXStackFrame) {
  if (!stackFrame.variableViewSettings.showSize) return
  val filtered = rxVars.filter { it.rVar.value !is RValueError && it.rVar.value !is RValueUnevaluated }
  if (filtered.isEmpty()) return
  val sizes = stackFrame.loader.rInterop.getObjectSizes(filtered.map { it.rVar.ref })
  filtered.zip(sizes).forEach { (rxVar, size) -> rxVar.objectSize = size.takeIf { it >= 0 } }
}

internal const val MAX_ITEMS = 250
