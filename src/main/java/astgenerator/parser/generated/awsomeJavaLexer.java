// Generated from C:/Users/Daniel/IdeaProjects/AwsomeJavaCompiler/src/main/java/astgenerator/parser\awsomeJava.g4 by ANTLR 4.7.2
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
		T__17=18, T__18=19, AccessModifier=20, JBoolean=21, JNull=22, Super=23, 
		Semicolon=24, JString=25, Identifier=26, JCharacter=27, JInteger=28, AssignOperator=29, 
		Comperator=30, OpBeforeIdentifier=31, OpBeforeOrAfterIdentifier=32, OpInBetweenIdentifier=33, 
		WS=34, Comment=35;
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
			"T__17", "T__18", "AccessModifier", "JBoolean", "JNull", "Super", "Semicolon", 
			"JString", "Identifier", "JCharacter", "JInteger", "AssignOperator", 
			"Comperator", "OpBeforeIdentifier", "OpBeforeOrAfterIdentifier", "OpInBetweenIdentifier", 
			"WS", "Comment"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'class'", "'('", "')'", "'{'", "'}'", "','", "'.'", "'='", "'new'", 
			"');'", "'if ('", "'else if('", "'else ('", "'while ('", "'return'", 
			"'int'", "'char'", "'boolean'", "'this'", null, null, "'null'", "'super()'", 
			"';'", null, null, null, null, null, null, "'!'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, "AccessModifier", "JBoolean", 
			"JNull", "Super", "Semicolon", "JString", "Identifier", "JCharacter", 
			"JInteger", "AssignOperator", "Comperator", "OpBeforeIdentifier", "OpBeforeOrAfterIdentifier", 
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2%\u011e\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3"+
		"\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\f"+
		"\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3"+
		"\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3"+
		"\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3"+
		"\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\25\3"+
		"\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3"+
		"\25\3\25\3\25\3\25\3\25\3\25\3\25\5\25\u00b5\n\25\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\5\26\u00c0\n\26\3\27\3\27\3\27\3\27\3\27\3\30"+
		"\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\32\3\32\3\32\6\32\u00d4"+
		"\n\32\r\32\16\32\u00d5\3\33\6\33\u00d9\n\33\r\33\16\33\u00da\3\34\3\34"+
		"\3\35\6\35\u00e0\n\35\r\35\16\35\u00e1\3\36\3\36\3\36\3\36\3\36\5\36\u00e9"+
		"\n\36\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\5\37\u00f4\n\37\3 "+
		"\3 \3!\3!\3!\3!\5!\u00fc\n!\3\"\3\"\3\"\3\"\3\"\5\"\u0103\n\"\3#\3#\3"+
		"#\3#\3$\3$\7$\u010b\n$\f$\16$\u010e\13$\3$\3$\3$\3$\7$\u0114\n$\f$\16"+
		"$\u0117\13$\3$\3$\5$\u011b\n$\3$\3$\2\2%\3\3\5\4\7\5\t\6\13\7\r\b\17\t"+
		"\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27"+
		"-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%\3\2\7\4\2C\\c|\3"+
		"\2\62;\4\2>>@@\4\2--//\7\2\13\f\17\17\"\"*+AA\2\u012f\2\3\3\2\2\2\2\5"+
		"\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2"+
		"\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33"+
		"\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2"+
		"\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2"+
		"\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2"+
		"\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\3I\3\2\2\2\5O"+
		"\3\2\2\2\7Q\3\2\2\2\tS\3\2\2\2\13U\3\2\2\2\rW\3\2\2\2\17Y\3\2\2\2\21["+
		"\3\2\2\2\23]\3\2\2\2\25a\3\2\2\2\27d\3\2\2\2\31i\3\2\2\2\33r\3\2\2\2\35"+
		"y\3\2\2\2\37\u0081\3\2\2\2!\u0088\3\2\2\2#\u008c\3\2\2\2%\u0091\3\2\2"+
		"\2\'\u0099\3\2\2\2)\u00b4\3\2\2\2+\u00bf\3\2\2\2-\u00c1\3\2\2\2/\u00c6"+
		"\3\2\2\2\61\u00ce\3\2\2\2\63\u00d0\3\2\2\2\65\u00d8\3\2\2\2\67\u00dc\3"+
		"\2\2\29\u00df\3\2\2\2;\u00e8\3\2\2\2=\u00f3\3\2\2\2?\u00f5\3\2\2\2A\u00fb"+
		"\3\2\2\2C\u0102\3\2\2\2E\u0104\3\2\2\2G\u011a\3\2\2\2IJ\7e\2\2JK\7n\2"+
		"\2KL\7c\2\2LM\7u\2\2MN\7u\2\2N\4\3\2\2\2OP\7*\2\2P\6\3\2\2\2QR\7+\2\2"+
		"R\b\3\2\2\2ST\7}\2\2T\n\3\2\2\2UV\7\177\2\2V\f\3\2\2\2WX\7.\2\2X\16\3"+
		"\2\2\2YZ\7\60\2\2Z\20\3\2\2\2[\\\7?\2\2\\\22\3\2\2\2]^\7p\2\2^_\7g\2\2"+
		"_`\7y\2\2`\24\3\2\2\2ab\7+\2\2bc\7=\2\2c\26\3\2\2\2de\7k\2\2ef\7h\2\2"+
		"fg\7\"\2\2gh\7*\2\2h\30\3\2\2\2ij\7g\2\2jk\7n\2\2kl\7u\2\2lm\7g\2\2mn"+
		"\7\"\2\2no\7k\2\2op\7h\2\2pq\7*\2\2q\32\3\2\2\2rs\7g\2\2st\7n\2\2tu\7"+
		"u\2\2uv\7g\2\2vw\7\"\2\2wx\7*\2\2x\34\3\2\2\2yz\7y\2\2z{\7j\2\2{|\7k\2"+
		"\2|}\7n\2\2}~\7g\2\2~\177\7\"\2\2\177\u0080\7*\2\2\u0080\36\3\2\2\2\u0081"+
		"\u0082\7t\2\2\u0082\u0083\7g\2\2\u0083\u0084\7v\2\2\u0084\u0085\7w\2\2"+
		"\u0085\u0086\7t\2\2\u0086\u0087\7p\2\2\u0087 \3\2\2\2\u0088\u0089\7k\2"+
		"\2\u0089\u008a\7p\2\2\u008a\u008b\7v\2\2\u008b\"\3\2\2\2\u008c\u008d\7"+
		"e\2\2\u008d\u008e\7j\2\2\u008e\u008f\7c\2\2\u008f\u0090\7t\2\2\u0090$"+
		"\3\2\2\2\u0091\u0092\7d\2\2\u0092\u0093\7q\2\2\u0093\u0094\7q\2\2\u0094"+
		"\u0095\7n\2\2\u0095\u0096\7g\2\2\u0096\u0097\7c\2\2\u0097\u0098\7p\2\2"+
		"\u0098&\3\2\2\2\u0099\u009a\7v\2\2\u009a\u009b\7j\2\2\u009b\u009c\7k\2"+
		"\2\u009c\u009d\7u\2\2\u009d(\3\2\2\2\u009e\u009f\7r\2\2\u009f\u00a0\7"+
		"w\2\2\u00a0\u00a1\7d\2\2\u00a1\u00a2\7n\2\2\u00a2\u00a3\7k\2\2\u00a3\u00b5"+
		"\7e\2\2\u00a4\u00a5\7r\2\2\u00a5\u00a6\7t\2\2\u00a6\u00a7\7q\2\2\u00a7"+
		"\u00a8\7v\2\2\u00a8\u00a9\7g\2\2\u00a9\u00aa\7e\2\2\u00aa\u00ab\7v\2\2"+
		"\u00ab\u00ac\7g\2\2\u00ac\u00b5\7f\2\2\u00ad\u00ae\7r\2\2\u00ae\u00af"+
		"\7t\2\2\u00af\u00b0\7k\2\2\u00b0\u00b1\7x\2\2\u00b1\u00b2\7c\2\2\u00b2"+
		"\u00b3\7v\2\2\u00b3\u00b5\7g\2\2\u00b4\u009e\3\2\2\2\u00b4\u00a4\3\2\2"+
		"\2\u00b4\u00ad\3\2\2\2\u00b5*\3\2\2\2\u00b6\u00b7\7v\2\2\u00b7\u00b8\7"+
		"t\2\2\u00b8\u00b9\7w\2\2\u00b9\u00c0\7g\2\2\u00ba\u00bb\7h\2\2\u00bb\u00bc"+
		"\7c\2\2\u00bc\u00bd\7n\2\2\u00bd\u00be\7u\2\2\u00be\u00c0\7g\2\2\u00bf"+
		"\u00b6\3\2\2\2\u00bf\u00ba\3\2\2\2\u00c0,\3\2\2\2\u00c1\u00c2\7p\2\2\u00c2"+
		"\u00c3\7w\2\2\u00c3\u00c4\7n\2\2\u00c4\u00c5\7n\2\2\u00c5.\3\2\2\2\u00c6"+
		"\u00c7\7u\2\2\u00c7\u00c8\7w\2\2\u00c8\u00c9\7r\2\2\u00c9\u00ca\7g\2\2"+
		"\u00ca\u00cb\7t\2\2\u00cb\u00cc\7*\2\2\u00cc\u00cd\7+\2\2\u00cd\60\3\2"+
		"\2\2\u00ce\u00cf\7=\2\2\u00cf\62\3\2\2\2\u00d0\u00d1\7$\2\2\u00d1\u00d3"+
		"\t\2\2\2\u00d2\u00d4\7$\2\2\u00d3\u00d2\3\2\2\2\u00d4\u00d5\3\2\2\2\u00d5"+
		"\u00d3\3\2\2\2\u00d5\u00d6\3\2\2\2\u00d6\64\3\2\2\2\u00d7\u00d9\t\2\2"+
		"\2\u00d8\u00d7\3\2\2\2\u00d9\u00da\3\2\2\2\u00da\u00d8\3\2\2\2\u00da\u00db"+
		"\3\2\2\2\u00db\66\3\2\2\2\u00dc\u00dd\t\2\2\2\u00dd8\3\2\2\2\u00de\u00e0"+
		"\t\3\2\2\u00df\u00de\3\2\2\2\u00e0\u00e1\3\2\2\2\u00e1\u00df\3\2\2\2\u00e1"+
		"\u00e2\3\2\2\2\u00e2:\3\2\2\2\u00e3\u00e9\7?\2\2\u00e4\u00e5\7-\2\2\u00e5"+
		"\u00e9\7?\2\2\u00e6\u00e7\7/\2\2\u00e7\u00e9\7?\2\2\u00e8\u00e3\3\2\2"+
		"\2\u00e8\u00e4\3\2\2\2\u00e8\u00e6\3\2\2\2\u00e9<\3\2\2\2\u00ea\u00eb"+
		"\7?\2\2\u00eb\u00f4\7?\2\2\u00ec\u00ed\7#\2\2\u00ed\u00f4\7?\2\2\u00ee"+
		"\u00ef\7@\2\2\u00ef\u00f4\7?\2\2\u00f0\u00f1\7>\2\2\u00f1\u00f4\7?\2\2"+
		"\u00f2\u00f4\t\4\2\2\u00f3\u00ea\3\2\2\2\u00f3\u00ec\3\2\2\2\u00f3\u00ee"+
		"\3\2\2\2\u00f3\u00f0\3\2\2\2\u00f3\u00f2\3\2\2\2\u00f4>\3\2\2\2\u00f5"+
		"\u00f6\7#\2\2\u00f6@\3\2\2\2\u00f7\u00f8\7-\2\2\u00f8\u00fc\7-\2\2\u00f9"+
		"\u00fa\7/\2\2\u00fa\u00fc\7/\2\2\u00fb\u00f7\3\2\2\2\u00fb\u00f9\3\2\2"+
		"\2\u00fcB\3\2\2\2\u00fd\u0103\t\5\2\2\u00fe\u00ff\7(\2\2\u00ff\u0103\7"+
		"(\2\2\u0100\u0101\7~\2\2\u0101\u0103\7~\2\2\u0102\u00fd\3\2\2\2\u0102"+
		"\u00fe\3\2\2\2\u0102\u0100\3\2\2\2\u0103D\3\2\2\2\u0104\u0105\t\6\2\2"+
		"\u0105\u0106\3\2\2\2\u0106\u0107\b#\2\2\u0107F\3\2\2\2\u0108\u010c\7^"+
		"\2\2\u0109\u010b\t\2\2\2\u010a\u0109\3\2\2\2\u010b\u010e\3\2\2\2\u010c"+
		"\u010a\3\2\2\2\u010c\u010d\3\2\2\2\u010d\u011b\3\2\2\2\u010e\u010c\3\2"+
		"\2\2\u010f\u0110\7\61\2\2\u0110\u0111\7,\2\2\u0111\u0115\3\2\2\2\u0112"+
		"\u0114\t\2\2\2\u0113\u0112\3\2\2\2\u0114\u0117\3\2\2\2\u0115\u0113\3\2"+
		"\2\2\u0115\u0116\3\2\2\2\u0116\u0118\3\2\2\2\u0117\u0115\3\2\2\2\u0118"+
		"\u0119\7,\2\2\u0119\u011b\7\61\2\2\u011a\u0108\3\2\2\2\u011a\u010f\3\2"+
		"\2\2\u011b\u011c\3\2\2\2\u011c\u011d\b$\2\2\u011dH\3\2\2\2\17\2\u00b4"+
		"\u00bf\u00d5\u00da\u00e1\u00e8\u00f3\u00fb\u0102\u010c\u0115\u011a\3\b"+
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