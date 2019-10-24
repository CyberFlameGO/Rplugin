/*
 * Copyright 2000-2019 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
 */

package org.jetbrains.r.psi;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.stubs.StubElement;
import com.intellij.psi.stubs.StubInputStream;
import com.intellij.psi.stubs.StubOutputStream;
import com.intellij.util.io.StringRef;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.r.psi.api.RParameter;
import org.jetbrains.r.psi.impl.RParameterImpl;
import org.jetbrains.r.psi.impl.RPsiImplUtil;
import org.jetbrains.r.psi.stubs.RParameterStub;
import org.jetbrains.r.psi.stubs.RParameterStubImpl;
import org.jetbrains.r.psi.stubs.RStubElementType;

import java.io.IOException;
import java.util.Objects;

public class RParameterElementType extends RStubElementType<RParameterStub, RParameter> {
  RParameterElementType(@NotNull final String debugName) {
    super(debugName);
  }

  @Override
  public PsiElement createElement(@NotNull final ASTNode node) {
    return new RParameterImpl(node);
  }

  @Override
  public RParameter createPsi(@NotNull final RParameterStub stub) {
    return new RParameterImpl(stub, this);
  }


  @NotNull
  @Override
  public RParameterStub createStub(@NotNull RParameter psi, StubElement parentStub) {
    final String name = psi.getName();
    return new RParameterStubImpl(name, parentStub, this);
  }

  @Override
  public void serialize(@NotNull final RParameterStub stub, @NotNull final StubOutputStream dataStream)
    throws IOException {
    dataStream.writeName(stub.getName());
  }

  @Override
  public boolean shouldCreateStub(ASTNode node) {
    return !new RParameterImpl(node).getName().equals(RPsiImplUtil.UNNAMED);
  }

  @Override
  @NotNull
  public RParameterStub deserialize(@NotNull final StubInputStream dataStream, final StubElement parentStub) throws IOException {
    String name = Objects.requireNonNull(StringRef.toString(dataStream.readName()));
    return new RParameterStubImpl(name, parentStub, this);
  }
}
