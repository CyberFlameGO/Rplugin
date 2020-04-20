/* The following code was generated by JFlex 1.7.0 tweaked for IntelliJ platform */

/*
 * Copyright 2000-2020 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
 */
package org.jetbrains.r.roxygen.lexer;

import com.intellij.lexer.FlexLexer;
import java.util.Stack;
import com.intellij.psi.tree.IElementType;

import static org.jetbrains.r.roxygen.parsing.RoxygenElementTypes.*;


/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.7.0
 * from the specification file <tt>Roxygen.flex</tt>
 */
class _RoxygenLexer implements FlexLexer {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;
  public static final int COMMENT_LINE_START = 2;
  public static final int COMMENT_LINE_CONTINUE = 4;
  public static final int PARAM_LIST_START = 6;
  public static final int PARAM_LIST_CONTINUE = 8;
  public static final int HELP_LINK_OR_LINK_TEXT = 10;
  public static final int LINK_DESTINATION = 12;
  public static final int AUTOLINK = 14;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0,  0,  1,  1,  2,  2,  3,  3,  4,  4,  5,  5,  6,  6,  7, 7
  };

  /** 
   * Translates characters to character classes
   * Chosen bits are [12, 6, 3]
   * Total runtime size is 17392 bytes
   */
  public static int ZZ_CMAP(int ch) {
    return ZZ_CMAP_A[(ZZ_CMAP_Y[(ZZ_CMAP_Z[ch>>9]<<6)|((ch>>3)&0x3f)]<<3)|(ch&0x7)];
  }

  /* The ZZ_CMAP_Z table has 2176 entries */
  static final char ZZ_CMAP_Z[] = zzUnpackCMap(
    "\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14\1\15\1\16\1\17\1"+
    "\20\5\21\1\22\1\23\1\24\1\21\14\25\1\26\50\25\1\27\2\25\1\30\1\31\1\32\1\33"+
    "\25\25\1\34\20\21\1\35\1\36\1\37\1\40\1\41\1\42\1\43\1\44\1\45\1\46\1\47\1"+
    "\21\1\50\1\51\1\52\1\53\1\54\1\55\1\56\1\21\1\25\1\57\1\60\5\21\2\25\1\61"+
    "\7\21\1\25\1\62\20\21\1\25\1\63\1\21\1\64\13\25\1\65\1\25\1\66\22\21\1\67"+
    "\1\70\4\21\1\71\11\21\1\72\1\73\1\74\1\75\1\21\1\76\2\21\1\77\3\21\1\100\2"+
    "\21\1\101\10\21\123\25\1\102\7\25\1\103\1\104\12\25\1\105\15\25\1\106\6\21"+
    "\1\25\1\107\u0582\21\1\110\u017f\21");

  /* The ZZ_CMAP_Y table has 4672 entries */
  static final char ZZ_CMAP_Y[] = zzUnpackCMap(
    "\1\0\1\1\1\0\1\2\1\3\1\4\1\5\1\6\1\7\2\10\1\11\1\12\1\13\1\14\1\15\4\0\1\16"+
    "\1\17\1\20\1\21\2\22\1\23\3\22\1\23\71\22\1\24\1\22\1\25\1\26\1\27\1\30\2"+
    "\26\16\0\1\31\1\32\1\33\1\34\2\22\1\35\11\22\1\36\21\22\1\37\1\40\24\22\1"+
    "\41\3\22\1\23\1\42\1\41\4\22\1\43\1\44\4\0\1\45\1\46\1\26\3\22\2\47\1\26\1"+
    "\50\1\51\1\0\1\52\5\22\1\53\3\0\1\54\1\55\13\22\1\56\1\45\1\57\1\60\1\0\1"+
    "\61\1\26\1\62\1\63\3\22\3\0\1\64\12\22\1\65\1\0\1\66\1\26\1\0\1\67\3\22\1"+
    "\53\1\70\1\21\2\22\1\65\1\71\1\72\1\73\2\26\3\22\1\74\1\22\1\47\6\26\2\22"+
    "\1\31\1\75\2\26\1\76\5\0\1\77\6\22\1\100\2\0\1\101\1\22\1\102\1\0\1\41\1\22"+
    "\1\103\1\104\1\105\2\22\1\106\1\107\1\110\1\111\1\112\1\62\1\113\1\102\1\0"+
    "\1\114\1\115\1\116\1\117\1\105\2\22\1\106\1\120\1\121\1\122\1\123\1\124\1"+
    "\125\1\126\1\0\1\127\1\26\1\116\1\36\1\35\2\22\1\106\1\130\1\110\1\45\1\131"+
    "\1\132\1\26\1\102\1\0\1\42\1\133\1\116\1\104\1\105\2\22\1\106\1\130\1\110"+
    "\1\111\1\123\1\126\1\113\1\102\1\0\1\42\1\26\1\134\1\135\1\136\1\137\1\115"+
    "\1\135\1\22\1\140\1\141\1\142\1\143\1\26\1\126\1\0\1\26\1\42\1\144\1\31\1"+
    "\106\2\22\1\106\1\22\1\145\1\146\1\142\1\147\1\47\1\102\1\0\2\26\1\103\1\31"+
    "\1\106\2\22\1\106\1\150\1\110\1\146\1\142\1\147\1\33\1\102\1\0\1\151\1\26"+
    "\1\144\1\31\1\106\4\22\1\152\1\146\1\153\1\154\1\43\1\102\1\0\1\26\1\40\1"+
    "\155\1\22\1\23\1\40\2\22\1\35\1\156\1\23\1\157\1\160\1\0\1\126\1\0\1\161\1"+
    "\26\1\41\5\22\1\162\1\163\1\164\1\165\1\0\1\166\4\26\1\167\1\170\1\171\1\41"+
    "\1\172\1\173\1\162\1\174\1\175\1\50\1\0\1\176\4\26\1\132\2\26\1\166\1\0\1"+
    "\166\1\177\1\200\1\22\1\41\3\22\1\27\1\44\1\0\1\146\1\201\1\0\1\44\3\0\1\202"+
    "\1\203\7\26\5\22\1\53\1\0\1\204\1\0\1\166\1\65\1\205\1\206\1\207\1\210\1\22"+
    "\1\211\1\212\1\0\1\50\4\22\1\36\1\20\5\22\1\213\51\22\1\136\1\23\1\136\5\22"+
    "\1\136\4\22\1\136\1\23\1\136\1\22\1\23\7\22\1\136\10\22\1\214\4\26\2\22\2"+
    "\26\12\22\2\75\1\41\114\22\1\104\2\22\1\41\2\22\1\47\11\22\1\135\1\22\1\132"+
    "\1\22\1\31\1\215\1\26\2\22\1\215\1\26\2\22\1\216\1\26\1\22\1\31\1\217\1\26"+
    "\6\22\1\220\3\0\1\221\1\222\1\0\1\166\3\26\1\223\1\0\1\166\13\22\1\26\1\224"+
    "\4\22\1\225\10\22\1\75\1\26\3\22\1\23\1\0\1\2\1\0\1\2\1\126\1\0\3\22\1\75"+
    "\1\27\1\26\5\22\1\114\3\22\1\25\1\0\1\166\4\26\2\22\1\164\1\2\6\22\1\201\1"+
    "\165\3\0\1\111\1\0\1\166\1\0\1\166\1\43\1\26\1\0\1\50\10\26\1\226\5\22\1\220"+
    "\1\0\1\226\1\114\1\0\1\166\1\26\1\227\1\2\1\26\1\230\3\22\1\101\1\207\1\0"+
    "\1\67\4\22\1\65\1\0\1\2\1\26\4\22\1\220\2\0\1\26\1\0\1\231\1\0\1\67\3\22\1"+
    "\75\1\22\1\132\10\26\1\232\2\0\1\233\1\234\1\166\30\22\7\0\1\235\42\22\2\75"+
    "\4\22\2\75\1\22\1\236\3\22\1\75\6\22\1\31\1\175\1\237\1\27\1\240\1\114\1\22"+
    "\1\27\1\237\1\27\1\26\1\227\3\26\1\241\1\26\1\43\1\132\1\26\1\242\1\26\1\146"+
    "\1\0\1\42\1\43\2\26\1\22\1\27\4\22\2\26\1\0\1\202\1\243\1\0\1\244\1\26\1\245"+
    "\1\40\1\156\1\246\1\30\1\247\1\22\1\250\1\251\1\252\2\26\5\22\1\132\116\26"+
    "\5\22\1\23\5\22\1\23\20\22\1\27\1\253\1\254\1\26\4\22\1\36\1\20\7\22\1\43"+
    "\1\26\1\62\2\22\1\23\1\26\10\23\4\0\5\26\1\43\72\26\1\251\3\26\1\41\1\211"+
    "\1\246\1\27\1\41\11\22\1\23\1\255\1\41\12\22\1\213\1\251\4\22\1\23\1\41\12"+
    "\22\1\23\2\26\3\22\1\47\6\26\170\22\1\75\11\26\75\22\1\47\2\26\21\22\1\27"+
    "\10\26\5\22\1\75\41\22\1\27\2\22\1\0\1\254\2\26\5\22\1\164\1\76\1\256\3\22"+
    "\1\65\12\22\1\166\3\26\1\43\1\22\1\40\14\22\1\105\3\22\1\23\1\22\7\26\1\43"+
    "\1\22\1\257\1\260\2\22\1\53\2\26\1\132\6\22\1\114\1\26\1\67\5\22\1\220\1\0"+
    "\1\50\1\26\1\0\1\166\2\0\1\67\1\261\1\0\1\67\2\22\1\65\1\50\2\22\1\164\1\0"+
    "\1\2\1\26\3\22\1\27\1\77\5\22\1\53\1\0\1\244\1\43\1\0\1\166\1\262\1\22\1\0"+
    "\1\263\5\22\1\101\1\165\1\26\1\260\1\264\1\0\1\166\2\22\1\23\1\265\6\22\1"+
    "\206\1\266\1\225\2\26\1\267\1\22\1\53\1\270\1\26\3\271\1\26\2\23\5\22\1\213"+
    "\1\75\1\26\16\22\1\53\1\272\1\0\1\166\64\22\1\114\1\26\2\22\1\23\1\273\5\22"+
    "\1\114\40\26\55\22\1\75\15\22\1\25\4\26\1\23\1\26\1\273\1\274\1\22\1\106\1"+
    "\23\1\175\1\275\15\22\1\25\3\26\1\273\54\22\1\75\2\26\10\22\1\40\6\22\5\26"+
    "\1\22\1\27\2\0\2\26\2\0\1\115\2\26\1\251\3\26\1\42\1\31\20\22\1\276\1\242"+
    "\1\26\1\0\1\166\1\41\2\22\1\117\1\41\2\22\1\47\1\277\12\22\1\23\3\40\1\300"+
    "\1\301\2\26\1\302\1\22\1\150\2\22\1\23\2\22\1\303\1\22\1\75\1\22\1\75\4\26"+
    "\17\22\1\47\10\26\6\22\1\27\20\26\1\304\20\26\3\22\1\27\6\22\1\132\1\26\1"+
    "\244\3\26\4\22\1\26\1\251\3\22\1\47\4\22\1\65\1\305\3\22\1\75\4\22\1\114\1"+
    "\22\1\246\5\26\23\22\1\75\1\0\1\166\4\22\1\114\4\22\1\114\5\22\1\26\6\22\1"+
    "\114\23\26\46\22\1\23\1\26\2\22\1\75\1\26\1\22\23\26\1\75\1\106\4\22\1\36"+
    "\1\306\2\22\1\75\1\26\2\22\1\23\1\26\3\22\1\23\10\26\2\22\1\307\1\26\2\22"+
    "\1\75\1\26\3\22\1\25\10\26\7\22\1\277\10\26\1\310\1\76\1\150\1\41\2\22\1\114"+
    "\1\122\4\26\3\22\1\27\3\22\1\27\4\26\1\22\1\41\2\22\1\311\3\26\6\22\1\75\1"+
    "\26\2\22\1\75\1\26\2\22\1\47\1\26\2\22\1\25\15\26\11\22\1\132\6\26\6\22\1"+
    "\47\1\26\6\22\1\47\41\26\1\230\6\22\1\0\1\165\3\26\1\126\1\0\1\26\1\62\1\230"+
    "\5\22\1\0\1\312\2\26\3\22\1\132\1\0\1\166\1\230\3\22\1\164\1\0\1\146\1\0\2"+
    "\26\4\22\1\313\1\26\1\230\5\22\1\53\1\0\1\314\1\315\1\0\1\316\4\26\2\22\1"+
    "\35\2\22\1\220\1\0\1\203\10\26\1\23\1\247\1\22\1\36\1\22\1\132\5\22\1\164"+
    "\1\0\1\305\1\0\1\166\1\144\1\104\1\105\2\22\1\106\1\130\1\110\1\111\1\123"+
    "\1\143\1\251\1\102\2\202\21\26\6\22\1\201\1\0\1\204\1\47\1\0\1\166\4\26\6"+
    "\22\2\0\1\317\1\26\1\0\1\166\24\26\5\22\1\164\1\50\1\0\1\244\2\26\1\264\4"+
    "\26\6\22\2\0\1\320\1\26\1\0\1\166\4\26\5\22\1\53\1\0\1\26\1\0\1\166\6\26\3"+
    "\22\1\321\1\0\1\2\1\0\1\166\54\26\10\22\1\0\1\166\1\26\1\43\40\26\1\101\1"+
    "\230\4\22\1\53\1\322\1\62\1\26\1\101\1\77\4\22\1\240\1\211\1\0\1\166\4\26"+
    "\7\22\1\132\40\26\1\22\1\106\3\22\1\164\1\165\1\0\1\132\1\26\1\0\1\166\2\26"+
    "\1\40\3\22\1\323\2\0\1\44\1\165\11\26\1\23\1\35\4\22\1\324\1\325\1\212\1\26"+
    "\1\0\1\166\24\26\63\22\1\25\14\26\15\22\1\23\2\26\30\22\1\114\27\26\5\22\1"+
    "\23\72\26\10\22\1\23\67\26\7\22\1\132\3\22\1\23\1\0\1\166\14\26\3\22\1\75"+
    "\1\202\1\26\6\22\1\165\1\26\1\114\1\26\1\0\1\166\1\273\2\22\1\251\2\22\56"+
    "\26\10\22\1\27\1\26\1\101\4\0\1\165\1\26\1\62\1\230\1\22\10\26\1\25\3\26\75"+
    "\22\1\27\2\26\36\22\1\47\41\26\43\22\1\23\12\26\61\22\1\114\40\26\15\22\1"+
    "\47\1\22\1\27\1\22\1\132\1\22\1\326\1\2\127\26\1\327\1\330\2\0\1\331\1\2\3"+
    "\26\1\332\22\26\1\315\67\26\12\22\1\31\10\22\1\31\1\333\1\334\1\22\1\335\1"+
    "\150\7\22\1\36\1\336\2\31\3\22\1\337\1\175\1\40\1\106\51\22\1\75\3\22\1\106"+
    "\2\22\1\213\3\22\1\213\2\22\1\31\3\22\1\31\2\22\1\23\3\22\1\23\3\22\1\106"+
    "\3\22\1\106\2\22\1\213\1\340\14\0\1\165\1\227\5\0\1\202\1\304\1\26\1\341\2"+
    "\26\1\227\1\44\1\0\52\26\1\165\2\0\1\342\1\343\1\305\72\26\30\22\1\27\1\26"+
    "\1\165\5\26\10\22\1\220\1\305\1\0\1\166\24\26\1\150\3\22\1\167\1\41\1\213"+
    "\1\344\1\245\1\345\1\167\1\236\1\167\2\213\1\125\1\22\1\35\1\22\1\114\1\346"+
    "\1\35\1\22\1\114\50\26\32\22\1\23\5\26\106\22\1\27\1\26\33\22\1\75\120\22"+
    "\1\25\1\26\146\22\1\132\3\26\3\22\1\75\74\26\1\124\3\26\14\0\20\26\36\0\2"+
    "\26");

  /* The ZZ_CMAP_A table has 1848 entries */
  static final char ZZ_CMAP_A[] = zzUnpackCMap(
    "\11\12\1\7\1\24\1\0\2\30\6\12\4\0\1\7\2\0\1\17\1\11\2\0\1\20\1\32\1\33\1\0"+
    "\1\21\1\31\1\21\1\2\1\0\12\4\1\22\1\0\1\27\1\0\1\23\1\0\1\10\22\1\1\25\1\6"+
    "\1\26\1\0\1\3\1\5\1\14\13\1\1\16\2\1\1\13\1\1\1\15\10\1\4\0\1\12\2\0\4\11"+
    "\4\0\1\11\2\0\1\12\7\0\1\11\4\0\1\11\5\0\17\11\1\0\2\11\4\0\4\11\16\0\5\11"+
    "\7\0\1\11\1\0\1\11\1\0\5\11\1\0\2\11\2\0\4\11\1\0\1\11\6\0\1\11\1\0\3\11\1"+
    "\0\1\11\1\0\4\11\1\0\13\11\1\0\3\11\1\0\5\12\2\0\6\11\1\0\7\11\1\0\1\11\15"+
    "\0\1\11\1\0\15\12\1\0\1\12\1\0\2\12\1\0\2\12\1\0\1\12\3\11\5\0\6\12\5\0\1"+
    "\11\4\0\3\12\1\0\1\12\3\0\3\11\7\12\4\0\2\11\1\12\13\11\1\0\1\11\7\12\2\11"+
    "\2\12\1\0\4\12\2\11\2\12\3\11\2\0\1\11\7\0\1\12\1\11\1\12\6\11\3\12\2\0\11"+
    "\11\3\12\1\11\6\0\2\12\6\11\4\12\2\11\2\0\2\12\1\11\11\12\1\11\3\12\1\11\5"+
    "\12\2\0\1\11\3\12\4\0\6\11\6\0\10\12\6\11\3\12\1\11\2\12\1\11\7\12\2\11\2"+
    "\12\2\0\2\12\1\11\3\12\1\0\10\11\2\0\2\11\2\0\6\11\1\0\7\11\1\0\1\11\3\0\4"+
    "\11\2\0\1\12\1\11\7\12\2\0\2\12\2\0\3\12\1\11\5\0\2\11\1\0\5\11\7\0\2\11\4"+
    "\0\3\12\1\0\6\11\4\0\2\11\1\0\2\11\1\0\2\11\1\0\2\11\2\0\1\12\1\0\5\12\4\0"+
    "\2\12\2\0\3\12\3\0\1\12\7\0\4\11\1\0\1\11\7\0\4\12\3\11\1\12\2\0\1\11\1\0"+
    "\2\11\1\0\3\11\2\12\1\0\3\12\2\0\1\11\10\0\1\11\6\12\2\0\1\12\1\11\1\0\6\11"+
    "\3\0\3\11\1\0\4\11\3\0\2\11\1\0\1\11\1\0\4\11\4\0\5\12\3\0\3\12\1\0\4\12\2"+
    "\0\1\11\6\0\5\12\1\0\5\11\3\0\1\11\7\12\1\0\2\12\5\0\2\12\1\0\4\11\1\0\3\11"+
    "\1\0\2\11\5\0\3\11\2\12\1\11\3\12\1\0\4\12\1\11\5\0\3\11\1\12\2\0\2\12\1\0"+
    "\7\11\1\0\1\11\4\0\1\12\4\0\6\12\1\0\1\12\3\0\2\12\4\0\1\11\1\12\2\11\7\12"+
    "\4\0\10\11\10\12\1\0\2\12\7\0\2\11\1\0\1\11\2\0\2\11\1\0\1\11\2\0\1\11\6\0"+
    "\4\11\1\0\3\11\1\0\1\11\1\0\1\11\2\0\2\11\1\0\3\11\2\12\1\0\2\12\1\11\2\0"+
    "\5\11\1\0\1\11\1\0\2\12\2\0\4\11\5\0\1\12\1\0\1\12\1\0\1\12\4\0\2\12\5\11"+
    "\10\12\11\0\1\12\1\0\7\12\1\11\2\12\4\11\3\12\1\11\3\12\2\11\7\12\3\11\4\12"+
    "\5\11\14\12\1\11\1\12\3\11\1\0\7\11\2\0\3\12\2\11\3\12\3\0\2\11\2\12\4\0\1"+
    "\11\1\0\2\12\4\0\4\11\10\12\3\0\1\11\3\0\2\11\1\12\5\0\4\12\1\0\5\11\2\12"+
    "\2\11\1\12\1\11\5\0\5\12\3\11\3\0\10\12\5\11\2\12\3\0\3\11\3\12\1\0\5\12\4"+
    "\11\1\12\4\11\3\12\2\11\3\12\1\0\5\12\1\0\1\11\1\0\1\11\1\0\1\11\1\0\1\11"+
    "\2\0\3\11\1\0\6\11\2\0\2\11\2\0\5\12\5\0\1\11\4\0\1\12\3\0\4\12\11\0\1\11"+
    "\4\0\1\11\1\0\5\11\2\0\1\11\1\0\4\11\1\0\3\11\2\0\4\11\5\0\5\11\4\0\1\11\4"+
    "\0\4\11\3\12\2\11\5\0\2\12\2\0\3\11\6\12\1\0\3\11\1\12\3\11\1\12\4\11\1\12"+
    "\4\11\3\0\1\11\1\0\1\11\2\0\5\11\1\12\2\11\2\12\5\11\1\0\4\11\2\12\4\0\1\11"+
    "\3\12\2\11\1\12\5\11\2\12\3\0\3\11\4\0\3\11\2\12\2\0\6\11\1\0\3\12\1\0\2\12"+
    "\5\0\5\11\5\0\1\11\1\12\3\11\1\0\2\11\1\0\7\11\2\0\1\12\6\0\2\11\2\0\3\11"+
    "\3\0\2\11\3\0\2\11\2\0\3\12\4\0\3\11\1\0\2\11\1\0\1\11\5\0\1\12\2\0\3\12\5"+
    "\0\1\11\3\0\1\11\2\0\4\11\1\0\2\11\2\0\1\11\3\12\1\0\2\12\1\0\5\11\2\12\1"+
    "\0\3\12\2\0\1\12\2\0\3\11\1\12\2\0\1\11\1\0\1\12\4\11\5\0\3\12\3\0\2\12\1"+
    "\11\1\0\1\11\3\0\4\12\2\11\1\0\1\11\1\12\3\0\1\11\3\0\2\11\3\0\5\12\1\11\4"+
    "\12\3\0\6\12\1\11\6\12\3\0\1\12\1\0\2\12\1\0\1\12\2\11\3\0\2\12\6\0\5\12\3"+
    "\0\6\12\2\0\3\12\2\0\4\12\4\0\1\11\2\0\2\11\2\0\4\11\1\0\4\11\1\0\1\11\1\0"+
    "\6\11\2\0\5\11\1\0\4\11\1\0\4\11\2\0\2\12\4\0\1\12\3\0\1\12\2\0\7\12\1\0\2"+
    "\12\1\0\2\12\1\0\1\11\1\0\1\11\5\0\1\11\1\0\1\11\1\0\3\11\1\0\3\11\1\0\3\11");

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\3\0\1\1\4\0\1\2\1\3\1\2\2\4\2\2"+
    "\1\5\1\6\1\7\1\1\2\10\1\4\1\11\3\2"+
    "\1\12\1\13\1\14\1\15\1\2\1\16\1\17\1\4"+
    "\1\20\1\21\1\22\2\23\1\2\1\0\1\10\1\0"+
    "\1\2\1\24\1\25\2\0\1\23\1\0\1\23\1\26"+
    "\1\23\1\27";

  private static int [] zzUnpackAction() {
    int [] result = new int[54];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\34\0\70\0\124\0\160\0\214\0\250\0\304"+
    "\0\340\0\374\0\u0118\0\340\0\u0134\0\u0150\0\u016c\0\340"+
    "\0\340\0\340\0\u0188\0\u01a4\0\u01c0\0\u01dc\0\340\0\u01dc"+
    "\0\u01f8\0\u0214\0\340\0\u0230\0\340\0\340\0\u024c\0\340"+
    "\0\340\0\u0268\0\340\0\340\0\340\0\u0284\0\u02a0\0\u02bc"+
    "\0\u01dc\0\340\0\u02d8\0\u02f4\0\340\0\340\0\u0268\0\u0310"+
    "\0\u032c\0\u0348\0\u0364\0\340\0\u0380\0\u0284";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[54];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\7\11\1\12\7\11\1\13\14\11\7\14\1\12\1\15"+
    "\23\14\6\16\1\17\1\12\14\16\1\20\1\21\1\16"+
    "\1\22\1\11\3\16\7\11\1\23\24\11\1\14\1\24"+
    "\1\25\2\14\1\26\5\14\4\24\12\14\1\27\2\14"+
    "\1\11\1\24\1\25\2\11\1\30\1\31\1\12\3\11"+
    "\4\24\3\11\1\32\1\11\1\20\1\33\1\34\1\22"+
    "\2\11\1\35\1\36\24\37\1\11\3\37\1\11\1\37"+
    "\1\40\1\41\1\14\1\42\11\14\4\42\4\14\1\43"+
    "\1\14\1\21\1\14\1\44\4\14\43\0\1\12\44\0"+
    "\1\45\14\0\1\46\1\0\1\46\5\0\1\46\1\0"+
    "\1\47\3\46\15\0\7\16\1\0\14\16\2\0\1\16"+
    "\2\0\11\16\1\50\1\11\14\16\2\11\1\16\2\11"+
    "\3\16\7\0\1\23\25\0\4\24\6\0\4\24\16\0"+
    "\3\24\7\0\4\24\15\0\5\51\1\52\1\53\25\51"+
    "\6\11\1\54\25\11\22\0\1\55\43\0\1\56\1\0"+
    "\24\37\1\0\3\37\1\0\1\37\3\0\2\57\1\0"+
    "\1\57\6\0\4\57\2\0\1\57\1\60\12\0\1\46"+
    "\1\0\2\46\4\0\6\46\16\0\1\46\1\0\2\46"+
    "\4\0\3\46\1\61\2\46\15\0\7\16\1\0\14\16"+
    "\1\0\1\11\1\16\2\0\3\16\34\51\25\0\2\11"+
    "\5\0\7\62\1\0\13\62\2\0\2\62\2\0\3\62"+
    "\1\0\1\46\1\0\2\46\4\0\4\46\1\63\1\46"+
    "\15\0\7\62\1\0\13\62\1\64\1\0\2\62\2\0"+
    "\3\62\1\0\1\46\1\0\2\46\4\0\3\46\1\65"+
    "\2\46\16\0\1\46\1\0\2\46\4\0\5\46\1\66"+
    "\15\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[924];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String[] ZZ_ERROR_MSG = {
    "Unknown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\3\0\1\1\4\0\1\11\2\1\1\11\3\1\3\11"+
    "\4\1\1\11\3\1\1\11\1\1\2\11\1\1\2\11"+
    "\1\1\3\11\3\1\1\0\1\11\1\0\1\1\2\11"+
    "\2\0\1\1\1\0\1\1\1\11\2\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[54];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private CharSequence zzBuffer = "";

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /**
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;

  /* user code: */
  private Stack<IElementType> myExpectedBracketsStack = new Stack<>();


  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  _RoxygenLexer(java.io.Reader in) {
    this.zzReader = in;
  }


  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    int size = 0;
    for (int i = 0, length = packed.length(); i < length; i += 2) {
      size += packed.charAt(i);
    }
    char[] map = new char[size];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < packed.length()) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }

  public final int getTokenStart() {
    return zzStartRead;
  }

  public final int getTokenEnd() {
    return getTokenStart() + yylength();
  }

  public void reset(CharSequence buffer, int start, int end, int initialState) {
    zzBuffer = buffer;
    zzCurrentPos = zzMarkedPos = zzStartRead = start;
    zzAtEOF  = false;
    zzAtBOL = true;
    zzEndRead = end;
    yybegin(initialState);
  }

  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   *
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {
    return true;
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final CharSequence yytext() {
    return zzBuffer.subSequence(zzStartRead, zzMarkedPos);
  }


  /**
   * Returns the character at position <tt>pos</tt> from the
   * matched text.
   *
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch.
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer.charAt(zzStartRead+pos);
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occurred while scanning.
   *
   * In a wellformed scanner (no or only correct usage of
   * yypushback(int) and a match-all fallback rule) this method
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  }


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public IElementType advance() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    CharSequence zzBufferL = zzBuffer;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;

      zzState = ZZ_LEXSTATE[zzLexicalState];

      // set up zzAction for empty match case:
      int zzAttributes = zzAttrL[zzState];
      if ( (zzAttributes & 1) == 1 ) {
        zzAction = zzState;
      }


      zzForAction: {
        while (true) {

          if (zzCurrentPosL < zzEndReadL) {
            zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL/*, zzEndReadL*/);
            zzCurrentPosL += Character.charCount(zzInput);
          }
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL/*, zzEndReadL*/);
              zzCurrentPosL += Character.charCount(zzInput);
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + ZZ_CMAP(zzInput) ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
        zzAtEOF = true;
        return null;
      }
      else {
        switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
          case 1: 
            { yybegin(PARAM_LIST_CONTINUE); if (yylength() > 0) return ROXYGEN_WS;
            } 
            // fall through
          case 24: break;
          case 2: 
            { return ROXYGEN_TEXT;
            } 
            // fall through
          case 25: break;
          case 3: 
            { return ROXYGEN_WS;
            } 
            // fall through
          case 26: break;
          case 4: 
            { yybegin(COMMENT_LINE_CONTINUE); yypushback(1);
            } 
            // fall through
          case 27: break;
          case 5: 
            { yybegin(YYINITIAL); return ROXYGEN_NL;
            } 
            // fall through
          case 28: break;
          case 6: 
            { yybegin(HELP_LINK_OR_LINK_TEXT); return ROXYGEN_LBRACKET;
            } 
            // fall through
          case 29: break;
          case 7: 
            { yybegin(AUTOLINK); return ROXYGEN_LANGLE;
            } 
            // fall through
          case 30: break;
          case 8: 
            { return ROXYGEN_IDENTIFIER;
            } 
            // fall through
          case 31: break;
          case 9: 
            { return ROXYGEN_COMMA;
            } 
            // fall through
          case 32: break;
          case 10: 
            { return ROXYGEN_LBRACKET;
            } 
            // fall through
          case 33: break;
          case 11: 
            { yybegin(COMMENT_LINE_CONTINUE); return ROXYGEN_RBRACKET;
            } 
            // fall through
          case 34: break;
          case 12: 
            { return ROXYGEN_LPAR;
            } 
            // fall through
          case 35: break;
          case 13: 
            { return ROXYGEN_RPAR;
            } 
            // fall through
          case 36: break;
          case 14: 
            { IElementType returnValue = myExpectedBracketsStack.isEmpty() ? ROXYGEN_LPAR : ROXYGEN_TEXT;
                                  myExpectedBracketsStack.add(ROXYGEN_LPAR);
                                  return returnValue;
            } 
            // fall through
          case 37: break;
          case 15: 
            { myExpectedBracketsStack.pop();
                                  IElementType returnValue;
                                  if (myExpectedBracketsStack.isEmpty()) {
                                    yybegin(COMMENT_LINE_CONTINUE);
                                    returnValue = ROXYGEN_RPAR;
                                  }
                                  else returnValue = ROXYGEN_TEXT;
                                  return returnValue;
            } 
            // fall through
          case 38: break;
          case 16: 
            { yybegin(COMMENT_LINE_CONTINUE); return ROXYGEN_RANGLE;
            } 
            // fall through
          case 39: break;
          case 17: 
            { return ROXYGEN_LANGLE;
            } 
            // fall through
          case 40: break;
          case 18: 
            { yybegin(COMMENT_LINE_START); return ROXYGEN_DOC_PREFIX;
            } 
            // fall through
          case 41: break;
          case 19: 
            { yybegin(COMMENT_LINE_CONTINUE); return ROXYGEN_TAG_NAME;
            } 
            // fall through
          case 42: break;
          case 20: 
            { return ROXYGEN_DOUBLECOLON;
            } 
            // fall through
          case 43: break;
          case 21: 
            // lookahead expression with fixed base length
            zzMarkedPos = Character.offsetByCodePoints
                (zzBufferL/*, zzStartRead, zzEndRead - zzStartRead*/, zzStartRead, 1);
            { yybegin(LINK_DESTINATION); return ROXYGEN_RBRACKET;
            } 
            // fall through
          case 44: break;
          case 22: 
            // lookahead expression with fixed lookahead length
            zzMarkedPos = Character.offsetByCodePoints
                (zzBufferL/*, zzStartRead, zzEndRead - zzStartRead*/, zzMarkedPos, -1);
            { return ROXYGEN_AUTOLINK_URI;
            } 
            // fall through
          case 45: break;
          case 23: 
            { yybegin(PARAM_LIST_START); return ROXYGEN_TAG_NAME;
            } 
            // fall through
          case 46: break;
          default:
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}
