// $ANTLR 3.5.3 de/kit/kastel/travart/kconfig/parser/LKC.g 2024-09-10 12:06:39

package de.kit.kastel.travart.kconfig.parser;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

@SuppressWarnings("all")
public class LKCLexer extends Lexer {
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



	// delegates
	// delegators
	public Lexer[] getDelegates() {
		return new Lexer[] {};
	}

	public LKCLexer() {} 
	public LKCLexer(CharStream input) {
		this(input, new RecognizerSharedState());
	}
	public LKCLexer(CharStream input, RecognizerSharedState state) {
		super(input,state);
	}
	@Override public String getGrammarFileName() { return "de/kit/kastel/travart/kconfig/parser/LKC.g"; }

	// $ANTLR start "DASH"
	public final void mDASH() throws RecognitionException {
		try {
			int _type = DASH;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// de/kit/kastel/travart/kconfig/parser/LKC.g:52:6: ( '-' )
			// de/kit/kastel/travart/kconfig/parser/LKC.g:52:8: '-'
			{
			match('-'); if (state.failed) return;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DASH"

	// $ANTLR start "HEX"
	public final void mHEX() throws RecognitionException {
		try {
			int _type = HEX;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// de/kit/kastel/travart/kconfig/parser/LKC.g:53:5: ( 'hex' )
			// de/kit/kastel/travart/kconfig/parser/LKC.g:53:7: 'hex'
			{
			match("hex"); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "HEX"

	// $ANTLR start "T__44"
	public final void mT__44() throws RecognitionException {
		try {
			int _type = T__44;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// de/kit/kastel/travart/kconfig/parser/LKC.g:54:7: ( '!=' )
			// de/kit/kastel/travart/kconfig/parser/LKC.g:54:9: '!='
			{
			match("!="); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__44"

	// $ANTLR start "T__45"
	public final void mT__45() throws RecognitionException {
		try {
			int _type = T__45;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// de/kit/kastel/travart/kconfig/parser/LKC.g:55:7: ( '&' )
			// de/kit/kastel/travart/kconfig/parser/LKC.g:55:9: '&'
			{
			match('&'); if (state.failed) return;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__45"

	// $ANTLR start "T__46"
	public final void mT__46() throws RecognitionException {
		try {
			int _type = T__46;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// de/kit/kastel/travart/kconfig/parser/LKC.g:56:7: ( '(' )
			// de/kit/kastel/travart/kconfig/parser/LKC.g:56:9: '('
			{
			match('('); if (state.failed) return;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__46"

	// $ANTLR start "T__47"
	public final void mT__47() throws RecognitionException {
		try {
			int _type = T__47;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// de/kit/kastel/travart/kconfig/parser/LKC.g:57:7: ( ')' )
			// de/kit/kastel/travart/kconfig/parser/LKC.g:57:9: ')'
			{
			match(')'); if (state.failed) return;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__47"

	// $ANTLR start "T__48"
	public final void mT__48() throws RecognitionException {
		try {
			int _type = T__48;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// de/kit/kastel/travart/kconfig/parser/LKC.g:58:7: ( ';' )
			// de/kit/kastel/travart/kconfig/parser/LKC.g:58:9: ';'
			{
			match(';'); if (state.failed) return;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__48"

	// $ANTLR start "T__49"
	public final void mT__49() throws RecognitionException {
		try {
			int _type = T__49;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// de/kit/kastel/travart/kconfig/parser/LKC.g:59:7: ( '=' )
			// de/kit/kastel/travart/kconfig/parser/LKC.g:59:9: '='
			{
			match('='); if (state.failed) return;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__49"

	// $ANTLR start "T__50"
	public final void mT__50() throws RecognitionException {
		try {
			int _type = T__50;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// de/kit/kastel/travart/kconfig/parser/LKC.g:60:7: ( 'bool' )
			// de/kit/kastel/travart/kconfig/parser/LKC.g:60:9: 'bool'
			{
			match("bool"); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__50"

	// $ANTLR start "T__51"
	public final void mT__51() throws RecognitionException {
		try {
			int _type = T__51;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// de/kit/kastel/travart/kconfig/parser/LKC.g:61:7: ( 'boolean' )
			// de/kit/kastel/travart/kconfig/parser/LKC.g:61:9: 'boolean'
			{
			match("boolean"); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__51"

	// $ANTLR start "T__52"
	public final void mT__52() throws RecognitionException {
		try {
			int _type = T__52;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// de/kit/kastel/travart/kconfig/parser/LKC.g:62:7: ( 'int' )
			// de/kit/kastel/travart/kconfig/parser/LKC.g:62:9: 'int'
			{
			match("int"); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__52"

	// $ANTLR start "T__53"
	public final void mT__53() throws RecognitionException {
		try {
			int _type = T__53;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// de/kit/kastel/travart/kconfig/parser/LKC.g:63:7: ( 'string' )
			// de/kit/kastel/travart/kconfig/parser/LKC.g:63:9: 'string'
			{
			match("string"); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__53"

	// $ANTLR start "T__54"
	public final void mT__54() throws RecognitionException {
		try {
			int _type = T__54;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// de/kit/kastel/travart/kconfig/parser/LKC.g:64:7: ( 'tristate' )
			// de/kit/kastel/travart/kconfig/parser/LKC.g:64:9: 'tristate'
			{
			match("tristate"); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__54"

	// $ANTLR start "T__55"
	public final void mT__55() throws RecognitionException {
		try {
			int _type = T__55;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// de/kit/kastel/travart/kconfig/parser/LKC.g:65:7: ( '|' )
			// de/kit/kastel/travart/kconfig/parser/LKC.g:65:9: '|'
			{
			match('|'); if (state.failed) return;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__55"

	// $ANTLR start "T__56"
	public final void mT__56() throws RecognitionException {
		try {
			int _type = T__56;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// de/kit/kastel/travart/kconfig/parser/LKC.g:66:7: ( '~' )
			// de/kit/kastel/travart/kconfig/parser/LKC.g:66:9: '~'
			{
			match('~'); if (state.failed) return;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__56"

	// $ANTLR start "MAINMENU"
	public final void mMAINMENU() throws RecognitionException {
		try {
			int _type = MAINMENU;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// de/kit/kastel/travart/kconfig/parser/LKC.g:243:13: ( 'mainmenu' )
			// de/kit/kastel/travart/kconfig/parser/LKC.g:243:15: 'mainmenu'
			{
			match("mainmenu"); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "MAINMENU"

	// $ANTLR start "CHOICE"
	public final void mCHOICE() throws RecognitionException {
		try {
			int _type = CHOICE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// de/kit/kastel/travart/kconfig/parser/LKC.g:244:13: ( 'choice' )
			// de/kit/kastel/travart/kconfig/parser/LKC.g:244:15: 'choice'
			{
			match("choice"); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "CHOICE"

	// $ANTLR start "ENDCHOICE"
	public final void mENDCHOICE() throws RecognitionException {
		try {
			int _type = ENDCHOICE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// de/kit/kastel/travart/kconfig/parser/LKC.g:245:13: ( 'endchoice' )
			// de/kit/kastel/travart/kconfig/parser/LKC.g:245:15: 'endchoice'
			{
			match("endchoice"); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ENDCHOICE"

	// $ANTLR start "MENU"
	public final void mMENU() throws RecognitionException {
		try {
			int _type = MENU;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// de/kit/kastel/travart/kconfig/parser/LKC.g:246:13: ( 'menu' )
			// de/kit/kastel/travart/kconfig/parser/LKC.g:246:15: 'menu'
			{
			match("menu"); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "MENU"

	// $ANTLR start "ENDMENU"
	public final void mENDMENU() throws RecognitionException {
		try {
			int _type = ENDMENU;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// de/kit/kastel/travart/kconfig/parser/LKC.g:247:13: ( 'endmenu' )
			// de/kit/kastel/travart/kconfig/parser/LKC.g:247:15: 'endmenu'
			{
			match("endmenu"); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ENDMENU"

	// $ANTLR start "IF"
	public final void mIF() throws RecognitionException {
		try {
			int _type = IF;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// de/kit/kastel/travart/kconfig/parser/LKC.g:248:13: ( 'if' )
			// de/kit/kastel/travart/kconfig/parser/LKC.g:248:15: 'if'
			{
			match("if"); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "IF"

	// $ANTLR start "ENDIF"
	public final void mENDIF() throws RecognitionException {
		try {
			int _type = ENDIF;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// de/kit/kastel/travart/kconfig/parser/LKC.g:249:13: ( 'endif' )
			// de/kit/kastel/travart/kconfig/parser/LKC.g:249:15: 'endif'
			{
			match("endif"); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ENDIF"

	// $ANTLR start "SOURCE"
	public final void mSOURCE() throws RecognitionException {
		try {
			int _type = SOURCE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// de/kit/kastel/travart/kconfig/parser/LKC.g:250:13: ( 'source' )
			// de/kit/kastel/travart/kconfig/parser/LKC.g:250:15: 'source'
			{
			match("source"); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "SOURCE"

	// $ANTLR start "COMMENT"
	public final void mCOMMENT() throws RecognitionException {
		try {
			int _type = COMMENT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// de/kit/kastel/travart/kconfig/parser/LKC.g:251:13: ( 'comment' )
			// de/kit/kastel/travart/kconfig/parser/LKC.g:251:15: 'comment'
			{
			match("comment"); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "COMMENT"

	// $ANTLR start "CONFIG"
	public final void mCONFIG() throws RecognitionException {
		try {
			int _type = CONFIG;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// de/kit/kastel/travart/kconfig/parser/LKC.g:252:13: ( 'config' )
			// de/kit/kastel/travart/kconfig/parser/LKC.g:252:15: 'config'
			{
			match("config"); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "CONFIG"

	// $ANTLR start "MENUCONFIG"
	public final void mMENUCONFIG() throws RecognitionException {
		try {
			int _type = MENUCONFIG;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// de/kit/kastel/travart/kconfig/parser/LKC.g:253:13: ( 'menuconfig' )
			// de/kit/kastel/travart/kconfig/parser/LKC.g:253:15: 'menuconfig'
			{
			match("menuconfig"); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "MENUCONFIG"

	// $ANTLR start "DEPENDS"
	public final void mDEPENDS() throws RecognitionException {
		try {
			int _type = DEPENDS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// de/kit/kastel/travart/kconfig/parser/LKC.g:254:13: ( 'depends' )
			// de/kit/kastel/travart/kconfig/parser/LKC.g:254:15: 'depends'
			{
			match("depends"); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DEPENDS"

	// $ANTLR start "ON"
	public final void mON() throws RecognitionException {
		try {
			int _type = ON;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// de/kit/kastel/travart/kconfig/parser/LKC.g:255:13: ( 'on' )
			// de/kit/kastel/travart/kconfig/parser/LKC.g:255:15: 'on'
			{
			match("on"); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ON"

	// $ANTLR start "SELECT"
	public final void mSELECT() throws RecognitionException {
		try {
			int _type = SELECT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// de/kit/kastel/travart/kconfig/parser/LKC.g:256:13: ( 'select' )
			// de/kit/kastel/travart/kconfig/parser/LKC.g:256:15: 'select'
			{
			match("select"); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "SELECT"

	// $ANTLR start "DEFAULT"
	public final void mDEFAULT() throws RecognitionException {
		try {
			int _type = DEFAULT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// de/kit/kastel/travart/kconfig/parser/LKC.g:257:13: ( 'default' | 'def_bool' | 'def_tristate' )
			int alt1=3;
			int LA1_0 = input.LA(1);
			if ( (LA1_0=='d') ) {
				int LA1_1 = input.LA(2);
				if ( (LA1_1=='e') ) {
					int LA1_2 = input.LA(3);
					if ( (LA1_2=='f') ) {
						int LA1_3 = input.LA(4);
						if ( (LA1_3=='a') ) {
							alt1=1;
						}
						else if ( (LA1_3=='_') ) {
							int LA1_5 = input.LA(5);
							if ( (LA1_5=='b') ) {
								alt1=2;
							}
							else if ( (LA1_5=='t') ) {
								alt1=3;
							}

							else {
								if (state.backtracking>0) {state.failed=true; return;}
								int nvaeMark = input.mark();
								try {
									for (int nvaeConsume = 0; nvaeConsume < 5 - 1; nvaeConsume++) {
										input.consume();
									}
									NoViableAltException nvae =
										new NoViableAltException("", 1, 5, input);
									throw nvae;
								} finally {
									input.rewind(nvaeMark);
								}
							}

						}

						else {
							if (state.backtracking>0) {state.failed=true; return;}
							int nvaeMark = input.mark();
							try {
								for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
									input.consume();
								}
								NoViableAltException nvae =
									new NoViableAltException("", 1, 3, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

					}

					else {
						if (state.backtracking>0) {state.failed=true; return;}
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 1, 2, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

				}

				else {
					if (state.backtracking>0) {state.failed=true; return;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 1, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				if (state.backtracking>0) {state.failed=true; return;}
				NoViableAltException nvae =
					new NoViableAltException("", 1, 0, input);
				throw nvae;
			}

			switch (alt1) {
				case 1 :
					// de/kit/kastel/travart/kconfig/parser/LKC.g:257:15: 'default'
					{
					match("default"); if (state.failed) return;

					}
					break;
				case 2 :
					// de/kit/kastel/travart/kconfig/parser/LKC.g:257:27: 'def_bool'
					{
					match("def_bool"); if (state.failed) return;

					}
					break;
				case 3 :
					// de/kit/kastel/travart/kconfig/parser/LKC.g:257:40: 'def_tristate'
					{
					match("def_tristate"); if (state.failed) return;

					}
					break;

			}
			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DEFAULT"

	// $ANTLR start "RANGE"
	public final void mRANGE() throws RecognitionException {
		try {
			int _type = RANGE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// de/kit/kastel/travart/kconfig/parser/LKC.g:258:13: ( 'range' )
			// de/kit/kastel/travart/kconfig/parser/LKC.g:258:15: 'range'
			{
			match("range"); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RANGE"

	// $ANTLR start "HELP"
	public final void mHELP() throws RecognitionException {
		try {
			int _type = HELP;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// de/kit/kastel/travart/kconfig/parser/LKC.g:259:13: ( 'help' )
			// de/kit/kastel/travart/kconfig/parser/LKC.g:259:15: 'help'
			{
			match("help"); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "HELP"

	// $ANTLR start "PROMPT"
	public final void mPROMPT() throws RecognitionException {
		try {
			int _type = PROMPT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// de/kit/kastel/travart/kconfig/parser/LKC.g:260:13: ( 'prompt' )
			// de/kit/kastel/travart/kconfig/parser/LKC.g:260:15: 'prompt'
			{
			match("prompt"); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "PROMPT"

	// $ANTLR start "OPTION"
	public final void mOPTION() throws RecognitionException {
		try {
			int _type = OPTION;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// de/kit/kastel/travart/kconfig/parser/LKC.g:261:13: ( 'option' )
			// de/kit/kastel/travart/kconfig/parser/LKC.g:261:15: 'option'
			{
			match("option"); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "OPTION"

	// $ANTLR start "ENV"
	public final void mENV() throws RecognitionException {
		try {
			int _type = ENV;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// de/kit/kastel/travart/kconfig/parser/LKC.g:262:13: ( 'env' )
			// de/kit/kastel/travart/kconfig/parser/LKC.g:262:15: 'env'
			{
			match("env"); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ENV"

	// $ANTLR start "DEFCONFIG_LIST"
	public final void mDEFCONFIG_LIST() throws RecognitionException {
		try {
			int _type = DEFCONFIG_LIST;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// de/kit/kastel/travart/kconfig/parser/LKC.g:263:15: ( 'defconfig_list' )
			// de/kit/kastel/travart/kconfig/parser/LKC.g:263:17: 'defconfig_list'
			{
			match("defconfig_list"); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DEFCONFIG_LIST"

	// $ANTLR start "OPTIONAL"
	public final void mOPTIONAL() throws RecognitionException {
		try {
			int _type = OPTIONAL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// de/kit/kastel/travart/kconfig/parser/LKC.g:264:13: ( 'optional' )
			// de/kit/kastel/travart/kconfig/parser/LKC.g:264:15: 'optional'
			{
			match("optional"); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "OPTIONAL"

	// $ANTLR start "FALSE"
	public final void mFALSE() throws RecognitionException {
		try {
			int _type = FALSE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// de/kit/kastel/travart/kconfig/parser/LKC.g:265:7: ( '$false' )
			// de/kit/kastel/travart/kconfig/parser/LKC.g:265:9: '$false'
			{
			match("$false"); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "FALSE"

	// $ANTLR start "TRUE"
	public final void mTRUE() throws RecognitionException {
		try {
			int _type = TRUE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// de/kit/kastel/travart/kconfig/parser/LKC.g:266:6: ( '$true' )
			// de/kit/kastel/travart/kconfig/parser/LKC.g:266:8: '$true'
			{
			match("$true"); if (state.failed) return;

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "TRUE"

	// $ANTLR start "NEWLINE"
	public final void mNEWLINE() throws RecognitionException {
		try {
			int _type = NEWLINE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// de/kit/kastel/travart/kconfig/parser/LKC.g:270:5: ( ( ( '\\r' )? '\\n' )+ )
			// de/kit/kastel/travart/kconfig/parser/LKC.g:270:7: ( ( '\\r' )? '\\n' )+
			{
			// de/kit/kastel/travart/kconfig/parser/LKC.g:270:7: ( ( '\\r' )? '\\n' )+
			int cnt3=0;
			loop3:
			while (true) {
				int alt3=2;
				int LA3_0 = input.LA(1);
				if ( (LA3_0=='\n'||LA3_0=='\r') ) {
					alt3=1;
				}

				switch (alt3) {
				case 1 :
					// de/kit/kastel/travart/kconfig/parser/LKC.g:270:8: ( '\\r' )? '\\n'
					{
					// de/kit/kastel/travart/kconfig/parser/LKC.g:270:8: ( '\\r' )?
					int alt2=2;
					int LA2_0 = input.LA(1);
					if ( (LA2_0=='\r') ) {
						alt2=1;
					}
					switch (alt2) {
						case 1 :
							// de/kit/kastel/travart/kconfig/parser/LKC.g:270:8: '\\r'
							{
							match('\r'); if (state.failed) return;
							}
							break;

					}

					match('\n'); if (state.failed) return;
					}
					break;

				default :
					if ( cnt3 >= 1 ) break loop3;
					if (state.backtracking>0) {state.failed=true; return;}
					EarlyExitException eee = new EarlyExitException(3, input);
					throw eee;
				}
				cnt3++;
			}

			if ( state.backtracking==0 ) {
			      if (startPos==0) {
			        _channel=HIDDEN;
			      }
			    }
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NEWLINE"

	// $ANTLR start "WS"
	public final void mWS() throws RecognitionException {
		try {
			int _type = WS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// de/kit/kastel/travart/kconfig/parser/LKC.g:279:5: ({...}? => ( ' ' | '\\t' )+ )
			// de/kit/kastel/travart/kconfig/parser/LKC.g:279:7: {...}? => ( ' ' | '\\t' )+
			{
			if ( !((startPos>0)) ) {
				if (state.backtracking>0) {state.failed=true; return;}
				throw new FailedPredicateException(input, "WS", "startPos>0");
			}
			// de/kit/kastel/travart/kconfig/parser/LKC.g:279:22: ( ' ' | '\\t' )+
			int cnt4=0;
			loop4:
			while (true) {
				int alt4=2;
				int LA4_0 = input.LA(1);
				if ( (LA4_0=='\t'||LA4_0==' ') ) {
					alt4=1;
				}

				switch (alt4) {
				case 1 :
					// de/kit/kastel/travart/kconfig/parser/LKC.g:
					{
					if ( input.LA(1)=='\t'||input.LA(1)==' ' ) {
						input.consume();
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt4 >= 1 ) break loop4;
					if (state.backtracking>0) {state.failed=true; return;}
					EarlyExitException eee = new EarlyExitException(4, input);
					throw eee;
				}
				cnt4++;
			}

			if ( state.backtracking==0 ) {
			      _channel=HIDDEN;
			    }
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "WS"

	// $ANTLR start "LEADING_WS"
	public final void mLEADING_WS() throws RecognitionException {
		try {
			int _type = LEADING_WS;
			int _channel = DEFAULT_TOKEN_CHANNEL;

			  int spaces = 0;
			  char[] indentation = null;

			// de/kit/kastel/travart/kconfig/parser/LKC.g:291:5: ({...}? => ( ' ' | '\\t' )+ ( ( ( '\\r' )? '\\n' | SL_COMMENT ) )* )
			// de/kit/kastel/travart/kconfig/parser/LKC.g:291:7: {...}? => ( ' ' | '\\t' )+ ( ( ( '\\r' )? '\\n' | SL_COMMENT ) )*
			{
			if ( !((startPos==0)) ) {
				if (state.backtracking>0) {state.failed=true; return;}
				throw new FailedPredicateException(input, "LEADING_WS", "startPos==0");
			}
			// de/kit/kastel/travart/kconfig/parser/LKC.g:292:7: ( ' ' | '\\t' )+
			int cnt5=0;
			loop5:
			while (true) {
				int alt5=3;
				int LA5_0 = input.LA(1);
				if ( (LA5_0==' ') ) {
					alt5=1;
				}
				else if ( (LA5_0=='\t') ) {
					alt5=2;
				}

				switch (alt5) {
				case 1 :
					// de/kit/kastel/travart/kconfig/parser/LKC.g:292:9: ' '
					{
					match(' '); if (state.failed) return;
					if ( state.backtracking==0 ) { spaces++; }
					}
					break;
				case 2 :
					// de/kit/kastel/travart/kconfig/parser/LKC.g:293:11: '\\t'
					{
					match('\t'); if (state.failed) return;
					if ( state.backtracking==0 ) {spaces += 8 - (spaces % 8); }
					}
					break;

				default :
					if ( cnt5 >= 1 ) break loop5;
					if (state.backtracking>0) {state.failed=true; return;}
					EarlyExitException eee = new EarlyExitException(5, input);
					throw eee;
				}
				cnt5++;
			}

			if ( state.backtracking==0 ) {
			        indentation = new char[spaces];
			        for (int i=0; i<spaces; i++) {
			            indentation[i] = ' ';
			        }
			      }
			// de/kit/kastel/travart/kconfig/parser/LKC.g:302:7: ( ( ( '\\r' )? '\\n' | SL_COMMENT ) )*
			loop8:
			while (true) {
				int alt8=2;
				int LA8_0 = input.LA(1);
				if ( (LA8_0=='\n'||LA8_0=='\r'||LA8_0=='#') ) {
					alt8=1;
				}

				switch (alt8) {
				case 1 :
					// de/kit/kastel/travart/kconfig/parser/LKC.g:302:9: ( ( '\\r' )? '\\n' | SL_COMMENT )
					{
					// de/kit/kastel/travart/kconfig/parser/LKC.g:302:9: ( ( '\\r' )? '\\n' | SL_COMMENT )
					int alt7=2;
					int LA7_0 = input.LA(1);
					if ( (LA7_0=='\n'||LA7_0=='\r') ) {
						alt7=1;
					}
					else if ( (LA7_0=='#') ) {
						alt7=2;
					}

					else {
						if (state.backtracking>0) {state.failed=true; return;}
						NoViableAltException nvae =
							new NoViableAltException("", 7, 0, input);
						throw nvae;
					}

					switch (alt7) {
						case 1 :
							// de/kit/kastel/travart/kconfig/parser/LKC.g:302:10: ( '\\r' )? '\\n'
							{
							// de/kit/kastel/travart/kconfig/parser/LKC.g:302:10: ( '\\r' )?
							int alt6=2;
							int LA6_0 = input.LA(1);
							if ( (LA6_0=='\r') ) {
								alt6=1;
							}
							switch (alt6) {
								case 1 :
									// de/kit/kastel/travart/kconfig/parser/LKC.g:302:11: '\\r'
									{
									match('\r'); if (state.failed) return;
									}
									break;

							}

							match('\n'); if (state.failed) return;
							}
							break;
						case 2 :
							// de/kit/kastel/travart/kconfig/parser/LKC.g:302:25: SL_COMMENT
							{
							mSL_COMMENT(); if (state.failed) return;

							}
							break;

					}

					if ( state.backtracking==0 ) {_channel=HIDDEN; }
					}
					break;

				default :
					break loop8;
				}
			}

			if ( state.backtracking==0 ) {
			        Token t = new ClassicToken(INDENT, new String(indentation));
			        t.setChannel(_channel);
			        emit(t);
			      }
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LEADING_WS"

	// $ANTLR start "INDENT"
	public final void mINDENT() throws RecognitionException {
		try {
			int _type = INDENT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// de/kit/kastel/travart/kconfig/parser/LKC.g:311:7: ( '\\t' )
			// de/kit/kastel/travart/kconfig/parser/LKC.g:311:9: '\\t'
			{
			match('\t'); if (state.failed) return;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "INDENT"

	// $ANTLR start "WORD"
	public final void mWORD() throws RecognitionException {
		try {
			int _type = WORD;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// de/kit/kastel/travart/kconfig/parser/LKC.g:314:5: ( '-' ( '0' .. '9' )+ | ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' | '/' | '.' )+ | ( '0' ( 'x' | 'X' ) )=> '0' ( 'x' | 'X' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )+ )
			int alt12=3;
			switch ( input.LA(1) ) {
			case '-':
				{
				alt12=1;
				}
				break;
			case '0':
				{
				int LA12_2 = input.LA(2);
				if ( (LA12_2=='X'||LA12_2=='x') ) {
					int LA12_4 = input.LA(3);
					if ( ((LA12_4 >= '0' && LA12_4 <= '9')||(LA12_4 >= 'A' && LA12_4 <= 'F')||(LA12_4 >= 'a' && LA12_4 <= 'f')) ) {
						int LA12_5 = input.LA(4);
						if ( (true) ) {
							alt12=2;
						}
						else if ( (synpred1_LKC()) ) {
							alt12=3;
						}

						else {
							if (state.backtracking>0) {state.failed=true; return;}
							int nvaeMark = input.mark();
							try {
								for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
									input.consume();
								}
								NoViableAltException nvae =
									new NoViableAltException("", 12, 5, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

					}

					else {
						alt12=2;
					}

				}

				else {
					alt12=2;
				}

				}
				break;
			case '.':
			case '/':
			case '1':
			case '2':
			case '3':
			case '4':
			case '5':
			case '6':
			case '7':
			case '8':
			case '9':
			case 'A':
			case 'B':
			case 'C':
			case 'D':
			case 'E':
			case 'F':
			case 'G':
			case 'H':
			case 'I':
			case 'J':
			case 'K':
			case 'L':
			case 'M':
			case 'N':
			case 'O':
			case 'P':
			case 'Q':
			case 'R':
			case 'S':
			case 'T':
			case 'U':
			case 'V':
			case 'W':
			case 'X':
			case 'Y':
			case 'Z':
			case '_':
			case 'a':
			case 'b':
			case 'c':
			case 'd':
			case 'e':
			case 'f':
			case 'g':
			case 'h':
			case 'i':
			case 'j':
			case 'k':
			case 'l':
			case 'm':
			case 'n':
			case 'o':
			case 'p':
			case 'q':
			case 'r':
			case 's':
			case 't':
			case 'u':
			case 'v':
			case 'w':
			case 'x':
			case 'y':
			case 'z':
				{
				alt12=2;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return;}
				NoViableAltException nvae =
					new NoViableAltException("", 12, 0, input);
				throw nvae;
			}
			switch (alt12) {
				case 1 :
					// de/kit/kastel/travart/kconfig/parser/LKC.g:315:7: '-' ( '0' .. '9' )+
					{
					match('-'); if (state.failed) return;
					// de/kit/kastel/travart/kconfig/parser/LKC.g:315:11: ( '0' .. '9' )+
					int cnt9=0;
					loop9:
					while (true) {
						int alt9=2;
						int LA9_0 = input.LA(1);
						if ( ((LA9_0 >= '0' && LA9_0 <= '9')) ) {
							alt9=1;
						}

						switch (alt9) {
						case 1 :
							// de/kit/kastel/travart/kconfig/parser/LKC.g:
							{
							if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
								input.consume();
								state.failed=false;
							}
							else {
								if (state.backtracking>0) {state.failed=true; return;}
								MismatchedSetException mse = new MismatchedSetException(null,input);
								recover(mse);
								throw mse;
							}
							}
							break;

						default :
							if ( cnt9 >= 1 ) break loop9;
							if (state.backtracking>0) {state.failed=true; return;}
							EarlyExitException eee = new EarlyExitException(9, input);
							throw eee;
						}
						cnt9++;
					}

					}
					break;
				case 2 :
					// de/kit/kastel/travart/kconfig/parser/LKC.g:316:7: ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' | '/' | '.' )+
					{
					// de/kit/kastel/travart/kconfig/parser/LKC.g:316:7: ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' | '/' | '.' )+
					int cnt10=0;
					loop10:
					while (true) {
						int alt10=2;
						int LA10_0 = input.LA(1);
						if ( ((LA10_0 >= '.' && LA10_0 <= '9')||(LA10_0 >= 'A' && LA10_0 <= 'Z')||LA10_0=='_'||(LA10_0 >= 'a' && LA10_0 <= 'z')) ) {
							alt10=1;
						}

						switch (alt10) {
						case 1 :
							// de/kit/kastel/travart/kconfig/parser/LKC.g:
							{
							if ( (input.LA(1) >= '.' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
								input.consume();
								state.failed=false;
							}
							else {
								if (state.backtracking>0) {state.failed=true; return;}
								MismatchedSetException mse = new MismatchedSetException(null,input);
								recover(mse);
								throw mse;
							}
							}
							break;

						default :
							if ( cnt10 >= 1 ) break loop10;
							if (state.backtracking>0) {state.failed=true; return;}
							EarlyExitException eee = new EarlyExitException(10, input);
							throw eee;
						}
						cnt10++;
					}

					}
					break;
				case 3 :
					// de/kit/kastel/travart/kconfig/parser/LKC.g:317:7: ( '0' ( 'x' | 'X' ) )=> '0' ( 'x' | 'X' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )+
					{
					match('0'); if (state.failed) return;
					if ( input.LA(1)=='X'||input.LA(1)=='x' ) {
						input.consume();
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					// de/kit/kastel/travart/kconfig/parser/LKC.g:317:40: ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )+
					int cnt11=0;
					loop11:
					while (true) {
						int alt11=2;
						int LA11_0 = input.LA(1);
						if ( ((LA11_0 >= '0' && LA11_0 <= '9')||(LA11_0 >= 'A' && LA11_0 <= 'F')||(LA11_0 >= 'a' && LA11_0 <= 'f')) ) {
							alt11=1;
						}

						switch (alt11) {
						case 1 :
							// de/kit/kastel/travart/kconfig/parser/LKC.g:
							{
							if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'F')||(input.LA(1) >= 'a' && input.LA(1) <= 'f') ) {
								input.consume();
								state.failed=false;
							}
							else {
								if (state.backtracking>0) {state.failed=true; return;}
								MismatchedSetException mse = new MismatchedSetException(null,input);
								recover(mse);
								throw mse;
							}
							}
							break;

						default :
							if ( cnt11 >= 1 ) break loop11;
							if (state.backtracking>0) {state.failed=true; return;}
							EarlyExitException eee = new EarlyExitException(11, input);
							throw eee;
						}
						cnt11++;
					}

					}
					break;

			}
			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "WORD"

	// $ANTLR start "WORD_QUOTE"
	public final void mWORD_QUOTE() throws RecognitionException {
		try {
			int _type = WORD_QUOTE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// de/kit/kastel/travart/kconfig/parser/LKC.g:321:5: ( '\\'' ( options {greedy=false; } : ESC | . )* '\\'' | '\"' ( options {greedy=false; } : ESC | . )* '\"' )
			int alt15=2;
			int LA15_0 = input.LA(1);
			if ( (LA15_0=='\'') ) {
				alt15=1;
			}
			else if ( (LA15_0=='\"') ) {
				alt15=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return;}
				NoViableAltException nvae =
					new NoViableAltException("", 15, 0, input);
				throw nvae;
			}

			switch (alt15) {
				case 1 :
					// de/kit/kastel/travart/kconfig/parser/LKC.g:321:7: '\\'' ( options {greedy=false; } : ESC | . )* '\\''
					{
					match('\''); if (state.failed) return;
					// de/kit/kastel/travart/kconfig/parser/LKC.g:321:12: ( options {greedy=false; } : ESC | . )*
					loop13:
					while (true) {
						int alt13=3;
						int LA13_0 = input.LA(1);
						if ( (LA13_0=='\'') ) {
							alt13=3;
						}
						else if ( (LA13_0=='\\') ) {
							int LA13_2 = input.LA(2);
							if ( (LA13_2=='\'') ) {
								alt13=1;
							}
							else if ( (LA13_2=='\"') ) {
								alt13=1;
							}
							else if ( ((LA13_2 >= '\u0000' && LA13_2 <= '!')||(LA13_2 >= '#' && LA13_2 <= '&')||(LA13_2 >= '(' && LA13_2 <= '\uFFFF')) ) {
								alt13=2;
							}

						}
						else if ( ((LA13_0 >= '\u0000' && LA13_0 <= '&')||(LA13_0 >= '(' && LA13_0 <= '[')||(LA13_0 >= ']' && LA13_0 <= '\uFFFF')) ) {
							alt13=2;
						}

						switch (alt13) {
						case 1 :
							// de/kit/kastel/travart/kconfig/parser/LKC.g:321:37: ESC
							{
							mESC(); if (state.failed) return;

							}
							break;
						case 2 :
							// de/kit/kastel/travart/kconfig/parser/LKC.g:321:41: .
							{
							matchAny(); if (state.failed) return;
							}
							break;

						default :
							break loop13;
						}
					}

					match('\''); if (state.failed) return;
					if ( state.backtracking==0 ) {
					      setText(getText().substring(1,getText().length()-1));
					    }
					}
					break;
				case 2 :
					// de/kit/kastel/travart/kconfig/parser/LKC.g:325:7: '\"' ( options {greedy=false; } : ESC | . )* '\"'
					{
					match('\"'); if (state.failed) return;
					// de/kit/kastel/travart/kconfig/parser/LKC.g:325:11: ( options {greedy=false; } : ESC | . )*
					loop14:
					while (true) {
						int alt14=3;
						int LA14_0 = input.LA(1);
						if ( (LA14_0=='\"') ) {
							alt14=3;
						}
						else if ( (LA14_0=='\\') ) {
							int LA14_2 = input.LA(2);
							if ( (LA14_2=='\"') ) {
								alt14=1;
							}
							else if ( (LA14_2=='\'') ) {
								alt14=1;
							}
							else if ( ((LA14_2 >= '\u0000' && LA14_2 <= '!')||(LA14_2 >= '#' && LA14_2 <= '&')||(LA14_2 >= '(' && LA14_2 <= '\uFFFF')) ) {
								alt14=2;
							}

						}
						else if ( ((LA14_0 >= '\u0000' && LA14_0 <= '!')||(LA14_0 >= '#' && LA14_0 <= '[')||(LA14_0 >= ']' && LA14_0 <= '\uFFFF')) ) {
							alt14=2;
						}

						switch (alt14) {
						case 1 :
							// de/kit/kastel/travart/kconfig/parser/LKC.g:325:36: ESC
							{
							mESC(); if (state.failed) return;

							}
							break;
						case 2 :
							// de/kit/kastel/travart/kconfig/parser/LKC.g:325:40: .
							{
							matchAny(); if (state.failed) return;
							}
							break;

						default :
							break loop14;
						}
					}

					match('\"'); if (state.failed) return;
					if ( state.backtracking==0 ) {
					      setText(getText().substring(1,getText().length()-1));
					    }
					}
					break;

			}
			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "WORD_QUOTE"

	// $ANTLR start "ESC"
	public final void mESC() throws RecognitionException {
		try {
			// de/kit/kastel/travart/kconfig/parser/LKC.g:334:5: ( '\\\\' ( '\"' | '\\'' ) )
			// de/kit/kastel/travart/kconfig/parser/LKC.g:334:7: '\\\\' ( '\"' | '\\'' )
			{
			match('\\'); if (state.failed) return;
			if ( input.LA(1)=='\"'||input.LA(1)=='\'' ) {
				input.consume();
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ESC"

	// $ANTLR start "CONTINUE"
	public final void mCONTINUE() throws RecognitionException {
		try {
			int _type = CONTINUE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// de/kit/kastel/travart/kconfig/parser/LKC.g:337:5: ( '\\\\' NEWLINE WS )
			// de/kit/kastel/travart/kconfig/parser/LKC.g:337:7: '\\\\' NEWLINE WS
			{
			match('\\'); if (state.failed) return;
			mNEWLINE(); if (state.failed) return;

			mWS(); if (state.failed) return;

			if ( state.backtracking==0 ) {
			      _channel=HIDDEN;
			    }
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "CONTINUE"

	// $ANTLR start "DASHES"
	public final void mDASHES() throws RecognitionException {
		try {
			int _type = DASHES;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// de/kit/kastel/travart/kconfig/parser/LKC.g:344:5: ( '-' ({...}? '-' ) ({...}? '-' )? )
			// de/kit/kastel/travart/kconfig/parser/LKC.g:344:7: '-' ({...}? '-' ) ({...}? '-' )?
			{
			match('-'); if (state.failed) return;
			// de/kit/kastel/travart/kconfig/parser/LKC.g:345:7: ({...}? '-' )
			// de/kit/kastel/travart/kconfig/parser/LKC.g:345:8: {...}? '-'
			{
			if ( !((input.LA(1)=='-')) ) {
				if (state.backtracking>0) {state.failed=true; return;}
				throw new FailedPredicateException(input, "DASHES", "input.LA(1)=='-'");
			}
			match('-'); if (state.failed) return;
			}

			// de/kit/kastel/travart/kconfig/parser/LKC.g:346:7: ({...}? '-' )?
			int alt16=2;
			int LA16_0 = input.LA(1);
			if ( (LA16_0=='-') ) {
				alt16=1;
			}
			switch (alt16) {
				case 1 :
					// de/kit/kastel/travart/kconfig/parser/LKC.g:346:8: {...}? '-'
					{
					if ( !((input.LA(1)=='-')) ) {
						if (state.backtracking>0) {state.failed=true; return;}
						throw new FailedPredicateException(input, "DASHES", "input.LA(1)=='-'");
					}
					match('-'); if (state.failed) return;
					}
					break;

			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DASHES"

	// $ANTLR start "HEX_OR_HELP"
	public final void mHEX_OR_HELP() throws RecognitionException {
		try {
			int _type = HEX_OR_HELP;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// de/kit/kastel/travart/kconfig/parser/LKC.g:356:5: ( ( LEADING_WS HEX )=> LEADING_WS HEX | HELP_TEXT )
			int alt17=2;
			alt17 = dfa17.predict(input);
			switch (alt17) {
				case 1 :
					// de/kit/kastel/travart/kconfig/parser/LKC.g:356:7: ( LEADING_WS HEX )=> LEADING_WS HEX
					{
					mLEADING_WS(); if (state.failed) return;

					mHEX(); if (state.failed) return;

					if ( state.backtracking==0 ) {
					        //INDENT is emitted by LEADING_WS rule
					        //HEX is emitted by this rule
					        emit(new ClassicToken(HEX, "hex"));
					      }
					}
					break;
				case 2 :
					// de/kit/kastel/travart/kconfig/parser/LKC.g:362:7: HELP_TEXT
					{
					mHELP_TEXT(); if (state.failed) return;

					}
					break;

			}
			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "HEX_OR_HELP"

	// $ANTLR start "HELP_TEXT"
	public final void mHELP_TEXT() throws RecognitionException {
		try {
			CommonToken next=null;


			  helpMargin = -1;

			// de/kit/kastel/travart/kconfig/parser/LKC.g:382:5: ( ( ( HELP_WS DASHES )=> HELP_WS DASHES HELP_WS HELP HELP_WS DASHES HELP_WS NEWLINE | HELP_WS HELP HELP_WS NEWLINE ) ( (next= HELP_WS {...}?|{...}? HELP_WS '\\n' )=>next= HELP_WS ( options {greedy=false; } : . )* '\\n' )* )
			// de/kit/kastel/travart/kconfig/parser/LKC.g:383:9: ( ( HELP_WS DASHES )=> HELP_WS DASHES HELP_WS HELP HELP_WS DASHES HELP_WS NEWLINE | HELP_WS HELP HELP_WS NEWLINE ) ( (next= HELP_WS {...}?|{...}? HELP_WS '\\n' )=>next= HELP_WS ( options {greedy=false; } : . )* '\\n' )*
			{
			// de/kit/kastel/travart/kconfig/parser/LKC.g:383:9: ( ( HELP_WS DASHES )=> HELP_WS DASHES HELP_WS HELP HELP_WS DASHES HELP_WS NEWLINE | HELP_WS HELP HELP_WS NEWLINE )
			int alt18=2;
			alt18 = dfa18.predict(input);
			switch (alt18) {
				case 1 :
					// de/kit/kastel/travart/kconfig/parser/LKC.g:385:11: ( HELP_WS DASHES )=> HELP_WS DASHES HELP_WS HELP HELP_WS DASHES HELP_WS NEWLINE
					{
					mHELP_WS(); if (state.failed) return;

					mDASHES(); if (state.failed) return;

					mHELP_WS(); if (state.failed) return;

					mHELP(); if (state.failed) return;

					mHELP_WS(); if (state.failed) return;

					mDASHES(); if (state.failed) return;

					mHELP_WS(); if (state.failed) return;

					mNEWLINE(); if (state.failed) return;

					}
					break;
				case 2 :
					// de/kit/kastel/travart/kconfig/parser/LKC.g:389:11: HELP_WS HELP HELP_WS NEWLINE
					{
					mHELP_WS(); if (state.failed) return;

					mHELP(); if (state.failed) return;

					mHELP_WS(); if (state.failed) return;

					mNEWLINE(); if (state.failed) return;

					}
					break;

			}

			// de/kit/kastel/travart/kconfig/parser/LKC.g:391:9: ( (next= HELP_WS {...}?|{...}? HELP_WS '\\n' )=>next= HELP_WS ( options {greedy=false; } : . )* '\\n' )*
			loop20:
			while (true) {
				int alt20=2;
				int LA20_0 = input.LA(1);
				if ( (LA20_0=='\t'||LA20_0==' ') && (synpred4_LKC())) {
					alt20=1;
				}
				else if ( (LA20_0=='\n') && (synpred4_LKC())) {
					alt20=1;
				}
				else if ( ((LA20_0 >= '\u0000' && LA20_0 <= '\b')||(LA20_0 >= '\u000B' && LA20_0 <= '\u001F')||(LA20_0 >= '!' && LA20_0 <= '\uFFFF')) && (synpred4_LKC())) {
					alt20=1;
				}

				switch (alt20) {
				case 1 :
					// de/kit/kastel/travart/kconfig/parser/LKC.g:394:12: (next= HELP_WS {...}?|{...}? HELP_WS '\\n' )=>next= HELP_WS ( options {greedy=false; } : . )* '\\n'
					{
					int nextStart1140 = getCharIndex();
					int nextStartLine1140 = getLine();
					int nextStartCharPos1140 = getCharPositionInLine();
					mHELP_WS(); if (state.failed) return;
					next = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, nextStart1140, getCharIndex()-1);
					next.setLine(nextStartLine1140);
					next.setCharPositionInLine(nextStartCharPos1140);

					// de/kit/kastel/travart/kconfig/parser/LKC.g:397:28: ( options {greedy=false; } : . )*
					loop19:
					while (true) {
						int alt19=2;
						int LA19_0 = input.LA(1);
						if ( (LA19_0=='\n') ) {
							alt19=2;
						}
						else if ( ((LA19_0 >= '\u0000' && LA19_0 <= '\t')||(LA19_0 >= '\u000B' && LA19_0 <= '\uFFFF')) ) {
							alt19=1;
						}

						switch (alt19) {
						case 1 :
							// de/kit/kastel/travart/kconfig/parser/LKC.g:397:53: .
							{
							matchAny(); if (state.failed) return;
							}
							break;

						default :
							break loop19;
						}
					}

					match('\n'); if (state.failed) return;
					if ( state.backtracking==0 ) {
					             if (helpMargin < 0)
					               helpMargin = wsLength(next);
					           }
					}
					break;

				default :
					break loop20;
				}
			}

			if ( state.backtracking==0 ) {
			          emit (new ClassicToken(HELP_TEXT, new String("<help text>")));
			        }
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "HELP_TEXT"

	// $ANTLR start "HELP_WS"
	public final void mHELP_WS() throws RecognitionException {
		try {
			// de/kit/kastel/travart/kconfig/parser/LKC.g:402:9: ( ( ' ' | '\\t' )* )
			// de/kit/kastel/travart/kconfig/parser/LKC.g:402:11: ( ' ' | '\\t' )*
			{
			// de/kit/kastel/travart/kconfig/parser/LKC.g:402:11: ( ' ' | '\\t' )*
			loop21:
			while (true) {
				int alt21=2;
				int LA21_0 = input.LA(1);
				if ( (LA21_0=='\t'||LA21_0==' ') ) {
					alt21=1;
				}

				switch (alt21) {
				case 1 :
					// de/kit/kastel/travart/kconfig/parser/LKC.g:
					{
					if ( input.LA(1)=='\t'||input.LA(1)==' ' ) {
						input.consume();
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					break loop21;
				}
			}

			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "HELP_WS"

	// $ANTLR start "SL_COMMENT"
	public final void mSL_COMMENT() throws RecognitionException {
		try {
			int _type = SL_COMMENT;
			int _channel = DEFAULT_TOKEN_CHANNEL;

			  _channel=HIDDEN;

			// de/kit/kastel/travart/kconfig/parser/LKC.g:407:5: ({...}? => '#' (~ ( '\\n' ) )* ( '\\n' )+ | '#' (~ ( '\\n' ) )* )
			int alt25=2;
			alt25 = dfa25.predict(input);
			switch (alt25) {
				case 1 :
					// de/kit/kastel/travart/kconfig/parser/LKC.g:407:7: {...}? => '#' (~ ( '\\n' ) )* ( '\\n' )+
					{
					if ( !((startPos==0)) ) {
						if (state.backtracking>0) {state.failed=true; return;}
						throw new FailedPredicateException(input, "SL_COMMENT", "startPos==0");
					}
					match('#'); if (state.failed) return;
					// de/kit/kastel/travart/kconfig/parser/LKC.g:407:28: (~ ( '\\n' ) )*
					loop22:
					while (true) {
						int alt22=2;
						int LA22_0 = input.LA(1);
						if ( ((LA22_0 >= '\u0000' && LA22_0 <= '\t')||(LA22_0 >= '\u000B' && LA22_0 <= '\uFFFF')) ) {
							alt22=1;
						}

						switch (alt22) {
						case 1 :
							// de/kit/kastel/travart/kconfig/parser/LKC.g:
							{
							if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '\t')||(input.LA(1) >= '\u000B' && input.LA(1) <= '\uFFFF') ) {
								input.consume();
								state.failed=false;
							}
							else {
								if (state.backtracking>0) {state.failed=true; return;}
								MismatchedSetException mse = new MismatchedSetException(null,input);
								recover(mse);
								throw mse;
							}
							}
							break;

						default :
							break loop22;
						}
					}

					// de/kit/kastel/travart/kconfig/parser/LKC.g:407:37: ( '\\n' )+
					int cnt23=0;
					loop23:
					while (true) {
						int alt23=2;
						int LA23_0 = input.LA(1);
						if ( (LA23_0=='\n') ) {
							alt23=1;
						}

						switch (alt23) {
						case 1 :
							// de/kit/kastel/travart/kconfig/parser/LKC.g:407:37: '\\n'
							{
							match('\n'); if (state.failed) return;
							}
							break;

						default :
							if ( cnt23 >= 1 ) break loop23;
							if (state.backtracking>0) {state.failed=true; return;}
							EarlyExitException eee = new EarlyExitException(23, input);
							throw eee;
						}
						cnt23++;
					}

					}
					break;
				case 2 :
					// de/kit/kastel/travart/kconfig/parser/LKC.g:408:7: '#' (~ ( '\\n' ) )*
					{
					match('#'); if (state.failed) return;
					// de/kit/kastel/travart/kconfig/parser/LKC.g:408:11: (~ ( '\\n' ) )*
					loop24:
					while (true) {
						int alt24=2;
						int LA24_0 = input.LA(1);
						if ( ((LA24_0 >= '\u0000' && LA24_0 <= '\t')||(LA24_0 >= '\u000B' && LA24_0 <= '\uFFFF')) ) {
							alt24=1;
						}

						switch (alt24) {
						case 1 :
							// de/kit/kastel/travart/kconfig/parser/LKC.g:
							{
							if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '\t')||(input.LA(1) >= '\u000B' && input.LA(1) <= '\uFFFF') ) {
								input.consume();
								state.failed=false;
							}
							else {
								if (state.backtracking>0) {state.failed=true; return;}
								MismatchedSetException mse = new MismatchedSetException(null,input);
								recover(mse);
								throw mse;
							}
							}
							break;

						default :
							break loop24;
						}
					}

					}
					break;

			}
			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "SL_COMMENT"

	@Override
	public void mTokens() throws RecognitionException {
		// de/kit/kastel/travart/kconfig/parser/LKC.g:1:8: ( DASH | HEX | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | MAINMENU | CHOICE | ENDCHOICE | MENU | ENDMENU | IF | ENDIF | SOURCE | COMMENT | CONFIG | MENUCONFIG | DEPENDS | ON | SELECT | DEFAULT | RANGE | HELP | PROMPT | OPTION | ENV | DEFCONFIG_LIST | OPTIONAL | FALSE | TRUE | NEWLINE | WS | LEADING_WS | INDENT | WORD | WORD_QUOTE | CONTINUE | DASHES | HEX_OR_HELP | SL_COMMENT )
		int alt26=49;
		alt26 = dfa26.predict(input);
		switch (alt26) {
			case 1 :
				// de/kit/kastel/travart/kconfig/parser/LKC.g:1:10: DASH
				{
				mDASH(); if (state.failed) return;

				}
				break;
			case 2 :
				// de/kit/kastel/travart/kconfig/parser/LKC.g:1:15: HEX
				{
				mHEX(); if (state.failed) return;

				}
				break;
			case 3 :
				// de/kit/kastel/travart/kconfig/parser/LKC.g:1:19: T__44
				{
				mT__44(); if (state.failed) return;

				}
				break;
			case 4 :
				// de/kit/kastel/travart/kconfig/parser/LKC.g:1:25: T__45
				{
				mT__45(); if (state.failed) return;

				}
				break;
			case 5 :
				// de/kit/kastel/travart/kconfig/parser/LKC.g:1:31: T__46
				{
				mT__46(); if (state.failed) return;

				}
				break;
			case 6 :
				// de/kit/kastel/travart/kconfig/parser/LKC.g:1:37: T__47
				{
				mT__47(); if (state.failed) return;

				}
				break;
			case 7 :
				// de/kit/kastel/travart/kconfig/parser/LKC.g:1:43: T__48
				{
				mT__48(); if (state.failed) return;

				}
				break;
			case 8 :
				// de/kit/kastel/travart/kconfig/parser/LKC.g:1:49: T__49
				{
				mT__49(); if (state.failed) return;

				}
				break;
			case 9 :
				// de/kit/kastel/travart/kconfig/parser/LKC.g:1:55: T__50
				{
				mT__50(); if (state.failed) return;

				}
				break;
			case 10 :
				// de/kit/kastel/travart/kconfig/parser/LKC.g:1:61: T__51
				{
				mT__51(); if (state.failed) return;

				}
				break;
			case 11 :
				// de/kit/kastel/travart/kconfig/parser/LKC.g:1:67: T__52
				{
				mT__52(); if (state.failed) return;

				}
				break;
			case 12 :
				// de/kit/kastel/travart/kconfig/parser/LKC.g:1:73: T__53
				{
				mT__53(); if (state.failed) return;

				}
				break;
			case 13 :
				// de/kit/kastel/travart/kconfig/parser/LKC.g:1:79: T__54
				{
				mT__54(); if (state.failed) return;

				}
				break;
			case 14 :
				// de/kit/kastel/travart/kconfig/parser/LKC.g:1:85: T__55
				{
				mT__55(); if (state.failed) return;

				}
				break;
			case 15 :
				// de/kit/kastel/travart/kconfig/parser/LKC.g:1:91: T__56
				{
				mT__56(); if (state.failed) return;

				}
				break;
			case 16 :
				// de/kit/kastel/travart/kconfig/parser/LKC.g:1:97: MAINMENU
				{
				mMAINMENU(); if (state.failed) return;

				}
				break;
			case 17 :
				// de/kit/kastel/travart/kconfig/parser/LKC.g:1:106: CHOICE
				{
				mCHOICE(); if (state.failed) return;

				}
				break;
			case 18 :
				// de/kit/kastel/travart/kconfig/parser/LKC.g:1:113: ENDCHOICE
				{
				mENDCHOICE(); if (state.failed) return;

				}
				break;
			case 19 :
				// de/kit/kastel/travart/kconfig/parser/LKC.g:1:123: MENU
				{
				mMENU(); if (state.failed) return;

				}
				break;
			case 20 :
				// de/kit/kastel/travart/kconfig/parser/LKC.g:1:128: ENDMENU
				{
				mENDMENU(); if (state.failed) return;

				}
				break;
			case 21 :
				// de/kit/kastel/travart/kconfig/parser/LKC.g:1:136: IF
				{
				mIF(); if (state.failed) return;

				}
				break;
			case 22 :
				// de/kit/kastel/travart/kconfig/parser/LKC.g:1:139: ENDIF
				{
				mENDIF(); if (state.failed) return;

				}
				break;
			case 23 :
				// de/kit/kastel/travart/kconfig/parser/LKC.g:1:145: SOURCE
				{
				mSOURCE(); if (state.failed) return;

				}
				break;
			case 24 :
				// de/kit/kastel/travart/kconfig/parser/LKC.g:1:152: COMMENT
				{
				mCOMMENT(); if (state.failed) return;

				}
				break;
			case 25 :
				// de/kit/kastel/travart/kconfig/parser/LKC.g:1:160: CONFIG
				{
				mCONFIG(); if (state.failed) return;

				}
				break;
			case 26 :
				// de/kit/kastel/travart/kconfig/parser/LKC.g:1:167: MENUCONFIG
				{
				mMENUCONFIG(); if (state.failed) return;

				}
				break;
			case 27 :
				// de/kit/kastel/travart/kconfig/parser/LKC.g:1:178: DEPENDS
				{
				mDEPENDS(); if (state.failed) return;

				}
				break;
			case 28 :
				// de/kit/kastel/travart/kconfig/parser/LKC.g:1:186: ON
				{
				mON(); if (state.failed) return;

				}
				break;
			case 29 :
				// de/kit/kastel/travart/kconfig/parser/LKC.g:1:189: SELECT
				{
				mSELECT(); if (state.failed) return;

				}
				break;
			case 30 :
				// de/kit/kastel/travart/kconfig/parser/LKC.g:1:196: DEFAULT
				{
				mDEFAULT(); if (state.failed) return;

				}
				break;
			case 31 :
				// de/kit/kastel/travart/kconfig/parser/LKC.g:1:204: RANGE
				{
				mRANGE(); if (state.failed) return;

				}
				break;
			case 32 :
				// de/kit/kastel/travart/kconfig/parser/LKC.g:1:210: HELP
				{
				mHELP(); if (state.failed) return;

				}
				break;
			case 33 :
				// de/kit/kastel/travart/kconfig/parser/LKC.g:1:215: PROMPT
				{
				mPROMPT(); if (state.failed) return;

				}
				break;
			case 34 :
				// de/kit/kastel/travart/kconfig/parser/LKC.g:1:222: OPTION
				{
				mOPTION(); if (state.failed) return;

				}
				break;
			case 35 :
				// de/kit/kastel/travart/kconfig/parser/LKC.g:1:229: ENV
				{
				mENV(); if (state.failed) return;

				}
				break;
			case 36 :
				// de/kit/kastel/travart/kconfig/parser/LKC.g:1:233: DEFCONFIG_LIST
				{
				mDEFCONFIG_LIST(); if (state.failed) return;

				}
				break;
			case 37 :
				// de/kit/kastel/travart/kconfig/parser/LKC.g:1:248: OPTIONAL
				{
				mOPTIONAL(); if (state.failed) return;

				}
				break;
			case 38 :
				// de/kit/kastel/travart/kconfig/parser/LKC.g:1:257: FALSE
				{
				mFALSE(); if (state.failed) return;

				}
				break;
			case 39 :
				// de/kit/kastel/travart/kconfig/parser/LKC.g:1:263: TRUE
				{
				mTRUE(); if (state.failed) return;

				}
				break;
			case 40 :
				// de/kit/kastel/travart/kconfig/parser/LKC.g:1:268: NEWLINE
				{
				mNEWLINE(); if (state.failed) return;

				}
				break;
			case 41 :
				// de/kit/kastel/travart/kconfig/parser/LKC.g:1:276: WS
				{
				mWS(); if (state.failed) return;

				}
				break;
			case 42 :
				// de/kit/kastel/travart/kconfig/parser/LKC.g:1:279: LEADING_WS
				{
				mLEADING_WS(); if (state.failed) return;

				}
				break;
			case 43 :
				// de/kit/kastel/travart/kconfig/parser/LKC.g:1:290: INDENT
				{
				mINDENT(); if (state.failed) return;

				}
				break;
			case 44 :
				// de/kit/kastel/travart/kconfig/parser/LKC.g:1:297: WORD
				{
				mWORD(); if (state.failed) return;

				}
				break;
			case 45 :
				// de/kit/kastel/travart/kconfig/parser/LKC.g:1:302: WORD_QUOTE
				{
				mWORD_QUOTE(); if (state.failed) return;

				}
				break;
			case 46 :
				// de/kit/kastel/travart/kconfig/parser/LKC.g:1:313: CONTINUE
				{
				mCONTINUE(); if (state.failed) return;

				}
				break;
			case 47 :
				// de/kit/kastel/travart/kconfig/parser/LKC.g:1:322: DASHES
				{
				mDASHES(); if (state.failed) return;

				}
				break;
			case 48 :
				// de/kit/kastel/travart/kconfig/parser/LKC.g:1:329: HEX_OR_HELP
				{
				mHEX_OR_HELP(); if (state.failed) return;

				}
				break;
			case 49 :
				// de/kit/kastel/travart/kconfig/parser/LKC.g:1:341: SL_COMMENT
				{
				mSL_COMMENT(); if (state.failed) return;

				}
				break;

		}
	}

	// $ANTLR start synpred1_LKC
	public final void synpred1_LKC_fragment() throws RecognitionException {
		// de/kit/kastel/travart/kconfig/parser/LKC.g:317:7: ( '0' ( 'x' | 'X' ) )
		// de/kit/kastel/travart/kconfig/parser/LKC.g:317:8: '0' ( 'x' | 'X' )
		{
		match('0'); if (state.failed) return;
		if ( input.LA(1)=='X'||input.LA(1)=='x' ) {
			input.consume();
			state.failed=false;
		}
		else {
			if (state.backtracking>0) {state.failed=true; return;}
			MismatchedSetException mse = new MismatchedSetException(null,input);
			recover(mse);
			throw mse;
		}
		}

	}
	// $ANTLR end synpred1_LKC

	// $ANTLR start synpred2_LKC
	public final void synpred2_LKC_fragment() throws RecognitionException {
		// de/kit/kastel/travart/kconfig/parser/LKC.g:356:7: ( LEADING_WS HEX )
		// de/kit/kastel/travart/kconfig/parser/LKC.g:356:8: LEADING_WS HEX
		{
		mLEADING_WS(); if (state.failed) return;

		mHEX(); if (state.failed) return;

		}

	}
	// $ANTLR end synpred2_LKC

	// $ANTLR start synpred3_LKC
	public final void synpred3_LKC_fragment() throws RecognitionException {
		// de/kit/kastel/travart/kconfig/parser/LKC.g:385:11: ( HELP_WS DASHES )
		// de/kit/kastel/travart/kconfig/parser/LKC.g:385:12: HELP_WS DASHES
		{
		mHELP_WS(); if (state.failed) return;

		mDASHES(); if (state.failed) return;

		}

	}
	// $ANTLR end synpred3_LKC

	// $ANTLR start synpred4_LKC
	public final void synpred4_LKC_fragment() throws RecognitionException {
		CommonToken next=null;

		// de/kit/kastel/travart/kconfig/parser/LKC.g:394:12: (next= HELP_WS {...}?|{...}? HELP_WS '\\n' )
		int alt27=2;
		alt27 = dfa27.predict(input);
		switch (alt27) {
			case 1 :
				// de/kit/kastel/travart/kconfig/parser/LKC.g:394:14: next= HELP_WS {...}?
				{
				int nextStart1089 = getCharIndex();
				int nextStartLine1089 = getLine();
				int nextStartCharPos1089 = getCharPositionInLine();
				mHELP_WS(); if (state.failed) return;
				next = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, nextStart1089, getCharIndex()-1);
				next.setLine(nextStartLine1089);
				next.setCharPositionInLine(nextStartCharPos1089);

				if ( !(( wsLength(next) > 0 && wsLength(next) >= helpMargin )) ) {
					if (state.backtracking>0) {state.failed=true; return;}
					throw new FailedPredicateException(input, "synpred4_LKC", " wsLength($next) > 0 && wsLength($next) >= helpMargin ");
				}
				}
				break;
			case 2 :
				// de/kit/kastel/travart/kconfig/parser/LKC.g:395:14: {...}? HELP_WS '\\n'
				{
				if ( !((helpMargin > 0)) ) {
					if (state.backtracking>0) {state.failed=true; return;}
					throw new FailedPredicateException(input, "synpred4_LKC", "helpMargin > 0");
				}
				mHELP_WS(); if (state.failed) return;

				match('\n'); if (state.failed) return;
				}
				break;

		}
	}
	// $ANTLR end synpred4_LKC

	public final boolean synpred3_LKC() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred3_LKC_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred1_LKC() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred1_LKC_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred4_LKC() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred4_LKC_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred2_LKC() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred2_LKC_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}


	protected DFA17 dfa17 = new DFA17(this);
	protected DFA18 dfa18 = new DFA18(this);
	protected DFA25 dfa25 = new DFA25(this);
	protected DFA26 dfa26 = new DFA26(this);
	protected DFA27 dfa27 = new DFA27(this);
	static final String DFA17_eotS =
		"\12\uffff";
	static final String DFA17_eofS =
		"\12\uffff";
	static final String DFA17_minS =
		"\3\11\4\uffff\1\145\1\154\1\uffff";
	static final String DFA17_maxS =
		"\3\150\4\uffff\1\145\1\170\1\uffff";
	static final String DFA17_acceptS =
		"\3\uffff\1\2\3\1\2\uffff\1\1";
	static final String DFA17_specialS =
		"\1\uffff\1\1\1\0\5\uffff\1\2\1\uffff}>";
	static final String[] DFA17_transitionS = {
			"\1\2\26\uffff\1\1\14\uffff\1\3\72\uffff\1\3",
			"\1\2\1\5\2\uffff\1\4\22\uffff\1\1\2\uffff\1\6\11\uffff\1\3\72\uffff"+
			"\1\7",
			"\1\2\1\5\2\uffff\1\4\22\uffff\1\1\2\uffff\1\6\11\uffff\1\3\72\uffff"+
			"\1\7",
			"",
			"",
			"",
			"",
			"\1\10",
			"\1\3\13\uffff\1\11",
			""
	};

	static final short[] DFA17_eot = DFA.unpackEncodedString(DFA17_eotS);
	static final short[] DFA17_eof = DFA.unpackEncodedString(DFA17_eofS);
	static final char[] DFA17_min = DFA.unpackEncodedStringToUnsignedChars(DFA17_minS);
	static final char[] DFA17_max = DFA.unpackEncodedStringToUnsignedChars(DFA17_maxS);
	static final short[] DFA17_accept = DFA.unpackEncodedString(DFA17_acceptS);
	static final short[] DFA17_special = DFA.unpackEncodedString(DFA17_specialS);
	static final short[][] DFA17_transition;

	static {
		int numStates = DFA17_transitionS.length;
		DFA17_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA17_transition[i] = DFA.unpackEncodedString(DFA17_transitionS[i]);
		}
	}

	protected class DFA17 extends DFA {

		public DFA17(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 17;
			this.eot = DFA17_eot;
			this.eof = DFA17_eof;
			this.min = DFA17_min;
			this.max = DFA17_max;
			this.accept = DFA17_accept;
			this.special = DFA17_special;
			this.transition = DFA17_transition;
		}
		@Override
		public String getDescription() {
			return "355:1: HEX_OR_HELP : ( ( LEADING_WS HEX )=> LEADING_WS HEX | HELP_TEXT );";
		}
		@Override
		public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
			IntStream input = _input;
			int _s = s;
			switch ( s ) {
					case 0 : 
						int LA17_2 = input.LA(1);
						 
						int index17_2 = input.index();
						input.rewind();
						s = -1;
						if ( (LA17_2=='\r') && (((startPos==0)&&synpred2_LKC()))) {s = 4;}
						else if ( (LA17_2=='\n') && (((startPos==0)&&synpred2_LKC()))) {s = 5;}
						else if ( (LA17_2=='#') && (((startPos==0)&&synpred2_LKC()))) {s = 6;}
						else if ( (LA17_2=='h') ) {s = 7;}
						else if ( (LA17_2==' ') ) {s = 1;}
						else if ( (LA17_2=='\t') ) {s = 2;}
						else if ( (LA17_2=='-') ) {s = 3;}
						 
						input.seek(index17_2);
						if ( s>=0 ) return s;
						break;
					case 1 : 
						int LA17_1 = input.LA(1);
						 
						int index17_1 = input.index();
						input.rewind();
						s = -1;
						if ( (LA17_1=='\r') && (((startPos==0)&&synpred2_LKC()))) {s = 4;}
						else if ( (LA17_1=='\n') && (((startPos==0)&&synpred2_LKC()))) {s = 5;}
						else if ( (LA17_1=='#') && (((startPos==0)&&synpred2_LKC()))) {s = 6;}
						else if ( (LA17_1=='h') ) {s = 7;}
						else if ( (LA17_1==' ') ) {s = 1;}
						else if ( (LA17_1=='\t') ) {s = 2;}
						else if ( (LA17_1=='-') ) {s = 3;}
						 
						input.seek(index17_1);
						if ( s>=0 ) return s;
						break;
					case 2 : 
						int LA17_8 = input.LA(1);
						 
						int index17_8 = input.index();
						input.rewind();
						s = -1;
						if ( (LA17_8=='x') && (((startPos==0)&&synpred2_LKC()))) {s = 9;}
						else if ( (LA17_8=='l') ) {s = 3;}
						 
						input.seek(index17_8);
						if ( s>=0 ) return s;
						break;
			}
			if (state.backtracking>0) {state.failed=true; return -1;}
			NoViableAltException nvae =
				new NoViableAltException(getDescription(), 17, _s, input);
			error(nvae);
			throw nvae;
		}
	}

	static final String DFA18_eotS =
		"\4\uffff";
	static final String DFA18_eofS =
		"\4\uffff";
	static final String DFA18_minS =
		"\2\11\2\uffff";
	static final String DFA18_maxS =
		"\2\150\2\uffff";
	static final String DFA18_acceptS =
		"\2\uffff\1\1\1\2";
	static final String DFA18_specialS =
		"\1\1\1\0\2\uffff}>";
	static final String[] DFA18_transitionS = {
			"\1\1\26\uffff\1\1\14\uffff\1\2\72\uffff\1\3",
			"\1\1\26\uffff\1\1\14\uffff\1\2\72\uffff\1\3",
			"",
			""
	};

	static final short[] DFA18_eot = DFA.unpackEncodedString(DFA18_eotS);
	static final short[] DFA18_eof = DFA.unpackEncodedString(DFA18_eofS);
	static final char[] DFA18_min = DFA.unpackEncodedStringToUnsignedChars(DFA18_minS);
	static final char[] DFA18_max = DFA.unpackEncodedStringToUnsignedChars(DFA18_maxS);
	static final short[] DFA18_accept = DFA.unpackEncodedString(DFA18_acceptS);
	static final short[] DFA18_special = DFA.unpackEncodedString(DFA18_specialS);
	static final short[][] DFA18_transition;

	static {
		int numStates = DFA18_transitionS.length;
		DFA18_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA18_transition[i] = DFA.unpackEncodedString(DFA18_transitionS[i]);
		}
	}

	protected class DFA18 extends DFA {

		public DFA18(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 18;
			this.eot = DFA18_eot;
			this.eof = DFA18_eof;
			this.min = DFA18_min;
			this.max = DFA18_max;
			this.accept = DFA18_accept;
			this.special = DFA18_special;
			this.transition = DFA18_transition;
		}
		@Override
		public String getDescription() {
			return "383:9: ( ( HELP_WS DASHES )=> HELP_WS DASHES HELP_WS HELP HELP_WS DASHES HELP_WS NEWLINE | HELP_WS HELP HELP_WS NEWLINE )";
		}
		@Override
		public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
			IntStream input = _input;
			int _s = s;
			switch ( s ) {
					case 0 : 
						int LA18_1 = input.LA(1);
						 
						int index18_1 = input.index();
						input.rewind();
						s = -1;
						if ( (LA18_1=='-') && (synpred3_LKC())) {s = 2;}
						else if ( (LA18_1=='\t'||LA18_1==' ') ) {s = 1;}
						else if ( (LA18_1=='h') ) {s = 3;}
						 
						input.seek(index18_1);
						if ( s>=0 ) return s;
						break;
					case 1 : 
						int LA18_0 = input.LA(1);
						 
						int index18_0 = input.index();
						input.rewind();
						s = -1;
						if ( (LA18_0=='\t'||LA18_0==' ') ) {s = 1;}
						else if ( (LA18_0=='-') && (synpred3_LKC())) {s = 2;}
						else if ( (LA18_0=='h') ) {s = 3;}
						 
						input.seek(index18_0);
						if ( s>=0 ) return s;
						break;
			}
			if (state.backtracking>0) {state.failed=true; return -1;}
			NoViableAltException nvae =
				new NoViableAltException(getDescription(), 18, _s, input);
			error(nvae);
			throw nvae;
		}
	}

	static final String DFA25_eotS =
		"\1\uffff\2\4\2\uffff";
	static final String DFA25_eofS =
		"\5\uffff";
	static final String DFA25_minS =
		"\1\43\2\0\2\uffff";
	static final String DFA25_maxS =
		"\1\43\2\uffff\2\uffff";
	static final String DFA25_acceptS =
		"\3\uffff\1\1\1\2";
	static final String DFA25_specialS =
		"\1\uffff\1\1\1\0\2\uffff}>";
	static final String[] DFA25_transitionS = {
			"\1\1",
			"\12\2\1\3\ufff5\2",
			"\12\2\1\3\ufff5\2",
			"",
			""
	};

	static final short[] DFA25_eot = DFA.unpackEncodedString(DFA25_eotS);
	static final short[] DFA25_eof = DFA.unpackEncodedString(DFA25_eofS);
	static final char[] DFA25_min = DFA.unpackEncodedStringToUnsignedChars(DFA25_minS);
	static final char[] DFA25_max = DFA.unpackEncodedStringToUnsignedChars(DFA25_maxS);
	static final short[] DFA25_accept = DFA.unpackEncodedString(DFA25_acceptS);
	static final short[] DFA25_special = DFA.unpackEncodedString(DFA25_specialS);
	static final short[][] DFA25_transition;

	static {
		int numStates = DFA25_transitionS.length;
		DFA25_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA25_transition[i] = DFA.unpackEncodedString(DFA25_transitionS[i]);
		}
	}

	protected class DFA25 extends DFA {

		public DFA25(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 25;
			this.eot = DFA25_eot;
			this.eof = DFA25_eof;
			this.min = DFA25_min;
			this.max = DFA25_max;
			this.accept = DFA25_accept;
			this.special = DFA25_special;
			this.transition = DFA25_transition;
		}
		@Override
		public String getDescription() {
			return "403:1: SL_COMMENT : ({...}? => '#' (~ ( '\\n' ) )* ( '\\n' )+ | '#' (~ ( '\\n' ) )* );";
		}
		@Override
		public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
			IntStream input = _input;
			int _s = s;
			switch ( s ) {
					case 0 : 
						int LA25_2 = input.LA(1);
						 
						int index25_2 = input.index();
						input.rewind();
						s = -1;
						if ( (LA25_2=='\n') && ((startPos==0))) {s = 3;}
						else if ( ((LA25_2 >= '\u0000' && LA25_2 <= '\t')||(LA25_2 >= '\u000B' && LA25_2 <= '\uFFFF')) ) {s = 2;}
						else s = 4;
						 
						input.seek(index25_2);
						if ( s>=0 ) return s;
						break;
					case 1 : 
						int LA25_1 = input.LA(1);
						 
						int index25_1 = input.index();
						input.rewind();
						s = -1;
						if ( ((LA25_1 >= '\u0000' && LA25_1 <= '\t')||(LA25_1 >= '\u000B' && LA25_1 <= '\uFFFF')) ) {s = 2;}
						else if ( (LA25_1=='\n') && ((startPos==0))) {s = 3;}
						else s = 4;
						 
						input.seek(index25_1);
						if ( s>=0 ) return s;
						break;
			}
			if (state.backtracking>0) {state.failed=true; return -1;}
			NoViableAltException nvae =
				new NoViableAltException(getDescription(), 25, _s, input);
			error(nvae);
			throw nvae;
		}
	}

	static final String DFA26_eotS =
		"\1\uffff\1\36\1\32\6\uffff\4\32\2\uffff\7\32\2\uffff\1\64\1\72\5\uffff"+
		"\1\74\3\32\1\101\12\32\1\117\3\32\4\uffff\2\124\1\64\2\uffff\1\74\1\uffff"+
		"\1\135\2\32\1\140\1\uffff\12\32\1\155\2\32\1\uffff\3\32\3\uffff\5\124"+
		"\3\uffff\1\166\1\170\1\uffff\5\32\1\177\6\32\1\uffff\7\32\1\124\1\uffff"+
		"\1\32\1\uffff\6\32\1\uffff\5\32\1\u009b\6\32\1\u00a2\1\32\1\u00a4\1\32"+
		"\1\u00a6\1\u00a7\1\u00a8\3\32\1\u00ac\1\32\1\u00ae\2\32\1\uffff\5\32\1"+
		"\u00b7\1\uffff\1\u00b8\1\uffff\1\u00b9\3\uffff\3\32\1\uffff\1\u00bd\1"+
		"\uffff\1\32\1\u00bf\1\u00c0\1\u00c1\4\32\3\uffff\1\u00c6\1\u00c7\1\32"+
		"\1\uffff\1\32\3\uffff\1\u00c1\2\32\1\u00cc\2\uffff\1\32\1\u00ce\2\32\1"+
		"\uffff\1\u00d1\1\uffff\2\32\1\uffff\2\32\1\u00c1\2\32\1\u00d8\1\uffff";
	static final String DFA26_eofS =
		"\u00d9\uffff";
	static final String DFA26_minS =
		"\1\11\1\55\1\145\6\uffff\1\157\1\146\1\145\1\162\2\uffff\1\141\1\150\1"+
		"\156\1\145\1\156\1\141\1\162\1\146\1\uffff\2\11\5\uffff\1\11\1\154\1\157"+
		"\1\164\1\56\1\162\1\165\1\154\2\151\1\156\1\157\1\155\1\144\1\146\1\56"+
		"\1\164\1\156\1\157\2\uffff\1\0\2\12\1\0\1\11\1\uffff\1\0\1\11\1\uffff"+
		"\1\56\1\160\1\154\1\56\1\uffff\1\151\1\162\1\145\1\163\1\156\1\165\1\151"+
		"\1\155\1\146\1\143\1\56\1\145\1\137\1\uffff\1\151\1\147\1\155\3\uffff"+
		"\1\0\1\12\3\0\3\uffff\1\11\1\56\1\uffff\1\156\2\143\1\164\1\155\1\56\1"+
		"\143\1\145\1\151\1\150\1\145\1\146\1\uffff\1\156\1\165\1\142\2\157\1\145"+
		"\1\160\1\0\1\uffff\1\141\1\uffff\1\147\1\145\1\164\1\141\1\145\1\157\1"+
		"\uffff\1\145\1\156\1\147\1\157\1\156\1\56\1\144\1\154\1\157\1\162\2\156"+
		"\1\56\1\164\1\0\1\156\3\56\1\164\2\156\1\56\1\164\1\56\1\151\1\165\1\uffff"+
		"\1\163\1\164\1\157\1\151\1\146\1\56\1\uffff\1\56\1\0\1\56\3\uffff\1\145"+
		"\1\165\1\146\1\uffff\1\56\1\uffff\1\143\3\56\1\154\1\163\1\151\1\154\3"+
		"\uffff\2\56\1\151\1\uffff\1\145\3\uffff\1\56\1\164\1\147\1\56\2\uffff"+
		"\1\147\1\56\1\141\1\137\1\uffff\1\56\1\uffff\1\164\1\154\1\uffff\1\145"+
		"\1\151\1\56\1\163\1\164\1\56\1\uffff";
	static final String DFA26_maxS =
		"\1\176\1\71\1\145\6\uffff\1\157\1\156\1\164\1\162\2\uffff\1\145\1\157"+
		"\1\156\1\145\1\160\1\141\1\162\1\164\1\uffff\2\150\5\uffff\1\150\1\170"+
		"\1\157\1\164\1\172\1\162\1\165\1\154\2\151\1\156\1\157\1\156\1\166\1\160"+
		"\1\172\1\164\1\156\1\157\2\uffff\1\0\1\12\1\150\1\uffff\1\150\1\uffff"+
		"\1\0\1\150\1\uffff\1\172\1\160\1\154\1\172\1\uffff\1\151\1\162\1\145\1"+
		"\163\1\156\1\165\1\151\1\155\1\146\1\155\1\172\1\145\1\143\1\uffff\1\151"+
		"\1\147\1\155\3\uffff\1\uffff\1\150\3\uffff\3\uffff\2\172\1\uffff\1\156"+
		"\2\143\1\164\1\155\1\172\1\143\1\145\1\151\1\150\1\145\1\146\1\uffff\1"+
		"\156\1\165\1\164\2\157\1\145\1\160\1\uffff\1\uffff\1\141\1\uffff\1\147"+
		"\1\145\1\164\1\141\1\145\1\157\1\uffff\1\145\1\156\1\147\1\157\1\156\1"+
		"\172\1\144\1\154\1\157\1\162\2\156\1\172\1\164\1\uffff\1\156\3\172\1\164"+
		"\2\156\1\172\1\164\1\172\1\151\1\165\1\uffff\1\163\1\164\1\157\1\151\1"+
		"\146\1\172\1\uffff\1\172\1\0\1\172\3\uffff\1\145\1\165\1\146\1\uffff\1"+
		"\172\1\uffff\1\143\3\172\1\154\1\163\1\151\1\154\3\uffff\2\172\1\151\1"+
		"\uffff\1\145\3\uffff\1\172\1\164\1\147\1\172\2\uffff\1\147\1\172\1\141"+
		"\1\137\1\uffff\1\172\1\uffff\1\164\1\154\1\uffff\1\145\1\151\1\172\1\163"+
		"\1\164\1\172\1\uffff";
	static final String DFA26_acceptS =
		"\3\uffff\1\3\1\4\1\5\1\6\1\7\1\10\4\uffff\1\16\1\17\10\uffff\1\50\2\uffff"+
		"\1\54\1\55\1\56\1\61\1\1\23\uffff\1\46\1\47\5\uffff\1\60\2\uffff\1\57"+
		"\4\uffff\1\25\15\uffff\1\34\3\uffff\1\51\1\52\1\60\5\uffff\1\60\1\53\1"+
		"\2\2\uffff\1\13\14\uffff\1\43\10\uffff\1\40\1\uffff\1\11\6\uffff\1\23"+
		"\33\uffff\1\26\6\uffff\1\37\3\uffff\1\14\1\27\1\35\3\uffff\1\21\1\uffff"+
		"\1\31\10\uffff\1\42\1\41\1\12\3\uffff\1\30\1\uffff\1\24\1\33\1\36\4\uffff"+
		"\1\15\1\20\4\uffff\1\45\1\uffff\1\22\2\uffff\1\32\6\uffff\1\44";
	static final String DFA26_specialS =
		"\30\uffff\1\10\1\2\32\uffff\1\12\1\16\1\3\1\7\1\11\1\uffff\1\5\33\uffff"+
		"\1\14\1\4\1\17\1\0\1\15\32\uffff\1\1\30\uffff\1\6\25\uffff\1\13\64\uffff}>";
	static final String[] DFA26_transitionS = {
			"\1\31\1\27\2\uffff\1\27\22\uffff\1\30\1\3\1\33\1\35\1\26\1\uffff\1\4"+
			"\1\33\1\5\1\6\3\uffff\1\1\14\32\1\uffff\1\7\1\uffff\1\10\3\uffff\32\32"+
			"\1\uffff\1\34\2\uffff\1\32\1\uffff\1\32\1\11\1\20\1\22\1\21\2\32\1\2"+
			"\1\12\3\32\1\17\1\32\1\23\1\25\1\32\1\24\1\13\1\14\6\32\1\uffff\1\15"+
			"\1\uffff\1\16",
			"\1\37\2\uffff\12\32",
			"\1\40",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\41",
			"\1\43\7\uffff\1\42",
			"\1\46\11\uffff\1\45\4\uffff\1\44",
			"\1\47",
			"",
			"",
			"\1\50\3\uffff\1\51",
			"\1\52\6\uffff\1\53",
			"\1\54",
			"\1\55",
			"\1\56\1\uffff\1\57",
			"\1\60",
			"\1\61",
			"\1\62\15\uffff\1\63",
			"",
			"\1\70\1\66\2\uffff\1\65\22\uffff\1\30\2\uffff\1\67\11\uffff\1\71\72"+
			"\uffff\1\71",
			"\1\70\1\66\2\uffff\1\65\22\uffff\1\30\2\uffff\1\67\11\uffff\1\71\72"+
			"\uffff\1\71",
			"",
			"",
			"",
			"",
			"",
			"\1\71\26\uffff\1\71\14\uffff\1\73\72\uffff\1\71",
			"\1\76\13\uffff\1\75",
			"\1\77",
			"\1\100",
			"\14\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
			"\1\102",
			"\1\103",
			"\1\104",
			"\1\105",
			"\1\106",
			"\1\107",
			"\1\110",
			"\1\111\1\112",
			"\1\113\21\uffff\1\114",
			"\1\116\11\uffff\1\115",
			"\14\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
			"\1\120",
			"\1\121",
			"\1\122",
			"",
			"",
			"\1\uffff",
			"\1\66",
			"\1\66\2\uffff\1\65\25\uffff\1\67\104\uffff\1\125",
			"\12\132\1\127\2\132\1\126\25\132\1\130\104\132\1\131\uff97\132",
			"\1\70\1\66\2\uffff\1\65\22\uffff\1\30\2\uffff\1\67\11\uffff\1\133\72"+
			"\uffff\1\71",
			"",
			"\1\uffff",
			"\1\133\26\uffff\1\133\107\uffff\1\133",
			"",
			"\14\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
			"\1\136",
			"\1\137",
			"\14\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
			"",
			"\1\141",
			"\1\142",
			"\1\143",
			"\1\144",
			"\1\145",
			"\1\146",
			"\1\147",
			"\1\150",
			"\1\151",
			"\1\152\5\uffff\1\154\3\uffff\1\153",
			"\14\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
			"\1\156",
			"\1\160\1\uffff\1\157\1\uffff\1\161",
			"",
			"\1\162",
			"\1\163",
			"\1\164",
			"",
			"",
			"",
			"\12\132\1\127\2\132\1\126\25\132\1\130\104\132\1\131\uff97\132",
			"\1\127\2\uffff\1\65\25\uffff\1\67\104\uffff\1\125",
			"\12\132\1\127\2\132\1\126\25\132\1\130\104\132\1\131\uff97\132",
			"\12\132\1\127\2\132\1\126\25\132\1\130\101\132\1\165\2\132\1\131\uff97"+
			"\132",
			"\12\132\1\127\2\132\1\126\25\132\1\130\104\132\1\131\uff97\132",
			"",
			"",
			"",
			"\2\133\2\uffff\1\133\22\uffff\1\133\15\uffff\14\32\7\uffff\32\32\4\uffff"+
			"\1\32\1\uffff\32\32",
			"\14\32\7\uffff\32\32\4\uffff\1\32\1\uffff\4\32\1\167\25\32",
			"",
			"\1\171",
			"\1\172",
			"\1\173",
			"\1\174",
			"\1\175",
			"\14\32\7\uffff\32\32\4\uffff\1\32\1\uffff\2\32\1\176\27\32",
			"\1\u0080",
			"\1\u0081",
			"\1\u0082",
			"\1\u0083",
			"\1\u0084",
			"\1\u0085",
			"",
			"\1\u0086",
			"\1\u0087",
			"\1\u0088\21\uffff\1\u0089",
			"\1\u008a",
			"\1\u008b",
			"\1\u008c",
			"\1\u008d",
			"\12\132\1\127\2\132\1\126\25\132\1\130\104\132\1\131\17\132\1\u008e"+
			"\uff87\132",
			"",
			"\1\u008f",
			"",
			"\1\u0090",
			"\1\u0091",
			"\1\u0092",
			"\1\u0093",
			"\1\u0094",
			"\1\u0095",
			"",
			"\1\u0096",
			"\1\u0097",
			"\1\u0098",
			"\1\u0099",
			"\1\u009a",
			"\14\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
			"\1\u009c",
			"\1\u009d",
			"\1\u009e",
			"\1\u009f",
			"\1\u00a0",
			"\1\u00a1",
			"\14\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
			"\1\u00a3",
			"\12\132\1\127\2\132\1\126\25\132\1\130\104\132\1\131\uff97\132",
			"\1\u00a5",
			"\14\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
			"\14\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
			"\14\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
			"\1\u00a9",
			"\1\u00aa",
			"\1\u00ab",
			"\14\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
			"\1\u00ad",
			"\14\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
			"\1\u00af",
			"\1\u00b0",
			"",
			"\1\u00b1",
			"\1\u00b2",
			"\1\u00b3",
			"\1\u00b4",
			"\1\u00b5",
			"\14\32\7\uffff\32\32\4\uffff\1\32\1\uffff\1\u00b6\31\32",
			"",
			"\14\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
			"\1\uffff",
			"\14\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
			"",
			"",
			"",
			"\1\u00ba",
			"\1\u00bb",
			"\1\u00bc",
			"",
			"\14\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
			"",
			"\1\u00be",
			"\14\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
			"\14\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
			"\14\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
			"\1\u00c2",
			"\1\u00c3",
			"\1\u00c4",
			"\1\u00c5",
			"",
			"",
			"",
			"\14\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
			"\14\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
			"\1\u00c8",
			"",
			"\1\u00c9",
			"",
			"",
			"",
			"\14\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
			"\1\u00ca",
			"\1\u00cb",
			"\14\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
			"",
			"",
			"\1\u00cd",
			"\14\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
			"\1\u00cf",
			"\1\u00d0",
			"",
			"\14\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
			"",
			"\1\u00d2",
			"\1\u00d3",
			"",
			"\1\u00d4",
			"\1\u00d5",
			"\14\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
			"\1\u00d6",
			"\1\u00d7",
			"\14\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
			""
	};

	static final short[] DFA26_eot = DFA.unpackEncodedString(DFA26_eotS);
	static final short[] DFA26_eof = DFA.unpackEncodedString(DFA26_eofS);
	static final char[] DFA26_min = DFA.unpackEncodedStringToUnsignedChars(DFA26_minS);
	static final char[] DFA26_max = DFA.unpackEncodedStringToUnsignedChars(DFA26_maxS);
	static final short[] DFA26_accept = DFA.unpackEncodedString(DFA26_acceptS);
	static final short[] DFA26_special = DFA.unpackEncodedString(DFA26_specialS);
	static final short[][] DFA26_transition;

	static {
		int numStates = DFA26_transitionS.length;
		DFA26_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA26_transition[i] = DFA.unpackEncodedString(DFA26_transitionS[i]);
		}
	}

	protected class DFA26 extends DFA {

		public DFA26(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 26;
			this.eot = DFA26_eot;
			this.eof = DFA26_eof;
			this.min = DFA26_min;
			this.max = DFA26_max;
			this.accept = DFA26_accept;
			this.special = DFA26_special;
			this.transition = DFA26_transition;
		}
		@Override
		public String getDescription() {
			return "1:1: Tokens : ( DASH | HEX | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | MAINMENU | CHOICE | ENDCHOICE | MENU | ENDMENU | IF | ENDIF | SOURCE | COMMENT | CONFIG | MENUCONFIG | DEPENDS | ON | SELECT | DEFAULT | RANGE | HELP | PROMPT | OPTION | ENV | DEFCONFIG_LIST | OPTIONAL | FALSE | TRUE | NEWLINE | WS | LEADING_WS | INDENT | WORD | WORD_QUOTE | CONTINUE | DASHES | HEX_OR_HELP | SL_COMMENT );";
		}
		@Override
		public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
			IntStream input = _input;
			int _s = s;
			switch ( s ) {
					case 0 : 
						int LA26_89 = input.LA(1);
						 
						int index26_89 = input.index();
						input.rewind();
						s = -1;
						if ( (LA26_89=='e') && ((startPos==0))) {s = 117;}
						else if ( (LA26_89=='\n') && ((startPos==0))) {s = 87;}
						else if ( (LA26_89=='\r') && ((startPos==0))) {s = 86;}
						else if ( (LA26_89=='#') && ((startPos==0))) {s = 88;}
						else if ( (LA26_89=='h') && ((startPos==0))) {s = 89;}
						else if ( ((LA26_89 >= '\u0000' && LA26_89 <= '\t')||(LA26_89 >= '\u000B' && LA26_89 <= '\f')||(LA26_89 >= '\u000E' && LA26_89 <= '\"')||(LA26_89 >= '$' && LA26_89 <= 'd')||(LA26_89 >= 'f' && LA26_89 <= 'g')||(LA26_89 >= 'i' && LA26_89 <= '\uFFFF')) && ((startPos==0))) {s = 90;}
						else s = 84;
						 
						input.seek(index26_89);
						if ( s>=0 ) return s;
						break;
					case 1 : 
						int LA26_117 = input.LA(1);
						 
						int index26_117 = input.index();
						input.rewind();
						s = -1;
						if ( (LA26_117=='x') && ((startPos==0))) {s = 142;}
						else if ( (LA26_117=='\n') && ((startPos==0))) {s = 87;}
						else if ( (LA26_117=='\r') && ((startPos==0))) {s = 86;}
						else if ( (LA26_117=='#') && ((startPos==0))) {s = 88;}
						else if ( (LA26_117=='h') && ((startPos==0))) {s = 89;}
						else if ( ((LA26_117 >= '\u0000' && LA26_117 <= '\t')||(LA26_117 >= '\u000B' && LA26_117 <= '\f')||(LA26_117 >= '\u000E' && LA26_117 <= '\"')||(LA26_117 >= '$' && LA26_117 <= 'g')||(LA26_117 >= 'i' && LA26_117 <= 'w')||(LA26_117 >= 'y' && LA26_117 <= '\uFFFF')) && ((startPos==0))) {s = 90;}
						else s = 84;
						 
						input.seek(index26_117);
						if ( s>=0 ) return s;
						break;
					case 2 : 
						int LA26_25 = input.LA(1);
						 
						int index26_25 = input.index();
						input.rewind();
						s = -1;
						if ( (LA26_25==' ') ) {s = 24;}
						else if ( (LA26_25=='\r') && ((startPos==0))) {s = 53;}
						else if ( (LA26_25=='\n') && ((startPos==0))) {s = 54;}
						else if ( (LA26_25=='#') && ((startPos==0))) {s = 55;}
						else if ( (LA26_25=='\t') ) {s = 56;}
						else if ( (LA26_25=='-'||LA26_25=='h') ) {s = 57;}
						else s = 58;
						 
						input.seek(index26_25);
						if ( s>=0 ) return s;
						break;
					case 3 : 
						int LA26_54 = input.LA(1);
						 
						int index26_54 = input.index();
						input.rewind();
						s = -1;
						if ( (LA26_54=='\r') && ((startPos==0))) {s = 53;}
						else if ( (LA26_54=='\n') && ((startPos==0))) {s = 54;}
						else if ( (LA26_54=='#') && ((startPos==0))) {s = 55;}
						else if ( (LA26_54=='h') && ((startPos==0))) {s = 85;}
						else s = 84;
						 
						input.seek(index26_54);
						if ( s>=0 ) return s;
						break;
					case 4 : 
						int LA26_87 = input.LA(1);
						 
						int index26_87 = input.index();
						input.rewind();
						s = -1;
						if ( (LA26_87=='\r') && ((startPos==0))) {s = 53;}
						else if ( (LA26_87=='\n') && ((startPos==0))) {s = 87;}
						else if ( (LA26_87=='#') && ((startPos==0))) {s = 55;}
						else if ( (LA26_87=='h') && ((startPos==0))) {s = 85;}
						else s = 84;
						 
						input.seek(index26_87);
						if ( s>=0 ) return s;
						break;
					case 5 : 
						int LA26_58 = input.LA(1);
						 
						int index26_58 = input.index();
						input.rewind();
						s = -1;
						if ( ((startPos>0)) ) {s = 83;}
						else if ( ((startPos==0)) ) {s = 84;}
						else if ( (true) ) {s = 92;}
						 
						input.seek(index26_58);
						if ( s>=0 ) return s;
						break;
					case 6 : 
						int LA26_142 = input.LA(1);
						 
						int index26_142 = input.index();
						input.rewind();
						s = -1;
						if ( (LA26_142=='\n') && ((startPos==0))) {s = 87;}
						else if ( (LA26_142=='\r') && ((startPos==0))) {s = 86;}
						else if ( (LA26_142=='#') && ((startPos==0))) {s = 88;}
						else if ( (LA26_142=='h') && ((startPos==0))) {s = 89;}
						else if ( ((LA26_142 >= '\u0000' && LA26_142 <= '\t')||(LA26_142 >= '\u000B' && LA26_142 <= '\f')||(LA26_142 >= '\u000E' && LA26_142 <= '\"')||(LA26_142 >= '$' && LA26_142 <= 'g')||(LA26_142 >= 'i' && LA26_142 <= '\uFFFF')) && ((startPos==0))) {s = 90;}
						else s = 164;
						 
						input.seek(index26_142);
						if ( s>=0 ) return s;
						break;
					case 7 : 
						int LA26_55 = input.LA(1);
						 
						int index26_55 = input.index();
						input.rewind();
						s = -1;
						if ( (LA26_55=='\r') && ((startPos==0))) {s = 86;}
						else if ( (LA26_55=='\n') && ((startPos==0))) {s = 87;}
						else if ( (LA26_55=='#') && ((startPos==0))) {s = 88;}
						else if ( (LA26_55=='h') && ((startPos==0))) {s = 89;}
						else if ( ((LA26_55 >= '\u0000' && LA26_55 <= '\t')||(LA26_55 >= '\u000B' && LA26_55 <= '\f')||(LA26_55 >= '\u000E' && LA26_55 <= '\"')||(LA26_55 >= '$' && LA26_55 <= 'g')||(LA26_55 >= 'i' && LA26_55 <= '\uFFFF')) && ((startPos==0))) {s = 90;}
						else s = 84;
						 
						input.seek(index26_55);
						if ( s>=0 ) return s;
						break;
					case 8 : 
						int LA26_24 = input.LA(1);
						 
						int index26_24 = input.index();
						input.rewind();
						s = -1;
						if ( (LA26_24==' ') ) {s = 24;}
						else if ( (LA26_24=='\r') && ((startPos==0))) {s = 53;}
						else if ( (LA26_24=='\n') && ((startPos==0))) {s = 54;}
						else if ( (LA26_24=='#') && ((startPos==0))) {s = 55;}
						else if ( (LA26_24=='\t') ) {s = 56;}
						else if ( (LA26_24=='-'||LA26_24=='h') ) {s = 57;}
						else s = 52;
						 
						input.seek(index26_24);
						if ( s>=0 ) return s;
						break;
					case 9 : 
						int LA26_56 = input.LA(1);
						 
						int index26_56 = input.index();
						input.rewind();
						s = -1;
						if ( (LA26_56==' ') ) {s = 24;}
						else if ( (LA26_56=='\r') && ((startPos==0))) {s = 53;}
						else if ( (LA26_56=='\n') && ((startPos==0))) {s = 54;}
						else if ( (LA26_56=='#') && ((startPos==0))) {s = 55;}
						else if ( (LA26_56=='\t') ) {s = 56;}
						else if ( (LA26_56=='h') ) {s = 57;}
						else if ( (LA26_56=='-') ) {s = 91;}
						else s = 52;
						 
						input.seek(index26_56);
						if ( s>=0 ) return s;
						break;
					case 10 : 
						int LA26_52 = input.LA(1);
						 
						int index26_52 = input.index();
						input.rewind();
						s = -1;
						if ( ((startPos>0)) ) {s = 83;}
						else if ( ((startPos==0)) ) {s = 84;}
						 
						input.seek(index26_52);
						if ( s>=0 ) return s;
						break;
					case 11 : 
						int LA26_164 = input.LA(1);
						 
						int index26_164 = input.index();
						input.rewind();
						s = -1;
						if ( ((startPos==0)) ) {s = 84;}
						else if ( ((startPos==0)) ) {s = 91;}
						 
						input.seek(index26_164);
						if ( s>=0 ) return s;
						break;
					case 12 : 
						int LA26_86 = input.LA(1);
						 
						int index26_86 = input.index();
						input.rewind();
						s = -1;
						if ( (LA26_86=='\n') && ((startPos==0))) {s = 87;}
						else if ( (LA26_86=='\r') && ((startPos==0))) {s = 86;}
						else if ( (LA26_86=='#') && ((startPos==0))) {s = 88;}
						else if ( (LA26_86=='h') && ((startPos==0))) {s = 89;}
						else if ( ((LA26_86 >= '\u0000' && LA26_86 <= '\t')||(LA26_86 >= '\u000B' && LA26_86 <= '\f')||(LA26_86 >= '\u000E' && LA26_86 <= '\"')||(LA26_86 >= '$' && LA26_86 <= 'g')||(LA26_86 >= 'i' && LA26_86 <= '\uFFFF')) && ((startPos==0))) {s = 90;}
						else s = 84;
						 
						input.seek(index26_86);
						if ( s>=0 ) return s;
						break;
					case 13 : 
						int LA26_90 = input.LA(1);
						 
						int index26_90 = input.index();
						input.rewind();
						s = -1;
						if ( (LA26_90=='\n') && ((startPos==0))) {s = 87;}
						else if ( (LA26_90=='\r') && ((startPos==0))) {s = 86;}
						else if ( (LA26_90=='#') && ((startPos==0))) {s = 88;}
						else if ( (LA26_90=='h') && ((startPos==0))) {s = 89;}
						else if ( ((LA26_90 >= '\u0000' && LA26_90 <= '\t')||(LA26_90 >= '\u000B' && LA26_90 <= '\f')||(LA26_90 >= '\u000E' && LA26_90 <= '\"')||(LA26_90 >= '$' && LA26_90 <= 'g')||(LA26_90 >= 'i' && LA26_90 <= '\uFFFF')) && ((startPos==0))) {s = 90;}
						else s = 84;
						 
						input.seek(index26_90);
						if ( s>=0 ) return s;
						break;
					case 14 : 
						int LA26_53 = input.LA(1);
						 
						int index26_53 = input.index();
						input.rewind();
						s = -1;
						if ( (LA26_53=='\n') && ((startPos==0))) {s = 54;}
						 
						input.seek(index26_53);
						if ( s>=0 ) return s;
						break;
					case 15 : 
						int LA26_88 = input.LA(1);
						 
						int index26_88 = input.index();
						input.rewind();
						s = -1;
						if ( (LA26_88=='\n') && ((startPos==0))) {s = 87;}
						else if ( (LA26_88=='\r') && ((startPos==0))) {s = 86;}
						else if ( (LA26_88=='#') && ((startPos==0))) {s = 88;}
						else if ( (LA26_88=='h') && ((startPos==0))) {s = 89;}
						else if ( ((LA26_88 >= '\u0000' && LA26_88 <= '\t')||(LA26_88 >= '\u000B' && LA26_88 <= '\f')||(LA26_88 >= '\u000E' && LA26_88 <= '\"')||(LA26_88 >= '$' && LA26_88 <= 'g')||(LA26_88 >= 'i' && LA26_88 <= '\uFFFF')) && ((startPos==0))) {s = 90;}
						else s = 84;
						 
						input.seek(index26_88);
						if ( s>=0 ) return s;
						break;
			}
			if (state.backtracking>0) {state.failed=true; return -1;}
			NoViableAltException nvae =
				new NoViableAltException(getDescription(), 26, _s, input);
			error(nvae);
			throw nvae;
		}
	}

	static final String DFA27_eotS =
		"\2\2\2\uffff";
	static final String DFA27_eofS =
		"\4\uffff";
	static final String DFA27_minS =
		"\2\11\2\uffff";
	static final String DFA27_maxS =
		"\2\40\2\uffff";
	static final String DFA27_acceptS =
		"\2\uffff\1\1\1\2";
	static final String DFA27_specialS =
		"\4\uffff}>";
	static final String[] DFA27_transitionS = {
			"\1\1\1\3\25\uffff\1\1",
			"\1\1\1\3\25\uffff\1\1",
			"",
			""
	};

	static final short[] DFA27_eot = DFA.unpackEncodedString(DFA27_eotS);
	static final short[] DFA27_eof = DFA.unpackEncodedString(DFA27_eofS);
	static final char[] DFA27_min = DFA.unpackEncodedStringToUnsignedChars(DFA27_minS);
	static final char[] DFA27_max = DFA.unpackEncodedStringToUnsignedChars(DFA27_maxS);
	static final short[] DFA27_accept = DFA.unpackEncodedString(DFA27_acceptS);
	static final short[] DFA27_special = DFA.unpackEncodedString(DFA27_specialS);
	static final short[][] DFA27_transition;

	static {
		int numStates = DFA27_transitionS.length;
		DFA27_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA27_transition[i] = DFA.unpackEncodedString(DFA27_transitionS[i]);
		}
	}

	protected class DFA27 extends DFA {

		public DFA27(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 27;
			this.eot = DFA27_eot;
			this.eof = DFA27_eof;
			this.min = DFA27_min;
			this.max = DFA27_max;
			this.accept = DFA27_accept;
			this.special = DFA27_special;
			this.transition = DFA27_transition;
		}
		@Override
		public String getDescription() {
			return "394:12: fragment synpred4_LKC : (next= HELP_WS {...}?|{...}? HELP_WS '\\n' );";
		}
	}

}
