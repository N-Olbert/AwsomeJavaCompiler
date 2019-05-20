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
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		AccessModifier=18, JBoolean=19, JNull=20, Void=21, Super=22, This=23, 
		JString=24, Identifier=25, JCharacter=26, JInteger=27, AssignOperator=28, 
		Comperator=29, OpBeforeIdentifier=30, OpBeforeOrAfterIdentifier=31, PointOperator=32, 
		AddSubOperator=33, LogicalOperator=34, WS=35, Comment=36;
	public static final int
		RULE_programm = 0, RULE_jClass = 1, RULE_constructor = 2, RULE_classBody = 3, 
		RULE_methodDeclaration = 4, RULE_fieldDeclaration = 5, RULE_methodParameter = 6, 
		RULE_nMethodParameters = 7, RULE_nArguments = 8, RULE_instVar = 9, RULE_expression = 10, 
		RULE_basicexpressions = 11, RULE_statementExpressions = 12, RULE_localVarDeclaration = 13, 
		RULE_assign = 14, RULE_jNew = 15, RULE_methodCall = 16, RULE_statement = 17, 
		RULE_block = 18, RULE_statementOrStatementExpression = 19, RULE_ifelse = 20, 
		RULE_jWhile = 21, RULE_jReturn = 22, RULE_unary = 23, RULE_operatorBeforeExpr = 24, 
		RULE_opBeforeIdentifier = 25, RULE_operatorAfterExpr = 26, RULE_binary = 27, 
		RULE_pointBinary = 28, RULE_baseType = 29, RULE_objectType = 30;
	private static String[] makeRuleNames() {
		return new String[] {
			"programm", "jClass", "constructor", "classBody", "methodDeclaration", 
			"fieldDeclaration", "methodParameter", "nMethodParameters", "nArguments", 
			"instVar", "expression", "basicexpressions", "statementExpressions", 
			"localVarDeclaration", "assign", "jNew", "methodCall", "statement", "block", 
			"statementOrStatementExpression", "ifelse", "jWhile", "jReturn", "unary", 
			"operatorBeforeExpr", "opBeforeIdentifier", "operatorAfterExpr", "binary", 
			"pointBinary", "baseType", "objectType"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'class'", "'('", "')'", "'{'", "'}'", "';'", "','", "'.'", "'new'", 
			"'if ('", "'else if('", "'else ('", "'while ('", "'return'", "'int'", 
			"'char'", "'boolean'", null, null, "'null'", "'void'", "'super()'", "'this'", 
			null, null, null, null, null, null, "'!'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, "AccessModifier", "JBoolean", "JNull", 
			"Void", "Super", "This", "JString", "Identifier", "JCharacter", "JInteger", 
			"AssignOperator", "Comperator", "OpBeforeIdentifier", "OpBeforeOrAfterIdentifier", 
			"PointOperator", "AddSubOperator", "LogicalOperator", "WS", "Comment"
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
			setState(68);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==AccessModifier) {
				{
				setState(67);
				match(AccessModifier);
				}
			}

			setState(70);
			match(T__0);
			setState(71);
			match(Identifier);
			setState(72);
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
			setState(75);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==AccessModifier) {
				{
				setState(74);
				match(AccessModifier);
				}
			}

			setState(77);
			match(Identifier);
			setState(78);
			match(T__1);
			setState(79);
			nMethodParameters();
			setState(80);
			match(T__2);
			setState(81);
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
		public ConstructorContext constructor() {
			return getRuleContext(ConstructorContext.class,0);
		}
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
			setState(83);
			match(T__3);
			setState(88);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(86);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
					case 1:
						{
						setState(84);
						methodDeclaration();
						}
						break;
					case 2:
						{
						setState(85);
						fieldDeclaration();
						}
						break;
					}
					} 
				}
				setState(90);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			}
			setState(91);
			constructor();
			setState(96);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << AccessModifier) | (1L << Void) | (1L << Identifier))) != 0)) {
				{
				setState(94);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
				case 1:
					{
					setState(92);
					methodDeclaration();
					}
					break;
				case 2:
					{
					setState(93);
					fieldDeclaration();
					}
					break;
				}
				}
				setState(98);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(99);
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
			setState(102);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==AccessModifier) {
				{
				setState(101);
				match(AccessModifier);
				}
			}

			setState(106);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__14:
			case T__15:
			case T__16:
			case Identifier:
				{
				setState(104);
				objectType();
				}
				break;
			case Void:
				{
				setState(105);
				match(Void);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(108);
			match(Identifier);
			setState(109);
			match(T__1);
			setState(110);
			nMethodParameters();
			setState(111);
			match(T__2);
			setState(112);
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
			setState(115);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==AccessModifier) {
				{
				setState(114);
				match(AccessModifier);
				}
			}

			setState(117);
			objectType();
			setState(118);
			match(Identifier);
			setState(119);
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
			setState(121);
			objectType();
			setState(122);
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
			setState(134);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(125);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << Identifier))) != 0)) {
					{
					setState(124);
					methodParameter();
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(127);
				methodParameter();
				setState(130); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(128);
					match(T__6);
					setState(129);
					methodParameter();
					}
					}
					setState(132); 
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
			setState(148);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(137);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << JBoolean) | (1L << JNull) | (1L << Super) | (1L << This) | (1L << JString) | (1L << Identifier) | (1L << JCharacter) | (1L << JInteger) | (1L << OpBeforeIdentifier) | (1L << OpBeforeOrAfterIdentifier))) != 0)) {
					{
					setState(136);
					expression();
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(139);
				expression();
				setState(144);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__6) {
					{
					{
					setState(140);
					match(T__6);
					setState(141);
					expression();
					}
					}
					setState(146);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(147);
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
		enterRule(_localctx, 18, RULE_instVar);
		try {
			int _alt;
			setState(160);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case This:
				enterOuterAlt(_localctx, 1);
				{
				setState(150);
				match(This);
				setState(151);
				match(T__7);
				setState(152);
				match(Identifier);
				}
				break;
			case Identifier:
				enterOuterAlt(_localctx, 2);
				{
				setState(155); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(153);
						match(Identifier);
						setState(154);
						match(T__7);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(157); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(159);
				match(Identifier);
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
			setState(164);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(162);
				basicexpressions();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(163);
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
		enterRule(_localctx, 22, RULE_basicexpressions);
		try {
			setState(174);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(166);
				match(T__1);
				setState(167);
				expression();
				setState(168);
				match(T__2);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(170);
				baseType();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(171);
				instVar();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(172);
				match(Identifier);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(173);
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
			enterOuterAlt(_localctx, 1);
			{
			setState(179);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				{
				setState(176);
				assign();
				}
				break;
			case 2:
				{
				setState(177);
				jNew();
				}
				break;
			case 3:
				{
				setState(178);
				methodCall();
				}
				break;
			}
			setState(181);
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

	public static class LocalVarDeclarationContext extends ParserRuleContext {
		public BaseTypeContext baseType() {
			return getRuleContext(BaseTypeContext.class,0);
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
			setState(183);
			baseType();
			setState(184);
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
		public TerminalNode Identifier() { return getToken(awsomeJavaParser.Identifier, 0); }
		public TerminalNode AssignOperator() { return getToken(awsomeJavaParser.AssignOperator, 0); }
		public JNewContext jNew() {
			return getRuleContext(JNewContext.class,0);
		}
		public MethodCallContext methodCall() {
			return getRuleContext(MethodCallContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public InstVarContext instVar() {
			return getRuleContext(InstVarContext.class,0);
		}
		public ObjectTypeContext objectType() {
			return getRuleContext(ObjectTypeContext.class,0);
		}
		public TerminalNode This() { return getToken(awsomeJavaParser.This, 0); }
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
			setState(189);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				{
				setState(186);
				objectType();
				}
				break;
			case 2:
				{
				setState(187);
				match(This);
				setState(188);
				match(T__7);
				}
				break;
			}
			setState(191);
			match(Identifier);
			setState(192);
			match(AssignOperator);
			setState(197);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				{
				setState(193);
				jNew();
				}
				break;
			case 2:
				{
				setState(194);
				methodCall();
				}
				break;
			case 3:
				{
				setState(195);
				expression();
				}
				break;
			case 4:
				{
				setState(196);
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
			setState(199);
			match(T__8);
			setState(200);
			match(Identifier);
			setState(201);
			match(T__1);
			setState(202);
			nMethodParameters();
			setState(203);
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
		public TerminalNode This() { return getToken(awsomeJavaParser.This, 0); }
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
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(207);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==This) {
				{
				setState(205);
				match(This);
				setState(206);
				match(T__7);
				}
			}

			setState(209);
			match(Identifier);
			setState(210);
			match(T__1);
			setState(211);
			nArguments();
			setState(212);
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
			setState(219);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__9:
				enterOuterAlt(_localctx, 1);
				{
				setState(214);
				ifelse();
				}
				break;
			case JBoolean:
			case JNull:
			case Super:
			case This:
			case JString:
			case JCharacter:
			case JInteger:
				enterOuterAlt(_localctx, 2);
				{
				setState(215);
				localVarDeclaration();
				}
				break;
			case T__13:
				enterOuterAlt(_localctx, 3);
				{
				setState(216);
				jReturn();
				}
				break;
			case T__12:
				enterOuterAlt(_localctx, 4);
				{
				setState(217);
				jWhile();
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 5);
				{
				setState(218);
				block();
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

	public static class BlockContext extends ParserRuleContext {
		public List<StatementOrStatementExpressionContext> statementOrStatementExpression() {
			return getRuleContexts(StatementOrStatementExpressionContext.class);
		}
		public StatementOrStatementExpressionContext statementOrStatementExpression(int i) {
			return getRuleContext(StatementOrStatementExpressionContext.class,i);
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
			setState(221);
			match(T__3);
			setState(225);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << T__8) | (1L << T__9) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << JBoolean) | (1L << JNull) | (1L << Super) | (1L << This) | (1L << JString) | (1L << Identifier) | (1L << JCharacter) | (1L << JInteger))) != 0)) {
				{
				{
				setState(222);
				statementOrStatementExpression();
				}
				}
				setState(227);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(228);
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

	public static class StatementOrStatementExpressionContext extends ParserRuleContext {
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public StatementExpressionsContext statementExpressions() {
			return getRuleContext(StatementExpressionsContext.class,0);
		}
		public StatementOrStatementExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statementOrStatementExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof awsomeJavaListener ) ((awsomeJavaListener)listener).enterStatementOrStatementExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof awsomeJavaListener ) ((awsomeJavaListener)listener).exitStatementOrStatementExpression(this);
		}
	}

	public final StatementOrStatementExpressionContext statementOrStatementExpression() throws RecognitionException {
		StatementOrStatementExpressionContext _localctx = new StatementOrStatementExpressionContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_statementOrStatementExpression);
		try {
			setState(232);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(230);
				statement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(231);
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

	public static class IfelseContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
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
			enterOuterAlt(_localctx, 1);
			{
			setState(234);
			match(T__9);
			setState(235);
			expression();
			setState(236);
			match(T__2);
			setState(237);
			block();
			setState(245);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__10) {
				{
				{
				setState(238);
				match(T__10);
				setState(239);
				expression();
				setState(240);
				match(T__2);
				setState(241);
				block();
				}
				}
				setState(247);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(253);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__11) {
				{
				setState(248);
				match(T__11);
				setState(249);
				expression();
				setState(250);
				match(T__2);
				setState(251);
				block();
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
		enterRule(_localctx, 42, RULE_jWhile);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(255);
			match(T__12);
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
		enterRule(_localctx, 44, RULE_jReturn);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(260);
			match(T__13);
			setState(261);
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
		enterRule(_localctx, 46, RULE_unary);
		try {
			setState(265);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OpBeforeIdentifier:
			case OpBeforeOrAfterIdentifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(263);
				operatorBeforeExpr();
				}
				break;
			case Identifier:
				enterOuterAlt(_localctx, 2);
				{
				setState(264);
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

	public static class OperatorBeforeExprContext extends ParserRuleContext {
		public OpBeforeIdentifierContext opBeforeIdentifier() {
			return getRuleContext(OpBeforeIdentifierContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(awsomeJavaParser.Identifier, 0); }
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
		enterRule(_localctx, 48, RULE_operatorBeforeExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(267);
			opBeforeIdentifier();
			setState(268);
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

	public static class OpBeforeIdentifierContext extends ParserRuleContext {
		public TerminalNode OpBeforeIdentifier() { return getToken(awsomeJavaParser.OpBeforeIdentifier, 0); }
		public TerminalNode OpBeforeOrAfterIdentifier() { return getToken(awsomeJavaParser.OpBeforeOrAfterIdentifier, 0); }
		public OpBeforeIdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_opBeforeIdentifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof awsomeJavaListener ) ((awsomeJavaListener)listener).enterOpBeforeIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof awsomeJavaListener ) ((awsomeJavaListener)listener).exitOpBeforeIdentifier(this);
		}
	}

	public final OpBeforeIdentifierContext opBeforeIdentifier() throws RecognitionException {
		OpBeforeIdentifierContext _localctx = new OpBeforeIdentifierContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_opBeforeIdentifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(270);
			_la = _input.LA(1);
			if ( !(_la==OpBeforeIdentifier || _la==OpBeforeOrAfterIdentifier) ) {
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

	public static class OperatorAfterExprContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(awsomeJavaParser.Identifier, 0); }
		public TerminalNode OpBeforeOrAfterIdentifier() { return getToken(awsomeJavaParser.OpBeforeOrAfterIdentifier, 0); }
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
		enterRule(_localctx, 52, RULE_operatorAfterExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(272);
			match(Identifier);
			setState(273);
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

	public static class BinaryContext extends ParserRuleContext {
		public List<BasicexpressionsContext> basicexpressions() {
			return getRuleContexts(BasicexpressionsContext.class);
		}
		public BasicexpressionsContext basicexpressions(int i) {
			return getRuleContext(BasicexpressionsContext.class,i);
		}
		public List<PointBinaryContext> pointBinary() {
			return getRuleContexts(PointBinaryContext.class);
		}
		public PointBinaryContext pointBinary(int i) {
			return getRuleContext(PointBinaryContext.class,i);
		}
		public List<TerminalNode> AddSubOperator() { return getTokens(awsomeJavaParser.AddSubOperator); }
		public TerminalNode AddSubOperator(int i) {
			return getToken(awsomeJavaParser.AddSubOperator, i);
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
		int _la;
		try {
			setState(289);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(277);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
				case 1:
					{
					setState(275);
					basicexpressions();
					}
					break;
				case 2:
					{
					setState(276);
					pointBinary();
					}
					break;
				}
				setState(284); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(279);
					match(AddSubOperator);
					setState(282);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
					case 1:
						{
						setState(280);
						basicexpressions();
						}
						break;
					case 2:
						{
						setState(281);
						pointBinary();
						}
						break;
					}
					}
					}
					setState(286); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==AddSubOperator );
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(288);
				pointBinary();
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

	public static class PointBinaryContext extends ParserRuleContext {
		public List<BasicexpressionsContext> basicexpressions() {
			return getRuleContexts(BasicexpressionsContext.class);
		}
		public BasicexpressionsContext basicexpressions(int i) {
			return getRuleContext(BasicexpressionsContext.class,i);
		}
		public List<TerminalNode> PointOperator() { return getTokens(awsomeJavaParser.PointOperator); }
		public TerminalNode PointOperator(int i) {
			return getToken(awsomeJavaParser.PointOperator, i);
		}
		public PointBinaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pointBinary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof awsomeJavaListener ) ((awsomeJavaListener)listener).enterPointBinary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof awsomeJavaListener ) ((awsomeJavaListener)listener).exitPointBinary(this);
		}
	}

	public final PointBinaryContext pointBinary() throws RecognitionException {
		PointBinaryContext _localctx = new PointBinaryContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_pointBinary);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(291);
			basicexpressions();
			}
			setState(294); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(292);
				match(PointOperator);
				setState(293);
				basicexpressions();
				}
				}
				setState(296); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==PointOperator );
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
			setState(298);
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
			setState(300);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << Identifier))) != 0)) ) {
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3&\u0131\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \3\2"+
		"\6\2B\n\2\r\2\16\2C\3\3\5\3G\n\3\3\3\3\3\3\3\3\3\3\4\5\4N\n\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\5\3\5\3\5\7\5Y\n\5\f\5\16\5\\\13\5\3\5\3\5\3\5\7\5"+
		"a\n\5\f\5\16\5d\13\5\3\5\3\5\3\6\5\6i\n\6\3\6\3\6\5\6m\n\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\7\5\7v\n\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\t\5\t\u0080\n"+
		"\t\3\t\3\t\3\t\6\t\u0085\n\t\r\t\16\t\u0086\5\t\u0089\n\t\3\n\5\n\u008c"+
		"\n\n\3\n\3\n\3\n\7\n\u0091\n\n\f\n\16\n\u0094\13\n\3\n\5\n\u0097\n\n\3"+
		"\13\3\13\3\13\3\13\3\13\6\13\u009e\n\13\r\13\16\13\u009f\3\13\5\13\u00a3"+
		"\n\13\3\f\3\f\5\f\u00a7\n\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u00b1"+
		"\n\r\3\16\3\16\3\16\5\16\u00b6\n\16\3\16\3\16\3\17\3\17\3\17\3\20\3\20"+
		"\3\20\5\20\u00c0\n\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u00c8\n\20\3"+
		"\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\5\22\u00d2\n\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\23\3\23\3\23\3\23\3\23\5\23\u00de\n\23\3\24\3\24\7\24\u00e2"+
		"\n\24\f\24\16\24\u00e5\13\24\3\24\3\24\3\25\3\25\5\25\u00eb\n\25\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\7\26\u00f6\n\26\f\26\16\26\u00f9"+
		"\13\26\3\26\3\26\3\26\3\26\3\26\5\26\u0100\n\26\3\27\3\27\3\27\3\27\3"+
		"\27\3\30\3\30\3\30\3\31\3\31\5\31\u010c\n\31\3\32\3\32\3\32\3\33\3\33"+
		"\3\34\3\34\3\34\3\35\3\35\5\35\u0118\n\35\3\35\3\35\3\35\5\35\u011d\n"+
		"\35\6\35\u011f\n\35\r\35\16\35\u0120\3\35\5\35\u0124\n\35\3\36\3\36\3"+
		"\36\6\36\u0129\n\36\r\36\16\36\u012a\3\37\3\37\3 \3 \3 \2\2!\2\4\6\b\n"+
		"\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>\2\5\3\2 !\5\2\25"+
		"\26\30\32\34\35\4\2\21\23\33\33\2\u013f\2A\3\2\2\2\4F\3\2\2\2\6M\3\2\2"+
		"\2\bU\3\2\2\2\nh\3\2\2\2\fu\3\2\2\2\16{\3\2\2\2\20\u0088\3\2\2\2\22\u0096"+
		"\3\2\2\2\24\u00a2\3\2\2\2\26\u00a6\3\2\2\2\30\u00b0\3\2\2\2\32\u00b5\3"+
		"\2\2\2\34\u00b9\3\2\2\2\36\u00bf\3\2\2\2 \u00c9\3\2\2\2\"\u00d1\3\2\2"+
		"\2$\u00dd\3\2\2\2&\u00df\3\2\2\2(\u00ea\3\2\2\2*\u00ec\3\2\2\2,\u0101"+
		"\3\2\2\2.\u0106\3\2\2\2\60\u010b\3\2\2\2\62\u010d\3\2\2\2\64\u0110\3\2"+
		"\2\2\66\u0112\3\2\2\28\u0123\3\2\2\2:\u0125\3\2\2\2<\u012c\3\2\2\2>\u012e"+
		"\3\2\2\2@B\5\4\3\2A@\3\2\2\2BC\3\2\2\2CA\3\2\2\2CD\3\2\2\2D\3\3\2\2\2"+
		"EG\7\24\2\2FE\3\2\2\2FG\3\2\2\2GH\3\2\2\2HI\7\3\2\2IJ\7\33\2\2JK\5\b\5"+
		"\2K\5\3\2\2\2LN\7\24\2\2ML\3\2\2\2MN\3\2\2\2NO\3\2\2\2OP\7\33\2\2PQ\7"+
		"\4\2\2QR\5\20\t\2RS\7\5\2\2ST\5&\24\2T\7\3\2\2\2UZ\7\6\2\2VY\5\n\6\2W"+
		"Y\5\f\7\2XV\3\2\2\2XW\3\2\2\2Y\\\3\2\2\2ZX\3\2\2\2Z[\3\2\2\2[]\3\2\2\2"+
		"\\Z\3\2\2\2]b\5\6\4\2^a\5\n\6\2_a\5\f\7\2`^\3\2\2\2`_\3\2\2\2ad\3\2\2"+
		"\2b`\3\2\2\2bc\3\2\2\2ce\3\2\2\2db\3\2\2\2ef\7\7\2\2f\t\3\2\2\2gi\7\24"+
		"\2\2hg\3\2\2\2hi\3\2\2\2il\3\2\2\2jm\5> \2km\7\27\2\2lj\3\2\2\2lk\3\2"+
		"\2\2mn\3\2\2\2no\7\33\2\2op\7\4\2\2pq\5\20\t\2qr\7\5\2\2rs\5&\24\2s\13"+
		"\3\2\2\2tv\7\24\2\2ut\3\2\2\2uv\3\2\2\2vw\3\2\2\2wx\5> \2xy\7\33\2\2y"+
		"z\7\b\2\2z\r\3\2\2\2{|\5> \2|}\7\33\2\2}\17\3\2\2\2~\u0080\5\16\b\2\177"+
		"~\3\2\2\2\177\u0080\3\2\2\2\u0080\u0089\3\2\2\2\u0081\u0084\5\16\b\2\u0082"+
		"\u0083\7\t\2\2\u0083\u0085\5\16\b\2\u0084\u0082\3\2\2\2\u0085\u0086\3"+
		"\2\2\2\u0086\u0084\3\2\2\2\u0086\u0087\3\2\2\2\u0087\u0089\3\2\2\2\u0088"+
		"\177\3\2\2\2\u0088\u0081\3\2\2\2\u0089\21\3\2\2\2\u008a\u008c\5\26\f\2"+
		"\u008b\u008a\3\2\2\2\u008b\u008c\3\2\2\2\u008c\u0097\3\2\2\2\u008d\u0092"+
		"\5\26\f\2\u008e\u008f\7\t\2\2\u008f\u0091\5\26\f\2\u0090\u008e\3\2\2\2"+
		"\u0091\u0094\3\2\2\2\u0092\u0090\3\2\2\2\u0092\u0093\3\2\2\2\u0093\u0097"+
		"\3\2\2\2\u0094\u0092\3\2\2\2\u0095\u0097\5\24\13\2\u0096\u008b\3\2\2\2"+
		"\u0096\u008d\3\2\2\2\u0096\u0095\3\2\2\2\u0097\23\3\2\2\2\u0098\u0099"+
		"\7\31\2\2\u0099\u009a\7\n\2\2\u009a\u00a3\7\33\2\2\u009b\u009c\7\33\2"+
		"\2\u009c\u009e\7\n\2\2\u009d\u009b\3\2\2\2\u009e\u009f\3\2\2\2\u009f\u009d"+
		"\3\2\2\2\u009f\u00a0\3\2\2\2\u00a0\u00a1\3\2\2\2\u00a1\u00a3\7\33\2\2"+
		"\u00a2\u0098\3\2\2\2\u00a2\u009d\3\2\2\2\u00a3\25\3\2\2\2\u00a4\u00a7"+
		"\5\30\r\2\u00a5\u00a7\58\35\2\u00a6\u00a4\3\2\2\2\u00a6\u00a5\3\2\2\2"+
		"\u00a7\27\3\2\2\2\u00a8\u00a9\7\4\2\2\u00a9\u00aa\5\26\f\2\u00aa\u00ab"+
		"\7\5\2\2\u00ab\u00b1\3\2\2\2\u00ac\u00b1\5<\37\2\u00ad\u00b1\5\24\13\2"+
		"\u00ae\u00b1\7\33\2\2\u00af\u00b1\5\60\31\2\u00b0\u00a8\3\2\2\2\u00b0"+
		"\u00ac\3\2\2\2\u00b0\u00ad\3\2\2\2\u00b0\u00ae\3\2\2\2\u00b0\u00af\3\2"+
		"\2\2\u00b1\31\3\2\2\2\u00b2\u00b6\5\36\20\2\u00b3\u00b6\5 \21\2\u00b4"+
		"\u00b6\5\"\22\2\u00b5\u00b2\3\2\2\2\u00b5\u00b3\3\2\2\2\u00b5\u00b4\3"+
		"\2\2\2\u00b6\u00b7\3\2\2\2\u00b7\u00b8\7\b\2\2\u00b8\33\3\2\2\2\u00b9"+
		"\u00ba\5<\37\2\u00ba\u00bb\7\33\2\2\u00bb\35\3\2\2\2\u00bc\u00c0\5> \2"+
		"\u00bd\u00be\7\31\2\2\u00be\u00c0\7\n\2\2\u00bf\u00bc\3\2\2\2\u00bf\u00bd"+
		"\3\2\2\2\u00bf\u00c0\3\2\2\2\u00c0\u00c1\3\2\2\2\u00c1\u00c2\7\33\2\2"+
		"\u00c2\u00c7\7\36\2\2\u00c3\u00c8\5 \21\2\u00c4\u00c8\5\"\22\2\u00c5\u00c8"+
		"\5\26\f\2\u00c6\u00c8\5\24\13\2\u00c7\u00c3\3\2\2\2\u00c7\u00c4\3\2\2"+
		"\2\u00c7\u00c5\3\2\2\2\u00c7\u00c6\3\2\2\2\u00c8\37\3\2\2\2\u00c9\u00ca"+
		"\7\13\2\2\u00ca\u00cb\7\33\2\2\u00cb\u00cc\7\4\2\2\u00cc\u00cd\5\20\t"+
		"\2\u00cd\u00ce\7\5\2\2\u00ce!\3\2\2\2\u00cf\u00d0\7\31\2\2\u00d0\u00d2"+
		"\7\n\2\2\u00d1\u00cf\3\2\2\2\u00d1\u00d2\3\2\2\2\u00d2\u00d3\3\2\2\2\u00d3"+
		"\u00d4\7\33\2\2\u00d4\u00d5\7\4\2\2\u00d5\u00d6\5\22\n\2\u00d6\u00d7\7"+
		"\5\2\2\u00d7#\3\2\2\2\u00d8\u00de\5*\26\2\u00d9\u00de\5\34\17\2\u00da"+
		"\u00de\5.\30\2\u00db\u00de\5,\27\2\u00dc\u00de\5&\24\2\u00dd\u00d8\3\2"+
		"\2\2\u00dd\u00d9\3\2\2\2\u00dd\u00da\3\2\2\2\u00dd\u00db\3\2\2\2\u00dd"+
		"\u00dc\3\2\2\2\u00de%\3\2\2\2\u00df\u00e3\7\6\2\2\u00e0\u00e2\5(\25\2"+
		"\u00e1\u00e0\3\2\2\2\u00e2\u00e5\3\2\2\2\u00e3\u00e1\3\2\2\2\u00e3\u00e4"+
		"\3\2\2\2\u00e4\u00e6\3\2\2\2\u00e5\u00e3\3\2\2\2\u00e6\u00e7\7\7\2\2\u00e7"+
		"\'\3\2\2\2\u00e8\u00eb\5$\23\2\u00e9\u00eb\5\32\16\2\u00ea\u00e8\3\2\2"+
		"\2\u00ea\u00e9\3\2\2\2\u00eb)\3\2\2\2\u00ec\u00ed\7\f\2\2\u00ed\u00ee"+
		"\5\26\f\2\u00ee\u00ef\7\5\2\2\u00ef\u00f7\5&\24\2\u00f0\u00f1\7\r\2\2"+
		"\u00f1\u00f2\5\26\f\2\u00f2\u00f3\7\5\2\2\u00f3\u00f4\5&\24\2\u00f4\u00f6"+
		"\3\2\2\2\u00f5\u00f0\3\2\2\2\u00f6\u00f9\3\2\2\2\u00f7\u00f5\3\2\2\2\u00f7"+
		"\u00f8\3\2\2\2\u00f8\u00ff\3\2\2\2\u00f9\u00f7\3\2\2\2\u00fa\u00fb\7\16"+
		"\2\2\u00fb\u00fc\5\26\f\2\u00fc\u00fd\7\5\2\2\u00fd\u00fe\5&\24\2\u00fe"+
		"\u0100\3\2\2\2\u00ff\u00fa\3\2\2\2\u00ff\u0100\3\2\2\2\u0100+\3\2\2\2"+
		"\u0101\u0102\7\17\2\2\u0102\u0103\5\26\f\2\u0103\u0104\7\5\2\2\u0104\u0105"+
		"\5&\24\2\u0105-\3\2\2\2\u0106\u0107\7\20\2\2\u0107\u0108\5\26\f\2\u0108"+
		"/\3\2\2\2\u0109\u010c\5\62\32\2\u010a\u010c\5\66\34\2\u010b\u0109\3\2"+
		"\2\2\u010b\u010a\3\2\2\2\u010c\61\3\2\2\2\u010d\u010e\5\64\33\2\u010e"+
		"\u010f\7\33\2\2\u010f\63\3\2\2\2\u0110\u0111\t\2\2\2\u0111\65\3\2\2\2"+
		"\u0112\u0113\7\33\2\2\u0113\u0114\7!\2\2\u0114\67\3\2\2\2\u0115\u0118"+
		"\5\30\r\2\u0116\u0118\5:\36\2\u0117\u0115\3\2\2\2\u0117\u0116\3\2\2\2"+
		"\u0118\u011e\3\2\2\2\u0119\u011c\7#\2\2\u011a\u011d\5\30\r\2\u011b\u011d"+
		"\5:\36\2\u011c\u011a\3\2\2\2\u011c\u011b\3\2\2\2\u011d\u011f\3\2\2\2\u011e"+
		"\u0119\3\2\2\2\u011f\u0120\3\2\2\2\u0120\u011e\3\2\2\2\u0120\u0121\3\2"+
		"\2\2\u0121\u0124\3\2\2\2\u0122\u0124\5:\36\2\u0123\u0117\3\2\2\2\u0123"+
		"\u0122\3\2\2\2\u01249\3\2\2\2\u0125\u0128\5\30\r\2\u0126\u0127\7\"\2\2"+
		"\u0127\u0129\5\30\r\2\u0128\u0126\3\2\2\2\u0129\u012a\3\2\2\2\u012a\u0128"+
		"\3\2\2\2\u012a\u012b\3\2\2\2\u012b;\3\2\2\2\u012c\u012d\t\3\2\2\u012d"+
		"=\3\2\2\2\u012e\u012f\t\4\2\2\u012f?\3\2\2\2%CFMXZ`bhlu\177\u0086\u0088"+
		"\u008b\u0092\u0096\u009f\u00a2\u00a6\u00b0\u00b5\u00bf\u00c7\u00d1\u00dd"+
		"\u00e3\u00ea\u00f7\u00ff\u010b\u0117\u011c\u0120\u0123\u012a";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}