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
		T__17=18, T__18=19, AccessModifier=20, JBoolean=21, JNull=22, Void=23, 
		Super=24, This=25, If=26, Else=27, EQUAL=28, PLUSEQUAL=29, MINUSEQUAL=30, 
		Comperator=31, OpBeforeIdentifier=32, OpBeforeOrAfterIdentifier=33, PointOperator=34, 
		AddSubOperator=35, LogicalOperator=36, JString=37, Identifier=38, JCharacter=39, 
		JInteger=40, WS=41, Comment=42, LineComment=43;
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
			"T__17", "T__18", "AccessModifier", "JBoolean", "JNull", "Void", "Super", 
			"This", "If", "Else", "EQUAL", "PLUSEQUAL", "MINUSEQUAL", "Comperator", 
			"OpBeforeIdentifier", "OpBeforeOrAfterIdentifier", "PointOperator", "AddSubOperator", 
			"LogicalOperator", "JString", "Identifier", "JCharacter", "JInteger", 
			"WS", "Comment", "LineComment"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'class'", "'('", "')'", "'static'", "'main'", "'(String[]'", "'args)'", 
			"'{'", "'}'", "';'", "','", "'.'", "'new'", "'while ('", "'return'", 
			"'int'", "'char'", "'boolean'", "'String'", null, null, "'null'", "'void'", 
			"'super'", "'this'", "'if'", "'else'", "'='", "'+='", "'-='", null, "'!'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, "AccessModifier", "JBoolean", 
			"JNull", "Void", "Super", "This", "If", "Else", "EQUAL", "PLUSEQUAL", 
			"MINUSEQUAL", "Comperator", "OpBeforeIdentifier", "OpBeforeOrAfterIdentifier", 
			"PointOperator", "AddSubOperator", "LogicalOperator", "JString", "Identifier", 
			"JCharacter", "JInteger", "WS", "Comment", "LineComment"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2-\u014e\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3"+
		"\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3"+
		"\20\3\20\3\20\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3"+
		"\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\25\3"+
		"\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3"+
		"\25\3\25\3\25\3\25\3\25\3\25\3\25\5\25\u00cb\n\25\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\5\26\u00d6\n\26\3\27\3\27\3\27\3\27\3\27\3\30"+
		"\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32"+
		"\3\32\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\35\3\35\3\36\3\36\3\36"+
		"\3\37\3\37\3\37\3 \3 \3 \3 \3 \3 \3 \3 \3 \5 \u0106\n \3!\3!\3\"\3\"\3"+
		"\"\3\"\5\"\u010e\n\"\3#\3#\3$\3$\3%\3%\3%\3%\5%\u0118\n%\3&\3&\3&\6&\u011d"+
		"\n&\r&\16&\u011e\3\'\6\'\u0122\n\'\r\'\16\'\u0123\3(\3(\3(\3(\3)\6)\u012b"+
		"\n)\r)\16)\u012c\3*\6*\u0130\n*\r*\16*\u0131\3*\3*\3+\3+\3+\3+\7+\u013a"+
		"\n+\f+\16+\u013d\13+\3+\3+\3+\3+\3+\3,\3,\3,\3,\7,\u0148\n,\f,\16,\u014b"+
		"\13,\3,\3,\3\u013b\2-\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27"+
		"\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33"+
		"\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-\3\2\t\4\2>>@@\4\2,"+
		",\61\61\4\2--//\4\2C\\c|\3\2\62;\5\2\13\f\17\17\"\"\4\2\f\f\17\17\2\u015c"+
		"\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2"+
		"\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2"+
		"\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2"+
		"\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2"+
		"\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3"+
		"\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2"+
		"\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2"+
		"U\3\2\2\2\2W\3\2\2\2\3Y\3\2\2\2\5_\3\2\2\2\7a\3\2\2\2\tc\3\2\2\2\13j\3"+
		"\2\2\2\ro\3\2\2\2\17y\3\2\2\2\21\177\3\2\2\2\23\u0081\3\2\2\2\25\u0083"+
		"\3\2\2\2\27\u0085\3\2\2\2\31\u0087\3\2\2\2\33\u0089\3\2\2\2\35\u008d\3"+
		"\2\2\2\37\u0095\3\2\2\2!\u009c\3\2\2\2#\u00a0\3\2\2\2%\u00a5\3\2\2\2\'"+
		"\u00ad\3\2\2\2)\u00ca\3\2\2\2+\u00d5\3\2\2\2-\u00d7\3\2\2\2/\u00dc\3\2"+
		"\2\2\61\u00e1\3\2\2\2\63\u00e7\3\2\2\2\65\u00ec\3\2\2\2\67\u00ef\3\2\2"+
		"\29\u00f4\3\2\2\2;\u00f6\3\2\2\2=\u00f9\3\2\2\2?\u0105\3\2\2\2A\u0107"+
		"\3\2\2\2C\u010d\3\2\2\2E\u010f\3\2\2\2G\u0111\3\2\2\2I\u0117\3\2\2\2K"+
		"\u0119\3\2\2\2M\u0121\3\2\2\2O\u0125\3\2\2\2Q\u012a\3\2\2\2S\u012f\3\2"+
		"\2\2U\u0135\3\2\2\2W\u0143\3\2\2\2YZ\7e\2\2Z[\7n\2\2[\\\7c\2\2\\]\7u\2"+
		"\2]^\7u\2\2^\4\3\2\2\2_`\7*\2\2`\6\3\2\2\2ab\7+\2\2b\b\3\2\2\2cd\7u\2"+
		"\2de\7v\2\2ef\7c\2\2fg\7v\2\2gh\7k\2\2hi\7e\2\2i\n\3\2\2\2jk\7o\2\2kl"+
		"\7c\2\2lm\7k\2\2mn\7p\2\2n\f\3\2\2\2op\7*\2\2pq\7U\2\2qr\7v\2\2rs\7t\2"+
		"\2st\7k\2\2tu\7p\2\2uv\7i\2\2vw\7]\2\2wx\7_\2\2x\16\3\2\2\2yz\7c\2\2z"+
		"{\7t\2\2{|\7i\2\2|}\7u\2\2}~\7+\2\2~\20\3\2\2\2\177\u0080\7}\2\2\u0080"+
		"\22\3\2\2\2\u0081\u0082\7\177\2\2\u0082\24\3\2\2\2\u0083\u0084\7=\2\2"+
		"\u0084\26\3\2\2\2\u0085\u0086\7.\2\2\u0086\30\3\2\2\2\u0087\u0088\7\60"+
		"\2\2\u0088\32\3\2\2\2\u0089\u008a\7p\2\2\u008a\u008b\7g\2\2\u008b\u008c"+
		"\7y\2\2\u008c\34\3\2\2\2\u008d\u008e\7y\2\2\u008e\u008f\7j\2\2\u008f\u0090"+
		"\7k\2\2\u0090\u0091\7n\2\2\u0091\u0092\7g\2\2\u0092\u0093\7\"\2\2\u0093"+
		"\u0094\7*\2\2\u0094\36\3\2\2\2\u0095\u0096\7t\2\2\u0096\u0097\7g\2\2\u0097"+
		"\u0098\7v\2\2\u0098\u0099\7w\2\2\u0099\u009a\7t\2\2\u009a\u009b\7p\2\2"+
		"\u009b \3\2\2\2\u009c\u009d\7k\2\2\u009d\u009e\7p\2\2\u009e\u009f\7v\2"+
		"\2\u009f\"\3\2\2\2\u00a0\u00a1\7e\2\2\u00a1\u00a2\7j\2\2\u00a2\u00a3\7"+
		"c\2\2\u00a3\u00a4\7t\2\2\u00a4$\3\2\2\2\u00a5\u00a6\7d\2\2\u00a6\u00a7"+
		"\7q\2\2\u00a7\u00a8\7q\2\2\u00a8\u00a9\7n\2\2\u00a9\u00aa\7g\2\2\u00aa"+
		"\u00ab\7c\2\2\u00ab\u00ac\7p\2\2\u00ac&\3\2\2\2\u00ad\u00ae\7U\2\2\u00ae"+
		"\u00af\7v\2\2\u00af\u00b0\7t\2\2\u00b0\u00b1\7k\2\2\u00b1\u00b2\7p\2\2"+
		"\u00b2\u00b3\7i\2\2\u00b3(\3\2\2\2\u00b4\u00b5\7r\2\2\u00b5\u00b6\7w\2"+
		"\2\u00b6\u00b7\7d\2\2\u00b7\u00b8\7n\2\2\u00b8\u00b9\7k\2\2\u00b9\u00cb"+
		"\7e\2\2\u00ba\u00bb\7r\2\2\u00bb\u00bc\7t\2\2\u00bc\u00bd\7q\2\2\u00bd"+
		"\u00be\7v\2\2\u00be\u00bf\7g\2\2\u00bf\u00c0\7e\2\2\u00c0\u00c1\7v\2\2"+
		"\u00c1\u00c2\7g\2\2\u00c2\u00cb\7f\2\2\u00c3\u00c4\7r\2\2\u00c4\u00c5"+
		"\7t\2\2\u00c5\u00c6\7k\2\2\u00c6\u00c7\7x\2\2\u00c7\u00c8\7c\2\2\u00c8"+
		"\u00c9\7v\2\2\u00c9\u00cb\7g\2\2\u00ca\u00b4\3\2\2\2\u00ca\u00ba\3\2\2"+
		"\2\u00ca\u00c3\3\2\2\2\u00cb*\3\2\2\2\u00cc\u00cd\7v\2\2\u00cd\u00ce\7"+
		"t\2\2\u00ce\u00cf\7w\2\2\u00cf\u00d6\7g\2\2\u00d0\u00d1\7h\2\2\u00d1\u00d2"+
		"\7c\2\2\u00d2\u00d3\7n\2\2\u00d3\u00d4\7u\2\2\u00d4\u00d6\7g\2\2\u00d5"+
		"\u00cc\3\2\2\2\u00d5\u00d0\3\2\2\2\u00d6,\3\2\2\2\u00d7\u00d8\7p\2\2\u00d8"+
		"\u00d9\7w\2\2\u00d9\u00da\7n\2\2\u00da\u00db\7n\2\2\u00db.\3\2\2\2\u00dc"+
		"\u00dd\7x\2\2\u00dd\u00de\7q\2\2\u00de\u00df\7k\2\2\u00df\u00e0\7f\2\2"+
		"\u00e0\60\3\2\2\2\u00e1\u00e2\7u\2\2\u00e2\u00e3\7w\2\2\u00e3\u00e4\7"+
		"r\2\2\u00e4\u00e5\7g\2\2\u00e5\u00e6\7t\2\2\u00e6\62\3\2\2\2\u00e7\u00e8"+
		"\7v\2\2\u00e8\u00e9\7j\2\2\u00e9\u00ea\7k\2\2\u00ea\u00eb\7u\2\2\u00eb"+
		"\64\3\2\2\2\u00ec\u00ed\7k\2\2\u00ed\u00ee\7h\2\2\u00ee\66\3\2\2\2\u00ef"+
		"\u00f0\7g\2\2\u00f0\u00f1\7n\2\2\u00f1\u00f2\7u\2\2\u00f2\u00f3\7g\2\2"+
		"\u00f38\3\2\2\2\u00f4\u00f5\7?\2\2\u00f5:\3\2\2\2\u00f6\u00f7\7-\2\2\u00f7"+
		"\u00f8\7?\2\2\u00f8<\3\2\2\2\u00f9\u00fa\7/\2\2\u00fa\u00fb\7?\2\2\u00fb"+
		">\3\2\2\2\u00fc\u00fd\7?\2\2\u00fd\u0106\7?\2\2\u00fe\u00ff\7#\2\2\u00ff"+
		"\u0106\7?\2\2\u0100\u0101\7@\2\2\u0101\u0106\7?\2\2\u0102\u0103\7>\2\2"+
		"\u0103\u0106\7?\2\2\u0104\u0106\t\2\2\2\u0105\u00fc\3\2\2\2\u0105\u00fe"+
		"\3\2\2\2\u0105\u0100\3\2\2\2\u0105\u0102\3\2\2\2\u0105\u0104\3\2\2\2\u0106"+
		"@\3\2\2\2\u0107\u0108\7#\2\2\u0108B\3\2\2\2\u0109\u010a\7-\2\2\u010a\u010e"+
		"\7-\2\2\u010b\u010c\7/\2\2\u010c\u010e\7/\2\2\u010d\u0109\3\2\2\2\u010d"+
		"\u010b\3\2\2\2\u010eD\3\2\2\2\u010f\u0110\t\3\2\2\u0110F\3\2\2\2\u0111"+
		"\u0112\t\4\2\2\u0112H\3\2\2\2\u0113\u0114\7(\2\2\u0114\u0118\7(\2\2\u0115"+
		"\u0116\7~\2\2\u0116\u0118\7~\2\2\u0117\u0113\3\2\2\2\u0117\u0115\3\2\2"+
		"\2\u0118J\3\2\2\2\u0119\u011a\7$\2\2\u011a\u011c\t\5\2\2\u011b\u011d\7"+
		"$\2\2\u011c\u011b\3\2\2\2\u011d\u011e\3\2\2\2\u011e\u011c\3\2\2\2\u011e"+
		"\u011f\3\2\2\2\u011fL\3\2\2\2\u0120\u0122\t\5\2\2\u0121\u0120\3\2\2\2"+
		"\u0122\u0123\3\2\2\2\u0123\u0121\3\2\2\2\u0123\u0124\3\2\2\2\u0124N\3"+
		"\2\2\2\u0125\u0126\7)\2\2\u0126\u0127\t\5\2\2\u0127\u0128\7)\2\2\u0128"+
		"P\3\2\2\2\u0129\u012b\t\6\2\2\u012a\u0129\3\2\2\2\u012b\u012c\3\2\2\2"+
		"\u012c\u012a\3\2\2\2\u012c\u012d\3\2\2\2\u012dR\3\2\2\2\u012e\u0130\t"+
		"\7\2\2\u012f\u012e\3\2\2\2\u0130\u0131\3\2\2\2\u0131\u012f\3\2\2\2\u0131"+
		"\u0132\3\2\2\2\u0132\u0133\3\2\2\2\u0133\u0134\b*\2\2\u0134T\3\2\2\2\u0135"+
		"\u0136\7\61\2\2\u0136\u0137\7,\2\2\u0137\u013b\3\2\2\2\u0138\u013a\13"+
		"\2\2\2\u0139\u0138\3\2\2\2\u013a\u013d\3\2\2\2\u013b\u013c\3\2\2\2\u013b"+
		"\u0139\3\2\2\2\u013c\u013e\3\2\2\2\u013d\u013b\3\2\2\2\u013e\u013f\7,"+
		"\2\2\u013f\u0140\7\61\2\2\u0140\u0141\3\2\2\2\u0141\u0142\b+\2\2\u0142"+
		"V\3\2\2\2\u0143\u0144\7\61\2\2\u0144\u0145\7\61\2\2\u0145\u0149\3\2\2"+
		"\2\u0146\u0148\n\b\2\2\u0147\u0146\3\2\2\2\u0148\u014b\3\2\2\2\u0149\u0147"+
		"\3\2\2\2\u0149\u014a\3\2\2\2\u014a\u014c\3\2\2\2\u014b\u0149\3\2\2\2\u014c"+
		"\u014d\b,\2\2\u014dX\3\2\2\2\16\2\u00ca\u00d5\u0105\u010d\u0117\u011e"+
		"\u0123\u012c\u0131\u013b\u0149\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}