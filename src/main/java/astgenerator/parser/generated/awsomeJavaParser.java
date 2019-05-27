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
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, AccessModifier=16, 
		JBoolean=17, JNull=18, Void=19, Super=20, This=21, If=22, Else=23, AssignOperator=24, 
		Comperator=25, OpBeforeIdentifier=26, OpBeforeOrAfterIdentifier=27, PointOperator=28, 
		AddSubOperator=29, LogicalOperator=30, JString=31, Identifier=32, JCharacter=33, 
		JInteger=34, WS=35, Comment=36, LineComment=37;
	public static final int
		RULE_programm = 0, RULE_jClass = 1, RULE_constructor = 2, RULE_classBody = 3, 
		RULE_methodDeclaration = 4, RULE_fieldDeclaration = 5, RULE_methodParameter = 6, 
		RULE_nMethodParameters = 7, RULE_nArguments = 8, RULE_expression = 9, 
		RULE_basicexpressions = 10, RULE_instVar = 11, RULE_statementExpressions = 12, 
		RULE_localVarDeclaration = 13, RULE_assign = 14, RULE_jNew = 15, RULE_methodCall = 16, 
		RULE_statement = 17, RULE_block = 18, RULE_ifelse = 19, RULE_jIf = 20, 
		RULE_jElseIf = 21, RULE_jElse = 22, RULE_jWhile = 23, RULE_jReturn = 24, 
		RULE_unary = 25, RULE_binary = 26, RULE_operatorBeforeExpr = 27, RULE_operatorAfterExpr = 28, 
		RULE_baseType = 29, RULE_objectType = 30, RULE_operators = 31;
	private static String[] makeRuleNames() {
		return new String[] {
			"programm", "jClass", "constructor", "classBody", "methodDeclaration", 
			"fieldDeclaration", "methodParameter", "nMethodParameters", "nArguments", 
			"expression", "basicexpressions", "instVar", "statementExpressions", 
			"localVarDeclaration", "assign", "jNew", "methodCall", "statement", "block", 
			"ifelse", "jIf", "jElseIf", "jElse", "jWhile", "jReturn", "unary", "binary", 
			"operatorBeforeExpr", "operatorAfterExpr", "baseType", "objectType", 
			"operators"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'class'", "'('", "')'", "'{'", "'}'", "';'", "','", "'.'", "'new'", 
			"'while ('", "'return'", "'int'", "'char'", "'boolean'", "'String'", 
			null, null, "'null'", "'void'", "'super()'", "'this'", "'if'", "'else'", 
			null, null, "'!'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, "AccessModifier", "JBoolean", "JNull", "Void", 
			"Super", "This", "If", "Else", "AssignOperator", "Comperator", "OpBeforeIdentifier", 
			"OpBeforeOrAfterIdentifier", "PointOperator", "AddSubOperator", "LogicalOperator", 
			"JString", "Identifier", "JCharacter", "JInteger", "WS", "Comment", "LineComment"
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
			setState(65); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(64);
				jClass();
				}
				}
				setState(67); 
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
			setState(70);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==AccessModifier) {
				{
				setState(69);
				match(AccessModifier);
				}
			}

			setState(72);
			match(T__0);
			setState(73);
			match(Identifier);
			setState(74);
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
		public NMethodParametersContext nMethodParameters() {
			return getRuleContext(NMethodParametersContext.class,0);
		}
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
			setState(77);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==AccessModifier) {
				{
				setState(76);
				match(AccessModifier);
				}
			}

			setState(79);
			match(Identifier);
			setState(80);
			match(T__1);
			setState(81);
			nMethodParameters();
			setState(82);
			match(T__2);
			setState(83);
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
		enterRule(_localctx, 6, RULE_classBody);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(85);
			match(T__3);
			setState(90);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(88);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
					case 1:
						{
						setState(86);
						methodDeclaration();
						}
						break;
					case 2:
						{
						setState(87);
						fieldDeclaration();
						}
						break;
					}
					} 
				}
				setState(92);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			}
			setState(94);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				{
				setState(93);
				constructor();
				}
				break;
			}
			setState(100);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << AccessModifier) | (1L << Void) | (1L << Identifier))) != 0)) {
				{
				setState(98);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
				case 1:
					{
					setState(96);
					methodDeclaration();
					}
					break;
				case 2:
					{
					setState(97);
					fieldDeclaration();
					}
					break;
				}
				}
				setState(102);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(103);
			match(T__4);
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
		public NMethodParametersContext nMethodParameters() {
			return getRuleContext(NMethodParametersContext.class,0);
		}
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
		enterRule(_localctx, 8, RULE_methodDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(106);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==AccessModifier) {
				{
				setState(105);
				match(AccessModifier);
				}
			}

			setState(110);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__11:
			case T__12:
			case T__13:
			case T__14:
			case Identifier:
				{
				setState(108);
				objectType();
				}
				break;
			case Void:
				{
				setState(109);
				match(Void);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(112);
			match(Identifier);
			setState(113);
			match(T__1);
			setState(114);
			nMethodParameters();
			setState(115);
			match(T__2);
			setState(116);
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
		public TerminalNode AccessModifier() { return getToken(awsomeJavaParser.AccessModifier, 0); }
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
		enterRule(_localctx, 10, RULE_fieldDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(119);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==AccessModifier) {
				{
				setState(118);
				match(AccessModifier);
				}
			}

			setState(121);
			objectType();
			setState(122);
			match(Identifier);
			setState(123);
			match(T__5);
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
		enterRule(_localctx, 12, RULE_methodParameter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(125);
			objectType();
			setState(126);
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
		enterRule(_localctx, 14, RULE_nMethodParameters);
		int _la;
		try {
			setState(138);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(129);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << Identifier))) != 0)) {
					{
					setState(128);
					methodParameter();
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(131);
				methodParameter();
				setState(134); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(132);
					match(T__6);
					setState(133);
					methodParameter();
					}
					}
					setState(136); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==T__6 );
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
		enterRule(_localctx, 16, RULE_nArguments);
		int _la;
		try {
			setState(152);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(141);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__8) | (1L << JBoolean) | (1L << JNull) | (1L << Super) | (1L << This) | (1L << OpBeforeIdentifier) | (1L << OpBeforeOrAfterIdentifier) | (1L << JString) | (1L << Identifier) | (1L << JCharacter) | (1L << JInteger))) != 0)) {
					{
					setState(140);
					expression();
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(143);
				expression();
				setState(148);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__6) {
					{
					{
					setState(144);
					match(T__6);
					setState(145);
					expression();
					}
					}
					setState(150);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(151);
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
		public StatementExpressionsContext statementExpressions() {
			return getRuleContext(StatementExpressionsContext.class,0);
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
		enterRule(_localctx, 18, RULE_expression);
		try {
			setState(157);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(154);
				basicexpressions();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(155);
				binary();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(156);
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

	public static class BasicexpressionsContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public BaseTypeContext baseType() {
			return getRuleContext(BaseTypeContext.class,0);
		}
		public InstVarContext instVar() {
			return getRuleContext(InstVarContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(awsomeJavaParser.Identifier, 0); }
		public UnaryContext unary() {
			return getRuleContext(UnaryContext.class,0);
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
		enterRule(_localctx, 20, RULE_basicexpressions);
		try {
			setState(167);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(159);
				match(T__1);
				setState(160);
				expression();
				setState(161);
				match(T__2);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(163);
				baseType();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(164);
				instVar();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(165);
				match(Identifier);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(166);
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

	public static class InstVarContext extends ParserRuleContext {
		public TerminalNode This() { return getToken(awsomeJavaParser.This, 0); }
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
		enterRule(_localctx, 22, RULE_instVar);
		int _la;
		try {
			int _alt;
			setState(182);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(169);
				match(This);
				setState(170);
				match(T__7);
				setState(171);
				match(Identifier);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(173);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==This) {
					{
					setState(172);
					match(This);
					}
				}

				setState(177); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(175);
						match(Identifier);
						setState(176);
						match(T__7);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(179); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(181);
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
		enterRule(_localctx, 24, RULE_statementExpressions);
		try {
			setState(187);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(184);
				assign();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(185);
				jNew();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(186);
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

	public static class LocalVarDeclarationContext extends ParserRuleContext {
		public ObjectTypeContext objectType() {
			return getRuleContext(ObjectTypeContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(awsomeJavaParser.Identifier, 0); }
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
		enterRule(_localctx, 26, RULE_localVarDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(189);
			objectType();
			setState(190);
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

	public static class AssignContext extends ParserRuleContext {
		public BasicexpressionsContext basicexpressions() {
			return getRuleContext(BasicexpressionsContext.class,0);
		}
		public TerminalNode AssignOperator() { return getToken(awsomeJavaParser.AssignOperator, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
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
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(192);
			basicexpressions();
			setState(193);
			match(AssignOperator);
			setState(194);
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

	public static class JNewContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(awsomeJavaParser.Identifier, 0); }
		public NMethodParametersContext nMethodParameters() {
			return getRuleContext(NMethodParametersContext.class,0);
		}
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
		enterRule(_localctx, 30, RULE_jNew);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(196);
			match(T__8);
			setState(197);
			match(Identifier);
			setState(198);
			match(T__1);
			setState(199);
			nMethodParameters();
			setState(200);
			match(T__2);
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
		public NArgumentsContext nArguments() {
			return getRuleContext(NArgumentsContext.class,0);
		}
		public InstVarContext instVar() {
			return getRuleContext(InstVarContext.class,0);
		}
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
		enterRule(_localctx, 32, RULE_methodCall);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(205);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				{
				setState(202);
				instVar();
				setState(203);
				match(T__7);
				}
				break;
			}
			setState(207);
			match(Identifier);
			setState(208);
			match(T__1);
			setState(209);
			nArguments();
			setState(210);
			match(T__2);
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
		public BinaryContext binary() {
			return getRuleContext(BinaryContext.class,0);
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
		enterRule(_localctx, 34, RULE_statement);
		try {
			setState(226);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(212);
				ifelse();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(213);
				localVarDeclaration();
				setState(214);
				match(T__5);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(216);
				jReturn();
				setState(217);
				match(T__5);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(219);
				jWhile();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(220);
				block();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(221);
				assign();
				setState(222);
				match(T__5);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(224);
				binary();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(225);
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

	public static class BlockContext extends ParserRuleContext {
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
		enterRule(_localctx, 36, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(228);
			match(T__3);
			setState(232);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__3) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << JBoolean) | (1L << JNull) | (1L << Super) | (1L << This) | (1L << If) | (1L << OpBeforeIdentifier) | (1L << OpBeforeOrAfterIdentifier) | (1L << JString) | (1L << Identifier) | (1L << JCharacter) | (1L << JInteger))) != 0)) {
				{
				{
				setState(229);
				statement();
				}
				}
				setState(234);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(235);
			match(T__4);
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
		enterRule(_localctx, 38, RULE_ifelse);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(237);
			jIf();
			setState(241);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(238);
					jElseIf();
					}
					} 
				}
				setState(243);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
			}
			setState(245);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Else) {
				{
				setState(244);
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
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
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
		enterRule(_localctx, 40, RULE_jIf);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(247);
			match(If);
			setState(248);
			match(T__1);
			setState(249);
			expression();
			setState(250);
			match(T__2);
			setState(251);
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
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
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
		enterRule(_localctx, 42, RULE_jElseIf);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(253);
			match(Else);
			setState(254);
			match(If);
			setState(255);
			match(T__1);
			setState(256);
			expression();
			setState(257);
			match(T__2);
			setState(258);
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
		enterRule(_localctx, 44, RULE_jElse);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(260);
			match(Else);
			setState(261);
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
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
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
		enterRule(_localctx, 46, RULE_jWhile);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(263);
			match(T__9);
			setState(264);
			expression();
			setState(265);
			match(T__2);
			setState(266);
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
		enterRule(_localctx, 48, RULE_jReturn);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(268);
			match(T__10);
			setState(269);
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
		enterRule(_localctx, 50, RULE_unary);
		try {
			setState(273);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OpBeforeIdentifier:
			case OpBeforeOrAfterIdentifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(271);
				operatorBeforeExpr();
				}
				break;
			case This:
			case Identifier:
				enterOuterAlt(_localctx, 2);
				{
				setState(272);
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
		enterRule(_localctx, 52, RULE_binary);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(275);
			basicexpressions();
			setState(279); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(276);
				operators();
				setState(277);
				basicexpressions();
				}
				}
				setState(281); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Comperator) | (1L << PointOperator) | (1L << AddSubOperator) | (1L << LogicalOperator))) != 0) );
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
		enterRule(_localctx, 54, RULE_operatorBeforeExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(283);
			_la = _input.LA(1);
			if ( !(_la==OpBeforeIdentifier || _la==OpBeforeOrAfterIdentifier) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(286);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
			case 1:
				{
				setState(284);
				match(Identifier);
				}
				break;
			case 2:
				{
				setState(285);
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
		enterRule(_localctx, 56, RULE_operatorAfterExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(290);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
			case 1:
				{
				setState(288);
				match(Identifier);
				}
				break;
			case 2:
				{
				setState(289);
				instVar();
				}
				break;
			}
			setState(292);
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
		enterRule(_localctx, 58, RULE_baseType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(294);
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
		enterRule(_localctx, 60, RULE_objectType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(296);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << Identifier))) != 0)) ) {
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
		enterRule(_localctx, 62, RULE_operators);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(298);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\'\u012f\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\3\2\6\2D\n\2\r\2\16\2E\3\3\5\3I\n\3\3\3\3\3\3\3\3\3\3\4\5\4P\n\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\7\5[\n\5\f\5\16\5^\13\5\3\5\5\5a\n"+
		"\5\3\5\3\5\7\5e\n\5\f\5\16\5h\13\5\3\5\3\5\3\6\5\6m\n\6\3\6\3\6\5\6q\n"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\5\7z\n\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3"+
		"\t\5\t\u0084\n\t\3\t\3\t\3\t\6\t\u0089\n\t\r\t\16\t\u008a\5\t\u008d\n"+
		"\t\3\n\5\n\u0090\n\n\3\n\3\n\3\n\7\n\u0095\n\n\f\n\16\n\u0098\13\n\3\n"+
		"\5\n\u009b\n\n\3\13\3\13\3\13\5\13\u00a0\n\13\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\5\f\u00aa\n\f\3\r\3\r\3\r\3\r\5\r\u00b0\n\r\3\r\3\r\6\r\u00b4"+
		"\n\r\r\r\16\r\u00b5\3\r\5\r\u00b9\n\r\3\16\3\16\3\16\5\16\u00be\n\16\3"+
		"\17\3\17\3\17\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3"+
		"\22\3\22\5\22\u00d0\n\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\5\23\u00e5\n\23\3\24"+
		"\3\24\7\24\u00e9\n\24\f\24\16\24\u00ec\13\24\3\24\3\24\3\25\3\25\7\25"+
		"\u00f2\n\25\f\25\16\25\u00f5\13\25\3\25\5\25\u00f8\n\25\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\31"+
		"\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\33\3\33\5\33\u0114\n\33\3\34\3\34"+
		"\3\34\3\34\6\34\u011a\n\34\r\34\16\34\u011b\3\35\3\35\3\35\5\35\u0121"+
		"\n\35\3\36\3\36\5\36\u0125\n\36\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3!\2\2"+
		"\"\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@\2"+
		"\6\3\2\34\35\6\2\23\24\26\27!!#$\4\2\16\21\"\"\4\2\33\33\36 \2\u013a\2"+
		"C\3\2\2\2\4H\3\2\2\2\6O\3\2\2\2\bW\3\2\2\2\nl\3\2\2\2\fy\3\2\2\2\16\177"+
		"\3\2\2\2\20\u008c\3\2\2\2\22\u009a\3\2\2\2\24\u009f\3\2\2\2\26\u00a9\3"+
		"\2\2\2\30\u00b8\3\2\2\2\32\u00bd\3\2\2\2\34\u00bf\3\2\2\2\36\u00c2\3\2"+
		"\2\2 \u00c6\3\2\2\2\"\u00cf\3\2\2\2$\u00e4\3\2\2\2&\u00e6\3\2\2\2(\u00ef"+
		"\3\2\2\2*\u00f9\3\2\2\2,\u00ff\3\2\2\2.\u0106\3\2\2\2\60\u0109\3\2\2\2"+
		"\62\u010e\3\2\2\2\64\u0113\3\2\2\2\66\u0115\3\2\2\28\u011d\3\2\2\2:\u0124"+
		"\3\2\2\2<\u0128\3\2\2\2>\u012a\3\2\2\2@\u012c\3\2\2\2BD\5\4\3\2CB\3\2"+
		"\2\2DE\3\2\2\2EC\3\2\2\2EF\3\2\2\2F\3\3\2\2\2GI\7\22\2\2HG\3\2\2\2HI\3"+
		"\2\2\2IJ\3\2\2\2JK\7\3\2\2KL\7\"\2\2LM\5\b\5\2M\5\3\2\2\2NP\7\22\2\2O"+
		"N\3\2\2\2OP\3\2\2\2PQ\3\2\2\2QR\7\"\2\2RS\7\4\2\2ST\5\20\t\2TU\7\5\2\2"+
		"UV\5&\24\2V\7\3\2\2\2W\\\7\6\2\2X[\5\n\6\2Y[\5\f\7\2ZX\3\2\2\2ZY\3\2\2"+
		"\2[^\3\2\2\2\\Z\3\2\2\2\\]\3\2\2\2]`\3\2\2\2^\\\3\2\2\2_a\5\6\4\2`_\3"+
		"\2\2\2`a\3\2\2\2af\3\2\2\2be\5\n\6\2ce\5\f\7\2db\3\2\2\2dc\3\2\2\2eh\3"+
		"\2\2\2fd\3\2\2\2fg\3\2\2\2gi\3\2\2\2hf\3\2\2\2ij\7\7\2\2j\t\3\2\2\2km"+
		"\7\22\2\2lk\3\2\2\2lm\3\2\2\2mp\3\2\2\2nq\5> \2oq\7\25\2\2pn\3\2\2\2p"+
		"o\3\2\2\2qr\3\2\2\2rs\7\"\2\2st\7\4\2\2tu\5\20\t\2uv\7\5\2\2vw\5&\24\2"+
		"w\13\3\2\2\2xz\7\22\2\2yx\3\2\2\2yz\3\2\2\2z{\3\2\2\2{|\5> \2|}\7\"\2"+
		"\2}~\7\b\2\2~\r\3\2\2\2\177\u0080\5> \2\u0080\u0081\7\"\2\2\u0081\17\3"+
		"\2\2\2\u0082\u0084\5\16\b\2\u0083\u0082\3\2\2\2\u0083\u0084\3\2\2\2\u0084"+
		"\u008d\3\2\2\2\u0085\u0088\5\16\b\2\u0086\u0087\7\t\2\2\u0087\u0089\5"+
		"\16\b\2\u0088\u0086\3\2\2\2\u0089\u008a\3\2\2\2\u008a\u0088\3\2\2\2\u008a"+
		"\u008b\3\2\2\2\u008b\u008d\3\2\2\2\u008c\u0083\3\2\2\2\u008c\u0085\3\2"+
		"\2\2\u008d\21\3\2\2\2\u008e\u0090\5\24\13\2\u008f\u008e\3\2\2\2\u008f"+
		"\u0090\3\2\2\2\u0090\u009b\3\2\2\2\u0091\u0096\5\24\13\2\u0092\u0093\7"+
		"\t\2\2\u0093\u0095\5\24\13\2\u0094\u0092\3\2\2\2\u0095\u0098\3\2\2\2\u0096"+
		"\u0094\3\2\2\2\u0096\u0097\3\2\2\2\u0097\u009b\3\2\2\2\u0098\u0096\3\2"+
		"\2\2\u0099\u009b\5\30\r\2\u009a\u008f\3\2\2\2\u009a\u0091\3\2\2\2\u009a"+
		"\u0099\3\2\2\2\u009b\23\3\2\2\2\u009c\u00a0\5\26\f\2\u009d\u00a0\5\66"+
		"\34\2\u009e\u00a0\5\32\16\2\u009f\u009c\3\2\2\2\u009f\u009d\3\2\2\2\u009f"+
		"\u009e\3\2\2\2\u00a0\25\3\2\2\2\u00a1\u00a2\7\4\2\2\u00a2\u00a3\5\24\13"+
		"\2\u00a3\u00a4\7\5\2\2\u00a4\u00aa\3\2\2\2\u00a5\u00aa\5<\37\2\u00a6\u00aa"+
		"\5\30\r\2\u00a7\u00aa\7\"\2\2\u00a8\u00aa\5\64\33\2\u00a9\u00a1\3\2\2"+
		"\2\u00a9\u00a5\3\2\2\2\u00a9\u00a6\3\2\2\2\u00a9\u00a7\3\2\2\2\u00a9\u00a8"+
		"\3\2\2\2\u00aa\27\3\2\2\2\u00ab\u00ac\7\27\2\2\u00ac\u00ad\7\n\2\2\u00ad"+
		"\u00b9\7\"\2\2\u00ae\u00b0\7\27\2\2\u00af\u00ae\3\2\2\2\u00af\u00b0\3"+
		"\2\2\2\u00b0\u00b3\3\2\2\2\u00b1\u00b2\7\"\2\2\u00b2\u00b4\7\n\2\2\u00b3"+
		"\u00b1\3\2\2\2\u00b4\u00b5\3\2\2\2\u00b5\u00b3\3\2\2\2\u00b5\u00b6\3\2"+
		"\2\2\u00b6\u00b7\3\2\2\2\u00b7\u00b9\7\"\2\2\u00b8\u00ab\3\2\2\2\u00b8"+
		"\u00af\3\2\2\2\u00b9\31\3\2\2\2\u00ba\u00be\5\36\20\2\u00bb\u00be\5 \21"+
		"\2\u00bc\u00be\5\"\22\2\u00bd\u00ba\3\2\2\2\u00bd\u00bb\3\2\2\2\u00bd"+
		"\u00bc\3\2\2\2\u00be\33\3\2\2\2\u00bf\u00c0\5> \2\u00c0\u00c1\7\"\2\2"+
		"\u00c1\35\3\2\2\2\u00c2\u00c3\5\26\f\2\u00c3\u00c4\7\32\2\2\u00c4\u00c5"+
		"\5\24\13\2\u00c5\37\3\2\2\2\u00c6\u00c7\7\13\2\2\u00c7\u00c8\7\"\2\2\u00c8"+
		"\u00c9\7\4\2\2\u00c9\u00ca\5\20\t\2\u00ca\u00cb\7\5\2\2\u00cb!\3\2\2\2"+
		"\u00cc\u00cd\5\30\r\2\u00cd\u00ce\7\n\2\2\u00ce\u00d0\3\2\2\2\u00cf\u00cc"+
		"\3\2\2\2\u00cf\u00d0\3\2\2\2\u00d0\u00d1\3\2\2\2\u00d1\u00d2\7\"\2\2\u00d2"+
		"\u00d3\7\4\2\2\u00d3\u00d4\5\22\n\2\u00d4\u00d5\7\5\2\2\u00d5#\3\2\2\2"+
		"\u00d6\u00e5\5(\25\2\u00d7\u00d8\5\34\17\2\u00d8\u00d9\7\b\2\2\u00d9\u00e5"+
		"\3\2\2\2\u00da\u00db\5\62\32\2\u00db\u00dc\7\b\2\2\u00dc\u00e5\3\2\2\2"+
		"\u00dd\u00e5\5\60\31\2\u00de\u00e5\5&\24\2\u00df\u00e0\5\36\20\2\u00e0"+
		"\u00e1\7\b\2\2\u00e1\u00e5\3\2\2\2\u00e2\u00e5\5\66\34\2\u00e3\u00e5\5"+
		"\32\16\2\u00e4\u00d6\3\2\2\2\u00e4\u00d7\3\2\2\2\u00e4\u00da\3\2\2\2\u00e4"+
		"\u00dd\3\2\2\2\u00e4\u00de\3\2\2\2\u00e4\u00df\3\2\2\2\u00e4\u00e2\3\2"+
		"\2\2\u00e4\u00e3\3\2\2\2\u00e5%\3\2\2\2\u00e6\u00ea\7\6\2\2\u00e7\u00e9"+
		"\5$\23\2\u00e8\u00e7\3\2\2\2\u00e9\u00ec\3\2\2\2\u00ea\u00e8\3\2\2\2\u00ea"+
		"\u00eb\3\2\2\2\u00eb\u00ed\3\2\2\2\u00ec\u00ea\3\2\2\2\u00ed\u00ee\7\7"+
		"\2\2\u00ee\'\3\2\2\2\u00ef\u00f3\5*\26\2\u00f0\u00f2\5,\27\2\u00f1\u00f0"+
		"\3\2\2\2\u00f2\u00f5\3\2\2\2\u00f3\u00f1\3\2\2\2\u00f3\u00f4\3\2\2\2\u00f4"+
		"\u00f7\3\2\2\2\u00f5\u00f3\3\2\2\2\u00f6\u00f8\5.\30\2\u00f7\u00f6\3\2"+
		"\2\2\u00f7\u00f8\3\2\2\2\u00f8)\3\2\2\2\u00f9\u00fa\7\30\2\2\u00fa\u00fb"+
		"\7\4\2\2\u00fb\u00fc\5\24\13\2\u00fc\u00fd\7\5\2\2\u00fd\u00fe\5&\24\2"+
		"\u00fe+\3\2\2\2\u00ff\u0100\7\31\2\2\u0100\u0101\7\30\2\2\u0101\u0102"+
		"\7\4\2\2\u0102\u0103\5\24\13\2\u0103\u0104\7\5\2\2\u0104\u0105\5&\24\2"+
		"\u0105-\3\2\2\2\u0106\u0107\7\31\2\2\u0107\u0108\5&\24\2\u0108/\3\2\2"+
		"\2\u0109\u010a\7\f\2\2\u010a\u010b\5\24\13\2\u010b\u010c\7\5\2\2\u010c"+
		"\u010d\5&\24\2\u010d\61\3\2\2\2\u010e\u010f\7\r\2\2\u010f\u0110\5\24\13"+
		"\2\u0110\63\3\2\2\2\u0111\u0114\58\35\2\u0112\u0114\5:\36\2\u0113\u0111"+
		"\3\2\2\2\u0113\u0112\3\2\2\2\u0114\65\3\2\2\2\u0115\u0119\5\26\f\2\u0116"+
		"\u0117\5@!\2\u0117\u0118\5\26\f\2\u0118\u011a\3\2\2\2\u0119\u0116\3\2"+
		"\2\2\u011a\u011b\3\2\2\2\u011b\u0119\3\2\2\2\u011b\u011c\3\2\2\2\u011c"+
		"\67\3\2\2\2\u011d\u0120\t\2\2\2\u011e\u0121\7\"\2\2\u011f\u0121\5\30\r"+
		"\2\u0120\u011e\3\2\2\2\u0120\u011f\3\2\2\2\u01219\3\2\2\2\u0122\u0125"+
		"\7\"\2\2\u0123\u0125\5\30\r\2\u0124\u0122\3\2\2\2\u0124\u0123\3\2\2\2"+
		"\u0125\u0126\3\2\2\2\u0126\u0127\7\35\2\2\u0127;\3\2\2\2\u0128\u0129\t"+
		"\3\2\2\u0129=\3\2\2\2\u012a\u012b\t\4\2\2\u012b?\3\2\2\2\u012c\u012d\t"+
		"\5\2\2\u012dA\3\2\2\2\"EHOZ\\`dflpy\u0083\u008a\u008c\u008f\u0096\u009a"+
		"\u009f\u00a9\u00af\u00b5\u00b8\u00bd\u00cf\u00e4\u00ea\u00f3\u00f7\u0113"+
		"\u011b\u0120\u0124";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}