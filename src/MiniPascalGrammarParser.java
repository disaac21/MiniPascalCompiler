// Generated from C:/Users/danie/Desktop/MiniPascalCompiler/MiniPascalGrammar.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class MiniPascalGrammarParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		BEGIN=1, END=2, WS=3, COMMENT=4, INTEGER=5, BOOLEAN=6, CHAR=7, STRING=8, 
		ASSIGN=9, PLUS=10, MINUS=11, DIV=12, MULT=13, MOD=14, AND=15, NOT=16, 
		OR=17, GT=18, LT=19, LE=20, GE=21, EQUAL=22, NOT_EQUAL=23, L_PAREN=24, 
		R_PAREN=25, L_BRACK=26, R_BRACK=27, COMMA=28, SEMICOLON=29, COLON=30, 
		DOT=31, DOUBLE_DOT=32, PROGRAM=33, FUNCTION=34, PROCEDURE=35, IF=36, THEN=37, 
		ELSE=38, UNTIL=39, WHILE=40, FOR=41, REPEAT=42, TO=43, DO=44, DOWNTO=45, 
		VAR=46, OVERLOAD=47, ARRAY=48, OF=49, INTEGER_=50, BOOLEAN_=51, CHAR_=52, 
		STRING_=53, READLN=54, READ=55, WRITELN=56, WRITE=57, NIL=58, INTERFACE=59, 
		IMPLEMENTATION=60, CONST=61, ID=62, CHR=63, TYPE=64, AT=65;
	public static final int
		RULE_program = 0, RULE_programHeading = 1, RULE_identifier = 2, RULE_block = 3, 
		RULE_constantDefinitionPart = 4, RULE_constantDefinition = 5, RULE_constantChr = 6, 
		RULE_constant = 7, RULE_varType = 8, RULE_arrayType = 9, RULE_arrayOfType = 10, 
		RULE_arrayValue = 11, RULE_indexRanges = 12, RULE_indexRange = 13, RULE_stringR_ = 14, 
		RULE_charR_ = 15, RULE_integerR_ = 16, RULE_booleanR_ = 17, RULE_unsignedNumber = 18, 
		RULE_unsignedInteger = 19, RULE_sign = 20, RULE_bool_ = 21, RULE_string = 22, 
		RULE_boolean = 23, RULE_char = 24, RULE_integer = 25, RULE_typeDefinitionPart = 26, 
		RULE_typeDefinition = 27, RULE_functionType = 28, RULE_procedureType = 29, 
		RULE_type_ = 30, RULE_simpleType = 31, RULE_scalarType = 32, RULE_subrangeType = 33, 
		RULE_typeIdentifier = 34, RULE_stringtype = 35, RULE_typeList = 36, RULE_indexType = 37, 
		RULE_componentType = 38, RULE_fixedPart = 39, RULE_recordSection = 40, 
		RULE_tag = 41, RULE_baseType = 42, RULE_variableDeclarationPart = 43, 
		RULE_variableDeclaration = 44, RULE_procedureAndFunctionDeclarationPart = 45, 
		RULE_procedureOrFunctionDeclaration = 46, RULE_formalParameterList = 47, 
		RULE_formalParameterSection = 48, RULE_parameterGroup = 49, RULE_identifierList = 50, 
		RULE_constList = 51, RULE_functionDeclaration = 52, RULE_procedureDeclaration = 53, 
		RULE_resultType = 54, RULE_statement = 55, RULE_writeStatement = 56, RULE_write = 57, 
		RULE_writeParam = 58, RULE_varValue = 59, RULE_readStatement = 60, RULE_read = 61, 
		RULE_readParam = 62, RULE_unlabelledStatement = 63, RULE_simpleStatement = 64, 
		RULE_assignmentStatement = 65, RULE_variable = 66, RULE_expressionList = 67, 
		RULE_expression = 68, RULE_relationaloperator = 69, RULE_simpleExpression = 70, 
		RULE_additiveoperator = 71, RULE_term = 72, RULE_multiplicativeoperator = 73, 
		RULE_signedFactor = 74, RULE_factor = 75, RULE_unsignedConstant = 76, 
		RULE_functionDesignator = 77, RULE_parameterList = 78, RULE_set_ = 79, 
		RULE_elementList = 80, RULE_element = 81, RULE_actualParameter = 82, RULE_parameterwidth = 83, 
		RULE_emptyStatement_ = 84, RULE_structuredStatement = 85, RULE_compoundStatement = 86, 
		RULE_statements = 87, RULE_conditionalStatement = 88, RULE_ifStatement = 89, 
		RULE_repetitiveStatement = 90, RULE_whileStatement = 91, RULE_repeatStatement = 92, 
		RULE_forStatement = 93, RULE_forList = 94, RULE_initialValue = 95, RULE_arrayInitialization = 96, 
		RULE_finalValue = 97;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "programHeading", "identifier", "block", "constantDefinitionPart", 
			"constantDefinition", "constantChr", "constant", "varType", "arrayType", 
			"arrayOfType", "arrayValue", "indexRanges", "indexRange", "stringR_", 
			"charR_", "integerR_", "booleanR_", "unsignedNumber", "unsignedInteger", 
			"sign", "bool_", "string", "boolean", "char", "integer", "typeDefinitionPart", 
			"typeDefinition", "functionType", "procedureType", "type_", "simpleType", 
			"scalarType", "subrangeType", "typeIdentifier", "stringtype", "typeList", 
			"indexType", "componentType", "fixedPart", "recordSection", "tag", "baseType", 
			"variableDeclarationPart", "variableDeclaration", "procedureAndFunctionDeclarationPart", 
			"procedureOrFunctionDeclaration", "formalParameterList", "formalParameterSection", 
			"parameterGroup", "identifierList", "constList", "functionDeclaration", 
			"procedureDeclaration", "resultType", "statement", "writeStatement", 
			"write", "writeParam", "varValue", "readStatement", "read", "readParam", 
			"unlabelledStatement", "simpleStatement", "assignmentStatement", "variable", 
			"expressionList", "expression", "relationaloperator", "simpleExpression", 
			"additiveoperator", "term", "multiplicativeoperator", "signedFactor", 
			"factor", "unsignedConstant", "functionDesignator", "parameterList", 
			"set_", "elementList", "element", "actualParameter", "parameterwidth", 
			"emptyStatement_", "structuredStatement", "compoundStatement", "statements", 
			"conditionalStatement", "ifStatement", "repetitiveStatement", "whileStatement", 
			"repeatStatement", "forStatement", "forList", "initialValue", "arrayInitialization", 
			"finalValue"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'begin'", "'end'", null, null, null, null, null, null, "':='", 
			"'+'", "'-'", null, "'*'", "'mod'", "'and'", "'not'", "'or'", "'>'", 
			"'<'", "'<='", "'>='", "'='", "'<>'", "'('", "')'", "'['", "']'", "','", 
			"';'", "':'", "'.'", "'..'", "'program'", "'function'", "'procedure'", 
			"'if'", "'then'", "'else'", "'until'", "'while'", "'for'", "'repeat'", 
			"'to'", "'do'", "'downto'", "'var'", "'overload'", "'Array'", "'of'", 
			"'INTEGER'", "'BOOLEAN'", "'CHAR'", "'STRING'", "'READLN'", "'READ'", 
			"'WRITELN'", "'WRITE'", "'NIL'", "'INTERFACE'", "'IMPLEMENTATION'", "'CONST'", 
			null, "'CHR'", "'TYPE'", "'AT'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "BEGIN", "END", "WS", "COMMENT", "INTEGER", "BOOLEAN", "CHAR", 
			"STRING", "ASSIGN", "PLUS", "MINUS", "DIV", "MULT", "MOD", "AND", "NOT", 
			"OR", "GT", "LT", "LE", "GE", "EQUAL", "NOT_EQUAL", "L_PAREN", "R_PAREN", 
			"L_BRACK", "R_BRACK", "COMMA", "SEMICOLON", "COLON", "DOT", "DOUBLE_DOT", 
			"PROGRAM", "FUNCTION", "PROCEDURE", "IF", "THEN", "ELSE", "UNTIL", "WHILE", 
			"FOR", "REPEAT", "TO", "DO", "DOWNTO", "VAR", "OVERLOAD", "ARRAY", "OF", 
			"INTEGER_", "BOOLEAN_", "CHAR_", "STRING_", "READLN", "READ", "WRITELN", 
			"WRITE", "NIL", "INTERFACE", "IMPLEMENTATION", "CONST", "ID", "CHR", 
			"TYPE", "AT"
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
	public String getGrammarFileName() { return "MiniPascalGrammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public MiniPascalGrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public ProgramHeadingContext programHeading() {
			return getRuleContext(ProgramHeadingContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode DOT() { return getToken(MiniPascalGrammarParser.DOT, 0); }
		public TerminalNode EOF() { return getToken(MiniPascalGrammarParser.EOF, 0); }
		public TerminalNode INTERFACE() { return getToken(MiniPascalGrammarParser.INTERFACE, 0); }
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPascalGrammarVisitor ) return ((MiniPascalGrammarVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(196);
			programHeading();
			setState(198);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==INTERFACE) {
				{
				setState(197);
				match(INTERFACE);
				}
			}

			setState(200);
			block();
			setState(201);
			match(DOT);
			setState(202);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramHeadingContext extends ParserRuleContext {
		public TerminalNode PROGRAM() { return getToken(MiniPascalGrammarParser.PROGRAM, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(MiniPascalGrammarParser.SEMICOLON, 0); }
		public TerminalNode L_PAREN() { return getToken(MiniPascalGrammarParser.L_PAREN, 0); }
		public IdentifierListContext identifierList() {
			return getRuleContext(IdentifierListContext.class,0);
		}
		public TerminalNode R_PAREN() { return getToken(MiniPascalGrammarParser.R_PAREN, 0); }
		public TerminalNode PROCEDURE() { return getToken(MiniPascalGrammarParser.PROCEDURE, 0); }
		public TerminalNode FUNCTION() { return getToken(MiniPascalGrammarParser.FUNCTION, 0); }
		public ProgramHeadingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_programHeading; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).enterProgramHeading(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).exitProgramHeading(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPascalGrammarVisitor ) return ((MiniPascalGrammarVisitor<? extends T>)visitor).visitProgramHeading(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramHeadingContext programHeading() throws RecognitionException {
		ProgramHeadingContext _localctx = new ProgramHeadingContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_programHeading);
		int _la;
		try {
			setState(216);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PROGRAM:
				enterOuterAlt(_localctx, 1);
				{
				setState(204);
				match(PROGRAM);
				setState(205);
				identifier();
				setState(210);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==L_PAREN) {
					{
					setState(206);
					match(L_PAREN);
					setState(207);
					identifierList();
					setState(208);
					match(R_PAREN);
					}
				}

				setState(212);
				match(SEMICOLON);
				}
				break;
			case PROCEDURE:
				enterOuterAlt(_localctx, 2);
				{
				setState(214);
				match(PROCEDURE);
				}
				break;
			case FUNCTION:
				enterOuterAlt(_localctx, 3);
				{
				setState(215);
				match(FUNCTION);
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

	@SuppressWarnings("CheckReturnValue")
	public static class IdentifierContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(MiniPascalGrammarParser.ID, 0); }
		public IdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).enterIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).exitIdentifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPascalGrammarVisitor ) return ((MiniPascalGrammarVisitor<? extends T>)visitor).visitIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdentifierContext identifier() throws RecognitionException {
		IdentifierContext _localctx = new IdentifierContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_identifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(218);
			match(ID);
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

	@SuppressWarnings("CheckReturnValue")
	public static class BlockContext extends ParserRuleContext {
		public List<ConstantDefinitionPartContext> constantDefinitionPart() {
			return getRuleContexts(ConstantDefinitionPartContext.class);
		}
		public ConstantDefinitionPartContext constantDefinitionPart(int i) {
			return getRuleContext(ConstantDefinitionPartContext.class,i);
		}
		public List<TypeDefinitionPartContext> typeDefinitionPart() {
			return getRuleContexts(TypeDefinitionPartContext.class);
		}
		public TypeDefinitionPartContext typeDefinitionPart(int i) {
			return getRuleContext(TypeDefinitionPartContext.class,i);
		}
		public List<VariableDeclarationPartContext> variableDeclarationPart() {
			return getRuleContexts(VariableDeclarationPartContext.class);
		}
		public VariableDeclarationPartContext variableDeclarationPart(int i) {
			return getRuleContext(VariableDeclarationPartContext.class,i);
		}
		public List<ProcedureAndFunctionDeclarationPartContext> procedureAndFunctionDeclarationPart() {
			return getRuleContexts(ProcedureAndFunctionDeclarationPartContext.class);
		}
		public ProcedureAndFunctionDeclarationPartContext procedureAndFunctionDeclarationPart(int i) {
			return getRuleContext(ProcedureAndFunctionDeclarationPartContext.class,i);
		}
		public List<TerminalNode> IMPLEMENTATION() { return getTokens(MiniPascalGrammarParser.IMPLEMENTATION); }
		public TerminalNode IMPLEMENTATION(int i) {
			return getToken(MiniPascalGrammarParser.IMPLEMENTATION, i);
		}
		public List<TerminalNode> OVERLOAD() { return getTokens(MiniPascalGrammarParser.OVERLOAD); }
		public TerminalNode OVERLOAD(int i) {
			return getToken(MiniPascalGrammarParser.OVERLOAD, i);
		}
		public List<TerminalNode> SEMICOLON() { return getTokens(MiniPascalGrammarParser.SEMICOLON); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(MiniPascalGrammarParser.SEMICOLON, i);
		}
		public List<CompoundStatementContext> compoundStatement() {
			return getRuleContexts(CompoundStatementContext.class);
		}
		public CompoundStatementContext compoundStatement(int i) {
			return getRuleContext(CompoundStatementContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).exitBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPascalGrammarVisitor ) return ((MiniPascalGrammarVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_block);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(229);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(227);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case CONST:
						{
						setState(220);
						constantDefinitionPart();
						}
						break;
					case TYPE:
						{
						setState(221);
						typeDefinitionPart();
						}
						break;
					case VAR:
						{
						setState(222);
						variableDeclarationPart();
						}
						break;
					case FUNCTION:
					case PROCEDURE:
						{
						setState(223);
						procedureAndFunctionDeclarationPart();
						}
						break;
					case IMPLEMENTATION:
						{
						setState(224);
						match(IMPLEMENTATION);
						}
						break;
					case OVERLOAD:
						{
						setState(225);
						match(OVERLOAD);
						setState(226);
						match(SEMICOLON);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					} 
				}
				setState(231);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			}
			setState(235);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(232);
					compoundStatement();
					}
					} 
				}
				setState(237);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ConstantDefinitionPartContext extends ParserRuleContext {
		public TerminalNode CONST() { return getToken(MiniPascalGrammarParser.CONST, 0); }
		public List<ConstantDefinitionContext> constantDefinition() {
			return getRuleContexts(ConstantDefinitionContext.class);
		}
		public ConstantDefinitionContext constantDefinition(int i) {
			return getRuleContext(ConstantDefinitionContext.class,i);
		}
		public List<TerminalNode> SEMICOLON() { return getTokens(MiniPascalGrammarParser.SEMICOLON); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(MiniPascalGrammarParser.SEMICOLON, i);
		}
		public ConstantDefinitionPartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constantDefinitionPart; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).enterConstantDefinitionPart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).exitConstantDefinitionPart(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPascalGrammarVisitor ) return ((MiniPascalGrammarVisitor<? extends T>)visitor).visitConstantDefinitionPart(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstantDefinitionPartContext constantDefinitionPart() throws RecognitionException {
		ConstantDefinitionPartContext _localctx = new ConstantDefinitionPartContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_constantDefinitionPart);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(238);
			match(CONST);
			setState(242); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(239);
				constantDefinition();
				setState(240);
				match(SEMICOLON);
				}
				}
				setState(244); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==ID );
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

	@SuppressWarnings("CheckReturnValue")
	public static class ConstantDefinitionContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode EQUAL() { return getToken(MiniPascalGrammarParser.EQUAL, 0); }
		public ConstantContext constant() {
			return getRuleContext(ConstantContext.class,0);
		}
		public ConstantDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constantDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).enterConstantDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).exitConstantDefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPascalGrammarVisitor ) return ((MiniPascalGrammarVisitor<? extends T>)visitor).visitConstantDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstantDefinitionContext constantDefinition() throws RecognitionException {
		ConstantDefinitionContext _localctx = new ConstantDefinitionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_constantDefinition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(246);
			identifier();
			setState(247);
			match(EQUAL);
			setState(248);
			constant();
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

	@SuppressWarnings("CheckReturnValue")
	public static class ConstantChrContext extends ParserRuleContext {
		public TerminalNode CHR() { return getToken(MiniPascalGrammarParser.CHR, 0); }
		public TerminalNode L_PAREN() { return getToken(MiniPascalGrammarParser.L_PAREN, 0); }
		public UnsignedIntegerContext unsignedInteger() {
			return getRuleContext(UnsignedIntegerContext.class,0);
		}
		public TerminalNode R_PAREN() { return getToken(MiniPascalGrammarParser.R_PAREN, 0); }
		public ConstantChrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constantChr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).enterConstantChr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).exitConstantChr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPascalGrammarVisitor ) return ((MiniPascalGrammarVisitor<? extends T>)visitor).visitConstantChr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstantChrContext constantChr() throws RecognitionException {
		ConstantChrContext _localctx = new ConstantChrContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_constantChr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(250);
			match(CHR);
			setState(251);
			match(L_PAREN);
			setState(252);
			unsignedInteger();
			setState(253);
			match(R_PAREN);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ConstantContext extends ParserRuleContext {
		public UnsignedNumberContext unsignedNumber() {
			return getRuleContext(UnsignedNumberContext.class,0);
		}
		public SignContext sign() {
			return getRuleContext(SignContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public StringContext string() {
			return getRuleContext(StringContext.class,0);
		}
		public ConstantChrContext constantChr() {
			return getRuleContext(ConstantChrContext.class,0);
		}
		public CharContext char_() {
			return getRuleContext(CharContext.class,0);
		}
		public BooleanContext boolean_() {
			return getRuleContext(BooleanContext.class,0);
		}
		public ConstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constant; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).enterConstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).exitConstant(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPascalGrammarVisitor ) return ((MiniPascalGrammarVisitor<? extends T>)visitor).visitConstant(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstantContext constant() throws RecognitionException {
		ConstantContext _localctx = new ConstantContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_constant);
		try {
			setState(266);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(255);
				unsignedNumber();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(256);
				sign();
				setState(257);
				unsignedNumber();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(259);
				sign();
				setState(260);
				identifier();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(262);
				string();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(263);
				constantChr();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(264);
				char_();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(265);
				boolean_();
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

	@SuppressWarnings("CheckReturnValue")
	public static class VarTypeContext extends ParserRuleContext {
		public ArrayTypeContext arrayType() {
			return getRuleContext(ArrayTypeContext.class,0);
		}
		public ArrayOfTypeContext arrayOfType() {
			return getRuleContext(ArrayOfTypeContext.class,0);
		}
		public StringR_Context stringR_() {
			return getRuleContext(StringR_Context.class,0);
		}
		public CharR_Context charR_() {
			return getRuleContext(CharR_Context.class,0);
		}
		public IntegerR_Context integerR_() {
			return getRuleContext(IntegerR_Context.class,0);
		}
		public BooleanR_Context booleanR_() {
			return getRuleContext(BooleanR_Context.class,0);
		}
		public VarTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).enterVarType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).exitVarType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPascalGrammarVisitor ) return ((MiniPascalGrammarVisitor<? extends T>)visitor).visitVarType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarTypeContext varType() throws RecognitionException {
		VarTypeContext _localctx = new VarTypeContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_varType);
		try {
			setState(274);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(268);
				arrayType();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(269);
				arrayOfType();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(270);
				stringR_();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(271);
				charR_();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(272);
				integerR_();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(273);
				booleanR_();
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

	@SuppressWarnings("CheckReturnValue")
	public static class ArrayTypeContext extends ParserRuleContext {
		public TerminalNode ARRAY() { return getToken(MiniPascalGrammarParser.ARRAY, 0); }
		public TerminalNode L_BRACK() { return getToken(MiniPascalGrammarParser.L_BRACK, 0); }
		public IndexRangesContext indexRanges() {
			return getRuleContext(IndexRangesContext.class,0);
		}
		public TerminalNode R_BRACK() { return getToken(MiniPascalGrammarParser.R_BRACK, 0); }
		public TerminalNode OF() { return getToken(MiniPascalGrammarParser.OF, 0); }
		public VarTypeContext varType() {
			return getRuleContext(VarTypeContext.class,0);
		}
		public ArrayTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).enterArrayType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).exitArrayType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPascalGrammarVisitor ) return ((MiniPascalGrammarVisitor<? extends T>)visitor).visitArrayType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayTypeContext arrayType() throws RecognitionException {
		ArrayTypeContext _localctx = new ArrayTypeContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_arrayType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(276);
			match(ARRAY);
			setState(277);
			match(L_BRACK);
			setState(278);
			indexRanges();
			setState(279);
			match(R_BRACK);
			setState(280);
			match(OF);
			setState(281);
			varType();
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

	@SuppressWarnings("CheckReturnValue")
	public static class ArrayOfTypeContext extends ParserRuleContext {
		public TerminalNode ARRAY() { return getToken(MiniPascalGrammarParser.ARRAY, 0); }
		public TerminalNode OF() { return getToken(MiniPascalGrammarParser.OF, 0); }
		public VarTypeContext varType() {
			return getRuleContext(VarTypeContext.class,0);
		}
		public ArrayOfTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayOfType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).enterArrayOfType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).exitArrayOfType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPascalGrammarVisitor ) return ((MiniPascalGrammarVisitor<? extends T>)visitor).visitArrayOfType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayOfTypeContext arrayOfType() throws RecognitionException {
		ArrayOfTypeContext _localctx = new ArrayOfTypeContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_arrayOfType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(283);
			match(ARRAY);
			setState(284);
			match(OF);
			setState(285);
			varType();
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

	@SuppressWarnings("CheckReturnValue")
	public static class ArrayValueContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode L_BRACK() { return getToken(MiniPascalGrammarParser.L_BRACK, 0); }
		public ExpressionListContext expressionList() {
			return getRuleContext(ExpressionListContext.class,0);
		}
		public TerminalNode R_BRACK() { return getToken(MiniPascalGrammarParser.R_BRACK, 0); }
		public ArrayValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).enterArrayValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).exitArrayValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPascalGrammarVisitor ) return ((MiniPascalGrammarVisitor<? extends T>)visitor).visitArrayValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayValueContext arrayValue() throws RecognitionException {
		ArrayValueContext _localctx = new ArrayValueContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_arrayValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(287);
			identifier();
			setState(288);
			match(L_BRACK);
			setState(289);
			expressionList();
			setState(290);
			match(R_BRACK);
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

	@SuppressWarnings("CheckReturnValue")
	public static class IndexRangesContext extends ParserRuleContext {
		public List<IndexRangeContext> indexRange() {
			return getRuleContexts(IndexRangeContext.class);
		}
		public IndexRangeContext indexRange(int i) {
			return getRuleContext(IndexRangeContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(MiniPascalGrammarParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(MiniPascalGrammarParser.COMMA, i);
		}
		public IndexRangesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_indexRanges; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).enterIndexRanges(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).exitIndexRanges(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPascalGrammarVisitor ) return ((MiniPascalGrammarVisitor<? extends T>)visitor).visitIndexRanges(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IndexRangesContext indexRanges() throws RecognitionException {
		IndexRangesContext _localctx = new IndexRangesContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_indexRanges);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(292);
			indexRange();
			setState(297);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(293);
				match(COMMA);
				setState(294);
				indexRange();
				}
				}
				setState(299);
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

	@SuppressWarnings("CheckReturnValue")
	public static class IndexRangeContext extends ParserRuleContext {
		public List<UnsignedIntegerContext> unsignedInteger() {
			return getRuleContexts(UnsignedIntegerContext.class);
		}
		public UnsignedIntegerContext unsignedInteger(int i) {
			return getRuleContext(UnsignedIntegerContext.class,i);
		}
		public TerminalNode DOUBLE_DOT() { return getToken(MiniPascalGrammarParser.DOUBLE_DOT, 0); }
		public IndexRangeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_indexRange; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).enterIndexRange(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).exitIndexRange(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPascalGrammarVisitor ) return ((MiniPascalGrammarVisitor<? extends T>)visitor).visitIndexRange(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IndexRangeContext indexRange() throws RecognitionException {
		IndexRangeContext _localctx = new IndexRangeContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_indexRange);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(300);
			unsignedInteger();
			setState(301);
			match(DOUBLE_DOT);
			setState(302);
			unsignedInteger();
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

	@SuppressWarnings("CheckReturnValue")
	public static class StringR_Context extends ParserRuleContext {
		public TerminalNode STRING_() { return getToken(MiniPascalGrammarParser.STRING_, 0); }
		public StringR_Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stringR_; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).enterStringR_(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).exitStringR_(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPascalGrammarVisitor ) return ((MiniPascalGrammarVisitor<? extends T>)visitor).visitStringR_(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StringR_Context stringR_() throws RecognitionException {
		StringR_Context _localctx = new StringR_Context(_ctx, getState());
		enterRule(_localctx, 28, RULE_stringR_);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(304);
			match(STRING_);
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

	@SuppressWarnings("CheckReturnValue")
	public static class CharR_Context extends ParserRuleContext {
		public TerminalNode CHAR_() { return getToken(MiniPascalGrammarParser.CHAR_, 0); }
		public CharR_Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_charR_; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).enterCharR_(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).exitCharR_(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPascalGrammarVisitor ) return ((MiniPascalGrammarVisitor<? extends T>)visitor).visitCharR_(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CharR_Context charR_() throws RecognitionException {
		CharR_Context _localctx = new CharR_Context(_ctx, getState());
		enterRule(_localctx, 30, RULE_charR_);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(306);
			match(CHAR_);
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

	@SuppressWarnings("CheckReturnValue")
	public static class IntegerR_Context extends ParserRuleContext {
		public TerminalNode INTEGER_() { return getToken(MiniPascalGrammarParser.INTEGER_, 0); }
		public IntegerR_Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_integerR_; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).enterIntegerR_(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).exitIntegerR_(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPascalGrammarVisitor ) return ((MiniPascalGrammarVisitor<? extends T>)visitor).visitIntegerR_(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IntegerR_Context integerR_() throws RecognitionException {
		IntegerR_Context _localctx = new IntegerR_Context(_ctx, getState());
		enterRule(_localctx, 32, RULE_integerR_);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(308);
			match(INTEGER_);
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

	@SuppressWarnings("CheckReturnValue")
	public static class BooleanR_Context extends ParserRuleContext {
		public TerminalNode BOOLEAN_() { return getToken(MiniPascalGrammarParser.BOOLEAN_, 0); }
		public BooleanR_Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_booleanR_; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).enterBooleanR_(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).exitBooleanR_(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPascalGrammarVisitor ) return ((MiniPascalGrammarVisitor<? extends T>)visitor).visitBooleanR_(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BooleanR_Context booleanR_() throws RecognitionException {
		BooleanR_Context _localctx = new BooleanR_Context(_ctx, getState());
		enterRule(_localctx, 34, RULE_booleanR_);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(310);
			match(BOOLEAN_);
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

	@SuppressWarnings("CheckReturnValue")
	public static class UnsignedNumberContext extends ParserRuleContext {
		public UnsignedIntegerContext unsignedInteger() {
			return getRuleContext(UnsignedIntegerContext.class,0);
		}
		public UnsignedNumberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unsignedNumber; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).enterUnsignedNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).exitUnsignedNumber(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPascalGrammarVisitor ) return ((MiniPascalGrammarVisitor<? extends T>)visitor).visitUnsignedNumber(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnsignedNumberContext unsignedNumber() throws RecognitionException {
		UnsignedNumberContext _localctx = new UnsignedNumberContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_unsignedNumber);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(312);
			unsignedInteger();
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

	@SuppressWarnings("CheckReturnValue")
	public static class UnsignedIntegerContext extends ParserRuleContext {
		public TerminalNode INTEGER() { return getToken(MiniPascalGrammarParser.INTEGER, 0); }
		public UnsignedIntegerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unsignedInteger; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).enterUnsignedInteger(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).exitUnsignedInteger(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPascalGrammarVisitor ) return ((MiniPascalGrammarVisitor<? extends T>)visitor).visitUnsignedInteger(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnsignedIntegerContext unsignedInteger() throws RecognitionException {
		UnsignedIntegerContext _localctx = new UnsignedIntegerContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_unsignedInteger);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(314);
			match(INTEGER);
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

	@SuppressWarnings("CheckReturnValue")
	public static class SignContext extends ParserRuleContext {
		public TerminalNode PLUS() { return getToken(MiniPascalGrammarParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(MiniPascalGrammarParser.MINUS, 0); }
		public SignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sign; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).enterSign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).exitSign(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPascalGrammarVisitor ) return ((MiniPascalGrammarVisitor<? extends T>)visitor).visitSign(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SignContext sign() throws RecognitionException {
		SignContext _localctx = new SignContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_sign);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(316);
			_la = _input.LA(1);
			if ( !(_la==PLUS || _la==MINUS) ) {
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

	@SuppressWarnings("CheckReturnValue")
	public static class Bool_Context extends ParserRuleContext {
		public TerminalNode BOOLEAN_() { return getToken(MiniPascalGrammarParser.BOOLEAN_, 0); }
		public Bool_Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bool_; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).enterBool_(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).exitBool_(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPascalGrammarVisitor ) return ((MiniPascalGrammarVisitor<? extends T>)visitor).visitBool_(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Bool_Context bool_() throws RecognitionException {
		Bool_Context _localctx = new Bool_Context(_ctx, getState());
		enterRule(_localctx, 42, RULE_bool_);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(318);
			match(BOOLEAN_);
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

	@SuppressWarnings("CheckReturnValue")
	public static class StringContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(MiniPascalGrammarParser.STRING, 0); }
		public StringContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_string; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).enterString(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).exitString(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPascalGrammarVisitor ) return ((MiniPascalGrammarVisitor<? extends T>)visitor).visitString(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StringContext string() throws RecognitionException {
		StringContext _localctx = new StringContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_string);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(320);
			match(STRING);
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

	@SuppressWarnings("CheckReturnValue")
	public static class BooleanContext extends ParserRuleContext {
		public TerminalNode BOOLEAN() { return getToken(MiniPascalGrammarParser.BOOLEAN, 0); }
		public BooleanContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolean; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).enterBoolean(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).exitBoolean(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPascalGrammarVisitor ) return ((MiniPascalGrammarVisitor<? extends T>)visitor).visitBoolean(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BooleanContext boolean_() throws RecognitionException {
		BooleanContext _localctx = new BooleanContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_boolean);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(322);
			match(BOOLEAN);
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

	@SuppressWarnings("CheckReturnValue")
	public static class CharContext extends ParserRuleContext {
		public TerminalNode CHAR() { return getToken(MiniPascalGrammarParser.CHAR, 0); }
		public CharContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_char; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).enterChar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).exitChar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPascalGrammarVisitor ) return ((MiniPascalGrammarVisitor<? extends T>)visitor).visitChar(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CharContext char_() throws RecognitionException {
		CharContext _localctx = new CharContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_char);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(324);
			match(CHAR);
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

	@SuppressWarnings("CheckReturnValue")
	public static class IntegerContext extends ParserRuleContext {
		public TerminalNode INTEGER() { return getToken(MiniPascalGrammarParser.INTEGER, 0); }
		public IntegerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_integer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).enterInteger(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).exitInteger(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPascalGrammarVisitor ) return ((MiniPascalGrammarVisitor<? extends T>)visitor).visitInteger(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IntegerContext integer() throws RecognitionException {
		IntegerContext _localctx = new IntegerContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_integer);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(326);
			match(INTEGER);
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

	@SuppressWarnings("CheckReturnValue")
	public static class TypeDefinitionPartContext extends ParserRuleContext {
		public TerminalNode TYPE() { return getToken(MiniPascalGrammarParser.TYPE, 0); }
		public List<TypeDefinitionContext> typeDefinition() {
			return getRuleContexts(TypeDefinitionContext.class);
		}
		public TypeDefinitionContext typeDefinition(int i) {
			return getRuleContext(TypeDefinitionContext.class,i);
		}
		public List<TerminalNode> SEMICOLON() { return getTokens(MiniPascalGrammarParser.SEMICOLON); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(MiniPascalGrammarParser.SEMICOLON, i);
		}
		public TypeDefinitionPartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeDefinitionPart; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).enterTypeDefinitionPart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).exitTypeDefinitionPart(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPascalGrammarVisitor ) return ((MiniPascalGrammarVisitor<? extends T>)visitor).visitTypeDefinitionPart(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeDefinitionPartContext typeDefinitionPart() throws RecognitionException {
		TypeDefinitionPartContext _localctx = new TypeDefinitionPartContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_typeDefinitionPart);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(328);
			match(TYPE);
			setState(332); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(329);
				typeDefinition();
				setState(330);
				match(SEMICOLON);
				}
				}
				setState(334); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==ID );
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

	@SuppressWarnings("CheckReturnValue")
	public static class TypeDefinitionContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode EQUAL() { return getToken(MiniPascalGrammarParser.EQUAL, 0); }
		public Type_Context type_() {
			return getRuleContext(Type_Context.class,0);
		}
		public FunctionTypeContext functionType() {
			return getRuleContext(FunctionTypeContext.class,0);
		}
		public TypeDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).enterTypeDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).exitTypeDefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPascalGrammarVisitor ) return ((MiniPascalGrammarVisitor<? extends T>)visitor).visitTypeDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeDefinitionContext typeDefinition() throws RecognitionException {
		TypeDefinitionContext _localctx = new TypeDefinitionContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_typeDefinition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(336);
			identifier();
			setState(337);
			match(EQUAL);
			setState(340);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INTEGER:
			case BOOLEAN:
			case CHAR:
			case STRING:
			case PLUS:
			case MINUS:
			case ARRAY:
			case INTEGER_:
			case BOOLEAN_:
			case CHAR_:
			case STRING_:
			case CHR:
				{
				setState(338);
				type_();
				}
				break;
			case FUNCTION:
				{
				setState(339);
				functionType();
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

	@SuppressWarnings("CheckReturnValue")
	public static class FunctionTypeContext extends ParserRuleContext {
		public TerminalNode FUNCTION() { return getToken(MiniPascalGrammarParser.FUNCTION, 0); }
		public TerminalNode COLON() { return getToken(MiniPascalGrammarParser.COLON, 0); }
		public VarTypeContext varType() {
			return getRuleContext(VarTypeContext.class,0);
		}
		public FormalParameterListContext formalParameterList() {
			return getRuleContext(FormalParameterListContext.class,0);
		}
		public FunctionTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).enterFunctionType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).exitFunctionType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPascalGrammarVisitor ) return ((MiniPascalGrammarVisitor<? extends T>)visitor).visitFunctionType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionTypeContext functionType() throws RecognitionException {
		FunctionTypeContext _localctx = new FunctionTypeContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_functionType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(342);
			match(FUNCTION);
			setState(344);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==L_PAREN) {
				{
				setState(343);
				formalParameterList();
				}
			}

			setState(346);
			match(COLON);
			setState(347);
			varType();
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

	@SuppressWarnings("CheckReturnValue")
	public static class ProcedureTypeContext extends ParserRuleContext {
		public TerminalNode PROCEDURE() { return getToken(MiniPascalGrammarParser.PROCEDURE, 0); }
		public TerminalNode COLON() { return getToken(MiniPascalGrammarParser.COLON, 0); }
		public VarTypeContext varType() {
			return getRuleContext(VarTypeContext.class,0);
		}
		public FormalParameterListContext formalParameterList() {
			return getRuleContext(FormalParameterListContext.class,0);
		}
		public ProcedureTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_procedureType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).enterProcedureType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).exitProcedureType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPascalGrammarVisitor ) return ((MiniPascalGrammarVisitor<? extends T>)visitor).visitProcedureType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProcedureTypeContext procedureType() throws RecognitionException {
		ProcedureTypeContext _localctx = new ProcedureTypeContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_procedureType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(349);
			match(PROCEDURE);
			setState(351);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==L_PAREN) {
				{
				setState(350);
				formalParameterList();
				}
			}

			setState(353);
			match(COLON);
			setState(354);
			varType();
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

	@SuppressWarnings("CheckReturnValue")
	public static class Type_Context extends ParserRuleContext {
		public SimpleTypeContext simpleType() {
			return getRuleContext(SimpleTypeContext.class,0);
		}
		public ArrayTypeContext arrayType() {
			return getRuleContext(ArrayTypeContext.class,0);
		}
		public Type_Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).enterType_(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).exitType_(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPascalGrammarVisitor ) return ((MiniPascalGrammarVisitor<? extends T>)visitor).visitType_(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Type_Context type_() throws RecognitionException {
		Type_Context _localctx = new Type_Context(_ctx, getState());
		enterRule(_localctx, 60, RULE_type_);
		try {
			setState(358);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INTEGER:
			case BOOLEAN:
			case CHAR:
			case STRING:
			case PLUS:
			case MINUS:
			case INTEGER_:
			case BOOLEAN_:
			case CHAR_:
			case STRING_:
			case CHR:
				enterOuterAlt(_localctx, 1);
				{
				setState(356);
				simpleType();
				}
				break;
			case ARRAY:
				enterOuterAlt(_localctx, 2);
				{
				setState(357);
				arrayType();
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

	@SuppressWarnings("CheckReturnValue")
	public static class SimpleTypeContext extends ParserRuleContext {
		public SubrangeTypeContext subrangeType() {
			return getRuleContext(SubrangeTypeContext.class,0);
		}
		public TypeIdentifierContext typeIdentifier() {
			return getRuleContext(TypeIdentifierContext.class,0);
		}
		public StringtypeContext stringtype() {
			return getRuleContext(StringtypeContext.class,0);
		}
		public ConstantContext constant() {
			return getRuleContext(ConstantContext.class,0);
		}
		public SimpleTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simpleType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).enterSimpleType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).exitSimpleType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPascalGrammarVisitor ) return ((MiniPascalGrammarVisitor<? extends T>)visitor).visitSimpleType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SimpleTypeContext simpleType() throws RecognitionException {
		SimpleTypeContext _localctx = new SimpleTypeContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_simpleType);
		try {
			setState(364);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(360);
				subrangeType();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(361);
				typeIdentifier();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(362);
				stringtype();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(363);
				constant();
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

	@SuppressWarnings("CheckReturnValue")
	public static class ScalarTypeContext extends ParserRuleContext {
		public TerminalNode L_PAREN() { return getToken(MiniPascalGrammarParser.L_PAREN, 0); }
		public IdentifierListContext identifierList() {
			return getRuleContext(IdentifierListContext.class,0);
		}
		public TerminalNode R_PAREN() { return getToken(MiniPascalGrammarParser.R_PAREN, 0); }
		public ScalarTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_scalarType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).enterScalarType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).exitScalarType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPascalGrammarVisitor ) return ((MiniPascalGrammarVisitor<? extends T>)visitor).visitScalarType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ScalarTypeContext scalarType() throws RecognitionException {
		ScalarTypeContext _localctx = new ScalarTypeContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_scalarType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(366);
			match(L_PAREN);
			setState(367);
			identifierList();
			setState(368);
			match(R_PAREN);
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

	@SuppressWarnings("CheckReturnValue")
	public static class SubrangeTypeContext extends ParserRuleContext {
		public List<ConstantContext> constant() {
			return getRuleContexts(ConstantContext.class);
		}
		public ConstantContext constant(int i) {
			return getRuleContext(ConstantContext.class,i);
		}
		public TerminalNode DOUBLE_DOT() { return getToken(MiniPascalGrammarParser.DOUBLE_DOT, 0); }
		public SubrangeTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_subrangeType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).enterSubrangeType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).exitSubrangeType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPascalGrammarVisitor ) return ((MiniPascalGrammarVisitor<? extends T>)visitor).visitSubrangeType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SubrangeTypeContext subrangeType() throws RecognitionException {
		SubrangeTypeContext _localctx = new SubrangeTypeContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_subrangeType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(370);
			constant();
			setState(371);
			match(DOUBLE_DOT);
			setState(372);
			constant();
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

	@SuppressWarnings("CheckReturnValue")
	public static class TypeIdentifierContext extends ParserRuleContext {
		public TerminalNode CHAR_() { return getToken(MiniPascalGrammarParser.CHAR_, 0); }
		public TerminalNode BOOLEAN_() { return getToken(MiniPascalGrammarParser.BOOLEAN_, 0); }
		public TerminalNode INTEGER_() { return getToken(MiniPascalGrammarParser.INTEGER_, 0); }
		public TerminalNode STRING_() { return getToken(MiniPascalGrammarParser.STRING_, 0); }
		public TypeIdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeIdentifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).enterTypeIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).exitTypeIdentifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPascalGrammarVisitor ) return ((MiniPascalGrammarVisitor<? extends T>)visitor).visitTypeIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeIdentifierContext typeIdentifier() throws RecognitionException {
		TypeIdentifierContext _localctx = new TypeIdentifierContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_typeIdentifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(374);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 16888498602639360L) != 0)) ) {
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

	@SuppressWarnings("CheckReturnValue")
	public static class StringtypeContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(MiniPascalGrammarParser.STRING, 0); }
		public TerminalNode L_BRACK() { return getToken(MiniPascalGrammarParser.L_BRACK, 0); }
		public TerminalNode R_BRACK() { return getToken(MiniPascalGrammarParser.R_BRACK, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public UnsignedNumberContext unsignedNumber() {
			return getRuleContext(UnsignedNumberContext.class,0);
		}
		public StringtypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stringtype; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).enterStringtype(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).exitStringtype(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPascalGrammarVisitor ) return ((MiniPascalGrammarVisitor<? extends T>)visitor).visitStringtype(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StringtypeContext stringtype() throws RecognitionException {
		StringtypeContext _localctx = new StringtypeContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_stringtype);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(376);
			match(STRING);
			setState(377);
			match(L_BRACK);
			setState(380);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				{
				setState(378);
				identifier();
				}
				break;
			case INTEGER:
				{
				setState(379);
				unsignedNumber();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(382);
			match(R_BRACK);
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

	@SuppressWarnings("CheckReturnValue")
	public static class TypeListContext extends ParserRuleContext {
		public List<IndexTypeContext> indexType() {
			return getRuleContexts(IndexTypeContext.class);
		}
		public IndexTypeContext indexType(int i) {
			return getRuleContext(IndexTypeContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(MiniPascalGrammarParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(MiniPascalGrammarParser.COMMA, i);
		}
		public TypeListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).enterTypeList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).exitTypeList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPascalGrammarVisitor ) return ((MiniPascalGrammarVisitor<? extends T>)visitor).visitTypeList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeListContext typeList() throws RecognitionException {
		TypeListContext _localctx = new TypeListContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_typeList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(384);
			indexType();
			setState(389);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(385);
				match(COMMA);
				setState(386);
				indexType();
				}
				}
				setState(391);
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

	@SuppressWarnings("CheckReturnValue")
	public static class IndexTypeContext extends ParserRuleContext {
		public SimpleTypeContext simpleType() {
			return getRuleContext(SimpleTypeContext.class,0);
		}
		public IndexTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_indexType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).enterIndexType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).exitIndexType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPascalGrammarVisitor ) return ((MiniPascalGrammarVisitor<? extends T>)visitor).visitIndexType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IndexTypeContext indexType() throws RecognitionException {
		IndexTypeContext _localctx = new IndexTypeContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_indexType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(392);
			simpleType();
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

	@SuppressWarnings("CheckReturnValue")
	public static class ComponentTypeContext extends ParserRuleContext {
		public Type_Context type_() {
			return getRuleContext(Type_Context.class,0);
		}
		public ComponentTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_componentType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).enterComponentType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).exitComponentType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPascalGrammarVisitor ) return ((MiniPascalGrammarVisitor<? extends T>)visitor).visitComponentType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComponentTypeContext componentType() throws RecognitionException {
		ComponentTypeContext _localctx = new ComponentTypeContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_componentType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(394);
			type_();
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

	@SuppressWarnings("CheckReturnValue")
	public static class FixedPartContext extends ParserRuleContext {
		public List<RecordSectionContext> recordSection() {
			return getRuleContexts(RecordSectionContext.class);
		}
		public RecordSectionContext recordSection(int i) {
			return getRuleContext(RecordSectionContext.class,i);
		}
		public List<TerminalNode> SEMICOLON() { return getTokens(MiniPascalGrammarParser.SEMICOLON); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(MiniPascalGrammarParser.SEMICOLON, i);
		}
		public FixedPartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fixedPart; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).enterFixedPart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).exitFixedPart(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPascalGrammarVisitor ) return ((MiniPascalGrammarVisitor<? extends T>)visitor).visitFixedPart(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FixedPartContext fixedPart() throws RecognitionException {
		FixedPartContext _localctx = new FixedPartContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_fixedPart);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(396);
			recordSection();
			setState(401);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SEMICOLON) {
				{
				{
				setState(397);
				match(SEMICOLON);
				setState(398);
				recordSection();
				}
				}
				setState(403);
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

	@SuppressWarnings("CheckReturnValue")
	public static class RecordSectionContext extends ParserRuleContext {
		public IdentifierListContext identifierList() {
			return getRuleContext(IdentifierListContext.class,0);
		}
		public TerminalNode COLON() { return getToken(MiniPascalGrammarParser.COLON, 0); }
		public Type_Context type_() {
			return getRuleContext(Type_Context.class,0);
		}
		public RecordSectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_recordSection; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).enterRecordSection(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).exitRecordSection(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPascalGrammarVisitor ) return ((MiniPascalGrammarVisitor<? extends T>)visitor).visitRecordSection(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RecordSectionContext recordSection() throws RecognitionException {
		RecordSectionContext _localctx = new RecordSectionContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_recordSection);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(404);
			identifierList();
			setState(405);
			match(COLON);
			setState(406);
			type_();
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

	@SuppressWarnings("CheckReturnValue")
	public static class TagContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode COLON() { return getToken(MiniPascalGrammarParser.COLON, 0); }
		public TypeIdentifierContext typeIdentifier() {
			return getRuleContext(TypeIdentifierContext.class,0);
		}
		public TagContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tag; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).enterTag(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).exitTag(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPascalGrammarVisitor ) return ((MiniPascalGrammarVisitor<? extends T>)visitor).visitTag(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TagContext tag() throws RecognitionException {
		TagContext _localctx = new TagContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_tag);
		try {
			setState(413);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(408);
				identifier();
				setState(409);
				match(COLON);
				setState(410);
				typeIdentifier();
				}
				break;
			case INTEGER_:
			case BOOLEAN_:
			case CHAR_:
			case STRING_:
				enterOuterAlt(_localctx, 2);
				{
				setState(412);
				typeIdentifier();
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

	@SuppressWarnings("CheckReturnValue")
	public static class BaseTypeContext extends ParserRuleContext {
		public SimpleTypeContext simpleType() {
			return getRuleContext(SimpleTypeContext.class,0);
		}
		public BaseTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_baseType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).enterBaseType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).exitBaseType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPascalGrammarVisitor ) return ((MiniPascalGrammarVisitor<? extends T>)visitor).visitBaseType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BaseTypeContext baseType() throws RecognitionException {
		BaseTypeContext _localctx = new BaseTypeContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_baseType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(415);
			simpleType();
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

	@SuppressWarnings("CheckReturnValue")
	public static class VariableDeclarationPartContext extends ParserRuleContext {
		public TerminalNode VAR() { return getToken(MiniPascalGrammarParser.VAR, 0); }
		public List<VariableDeclarationContext> variableDeclaration() {
			return getRuleContexts(VariableDeclarationContext.class);
		}
		public VariableDeclarationContext variableDeclaration(int i) {
			return getRuleContext(VariableDeclarationContext.class,i);
		}
		public List<TerminalNode> SEMICOLON() { return getTokens(MiniPascalGrammarParser.SEMICOLON); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(MiniPascalGrammarParser.SEMICOLON, i);
		}
		public VariableDeclarationPartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDeclarationPart; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).enterVariableDeclarationPart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).exitVariableDeclarationPart(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPascalGrammarVisitor ) return ((MiniPascalGrammarVisitor<? extends T>)visitor).visitVariableDeclarationPart(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableDeclarationPartContext variableDeclarationPart() throws RecognitionException {
		VariableDeclarationPartContext _localctx = new VariableDeclarationPartContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_variableDeclarationPart);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(417);
			match(VAR);
			setState(418);
			variableDeclaration();
			setState(423);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(419);
					match(SEMICOLON);
					setState(420);
					variableDeclaration();
					}
					} 
				}
				setState(425);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			}
			setState(426);
			match(SEMICOLON);
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

	@SuppressWarnings("CheckReturnValue")
	public static class VariableDeclarationContext extends ParserRuleContext {
		public IdentifierListContext identifierList() {
			return getRuleContext(IdentifierListContext.class,0);
		}
		public TerminalNode COLON() { return getToken(MiniPascalGrammarParser.COLON, 0); }
		public Type_Context type_() {
			return getRuleContext(Type_Context.class,0);
		}
		public TerminalNode EQUAL() { return getToken(MiniPascalGrammarParser.EQUAL, 0); }
		public InitialValueContext initialValue() {
			return getRuleContext(InitialValueContext.class,0);
		}
		public VariableDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).enterVariableDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).exitVariableDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPascalGrammarVisitor ) return ((MiniPascalGrammarVisitor<? extends T>)visitor).visitVariableDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableDeclarationContext variableDeclaration() throws RecognitionException {
		VariableDeclarationContext _localctx = new VariableDeclarationContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_variableDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(428);
			identifierList();
			setState(429);
			match(COLON);
			setState(430);
			type_();
			setState(433);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EQUAL) {
				{
				setState(431);
				match(EQUAL);
				setState(432);
				initialValue();
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

	@SuppressWarnings("CheckReturnValue")
	public static class ProcedureAndFunctionDeclarationPartContext extends ParserRuleContext {
		public ProcedureOrFunctionDeclarationContext procedureOrFunctionDeclaration() {
			return getRuleContext(ProcedureOrFunctionDeclarationContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(MiniPascalGrammarParser.SEMICOLON, 0); }
		public ProcedureAndFunctionDeclarationPartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_procedureAndFunctionDeclarationPart; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).enterProcedureAndFunctionDeclarationPart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).exitProcedureAndFunctionDeclarationPart(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPascalGrammarVisitor ) return ((MiniPascalGrammarVisitor<? extends T>)visitor).visitProcedureAndFunctionDeclarationPart(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProcedureAndFunctionDeclarationPartContext procedureAndFunctionDeclarationPart() throws RecognitionException {
		ProcedureAndFunctionDeclarationPartContext _localctx = new ProcedureAndFunctionDeclarationPartContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_procedureAndFunctionDeclarationPart);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(435);
			procedureOrFunctionDeclaration();
			setState(436);
			match(SEMICOLON);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ProcedureOrFunctionDeclarationContext extends ParserRuleContext {
		public FunctionDeclarationContext functionDeclaration() {
			return getRuleContext(FunctionDeclarationContext.class,0);
		}
		public ProcedureDeclarationContext procedureDeclaration() {
			return getRuleContext(ProcedureDeclarationContext.class,0);
		}
		public ProcedureOrFunctionDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_procedureOrFunctionDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).enterProcedureOrFunctionDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).exitProcedureOrFunctionDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPascalGrammarVisitor ) return ((MiniPascalGrammarVisitor<? extends T>)visitor).visitProcedureOrFunctionDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProcedureOrFunctionDeclarationContext procedureOrFunctionDeclaration() throws RecognitionException {
		ProcedureOrFunctionDeclarationContext _localctx = new ProcedureOrFunctionDeclarationContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_procedureOrFunctionDeclaration);
		try {
			setState(440);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FUNCTION:
				enterOuterAlt(_localctx, 1);
				{
				setState(438);
				functionDeclaration();
				}
				break;
			case PROCEDURE:
				enterOuterAlt(_localctx, 2);
				{
				setState(439);
				procedureDeclaration();
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

	@SuppressWarnings("CheckReturnValue")
	public static class FormalParameterListContext extends ParserRuleContext {
		public TerminalNode L_PAREN() { return getToken(MiniPascalGrammarParser.L_PAREN, 0); }
		public List<FormalParameterSectionContext> formalParameterSection() {
			return getRuleContexts(FormalParameterSectionContext.class);
		}
		public FormalParameterSectionContext formalParameterSection(int i) {
			return getRuleContext(FormalParameterSectionContext.class,i);
		}
		public TerminalNode R_PAREN() { return getToken(MiniPascalGrammarParser.R_PAREN, 0); }
		public List<TerminalNode> SEMICOLON() { return getTokens(MiniPascalGrammarParser.SEMICOLON); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(MiniPascalGrammarParser.SEMICOLON, i);
		}
		public FormalParameterListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formalParameterList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).enterFormalParameterList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).exitFormalParameterList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPascalGrammarVisitor ) return ((MiniPascalGrammarVisitor<? extends T>)visitor).visitFormalParameterList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FormalParameterListContext formalParameterList() throws RecognitionException {
		FormalParameterListContext _localctx = new FormalParameterListContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_formalParameterList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(442);
			match(L_PAREN);
			setState(443);
			formalParameterSection();
			setState(448);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SEMICOLON) {
				{
				{
				setState(444);
				match(SEMICOLON);
				setState(445);
				formalParameterSection();
				}
				}
				setState(450);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(451);
			match(R_PAREN);
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

	@SuppressWarnings("CheckReturnValue")
	public static class FormalParameterSectionContext extends ParserRuleContext {
		public ParameterGroupContext parameterGroup() {
			return getRuleContext(ParameterGroupContext.class,0);
		}
		public TerminalNode VAR() { return getToken(MiniPascalGrammarParser.VAR, 0); }
		public TerminalNode FUNCTION() { return getToken(MiniPascalGrammarParser.FUNCTION, 0); }
		public FormalParameterSectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formalParameterSection; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).enterFormalParameterSection(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).exitFormalParameterSection(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPascalGrammarVisitor ) return ((MiniPascalGrammarVisitor<? extends T>)visitor).visitFormalParameterSection(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FormalParameterSectionContext formalParameterSection() throws RecognitionException {
		FormalParameterSectionContext _localctx = new FormalParameterSectionContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_formalParameterSection);
		try {
			setState(458);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case R_PAREN:
			case SEMICOLON:
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(453);
				parameterGroup();
				}
				break;
			case VAR:
				enterOuterAlt(_localctx, 2);
				{
				setState(454);
				match(VAR);
				setState(455);
				parameterGroup();
				}
				break;
			case FUNCTION:
				enterOuterAlt(_localctx, 3);
				{
				setState(456);
				match(FUNCTION);
				setState(457);
				parameterGroup();
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

	@SuppressWarnings("CheckReturnValue")
	public static class ParameterGroupContext extends ParserRuleContext {
		public IdentifierListContext identifierList() {
			return getRuleContext(IdentifierListContext.class,0);
		}
		public TerminalNode COLON() { return getToken(MiniPascalGrammarParser.COLON, 0); }
		public VarTypeContext varType() {
			return getRuleContext(VarTypeContext.class,0);
		}
		public EmptyStatement_Context emptyStatement_() {
			return getRuleContext(EmptyStatement_Context.class,0);
		}
		public ParameterGroupContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameterGroup; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).enterParameterGroup(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).exitParameterGroup(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPascalGrammarVisitor ) return ((MiniPascalGrammarVisitor<? extends T>)visitor).visitParameterGroup(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParameterGroupContext parameterGroup() throws RecognitionException {
		ParameterGroupContext _localctx = new ParameterGroupContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_parameterGroup);
		try {
			setState(465);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(460);
				identifierList();
				setState(461);
				match(COLON);
				setState(462);
				varType();
				}
				break;
			case R_PAREN:
			case SEMICOLON:
				enterOuterAlt(_localctx, 2);
				{
				setState(464);
				emptyStatement_();
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

	@SuppressWarnings("CheckReturnValue")
	public static class IdentifierListContext extends ParserRuleContext {
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(MiniPascalGrammarParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(MiniPascalGrammarParser.COMMA, i);
		}
		public IdentifierListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifierList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).enterIdentifierList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).exitIdentifierList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPascalGrammarVisitor ) return ((MiniPascalGrammarVisitor<? extends T>)visitor).visitIdentifierList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdentifierListContext identifierList() throws RecognitionException {
		IdentifierListContext _localctx = new IdentifierListContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_identifierList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(467);
			identifier();
			setState(472);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(468);
				match(COMMA);
				setState(469);
				identifier();
				}
				}
				setState(474);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ConstListContext extends ParserRuleContext {
		public List<ConstantContext> constant() {
			return getRuleContexts(ConstantContext.class);
		}
		public ConstantContext constant(int i) {
			return getRuleContext(ConstantContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(MiniPascalGrammarParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(MiniPascalGrammarParser.COMMA, i);
		}
		public ConstListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).enterConstList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).exitConstList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPascalGrammarVisitor ) return ((MiniPascalGrammarVisitor<? extends T>)visitor).visitConstList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstListContext constList() throws RecognitionException {
		ConstListContext _localctx = new ConstListContext(_ctx, getState());
		enterRule(_localctx, 102, RULE_constList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(475);
			constant();
			setState(480);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(476);
				match(COMMA);
				setState(477);
				constant();
				}
				}
				setState(482);
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

	@SuppressWarnings("CheckReturnValue")
	public static class FunctionDeclarationContext extends ParserRuleContext {
		public TerminalNode FUNCTION() { return getToken(MiniPascalGrammarParser.FUNCTION, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public FormalParameterListContext formalParameterList() {
			return getRuleContext(FormalParameterListContext.class,0);
		}
		public TerminalNode COLON() { return getToken(MiniPascalGrammarParser.COLON, 0); }
		public VarTypeContext varType() {
			return getRuleContext(VarTypeContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(MiniPascalGrammarParser.SEMICOLON, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public FunctionDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).enterFunctionDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).exitFunctionDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPascalGrammarVisitor ) return ((MiniPascalGrammarVisitor<? extends T>)visitor).visitFunctionDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionDeclarationContext functionDeclaration() throws RecognitionException {
		FunctionDeclarationContext _localctx = new FunctionDeclarationContext(_ctx, getState());
		enterRule(_localctx, 104, RULE_functionDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(483);
			match(FUNCTION);
			setState(484);
			identifier();
			setState(485);
			formalParameterList();
			setState(486);
			match(COLON);
			setState(487);
			varType();
			setState(488);
			match(SEMICOLON);
			setState(489);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ProcedureDeclarationContext extends ParserRuleContext {
		public TerminalNode PROCEDURE() { return getToken(MiniPascalGrammarParser.PROCEDURE, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public FormalParameterListContext formalParameterList() {
			return getRuleContext(FormalParameterListContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(MiniPascalGrammarParser.SEMICOLON, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ProcedureDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_procedureDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).enterProcedureDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).exitProcedureDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPascalGrammarVisitor ) return ((MiniPascalGrammarVisitor<? extends T>)visitor).visitProcedureDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProcedureDeclarationContext procedureDeclaration() throws RecognitionException {
		ProcedureDeclarationContext _localctx = new ProcedureDeclarationContext(_ctx, getState());
		enterRule(_localctx, 106, RULE_procedureDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(491);
			match(PROCEDURE);
			setState(492);
			identifier();
			setState(493);
			formalParameterList();
			setState(494);
			match(SEMICOLON);
			setState(495);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ResultTypeContext extends ParserRuleContext {
		public TypeIdentifierContext typeIdentifier() {
			return getRuleContext(TypeIdentifierContext.class,0);
		}
		public ResultTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_resultType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).enterResultType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).exitResultType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPascalGrammarVisitor ) return ((MiniPascalGrammarVisitor<? extends T>)visitor).visitResultType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ResultTypeContext resultType() throws RecognitionException {
		ResultTypeContext _localctx = new ResultTypeContext(_ctx, getState());
		enterRule(_localctx, 108, RULE_resultType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(497);
			typeIdentifier();
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

	@SuppressWarnings("CheckReturnValue")
	public static class StatementContext extends ParserRuleContext {
		public WriteStatementContext writeStatement() {
			return getRuleContext(WriteStatementContext.class,0);
		}
		public ReadStatementContext readStatement() {
			return getRuleContext(ReadStatementContext.class,0);
		}
		public UnlabelledStatementContext unlabelledStatement() {
			return getRuleContext(UnlabelledStatementContext.class,0);
		}
		public FunctionDesignatorContext functionDesignator() {
			return getRuleContext(FunctionDesignatorContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPascalGrammarVisitor ) return ((MiniPascalGrammarVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 110, RULE_statement);
		try {
			setState(503);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(499);
				writeStatement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(500);
				readStatement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(501);
				unlabelledStatement();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(502);
				functionDesignator();
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

	@SuppressWarnings("CheckReturnValue")
	public static class WriteStatementContext extends ParserRuleContext {
		public WriteContext write() {
			return getRuleContext(WriteContext.class,0);
		}
		public TerminalNode L_PAREN() { return getToken(MiniPascalGrammarParser.L_PAREN, 0); }
		public TerminalNode R_PAREN() { return getToken(MiniPascalGrammarParser.R_PAREN, 0); }
		public List<WriteParamContext> writeParam() {
			return getRuleContexts(WriteParamContext.class);
		}
		public WriteParamContext writeParam(int i) {
			return getRuleContext(WriteParamContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(MiniPascalGrammarParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(MiniPascalGrammarParser.COMMA, i);
		}
		public WriteStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_writeStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).enterWriteStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).exitWriteStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPascalGrammarVisitor ) return ((MiniPascalGrammarVisitor<? extends T>)visitor).visitWriteStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WriteStatementContext writeStatement() throws RecognitionException {
		WriteStatementContext _localctx = new WriteStatementContext(_ctx, getState());
		enterRule(_localctx, 112, RULE_writeStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(505);
			write();
			setState(506);
			match(L_PAREN);
			setState(515);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4611686018427388384L) != 0)) {
				{
				setState(507);
				writeParam();
				setState(512);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(508);
					match(COMMA);
					setState(509);
					writeParam();
					}
					}
					setState(514);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(517);
			match(R_PAREN);
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

	@SuppressWarnings("CheckReturnValue")
	public static class WriteContext extends ParserRuleContext {
		public TerminalNode WRITE() { return getToken(MiniPascalGrammarParser.WRITE, 0); }
		public TerminalNode WRITELN() { return getToken(MiniPascalGrammarParser.WRITELN, 0); }
		public WriteContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_write; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).enterWrite(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).exitWrite(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPascalGrammarVisitor ) return ((MiniPascalGrammarVisitor<? extends T>)visitor).visitWrite(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WriteContext write() throws RecognitionException {
		WriteContext _localctx = new WriteContext(_ctx, getState());
		enterRule(_localctx, 114, RULE_write);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(519);
			_la = _input.LA(1);
			if ( !(_la==WRITELN || _la==WRITE) ) {
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

	@SuppressWarnings("CheckReturnValue")
	public static class WriteParamContext extends ParserRuleContext {
		public VarValueContext varValue() {
			return getRuleContext(VarValueContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public ArrayValueContext arrayValue() {
			return getRuleContext(ArrayValueContext.class,0);
		}
		public WriteParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_writeParam; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).enterWriteParam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).exitWriteParam(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPascalGrammarVisitor ) return ((MiniPascalGrammarVisitor<? extends T>)visitor).visitWriteParam(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WriteParamContext writeParam() throws RecognitionException {
		WriteParamContext _localctx = new WriteParamContext(_ctx, getState());
		enterRule(_localctx, 116, RULE_writeParam);
		try {
			setState(524);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(521);
				varValue();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(522);
				identifier();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(523);
				arrayValue();
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

	@SuppressWarnings("CheckReturnValue")
	public static class VarValueContext extends ParserRuleContext {
		public StringContext string() {
			return getRuleContext(StringContext.class,0);
		}
		public BooleanContext boolean_() {
			return getRuleContext(BooleanContext.class,0);
		}
		public CharContext char_() {
			return getRuleContext(CharContext.class,0);
		}
		public IntegerContext integer() {
			return getRuleContext(IntegerContext.class,0);
		}
		public VarValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).enterVarValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).exitVarValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPascalGrammarVisitor ) return ((MiniPascalGrammarVisitor<? extends T>)visitor).visitVarValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarValueContext varValue() throws RecognitionException {
		VarValueContext _localctx = new VarValueContext(_ctx, getState());
		enterRule(_localctx, 118, RULE_varValue);
		try {
			setState(530);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STRING:
				enterOuterAlt(_localctx, 1);
				{
				setState(526);
				string();
				}
				break;
			case BOOLEAN:
				enterOuterAlt(_localctx, 2);
				{
				setState(527);
				boolean_();
				}
				break;
			case CHAR:
				enterOuterAlt(_localctx, 3);
				{
				setState(528);
				char_();
				}
				break;
			case INTEGER:
				enterOuterAlt(_localctx, 4);
				{
				setState(529);
				integer();
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

	@SuppressWarnings("CheckReturnValue")
	public static class ReadStatementContext extends ParserRuleContext {
		public ReadContext read() {
			return getRuleContext(ReadContext.class,0);
		}
		public TerminalNode L_PAREN() { return getToken(MiniPascalGrammarParser.L_PAREN, 0); }
		public ReadParamContext readParam() {
			return getRuleContext(ReadParamContext.class,0);
		}
		public TerminalNode R_PAREN() { return getToken(MiniPascalGrammarParser.R_PAREN, 0); }
		public ReadStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_readStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).enterReadStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).exitReadStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPascalGrammarVisitor ) return ((MiniPascalGrammarVisitor<? extends T>)visitor).visitReadStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReadStatementContext readStatement() throws RecognitionException {
		ReadStatementContext _localctx = new ReadStatementContext(_ctx, getState());
		enterRule(_localctx, 120, RULE_readStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(532);
			read();
			setState(533);
			match(L_PAREN);
			setState(534);
			readParam();
			setState(535);
			match(R_PAREN);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ReadContext extends ParserRuleContext {
		public TerminalNode READ() { return getToken(MiniPascalGrammarParser.READ, 0); }
		public TerminalNode READLN() { return getToken(MiniPascalGrammarParser.READLN, 0); }
		public ReadContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_read; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).enterRead(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).exitRead(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPascalGrammarVisitor ) return ((MiniPascalGrammarVisitor<? extends T>)visitor).visitRead(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReadContext read() throws RecognitionException {
		ReadContext _localctx = new ReadContext(_ctx, getState());
		enterRule(_localctx, 122, RULE_read);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(537);
			_la = _input.LA(1);
			if ( !(_la==READLN || _la==READ) ) {
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

	@SuppressWarnings("CheckReturnValue")
	public static class ReadParamContext extends ParserRuleContext {
		public VarValueContext varValue() {
			return getRuleContext(VarValueContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public ArrayValueContext arrayValue() {
			return getRuleContext(ArrayValueContext.class,0);
		}
		public ReadParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_readParam; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).enterReadParam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).exitReadParam(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPascalGrammarVisitor ) return ((MiniPascalGrammarVisitor<? extends T>)visitor).visitReadParam(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReadParamContext readParam() throws RecognitionException {
		ReadParamContext _localctx = new ReadParamContext(_ctx, getState());
		enterRule(_localctx, 124, RULE_readParam);
		try {
			setState(542);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(539);
				varValue();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(540);
				identifier();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(541);
				arrayValue();
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

	@SuppressWarnings("CheckReturnValue")
	public static class UnlabelledStatementContext extends ParserRuleContext {
		public SimpleStatementContext simpleStatement() {
			return getRuleContext(SimpleStatementContext.class,0);
		}
		public StructuredStatementContext structuredStatement() {
			return getRuleContext(StructuredStatementContext.class,0);
		}
		public UnlabelledStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unlabelledStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).enterUnlabelledStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).exitUnlabelledStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPascalGrammarVisitor ) return ((MiniPascalGrammarVisitor<? extends T>)visitor).visitUnlabelledStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnlabelledStatementContext unlabelledStatement() throws RecognitionException {
		UnlabelledStatementContext _localctx = new UnlabelledStatementContext(_ctx, getState());
		enterRule(_localctx, 126, RULE_unlabelledStatement);
		try {
			setState(546);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case END:
			case SEMICOLON:
			case ELSE:
			case UNTIL:
			case ID:
			case AT:
				enterOuterAlt(_localctx, 1);
				{
				setState(544);
				simpleStatement();
				}
				break;
			case BEGIN:
			case FUNCTION:
			case PROCEDURE:
			case IF:
			case WHILE:
			case FOR:
			case REPEAT:
				enterOuterAlt(_localctx, 2);
				{
				setState(545);
				structuredStatement();
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

	@SuppressWarnings("CheckReturnValue")
	public static class SimpleStatementContext extends ParserRuleContext {
		public AssignmentStatementContext assignmentStatement() {
			return getRuleContext(AssignmentStatementContext.class,0);
		}
		public EmptyStatement_Context emptyStatement_() {
			return getRuleContext(EmptyStatement_Context.class,0);
		}
		public SimpleStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simpleStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).enterSimpleStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).exitSimpleStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPascalGrammarVisitor ) return ((MiniPascalGrammarVisitor<? extends T>)visitor).visitSimpleStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SimpleStatementContext simpleStatement() throws RecognitionException {
		SimpleStatementContext _localctx = new SimpleStatementContext(_ctx, getState());
		enterRule(_localctx, 128, RULE_simpleStatement);
		try {
			setState(550);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
			case AT:
				enterOuterAlt(_localctx, 1);
				{
				setState(548);
				assignmentStatement();
				}
				break;
			case END:
			case SEMICOLON:
			case ELSE:
			case UNTIL:
				enterOuterAlt(_localctx, 2);
				{
				setState(549);
				emptyStatement_();
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

	@SuppressWarnings("CheckReturnValue")
	public static class AssignmentStatementContext extends ParserRuleContext {
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(MiniPascalGrammarParser.ASSIGN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public AssignmentStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignmentStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).enterAssignmentStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).exitAssignmentStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPascalGrammarVisitor ) return ((MiniPascalGrammarVisitor<? extends T>)visitor).visitAssignmentStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentStatementContext assignmentStatement() throws RecognitionException {
		AssignmentStatementContext _localctx = new AssignmentStatementContext(_ctx, getState());
		enterRule(_localctx, 130, RULE_assignmentStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(552);
			variable();
			setState(553);
			match(ASSIGN);
			setState(554);
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

	@SuppressWarnings("CheckReturnValue")
	public static class VariableContext extends ParserRuleContext {
		public TerminalNode AT() { return getToken(MiniPascalGrammarParser.AT, 0); }
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public List<TerminalNode> L_BRACK() { return getTokens(MiniPascalGrammarParser.L_BRACK); }
		public TerminalNode L_BRACK(int i) {
			return getToken(MiniPascalGrammarParser.L_BRACK, i);
		}
		public List<ExpressionListContext> expressionList() {
			return getRuleContexts(ExpressionListContext.class);
		}
		public ExpressionListContext expressionList(int i) {
			return getRuleContext(ExpressionListContext.class,i);
		}
		public List<TerminalNode> R_BRACK() { return getTokens(MiniPascalGrammarParser.R_BRACK); }
		public TerminalNode R_BRACK(int i) {
			return getToken(MiniPascalGrammarParser.R_BRACK, i);
		}
		public List<TerminalNode> DOT() { return getTokens(MiniPascalGrammarParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(MiniPascalGrammarParser.DOT, i);
		}
		public VariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).enterVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).exitVariable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPascalGrammarVisitor ) return ((MiniPascalGrammarVisitor<? extends T>)visitor).visitVariable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableContext variable() throws RecognitionException {
		VariableContext _localctx = new VariableContext(_ctx, getState());
		enterRule(_localctx, 132, RULE_variable);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(559);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case AT:
				{
				setState(556);
				match(AT);
				setState(557);
				identifier();
				}
				break;
			case ID:
				{
				setState(558);
				identifier();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(569);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==L_BRACK || _la==DOT) {
				{
				setState(567);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case L_BRACK:
					{
					setState(561);
					match(L_BRACK);
					setState(562);
					expressionList();
					setState(563);
					match(R_BRACK);
					}
					break;
				case DOT:
					{
					setState(565);
					match(DOT);
					setState(566);
					identifier();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(571);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionListContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(MiniPascalGrammarParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(MiniPascalGrammarParser.COMMA, i);
		}
		public ExpressionListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).enterExpressionList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).exitExpressionList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPascalGrammarVisitor ) return ((MiniPascalGrammarVisitor<? extends T>)visitor).visitExpressionList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionListContext expressionList() throws RecognitionException {
		ExpressionListContext _localctx = new ExpressionListContext(_ctx, getState());
		enterRule(_localctx, 134, RULE_expressionList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(572);
			expression();
			setState(577);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(573);
				match(COMMA);
				setState(574);
				expression();
				}
				}
				setState(579);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionContext extends ParserRuleContext {
		public SimpleExpressionContext simpleExpression() {
			return getRuleContext(SimpleExpressionContext.class,0);
		}
		public RelationaloperatorContext relationaloperator() {
			return getRuleContext(RelationaloperatorContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPascalGrammarVisitor ) return ((MiniPascalGrammarVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 136, RULE_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(580);
			simpleExpression();
			setState(584);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 16515072L) != 0)) {
				{
				setState(581);
				relationaloperator();
				setState(582);
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

	@SuppressWarnings("CheckReturnValue")
	public static class RelationaloperatorContext extends ParserRuleContext {
		public TerminalNode EQUAL() { return getToken(MiniPascalGrammarParser.EQUAL, 0); }
		public TerminalNode NOT_EQUAL() { return getToken(MiniPascalGrammarParser.NOT_EQUAL, 0); }
		public TerminalNode LT() { return getToken(MiniPascalGrammarParser.LT, 0); }
		public TerminalNode LE() { return getToken(MiniPascalGrammarParser.LE, 0); }
		public TerminalNode GE() { return getToken(MiniPascalGrammarParser.GE, 0); }
		public TerminalNode GT() { return getToken(MiniPascalGrammarParser.GT, 0); }
		public RelationaloperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relationaloperator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).enterRelationaloperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).exitRelationaloperator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPascalGrammarVisitor ) return ((MiniPascalGrammarVisitor<? extends T>)visitor).visitRelationaloperator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RelationaloperatorContext relationaloperator() throws RecognitionException {
		RelationaloperatorContext _localctx = new RelationaloperatorContext(_ctx, getState());
		enterRule(_localctx, 138, RULE_relationaloperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(586);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 16515072L) != 0)) ) {
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

	@SuppressWarnings("CheckReturnValue")
	public static class SimpleExpressionContext extends ParserRuleContext {
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public AdditiveoperatorContext additiveoperator() {
			return getRuleContext(AdditiveoperatorContext.class,0);
		}
		public SimpleExpressionContext simpleExpression() {
			return getRuleContext(SimpleExpressionContext.class,0);
		}
		public SimpleExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simpleExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).enterSimpleExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).exitSimpleExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPascalGrammarVisitor ) return ((MiniPascalGrammarVisitor<? extends T>)visitor).visitSimpleExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SimpleExpressionContext simpleExpression() throws RecognitionException {
		SimpleExpressionContext _localctx = new SimpleExpressionContext(_ctx, getState());
		enterRule(_localctx, 140, RULE_simpleExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(588);
			term();
			setState(592);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 166912L) != 0)) {
				{
				setState(589);
				additiveoperator();
				setState(590);
				simpleExpression();
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

	@SuppressWarnings("CheckReturnValue")
	public static class AdditiveoperatorContext extends ParserRuleContext {
		public TerminalNode PLUS() { return getToken(MiniPascalGrammarParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(MiniPascalGrammarParser.MINUS, 0); }
		public TerminalNode OR() { return getToken(MiniPascalGrammarParser.OR, 0); }
		public TerminalNode AND() { return getToken(MiniPascalGrammarParser.AND, 0); }
		public AdditiveoperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_additiveoperator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).enterAdditiveoperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).exitAdditiveoperator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPascalGrammarVisitor ) return ((MiniPascalGrammarVisitor<? extends T>)visitor).visitAdditiveoperator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AdditiveoperatorContext additiveoperator() throws RecognitionException {
		AdditiveoperatorContext _localctx = new AdditiveoperatorContext(_ctx, getState());
		enterRule(_localctx, 142, RULE_additiveoperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(594);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 166912L) != 0)) ) {
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

	@SuppressWarnings("CheckReturnValue")
	public static class TermContext extends ParserRuleContext {
		public SignedFactorContext signedFactor() {
			return getRuleContext(SignedFactorContext.class,0);
		}
		public MultiplicativeoperatorContext multiplicativeoperator() {
			return getRuleContext(MultiplicativeoperatorContext.class,0);
		}
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).enterTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).exitTerm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPascalGrammarVisitor ) return ((MiniPascalGrammarVisitor<? extends T>)visitor).visitTerm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 144, RULE_term);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(596);
			signedFactor();
			setState(600);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 28672L) != 0)) {
				{
				setState(597);
				multiplicativeoperator();
				setState(598);
				term();
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

	@SuppressWarnings("CheckReturnValue")
	public static class MultiplicativeoperatorContext extends ParserRuleContext {
		public TerminalNode MULT() { return getToken(MiniPascalGrammarParser.MULT, 0); }
		public TerminalNode DIV() { return getToken(MiniPascalGrammarParser.DIV, 0); }
		public TerminalNode MOD() { return getToken(MiniPascalGrammarParser.MOD, 0); }
		public MultiplicativeoperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiplicativeoperator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).enterMultiplicativeoperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).exitMultiplicativeoperator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPascalGrammarVisitor ) return ((MiniPascalGrammarVisitor<? extends T>)visitor).visitMultiplicativeoperator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MultiplicativeoperatorContext multiplicativeoperator() throws RecognitionException {
		MultiplicativeoperatorContext _localctx = new MultiplicativeoperatorContext(_ctx, getState());
		enterRule(_localctx, 146, RULE_multiplicativeoperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(602);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 28672L) != 0)) ) {
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

	@SuppressWarnings("CheckReturnValue")
	public static class SignedFactorContext extends ParserRuleContext {
		public FactorContext factor() {
			return getRuleContext(FactorContext.class,0);
		}
		public TerminalNode PLUS() { return getToken(MiniPascalGrammarParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(MiniPascalGrammarParser.MINUS, 0); }
		public SignedFactorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_signedFactor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).enterSignedFactor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).exitSignedFactor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPascalGrammarVisitor ) return ((MiniPascalGrammarVisitor<? extends T>)visitor).visitSignedFactor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SignedFactorContext signedFactor() throws RecognitionException {
		SignedFactorContext _localctx = new SignedFactorContext(_ctx, getState());
		enterRule(_localctx, 148, RULE_signedFactor);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(605);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PLUS || _la==MINUS) {
				{
				setState(604);
				_la = _input.LA(1);
				if ( !(_la==PLUS || _la==MINUS) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
			}

			setState(607);
			factor();
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

	@SuppressWarnings("CheckReturnValue")
	public static class FactorContext extends ParserRuleContext {
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public TerminalNode L_PAREN() { return getToken(MiniPascalGrammarParser.L_PAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode R_PAREN() { return getToken(MiniPascalGrammarParser.R_PAREN, 0); }
		public FunctionDesignatorContext functionDesignator() {
			return getRuleContext(FunctionDesignatorContext.class,0);
		}
		public UnsignedConstantContext unsignedConstant() {
			return getRuleContext(UnsignedConstantContext.class,0);
		}
		public Set_Context set_() {
			return getRuleContext(Set_Context.class,0);
		}
		public TerminalNode NOT() { return getToken(MiniPascalGrammarParser.NOT, 0); }
		public FactorContext factor() {
			return getRuleContext(FactorContext.class,0);
		}
		public Bool_Context bool_() {
			return getRuleContext(Bool_Context.class,0);
		}
		public CharContext char_() {
			return getRuleContext(CharContext.class,0);
		}
		public BooleanContext boolean_() {
			return getRuleContext(BooleanContext.class,0);
		}
		public FactorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_factor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).enterFactor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).exitFactor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPascalGrammarVisitor ) return ((MiniPascalGrammarVisitor<? extends T>)visitor).visitFactor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FactorContext factor() throws RecognitionException {
		FactorContext _localctx = new FactorContext(_ctx, getState());
		enterRule(_localctx, 150, RULE_factor);
		try {
			setState(622);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,44,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(609);
				variable();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(610);
				match(L_PAREN);
				setState(611);
				expression();
				setState(612);
				match(R_PAREN);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(614);
				functionDesignator();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(615);
				unsignedConstant();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(616);
				set_();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(617);
				match(NOT);
				setState(618);
				factor();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(619);
				bool_();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(620);
				char_();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(621);
				boolean_();
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

	@SuppressWarnings("CheckReturnValue")
	public static class UnsignedConstantContext extends ParserRuleContext {
		public UnsignedNumberContext unsignedNumber() {
			return getRuleContext(UnsignedNumberContext.class,0);
		}
		public ConstantChrContext constantChr() {
			return getRuleContext(ConstantChrContext.class,0);
		}
		public StringContext string() {
			return getRuleContext(StringContext.class,0);
		}
		public TerminalNode NIL() { return getToken(MiniPascalGrammarParser.NIL, 0); }
		public UnsignedConstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unsignedConstant; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).enterUnsignedConstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).exitUnsignedConstant(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPascalGrammarVisitor ) return ((MiniPascalGrammarVisitor<? extends T>)visitor).visitUnsignedConstant(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnsignedConstantContext unsignedConstant() throws RecognitionException {
		UnsignedConstantContext _localctx = new UnsignedConstantContext(_ctx, getState());
		enterRule(_localctx, 152, RULE_unsignedConstant);
		try {
			setState(628);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INTEGER:
				enterOuterAlt(_localctx, 1);
				{
				setState(624);
				unsignedNumber();
				}
				break;
			case CHR:
				enterOuterAlt(_localctx, 2);
				{
				setState(625);
				constantChr();
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 3);
				{
				setState(626);
				string();
				}
				break;
			case NIL:
				enterOuterAlt(_localctx, 4);
				{
				setState(627);
				match(NIL);
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

	@SuppressWarnings("CheckReturnValue")
	public static class FunctionDesignatorContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode L_PAREN() { return getToken(MiniPascalGrammarParser.L_PAREN, 0); }
		public ParameterListContext parameterList() {
			return getRuleContext(ParameterListContext.class,0);
		}
		public TerminalNode R_PAREN() { return getToken(MiniPascalGrammarParser.R_PAREN, 0); }
		public FunctionDesignatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDesignator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).enterFunctionDesignator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).exitFunctionDesignator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPascalGrammarVisitor ) return ((MiniPascalGrammarVisitor<? extends T>)visitor).visitFunctionDesignator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionDesignatorContext functionDesignator() throws RecognitionException {
		FunctionDesignatorContext _localctx = new FunctionDesignatorContext(_ctx, getState());
		enterRule(_localctx, 154, RULE_functionDesignator);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(630);
			identifier();
			setState(631);
			match(L_PAREN);
			setState(632);
			parameterList();
			setState(633);
			match(R_PAREN);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ParameterListContext extends ParserRuleContext {
		public List<ActualParameterContext> actualParameter() {
			return getRuleContexts(ActualParameterContext.class);
		}
		public ActualParameterContext actualParameter(int i) {
			return getRuleContext(ActualParameterContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(MiniPascalGrammarParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(MiniPascalGrammarParser.COMMA, i);
		}
		public ParameterListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameterList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).enterParameterList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).exitParameterList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPascalGrammarVisitor ) return ((MiniPascalGrammarVisitor<? extends T>)visitor).visitParameterList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParameterListContext parameterList() throws RecognitionException {
		ParameterListContext _localctx = new ParameterListContext(_ctx, getState());
		enterRule(_localctx, 156, RULE_parameterList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(635);
			actualParameter();
			setState(640);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(636);
				match(COMMA);
				setState(637);
				actualParameter();
				}
				}
				setState(642);
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

	@SuppressWarnings("CheckReturnValue")
	public static class Set_Context extends ParserRuleContext {
		public TerminalNode L_BRACK() { return getToken(MiniPascalGrammarParser.L_BRACK, 0); }
		public ElementListContext elementList() {
			return getRuleContext(ElementListContext.class,0);
		}
		public TerminalNode R_BRACK() { return getToken(MiniPascalGrammarParser.R_BRACK, 0); }
		public Set_Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_set_; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).enterSet_(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).exitSet_(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPascalGrammarVisitor ) return ((MiniPascalGrammarVisitor<? extends T>)visitor).visitSet_(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Set_Context set_() throws RecognitionException {
		Set_Context _localctx = new Set_Context(_ctx, getState());
		enterRule(_localctx, 158, RULE_set_);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(643);
			match(L_BRACK);
			setState(644);
			elementList();
			setState(645);
			match(R_BRACK);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ElementListContext extends ParserRuleContext {
		public List<ElementContext> element() {
			return getRuleContexts(ElementContext.class);
		}
		public ElementContext element(int i) {
			return getRuleContext(ElementContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(MiniPascalGrammarParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(MiniPascalGrammarParser.COMMA, i);
		}
		public ElementListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elementList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).enterElementList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).exitElementList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPascalGrammarVisitor ) return ((MiniPascalGrammarVisitor<? extends T>)visitor).visitElementList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElementListContext elementList() throws RecognitionException {
		ElementListContext _localctx = new ElementListContext(_ctx, getState());
		enterRule(_localctx, 160, RULE_elementList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(647);
			element();
			setState(652);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(648);
				match(COMMA);
				setState(649);
				element();
				}
				}
				setState(654);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ElementContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode DOUBLE_DOT() { return getToken(MiniPascalGrammarParser.DOUBLE_DOT, 0); }
		public ElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_element; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).enterElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).exitElement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPascalGrammarVisitor ) return ((MiniPascalGrammarVisitor<? extends T>)visitor).visitElement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElementContext element() throws RecognitionException {
		ElementContext _localctx = new ElementContext(_ctx, getState());
		enterRule(_localctx, 162, RULE_element);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(655);
			expression();
			setState(658);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DOUBLE_DOT) {
				{
				setState(656);
				match(DOUBLE_DOT);
				setState(657);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ActualParameterContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<ParameterwidthContext> parameterwidth() {
			return getRuleContexts(ParameterwidthContext.class);
		}
		public ParameterwidthContext parameterwidth(int i) {
			return getRuleContext(ParameterwidthContext.class,i);
		}
		public ActualParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_actualParameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).enterActualParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).exitActualParameter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPascalGrammarVisitor ) return ((MiniPascalGrammarVisitor<? extends T>)visitor).visitActualParameter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ActualParameterContext actualParameter() throws RecognitionException {
		ActualParameterContext _localctx = new ActualParameterContext(_ctx, getState());
		enterRule(_localctx, 164, RULE_actualParameter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(660);
			expression();
			setState(664);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COLON) {
				{
				{
				setState(661);
				parameterwidth();
				}
				}
				setState(666);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ParameterwidthContext extends ParserRuleContext {
		public TerminalNode COLON() { return getToken(MiniPascalGrammarParser.COLON, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ParameterwidthContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameterwidth; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).enterParameterwidth(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).exitParameterwidth(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPascalGrammarVisitor ) return ((MiniPascalGrammarVisitor<? extends T>)visitor).visitParameterwidth(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParameterwidthContext parameterwidth() throws RecognitionException {
		ParameterwidthContext _localctx = new ParameterwidthContext(_ctx, getState());
		enterRule(_localctx, 166, RULE_parameterwidth);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(667);
			match(COLON);
			setState(668);
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

	@SuppressWarnings("CheckReturnValue")
	public static class EmptyStatement_Context extends ParserRuleContext {
		public EmptyStatement_Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_emptyStatement_; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).enterEmptyStatement_(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).exitEmptyStatement_(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPascalGrammarVisitor ) return ((MiniPascalGrammarVisitor<? extends T>)visitor).visitEmptyStatement_(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EmptyStatement_Context emptyStatement_() throws RecognitionException {
		EmptyStatement_Context _localctx = new EmptyStatement_Context(_ctx, getState());
		enterRule(_localctx, 168, RULE_emptyStatement_);
		try {
			enterOuterAlt(_localctx, 1);
			{
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

	@SuppressWarnings("CheckReturnValue")
	public static class StructuredStatementContext extends ParserRuleContext {
		public CompoundStatementContext compoundStatement() {
			return getRuleContext(CompoundStatementContext.class,0);
		}
		public ConditionalStatementContext conditionalStatement() {
			return getRuleContext(ConditionalStatementContext.class,0);
		}
		public RepetitiveStatementContext repetitiveStatement() {
			return getRuleContext(RepetitiveStatementContext.class,0);
		}
		public StructuredStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_structuredStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).enterStructuredStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).exitStructuredStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPascalGrammarVisitor ) return ((MiniPascalGrammarVisitor<? extends T>)visitor).visitStructuredStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StructuredStatementContext structuredStatement() throws RecognitionException {
		StructuredStatementContext _localctx = new StructuredStatementContext(_ctx, getState());
		enterRule(_localctx, 170, RULE_structuredStatement);
		try {
			setState(675);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BEGIN:
			case FUNCTION:
			case PROCEDURE:
				enterOuterAlt(_localctx, 1);
				{
				setState(672);
				compoundStatement();
				}
				break;
			case IF:
				enterOuterAlt(_localctx, 2);
				{
				setState(673);
				conditionalStatement();
				}
				break;
			case WHILE:
			case FOR:
			case REPEAT:
				enterOuterAlt(_localctx, 3);
				{
				setState(674);
				repetitiveStatement();
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

	@SuppressWarnings("CheckReturnValue")
	public static class CompoundStatementContext extends ParserRuleContext {
		public TerminalNode BEGIN() { return getToken(MiniPascalGrammarParser.BEGIN, 0); }
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public TerminalNode END() { return getToken(MiniPascalGrammarParser.END, 0); }
		public ProcedureOrFunctionDeclarationContext procedureOrFunctionDeclaration() {
			return getRuleContext(ProcedureOrFunctionDeclarationContext.class,0);
		}
		public CompoundStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compoundStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).enterCompoundStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).exitCompoundStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPascalGrammarVisitor ) return ((MiniPascalGrammarVisitor<? extends T>)visitor).visitCompoundStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CompoundStatementContext compoundStatement() throws RecognitionException {
		CompoundStatementContext _localctx = new CompoundStatementContext(_ctx, getState());
		enterRule(_localctx, 172, RULE_compoundStatement);
		try {
			setState(682);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BEGIN:
				enterOuterAlt(_localctx, 1);
				{
				setState(677);
				match(BEGIN);
				setState(678);
				statements();
				setState(679);
				match(END);
				}
				break;
			case FUNCTION:
			case PROCEDURE:
				enterOuterAlt(_localctx, 2);
				{
				setState(681);
				procedureOrFunctionDeclaration();
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

	@SuppressWarnings("CheckReturnValue")
	public static class StatementsContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<TerminalNode> SEMICOLON() { return getTokens(MiniPascalGrammarParser.SEMICOLON); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(MiniPascalGrammarParser.SEMICOLON, i);
		}
		public StatementsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statements; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).enterStatements(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).exitStatements(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPascalGrammarVisitor ) return ((MiniPascalGrammarVisitor<? extends T>)visitor).visitStatements(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementsContext statements() throws RecognitionException {
		StatementsContext _localctx = new StatementsContext(_ctx, getState());
		enterRule(_localctx, 174, RULE_statements);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(684);
			statement();
			setState(689);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SEMICOLON) {
				{
				{
				setState(685);
				match(SEMICOLON);
				setState(686);
				statement();
				}
				}
				setState(691);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ConditionalStatementContext extends ParserRuleContext {
		public IfStatementContext ifStatement() {
			return getRuleContext(IfStatementContext.class,0);
		}
		public ConditionalStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conditionalStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).enterConditionalStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).exitConditionalStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPascalGrammarVisitor ) return ((MiniPascalGrammarVisitor<? extends T>)visitor).visitConditionalStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditionalStatementContext conditionalStatement() throws RecognitionException {
		ConditionalStatementContext _localctx = new ConditionalStatementContext(_ctx, getState());
		enterRule(_localctx, 176, RULE_conditionalStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(692);
			ifStatement();
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

	@SuppressWarnings("CheckReturnValue")
	public static class IfStatementContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(MiniPascalGrammarParser.IF, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode THEN() { return getToken(MiniPascalGrammarParser.THEN, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(MiniPascalGrammarParser.ELSE, 0); }
		public IfStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).enterIfStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).exitIfStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPascalGrammarVisitor ) return ((MiniPascalGrammarVisitor<? extends T>)visitor).visitIfStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfStatementContext ifStatement() throws RecognitionException {
		IfStatementContext _localctx = new IfStatementContext(_ctx, getState());
		enterRule(_localctx, 178, RULE_ifStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(694);
			match(IF);
			setState(695);
			expression();
			setState(696);
			match(THEN);
			setState(697);
			statement();
			setState(700);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,53,_ctx) ) {
			case 1:
				{
				setState(698);
				match(ELSE);
				setState(699);
				statement();
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

	@SuppressWarnings("CheckReturnValue")
	public static class RepetitiveStatementContext extends ParserRuleContext {
		public WhileStatementContext whileStatement() {
			return getRuleContext(WhileStatementContext.class,0);
		}
		public RepeatStatementContext repeatStatement() {
			return getRuleContext(RepeatStatementContext.class,0);
		}
		public ForStatementContext forStatement() {
			return getRuleContext(ForStatementContext.class,0);
		}
		public RepetitiveStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_repetitiveStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).enterRepetitiveStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).exitRepetitiveStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPascalGrammarVisitor ) return ((MiniPascalGrammarVisitor<? extends T>)visitor).visitRepetitiveStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RepetitiveStatementContext repetitiveStatement() throws RecognitionException {
		RepetitiveStatementContext _localctx = new RepetitiveStatementContext(_ctx, getState());
		enterRule(_localctx, 180, RULE_repetitiveStatement);
		try {
			setState(705);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case WHILE:
				enterOuterAlt(_localctx, 1);
				{
				setState(702);
				whileStatement();
				}
				break;
			case REPEAT:
				enterOuterAlt(_localctx, 2);
				{
				setState(703);
				repeatStatement();
				}
				break;
			case FOR:
				enterOuterAlt(_localctx, 3);
				{
				setState(704);
				forStatement();
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

	@SuppressWarnings("CheckReturnValue")
	public static class WhileStatementContext extends ParserRuleContext {
		public TerminalNode WHILE() { return getToken(MiniPascalGrammarParser.WHILE, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode DO() { return getToken(MiniPascalGrammarParser.DO, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public WhileStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).enterWhileStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).exitWhileStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPascalGrammarVisitor ) return ((MiniPascalGrammarVisitor<? extends T>)visitor).visitWhileStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhileStatementContext whileStatement() throws RecognitionException {
		WhileStatementContext _localctx = new WhileStatementContext(_ctx, getState());
		enterRule(_localctx, 182, RULE_whileStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(707);
			match(WHILE);
			setState(708);
			expression();
			setState(709);
			match(DO);
			setState(710);
			statement();
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

	@SuppressWarnings("CheckReturnValue")
	public static class RepeatStatementContext extends ParserRuleContext {
		public TerminalNode REPEAT() { return getToken(MiniPascalGrammarParser.REPEAT, 0); }
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public TerminalNode UNTIL() { return getToken(MiniPascalGrammarParser.UNTIL, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public RepeatStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_repeatStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).enterRepeatStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).exitRepeatStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPascalGrammarVisitor ) return ((MiniPascalGrammarVisitor<? extends T>)visitor).visitRepeatStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RepeatStatementContext repeatStatement() throws RecognitionException {
		RepeatStatementContext _localctx = new RepeatStatementContext(_ctx, getState());
		enterRule(_localctx, 184, RULE_repeatStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(712);
			match(REPEAT);
			setState(713);
			statements();
			setState(714);
			match(UNTIL);
			setState(715);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ForStatementContext extends ParserRuleContext {
		public TerminalNode FOR() { return getToken(MiniPascalGrammarParser.FOR, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(MiniPascalGrammarParser.ASSIGN, 0); }
		public ForListContext forList() {
			return getRuleContext(ForListContext.class,0);
		}
		public TerminalNode DO() { return getToken(MiniPascalGrammarParser.DO, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public ForStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).enterForStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).exitForStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPascalGrammarVisitor ) return ((MiniPascalGrammarVisitor<? extends T>)visitor).visitForStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForStatementContext forStatement() throws RecognitionException {
		ForStatementContext _localctx = new ForStatementContext(_ctx, getState());
		enterRule(_localctx, 186, RULE_forStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(717);
			match(FOR);
			setState(718);
			identifier();
			setState(719);
			match(ASSIGN);
			setState(720);
			forList();
			setState(721);
			match(DO);
			setState(722);
			statement();
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

	@SuppressWarnings("CheckReturnValue")
	public static class ForListContext extends ParserRuleContext {
		public InitialValueContext initialValue() {
			return getRuleContext(InitialValueContext.class,0);
		}
		public FinalValueContext finalValue() {
			return getRuleContext(FinalValueContext.class,0);
		}
		public TerminalNode TO() { return getToken(MiniPascalGrammarParser.TO, 0); }
		public TerminalNode DOWNTO() { return getToken(MiniPascalGrammarParser.DOWNTO, 0); }
		public ForListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).enterForList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).exitForList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPascalGrammarVisitor ) return ((MiniPascalGrammarVisitor<? extends T>)visitor).visitForList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForListContext forList() throws RecognitionException {
		ForListContext _localctx = new ForListContext(_ctx, getState());
		enterRule(_localctx, 188, RULE_forList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(724);
			initialValue();
			setState(725);
			_la = _input.LA(1);
			if ( !(_la==TO || _la==DOWNTO) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(726);
			finalValue();
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

	@SuppressWarnings("CheckReturnValue")
	public static class InitialValueContext extends ParserRuleContext {
		public ArrayInitializationContext arrayInitialization() {
			return getRuleContext(ArrayInitializationContext.class,0);
		}
		public ConstantContext constant() {
			return getRuleContext(ConstantContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public InitialValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_initialValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).enterInitialValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).exitInitialValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPascalGrammarVisitor ) return ((MiniPascalGrammarVisitor<? extends T>)visitor).visitInitialValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InitialValueContext initialValue() throws RecognitionException {
		InitialValueContext _localctx = new InitialValueContext(_ctx, getState());
		enterRule(_localctx, 190, RULE_initialValue);
		try {
			setState(731);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case L_PAREN:
				enterOuterAlt(_localctx, 1);
				{
				setState(728);
				arrayInitialization();
				}
				break;
			case INTEGER:
			case BOOLEAN:
			case CHAR:
			case STRING:
			case PLUS:
			case MINUS:
			case CHR:
				enterOuterAlt(_localctx, 2);
				{
				setState(729);
				constant();
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 3);
				{
				setState(730);
				identifier();
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

	@SuppressWarnings("CheckReturnValue")
	public static class ArrayInitializationContext extends ParserRuleContext {
		public TerminalNode L_PAREN() { return getToken(MiniPascalGrammarParser.L_PAREN, 0); }
		public ConstListContext constList() {
			return getRuleContext(ConstListContext.class,0);
		}
		public TerminalNode R_PAREN() { return getToken(MiniPascalGrammarParser.R_PAREN, 0); }
		public ArrayInitializationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayInitialization; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).enterArrayInitialization(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).exitArrayInitialization(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPascalGrammarVisitor ) return ((MiniPascalGrammarVisitor<? extends T>)visitor).visitArrayInitialization(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayInitializationContext arrayInitialization() throws RecognitionException {
		ArrayInitializationContext _localctx = new ArrayInitializationContext(_ctx, getState());
		enterRule(_localctx, 192, RULE_arrayInitialization);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(733);
			match(L_PAREN);
			setState(734);
			constList();
			setState(735);
			match(R_PAREN);
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

	@SuppressWarnings("CheckReturnValue")
	public static class FinalValueContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public FinalValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_finalValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).enterFinalValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniPascalGrammarListener ) ((MiniPascalGrammarListener)listener).exitFinalValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniPascalGrammarVisitor ) return ((MiniPascalGrammarVisitor<? extends T>)visitor).visitFinalValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FinalValueContext finalValue() throws RecognitionException {
		FinalValueContext _localctx = new FinalValueContext(_ctx, getState());
		enterRule(_localctx, 194, RULE_finalValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(737);
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

	public static final String _serializedATN =
		"\u0004\u0001A\u02e4\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b"+
		"\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007\u001e"+
		"\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007!\u0002\"\u0007\"\u0002"+
		"#\u0007#\u0002$\u0007$\u0002%\u0007%\u0002&\u0007&\u0002\'\u0007\'\u0002"+
		"(\u0007(\u0002)\u0007)\u0002*\u0007*\u0002+\u0007+\u0002,\u0007,\u0002"+
		"-\u0007-\u0002.\u0007.\u0002/\u0007/\u00020\u00070\u00021\u00071\u0002"+
		"2\u00072\u00023\u00073\u00024\u00074\u00025\u00075\u00026\u00076\u0002"+
		"7\u00077\u00028\u00078\u00029\u00079\u0002:\u0007:\u0002;\u0007;\u0002"+
		"<\u0007<\u0002=\u0007=\u0002>\u0007>\u0002?\u0007?\u0002@\u0007@\u0002"+
		"A\u0007A\u0002B\u0007B\u0002C\u0007C\u0002D\u0007D\u0002E\u0007E\u0002"+
		"F\u0007F\u0002G\u0007G\u0002H\u0007H\u0002I\u0007I\u0002J\u0007J\u0002"+
		"K\u0007K\u0002L\u0007L\u0002M\u0007M\u0002N\u0007N\u0002O\u0007O\u0002"+
		"P\u0007P\u0002Q\u0007Q\u0002R\u0007R\u0002S\u0007S\u0002T\u0007T\u0002"+
		"U\u0007U\u0002V\u0007V\u0002W\u0007W\u0002X\u0007X\u0002Y\u0007Y\u0002"+
		"Z\u0007Z\u0002[\u0007[\u0002\\\u0007\\\u0002]\u0007]\u0002^\u0007^\u0002"+
		"_\u0007_\u0002`\u0007`\u0002a\u0007a\u0001\u0000\u0001\u0000\u0003\u0000"+
		"\u00c7\b\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001"+
		"\u00d3\b\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001"+
		"\u00d9\b\u0001\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0005\u0003\u00e4\b\u0003"+
		"\n\u0003\f\u0003\u00e7\t\u0003\u0001\u0003\u0005\u0003\u00ea\b\u0003\n"+
		"\u0003\f\u0003\u00ed\t\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0004\u0004\u00f3\b\u0004\u000b\u0004\f\u0004\u00f4\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0003\u0007\u010b\b\u0007\u0001\b\u0001\b\u0001\b\u0001\b"+
		"\u0001\b\u0001\b\u0003\b\u0113\b\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0005\f\u0128"+
		"\b\f\n\f\f\f\u012b\t\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\u000e\u0001"+
		"\u000e\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0011\u0001"+
		"\u0011\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0014\u0001"+
		"\u0014\u0001\u0015\u0001\u0015\u0001\u0016\u0001\u0016\u0001\u0017\u0001"+
		"\u0017\u0001\u0018\u0001\u0018\u0001\u0019\u0001\u0019\u0001\u001a\u0001"+
		"\u001a\u0001\u001a\u0001\u001a\u0004\u001a\u014d\b\u001a\u000b\u001a\f"+
		"\u001a\u014e\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0003\u001b"+
		"\u0155\b\u001b\u0001\u001c\u0001\u001c\u0003\u001c\u0159\b\u001c\u0001"+
		"\u001c\u0001\u001c\u0001\u001c\u0001\u001d\u0001\u001d\u0003\u001d\u0160"+
		"\b\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001e\u0001\u001e\u0003"+
		"\u001e\u0167\b\u001e\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0003"+
		"\u001f\u016d\b\u001f\u0001 \u0001 \u0001 \u0001 \u0001!\u0001!\u0001!"+
		"\u0001!\u0001\"\u0001\"\u0001#\u0001#\u0001#\u0001#\u0003#\u017d\b#\u0001"+
		"#\u0001#\u0001$\u0001$\u0001$\u0005$\u0184\b$\n$\f$\u0187\t$\u0001%\u0001"+
		"%\u0001&\u0001&\u0001\'\u0001\'\u0001\'\u0005\'\u0190\b\'\n\'\f\'\u0193"+
		"\t\'\u0001(\u0001(\u0001(\u0001(\u0001)\u0001)\u0001)\u0001)\u0001)\u0003"+
		")\u019e\b)\u0001*\u0001*\u0001+\u0001+\u0001+\u0001+\u0005+\u01a6\b+\n"+
		"+\f+\u01a9\t+\u0001+\u0001+\u0001,\u0001,\u0001,\u0001,\u0001,\u0003,"+
		"\u01b2\b,\u0001-\u0001-\u0001-\u0001.\u0001.\u0003.\u01b9\b.\u0001/\u0001"+
		"/\u0001/\u0001/\u0005/\u01bf\b/\n/\f/\u01c2\t/\u0001/\u0001/\u00010\u0001"+
		"0\u00010\u00010\u00010\u00030\u01cb\b0\u00011\u00011\u00011\u00011\u0001"+
		"1\u00031\u01d2\b1\u00012\u00012\u00012\u00052\u01d7\b2\n2\f2\u01da\t2"+
		"\u00013\u00013\u00013\u00053\u01df\b3\n3\f3\u01e2\t3\u00014\u00014\u0001"+
		"4\u00014\u00014\u00014\u00014\u00014\u00015\u00015\u00015\u00015\u0001"+
		"5\u00015\u00016\u00016\u00017\u00017\u00017\u00017\u00037\u01f8\b7\u0001"+
		"8\u00018\u00018\u00018\u00018\u00058\u01ff\b8\n8\f8\u0202\t8\u00038\u0204"+
		"\b8\u00018\u00018\u00019\u00019\u0001:\u0001:\u0001:\u0003:\u020d\b:\u0001"+
		";\u0001;\u0001;\u0001;\u0003;\u0213\b;\u0001<\u0001<\u0001<\u0001<\u0001"+
		"<\u0001=\u0001=\u0001>\u0001>\u0001>\u0003>\u021f\b>\u0001?\u0001?\u0003"+
		"?\u0223\b?\u0001@\u0001@\u0003@\u0227\b@\u0001A\u0001A\u0001A\u0001A\u0001"+
		"B\u0001B\u0001B\u0003B\u0230\bB\u0001B\u0001B\u0001B\u0001B\u0001B\u0001"+
		"B\u0005B\u0238\bB\nB\fB\u023b\tB\u0001C\u0001C\u0001C\u0005C\u0240\bC"+
		"\nC\fC\u0243\tC\u0001D\u0001D\u0001D\u0001D\u0003D\u0249\bD\u0001E\u0001"+
		"E\u0001F\u0001F\u0001F\u0001F\u0003F\u0251\bF\u0001G\u0001G\u0001H\u0001"+
		"H\u0001H\u0001H\u0003H\u0259\bH\u0001I\u0001I\u0001J\u0003J\u025e\bJ\u0001"+
		"J\u0001J\u0001K\u0001K\u0001K\u0001K\u0001K\u0001K\u0001K\u0001K\u0001"+
		"K\u0001K\u0001K\u0001K\u0001K\u0003K\u026f\bK\u0001L\u0001L\u0001L\u0001"+
		"L\u0003L\u0275\bL\u0001M\u0001M\u0001M\u0001M\u0001M\u0001N\u0001N\u0001"+
		"N\u0005N\u027f\bN\nN\fN\u0282\tN\u0001O\u0001O\u0001O\u0001O\u0001P\u0001"+
		"P\u0001P\u0005P\u028b\bP\nP\fP\u028e\tP\u0001Q\u0001Q\u0001Q\u0003Q\u0293"+
		"\bQ\u0001R\u0001R\u0005R\u0297\bR\nR\fR\u029a\tR\u0001S\u0001S\u0001S"+
		"\u0001T\u0001T\u0001U\u0001U\u0001U\u0003U\u02a4\bU\u0001V\u0001V\u0001"+
		"V\u0001V\u0001V\u0003V\u02ab\bV\u0001W\u0001W\u0001W\u0005W\u02b0\bW\n"+
		"W\fW\u02b3\tW\u0001X\u0001X\u0001Y\u0001Y\u0001Y\u0001Y\u0001Y\u0001Y"+
		"\u0003Y\u02bd\bY\u0001Z\u0001Z\u0001Z\u0003Z\u02c2\bZ\u0001[\u0001[\u0001"+
		"[\u0001[\u0001[\u0001\\\u0001\\\u0001\\\u0001\\\u0001\\\u0001]\u0001]"+
		"\u0001]\u0001]\u0001]\u0001]\u0001]\u0001^\u0001^\u0001^\u0001^\u0001"+
		"_\u0001_\u0001_\u0003_\u02dc\b_\u0001`\u0001`\u0001`\u0001`\u0001a\u0001"+
		"a\u0001a\u0000\u0000b\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012"+
		"\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*,.02468:<>@BDFHJLNPRTVXZ\\"+
		"^`bdfhjlnprtvxz|~\u0080\u0082\u0084\u0086\u0088\u008a\u008c\u008e\u0090"+
		"\u0092\u0094\u0096\u0098\u009a\u009c\u009e\u00a0\u00a2\u00a4\u00a6\u00a8"+
		"\u00aa\u00ac\u00ae\u00b0\u00b2\u00b4\u00b6\u00b8\u00ba\u00bc\u00be\u00c0"+
		"\u00c2\u0000\b\u0001\u0000\n\u000b\u0001\u000025\u0001\u000089\u0001\u0000"+
		"67\u0001\u0000\u0012\u0017\u0003\u0000\n\u000b\u000f\u000f\u0011\u0011"+
		"\u0001\u0000\f\u000e\u0002\u0000++--\u02dc\u0000\u00c4\u0001\u0000\u0000"+
		"\u0000\u0002\u00d8\u0001\u0000\u0000\u0000\u0004\u00da\u0001\u0000\u0000"+
		"\u0000\u0006\u00e5\u0001\u0000\u0000\u0000\b\u00ee\u0001\u0000\u0000\u0000"+
		"\n\u00f6\u0001\u0000\u0000\u0000\f\u00fa\u0001\u0000\u0000\u0000\u000e"+
		"\u010a\u0001\u0000\u0000\u0000\u0010\u0112\u0001\u0000\u0000\u0000\u0012"+
		"\u0114\u0001\u0000\u0000\u0000\u0014\u011b\u0001\u0000\u0000\u0000\u0016"+
		"\u011f\u0001\u0000\u0000\u0000\u0018\u0124\u0001\u0000\u0000\u0000\u001a"+
		"\u012c\u0001\u0000\u0000\u0000\u001c\u0130\u0001\u0000\u0000\u0000\u001e"+
		"\u0132\u0001\u0000\u0000\u0000 \u0134\u0001\u0000\u0000\u0000\"\u0136"+
		"\u0001\u0000\u0000\u0000$\u0138\u0001\u0000\u0000\u0000&\u013a\u0001\u0000"+
		"\u0000\u0000(\u013c\u0001\u0000\u0000\u0000*\u013e\u0001\u0000\u0000\u0000"+
		",\u0140\u0001\u0000\u0000\u0000.\u0142\u0001\u0000\u0000\u00000\u0144"+
		"\u0001\u0000\u0000\u00002\u0146\u0001\u0000\u0000\u00004\u0148\u0001\u0000"+
		"\u0000\u00006\u0150\u0001\u0000\u0000\u00008\u0156\u0001\u0000\u0000\u0000"+
		":\u015d\u0001\u0000\u0000\u0000<\u0166\u0001\u0000\u0000\u0000>\u016c"+
		"\u0001\u0000\u0000\u0000@\u016e\u0001\u0000\u0000\u0000B\u0172\u0001\u0000"+
		"\u0000\u0000D\u0176\u0001\u0000\u0000\u0000F\u0178\u0001\u0000\u0000\u0000"+
		"H\u0180\u0001\u0000\u0000\u0000J\u0188\u0001\u0000\u0000\u0000L\u018a"+
		"\u0001\u0000\u0000\u0000N\u018c\u0001\u0000\u0000\u0000P\u0194\u0001\u0000"+
		"\u0000\u0000R\u019d\u0001\u0000\u0000\u0000T\u019f\u0001\u0000\u0000\u0000"+
		"V\u01a1\u0001\u0000\u0000\u0000X\u01ac\u0001\u0000\u0000\u0000Z\u01b3"+
		"\u0001\u0000\u0000\u0000\\\u01b8\u0001\u0000\u0000\u0000^\u01ba\u0001"+
		"\u0000\u0000\u0000`\u01ca\u0001\u0000\u0000\u0000b\u01d1\u0001\u0000\u0000"+
		"\u0000d\u01d3\u0001\u0000\u0000\u0000f\u01db\u0001\u0000\u0000\u0000h"+
		"\u01e3\u0001\u0000\u0000\u0000j\u01eb\u0001\u0000\u0000\u0000l\u01f1\u0001"+
		"\u0000\u0000\u0000n\u01f7\u0001\u0000\u0000\u0000p\u01f9\u0001\u0000\u0000"+
		"\u0000r\u0207\u0001\u0000\u0000\u0000t\u020c\u0001\u0000\u0000\u0000v"+
		"\u0212\u0001\u0000\u0000\u0000x\u0214\u0001\u0000\u0000\u0000z\u0219\u0001"+
		"\u0000\u0000\u0000|\u021e\u0001\u0000\u0000\u0000~\u0222\u0001\u0000\u0000"+
		"\u0000\u0080\u0226\u0001\u0000\u0000\u0000\u0082\u0228\u0001\u0000\u0000"+
		"\u0000\u0084\u022f\u0001\u0000\u0000\u0000\u0086\u023c\u0001\u0000\u0000"+
		"\u0000\u0088\u0244\u0001\u0000\u0000\u0000\u008a\u024a\u0001\u0000\u0000"+
		"\u0000\u008c\u024c\u0001\u0000\u0000\u0000\u008e\u0252\u0001\u0000\u0000"+
		"\u0000\u0090\u0254\u0001\u0000\u0000\u0000\u0092\u025a\u0001\u0000\u0000"+
		"\u0000\u0094\u025d\u0001\u0000\u0000\u0000\u0096\u026e\u0001\u0000\u0000"+
		"\u0000\u0098\u0274\u0001\u0000\u0000\u0000\u009a\u0276\u0001\u0000\u0000"+
		"\u0000\u009c\u027b\u0001\u0000\u0000\u0000\u009e\u0283\u0001\u0000\u0000"+
		"\u0000\u00a0\u0287\u0001\u0000\u0000\u0000\u00a2\u028f\u0001\u0000\u0000"+
		"\u0000\u00a4\u0294\u0001\u0000\u0000\u0000\u00a6\u029b\u0001\u0000\u0000"+
		"\u0000\u00a8\u029e\u0001\u0000\u0000\u0000\u00aa\u02a3\u0001\u0000\u0000"+
		"\u0000\u00ac\u02aa\u0001\u0000\u0000\u0000\u00ae\u02ac\u0001\u0000\u0000"+
		"\u0000\u00b0\u02b4\u0001\u0000\u0000\u0000\u00b2\u02b6\u0001\u0000\u0000"+
		"\u0000\u00b4\u02c1\u0001\u0000\u0000\u0000\u00b6\u02c3\u0001\u0000\u0000"+
		"\u0000\u00b8\u02c8\u0001\u0000\u0000\u0000\u00ba\u02cd\u0001\u0000\u0000"+
		"\u0000\u00bc\u02d4\u0001\u0000\u0000\u0000\u00be\u02db\u0001\u0000\u0000"+
		"\u0000\u00c0\u02dd\u0001\u0000\u0000\u0000\u00c2\u02e1\u0001\u0000\u0000"+
		"\u0000\u00c4\u00c6\u0003\u0002\u0001\u0000\u00c5\u00c7\u0005;\u0000\u0000"+
		"\u00c6\u00c5\u0001\u0000\u0000\u0000\u00c6\u00c7\u0001\u0000\u0000\u0000"+
		"\u00c7\u00c8\u0001\u0000\u0000\u0000\u00c8\u00c9\u0003\u0006\u0003\u0000"+
		"\u00c9\u00ca\u0005\u001f\u0000\u0000\u00ca\u00cb\u0005\u0000\u0000\u0001"+
		"\u00cb\u0001\u0001\u0000\u0000\u0000\u00cc\u00cd\u0005!\u0000\u0000\u00cd"+
		"\u00d2\u0003\u0004\u0002\u0000\u00ce\u00cf\u0005\u0018\u0000\u0000\u00cf"+
		"\u00d0\u0003d2\u0000\u00d0\u00d1\u0005\u0019\u0000\u0000\u00d1\u00d3\u0001"+
		"\u0000\u0000\u0000\u00d2\u00ce\u0001\u0000\u0000\u0000\u00d2\u00d3\u0001"+
		"\u0000\u0000\u0000\u00d3\u00d4\u0001\u0000\u0000\u0000\u00d4\u00d5\u0005"+
		"\u001d\u0000\u0000\u00d5\u00d9\u0001\u0000\u0000\u0000\u00d6\u00d9\u0005"+
		"#\u0000\u0000\u00d7\u00d9\u0005\"\u0000\u0000\u00d8\u00cc\u0001\u0000"+
		"\u0000\u0000\u00d8\u00d6\u0001\u0000\u0000\u0000\u00d8\u00d7\u0001\u0000"+
		"\u0000\u0000\u00d9\u0003\u0001\u0000\u0000\u0000\u00da\u00db\u0005>\u0000"+
		"\u0000\u00db\u0005\u0001\u0000\u0000\u0000\u00dc\u00e4\u0003\b\u0004\u0000"+
		"\u00dd\u00e4\u00034\u001a\u0000\u00de\u00e4\u0003V+\u0000\u00df\u00e4"+
		"\u0003Z-\u0000\u00e0\u00e4\u0005<\u0000\u0000\u00e1\u00e2\u0005/\u0000"+
		"\u0000\u00e2\u00e4\u0005\u001d\u0000\u0000\u00e3\u00dc\u0001\u0000\u0000"+
		"\u0000\u00e3\u00dd\u0001\u0000\u0000\u0000\u00e3\u00de\u0001\u0000\u0000"+
		"\u0000\u00e3\u00df\u0001\u0000\u0000\u0000\u00e3\u00e0\u0001\u0000\u0000"+
		"\u0000\u00e3\u00e1\u0001\u0000\u0000\u0000\u00e4\u00e7\u0001\u0000\u0000"+
		"\u0000\u00e5\u00e3\u0001\u0000\u0000\u0000\u00e5\u00e6\u0001\u0000\u0000"+
		"\u0000\u00e6\u00eb\u0001\u0000\u0000\u0000\u00e7\u00e5\u0001\u0000\u0000"+
		"\u0000\u00e8\u00ea\u0003\u00acV\u0000\u00e9\u00e8\u0001\u0000\u0000\u0000"+
		"\u00ea\u00ed\u0001\u0000\u0000\u0000\u00eb\u00e9\u0001\u0000\u0000\u0000"+
		"\u00eb\u00ec\u0001\u0000\u0000\u0000\u00ec\u0007\u0001\u0000\u0000\u0000"+
		"\u00ed\u00eb\u0001\u0000\u0000\u0000\u00ee\u00f2\u0005=\u0000\u0000\u00ef"+
		"\u00f0\u0003\n\u0005\u0000\u00f0\u00f1\u0005\u001d\u0000\u0000\u00f1\u00f3"+
		"\u0001\u0000\u0000\u0000\u00f2\u00ef\u0001\u0000\u0000\u0000\u00f3\u00f4"+
		"\u0001\u0000\u0000\u0000\u00f4\u00f2\u0001\u0000\u0000\u0000\u00f4\u00f5"+
		"\u0001\u0000\u0000\u0000\u00f5\t\u0001\u0000\u0000\u0000\u00f6\u00f7\u0003"+
		"\u0004\u0002\u0000\u00f7\u00f8\u0005\u0016\u0000\u0000\u00f8\u00f9\u0003"+
		"\u000e\u0007\u0000\u00f9\u000b\u0001\u0000\u0000\u0000\u00fa\u00fb\u0005"+
		"?\u0000\u0000\u00fb\u00fc\u0005\u0018\u0000\u0000\u00fc\u00fd\u0003&\u0013"+
		"\u0000\u00fd\u00fe\u0005\u0019\u0000\u0000\u00fe\r\u0001\u0000\u0000\u0000"+
		"\u00ff\u010b\u0003$\u0012\u0000\u0100\u0101\u0003(\u0014\u0000\u0101\u0102"+
		"\u0003$\u0012\u0000\u0102\u010b\u0001\u0000\u0000\u0000\u0103\u0104\u0003"+
		"(\u0014\u0000\u0104\u0105\u0003\u0004\u0002\u0000\u0105\u010b\u0001\u0000"+
		"\u0000\u0000\u0106\u010b\u0003,\u0016\u0000\u0107\u010b\u0003\f\u0006"+
		"\u0000\u0108\u010b\u00030\u0018\u0000\u0109\u010b\u0003.\u0017\u0000\u010a"+
		"\u00ff\u0001\u0000\u0000\u0000\u010a\u0100\u0001\u0000\u0000\u0000\u010a"+
		"\u0103\u0001\u0000\u0000\u0000\u010a\u0106\u0001\u0000\u0000\u0000\u010a"+
		"\u0107\u0001\u0000\u0000\u0000\u010a\u0108\u0001\u0000\u0000\u0000\u010a"+
		"\u0109\u0001\u0000\u0000\u0000\u010b\u000f\u0001\u0000\u0000\u0000\u010c"+
		"\u0113\u0003\u0012\t\u0000\u010d\u0113\u0003\u0014\n\u0000\u010e\u0113"+
		"\u0003\u001c\u000e\u0000\u010f\u0113\u0003\u001e\u000f\u0000\u0110\u0113"+
		"\u0003 \u0010\u0000\u0111\u0113\u0003\"\u0011\u0000\u0112\u010c\u0001"+
		"\u0000\u0000\u0000\u0112\u010d\u0001\u0000\u0000\u0000\u0112\u010e\u0001"+
		"\u0000\u0000\u0000\u0112\u010f\u0001\u0000\u0000\u0000\u0112\u0110\u0001"+
		"\u0000\u0000\u0000\u0112\u0111\u0001\u0000\u0000\u0000\u0113\u0011\u0001"+
		"\u0000\u0000\u0000\u0114\u0115\u00050\u0000\u0000\u0115\u0116\u0005\u001a"+
		"\u0000\u0000\u0116\u0117\u0003\u0018\f\u0000\u0117\u0118\u0005\u001b\u0000"+
		"\u0000\u0118\u0119\u00051\u0000\u0000\u0119\u011a\u0003\u0010\b\u0000"+
		"\u011a\u0013\u0001\u0000\u0000\u0000\u011b\u011c\u00050\u0000\u0000\u011c"+
		"\u011d\u00051\u0000\u0000\u011d\u011e\u0003\u0010\b\u0000\u011e\u0015"+
		"\u0001\u0000\u0000\u0000\u011f\u0120\u0003\u0004\u0002\u0000\u0120\u0121"+
		"\u0005\u001a\u0000\u0000\u0121\u0122\u0003\u0086C\u0000\u0122\u0123\u0005"+
		"\u001b\u0000\u0000\u0123\u0017\u0001\u0000\u0000\u0000\u0124\u0129\u0003"+
		"\u001a\r\u0000\u0125\u0126\u0005\u001c\u0000\u0000\u0126\u0128\u0003\u001a"+
		"\r\u0000\u0127\u0125\u0001\u0000\u0000\u0000\u0128\u012b\u0001\u0000\u0000"+
		"\u0000\u0129\u0127\u0001\u0000\u0000\u0000\u0129\u012a\u0001\u0000\u0000"+
		"\u0000\u012a\u0019\u0001\u0000\u0000\u0000\u012b\u0129\u0001\u0000\u0000"+
		"\u0000\u012c\u012d\u0003&\u0013\u0000\u012d\u012e\u0005 \u0000\u0000\u012e"+
		"\u012f\u0003&\u0013\u0000\u012f\u001b\u0001\u0000\u0000\u0000\u0130\u0131"+
		"\u00055\u0000\u0000\u0131\u001d\u0001\u0000\u0000\u0000\u0132\u0133\u0005"+
		"4\u0000\u0000\u0133\u001f\u0001\u0000\u0000\u0000\u0134\u0135\u00052\u0000"+
		"\u0000\u0135!\u0001\u0000\u0000\u0000\u0136\u0137\u00053\u0000\u0000\u0137"+
		"#\u0001\u0000\u0000\u0000\u0138\u0139\u0003&\u0013\u0000\u0139%\u0001"+
		"\u0000\u0000\u0000\u013a\u013b\u0005\u0005\u0000\u0000\u013b\'\u0001\u0000"+
		"\u0000\u0000\u013c\u013d\u0007\u0000\u0000\u0000\u013d)\u0001\u0000\u0000"+
		"\u0000\u013e\u013f\u00053\u0000\u0000\u013f+\u0001\u0000\u0000\u0000\u0140"+
		"\u0141\u0005\b\u0000\u0000\u0141-\u0001\u0000\u0000\u0000\u0142\u0143"+
		"\u0005\u0006\u0000\u0000\u0143/\u0001\u0000\u0000\u0000\u0144\u0145\u0005"+
		"\u0007\u0000\u0000\u01451\u0001\u0000\u0000\u0000\u0146\u0147\u0005\u0005"+
		"\u0000\u0000\u01473\u0001\u0000\u0000\u0000\u0148\u014c\u0005@\u0000\u0000"+
		"\u0149\u014a\u00036\u001b\u0000\u014a\u014b\u0005\u001d\u0000\u0000\u014b"+
		"\u014d\u0001\u0000\u0000\u0000\u014c\u0149\u0001\u0000\u0000\u0000\u014d"+
		"\u014e\u0001\u0000\u0000\u0000\u014e\u014c\u0001\u0000\u0000\u0000\u014e"+
		"\u014f\u0001\u0000\u0000\u0000\u014f5\u0001\u0000\u0000\u0000\u0150\u0151"+
		"\u0003\u0004\u0002\u0000\u0151\u0154\u0005\u0016\u0000\u0000\u0152\u0155"+
		"\u0003<\u001e\u0000\u0153\u0155\u00038\u001c\u0000\u0154\u0152\u0001\u0000"+
		"\u0000\u0000\u0154\u0153\u0001\u0000\u0000\u0000\u01557\u0001\u0000\u0000"+
		"\u0000\u0156\u0158\u0005\"\u0000\u0000\u0157\u0159\u0003^/\u0000\u0158"+
		"\u0157\u0001\u0000\u0000\u0000\u0158\u0159\u0001\u0000\u0000\u0000\u0159"+
		"\u015a\u0001\u0000\u0000\u0000\u015a\u015b\u0005\u001e\u0000\u0000\u015b"+
		"\u015c\u0003\u0010\b\u0000\u015c9\u0001\u0000\u0000\u0000\u015d\u015f"+
		"\u0005#\u0000\u0000\u015e\u0160\u0003^/\u0000\u015f\u015e\u0001\u0000"+
		"\u0000\u0000\u015f\u0160\u0001\u0000\u0000\u0000\u0160\u0161\u0001\u0000"+
		"\u0000\u0000\u0161\u0162\u0005\u001e\u0000\u0000\u0162\u0163\u0003\u0010"+
		"\b\u0000\u0163;\u0001\u0000\u0000\u0000\u0164\u0167\u0003>\u001f\u0000"+
		"\u0165\u0167\u0003\u0012\t\u0000\u0166\u0164\u0001\u0000\u0000\u0000\u0166"+
		"\u0165\u0001\u0000\u0000\u0000\u0167=\u0001\u0000\u0000\u0000\u0168\u016d"+
		"\u0003B!\u0000\u0169\u016d\u0003D\"\u0000\u016a\u016d\u0003F#\u0000\u016b"+
		"\u016d\u0003\u000e\u0007\u0000\u016c\u0168\u0001\u0000\u0000\u0000\u016c"+
		"\u0169\u0001\u0000\u0000\u0000\u016c\u016a\u0001\u0000\u0000\u0000\u016c"+
		"\u016b\u0001\u0000\u0000\u0000\u016d?\u0001\u0000\u0000\u0000\u016e\u016f"+
		"\u0005\u0018\u0000\u0000\u016f\u0170\u0003d2\u0000\u0170\u0171\u0005\u0019"+
		"\u0000\u0000\u0171A\u0001\u0000\u0000\u0000\u0172\u0173\u0003\u000e\u0007"+
		"\u0000\u0173\u0174\u0005 \u0000\u0000\u0174\u0175\u0003\u000e\u0007\u0000"+
		"\u0175C\u0001\u0000\u0000\u0000\u0176\u0177\u0007\u0001\u0000\u0000\u0177"+
		"E\u0001\u0000\u0000\u0000\u0178\u0179\u0005\b\u0000\u0000\u0179\u017c"+
		"\u0005\u001a\u0000\u0000\u017a\u017d\u0003\u0004\u0002\u0000\u017b\u017d"+
		"\u0003$\u0012\u0000\u017c\u017a\u0001\u0000\u0000\u0000\u017c\u017b\u0001"+
		"\u0000\u0000\u0000\u017d\u017e\u0001\u0000\u0000\u0000\u017e\u017f\u0005"+
		"\u001b\u0000\u0000\u017fG\u0001\u0000\u0000\u0000\u0180\u0185\u0003J%"+
		"\u0000\u0181\u0182\u0005\u001c\u0000\u0000\u0182\u0184\u0003J%\u0000\u0183"+
		"\u0181\u0001\u0000\u0000\u0000\u0184\u0187\u0001\u0000\u0000\u0000\u0185"+
		"\u0183\u0001\u0000\u0000\u0000\u0185\u0186\u0001\u0000\u0000\u0000\u0186"+
		"I\u0001\u0000\u0000\u0000\u0187\u0185\u0001\u0000\u0000\u0000\u0188\u0189"+
		"\u0003>\u001f\u0000\u0189K\u0001\u0000\u0000\u0000\u018a\u018b\u0003<"+
		"\u001e\u0000\u018bM\u0001\u0000\u0000\u0000\u018c\u0191\u0003P(\u0000"+
		"\u018d\u018e\u0005\u001d\u0000\u0000\u018e\u0190\u0003P(\u0000\u018f\u018d"+
		"\u0001\u0000\u0000\u0000\u0190\u0193\u0001\u0000\u0000\u0000\u0191\u018f"+
		"\u0001\u0000\u0000\u0000\u0191\u0192\u0001\u0000\u0000\u0000\u0192O\u0001"+
		"\u0000\u0000\u0000\u0193\u0191\u0001\u0000\u0000\u0000\u0194\u0195\u0003"+
		"d2\u0000\u0195\u0196\u0005\u001e\u0000\u0000\u0196\u0197\u0003<\u001e"+
		"\u0000\u0197Q\u0001\u0000\u0000\u0000\u0198\u0199\u0003\u0004\u0002\u0000"+
		"\u0199\u019a\u0005\u001e\u0000\u0000\u019a\u019b\u0003D\"\u0000\u019b"+
		"\u019e\u0001\u0000\u0000\u0000\u019c\u019e\u0003D\"\u0000\u019d\u0198"+
		"\u0001\u0000\u0000\u0000\u019d\u019c\u0001\u0000\u0000\u0000\u019eS\u0001"+
		"\u0000\u0000\u0000\u019f\u01a0\u0003>\u001f\u0000\u01a0U\u0001\u0000\u0000"+
		"\u0000\u01a1\u01a2\u0005.\u0000\u0000\u01a2\u01a7\u0003X,\u0000\u01a3"+
		"\u01a4\u0005\u001d\u0000\u0000\u01a4\u01a6\u0003X,\u0000\u01a5\u01a3\u0001"+
		"\u0000\u0000\u0000\u01a6\u01a9\u0001\u0000\u0000\u0000\u01a7\u01a5\u0001"+
		"\u0000\u0000\u0000\u01a7\u01a8\u0001\u0000\u0000\u0000\u01a8\u01aa\u0001"+
		"\u0000\u0000\u0000\u01a9\u01a7\u0001\u0000\u0000\u0000\u01aa\u01ab\u0005"+
		"\u001d\u0000\u0000\u01abW\u0001\u0000\u0000\u0000\u01ac\u01ad\u0003d2"+
		"\u0000\u01ad\u01ae\u0005\u001e\u0000\u0000\u01ae\u01b1\u0003<\u001e\u0000"+
		"\u01af\u01b0\u0005\u0016\u0000\u0000\u01b0\u01b2\u0003\u00be_\u0000\u01b1"+
		"\u01af\u0001\u0000\u0000\u0000\u01b1\u01b2\u0001\u0000\u0000\u0000\u01b2"+
		"Y\u0001\u0000\u0000\u0000\u01b3\u01b4\u0003\\.\u0000\u01b4\u01b5\u0005"+
		"\u001d\u0000\u0000\u01b5[\u0001\u0000\u0000\u0000\u01b6\u01b9\u0003h4"+
		"\u0000\u01b7\u01b9\u0003j5\u0000\u01b8\u01b6\u0001\u0000\u0000\u0000\u01b8"+
		"\u01b7\u0001\u0000\u0000\u0000\u01b9]\u0001\u0000\u0000\u0000\u01ba\u01bb"+
		"\u0005\u0018\u0000\u0000\u01bb\u01c0\u0003`0\u0000\u01bc\u01bd\u0005\u001d"+
		"\u0000\u0000\u01bd\u01bf\u0003`0\u0000\u01be\u01bc\u0001\u0000\u0000\u0000"+
		"\u01bf\u01c2\u0001\u0000\u0000\u0000\u01c0\u01be\u0001\u0000\u0000\u0000"+
		"\u01c0\u01c1\u0001\u0000\u0000\u0000\u01c1\u01c3\u0001\u0000\u0000\u0000"+
		"\u01c2\u01c0\u0001\u0000\u0000\u0000\u01c3\u01c4\u0005\u0019\u0000\u0000"+
		"\u01c4_\u0001\u0000\u0000\u0000\u01c5\u01cb\u0003b1\u0000\u01c6\u01c7"+
		"\u0005.\u0000\u0000\u01c7\u01cb\u0003b1\u0000\u01c8\u01c9\u0005\"\u0000"+
		"\u0000\u01c9\u01cb\u0003b1\u0000\u01ca\u01c5\u0001\u0000\u0000\u0000\u01ca"+
		"\u01c6\u0001\u0000\u0000\u0000\u01ca\u01c8\u0001\u0000\u0000\u0000\u01cb"+
		"a\u0001\u0000\u0000\u0000\u01cc\u01cd\u0003d2\u0000\u01cd\u01ce\u0005"+
		"\u001e\u0000\u0000\u01ce\u01cf\u0003\u0010\b\u0000\u01cf\u01d2\u0001\u0000"+
		"\u0000\u0000\u01d0\u01d2\u0003\u00a8T\u0000\u01d1\u01cc\u0001\u0000\u0000"+
		"\u0000\u01d1\u01d0\u0001\u0000\u0000\u0000\u01d2c\u0001\u0000\u0000\u0000"+
		"\u01d3\u01d8\u0003\u0004\u0002\u0000\u01d4\u01d5\u0005\u001c\u0000\u0000"+
		"\u01d5\u01d7\u0003\u0004\u0002\u0000\u01d6\u01d4\u0001\u0000\u0000\u0000"+
		"\u01d7\u01da\u0001\u0000\u0000\u0000\u01d8\u01d6\u0001\u0000\u0000\u0000"+
		"\u01d8\u01d9\u0001\u0000\u0000\u0000\u01d9e\u0001\u0000\u0000\u0000\u01da"+
		"\u01d8\u0001\u0000\u0000\u0000\u01db\u01e0\u0003\u000e\u0007\u0000\u01dc"+
		"\u01dd\u0005\u001c\u0000\u0000\u01dd\u01df\u0003\u000e\u0007\u0000\u01de"+
		"\u01dc\u0001\u0000\u0000\u0000\u01df\u01e2\u0001\u0000\u0000\u0000\u01e0"+
		"\u01de\u0001\u0000\u0000\u0000\u01e0\u01e1\u0001\u0000\u0000\u0000\u01e1"+
		"g\u0001\u0000\u0000\u0000\u01e2\u01e0\u0001\u0000\u0000\u0000\u01e3\u01e4"+
		"\u0005\"\u0000\u0000\u01e4\u01e5\u0003\u0004\u0002\u0000\u01e5\u01e6\u0003"+
		"^/\u0000\u01e6\u01e7\u0005\u001e\u0000\u0000\u01e7\u01e8\u0003\u0010\b"+
		"\u0000\u01e8\u01e9\u0005\u001d\u0000\u0000\u01e9\u01ea\u0003\u0006\u0003"+
		"\u0000\u01eai\u0001\u0000\u0000\u0000\u01eb\u01ec\u0005#\u0000\u0000\u01ec"+
		"\u01ed\u0003\u0004\u0002\u0000\u01ed\u01ee\u0003^/\u0000\u01ee\u01ef\u0005"+
		"\u001d\u0000\u0000\u01ef\u01f0\u0003\u0006\u0003\u0000\u01f0k\u0001\u0000"+
		"\u0000\u0000\u01f1\u01f2\u0003D\"\u0000\u01f2m\u0001\u0000\u0000\u0000"+
		"\u01f3\u01f8\u0003p8\u0000\u01f4\u01f8\u0003x<\u0000\u01f5\u01f8\u0003"+
		"~?\u0000\u01f6\u01f8\u0003\u009aM\u0000\u01f7\u01f3\u0001\u0000\u0000"+
		"\u0000\u01f7\u01f4\u0001\u0000\u0000\u0000\u01f7\u01f5\u0001\u0000\u0000"+
		"\u0000\u01f7\u01f6\u0001\u0000\u0000\u0000\u01f8o\u0001\u0000\u0000\u0000"+
		"\u01f9\u01fa\u0003r9\u0000\u01fa\u0203\u0005\u0018\u0000\u0000\u01fb\u0200"+
		"\u0003t:\u0000\u01fc\u01fd\u0005\u001c\u0000\u0000\u01fd\u01ff\u0003t"+
		":\u0000\u01fe\u01fc\u0001\u0000\u0000\u0000\u01ff\u0202\u0001\u0000\u0000"+
		"\u0000\u0200\u01fe\u0001\u0000\u0000\u0000\u0200\u0201\u0001\u0000\u0000"+
		"\u0000\u0201\u0204\u0001\u0000\u0000\u0000\u0202\u0200\u0001\u0000\u0000"+
		"\u0000\u0203\u01fb\u0001\u0000\u0000\u0000\u0203\u0204\u0001\u0000\u0000"+
		"\u0000\u0204\u0205\u0001\u0000\u0000\u0000\u0205\u0206\u0005\u0019\u0000"+
		"\u0000\u0206q\u0001\u0000\u0000\u0000\u0207\u0208\u0007\u0002\u0000\u0000"+
		"\u0208s\u0001\u0000\u0000\u0000\u0209\u020d\u0003v;\u0000\u020a\u020d"+
		"\u0003\u0004\u0002\u0000\u020b\u020d\u0003\u0016\u000b\u0000\u020c\u0209"+
		"\u0001\u0000\u0000\u0000\u020c\u020a\u0001\u0000\u0000\u0000\u020c\u020b"+
		"\u0001\u0000\u0000\u0000\u020du\u0001\u0000\u0000\u0000\u020e\u0213\u0003"+
		",\u0016\u0000\u020f\u0213\u0003.\u0017\u0000\u0210\u0213\u00030\u0018"+
		"\u0000\u0211\u0213\u00032\u0019\u0000\u0212\u020e\u0001\u0000\u0000\u0000"+
		"\u0212\u020f\u0001\u0000\u0000\u0000\u0212\u0210\u0001\u0000\u0000\u0000"+
		"\u0212\u0211\u0001\u0000\u0000\u0000\u0213w\u0001\u0000\u0000\u0000\u0214"+
		"\u0215\u0003z=\u0000\u0215\u0216\u0005\u0018\u0000\u0000\u0216\u0217\u0003"+
		"|>\u0000\u0217\u0218\u0005\u0019\u0000\u0000\u0218y\u0001\u0000\u0000"+
		"\u0000\u0219\u021a\u0007\u0003\u0000\u0000\u021a{\u0001\u0000\u0000\u0000"+
		"\u021b\u021f\u0003v;\u0000\u021c\u021f\u0003\u0004\u0002\u0000\u021d\u021f"+
		"\u0003\u0016\u000b\u0000\u021e\u021b\u0001\u0000\u0000\u0000\u021e\u021c"+
		"\u0001\u0000\u0000\u0000\u021e\u021d\u0001\u0000\u0000\u0000\u021f}\u0001"+
		"\u0000\u0000\u0000\u0220\u0223\u0003\u0080@\u0000\u0221\u0223\u0003\u00aa"+
		"U\u0000\u0222\u0220\u0001\u0000\u0000\u0000\u0222\u0221\u0001\u0000\u0000"+
		"\u0000\u0223\u007f\u0001\u0000\u0000\u0000\u0224\u0227\u0003\u0082A\u0000"+
		"\u0225\u0227\u0003\u00a8T\u0000\u0226\u0224\u0001\u0000\u0000\u0000\u0226"+
		"\u0225\u0001\u0000\u0000\u0000\u0227\u0081\u0001\u0000\u0000\u0000\u0228"+
		"\u0229\u0003\u0084B\u0000\u0229\u022a\u0005\t\u0000\u0000\u022a\u022b"+
		"\u0003\u0088D\u0000\u022b\u0083\u0001\u0000\u0000\u0000\u022c\u022d\u0005"+
		"A\u0000\u0000\u022d\u0230\u0003\u0004\u0002\u0000\u022e\u0230\u0003\u0004"+
		"\u0002\u0000\u022f\u022c\u0001\u0000\u0000\u0000\u022f\u022e\u0001\u0000"+
		"\u0000\u0000\u0230\u0239\u0001\u0000\u0000\u0000\u0231\u0232\u0005\u001a"+
		"\u0000\u0000\u0232\u0233\u0003\u0086C\u0000\u0233\u0234\u0005\u001b\u0000"+
		"\u0000\u0234\u0238\u0001\u0000\u0000\u0000\u0235\u0236\u0005\u001f\u0000"+
		"\u0000\u0236\u0238\u0003\u0004\u0002\u0000\u0237\u0231\u0001\u0000\u0000"+
		"\u0000\u0237\u0235\u0001\u0000\u0000\u0000\u0238\u023b\u0001\u0000\u0000"+
		"\u0000\u0239\u0237\u0001\u0000\u0000\u0000\u0239\u023a\u0001\u0000\u0000"+
		"\u0000\u023a\u0085\u0001\u0000\u0000\u0000\u023b\u0239\u0001\u0000\u0000"+
		"\u0000\u023c\u0241\u0003\u0088D\u0000\u023d\u023e\u0005\u001c\u0000\u0000"+
		"\u023e\u0240\u0003\u0088D\u0000\u023f\u023d\u0001\u0000\u0000\u0000\u0240"+
		"\u0243\u0001\u0000\u0000\u0000\u0241\u023f\u0001\u0000\u0000\u0000\u0241"+
		"\u0242\u0001\u0000\u0000\u0000\u0242\u0087\u0001\u0000\u0000\u0000\u0243"+
		"\u0241\u0001\u0000\u0000\u0000\u0244\u0248\u0003\u008cF\u0000\u0245\u0246"+
		"\u0003\u008aE\u0000\u0246\u0247\u0003\u0088D\u0000\u0247\u0249\u0001\u0000"+
		"\u0000\u0000\u0248\u0245\u0001\u0000\u0000\u0000\u0248\u0249\u0001\u0000"+
		"\u0000\u0000\u0249\u0089\u0001\u0000\u0000\u0000\u024a\u024b\u0007\u0004"+
		"\u0000\u0000\u024b\u008b\u0001\u0000\u0000\u0000\u024c\u0250\u0003\u0090"+
		"H\u0000\u024d\u024e\u0003\u008eG\u0000\u024e\u024f\u0003\u008cF\u0000"+
		"\u024f\u0251\u0001\u0000\u0000\u0000\u0250\u024d\u0001\u0000\u0000\u0000"+
		"\u0250\u0251\u0001\u0000\u0000\u0000\u0251\u008d\u0001\u0000\u0000\u0000"+
		"\u0252\u0253\u0007\u0005\u0000\u0000\u0253\u008f\u0001\u0000\u0000\u0000"+
		"\u0254\u0258\u0003\u0094J\u0000\u0255\u0256\u0003\u0092I\u0000\u0256\u0257"+
		"\u0003\u0090H\u0000\u0257\u0259\u0001\u0000\u0000\u0000\u0258\u0255\u0001"+
		"\u0000\u0000\u0000\u0258\u0259\u0001\u0000\u0000\u0000\u0259\u0091\u0001"+
		"\u0000\u0000\u0000\u025a\u025b\u0007\u0006\u0000\u0000\u025b\u0093\u0001"+
		"\u0000\u0000\u0000\u025c\u025e\u0007\u0000\u0000\u0000\u025d\u025c\u0001"+
		"\u0000\u0000\u0000\u025d\u025e\u0001\u0000\u0000\u0000\u025e\u025f\u0001"+
		"\u0000\u0000\u0000\u025f\u0260\u0003\u0096K\u0000\u0260\u0095\u0001\u0000"+
		"\u0000\u0000\u0261\u026f\u0003\u0084B\u0000\u0262\u0263\u0005\u0018\u0000"+
		"\u0000\u0263\u0264\u0003\u0088D\u0000\u0264\u0265\u0005\u0019\u0000\u0000"+
		"\u0265\u026f\u0001\u0000\u0000\u0000\u0266\u026f\u0003\u009aM\u0000\u0267"+
		"\u026f\u0003\u0098L\u0000\u0268\u026f\u0003\u009eO\u0000\u0269\u026a\u0005"+
		"\u0010\u0000\u0000\u026a\u026f\u0003\u0096K\u0000\u026b\u026f\u0003*\u0015"+
		"\u0000\u026c\u026f\u00030\u0018\u0000\u026d\u026f\u0003.\u0017\u0000\u026e"+
		"\u0261\u0001\u0000\u0000\u0000\u026e\u0262\u0001\u0000\u0000\u0000\u026e"+
		"\u0266\u0001\u0000\u0000\u0000\u026e\u0267\u0001\u0000\u0000\u0000\u026e"+
		"\u0268\u0001\u0000\u0000\u0000\u026e\u0269\u0001\u0000\u0000\u0000\u026e"+
		"\u026b\u0001\u0000\u0000\u0000\u026e\u026c\u0001\u0000\u0000\u0000\u026e"+
		"\u026d\u0001\u0000\u0000\u0000\u026f\u0097\u0001\u0000\u0000\u0000\u0270"+
		"\u0275\u0003$\u0012\u0000\u0271\u0275\u0003\f\u0006\u0000\u0272\u0275"+
		"\u0003,\u0016\u0000\u0273\u0275\u0005:\u0000\u0000\u0274\u0270\u0001\u0000"+
		"\u0000\u0000\u0274\u0271\u0001\u0000\u0000\u0000\u0274\u0272\u0001\u0000"+
		"\u0000\u0000\u0274\u0273\u0001\u0000\u0000\u0000\u0275\u0099\u0001\u0000"+
		"\u0000\u0000\u0276\u0277\u0003\u0004\u0002\u0000\u0277\u0278\u0005\u0018"+
		"\u0000\u0000\u0278\u0279\u0003\u009cN\u0000\u0279\u027a\u0005\u0019\u0000"+
		"\u0000\u027a\u009b\u0001\u0000\u0000\u0000\u027b\u0280\u0003\u00a4R\u0000"+
		"\u027c\u027d\u0005\u001c\u0000\u0000\u027d\u027f\u0003\u00a4R\u0000\u027e"+
		"\u027c\u0001\u0000\u0000\u0000\u027f\u0282\u0001\u0000\u0000\u0000\u0280"+
		"\u027e\u0001\u0000\u0000\u0000\u0280\u0281\u0001\u0000\u0000\u0000\u0281"+
		"\u009d\u0001\u0000\u0000\u0000\u0282\u0280\u0001\u0000\u0000\u0000\u0283"+
		"\u0284\u0005\u001a\u0000\u0000\u0284\u0285\u0003\u00a0P\u0000\u0285\u0286"+
		"\u0005\u001b\u0000\u0000\u0286\u009f\u0001\u0000\u0000\u0000\u0287\u028c"+
		"\u0003\u00a2Q\u0000\u0288\u0289\u0005\u001c\u0000\u0000\u0289\u028b\u0003"+
		"\u00a2Q\u0000\u028a\u0288\u0001\u0000\u0000\u0000\u028b\u028e\u0001\u0000"+
		"\u0000\u0000\u028c\u028a\u0001\u0000\u0000\u0000\u028c\u028d\u0001\u0000"+
		"\u0000\u0000\u028d\u00a1\u0001\u0000\u0000\u0000\u028e\u028c\u0001\u0000"+
		"\u0000\u0000\u028f\u0292\u0003\u0088D\u0000\u0290\u0291\u0005 \u0000\u0000"+
		"\u0291\u0293\u0003\u0088D\u0000\u0292\u0290\u0001\u0000\u0000\u0000\u0292"+
		"\u0293\u0001\u0000\u0000\u0000\u0293\u00a3\u0001\u0000\u0000\u0000\u0294"+
		"\u0298\u0003\u0088D\u0000\u0295\u0297\u0003\u00a6S\u0000\u0296\u0295\u0001"+
		"\u0000\u0000\u0000\u0297\u029a\u0001\u0000\u0000\u0000\u0298\u0296\u0001"+
		"\u0000\u0000\u0000\u0298\u0299\u0001\u0000\u0000\u0000\u0299\u00a5\u0001"+
		"\u0000\u0000\u0000\u029a\u0298\u0001\u0000\u0000\u0000\u029b\u029c\u0005"+
		"\u001e\u0000\u0000\u029c\u029d\u0003\u0088D\u0000\u029d\u00a7\u0001\u0000"+
		"\u0000\u0000\u029e\u029f\u0001\u0000\u0000\u0000\u029f\u00a9\u0001\u0000"+
		"\u0000\u0000\u02a0\u02a4\u0003\u00acV\u0000\u02a1\u02a4\u0003\u00b0X\u0000"+
		"\u02a2\u02a4\u0003\u00b4Z\u0000\u02a3\u02a0\u0001\u0000\u0000\u0000\u02a3"+
		"\u02a1\u0001\u0000\u0000\u0000\u02a3\u02a2\u0001\u0000\u0000\u0000\u02a4"+
		"\u00ab\u0001\u0000\u0000\u0000\u02a5\u02a6\u0005\u0001\u0000\u0000\u02a6"+
		"\u02a7\u0003\u00aeW\u0000\u02a7\u02a8\u0005\u0002\u0000\u0000\u02a8\u02ab"+
		"\u0001\u0000\u0000\u0000\u02a9\u02ab\u0003\\.\u0000\u02aa\u02a5\u0001"+
		"\u0000\u0000\u0000\u02aa\u02a9\u0001\u0000\u0000\u0000\u02ab\u00ad\u0001"+
		"\u0000\u0000\u0000\u02ac\u02b1\u0003n7\u0000\u02ad\u02ae\u0005\u001d\u0000"+
		"\u0000\u02ae\u02b0\u0003n7\u0000\u02af\u02ad\u0001\u0000\u0000\u0000\u02b0"+
		"\u02b3\u0001\u0000\u0000\u0000\u02b1\u02af\u0001\u0000\u0000\u0000\u02b1"+
		"\u02b2\u0001\u0000\u0000\u0000\u02b2\u00af\u0001\u0000\u0000\u0000\u02b3"+
		"\u02b1\u0001\u0000\u0000\u0000\u02b4\u02b5\u0003\u00b2Y\u0000\u02b5\u00b1"+
		"\u0001\u0000\u0000\u0000\u02b6\u02b7\u0005$\u0000\u0000\u02b7\u02b8\u0003"+
		"\u0088D\u0000\u02b8\u02b9\u0005%\u0000\u0000\u02b9\u02bc\u0003n7\u0000"+
		"\u02ba\u02bb\u0005&\u0000\u0000\u02bb\u02bd\u0003n7\u0000\u02bc\u02ba"+
		"\u0001\u0000\u0000\u0000\u02bc\u02bd\u0001\u0000\u0000\u0000\u02bd\u00b3"+
		"\u0001\u0000\u0000\u0000\u02be\u02c2\u0003\u00b6[\u0000\u02bf\u02c2\u0003"+
		"\u00b8\\\u0000\u02c0\u02c2\u0003\u00ba]\u0000\u02c1\u02be\u0001\u0000"+
		"\u0000\u0000\u02c1\u02bf\u0001\u0000\u0000\u0000\u02c1\u02c0\u0001\u0000"+
		"\u0000\u0000\u02c2\u00b5\u0001\u0000\u0000\u0000\u02c3\u02c4\u0005(\u0000"+
		"\u0000\u02c4\u02c5\u0003\u0088D\u0000\u02c5\u02c6\u0005,\u0000\u0000\u02c6"+
		"\u02c7\u0003n7\u0000\u02c7\u00b7\u0001\u0000\u0000\u0000\u02c8\u02c9\u0005"+
		"*\u0000\u0000\u02c9\u02ca\u0003\u00aeW\u0000\u02ca\u02cb\u0005\'\u0000"+
		"\u0000\u02cb\u02cc\u0003\u0088D\u0000\u02cc\u00b9\u0001\u0000\u0000\u0000"+
		"\u02cd\u02ce\u0005)\u0000\u0000\u02ce\u02cf\u0003\u0004\u0002\u0000\u02cf"+
		"\u02d0\u0005\t\u0000\u0000\u02d0\u02d1\u0003\u00bc^\u0000\u02d1\u02d2"+
		"\u0005,\u0000\u0000\u02d2\u02d3\u0003n7\u0000\u02d3\u00bb\u0001\u0000"+
		"\u0000\u0000\u02d4\u02d5\u0003\u00be_\u0000\u02d5\u02d6\u0007\u0007\u0000"+
		"\u0000\u02d6\u02d7\u0003\u00c2a\u0000\u02d7\u00bd\u0001\u0000\u0000\u0000"+
		"\u02d8\u02dc\u0003\u00c0`\u0000\u02d9\u02dc\u0003\u000e\u0007\u0000\u02da"+
		"\u02dc\u0003\u0004\u0002\u0000\u02db\u02d8\u0001\u0000\u0000\u0000\u02db"+
		"\u02d9\u0001\u0000\u0000\u0000\u02db\u02da\u0001\u0000\u0000\u0000\u02dc"+
		"\u00bf\u0001\u0000\u0000\u0000\u02dd\u02de\u0005\u0018\u0000\u0000\u02de"+
		"\u02df\u0003f3\u0000\u02df\u02e0\u0005\u0019\u0000\u0000\u02e0\u00c1\u0001"+
		"\u0000\u0000\u0000\u02e1\u02e2\u0003\u0088D\u0000\u02e2\u00c3\u0001\u0000"+
		"\u0000\u00008\u00c6\u00d2\u00d8\u00e3\u00e5\u00eb\u00f4\u010a\u0112\u0129"+
		"\u014e\u0154\u0158\u015f\u0166\u016c\u017c\u0185\u0191\u019d\u01a7\u01b1"+
		"\u01b8\u01c0\u01ca\u01d1\u01d8\u01e0\u01f7\u0200\u0203\u020c\u0212\u021e"+
		"\u0222\u0226\u022f\u0237\u0239\u0241\u0248\u0250\u0258\u025d\u026e\u0274"+
		"\u0280\u028c\u0292\u0298\u02a3\u02aa\u02b1\u02bc\u02c1\u02db";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}