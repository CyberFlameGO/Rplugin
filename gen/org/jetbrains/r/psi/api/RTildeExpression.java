// This is a generated file. Not intended for manual editing.
package org.jetbrains.r.psi.api;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface RTildeExpression extends RExpression {

  @NotNull
  List<RExpression> getExpressionList();

  @NotNull
  RTildeOperator getTildeOperator();

}
