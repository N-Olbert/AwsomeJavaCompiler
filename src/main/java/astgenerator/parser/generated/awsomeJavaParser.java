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
		T__9=10, T__10=11, T__11=12, AccessModifier=13, JBoolean=14, JNull=15, 
		Void=16, Super=17, This=18, If=19, Else=20, Equal=21, PlusEqual=22, MinusEqual=23, 
		Comperator=24, OpBeforeIdentifier=25, OpBeforeOrAfterIdentifier=26, PointOperator=27, 
		AddSubOperator=28, LogicalOperator=29, LBracket=30, RBracket=31, CurlyLBracket=32, 
		CurlyRBracket=33, Dot=34, Comma=35, Semincolor=36, JString=37, Identifier=38, 
		JCharacter=39, JInteger=40, WS=41, Comment=42, LineComment=43;
	public static final int
		RULE_programm = 0, RULE_jClass = 1, RULE_constructor = 2, RULE_mainMethod = 3, 
		RULE_classBody = 4, RULE_methodDeclaration = 5, RULE_fieldDeclaration = 6, 
		RULE_methodParameter = 7, RULE_nMethodParameters = 8, RULE_nArguments = 9, 
		RULE_expression = 10, RULE_basicexpressions = 11, RULE_instVar = 12, RULE_statementExpressions = 13, 
		RULE_assign = 14, RULE_localVarDeclaration = 15, RULE_jNew = 16, RULE_methodCall = 17, 
		RULE_statement = 18, RULE_block = 19, RULE_ifelse = 20, RULE_jIf = 21, 
		RULE_jElseIf = 22, RULE_jElse = 23, RULE_jWhile = 24, RULE_jReturn = 25, 
		RULE_unary = 26, RULE_binary = 27, RULE_operatorBeforeExpr = 28, RULE_operatorAfterExpr = 29, 
		RULE_baseType = 30, RULE_objectType = 31, RULE_operators = 32;
	private static String[] makeRuleNames() {
		return new String[] {
			"programm", "jClass", "constructor", "mainMethod", "classBody", "methodDeclaration", 
			"fieldDeclaration", "methodParameter", "nMethodParameters", "nArguments", 
			"expression", "basicexpressions", "instVar", "statementExpressions", 
			"assign", "localVarDeclaration", "jNew", "methodCall", "statement", "block", 
			"ifelse", "jIf", "jElseIf", "jElse", "jWhile", "jReturn", "unary", "binary", 
			"operatorBeforeExpr", "operatorAfterExpr", "baseType", "objectType", 
			"operators"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'class'", "'static'", "'main'", "'String[]'", "'args'", "'new'", 
			"'while'", "'return'", "'int'", "'char'", "'boolean'", "'String'", null, 
			null, "'null'", "'void'", "'super'", "'this'", "'if'", "'else'", "'='", 
			"'+='", "'-='", null, "'!'", null, null, null, null, "'('", "')'", "'{'", 
			"'}'", "'.'", "','", "';'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, "AccessModifier", "JBoolean", "JNull", "Void", "Super", "This", 
			"If", "Else", "Equal", "PlusEqual", "MinusEqual", "Comperator", "OpBeforeIdentifier", 
			"OpBeforeOrAfterIdentifier", "PointOperator", "AddSubOperator", "LogicalOperator", 
			"LBracket", "RBracket", "CurlyLBracket", "CurlyRBracket", "Dot", "Comma", 
			"Semincolor", "JString", "Identifier", "JCharacter", "JInteger", "WS", 
			"Comment", "LineComment"
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
			setState(67); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(66);
				jClass();
				}
				}
				setState(69); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__0 || _la==AccessModifier );
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
		public TerminalNode AccessModifier() { return getToken(awsomeJavaParser.AccessModifier, 0); }
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
			match(T__0);
			setState(75);
			match(Identifier);
			setState(76);
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
			setState(79);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==AccessModifier) {
				{
				setState(78);
				match(AccessModifier);
				}
			}

			setState(81);
			match(Identifier);
			setState(82);
			match(LBracket);
			setState(83);
			nMethodParameters();
			setState(84);
			match(RBracket);
			setState(85);
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
			setState(87);
			match(AccessModifier);
			setState(88);
			match(T__1);
			setState(89);
			match(Void);
			setState(90);
			match(T__2);
			setState(91);
			match(LBracket);
			setState(92);
			match(T__3);
			setState(93);
			match(T__4);
			setState(94);
			match(RBracket);
			setState(95);
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
		public ConstructorContext constructor() {
			return getRuleContext(ConstructorContext.class,0);
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
			setState(97);
			match(CurlyLBracket);
			setState(102);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(100);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
					case 1:
						{
						setState(98);
						methodDeclaration();
						}
						break;
					case 2:
						{
						setState(99);
						fieldDeclaration();
						}
						break;
					}
					} 
				}
				setState(104);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			}
			setState(106);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				{
				setState(105);
				constructor();
				}
				break;
			}
			setState(109);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				{
				setState(108);
				mainMethod();
				}
				break;
			}
			setState(115);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << AccessModifier) | (1L << Void) | (1L << Identifier))) != 0)) {
				{
				setState(113);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
				case 1:
					{
					setState(111);
					methodDeclaration();
					}
					break;
				case 2:
					{
					setState(112);
					fieldDeclaration();
					}
					break;
				}
				}
				setState(117);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(118);
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
			setState(121);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==AccessModifier) {
				{
				setState(120);
				match(AccessModifier);
				}
			}

			setState(125);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__8:
			case T__9:
			case T__10:
			case T__11:
			case Identifier:
				{
				setState(123);
				objectType();
				}
				break;
			case Void:
				{
				setState(124);
				match(Void);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(127);
			match(Identifier);
			setState(128);
			match(LBracket);
			setState(129);
			nMethodParameters();
			setState(130);
			match(RBracket);
			setState(131);
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
		public TerminalNode Identifier() { return getToken(awsomeJavaParser.Identifier, 0); }
		public TerminalNode Semincolor() { return getToken(awsomeJavaParser.Semincolor, 0); }
		public TerminalNode AccessModifier() { return getToken(awsomeJavaParser.AccessModifier, 0); }
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
			setState(134);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==AccessModifier) {
				{
				setState(133);
				match(AccessModifier);
				}
			}

			setState(136);
			objectType();
			setState(137);
			match(Identifier);
			setState(140);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Equal) {
				{
				setState(138);
				match(Equal);
				setState(139);
				expression();
				}
			}

			setState(142);
			match(Semincolor);
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
			setState(144);
			objectType();
			setState(145);
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
			setState(157);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(148);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << Identifier))) != 0)) {
					{
					setState(147);
					methodParameter();
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(150);
				methodParameter();
				setState(153); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(151);
					match(Comma);
					setState(152);
					methodParameter();
					}
					}
					setState(155); 
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
			setState(171);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(160);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << JBoolean) | (1L << JNull) | (1L << Super) | (1L << This) | (1L << OpBeforeIdentifier) | (1L << OpBeforeOrAfterIdentifier) | (1L << LBracket) | (1L << JString) | (1L << Identifier) | (1L << JCharacter) | (1L << JInteger))) != 0)) {
					{
					setState(159);
					expression();
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(162);
				expression();
				setState(167);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Comma) {
					{
					{
					setState(163);
					match(Comma);
					setState(164);
					expression();
					}
					}
					setState(169);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(170);
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
		public TerminalNode LBracket() { return getToken(awsomeJavaParser.LBracket, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RBracket() { return getToken(awsomeJavaParser.RBracket, 0); }
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
			setState(179);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(173);
				basicexpressions();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(174);
				binary();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(175);
				match(LBracket);
				setState(176);
				expression();
				setState(177);
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
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(181);
				baseType();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(182);
				instVar();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(183);
				match(Identifier);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(184);
				statementExpressions();
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
		public TerminalNode Super() { return getToken(awsomeJavaParser.Super, 0); }
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
			setState(215);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
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
					_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(200);
				match(Identifier);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(201);
				match(Super);
				setState(202);
				match(Dot);
				setState(203);
				match(Identifier);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(206);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Super) {
					{
					setState(204);
					match(Super);
					setState(205);
					match(Dot);
					}
				}

				setState(210); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(208);
						match(Identifier);
						setState(209);
						match(Dot);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(212); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(214);
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
		public UnaryContext unary() {
			return getRuleContext(UnaryContext.class,0);
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
			setState(221);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(217);
				assign();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(218);
				jNew();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(219);
				methodCall();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(220);
				unary();
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
			setState(225);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				{
				setState(223);
				instVar();
				}
				break;
			case 2:
				{
				setState(224);
				match(Identifier);
				}
				break;
			}
			setState(227);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Equal) | (1L << PlusEqual) | (1L << MinusEqual))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(228);
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
		public TerminalNode Identifier() { return getToken(awsomeJavaParser.Identifier, 0); }
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
			setState(230);
			objectType();
			setState(231);
			match(Identifier);
			setState(234);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Equal) | (1L << PlusEqual) | (1L << MinusEqual))) != 0)) {
				{
				setState(232);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Equal) | (1L << PlusEqual) | (1L << MinusEqual))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(233);
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
			setState(236);
			match(T__5);
			setState(237);
			match(Identifier);
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

	public static class MethodCallContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(awsomeJavaParser.Identifier, 0); }
		public TerminalNode LBracket() { return getToken(awsomeJavaParser.LBracket, 0); }
		public NArgumentsContext nArguments() {
			return getRuleContext(NArgumentsContext.class,0);
		}
		public TerminalNode RBracket() { return getToken(awsomeJavaParser.RBracket, 0); }
		public InstVarContext instVar() {
			return getRuleContext(InstVarContext.class,0);
		}
		public TerminalNode Dot() { return getToken(awsomeJavaParser.Dot, 0); }
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
			setState(245);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
			case 1:
				{
				setState(242);
				instVar();
				setState(243);
				match(Dot);
				}
				break;
			}
			setState(247);
			match(Identifier);
			setState(248);
			match(LBracket);
			setState(249);
			nArguments();
			setState(250);
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
		public TerminalNode Semincolor() { return getToken(awsomeJavaParser.Semincolor, 0); }
		public JReturnContext jReturn() {
			return getRuleContext(JReturnContext.class,0);
		}
		public JWhileContext jWhile() {
			return getRuleContext(JWhileContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public AssignContext assign() {
			return getRuleContext(AssignContext.class,0);
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
			setState(267);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(252);
				ifelse();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(253);
				localVarDeclaration();
				setState(254);
				match(Semincolor);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(256);
				jReturn();
				setState(257);
				match(Semincolor);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(259);
				jWhile();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(260);
				block();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(261);
				assign();
				setState(262);
				match(Semincolor);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(264);
				statementExpressions();
				setState(265);
				match(Semincolor);
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
			setState(269);
			match(CurlyLBracket);
			setState(273);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << Super) | (1L << This) | (1L << If) | (1L << OpBeforeIdentifier) | (1L << OpBeforeOrAfterIdentifier) | (1L << CurlyLBracket) | (1L << Identifier))) != 0)) {
				{
				{
				setState(270);
				statement();
				}
				}
				setState(275);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(276);
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
			setState(278);
			jIf();
			setState(282);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(279);
					jElseIf();
					}
					} 
				}
				setState(284);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
			}
			setState(286);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Else) {
				{
				setState(285);
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
			setState(288);
			match(If);
			setState(289);
			match(LBracket);
			setState(290);
			expression();
			setState(291);
			match(RBracket);
			setState(292);
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
			setState(294);
			match(Else);
			setState(295);
			match(If);
			setState(296);
			match(LBracket);
			setState(297);
			expression();
			setState(298);
			match(RBracket);
			setState(299);
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
			setState(301);
			match(Else);
			setState(302);
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
			setState(304);
			match(T__6);
			setState(305);
			match(LBracket);
			setState(306);
			expression();
			setState(307);
			match(RBracket);
			setState(308);
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
			setState(310);
			match(T__7);
			setState(311);
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
		public OperatorBeforeExprContext operatorBeforeExpr() {
			return getRuleContext(OperatorBeforeExprContext.class,0);
		}
		public OperatorAfterExprContext operatorAfterExpr() {
			return getRuleContext(OperatorAfterExprContext.class,0);
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
			setState(315);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OpBeforeIdentifier:
			case OpBeforeOrAfterIdentifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(313);
				operatorBeforeExpr();
				}
				break;
			case Super:
			case This:
			case Identifier:
				enterOuterAlt(_localctx, 2);
				{
				setState(314);
				operatorAfterExpr();
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
			setState(317);
			basicexpressions();
			setState(321); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(318);
					operators();
					setState(319);
					basicexpressions();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(323); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,35,_ctx);
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

	public static class OperatorBeforeExprContext extends ParserRuleContext {
		public TerminalNode OpBeforeIdentifier() { return getToken(awsomeJavaParser.OpBeforeIdentifier, 0); }
		public TerminalNode OpBeforeOrAfterIdentifier() { return getToken(awsomeJavaParser.OpBeforeOrAfterIdentifier, 0); }
		public TerminalNode Identifier() { return getToken(awsomeJavaParser.Identifier, 0); }
		public InstVarContext instVar() {
			return getRuleContext(InstVarContext.class,0);
		}
		public OperatorBeforeExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operatorBeforeExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof awsomeJavaListener ) ((awsomeJavaListener)listener).enterOperatorBeforeExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof awsomeJavaListener ) ((awsomeJavaListener)listener).exitOperatorBeforeExpr(this);
		}
	}

	public final OperatorBeforeExprContext operatorBeforeExpr() throws RecognitionException {
		OperatorBeforeExprContext _localctx = new OperatorBeforeExprContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_operatorBeforeExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(325);
			_la = _input.LA(1);
			if ( !(_la==OpBeforeIdentifier || _la==OpBeforeOrAfterIdentifier) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(328);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,36,_ctx) ) {
			case 1:
				{
				setState(326);
				match(Identifier);
				}
				break;
			case 2:
				{
				setState(327);
				instVar();
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

	public static class OperatorAfterExprContext extends ParserRuleContext {
		public TerminalNode OpBeforeOrAfterIdentifier() { return getToken(awsomeJavaParser.OpBeforeOrAfterIdentifier, 0); }
		public TerminalNode Identifier() { return getToken(awsomeJavaParser.Identifier, 0); }
		public InstVarContext instVar() {
			return getRuleContext(InstVarContext.class,0);
		}
		public OperatorAfterExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operatorAfterExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof awsomeJavaListener ) ((awsomeJavaListener)listener).enterOperatorAfterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof awsomeJavaListener ) ((awsomeJavaListener)listener).exitOperatorAfterExpr(this);
		}
	}

	public final OperatorAfterExprContext operatorAfterExpr() throws RecognitionException {
		OperatorAfterExprContext _localctx = new OperatorAfterExprContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_operatorAfterExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(332);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,37,_ctx) ) {
			case 1:
				{
				setState(330);
				match(Identifier);
				}
				break;
			case 2:
				{
				setState(331);
				instVar();
				}
				break;
			}
			setState(334);
			match(OpBeforeOrAfterIdentifier);
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
		enterRule(_localctx, 60, RULE_baseType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(336);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << JBoolean) | (1L << JNull) | (1L << Super) | (1L << This) | (1L << JString) | (1L << JCharacter) | (1L << JInteger))) != 0)) ) {
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
		enterRule(_localctx, 62, RULE_objectType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(338);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << Identifier))) != 0)) ) {
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
		enterRule(_localctx, 64, RULE_operators);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(340);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3-\u0159\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\3\2\6\2F\n\2\r\2\16\2G\3\3\5\3K\n\3\3\3\3\3\3\3\3\3\3\4\5"+
		"\4R\n\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\6\3\6\3\6\7\6g\n\6\f\6\16\6j\13\6\3\6\5\6m\n\6\3\6\5\6p\n\6\3\6\3"+
		"\6\7\6t\n\6\f\6\16\6w\13\6\3\6\3\6\3\7\5\7|\n\7\3\7\3\7\5\7\u0080\n\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\b\5\b\u0089\n\b\3\b\3\b\3\b\3\b\5\b\u008f\n"+
		"\b\3\b\3\b\3\t\3\t\3\t\3\n\5\n\u0097\n\n\3\n\3\n\3\n\6\n\u009c\n\n\r\n"+
		"\16\n\u009d\5\n\u00a0\n\n\3\13\5\13\u00a3\n\13\3\13\3\13\3\13\7\13\u00a8"+
		"\n\13\f\13\16\13\u00ab\13\13\3\13\5\13\u00ae\n\13\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\5\f\u00b6\n\f\3\r\3\r\3\r\3\r\5\r\u00bc\n\r\3\16\3\16\3\16\3\16\3"+
		"\16\5\16\u00c3\n\16\3\16\3\16\6\16\u00c7\n\16\r\16\16\16\u00c8\3\16\3"+
		"\16\3\16\3\16\3\16\3\16\5\16\u00d1\n\16\3\16\3\16\6\16\u00d5\n\16\r\16"+
		"\16\16\u00d6\3\16\5\16\u00da\n\16\3\17\3\17\3\17\3\17\5\17\u00e0\n\17"+
		"\3\20\3\20\5\20\u00e4\n\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\5\21\u00ed"+
		"\n\21\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\5\23\u00f8\n\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\5\24\u010e\n\24\3\25\3\25\7\25\u0112\n\25\f"+
		"\25\16\25\u0115\13\25\3\25\3\25\3\26\3\26\7\26\u011b\n\26\f\26\16\26\u011e"+
		"\13\26\3\26\5\26\u0121\n\26\3\27\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3"+
		"\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\32\3"+
		"\33\3\33\3\33\3\34\3\34\5\34\u013e\n\34\3\35\3\35\3\35\3\35\6\35\u0144"+
		"\n\35\r\35\16\35\u0145\3\36\3\36\3\36\5\36\u014b\n\36\3\37\3\37\5\37\u014f"+
		"\n\37\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3\"\2\2#\2\4\6\b\n\f\16\20\22\24\26"+
		"\30\32\34\36 \"$&(*,.\60\62\64\668:<>@B\2\7\3\2\27\31\3\2\33\34\6\2\20"+
		"\21\23\24\'\')*\4\2\13\16((\4\2\32\32\35\37\2\u016a\2E\3\2\2\2\4J\3\2"+
		"\2\2\6Q\3\2\2\2\bY\3\2\2\2\nc\3\2\2\2\f{\3\2\2\2\16\u0088\3\2\2\2\20\u0092"+
		"\3\2\2\2\22\u009f\3\2\2\2\24\u00ad\3\2\2\2\26\u00b5\3\2\2\2\30\u00bb\3"+
		"\2\2\2\32\u00d9\3\2\2\2\34\u00df\3\2\2\2\36\u00e3\3\2\2\2 \u00e8\3\2\2"+
		"\2\"\u00ee\3\2\2\2$\u00f7\3\2\2\2&\u010d\3\2\2\2(\u010f\3\2\2\2*\u0118"+
		"\3\2\2\2,\u0122\3\2\2\2.\u0128\3\2\2\2\60\u012f\3\2\2\2\62\u0132\3\2\2"+
		"\2\64\u0138\3\2\2\2\66\u013d\3\2\2\28\u013f\3\2\2\2:\u0147\3\2\2\2<\u014e"+
		"\3\2\2\2>\u0152\3\2\2\2@\u0154\3\2\2\2B\u0156\3\2\2\2DF\5\4\3\2ED\3\2"+
		"\2\2FG\3\2\2\2GE\3\2\2\2GH\3\2\2\2H\3\3\2\2\2IK\7\17\2\2JI\3\2\2\2JK\3"+
		"\2\2\2KL\3\2\2\2LM\7\3\2\2MN\7(\2\2NO\5\n\6\2O\5\3\2\2\2PR\7\17\2\2QP"+
		"\3\2\2\2QR\3\2\2\2RS\3\2\2\2ST\7(\2\2TU\7 \2\2UV\5\22\n\2VW\7!\2\2WX\5"+
		"(\25\2X\7\3\2\2\2YZ\7\17\2\2Z[\7\4\2\2[\\\7\22\2\2\\]\7\5\2\2]^\7 \2\2"+
		"^_\7\6\2\2_`\7\7\2\2`a\7!\2\2ab\5(\25\2b\t\3\2\2\2ch\7\"\2\2dg\5\f\7\2"+
		"eg\5\16\b\2fd\3\2\2\2fe\3\2\2\2gj\3\2\2\2hf\3\2\2\2hi\3\2\2\2il\3\2\2"+
		"\2jh\3\2\2\2km\5\6\4\2lk\3\2\2\2lm\3\2\2\2mo\3\2\2\2np\5\b\5\2on\3\2\2"+
		"\2op\3\2\2\2pu\3\2\2\2qt\5\f\7\2rt\5\16\b\2sq\3\2\2\2sr\3\2\2\2tw\3\2"+
		"\2\2us\3\2\2\2uv\3\2\2\2vx\3\2\2\2wu\3\2\2\2xy\7#\2\2y\13\3\2\2\2z|\7"+
		"\17\2\2{z\3\2\2\2{|\3\2\2\2|\177\3\2\2\2}\u0080\5@!\2~\u0080\7\22\2\2"+
		"\177}\3\2\2\2\177~\3\2\2\2\u0080\u0081\3\2\2\2\u0081\u0082\7(\2\2\u0082"+
		"\u0083\7 \2\2\u0083\u0084\5\22\n\2\u0084\u0085\7!\2\2\u0085\u0086\5(\25"+
		"\2\u0086\r\3\2\2\2\u0087\u0089\7\17\2\2\u0088\u0087\3\2\2\2\u0088\u0089"+
		"\3\2\2\2\u0089\u008a\3\2\2\2\u008a\u008b\5@!\2\u008b\u008e\7(\2\2\u008c"+
		"\u008d\7\27\2\2\u008d\u008f\5\26\f\2\u008e\u008c\3\2\2\2\u008e\u008f\3"+
		"\2\2\2\u008f\u0090\3\2\2\2\u0090\u0091\7&\2\2\u0091\17\3\2\2\2\u0092\u0093"+
		"\5@!\2\u0093\u0094\7(\2\2\u0094\21\3\2\2\2\u0095\u0097\5\20\t\2\u0096"+
		"\u0095\3\2\2\2\u0096\u0097\3\2\2\2\u0097\u00a0\3\2\2\2\u0098\u009b\5\20"+
		"\t\2\u0099\u009a\7%\2\2\u009a\u009c\5\20\t\2\u009b\u0099\3\2\2\2\u009c"+
		"\u009d\3\2\2\2\u009d\u009b\3\2\2\2\u009d\u009e\3\2\2\2\u009e\u00a0\3\2"+
		"\2\2\u009f\u0096\3\2\2\2\u009f\u0098\3\2\2\2\u00a0\23\3\2\2\2\u00a1\u00a3"+
		"\5\26\f\2\u00a2\u00a1\3\2\2\2\u00a2\u00a3\3\2\2\2\u00a3\u00ae\3\2\2\2"+
		"\u00a4\u00a9\5\26\f\2\u00a5\u00a6\7%\2\2\u00a6\u00a8\5\26\f\2\u00a7\u00a5"+
		"\3\2\2\2\u00a8\u00ab\3\2\2\2\u00a9\u00a7\3\2\2\2\u00a9\u00aa\3\2\2\2\u00aa"+
		"\u00ae\3\2\2\2\u00ab\u00a9\3\2\2\2\u00ac\u00ae\5\32\16\2\u00ad\u00a2\3"+
		"\2\2\2\u00ad\u00a4\3\2\2\2\u00ad\u00ac\3\2\2\2\u00ae\25\3\2\2\2\u00af"+
		"\u00b6\5\30\r\2\u00b0\u00b6\58\35\2\u00b1\u00b2\7 \2\2\u00b2\u00b3\5\26"+
		"\f\2\u00b3\u00b4\7!\2\2\u00b4\u00b6\3\2\2\2\u00b5\u00af\3\2\2\2\u00b5"+
		"\u00b0\3\2\2\2\u00b5\u00b1\3\2\2\2\u00b6\27\3\2\2\2\u00b7\u00bc\5> \2"+
		"\u00b8\u00bc\5\32\16\2\u00b9\u00bc\7(\2\2\u00ba\u00bc\5\34\17\2\u00bb"+
		"\u00b7\3\2\2\2\u00bb\u00b8\3\2\2\2\u00bb\u00b9\3\2\2\2\u00bb\u00ba\3\2"+
		"\2\2\u00bc\31\3\2\2\2\u00bd\u00be\7\24\2\2\u00be\u00bf\7$\2\2\u00bf\u00da"+
		"\7(\2\2\u00c0\u00c1\7\24\2\2\u00c1\u00c3\7$\2\2\u00c2\u00c0\3\2\2\2\u00c2"+
		"\u00c3\3\2\2\2\u00c3\u00c6\3\2\2\2\u00c4\u00c5\7(\2\2\u00c5\u00c7\7$\2"+
		"\2\u00c6\u00c4\3\2\2\2\u00c7\u00c8\3\2\2\2\u00c8\u00c6\3\2\2\2\u00c8\u00c9"+
		"\3\2\2\2\u00c9\u00ca\3\2\2\2\u00ca\u00da\7(\2\2\u00cb\u00cc\7\23\2\2\u00cc"+
		"\u00cd\7$\2\2\u00cd\u00da\7(\2\2\u00ce\u00cf\7\23\2\2\u00cf\u00d1\7$\2"+
		"\2\u00d0\u00ce\3\2\2\2\u00d0\u00d1\3\2\2\2\u00d1\u00d4\3\2\2\2\u00d2\u00d3"+
		"\7(\2\2\u00d3\u00d5\7$\2\2\u00d4\u00d2\3\2\2\2\u00d5\u00d6\3\2\2\2\u00d6"+
		"\u00d4\3\2\2\2\u00d6\u00d7\3\2\2\2\u00d7\u00d8\3\2\2\2\u00d8\u00da\7("+
		"\2\2\u00d9\u00bd\3\2\2\2\u00d9\u00c2\3\2\2\2\u00d9\u00cb\3\2\2\2\u00d9"+
		"\u00d0\3\2\2\2\u00da\33\3\2\2\2\u00db\u00e0\5\36\20\2\u00dc\u00e0\5\""+
		"\22\2\u00dd\u00e0\5$\23\2\u00de\u00e0\5\66\34\2\u00df\u00db\3\2\2\2\u00df"+
		"\u00dc\3\2\2\2\u00df\u00dd\3\2\2\2\u00df\u00de\3\2\2\2\u00e0\35\3\2\2"+
		"\2\u00e1\u00e4\5\32\16\2\u00e2\u00e4\7(\2\2\u00e3\u00e1\3\2\2\2\u00e3"+
		"\u00e2\3\2\2\2\u00e4\u00e5\3\2\2\2\u00e5\u00e6\t\2\2\2\u00e6\u00e7\5\26"+
		"\f\2\u00e7\37\3\2\2\2\u00e8\u00e9\5@!\2\u00e9\u00ec\7(\2\2\u00ea\u00eb"+
		"\t\2\2\2\u00eb\u00ed\5\26\f\2\u00ec\u00ea\3\2\2\2\u00ec\u00ed\3\2\2\2"+
		"\u00ed!\3\2\2\2\u00ee\u00ef\7\b\2\2\u00ef\u00f0\7(\2\2\u00f0\u00f1\7 "+
		"\2\2\u00f1\u00f2\5\24\13\2\u00f2\u00f3\7!\2\2\u00f3#\3\2\2\2\u00f4\u00f5"+
		"\5\32\16\2\u00f5\u00f6\7$\2\2\u00f6\u00f8\3\2\2\2\u00f7\u00f4\3\2\2\2"+
		"\u00f7\u00f8\3\2\2\2\u00f8\u00f9\3\2\2\2\u00f9\u00fa\7(\2\2\u00fa\u00fb"+
		"\7 \2\2\u00fb\u00fc\5\24\13\2\u00fc\u00fd\7!\2\2\u00fd%\3\2\2\2\u00fe"+
		"\u010e\5*\26\2\u00ff\u0100\5 \21\2\u0100\u0101\7&\2\2\u0101\u010e\3\2"+
		"\2\2\u0102\u0103\5\64\33\2\u0103\u0104\7&\2\2\u0104\u010e\3\2\2\2\u0105"+
		"\u010e\5\62\32\2\u0106\u010e\5(\25\2\u0107\u0108\5\36\20\2\u0108\u0109"+
		"\7&\2\2\u0109\u010e\3\2\2\2\u010a\u010b\5\34\17\2\u010b\u010c\7&\2\2\u010c"+
		"\u010e\3\2\2\2\u010d\u00fe\3\2\2\2\u010d\u00ff\3\2\2\2\u010d\u0102\3\2"+
		"\2\2\u010d\u0105\3\2\2\2\u010d\u0106\3\2\2\2\u010d\u0107\3\2\2\2\u010d"+
		"\u010a\3\2\2\2\u010e\'\3\2\2\2\u010f\u0113\7\"\2\2\u0110\u0112\5&\24\2"+
		"\u0111\u0110\3\2\2\2\u0112\u0115\3\2\2\2\u0113\u0111\3\2\2\2\u0113\u0114"+
		"\3\2\2\2\u0114\u0116\3\2\2\2\u0115\u0113\3\2\2\2\u0116\u0117\7#\2\2\u0117"+
		")\3\2\2\2\u0118\u011c\5,\27\2\u0119\u011b\5.\30\2\u011a\u0119\3\2\2\2"+
		"\u011b\u011e\3\2\2\2\u011c\u011a\3\2\2\2\u011c\u011d\3\2\2\2\u011d\u0120"+
		"\3\2\2\2\u011e\u011c\3\2\2\2\u011f\u0121\5\60\31\2\u0120\u011f\3\2\2\2"+
		"\u0120\u0121\3\2\2\2\u0121+\3\2\2\2\u0122\u0123\7\25\2\2\u0123\u0124\7"+
		" \2\2\u0124\u0125\5\26\f\2\u0125\u0126\7!\2\2\u0126\u0127\5(\25\2\u0127"+
		"-\3\2\2\2\u0128\u0129\7\26\2\2\u0129\u012a\7\25\2\2\u012a\u012b\7 \2\2"+
		"\u012b\u012c\5\26\f\2\u012c\u012d\7!\2\2\u012d\u012e\5(\25\2\u012e/\3"+
		"\2\2\2\u012f\u0130\7\26\2\2\u0130\u0131\5(\25\2\u0131\61\3\2\2\2\u0132"+
		"\u0133\7\t\2\2\u0133\u0134\7 \2\2\u0134\u0135\5\26\f\2\u0135\u0136\7!"+
		"\2\2\u0136\u0137\5(\25\2\u0137\63\3\2\2\2\u0138\u0139\7\n\2\2\u0139\u013a"+
		"\5\26\f\2\u013a\65\3\2\2\2\u013b\u013e\5:\36\2\u013c\u013e\5<\37\2\u013d"+
		"\u013b\3\2\2\2\u013d\u013c\3\2\2\2\u013e\67\3\2\2\2\u013f\u0143\5\30\r"+
		"\2\u0140\u0141\5B\"\2\u0141\u0142\5\30\r\2\u0142\u0144\3\2\2\2\u0143\u0140"+
		"\3\2\2\2\u0144\u0145\3\2\2\2\u0145\u0143\3\2\2\2\u0145\u0146\3\2\2\2\u0146"+
		"9\3\2\2\2\u0147\u014a\t\3\2\2\u0148\u014b\7(\2\2\u0149\u014b\5\32\16\2"+
		"\u014a\u0148\3\2\2\2\u014a\u0149\3\2\2\2\u014b;\3\2\2\2\u014c\u014f\7"+
		"(\2\2\u014d\u014f\5\32\16\2\u014e\u014c\3\2\2\2\u014e\u014d\3\2\2\2\u014f"+
		"\u0150\3\2\2\2\u0150\u0151\7\34\2\2\u0151=\3\2\2\2\u0152\u0153\t\4\2\2"+
		"\u0153?\3\2\2\2\u0154\u0155\t\5\2\2\u0155A\3\2\2\2\u0156\u0157\t\6\2\2"+
		"\u0157C\3\2\2\2(GJQfhlosu{\177\u0088\u008e\u0096\u009d\u009f\u00a2\u00a9"+
		"\u00ad\u00b5\u00bb\u00c2\u00c8\u00d0\u00d6\u00d9\u00df\u00e3\u00ec\u00f7"+
		"\u010d\u0113\u011c\u0120\u013d\u0145\u014a\u014e";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}