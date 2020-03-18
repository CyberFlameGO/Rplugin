/*
 * Copyright 2000-2019 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
 */

package org.jetbrains.r.psi

import org.jetbrains.r.console.RConsoleRuntimeInfo
import org.jetbrains.r.hints.parameterInfo.RArgumentInfo
import org.jetbrains.r.psi.api.*

object RDplyrAnalyzer : TableManipulationAnalyzer<DplyrFunction>() {
  const val PIPE_OPERATOR = "%>%"

  override val nameToFunction = DplyrFunction.values()
    .mapNotNull { (it.functionName ?: return@mapNotNull null) to it }
    .toMap()

  override val packageName = "dplyr"
  override val subscriptionOperator = DplyrFunction.SUBSCRIPTION_OPERATOR
  override val doubleSubscriptionOperator = DplyrFunction.DOUBLE_SUBSCRIPTION_OPERATOR
  override val tableColumnType = TableType.DPLYR

  // TODO(DS-226): Put more functions here
  @Suppress("SpellCheckingInspection")
  override val safeFunctions = super.safeFunctions + mapOf<String, Set<String>>(
    "dplyr" to setOf(
      "all_vars", "any_vars", "between", "case_when", "coalesce", "contains", "cumall", "cumany", "cume_dist", "cummean", "dense_rank",
      "desc", "ends_with", "everything", "first", "if_else", "lag", "last", "last_col", "lead", "matches", "min_rank", "n", "n_distinct",
      "na_if", "near", "nth", "ntile", "num_range", "one_of", "order_by", "percent_rank", "recode", "recode_factor", "row_number",
      "starts_with"
    ) + nameToFunction.keys
  )

  override fun transformNotCall(expr: RExpression, command: StringBuilder, runtimeInfo: RConsoleRuntimeInfo, preserveRows: Boolean) {
    if (isSafe(expr, runtimeInfo)) {
      if (!preserveRows) command.append("dplyr::filter(")
      command.append("(").append(expr.text).append(")")
      if (!preserveRows) command.append(",FALSE)")
    }
    else {
      command.append("(dplyr::tibble())")
    }
  }

  fun isPipeCall(expr: RCallExpression): Boolean {
    val parent = expr.parent
    return parent is ROperatorExpression && parent.operator?.name == PIPE_OPERATOR && expr == parent.rightExpr
  }

  fun addCurrentColumns(columns: List<TableManipulationColumn>,
                        callInfo: TableManipulationCallInfo<*>,
                        currentArg: RExpression): List<TableManipulationColumn> {
    val arguments = callInfo.argumentInfo.expressionListWithPipeExpression
    val currentArgIndex = arguments.indexOf(currentArg)
    return columns + arguments.subList(0, currentArgIndex)
      .filter { !callInfo.isTableArgument(it) }
      .mapNotNull {
        when (it) {
          is RIdentifierExpression -> TableManipulationColumn(it.name)
          is RNamedArgument -> {
            val name = it.name
            if (name.startsWith(".")) return@mapNotNull null
            TableManipulationColumn(name)
          }
          else -> null
        }
      }
  }
}

