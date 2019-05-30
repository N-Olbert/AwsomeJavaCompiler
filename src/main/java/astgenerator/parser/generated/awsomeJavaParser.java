// Generated from C:/Users/Daniel/IdeaProjects/AwsomeJavaCompiler/src/main/java/astgenerator/parser/grammar\awsomeJava.g4 by ANTLR 4.7.2
package astgenerator.parser.generated;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class awsomeJavaParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, AccessModifier=12, JBoolean=13, JNull=14, Void=15, 
		Super=16, This=17, If=18, Else=19, Equal=20, PlusEqual=21, MinusEqual=22, 
		Comperator=23, NotOperator=24, OpBeforeOrAfterIdentifier=25, PointOperator=26, 
		AddSubOperator=27, LogicalOperator=28, LBracket=29, RBracket=30, CurlyLBracket=31, 
		CurlyRBracket=32, Dot=33, Comma=34, Semicolon=35, Identifier=36, JCharacter=37, 
		JInteger=38, WS=39, Comment=40, LineComment=41, JString=42;
	public static final int
		RULE_programm = 0, RULE_jClass = 1, RULE_constructor = 2, RULE_mainMethod = 3, 
		RULE_classBody = 4, RULE_methodDeclaration = 5, RULE_fieldDeclaration = 6, 
		RULE_methodParameter = 7, RULE_nMethodParameters = 8, RULE_nArguments = 9, 
		RULE_expression = 10, RULE_basicexpressions = 11, RULE_instVar = 12, RULE_statementExpressions = 13, 
		RULE_assign = 14, RULE_localVarDeclaration = 15, RULE_jNew = 16, RULE_methodCall = 17, 
		RULE_statement = 18, RULE_block = 19, RULE_ifelse = 20, RULE_jIf = 21, 
		RULE_jElseIf = 22, RULE_jElse = 23, RULE_jWhile = 24, RULE_jReturn = 25, 
		RULE_unary = 26, RULE_binary = 27, RULE_baseType = 28, RULE_objectType = 29, 
		RULE_operators = 30;
	private static String[] makeRuleNames() {
		return new String[] {
			"programm", "jClass", "constructor", "mainMethod", "classBody", "methodDeclaration", 
			"fieldDeclaration", "methodParameter", "nMethodParameters", "nArguments", 
			"expression", "basicexpressions", "instVar", "statementExpressions", 
			"assign", "localVarDeclaration", "jNew", "methodCall", "statement", "block", 
			"ifelse", "jIf", "jElseIf", "jElse", "jWhile", "jReturn", "unary", "binary", 
			"baseType", "objectType", "operators"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'class'", "'static'", "'main'", "'String[]'", "'args'", "'new'", 
			"'while'", "'return'", "'int'", "'char'", "'boolean'", null, null, "'null'", 
			"'void'", "'super'", "'this'", "'if'", "'else'", "'='", "'+='", "'-='", 
			null, "'!'", null, null, null, null, "'('", "')'", "'{'", "'}'", "'.'", 
			"','", "';'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			"AccessModifier", "JBoolean", "JNull", "Void", "Super", "This", "If", 
			"Else", "Equal", "PlusEqual", "MinusEqual", "Comperator", "NotOperator", 
			"OpBeforeOrAfterIdentifier", "PointOperator", "AddSubOperator", "LogicalOperator", 
			"LBracket", "RBracket", "CurlyLBracket", "CurlyRBracket", "Dot", "Comma", 
			"Semicolon", "Identifier", "JCharacter", "JInteger", "WS", "Comment", 
			"LineComment", "JString"
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
	public String getGrammarFileName() { return "awsomeJava.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public awsomeJavaParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgrammContext extends ParserRuleContext {
		public List<JClassContext> jClass() {
			return getRuleContexts(JClassContext.class);
		}
		public JClassContext jClass(int i) {
			return getRuleContext(JClassContext.class,i);
		}
		public ProgrammContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_programm; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof awsomeJavaListener ) ((awsomeJavaListener)listener).enterProgramm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof awsomeJavaListener ) ((awsomeJavaListener)listener).exitProgramm(this);
		}
	}

	public final ProgrammContext programm() throws RecognitionException {
		ProgrammContext _localctx = new ProgrammContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_programm);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(63); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(62);
				jClass();
				}
				}
				setState(65); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__0 );
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

	public static class JClassContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(awsomeJavaParser.Identifier, 0); }
		public ClassBodyContext classBody() {
			return getRuleContext(ClassBodyContext.class,0);
		}
		public JClassContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jClass; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof awsomeJavaListener ) ((awsomeJavaListener)listener).enterJClass(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof awsomeJavaListener ) ((awsomeJavaListener)listener).exitJClass(this);
		}
	}

	public final JClassContext jClass() throws RecognitionException {
		JClassContext _localctx = new JClassContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_jClass);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(67);
			match(T__0);
			setState(68);
			match(Identifier);
			setState(69);
			classBody();
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
		public TerminalNode Identifier() { return getToken(awsomeJavaParser.Identifier, 0); }
		public TerminalNode LBracket() { return getToken(awsomeJavaParser.LBracket, 0); }
		public NMethodParametersContext nMethodParameters() {
			return getRuleContext(NMethodParametersContext.class,0);
		}
		public TerminalNode RBracket() { return getToken(awsomeJavaParser.RBracket, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode AccessModifier() { return getToken(awsomeJavaParser.AccessModifier, 0); }
		public ConstructorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constructor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof awsomeJavaListener ) ((awsomeJavaListener)listener).enterConstructor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof awsomeJavaListener ) ((awsomeJavaListener)listener).exitConstructor(this);
		}
	}

	public final ConstructorContext constructor() throws RecognitionException {
		ConstructorContext _localctx = new ConstructorContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_constructor);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(72);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==AccessModifier) {
				{
				setState(71);
				match(AccessModifier);
				}
			}

			setState(74);
			match(Identifier);
			setState(75);
			match(LBracket);
			setState(76);
			nMethodParameters();
			setState(77);
			match(RBracket);
			setState(78);
			block();
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

	public static class MainMethodContext extends ParserRuleContext {
		public TerminalNode AccessModifier() { return getToken(awsomeJavaParser.AccessModifier, 0); }
		public TerminalNode Void() { return getToken(awsomeJavaParser.Void, 0); }
		public TerminalNode LBracket() { return getToken(awsomeJavaParser.LBracket, 0); }
		public TerminalNode RBracket() { return getToken(awsomeJavaParser.RBracket, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public MainMethodContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mainMethod; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof awsomeJavaListener ) ((awsomeJavaListener)listener).enterMainMethod(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof awsomeJavaListener ) ((awsomeJavaListener)listener).exitMainMethod(this);
		}
	}

	public final MainMethodContext mainMethod() throws RecognitionException {
		MainMethodContext _localctx = new MainMethodContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_mainMethod);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(80);
			match(AccessModifier);
			setState(81);
			match(T__1);
			setState(82);
			match(Void);
			setState(83);
			match(T__2);
			setState(84);
			match(LBracket);
			setState(85);
			match(T__3);
			setState(86);
			match(T__4);
			setState(87);
			match(RBracket);
			setState(88);
			block();
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

	public static class ClassBodyContext extends ParserRuleContext {
		public TerminalNode CurlyLBracket() { return getToken(awsomeJavaParser.CurlyLBracket, 0); }
		public TerminalNode CurlyRBracket() { return getToken(awsomeJavaParser.CurlyRBracket, 0); }
		public List<MethodDeclarationContext> methodDeclaration() {
			return getRuleContexts(MethodDeclarationContext.class);
		}
		public MethodDeclarationContext methodDeclaration(int i) {
			return getRuleContext(MethodDeclarationContext.class,i);
		}
		public List<FieldDeclarationContext> fieldDeclaration() {
			return getRuleContexts(FieldDeclarationContext.class);
		}
		public FieldDeclarationContext fieldDeclaration(int i) {
			return getRuleContext(FieldDeclarationContext.class,i);
		}
		public List<ConstructorContext> constructor() {
			return getRuleContexts(ConstructorContext.class);
		}
		public ConstructorContext constructor(int i) {
			return getRuleContext(ConstructorContext.class,i);
		}
		public MainMethodContext mainMethod() {
			return getRuleContext(MainMethodContext.class,0);
		}
		public ClassBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof awsomeJavaListener ) ((awsomeJavaListener)listener).enterClassBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof awsomeJavaListener ) ((awsomeJavaListener)listener).exitClassBody(this);
		}
	}

	public final ClassBodyContext classBody() throws RecognitionException {
		ClassBodyContext _localctx = new ClassBodyContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_classBody);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(90);
			match(CurlyLBracket);
			setState(96);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(94);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
					case 1:
						{
						setState(91);
						methodDeclaration();
						}
						break;
					case 2:
						{
						setState(92);
						fieldDeclaration();
						}
						break;
					case 3:
						{
						setState(93);
						constructor();
						}
						break;
					}
					} 
				}
				setState(98);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			}
			setState(100);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				{
				setState(99);
				mainMethod();
				}
				break;
			}
			setState(107);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << AccessModifier) | (1L << Void) | (1L << Identifier))) != 0)) {
				{
				setState(105);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
				case 1:
					{
					setState(102);
					methodDeclaration();
					}
					break;
				case 2:
					{
					setState(103);
					fieldDeclaration();
					}
					break;
				case 3:
					{
					setState(104);
					constructor();
					}
					break;
				}
				}
				setState(109);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(110);
			match(CurlyRBracket);
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

	public static class MethodDeclarationContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(awsomeJavaParser.Identifier, 0); }
		public TerminalNode LBracket() { return getToken(awsomeJavaParser.LBracket, 0); }
		public NMethodParametersContext nMethodParameters() {
			return getRuleContext(NMethodParametersContext.class,0);
		}
		public TerminalNode RBracket() { return getToken(awsomeJavaParser.RBracket, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ObjectTypeContext objectType() {
			return getRuleContext(ObjectTypeContext.class,0);
		}
		public TerminalNode Void() { return getToken(awsomeJavaParser.Void, 0); }
		public TerminalNode AccessModifier() { return getToken(awsomeJavaParser.AccessModifier, 0); }
		public MethodDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof awsomeJavaListener ) ((awsomeJavaListener)listener).enterMethodDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof awsomeJavaListener ) ((awsomeJavaListener)listener).exitMethodDeclaration(this);
		}
	}

	public final MethodDeclarationContext methodDeclaration() throws RecognitionException {
		MethodDeclarationContext _localctx = new MethodDeclarationContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_methodDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(113);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==AccessModifier) {
				{
				setState(112);
				match(AccessModifier);
				}
			}

			setState(117);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__8:
			case T__9:
			case T__10:
			case Identifier:
				{
				setState(115);
				objectType();
				}
				break;
			case Void:
				{
				setState(116);
				match(Void);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(119);
			match(Identifier);
			setState(120);
			match(LBracket);
			setState(121);
			nMethodParameters();
			setState(122);
			match(RBracket);
			setState(123);
			block();
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

	public static class FieldDeclarationContext extends ParserRuleContext {
		public ObjectTypeContext objectType() {
			return getRuleContext(ObjectTypeContext.class,0);
		}
		public List<TerminalNode> Identifier() { return getTokens(awsomeJavaParser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(awsomeJavaParser.Identifier, i);
		}
		public TerminalNode Semicolon() { return getToken(awsomeJavaParser.Semicolon, 0); }
		public TerminalNode AccessModifier() { return getToken(awsomeJavaParser.AccessModifier, 0); }
		public List<TerminalNode> Comma() { return getTokens(awsomeJavaParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(awsomeJavaParser.Comma, i);
		}
		public TerminalNode Equal() { return getToken(awsomeJavaParser.Equal, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public FieldDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof awsomeJavaListener ) ((awsomeJavaListener)listener).enterFieldDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof awsomeJavaListener ) ((awsomeJavaListener)listener).exitFieldDeclaration(this);
		}
	}

	public final FieldDeclarationContext fieldDeclaration() throws RecognitionException {
		FieldDeclarationContext _localctx = new FieldDeclarationContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_fieldDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(126);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==AccessModifier) {
				{
				setState(125);
				match(AccessModifier);
				}
			}

			setState(128);
			objectType();
			setState(129);
			match(Identifier);
			setState(134);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(130);
				match(Comma);
				setState(131);
				match(Identifier);
				}
				}
				setState(136);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(139);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Equal) {
				{
				setState(137);
				match(Equal);
				setState(138);
				expression();
				}
			}

			setState(141);
			match(Semicolon);
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

	public static class MethodParameterContext extends ParserRuleContext {
		public ObjectTypeContext objectType() {
			return getRuleContext(ObjectTypeContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(awsomeJavaParser.Identifier, 0); }
		public MethodParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodParameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof awsomeJavaListener ) ((awsomeJavaListener)listener).enterMethodParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof awsomeJavaListener ) ((awsomeJavaListener)listener).exitMethodParameter(this);
		}
	}

	public final MethodParameterContext methodParameter() throws RecognitionException {
		MethodParameterContext _localctx = new MethodParameterContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_methodParameter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(143);
			objectType();
			setState(144);
			match(Identifier);
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

	public static class NMethodParametersContext extends ParserRuleContext {
		public List<MethodParameterContext> methodParameter() {
			return getRuleContexts(MethodParameterContext.class);
		}
		public MethodParameterContext methodParameter(int i) {
			return getRuleContext(MethodParameterContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(awsomeJavaParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(awsomeJavaParser.Comma, i);
		}
		public NMethodParametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nMethodParameters; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof awsomeJavaListener ) ((awsomeJavaListener)listener).enterNMethodParameters(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof awsomeJavaListener ) ((awsomeJavaListener)listener).exitNMethodParameters(this);
		}
	}

	public final NMethodParametersContext nMethodParameters() throws RecognitionException {
		NMethodParametersContext _localctx = new NMethodParametersContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_nMethodParameters);
		int _la;
		try {
			setState(156);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(147);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << Identifier))) != 0)) {
					{
					setState(146);
					methodParameter();
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(149);
				methodParameter();
				setState(152); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(150);
					match(Comma);
					setState(151);
					methodParameter();
					}
					}
					setState(154); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==Comma );
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

	public static class NArgumentsContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(awsomeJavaParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(awsomeJavaParser.Comma, i);
		}
		public InstVarContext instVar() {
			return getRuleContext(InstVarContext.class,0);
		}
		public NArgumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nArguments; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof awsomeJavaListener ) ((awsomeJavaListener)listener).enterNArguments(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof awsomeJavaListener ) ((awsomeJavaListener)listener).exitNArguments(this);
		}
	}

	public final NArgumentsContext nArguments() throws RecognitionException {
		NArgumentsContext _localctx = new NArgumentsContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_nArguments);
		int _la;
		try {
			setState(170);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(159);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << JBoolean) | (1L << JNull) | (1L << Super) | (1L << This) | (1L << NotOperator) | (1L << LBracket) | (1L << Identifier) | (1L << JCharacter) | (1L << JInteger) | (1L << JString))) != 0)) {
					{
					setState(158);
					expression();
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(161);
				expression();
				setState(166);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Comma) {
					{
					{
					setState(162);
					match(Comma);
					setState(163);
					expression();
					}
					}
					setState(168);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(169);
				instVar();
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

	public static class ExpressionContext extends ParserRuleContext {
		public BasicexpressionsContext basicexpressions() {
			return getRuleContext(BasicexpressionsContext.class,0);
		}
		public BinaryContext binary() {
			return getRuleContext(BinaryContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof awsomeJavaListener ) ((awsomeJavaListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof awsomeJavaListener ) ((awsomeJavaListener)listener).exitExpression(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_expression);
		try {
			setState(174);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(172);
				basicexpressions();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(173);
				binary();
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

	public static class BasicexpressionsContext extends ParserRuleContext {
		public BaseTypeContext baseType() {
			return getRuleContext(BaseTypeContext.class,0);
		}
		public InstVarContext instVar() {
			return getRuleContext(InstVarContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(awsomeJavaParser.Identifier, 0); }
		public StatementExpressionsContext statementExpressions() {
			return getRuleContext(StatementExpressionsContext.class,0);
		}
		public UnaryContext unary() {
			return getRuleContext(UnaryContext.class,0);
		}
		public TerminalNode LBracket() { return getToken(awsomeJavaParser.LBracket, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RBracket() { return getToken(awsomeJavaParser.RBracket, 0); }
		public BasicexpressionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_basicexpressions; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof awsomeJavaListener ) ((awsomeJavaListener)listener).enterBasicexpressions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof awsomeJavaListener ) ((awsomeJavaListener)listener).exitBasicexpressions(this);
		}
	}

	public final BasicexpressionsContext basicexpressions() throws RecognitionException {
		BasicexpressionsContext _localctx = new BasicexpressionsContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_basicexpressions);
		try {
			setState(185);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(176);
				baseType();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(177);
				instVar();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(178);
				match(Identifier);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(179);
				statementExpressions();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(180);
				unary();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(181);
				match(LBracket);
				setState(182);
				expression();
				setState(183);
				match(RBracket);
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

	public static class InstVarContext extends ParserRuleContext {
		public TerminalNode This() { return getToken(awsomeJavaParser.This, 0); }
		public List<TerminalNode> Dot() { return getTokens(awsomeJavaParser.Dot); }
		public TerminalNode Dot(int i) {
			return getToken(awsomeJavaParser.Dot, i);
		}
		public List<TerminalNode> Identifier() { return getTokens(awsomeJavaParser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(awsomeJavaParser.Identifier, i);
		}
		public InstVarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instVar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof awsomeJavaListener ) ((awsomeJavaListener)listener).enterInstVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof awsomeJavaListener ) ((awsomeJavaListener)listener).exitInstVar(this);
		}
	}

	public final InstVarContext instVar() throws RecognitionException {
		InstVarContext _localctx = new InstVarContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_instVar);
		int _la;
		try {
			int _alt;
			setState(201);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(187);
				match(This);
				setState(188);
				match(Dot);
				setState(189);
				match(Identifier);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(192);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==This) {
					{
					setState(190);
					match(This);
					setState(191);
					match(Dot);
					}
				}

				setState(196); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(194);
						match(Identifier);
						setState(195);
						match(Dot);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(198); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(200);
				match(Identifier);
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

	public static class StatementExpressionsContext extends ParserRuleContext {
		public AssignContext assign() {
			return getRuleContext(AssignContext.class,0);
		}
		public JNewContext jNew() {
			return getRuleContext(JNewContext.class,0);
		}
		public MethodCallContext methodCall() {
			return getRuleContext(MethodCallContext.class,0);
		}
		public StatementExpressionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statementExpressions; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof awsomeJavaListener ) ((awsomeJavaListener)listener).enterStatementExpressions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof awsomeJavaListener ) ((awsomeJavaListener)listener).exitStatementExpressions(this);
		}
	}

	public final StatementExpressionsContext statementExpressions() throws RecognitionException {
		StatementExpressionsContext _localctx = new StatementExpressionsContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_statementExpressions);
		try {
			setState(206);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(203);
				assign();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(204);
				jNew();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(205);
				methodCall();
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

	public static class AssignContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode Equal() { return getToken(awsomeJavaParser.Equal, 0); }
		public TerminalNode PlusEqual() { return getToken(awsomeJavaParser.PlusEqual, 0); }
		public TerminalNode MinusEqual() { return getToken(awsomeJavaParser.MinusEqual, 0); }
		public InstVarContext instVar() {
			return getRuleContext(InstVarContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(awsomeJavaParser.Identifier, 0); }
		public AssignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assign; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof awsomeJavaListener ) ((awsomeJavaListener)listener).enterAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof awsomeJavaListener ) ((awsomeJavaListener)listener).exitAssign(this);
		}
	}

	public final AssignContext assign() throws RecognitionException {
		AssignContext _localctx = new AssignContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_assign);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(210);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
			case 1:
				{
				setState(208);
				instVar();
				}
				break;
			case 2:
				{
				setState(209);
				match(Identifier);
				}
				break;
			}
			setState(212);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Equal) | (1L << PlusEqual) | (1L << MinusEqual))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(213);
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

	public static class LocalVarDeclarationContext extends ParserRuleContext {
		public ObjectTypeContext objectType() {
			return getRuleContext(ObjectTypeContext.class,0);
		}
		public List<TerminalNode> Identifier() { return getTokens(awsomeJavaParser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(awsomeJavaParser.Identifier, i);
		}
		public List<TerminalNode> Comma() { return getTokens(awsomeJavaParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(awsomeJavaParser.Comma, i);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode Equal() { return getToken(awsomeJavaParser.Equal, 0); }
		public TerminalNode PlusEqual() { return getToken(awsomeJavaParser.PlusEqual, 0); }
		public TerminalNode MinusEqual() { return getToken(awsomeJavaParser.MinusEqual, 0); }
		public LocalVarDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_localVarDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof awsomeJavaListener ) ((awsomeJavaListener)listener).enterLocalVarDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof awsomeJavaListener ) ((awsomeJavaListener)listener).exitLocalVarDeclaration(this);
		}
	}

	public final LocalVarDeclarationContext localVarDeclaration() throws RecognitionException {
		LocalVarDeclarationContext _localctx = new LocalVarDeclarationContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_localVarDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(215);
			objectType();
			setState(216);
			match(Identifier);
			setState(221);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(217);
				match(Comma);
				setState(218);
				match(Identifier);
				}
				}
				setState(223);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(226);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Equal) | (1L << PlusEqual) | (1L << MinusEqual))) != 0)) {
				{
				setState(224);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Equal) | (1L << PlusEqual) | (1L << MinusEqual))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(225);
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

	public static class JNewContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(awsomeJavaParser.Identifier, 0); }
		public TerminalNode LBracket() { return getToken(awsomeJavaParser.LBracket, 0); }
		public NArgumentsContext nArguments() {
			return getRuleContext(NArgumentsContext.class,0);
		}
		public TerminalNode RBracket() { return getToken(awsomeJavaParser.RBracket, 0); }
		public JNewContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jNew; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof awsomeJavaListener ) ((awsomeJavaListener)listener).enterJNew(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof awsomeJavaListener ) ((awsomeJavaListener)listener).exitJNew(this);
		}
	}

	public final JNewContext jNew() throws RecognitionException {
		JNewContext _localctx = new JNewContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_jNew);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(228);
			match(T__5);
			setState(229);
			match(Identifier);
			setState(230);
			match(LBracket);
			setState(231);
			nArguments();
			setState(232);
			match(RBracket);
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

	public static class MethodCallContext extends ParserRuleContext {
		public TerminalNode LBracket() { return getToken(awsomeJavaParser.LBracket, 0); }
		public NArgumentsContext nArguments() {
			return getRuleContext(NArgumentsContext.class,0);
		}
		public TerminalNode RBracket() { return getToken(awsomeJavaParser.RBracket, 0); }
		public InstVarContext instVar() {
			return getRuleContext(InstVarContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(awsomeJavaParser.Identifier, 0); }
		public MethodCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodCall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof awsomeJavaListener ) ((awsomeJavaListener)listener).enterMethodCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof awsomeJavaListener ) ((awsomeJavaListener)listener).exitMethodCall(this);
		}
	}

	public final MethodCallContext methodCall() throws RecognitionException {
		MethodCallContext _localctx = new MethodCallContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_methodCall);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(236);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				{
				setState(234);
				instVar();
				}
				break;
			case 2:
				{
				setState(235);
				match(Identifier);
				}
				break;
			}
			setState(238);
			match(LBracket);
			setState(239);
			nArguments();
			setState(240);
			match(RBracket);
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

	public static class StatementContext extends ParserRuleContext {
		public IfelseContext ifelse() {
			return getRuleContext(IfelseContext.class,0);
		}
		public LocalVarDeclarationContext localVarDeclaration() {
			return getRuleContext(LocalVarDeclarationContext.class,0);
		}
		public TerminalNode Semicolon() { return getToken(awsomeJavaParser.Semicolon, 0); }
		public JReturnContext jReturn() {
			return getRuleContext(JReturnContext.class,0);
		}
		public JWhileContext jWhile() {
			return getRuleContext(JWhileContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public StatementExpressionsContext statementExpressions() {
			return getRuleContext(StatementExpressionsContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof awsomeJavaListener ) ((awsomeJavaListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof awsomeJavaListener ) ((awsomeJavaListener)listener).exitStatement(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_statement);
		try {
			setState(254);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(242);
				ifelse();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(243);
				localVarDeclaration();
				setState(244);
				match(Semicolon);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(246);
				jReturn();
				setState(247);
				match(Semicolon);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(249);
				jWhile();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(250);
				block();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(251);
				statementExpressions();
				setState(252);
				match(Semicolon);
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

	public static class BlockContext extends ParserRuleContext {
		public TerminalNode CurlyLBracket() { return getToken(awsomeJavaParser.CurlyLBracket, 0); }
		public TerminalNode CurlyRBracket() { return getToken(awsomeJavaParser.CurlyRBracket, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof awsomeJavaListener ) ((awsomeJavaListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof awsomeJavaListener ) ((awsomeJavaListener)listener).exitBlock(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(256);
			match(CurlyLBracket);
			setState(260);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << This) | (1L << If) | (1L << CurlyLBracket) | (1L << Identifier))) != 0)) {
				{
				{
				setState(257);
				statement();
				}
				}
				setState(262);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(263);
			match(CurlyRBracket);
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

	public static class IfelseContext extends ParserRuleContext {
		public JIfContext jIf() {
			return getRuleContext(JIfContext.class,0);
		}
		public List<JElseIfContext> jElseIf() {
			return getRuleContexts(JElseIfContext.class);
		}
		public JElseIfContext jElseIf(int i) {
			return getRuleContext(JElseIfContext.class,i);
		}
		public JElseContext jElse() {
			return getRuleContext(JElseContext.class,0);
		}
		public IfelseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifelse; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof awsomeJavaListener ) ((awsomeJavaListener)listener).enterIfelse(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof awsomeJavaListener ) ((awsomeJavaListener)listener).exitIfelse(this);
		}
	}

	public final IfelseContext ifelse() throws RecognitionException {
		IfelseContext _localctx = new IfelseContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_ifelse);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(265);
			jIf();
			setState(269);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,30,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(266);
					jElseIf();
					}
					} 
				}
				setState(271);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,30,_ctx);
			}
			setState(273);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Else) {
				{
				setState(272);
				jElse();
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

	public static class JIfContext extends ParserRuleContext {
		public TerminalNode If() { return getToken(awsomeJavaParser.If, 0); }
		public TerminalNode LBracket() { return getToken(awsomeJavaParser.LBracket, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RBracket() { return getToken(awsomeJavaParser.RBracket, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public JIfContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jIf; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof awsomeJavaListener ) ((awsomeJavaListener)listener).enterJIf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof awsomeJavaListener ) ((awsomeJavaListener)listener).exitJIf(this);
		}
	}

	public final JIfContext jIf() throws RecognitionException {
		JIfContext _localctx = new JIfContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_jIf);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(275);
			match(If);
			setState(276);
			match(LBracket);
			setState(277);
			expression();
			setState(278);
			match(RBracket);
			setState(279);
			block();
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

	public static class JElseIfContext extends ParserRuleContext {
		public TerminalNode Else() { return getToken(awsomeJavaParser.Else, 0); }
		public TerminalNode If() { return getToken(awsomeJavaParser.If, 0); }
		public TerminalNode LBracket() { return getToken(awsomeJavaParser.LBracket, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RBracket() { return getToken(awsomeJavaParser.RBracket, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public JElseIfContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jElseIf; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof awsomeJavaListener ) ((awsomeJavaListener)listener).enterJElseIf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof awsomeJavaListener ) ((awsomeJavaListener)listener).exitJElseIf(this);
		}
	}

	public final JElseIfContext jElseIf() throws RecognitionException {
		JElseIfContext _localctx = new JElseIfContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_jElseIf);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(281);
			match(Else);
			setState(282);
			match(If);
			setState(283);
			match(LBracket);
			setState(284);
			expression();
			setState(285);
			match(RBracket);
			setState(286);
			block();
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

	public static class JElseContext extends ParserRuleContext {
		public TerminalNode Else() { return getToken(awsomeJavaParser.Else, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public JElseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jElse; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof awsomeJavaListener ) ((awsomeJavaListener)listener).enterJElse(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof awsomeJavaListener ) ((awsomeJavaListener)listener).exitJElse(this);
		}
	}

	public final JElseContext jElse() throws RecognitionException {
		JElseContext _localctx = new JElseContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_jElse);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(288);
			match(Else);
			setState(289);
			block();
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

	public static class JWhileContext extends ParserRuleContext {
		public TerminalNode LBracket() { return getToken(awsomeJavaParser.LBracket, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RBracket() { return getToken(awsomeJavaParser.RBracket, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public JWhileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jWhile; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof awsomeJavaListener ) ((awsomeJavaListener)listener).enterJWhile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof awsomeJavaListener ) ((awsomeJavaListener)listener).exitJWhile(this);
		}
	}

	public final JWhileContext jWhile() throws RecognitionException {
		JWhileContext _localctx = new JWhileContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_jWhile);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(291);
			match(T__6);
			setState(292);
			match(LBracket);
			setState(293);
			expression();
			setState(294);
			match(RBracket);
			setState(295);
			block();
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

	public static class JReturnContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public JReturnContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jReturn; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof awsomeJavaListener ) ((awsomeJavaListener)listener).enterJReturn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof awsomeJavaListener ) ((awsomeJavaListener)listener).exitJReturn(this);
		}
	}

	public final JReturnContext jReturn() throws RecognitionException {
		JReturnContext _localctx = new JReturnContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_jReturn);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(297);
			match(T__7);
			setState(298);
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

	public static class UnaryContext extends ParserRuleContext {
		public TerminalNode NotOperator() { return getToken(awsomeJavaParser.NotOperator, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public UnaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof awsomeJavaListener ) ((awsomeJavaListener)listener).enterUnary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof awsomeJavaListener ) ((awsomeJavaListener)listener).exitUnary(this);
		}
	}

	public final UnaryContext unary() throws RecognitionException {
		UnaryContext _localctx = new UnaryContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_unary);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(300);
			match(NotOperator);
			setState(301);
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

	public static class BinaryContext extends ParserRuleContext {
		public List<BasicexpressionsContext> basicexpressions() {
			return getRuleContexts(BasicexpressionsContext.class);
		}
		public BasicexpressionsContext basicexpressions(int i) {
			return getRuleContext(BasicexpressionsContext.class,i);
		}
		public List<OperatorsContext> operators() {
			return getRuleContexts(OperatorsContext.class);
		}
		public OperatorsContext operators(int i) {
			return getRuleContext(OperatorsContext.class,i);
		}
		public BinaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof awsomeJavaListener ) ((awsomeJavaListener)listener).enterBinary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof awsomeJavaListener ) ((awsomeJavaListener)listener).exitBinary(this);
		}
	}

	public final BinaryContext binary() throws RecognitionException {
		BinaryContext _localctx = new BinaryContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_binary);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(303);
			basicexpressions();
			setState(307); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(304);
					operators();
					setState(305);
					basicexpressions();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(309); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
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

	public static class BaseTypeContext extends ParserRuleContext {
		public TerminalNode JBoolean() { return getToken(awsomeJavaParser.JBoolean, 0); }
		public TerminalNode JNull() { return getToken(awsomeJavaParser.JNull, 0); }
		public TerminalNode This() { return getToken(awsomeJavaParser.This, 0); }
		public TerminalNode JString() { return getToken(awsomeJavaParser.JString, 0); }
		public TerminalNode JCharacter() { return getToken(awsomeJavaParser.JCharacter, 0); }
		public TerminalNode JInteger() { return getToken(awsomeJavaParser.JInteger, 0); }
		public TerminalNode Super() { return getToken(awsomeJavaParser.Super, 0); }
		public BaseTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_baseType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof awsomeJavaListener ) ((awsomeJavaListener)listener).enterBaseType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof awsomeJavaListener ) ((awsomeJavaListener)listener).exitBaseType(this);
		}
	}

	public final BaseTypeContext baseType() throws RecognitionException {
		BaseTypeContext _localctx = new BaseTypeContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_baseType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(311);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << JBoolean) | (1L << JNull) | (1L << Super) | (1L << This) | (1L << JCharacter) | (1L << JInteger) | (1L << JString))) != 0)) ) {
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

	public static class ObjectTypeContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(awsomeJavaParser.Identifier, 0); }
		public ObjectTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_objectType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof awsomeJavaListener ) ((awsomeJavaListener)listener).enterObjectType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof awsomeJavaListener ) ((awsomeJavaListener)listener).exitObjectType(this);
		}
	}

	public final ObjectTypeContext objectType() throws RecognitionException {
		ObjectTypeContext _localctx = new ObjectTypeContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_objectType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(313);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << Identifier))) != 0)) ) {
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

	public static class OperatorsContext extends ParserRuleContext {
		public TerminalNode LogicalOperator() { return getToken(awsomeJavaParser.LogicalOperator, 0); }
		public TerminalNode Comperator() { return getToken(awsomeJavaParser.Comperator, 0); }
		public TerminalNode AddSubOperator() { return getToken(awsomeJavaParser.AddSubOperator, 0); }
		public TerminalNode PointOperator() { return getToken(awsomeJavaParser.PointOperator, 0); }
		public OperatorsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operators; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof awsomeJavaListener ) ((awsomeJavaListener)listener).enterOperators(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof awsomeJavaListener ) ((awsomeJavaListener)listener).exitOperators(this);
		}
	}

	public final OperatorsContext operators() throws RecognitionException {
		OperatorsContext _localctx = new OperatorsContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_operators);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(315);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Comperator) | (1L << PointOperator) | (1L << AddSubOperator) | (1L << LogicalOperator))) != 0)) ) {
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3,\u0140\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \3\2"+
		"\6\2B\n\2\r\2\16\2C\3\3\3\3\3\3\3\3\3\4\5\4K\n\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\7\6a\n\6\f"+
		"\6\16\6d\13\6\3\6\5\6g\n\6\3\6\3\6\3\6\7\6l\n\6\f\6\16\6o\13\6\3\6\3\6"+
		"\3\7\5\7t\n\7\3\7\3\7\5\7x\n\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\5\b\u0081\n"+
		"\b\3\b\3\b\3\b\3\b\7\b\u0087\n\b\f\b\16\b\u008a\13\b\3\b\3\b\5\b\u008e"+
		"\n\b\3\b\3\b\3\t\3\t\3\t\3\n\5\n\u0096\n\n\3\n\3\n\3\n\6\n\u009b\n\n\r"+
		"\n\16\n\u009c\5\n\u009f\n\n\3\13\5\13\u00a2\n\13\3\13\3\13\3\13\7\13\u00a7"+
		"\n\13\f\13\16\13\u00aa\13\13\3\13\5\13\u00ad\n\13\3\f\3\f\5\f\u00b1\n"+
		"\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u00bc\n\r\3\16\3\16\3\16\3"+
		"\16\3\16\5\16\u00c3\n\16\3\16\3\16\6\16\u00c7\n\16\r\16\16\16\u00c8\3"+
		"\16\5\16\u00cc\n\16\3\17\3\17\3\17\5\17\u00d1\n\17\3\20\3\20\5\20\u00d5"+
		"\n\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\7\21\u00de\n\21\f\21\16\21\u00e1"+
		"\13\21\3\21\3\21\5\21\u00e5\n\21\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3"+
		"\23\5\23\u00ef\n\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\5\24\u0101\n\24\3\25\3\25\7\25\u0105\n"+
		"\25\f\25\16\25\u0108\13\25\3\25\3\25\3\26\3\26\7\26\u010e\n\26\f\26\16"+
		"\26\u0111\13\26\3\26\5\26\u0114\n\26\3\27\3\27\3\27\3\27\3\27\3\27\3\30"+
		"\3\30\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32"+
		"\3\32\3\33\3\33\3\33\3\34\3\34\3\34\3\35\3\35\3\35\3\35\6\35\u0136\n\35"+
		"\r\35\16\35\u0137\3\36\3\36\3\37\3\37\3 \3 \3 \2\2!\2\4\6\b\n\f\16\20"+
		"\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>\2\6\3\2\26\30\6\2\17\20"+
		"\22\23\'(,,\4\2\13\r&&\4\2\31\31\34\36\2\u014d\2A\3\2\2\2\4E\3\2\2\2\6"+
		"J\3\2\2\2\bR\3\2\2\2\n\\\3\2\2\2\fs\3\2\2\2\16\u0080\3\2\2\2\20\u0091"+
		"\3\2\2\2\22\u009e\3\2\2\2\24\u00ac\3\2\2\2\26\u00b0\3\2\2\2\30\u00bb\3"+
		"\2\2\2\32\u00cb\3\2\2\2\34\u00d0\3\2\2\2\36\u00d4\3\2\2\2 \u00d9\3\2\2"+
		"\2\"\u00e6\3\2\2\2$\u00ee\3\2\2\2&\u0100\3\2\2\2(\u0102\3\2\2\2*\u010b"+
		"\3\2\2\2,\u0115\3\2\2\2.\u011b\3\2\2\2\60\u0122\3\2\2\2\62\u0125\3\2\2"+
		"\2\64\u012b\3\2\2\2\66\u012e\3\2\2\28\u0131\3\2\2\2:\u0139\3\2\2\2<\u013b"+
		"\3\2\2\2>\u013d\3\2\2\2@B\5\4\3\2A@\3\2\2\2BC\3\2\2\2CA\3\2\2\2CD\3\2"+
		"\2\2D\3\3\2\2\2EF\7\3\2\2FG\7&\2\2GH\5\n\6\2H\5\3\2\2\2IK\7\16\2\2JI\3"+
		"\2\2\2JK\3\2\2\2KL\3\2\2\2LM\7&\2\2MN\7\37\2\2NO\5\22\n\2OP\7 \2\2PQ\5"+
		"(\25\2Q\7\3\2\2\2RS\7\16\2\2ST\7\4\2\2TU\7\21\2\2UV\7\5\2\2VW\7\37\2\2"+
		"WX\7\6\2\2XY\7\7\2\2YZ\7 \2\2Z[\5(\25\2[\t\3\2\2\2\\b\7!\2\2]a\5\f\7\2"+
		"^a\5\16\b\2_a\5\6\4\2`]\3\2\2\2`^\3\2\2\2`_\3\2\2\2ad\3\2\2\2b`\3\2\2"+
		"\2bc\3\2\2\2cf\3\2\2\2db\3\2\2\2eg\5\b\5\2fe\3\2\2\2fg\3\2\2\2gm\3\2\2"+
		"\2hl\5\f\7\2il\5\16\b\2jl\5\6\4\2kh\3\2\2\2ki\3\2\2\2kj\3\2\2\2lo\3\2"+
		"\2\2mk\3\2\2\2mn\3\2\2\2np\3\2\2\2om\3\2\2\2pq\7\"\2\2q\13\3\2\2\2rt\7"+
		"\16\2\2sr\3\2\2\2st\3\2\2\2tw\3\2\2\2ux\5<\37\2vx\7\21\2\2wu\3\2\2\2w"+
		"v\3\2\2\2xy\3\2\2\2yz\7&\2\2z{\7\37\2\2{|\5\22\n\2|}\7 \2\2}~\5(\25\2"+
		"~\r\3\2\2\2\177\u0081\7\16\2\2\u0080\177\3\2\2\2\u0080\u0081\3\2\2\2\u0081"+
		"\u0082\3\2\2\2\u0082\u0083\5<\37\2\u0083\u0088\7&\2\2\u0084\u0085\7$\2"+
		"\2\u0085\u0087\7&\2\2\u0086\u0084\3\2\2\2\u0087\u008a\3\2\2\2\u0088\u0086"+
		"\3\2\2\2\u0088\u0089\3\2\2\2\u0089\u008d\3\2\2\2\u008a\u0088\3\2\2\2\u008b"+
		"\u008c\7\26\2\2\u008c\u008e\5\26\f\2\u008d\u008b\3\2\2\2\u008d\u008e\3"+
		"\2\2\2\u008e\u008f\3\2\2\2\u008f\u0090\7%\2\2\u0090\17\3\2\2\2\u0091\u0092"+
		"\5<\37\2\u0092\u0093\7&\2\2\u0093\21\3\2\2\2\u0094\u0096\5\20\t\2\u0095"+
		"\u0094\3\2\2\2\u0095\u0096\3\2\2\2\u0096\u009f\3\2\2\2\u0097\u009a\5\20"+
		"\t\2\u0098\u0099\7$\2\2\u0099\u009b\5\20\t\2\u009a\u0098\3\2\2\2\u009b"+
		"\u009c\3\2\2\2\u009c\u009a\3\2\2\2\u009c\u009d\3\2\2\2\u009d\u009f\3\2"+
		"\2\2\u009e\u0095\3\2\2\2\u009e\u0097\3\2\2\2\u009f\23\3\2\2\2\u00a0\u00a2"+
		"\5\26\f\2\u00a1\u00a0\3\2\2\2\u00a1\u00a2\3\2\2\2\u00a2\u00ad\3\2\2\2"+
		"\u00a3\u00a8\5\26\f\2\u00a4\u00a5\7$\2\2\u00a5\u00a7\5\26\f\2\u00a6\u00a4"+
		"\3\2\2\2\u00a7\u00aa\3\2\2\2\u00a8\u00a6\3\2\2\2\u00a8\u00a9\3\2\2\2\u00a9"+
		"\u00ad\3\2\2\2\u00aa\u00a8\3\2\2\2\u00ab\u00ad\5\32\16\2\u00ac\u00a1\3"+
		"\2\2\2\u00ac\u00a3\3\2\2\2\u00ac\u00ab\3\2\2\2\u00ad\25\3\2\2\2\u00ae"+
		"\u00b1\5\30\r\2\u00af\u00b1\58\35\2\u00b0\u00ae\3\2\2\2\u00b0\u00af\3"+
		"\2\2\2\u00b1\27\3\2\2\2\u00b2\u00bc\5:\36\2\u00b3\u00bc\5\32\16\2\u00b4"+
		"\u00bc\7&\2\2\u00b5\u00bc\5\34\17\2\u00b6\u00bc\5\66\34\2\u00b7\u00b8"+
		"\7\37\2\2\u00b8\u00b9\5\26\f\2\u00b9\u00ba\7 \2\2\u00ba\u00bc\3\2\2\2"+
		"\u00bb\u00b2\3\2\2\2\u00bb\u00b3\3\2\2\2\u00bb\u00b4\3\2\2\2\u00bb\u00b5"+
		"\3\2\2\2\u00bb\u00b6\3\2\2\2\u00bb\u00b7\3\2\2\2\u00bc\31\3\2\2\2\u00bd"+
		"\u00be\7\23\2\2\u00be\u00bf\7#\2\2\u00bf\u00cc\7&\2\2\u00c0\u00c1\7\23"+
		"\2\2\u00c1\u00c3\7#\2\2\u00c2\u00c0\3\2\2\2\u00c2\u00c3\3\2\2\2\u00c3"+
		"\u00c6\3\2\2\2\u00c4\u00c5\7&\2\2\u00c5\u00c7\7#\2\2\u00c6\u00c4\3\2\2"+
		"\2\u00c7\u00c8\3\2\2\2\u00c8\u00c6\3\2\2\2\u00c8\u00c9\3\2\2\2\u00c9\u00ca"+
		"\3\2\2\2\u00ca\u00cc\7&\2\2\u00cb\u00bd\3\2\2\2\u00cb\u00c2\3\2\2\2\u00cc"+
		"\33\3\2\2\2\u00cd\u00d1\5\36\20\2\u00ce\u00d1\5\"\22\2\u00cf\u00d1\5$"+
		"\23\2\u00d0\u00cd\3\2\2\2\u00d0\u00ce\3\2\2\2\u00d0\u00cf\3\2\2\2\u00d1"+
		"\35\3\2\2\2\u00d2\u00d5\5\32\16\2\u00d3\u00d5\7&\2\2\u00d4\u00d2\3\2\2"+
		"\2\u00d4\u00d3\3\2\2\2\u00d5\u00d6\3\2\2\2\u00d6\u00d7\t\2\2\2\u00d7\u00d8"+
		"\5\26\f\2\u00d8\37\3\2\2\2\u00d9\u00da\5<\37\2\u00da\u00df\7&\2\2\u00db"+
		"\u00dc\7$\2\2\u00dc\u00de\7&\2\2\u00dd\u00db\3\2\2\2\u00de\u00e1\3\2\2"+
		"\2\u00df\u00dd\3\2\2\2\u00df\u00e0\3\2\2\2\u00e0\u00e4\3\2\2\2\u00e1\u00df"+
		"\3\2\2\2\u00e2\u00e3\t\2\2\2\u00e3\u00e5\5\26\f\2\u00e4\u00e2\3\2\2\2"+
		"\u00e4\u00e5\3\2\2\2\u00e5!\3\2\2\2\u00e6\u00e7\7\b\2\2\u00e7\u00e8\7"+
		"&\2\2\u00e8\u00e9\7\37\2\2\u00e9\u00ea\5\24\13\2\u00ea\u00eb\7 \2\2\u00eb"+
		"#\3\2\2\2\u00ec\u00ef\5\32\16\2\u00ed\u00ef\7&\2\2\u00ee\u00ec\3\2\2\2"+
		"\u00ee\u00ed\3\2\2\2\u00ef\u00f0\3\2\2\2\u00f0\u00f1\7\37\2\2\u00f1\u00f2"+
		"\5\24\13\2\u00f2\u00f3\7 \2\2\u00f3%\3\2\2\2\u00f4\u0101\5*\26\2\u00f5"+
		"\u00f6\5 \21\2\u00f6\u00f7\7%\2\2\u00f7\u0101\3\2\2\2\u00f8\u00f9\5\64"+
		"\33\2\u00f9\u00fa\7%\2\2\u00fa\u0101\3\2\2\2\u00fb\u0101\5\62\32\2\u00fc"+
		"\u0101\5(\25\2\u00fd\u00fe\5\34\17\2\u00fe\u00ff\7%\2\2\u00ff\u0101\3"+
		"\2\2\2\u0100\u00f4\3\2\2\2\u0100\u00f5\3\2\2\2\u0100\u00f8\3\2\2\2\u0100"+
		"\u00fb\3\2\2\2\u0100\u00fc\3\2\2\2\u0100\u00fd\3\2\2\2\u0101\'\3\2\2\2"+
		"\u0102\u0106\7!\2\2\u0103\u0105\5&\24\2\u0104\u0103\3\2\2\2\u0105\u0108"+
		"\3\2\2\2\u0106\u0104\3\2\2\2\u0106\u0107\3\2\2\2\u0107\u0109\3\2\2\2\u0108"+
		"\u0106\3\2\2\2\u0109\u010a\7\"\2\2\u010a)\3\2\2\2\u010b\u010f\5,\27\2"+
		"\u010c\u010e\5.\30\2\u010d\u010c\3\2\2\2\u010e\u0111\3\2\2\2\u010f\u010d"+
		"\3\2\2\2\u010f\u0110\3\2\2\2\u0110\u0113\3\2\2\2\u0111\u010f\3\2\2\2\u0112"+
		"\u0114\5\60\31\2\u0113\u0112\3\2\2\2\u0113\u0114\3\2\2\2\u0114+\3\2\2"+
		"\2\u0115\u0116\7\24\2\2\u0116\u0117\7\37\2\2\u0117\u0118\5\26\f\2\u0118"+
		"\u0119\7 \2\2\u0119\u011a\5(\25\2\u011a-\3\2\2\2\u011b\u011c\7\25\2\2"+
		"\u011c\u011d\7\24\2\2\u011d\u011e\7\37\2\2\u011e\u011f\5\26\f\2\u011f"+
		"\u0120\7 \2\2\u0120\u0121\5(\25\2\u0121/\3\2\2\2\u0122\u0123\7\25\2\2"+
		"\u0123\u0124\5(\25\2\u0124\61\3\2\2\2\u0125\u0126\7\t\2\2\u0126\u0127"+
		"\7\37\2\2\u0127\u0128\5\26\f\2\u0128\u0129\7 \2\2\u0129\u012a\5(\25\2"+
		"\u012a\63\3\2\2\2\u012b\u012c\7\n\2\2\u012c\u012d\5\26\f\2\u012d\65\3"+
		"\2\2\2\u012e\u012f\7\32\2\2\u012f\u0130\5\26\f\2\u0130\67\3\2\2\2\u0131"+
		"\u0135\5\30\r\2\u0132\u0133\5> \2\u0133\u0134\5\30\r\2\u0134\u0136\3\2"+
		"\2\2\u0135\u0132\3\2\2\2\u0136\u0137\3\2\2\2\u0137\u0135\3\2\2\2\u0137"+
		"\u0138\3\2\2\2\u01389\3\2\2\2\u0139\u013a\t\3\2\2\u013a;\3\2\2\2\u013b"+
		"\u013c\t\4\2\2\u013c=\3\2\2\2\u013d\u013e\t\5\2\2\u013e?\3\2\2\2#CJ`b"+
		"fkmsw\u0080\u0088\u008d\u0095\u009c\u009e\u00a1\u00a8\u00ac\u00b0\u00bb"+
		"\u00c2\u00c8\u00cb\u00d0\u00d4\u00df\u00e4\u00ee\u0100\u0106\u010f\u0113"+
		"\u0137";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}