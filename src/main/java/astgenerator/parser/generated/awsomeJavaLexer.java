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
		T__9=10, T__10=11, T__11=12, AccessModifier=13, JBoolean=14, JNull=15, 
		Void=16, Super=17, This=18, If=19, Else=20, Equal=21, PlusEqual=22, MinusEqual=23, 
		Comperator=24, OpBeforeIdentifier=25, OpBeforeOrAfterIdentifier=26, PointOperator=27, 
		AddSubOperator=28, LogicalOperator=29, LBracket=30, RBracket=31, CurlyLBracket=32, 
		CurlyRBracket=33, Dot=34, Comma=35, Semincolor=36, JString=37, Identifier=38, 
		JCharacter=39, JInteger=40, WS=41, Comment=42, LineComment=43;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "AccessModifier", "JBoolean", "JNull", "Void", 
			"Super", "This", "If", "Else", "Equal", "PlusEqual", "MinusEqual", "Comperator", 
			"OpBeforeIdentifier", "OpBeforeOrAfterIdentifier", "PointOperator", "AddSubOperator", 
			"LogicalOperator", "LBracket", "RBracket", "CurlyLBracket", "CurlyRBracket", 
			"Dot", "Comma", "Semincolor", "JString", "Identifier", "JCharacter", 
			"JInteger", "WS", "Comment", "LineComment"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2-\u0151\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3"+
		"\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\7\3\7"+
		"\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3"+
		"\n\3\n\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3"+
		"\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u00b9"+
		"\n\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u00c4\n\17\3\20"+
		"\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25"+
		"\3\26\3\26\3\27\3\27\3\27\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\31"+
		"\3\31\3\31\3\31\5\31\u00f4\n\31\3\32\3\32\3\33\3\33\3\33\3\33\5\33\u00fc"+
		"\n\33\3\34\3\34\3\35\3\35\3\36\3\36\3\36\3\36\5\36\u0106\n\36\3\37\3\37"+
		"\3 \3 \3!\3!\3\"\3\"\3#\3#\3$\3$\3%\3%\3&\3&\7&\u0118\n&\f&\16&\u011b"+
		"\13&\3&\6&\u011e\n&\r&\16&\u011f\3\'\3\'\7\'\u0124\n\'\f\'\16\'\u0127"+
		"\13\'\3(\3(\3(\3(\3)\6)\u012e\n)\r)\16)\u012f\3*\6*\u0133\n*\r*\16*\u0134"+
		"\3*\3*\3+\3+\3+\3+\7+\u013d\n+\f+\16+\u0140\13+\3+\3+\3+\3+\3+\3,\3,\3"+
		",\3,\7,\u014b\n,\f,\16,\u014e\13,\3,\3,\3\u013e\2-\3\3\5\4\7\5\t\6\13"+
		"\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'"+
		"\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'"+
		"M(O)Q*S+U,W-\3\2\n\4\2>>@@\4\2,,\61\61\4\2--//\4\2C\\c|\5\2\62;C\\c|\3"+
		"\2\62;\5\2\13\f\17\17\"\"\4\2\f\f\17\17\2\u0160\2\3\3\2\2\2\2\5\3\2\2"+
		"\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21"+
		"\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2"+
		"\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3"+
		"\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3"+
		"\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3"+
		"\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2"+
		"\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\3"+
		"Y\3\2\2\2\5_\3\2\2\2\7f\3\2\2\2\tk\3\2\2\2\13t\3\2\2\2\ry\3\2\2\2\17}"+
		"\3\2\2\2\21\u0083\3\2\2\2\23\u008a\3\2\2\2\25\u008e\3\2\2\2\27\u0093\3"+
		"\2\2\2\31\u009b\3\2\2\2\33\u00b8\3\2\2\2\35\u00c3\3\2\2\2\37\u00c5\3\2"+
		"\2\2!\u00ca\3\2\2\2#\u00cf\3\2\2\2%\u00d5\3\2\2\2\'\u00da\3\2\2\2)\u00dd"+
		"\3\2\2\2+\u00e2\3\2\2\2-\u00e4\3\2\2\2/\u00e7\3\2\2\2\61\u00f3\3\2\2\2"+
		"\63\u00f5\3\2\2\2\65\u00fb\3\2\2\2\67\u00fd\3\2\2\29\u00ff\3\2\2\2;\u0105"+
		"\3\2\2\2=\u0107\3\2\2\2?\u0109\3\2\2\2A\u010b\3\2\2\2C\u010d\3\2\2\2E"+
		"\u010f\3\2\2\2G\u0111\3\2\2\2I\u0113\3\2\2\2K\u0115\3\2\2\2M\u0121\3\2"+
		"\2\2O\u0128\3\2\2\2Q\u012d\3\2\2\2S\u0132\3\2\2\2U\u0138\3\2\2\2W\u0146"+
		"\3\2\2\2YZ\7e\2\2Z[\7n\2\2[\\\7c\2\2\\]\7u\2\2]^\7u\2\2^\4\3\2\2\2_`\7"+
		"u\2\2`a\7v\2\2ab\7c\2\2bc\7v\2\2cd\7k\2\2de\7e\2\2e\6\3\2\2\2fg\7o\2\2"+
		"gh\7c\2\2hi\7k\2\2ij\7p\2\2j\b\3\2\2\2kl\7U\2\2lm\7v\2\2mn\7t\2\2no\7"+
		"k\2\2op\7p\2\2pq\7i\2\2qr\7]\2\2rs\7_\2\2s\n\3\2\2\2tu\7c\2\2uv\7t\2\2"+
		"vw\7i\2\2wx\7u\2\2x\f\3\2\2\2yz\7p\2\2z{\7g\2\2{|\7y\2\2|\16\3\2\2\2}"+
		"~\7y\2\2~\177\7j\2\2\177\u0080\7k\2\2\u0080\u0081\7n\2\2\u0081\u0082\7"+
		"g\2\2\u0082\20\3\2\2\2\u0083\u0084\7t\2\2\u0084\u0085\7g\2\2\u0085\u0086"+
		"\7v\2\2\u0086\u0087\7w\2\2\u0087\u0088\7t\2\2\u0088\u0089\7p\2\2\u0089"+
		"\22\3\2\2\2\u008a\u008b\7k\2\2\u008b\u008c\7p\2\2\u008c\u008d\7v\2\2\u008d"+
		"\24\3\2\2\2\u008e\u008f\7e\2\2\u008f\u0090\7j\2\2\u0090\u0091\7c\2\2\u0091"+
		"\u0092\7t\2\2\u0092\26\3\2\2\2\u0093\u0094\7d\2\2\u0094\u0095\7q\2\2\u0095"+
		"\u0096\7q\2\2\u0096\u0097\7n\2\2\u0097\u0098\7g\2\2\u0098\u0099\7c\2\2"+
		"\u0099\u009a\7p\2\2\u009a\30\3\2\2\2\u009b\u009c\7U\2\2\u009c\u009d\7"+
		"v\2\2\u009d\u009e\7t\2\2\u009e\u009f\7k\2\2\u009f\u00a0\7p\2\2\u00a0\u00a1"+
		"\7i\2\2\u00a1\32\3\2\2\2\u00a2\u00a3\7r\2\2\u00a3\u00a4\7w\2\2\u00a4\u00a5"+
		"\7d\2\2\u00a5\u00a6\7n\2\2\u00a6\u00a7\7k\2\2\u00a7\u00b9\7e\2\2\u00a8"+
		"\u00a9\7r\2\2\u00a9\u00aa\7t\2\2\u00aa\u00ab\7q\2\2\u00ab\u00ac\7v\2\2"+
		"\u00ac\u00ad\7g\2\2\u00ad\u00ae\7e\2\2\u00ae\u00af\7v\2\2\u00af\u00b0"+
		"\7g\2\2\u00b0\u00b9\7f\2\2\u00b1\u00b2\7r\2\2\u00b2\u00b3\7t\2\2\u00b3"+
		"\u00b4\7k\2\2\u00b4\u00b5\7x\2\2\u00b5\u00b6\7c\2\2\u00b6\u00b7\7v\2\2"+
		"\u00b7\u00b9\7g\2\2\u00b8\u00a2\3\2\2\2\u00b8\u00a8\3\2\2\2\u00b8\u00b1"+
		"\3\2\2\2\u00b9\34\3\2\2\2\u00ba\u00bb\7v\2\2\u00bb\u00bc\7t\2\2\u00bc"+
		"\u00bd\7w\2\2\u00bd\u00c4\7g\2\2\u00be\u00bf\7h\2\2\u00bf\u00c0\7c\2\2"+
		"\u00c0\u00c1\7n\2\2\u00c1\u00c2\7u\2\2\u00c2\u00c4\7g\2\2\u00c3\u00ba"+
		"\3\2\2\2\u00c3\u00be\3\2\2\2\u00c4\36\3\2\2\2\u00c5\u00c6\7p\2\2\u00c6"+
		"\u00c7\7w\2\2\u00c7\u00c8\7n\2\2\u00c8\u00c9\7n\2\2\u00c9 \3\2\2\2\u00ca"+
		"\u00cb\7x\2\2\u00cb\u00cc\7q\2\2\u00cc\u00cd\7k\2\2\u00cd\u00ce\7f\2\2"+
		"\u00ce\"\3\2\2\2\u00cf\u00d0\7u\2\2\u00d0\u00d1\7w\2\2\u00d1\u00d2\7r"+
		"\2\2\u00d2\u00d3\7g\2\2\u00d3\u00d4\7t\2\2\u00d4$\3\2\2\2\u00d5\u00d6"+
		"\7v\2\2\u00d6\u00d7\7j\2\2\u00d7\u00d8\7k\2\2\u00d8\u00d9\7u\2\2\u00d9"+
		"&\3\2\2\2\u00da\u00db\7k\2\2\u00db\u00dc\7h\2\2\u00dc(\3\2\2\2\u00dd\u00de"+
		"\7g\2\2\u00de\u00df\7n\2\2\u00df\u00e0\7u\2\2\u00e0\u00e1\7g\2\2\u00e1"+
		"*\3\2\2\2\u00e2\u00e3\7?\2\2\u00e3,\3\2\2\2\u00e4\u00e5\7-\2\2\u00e5\u00e6"+
		"\7?\2\2\u00e6.\3\2\2\2\u00e7\u00e8\7/\2\2\u00e8\u00e9\7?\2\2\u00e9\60"+
		"\3\2\2\2\u00ea\u00eb\7?\2\2\u00eb\u00f4\7?\2\2\u00ec\u00ed\7#\2\2\u00ed"+
		"\u00f4\7?\2\2\u00ee\u00ef\7@\2\2\u00ef\u00f4\7?\2\2\u00f0\u00f1\7>\2\2"+
		"\u00f1\u00f4\7?\2\2\u00f2\u00f4\t\2\2\2\u00f3\u00ea\3\2\2\2\u00f3\u00ec"+
		"\3\2\2\2\u00f3\u00ee\3\2\2\2\u00f3\u00f0\3\2\2\2\u00f3\u00f2\3\2\2\2\u00f4"+
		"\62\3\2\2\2\u00f5\u00f6\7#\2\2\u00f6\64\3\2\2\2\u00f7\u00f8\7-\2\2\u00f8"+
		"\u00fc\7-\2\2\u00f9\u00fa\7/\2\2\u00fa\u00fc\7/\2\2\u00fb\u00f7\3\2\2"+
		"\2\u00fb\u00f9\3\2\2\2\u00fc\66\3\2\2\2\u00fd\u00fe\t\3\2\2\u00fe8\3\2"+
		"\2\2\u00ff\u0100\t\4\2\2\u0100:\3\2\2\2\u0101\u0102\7(\2\2\u0102\u0106"+
		"\7(\2\2\u0103\u0104\7~\2\2\u0104\u0106\7~\2\2\u0105\u0101\3\2\2\2\u0105"+
		"\u0103\3\2\2\2\u0106<\3\2\2\2\u0107\u0108\7*\2\2\u0108>\3\2\2\2\u0109"+
		"\u010a\7+\2\2\u010a@\3\2\2\2\u010b\u010c\7}\2\2\u010cB\3\2\2\2\u010d\u010e"+
		"\7\177\2\2\u010eD\3\2\2\2\u010f\u0110\7\60\2\2\u0110F\3\2\2\2\u0111\u0112"+
		"\7.\2\2\u0112H\3\2\2\2\u0113\u0114\7=\2\2\u0114J\3\2\2\2\u0115\u0119\7"+
		"$\2\2\u0116\u0118\t\5\2\2\u0117\u0116\3\2\2\2\u0118\u011b\3\2\2\2\u0119"+
		"\u0117\3\2\2\2\u0119\u011a\3\2\2\2\u011a\u011d\3\2\2\2\u011b\u0119\3\2"+
		"\2\2\u011c\u011e\7$\2\2\u011d\u011c\3\2\2\2\u011e\u011f\3\2\2\2\u011f"+
		"\u011d\3\2\2\2\u011f\u0120\3\2\2\2\u0120L\3\2\2\2\u0121\u0125\t\5\2\2"+
		"\u0122\u0124\t\6\2\2\u0123\u0122\3\2\2\2\u0124\u0127\3\2\2\2\u0125\u0123"+
		"\3\2\2\2\u0125\u0126\3\2\2\2\u0126N\3\2\2\2\u0127\u0125\3\2\2\2\u0128"+
		"\u0129\7)\2\2\u0129\u012a\t\5\2\2\u012a\u012b\7)\2\2\u012bP\3\2\2\2\u012c"+
		"\u012e\t\7\2\2\u012d\u012c\3\2\2\2\u012e\u012f\3\2\2\2\u012f\u012d\3\2"+
		"\2\2\u012f\u0130\3\2\2\2\u0130R\3\2\2\2\u0131\u0133\t\b\2\2\u0132\u0131"+
		"\3\2\2\2\u0133\u0134\3\2\2\2\u0134\u0132\3\2\2\2\u0134\u0135\3\2\2\2\u0135"+
		"\u0136\3\2\2\2\u0136\u0137\b*\2\2\u0137T\3\2\2\2\u0138\u0139\7\61\2\2"+
		"\u0139\u013a\7,\2\2\u013a\u013e\3\2\2\2\u013b\u013d\13\2\2\2\u013c\u013b"+
		"\3\2\2\2\u013d\u0140\3\2\2\2\u013e\u013f\3\2\2\2\u013e\u013c\3\2\2\2\u013f"+
		"\u0141\3\2\2\2\u0140\u013e\3\2\2\2\u0141\u0142\7,\2\2\u0142\u0143\7\61"+
		"\2\2\u0143\u0144\3\2\2\2\u0144\u0145\b+\2\2\u0145V\3\2\2\2\u0146\u0147"+
		"\7\61\2\2\u0147\u0148\7\61\2\2\u0148\u014c\3\2\2\2\u0149\u014b\n\t\2\2"+
		"\u014a\u0149\3\2\2\2\u014b\u014e\3\2\2\2\u014c\u014a\3\2\2\2\u014c\u014d"+
		"\3\2\2\2\u014d\u014f\3\2\2\2\u014e\u014c\3\2\2\2\u014f\u0150\b,\2\2\u0150"+
		"X\3\2\2\2\17\2\u00b8\u00c3\u00f3\u00fb\u0105\u0119\u011f\u0125\u012f\u0134"+
		"\u013e\u014c\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}