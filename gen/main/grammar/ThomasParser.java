// Generated from E:/UT/S6/TA/Compiler/Joey-Compiler/src/main/grammar\Thomas.g4 by ANTLR 4.9.2
package main.grammar;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ThomasParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		CLASS=1, PUBLIC=2, PRIVATE=3, INITIALIZE=4, NEW=5, MAIN=6, RETURN=7, VOID=8, 
		DELETE=9, INCLUDE=10, ADD=11, MERGE=12, PRINT=13, IF=14, ELSE=15, ELSIF=16, 
		PLUS=17, MINUS=18, MULT=19, DIVIDE=20, INC=21, DEC=22, EQUAL=23, GREATER_THAN=24, 
		LESS_THAN=25, ARROW=26, BAR=27, AND=28, OR=29, NOT=30, TIF=31, TELSE=32, 
		TRUE=33, FALSE=34, NULL=35, BEGIN=36, END=37, INT=38, BOOL=39, FPTR=40, 
		SET=41, EACH=42, DO=43, ASSIGN=44, SHARP=45, LPAR=46, RPAR=47, LBRACK=48, 
		RBRACK=49, LBRACE=50, RBRACE=51, COMMA=52, DOT=53, SEMICOLON=54, NEWLINE=55, 
		INT_VALUE=56, IDENTIFIER=57, CLASS_IDENTIFIER=58, COMMENT=59, MLCOMMENT=60, 
		WS=61, LINE_BREAK=62;
	public static final int
		RULE_thomas = 0, RULE_program = 1, RULE_constructor = 2, RULE_classDeclaration = 3, 
		RULE_field_decleration = 4, RULE_method = 5, RULE_methodArgsDec = 6, RULE_argDec = 7, 
		RULE_methodArgs = 8, RULE_body = 9, RULE_blockStatement = 10, RULE_singleStatement = 11, 
		RULE_addStatement = 12, RULE_mergeStatement = 13, RULE_deleteStatement = 14, 
		RULE_varDecStatement = 15, RULE_ifStatement = 16, RULE_elsifStatement = 17, 
		RULE_elseStatement = 18, RULE_printStatement = 19, RULE_methodCallStmt = 20, 
		RULE_returnStatement = 21, RULE_assignmentStatement = 22, RULE_loopStatement = 23, 
		RULE_expression = 24, RULE_ternaryExpression = 25, RULE_orExpression = 26, 
		RULE_andExpression = 27, RULE_equalityExpression = 28, RULE_relationalExpression = 29, 
		RULE_additiveExpression = 30, RULE_multiplicativeExpression = 31, RULE_preUnaryExpression = 32, 
		RULE_postUnaryExpression = 33, RULE_accessExpression = 34, RULE_otherExpression = 35, 
		RULE_accessByIndex = 36, RULE_setNew = 37, RULE_setInclude = 38, RULE_value = 39, 
		RULE_boolValue = 40, RULE_class_identifier = 41, RULE_identifier = 42, 
		RULE_type = 43, RULE_array_type = 44, RULE_fptr_type = 45, RULE_set_type = 46;
	private static String[] makeRuleNames() {
		return new String[] {
			"thomas", "program", "constructor", "classDeclaration", "field_decleration", 
			"method", "methodArgsDec", "argDec", "methodArgs", "body", "blockStatement", 
			"singleStatement", "addStatement", "mergeStatement", "deleteStatement", 
			"varDecStatement", "ifStatement", "elsifStatement", "elseStatement", 
			"printStatement", "methodCallStmt", "returnStatement", "assignmentStatement", 
			"loopStatement", "expression", "ternaryExpression", "orExpression", "andExpression", 
			"equalityExpression", "relationalExpression", "additiveExpression", "multiplicativeExpression", 
			"preUnaryExpression", "postUnaryExpression", "accessExpression", "otherExpression", 
			"accessByIndex", "setNew", "setInclude", "value", "boolValue", "class_identifier", 
			"identifier", "type", "array_type", "fptr_type", "set_type"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'class'", "'public'", "'private'", "'initialize'", "'new'", "'main'", 
			"'return'", "'void'", "'delete'", "'include'", "'add'", "'merge'", "'print'", 
			"'if'", "'else'", "'elsif'", "'+'", "'-'", "'*'", "'/'", "'++'", "'--'", 
			"'=='", "'>'", "'<'", "'->'", "'|'", "'&&'", "'||'", "'!'", "'?'", "':'", 
			"'true'", "'false'", "'null'", "'=begin'", "'=end'", "'int'", "'bool'", 
			"'fptr'", "'Set'", "'each'", "'do'", "'='", "'#'", "'('", "')'", "'['", 
			"']'", "'{'", "'}'", "','", "'.'", "';'", "'\n'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "CLASS", "PUBLIC", "PRIVATE", "INITIALIZE", "NEW", "MAIN", "RETURN", 
			"VOID", "DELETE", "INCLUDE", "ADD", "MERGE", "PRINT", "IF", "ELSE", "ELSIF", 
			"PLUS", "MINUS", "MULT", "DIVIDE", "INC", "DEC", "EQUAL", "GREATER_THAN", 
			"LESS_THAN", "ARROW", "BAR", "AND", "OR", "NOT", "TIF", "TELSE", "TRUE", 
			"FALSE", "NULL", "BEGIN", "END", "INT", "BOOL", "FPTR", "SET", "EACH", 
			"DO", "ASSIGN", "SHARP", "LPAR", "RPAR", "LBRACK", "RBRACK", "LBRACE", 
			"RBRACE", "COMMA", "DOT", "SEMICOLON", "NEWLINE", "INT_VALUE", "IDENTIFIER", 
			"CLASS_IDENTIFIER", "COMMENT", "MLCOMMENT", "WS", "LINE_BREAK"
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
	public String getGrammarFileName() { return "Thomas.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ThomasParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ThomasContext extends ParserRuleContext {
		public ProgramContext p;
		public TerminalNode EOF() { return getToken(ThomasParser.EOF, 0); }
		public ProgramContext program() {
			return getRuleContext(ProgramContext.class,0);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(ThomasParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(ThomasParser.NEWLINE, i);
		}
		public ThomasContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_thomas; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ThomasListener ) ((ThomasListener)listener).enterThomas(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ThomasListener ) ((ThomasListener)listener).exitThomas(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ThomasVisitor ) return ((ThomasVisitor<? extends T>)visitor).visitThomas(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ThomasContext thomas() throws RecognitionException {
		ThomasContext _localctx = new ThomasContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_thomas);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(97);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(94);
					match(NEWLINE);
					}
					} 
				}
				setState(99);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			setState(100);
			((ThomasContext)_localctx).p = program();
			setState(104);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEWLINE) {
				{
				{
				setState(101);
				match(NEWLINE);
				}
				}
				setState(106);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(107);
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

	public static class ProgramContext extends ParserRuleContext {
		public List<ClassDeclarationContext> classDeclaration() {
			return getRuleContexts(ClassDeclarationContext.class);
		}
		public ClassDeclarationContext classDeclaration(int i) {
			return getRuleContext(ClassDeclarationContext.class,i);
		}
		public List<VarDecStatementContext> varDecStatement() {
			return getRuleContexts(VarDecStatementContext.class);
		}
		public VarDecStatementContext varDecStatement(int i) {
			return getRuleContext(VarDecStatementContext.class,i);
		}
		public List<TerminalNode> SEMICOLON() { return getTokens(ThomasParser.SEMICOLON); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(ThomasParser.SEMICOLON, i);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(ThomasParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(ThomasParser.NEWLINE, i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ThomasListener ) ((ThomasListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ThomasListener ) ((ThomasListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ThomasVisitor ) return ((ThomasVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_program);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(120);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << BOOL) | (1L << FPTR) | (1L << SET) | (1L << CLASS_IDENTIFIER))) != 0)) {
				{
				{
				setState(109);
				varDecStatement();
				setState(111);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SEMICOLON) {
					{
					setState(110);
					match(SEMICOLON);
					}
				}

				setState(114); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(113);
						match(NEWLINE);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(116); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				}
				setState(122);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(131);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(123);
					classDeclaration();
					setState(125); 
					_errHandler.sync(this);
					_alt = 1;
					do {
						switch (_alt) {
						case 1:
							{
							{
							setState(124);
							match(NEWLINE);
							}
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(127); 
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
					} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
					}
					} 
				}
				setState(133);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			}
			setState(136);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CLASS:
				{
				setState(134);
				classDeclaration();
				}
				break;
			case EOF:
			case NEWLINE:
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class ConstructorContext extends ParserRuleContext {
		public TerminalNode INITIALIZE() { return getToken(ThomasParser.INITIALIZE, 0); }
		public MethodArgsDecContext methodArgsDec() {
			return getRuleContext(MethodArgsDecContext.class,0);
		}
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public ConstructorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constructor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ThomasListener ) ((ThomasListener)listener).enterConstructor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ThomasListener ) ((ThomasListener)listener).exitConstructor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ThomasVisitor ) return ((ThomasVisitor<? extends T>)visitor).visitConstructor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstructorContext constructor() throws RecognitionException {
		ConstructorContext _localctx = new ConstructorContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_constructor);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(138);
			match(INITIALIZE);
			setState(139);
			methodArgsDec();
			setState(140);
			body();
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

	public static class ClassDeclarationContext extends ParserRuleContext {
		public Token CLASS_IDENTIFIER;
		public Token PR;
		public TerminalNode CLASS() { return getToken(ThomasParser.CLASS, 0); }
		public List<TerminalNode> CLASS_IDENTIFIER() { return getTokens(ThomasParser.CLASS_IDENTIFIER); }
		public TerminalNode CLASS_IDENTIFIER(int i) {
			return getToken(ThomasParser.CLASS_IDENTIFIER, i);
		}
		public TerminalNode LBRACE() { return getToken(ThomasParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(ThomasParser.RBRACE, 0); }
		public TerminalNode LESS_THAN() { return getToken(ThomasParser.LESS_THAN, 0); }
		public List<TerminalNode> NEWLINE() { return getTokens(ThomasParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(ThomasParser.NEWLINE, i);
		}
		public List<Field_declerationContext> field_decleration() {
			return getRuleContexts(Field_declerationContext.class);
		}
		public Field_declerationContext field_decleration(int i) {
			return getRuleContext(Field_declerationContext.class,i);
		}
		public ClassDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ThomasListener ) ((ThomasListener)listener).enterClassDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ThomasListener ) ((ThomasListener)listener).exitClassDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ThomasVisitor ) return ((ThomasVisitor<? extends T>)visitor).visitClassDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassDeclarationContext classDeclaration() throws RecognitionException {
		ClassDeclarationContext _localctx = new ClassDeclarationContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_classDeclaration);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(142);
			match(CLASS);
			setState(143);
			((ClassDeclarationContext)_localctx).CLASS_IDENTIFIER = match(CLASS_IDENTIFIER);
			System.out.println("ClassDec : " + ((ClassDeclarationContext)_localctx).CLASS_IDENTIFIER.getText());
			setState(148);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LESS_THAN) {
				{
				setState(145);
				match(LESS_THAN);
				setState(146);
				((ClassDeclarationContext)_localctx).PR = match(CLASS_IDENTIFIER);
				System.out.println("Inheritance : " + ((ClassDeclarationContext)_localctx).CLASS_IDENTIFIER.getText() + " < " + ((ClassDeclarationContext)_localctx).PR.getText());
				}
			}

			setState(153);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEWLINE) {
				{
				{
				setState(150);
				match(NEWLINE);
				}
				}
				setState(155);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(156);
			match(LBRACE);
			setState(158); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(157);
				match(NEWLINE);
				}
				}
				setState(160); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NEWLINE );
			setState(165);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PUBLIC || _la==PRIVATE) {
				{
				{
				setState(162);
				field_decleration();
				}
				}
				setState(167);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(168);
			match(RBRACE);
			setState(172);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(169);
					match(NEWLINE);
					}
					} 
				}
				setState(174);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
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

	public static class Field_declerationContext extends ParserRuleContext {
		public TerminalNode PUBLIC() { return getToken(ThomasParser.PUBLIC, 0); }
		public TerminalNode PRIVATE() { return getToken(ThomasParser.PRIVATE, 0); }
		public VarDecStatementContext varDecStatement() {
			return getRuleContext(VarDecStatementContext.class,0);
		}
		public MethodContext method() {
			return getRuleContext(MethodContext.class,0);
		}
		public ConstructorContext constructor() {
			return getRuleContext(ConstructorContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(ThomasParser.SEMICOLON, 0); }
		public List<TerminalNode> NEWLINE() { return getTokens(ThomasParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(ThomasParser.NEWLINE, i);
		}
		public Field_declerationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_field_decleration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ThomasListener ) ((ThomasListener)listener).enterField_decleration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ThomasListener ) ((ThomasListener)listener).exitField_decleration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ThomasVisitor ) return ((ThomasVisitor<? extends T>)visitor).visitField_decleration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Field_declerationContext field_decleration() throws RecognitionException {
		Field_declerationContext _localctx = new Field_declerationContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_field_decleration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(175);
			_la = _input.LA(1);
			if ( !(_la==PUBLIC || _la==PRIVATE) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(179);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				{
				setState(176);
				varDecStatement();
				}
				break;
			case 2:
				{
				setState(177);
				method();
				}
				break;
			case 3:
				{
				setState(178);
				constructor();
				}
				break;
			}
			setState(182);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SEMICOLON) {
				{
				setState(181);
				match(SEMICOLON);
				}
			}

			setState(185); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(184);
				match(NEWLINE);
				}
				}
				setState(187); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NEWLINE );
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

	public static class MethodContext extends ParserRuleContext {
		public Token IDENTIFIER;
		public TerminalNode IDENTIFIER() { return getToken(ThomasParser.IDENTIFIER, 0); }
		public MethodArgsDecContext methodArgsDec() {
			return getRuleContext(MethodArgsDecContext.class,0);
		}
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode VOID() { return getToken(ThomasParser.VOID, 0); }
		public List<TerminalNode> NEWLINE() { return getTokens(ThomasParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(ThomasParser.NEWLINE, i);
		}
		public MethodContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_method; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ThomasListener ) ((ThomasListener)listener).enterMethod(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ThomasListener ) ((ThomasListener)listener).exitMethod(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ThomasVisitor ) return ((ThomasVisitor<? extends T>)visitor).visitMethod(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodContext method() throws RecognitionException {
		MethodContext _localctx = new MethodContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_method);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(191);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
			case BOOL:
			case FPTR:
			case SET:
			case CLASS_IDENTIFIER:
				{
				setState(189);
				type();
				}
				break;
			case VOID:
				{
				setState(190);
				match(VOID);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(193);
			((MethodContext)_localctx).IDENTIFIER = match(IDENTIFIER);
			System.out.println("MethodDec : " + ((MethodContext)_localctx).IDENTIFIER.getText());
			setState(195);
			methodArgsDec();
			setState(199);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(196);
					match(NEWLINE);
					}
					} 
				}
				setState(201);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			}
			setState(202);
			body();
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

	public static class MethodArgsDecContext extends ParserRuleContext {
		public TerminalNode LPAR() { return getToken(ThomasParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(ThomasParser.RPAR, 0); }
		public List<ArgDecContext> argDec() {
			return getRuleContexts(ArgDecContext.class);
		}
		public ArgDecContext argDec(int i) {
			return getRuleContext(ArgDecContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(ThomasParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ThomasParser.COMMA, i);
		}
		public MethodArgsDecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodArgsDec; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ThomasListener ) ((ThomasListener)listener).enterMethodArgsDec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ThomasListener ) ((ThomasListener)listener).exitMethodArgsDec(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ThomasVisitor ) return ((ThomasVisitor<? extends T>)visitor).visitMethodArgsDec(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodArgsDecContext methodArgsDec() throws RecognitionException {
		MethodArgsDecContext _localctx = new MethodArgsDecContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_methodArgsDec);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(204);
			match(LPAR);
			setState(213);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << BOOL) | (1L << FPTR) | (1L << SET) | (1L << CLASS_IDENTIFIER))) != 0)) {
				{
				setState(205);
				argDec();
				setState(210);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(206);
					match(COMMA);
					setState(207);
					argDec();
					}
					}
					setState(212);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(215);
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

	public static class ArgDecContext extends ParserRuleContext {
		public Token IDENTIFIER;
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(ThomasParser.IDENTIFIER, 0); }
		public TerminalNode ASSIGN() { return getToken(ThomasParser.ASSIGN, 0); }
		public OrExpressionContext orExpression() {
			return getRuleContext(OrExpressionContext.class,0);
		}
		public ArgDecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argDec; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ThomasListener ) ((ThomasListener)listener).enterArgDec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ThomasListener ) ((ThomasListener)listener).exitArgDec(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ThomasVisitor ) return ((ThomasVisitor<? extends T>)visitor).visitArgDec(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgDecContext argDec() throws RecognitionException {
		ArgDecContext _localctx = new ArgDecContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_argDec);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(217);
			type();
			setState(218);
			((ArgDecContext)_localctx).IDENTIFIER = match(IDENTIFIER);
			System.out.println("ArgumentDec : " + ((ArgDecContext)_localctx).IDENTIFIER.getText());
			setState(222);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASSIGN) {
				{
				setState(220);
				match(ASSIGN);
				setState(221);
				orExpression();
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

	public static class MethodArgsContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(ThomasParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ThomasParser.COMMA, i);
		}
		public MethodArgsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodArgs; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ThomasListener ) ((ThomasListener)listener).enterMethodArgs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ThomasListener ) ((ThomasListener)listener).exitMethodArgs(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ThomasVisitor ) return ((ThomasVisitor<? extends T>)visitor).visitMethodArgs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodArgsContext methodArgs() throws RecognitionException {
		MethodArgsContext _localctx = new MethodArgsContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_methodArgs);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(232);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MINUS) | (1L << NOT) | (1L << TRUE) | (1L << FALSE) | (1L << SET) | (1L << LPAR) | (1L << INT_VALUE) | (1L << IDENTIFIER))) != 0)) {
				{
				setState(224);
				expression();
				setState(229);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(225);
					match(COMMA);
					setState(226);
					expression();
					}
					}
					setState(231);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
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

	public static class BodyContext extends ParserRuleContext {
		public BlockStatementContext blockStatement() {
			return getRuleContext(BlockStatementContext.class,0);
		}
		public SingleStatementContext singleStatement() {
			return getRuleContext(SingleStatementContext.class,0);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(ThomasParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(ThomasParser.NEWLINE, i);
		}
		public TerminalNode SEMICOLON() { return getToken(ThomasParser.SEMICOLON, 0); }
		public BodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_body; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ThomasListener ) ((ThomasListener)listener).enterBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ThomasListener ) ((ThomasListener)listener).exitBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ThomasVisitor ) return ((ThomasVisitor<? extends T>)visitor).visitBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BodyContext body() throws RecognitionException {
		BodyContext _localctx = new BodyContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_body);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(244);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LBRACE:
				{
				setState(234);
				blockStatement();
				}
				break;
			case NEWLINE:
				{
				{
				setState(236); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(235);
					match(NEWLINE);
					}
					}
					setState(238); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==NEWLINE );
				setState(240);
				singleStatement();
				setState(242);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
				case 1:
					{
					setState(241);
					match(SEMICOLON);
					}
					break;
				}
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class BlockStatementContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(ThomasParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(ThomasParser.RBRACE, 0); }
		public List<SingleStatementContext> singleStatement() {
			return getRuleContexts(SingleStatementContext.class);
		}
		public SingleStatementContext singleStatement(int i) {
			return getRuleContext(SingleStatementContext.class,i);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(ThomasParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(ThomasParser.NEWLINE, i);
		}
		public List<TerminalNode> SEMICOLON() { return getTokens(ThomasParser.SEMICOLON); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(ThomasParser.SEMICOLON, i);
		}
		public BlockStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blockStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ThomasListener ) ((ThomasListener)listener).enterBlockStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ThomasListener ) ((ThomasListener)listener).exitBlockStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ThomasVisitor ) return ((ThomasVisitor<? extends T>)visitor).visitBlockStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockStatementContext blockStatement() throws RecognitionException {
		BlockStatementContext _localctx = new BlockStatementContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_blockStatement);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(246);
			match(LBRACE);
			setState(256); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(248); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(247);
						match(NEWLINE);
						}
						}
						setState(250); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==NEWLINE );
					setState(252);
					singleStatement();
					setState(254);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==SEMICOLON) {
						{
						setState(253);
						match(SEMICOLON);
						}
					}

					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(258); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(261); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(260);
				match(NEWLINE);
				}
				}
				setState(263); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NEWLINE );
			setState(265);
			match(RBRACE);
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

	public static class SingleStatementContext extends ParserRuleContext {
		public IfStatementContext ifStatement() {
			return getRuleContext(IfStatementContext.class,0);
		}
		public PrintStatementContext printStatement() {
			return getRuleContext(PrintStatementContext.class,0);
		}
		public MethodCallStmtContext methodCallStmt() {
			return getRuleContext(MethodCallStmtContext.class,0);
		}
		public ReturnStatementContext returnStatement() {
			return getRuleContext(ReturnStatementContext.class,0);
		}
		public AssignmentStatementContext assignmentStatement() {
			return getRuleContext(AssignmentStatementContext.class,0);
		}
		public VarDecStatementContext varDecStatement() {
			return getRuleContext(VarDecStatementContext.class,0);
		}
		public LoopStatementContext loopStatement() {
			return getRuleContext(LoopStatementContext.class,0);
		}
		public AddStatementContext addStatement() {
			return getRuleContext(AddStatementContext.class,0);
		}
		public MergeStatementContext mergeStatement() {
			return getRuleContext(MergeStatementContext.class,0);
		}
		public DeleteStatementContext deleteStatement() {
			return getRuleContext(DeleteStatementContext.class,0);
		}
		public SingleStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_singleStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ThomasListener ) ((ThomasListener)listener).enterSingleStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ThomasListener ) ((ThomasListener)listener).exitSingleStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ThomasVisitor ) return ((ThomasVisitor<? extends T>)visitor).visitSingleStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SingleStatementContext singleStatement() throws RecognitionException {
		SingleStatementContext _localctx = new SingleStatementContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_singleStatement);
		try {
			setState(277);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(267);
				ifStatement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(268);
				printStatement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(269);
				methodCallStmt();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(270);
				returnStatement();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(271);
				assignmentStatement();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(272);
				varDecStatement();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(273);
				loopStatement();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(274);
				addStatement();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(275);
				mergeStatement();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(276);
				deleteStatement();
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

	public static class AddStatementContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode DOT() { return getToken(ThomasParser.DOT, 0); }
		public TerminalNode ADD() { return getToken(ThomasParser.ADD, 0); }
		public TerminalNode LPAR() { return getToken(ThomasParser.LPAR, 0); }
		public OrExpressionContext orExpression() {
			return getRuleContext(OrExpressionContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(ThomasParser.RPAR, 0); }
		public AddStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_addStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ThomasListener ) ((ThomasListener)listener).enterAddStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ThomasListener ) ((ThomasListener)listener).exitAddStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ThomasVisitor ) return ((ThomasVisitor<? extends T>)visitor).visitAddStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AddStatementContext addStatement() throws RecognitionException {
		AddStatementContext _localctx = new AddStatementContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_addStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(279);
			identifier();
			setState(280);
			match(DOT);
			setState(281);
			match(ADD);
			System.out.println("ADD");
			setState(283);
			match(LPAR);
			setState(284);
			orExpression();
			setState(285);
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

	public static class MergeStatementContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode DOT() { return getToken(ThomasParser.DOT, 0); }
		public TerminalNode MERGE() { return getToken(ThomasParser.MERGE, 0); }
		public TerminalNode LPAR() { return getToken(ThomasParser.LPAR, 0); }
		public List<OrExpressionContext> orExpression() {
			return getRuleContexts(OrExpressionContext.class);
		}
		public OrExpressionContext orExpression(int i) {
			return getRuleContext(OrExpressionContext.class,i);
		}
		public TerminalNode RPAR() { return getToken(ThomasParser.RPAR, 0); }
		public List<TerminalNode> COMMA() { return getTokens(ThomasParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ThomasParser.COMMA, i);
		}
		public MergeStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mergeStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ThomasListener ) ((ThomasListener)listener).enterMergeStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ThomasListener ) ((ThomasListener)listener).exitMergeStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ThomasVisitor ) return ((ThomasVisitor<? extends T>)visitor).visitMergeStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MergeStatementContext mergeStatement() throws RecognitionException {
		MergeStatementContext _localctx = new MergeStatementContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_mergeStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(287);
			identifier();
			setState(288);
			match(DOT);
			setState(289);
			match(MERGE);
			System.out.println("MERGE");
			setState(291);
			match(LPAR);
			setState(292);
			orExpression();
			setState(297);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(293);
				match(COMMA);
				setState(294);
				orExpression();
				}
				}
				setState(299);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(300);
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

	public static class DeleteStatementContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode DOT() { return getToken(ThomasParser.DOT, 0); }
		public TerminalNode DELETE() { return getToken(ThomasParser.DELETE, 0); }
		public TerminalNode LPAR() { return getToken(ThomasParser.LPAR, 0); }
		public OrExpressionContext orExpression() {
			return getRuleContext(OrExpressionContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(ThomasParser.RPAR, 0); }
		public DeleteStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_deleteStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ThomasListener ) ((ThomasListener)listener).enterDeleteStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ThomasListener ) ((ThomasListener)listener).exitDeleteStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ThomasVisitor ) return ((ThomasVisitor<? extends T>)visitor).visitDeleteStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeleteStatementContext deleteStatement() throws RecognitionException {
		DeleteStatementContext _localctx = new DeleteStatementContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_deleteStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(302);
			identifier();
			setState(303);
			match(DOT);
			setState(304);
			match(DELETE);
			System.out.println("DELETE");
			setState(306);
			match(LPAR);
			setState(307);
			orExpression();
			setState(308);
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

	public static class VarDecStatementContext extends ParserRuleContext {
		public Token IDENTIFIER;
		public Token ID2;
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<TerminalNode> IDENTIFIER() { return getTokens(ThomasParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(ThomasParser.IDENTIFIER, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(ThomasParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ThomasParser.COMMA, i);
		}
		public VarDecStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDecStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ThomasListener ) ((ThomasListener)listener).enterVarDecStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ThomasListener ) ((ThomasListener)listener).exitVarDecStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ThomasVisitor ) return ((ThomasVisitor<? extends T>)visitor).visitVarDecStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarDecStatementContext varDecStatement() throws RecognitionException {
		VarDecStatementContext _localctx = new VarDecStatementContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_varDecStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(310);
			type();
			setState(311);
			((VarDecStatementContext)_localctx).IDENTIFIER = match(IDENTIFIER);
			System.out.println("VarDec : " + ((VarDecStatementContext)_localctx).IDENTIFIER.getText());
			setState(318);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(313);
				match(COMMA);
				setState(314);
				((VarDecStatementContext)_localctx).ID2 = match(IDENTIFIER);
				System.out.println("VarDec : " + ((VarDecStatementContext)_localctx).ID2.getText());
				}
				}
				setState(320);
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

	public static class IfStatementContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(ThomasParser.IF, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public TerminalNode LPAR() { return getToken(ThomasParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(ThomasParser.RPAR, 0); }
		public List<ElsifStatementContext> elsifStatement() {
			return getRuleContexts(ElsifStatementContext.class);
		}
		public ElsifStatementContext elsifStatement(int i) {
			return getRuleContext(ElsifStatementContext.class,i);
		}
		public ElseStatementContext elseStatement() {
			return getRuleContext(ElseStatementContext.class,0);
		}
		public IfStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ThomasListener ) ((ThomasListener)listener).enterIfStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ThomasListener ) ((ThomasListener)listener).exitIfStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ThomasVisitor ) return ((ThomasVisitor<? extends T>)visitor).visitIfStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfStatementContext ifStatement() throws RecognitionException {
		IfStatementContext _localctx = new IfStatementContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_ifStatement);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(321);
			match(IF);
			System.out.println("Conditional : if");
			setState(325);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
			case 1:
				{
				setState(323);
				match(LPAR);
				}
				break;
			case 2:
				{
				}
				break;
			}
			setState(327);
			expression();
			setState(330);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case RPAR:
				{
				setState(328);
				match(RPAR);
				}
				break;
			case LBRACE:
			case NEWLINE:
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(332);
			body();
			setState(336);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,35,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(333);
					elsifStatement();
					}
					} 
				}
				setState(338);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,35,_ctx);
			}
			setState(340);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,36,_ctx) ) {
			case 1:
				{
				setState(339);
				elseStatement();
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

	public static class ElsifStatementContext extends ParserRuleContext {
		public TerminalNode ELSIF() { return getToken(ThomasParser.ELSIF, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public TerminalNode LPAR() { return getToken(ThomasParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(ThomasParser.RPAR, 0); }
		public List<TerminalNode> NEWLINE() { return getTokens(ThomasParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(ThomasParser.NEWLINE, i);
		}
		public ElsifStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elsifStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ThomasListener ) ((ThomasListener)listener).enterElsifStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ThomasListener ) ((ThomasListener)listener).exitElsifStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ThomasVisitor ) return ((ThomasVisitor<? extends T>)visitor).visitElsifStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElsifStatementContext elsifStatement() throws RecognitionException {
		ElsifStatementContext _localctx = new ElsifStatementContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_elsifStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(345);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEWLINE) {
				{
				{
				setState(342);
				match(NEWLINE);
				}
				}
				setState(347);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(348);
			match(ELSIF);
			System.out.println("Conditional : elsif");
			setState(352);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,38,_ctx) ) {
			case 1:
				{
				setState(350);
				match(LPAR);
				}
				break;
			case 2:
				{
				}
				break;
			}
			setState(354);
			expression();
			setState(357);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case RPAR:
				{
				setState(355);
				match(RPAR);
				}
				break;
			case LBRACE:
			case NEWLINE:
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(359);
			body();
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

	public static class ElseStatementContext extends ParserRuleContext {
		public TerminalNode ELSE() { return getToken(ThomasParser.ELSE, 0); }
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(ThomasParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(ThomasParser.NEWLINE, i);
		}
		public ElseStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elseStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ThomasListener ) ((ThomasListener)listener).enterElseStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ThomasListener ) ((ThomasListener)listener).exitElseStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ThomasVisitor ) return ((ThomasVisitor<? extends T>)visitor).visitElseStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElseStatementContext elseStatement() throws RecognitionException {
		ElseStatementContext _localctx = new ElseStatementContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_elseStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(364);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEWLINE) {
				{
				{
				setState(361);
				match(NEWLINE);
				}
				}
				setState(366);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(367);
			match(ELSE);
			System.out.println("Conditional : else");
			setState(369);
			body();
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

	public static class PrintStatementContext extends ParserRuleContext {
		public TerminalNode PRINT() { return getToken(ThomasParser.PRINT, 0); }
		public TerminalNode LPAR() { return getToken(ThomasParser.LPAR, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(ThomasParser.RPAR, 0); }
		public PrintStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_printStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ThomasListener ) ((ThomasListener)listener).enterPrintStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ThomasListener ) ((ThomasListener)listener).exitPrintStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ThomasVisitor ) return ((ThomasVisitor<? extends T>)visitor).visitPrintStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrintStatementContext printStatement() throws RecognitionException {
		PrintStatementContext _localctx = new PrintStatementContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_printStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(371);
			match(PRINT);
			System.out.println("Built-in : print");
			setState(373);
			match(LPAR);
			setState(374);
			expression();
			setState(375);
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

	public static class MethodCallStmtContext extends ParserRuleContext {
		public Token op;
		public OtherExpressionContext otherExpression() {
			return getRuleContext(OtherExpressionContext.class,0);
		}
		public List<TerminalNode> DOT() { return getTokens(ThomasParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(ThomasParser.DOT, i);
		}
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public TerminalNode LPAR() { return getToken(ThomasParser.LPAR, 0); }
		public MethodArgsContext methodArgs() {
			return getRuleContext(MethodArgsContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(ThomasParser.RPAR, 0); }
		public TerminalNode INC() { return getToken(ThomasParser.INC, 0); }
		public TerminalNode DEC() { return getToken(ThomasParser.DEC, 0); }
		public MethodCallStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodCallStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ThomasListener ) ((ThomasListener)listener).enterMethodCallStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ThomasListener ) ((ThomasListener)listener).exitMethodCallStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ThomasVisitor ) return ((ThomasVisitor<? extends T>)visitor).visitMethodCallStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodCallStmtContext methodCallStmt() throws RecognitionException {
		MethodCallStmtContext _localctx = new MethodCallStmtContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_methodCallStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(377);
			otherExpression();
			setState(382);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DOT) {
				{
				{
				setState(378);
				match(DOT);
				setState(379);
				identifier();
				}
				}
				setState(384);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(395);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LPAR:
				{
				{
				System.out.println("MethodCall");
				setState(386);
				match(LPAR);
				setState(387);
				methodArgs();
				setState(388);
				match(RPAR);
				}
				}
				break;
			case INC:
			case DEC:
				{
				{
				setState(392);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case INC:
					{
					setState(390);
					((MethodCallStmtContext)_localctx).op = match(INC);
					}
					break;
				case DEC:
					{
					setState(391);
					((MethodCallStmtContext)_localctx).op = match(DEC);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				System.out.println("Operator : " + ((MethodCallStmtContext)_localctx).op.getText());
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class ReturnStatementContext extends ParserRuleContext {
		public TerminalNode RETURN() { return getToken(ThomasParser.RETURN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ReturnStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ThomasListener ) ((ThomasListener)listener).enterReturnStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ThomasListener ) ((ThomasListener)listener).exitReturnStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ThomasVisitor ) return ((ThomasVisitor<? extends T>)visitor).visitReturnStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnStatementContext returnStatement() throws RecognitionException {
		ReturnStatementContext _localctx = new ReturnStatementContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_returnStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(397);
			match(RETURN);
			System.out.println("Return");
			setState(400);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MINUS) | (1L << NOT) | (1L << TRUE) | (1L << FALSE) | (1L << SET) | (1L << LPAR) | (1L << INT_VALUE) | (1L << IDENTIFIER))) != 0)) {
				{
				setState(399);
				expression();
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

	public static class AssignmentStatementContext extends ParserRuleContext {
		public OrExpressionContext orExpression() {
			return getRuleContext(OrExpressionContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(ThomasParser.ASSIGN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public AssignmentStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignmentStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ThomasListener ) ((ThomasListener)listener).enterAssignmentStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ThomasListener ) ((ThomasListener)listener).exitAssignmentStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ThomasVisitor ) return ((ThomasVisitor<? extends T>)visitor).visitAssignmentStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentStatementContext assignmentStatement() throws RecognitionException {
		AssignmentStatementContext _localctx = new AssignmentStatementContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_assignmentStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(402);
			orExpression();
			setState(403);
			match(ASSIGN);
			setState(404);
			expression();
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

	public static class LoopStatementContext extends ParserRuleContext {
		public List<TerminalNode> DOT() { return getTokens(ThomasParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(ThomasParser.DOT, i);
		}
		public TerminalNode EACH() { return getToken(ThomasParser.EACH, 0); }
		public TerminalNode DO() { return getToken(ThomasParser.DO, 0); }
		public List<TerminalNode> BAR() { return getTokens(ThomasParser.BAR); }
		public TerminalNode BAR(int i) {
			return getToken(ThomasParser.BAR, i);
		}
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public TerminalNode LPAR() { return getToken(ThomasParser.LPAR, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode RPAR() { return getToken(ThomasParser.RPAR, 0); }
		public LoopStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_loopStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ThomasListener ) ((ThomasListener)listener).enterLoopStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ThomasListener ) ((ThomasListener)listener).exitLoopStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ThomasVisitor ) return ((ThomasVisitor<? extends T>)visitor).visitLoopStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LoopStatementContext loopStatement() throws RecognitionException {
		LoopStatementContext _localctx = new LoopStatementContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_loopStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(414);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				{
				{
				setState(406);
				identifier();
				}
				}
				break;
			case LPAR:
				{
				{
				setState(407);
				match(LPAR);
				setState(408);
				expression();
				setState(409);
				match(DOT);
				setState(410);
				match(DOT);
				setState(411);
				expression();
				setState(412);
				match(RPAR);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(416);
			match(DOT);
			setState(417);
			match(EACH);
			System.out.println("Loop : each");
			setState(419);
			match(DO);
			setState(420);
			match(BAR);
			setState(421);
			identifier();
			setState(422);
			match(BAR);
			setState(423);
			body();
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

	public static class ExpressionContext extends ParserRuleContext {
		public Token op;
		public TernaryExpressionContext ternaryExpression() {
			return getRuleContext(TernaryExpressionContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(ThomasParser.ASSIGN, 0); }
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ThomasListener ) ((ThomasListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ThomasListener ) ((ThomasListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ThomasVisitor ) return ((ThomasVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(425);
			ternaryExpression();
			setState(428);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASSIGN) {
				{
				setState(426);
				((ExpressionContext)_localctx).op = match(ASSIGN);
				setState(427);
				expression();
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

	public static class TernaryExpressionContext extends ParserRuleContext {
		public Token op;
		public OrExpressionContext orExpression() {
			return getRuleContext(OrExpressionContext.class,0);
		}
		public List<TernaryExpressionContext> ternaryExpression() {
			return getRuleContexts(TernaryExpressionContext.class);
		}
		public TernaryExpressionContext ternaryExpression(int i) {
			return getRuleContext(TernaryExpressionContext.class,i);
		}
		public List<TerminalNode> TELSE() { return getTokens(ThomasParser.TELSE); }
		public TerminalNode TELSE(int i) {
			return getToken(ThomasParser.TELSE, i);
		}
		public List<TerminalNode> TIF() { return getTokens(ThomasParser.TIF); }
		public TerminalNode TIF(int i) {
			return getToken(ThomasParser.TIF, i);
		}
		public TernaryExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ternaryExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ThomasListener ) ((ThomasListener)listener).enterTernaryExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ThomasListener ) ((ThomasListener)listener).exitTernaryExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ThomasVisitor ) return ((ThomasVisitor<? extends T>)visitor).visitTernaryExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TernaryExpressionContext ternaryExpression() throws RecognitionException {
		TernaryExpressionContext _localctx = new TernaryExpressionContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_ternaryExpression);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(430);
			orExpression();
			setState(438);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,47,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(431);
					((TernaryExpressionContext)_localctx).op = match(TIF);
					setState(432);
					ternaryExpression();
					setState(433);
					match(TELSE);
					setState(434);
					ternaryExpression();
					}
					} 
				}
				setState(440);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,47,_ctx);
			}
			System.out.println("Operator : ?:");
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

	public static class OrExpressionContext extends ParserRuleContext {
		public Token op;
		public List<AndExpressionContext> andExpression() {
			return getRuleContexts(AndExpressionContext.class);
		}
		public AndExpressionContext andExpression(int i) {
			return getRuleContext(AndExpressionContext.class,i);
		}
		public List<TerminalNode> OR() { return getTokens(ThomasParser.OR); }
		public TerminalNode OR(int i) {
			return getToken(ThomasParser.OR, i);
		}
		public OrExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_orExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ThomasListener ) ((ThomasListener)listener).enterOrExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ThomasListener ) ((ThomasListener)listener).exitOrExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ThomasVisitor ) return ((ThomasVisitor<? extends T>)visitor).visitOrExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OrExpressionContext orExpression() throws RecognitionException {
		OrExpressionContext _localctx = new OrExpressionContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_orExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(443);
			andExpression();
			setState(448);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OR) {
				{
				{
				setState(444);
				((OrExpressionContext)_localctx).op = match(OR);
				setState(445);
				andExpression();
				}
				}
				setState(450);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			System.out.println("Operator : ||");
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

	public static class AndExpressionContext extends ParserRuleContext {
		public Token op;
		public List<EqualityExpressionContext> equalityExpression() {
			return getRuleContexts(EqualityExpressionContext.class);
		}
		public EqualityExpressionContext equalityExpression(int i) {
			return getRuleContext(EqualityExpressionContext.class,i);
		}
		public List<TerminalNode> AND() { return getTokens(ThomasParser.AND); }
		public TerminalNode AND(int i) {
			return getToken(ThomasParser.AND, i);
		}
		public AndExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_andExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ThomasListener ) ((ThomasListener)listener).enterAndExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ThomasListener ) ((ThomasListener)listener).exitAndExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ThomasVisitor ) return ((ThomasVisitor<? extends T>)visitor).visitAndExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AndExpressionContext andExpression() throws RecognitionException {
		AndExpressionContext _localctx = new AndExpressionContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_andExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(453);
			equalityExpression();
			setState(458);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AND) {
				{
				{
				setState(454);
				((AndExpressionContext)_localctx).op = match(AND);
				setState(455);
				equalityExpression();
				}
				}
				setState(460);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			System.out.println("Operator : &&");
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

	public static class EqualityExpressionContext extends ParserRuleContext {
		public Token op;
		public List<RelationalExpressionContext> relationalExpression() {
			return getRuleContexts(RelationalExpressionContext.class);
		}
		public RelationalExpressionContext relationalExpression(int i) {
			return getRuleContext(RelationalExpressionContext.class,i);
		}
		public List<TerminalNode> EQUAL() { return getTokens(ThomasParser.EQUAL); }
		public TerminalNode EQUAL(int i) {
			return getToken(ThomasParser.EQUAL, i);
		}
		public EqualityExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_equalityExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ThomasListener ) ((ThomasListener)listener).enterEqualityExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ThomasListener ) ((ThomasListener)listener).exitEqualityExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ThomasVisitor ) return ((ThomasVisitor<? extends T>)visitor).visitEqualityExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EqualityExpressionContext equalityExpression() throws RecognitionException {
		EqualityExpressionContext _localctx = new EqualityExpressionContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_equalityExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(463);
			relationalExpression();
			setState(468);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==EQUAL) {
				{
				{
				setState(464);
				((EqualityExpressionContext)_localctx).op = match(EQUAL);
				setState(465);
				relationalExpression();
				}
				}
				setState(470);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			System.out.println("Operator : ==");
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

	public static class RelationalExpressionContext extends ParserRuleContext {
		public Token op;
		public List<AdditiveExpressionContext> additiveExpression() {
			return getRuleContexts(AdditiveExpressionContext.class);
		}
		public AdditiveExpressionContext additiveExpression(int i) {
			return getRuleContext(AdditiveExpressionContext.class,i);
		}
		public List<TerminalNode> GREATER_THAN() { return getTokens(ThomasParser.GREATER_THAN); }
		public TerminalNode GREATER_THAN(int i) {
			return getToken(ThomasParser.GREATER_THAN, i);
		}
		public List<TerminalNode> LESS_THAN() { return getTokens(ThomasParser.LESS_THAN); }
		public TerminalNode LESS_THAN(int i) {
			return getToken(ThomasParser.LESS_THAN, i);
		}
		public RelationalExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relationalExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ThomasListener ) ((ThomasListener)listener).enterRelationalExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ThomasListener ) ((ThomasListener)listener).exitRelationalExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ThomasVisitor ) return ((ThomasVisitor<? extends T>)visitor).visitRelationalExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RelationalExpressionContext relationalExpression() throws RecognitionException {
		RelationalExpressionContext _localctx = new RelationalExpressionContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_relationalExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(473);
			additiveExpression();
			setState(481);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==GREATER_THAN || _la==LESS_THAN) {
				{
				{
				setState(476);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case GREATER_THAN:
					{
					setState(474);
					((RelationalExpressionContext)_localctx).op = match(GREATER_THAN);
					}
					break;
				case LESS_THAN:
					{
					setState(475);
					((RelationalExpressionContext)_localctx).op = match(LESS_THAN);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(478);
				additiveExpression();
				}
				}
				setState(483);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			System.out.println("Operator : "+((RelationalExpressionContext)_localctx).op.getText());
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

	public static class AdditiveExpressionContext extends ParserRuleContext {
		public Token op;
		public List<MultiplicativeExpressionContext> multiplicativeExpression() {
			return getRuleContexts(MultiplicativeExpressionContext.class);
		}
		public MultiplicativeExpressionContext multiplicativeExpression(int i) {
			return getRuleContext(MultiplicativeExpressionContext.class,i);
		}
		public List<TerminalNode> PLUS() { return getTokens(ThomasParser.PLUS); }
		public TerminalNode PLUS(int i) {
			return getToken(ThomasParser.PLUS, i);
		}
		public List<TerminalNode> MINUS() { return getTokens(ThomasParser.MINUS); }
		public TerminalNode MINUS(int i) {
			return getToken(ThomasParser.MINUS, i);
		}
		public AdditiveExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_additiveExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ThomasListener ) ((ThomasListener)listener).enterAdditiveExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ThomasListener ) ((ThomasListener)listener).exitAdditiveExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ThomasVisitor ) return ((ThomasVisitor<? extends T>)visitor).visitAdditiveExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AdditiveExpressionContext additiveExpression() throws RecognitionException {
		AdditiveExpressionContext _localctx = new AdditiveExpressionContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_additiveExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(486);
			multiplicativeExpression();
			setState(494);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PLUS || _la==MINUS) {
				{
				{
				setState(489);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case PLUS:
					{
					setState(487);
					((AdditiveExpressionContext)_localctx).op = match(PLUS);
					}
					break;
				case MINUS:
					{
					setState(488);
					((AdditiveExpressionContext)_localctx).op = match(MINUS);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(491);
				multiplicativeExpression();
				}
				}
				setState(496);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			System.out.println("Operator : "+((AdditiveExpressionContext)_localctx).op.getText());
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

	public static class MultiplicativeExpressionContext extends ParserRuleContext {
		public Token op;
		public List<PreUnaryExpressionContext> preUnaryExpression() {
			return getRuleContexts(PreUnaryExpressionContext.class);
		}
		public PreUnaryExpressionContext preUnaryExpression(int i) {
			return getRuleContext(PreUnaryExpressionContext.class,i);
		}
		public List<TerminalNode> MULT() { return getTokens(ThomasParser.MULT); }
		public TerminalNode MULT(int i) {
			return getToken(ThomasParser.MULT, i);
		}
		public List<TerminalNode> DIVIDE() { return getTokens(ThomasParser.DIVIDE); }
		public TerminalNode DIVIDE(int i) {
			return getToken(ThomasParser.DIVIDE, i);
		}
		public MultiplicativeExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiplicativeExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ThomasListener ) ((ThomasListener)listener).enterMultiplicativeExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ThomasListener ) ((ThomasListener)listener).exitMultiplicativeExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ThomasVisitor ) return ((ThomasVisitor<? extends T>)visitor).visitMultiplicativeExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MultiplicativeExpressionContext multiplicativeExpression() throws RecognitionException {
		MultiplicativeExpressionContext _localctx = new MultiplicativeExpressionContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_multiplicativeExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(499);
			preUnaryExpression();
			setState(507);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==MULT || _la==DIVIDE) {
				{
				{
				setState(502);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case MULT:
					{
					setState(500);
					((MultiplicativeExpressionContext)_localctx).op = match(MULT);
					}
					break;
				case DIVIDE:
					{
					setState(501);
					((MultiplicativeExpressionContext)_localctx).op = match(DIVIDE);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(504);
				preUnaryExpression();
				}
				}
				setState(509);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			System.out.println("Operator : "+((MultiplicativeExpressionContext)_localctx).op.getText());
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

	public static class PreUnaryExpressionContext extends ParserRuleContext {
		public Token op;
		public PreUnaryExpressionContext preUnaryExpression() {
			return getRuleContext(PreUnaryExpressionContext.class,0);
		}
		public TerminalNode NOT() { return getToken(ThomasParser.NOT, 0); }
		public TerminalNode MINUS() { return getToken(ThomasParser.MINUS, 0); }
		public PostUnaryExpressionContext postUnaryExpression() {
			return getRuleContext(PostUnaryExpressionContext.class,0);
		}
		public PreUnaryExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_preUnaryExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ThomasListener ) ((ThomasListener)listener).enterPreUnaryExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ThomasListener ) ((ThomasListener)listener).exitPreUnaryExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ThomasVisitor ) return ((ThomasVisitor<? extends T>)visitor).visitPreUnaryExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PreUnaryExpressionContext preUnaryExpression() throws RecognitionException {
		PreUnaryExpressionContext _localctx = new PreUnaryExpressionContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_preUnaryExpression);
		try {
			setState(520);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case MINUS:
			case NOT:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(514);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case NOT:
					{
					setState(512);
					((PreUnaryExpressionContext)_localctx).op = match(NOT);
					}
					break;
				case MINUS:
					{
					setState(513);
					((PreUnaryExpressionContext)_localctx).op = match(MINUS);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(516);
				preUnaryExpression();
				System.out.println("Operator : "+((PreUnaryExpressionContext)_localctx).op.getText());
				}
				}
				break;
			case TRUE:
			case FALSE:
			case SET:
			case LPAR:
			case INT_VALUE:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(519);
				postUnaryExpression();
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

	public static class PostUnaryExpressionContext extends ParserRuleContext {
		public Token op;
		public AccessExpressionContext accessExpression() {
			return getRuleContext(AccessExpressionContext.class,0);
		}
		public TerminalNode INC() { return getToken(ThomasParser.INC, 0); }
		public TerminalNode DEC() { return getToken(ThomasParser.DEC, 0); }
		public PostUnaryExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_postUnaryExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ThomasListener ) ((ThomasListener)listener).enterPostUnaryExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ThomasListener ) ((ThomasListener)listener).exitPostUnaryExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ThomasVisitor ) return ((ThomasVisitor<? extends T>)visitor).visitPostUnaryExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PostUnaryExpressionContext postUnaryExpression() throws RecognitionException {
		PostUnaryExpressionContext _localctx = new PostUnaryExpressionContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_postUnaryExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(522);
			accessExpression();
			setState(525);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INC:
				{
				setState(523);
				((PostUnaryExpressionContext)_localctx).op = match(INC);
				}
				break;
			case DEC:
				{
				setState(524);
				((PostUnaryExpressionContext)_localctx).op = match(DEC);
				}
				break;
			case ELSE:
			case ELSIF:
			case PLUS:
			case MINUS:
			case MULT:
			case DIVIDE:
			case EQUAL:
			case GREATER_THAN:
			case LESS_THAN:
			case AND:
			case OR:
			case TIF:
			case TELSE:
			case ASSIGN:
			case RPAR:
			case RBRACK:
			case LBRACE:
			case COMMA:
			case DOT:
			case SEMICOLON:
			case NEWLINE:
				break;
			default:
				break;
			}
			System.out.println("Operator : "+((PostUnaryExpressionContext)_localctx).op.getText());
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

	public static class AccessExpressionContext extends ParserRuleContext {
		public OtherExpressionContext otherExpression() {
			return getRuleContext(OtherExpressionContext.class,0);
		}
		public List<TerminalNode> LPAR() { return getTokens(ThomasParser.LPAR); }
		public TerminalNode LPAR(int i) {
			return getToken(ThomasParser.LPAR, i);
		}
		public List<MethodArgsContext> methodArgs() {
			return getRuleContexts(MethodArgsContext.class);
		}
		public MethodArgsContext methodArgs(int i) {
			return getRuleContext(MethodArgsContext.class,i);
		}
		public List<TerminalNode> RPAR() { return getTokens(ThomasParser.RPAR); }
		public TerminalNode RPAR(int i) {
			return getToken(ThomasParser.RPAR, i);
		}
		public List<TerminalNode> DOT() { return getTokens(ThomasParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(ThomasParser.DOT, i);
		}
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public List<TerminalNode> LBRACK() { return getTokens(ThomasParser.LBRACK); }
		public TerminalNode LBRACK(int i) {
			return getToken(ThomasParser.LBRACK, i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> RBRACK() { return getTokens(ThomasParser.RBRACK); }
		public TerminalNode RBRACK(int i) {
			return getToken(ThomasParser.RBRACK, i);
		}
		public AccessExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_accessExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ThomasListener ) ((ThomasListener)listener).enterAccessExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ThomasListener ) ((ThomasListener)listener).exitAccessExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ThomasVisitor ) return ((ThomasVisitor<? extends T>)visitor).visitAccessExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AccessExpressionContext accessExpression() throws RecognitionException {
		AccessExpressionContext _localctx = new AccessExpressionContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_accessExpression);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(529);
			otherExpression();
			setState(538);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,61,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(536);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case LPAR:
						{
						{
						setState(530);
						match(LPAR);
						setState(531);
						methodArgs();
						setState(532);
						match(RPAR);
						}
						}
						break;
					case DOT:
						{
						{
						setState(534);
						match(DOT);
						setState(535);
						identifier();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					} 
				}
				setState(540);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,61,_ctx);
			}
			setState(549);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,63,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(547);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case LBRACK:
						{
						{
						setState(541);
						match(LBRACK);
						setState(542);
						expression();
						setState(543);
						match(RBRACK);
						}
						}
						break;
					case DOT:
						{
						{
						setState(545);
						match(DOT);
						setState(546);
						identifier();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					} 
				}
				setState(551);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,63,_ctx);
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

	public static class OtherExpressionContext extends ParserRuleContext {
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode LPAR() { return getToken(ThomasParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(ThomasParser.RPAR, 0); }
		public MethodArgsContext methodArgs() {
			return getRuleContext(MethodArgsContext.class,0);
		}
		public SetNewContext setNew() {
			return getRuleContext(SetNewContext.class,0);
		}
		public SetIncludeContext setInclude() {
			return getRuleContext(SetIncludeContext.class,0);
		}
		public AccessByIndexContext accessByIndex() {
			return getRuleContext(AccessByIndexContext.class,0);
		}
		public OtherExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_otherExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ThomasListener ) ((ThomasListener)listener).enterOtherExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ThomasListener ) ((ThomasListener)listener).exitOtherExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ThomasVisitor ) return ((ThomasVisitor<? extends T>)visitor).visitOtherExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OtherExpressionContext otherExpression() throws RecognitionException {
		OtherExpressionContext _localctx = new OtherExpressionContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_otherExpression);
		try {
			setState(561);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,64,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(552);
				value();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(553);
				identifier();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(554);
				match(LPAR);
				{
				setState(555);
				methodArgs();
				}
				setState(556);
				match(RPAR);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(558);
				setNew();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(559);
				setInclude();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(560);
				accessByIndex();
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

	public static class AccessByIndexContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode LBRACK() { return getToken(ThomasParser.LBRACK, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RBRACK() { return getToken(ThomasParser.RBRACK, 0); }
		public AccessByIndexContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_accessByIndex; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ThomasListener ) ((ThomasListener)listener).enterAccessByIndex(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ThomasListener ) ((ThomasListener)listener).exitAccessByIndex(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ThomasVisitor ) return ((ThomasVisitor<? extends T>)visitor).visitAccessByIndex(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AccessByIndexContext accessByIndex() throws RecognitionException {
		AccessByIndexContext _localctx = new AccessByIndexContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_accessByIndex);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(563);
			identifier();
			setState(564);
			match(LBRACK);
			setState(565);
			expression();
			setState(566);
			match(RBRACK);
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

	public static class SetNewContext extends ParserRuleContext {
		public TerminalNode SET() { return getToken(ThomasParser.SET, 0); }
		public TerminalNode DOT() { return getToken(ThomasParser.DOT, 0); }
		public TerminalNode NEW() { return getToken(ThomasParser.NEW, 0); }
		public TerminalNode LPAR() { return getToken(ThomasParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(ThomasParser.RPAR, 0); }
		public List<OrExpressionContext> orExpression() {
			return getRuleContexts(OrExpressionContext.class);
		}
		public OrExpressionContext orExpression(int i) {
			return getRuleContext(OrExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(ThomasParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ThomasParser.COMMA, i);
		}
		public SetNewContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_setNew; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ThomasListener ) ((ThomasListener)listener).enterSetNew(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ThomasListener ) ((ThomasListener)listener).exitSetNew(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ThomasVisitor ) return ((ThomasVisitor<? extends T>)visitor).visitSetNew(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SetNewContext setNew() throws RecognitionException {
		SetNewContext _localctx = new SetNewContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_setNew);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(568);
			match(SET);
			setState(569);
			match(DOT);
			setState(570);
			match(NEW);
			System.out.println("NEW");
			setState(572);
			match(LPAR);
			setState(581);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MINUS) | (1L << NOT) | (1L << TRUE) | (1L << FALSE) | (1L << SET) | (1L << LPAR) | (1L << INT_VALUE) | (1L << IDENTIFIER))) != 0)) {
				{
				setState(573);
				orExpression();
				setState(578);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(574);
					match(COMMA);
					setState(575);
					orExpression();
					}
					}
					setState(580);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(583);
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

	public static class SetIncludeContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode DOT() { return getToken(ThomasParser.DOT, 0); }
		public TerminalNode INCLUDE() { return getToken(ThomasParser.INCLUDE, 0); }
		public TerminalNode LPAR() { return getToken(ThomasParser.LPAR, 0); }
		public OrExpressionContext orExpression() {
			return getRuleContext(OrExpressionContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(ThomasParser.RPAR, 0); }
		public SetIncludeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_setInclude; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ThomasListener ) ((ThomasListener)listener).enterSetInclude(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ThomasListener ) ((ThomasListener)listener).exitSetInclude(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ThomasVisitor ) return ((ThomasVisitor<? extends T>)visitor).visitSetInclude(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SetIncludeContext setInclude() throws RecognitionException {
		SetIncludeContext _localctx = new SetIncludeContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_setInclude);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(585);
			identifier();
			setState(586);
			match(DOT);
			setState(587);
			match(INCLUDE);
			System.out.println("INCLUDE");
			setState(589);
			match(LPAR);
			setState(590);
			orExpression();
			setState(591);
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

	public static class ValueContext extends ParserRuleContext {
		public BoolValueContext boolValue() {
			return getRuleContext(BoolValueContext.class,0);
		}
		public TerminalNode INT_VALUE() { return getToken(ThomasParser.INT_VALUE, 0); }
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ThomasListener ) ((ThomasListener)listener).enterValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ThomasListener ) ((ThomasListener)listener).exitValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ThomasVisitor ) return ((ThomasVisitor<? extends T>)visitor).visitValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_value);
		try {
			setState(595);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TRUE:
			case FALSE:
				enterOuterAlt(_localctx, 1);
				{
				setState(593);
				boolValue();
				}
				break;
			case INT_VALUE:
				enterOuterAlt(_localctx, 2);
				{
				setState(594);
				match(INT_VALUE);
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

	public static class BoolValueContext extends ParserRuleContext {
		public TerminalNode TRUE() { return getToken(ThomasParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(ThomasParser.FALSE, 0); }
		public BoolValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ThomasListener ) ((ThomasListener)listener).enterBoolValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ThomasListener ) ((ThomasListener)listener).exitBoolValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ThomasVisitor ) return ((ThomasVisitor<? extends T>)visitor).visitBoolValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BoolValueContext boolValue() throws RecognitionException {
		BoolValueContext _localctx = new BoolValueContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_boolValue);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(597);
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

	public static class Class_identifierContext extends ParserRuleContext {
		public TerminalNode CLASS_IDENTIFIER() { return getToken(ThomasParser.CLASS_IDENTIFIER, 0); }
		public Class_identifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_class_identifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ThomasListener ) ((ThomasListener)listener).enterClass_identifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ThomasListener ) ((ThomasListener)listener).exitClass_identifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ThomasVisitor ) return ((ThomasVisitor<? extends T>)visitor).visitClass_identifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Class_identifierContext class_identifier() throws RecognitionException {
		Class_identifierContext _localctx = new Class_identifierContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_class_identifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(599);
			match(CLASS_IDENTIFIER);
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

	public static class IdentifierContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(ThomasParser.IDENTIFIER, 0); }
		public IdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ThomasListener ) ((ThomasListener)listener).enterIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ThomasListener ) ((ThomasListener)listener).exitIdentifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ThomasVisitor ) return ((ThomasVisitor<? extends T>)visitor).visitIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdentifierContext identifier() throws RecognitionException {
		IdentifierContext _localctx = new IdentifierContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_identifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(601);
			match(IDENTIFIER);
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

	public static class TypeContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(ThomasParser.INT, 0); }
		public TerminalNode BOOL() { return getToken(ThomasParser.BOOL, 0); }
		public Array_typeContext array_type() {
			return getRuleContext(Array_typeContext.class,0);
		}
		public Fptr_typeContext fptr_type() {
			return getRuleContext(Fptr_typeContext.class,0);
		}
		public Set_typeContext set_type() {
			return getRuleContext(Set_typeContext.class,0);
		}
		public Class_identifierContext class_identifier() {
			return getRuleContext(Class_identifierContext.class,0);
		}
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ThomasListener ) ((ThomasListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ThomasListener ) ((ThomasListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ThomasVisitor ) return ((ThomasVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_type);
		try {
			setState(609);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,68,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(603);
				match(INT);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(604);
				match(BOOL);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(605);
				array_type();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(606);
				fptr_type();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(607);
				set_type();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(608);
				class_identifier();
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

	public static class Array_typeContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(ThomasParser.INT, 0); }
		public TerminalNode BOOL() { return getToken(ThomasParser.BOOL, 0); }
		public Class_identifierContext class_identifier() {
			return getRuleContext(Class_identifierContext.class,0);
		}
		public List<TerminalNode> LBRACK() { return getTokens(ThomasParser.LBRACK); }
		public TerminalNode LBRACK(int i) {
			return getToken(ThomasParser.LBRACK, i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> RBRACK() { return getTokens(ThomasParser.RBRACK); }
		public TerminalNode RBRACK(int i) {
			return getToken(ThomasParser.RBRACK, i);
		}
		public Array_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_array_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ThomasListener ) ((ThomasListener)listener).enterArray_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ThomasListener ) ((ThomasListener)listener).exitArray_type(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ThomasVisitor ) return ((ThomasVisitor<? extends T>)visitor).visitArray_type(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Array_typeContext array_type() throws RecognitionException {
		Array_typeContext _localctx = new Array_typeContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_array_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(614);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
				{
				setState(611);
				match(INT);
				}
				break;
			case BOOL:
				{
				setState(612);
				match(BOOL);
				}
				break;
			case CLASS_IDENTIFIER:
				{
				setState(613);
				class_identifier();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(620); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(616);
				match(LBRACK);
				setState(617);
				expression();
				setState(618);
				match(RBRACK);
				}
				}
				setState(622); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==LBRACK );
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

	public static class Fptr_typeContext extends ParserRuleContext {
		public TerminalNode FPTR() { return getToken(ThomasParser.FPTR, 0); }
		public TerminalNode LESS_THAN() { return getToken(ThomasParser.LESS_THAN, 0); }
		public TerminalNode ARROW() { return getToken(ThomasParser.ARROW, 0); }
		public TerminalNode GREATER_THAN() { return getToken(ThomasParser.GREATER_THAN, 0); }
		public List<TerminalNode> VOID() { return getTokens(ThomasParser.VOID); }
		public TerminalNode VOID(int i) {
			return getToken(ThomasParser.VOID, i);
		}
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(ThomasParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ThomasParser.COMMA, i);
		}
		public Fptr_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fptr_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ThomasListener ) ((ThomasListener)listener).enterFptr_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ThomasListener ) ((ThomasListener)listener).exitFptr_type(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ThomasVisitor ) return ((ThomasVisitor<? extends T>)visitor).visitFptr_type(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Fptr_typeContext fptr_type() throws RecognitionException {
		Fptr_typeContext _localctx = new Fptr_typeContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_fptr_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(624);
			match(FPTR);
			setState(625);
			match(LESS_THAN);
			setState(635);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VOID:
				{
				setState(626);
				match(VOID);
				}
				break;
			case INT:
			case BOOL:
			case FPTR:
			case SET:
			case CLASS_IDENTIFIER:
				{
				{
				setState(627);
				type();
				setState(632);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(628);
					match(COMMA);
					setState(629);
					type();
					}
					}
					setState(634);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(637);
			match(ARROW);
			setState(640);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
			case BOOL:
			case FPTR:
			case SET:
			case CLASS_IDENTIFIER:
				{
				setState(638);
				type();
				}
				break;
			case VOID:
				{
				setState(639);
				match(VOID);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(642);
			match(GREATER_THAN);
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

	public static class Set_typeContext extends ParserRuleContext {
		public TerminalNode SET() { return getToken(ThomasParser.SET, 0); }
		public TerminalNode LESS_THAN() { return getToken(ThomasParser.LESS_THAN, 0); }
		public TerminalNode GREATER_THAN() { return getToken(ThomasParser.GREATER_THAN, 0); }
		public TerminalNode INT() { return getToken(ThomasParser.INT, 0); }
		public Set_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_set_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ThomasListener ) ((ThomasListener)listener).enterSet_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ThomasListener ) ((ThomasListener)listener).exitSet_type(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ThomasVisitor ) return ((ThomasVisitor<? extends T>)visitor).visitSet_type(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Set_typeContext set_type() throws RecognitionException {
		Set_typeContext _localctx = new Set_typeContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_set_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(644);
			match(SET);
			setState(645);
			match(LESS_THAN);
			{
			setState(646);
			match(INT);
			}
			setState(647);
			match(GREATER_THAN);
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3@\u028c\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\3\2\7\2b\n\2\f\2\16\2e\13\2\3\2\3\2\7"+
		"\2i\n\2\f\2\16\2l\13\2\3\2\3\2\3\3\3\3\5\3r\n\3\3\3\6\3u\n\3\r\3\16\3"+
		"v\7\3y\n\3\f\3\16\3|\13\3\3\3\3\3\6\3\u0080\n\3\r\3\16\3\u0081\7\3\u0084"+
		"\n\3\f\3\16\3\u0087\13\3\3\3\3\3\5\3\u008b\n\3\3\4\3\4\3\4\3\4\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\5\5\u0097\n\5\3\5\7\5\u009a\n\5\f\5\16\5\u009d\13\5\3"+
		"\5\3\5\6\5\u00a1\n\5\r\5\16\5\u00a2\3\5\7\5\u00a6\n\5\f\5\16\5\u00a9\13"+
		"\5\3\5\3\5\7\5\u00ad\n\5\f\5\16\5\u00b0\13\5\3\6\3\6\3\6\3\6\5\6\u00b6"+
		"\n\6\3\6\5\6\u00b9\n\6\3\6\6\6\u00bc\n\6\r\6\16\6\u00bd\3\7\3\7\5\7\u00c2"+
		"\n\7\3\7\3\7\3\7\3\7\7\7\u00c8\n\7\f\7\16\7\u00cb\13\7\3\7\3\7\3\b\3\b"+
		"\3\b\3\b\7\b\u00d3\n\b\f\b\16\b\u00d6\13\b\5\b\u00d8\n\b\3\b\3\b\3\t\3"+
		"\t\3\t\3\t\3\t\5\t\u00e1\n\t\3\n\3\n\3\n\7\n\u00e6\n\n\f\n\16\n\u00e9"+
		"\13\n\5\n\u00eb\n\n\3\13\3\13\6\13\u00ef\n\13\r\13\16\13\u00f0\3\13\3"+
		"\13\5\13\u00f5\n\13\5\13\u00f7\n\13\3\f\3\f\6\f\u00fb\n\f\r\f\16\f\u00fc"+
		"\3\f\3\f\5\f\u0101\n\f\6\f\u0103\n\f\r\f\16\f\u0104\3\f\6\f\u0108\n\f"+
		"\r\f\16\f\u0109\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u0118"+
		"\n\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\7\17\u012a\n\17\f\17\16\17\u012d\13\17\3\17\3\17\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\7\21"+
		"\u013f\n\21\f\21\16\21\u0142\13\21\3\22\3\22\3\22\3\22\5\22\u0148\n\22"+
		"\3\22\3\22\3\22\5\22\u014d\n\22\3\22\3\22\7\22\u0151\n\22\f\22\16\22\u0154"+
		"\13\22\3\22\5\22\u0157\n\22\3\23\7\23\u015a\n\23\f\23\16\23\u015d\13\23"+
		"\3\23\3\23\3\23\3\23\5\23\u0163\n\23\3\23\3\23\3\23\5\23\u0168\n\23\3"+
		"\23\3\23\3\24\7\24\u016d\n\24\f\24\16\24\u0170\13\24\3\24\3\24\3\24\3"+
		"\24\3\25\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\7\26\u017f\n\26\f\26"+
		"\16\26\u0182\13\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\5\26\u018b\n\26"+
		"\3\26\5\26\u018e\n\26\3\27\3\27\3\27\5\27\u0193\n\27\3\30\3\30\3\30\3"+
		"\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\5\31\u01a1\n\31\3\31\3\31"+
		"\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\5\32\u01af\n\32\3\33"+
		"\3\33\3\33\3\33\3\33\3\33\7\33\u01b7\n\33\f\33\16\33\u01ba\13\33\3\33"+
		"\3\33\3\34\3\34\3\34\7\34\u01c1\n\34\f\34\16\34\u01c4\13\34\3\34\3\34"+
		"\3\35\3\35\3\35\7\35\u01cb\n\35\f\35\16\35\u01ce\13\35\3\35\3\35\3\36"+
		"\3\36\3\36\7\36\u01d5\n\36\f\36\16\36\u01d8\13\36\3\36\3\36\3\37\3\37"+
		"\3\37\5\37\u01df\n\37\3\37\7\37\u01e2\n\37\f\37\16\37\u01e5\13\37\3\37"+
		"\3\37\3 \3 \3 \5 \u01ec\n \3 \7 \u01ef\n \f \16 \u01f2\13 \3 \3 \3!\3"+
		"!\3!\5!\u01f9\n!\3!\7!\u01fc\n!\f!\16!\u01ff\13!\3!\3!\3\"\3\"\5\"\u0205"+
		"\n\"\3\"\3\"\3\"\3\"\5\"\u020b\n\"\3#\3#\3#\5#\u0210\n#\3#\3#\3$\3$\3"+
		"$\3$\3$\3$\3$\7$\u021b\n$\f$\16$\u021e\13$\3$\3$\3$\3$\3$\3$\7$\u0226"+
		"\n$\f$\16$\u0229\13$\3%\3%\3%\3%\3%\3%\3%\3%\3%\5%\u0234\n%\3&\3&\3&\3"+
		"&\3&\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\7\'\u0243\n\'\f\'\16\'\u0246\13\'"+
		"\5\'\u0248\n\'\3\'\3\'\3(\3(\3(\3(\3(\3(\3(\3(\3)\3)\5)\u0256\n)\3*\3"+
		"*\3+\3+\3,\3,\3-\3-\3-\3-\3-\3-\5-\u0264\n-\3.\3.\3.\5.\u0269\n.\3.\3"+
		".\3.\3.\6.\u026f\n.\r.\16.\u0270\3/\3/\3/\3/\3/\3/\7/\u0279\n/\f/\16/"+
		"\u027c\13/\5/\u027e\n/\3/\3/\3/\5/\u0283\n/\3/\3/\3\60\3\60\3\60\3\60"+
		"\3\60\3\60\2\2\61\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62"+
		"\64\668:<>@BDFHJLNPRTVXZ\\^\2\4\3\2\4\5\3\2#$\2\u02b9\2c\3\2\2\2\4z\3"+
		"\2\2\2\6\u008c\3\2\2\2\b\u0090\3\2\2\2\n\u00b1\3\2\2\2\f\u00c1\3\2\2\2"+
		"\16\u00ce\3\2\2\2\20\u00db\3\2\2\2\22\u00ea\3\2\2\2\24\u00f6\3\2\2\2\26"+
		"\u00f8\3\2\2\2\30\u0117\3\2\2\2\32\u0119\3\2\2\2\34\u0121\3\2\2\2\36\u0130"+
		"\3\2\2\2 \u0138\3\2\2\2\"\u0143\3\2\2\2$\u015b\3\2\2\2&\u016e\3\2\2\2"+
		"(\u0175\3\2\2\2*\u017b\3\2\2\2,\u018f\3\2\2\2.\u0194\3\2\2\2\60\u01a0"+
		"\3\2\2\2\62\u01ab\3\2\2\2\64\u01b0\3\2\2\2\66\u01bd\3\2\2\28\u01c7\3\2"+
		"\2\2:\u01d1\3\2\2\2<\u01db\3\2\2\2>\u01e8\3\2\2\2@\u01f5\3\2\2\2B\u020a"+
		"\3\2\2\2D\u020c\3\2\2\2F\u0213\3\2\2\2H\u0233\3\2\2\2J\u0235\3\2\2\2L"+
		"\u023a\3\2\2\2N\u024b\3\2\2\2P\u0255\3\2\2\2R\u0257\3\2\2\2T\u0259\3\2"+
		"\2\2V\u025b\3\2\2\2X\u0263\3\2\2\2Z\u0268\3\2\2\2\\\u0272\3\2\2\2^\u0286"+
		"\3\2\2\2`b\79\2\2a`\3\2\2\2be\3\2\2\2ca\3\2\2\2cd\3\2\2\2df\3\2\2\2ec"+
		"\3\2\2\2fj\5\4\3\2gi\79\2\2hg\3\2\2\2il\3\2\2\2jh\3\2\2\2jk\3\2\2\2km"+
		"\3\2\2\2lj\3\2\2\2mn\7\2\2\3n\3\3\2\2\2oq\5 \21\2pr\78\2\2qp\3\2\2\2q"+
		"r\3\2\2\2rt\3\2\2\2su\79\2\2ts\3\2\2\2uv\3\2\2\2vt\3\2\2\2vw\3\2\2\2w"+
		"y\3\2\2\2xo\3\2\2\2y|\3\2\2\2zx\3\2\2\2z{\3\2\2\2{\u0085\3\2\2\2|z\3\2"+
		"\2\2}\177\5\b\5\2~\u0080\79\2\2\177~\3\2\2\2\u0080\u0081\3\2\2\2\u0081"+
		"\177\3\2\2\2\u0081\u0082\3\2\2\2\u0082\u0084\3\2\2\2\u0083}\3\2\2\2\u0084"+
		"\u0087\3\2\2\2\u0085\u0083\3\2\2\2\u0085\u0086\3\2\2\2\u0086\u008a\3\2"+
		"\2\2\u0087\u0085\3\2\2\2\u0088\u008b\5\b\5\2\u0089\u008b\3\2\2\2\u008a"+
		"\u0088\3\2\2\2\u008a\u0089\3\2\2\2\u008b\5\3\2\2\2\u008c\u008d\7\6\2\2"+
		"\u008d\u008e\5\16\b\2\u008e\u008f\5\24\13\2\u008f\7\3\2\2\2\u0090\u0091"+
		"\7\3\2\2\u0091\u0092\7<\2\2\u0092\u0096\b\5\1\2\u0093\u0094\7\33\2\2\u0094"+
		"\u0095\7<\2\2\u0095\u0097\b\5\1\2\u0096\u0093\3\2\2\2\u0096\u0097\3\2"+
		"\2\2\u0097\u009b\3\2\2\2\u0098\u009a\79\2\2\u0099\u0098\3\2\2\2\u009a"+
		"\u009d\3\2\2\2\u009b\u0099\3\2\2\2\u009b\u009c\3\2\2\2\u009c\u009e\3\2"+
		"\2\2\u009d\u009b\3\2\2\2\u009e\u00a0\7\64\2\2\u009f\u00a1\79\2\2\u00a0"+
		"\u009f\3\2\2\2\u00a1\u00a2\3\2\2\2\u00a2\u00a0\3\2\2\2\u00a2\u00a3\3\2"+
		"\2\2\u00a3\u00a7\3\2\2\2\u00a4\u00a6\5\n\6\2\u00a5\u00a4\3\2\2\2\u00a6"+
		"\u00a9\3\2\2\2\u00a7\u00a5\3\2\2\2\u00a7\u00a8\3\2\2\2\u00a8\u00aa\3\2"+
		"\2\2\u00a9\u00a7\3\2\2\2\u00aa\u00ae\7\65\2\2\u00ab\u00ad\79\2\2\u00ac"+
		"\u00ab\3\2\2\2\u00ad\u00b0\3\2\2\2\u00ae\u00ac\3\2\2\2\u00ae\u00af\3\2"+
		"\2\2\u00af\t\3\2\2\2\u00b0\u00ae\3\2\2\2\u00b1\u00b5\t\2\2\2\u00b2\u00b6"+
		"\5 \21\2\u00b3\u00b6\5\f\7\2\u00b4\u00b6\5\6\4\2\u00b5\u00b2\3\2\2\2\u00b5"+
		"\u00b3\3\2\2\2\u00b5\u00b4\3\2\2\2\u00b6\u00b8\3\2\2\2\u00b7\u00b9\78"+
		"\2\2\u00b8\u00b7\3\2\2\2\u00b8\u00b9\3\2\2\2\u00b9\u00bb\3\2\2\2\u00ba"+
		"\u00bc\79\2\2\u00bb\u00ba\3\2\2\2\u00bc\u00bd\3\2\2\2\u00bd\u00bb\3\2"+
		"\2\2\u00bd\u00be\3\2\2\2\u00be\13\3\2\2\2\u00bf\u00c2\5X-\2\u00c0\u00c2"+
		"\7\n\2\2\u00c1\u00bf\3\2\2\2\u00c1\u00c0\3\2\2\2\u00c2\u00c3\3\2\2\2\u00c3"+
		"\u00c4\7;\2\2\u00c4\u00c5\b\7\1\2\u00c5\u00c9\5\16\b\2\u00c6\u00c8\79"+
		"\2\2\u00c7\u00c6\3\2\2\2\u00c8\u00cb\3\2\2\2\u00c9\u00c7\3\2\2\2\u00c9"+
		"\u00ca\3\2\2\2\u00ca\u00cc\3\2\2\2\u00cb\u00c9\3\2\2\2\u00cc\u00cd\5\24"+
		"\13\2\u00cd\r\3\2\2\2\u00ce\u00d7\7\60\2\2\u00cf\u00d4\5\20\t\2\u00d0"+
		"\u00d1\7\66\2\2\u00d1\u00d3\5\20\t\2\u00d2\u00d0\3\2\2\2\u00d3\u00d6\3"+
		"\2\2\2\u00d4\u00d2\3\2\2\2\u00d4\u00d5\3\2\2\2\u00d5\u00d8\3\2\2\2\u00d6"+
		"\u00d4\3\2\2\2\u00d7\u00cf\3\2\2\2\u00d7\u00d8\3\2\2\2\u00d8\u00d9\3\2"+
		"\2\2\u00d9\u00da\7\61\2\2\u00da\17\3\2\2\2\u00db\u00dc\5X-\2\u00dc\u00dd"+
		"\7;\2\2\u00dd\u00e0\b\t\1\2\u00de\u00df\7.\2\2\u00df\u00e1\5\66\34\2\u00e0"+
		"\u00de\3\2\2\2\u00e0\u00e1\3\2\2\2\u00e1\21\3\2\2\2\u00e2\u00e7\5\62\32"+
		"\2\u00e3\u00e4\7\66\2\2\u00e4\u00e6\5\62\32\2\u00e5\u00e3\3\2\2\2\u00e6"+
		"\u00e9\3\2\2\2\u00e7\u00e5\3\2\2\2\u00e7\u00e8\3\2\2\2\u00e8\u00eb\3\2"+
		"\2\2\u00e9\u00e7\3\2\2\2\u00ea\u00e2\3\2\2\2\u00ea\u00eb\3\2\2\2\u00eb"+
		"\23\3\2\2\2\u00ec\u00f7\5\26\f\2\u00ed\u00ef\79\2\2\u00ee\u00ed\3\2\2"+
		"\2\u00ef\u00f0\3\2\2\2\u00f0\u00ee\3\2\2\2\u00f0\u00f1\3\2\2\2\u00f1\u00f2"+
		"\3\2\2\2\u00f2\u00f4\5\30\r\2\u00f3\u00f5\78\2\2\u00f4\u00f3\3\2\2\2\u00f4"+
		"\u00f5\3\2\2\2\u00f5\u00f7\3\2\2\2\u00f6\u00ec\3\2\2\2\u00f6\u00ee\3\2"+
		"\2\2\u00f7\25\3\2\2\2\u00f8\u0102\7\64\2\2\u00f9\u00fb\79\2\2\u00fa\u00f9"+
		"\3\2\2\2\u00fb\u00fc\3\2\2\2\u00fc\u00fa\3\2\2\2\u00fc\u00fd\3\2\2\2\u00fd"+
		"\u00fe\3\2\2\2\u00fe\u0100\5\30\r\2\u00ff\u0101\78\2\2\u0100\u00ff\3\2"+
		"\2\2\u0100\u0101\3\2\2\2\u0101\u0103\3\2\2\2\u0102\u00fa\3\2\2\2\u0103"+
		"\u0104\3\2\2\2\u0104\u0102\3\2\2\2\u0104\u0105\3\2\2\2\u0105\u0107\3\2"+
		"\2\2\u0106\u0108\79\2\2\u0107\u0106\3\2\2\2\u0108\u0109\3\2\2\2\u0109"+
		"\u0107\3\2\2\2\u0109\u010a\3\2\2\2\u010a\u010b\3\2\2\2\u010b\u010c\7\65"+
		"\2\2\u010c\27\3\2\2\2\u010d\u0118\5\"\22\2\u010e\u0118\5(\25\2\u010f\u0118"+
		"\5*\26\2\u0110\u0118\5,\27\2\u0111\u0118\5.\30\2\u0112\u0118\5 \21\2\u0113"+
		"\u0118\5\60\31\2\u0114\u0118\5\32\16\2\u0115\u0118\5\34\17\2\u0116\u0118"+
		"\5\36\20\2\u0117\u010d\3\2\2\2\u0117\u010e\3\2\2\2\u0117\u010f\3\2\2\2"+
		"\u0117\u0110\3\2\2\2\u0117\u0111\3\2\2\2\u0117\u0112\3\2\2\2\u0117\u0113"+
		"\3\2\2\2\u0117\u0114\3\2\2\2\u0117\u0115\3\2\2\2\u0117\u0116\3\2\2\2\u0118"+
		"\31\3\2\2\2\u0119\u011a\5V,\2\u011a\u011b\7\67\2\2\u011b\u011c\7\r\2\2"+
		"\u011c\u011d\b\16\1\2\u011d\u011e\7\60\2\2\u011e\u011f\5\66\34\2\u011f"+
		"\u0120\7\61\2\2\u0120\33\3\2\2\2\u0121\u0122\5V,\2\u0122\u0123\7\67\2"+
		"\2\u0123\u0124\7\16\2\2\u0124\u0125\b\17\1\2\u0125\u0126\7\60\2\2\u0126"+
		"\u012b\5\66\34\2\u0127\u0128\7\66\2\2\u0128\u012a\5\66\34\2\u0129\u0127"+
		"\3\2\2\2\u012a\u012d\3\2\2\2\u012b\u0129\3\2\2\2\u012b\u012c\3\2\2\2\u012c"+
		"\u012e\3\2\2\2\u012d\u012b\3\2\2\2\u012e\u012f\7\61\2\2\u012f\35\3\2\2"+
		"\2\u0130\u0131\5V,\2\u0131\u0132\7\67\2\2\u0132\u0133\7\13\2\2\u0133\u0134"+
		"\b\20\1\2\u0134\u0135\7\60\2\2\u0135\u0136\5\66\34\2\u0136\u0137\7\61"+
		"\2\2\u0137\37\3\2\2\2\u0138\u0139\5X-\2\u0139\u013a\7;\2\2\u013a\u0140"+
		"\b\21\1\2\u013b\u013c\7\66\2\2\u013c\u013d\7;\2\2\u013d\u013f\b\21\1\2"+
		"\u013e\u013b\3\2\2\2\u013f\u0142\3\2\2\2\u0140\u013e\3\2\2\2\u0140\u0141"+
		"\3\2\2\2\u0141!\3\2\2\2\u0142\u0140\3\2\2\2\u0143\u0144\7\20\2\2\u0144"+
		"\u0147\b\22\1\2\u0145\u0148\7\60\2\2\u0146\u0148\3\2\2\2\u0147\u0145\3"+
		"\2\2\2\u0147\u0146\3\2\2\2\u0148\u0149\3\2\2\2\u0149\u014c\5\62\32\2\u014a"+
		"\u014d\7\61\2\2\u014b\u014d\3\2\2\2\u014c\u014a\3\2\2\2\u014c\u014b\3"+
		"\2\2\2\u014d\u014e\3\2\2\2\u014e\u0152\5\24\13\2\u014f\u0151\5$\23\2\u0150"+
		"\u014f\3\2\2\2\u0151\u0154\3\2\2\2\u0152\u0150\3\2\2\2\u0152\u0153\3\2"+
		"\2\2\u0153\u0156\3\2\2\2\u0154\u0152\3\2\2\2\u0155\u0157\5&\24\2\u0156"+
		"\u0155\3\2\2\2\u0156\u0157\3\2\2\2\u0157#\3\2\2\2\u0158\u015a\79\2\2\u0159"+
		"\u0158\3\2\2\2\u015a\u015d\3\2\2\2\u015b\u0159\3\2\2\2\u015b\u015c\3\2"+
		"\2\2\u015c\u015e\3\2\2\2\u015d\u015b\3\2\2\2\u015e\u015f\7\22\2\2\u015f"+
		"\u0162\b\23\1\2\u0160\u0163\7\60\2\2\u0161\u0163\3\2\2\2\u0162\u0160\3"+
		"\2\2\2\u0162\u0161\3\2\2\2\u0163\u0164\3\2\2\2\u0164\u0167\5\62\32\2\u0165"+
		"\u0168\7\61\2\2\u0166\u0168\3\2\2\2\u0167\u0165\3\2\2\2\u0167\u0166\3"+
		"\2\2\2\u0168\u0169\3\2\2\2\u0169\u016a\5\24\13\2\u016a%\3\2\2\2\u016b"+
		"\u016d\79\2\2\u016c\u016b\3\2\2\2\u016d\u0170\3\2\2\2\u016e\u016c\3\2"+
		"\2\2\u016e\u016f\3\2\2\2\u016f\u0171\3\2\2\2\u0170\u016e\3\2\2\2\u0171"+
		"\u0172\7\21\2\2\u0172\u0173\b\24\1\2\u0173\u0174\5\24\13\2\u0174\'\3\2"+
		"\2\2\u0175\u0176\7\17\2\2\u0176\u0177\b\25\1\2\u0177\u0178\7\60\2\2\u0178"+
		"\u0179\5\62\32\2\u0179\u017a\7\61\2\2\u017a)\3\2\2\2\u017b\u0180\5H%\2"+
		"\u017c\u017d\7\67\2\2\u017d\u017f\5V,\2\u017e\u017c\3\2\2\2\u017f\u0182"+
		"\3\2\2\2\u0180\u017e\3\2\2\2\u0180\u0181\3\2\2\2\u0181\u018d\3\2\2\2\u0182"+
		"\u0180\3\2\2\2\u0183\u0184\b\26\1\2\u0184\u0185\7\60\2\2\u0185\u0186\5"+
		"\22\n\2\u0186\u0187\7\61\2\2\u0187\u018e\3\2\2\2\u0188\u018b\7\27\2\2"+
		"\u0189\u018b\7\30\2\2\u018a\u0188\3\2\2\2\u018a\u0189\3\2\2\2\u018b\u018c"+
		"\3\2\2\2\u018c\u018e\b\26\1\2\u018d\u0183\3\2\2\2\u018d\u018a\3\2\2\2"+
		"\u018e+\3\2\2\2\u018f\u0190\7\t\2\2\u0190\u0192\b\27\1\2\u0191\u0193\5"+
		"\62\32\2\u0192\u0191\3\2\2\2\u0192\u0193\3\2\2\2\u0193-\3\2\2\2\u0194"+
		"\u0195\5\66\34\2\u0195\u0196\7.\2\2\u0196\u0197\5\62\32\2\u0197/\3\2\2"+
		"\2\u0198\u01a1\5V,\2\u0199\u019a\7\60\2\2\u019a\u019b\5\62\32\2\u019b"+
		"\u019c\7\67\2\2\u019c\u019d\7\67\2\2\u019d\u019e\5\62\32\2\u019e\u019f"+
		"\7\61\2\2\u019f\u01a1\3\2\2\2\u01a0\u0198\3\2\2\2\u01a0\u0199\3\2\2\2"+
		"\u01a1\u01a2\3\2\2\2\u01a2\u01a3\7\67\2\2\u01a3\u01a4\7,\2\2\u01a4\u01a5"+
		"\b\31\1\2\u01a5\u01a6\7-\2\2\u01a6\u01a7\7\35\2\2\u01a7\u01a8\5V,\2\u01a8"+
		"\u01a9\7\35\2\2\u01a9\u01aa\5\24\13\2\u01aa\61\3\2\2\2\u01ab\u01ae\5\64"+
		"\33\2\u01ac\u01ad\7.\2\2\u01ad\u01af\5\62\32\2\u01ae\u01ac\3\2\2\2\u01ae"+
		"\u01af\3\2\2\2\u01af\63\3\2\2\2\u01b0\u01b8\5\66\34\2\u01b1\u01b2\7!\2"+
		"\2\u01b2\u01b3\5\64\33\2\u01b3\u01b4\7\"\2\2\u01b4\u01b5\5\64\33\2\u01b5"+
		"\u01b7\3\2\2\2\u01b6\u01b1\3\2\2\2\u01b7\u01ba\3\2\2\2\u01b8\u01b6\3\2"+
		"\2\2\u01b8\u01b9\3\2\2\2\u01b9\u01bb\3\2\2\2\u01ba\u01b8\3\2\2\2\u01bb"+
		"\u01bc\b\33\1\2\u01bc\65\3\2\2\2\u01bd\u01c2\58\35\2\u01be\u01bf\7\37"+
		"\2\2\u01bf\u01c1\58\35\2\u01c0\u01be\3\2\2\2\u01c1\u01c4\3\2\2\2\u01c2"+
		"\u01c0\3\2\2\2\u01c2\u01c3\3\2\2\2\u01c3\u01c5\3\2\2\2\u01c4\u01c2\3\2"+
		"\2\2\u01c5\u01c6\b\34\1\2\u01c6\67\3\2\2\2\u01c7\u01cc\5:\36\2\u01c8\u01c9"+
		"\7\36\2\2\u01c9\u01cb\5:\36\2\u01ca\u01c8\3\2\2\2\u01cb\u01ce\3\2\2\2"+
		"\u01cc\u01ca\3\2\2\2\u01cc\u01cd\3\2\2\2\u01cd\u01cf\3\2\2\2\u01ce\u01cc"+
		"\3\2\2\2\u01cf\u01d0\b\35\1\2\u01d09\3\2\2\2\u01d1\u01d6\5<\37\2\u01d2"+
		"\u01d3\7\31\2\2\u01d3\u01d5\5<\37\2\u01d4\u01d2\3\2\2\2\u01d5\u01d8\3"+
		"\2\2\2\u01d6\u01d4\3\2\2\2\u01d6\u01d7\3\2\2\2\u01d7\u01d9\3\2\2\2\u01d8"+
		"\u01d6\3\2\2\2\u01d9\u01da\b\36\1\2\u01da;\3\2\2\2\u01db\u01e3\5> \2\u01dc"+
		"\u01df\7\32\2\2\u01dd\u01df\7\33\2\2\u01de\u01dc\3\2\2\2\u01de\u01dd\3"+
		"\2\2\2\u01df\u01e0\3\2\2\2\u01e0\u01e2\5> \2\u01e1\u01de\3\2\2\2\u01e2"+
		"\u01e5\3\2\2\2\u01e3\u01e1\3\2\2\2\u01e3\u01e4\3\2\2\2\u01e4\u01e6\3\2"+
		"\2\2\u01e5\u01e3\3\2\2\2\u01e6\u01e7\b\37\1\2\u01e7=\3\2\2\2\u01e8\u01f0"+
		"\5@!\2\u01e9\u01ec\7\23\2\2\u01ea\u01ec\7\24\2\2\u01eb\u01e9\3\2\2\2\u01eb"+
		"\u01ea\3\2\2\2\u01ec\u01ed\3\2\2\2\u01ed\u01ef\5@!\2\u01ee\u01eb\3\2\2"+
		"\2\u01ef\u01f2\3\2\2\2\u01f0\u01ee\3\2\2\2\u01f0\u01f1\3\2\2\2\u01f1\u01f3"+
		"\3\2\2\2\u01f2\u01f0\3\2\2\2\u01f3\u01f4\b \1\2\u01f4?\3\2\2\2\u01f5\u01fd"+
		"\5B\"\2\u01f6\u01f9\7\25\2\2\u01f7\u01f9\7\26\2\2\u01f8\u01f6\3\2\2\2"+
		"\u01f8\u01f7\3\2\2\2\u01f9\u01fa\3\2\2\2\u01fa\u01fc\5B\"\2\u01fb\u01f8"+
		"\3\2\2\2\u01fc\u01ff\3\2\2\2\u01fd\u01fb\3\2\2\2\u01fd\u01fe\3\2\2\2\u01fe"+
		"\u0200\3\2\2\2\u01ff\u01fd\3\2\2\2\u0200\u0201\b!\1\2\u0201A\3\2\2\2\u0202"+
		"\u0205\7 \2\2\u0203\u0205\7\24\2\2\u0204\u0202\3\2\2\2\u0204\u0203\3\2"+
		"\2\2\u0205\u0206\3\2\2\2\u0206\u0207\5B\"\2\u0207\u0208\b\"\1\2\u0208"+
		"\u020b\3\2\2\2\u0209\u020b\5D#\2\u020a\u0204\3\2\2\2\u020a\u0209\3\2\2"+
		"\2\u020bC\3\2\2\2\u020c\u020f\5F$\2\u020d\u0210\7\27\2\2\u020e\u0210\7"+
		"\30\2\2\u020f\u020d\3\2\2\2\u020f\u020e\3\2\2\2\u020f\u0210\3\2\2\2\u0210"+
		"\u0211\3\2\2\2\u0211\u0212\b#\1\2\u0212E\3\2\2\2\u0213\u021c\5H%\2\u0214"+
		"\u0215\7\60\2\2\u0215\u0216\5\22\n\2\u0216\u0217\7\61\2\2\u0217\u021b"+
		"\3\2\2\2\u0218\u0219\7\67\2\2\u0219\u021b\5V,\2\u021a\u0214\3\2\2\2\u021a"+
		"\u0218\3\2\2\2\u021b\u021e\3\2\2\2\u021c\u021a\3\2\2\2\u021c\u021d\3\2"+
		"\2\2\u021d\u0227\3\2\2\2\u021e\u021c\3\2\2\2\u021f\u0220\7\62\2\2\u0220"+
		"\u0221\5\62\32\2\u0221\u0222\7\63\2\2\u0222\u0226\3\2\2\2\u0223\u0224"+
		"\7\67\2\2\u0224\u0226\5V,\2\u0225\u021f\3\2\2\2\u0225\u0223\3\2\2\2\u0226"+
		"\u0229\3\2\2\2\u0227\u0225\3\2\2\2\u0227\u0228\3\2\2\2\u0228G\3\2\2\2"+
		"\u0229\u0227\3\2\2\2\u022a\u0234\5P)\2\u022b\u0234\5V,\2\u022c\u022d\7"+
		"\60\2\2\u022d\u022e\5\22\n\2\u022e\u022f\7\61\2\2\u022f\u0234\3\2\2\2"+
		"\u0230\u0234\5L\'\2\u0231\u0234\5N(\2\u0232\u0234\5J&\2\u0233\u022a\3"+
		"\2\2\2\u0233\u022b\3\2\2\2\u0233\u022c\3\2\2\2\u0233\u0230\3\2\2\2\u0233"+
		"\u0231\3\2\2\2\u0233\u0232\3\2\2\2\u0234I\3\2\2\2\u0235\u0236\5V,\2\u0236"+
		"\u0237\7\62\2\2\u0237\u0238\5\62\32\2\u0238\u0239\7\63\2\2\u0239K\3\2"+
		"\2\2\u023a\u023b\7+\2\2\u023b\u023c\7\67\2\2\u023c\u023d\7\7\2\2\u023d"+
		"\u023e\b\'\1\2\u023e\u0247\7\60\2\2\u023f\u0244\5\66\34\2\u0240\u0241"+
		"\7\66\2\2\u0241\u0243\5\66\34\2\u0242\u0240\3\2\2\2\u0243\u0246\3\2\2"+
		"\2\u0244\u0242\3\2\2\2\u0244\u0245\3\2\2\2\u0245\u0248\3\2\2\2\u0246\u0244"+
		"\3\2\2\2\u0247\u023f\3\2\2\2\u0247\u0248\3\2\2\2\u0248\u0249\3\2\2\2\u0249"+
		"\u024a\7\61\2\2\u024aM\3\2\2\2\u024b\u024c\5V,\2\u024c\u024d\7\67\2\2"+
		"\u024d\u024e\7\f\2\2\u024e\u024f\b(\1\2\u024f\u0250\7\60\2\2\u0250\u0251"+
		"\5\66\34\2\u0251\u0252\7\61\2\2\u0252O\3\2\2\2\u0253\u0256\5R*\2\u0254"+
		"\u0256\7:\2\2\u0255\u0253\3\2\2\2\u0255\u0254\3\2\2\2\u0256Q\3\2\2\2\u0257"+
		"\u0258\t\3\2\2\u0258S\3\2\2\2\u0259\u025a\7<\2\2\u025aU\3\2\2\2\u025b"+
		"\u025c\7;\2\2\u025cW\3\2\2\2\u025d\u0264\7(\2\2\u025e\u0264\7)\2\2\u025f"+
		"\u0264\5Z.\2\u0260\u0264\5\\/\2\u0261\u0264\5^\60\2\u0262\u0264\5T+\2"+
		"\u0263\u025d\3\2\2\2\u0263\u025e\3\2\2\2\u0263\u025f\3\2\2\2\u0263\u0260"+
		"\3\2\2\2\u0263\u0261\3\2\2\2\u0263\u0262\3\2\2\2\u0264Y\3\2\2\2\u0265"+
		"\u0269\7(\2\2\u0266\u0269\7)\2\2\u0267\u0269\5T+\2\u0268\u0265\3\2\2\2"+
		"\u0268\u0266\3\2\2\2\u0268\u0267\3\2\2\2\u0269\u026e\3\2\2\2\u026a\u026b"+
		"\7\62\2\2\u026b\u026c\5\62\32\2\u026c\u026d\7\63\2\2\u026d\u026f\3\2\2"+
		"\2\u026e\u026a\3\2\2\2\u026f\u0270\3\2\2\2\u0270\u026e\3\2\2\2\u0270\u0271"+
		"\3\2\2\2\u0271[\3\2\2\2\u0272\u0273\7*\2\2\u0273\u027d\7\33\2\2\u0274"+
		"\u027e\7\n\2\2\u0275\u027a\5X-\2\u0276\u0277\7\66\2\2\u0277\u0279\5X-"+
		"\2\u0278\u0276\3\2\2\2\u0279\u027c\3\2\2\2\u027a\u0278\3\2\2\2\u027a\u027b"+
		"\3\2\2\2\u027b\u027e\3\2\2\2\u027c\u027a\3\2\2\2\u027d\u0274\3\2\2\2\u027d"+
		"\u0275\3\2\2\2\u027e\u027f\3\2\2\2\u027f\u0282\7\34\2\2\u0280\u0283\5"+
		"X-\2\u0281\u0283\7\n\2\2\u0282\u0280\3\2\2\2\u0282\u0281\3\2\2\2\u0283"+
		"\u0284\3\2\2\2\u0284\u0285\7\32\2\2\u0285]\3\2\2\2\u0286\u0287\7+\2\2"+
		"\u0287\u0288\7\33\2\2\u0288\u0289\7(\2\2\u0289\u028a\7\32\2\2\u028a_\3"+
		"\2\2\2Lcjqvz\u0081\u0085\u008a\u0096\u009b\u00a2\u00a7\u00ae\u00b5\u00b8"+
		"\u00bd\u00c1\u00c9\u00d4\u00d7\u00e0\u00e7\u00ea\u00f0\u00f4\u00f6\u00fc"+
		"\u0100\u0104\u0109\u0117\u012b\u0140\u0147\u014c\u0152\u0156\u015b\u0162"+
		"\u0167\u016e\u0180\u018a\u018d\u0192\u01a0\u01ae\u01b8\u01c2\u01cc\u01d6"+
		"\u01de\u01e3\u01eb\u01f0\u01f8\u01fd\u0204\u020a\u020f\u021a\u021c\u0225"+
		"\u0227\u0233\u0244\u0247\u0255\u0263\u0268\u0270\u027a\u027d\u0282";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}