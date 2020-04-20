// This is a generated file. Not intended for manual editing.
package org.jetbrains.r.roxygen.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static org.jetbrains.r.roxygen.parsing.RoxygenElementTypes.*;
import org.jetbrains.r.roxygen.psi.api.*;

public class RoxygenParamTagImpl extends RoxygenTagImpl implements RoxygenParamTag {

  public RoxygenParamTagImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull RoxygenVisitor visitor) {
    visitor.visitParamTag(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof RoxygenVisitor) accept((RoxygenVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<RoxygenParameter> getParameters() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, RoxygenParameter.class);
  }

}
