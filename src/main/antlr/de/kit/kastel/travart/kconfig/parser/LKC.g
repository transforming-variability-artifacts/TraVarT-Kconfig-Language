// vim: ft=antlr
// Vim's syntax file for ANTLR grammars seems to be obsolete...
/**
* Copyright (c) 2023 Kaan Berk Yaman
* Copyright (c) 2009 Steven She
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*
* The original version of this file can be found under
* https://code.google.com/archive/p/kconfig-g/
*
* Contributors:
*   Steven She - initial API and implementation
*   Kaan Berk Yaman - KFeature adaptation and minor bug fixes
*/
grammar LKC;

options {
  language = Java;
  output = AST;
  ASTLabelType = CommonTree;
}

tokens {
  INDENT;
  BLOCK;
  HEX='hex';
  DASH='-';
}

@header {
package de.kit.kastel.travart.kconfig.parser;
import java.io.IOException;
// Required for parsing of source statements
}

@members {
  public String baseDir;

  public String getErrorHeader(RecognitionException e) {
    String msg = super.getErrorHeader(e);
    msg = getSourceName() + ": " + msg;
    return msg;
  }
}

@lexer::header {
package de.kit.kastel.travart.kconfig.parser;
}
@lexer::members {
  protected int startPos=-1;
  protected int helpMargin=-1, nextMargin=-1;

  private int wsLength(Token t) {
    if (t == null) return 0;
    int spaces = 0;
    for (char c : t.getText().toCharArray()) {
      if (c == '\t') {
        spaces += 8 - ((spaces - 8 *  (spaces / 8)));
      }
      else {
        spaces++;
      }
    }
    //System.out.println("Checking wsLength: " + spaces);
    return spaces;
  }

  //Emit Multiple Tokens per rule
  //Needed for HEX_OR_HELP
  List<Token> tokens = new ArrayList<Token>();
  public void emit(Token token) {
     state.token = token;
     tokens.add(token);
  }
  public Token nextToken() {
    super.nextToken();
    if ( tokens.size()==0 ) {
      return getEOFToken();
    }
    return (Token)tokens.remove(0);
  }

  public String getErrorHeader(RecognitionException e) {
    String msg = super.getErrorHeader(e);
    msg = getSourceName() + ": " + msg;
    return msg;
   }
   
  @Override
  public void reportError(RecognitionException e) {
	// Suppress lexer errors, i.e., "no viable alternative"
  }
}

input: stmts+;

stmts:
     common_stmt
     | menu_stmt
     | choice_stmt
     | mainmenu_stmt
     ;

block
    : block_stmts* -> ^(BLOCK block_stmts*)
    ;

block_stmts
    : common_stmt
    | menu_stmt
    | choice_stmt
    ;

common_stmt
    : config_stmt
    | source_stmt
    | comment_stmt
    | if_stmt
    | NEWLINE!
    ;


mainmenu_stmt
    : MAINMENU^ prompt NEWLINE!
    ;

/**
FIXME rewrite rule
**/
menu_stmt
    : MENU prompt NEWLINE depends_stmt* block ENDMENU
    -> ^(MENU prompt depends_stmt* block)
    ;

choice_stmt
    : CHOICE WORD? NEWLINE option_stmt+ common_stmt* ENDCHOICE
    -> ^(CHOICE WORD? option_stmt+ common_stmt*)
    ;

depends_stmt
    : INDENT!? DEPENDS^ ON! expr NEWLINE!
    ;

comment_stmt
    : COMMENT^ prompt NEWLINE! depends_stmt*
    ;

source_stmt
@init { CommonTree includetree = null; }
 :
  INDENT? 'source' include_filename=prompt NEWLINE {
//    System.out.println($include_filename.text);
    try {
      CharStream inputstream = null;
      inputstream = new ANTLRFileStream(baseDir + "/" + $include_filename.text);
      LKCLexer innerlexer = new LKCLexer(inputstream);
      LKCParser innerparser = new LKCParser(new CommonTokenStream(innerlexer));
      innerparser.baseDir = baseDir;
      includetree = (CommonTree)(innerparser.input().getTree());
    } catch (IOException fnf) {
      fnf.printStackTrace();
      throw new RuntimeException(fnf);
    }
  }
  -> ^('source' prompt {includetree});



if_stmt
    : if_expr^ NEWLINE! block ENDIF
    ;

config_stmt
    : INDENT!? (CONFIG|MENUCONFIG)^ WORD NEWLINE! option_stmt+
    ;

option_stmt
    : INDENT! config_option^ if_expr? NEWLINE!
    | HELP_TEXT
    ;

config_option
    : type^      (WORD | WORD_QUOTE)? ';'!?
    | DEPENDS^  ON! expr
    | PROMPT^   (WORD | WORD_QUOTE)
    | SELECT^   WORD
    | DEFAULT^  expr
    | RANGE^    WORD WORD
    | OPTION^   misc_option
    | OPTIONAL
    ;

fragment
type        :  'tristate' | 'bool' | 'boolean' | 'int' | 'string' | HEX;

fragment
prompt
    : WORD | WORD_QUOTE;

