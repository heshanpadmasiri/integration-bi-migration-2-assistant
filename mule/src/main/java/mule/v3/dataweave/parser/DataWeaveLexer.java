/*
 *  Copyright (c) 2025, WSO2 LLC. (http://www.wso2.com).
 *
 *  WSO2 LLC. licenses this file to you under the Apache License,
 *  Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */

// Generated from src/main/java/dataweave/parser/DataWeave.g4 by ANTLR 4.13.2
package mule.v3.dataweave.parser;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.LexerATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class DataWeaveLexer extends Lexer {
    static {
        RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION);
    }

    protected static final DFA[] _decisionToDFA;
    protected static final PredictionContextCache _sharedContextCache =
            new PredictionContextCache();
    public static final int
            T__0 = 1, T__1 = 2, T__2 = 3, T__3 = 4, T__4 = 5, T__5 = 6, T__6 = 7, T__7 = 8, T__8 = 9,
            T__9 = 10, T__10 = 11, T__11 = 12, T__12 = 13, T__13 = 14, T__14 = 15, T__15 = 16, VAR = 17,
            FUNCTION = 18, INPUT = 19, NAMESPACE = 20, OUTPUT = 21, DW = 22, ASSIGN = 23, ARROW = 24,
            BOOLEAN = 25, OPERATOR_EQUALITY = 26, OPERATOR_RELATIONAL = 27, OPERATOR_MULTIPLICATIVE = 28,
            OPERATOR_ADDITIVE = 29, OPERATOR_TYPE_COERCION = 30, OPERATOR_RANGE = 31, IDENTIFIER = 32,
            INDEX_IDENTIFIER = 33, VALUE_IDENTIFIER = 34, URL = 35, MEDIA_TYPE = 36, NUMBER = 37,
            STRING = 38, DATE = 39, REGEX = 40, DOT = 41, COLON = 42, COMMA = 43, LCURLY = 44, RCURLY = 45,
            LSQUARE = 46, RSQUARE = 47, SEPARATOR = 48, WS = 49, NEWLINE = 50, COMMENT = 51, STAR = 52,
            AT = 53, QUESTION = 54;
    public static String[] channelNames = {
            "DEFAULT_TOKEN_CHANNEL", "HIDDEN"
    };

    public static String[] modeNames = {
            "DEFAULT_MODE"
    };

    private static String[] makeRuleNames() {
        return new String[]{
                "T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8",
                "T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "VAR",
                "FUNCTION", "INPUT", "NAMESPACE", "OUTPUT", "DW", "ASSIGN", "ARROW",
                "BOOLEAN", "OPERATOR_EQUALITY", "OPERATOR_RELATIONAL", "OPERATOR_MULTIPLICATIVE",
                "OPERATOR_ADDITIVE", "OPERATOR_TYPE_COERCION", "OPERATOR_RANGE", "IDENTIFIER",
                "INDEX_IDENTIFIER", "VALUE_IDENTIFIER", "URL", "MEDIA_TYPE", "NUMBER",
                "STRING", "DATE", "REGEX", "DOT", "COLON", "COMMA", "LCURLY", "RCURLY",
                "LSQUARE", "RSQUARE", "SEPARATOR", "WS", "NEWLINE", "COMMENT", "STAR",
                "AT", "QUESTION"
        };
    }

    public static final String[] ruleNames = makeRuleNames();

    private static String[] makeLiteralNames() {
        return new String[]{
                null, "'('", "')'", "'when'", "'otherwise'", "'unless'", "'filter'",
                "'map'", "'groupBy'", "'replace'", "'with'", "'++'", "'or'", "'and'",
                "'sizeOf'", "'upper'", "'lower'", "'%var'", "'%function'", "'%input'",
                "'%namespace'", "'%output'", "'%dw'", "'='", "'->'", null, null, null,
                null, null, "'as'", "'..'", null, "'$$'", "'$'", null, null, null, null,
                null, null, "'.'", "':'", "','", "'{'", "'}'", "'['", "']'", "'---'",
                null, null, null, "'*'", "'@'", "'?'"
        };
    }

    private static final String[] _LITERAL_NAMES = makeLiteralNames();

    private static String[] makeSymbolicNames() {
        return new String[]{
                null, null, null, null, null, null, null, null, null, null, null, null,
                null, null, null, null, null, "VAR", "FUNCTION", "INPUT", "NAMESPACE",
                "OUTPUT", "DW", "ASSIGN", "ARROW", "BOOLEAN", "OPERATOR_EQUALITY", "OPERATOR_RELATIONAL",
                "OPERATOR_MULTIPLICATIVE", "OPERATOR_ADDITIVE", "OPERATOR_TYPE_COERCION",
                "OPERATOR_RANGE", "IDENTIFIER", "INDEX_IDENTIFIER", "VALUE_IDENTIFIER",
                "URL", "MEDIA_TYPE", "NUMBER", "STRING", "DATE", "REGEX", "DOT", "COLON",
                "COMMA", "LCURLY", "RCURLY", "LSQUARE", "RSQUARE", "SEPARATOR", "WS",
                "NEWLINE", "COMMENT", "STAR", "AT", "QUESTION"
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


    public DataWeaveLexer(CharStream input) {
        super(input);
        _interp = new LexerATNSimulator(this, _ATN, _decisionToDFA, _sharedContextCache);
    }

    @Override
    public String getGrammarFileName() {
        return "DataWeave.g4";
    }

    @Override
    public String[] getRuleNames() {
        return ruleNames;
    }

    @Override
    public String getSerializedATN() {
        return _serializedATN;
    }

    @Override
    public String[] getChannelNames() {
        return channelNames;
    }

    @Override
    public String[] getModeNames() {
        return modeNames;
    }

    @Override
    public ATN getATN() {
        return _ATN;
    }

    public static final String _serializedATN =
            "\u0004\u00006\u01a7\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001" +
                    "\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004" +
                    "\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007" +
                    "\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b" +
                    "\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002" +
                    "\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002" +
                    "\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002" +
                    "\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002" +
                    "\u0018\u0007\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002" +
                    "\u001b\u0007\u001b\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002" +
                    "\u001e\u0007\u001e\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007" +
                    "!\u0002\"\u0007\"\u0002#\u0007#\u0002$\u0007$\u0002%\u0007%\u0002&\u0007" +
                    "&\u0002\'\u0007\'\u0002(\u0007(\u0002)\u0007)\u0002*\u0007*\u0002+\u0007" +
                    "+\u0002,\u0007,\u0002-\u0007-\u0002.\u0007.\u0002/\u0007/\u00020\u0007" +
                    "0\u00021\u00071\u00022\u00072\u00023\u00073\u00024\u00074\u00025\u0007" +
                    "5\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002" +
                    "\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003" +
                    "\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003" +
                    "\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004" +
                    "\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005" +
                    "\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006" +
                    "\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007" +
                    "\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001" +
                    "\b\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001" +
                    "\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001\f" +
                    "\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001" +
                    "\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e" +
                    "\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f" +
                    "\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0011" +
                    "\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011" +
                    "\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0012" +
                    "\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013" +
                    "\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013" +
                    "\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0014\u0001\u0014\u0001\u0014" +
                    "\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0015" +
                    "\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0016\u0001\u0016\u0001\u0017" +
                    "\u0001\u0017\u0001\u0017\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018" +
                    "\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0003\u0018" +
                    "\u0100\b\u0018\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019" +
                    "\u0001\u0019\u0003\u0019\u0108\b\u0019\u0001\u001a\u0001\u001a\u0001\u001a" +
                    "\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0003\u001a\u0111\b\u001a" +
                    "\u0001\u001b\u0001\u001b\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c" +
                    "\u0003\u001c\u0119\b\u001c\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001e" +
                    "\u0001\u001e\u0001\u001e\u0001\u001f\u0001\u001f\u0005\u001f\u0123\b\u001f" +
                    "\n\u001f\f\u001f\u0126\t\u001f\u0001 \u0001 \u0001 \u0001!\u0001!\u0001" +
                    "\"\u0004\"\u012e\b\"\u000b\"\f\"\u012f\u0001\"\u0001\"\u0001\"\u0001\"" +
                    "\u0001\"\u0004\"\u0137\b\"\u000b\"\f\"\u0138\u0001#\u0004#\u013c\b#\u000b" +
                    "#\f#\u013d\u0001#\u0001#\u0004#\u0142\b#\u000b#\f#\u0143\u0001$\u0004" +
                    "$\u0147\b$\u000b$\f$\u0148\u0001$\u0001$\u0004$\u014d\b$\u000b$\f$\u014e" +
                    "\u0003$\u0151\b$\u0001%\u0001%\u0005%\u0155\b%\n%\f%\u0158\t%\u0001%\u0001" +
                    "%\u0001%\u0005%\u015d\b%\n%\f%\u0160\t%\u0001%\u0003%\u0163\b%\u0001&" +
                    "\u0001&\u0005&\u0167\b&\n&\f&\u016a\t&\u0001&\u0001&\u0001\'\u0001\'\u0005" +
                    "\'\u0170\b\'\n\'\f\'\u0173\t\'\u0001\'\u0001\'\u0001(\u0001(\u0001)\u0001" +
                    ")\u0001*\u0001*\u0001+\u0001+\u0001,\u0001,\u0001-\u0001-\u0001.\u0001" +
                    ".\u0001/\u0001/\u0001/\u0001/\u00010\u00040\u018a\b0\u000b0\f0\u018b\u0001" +
                    "0\u00010\u00011\u00041\u0191\b1\u000b1\f1\u0192\u00011\u00011\u00012\u0001" +
                    "2\u00012\u00012\u00052\u019b\b2\n2\f2\u019e\t2\u00012\u00012\u00013\u0001" +
                    "3\u00014\u00014\u00015\u00015\u0004\u0156\u015e\u0168\u0171\u00006\u0001" +
                    "\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007" +
                    "\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0019\r\u001b\u000e\u001d" +
                    "\u000f\u001f\u0010!\u0011#\u0012%\u0013\'\u0014)\u0015+\u0016-\u0017/" +
                    "\u00181\u00193\u001a5\u001b7\u001c9\u001d;\u001e=\u001f? A!C\"E#G$I%K" +
                    "&M\'O(Q)S*U+W,Y-[.]/_0a1c2e3g4i5k6\u0001\u0000\u000b\u0002\u0000<<>>\u0002" +
                    "\u0000**//\u0003\u0000AZ__az\u0004\u000009AZ__az\u0002\u0000AZaz\u0004" +
                    "\u0000-9AZ__az\u0001\u0000az\u0004\u0000++-.09az\u0001\u000009\u0002\u0000" +
                    "\t\t  \u0002\u0000\n\n\r\r\u01be\u0000\u0001\u0001\u0000\u0000\u0000\u0000" +
                    "\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000" +
                    "\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b" +
                    "\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001" +
                    "\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0013\u0001" +
                    "\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000\u0000\u0000\u0017\u0001" +
                    "\u0000\u0000\u0000\u0000\u0019\u0001\u0000\u0000\u0000\u0000\u001b\u0001" +
                    "\u0000\u0000\u0000\u0000\u001d\u0001\u0000\u0000\u0000\u0000\u001f\u0001" +
                    "\u0000\u0000\u0000\u0000!\u0001\u0000\u0000\u0000\u0000#\u0001\u0000\u0000" +
                    "\u0000\u0000%\u0001\u0000\u0000\u0000\u0000\'\u0001\u0000\u0000\u0000" +
                    "\u0000)\u0001\u0000\u0000\u0000\u0000+\u0001\u0000\u0000\u0000\u0000-" +
                    "\u0001\u0000\u0000\u0000\u0000/\u0001\u0000\u0000\u0000\u00001\u0001\u0000" +
                    "\u0000\u0000\u00003\u0001\u0000\u0000\u0000\u00005\u0001\u0000\u0000\u0000" +
                    "\u00007\u0001\u0000\u0000\u0000\u00009\u0001\u0000\u0000\u0000\u0000;" +
                    "\u0001\u0000\u0000\u0000\u0000=\u0001\u0000\u0000\u0000\u0000?\u0001\u0000" +
                    "\u0000\u0000\u0000A\u0001\u0000\u0000\u0000\u0000C\u0001\u0000\u0000\u0000" +
                    "\u0000E\u0001\u0000\u0000\u0000\u0000G\u0001\u0000\u0000\u0000\u0000I" +
                    "\u0001\u0000\u0000\u0000\u0000K\u0001\u0000\u0000\u0000\u0000M\u0001\u0000" +
                    "\u0000\u0000\u0000O\u0001\u0000\u0000\u0000\u0000Q\u0001\u0000\u0000\u0000" +
                    "\u0000S\u0001\u0000\u0000\u0000\u0000U\u0001\u0000\u0000\u0000\u0000W" +
                    "\u0001\u0000\u0000\u0000\u0000Y\u0001\u0000\u0000\u0000\u0000[\u0001\u0000" +
                    "\u0000\u0000\u0000]\u0001\u0000\u0000\u0000\u0000_\u0001\u0000\u0000\u0000" +
                    "\u0000a\u0001\u0000\u0000\u0000\u0000c\u0001\u0000\u0000\u0000\u0000e" +
                    "\u0001\u0000\u0000\u0000\u0000g\u0001\u0000\u0000\u0000\u0000i\u0001\u0000" +
                    "\u0000\u0000\u0000k\u0001\u0000\u0000\u0000\u0001m\u0001\u0000\u0000\u0000" +
                    "\u0003o\u0001\u0000\u0000\u0000\u0005q\u0001\u0000\u0000\u0000\u0007v" +
                    "\u0001\u0000\u0000\u0000\t\u0080\u0001\u0000\u0000\u0000\u000b\u0087\u0001" +
                    "\u0000\u0000\u0000\r\u008e\u0001\u0000\u0000\u0000\u000f\u0092\u0001\u0000" +
                    "\u0000\u0000\u0011\u009a\u0001\u0000\u0000\u0000\u0013\u00a2\u0001\u0000" +
                    "\u0000\u0000\u0015\u00a7\u0001\u0000\u0000\u0000\u0017\u00aa\u0001\u0000" +
                    "\u0000\u0000\u0019\u00ad\u0001\u0000\u0000\u0000\u001b\u00b1\u0001\u0000" +
                    "\u0000\u0000\u001d\u00b8\u0001\u0000\u0000\u0000\u001f\u00be\u0001\u0000" +
                    "\u0000\u0000!\u00c4\u0001\u0000\u0000\u0000#\u00c9\u0001\u0000\u0000\u0000" +
                    "%\u00d3\u0001\u0000\u0000\u0000\'\u00da\u0001\u0000\u0000\u0000)\u00e5" +
                    "\u0001\u0000\u0000\u0000+\u00ed\u0001\u0000\u0000\u0000-\u00f1\u0001\u0000" +
                    "\u0000\u0000/\u00f3\u0001\u0000\u0000\u00001\u00ff\u0001\u0000\u0000\u0000" +
                    "3\u0107\u0001\u0000\u0000\u00005\u0110\u0001\u0000\u0000\u00007\u0112" +
                    "\u0001\u0000\u0000\u00009\u0118\u0001\u0000\u0000\u0000;\u011a\u0001\u0000" +
                    "\u0000\u0000=\u011d\u0001\u0000\u0000\u0000?\u0120\u0001\u0000\u0000\u0000" +
                    "A\u0127\u0001\u0000\u0000\u0000C\u012a\u0001\u0000\u0000\u0000E\u012d" +
                    "\u0001\u0000\u0000\u0000G\u013b\u0001\u0000\u0000\u0000I\u0146\u0001\u0000" +
                    "\u0000\u0000K\u0162\u0001\u0000\u0000\u0000M\u0164\u0001\u0000\u0000\u0000" +
                    "O\u016d\u0001\u0000\u0000\u0000Q\u0176\u0001\u0000\u0000\u0000S\u0178" +
                    "\u0001\u0000\u0000\u0000U\u017a\u0001\u0000\u0000\u0000W\u017c\u0001\u0000" +
                    "\u0000\u0000Y\u017e\u0001\u0000\u0000\u0000[\u0180\u0001\u0000\u0000\u0000" +
                    "]\u0182\u0001\u0000\u0000\u0000_\u0184\u0001\u0000\u0000\u0000a\u0189" +
                    "\u0001\u0000\u0000\u0000c\u0190\u0001\u0000\u0000\u0000e\u0196\u0001\u0000" +
                    "\u0000\u0000g\u01a1\u0001\u0000\u0000\u0000i\u01a3\u0001\u0000\u0000\u0000" +
                    "k\u01a5\u0001\u0000\u0000\u0000mn\u0005(\u0000\u0000n\u0002\u0001\u0000" +
                    "\u0000\u0000op\u0005)\u0000\u0000p\u0004\u0001\u0000\u0000\u0000qr\u0005" +
                    "w\u0000\u0000rs\u0005h\u0000\u0000st\u0005e\u0000\u0000tu\u0005n\u0000" +
                    "\u0000u\u0006\u0001\u0000\u0000\u0000vw\u0005o\u0000\u0000wx\u0005t\u0000" +
                    "\u0000xy\u0005h\u0000\u0000yz\u0005e\u0000\u0000z{\u0005r\u0000\u0000" +
                    "{|\u0005w\u0000\u0000|}\u0005i\u0000\u0000}~\u0005s\u0000\u0000~\u007f" +
                    "\u0005e\u0000\u0000\u007f\b\u0001\u0000\u0000\u0000\u0080\u0081\u0005" +
                    "u\u0000\u0000\u0081\u0082\u0005n\u0000\u0000\u0082\u0083\u0005l\u0000" +
                    "\u0000\u0083\u0084\u0005e\u0000\u0000\u0084\u0085\u0005s\u0000\u0000\u0085" +
                    "\u0086\u0005s\u0000\u0000\u0086\n\u0001\u0000\u0000\u0000\u0087\u0088" +
                    "\u0005f\u0000\u0000\u0088\u0089\u0005i\u0000\u0000\u0089\u008a\u0005l" +
                    "\u0000\u0000\u008a\u008b\u0005t\u0000\u0000\u008b\u008c\u0005e\u0000\u0000" +
                    "\u008c\u008d\u0005r\u0000\u0000\u008d\f\u0001\u0000\u0000\u0000\u008e" +
                    "\u008f\u0005m\u0000\u0000\u008f\u0090\u0005a\u0000\u0000\u0090\u0091\u0005" +
                    "p\u0000\u0000\u0091\u000e\u0001\u0000\u0000\u0000\u0092\u0093\u0005g\u0000" +
                    "\u0000\u0093\u0094\u0005r\u0000\u0000\u0094\u0095\u0005o\u0000\u0000\u0095" +
                    "\u0096\u0005u\u0000\u0000\u0096\u0097\u0005p\u0000\u0000\u0097\u0098\u0005" +
                    "B\u0000\u0000\u0098\u0099\u0005y\u0000\u0000\u0099\u0010\u0001\u0000\u0000" +
                    "\u0000\u009a\u009b\u0005r\u0000\u0000\u009b\u009c\u0005e\u0000\u0000\u009c" +
                    "\u009d\u0005p\u0000\u0000\u009d\u009e\u0005l\u0000\u0000\u009e\u009f\u0005" +
                    "a\u0000\u0000\u009f\u00a0\u0005c\u0000\u0000\u00a0\u00a1\u0005e\u0000" +
                    "\u0000\u00a1\u0012\u0001\u0000\u0000\u0000\u00a2\u00a3\u0005w\u0000\u0000" +
                    "\u00a3\u00a4\u0005i\u0000\u0000\u00a4\u00a5\u0005t\u0000\u0000\u00a5\u00a6" +
                    "\u0005h\u0000\u0000\u00a6\u0014\u0001\u0000\u0000\u0000\u00a7\u00a8\u0005" +
                    "+\u0000\u0000\u00a8\u00a9\u0005+\u0000\u0000\u00a9\u0016\u0001\u0000\u0000" +
                    "\u0000\u00aa\u00ab\u0005o\u0000\u0000\u00ab\u00ac\u0005r\u0000\u0000\u00ac" +
                    "\u0018\u0001\u0000\u0000\u0000\u00ad\u00ae\u0005a\u0000\u0000\u00ae\u00af" +
                    "\u0005n\u0000\u0000\u00af\u00b0\u0005d\u0000\u0000\u00b0\u001a\u0001\u0000" +
                    "\u0000\u0000\u00b1\u00b2\u0005s\u0000\u0000\u00b2\u00b3\u0005i\u0000\u0000" +
                    "\u00b3\u00b4\u0005z\u0000\u0000\u00b4\u00b5\u0005e\u0000\u0000\u00b5\u00b6" +
                    "\u0005O\u0000\u0000\u00b6\u00b7\u0005f\u0000\u0000\u00b7\u001c\u0001\u0000" +
                    "\u0000\u0000\u00b8\u00b9\u0005u\u0000\u0000\u00b9\u00ba\u0005p\u0000\u0000" +
                    "\u00ba\u00bb\u0005p\u0000\u0000\u00bb\u00bc\u0005e\u0000\u0000\u00bc\u00bd" +
                    "\u0005r\u0000\u0000\u00bd\u001e\u0001\u0000\u0000\u0000\u00be\u00bf\u0005" +
                    "l\u0000\u0000\u00bf\u00c0\u0005o\u0000\u0000\u00c0\u00c1\u0005w\u0000" +
                    "\u0000\u00c1\u00c2\u0005e\u0000\u0000\u00c2\u00c3\u0005r\u0000\u0000\u00c3" +
                    " \u0001\u0000\u0000\u0000\u00c4\u00c5\u0005%\u0000\u0000\u00c5\u00c6\u0005" +
                    "v\u0000\u0000\u00c6\u00c7\u0005a\u0000\u0000\u00c7\u00c8\u0005r\u0000" +
                    "\u0000\u00c8\"\u0001\u0000\u0000\u0000\u00c9\u00ca\u0005%\u0000\u0000" +
                    "\u00ca\u00cb\u0005f\u0000\u0000\u00cb\u00cc\u0005u\u0000\u0000\u00cc\u00cd" +
                    "\u0005n\u0000\u0000\u00cd\u00ce\u0005c\u0000\u0000\u00ce\u00cf\u0005t" +
                    "\u0000\u0000\u00cf\u00d0\u0005i\u0000\u0000\u00d0\u00d1\u0005o\u0000\u0000" +
                    "\u00d1\u00d2\u0005n\u0000\u0000\u00d2$\u0001\u0000\u0000\u0000\u00d3\u00d4" +
                    "\u0005%\u0000\u0000\u00d4\u00d5\u0005i\u0000\u0000\u00d5\u00d6\u0005n" +
                    "\u0000\u0000\u00d6\u00d7\u0005p\u0000\u0000\u00d7\u00d8\u0005u\u0000\u0000" +
                    "\u00d8\u00d9\u0005t\u0000\u0000\u00d9&\u0001\u0000\u0000\u0000\u00da\u00db" +
                    "\u0005%\u0000\u0000\u00db\u00dc\u0005n\u0000\u0000\u00dc\u00dd\u0005a" +
                    "\u0000\u0000\u00dd\u00de\u0005m\u0000\u0000\u00de\u00df\u0005e\u0000\u0000" +
                    "\u00df\u00e0\u0005s\u0000\u0000\u00e0\u00e1\u0005p\u0000\u0000\u00e1\u00e2" +
                    "\u0005a\u0000\u0000\u00e2\u00e3\u0005c\u0000\u0000\u00e3\u00e4\u0005e" +
                    "\u0000\u0000\u00e4(\u0001\u0000\u0000\u0000\u00e5\u00e6\u0005%\u0000\u0000" +
                    "\u00e6\u00e7\u0005o\u0000\u0000\u00e7\u00e8\u0005u\u0000\u0000\u00e8\u00e9" +
                    "\u0005t\u0000\u0000\u00e9\u00ea\u0005p\u0000\u0000\u00ea\u00eb\u0005u" +
                    "\u0000\u0000\u00eb\u00ec\u0005t\u0000\u0000\u00ec*\u0001\u0000\u0000\u0000" +
                    "\u00ed\u00ee\u0005%\u0000\u0000\u00ee\u00ef\u0005d\u0000\u0000\u00ef\u00f0" +
                    "\u0005w\u0000\u0000\u00f0,\u0001\u0000\u0000\u0000\u00f1\u00f2\u0005=" +
                    "\u0000\u0000\u00f2.\u0001\u0000\u0000\u0000\u00f3\u00f4\u0005-\u0000\u0000" +
                    "\u00f4\u00f5\u0005>\u0000\u0000\u00f50\u0001\u0000\u0000\u0000\u00f6\u00f7" +
                    "\u0005t\u0000\u0000\u00f7\u00f8\u0005r\u0000\u0000\u00f8\u00f9\u0005u" +
                    "\u0000\u0000\u00f9\u0100\u0005e\u0000\u0000\u00fa\u00fb\u0005f\u0000\u0000" +
                    "\u00fb\u00fc\u0005a\u0000\u0000\u00fc\u00fd\u0005l\u0000\u0000\u00fd\u00fe" +
                    "\u0005s\u0000\u0000\u00fe\u0100\u0005e\u0000\u0000\u00ff\u00f6\u0001\u0000" +
                    "\u0000\u0000\u00ff\u00fa\u0001\u0000\u0000\u0000\u01002\u0001\u0000\u0000" +
                    "\u0000\u0101\u0102\u0005=\u0000\u0000\u0102\u0108\u0005=\u0000\u0000\u0103" +
                    "\u0104\u0005!\u0000\u0000\u0104\u0108\u0005=\u0000\u0000\u0105\u0106\u0005" +
                    "~\u0000\u0000\u0106\u0108\u0005=\u0000\u0000\u0107\u0101\u0001\u0000\u0000" +
                    "\u0000\u0107\u0103\u0001\u0000\u0000\u0000\u0107\u0105\u0001\u0000\u0000" +
                    "\u0000\u01084\u0001\u0000\u0000\u0000\u0109\u0111\u0007\u0000\u0000\u0000" +
                    "\u010a\u010b\u0005>\u0000\u0000\u010b\u0111\u0005=\u0000\u0000\u010c\u010d" +
                    "\u0005<\u0000\u0000\u010d\u0111\u0005=\u0000\u0000\u010e\u010f\u0005i" +
                    "\u0000\u0000\u010f\u0111\u0005s\u0000\u0000\u0110\u0109\u0001\u0000\u0000" +
                    "\u0000\u0110\u010a\u0001\u0000\u0000\u0000\u0110\u010c\u0001\u0000\u0000" +
                    "\u0000\u0110\u010e\u0001\u0000\u0000\u0000\u01116\u0001\u0000\u0000\u0000" +
                    "\u0112\u0113\u0007\u0001\u0000\u0000\u01138\u0001\u0000\u0000\u0000\u0114" +
                    "\u0119\u0005+\u0000\u0000\u0115\u0116\u0005>\u0000\u0000\u0116\u0119\u0005" +
                    ">\u0000\u0000\u0117\u0119\u0005-\u0000\u0000\u0118\u0114\u0001\u0000\u0000" +
                    "\u0000\u0118\u0115\u0001\u0000\u0000\u0000\u0118\u0117\u0001\u0000\u0000" +
                    "\u0000\u0119:\u0001\u0000\u0000\u0000\u011a\u011b\u0005a\u0000\u0000\u011b" +
                    "\u011c\u0005s\u0000\u0000\u011c<\u0001\u0000\u0000\u0000\u011d\u011e\u0005" +
                    ".\u0000\u0000\u011e\u011f\u0005.\u0000\u0000\u011f>\u0001\u0000\u0000" +
                    "\u0000\u0120\u0124\u0007\u0002\u0000\u0000\u0121\u0123\u0007\u0003\u0000" +
                    "\u0000\u0122\u0121\u0001\u0000\u0000\u0000\u0123\u0126\u0001\u0000\u0000" +
                    "\u0000\u0124\u0122\u0001\u0000\u0000\u0000\u0124\u0125\u0001\u0000\u0000" +
                    "\u0000\u0125@\u0001\u0000\u0000\u0000\u0126\u0124\u0001\u0000\u0000\u0000" +
                    "\u0127\u0128\u0005$\u0000\u0000\u0128\u0129\u0005$\u0000\u0000\u0129B" +
                    "\u0001\u0000\u0000\u0000\u012a\u012b\u0005$\u0000\u0000\u012bD\u0001\u0000" +
                    "\u0000\u0000\u012c\u012e\u0007\u0004\u0000\u0000\u012d\u012c\u0001\u0000" +
                    "\u0000\u0000\u012e\u012f\u0001\u0000\u0000\u0000\u012f\u012d\u0001\u0000" +
                    "\u0000\u0000\u012f\u0130\u0001\u0000\u0000\u0000\u0130\u0131\u0001\u0000" +
                    "\u0000\u0000\u0131\u0132\u0005:\u0000\u0000\u0132\u0133\u0005/\u0000\u0000" +
                    "\u0133\u0134\u0005/\u0000\u0000\u0134\u0136\u0001\u0000\u0000\u0000\u0135" +
                    "\u0137\u0007\u0005\u0000\u0000\u0136\u0135\u0001\u0000\u0000\u0000\u0137" +
                    "\u0138\u0001\u0000\u0000\u0000\u0138\u0136\u0001\u0000\u0000\u0000\u0138" +
                    "\u0139\u0001\u0000\u0000\u0000\u0139F\u0001\u0000\u0000\u0000\u013a\u013c" +
                    "\u0007\u0006\u0000\u0000\u013b\u013a\u0001\u0000\u0000\u0000\u013c\u013d" +
                    "\u0001\u0000\u0000\u0000\u013d\u013b\u0001\u0000\u0000\u0000\u013d\u013e" +
                    "\u0001\u0000\u0000\u0000\u013e\u013f\u0001\u0000\u0000\u0000\u013f\u0141" +
                    "\u0005/\u0000\u0000\u0140\u0142\u0007\u0007\u0000\u0000\u0141\u0140\u0001" +
                    "\u0000\u0000\u0000\u0142\u0143\u0001\u0000\u0000\u0000\u0143\u0141\u0001" +
                    "\u0000\u0000\u0000\u0143\u0144\u0001\u0000\u0000\u0000\u0144H\u0001\u0000" +
                    "\u0000\u0000\u0145\u0147\u0007\b\u0000\u0000\u0146\u0145\u0001\u0000\u0000" +
                    "\u0000\u0147\u0148\u0001\u0000\u0000\u0000\u0148\u0146\u0001\u0000\u0000" +
                    "\u0000\u0148\u0149\u0001\u0000\u0000\u0000\u0149\u0150\u0001\u0000\u0000" +
                    "\u0000\u014a\u014c\u0005.\u0000\u0000\u014b\u014d\u0007\b\u0000\u0000" +
                    "\u014c\u014b\u0001\u0000\u0000\u0000\u014d\u014e\u0001\u0000\u0000\u0000" +
                    "\u014e\u014c\u0001\u0000\u0000\u0000\u014e\u014f\u0001\u0000\u0000\u0000" +
                    "\u014f\u0151\u0001\u0000\u0000\u0000\u0150\u014a\u0001\u0000\u0000\u0000" +
                    "\u0150\u0151\u0001\u0000\u0000\u0000\u0151J\u0001\u0000\u0000\u0000\u0152" +
                    "\u0156\u0005\"\u0000\u0000\u0153\u0155\t\u0000\u0000\u0000\u0154\u0153" +
                    "\u0001\u0000\u0000\u0000\u0155\u0158\u0001\u0000\u0000\u0000\u0156\u0157" +
                    "\u0001\u0000\u0000\u0000\u0156\u0154\u0001\u0000\u0000\u0000\u0157\u0159" +
                    "\u0001\u0000\u0000\u0000\u0158\u0156\u0001\u0000\u0000\u0000\u0159\u0163" +
                    "\u0005\"\u0000\u0000\u015a\u015e\u0005\'\u0000\u0000\u015b\u015d\t\u0000" +
                    "\u0000\u0000\u015c\u015b\u0001\u0000\u0000\u0000\u015d\u0160\u0001\u0000" +
                    "\u0000\u0000\u015e\u015f\u0001\u0000\u0000\u0000\u015e\u015c\u0001\u0000" +
                    "\u0000\u0000\u015f\u0161\u0001\u0000\u0000\u0000\u0160\u015e\u0001\u0000" +
                    "\u0000\u0000\u0161\u0163\u0005\'\u0000\u0000\u0162\u0152\u0001\u0000\u0000" +
                    "\u0000\u0162\u015a\u0001\u0000\u0000\u0000\u0163L\u0001\u0000\u0000\u0000" +
                    "\u0164\u0168\u0005|\u0000\u0000\u0165\u0167\t\u0000\u0000\u0000\u0166" +
                    "\u0165\u0001\u0000\u0000\u0000\u0167\u016a\u0001\u0000\u0000\u0000\u0168" +
                    "\u0169\u0001\u0000\u0000\u0000\u0168\u0166\u0001\u0000\u0000\u0000\u0169" +
                    "\u016b\u0001\u0000\u0000\u0000\u016a\u0168\u0001\u0000\u0000\u0000\u016b" +
                    "\u016c\u0005|\u0000\u0000\u016cN\u0001\u0000\u0000\u0000\u016d\u0171\u0005" +
                    "/\u0000\u0000\u016e\u0170\t\u0000\u0000\u0000\u016f\u016e\u0001\u0000" +
                    "\u0000\u0000\u0170\u0173\u0001\u0000\u0000\u0000\u0171\u0172\u0001\u0000" +
                    "\u0000\u0000\u0171\u016f\u0001\u0000\u0000\u0000\u0172\u0174\u0001\u0000" +
                    "\u0000\u0000\u0173\u0171\u0001\u0000\u0000\u0000\u0174\u0175\u0005/\u0000" +
                    "\u0000\u0175P\u0001\u0000\u0000\u0000\u0176\u0177\u0005.\u0000\u0000\u0177" +
                    "R\u0001\u0000\u0000\u0000\u0178\u0179\u0005:\u0000\u0000\u0179T\u0001" +
                    "\u0000\u0000\u0000\u017a\u017b\u0005,\u0000\u0000\u017bV\u0001\u0000\u0000" +
                    "\u0000\u017c\u017d\u0005{\u0000\u0000\u017dX\u0001\u0000\u0000\u0000\u017e" +
                    "\u017f\u0005}\u0000\u0000\u017fZ\u0001\u0000\u0000\u0000\u0180\u0181\u0005" +
                    "[\u0000\u0000\u0181\\\u0001\u0000\u0000\u0000\u0182\u0183\u0005]\u0000" +
                    "\u0000\u0183^\u0001\u0000\u0000\u0000\u0184\u0185\u0005-\u0000\u0000\u0185" +
                    "\u0186\u0005-\u0000\u0000\u0186\u0187\u0005-\u0000\u0000\u0187`\u0001" +
                    "\u0000\u0000\u0000\u0188\u018a\u0007\t\u0000\u0000\u0189\u0188\u0001\u0000" +
                    "\u0000\u0000\u018a\u018b\u0001\u0000\u0000\u0000\u018b\u0189\u0001\u0000" +
                    "\u0000\u0000\u018b\u018c\u0001\u0000\u0000\u0000\u018c\u018d\u0001\u0000" +
                    "\u0000\u0000\u018d\u018e\u00060\u0000\u0000\u018eb\u0001\u0000\u0000\u0000" +
                    "\u018f\u0191\u0007\n\u0000\u0000\u0190\u018f\u0001\u0000\u0000\u0000\u0191" +
                    "\u0192\u0001\u0000\u0000\u0000\u0192\u0190\u0001\u0000\u0000\u0000\u0192" +
                    "\u0193\u0001\u0000\u0000\u0000\u0193\u0194\u0001\u0000\u0000\u0000\u0194" +
                    "\u0195\u00061\u0000\u0000\u0195d\u0001\u0000\u0000\u0000\u0196\u0197\u0005" +
                    "/\u0000\u0000\u0197\u0198\u0005/\u0000\u0000\u0198\u019c\u0001\u0000\u0000" +
                    "\u0000\u0199\u019b\b\n\u0000\u0000\u019a\u0199\u0001\u0000\u0000\u0000" +
                    "\u019b\u019e\u0001\u0000\u0000\u0000\u019c\u019a\u0001\u0000\u0000\u0000" +
                    "\u019c\u019d\u0001\u0000\u0000\u0000\u019d\u019f\u0001\u0000\u0000\u0000" +
                    "\u019e\u019c\u0001\u0000\u0000\u0000\u019f\u01a0\u00062\u0000\u0000\u01a0" +
                    "f\u0001\u0000\u0000\u0000\u01a1\u01a2\u0005*\u0000\u0000\u01a2h\u0001" +
                    "\u0000\u0000\u0000\u01a3\u01a4\u0005@\u0000\u0000\u01a4j\u0001\u0000\u0000" +
                    "\u0000\u01a5\u01a6\u0005?\u0000\u0000\u01a6l\u0001\u0000\u0000\u0000\u0015" +
                    "\u0000\u00ff\u0107\u0110\u0118\u0124\u012f\u0138\u013d\u0143\u0148\u014e" +
                    "\u0150\u0156\u015e\u0162\u0168\u0171\u018b\u0192\u019c\u0001\u0006\u0000" +
                    "\u0000";
    public static final ATN _ATN =
            new ATNDeserializer().deserialize(_serializedATN.toCharArray());

    static {
        _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
        for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
            _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
        }
    }
}
