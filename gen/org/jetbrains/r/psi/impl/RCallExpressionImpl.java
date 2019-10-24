// This is a generated file. Not intended for manual editing.
package org.jetbrains.r.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static org.jetbrains.r.parsing.RElementTypes.*;
import org.jetbrains.r.psi.api.*;

public class RCallExpressionImpl extends RExpressionImpl implements RCallExpression {

  public RCallExpressionImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull RVisitor visitor) {
    visitor.visitCallExpression(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof RVisitor) accept((RVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public RArgumentList getArgumentList() {
    return notNullChild(PsiTreeUtil.getChildOfType(this, RArgumentList.class));
  }

  @Override
  @NotNull
  public RExpression getExpression() {
    return notNullChild(PsiTreeUtil.getChildOfType(this, RExpression.class));
  }

}
