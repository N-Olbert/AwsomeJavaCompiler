// Generated from C:/Users/Daniel/IdeaProjects/AwsomeJavaCompiler/src/main/java/astgenerator/parser/grammar\awsomeJava.g4 by ANTLR 4.7.2
package astgenerator.parser.generated;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class awsomeJavaLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		AccessModifier=18, JBoolean=19, JNull=20, Void=21, Super=22, This=23, 
		JString=24, Identifier=25, JCharacter=26, JInteger=27, AssignOperator=28, 
		Comperator=29, OpBeforeIdentifier=30, OpBeforeOrAfterIdentifier=31, OpInBetweenIdentifier=32, 
		WS=33, Comment=34;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
			"AccessModifier", "JBoolean", "JNull", "Void", "Super", "This", "JString", 
			"Identifier", "JCharacter", "JInteger", "AssignOperator", "Comperator", 
			"OpBeforeIdentifier", "OpBeforeOrAfterIdentifier", "OpInBetweenIdentifier", 
			"WS", "Comment"
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
			"OpInBetweenIdentifier", "WS", "Comment"
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


	public awsomeJavaLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "awsomeJava.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2$\u011e\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6"+
		"\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\5\23\u00ab\n\23"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\5\24\u00b6\n\24\3\25\3\25"+
		"\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31\6\31\u00d2\n\31\r\31"+
		"\16\31\u00d3\3\32\6\32\u00d7\n\32\r\32\16\32\u00d8\3\33\3\33\3\34\6\34"+
		"\u00de\n\34\r\34\16\34\u00df\3\35\3\35\3\35\3\35\3\35\5\35\u00e7\n\35"+
		"\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\5\36\u00f2\n\36\3\37\3\37"+
		"\3 \3 \3 \3 \5 \u00fa\n \3!\3!\3!\3!\3!\5!\u0101\n!\3\"\3\"\3\"\3\"\3"+
		"#\3#\3#\3#\7#\u010b\n#\f#\16#\u010e\13#\3#\3#\3#\3#\7#\u0114\n#\f#\16"+
		"#\u0117\13#\3#\3#\5#\u011b\n#\3#\3#\2\2$\3\3\5\4\7\5\t\6\13\7\r\b\17\t"+
		"\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27"+
		"-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$\3\2\7\4\2C\\c|\3\2"+
		"\62;\4\2>>@@\4\2--//\7\2\13\f\17\17\"\"*+AA\2\u012f\2\3\3\2\2\2\2\5\3"+
		"\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2"+
		"\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3"+
		"\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'"+
		"\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63"+
		"\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2"+
		"?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\3G\3\2\2\2\5M\3\2\2\2\7O\3"+
		"\2\2\2\tQ\3\2\2\2\13S\3\2\2\2\rU\3\2\2\2\17W\3\2\2\2\21Y\3\2\2\2\23[\3"+
		"\2\2\2\25_\3\2\2\2\27d\3\2\2\2\31m\3\2\2\2\33t\3\2\2\2\35|\3\2\2\2\37"+
		"\u0083\3\2\2\2!\u0087\3\2\2\2#\u008c\3\2\2\2%\u00aa\3\2\2\2\'\u00b5\3"+
		"\2\2\2)\u00b7\3\2\2\2+\u00bc\3\2\2\2-\u00c1\3\2\2\2/\u00c9\3\2\2\2\61"+
		"\u00ce\3\2\2\2\63\u00d6\3\2\2\2\65\u00da\3\2\2\2\67\u00dd\3\2\2\29\u00e6"+
		"\3\2\2\2;\u00f1\3\2\2\2=\u00f3\3\2\2\2?\u00f9\3\2\2\2A\u0100\3\2\2\2C"+
		"\u0102\3\2\2\2E\u011a\3\2\2\2GH\7e\2\2HI\7n\2\2IJ\7c\2\2JK\7u\2\2KL\7"+
		"u\2\2L\4\3\2\2\2MN\7*\2\2N\6\3\2\2\2OP\7+\2\2P\b\3\2\2\2QR\7}\2\2R\n\3"+
		"\2\2\2ST\7\177\2\2T\f\3\2\2\2UV\7=\2\2V\16\3\2\2\2WX\7.\2\2X\20\3\2\2"+
		"\2YZ\7\60\2\2Z\22\3\2\2\2[\\\7p\2\2\\]\7g\2\2]^\7y\2\2^\24\3\2\2\2_`\7"+
		"k\2\2`a\7h\2\2ab\7\"\2\2bc\7*\2\2c\26\3\2\2\2de\7g\2\2ef\7n\2\2fg\7u\2"+
		"\2gh\7g\2\2hi\7\"\2\2ij\7k\2\2jk\7h\2\2kl\7*\2\2l\30\3\2\2\2mn\7g\2\2"+
		"no\7n\2\2op\7u\2\2pq\7g\2\2qr\7\"\2\2rs\7*\2\2s\32\3\2\2\2tu\7y\2\2uv"+
		"\7j\2\2vw\7k\2\2wx\7n\2\2xy\7g\2\2yz\7\"\2\2z{\7*\2\2{\34\3\2\2\2|}\7"+
		"t\2\2}~\7g\2\2~\177\7v\2\2\177\u0080\7w\2\2\u0080\u0081\7t\2\2\u0081\u0082"+
		"\7p\2\2\u0082\36\3\2\2\2\u0083\u0084\7k\2\2\u0084\u0085\7p\2\2\u0085\u0086"+
		"\7v\2\2\u0086 \3\2\2\2\u0087\u0088\7e\2\2\u0088\u0089\7j\2\2\u0089\u008a"+
		"\7c\2\2\u008a\u008b\7t\2\2\u008b\"\3\2\2\2\u008c\u008d\7d\2\2\u008d\u008e"+
		"\7q\2\2\u008e\u008f\7q\2\2\u008f\u0090\7n\2\2\u0090\u0091\7g\2\2\u0091"+
		"\u0092\7c\2\2\u0092\u0093\7p\2\2\u0093$\3\2\2\2\u0094\u0095\7r\2\2\u0095"+
		"\u0096\7w\2\2\u0096\u0097\7d\2\2\u0097\u0098\7n\2\2\u0098\u0099\7k\2\2"+
		"\u0099\u00ab\7e\2\2\u009a\u009b\7r\2\2\u009b\u009c\7t\2\2\u009c\u009d"+
		"\7q\2\2\u009d\u009e\7v\2\2\u009e\u009f\7g\2\2\u009f\u00a0\7e\2\2\u00a0"+
		"\u00a1\7v\2\2\u00a1\u00a2\7g\2\2\u00a2\u00ab\7f\2\2\u00a3\u00a4\7r\2\2"+
		"\u00a4\u00a5\7t\2\2\u00a5\u00a6\7k\2\2\u00a6\u00a7\7x\2\2\u00a7\u00a8"+
		"\7c\2\2\u00a8\u00a9\7v\2\2\u00a9\u00ab\7g\2\2\u00aa\u0094\3\2\2\2\u00aa"+
		"\u009a\3\2\2\2\u00aa\u00a3\3\2\2\2\u00ab&\3\2\2\2\u00ac\u00ad\7v\2\2\u00ad"+
		"\u00ae\7t\2\2\u00ae\u00af\7w\2\2\u00af\u00b6\7g\2\2\u00b0\u00b1\7h\2\2"+
		"\u00b1\u00b2\7c\2\2\u00b2\u00b3\7n\2\2\u00b3\u00b4\7u\2\2\u00b4\u00b6"+
		"\7g\2\2\u00b5\u00ac\3\2\2\2\u00b5\u00b0\3\2\2\2\u00b6(\3\2\2\2\u00b7\u00b8"+
		"\7p\2\2\u00b8\u00b9\7w\2\2\u00b9\u00ba\7n\2\2\u00ba\u00bb\7n\2\2\u00bb"+
		"*\3\2\2\2\u00bc\u00bd\7x\2\2\u00bd\u00be\7q\2\2\u00be\u00bf\7k\2\2\u00bf"+
		"\u00c0\7f\2\2\u00c0,\3\2\2\2\u00c1\u00c2\7u\2\2\u00c2\u00c3\7w\2\2\u00c3"+
		"\u00c4\7r\2\2\u00c4\u00c5\7g\2\2\u00c5\u00c6\7t\2\2\u00c6\u00c7\7*\2\2"+
		"\u00c7\u00c8\7+\2\2\u00c8.\3\2\2\2\u00c9\u00ca\7v\2\2\u00ca\u00cb\7j\2"+
		"\2\u00cb\u00cc\7k\2\2\u00cc\u00cd\7u\2\2\u00cd\60\3\2\2\2\u00ce\u00cf"+
		"\7$\2\2\u00cf\u00d1\t\2\2\2\u00d0\u00d2\7$\2\2\u00d1\u00d0\3\2\2\2\u00d2"+
		"\u00d3\3\2\2\2\u00d3\u00d1\3\2\2\2\u00d3\u00d4\3\2\2\2\u00d4\62\3\2\2"+
		"\2\u00d5\u00d7\t\2\2\2\u00d6\u00d5\3\2\2\2\u00d7\u00d8\3\2\2\2\u00d8\u00d6"+
		"\3\2\2\2\u00d8\u00d9\3\2\2\2\u00d9\64\3\2\2\2\u00da\u00db\t\2\2\2\u00db"+
		"\66\3\2\2\2\u00dc\u00de\t\3\2\2\u00dd\u00dc\3\2\2\2\u00de\u00df\3\2\2"+
		"\2\u00df\u00dd\3\2\2\2\u00df\u00e0\3\2\2\2\u00e08\3\2\2\2\u00e1\u00e7"+
		"\7?\2\2\u00e2\u00e3\7-\2\2\u00e3\u00e7\7?\2\2\u00e4\u00e5\7/\2\2\u00e5"+
		"\u00e7\7?\2\2\u00e6\u00e1\3\2\2\2\u00e6\u00e2\3\2\2\2\u00e6\u00e4\3\2"+
		"\2\2\u00e7:\3\2\2\2\u00e8\u00e9\7?\2\2\u00e9\u00f2\7?\2\2\u00ea\u00eb"+
		"\7#\2\2\u00eb\u00f2\7?\2\2\u00ec\u00ed\7@\2\2\u00ed\u00f2\7?\2\2\u00ee"+
		"\u00ef\7>\2\2\u00ef\u00f2\7?\2\2\u00f0\u00f2\t\4\2\2\u00f1\u00e8\3\2\2"+
		"\2\u00f1\u00ea\3\2\2\2\u00f1\u00ec\3\2\2\2\u00f1\u00ee\3\2\2\2\u00f1\u00f0"+
		"\3\2\2\2\u00f2<\3\2\2\2\u00f3\u00f4\7#\2\2\u00f4>\3\2\2\2\u00f5\u00f6"+
		"\7-\2\2\u00f6\u00fa\7-\2\2\u00f7\u00f8\7/\2\2\u00f8\u00fa\7/\2\2\u00f9"+
		"\u00f5\3\2\2\2\u00f9\u00f7\3\2\2\2\u00fa@\3\2\2\2\u00fb\u0101\t\5\2\2"+
		"\u00fc\u00fd\7(\2\2\u00fd\u0101\7(\2\2\u00fe\u00ff\7~\2\2\u00ff\u0101"+
		"\7~\2\2\u0100\u00fb\3\2\2\2\u0100\u00fc\3\2\2\2\u0100\u00fe\3\2\2\2\u0101"+
		"B\3\2\2\2\u0102\u0103\t\6\2\2\u0103\u0104\3\2\2\2\u0104\u0105\b\"\2\2"+
		"\u0105D\3\2\2\2\u0106\u0107\7\61\2\2\u0107\u0108\7\61\2\2\u0108\u010c"+
		"\3\2\2\2\u0109\u010b\t\2\2\2\u010a\u0109\3\2\2\2\u010b\u010e\3\2\2\2\u010c"+
		"\u010a\3\2\2\2\u010c\u010d\3\2\2\2\u010d\u011b\3\2\2\2\u010e\u010c\3\2"+
		"\2\2\u010f\u0110\7\61\2\2\u0110\u0111\7,\2\2\u0111\u0115\3\2\2\2\u0112"+
		"\u0114\t\2\2\2\u0113\u0112\3\2\2\2\u0114\u0117\3\2\2\2\u0115\u0113\3\2"+
		"\2\2\u0115\u0116\3\2\2\2\u0116\u0118\3\2\2\2\u0117\u0115\3\2\2\2\u0118"+
		"\u0119\7,\2\2\u0119\u011b\7\61\2\2\u011a\u0106\3\2\2\2\u011a\u010f\3\2"+
		"\2\2\u011b\u011c\3\2\2\2\u011c\u011d\b#\2\2\u011dF\3\2\2\2\17\2\u00aa"+
		"\u00b5\u00d3\u00d8\u00df\u00e6\u00f1\u00f9\u0100\u010c\u0115\u011a\3\b"+
		"\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}