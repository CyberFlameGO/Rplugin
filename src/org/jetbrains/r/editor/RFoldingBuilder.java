// Copyright (c) 2017, Holger Brandl, Ekaterina Tuzova


/*
 * Copyright 2000-2019 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
 */

package org.jetbrains.r.editor;


import com.intellij.lang.ASTNode;
import com.intellij.lang.folding.FoldingBuilder;
import com.intellij.lang.folding.FoldingDescriptor;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.util.TextRange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.r.parsing.RElementTypes;
import org.jetbrains.r.psi.api.*;

import java.util.ArrayList;
import java.util.List;


/**
 * Defines how code folding should behave for R files
 * <p>
 * For details see http://www.jetbrains.org/intellij/sdk/docs/tutorials/custom_language_support/folding_builder.html
 */
public class RFoldingBuilder implements FoldingBuilder {

    public String getPlaceholderText(@NotNull ASTNode node) {
        if (node.getElementType() == RElementTypes.R_BLOCK_EXPRESSION) {

            return "{...}";
        }
        if (node.getElementType() == RElementTypes.R_FUNCTION_EXPRESSION) {
            RFunctionExpression def = (RFunctionExpression) node.getPsi();
            RParameterList funargs = def.getParameterList();

//            if (funargs != null) {
            return "function" + funargs.getText() + " ...";
        }

        if (node.getElementType() == RElementTypes.R_IF_STATEMENT) {
            RIfStatement def = (RIfStatement) node.getPsi();
            return "if (" + def.getExpressionList().get(0).getText() + ")} ...";
        }

        if (node.getElementType() == RElementTypes.R_ELSE) {
//            RIfStatement def = (RIfStatement) node.getPsi();
            return "else { ... } ";
        }
        if (node.getElementType() == RElementTypes.R_FOR_STATEMENT) {
            RForStatement def = (RForStatement) node.getPsi();
            return "for (" + def.getExpressionList().get(0).getText() + " in " + def.getExpressionList().get(1).getText() + ") ...";
        }

        return null;
    }


    public boolean isCollapsedByDefault(@NotNull ASTNode node) {
        return false;
    }


    @NotNull
    public FoldingDescriptor[] buildFoldRegions(@NotNull ASTNode node, @NotNull Document document) {
        List<FoldingDescriptor> descriptors = new ArrayList<FoldingDescriptor>();
        appendDescriptors(node, descriptors);
        return descriptors.toArray(new FoldingDescriptor[descriptors.size()]);
    }


    private void appendDescriptors(final ASTNode node, final List<FoldingDescriptor> descriptors) {

        if (node.getElementType() == RElementTypes.R_BLOCK_EXPRESSION) {
            RBlockExpression blockExpr = (RBlockExpression) node.getPsi();


            int lbraceStart = blockExpr.getTextRange().getStartOffset();
            int rbraceStart = blockExpr.getTextRange().getEndOffset();

            descriptors.add(new FoldingDescriptor(node, new TextRange(lbraceStart, rbraceStart)));
        }


        ASTNode child = node.getFirstChildNode();
        while (child != null)


        {
            appendDescriptors(child, descriptors);
            child = child.getTreeNext();
        }
    }
}
