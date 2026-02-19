// Generated from parser/LamaLanguage.g4 by ANTLR 4.13.2
package com.oracle.truffle.lama.parser;



import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class LamaLanguageParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		WHITESPACE=1, NOP=2, IF=3, THEN=4, ELSE=5, ELIF=6, FI=7, CASE=8, OF=9, 
		ESAC=10, WHILE=11, DO=12, OD=13, FOR=14, LET=15, IN=16, VAR=17, FUN=18, 
		TRUE=19, FALSE=20, STRING=21, CHARACTER=22, INTEGER=23, LIDENT=24, UIDENT=25, 
		OP_ASSN1=26, OP_ASSN2=27, OP_OR=28, OP_AND=29, OP_CMP=30, OP_ADD=31, OP_MUL=32, 
		LPAR=33, RPAR=34, LBRKT=35, RBRKT=36, LCB=37, RCB=38, COMMA=39, CLN=40, 
		SCLN=41, SQUOTE=42, DQUOTE=43, DOT=44, ALIAS=45, RARROW=46, VBAR=47, ASSERT_VAL=48, 
		ASSERT_FUN=49, ASSERT_STR=50;
	public static final int
		RULE_lamaLanguage = 0, RULE_scopeExp = 1, RULE_oneVarDef = 2, RULE_definition = 3, 
		RULE_lidentList0 = 4, RULE_expList0 = 5, RULE_expList = 6, RULE_exp = 7, 
		RULE_basic = 8, RULE_basicCons = 9, RULE_basicOr = 10, RULE_basicAnd = 11, 
		RULE_basicCmp = 12, RULE_basicAdd = 13, RULE_basicMul = 14, RULE_basicUnary = 15, 
		RULE_postfix = 16, RULE_primary = 17, RULE_sexp = 18, RULE_array = 19, 
		RULE_list = 20, RULE_literal = 21, RULE_strlit = 22, RULE_chrlit = 23, 
		RULE_intlit = 24, RULE_blit = 25, RULE_parentheses = 26, RULE_nop = 27, 
		RULE_whileLoop = 28, RULE_doWhileLoop = 29, RULE_forLoop = 30, RULE_ifStmt = 31, 
		RULE_caseStmt = 32, RULE_caseOption = 33, RULE_lambda = 34, RULE_pattern = 35, 
		RULE_nonConsPattern = 36, RULE_patternList0 = 37, RULE_patternList = 38, 
		RULE_parenthesesPattern = 39, RULE_literalPattern = 40, RULE_varPattern = 41, 
		RULE_sexpPattern = 42, RULE_arrayPattern = 43, RULE_listPattern = 44, 
		RULE_assertFunPattern = 45, RULE_assertValPattern = 46, RULE_assertStrPattern = 47;
	private static String[] makeRuleNames() {
		return new String[] {
			"lamaLanguage", "scopeExp", "oneVarDef", "definition", "lidentList0", 
			"expList0", "expList", "exp", "basic", "basicCons", "basicOr", "basicAnd", 
			"basicCmp", "basicAdd", "basicMul", "basicUnary", "postfix", "primary", 
			"sexp", "array", "list", "literal", "strlit", "chrlit", "intlit", "blit", 
			"parentheses", "nop", "whileLoop", "doWhileLoop", "forLoop", "ifStmt", 
			"caseStmt", "caseOption", "lambda", "pattern", "nonConsPattern", "patternList0", 
			"patternList", "parenthesesPattern", "literalPattern", "varPattern", 
			"sexpPattern", "arrayPattern", "listPattern", "assertFunPattern", "assertValPattern", 
			"assertStrPattern"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, "'skip'", "'if'", "'then'", "'else'", "'elif'", "'fi'", "'case'", 
			"'of'", "'esac'", "'while'", "'do'", "'od'", "'for'", "'let'", "'in'", 
			"'var'", "'fun'", "'true'", "'false'", null, null, null, null, null, 
			"'='", "':='", "'!!'", "'&&'", null, null, null, "'('", "')'", "'['", 
			"']'", "'{'", "'}'", "','", "':'", "';'", "'''", "'\"'", "'.'", "'@'", 
			"'->'", "'|'", "'#val'", "'#fun'", "'#str'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "WHITESPACE", "NOP", "IF", "THEN", "ELSE", "ELIF", "FI", "CASE", 
			"OF", "ESAC", "WHILE", "DO", "OD", "FOR", "LET", "IN", "VAR", "FUN", 
			"TRUE", "FALSE", "STRING", "CHARACTER", "INTEGER", "LIDENT", "UIDENT", 
			"OP_ASSN1", "OP_ASSN2", "OP_OR", "OP_AND", "OP_CMP", "OP_ADD", "OP_MUL", 
			"LPAR", "RPAR", "LBRKT", "RBRKT", "LCB", "RCB", "COMMA", "CLN", "SCLN", 
			"SQUOTE", "DQUOTE", "DOT", "ALIAS", "RARROW", "VBAR", "ASSERT_VAL", "ASSERT_FUN", 
			"ASSERT_STR"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "LamaLanguage.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public LamaLanguageParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LamaLanguageContext extends ParserRuleContext {
		public ScopeExpContext scopeExp() {
			return getRuleContext(ScopeExpContext.class,0);
		}
		public TerminalNode EOF() { return getToken(LamaLanguageParser.EOF, 0); }
		public LamaLanguageContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lamaLanguage; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LamaLanguageVisitor ) return ((LamaLanguageVisitor<? extends T>)visitor).visitLamaLanguage(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LamaLanguageContext lamaLanguage() throws RecognitionException {
		LamaLanguageContext _localctx = new LamaLanguageContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_lamaLanguage);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(96);
			scopeExp();
			setState(97);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ScopeExpContext extends ParserRuleContext {
		public ExpContext body;
		public List<DefinitionContext> definition() {
			return getRuleContexts(DefinitionContext.class);
		}
		public DefinitionContext definition(int i) {
			return getRuleContext(DefinitionContext.class,i);
		}
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public ScopeExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_scopeExp; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LamaLanguageVisitor ) return ((LamaLanguageVisitor<? extends T>)visitor).visitScopeExp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ScopeExpContext scopeExp() throws RecognitionException {
		ScopeExpContext _localctx = new ScopeExpContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_scopeExp);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(102);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(99);
					definition();
					}
					} 
				}
				setState(104);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			setState(106);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				{
				setState(105);
				((ScopeExpContext)_localctx).body = exp();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class OneVarDefContext extends ParserRuleContext {
		public Token name;
		public BasicContext assignedValue;
		public TerminalNode LIDENT() { return getToken(LamaLanguageParser.LIDENT, 0); }
		public TerminalNode OP_ASSN1() { return getToken(LamaLanguageParser.OP_ASSN1, 0); }
		public BasicContext basic() {
			return getRuleContext(BasicContext.class,0);
		}
		public OneVarDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oneVarDef; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LamaLanguageVisitor ) return ((LamaLanguageVisitor<? extends T>)visitor).visitOneVarDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OneVarDefContext oneVarDef() throws RecognitionException {
		OneVarDefContext _localctx = new OneVarDefContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_oneVarDef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(108);
			((OneVarDefContext)_localctx).name = match(LIDENT);
			setState(111);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OP_ASSN1) {
				{
				setState(109);
				match(OP_ASSN1);
				setState(110);
				((OneVarDefContext)_localctx).assignedValue = basic();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DefinitionContext extends ParserRuleContext {
		public DefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_definition; }
	 
		public DefinitionContext() { }
		public void copyFrom(DefinitionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FunDefinitionContext extends DefinitionContext {
		public Token name;
		public LidentList0Context args;
		public ScopeExpContext body;
		public TerminalNode FUN() { return getToken(LamaLanguageParser.FUN, 0); }
		public TerminalNode LPAR() { return getToken(LamaLanguageParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(LamaLanguageParser.RPAR, 0); }
		public TerminalNode LCB() { return getToken(LamaLanguageParser.LCB, 0); }
		public TerminalNode RCB() { return getToken(LamaLanguageParser.RCB, 0); }
		public TerminalNode LIDENT() { return getToken(LamaLanguageParser.LIDENT, 0); }
		public LidentList0Context lidentList0() {
			return getRuleContext(LidentList0Context.class,0);
		}
		public ScopeExpContext scopeExp() {
			return getRuleContext(ScopeExpContext.class,0);
		}
		public FunDefinitionContext(DefinitionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LamaLanguageVisitor ) return ((LamaLanguageVisitor<? extends T>)visitor).visitFunDefinition(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class VarDefinitionContext extends DefinitionContext {
		public OneVarDefContext firstdef;
		public TerminalNode VAR() { return getToken(LamaLanguageParser.VAR, 0); }
		public TerminalNode SCLN() { return getToken(LamaLanguageParser.SCLN, 0); }
		public List<OneVarDefContext> oneVarDef() {
			return getRuleContexts(OneVarDefContext.class);
		}
		public OneVarDefContext oneVarDef(int i) {
			return getRuleContext(OneVarDefContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(LamaLanguageParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(LamaLanguageParser.COMMA, i);
		}
		public VarDefinitionContext(DefinitionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LamaLanguageVisitor ) return ((LamaLanguageVisitor<? extends T>)visitor).visitVarDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DefinitionContext definition() throws RecognitionException {
		DefinitionContext _localctx = new DefinitionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_definition);
		int _la;
		try {
			setState(133);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VAR:
				_localctx = new VarDefinitionContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(113);
				match(VAR);
				setState(114);
				((VarDefinitionContext)_localctx).firstdef = oneVarDef();
				setState(119);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(115);
					match(COMMA);
					setState(116);
					oneVarDef();
					}
					}
					setState(121);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(122);
				match(SCLN);
				}
				break;
			case FUN:
				_localctx = new FunDefinitionContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(124);
				match(FUN);
				setState(125);
				((FunDefinitionContext)_localctx).name = match(LIDENT);
				setState(126);
				match(LPAR);
				setState(127);
				((FunDefinitionContext)_localctx).args = lidentList0();
				setState(128);
				match(RPAR);
				setState(129);
				match(LCB);
				setState(130);
				((FunDefinitionContext)_localctx).body = scopeExp();
				setState(131);
				match(RCB);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LidentList0Context extends ParserRuleContext {
		public Token hd;
		public List<TerminalNode> LIDENT() { return getTokens(LamaLanguageParser.LIDENT); }
		public TerminalNode LIDENT(int i) {
			return getToken(LamaLanguageParser.LIDENT, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(LamaLanguageParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(LamaLanguageParser.COMMA, i);
		}
		public LidentList0Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lidentList0; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LamaLanguageVisitor ) return ((LamaLanguageVisitor<? extends T>)visitor).visitLidentList0(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LidentList0Context lidentList0() throws RecognitionException {
		LidentList0Context _localctx = new LidentList0Context(_ctx, getState());
		enterRule(_localctx, 8, RULE_lidentList0);
		int _la;
		try {
			setState(144);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case RPAR:
				enterOuterAlt(_localctx, 1);
				{
				}
				break;
			case LIDENT:
				enterOuterAlt(_localctx, 2);
				{
				setState(136);
				((LidentList0Context)_localctx).hd = match(LIDENT);
				setState(141);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(137);
					match(COMMA);
					setState(138);
					match(LIDENT);
					}
					}
					setState(143);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExpList0Context extends ParserRuleContext {
		public ExpContext hd;
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(LamaLanguageParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(LamaLanguageParser.COMMA, i);
		}
		public ExpList0Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expList0; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LamaLanguageVisitor ) return ((LamaLanguageVisitor<? extends T>)visitor).visitExpList0(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpList0Context expList0() throws RecognitionException {
		ExpList0Context _localctx = new ExpList0Context(_ctx, getState());
		enterRule(_localctx, 10, RULE_expList0);
		int _la;
		try {
			setState(155);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case RPAR:
			case RBRKT:
			case RCB:
				enterOuterAlt(_localctx, 1);
				{
				}
				break;
			case NOP:
			case IF:
			case CASE:
			case WHILE:
			case DO:
			case FOR:
			case LET:
			case FUN:
			case TRUE:
			case FALSE:
			case STRING:
			case CHARACTER:
			case INTEGER:
			case LIDENT:
			case UIDENT:
			case OP_ADD:
			case LPAR:
			case LBRKT:
			case LCB:
				enterOuterAlt(_localctx, 2);
				{
				setState(147);
				((ExpList0Context)_localctx).hd = exp();
				setState(152);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(148);
					match(COMMA);
					setState(149);
					exp();
					}
					}
					setState(154);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExpListContext extends ParserRuleContext {
		public ExpContext hd;
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(LamaLanguageParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(LamaLanguageParser.COMMA, i);
		}
		public ExpListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expList; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LamaLanguageVisitor ) return ((LamaLanguageVisitor<? extends T>)visitor).visitExpList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpListContext expList() throws RecognitionException {
		ExpListContext _localctx = new ExpListContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_expList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(157);
			((ExpListContext)_localctx).hd = exp();
			setState(162);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(158);
				match(COMMA);
				setState(159);
				exp();
				}
				}
				setState(164);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExpContext extends ParserRuleContext {
		public ExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp; }
	 
		public ExpContext() { }
		public void copyFrom(ExpContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LetExpContext extends ExpContext {
		public ExpContext r;
		public TerminalNode LET() { return getToken(LamaLanguageParser.LET, 0); }
		public PatternContext pattern() {
			return getRuleContext(PatternContext.class,0);
		}
		public TerminalNode OP_ASSN1() { return getToken(LamaLanguageParser.OP_ASSN1, 0); }
		public BasicContext basic() {
			return getRuleContext(BasicContext.class,0);
		}
		public TerminalNode IN() { return getToken(LamaLanguageParser.IN, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public LetExpContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LamaLanguageVisitor ) return ((LamaLanguageVisitor<? extends T>)visitor).visitLetExp(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SingleExpContext extends ExpContext {
		public BasicContext basic() {
			return getRuleContext(BasicContext.class,0);
		}
		public SingleExpContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LamaLanguageVisitor ) return ((LamaLanguageVisitor<? extends T>)visitor).visitSingleExp(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SeqExpContext extends ExpContext {
		public BasicContext l;
		public ExpContext r;
		public TerminalNode SCLN() { return getToken(LamaLanguageParser.SCLN, 0); }
		public BasicContext basic() {
			return getRuleContext(BasicContext.class,0);
		}
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public SeqExpContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LamaLanguageVisitor ) return ((LamaLanguageVisitor<? extends T>)visitor).visitSeqExp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpContext exp() throws RecognitionException {
		ExpContext _localctx = new ExpContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_exp);
		try {
			setState(177);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				_localctx = new SingleExpContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(165);
				basic();
				}
				break;
			case 2:
				_localctx = new SeqExpContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(166);
				((SeqExpContext)_localctx).l = basic();
				setState(167);
				match(SCLN);
				setState(168);
				((SeqExpContext)_localctx).r = exp();
				}
				break;
			case 3:
				_localctx = new LetExpContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(170);
				match(LET);
				setState(171);
				pattern();
				setState(172);
				match(OP_ASSN1);
				setState(173);
				basic();
				setState(174);
				match(IN);
				setState(175);
				((LetExpContext)_localctx).r = exp();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BasicContext extends ParserRuleContext {
		public BasicContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_basic; }
	 
		public BasicContext() { }
		public void copyFrom(BasicContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BasicExpContext extends BasicContext {
		public BasicOrContext basicOr() {
			return getRuleContext(BasicOrContext.class,0);
		}
		public BasicExpContext(BasicContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LamaLanguageVisitor ) return ((LamaLanguageVisitor<? extends T>)visitor).visitBasicExp(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ConsExpContext extends BasicContext {
		public BasicConsContext basicCons() {
			return getRuleContext(BasicConsContext.class,0);
		}
		public ConsExpContext(BasicContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LamaLanguageVisitor ) return ((LamaLanguageVisitor<? extends T>)visitor).visitConsExp(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AssignmentExpContext extends BasicContext {
		public PostfixContext l;
		public BasicContext r;
		public TerminalNode OP_ASSN2() { return getToken(LamaLanguageParser.OP_ASSN2, 0); }
		public PostfixContext postfix() {
			return getRuleContext(PostfixContext.class,0);
		}
		public BasicContext basic() {
			return getRuleContext(BasicContext.class,0);
		}
		public AssignmentExpContext(BasicContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LamaLanguageVisitor ) return ((LamaLanguageVisitor<? extends T>)visitor).visitAssignmentExp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BasicContext basic() throws RecognitionException {
		BasicContext _localctx = new BasicContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_basic);
		try {
			setState(185);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				_localctx = new BasicExpContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(179);
				basicOr(0);
				}
				break;
			case 2:
				_localctx = new ConsExpContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(180);
				basicCons();
				}
				break;
			case 3:
				_localctx = new AssignmentExpContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(181);
				((AssignmentExpContext)_localctx).l = postfix(0);
				setState(182);
				match(OP_ASSN2);
				setState(183);
				((AssignmentExpContext)_localctx).r = basic();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BasicConsContext extends ParserRuleContext {
		public BasicOrContext l;
		public PostfixContext postfix() {
			return getRuleContext(PostfixContext.class,0);
		}
		public List<TerminalNode> CLN() { return getTokens(LamaLanguageParser.CLN); }
		public TerminalNode CLN(int i) {
			return getToken(LamaLanguageParser.CLN, i);
		}
		public List<BasicOrContext> basicOr() {
			return getRuleContexts(BasicOrContext.class);
		}
		public BasicOrContext basicOr(int i) {
			return getRuleContext(BasicOrContext.class,i);
		}
		public BasicConsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_basicCons; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LamaLanguageVisitor ) return ((LamaLanguageVisitor<? extends T>)visitor).visitBasicCons(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BasicConsContext basicCons() throws RecognitionException {
		BasicConsContext _localctx = new BasicConsContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_basicCons);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(190); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(187);
					((BasicConsContext)_localctx).l = basicOr(0);
					setState(188);
					match(CLN);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(192); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(194);
			postfix(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BasicOrContext extends ParserRuleContext {
		public BasicOrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_basicOr; }
	 
		public BasicOrContext() { }
		public void copyFrom(BasicOrContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class OpOrContext extends BasicOrContext {
		public BasicOrContext l;
		public BasicAndContext r;
		public TerminalNode OP_OR() { return getToken(LamaLanguageParser.OP_OR, 0); }
		public BasicOrContext basicOr() {
			return getRuleContext(BasicOrContext.class,0);
		}
		public BasicAndContext basicAnd() {
			return getRuleContext(BasicAndContext.class,0);
		}
		public OpOrContext(BasicOrContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LamaLanguageVisitor ) return ((LamaLanguageVisitor<? extends T>)visitor).visitOpOr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class QuasiOrContext extends BasicOrContext {
		public BasicAndContext basicAnd() {
			return getRuleContext(BasicAndContext.class,0);
		}
		public QuasiOrContext(BasicOrContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LamaLanguageVisitor ) return ((LamaLanguageVisitor<? extends T>)visitor).visitQuasiOr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BasicOrContext basicOr() throws RecognitionException {
		return basicOr(0);
	}

	private BasicOrContext basicOr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		BasicOrContext _localctx = new BasicOrContext(_ctx, _parentState);
		BasicOrContext _prevctx = _localctx;
		int _startState = 20;
		enterRecursionRule(_localctx, 20, RULE_basicOr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new QuasiOrContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(197);
			basicAnd(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(204);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new OpOrContext(new BasicOrContext(_parentctx, _parentState));
					((OpOrContext)_localctx).l = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_basicOr);
					setState(199);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(200);
					match(OP_OR);
					setState(201);
					((OpOrContext)_localctx).r = basicAnd(0);
					}
					} 
				}
				setState(206);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BasicAndContext extends ParserRuleContext {
		public BasicAndContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_basicAnd; }
	 
		public BasicAndContext() { }
		public void copyFrom(BasicAndContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class QuasiAndContext extends BasicAndContext {
		public BasicCmpContext basicCmp() {
			return getRuleContext(BasicCmpContext.class,0);
		}
		public QuasiAndContext(BasicAndContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LamaLanguageVisitor ) return ((LamaLanguageVisitor<? extends T>)visitor).visitQuasiAnd(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class OpAndContext extends BasicAndContext {
		public BasicAndContext l;
		public BasicCmpContext r;
		public TerminalNode OP_AND() { return getToken(LamaLanguageParser.OP_AND, 0); }
		public BasicAndContext basicAnd() {
			return getRuleContext(BasicAndContext.class,0);
		}
		public BasicCmpContext basicCmp() {
			return getRuleContext(BasicCmpContext.class,0);
		}
		public OpAndContext(BasicAndContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LamaLanguageVisitor ) return ((LamaLanguageVisitor<? extends T>)visitor).visitOpAnd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BasicAndContext basicAnd() throws RecognitionException {
		return basicAnd(0);
	}

	private BasicAndContext basicAnd(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		BasicAndContext _localctx = new BasicAndContext(_ctx, _parentState);
		BasicAndContext _prevctx = _localctx;
		int _startState = 22;
		enterRecursionRule(_localctx, 22, RULE_basicAnd, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new QuasiAndContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(208);
			basicCmp();
			}
			_ctx.stop = _input.LT(-1);
			setState(215);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new OpAndContext(new BasicAndContext(_parentctx, _parentState));
					((OpAndContext)_localctx).l = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_basicAnd);
					setState(210);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(211);
					match(OP_AND);
					setState(212);
					((OpAndContext)_localctx).r = basicCmp();
					}
					} 
				}
				setState(217);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BasicCmpContext extends ParserRuleContext {
		public BasicCmpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_basicCmp; }
	 
		public BasicCmpContext() { }
		public void copyFrom(BasicCmpContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class QuasiCmpContext extends BasicCmpContext {
		public BasicAddContext basicAdd() {
			return getRuleContext(BasicAddContext.class,0);
		}
		public QuasiCmpContext(BasicCmpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LamaLanguageVisitor ) return ((LamaLanguageVisitor<? extends T>)visitor).visitQuasiCmp(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class OpCmpContext extends BasicCmpContext {
		public BasicAddContext l;
		public BasicAddContext r;
		public TerminalNode OP_CMP() { return getToken(LamaLanguageParser.OP_CMP, 0); }
		public List<BasicAddContext> basicAdd() {
			return getRuleContexts(BasicAddContext.class);
		}
		public BasicAddContext basicAdd(int i) {
			return getRuleContext(BasicAddContext.class,i);
		}
		public OpCmpContext(BasicCmpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LamaLanguageVisitor ) return ((LamaLanguageVisitor<? extends T>)visitor).visitOpCmp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BasicCmpContext basicCmp() throws RecognitionException {
		BasicCmpContext _localctx = new BasicCmpContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_basicCmp);
		try {
			setState(223);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				_localctx = new QuasiCmpContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(218);
				basicAdd(0);
				}
				break;
			case 2:
				_localctx = new OpCmpContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(219);
				((OpCmpContext)_localctx).l = basicAdd(0);
				setState(220);
				match(OP_CMP);
				setState(221);
				((OpCmpContext)_localctx).r = basicAdd(0);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BasicAddContext extends ParserRuleContext {
		public BasicAddContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_basicAdd; }
	 
		public BasicAddContext() { }
		public void copyFrom(BasicAddContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class QuasiAddContext extends BasicAddContext {
		public BasicMulContext basicMul() {
			return getRuleContext(BasicMulContext.class,0);
		}
		public QuasiAddContext(BasicAddContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LamaLanguageVisitor ) return ((LamaLanguageVisitor<? extends T>)visitor).visitQuasiAdd(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class OpAddContext extends BasicAddContext {
		public BasicAddContext l;
		public BasicMulContext r;
		public TerminalNode OP_ADD() { return getToken(LamaLanguageParser.OP_ADD, 0); }
		public BasicAddContext basicAdd() {
			return getRuleContext(BasicAddContext.class,0);
		}
		public BasicMulContext basicMul() {
			return getRuleContext(BasicMulContext.class,0);
		}
		public OpAddContext(BasicAddContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LamaLanguageVisitor ) return ((LamaLanguageVisitor<? extends T>)visitor).visitOpAdd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BasicAddContext basicAdd() throws RecognitionException {
		return basicAdd(0);
	}

	private BasicAddContext basicAdd(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		BasicAddContext _localctx = new BasicAddContext(_ctx, _parentState);
		BasicAddContext _prevctx = _localctx;
		int _startState = 26;
		enterRecursionRule(_localctx, 26, RULE_basicAdd, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new QuasiAddContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(226);
			basicMul(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(233);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new OpAddContext(new BasicAddContext(_parentctx, _parentState));
					((OpAddContext)_localctx).l = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_basicAdd);
					setState(228);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(229);
					match(OP_ADD);
					setState(230);
					((OpAddContext)_localctx).r = basicMul(0);
					}
					} 
				}
				setState(235);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BasicMulContext extends ParserRuleContext {
		public BasicMulContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_basicMul; }
	 
		public BasicMulContext() { }
		public void copyFrom(BasicMulContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class QuasiMulContext extends BasicMulContext {
		public BasicUnaryContext basicUnary() {
			return getRuleContext(BasicUnaryContext.class,0);
		}
		public QuasiMulContext(BasicMulContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LamaLanguageVisitor ) return ((LamaLanguageVisitor<? extends T>)visitor).visitQuasiMul(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class OpMulContext extends BasicMulContext {
		public BasicMulContext l;
		public BasicUnaryContext r;
		public TerminalNode OP_MUL() { return getToken(LamaLanguageParser.OP_MUL, 0); }
		public BasicMulContext basicMul() {
			return getRuleContext(BasicMulContext.class,0);
		}
		public BasicUnaryContext basicUnary() {
			return getRuleContext(BasicUnaryContext.class,0);
		}
		public OpMulContext(BasicMulContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LamaLanguageVisitor ) return ((LamaLanguageVisitor<? extends T>)visitor).visitOpMul(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BasicMulContext basicMul() throws RecognitionException {
		return basicMul(0);
	}

	private BasicMulContext basicMul(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		BasicMulContext _localctx = new BasicMulContext(_ctx, _parentState);
		BasicMulContext _prevctx = _localctx;
		int _startState = 28;
		enterRecursionRule(_localctx, 28, RULE_basicMul, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new QuasiMulContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(237);
			basicUnary();
			}
			_ctx.stop = _input.LT(-1);
			setState(244);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new OpMulContext(new BasicMulContext(_parentctx, _parentState));
					((OpMulContext)_localctx).l = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_basicMul);
					setState(239);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(240);
					match(OP_MUL);
					setState(241);
					((OpMulContext)_localctx).r = basicUnary();
					}
					} 
				}
				setState(246);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BasicUnaryContext extends ParserRuleContext {
		public BasicUnaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_basicUnary; }
	 
		public BasicUnaryContext() { }
		public void copyFrom(BasicUnaryContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class OpUnaryContext extends BasicUnaryContext {
		public TerminalNode OP_ADD() { return getToken(LamaLanguageParser.OP_ADD, 0); }
		public BasicUnaryContext basicUnary() {
			return getRuleContext(BasicUnaryContext.class,0);
		}
		public OpUnaryContext(BasicUnaryContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LamaLanguageVisitor ) return ((LamaLanguageVisitor<? extends T>)visitor).visitOpUnary(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class QuasiUnaryContext extends BasicUnaryContext {
		public PostfixContext postfix() {
			return getRuleContext(PostfixContext.class,0);
		}
		public QuasiUnaryContext(BasicUnaryContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LamaLanguageVisitor ) return ((LamaLanguageVisitor<? extends T>)visitor).visitQuasiUnary(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BasicUnaryContext basicUnary() throws RecognitionException {
		BasicUnaryContext _localctx = new BasicUnaryContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_basicUnary);
		try {
			setState(250);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NOP:
			case IF:
			case CASE:
			case WHILE:
			case DO:
			case FOR:
			case FUN:
			case TRUE:
			case FALSE:
			case STRING:
			case CHARACTER:
			case INTEGER:
			case LIDENT:
			case UIDENT:
			case LPAR:
			case LBRKT:
			case LCB:
				_localctx = new QuasiUnaryContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(247);
				postfix(0);
				}
				break;
			case OP_ADD:
				_localctx = new OpUnaryContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(248);
				match(OP_ADD);
				setState(249);
				basicUnary();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PostfixContext extends ParserRuleContext {
		public PostfixContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_postfix; }
	 
		public PostfixContext() { }
		public void copyFrom(PostfixContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CallContext extends PostfixContext {
		public PostfixContext funcref;
		public ExpList0Context args;
		public TerminalNode LPAR() { return getToken(LamaLanguageParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(LamaLanguageParser.RPAR, 0); }
		public PostfixContext postfix() {
			return getRuleContext(PostfixContext.class,0);
		}
		public ExpList0Context expList0() {
			return getRuleContext(ExpList0Context.class,0);
		}
		public CallContext(PostfixContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LamaLanguageVisitor ) return ((LamaLanguageVisitor<? extends T>)visitor).visitCall(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DotNotationCallContext extends PostfixContext {
		public PostfixContext firstarg;
		public Token name;
		public ExpListContext args;
		public TerminalNode DOT() { return getToken(LamaLanguageParser.DOT, 0); }
		public PostfixContext postfix() {
			return getRuleContext(PostfixContext.class,0);
		}
		public TerminalNode LIDENT() { return getToken(LamaLanguageParser.LIDENT, 0); }
		public TerminalNode LPAR() { return getToken(LamaLanguageParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(LamaLanguageParser.RPAR, 0); }
		public ExpListContext expList() {
			return getRuleContext(ExpListContext.class,0);
		}
		public DotNotationCallContext(PostfixContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LamaLanguageVisitor ) return ((LamaLanguageVisitor<? extends T>)visitor).visitDotNotationCall(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PrimaryExpContext extends PostfixContext {
		public PrimaryContext primary() {
			return getRuleContext(PrimaryContext.class,0);
		}
		public PrimaryExpContext(PostfixContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LamaLanguageVisitor ) return ((LamaLanguageVisitor<? extends T>)visitor).visitPrimaryExp(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IndexRefContext extends PostfixContext {
		public PostfixContext ref;
		public ExpContext index;
		public TerminalNode LBRKT() { return getToken(LamaLanguageParser.LBRKT, 0); }
		public TerminalNode RBRKT() { return getToken(LamaLanguageParser.RBRKT, 0); }
		public PostfixContext postfix() {
			return getRuleContext(PostfixContext.class,0);
		}
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public IndexRefContext(PostfixContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LamaLanguageVisitor ) return ((LamaLanguageVisitor<? extends T>)visitor).visitIndexRef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PostfixContext postfix() throws RecognitionException {
		return postfix(0);
	}

	private PostfixContext postfix(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		PostfixContext _localctx = new PostfixContext(_ctx, _parentState);
		PostfixContext _prevctx = _localctx;
		int _startState = 32;
		enterRecursionRule(_localctx, 32, RULE_postfix, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new PrimaryExpContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(253);
			primary();
			}
			_ctx.stop = _input.LT(-1);
			setState(276);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(274);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
					case 1:
						{
						_localctx = new IndexRefContext(new PostfixContext(_parentctx, _parentState));
						((IndexRefContext)_localctx).ref = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_postfix);
						setState(255);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(256);
						match(LBRKT);
						setState(257);
						((IndexRefContext)_localctx).index = exp();
						setState(258);
						match(RBRKT);
						}
						break;
					case 2:
						{
						_localctx = new CallContext(new PostfixContext(_parentctx, _parentState));
						((CallContext)_localctx).funcref = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_postfix);
						setState(260);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(261);
						match(LPAR);
						setState(262);
						((CallContext)_localctx).args = expList0();
						setState(263);
						match(RPAR);
						}
						break;
					case 3:
						{
						_localctx = new DotNotationCallContext(new PostfixContext(_parentctx, _parentState));
						((DotNotationCallContext)_localctx).firstarg = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_postfix);
						setState(265);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(266);
						match(DOT);
						setState(267);
						((DotNotationCallContext)_localctx).name = match(LIDENT);
						setState(272);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
						case 1:
							{
							setState(268);
							match(LPAR);
							setState(269);
							((DotNotationCallContext)_localctx).args = expList();
							setState(270);
							match(RPAR);
							}
							break;
						}
						}
						break;
					}
					} 
				}
				setState(278);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PrimaryContext extends ParserRuleContext {
		public TerminalNode LIDENT() { return getToken(LamaLanguageParser.LIDENT, 0); }
		public SexpContext sexp() {
			return getRuleContext(SexpContext.class,0);
		}
		public ArrayContext array() {
			return getRuleContext(ArrayContext.class,0);
		}
		public ListContext list() {
			return getRuleContext(ListContext.class,0);
		}
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public ParenthesesContext parentheses() {
			return getRuleContext(ParenthesesContext.class,0);
		}
		public NopContext nop() {
			return getRuleContext(NopContext.class,0);
		}
		public WhileLoopContext whileLoop() {
			return getRuleContext(WhileLoopContext.class,0);
		}
		public DoWhileLoopContext doWhileLoop() {
			return getRuleContext(DoWhileLoopContext.class,0);
		}
		public ForLoopContext forLoop() {
			return getRuleContext(ForLoopContext.class,0);
		}
		public IfStmtContext ifStmt() {
			return getRuleContext(IfStmtContext.class,0);
		}
		public CaseStmtContext caseStmt() {
			return getRuleContext(CaseStmtContext.class,0);
		}
		public LambdaContext lambda() {
			return getRuleContext(LambdaContext.class,0);
		}
		public PrimaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primary; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LamaLanguageVisitor ) return ((LamaLanguageVisitor<? extends T>)visitor).visitPrimary(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimaryContext primary() throws RecognitionException {
		PrimaryContext _localctx = new PrimaryContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_primary);
		try {
			setState(292);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LIDENT:
				enterOuterAlt(_localctx, 1);
				{
				setState(279);
				match(LIDENT);
				}
				break;
			case UIDENT:
				enterOuterAlt(_localctx, 2);
				{
				setState(280);
				sexp();
				}
				break;
			case LBRKT:
				enterOuterAlt(_localctx, 3);
				{
				setState(281);
				array();
				}
				break;
			case LCB:
				enterOuterAlt(_localctx, 4);
				{
				setState(282);
				list();
				}
				break;
			case TRUE:
			case FALSE:
			case STRING:
			case CHARACTER:
			case INTEGER:
				enterOuterAlt(_localctx, 5);
				{
				setState(283);
				literal();
				}
				break;
			case LPAR:
				enterOuterAlt(_localctx, 6);
				{
				setState(284);
				parentheses();
				}
				break;
			case NOP:
				enterOuterAlt(_localctx, 7);
				{
				setState(285);
				nop();
				}
				break;
			case WHILE:
				enterOuterAlt(_localctx, 8);
				{
				setState(286);
				whileLoop();
				}
				break;
			case DO:
				enterOuterAlt(_localctx, 9);
				{
				setState(287);
				doWhileLoop();
				}
				break;
			case FOR:
				enterOuterAlt(_localctx, 10);
				{
				setState(288);
				forLoop();
				}
				break;
			case IF:
				enterOuterAlt(_localctx, 11);
				{
				setState(289);
				ifStmt();
				}
				break;
			case CASE:
				enterOuterAlt(_localctx, 12);
				{
				setState(290);
				caseStmt();
				}
				break;
			case FUN:
				enterOuterAlt(_localctx, 13);
				{
				setState(291);
				lambda();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SexpContext extends ParserRuleContext {
		public Token name;
		public ExpListContext args;
		public TerminalNode UIDENT() { return getToken(LamaLanguageParser.UIDENT, 0); }
		public TerminalNode LPAR() { return getToken(LamaLanguageParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(LamaLanguageParser.RPAR, 0); }
		public ExpListContext expList() {
			return getRuleContext(ExpListContext.class,0);
		}
		public SexpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sexp; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LamaLanguageVisitor ) return ((LamaLanguageVisitor<? extends T>)visitor).visitSexp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SexpContext sexp() throws RecognitionException {
		SexpContext _localctx = new SexpContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_sexp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(294);
			((SexpContext)_localctx).name = match(UIDENT);
			setState(299);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				{
				setState(295);
				match(LPAR);
				setState(296);
				((SexpContext)_localctx).args = expList();
				setState(297);
				match(RPAR);
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ArrayContext extends ParserRuleContext {
		public ExpList0Context members;
		public TerminalNode LBRKT() { return getToken(LamaLanguageParser.LBRKT, 0); }
		public TerminalNode RBRKT() { return getToken(LamaLanguageParser.RBRKT, 0); }
		public ExpList0Context expList0() {
			return getRuleContext(ExpList0Context.class,0);
		}
		public ArrayContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_array; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LamaLanguageVisitor ) return ((LamaLanguageVisitor<? extends T>)visitor).visitArray(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayContext array() throws RecognitionException {
		ArrayContext _localctx = new ArrayContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_array);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(301);
			match(LBRKT);
			setState(302);
			((ArrayContext)_localctx).members = expList0();
			setState(303);
			match(RBRKT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ListContext extends ParserRuleContext {
		public ExpList0Context members;
		public TerminalNode LCB() { return getToken(LamaLanguageParser.LCB, 0); }
		public TerminalNode RCB() { return getToken(LamaLanguageParser.RCB, 0); }
		public ExpList0Context expList0() {
			return getRuleContext(ExpList0Context.class,0);
		}
		public ListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_list; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LamaLanguageVisitor ) return ((LamaLanguageVisitor<? extends T>)visitor).visitList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ListContext list() throws RecognitionException {
		ListContext _localctx = new ListContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_list);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(305);
			match(LCB);
			setState(306);
			((ListContext)_localctx).members = expList0();
			setState(307);
			match(RCB);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LiteralContext extends ParserRuleContext {
		public StrlitContext strlit() {
			return getRuleContext(StrlitContext.class,0);
		}
		public ChrlitContext chrlit() {
			return getRuleContext(ChrlitContext.class,0);
		}
		public IntlitContext intlit() {
			return getRuleContext(IntlitContext.class,0);
		}
		public BlitContext blit() {
			return getRuleContext(BlitContext.class,0);
		}
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LamaLanguageVisitor ) return ((LamaLanguageVisitor<? extends T>)visitor).visitLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_literal);
		try {
			setState(313);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STRING:
				enterOuterAlt(_localctx, 1);
				{
				setState(309);
				strlit();
				}
				break;
			case CHARACTER:
				enterOuterAlt(_localctx, 2);
				{
				setState(310);
				chrlit();
				}
				break;
			case INTEGER:
				enterOuterAlt(_localctx, 3);
				{
				setState(311);
				intlit();
				}
				break;
			case TRUE:
			case FALSE:
				enterOuterAlt(_localctx, 4);
				{
				setState(312);
				blit();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StrlitContext extends ParserRuleContext {
		public Token value;
		public TerminalNode STRING() { return getToken(LamaLanguageParser.STRING, 0); }
		public StrlitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_strlit; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LamaLanguageVisitor ) return ((LamaLanguageVisitor<? extends T>)visitor).visitStrlit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StrlitContext strlit() throws RecognitionException {
		StrlitContext _localctx = new StrlitContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_strlit);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(315);
			((StrlitContext)_localctx).value = match(STRING);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ChrlitContext extends ParserRuleContext {
		public Token value;
		public TerminalNode CHARACTER() { return getToken(LamaLanguageParser.CHARACTER, 0); }
		public ChrlitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_chrlit; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LamaLanguageVisitor ) return ((LamaLanguageVisitor<? extends T>)visitor).visitChrlit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ChrlitContext chrlit() throws RecognitionException {
		ChrlitContext _localctx = new ChrlitContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_chrlit);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(317);
			((ChrlitContext)_localctx).value = match(CHARACTER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IntlitContext extends ParserRuleContext {
		public Token value;
		public TerminalNode INTEGER() { return getToken(LamaLanguageParser.INTEGER, 0); }
		public IntlitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_intlit; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LamaLanguageVisitor ) return ((LamaLanguageVisitor<? extends T>)visitor).visitIntlit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IntlitContext intlit() throws RecognitionException {
		IntlitContext _localctx = new IntlitContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_intlit);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(319);
			((IntlitContext)_localctx).value = match(INTEGER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BlitContext extends ParserRuleContext {
		public TerminalNode TRUE() { return getToken(LamaLanguageParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(LamaLanguageParser.FALSE, 0); }
		public BlitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blit; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LamaLanguageVisitor ) return ((LamaLanguageVisitor<? extends T>)visitor).visitBlit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlitContext blit() throws RecognitionException {
		BlitContext _localctx = new BlitContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_blit);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(321);
			_la = _input.LA(1);
			if ( !(_la==TRUE || _la==FALSE) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParenthesesContext extends ParserRuleContext {
		public ScopeExpContext body;
		public TerminalNode LPAR() { return getToken(LamaLanguageParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(LamaLanguageParser.RPAR, 0); }
		public ScopeExpContext scopeExp() {
			return getRuleContext(ScopeExpContext.class,0);
		}
		public ParenthesesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parentheses; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LamaLanguageVisitor ) return ((LamaLanguageVisitor<? extends T>)visitor).visitParentheses(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParenthesesContext parentheses() throws RecognitionException {
		ParenthesesContext _localctx = new ParenthesesContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_parentheses);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(323);
			match(LPAR);
			setState(324);
			((ParenthesesContext)_localctx).body = scopeExp();
			setState(325);
			match(RPAR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class NopContext extends ParserRuleContext {
		public TerminalNode NOP() { return getToken(LamaLanguageParser.NOP, 0); }
		public NopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nop; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LamaLanguageVisitor ) return ((LamaLanguageVisitor<? extends T>)visitor).visitNop(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NopContext nop() throws RecognitionException {
		NopContext _localctx = new NopContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_nop);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(327);
			match(NOP);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class WhileLoopContext extends ParserRuleContext {
		public ExpContext cond;
		public ScopeExpContext body;
		public TerminalNode WHILE() { return getToken(LamaLanguageParser.WHILE, 0); }
		public TerminalNode DO() { return getToken(LamaLanguageParser.DO, 0); }
		public TerminalNode OD() { return getToken(LamaLanguageParser.OD, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public ScopeExpContext scopeExp() {
			return getRuleContext(ScopeExpContext.class,0);
		}
		public WhileLoopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileLoop; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LamaLanguageVisitor ) return ((LamaLanguageVisitor<? extends T>)visitor).visitWhileLoop(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhileLoopContext whileLoop() throws RecognitionException {
		WhileLoopContext _localctx = new WhileLoopContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_whileLoop);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(329);
			match(WHILE);
			setState(330);
			((WhileLoopContext)_localctx).cond = exp();
			setState(331);
			match(DO);
			setState(332);
			((WhileLoopContext)_localctx).body = scopeExp();
			setState(333);
			match(OD);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DoWhileLoopContext extends ParserRuleContext {
		public ScopeExpContext body;
		public ExpContext cond;
		public TerminalNode DO() { return getToken(LamaLanguageParser.DO, 0); }
		public TerminalNode WHILE() { return getToken(LamaLanguageParser.WHILE, 0); }
		public TerminalNode OD() { return getToken(LamaLanguageParser.OD, 0); }
		public ScopeExpContext scopeExp() {
			return getRuleContext(ScopeExpContext.class,0);
		}
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public DoWhileLoopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_doWhileLoop; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LamaLanguageVisitor ) return ((LamaLanguageVisitor<? extends T>)visitor).visitDoWhileLoop(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DoWhileLoopContext doWhileLoop() throws RecognitionException {
		DoWhileLoopContext _localctx = new DoWhileLoopContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_doWhileLoop);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(335);
			match(DO);
			setState(336);
			((DoWhileLoopContext)_localctx).body = scopeExp();
			setState(337);
			match(WHILE);
			setState(338);
			((DoWhileLoopContext)_localctx).cond = exp();
			setState(339);
			match(OD);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ForLoopContext extends ParserRuleContext {
		public DefinitionContext def;
		public ExpContext init;
		public ExpContext cond;
		public ExpContext inc;
		public ScopeExpContext body;
		public TerminalNode FOR() { return getToken(LamaLanguageParser.FOR, 0); }
		public List<TerminalNode> COMMA() { return getTokens(LamaLanguageParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(LamaLanguageParser.COMMA, i);
		}
		public TerminalNode DO() { return getToken(LamaLanguageParser.DO, 0); }
		public TerminalNode OD() { return getToken(LamaLanguageParser.OD, 0); }
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public ScopeExpContext scopeExp() {
			return getRuleContext(ScopeExpContext.class,0);
		}
		public DefinitionContext definition() {
			return getRuleContext(DefinitionContext.class,0);
		}
		public ForLoopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forLoop; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LamaLanguageVisitor ) return ((LamaLanguageVisitor<? extends T>)visitor).visitForLoop(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForLoopContext forLoop() throws RecognitionException {
		ForLoopContext _localctx = new ForLoopContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_forLoop);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(341);
			match(FOR);
			setState(343);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
			case 1:
				{
				setState(342);
				((ForLoopContext)_localctx).def = definition();
				}
				break;
			}
			setState(345);
			((ForLoopContext)_localctx).init = exp();
			setState(346);
			match(COMMA);
			setState(347);
			((ForLoopContext)_localctx).cond = exp();
			setState(348);
			match(COMMA);
			setState(349);
			((ForLoopContext)_localctx).inc = exp();
			setState(350);
			match(DO);
			setState(351);
			((ForLoopContext)_localctx).body = scopeExp();
			setState(352);
			match(OD);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IfStmtContext extends ParserRuleContext {
		public ExpContext cond;
		public ScopeExpContext body;
		public ExpContext condAlt;
		public ScopeExpContext bodyAlt;
		public ScopeExpContext bodyElse;
		public TerminalNode IF() { return getToken(LamaLanguageParser.IF, 0); }
		public List<TerminalNode> THEN() { return getTokens(LamaLanguageParser.THEN); }
		public TerminalNode THEN(int i) {
			return getToken(LamaLanguageParser.THEN, i);
		}
		public TerminalNode FI() { return getToken(LamaLanguageParser.FI, 0); }
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public List<ScopeExpContext> scopeExp() {
			return getRuleContexts(ScopeExpContext.class);
		}
		public ScopeExpContext scopeExp(int i) {
			return getRuleContext(ScopeExpContext.class,i);
		}
		public List<TerminalNode> ELIF() { return getTokens(LamaLanguageParser.ELIF); }
		public TerminalNode ELIF(int i) {
			return getToken(LamaLanguageParser.ELIF, i);
		}
		public TerminalNode ELSE() { return getToken(LamaLanguageParser.ELSE, 0); }
		public IfStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStmt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LamaLanguageVisitor ) return ((LamaLanguageVisitor<? extends T>)visitor).visitIfStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfStmtContext ifStmt() throws RecognitionException {
		IfStmtContext _localctx = new IfStmtContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_ifStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(354);
			match(IF);
			setState(355);
			((IfStmtContext)_localctx).cond = exp();
			setState(356);
			match(THEN);
			setState(357);
			((IfStmtContext)_localctx).body = scopeExp();
			setState(365);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ELIF) {
				{
				{
				setState(358);
				match(ELIF);
				setState(359);
				((IfStmtContext)_localctx).condAlt = exp();
				setState(360);
				match(THEN);
				setState(361);
				((IfStmtContext)_localctx).bodyAlt = scopeExp();
				}
				}
				setState(367);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(370);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(368);
				match(ELSE);
				setState(369);
				((IfStmtContext)_localctx).bodyElse = scopeExp();
				}
			}

			setState(372);
			match(FI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CaseStmtContext extends ParserRuleContext {
		public TerminalNode CASE() { return getToken(LamaLanguageParser.CASE, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode OF() { return getToken(LamaLanguageParser.OF, 0); }
		public List<CaseOptionContext> caseOption() {
			return getRuleContexts(CaseOptionContext.class);
		}
		public CaseOptionContext caseOption(int i) {
			return getRuleContext(CaseOptionContext.class,i);
		}
		public TerminalNode ESAC() { return getToken(LamaLanguageParser.ESAC, 0); }
		public List<TerminalNode> VBAR() { return getTokens(LamaLanguageParser.VBAR); }
		public TerminalNode VBAR(int i) {
			return getToken(LamaLanguageParser.VBAR, i);
		}
		public CaseStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_caseStmt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LamaLanguageVisitor ) return ((LamaLanguageVisitor<? extends T>)visitor).visitCaseStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CaseStmtContext caseStmt() throws RecognitionException {
		CaseStmtContext _localctx = new CaseStmtContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_caseStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(374);
			match(CASE);
			setState(375);
			exp();
			setState(376);
			match(OF);
			setState(377);
			caseOption();
			setState(382);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VBAR) {
				{
				{
				setState(378);
				match(VBAR);
				setState(379);
				caseOption();
				}
				}
				setState(384);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(385);
			match(ESAC);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CaseOptionContext extends ParserRuleContext {
		public PatternContext pattern() {
			return getRuleContext(PatternContext.class,0);
		}
		public TerminalNode RARROW() { return getToken(LamaLanguageParser.RARROW, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public CaseOptionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_caseOption; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LamaLanguageVisitor ) return ((LamaLanguageVisitor<? extends T>)visitor).visitCaseOption(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CaseOptionContext caseOption() throws RecognitionException {
		CaseOptionContext _localctx = new CaseOptionContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_caseOption);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(387);
			pattern();
			setState(388);
			match(RARROW);
			setState(389);
			exp();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LambdaContext extends ParserRuleContext {
		public LidentList0Context args;
		public ScopeExpContext body;
		public TerminalNode FUN() { return getToken(LamaLanguageParser.FUN, 0); }
		public TerminalNode LPAR() { return getToken(LamaLanguageParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(LamaLanguageParser.RPAR, 0); }
		public TerminalNode LCB() { return getToken(LamaLanguageParser.LCB, 0); }
		public TerminalNode RCB() { return getToken(LamaLanguageParser.RCB, 0); }
		public LidentList0Context lidentList0() {
			return getRuleContext(LidentList0Context.class,0);
		}
		public ScopeExpContext scopeExp() {
			return getRuleContext(ScopeExpContext.class,0);
		}
		public LambdaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lambda; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LamaLanguageVisitor ) return ((LamaLanguageVisitor<? extends T>)visitor).visitLambda(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LambdaContext lambda() throws RecognitionException {
		LambdaContext _localctx = new LambdaContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_lambda);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(391);
			match(FUN);
			setState(392);
			match(LPAR);
			setState(393);
			((LambdaContext)_localctx).args = lidentList0();
			setState(394);
			match(RPAR);
			setState(395);
			match(LCB);
			setState(396);
			((LambdaContext)_localctx).body = scopeExp();
			setState(397);
			match(RCB);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PatternContext extends ParserRuleContext {
		public PatternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pattern; }
	 
		public PatternContext() { }
		public void copyFrom(PatternContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ConsPatternContext extends PatternContext {
		public List<NonConsPatternContext> nonConsPattern() {
			return getRuleContexts(NonConsPatternContext.class);
		}
		public NonConsPatternContext nonConsPattern(int i) {
			return getRuleContext(NonConsPatternContext.class,i);
		}
		public List<TerminalNode> CLN() { return getTokens(LamaLanguageParser.CLN); }
		public TerminalNode CLN(int i) {
			return getToken(LamaLanguageParser.CLN, i);
		}
		public ConsPatternContext(PatternContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LamaLanguageVisitor ) return ((LamaLanguageVisitor<? extends T>)visitor).visitConsPattern(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SimplePatternContext extends PatternContext {
		public NonConsPatternContext nonConsPattern() {
			return getRuleContext(NonConsPatternContext.class,0);
		}
		public SimplePatternContext(PatternContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LamaLanguageVisitor ) return ((LamaLanguageVisitor<? extends T>)visitor).visitSimplePattern(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PatternContext pattern() throws RecognitionException {
		PatternContext _localctx = new PatternContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_pattern);
		int _la;
		try {
			setState(408);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
			case 1:
				_localctx = new SimplePatternContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(399);
				nonConsPattern();
				}
				break;
			case 2:
				_localctx = new ConsPatternContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(400);
				nonConsPattern();
				setState(405);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==CLN) {
					{
					{
					setState(401);
					match(CLN);
					setState(402);
					nonConsPattern();
					}
					}
					setState(407);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class NonConsPatternContext extends ParserRuleContext {
		public ParenthesesPatternContext parenthesesPattern() {
			return getRuleContext(ParenthesesPatternContext.class,0);
		}
		public LiteralPatternContext literalPattern() {
			return getRuleContext(LiteralPatternContext.class,0);
		}
		public VarPatternContext varPattern() {
			return getRuleContext(VarPatternContext.class,0);
		}
		public SexpPatternContext sexpPattern() {
			return getRuleContext(SexpPatternContext.class,0);
		}
		public ArrayPatternContext arrayPattern() {
			return getRuleContext(ArrayPatternContext.class,0);
		}
		public ListPatternContext listPattern() {
			return getRuleContext(ListPatternContext.class,0);
		}
		public AssertFunPatternContext assertFunPattern() {
			return getRuleContext(AssertFunPatternContext.class,0);
		}
		public AssertStrPatternContext assertStrPattern() {
			return getRuleContext(AssertStrPatternContext.class,0);
		}
		public AssertValPatternContext assertValPattern() {
			return getRuleContext(AssertValPatternContext.class,0);
		}
		public NonConsPatternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nonConsPattern; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LamaLanguageVisitor ) return ((LamaLanguageVisitor<? extends T>)visitor).visitNonConsPattern(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NonConsPatternContext nonConsPattern() throws RecognitionException {
		NonConsPatternContext _localctx = new NonConsPatternContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_nonConsPattern);
		try {
			setState(419);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LPAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(410);
				parenthesesPattern();
				}
				break;
			case TRUE:
			case FALSE:
			case STRING:
			case CHARACTER:
			case INTEGER:
				enterOuterAlt(_localctx, 2);
				{
				setState(411);
				literalPattern();
				}
				break;
			case LIDENT:
				enterOuterAlt(_localctx, 3);
				{
				setState(412);
				varPattern();
				}
				break;
			case UIDENT:
				enterOuterAlt(_localctx, 4);
				{
				setState(413);
				sexpPattern();
				}
				break;
			case LBRKT:
				enterOuterAlt(_localctx, 5);
				{
				setState(414);
				arrayPattern();
				}
				break;
			case LCB:
				enterOuterAlt(_localctx, 6);
				{
				setState(415);
				listPattern();
				}
				break;
			case ASSERT_FUN:
				enterOuterAlt(_localctx, 7);
				{
				setState(416);
				assertFunPattern();
				}
				break;
			case ASSERT_STR:
				enterOuterAlt(_localctx, 8);
				{
				setState(417);
				assertStrPattern();
				}
				break;
			case ASSERT_VAL:
				enterOuterAlt(_localctx, 9);
				{
				setState(418);
				assertValPattern();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PatternList0Context extends ParserRuleContext {
		public PatternContext hd;
		public List<PatternContext> pattern() {
			return getRuleContexts(PatternContext.class);
		}
		public PatternContext pattern(int i) {
			return getRuleContext(PatternContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(LamaLanguageParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(LamaLanguageParser.COMMA, i);
		}
		public PatternList0Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_patternList0; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LamaLanguageVisitor ) return ((LamaLanguageVisitor<? extends T>)visitor).visitPatternList0(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PatternList0Context patternList0() throws RecognitionException {
		PatternList0Context _localctx = new PatternList0Context(_ctx, getState());
		enterRule(_localctx, 74, RULE_patternList0);
		int _la;
		try {
			setState(430);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case RBRKT:
			case RCB:
				enterOuterAlt(_localctx, 1);
				{
				}
				break;
			case TRUE:
			case FALSE:
			case STRING:
			case CHARACTER:
			case INTEGER:
			case LIDENT:
			case UIDENT:
			case LPAR:
			case LBRKT:
			case LCB:
			case ASSERT_VAL:
			case ASSERT_FUN:
			case ASSERT_STR:
				enterOuterAlt(_localctx, 2);
				{
				setState(422);
				((PatternList0Context)_localctx).hd = pattern();
				setState(427);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(423);
					match(COMMA);
					setState(424);
					pattern();
					}
					}
					setState(429);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PatternListContext extends ParserRuleContext {
		public PatternContext hd;
		public List<PatternContext> pattern() {
			return getRuleContexts(PatternContext.class);
		}
		public PatternContext pattern(int i) {
			return getRuleContext(PatternContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(LamaLanguageParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(LamaLanguageParser.COMMA, i);
		}
		public PatternListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_patternList; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LamaLanguageVisitor ) return ((LamaLanguageVisitor<? extends T>)visitor).visitPatternList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PatternListContext patternList() throws RecognitionException {
		PatternListContext _localctx = new PatternListContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_patternList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(432);
			((PatternListContext)_localctx).hd = pattern();
			setState(437);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(433);
				match(COMMA);
				setState(434);
				pattern();
				}
				}
				setState(439);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParenthesesPatternContext extends ParserRuleContext {
		public TerminalNode LPAR() { return getToken(LamaLanguageParser.LPAR, 0); }
		public PatternContext pattern() {
			return getRuleContext(PatternContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(LamaLanguageParser.RPAR, 0); }
		public ParenthesesPatternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parenthesesPattern; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LamaLanguageVisitor ) return ((LamaLanguageVisitor<? extends T>)visitor).visitParenthesesPattern(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParenthesesPatternContext parenthesesPattern() throws RecognitionException {
		ParenthesesPatternContext _localctx = new ParenthesesPatternContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_parenthesesPattern);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(440);
			match(LPAR);
			setState(441);
			pattern();
			setState(442);
			match(RPAR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LiteralPatternContext extends ParserRuleContext {
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public LiteralPatternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literalPattern; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LamaLanguageVisitor ) return ((LamaLanguageVisitor<? extends T>)visitor).visitLiteralPattern(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteralPatternContext literalPattern() throws RecognitionException {
		LiteralPatternContext _localctx = new LiteralPatternContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_literalPattern);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(444);
			literal();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class VarPatternContext extends ParserRuleContext {
		public VarPatternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varPattern; }
	 
		public VarPatternContext() { }
		public void copyFrom(VarPatternContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AliasPatternContext extends VarPatternContext {
		public TerminalNode LIDENT() { return getToken(LamaLanguageParser.LIDENT, 0); }
		public TerminalNode ALIAS() { return getToken(LamaLanguageParser.ALIAS, 0); }
		public NonConsPatternContext nonConsPattern() {
			return getRuleContext(NonConsPatternContext.class,0);
		}
		public AliasPatternContext(VarPatternContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LamaLanguageVisitor ) return ((LamaLanguageVisitor<? extends T>)visitor).visitAliasPattern(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LidentPatternContext extends VarPatternContext {
		public TerminalNode LIDENT() { return getToken(LamaLanguageParser.LIDENT, 0); }
		public LidentPatternContext(VarPatternContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LamaLanguageVisitor ) return ((LamaLanguageVisitor<? extends T>)visitor).visitLidentPattern(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarPatternContext varPattern() throws RecognitionException {
		VarPatternContext _localctx = new VarPatternContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_varPattern);
		try {
			setState(450);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,35,_ctx) ) {
			case 1:
				_localctx = new LidentPatternContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(446);
				match(LIDENT);
				}
				break;
			case 2:
				_localctx = new AliasPatternContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(447);
				match(LIDENT);
				setState(448);
				match(ALIAS);
				setState(449);
				nonConsPattern();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SexpPatternContext extends ParserRuleContext {
		public Token name;
		public PatternListContext args;
		public TerminalNode UIDENT() { return getToken(LamaLanguageParser.UIDENT, 0); }
		public TerminalNode LPAR() { return getToken(LamaLanguageParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(LamaLanguageParser.RPAR, 0); }
		public PatternListContext patternList() {
			return getRuleContext(PatternListContext.class,0);
		}
		public SexpPatternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sexpPattern; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LamaLanguageVisitor ) return ((LamaLanguageVisitor<? extends T>)visitor).visitSexpPattern(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SexpPatternContext sexpPattern() throws RecognitionException {
		SexpPatternContext _localctx = new SexpPatternContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_sexpPattern);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(452);
			((SexpPatternContext)_localctx).name = match(UIDENT);
			setState(457);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LPAR) {
				{
				setState(453);
				match(LPAR);
				setState(454);
				((SexpPatternContext)_localctx).args = patternList();
				setState(455);
				match(RPAR);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ArrayPatternContext extends ParserRuleContext {
		public PatternList0Context members;
		public TerminalNode LBRKT() { return getToken(LamaLanguageParser.LBRKT, 0); }
		public TerminalNode RBRKT() { return getToken(LamaLanguageParser.RBRKT, 0); }
		public PatternList0Context patternList0() {
			return getRuleContext(PatternList0Context.class,0);
		}
		public ArrayPatternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayPattern; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LamaLanguageVisitor ) return ((LamaLanguageVisitor<? extends T>)visitor).visitArrayPattern(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayPatternContext arrayPattern() throws RecognitionException {
		ArrayPatternContext _localctx = new ArrayPatternContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_arrayPattern);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(459);
			match(LBRKT);
			setState(460);
			((ArrayPatternContext)_localctx).members = patternList0();
			setState(461);
			match(RBRKT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ListPatternContext extends ParserRuleContext {
		public PatternList0Context members;
		public TerminalNode LCB() { return getToken(LamaLanguageParser.LCB, 0); }
		public TerminalNode RCB() { return getToken(LamaLanguageParser.RCB, 0); }
		public PatternList0Context patternList0() {
			return getRuleContext(PatternList0Context.class,0);
		}
		public ListPatternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listPattern; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LamaLanguageVisitor ) return ((LamaLanguageVisitor<? extends T>)visitor).visitListPattern(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ListPatternContext listPattern() throws RecognitionException {
		ListPatternContext _localctx = new ListPatternContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_listPattern);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(463);
			match(LCB);
			setState(464);
			((ListPatternContext)_localctx).members = patternList0();
			setState(465);
			match(RCB);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AssertFunPatternContext extends ParserRuleContext {
		public TerminalNode ASSERT_FUN() { return getToken(LamaLanguageParser.ASSERT_FUN, 0); }
		public AssertFunPatternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assertFunPattern; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LamaLanguageVisitor ) return ((LamaLanguageVisitor<? extends T>)visitor).visitAssertFunPattern(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssertFunPatternContext assertFunPattern() throws RecognitionException {
		AssertFunPatternContext _localctx = new AssertFunPatternContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_assertFunPattern);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(467);
			match(ASSERT_FUN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AssertValPatternContext extends ParserRuleContext {
		public TerminalNode ASSERT_VAL() { return getToken(LamaLanguageParser.ASSERT_VAL, 0); }
		public AssertValPatternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assertValPattern; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LamaLanguageVisitor ) return ((LamaLanguageVisitor<? extends T>)visitor).visitAssertValPattern(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssertValPatternContext assertValPattern() throws RecognitionException {
		AssertValPatternContext _localctx = new AssertValPatternContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_assertValPattern);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(469);
			match(ASSERT_VAL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AssertStrPatternContext extends ParserRuleContext {
		public TerminalNode ASSERT_STR() { return getToken(LamaLanguageParser.ASSERT_STR, 0); }
		public AssertStrPatternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assertStrPattern; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LamaLanguageVisitor ) return ((LamaLanguageVisitor<? extends T>)visitor).visitAssertStrPattern(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssertStrPatternContext assertStrPattern() throws RecognitionException {
		AssertStrPatternContext _localctx = new AssertStrPatternContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_assertStrPattern);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(471);
			match(ASSERT_STR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 10:
			return basicOr_sempred((BasicOrContext)_localctx, predIndex);
		case 11:
			return basicAnd_sempred((BasicAndContext)_localctx, predIndex);
		case 13:
			return basicAdd_sempred((BasicAddContext)_localctx, predIndex);
		case 14:
			return basicMul_sempred((BasicMulContext)_localctx, predIndex);
		case 16:
			return postfix_sempred((PostfixContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean basicOr_sempred(BasicOrContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean basicAnd_sempred(BasicAndContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean basicAdd_sempred(BasicAddContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean basicMul_sempred(BasicMulContext _localctx, int predIndex) {
		switch (predIndex) {
		case 3:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean postfix_sempred(PostfixContext _localctx, int predIndex) {
		switch (predIndex) {
		case 4:
			return precpred(_ctx, 3);
		case 5:
			return precpred(_ctx, 2);
		case 6:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u00012\u01da\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b"+
		"\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007\u001e"+
		"\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007!\u0002\"\u0007\"\u0002"+
		"#\u0007#\u0002$\u0007$\u0002%\u0007%\u0002&\u0007&\u0002\'\u0007\'\u0002"+
		"(\u0007(\u0002)\u0007)\u0002*\u0007*\u0002+\u0007+\u0002,\u0007,\u0002"+
		"-\u0007-\u0002.\u0007.\u0002/\u0007/\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0001\u0005\u0001e\b\u0001\n\u0001\f\u0001h\t\u0001\u0001\u0001"+
		"\u0003\u0001k\b\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002"+
		"p\b\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0005\u0003"+
		"v\b\u0003\n\u0003\f\u0003y\t\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0003\u0003\u0086\b\u0003\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0005\u0004\u008c\b\u0004\n\u0004\f\u0004\u008f"+
		"\t\u0004\u0003\u0004\u0091\b\u0004\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0005\u0005\u0097\b\u0005\n\u0005\f\u0005\u009a\t\u0005\u0003"+
		"\u0005\u009c\b\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0005\u0006\u00a1"+
		"\b\u0006\n\u0006\f\u0006\u00a4\t\u0006\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0003\u0007\u00b2\b\u0007\u0001\b"+
		"\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0003\b\u00ba\b\b\u0001\t\u0001"+
		"\t\u0001\t\u0004\t\u00bf\b\t\u000b\t\f\t\u00c0\u0001\t\u0001\t\u0001\n"+
		"\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0005\n\u00cb\b\n\n\n\f\n\u00ce"+
		"\t\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0005\u000b\u00d6\b\u000b\n\u000b\f\u000b\u00d9\t\u000b\u0001\f"+
		"\u0001\f\u0001\f\u0001\f\u0001\f\u0003\f\u00e0\b\f\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0005\r\u00e8\b\r\n\r\f\r\u00eb\t\r\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0005\u000e"+
		"\u00f3\b\u000e\n\u000e\f\u000e\u00f6\t\u000e\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0003\u000f\u00fb\b\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0003\u0010\u0111"+
		"\b\u0010\u0005\u0010\u0113\b\u0010\n\u0010\f\u0010\u0116\t\u0010\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0003\u0011\u0125\b\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0001"+
		"\u0012\u0001\u0012\u0003\u0012\u012c\b\u0012\u0001\u0013\u0001\u0013\u0001"+
		"\u0013\u0001\u0013\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001"+
		"\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0003\u0015\u013a\b\u0015\u0001"+
		"\u0016\u0001\u0016\u0001\u0017\u0001\u0017\u0001\u0018\u0001\u0018\u0001"+
		"\u0019\u0001\u0019\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001"+
		"\u001b\u0001\u001b\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001"+
		"\u001c\u0001\u001c\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001"+
		"\u001d\u0001\u001d\u0001\u001e\u0001\u001e\u0003\u001e\u0158\b\u001e\u0001"+
		"\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001"+
		"\u001e\u0001\u001e\u0001\u001e\u0001\u001f\u0001\u001f\u0001\u001f\u0001"+
		"\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0005"+
		"\u001f\u016c\b\u001f\n\u001f\f\u001f\u016f\t\u001f\u0001\u001f\u0001\u001f"+
		"\u0003\u001f\u0173\b\u001f\u0001\u001f\u0001\u001f\u0001 \u0001 \u0001"+
		" \u0001 \u0001 \u0001 \u0005 \u017d\b \n \f \u0180\t \u0001 \u0001 \u0001"+
		"!\u0001!\u0001!\u0001!\u0001\"\u0001\"\u0001\"\u0001\"\u0001\"\u0001\""+
		"\u0001\"\u0001\"\u0001#\u0001#\u0001#\u0001#\u0005#\u0194\b#\n#\f#\u0197"+
		"\t#\u0003#\u0199\b#\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001"+
		"$\u0001$\u0003$\u01a4\b$\u0001%\u0001%\u0001%\u0001%\u0005%\u01aa\b%\n"+
		"%\f%\u01ad\t%\u0003%\u01af\b%\u0001&\u0001&\u0001&\u0005&\u01b4\b&\n&"+
		"\f&\u01b7\t&\u0001\'\u0001\'\u0001\'\u0001\'\u0001(\u0001(\u0001)\u0001"+
		")\u0001)\u0001)\u0003)\u01c3\b)\u0001*\u0001*\u0001*\u0001*\u0001*\u0003"+
		"*\u01ca\b*\u0001+\u0001+\u0001+\u0001+\u0001,\u0001,\u0001,\u0001,\u0001"+
		"-\u0001-\u0001.\u0001.\u0001/\u0001/\u0001/\u0000\u0005\u0014\u0016\u001a"+
		"\u001c 0\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018"+
		"\u001a\u001c\u001e \"$&(*,.02468:<>@BDFHJLNPRTVXZ\\^\u0000\u0001\u0001"+
		"\u0000\u0013\u0014\u01e5\u0000`\u0001\u0000\u0000\u0000\u0002f\u0001\u0000"+
		"\u0000\u0000\u0004l\u0001\u0000\u0000\u0000\u0006\u0085\u0001\u0000\u0000"+
		"\u0000\b\u0090\u0001\u0000\u0000\u0000\n\u009b\u0001\u0000\u0000\u0000"+
		"\f\u009d\u0001\u0000\u0000\u0000\u000e\u00b1\u0001\u0000\u0000\u0000\u0010"+
		"\u00b9\u0001\u0000\u0000\u0000\u0012\u00be\u0001\u0000\u0000\u0000\u0014"+
		"\u00c4\u0001\u0000\u0000\u0000\u0016\u00cf\u0001\u0000\u0000\u0000\u0018"+
		"\u00df\u0001\u0000\u0000\u0000\u001a\u00e1\u0001\u0000\u0000\u0000\u001c"+
		"\u00ec\u0001\u0000\u0000\u0000\u001e\u00fa\u0001\u0000\u0000\u0000 \u00fc"+
		"\u0001\u0000\u0000\u0000\"\u0124\u0001\u0000\u0000\u0000$\u0126\u0001"+
		"\u0000\u0000\u0000&\u012d\u0001\u0000\u0000\u0000(\u0131\u0001\u0000\u0000"+
		"\u0000*\u0139\u0001\u0000\u0000\u0000,\u013b\u0001\u0000\u0000\u0000."+
		"\u013d\u0001\u0000\u0000\u00000\u013f\u0001\u0000\u0000\u00002\u0141\u0001"+
		"\u0000\u0000\u00004\u0143\u0001\u0000\u0000\u00006\u0147\u0001\u0000\u0000"+
		"\u00008\u0149\u0001\u0000\u0000\u0000:\u014f\u0001\u0000\u0000\u0000<"+
		"\u0155\u0001\u0000\u0000\u0000>\u0162\u0001\u0000\u0000\u0000@\u0176\u0001"+
		"\u0000\u0000\u0000B\u0183\u0001\u0000\u0000\u0000D\u0187\u0001\u0000\u0000"+
		"\u0000F\u0198\u0001\u0000\u0000\u0000H\u01a3\u0001\u0000\u0000\u0000J"+
		"\u01ae\u0001\u0000\u0000\u0000L\u01b0\u0001\u0000\u0000\u0000N\u01b8\u0001"+
		"\u0000\u0000\u0000P\u01bc\u0001\u0000\u0000\u0000R\u01c2\u0001\u0000\u0000"+
		"\u0000T\u01c4\u0001\u0000\u0000\u0000V\u01cb\u0001\u0000\u0000\u0000X"+
		"\u01cf\u0001\u0000\u0000\u0000Z\u01d3\u0001\u0000\u0000\u0000\\\u01d5"+
		"\u0001\u0000\u0000\u0000^\u01d7\u0001\u0000\u0000\u0000`a\u0003\u0002"+
		"\u0001\u0000ab\u0005\u0000\u0000\u0001b\u0001\u0001\u0000\u0000\u0000"+
		"ce\u0003\u0006\u0003\u0000dc\u0001\u0000\u0000\u0000eh\u0001\u0000\u0000"+
		"\u0000fd\u0001\u0000\u0000\u0000fg\u0001\u0000\u0000\u0000gj\u0001\u0000"+
		"\u0000\u0000hf\u0001\u0000\u0000\u0000ik\u0003\u000e\u0007\u0000ji\u0001"+
		"\u0000\u0000\u0000jk\u0001\u0000\u0000\u0000k\u0003\u0001\u0000\u0000"+
		"\u0000lo\u0005\u0018\u0000\u0000mn\u0005\u001a\u0000\u0000np\u0003\u0010"+
		"\b\u0000om\u0001\u0000\u0000\u0000op\u0001\u0000\u0000\u0000p\u0005\u0001"+
		"\u0000\u0000\u0000qr\u0005\u0011\u0000\u0000rw\u0003\u0004\u0002\u0000"+
		"st\u0005\'\u0000\u0000tv\u0003\u0004\u0002\u0000us\u0001\u0000\u0000\u0000"+
		"vy\u0001\u0000\u0000\u0000wu\u0001\u0000\u0000\u0000wx\u0001\u0000\u0000"+
		"\u0000xz\u0001\u0000\u0000\u0000yw\u0001\u0000\u0000\u0000z{\u0005)\u0000"+
		"\u0000{\u0086\u0001\u0000\u0000\u0000|}\u0005\u0012\u0000\u0000}~\u0005"+
		"\u0018\u0000\u0000~\u007f\u0005!\u0000\u0000\u007f\u0080\u0003\b\u0004"+
		"\u0000\u0080\u0081\u0005\"\u0000\u0000\u0081\u0082\u0005%\u0000\u0000"+
		"\u0082\u0083\u0003\u0002\u0001\u0000\u0083\u0084\u0005&\u0000\u0000\u0084"+
		"\u0086\u0001\u0000\u0000\u0000\u0085q\u0001\u0000\u0000\u0000\u0085|\u0001"+
		"\u0000\u0000\u0000\u0086\u0007\u0001\u0000\u0000\u0000\u0087\u0091\u0001"+
		"\u0000\u0000\u0000\u0088\u008d\u0005\u0018\u0000\u0000\u0089\u008a\u0005"+
		"\'\u0000\u0000\u008a\u008c\u0005\u0018\u0000\u0000\u008b\u0089\u0001\u0000"+
		"\u0000\u0000\u008c\u008f\u0001\u0000\u0000\u0000\u008d\u008b\u0001\u0000"+
		"\u0000\u0000\u008d\u008e\u0001\u0000\u0000\u0000\u008e\u0091\u0001\u0000"+
		"\u0000\u0000\u008f\u008d\u0001\u0000\u0000\u0000\u0090\u0087\u0001\u0000"+
		"\u0000\u0000\u0090\u0088\u0001\u0000\u0000\u0000\u0091\t\u0001\u0000\u0000"+
		"\u0000\u0092\u009c\u0001\u0000\u0000\u0000\u0093\u0098\u0003\u000e\u0007"+
		"\u0000\u0094\u0095\u0005\'\u0000\u0000\u0095\u0097\u0003\u000e\u0007\u0000"+
		"\u0096\u0094\u0001\u0000\u0000\u0000\u0097\u009a\u0001\u0000\u0000\u0000"+
		"\u0098\u0096\u0001\u0000\u0000\u0000\u0098\u0099\u0001\u0000\u0000\u0000"+
		"\u0099\u009c\u0001\u0000\u0000\u0000\u009a\u0098\u0001\u0000\u0000\u0000"+
		"\u009b\u0092\u0001\u0000\u0000\u0000\u009b\u0093\u0001\u0000\u0000\u0000"+
		"\u009c\u000b\u0001\u0000\u0000\u0000\u009d\u00a2\u0003\u000e\u0007\u0000"+
		"\u009e\u009f\u0005\'\u0000\u0000\u009f\u00a1\u0003\u000e\u0007\u0000\u00a0"+
		"\u009e\u0001\u0000\u0000\u0000\u00a1\u00a4\u0001\u0000\u0000\u0000\u00a2"+
		"\u00a0\u0001\u0000\u0000\u0000\u00a2\u00a3\u0001\u0000\u0000\u0000\u00a3"+
		"\r\u0001\u0000\u0000\u0000\u00a4\u00a2\u0001\u0000\u0000\u0000\u00a5\u00b2"+
		"\u0003\u0010\b\u0000\u00a6\u00a7\u0003\u0010\b\u0000\u00a7\u00a8\u0005"+
		")\u0000\u0000\u00a8\u00a9\u0003\u000e\u0007\u0000\u00a9\u00b2\u0001\u0000"+
		"\u0000\u0000\u00aa\u00ab\u0005\u000f\u0000\u0000\u00ab\u00ac\u0003F#\u0000"+
		"\u00ac\u00ad\u0005\u001a\u0000\u0000\u00ad\u00ae\u0003\u0010\b\u0000\u00ae"+
		"\u00af\u0005\u0010\u0000\u0000\u00af\u00b0\u0003\u000e\u0007\u0000\u00b0"+
		"\u00b2\u0001\u0000\u0000\u0000\u00b1\u00a5\u0001\u0000\u0000\u0000\u00b1"+
		"\u00a6\u0001\u0000\u0000\u0000\u00b1\u00aa\u0001\u0000\u0000\u0000\u00b2"+
		"\u000f\u0001\u0000\u0000\u0000\u00b3\u00ba\u0003\u0014\n\u0000\u00b4\u00ba"+
		"\u0003\u0012\t\u0000\u00b5\u00b6\u0003 \u0010\u0000\u00b6\u00b7\u0005"+
		"\u001b\u0000\u0000\u00b7\u00b8\u0003\u0010\b\u0000\u00b8\u00ba\u0001\u0000"+
		"\u0000\u0000\u00b9\u00b3\u0001\u0000\u0000\u0000\u00b9\u00b4\u0001\u0000"+
		"\u0000\u0000\u00b9\u00b5\u0001\u0000\u0000\u0000\u00ba\u0011\u0001\u0000"+
		"\u0000\u0000\u00bb\u00bc\u0003\u0014\n\u0000\u00bc\u00bd\u0005(\u0000"+
		"\u0000\u00bd\u00bf\u0001\u0000\u0000\u0000\u00be\u00bb\u0001\u0000\u0000"+
		"\u0000\u00bf\u00c0\u0001\u0000\u0000\u0000\u00c0\u00be\u0001\u0000\u0000"+
		"\u0000\u00c0\u00c1\u0001\u0000\u0000\u0000\u00c1\u00c2\u0001\u0000\u0000"+
		"\u0000\u00c2\u00c3\u0003 \u0010\u0000\u00c3\u0013\u0001\u0000\u0000\u0000"+
		"\u00c4\u00c5\u0006\n\uffff\uffff\u0000\u00c5\u00c6\u0003\u0016\u000b\u0000"+
		"\u00c6\u00cc\u0001\u0000\u0000\u0000\u00c7\u00c8\n\u0001\u0000\u0000\u00c8"+
		"\u00c9\u0005\u001c\u0000\u0000\u00c9\u00cb\u0003\u0016\u000b\u0000\u00ca"+
		"\u00c7\u0001\u0000\u0000\u0000\u00cb\u00ce\u0001\u0000\u0000\u0000\u00cc"+
		"\u00ca\u0001\u0000\u0000\u0000\u00cc\u00cd\u0001\u0000\u0000\u0000\u00cd"+
		"\u0015\u0001\u0000\u0000\u0000\u00ce\u00cc\u0001\u0000\u0000\u0000\u00cf"+
		"\u00d0\u0006\u000b\uffff\uffff\u0000\u00d0\u00d1\u0003\u0018\f\u0000\u00d1"+
		"\u00d7\u0001\u0000\u0000\u0000\u00d2\u00d3\n\u0001\u0000\u0000\u00d3\u00d4"+
		"\u0005\u001d\u0000\u0000\u00d4\u00d6\u0003\u0018\f\u0000\u00d5\u00d2\u0001"+
		"\u0000\u0000\u0000\u00d6\u00d9\u0001\u0000\u0000\u0000\u00d7\u00d5\u0001"+
		"\u0000\u0000\u0000\u00d7\u00d8\u0001\u0000\u0000\u0000\u00d8\u0017\u0001"+
		"\u0000\u0000\u0000\u00d9\u00d7\u0001\u0000\u0000\u0000\u00da\u00e0\u0003"+
		"\u001a\r\u0000\u00db\u00dc\u0003\u001a\r\u0000\u00dc\u00dd\u0005\u001e"+
		"\u0000\u0000\u00dd\u00de\u0003\u001a\r\u0000\u00de\u00e0\u0001\u0000\u0000"+
		"\u0000\u00df\u00da\u0001\u0000\u0000\u0000\u00df\u00db\u0001\u0000\u0000"+
		"\u0000\u00e0\u0019\u0001\u0000\u0000\u0000\u00e1\u00e2\u0006\r\uffff\uffff"+
		"\u0000\u00e2\u00e3\u0003\u001c\u000e\u0000\u00e3\u00e9\u0001\u0000\u0000"+
		"\u0000\u00e4\u00e5\n\u0001\u0000\u0000\u00e5\u00e6\u0005\u001f\u0000\u0000"+
		"\u00e6\u00e8\u0003\u001c\u000e\u0000\u00e7\u00e4\u0001\u0000\u0000\u0000"+
		"\u00e8\u00eb\u0001\u0000\u0000\u0000\u00e9\u00e7\u0001\u0000\u0000\u0000"+
		"\u00e9\u00ea\u0001\u0000\u0000\u0000\u00ea\u001b\u0001\u0000\u0000\u0000"+
		"\u00eb\u00e9\u0001\u0000\u0000\u0000\u00ec\u00ed\u0006\u000e\uffff\uffff"+
		"\u0000\u00ed\u00ee\u0003\u001e\u000f\u0000\u00ee\u00f4\u0001\u0000\u0000"+
		"\u0000\u00ef\u00f0\n\u0001\u0000\u0000\u00f0\u00f1\u0005 \u0000\u0000"+
		"\u00f1\u00f3\u0003\u001e\u000f\u0000\u00f2\u00ef\u0001\u0000\u0000\u0000"+
		"\u00f3\u00f6\u0001\u0000\u0000\u0000\u00f4\u00f2\u0001\u0000\u0000\u0000"+
		"\u00f4\u00f5\u0001\u0000\u0000\u0000\u00f5\u001d\u0001\u0000\u0000\u0000"+
		"\u00f6\u00f4\u0001\u0000\u0000\u0000\u00f7\u00fb\u0003 \u0010\u0000\u00f8"+
		"\u00f9\u0005\u001f\u0000\u0000\u00f9\u00fb\u0003\u001e\u000f\u0000\u00fa"+
		"\u00f7\u0001\u0000\u0000\u0000\u00fa\u00f8\u0001\u0000\u0000\u0000\u00fb"+
		"\u001f\u0001\u0000\u0000\u0000\u00fc\u00fd\u0006\u0010\uffff\uffff\u0000"+
		"\u00fd\u00fe\u0003\"\u0011\u0000\u00fe\u0114\u0001\u0000\u0000\u0000\u00ff"+
		"\u0100\n\u0003\u0000\u0000\u0100\u0101\u0005#\u0000\u0000\u0101\u0102"+
		"\u0003\u000e\u0007\u0000\u0102\u0103\u0005$\u0000\u0000\u0103\u0113\u0001"+
		"\u0000\u0000\u0000\u0104\u0105\n\u0002\u0000\u0000\u0105\u0106\u0005!"+
		"\u0000\u0000\u0106\u0107\u0003\n\u0005\u0000\u0107\u0108\u0005\"\u0000"+
		"\u0000\u0108\u0113\u0001\u0000\u0000\u0000\u0109\u010a\n\u0001\u0000\u0000"+
		"\u010a\u010b\u0005,\u0000\u0000\u010b\u0110\u0005\u0018\u0000\u0000\u010c"+
		"\u010d\u0005!\u0000\u0000\u010d\u010e\u0003\f\u0006\u0000\u010e\u010f"+
		"\u0005\"\u0000\u0000\u010f\u0111\u0001\u0000\u0000\u0000\u0110\u010c\u0001"+
		"\u0000\u0000\u0000\u0110\u0111\u0001\u0000\u0000\u0000\u0111\u0113\u0001"+
		"\u0000\u0000\u0000\u0112\u00ff\u0001\u0000\u0000\u0000\u0112\u0104\u0001"+
		"\u0000\u0000\u0000\u0112\u0109\u0001\u0000\u0000\u0000\u0113\u0116\u0001"+
		"\u0000\u0000\u0000\u0114\u0112\u0001\u0000\u0000\u0000\u0114\u0115\u0001"+
		"\u0000\u0000\u0000\u0115!\u0001\u0000\u0000\u0000\u0116\u0114\u0001\u0000"+
		"\u0000\u0000\u0117\u0125\u0005\u0018\u0000\u0000\u0118\u0125\u0003$\u0012"+
		"\u0000\u0119\u0125\u0003&\u0013\u0000\u011a\u0125\u0003(\u0014\u0000\u011b"+
		"\u0125\u0003*\u0015\u0000\u011c\u0125\u00034\u001a\u0000\u011d\u0125\u0003"+
		"6\u001b\u0000\u011e\u0125\u00038\u001c\u0000\u011f\u0125\u0003:\u001d"+
		"\u0000\u0120\u0125\u0003<\u001e\u0000\u0121\u0125\u0003>\u001f\u0000\u0122"+
		"\u0125\u0003@ \u0000\u0123\u0125\u0003D\"\u0000\u0124\u0117\u0001\u0000"+
		"\u0000\u0000\u0124\u0118\u0001\u0000\u0000\u0000\u0124\u0119\u0001\u0000"+
		"\u0000\u0000\u0124\u011a\u0001\u0000\u0000\u0000\u0124\u011b\u0001\u0000"+
		"\u0000\u0000\u0124\u011c\u0001\u0000\u0000\u0000\u0124\u011d\u0001\u0000"+
		"\u0000\u0000\u0124\u011e\u0001\u0000\u0000\u0000\u0124\u011f\u0001\u0000"+
		"\u0000\u0000\u0124\u0120\u0001\u0000\u0000\u0000\u0124\u0121\u0001\u0000"+
		"\u0000\u0000\u0124\u0122\u0001\u0000\u0000\u0000\u0124\u0123\u0001\u0000"+
		"\u0000\u0000\u0125#\u0001\u0000\u0000\u0000\u0126\u012b\u0005\u0019\u0000"+
		"\u0000\u0127\u0128\u0005!\u0000\u0000\u0128\u0129\u0003\f\u0006\u0000"+
		"\u0129\u012a\u0005\"\u0000\u0000\u012a\u012c\u0001\u0000\u0000\u0000\u012b"+
		"\u0127\u0001\u0000\u0000\u0000\u012b\u012c\u0001\u0000\u0000\u0000\u012c"+
		"%\u0001\u0000\u0000\u0000\u012d\u012e\u0005#\u0000\u0000\u012e\u012f\u0003"+
		"\n\u0005\u0000\u012f\u0130\u0005$\u0000\u0000\u0130\'\u0001\u0000\u0000"+
		"\u0000\u0131\u0132\u0005%\u0000\u0000\u0132\u0133\u0003\n\u0005\u0000"+
		"\u0133\u0134\u0005&\u0000\u0000\u0134)\u0001\u0000\u0000\u0000\u0135\u013a"+
		"\u0003,\u0016\u0000\u0136\u013a\u0003.\u0017\u0000\u0137\u013a\u00030"+
		"\u0018\u0000\u0138\u013a\u00032\u0019\u0000\u0139\u0135\u0001\u0000\u0000"+
		"\u0000\u0139\u0136\u0001\u0000\u0000\u0000\u0139\u0137\u0001\u0000\u0000"+
		"\u0000\u0139\u0138\u0001\u0000\u0000\u0000\u013a+\u0001\u0000\u0000\u0000"+
		"\u013b\u013c\u0005\u0015\u0000\u0000\u013c-\u0001\u0000\u0000\u0000\u013d"+
		"\u013e\u0005\u0016\u0000\u0000\u013e/\u0001\u0000\u0000\u0000\u013f\u0140"+
		"\u0005\u0017\u0000\u0000\u01401\u0001\u0000\u0000\u0000\u0141\u0142\u0007"+
		"\u0000\u0000\u0000\u01423\u0001\u0000\u0000\u0000\u0143\u0144\u0005!\u0000"+
		"\u0000\u0144\u0145\u0003\u0002\u0001\u0000\u0145\u0146\u0005\"\u0000\u0000"+
		"\u01465\u0001\u0000\u0000\u0000\u0147\u0148\u0005\u0002\u0000\u0000\u0148"+
		"7\u0001\u0000\u0000\u0000\u0149\u014a\u0005\u000b\u0000\u0000\u014a\u014b"+
		"\u0003\u000e\u0007\u0000\u014b\u014c\u0005\f\u0000\u0000\u014c\u014d\u0003"+
		"\u0002\u0001\u0000\u014d\u014e\u0005\r\u0000\u0000\u014e9\u0001\u0000"+
		"\u0000\u0000\u014f\u0150\u0005\f\u0000\u0000\u0150\u0151\u0003\u0002\u0001"+
		"\u0000\u0151\u0152\u0005\u000b\u0000\u0000\u0152\u0153\u0003\u000e\u0007"+
		"\u0000\u0153\u0154\u0005\r\u0000\u0000\u0154;\u0001\u0000\u0000\u0000"+
		"\u0155\u0157\u0005\u000e\u0000\u0000\u0156\u0158\u0003\u0006\u0003\u0000"+
		"\u0157\u0156\u0001\u0000\u0000\u0000\u0157\u0158\u0001\u0000\u0000\u0000"+
		"\u0158\u0159\u0001\u0000\u0000\u0000\u0159\u015a\u0003\u000e\u0007\u0000"+
		"\u015a\u015b\u0005\'\u0000\u0000\u015b\u015c\u0003\u000e\u0007\u0000\u015c"+
		"\u015d\u0005\'\u0000\u0000\u015d\u015e\u0003\u000e\u0007\u0000\u015e\u015f"+
		"\u0005\f\u0000\u0000\u015f\u0160\u0003\u0002\u0001\u0000\u0160\u0161\u0005"+
		"\r\u0000\u0000\u0161=\u0001\u0000\u0000\u0000\u0162\u0163\u0005\u0003"+
		"\u0000\u0000\u0163\u0164\u0003\u000e\u0007\u0000\u0164\u0165\u0005\u0004"+
		"\u0000\u0000\u0165\u016d\u0003\u0002\u0001\u0000\u0166\u0167\u0005\u0006"+
		"\u0000\u0000\u0167\u0168\u0003\u000e\u0007\u0000\u0168\u0169\u0005\u0004"+
		"\u0000\u0000\u0169\u016a\u0003\u0002\u0001\u0000\u016a\u016c\u0001\u0000"+
		"\u0000\u0000\u016b\u0166\u0001\u0000\u0000\u0000\u016c\u016f\u0001\u0000"+
		"\u0000\u0000\u016d\u016b\u0001\u0000\u0000\u0000\u016d\u016e\u0001\u0000"+
		"\u0000\u0000\u016e\u0172\u0001\u0000\u0000\u0000\u016f\u016d\u0001\u0000"+
		"\u0000\u0000\u0170\u0171\u0005\u0005\u0000\u0000\u0171\u0173\u0003\u0002"+
		"\u0001\u0000\u0172\u0170\u0001\u0000\u0000\u0000\u0172\u0173\u0001\u0000"+
		"\u0000\u0000\u0173\u0174\u0001\u0000\u0000\u0000\u0174\u0175\u0005\u0007"+
		"\u0000\u0000\u0175?\u0001\u0000\u0000\u0000\u0176\u0177\u0005\b\u0000"+
		"\u0000\u0177\u0178\u0003\u000e\u0007\u0000\u0178\u0179\u0005\t\u0000\u0000"+
		"\u0179\u017e\u0003B!\u0000\u017a\u017b\u0005/\u0000\u0000\u017b\u017d"+
		"\u0003B!\u0000\u017c\u017a\u0001\u0000\u0000\u0000\u017d\u0180\u0001\u0000"+
		"\u0000\u0000\u017e\u017c\u0001\u0000\u0000\u0000\u017e\u017f\u0001\u0000"+
		"\u0000\u0000\u017f\u0181\u0001\u0000\u0000\u0000\u0180\u017e\u0001\u0000"+
		"\u0000\u0000\u0181\u0182\u0005\n\u0000\u0000\u0182A\u0001\u0000\u0000"+
		"\u0000\u0183\u0184\u0003F#\u0000\u0184\u0185\u0005.\u0000\u0000\u0185"+
		"\u0186\u0003\u000e\u0007\u0000\u0186C\u0001\u0000\u0000\u0000\u0187\u0188"+
		"\u0005\u0012\u0000\u0000\u0188\u0189\u0005!\u0000\u0000\u0189\u018a\u0003"+
		"\b\u0004\u0000\u018a\u018b\u0005\"\u0000\u0000\u018b\u018c\u0005%\u0000"+
		"\u0000\u018c\u018d\u0003\u0002\u0001\u0000\u018d\u018e\u0005&\u0000\u0000"+
		"\u018eE\u0001\u0000\u0000\u0000\u018f\u0199\u0003H$\u0000\u0190\u0195"+
		"\u0003H$\u0000\u0191\u0192\u0005(\u0000\u0000\u0192\u0194\u0003H$\u0000"+
		"\u0193\u0191\u0001\u0000\u0000\u0000\u0194\u0197\u0001\u0000\u0000\u0000"+
		"\u0195\u0193\u0001\u0000\u0000\u0000\u0195\u0196\u0001\u0000\u0000\u0000"+
		"\u0196\u0199\u0001\u0000\u0000\u0000\u0197\u0195\u0001\u0000\u0000\u0000"+
		"\u0198\u018f\u0001\u0000\u0000\u0000\u0198\u0190\u0001\u0000\u0000\u0000"+
		"\u0199G\u0001\u0000\u0000\u0000\u019a\u01a4\u0003N\'\u0000\u019b\u01a4"+
		"\u0003P(\u0000\u019c\u01a4\u0003R)\u0000\u019d\u01a4\u0003T*\u0000\u019e"+
		"\u01a4\u0003V+\u0000\u019f\u01a4\u0003X,\u0000\u01a0\u01a4\u0003Z-\u0000"+
		"\u01a1\u01a4\u0003^/\u0000\u01a2\u01a4\u0003\\.\u0000\u01a3\u019a\u0001"+
		"\u0000\u0000\u0000\u01a3\u019b\u0001\u0000\u0000\u0000\u01a3\u019c\u0001"+
		"\u0000\u0000\u0000\u01a3\u019d\u0001\u0000\u0000\u0000\u01a3\u019e\u0001"+
		"\u0000\u0000\u0000\u01a3\u019f\u0001\u0000\u0000\u0000\u01a3\u01a0\u0001"+
		"\u0000\u0000\u0000\u01a3\u01a1\u0001\u0000\u0000\u0000\u01a3\u01a2\u0001"+
		"\u0000\u0000\u0000\u01a4I\u0001\u0000\u0000\u0000\u01a5\u01af\u0001\u0000"+
		"\u0000\u0000\u01a6\u01ab\u0003F#\u0000\u01a7\u01a8\u0005\'\u0000\u0000"+
		"\u01a8\u01aa\u0003F#\u0000\u01a9\u01a7\u0001\u0000\u0000\u0000\u01aa\u01ad"+
		"\u0001\u0000\u0000\u0000\u01ab\u01a9\u0001\u0000\u0000\u0000\u01ab\u01ac"+
		"\u0001\u0000\u0000\u0000\u01ac\u01af\u0001\u0000\u0000\u0000\u01ad\u01ab"+
		"\u0001\u0000\u0000\u0000\u01ae\u01a5\u0001\u0000\u0000\u0000\u01ae\u01a6"+
		"\u0001\u0000\u0000\u0000\u01afK\u0001\u0000\u0000\u0000\u01b0\u01b5\u0003"+
		"F#\u0000\u01b1\u01b2\u0005\'\u0000\u0000\u01b2\u01b4\u0003F#\u0000\u01b3"+
		"\u01b1\u0001\u0000\u0000\u0000\u01b4\u01b7\u0001\u0000\u0000\u0000\u01b5"+
		"\u01b3\u0001\u0000\u0000\u0000\u01b5\u01b6\u0001\u0000\u0000\u0000\u01b6"+
		"M\u0001\u0000\u0000\u0000\u01b7\u01b5\u0001\u0000\u0000\u0000\u01b8\u01b9"+
		"\u0005!\u0000\u0000\u01b9\u01ba\u0003F#\u0000\u01ba\u01bb\u0005\"\u0000"+
		"\u0000\u01bbO\u0001\u0000\u0000\u0000\u01bc\u01bd\u0003*\u0015\u0000\u01bd"+
		"Q\u0001\u0000\u0000\u0000\u01be\u01c3\u0005\u0018\u0000\u0000\u01bf\u01c0"+
		"\u0005\u0018\u0000\u0000\u01c0\u01c1\u0005-\u0000\u0000\u01c1\u01c3\u0003"+
		"H$\u0000\u01c2\u01be\u0001\u0000\u0000\u0000\u01c2\u01bf\u0001\u0000\u0000"+
		"\u0000\u01c3S\u0001\u0000\u0000\u0000\u01c4\u01c9\u0005\u0019\u0000\u0000"+
		"\u01c5\u01c6\u0005!\u0000\u0000\u01c6\u01c7\u0003L&\u0000\u01c7\u01c8"+
		"\u0005\"\u0000\u0000\u01c8\u01ca\u0001\u0000\u0000\u0000\u01c9\u01c5\u0001"+
		"\u0000\u0000\u0000\u01c9\u01ca\u0001\u0000\u0000\u0000\u01caU\u0001\u0000"+
		"\u0000\u0000\u01cb\u01cc\u0005#\u0000\u0000\u01cc\u01cd\u0003J%\u0000"+
		"\u01cd\u01ce\u0005$\u0000\u0000\u01ceW\u0001\u0000\u0000\u0000\u01cf\u01d0"+
		"\u0005%\u0000\u0000\u01d0\u01d1\u0003J%\u0000\u01d1\u01d2\u0005&\u0000"+
		"\u0000\u01d2Y\u0001\u0000\u0000\u0000\u01d3\u01d4\u00051\u0000\u0000\u01d4"+
		"[\u0001\u0000\u0000\u0000\u01d5\u01d6\u00050\u0000\u0000\u01d6]\u0001"+
		"\u0000\u0000\u0000\u01d7\u01d8\u00052\u0000\u0000\u01d8_\u0001\u0000\u0000"+
		"\u0000%fjow\u0085\u008d\u0090\u0098\u009b\u00a2\u00b1\u00b9\u00c0\u00cc"+
		"\u00d7\u00df\u00e9\u00f4\u00fa\u0110\u0112\u0114\u0124\u012b\u0139\u0157"+
		"\u016d\u0172\u017e\u0195\u0198\u01a3\u01ab\u01ae\u01b5\u01c2\u01c9";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}