misc_option
    : ENV^ '='! WORD_QUOTE
    | DEFCONFIG_LIST
    ;

/**
Expressions
**/

if_expr
    : IF^ expr
    ;

expr
    : or_expr expr?
    ;

or_expr
    : and_expr ('|'^ and_expr)*
    ;

and_expr
    : unary_expr ('&'^ unary_expr)*
    ;

unary_expr
    : '~'^ unary_expr
    | equals_expr
    ;

equals_expr
    : primary (('='|'!=')^ primary)?
    ;

/**
FIXME
**/
primary
    : atom
    | '('! expr ')'!
    ;

atom: WORD | WORD_QUOTE | FALSE | TRUE;

MAINMENU    : 'mainmenu';
CHOICE      : 'choice';
ENDCHOICE   : 'endchoice';
MENU        : 'menu';
ENDMENU     : 'endmenu';
IF          : 'if';
ENDIF       : 'endif';
SOURCE      : 'source';
COMMENT     : 'comment';
CONFIG      : 'config';
MENUCONFIG  : 'menuconfig';
DEPENDS     : 'depends';
ON          : 'on';
SELECT      : 'select';
DEFAULT     : 'default' | 'def_bool' | 'def_tristate';
RANGE       : 'range';
HELP        : 'help';
PROMPT      : 'prompt';
OPTION      : 'option';
ENV         : 'env';
DEFCONFIG_LIST: 'defconfig_list';
OPTIONAL    : 'optional';
FALSE : '$false';
TRUE : '$true';


NEWLINE
    : ('\r'? '\n')+
    {
      if (startPos==0) {
        $channel=HIDDEN;
      }
    }
    ;

WS
    : {startPos>0}?=>(' '|'\t')+
    {
      $channel=HIDDEN;
    }
    ;


LEADING_WS
@init {
  int spaces = 0;
  char[] indentation = null;
}
    : {startPos==0}?=>
      ( ' '   { spaces++; }
        | '\t'  {spaces += 8 - (spaces \% 8); }
      )+
      {
        indentation = new char[spaces];
        for (int i=0; i<spaces; i++) {
            indentation[i] = ' ';
        }
      }
      // kill trailing newline / comment if present and then ignore
      ( (('\r')? '\n' | SL_COMMENT) {$channel=HIDDEN; })*
      {
        Token t = new ClassicToken(INDENT, new String(indentation));
        t.setChannel($channel);
        emit(t);
      }
    ;

// Required as a workaround until the WS_LEADING rule is fixed
INDENT: '\t';

WORD
    :
      '-' ('0'..'9')+
    | ('A'..'Z'|'a'..'z'|'0'..'9'|'_'|'/'|'.')+
    | ('0' ('x'|'X'))=>'0' ('x' | 'X') ('0'..'9' | 'a'..'f' | 'A'..'F')+
    ;

WORD_QUOTE
    : '\'' (options {greedy=false;}:ESC|.)* '\''
    {
      setText($text.substring(1,$text.length()-1));
    }
    | '"' (options {greedy=false;}:ESC|.)* '"'
    {
      setText($text.substring(1,$text.length()-1));
    }
    ;

fragment
ESC
    : '\\' ('"'|'\'')
    ;

CONTINUE
    : '\\' NEWLINE WS
    {
      $channel=HIDDEN;
    }
    ;

DASHES
    : '-'
      ({input.LA(1)=='-'}? '-')
      ({input.LA(1)=='-'}? '-')?
    ;

/**
Disambiguate between the 'hex' or 'help' keywords
**/
HEX_OR_HELP
    : (LEADING_WS HEX)=> LEADING_WS HEX
      {
        //INDENT is emitted by LEADING_WS rule
        //HEX is emitted by this rule
        emit(new ClassicToken(HEX, "hex"));
      }
    | HELP_TEXT
    ;

/**
 * Handles the following cases:
 *  - help with no help text
 *  - --- help --- / --- help --
 *
 * TODO gather help text and emit in HELP_TEXT token
 **/
fragment
HELP_TEXT
@init {
  helpMargin = -1;
}
    :
        (
          //Disambiguate between a single dash (WORD) and multiple
          (HELP_WS DASHES)=>
           HELP_WS DASHES HELP_WS HELP HELP_WS DASHES HELP_WS NEWLINE
        |
          //Dashes not present
          HELP_WS HELP HELP_WS NEWLINE
        )
        (
           //If there is some leading space on the next line, take it
           //Otherwise, we allow empty new lines only if helpMargin has been initialized
           ( next=HELP_WS { wsLength($next) > 0 && wsLength($next) >= helpMargin }?
           | {helpMargin > 0}? HELP_WS '\n'
           )
           => next=HELP_WS (options {greedy=false;}:.)* '\n'
           {
             if (helpMargin < 0)
               helpMargin = wsLength($next);
           }
        )*
        {
          emit (new ClassicToken(HELP_TEXT, new String("<help text>")));
        }
    ;

fragment
HELP_WS : (' '|'\t')*;

SL_COMMENT
@init{
  $channel=HIDDEN;
}
    : {startPos==0}?=> '#' ~('\n')* '\n'+
    | '#' ~('\n')*
    ;
