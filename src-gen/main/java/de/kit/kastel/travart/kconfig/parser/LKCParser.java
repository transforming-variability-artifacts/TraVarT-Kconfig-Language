// $ANTLR 3.5.3 de/kit/kastel/travart/kconfig/parser/LKC.g 2024-09-10 12:06:39

package de.kit.kastel.travart.kconfig.parser;
import java.io.IOException;
// Required for parsing of source statements


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.runtime.tree.*;


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
@SuppressWarnings("all")
public class LKCParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "BLOCK", "CHOICE", "COMMENT", 
		"CONFIG", "CONTINUE", "DASH", "DASHES", "DEFAULT", "DEFCONFIG_LIST", "DEPENDS", 
		"ENDCHOICE", "ENDIF", "ENDMENU", "ENV", "ESC", "FALSE", "HELP", "HELP_TEXT", 
		"HELP_WS", "HEX", "HEX_OR_HELP", "IF", "INDENT", "LEADING_WS", "MAINMENU", 
		"MENU", "MENUCONFIG", "NEWLINE", "ON", "OPTION", "OPTIONAL", "PROMPT", 
		"RANGE", "SELECT", "SL_COMMENT", "SOURCE", "TRUE", "WORD", "WORD_QUOTE", 
		"WS", "'!='", "'&'", "'('", "')'", "';'", "'='", "'bool'", "'boolean'", 
		"'int'", "'string'", "'tristate'", "'|'", "'~'"
	};
	public static final int EOF=-1;
	public static final int T__44=44;
	public static final int T__45=45;
	public static final int T__46=46;
	public static final int T__47=47;
	public static final int T__48=48;
	public static final int T__49=49;
	public static final int T__50=50;
	public static final int T__51=51;
	public static final int T__52=52;
	public static final int T__53=53;
	public static final int T__54=54;
	public static final int T__55=55;
	public static final int T__56=56;
	public static final int BLOCK=4;
	public static final int CHOICE=5;
	public static final int COMMENT=6;
	public static final int CONFIG=7;
	public static final int CONTINUE=8;
	public static final int DASH=9;
	public static final int DASHES=10;
	public static final int DEFAULT=11;
	public static final int DEFCONFIG_LIST=12;
	public static final int DEPENDS=13;
	public static final int ENDCHOICE=14;
	public static final int ENDIF=15;
	public static final int ENDMENU=16;
	public static final int ENV=17;
	public static final int ESC=18;
	public static final int FALSE=19;
	public static final int HELP=20;
	public static final int HELP_TEXT=21;
	public static final int HELP_WS=22;
	public static final int HEX=23;
	public static final int HEX_OR_HELP=24;
	public static final int IF=25;
	public static final int INDENT=26;
	public static final int LEADING_WS=27;
	public static final int MAINMENU=28;
	public static final int MENU=29;
	public static final int MENUCONFIG=30;
	public static final int NEWLINE=31;
	public static final int ON=32;
	public static final int OPTION=33;
	public static final int OPTIONAL=34;
	public static final int PROMPT=35;
	public static final int RANGE=36;
	public static final int SELECT=37;
	public static final int SL_COMMENT=38;
	public static final int SOURCE=39;
	public static final int TRUE=40;
	public static final int WORD=41;
	public static final int WORD_QUOTE=42;
	public static final int WS=43;

	// delegates
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public LKCParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}
	public LKCParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}

	protected TreeAdaptor adaptor = new CommonTreeAdaptor();

	public void setTreeAdaptor(TreeAdaptor adaptor) {
		this.adaptor = adaptor;
	}
	public TreeAdaptor getTreeAdaptor() {
		return adaptor;
	}
	@Override public String[] getTokenNames() { return LKCParser.tokenNames; }
	@Override public String getGrammarFileName() { return "de/kit/kastel/travart/kconfig/parser/LKC.g"; }


	  public String baseDir;

	  public String getErrorHeader(RecognitionException e) {
	    String msg = super.getErrorHeader(e);
	    msg = getSourceName() + ": " + msg;
	    return msg;
	  }


	public static class input_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "input"
	// de/kit/kastel/travart/kconfig/parser/LKC.g:94:1: input : ( stmts )+ ;
	public final LKCParser.input_return input() throws RecognitionException {
		LKCParser.input_return retval = new LKCParser.input_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope stmts1 =null;


		try {
			// de/kit/kastel/travart/kconfig/parser/LKC.g:94:6: ( ( stmts )+ )
			// de/kit/kastel/travart/kconfig/parser/LKC.g:94:8: ( stmts )+
			{
			root_0 = (CommonTree)adaptor.nil();


			// de/kit/kastel/travart/kconfig/parser/LKC.g:94:8: ( stmts )+
			int cnt1=0;
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( ((LA1_0 >= CHOICE && LA1_0 <= CONFIG)||(LA1_0 >= IF && LA1_0 <= INDENT)||(LA1_0 >= MAINMENU && LA1_0 <= NEWLINE)||LA1_0==SOURCE) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// de/kit/kastel/travart/kconfig/parser/LKC.g:94:8: stmts
					{
					pushFollow(FOLLOW_stmts_in_input103);
					stmts1=stmts();
					state._fsp--;

					adaptor.addChild(root_0, stmts1.getTree());

					}
					break;

				default :
					if ( cnt1 >= 1 ) break loop1;
					EarlyExitException eee = new EarlyExitException(1, input);
					throw eee;
				}
				cnt1++;
			}

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "input"


	public static class stmts_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "stmts"
	// de/kit/kastel/travart/kconfig/parser/LKC.g:96:1: stmts : ( common_stmt | menu_stmt | choice_stmt | mainmenu_stmt );
	public final LKCParser.stmts_return stmts() throws RecognitionException {
		LKCParser.stmts_return retval = new LKCParser.stmts_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope common_stmt2 =null;
		ParserRuleReturnScope menu_stmt3 =null;
		ParserRuleReturnScope choice_stmt4 =null;
		ParserRuleReturnScope mainmenu_stmt5 =null;


		try {
			// de/kit/kastel/travart/kconfig/parser/LKC.g:96:6: ( common_stmt | menu_stmt | choice_stmt | mainmenu_stmt )
			int alt2=4;
			switch ( input.LA(1) ) {
			case COMMENT:
			case CONFIG:
			case IF:
			case INDENT:
			case MENUCONFIG:
			case NEWLINE:
			case SOURCE:
				{
				alt2=1;
				}
				break;
			case MENU:
				{
				alt2=2;
				}
				break;
			case CHOICE:
				{
				alt2=3;
				}
				break;
			case MAINMENU:
				{
				alt2=4;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 2, 0, input);
				throw nvae;
			}
			switch (alt2) {
				case 1 :
					// de/kit/kastel/travart/kconfig/parser/LKC.g:97:6: common_stmt
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_common_stmt_in_stmts116);
					common_stmt2=common_stmt();
					state._fsp--;

					adaptor.addChild(root_0, common_stmt2.getTree());

					}
					break;
				case 2 :
					// de/kit/kastel/travart/kconfig/parser/LKC.g:98:8: menu_stmt
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_menu_stmt_in_stmts125);
					menu_stmt3=menu_stmt();
					state._fsp--;

					adaptor.addChild(root_0, menu_stmt3.getTree());

					}
					break;
				case 3 :
					// de/kit/kastel/travart/kconfig/parser/LKC.g:99:8: choice_stmt
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_choice_stmt_in_stmts134);
					choice_stmt4=choice_stmt();
					state._fsp--;

					adaptor.addChild(root_0, choice_stmt4.getTree());

					}
					break;
				case 4 :
					// de/kit/kastel/travart/kconfig/parser/LKC.g:100:8: mainmenu_stmt
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_mainmenu_stmt_in_stmts143);
					mainmenu_stmt5=mainmenu_stmt();
					state._fsp--;

					adaptor.addChild(root_0, mainmenu_stmt5.getTree());

					}
					break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "stmts"


	public static class block_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "block"
	// de/kit/kastel/travart/kconfig/parser/LKC.g:103:1: block : ( block_stmts )* -> ^( BLOCK ( block_stmts )* ) ;
	public final LKCParser.block_return block() throws RecognitionException {
		LKCParser.block_return retval = new LKCParser.block_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope block_stmts6 =null;

		RewriteRuleSubtreeStream stream_block_stmts=new RewriteRuleSubtreeStream(adaptor,"rule block_stmts");

		try {
			// de/kit/kastel/travart/kconfig/parser/LKC.g:104:5: ( ( block_stmts )* -> ^( BLOCK ( block_stmts )* ) )
			// de/kit/kastel/travart/kconfig/parser/LKC.g:104:7: ( block_stmts )*
			{
			// de/kit/kastel/travart/kconfig/parser/LKC.g:104:7: ( block_stmts )*
			loop3:
			while (true) {
				int alt3=2;
				int LA3_0 = input.LA(1);
				if ( ((LA3_0 >= CHOICE && LA3_0 <= CONFIG)||(LA3_0 >= IF && LA3_0 <= INDENT)||(LA3_0 >= MENU && LA3_0 <= NEWLINE)||LA3_0==SOURCE) ) {
					alt3=1;
				}

				switch (alt3) {
				case 1 :
					// de/kit/kastel/travart/kconfig/parser/LKC.g:104:7: block_stmts
					{
					pushFollow(FOLLOW_block_stmts_in_block161);
					block_stmts6=block_stmts();
					state._fsp--;

					stream_block_stmts.add(block_stmts6.getTree());
					}
					break;

				default :
					break loop3;
				}
			}


			// AST REWRITE
			// elements: block_stmts
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 104:20: -> ^( BLOCK ( block_stmts )* )
			{
				// de/kit/kastel/travart/kconfig/parser/LKC.g:104:23: ^( BLOCK ( block_stmts )* )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(BLOCK, "BLOCK"), root_1);
				// de/kit/kastel/travart/kconfig/parser/LKC.g:104:31: ( block_stmts )*
				while ( stream_block_stmts.hasNext() ) {
					adaptor.addChild(root_1, stream_block_stmts.nextTree());
				}
				stream_block_stmts.reset();

				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "block"


	public static class block_stmts_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "block_stmts"
	// de/kit/kastel/travart/kconfig/parser/LKC.g:107:1: block_stmts : ( common_stmt | menu_stmt | choice_stmt );
	public final LKCParser.block_stmts_return block_stmts() throws RecognitionException {
		LKCParser.block_stmts_return retval = new LKCParser.block_stmts_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope common_stmt7 =null;
		ParserRuleReturnScope menu_stmt8 =null;
		ParserRuleReturnScope choice_stmt9 =null;


		try {
			// de/kit/kastel/travart/kconfig/parser/LKC.g:108:5: ( common_stmt | menu_stmt | choice_stmt )
			int alt4=3;
			switch ( input.LA(1) ) {
			case COMMENT:
			case CONFIG:
			case IF:
			case INDENT:
			case MENUCONFIG:
			case NEWLINE:
			case SOURCE:
				{
				alt4=1;
				}
				break;
			case MENU:
				{
				alt4=2;
				}
				break;
			case CHOICE:
				{
				alt4=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 4, 0, input);
				throw nvae;
			}
			switch (alt4) {
				case 1 :
					// de/kit/kastel/travart/kconfig/parser/LKC.g:108:7: common_stmt
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_common_stmt_in_block_stmts188);
					common_stmt7=common_stmt();
					state._fsp--;

					adaptor.addChild(root_0, common_stmt7.getTree());

					}
					break;
				case 2 :
					// de/kit/kastel/travart/kconfig/parser/LKC.g:109:7: menu_stmt
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_menu_stmt_in_block_stmts196);
					menu_stmt8=menu_stmt();
					state._fsp--;

					adaptor.addChild(root_0, menu_stmt8.getTree());

					}
					break;
				case 3 :
					// de/kit/kastel/travart/kconfig/parser/LKC.g:110:7: choice_stmt
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_choice_stmt_in_block_stmts204);
					choice_stmt9=choice_stmt();
					state._fsp--;

					adaptor.addChild(root_0, choice_stmt9.getTree());

					}
					break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "block_stmts"


	public static class common_stmt_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "common_stmt"
	// de/kit/kastel/travart/kconfig/parser/LKC.g:113:1: common_stmt : ( config_stmt | source_stmt | comment_stmt | if_stmt | NEWLINE !);
	public final LKCParser.common_stmt_return common_stmt() throws RecognitionException {
		LKCParser.common_stmt_return retval = new LKCParser.common_stmt_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token NEWLINE14=null;
		ParserRuleReturnScope config_stmt10 =null;
		ParserRuleReturnScope source_stmt11 =null;
		ParserRuleReturnScope comment_stmt12 =null;
		ParserRuleReturnScope if_stmt13 =null;

		CommonTree NEWLINE14_tree=null;

		try {
			// de/kit/kastel/travart/kconfig/parser/LKC.g:114:5: ( config_stmt | source_stmt | comment_stmt | if_stmt | NEWLINE !)
			int alt5=5;
			switch ( input.LA(1) ) {
			case INDENT:
				{
				int LA5_1 = input.LA(2);
				if ( (LA5_1==CONFIG||LA5_1==MENUCONFIG) ) {
					alt5=1;
				}
				else if ( (LA5_1==SOURCE) ) {
					alt5=2;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 5, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case CONFIG:
			case MENUCONFIG:
				{
				alt5=1;
				}
				break;
			case SOURCE:
				{
				alt5=2;
				}
				break;
			case COMMENT:
				{
				alt5=3;
				}
				break;
			case IF:
				{
				alt5=4;
				}
				break;
			case NEWLINE:
				{
				alt5=5;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 5, 0, input);
				throw nvae;
			}
			switch (alt5) {
				case 1 :
					// de/kit/kastel/travart/kconfig/parser/LKC.g:114:7: config_stmt
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_config_stmt_in_common_stmt221);
					config_stmt10=config_stmt();
					state._fsp--;

					adaptor.addChild(root_0, config_stmt10.getTree());

					}
					break;
				case 2 :
					// de/kit/kastel/travart/kconfig/parser/LKC.g:115:7: source_stmt
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_source_stmt_in_common_stmt229);
					source_stmt11=source_stmt();
					state._fsp--;

					adaptor.addChild(root_0, source_stmt11.getTree());

					}
					break;
				case 3 :
					// de/kit/kastel/travart/kconfig/parser/LKC.g:116:7: comment_stmt
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_comment_stmt_in_common_stmt237);
					comment_stmt12=comment_stmt();
					state._fsp--;

					adaptor.addChild(root_0, comment_stmt12.getTree());

					}
					break;
				case 4 :
					// de/kit/kastel/travart/kconfig/parser/LKC.g:117:7: if_stmt
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_if_stmt_in_common_stmt245);
					if_stmt13=if_stmt();
					state._fsp--;

					adaptor.addChild(root_0, if_stmt13.getTree());

					}
					break;
				case 5 :
					// de/kit/kastel/travart/kconfig/parser/LKC.g:118:7: NEWLINE !
					{
					root_0 = (CommonTree)adaptor.nil();


					NEWLINE14=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_common_stmt253); 
					}
					break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "common_stmt"


	public static class mainmenu_stmt_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "mainmenu_stmt"
	// de/kit/kastel/travart/kconfig/parser/LKC.g:122:1: mainmenu_stmt : MAINMENU ^ prompt NEWLINE !;
	public final LKCParser.mainmenu_stmt_return mainmenu_stmt() throws RecognitionException {
		LKCParser.mainmenu_stmt_return retval = new LKCParser.mainmenu_stmt_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token MAINMENU15=null;
		Token NEWLINE17=null;
		ParserRuleReturnScope prompt16 =null;

		CommonTree MAINMENU15_tree=null;
		CommonTree NEWLINE17_tree=null;

		try {
			// de/kit/kastel/travart/kconfig/parser/LKC.g:123:5: ( MAINMENU ^ prompt NEWLINE !)
			// de/kit/kastel/travart/kconfig/parser/LKC.g:123:7: MAINMENU ^ prompt NEWLINE !
			{
			root_0 = (CommonTree)adaptor.nil();


			MAINMENU15=(Token)match(input,MAINMENU,FOLLOW_MAINMENU_in_mainmenu_stmt272); 
			MAINMENU15_tree = (CommonTree)adaptor.create(MAINMENU15);
			root_0 = (CommonTree)adaptor.becomeRoot(MAINMENU15_tree, root_0);

			pushFollow(FOLLOW_prompt_in_mainmenu_stmt275);
			prompt16=prompt();
			state._fsp--;

			adaptor.addChild(root_0, prompt16.getTree());

			NEWLINE17=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_mainmenu_stmt277); 
			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "mainmenu_stmt"


	public static class menu_stmt_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "menu_stmt"
	// de/kit/kastel/travart/kconfig/parser/LKC.g:129:1: menu_stmt : MENU prompt NEWLINE ( depends_stmt )* block ENDMENU -> ^( MENU prompt ( depends_stmt )* block ) ;
	public final LKCParser.menu_stmt_return menu_stmt() throws RecognitionException {
		LKCParser.menu_stmt_return retval = new LKCParser.menu_stmt_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token MENU18=null;
		Token NEWLINE20=null;
		Token ENDMENU23=null;
		ParserRuleReturnScope prompt19 =null;
		ParserRuleReturnScope depends_stmt21 =null;
		ParserRuleReturnScope block22 =null;

		CommonTree MENU18_tree=null;
		CommonTree NEWLINE20_tree=null;
		CommonTree ENDMENU23_tree=null;
		RewriteRuleTokenStream stream_ENDMENU=new RewriteRuleTokenStream(adaptor,"token ENDMENU");
		RewriteRuleTokenStream stream_NEWLINE=new RewriteRuleTokenStream(adaptor,"token NEWLINE");
		RewriteRuleTokenStream stream_MENU=new RewriteRuleTokenStream(adaptor,"token MENU");
		RewriteRuleSubtreeStream stream_block=new RewriteRuleSubtreeStream(adaptor,"rule block");
		RewriteRuleSubtreeStream stream_prompt=new RewriteRuleSubtreeStream(adaptor,"rule prompt");
		RewriteRuleSubtreeStream stream_depends_stmt=new RewriteRuleSubtreeStream(adaptor,"rule depends_stmt");

		try {
			// de/kit/kastel/travart/kconfig/parser/LKC.g:130:5: ( MENU prompt NEWLINE ( depends_stmt )* block ENDMENU -> ^( MENU prompt ( depends_stmt )* block ) )
			// de/kit/kastel/travart/kconfig/parser/LKC.g:130:7: MENU prompt NEWLINE ( depends_stmt )* block ENDMENU
			{
			MENU18=(Token)match(input,MENU,FOLLOW_MENU_in_menu_stmt297);  
			stream_MENU.add(MENU18);

			pushFollow(FOLLOW_prompt_in_menu_stmt299);
			prompt19=prompt();
			state._fsp--;

			stream_prompt.add(prompt19.getTree());
			NEWLINE20=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_menu_stmt301);  
			stream_NEWLINE.add(NEWLINE20);

			// de/kit/kastel/travart/kconfig/parser/LKC.g:130:27: ( depends_stmt )*
			loop6:
			while (true) {
				int alt6=2;
				int LA6_0 = input.LA(1);
				if ( (LA6_0==INDENT) ) {
					int LA6_1 = input.LA(2);
					if ( (LA6_1==DEPENDS) ) {
						alt6=1;
					}

				}
				else if ( (LA6_0==DEPENDS) ) {
					alt6=1;
				}

				switch (alt6) {
				case 1 :
					// de/kit/kastel/travart/kconfig/parser/LKC.g:130:27: depends_stmt
					{
					pushFollow(FOLLOW_depends_stmt_in_menu_stmt303);
					depends_stmt21=depends_stmt();
					state._fsp--;

					stream_depends_stmt.add(depends_stmt21.getTree());
					}
					break;

				default :
					break loop6;
				}
			}

			pushFollow(FOLLOW_block_in_menu_stmt306);
			block22=block();
			state._fsp--;

			stream_block.add(block22.getTree());
			ENDMENU23=(Token)match(input,ENDMENU,FOLLOW_ENDMENU_in_menu_stmt308);  
			stream_ENDMENU.add(ENDMENU23);


			// AST REWRITE
			// elements: prompt, block, MENU, depends_stmt
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 131:5: -> ^( MENU prompt ( depends_stmt )* block )
			{
				// de/kit/kastel/travart/kconfig/parser/LKC.g:131:8: ^( MENU prompt ( depends_stmt )* block )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot(stream_MENU.nextNode(), root_1);
				adaptor.addChild(root_1, stream_prompt.nextTree());
				// de/kit/kastel/travart/kconfig/parser/LKC.g:131:22: ( depends_stmt )*
				while ( stream_depends_stmt.hasNext() ) {
					adaptor.addChild(root_1, stream_depends_stmt.nextTree());
				}
				stream_depends_stmt.reset();

				adaptor.addChild(root_1, stream_block.nextTree());
				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "menu_stmt"


	public static class choice_stmt_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "choice_stmt"
	// de/kit/kastel/travart/kconfig/parser/LKC.g:134:1: choice_stmt : CHOICE ( WORD )? NEWLINE ( option_stmt )+ ( common_stmt )* ENDCHOICE -> ^( CHOICE ( WORD )? ( option_stmt )+ ( common_stmt )* ) ;
	public final LKCParser.choice_stmt_return choice_stmt() throws RecognitionException {
		LKCParser.choice_stmt_return retval = new LKCParser.choice_stmt_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token CHOICE24=null;
		Token WORD25=null;
		Token NEWLINE26=null;
		Token ENDCHOICE29=null;
		ParserRuleReturnScope option_stmt27 =null;
		ParserRuleReturnScope common_stmt28 =null;

		CommonTree CHOICE24_tree=null;
		CommonTree WORD25_tree=null;
		CommonTree NEWLINE26_tree=null;
		CommonTree ENDCHOICE29_tree=null;
		RewriteRuleTokenStream stream_CHOICE=new RewriteRuleTokenStream(adaptor,"token CHOICE");
		RewriteRuleTokenStream stream_WORD=new RewriteRuleTokenStream(adaptor,"token WORD");
		RewriteRuleTokenStream stream_NEWLINE=new RewriteRuleTokenStream(adaptor,"token NEWLINE");
		RewriteRuleTokenStream stream_ENDCHOICE=new RewriteRuleTokenStream(adaptor,"token ENDCHOICE");
		RewriteRuleSubtreeStream stream_option_stmt=new RewriteRuleSubtreeStream(adaptor,"rule option_stmt");
		RewriteRuleSubtreeStream stream_common_stmt=new RewriteRuleSubtreeStream(adaptor,"rule common_stmt");

		try {
			// de/kit/kastel/travart/kconfig/parser/LKC.g:135:5: ( CHOICE ( WORD )? NEWLINE ( option_stmt )+ ( common_stmt )* ENDCHOICE -> ^( CHOICE ( WORD )? ( option_stmt )+ ( common_stmt )* ) )
			// de/kit/kastel/travart/kconfig/parser/LKC.g:135:7: CHOICE ( WORD )? NEWLINE ( option_stmt )+ ( common_stmt )* ENDCHOICE
			{
			CHOICE24=(Token)match(input,CHOICE,FOLLOW_CHOICE_in_choice_stmt342);  
			stream_CHOICE.add(CHOICE24);

			// de/kit/kastel/travart/kconfig/parser/LKC.g:135:14: ( WORD )?
			int alt7=2;
			int LA7_0 = input.LA(1);
			if ( (LA7_0==WORD) ) {
				alt7=1;
			}
			switch (alt7) {
				case 1 :
					// de/kit/kastel/travart/kconfig/parser/LKC.g:135:14: WORD
					{
					WORD25=(Token)match(input,WORD,FOLLOW_WORD_in_choice_stmt344);  
					stream_WORD.add(WORD25);

					}
					break;

			}

			NEWLINE26=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_choice_stmt347);  
			stream_NEWLINE.add(NEWLINE26);

			// de/kit/kastel/travart/kconfig/parser/LKC.g:135:28: ( option_stmt )+
			int cnt8=0;
			loop8:
			while (true) {
				int alt8=2;
				int LA8_0 = input.LA(1);
				if ( (LA8_0==INDENT) ) {
					int LA8_1 = input.LA(2);
					if ( (LA8_1==DEFAULT||LA8_1==DEPENDS||LA8_1==HEX||(LA8_1 >= OPTION && LA8_1 <= SELECT)||(LA8_1 >= 50 && LA8_1 <= 54)) ) {
						alt8=1;
					}

				}
				else if ( (LA8_0==HELP_TEXT) ) {
					alt8=1;
				}

				switch (alt8) {
				case 1 :
					// de/kit/kastel/travart/kconfig/parser/LKC.g:135:28: option_stmt
					{
					pushFollow(FOLLOW_option_stmt_in_choice_stmt349);
					option_stmt27=option_stmt();
					state._fsp--;

					stream_option_stmt.add(option_stmt27.getTree());
					}
					break;

				default :
					if ( cnt8 >= 1 ) break loop8;
					EarlyExitException eee = new EarlyExitException(8, input);
					throw eee;
				}
				cnt8++;
			}

			// de/kit/kastel/travart/kconfig/parser/LKC.g:135:41: ( common_stmt )*
			loop9:
			while (true) {
				int alt9=2;
				int LA9_0 = input.LA(1);
				if ( ((LA9_0 >= COMMENT && LA9_0 <= CONFIG)||(LA9_0 >= IF && LA9_0 <= INDENT)||(LA9_0 >= MENUCONFIG && LA9_0 <= NEWLINE)||LA9_0==SOURCE) ) {
					alt9=1;
				}

				switch (alt9) {
				case 1 :
					// de/kit/kastel/travart/kconfig/parser/LKC.g:135:41: common_stmt
					{
					pushFollow(FOLLOW_common_stmt_in_choice_stmt352);
					common_stmt28=common_stmt();
					state._fsp--;

					stream_common_stmt.add(common_stmt28.getTree());
					}
					break;

				default :
					break loop9;
				}
			}

			ENDCHOICE29=(Token)match(input,ENDCHOICE,FOLLOW_ENDCHOICE_in_choice_stmt355);  
			stream_ENDCHOICE.add(ENDCHOICE29);


			// AST REWRITE
			// elements: CHOICE, WORD, common_stmt, option_stmt
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 136:5: -> ^( CHOICE ( WORD )? ( option_stmt )+ ( common_stmt )* )
			{
				// de/kit/kastel/travart/kconfig/parser/LKC.g:136:8: ^( CHOICE ( WORD )? ( option_stmt )+ ( common_stmt )* )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot(stream_CHOICE.nextNode(), root_1);
				// de/kit/kastel/travart/kconfig/parser/LKC.g:136:17: ( WORD )?
				if ( stream_WORD.hasNext() ) {
					adaptor.addChild(root_1, stream_WORD.nextNode());
				}
				stream_WORD.reset();

				if ( !(stream_option_stmt.hasNext()) ) {
					throw new RewriteEarlyExitException();
				}
				while ( stream_option_stmt.hasNext() ) {
					adaptor.addChild(root_1, stream_option_stmt.nextTree());
				}
				stream_option_stmt.reset();

				// de/kit/kastel/travart/kconfig/parser/LKC.g:136:36: ( common_stmt )*
				while ( stream_common_stmt.hasNext() ) {
					adaptor.addChild(root_1, stream_common_stmt.nextTree());
				}
				stream_common_stmt.reset();

				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "choice_stmt"


	public static class depends_stmt_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "depends_stmt"
	// de/kit/kastel/travart/kconfig/parser/LKC.g:139:1: depends_stmt : ( INDENT !)? DEPENDS ^ ON ! expr NEWLINE !;
	public final LKCParser.depends_stmt_return depends_stmt() throws RecognitionException {
		LKCParser.depends_stmt_return retval = new LKCParser.depends_stmt_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token INDENT30=null;
		Token DEPENDS31=null;
		Token ON32=null;
		Token NEWLINE34=null;
		ParserRuleReturnScope expr33 =null;

		CommonTree INDENT30_tree=null;
		CommonTree DEPENDS31_tree=null;
		CommonTree ON32_tree=null;
		CommonTree NEWLINE34_tree=null;

		try {
			// de/kit/kastel/travart/kconfig/parser/LKC.g:140:5: ( ( INDENT !)? DEPENDS ^ ON ! expr NEWLINE !)
			// de/kit/kastel/travart/kconfig/parser/LKC.g:140:7: ( INDENT !)? DEPENDS ^ ON ! expr NEWLINE !
			{
			root_0 = (CommonTree)adaptor.nil();


			// de/kit/kastel/travart/kconfig/parser/LKC.g:140:13: ( INDENT !)?
			int alt10=2;
			int LA10_0 = input.LA(1);
			if ( (LA10_0==INDENT) ) {
				alt10=1;
			}
			switch (alt10) {
				case 1 :
					// de/kit/kastel/travart/kconfig/parser/LKC.g:140:13: INDENT !
					{
					INDENT30=(Token)match(input,INDENT,FOLLOW_INDENT_in_depends_stmt391); 
					}
					break;

			}

			DEPENDS31=(Token)match(input,DEPENDS,FOLLOW_DEPENDS_in_depends_stmt395); 
			DEPENDS31_tree = (CommonTree)adaptor.create(DEPENDS31);
			root_0 = (CommonTree)adaptor.becomeRoot(DEPENDS31_tree, root_0);

			ON32=(Token)match(input,ON,FOLLOW_ON_in_depends_stmt398); 
			pushFollow(FOLLOW_expr_in_depends_stmt401);
			expr33=expr();
			state._fsp--;

			adaptor.addChild(root_0, expr33.getTree());

			NEWLINE34=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_depends_stmt403); 
			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "depends_stmt"


	public static class comment_stmt_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "comment_stmt"
	// de/kit/kastel/travart/kconfig/parser/LKC.g:143:1: comment_stmt : COMMENT ^ prompt NEWLINE ! ( depends_stmt )* ;
	public final LKCParser.comment_stmt_return comment_stmt() throws RecognitionException {
		LKCParser.comment_stmt_return retval = new LKCParser.comment_stmt_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token COMMENT35=null;
		Token NEWLINE37=null;
		ParserRuleReturnScope prompt36 =null;
		ParserRuleReturnScope depends_stmt38 =null;

		CommonTree COMMENT35_tree=null;
		CommonTree NEWLINE37_tree=null;

		try {
			// de/kit/kastel/travart/kconfig/parser/LKC.g:144:5: ( COMMENT ^ prompt NEWLINE ! ( depends_stmt )* )
			// de/kit/kastel/travart/kconfig/parser/LKC.g:144:7: COMMENT ^ prompt NEWLINE ! ( depends_stmt )*
			{
			root_0 = (CommonTree)adaptor.nil();


			COMMENT35=(Token)match(input,COMMENT,FOLLOW_COMMENT_in_comment_stmt421); 
			COMMENT35_tree = (CommonTree)adaptor.create(COMMENT35);
			root_0 = (CommonTree)adaptor.becomeRoot(COMMENT35_tree, root_0);

			pushFollow(FOLLOW_prompt_in_comment_stmt424);
			prompt36=prompt();
			state._fsp--;

			adaptor.addChild(root_0, prompt36.getTree());

			NEWLINE37=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_comment_stmt426); 
			// de/kit/kastel/travart/kconfig/parser/LKC.g:144:32: ( depends_stmt )*
			loop11:
			while (true) {
				int alt11=2;
				int LA11_0 = input.LA(1);
				if ( (LA11_0==INDENT) ) {
					int LA11_2 = input.LA(2);
					if ( (LA11_2==DEPENDS) ) {
						alt11=1;
					}

				}
				else if ( (LA11_0==DEPENDS) ) {
					alt11=1;
				}

				switch (alt11) {
				case 1 :
					// de/kit/kastel/travart/kconfig/parser/LKC.g:144:32: depends_stmt
					{
					pushFollow(FOLLOW_depends_stmt_in_comment_stmt429);
					depends_stmt38=depends_stmt();
					state._fsp--;

					adaptor.addChild(root_0, depends_stmt38.getTree());

					}
					break;

				default :
					break loop11;
				}
			}

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "comment_stmt"


	public static class source_stmt_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "source_stmt"
	// de/kit/kastel/travart/kconfig/parser/LKC.g:147:1: source_stmt : ( INDENT )? 'source' include_filename= prompt NEWLINE -> ^( 'source' prompt ) ;
	public final LKCParser.source_stmt_return source_stmt() throws RecognitionException {
		LKCParser.source_stmt_return retval = new LKCParser.source_stmt_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token INDENT39=null;
		Token string_literal40=null;
		Token NEWLINE41=null;
		ParserRuleReturnScope include_filename =null;

		CommonTree INDENT39_tree=null;
		CommonTree string_literal40_tree=null;
		CommonTree NEWLINE41_tree=null;
		RewriteRuleTokenStream stream_INDENT=new RewriteRuleTokenStream(adaptor,"token INDENT");
		RewriteRuleTokenStream stream_NEWLINE=new RewriteRuleTokenStream(adaptor,"token NEWLINE");
		RewriteRuleTokenStream stream_SOURCE=new RewriteRuleTokenStream(adaptor,"token SOURCE");
		RewriteRuleSubtreeStream stream_prompt=new RewriteRuleSubtreeStream(adaptor,"rule prompt");

		 CommonTree includetree = null; 
		try {
			// de/kit/kastel/travart/kconfig/parser/LKC.g:149:2: ( ( INDENT )? 'source' include_filename= prompt NEWLINE -> ^( 'source' prompt ) )
			// de/kit/kastel/travart/kconfig/parser/LKC.g:150:3: ( INDENT )? 'source' include_filename= prompt NEWLINE
			{
			// de/kit/kastel/travart/kconfig/parser/LKC.g:150:3: ( INDENT )?
			int alt12=2;
			int LA12_0 = input.LA(1);
			if ( (LA12_0==INDENT) ) {
				alt12=1;
			}
			switch (alt12) {
				case 1 :
					// de/kit/kastel/travart/kconfig/parser/LKC.g:150:3: INDENT
					{
					INDENT39=(Token)match(input,INDENT,FOLLOW_INDENT_in_source_stmt451);  
					stream_INDENT.add(INDENT39);

					}
					break;

			}

			string_literal40=(Token)match(input,SOURCE,FOLLOW_SOURCE_in_source_stmt454);  
			stream_SOURCE.add(string_literal40);

			pushFollow(FOLLOW_prompt_in_source_stmt458);
			include_filename=prompt();
			state._fsp--;

			stream_prompt.add(include_filename.getTree());
			NEWLINE41=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_source_stmt460);  
			stream_NEWLINE.add(NEWLINE41);


			//    System.out.println((include_filename!=null?input.toString(include_filename.start,include_filename.stop):null));
			    try {
			      CharStream inputstream = null;
			      inputstream = new ANTLRFileStream(baseDir + "/" + (include_filename!=null?input.toString(include_filename.start,include_filename.stop):null));
			      LKCLexer innerlexer = new LKCLexer(inputstream);
			      LKCParser innerparser = new LKCParser(new CommonTokenStream(innerlexer));
			      innerparser.baseDir = baseDir;
			      includetree = (CommonTree)(innerparser.input().getTree());
			    } catch (IOException fnf) {
			      fnf.printStackTrace();
			      throw new RuntimeException(fnf);
			    }
			  

			// AST REWRITE
			// elements: prompt, SOURCE
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 164:3: -> ^( 'source' prompt )
			{
				// de/kit/kastel/travart/kconfig/parser/LKC.g:164:6: ^( 'source' prompt )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot(stream_SOURCE.nextNode(), root_1);
				adaptor.addChild(root_1, stream_prompt.nextTree());
				adaptor.addChild(root_1, includetree);
				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "source_stmt"


	public static class if_stmt_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "if_stmt"
	// de/kit/kastel/travart/kconfig/parser/LKC.g:168:1: if_stmt : if_expr ^ NEWLINE ! block ENDIF ;
	public final LKCParser.if_stmt_return if_stmt() throws RecognitionException {
		LKCParser.if_stmt_return retval = new LKCParser.if_stmt_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token NEWLINE43=null;
		Token ENDIF45=null;
		ParserRuleReturnScope if_expr42 =null;
		ParserRuleReturnScope block44 =null;

		CommonTree NEWLINE43_tree=null;
		CommonTree ENDIF45_tree=null;

		try {
			// de/kit/kastel/travart/kconfig/parser/LKC.g:169:5: ( if_expr ^ NEWLINE ! block ENDIF )
			// de/kit/kastel/travart/kconfig/parser/LKC.g:169:7: if_expr ^ NEWLINE ! block ENDIF
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_if_expr_in_if_stmt488);
			if_expr42=if_expr();
			state._fsp--;

			root_0 = (CommonTree)adaptor.becomeRoot(if_expr42.getTree(), root_0);
			NEWLINE43=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_if_stmt491); 
			pushFollow(FOLLOW_block_in_if_stmt494);
			block44=block();
			state._fsp--;

			adaptor.addChild(root_0, block44.getTree());

			ENDIF45=(Token)match(input,ENDIF,FOLLOW_ENDIF_in_if_stmt496); 
			ENDIF45_tree = (CommonTree)adaptor.create(ENDIF45);
			adaptor.addChild(root_0, ENDIF45_tree);

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "if_stmt"


	public static class config_stmt_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "config_stmt"
	// de/kit/kastel/travart/kconfig/parser/LKC.g:172:1: config_stmt : ( INDENT !)? ( CONFIG | MENUCONFIG ) ^ WORD NEWLINE ! ( option_stmt )+ ;
	public final LKCParser.config_stmt_return config_stmt() throws RecognitionException {
		LKCParser.config_stmt_return retval = new LKCParser.config_stmt_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token INDENT46=null;
		Token set47=null;
		Token WORD48=null;
		Token NEWLINE49=null;
		ParserRuleReturnScope option_stmt50 =null;

		CommonTree INDENT46_tree=null;
		CommonTree set47_tree=null;
		CommonTree WORD48_tree=null;
		CommonTree NEWLINE49_tree=null;

		try {
			// de/kit/kastel/travart/kconfig/parser/LKC.g:173:5: ( ( INDENT !)? ( CONFIG | MENUCONFIG ) ^ WORD NEWLINE ! ( option_stmt )+ )
			// de/kit/kastel/travart/kconfig/parser/LKC.g:173:7: ( INDENT !)? ( CONFIG | MENUCONFIG ) ^ WORD NEWLINE ! ( option_stmt )+
			{
			root_0 = (CommonTree)adaptor.nil();


			// de/kit/kastel/travart/kconfig/parser/LKC.g:173:13: ( INDENT !)?
			int alt13=2;
			int LA13_0 = input.LA(1);
			if ( (LA13_0==INDENT) ) {
				alt13=1;
			}
			switch (alt13) {
				case 1 :
					// de/kit/kastel/travart/kconfig/parser/LKC.g:173:13: INDENT !
					{
					INDENT46=(Token)match(input,INDENT,FOLLOW_INDENT_in_config_stmt513); 
					}
					break;

			}

			set47=input.LT(1);
			set47=input.LT(1);
			if ( input.LA(1)==CONFIG||input.LA(1)==MENUCONFIG ) {
				input.consume();
				root_0 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(set47), root_0);
				state.errorRecovery=false;
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			WORD48=(Token)match(input,WORD,FOLLOW_WORD_in_config_stmt524); 
			WORD48_tree = (CommonTree)adaptor.create(WORD48);
			adaptor.addChild(root_0, WORD48_tree);

			NEWLINE49=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_config_stmt526); 
			// de/kit/kastel/travart/kconfig/parser/LKC.g:173:51: ( option_stmt )+
			int cnt14=0;
			loop14:
			while (true) {
				int alt14=2;
				int LA14_0 = input.LA(1);
				if ( (LA14_0==INDENT) ) {
					int LA14_2 = input.LA(2);
					if ( (LA14_2==DEFAULT||LA14_2==DEPENDS||LA14_2==HEX||(LA14_2 >= OPTION && LA14_2 <= SELECT)||(LA14_2 >= 50 && LA14_2 <= 54)) ) {
						alt14=1;
					}

				}
				else if ( (LA14_0==HELP_TEXT) ) {
					alt14=1;
				}

				switch (alt14) {
				case 1 :
					// de/kit/kastel/travart/kconfig/parser/LKC.g:173:51: option_stmt
					{
					pushFollow(FOLLOW_option_stmt_in_config_stmt529);
					option_stmt50=option_stmt();
					state._fsp--;

					adaptor.addChild(root_0, option_stmt50.getTree());

					}
					break;

				default :
					if ( cnt14 >= 1 ) break loop14;
					EarlyExitException eee = new EarlyExitException(14, input);
					throw eee;
				}
				cnt14++;
			}

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "config_stmt"


	public static class option_stmt_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "option_stmt"
	// de/kit/kastel/travart/kconfig/parser/LKC.g:176:1: option_stmt : ( INDENT ! config_option ^ ( if_expr )? NEWLINE !| HELP_TEXT );
	public final LKCParser.option_stmt_return option_stmt() throws RecognitionException {
		LKCParser.option_stmt_return retval = new LKCParser.option_stmt_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token INDENT51=null;
		Token NEWLINE54=null;
		Token HELP_TEXT55=null;
		ParserRuleReturnScope config_option52 =null;
		ParserRuleReturnScope if_expr53 =null;

		CommonTree INDENT51_tree=null;
		CommonTree NEWLINE54_tree=null;
		CommonTree HELP_TEXT55_tree=null;

		try {
			// de/kit/kastel/travart/kconfig/parser/LKC.g:177:5: ( INDENT ! config_option ^ ( if_expr )? NEWLINE !| HELP_TEXT )
			int alt16=2;
			int LA16_0 = input.LA(1);
			if ( (LA16_0==INDENT) ) {
				alt16=1;
			}
			else if ( (LA16_0==HELP_TEXT) ) {
				alt16=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 16, 0, input);
				throw nvae;
			}

			switch (alt16) {
				case 1 :
					// de/kit/kastel/travart/kconfig/parser/LKC.g:177:7: INDENT ! config_option ^ ( if_expr )? NEWLINE !
					{
					root_0 = (CommonTree)adaptor.nil();


					INDENT51=(Token)match(input,INDENT,FOLLOW_INDENT_in_option_stmt547); 
					pushFollow(FOLLOW_config_option_in_option_stmt550);
					config_option52=config_option();
					state._fsp--;

					root_0 = (CommonTree)adaptor.becomeRoot(config_option52.getTree(), root_0);
					// de/kit/kastel/travart/kconfig/parser/LKC.g:177:30: ( if_expr )?
					int alt15=2;
					int LA15_0 = input.LA(1);
					if ( (LA15_0==IF) ) {
						alt15=1;
					}
					switch (alt15) {
						case 1 :
							// de/kit/kastel/travart/kconfig/parser/LKC.g:177:30: if_expr
							{
							pushFollow(FOLLOW_if_expr_in_option_stmt553);
							if_expr53=if_expr();
							state._fsp--;

							adaptor.addChild(root_0, if_expr53.getTree());

							}
							break;

					}

					NEWLINE54=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_option_stmt556); 
					}
					break;
				case 2 :
					// de/kit/kastel/travart/kconfig/parser/LKC.g:178:7: HELP_TEXT
					{
					root_0 = (CommonTree)adaptor.nil();


					HELP_TEXT55=(Token)match(input,HELP_TEXT,FOLLOW_HELP_TEXT_in_option_stmt565); 
					HELP_TEXT55_tree = (CommonTree)adaptor.create(HELP_TEXT55);
					adaptor.addChild(root_0, HELP_TEXT55_tree);

					}
					break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "option_stmt"


	public static class config_option_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "config_option"
	// de/kit/kastel/travart/kconfig/parser/LKC.g:181:1: config_option : ( type ^ ( WORD | WORD_QUOTE )? ( ';' !)? | DEPENDS ^ ON ! expr | PROMPT ^ ( WORD | WORD_QUOTE ) | SELECT ^ WORD | DEFAULT ^ expr | RANGE ^ WORD WORD | OPTION ^ misc_option | OPTIONAL );
	public final LKCParser.config_option_return config_option() throws RecognitionException {
		LKCParser.config_option_return retval = new LKCParser.config_option_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token set57=null;
		Token char_literal58=null;
		Token DEPENDS59=null;
		Token ON60=null;
		Token PROMPT62=null;
		Token set63=null;
		Token SELECT64=null;
		Token WORD65=null;
		Token DEFAULT66=null;
		Token RANGE68=null;
		Token WORD69=null;
		Token WORD70=null;
		Token OPTION71=null;
		Token OPTIONAL73=null;
		ParserRuleReturnScope type56 =null;
		ParserRuleReturnScope expr61 =null;
		ParserRuleReturnScope expr67 =null;
		ParserRuleReturnScope misc_option72 =null;

		CommonTree set57_tree=null;
		CommonTree char_literal58_tree=null;
		CommonTree DEPENDS59_tree=null;
		CommonTree ON60_tree=null;
		CommonTree PROMPT62_tree=null;
		CommonTree set63_tree=null;
		CommonTree SELECT64_tree=null;
		CommonTree WORD65_tree=null;
		CommonTree DEFAULT66_tree=null;
		CommonTree RANGE68_tree=null;
		CommonTree WORD69_tree=null;
		CommonTree WORD70_tree=null;
		CommonTree OPTION71_tree=null;
		CommonTree OPTIONAL73_tree=null;

		try {
			// de/kit/kastel/travart/kconfig/parser/LKC.g:182:5: ( type ^ ( WORD | WORD_QUOTE )? ( ';' !)? | DEPENDS ^ ON ! expr | PROMPT ^ ( WORD | WORD_QUOTE ) | SELECT ^ WORD | DEFAULT ^ expr | RANGE ^ WORD WORD | OPTION ^ misc_option | OPTIONAL )
			int alt19=8;
			switch ( input.LA(1) ) {
			case HEX:
			case 50:
			case 51:
			case 52:
			case 53:
			case 54:
				{
				alt19=1;
				}
				break;
			case DEPENDS:
				{
				alt19=2;
				}
				break;
			case PROMPT:
				{
				alt19=3;
				}
				break;
			case SELECT:
				{
				alt19=4;
				}
				break;
			case DEFAULT:
				{
				alt19=5;
				}
				break;
			case RANGE:
				{
				alt19=6;
				}
				break;
			case OPTION:
				{
				alt19=7;
				}
				break;
			case OPTIONAL:
				{
				alt19=8;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 19, 0, input);
				throw nvae;
			}
			switch (alt19) {
				case 1 :
					// de/kit/kastel/travart/kconfig/parser/LKC.g:182:7: type ^ ( WORD | WORD_QUOTE )? ( ';' !)?
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_type_in_config_option582);
					type56=type();
					state._fsp--;

					root_0 = (CommonTree)adaptor.becomeRoot(type56.getTree(), root_0);
					// de/kit/kastel/travart/kconfig/parser/LKC.g:182:18: ( WORD | WORD_QUOTE )?
					int alt17=2;
					int LA17_0 = input.LA(1);
					if ( ((LA17_0 >= WORD && LA17_0 <= WORD_QUOTE)) ) {
						alt17=1;
					}
					switch (alt17) {
						case 1 :
							// de/kit/kastel/travart/kconfig/parser/LKC.g:
							{
							set57=input.LT(1);
							if ( (input.LA(1) >= WORD && input.LA(1) <= WORD_QUOTE) ) {
								input.consume();
								adaptor.addChild(root_0, (CommonTree)adaptor.create(set57));
								state.errorRecovery=false;
							}
							else {
								MismatchedSetException mse = new MismatchedSetException(null,input);
								throw mse;
							}
							}
							break;

					}

					// de/kit/kastel/travart/kconfig/parser/LKC.g:182:42: ( ';' !)?
					int alt18=2;
					int LA18_0 = input.LA(1);
					if ( (LA18_0==48) ) {
						alt18=1;
					}
					switch (alt18) {
						case 1 :
							// de/kit/kastel/travart/kconfig/parser/LKC.g:182:42: ';' !
							{
							char_literal58=(Token)match(input,48,FOLLOW_48_in_config_option599); 
							}
							break;

					}

					}
					break;
				case 2 :
					// de/kit/kastel/travart/kconfig/parser/LKC.g:183:7: DEPENDS ^ ON ! expr
					{
					root_0 = (CommonTree)adaptor.nil();


					DEPENDS59=(Token)match(input,DEPENDS,FOLLOW_DEPENDS_in_config_option609); 
					DEPENDS59_tree = (CommonTree)adaptor.create(DEPENDS59);
					root_0 = (CommonTree)adaptor.becomeRoot(DEPENDS59_tree, root_0);

					ON60=(Token)match(input,ON,FOLLOW_ON_in_config_option613); 
					pushFollow(FOLLOW_expr_in_config_option616);
					expr61=expr();
					state._fsp--;

					adaptor.addChild(root_0, expr61.getTree());

					}
					break;
				case 3 :
					// de/kit/kastel/travart/kconfig/parser/LKC.g:184:7: PROMPT ^ ( WORD | WORD_QUOTE )
					{
					root_0 = (CommonTree)adaptor.nil();


					PROMPT62=(Token)match(input,PROMPT,FOLLOW_PROMPT_in_config_option624); 
					PROMPT62_tree = (CommonTree)adaptor.create(PROMPT62);
					root_0 = (CommonTree)adaptor.becomeRoot(PROMPT62_tree, root_0);

					set63=input.LT(1);
					if ( (input.LA(1) >= WORD && input.LA(1) <= WORD_QUOTE) ) {
						input.consume();
						adaptor.addChild(root_0, (CommonTree)adaptor.create(set63));
						state.errorRecovery=false;
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					}
					break;
				case 4 :
					// de/kit/kastel/travart/kconfig/parser/LKC.g:185:7: SELECT ^ WORD
					{
					root_0 = (CommonTree)adaptor.nil();


					SELECT64=(Token)match(input,SELECT,FOLLOW_SELECT_in_config_option643); 
					SELECT64_tree = (CommonTree)adaptor.create(SELECT64);
					root_0 = (CommonTree)adaptor.becomeRoot(SELECT64_tree, root_0);

					WORD65=(Token)match(input,WORD,FOLLOW_WORD_in_config_option648); 
					WORD65_tree = (CommonTree)adaptor.create(WORD65);
					adaptor.addChild(root_0, WORD65_tree);

					}
					break;
				case 5 :
					// de/kit/kastel/travart/kconfig/parser/LKC.g:186:7: DEFAULT ^ expr
					{
					root_0 = (CommonTree)adaptor.nil();


					DEFAULT66=(Token)match(input,DEFAULT,FOLLOW_DEFAULT_in_config_option656); 
					DEFAULT66_tree = (CommonTree)adaptor.create(DEFAULT66);
					root_0 = (CommonTree)adaptor.becomeRoot(DEFAULT66_tree, root_0);

					pushFollow(FOLLOW_expr_in_config_option660);
					expr67=expr();
					state._fsp--;

					adaptor.addChild(root_0, expr67.getTree());

					}
					break;
				case 6 :
					// de/kit/kastel/travart/kconfig/parser/LKC.g:187:7: RANGE ^ WORD WORD
					{
					root_0 = (CommonTree)adaptor.nil();


					RANGE68=(Token)match(input,RANGE,FOLLOW_RANGE_in_config_option668); 
					RANGE68_tree = (CommonTree)adaptor.create(RANGE68);
					root_0 = (CommonTree)adaptor.becomeRoot(RANGE68_tree, root_0);

					WORD69=(Token)match(input,WORD,FOLLOW_WORD_in_config_option674); 
					WORD69_tree = (CommonTree)adaptor.create(WORD69);
					adaptor.addChild(root_0, WORD69_tree);

					WORD70=(Token)match(input,WORD,FOLLOW_WORD_in_config_option676); 
					WORD70_tree = (CommonTree)adaptor.create(WORD70);
					adaptor.addChild(root_0, WORD70_tree);

					}
					break;
				case 7 :
					// de/kit/kastel/travart/kconfig/parser/LKC.g:188:7: OPTION ^ misc_option
					{
					root_0 = (CommonTree)adaptor.nil();


					OPTION71=(Token)match(input,OPTION,FOLLOW_OPTION_in_config_option684); 
					OPTION71_tree = (CommonTree)adaptor.create(OPTION71);
					root_0 = (CommonTree)adaptor.becomeRoot(OPTION71_tree, root_0);

					pushFollow(FOLLOW_misc_option_in_config_option689);
					misc_option72=misc_option();
					state._fsp--;

					adaptor.addChild(root_0, misc_option72.getTree());

					}
					break;
				case 8 :
					// de/kit/kastel/travart/kconfig/parser/LKC.g:189:7: OPTIONAL
					{
					root_0 = (CommonTree)adaptor.nil();


					OPTIONAL73=(Token)match(input,OPTIONAL,FOLLOW_OPTIONAL_in_config_option697); 
					OPTIONAL73_tree = (CommonTree)adaptor.create(OPTIONAL73);
					adaptor.addChild(root_0, OPTIONAL73_tree);

					}
					break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "config_option"


	public static class type_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "type"
	// de/kit/kastel/travart/kconfig/parser/LKC.g:193:1: fragment type : ( 'tristate' | 'bool' | 'boolean' | 'int' | 'string' | HEX );
	public final LKCParser.type_return type() throws RecognitionException {
		LKCParser.type_return retval = new LKCParser.type_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token set74=null;

		CommonTree set74_tree=null;

		try {
			// de/kit/kastel/travart/kconfig/parser/LKC.g:193:13: ( 'tristate' | 'bool' | 'boolean' | 'int' | 'string' | HEX )
			// de/kit/kastel/travart/kconfig/parser/LKC.g:
			{
			root_0 = (CommonTree)adaptor.nil();


			set74=input.LT(1);
			if ( input.LA(1)==HEX||(input.LA(1) >= 50 && input.LA(1) <= 54) ) {
				input.consume();
				adaptor.addChild(root_0, (CommonTree)adaptor.create(set74));
				state.errorRecovery=false;
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "type"


	public static class prompt_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "prompt"
	// de/kit/kastel/travart/kconfig/parser/LKC.g:196:1: fragment prompt : ( WORD | WORD_QUOTE );
	public final LKCParser.prompt_return prompt() throws RecognitionException {
		LKCParser.prompt_return retval = new LKCParser.prompt_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token set75=null;

		CommonTree set75_tree=null;

		try {
			// de/kit/kastel/travart/kconfig/parser/LKC.g:197:5: ( WORD | WORD_QUOTE )
			// de/kit/kastel/travart/kconfig/parser/LKC.g:
			{
			root_0 = (CommonTree)adaptor.nil();


			set75=input.LT(1);
			if ( (input.LA(1) >= WORD && input.LA(1) <= WORD_QUOTE) ) {
				input.consume();
				adaptor.addChild(root_0, (CommonTree)adaptor.create(set75));
				state.errorRecovery=false;
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "prompt"


	public static class misc_option_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "misc_option"
	// de/kit/kastel/travart/kconfig/parser/LKC.g:199:1: misc_option : ( ENV ^ '=' ! WORD_QUOTE | DEFCONFIG_LIST );
	public final LKCParser.misc_option_return misc_option() throws RecognitionException {
		LKCParser.misc_option_return retval = new LKCParser.misc_option_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token ENV76=null;
		Token char_literal77=null;
		Token WORD_QUOTE78=null;
		Token DEFCONFIG_LIST79=null;

		CommonTree ENV76_tree=null;
		CommonTree char_literal77_tree=null;
		CommonTree WORD_QUOTE78_tree=null;
		CommonTree DEFCONFIG_LIST79_tree=null;

		try {
			// de/kit/kastel/travart/kconfig/parser/LKC.g:200:5: ( ENV ^ '=' ! WORD_QUOTE | DEFCONFIG_LIST )
			int alt20=2;
			int LA20_0 = input.LA(1);
			if ( (LA20_0==ENV) ) {
				alt20=1;
			}
			else if ( (LA20_0==DEFCONFIG_LIST) ) {
				alt20=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 20, 0, input);
				throw nvae;
			}

			switch (alt20) {
				case 1 :
					// de/kit/kastel/travart/kconfig/parser/LKC.g:200:7: ENV ^ '=' ! WORD_QUOTE
					{
					root_0 = (CommonTree)adaptor.nil();


					ENV76=(Token)match(input,ENV,FOLLOW_ENV_in_misc_option770); 
					ENV76_tree = (CommonTree)adaptor.create(ENV76);
					root_0 = (CommonTree)adaptor.becomeRoot(ENV76_tree, root_0);

					char_literal77=(Token)match(input,49,FOLLOW_49_in_misc_option773); 
					WORD_QUOTE78=(Token)match(input,WORD_QUOTE,FOLLOW_WORD_QUOTE_in_misc_option776); 
					WORD_QUOTE78_tree = (CommonTree)adaptor.create(WORD_QUOTE78);
					adaptor.addChild(root_0, WORD_QUOTE78_tree);

					}
					break;
				case 2 :
					// de/kit/kastel/travart/kconfig/parser/LKC.g:201:7: DEFCONFIG_LIST
					{
					root_0 = (CommonTree)adaptor.nil();


					DEFCONFIG_LIST79=(Token)match(input,DEFCONFIG_LIST,FOLLOW_DEFCONFIG_LIST_in_misc_option784); 
					DEFCONFIG_LIST79_tree = (CommonTree)adaptor.create(DEFCONFIG_LIST79);
					adaptor.addChild(root_0, DEFCONFIG_LIST79_tree);

					}
					break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "misc_option"


	public static class if_expr_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "if_expr"
	// de/kit/kastel/travart/kconfig/parser/LKC.g:208:1: if_expr : IF ^ expr ;
	public final LKCParser.if_expr_return if_expr() throws RecognitionException {
		LKCParser.if_expr_return retval = new LKCParser.if_expr_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token IF80=null;
		ParserRuleReturnScope expr81 =null;

		CommonTree IF80_tree=null;

		try {
			// de/kit/kastel/travart/kconfig/parser/LKC.g:209:5: ( IF ^ expr )
			// de/kit/kastel/travart/kconfig/parser/LKC.g:209:7: IF ^ expr
			{
			root_0 = (CommonTree)adaptor.nil();


			IF80=(Token)match(input,IF,FOLLOW_IF_in_if_expr804); 
			IF80_tree = (CommonTree)adaptor.create(IF80);
			root_0 = (CommonTree)adaptor.becomeRoot(IF80_tree, root_0);

			pushFollow(FOLLOW_expr_in_if_expr807);
			expr81=expr();
			state._fsp--;

			adaptor.addChild(root_0, expr81.getTree());

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "if_expr"


	public static class expr_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "expr"
	// de/kit/kastel/travart/kconfig/parser/LKC.g:212:1: expr : or_expr ( expr )? ;
	public final LKCParser.expr_return expr() throws RecognitionException {
		LKCParser.expr_return retval = new LKCParser.expr_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope or_expr82 =null;
		ParserRuleReturnScope expr83 =null;


		try {
			// de/kit/kastel/travart/kconfig/parser/LKC.g:213:5: ( or_expr ( expr )? )
			// de/kit/kastel/travart/kconfig/parser/LKC.g:213:7: or_expr ( expr )?
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_or_expr_in_expr824);
			or_expr82=or_expr();
			state._fsp--;

			adaptor.addChild(root_0, or_expr82.getTree());

			// de/kit/kastel/travart/kconfig/parser/LKC.g:213:15: ( expr )?
			int alt21=2;
			int LA21_0 = input.LA(1);
			if ( (LA21_0==FALSE||(LA21_0 >= TRUE && LA21_0 <= WORD_QUOTE)||LA21_0==46||LA21_0==56) ) {
				alt21=1;
			}
			switch (alt21) {
				case 1 :
					// de/kit/kastel/travart/kconfig/parser/LKC.g:213:15: expr
					{
					pushFollow(FOLLOW_expr_in_expr826);
					expr83=expr();
					state._fsp--;

					adaptor.addChild(root_0, expr83.getTree());

					}
					break;

			}

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "expr"


	public static class or_expr_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "or_expr"
	// de/kit/kastel/travart/kconfig/parser/LKC.g:216:1: or_expr : and_expr ( '|' ^ and_expr )* ;
	public final LKCParser.or_expr_return or_expr() throws RecognitionException {
		LKCParser.or_expr_return retval = new LKCParser.or_expr_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token char_literal85=null;
		ParserRuleReturnScope and_expr84 =null;
		ParserRuleReturnScope and_expr86 =null;

		CommonTree char_literal85_tree=null;

		try {
			// de/kit/kastel/travart/kconfig/parser/LKC.g:217:5: ( and_expr ( '|' ^ and_expr )* )
			// de/kit/kastel/travart/kconfig/parser/LKC.g:217:7: and_expr ( '|' ^ and_expr )*
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_and_expr_in_or_expr844);
			and_expr84=and_expr();
			state._fsp--;

			adaptor.addChild(root_0, and_expr84.getTree());

			// de/kit/kastel/travart/kconfig/parser/LKC.g:217:16: ( '|' ^ and_expr )*
			loop22:
			while (true) {
				int alt22=2;
				int LA22_0 = input.LA(1);
				if ( (LA22_0==55) ) {
					alt22=1;
				}

				switch (alt22) {
				case 1 :
					// de/kit/kastel/travart/kconfig/parser/LKC.g:217:17: '|' ^ and_expr
					{
					char_literal85=(Token)match(input,55,FOLLOW_55_in_or_expr847); 
					char_literal85_tree = (CommonTree)adaptor.create(char_literal85);
					root_0 = (CommonTree)adaptor.becomeRoot(char_literal85_tree, root_0);

					pushFollow(FOLLOW_and_expr_in_or_expr850);
					and_expr86=and_expr();
					state._fsp--;

					adaptor.addChild(root_0, and_expr86.getTree());

					}
					break;

				default :
					break loop22;
				}
			}

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "or_expr"


	public static class and_expr_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "and_expr"
	// de/kit/kastel/travart/kconfig/parser/LKC.g:220:1: and_expr : unary_expr ( '&' ^ unary_expr )* ;
	public final LKCParser.and_expr_return and_expr() throws RecognitionException {
		LKCParser.and_expr_return retval = new LKCParser.and_expr_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token char_literal88=null;
		ParserRuleReturnScope unary_expr87 =null;
		ParserRuleReturnScope unary_expr89 =null;

		CommonTree char_literal88_tree=null;

		try {
			// de/kit/kastel/travart/kconfig/parser/LKC.g:221:5: ( unary_expr ( '&' ^ unary_expr )* )
			// de/kit/kastel/travart/kconfig/parser/LKC.g:221:7: unary_expr ( '&' ^ unary_expr )*
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_unary_expr_in_and_expr869);
			unary_expr87=unary_expr();
			state._fsp--;

			adaptor.addChild(root_0, unary_expr87.getTree());

			// de/kit/kastel/travart/kconfig/parser/LKC.g:221:18: ( '&' ^ unary_expr )*
			loop23:
			while (true) {
				int alt23=2;
				int LA23_0 = input.LA(1);
				if ( (LA23_0==45) ) {
					alt23=1;
				}

				switch (alt23) {
				case 1 :
					// de/kit/kastel/travart/kconfig/parser/LKC.g:221:19: '&' ^ unary_expr
					{
					char_literal88=(Token)match(input,45,FOLLOW_45_in_and_expr872); 
					char_literal88_tree = (CommonTree)adaptor.create(char_literal88);
					root_0 = (CommonTree)adaptor.becomeRoot(char_literal88_tree, root_0);

					pushFollow(FOLLOW_unary_expr_in_and_expr875);
					unary_expr89=unary_expr();
					state._fsp--;

					adaptor.addChild(root_0, unary_expr89.getTree());

					}
					break;

				default :
					break loop23;
				}
			}

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "and_expr"


	public static class unary_expr_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "unary_expr"
	// de/kit/kastel/travart/kconfig/parser/LKC.g:224:1: unary_expr : ( '~' ^ unary_expr | equals_expr );
	public final LKCParser.unary_expr_return unary_expr() throws RecognitionException {
		LKCParser.unary_expr_return retval = new LKCParser.unary_expr_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token char_literal90=null;
		ParserRuleReturnScope unary_expr91 =null;
		ParserRuleReturnScope equals_expr92 =null;

		CommonTree char_literal90_tree=null;

		try {
			// de/kit/kastel/travart/kconfig/parser/LKC.g:225:5: ( '~' ^ unary_expr | equals_expr )
			int alt24=2;
			int LA24_0 = input.LA(1);
			if ( (LA24_0==56) ) {
				alt24=1;
			}
			else if ( (LA24_0==FALSE||(LA24_0 >= TRUE && LA24_0 <= WORD_QUOTE)||LA24_0==46) ) {
				alt24=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 24, 0, input);
				throw nvae;
			}

			switch (alt24) {
				case 1 :
					// de/kit/kastel/travart/kconfig/parser/LKC.g:225:7: '~' ^ unary_expr
					{
					root_0 = (CommonTree)adaptor.nil();


					char_literal90=(Token)match(input,56,FOLLOW_56_in_unary_expr894); 
					char_literal90_tree = (CommonTree)adaptor.create(char_literal90);
					root_0 = (CommonTree)adaptor.becomeRoot(char_literal90_tree, root_0);

					pushFollow(FOLLOW_unary_expr_in_unary_expr897);
					unary_expr91=unary_expr();
					state._fsp--;

					adaptor.addChild(root_0, unary_expr91.getTree());

					}
					break;
				case 2 :
					// de/kit/kastel/travart/kconfig/parser/LKC.g:226:7: equals_expr
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_equals_expr_in_unary_expr905);
					equals_expr92=equals_expr();
					state._fsp--;

					adaptor.addChild(root_0, equals_expr92.getTree());

					}
					break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "unary_expr"


	public static class equals_expr_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "equals_expr"
	// de/kit/kastel/travart/kconfig/parser/LKC.g:229:1: equals_expr : primary ( ( '=' | '!=' ) ^ primary )? ;
	public final LKCParser.equals_expr_return equals_expr() throws RecognitionException {
		LKCParser.equals_expr_return retval = new LKCParser.equals_expr_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token set94=null;
		ParserRuleReturnScope primary93 =null;
		ParserRuleReturnScope primary95 =null;

		CommonTree set94_tree=null;

		try {
			// de/kit/kastel/travart/kconfig/parser/LKC.g:230:5: ( primary ( ( '=' | '!=' ) ^ primary )? )
			// de/kit/kastel/travart/kconfig/parser/LKC.g:230:7: primary ( ( '=' | '!=' ) ^ primary )?
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_primary_in_equals_expr922);
			primary93=primary();
			state._fsp--;

			adaptor.addChild(root_0, primary93.getTree());

			// de/kit/kastel/travart/kconfig/parser/LKC.g:230:15: ( ( '=' | '!=' ) ^ primary )?
			int alt25=2;
			int LA25_0 = input.LA(1);
			if ( (LA25_0==44||LA25_0==49) ) {
				alt25=1;
			}
			switch (alt25) {
				case 1 :
					// de/kit/kastel/travart/kconfig/parser/LKC.g:230:16: ( '=' | '!=' ) ^ primary
					{
					set94=input.LT(1);
					set94=input.LT(1);
					if ( input.LA(1)==44||input.LA(1)==49 ) {
						input.consume();
						root_0 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(set94), root_0);
						state.errorRecovery=false;
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_primary_in_equals_expr932);
					primary95=primary();
					state._fsp--;

					adaptor.addChild(root_0, primary95.getTree());

					}
					break;

			}

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "equals_expr"


	public static class primary_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "primary"
	// de/kit/kastel/travart/kconfig/parser/LKC.g:236:1: primary : ( atom | '(' ! expr ')' !);
	public final LKCParser.primary_return primary() throws RecognitionException {
		LKCParser.primary_return retval = new LKCParser.primary_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token char_literal97=null;
		Token char_literal99=null;
		ParserRuleReturnScope atom96 =null;
		ParserRuleReturnScope expr98 =null;

		CommonTree char_literal97_tree=null;
		CommonTree char_literal99_tree=null;

		try {
			// de/kit/kastel/travart/kconfig/parser/LKC.g:237:5: ( atom | '(' ! expr ')' !)
			int alt26=2;
			int LA26_0 = input.LA(1);
			if ( (LA26_0==FALSE||(LA26_0 >= TRUE && LA26_0 <= WORD_QUOTE)) ) {
				alt26=1;
			}
			else if ( (LA26_0==46) ) {
				alt26=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 26, 0, input);
				throw nvae;
			}

			switch (alt26) {
				case 1 :
					// de/kit/kastel/travart/kconfig/parser/LKC.g:237:7: atom
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_atom_in_primary953);
					atom96=atom();
					state._fsp--;

					adaptor.addChild(root_0, atom96.getTree());

					}
					break;
				case 2 :
					// de/kit/kastel/travart/kconfig/parser/LKC.g:238:7: '(' ! expr ')' !
					{
					root_0 = (CommonTree)adaptor.nil();


					char_literal97=(Token)match(input,46,FOLLOW_46_in_primary961); 
					pushFollow(FOLLOW_expr_in_primary964);
					expr98=expr();
					state._fsp--;

					adaptor.addChild(root_0, expr98.getTree());

					char_literal99=(Token)match(input,47,FOLLOW_47_in_primary966); 
					}
					break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "primary"


	public static class atom_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "atom"
	// de/kit/kastel/travart/kconfig/parser/LKC.g:241:1: atom : ( WORD | WORD_QUOTE | FALSE | TRUE );
	public final LKCParser.atom_return atom() throws RecognitionException {
		LKCParser.atom_return retval = new LKCParser.atom_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token set100=null;

		CommonTree set100_tree=null;

		try {
			// de/kit/kastel/travart/kconfig/parser/LKC.g:241:5: ( WORD | WORD_QUOTE | FALSE | TRUE )
			// de/kit/kastel/travart/kconfig/parser/LKC.g:
			{
			root_0 = (CommonTree)adaptor.nil();


			set100=input.LT(1);
			if ( input.LA(1)==FALSE||(input.LA(1) >= TRUE && input.LA(1) <= WORD_QUOTE) ) {
				input.consume();
				adaptor.addChild(root_0, (CommonTree)adaptor.create(set100));
				state.errorRecovery=false;
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "atom"

	// Delegated rules



	public static final BitSet FOLLOW_stmts_in_input103 = new BitSet(new long[]{0x00000080F60000E2L});
	public static final BitSet FOLLOW_common_stmt_in_stmts116 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_menu_stmt_in_stmts125 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_choice_stmt_in_stmts134 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_mainmenu_stmt_in_stmts143 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_block_stmts_in_block161 = new BitSet(new long[]{0x00000080E60000E2L});
	public static final BitSet FOLLOW_common_stmt_in_block_stmts188 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_menu_stmt_in_block_stmts196 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_choice_stmt_in_block_stmts204 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_config_stmt_in_common_stmt221 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_source_stmt_in_common_stmt229 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_comment_stmt_in_common_stmt237 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_if_stmt_in_common_stmt245 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NEWLINE_in_common_stmt253 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MAINMENU_in_mainmenu_stmt272 = new BitSet(new long[]{0x0000060000000000L});
	public static final BitSet FOLLOW_prompt_in_mainmenu_stmt275 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_NEWLINE_in_mainmenu_stmt277 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MENU_in_menu_stmt297 = new BitSet(new long[]{0x0000060000000000L});
	public static final BitSet FOLLOW_prompt_in_menu_stmt299 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_NEWLINE_in_menu_stmt301 = new BitSet(new long[]{0x00000080E60120E0L});
	public static final BitSet FOLLOW_depends_stmt_in_menu_stmt303 = new BitSet(new long[]{0x00000080E60120E0L});
	public static final BitSet FOLLOW_block_in_menu_stmt306 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_ENDMENU_in_menu_stmt308 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CHOICE_in_choice_stmt342 = new BitSet(new long[]{0x0000020080000000L});
	public static final BitSet FOLLOW_WORD_in_choice_stmt344 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_NEWLINE_in_choice_stmt347 = new BitSet(new long[]{0x0000000004200000L});
	public static final BitSet FOLLOW_option_stmt_in_choice_stmt349 = new BitSet(new long[]{0x00000080C62040C0L});
	public static final BitSet FOLLOW_common_stmt_in_choice_stmt352 = new BitSet(new long[]{0x00000080C60040C0L});
	public static final BitSet FOLLOW_ENDCHOICE_in_choice_stmt355 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INDENT_in_depends_stmt391 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_DEPENDS_in_depends_stmt395 = new BitSet(new long[]{0x0000000100000000L});
	public static final BitSet FOLLOW_ON_in_depends_stmt398 = new BitSet(new long[]{0x0100470000080000L});
	public static final BitSet FOLLOW_expr_in_depends_stmt401 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_NEWLINE_in_depends_stmt403 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_COMMENT_in_comment_stmt421 = new BitSet(new long[]{0x0000060000000000L});
	public static final BitSet FOLLOW_prompt_in_comment_stmt424 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_NEWLINE_in_comment_stmt426 = new BitSet(new long[]{0x0000000004002002L});
	public static final BitSet FOLLOW_depends_stmt_in_comment_stmt429 = new BitSet(new long[]{0x0000000004002002L});
	public static final BitSet FOLLOW_INDENT_in_source_stmt451 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_SOURCE_in_source_stmt454 = new BitSet(new long[]{0x0000060000000000L});
	public static final BitSet FOLLOW_prompt_in_source_stmt458 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_NEWLINE_in_source_stmt460 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_if_expr_in_if_stmt488 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_NEWLINE_in_if_stmt491 = new BitSet(new long[]{0x00000080E60080E0L});
	public static final BitSet FOLLOW_block_in_if_stmt494 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_ENDIF_in_if_stmt496 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INDENT_in_config_stmt513 = new BitSet(new long[]{0x0000000040000080L});
	public static final BitSet FOLLOW_set_in_config_stmt517 = new BitSet(new long[]{0x0000020000000000L});
	public static final BitSet FOLLOW_WORD_in_config_stmt524 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_NEWLINE_in_config_stmt526 = new BitSet(new long[]{0x0000000004200000L});
	public static final BitSet FOLLOW_option_stmt_in_config_stmt529 = new BitSet(new long[]{0x0000000004200002L});
	public static final BitSet FOLLOW_INDENT_in_option_stmt547 = new BitSet(new long[]{0x007C003E00802800L});
	public static final BitSet FOLLOW_config_option_in_option_stmt550 = new BitSet(new long[]{0x0000000082000000L});
	public static final BitSet FOLLOW_if_expr_in_option_stmt553 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_NEWLINE_in_option_stmt556 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_HELP_TEXT_in_option_stmt565 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_type_in_config_option582 = new BitSet(new long[]{0x0001060000000002L});
	public static final BitSet FOLLOW_48_in_config_option599 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DEPENDS_in_config_option609 = new BitSet(new long[]{0x0000000100000000L});
	public static final BitSet FOLLOW_ON_in_config_option613 = new BitSet(new long[]{0x0100470000080000L});
	public static final BitSet FOLLOW_expr_in_config_option616 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PROMPT_in_config_option624 = new BitSet(new long[]{0x0000060000000000L});
	public static final BitSet FOLLOW_set_in_config_option629 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SELECT_in_config_option643 = new BitSet(new long[]{0x0000020000000000L});
	public static final BitSet FOLLOW_WORD_in_config_option648 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DEFAULT_in_config_option656 = new BitSet(new long[]{0x0100470000080000L});
	public static final BitSet FOLLOW_expr_in_config_option660 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_RANGE_in_config_option668 = new BitSet(new long[]{0x0000020000000000L});
	public static final BitSet FOLLOW_WORD_in_config_option674 = new BitSet(new long[]{0x0000020000000000L});
	public static final BitSet FOLLOW_WORD_in_config_option676 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OPTION_in_config_option684 = new BitSet(new long[]{0x0000000000021000L});
	public static final BitSet FOLLOW_misc_option_in_config_option689 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OPTIONAL_in_config_option697 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ENV_in_misc_option770 = new BitSet(new long[]{0x0002000000000000L});
	public static final BitSet FOLLOW_49_in_misc_option773 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_WORD_QUOTE_in_misc_option776 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DEFCONFIG_LIST_in_misc_option784 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IF_in_if_expr804 = new BitSet(new long[]{0x0100470000080000L});
	public static final BitSet FOLLOW_expr_in_if_expr807 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_or_expr_in_expr824 = new BitSet(new long[]{0x0100470000080002L});
	public static final BitSet FOLLOW_expr_in_expr826 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_and_expr_in_or_expr844 = new BitSet(new long[]{0x0080000000000002L});
	public static final BitSet FOLLOW_55_in_or_expr847 = new BitSet(new long[]{0x0100470000080000L});
	public static final BitSet FOLLOW_and_expr_in_or_expr850 = new BitSet(new long[]{0x0080000000000002L});
	public static final BitSet FOLLOW_unary_expr_in_and_expr869 = new BitSet(new long[]{0x0000200000000002L});
	public static final BitSet FOLLOW_45_in_and_expr872 = new BitSet(new long[]{0x0100470000080000L});
	public static final BitSet FOLLOW_unary_expr_in_and_expr875 = new BitSet(new long[]{0x0000200000000002L});
	public static final BitSet FOLLOW_56_in_unary_expr894 = new BitSet(new long[]{0x0100470000080000L});
	public static final BitSet FOLLOW_unary_expr_in_unary_expr897 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_equals_expr_in_unary_expr905 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_primary_in_equals_expr922 = new BitSet(new long[]{0x0002100000000002L});
	public static final BitSet FOLLOW_set_in_equals_expr925 = new BitSet(new long[]{0x0000470000080000L});
	public static final BitSet FOLLOW_primary_in_equals_expr932 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_atom_in_primary953 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_46_in_primary961 = new BitSet(new long[]{0x0100470000080000L});
	public static final BitSet FOLLOW_expr_in_primary964 = new BitSet(new long[]{0x0000800000000000L});
	public static final BitSet FOLLOW_47_in_primary966 = new BitSet(new long[]{0x0000000000000002L});
}