@Suppress("SpellCheckingInspection")
enum class DplyrFunction(
  override val functionName: String? = null,
  override val returnsTable: Boolean = true,
  override val ignoreInTransform: Boolean = false,
  override val rowsOmittingUnavailable: Boolean = false,
  override val tableArguments: List<String> = listOf(".tbl"),
  override val inheritedFunction: Boolean = false,
  override val fullSuperFunctionName: String? = null,
  override val s3Function: Boolean = false
) : TableManipulationFunction {
  ADD_COUNT("add_count", tableArguments = listOf("x")),
  ADD_ROW("add_row", tableArguments = listOf(".data")),
  ADD_TALLY("add_tally", tableArguments = listOf("x")),
  ARRANGE("arrange", tableArguments = listOf(".data")),
  ARRANGE_ALL("arrange_all"),
  ARRANGE_AT("arrange_at"),
  ARRANGE_IF("arrange_if"),
  COUNT("count", tableArguments = listOf("x")),
  DISTINCT("distinct", tableArguments = listOf(".data")),
  DISTINCT_ALL("distinct_all"),
  DISTINCT_AT("distinct_at"),
  DISTINCT_IF("distinct_if"),
  FILTER("filter", tableArguments = listOf(".data")),
  GROUP_BY("group_by", tableArguments = listOf(".data")),
  GROUP_BY_ALL("group_by_all"),
  GROUP_BY_AT("group_by_at"),
  GROUP_BY_IF("group_by_if"),
  MUTATE("mutate", tableArguments = listOf(".data")),
  MUTATE_ALL("mutate_all"),
  MUTATE_AT("mutate_at"),
  MUTATE_IF("mutate_if"),
  PULL("pull", returnsTable = false, tableArguments = listOf(".data")),
  RENAME("rename", tableArguments = listOf(".data")),
  RENAME_ALL("rename_all"),
  RENAME_AT("rename_at"),
  RENAME_IF("rename_if"),
  SAMPLE_FRAC("sample_frac", ignoreInTransform = true, tableArguments = listOf("tbl")),
  SAMPLE_N("sample_n", ignoreInTransform = true, tableArguments = listOf("tbl")),
  SELECT("select", tableArguments = listOf(".data")),
  SELECT_ALL("select_all"),
  SELECT_AT("select_at"),
  SELECT_IF("select_if"),
  SLICE("slice", tableArguments = listOf(".data")),
  SUMMARISE("summarise", tableArguments = listOf(".data")),
  SUMMARISE_ALL("summarise_all"),
  SUMMARISE_AT("summarise_at"),
  SUMMARISE_IF("summarise_if"),
  SUMMARIZE("summarize", tableArguments = listOf(".data")),
  SUMMARIZE_ALL("summarize_all"),
  SUMMARIZE_AT("summarize_at"),
  SUMMARIZE_IF("summarize_if"),
  TALLY("tally", tableArguments = listOf("x")),
  TIBBLE("tibble", tableArguments = listOf()),
  TOP_FRAC("top_frac", tableArguments = listOf("x")),
  TOP_N("top_n", tableArguments = listOf("x")),
  TRANSMUTE("transmute", tableArguments = listOf(".data")),
  TRANSMUTE_ALL("transmute_all"),
  TRANSMUTE_AT("transmute_at"),
  TRANSMUTE_IF("transmute_if"),
  UNGROUP("ungroup", tableArguments = listOf("x")),

  DOUBLE_SUBSCRIPTION_OPERATOR(
    tableArguments = listOf("x"), functionName = "`[[.tbl_df`",
    returnsTable = false, s3Function = true,
    inheritedFunction = true, fullSuperFunctionName = "tibble:::`[[.tbl_df`"),
  SUBSCRIPTION_OPERATOR(
    tableArguments = listOf("x"), functionName = "`[.tbl_df`", s3Function = true,
    inheritedFunction = true, fullSuperFunctionName = "tibble:::`[.tbl_df`"),

  BIND_COLS("bind_cols", tableArguments = listOf("...")),
  BIND_ROWS("bind_rows", tableArguments = listOf("...")),

  INTERSECT("intersect", tableArguments = listOf("x", "y")),
  SETDIFF("setdiff", tableArguments = listOf("x", "y")),
  UNION("union", tableArguments = listOf("x", "y")),
  UNION_ALL("union_all", tableArguments = listOf("x", "y")),

  ANTI_JOIN("anti_join", tableArguments = listOf("x", "y")),
  FULL_JOIN("full_join", tableArguments = listOf("x", "y")),
  INNER_JOIN("inner_join", tableArguments = listOf("x", "y")),
  LEFT_JOIN("left_join", tableArguments = listOf("x", "y")),
  NEST_JOIN("nest_join", tableArguments = listOf("x", "y")),
  RIGHT_JOIN("right_join", tableArguments = listOf("x", "y")),
  SEMI_JOIN("semi_join", tableArguments = listOf("x", "y"));

  override fun isQuotesNeeded(argumentInfo: RArgumentInfo, currentArgument: RExpression): Boolean {
    return when (this) {
      SUBSCRIPTION_OPERATOR, DOUBLE_SUBSCRIPTION_OPERATOR,
      ANTI_JOIN, FULL_JOIN, INNER_JOIN, LEFT_JOIN, NEST_JOIN,
      RIGHT_JOIN, SEMI_JOIN -> true
      else -> false
    }
  }

  protected fun isNeedCompletionInsideSubscription(argumentInfo: RArgumentInfo, currentArgument: RExpression): Boolean {
    // table[1:3] - select columns
    // table[,1:3] - select columns
    // table[1:3,] - select rows
    val size = argumentInfo.expressionListWithPipeExpression.size
    val argIndex = argumentInfo.expressionListWithPipeExpression.indexOf(currentArgument)
    return !(argIndex == 0 || size > 3 || (size == 3 && argIndex == 1))
  }
}

