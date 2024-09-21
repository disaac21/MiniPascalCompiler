// Generated from C:/Users/danie/Desktop/MiniPascalCompiler/MiniPascalGrammar.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MiniPascalGrammarParser}.
 */
public interface MiniPascalGrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MiniPascalGrammarParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(MiniPascalGrammarParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPascalGrammarParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(MiniPascalGrammarParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPascalGrammarParser#programHeading}.
	 * @param ctx the parse tree
	 */
	void enterProgramHeading(MiniPascalGrammarParser.ProgramHeadingContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPascalGrammarParser#programHeading}.
	 * @param ctx the parse tree
	 */
	void exitProgramHeading(MiniPascalGrammarParser.ProgramHeadingContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPascalGrammarParser#identifier}.
	 * @param ctx the parse tree
	 */
	void enterIdentifier(MiniPascalGrammarParser.IdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPascalGrammarParser#identifier}.
	 * @param ctx the parse tree
	 */
	void exitIdentifier(MiniPascalGrammarParser.IdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPascalGrammarParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(MiniPascalGrammarParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPascalGrammarParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(MiniPascalGrammarParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPascalGrammarParser#constantDefinitionPart}.
	 * @param ctx the parse tree
	 */
	void enterConstantDefinitionPart(MiniPascalGrammarParser.ConstantDefinitionPartContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPascalGrammarParser#constantDefinitionPart}.
	 * @param ctx the parse tree
	 */
	void exitConstantDefinitionPart(MiniPascalGrammarParser.ConstantDefinitionPartContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPascalGrammarParser#constantDefinition}.
	 * @param ctx the parse tree
	 */
	void enterConstantDefinition(MiniPascalGrammarParser.ConstantDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPascalGrammarParser#constantDefinition}.
	 * @param ctx the parse tree
	 */
	void exitConstantDefinition(MiniPascalGrammarParser.ConstantDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPascalGrammarParser#constantChr}.
	 * @param ctx the parse tree
	 */
	void enterConstantChr(MiniPascalGrammarParser.ConstantChrContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPascalGrammarParser#constantChr}.
	 * @param ctx the parse tree
	 */
	void exitConstantChr(MiniPascalGrammarParser.ConstantChrContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPascalGrammarParser#constant}.
	 * @param ctx the parse tree
	 */
	void enterConstant(MiniPascalGrammarParser.ConstantContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPascalGrammarParser#constant}.
	 * @param ctx the parse tree
	 */
	void exitConstant(MiniPascalGrammarParser.ConstantContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPascalGrammarParser#varType}.
	 * @param ctx the parse tree
	 */
	void enterVarType(MiniPascalGrammarParser.VarTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPascalGrammarParser#varType}.
	 * @param ctx the parse tree
	 */
	void exitVarType(MiniPascalGrammarParser.VarTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPascalGrammarParser#arrayType}.
	 * @param ctx the parse tree
	 */
	void enterArrayType(MiniPascalGrammarParser.ArrayTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPascalGrammarParser#arrayType}.
	 * @param ctx the parse tree
	 */
	void exitArrayType(MiniPascalGrammarParser.ArrayTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPascalGrammarParser#arrayOfType}.
	 * @param ctx the parse tree
	 */
	void enterArrayOfType(MiniPascalGrammarParser.ArrayOfTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPascalGrammarParser#arrayOfType}.
	 * @param ctx the parse tree
	 */
	void exitArrayOfType(MiniPascalGrammarParser.ArrayOfTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPascalGrammarParser#arrayValue}.
	 * @param ctx the parse tree
	 */
	void enterArrayValue(MiniPascalGrammarParser.ArrayValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPascalGrammarParser#arrayValue}.
	 * @param ctx the parse tree
	 */
	void exitArrayValue(MiniPascalGrammarParser.ArrayValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPascalGrammarParser#indexRanges}.
	 * @param ctx the parse tree
	 */
	void enterIndexRanges(MiniPascalGrammarParser.IndexRangesContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPascalGrammarParser#indexRanges}.
	 * @param ctx the parse tree
	 */
	void exitIndexRanges(MiniPascalGrammarParser.IndexRangesContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPascalGrammarParser#indexRange}.
	 * @param ctx the parse tree
	 */
	void enterIndexRange(MiniPascalGrammarParser.IndexRangeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPascalGrammarParser#indexRange}.
	 * @param ctx the parse tree
	 */
	void exitIndexRange(MiniPascalGrammarParser.IndexRangeContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPascalGrammarParser#stringR_}.
	 * @param ctx the parse tree
	 */
	void enterStringR_(MiniPascalGrammarParser.StringR_Context ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPascalGrammarParser#stringR_}.
	 * @param ctx the parse tree
	 */
	void exitStringR_(MiniPascalGrammarParser.StringR_Context ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPascalGrammarParser#charR_}.
	 * @param ctx the parse tree
	 */
	void enterCharR_(MiniPascalGrammarParser.CharR_Context ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPascalGrammarParser#charR_}.
	 * @param ctx the parse tree
	 */
	void exitCharR_(MiniPascalGrammarParser.CharR_Context ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPascalGrammarParser#integerR_}.
	 * @param ctx the parse tree
	 */
	void enterIntegerR_(MiniPascalGrammarParser.IntegerR_Context ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPascalGrammarParser#integerR_}.
	 * @param ctx the parse tree
	 */
	void exitIntegerR_(MiniPascalGrammarParser.IntegerR_Context ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPascalGrammarParser#booleanR_}.
	 * @param ctx the parse tree
	 */
	void enterBooleanR_(MiniPascalGrammarParser.BooleanR_Context ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPascalGrammarParser#booleanR_}.
	 * @param ctx the parse tree
	 */
	void exitBooleanR_(MiniPascalGrammarParser.BooleanR_Context ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPascalGrammarParser#unsignedNumber}.
	 * @param ctx the parse tree
	 */
	void enterUnsignedNumber(MiniPascalGrammarParser.UnsignedNumberContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPascalGrammarParser#unsignedNumber}.
	 * @param ctx the parse tree
	 */
	void exitUnsignedNumber(MiniPascalGrammarParser.UnsignedNumberContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPascalGrammarParser#unsignedInteger}.
	 * @param ctx the parse tree
	 */
	void enterUnsignedInteger(MiniPascalGrammarParser.UnsignedIntegerContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPascalGrammarParser#unsignedInteger}.
	 * @param ctx the parse tree
	 */
	void exitUnsignedInteger(MiniPascalGrammarParser.UnsignedIntegerContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPascalGrammarParser#sign}.
	 * @param ctx the parse tree
	 */
	void enterSign(MiniPascalGrammarParser.SignContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPascalGrammarParser#sign}.
	 * @param ctx the parse tree
	 */
	void exitSign(MiniPascalGrammarParser.SignContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPascalGrammarParser#bool_}.
	 * @param ctx the parse tree
	 */
	void enterBool_(MiniPascalGrammarParser.Bool_Context ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPascalGrammarParser#bool_}.
	 * @param ctx the parse tree
	 */
	void exitBool_(MiniPascalGrammarParser.Bool_Context ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPascalGrammarParser#string}.
	 * @param ctx the parse tree
	 */
	void enterString(MiniPascalGrammarParser.StringContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPascalGrammarParser#string}.
	 * @param ctx the parse tree
	 */
	void exitString(MiniPascalGrammarParser.StringContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPascalGrammarParser#boolean}.
	 * @param ctx the parse tree
	 */
	void enterBoolean(MiniPascalGrammarParser.BooleanContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPascalGrammarParser#boolean}.
	 * @param ctx the parse tree
	 */
	void exitBoolean(MiniPascalGrammarParser.BooleanContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPascalGrammarParser#char}.
	 * @param ctx the parse tree
	 */
	void enterChar(MiniPascalGrammarParser.CharContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPascalGrammarParser#char}.
	 * @param ctx the parse tree
	 */
	void exitChar(MiniPascalGrammarParser.CharContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPascalGrammarParser#integer}.
	 * @param ctx the parse tree
	 */
	void enterInteger(MiniPascalGrammarParser.IntegerContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPascalGrammarParser#integer}.
	 * @param ctx the parse tree
	 */
	void exitInteger(MiniPascalGrammarParser.IntegerContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPascalGrammarParser#typeDefinitionPart}.
	 * @param ctx the parse tree
	 */
	void enterTypeDefinitionPart(MiniPascalGrammarParser.TypeDefinitionPartContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPascalGrammarParser#typeDefinitionPart}.
	 * @param ctx the parse tree
	 */
	void exitTypeDefinitionPart(MiniPascalGrammarParser.TypeDefinitionPartContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPascalGrammarParser#typeDefinition}.
	 * @param ctx the parse tree
	 */
	void enterTypeDefinition(MiniPascalGrammarParser.TypeDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPascalGrammarParser#typeDefinition}.
	 * @param ctx the parse tree
	 */
	void exitTypeDefinition(MiniPascalGrammarParser.TypeDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPascalGrammarParser#functionType}.
	 * @param ctx the parse tree
	 */
	void enterFunctionType(MiniPascalGrammarParser.FunctionTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPascalGrammarParser#functionType}.
	 * @param ctx the parse tree
	 */
	void exitFunctionType(MiniPascalGrammarParser.FunctionTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPascalGrammarParser#type_}.
	 * @param ctx the parse tree
	 */
	void enterType_(MiniPascalGrammarParser.Type_Context ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPascalGrammarParser#type_}.
	 * @param ctx the parse tree
	 */
	void exitType_(MiniPascalGrammarParser.Type_Context ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPascalGrammarParser#simpleType}.
	 * @param ctx the parse tree
	 */
	void enterSimpleType(MiniPascalGrammarParser.SimpleTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPascalGrammarParser#simpleType}.
	 * @param ctx the parse tree
	 */
	void exitSimpleType(MiniPascalGrammarParser.SimpleTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPascalGrammarParser#subrangeType}.
	 * @param ctx the parse tree
	 */
	void enterSubrangeType(MiniPascalGrammarParser.SubrangeTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPascalGrammarParser#subrangeType}.
	 * @param ctx the parse tree
	 */
	void exitSubrangeType(MiniPascalGrammarParser.SubrangeTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPascalGrammarParser#typeIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterTypeIdentifier(MiniPascalGrammarParser.TypeIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPascalGrammarParser#typeIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitTypeIdentifier(MiniPascalGrammarParser.TypeIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPascalGrammarParser#stringtype}.
	 * @param ctx the parse tree
	 */
	void enterStringtype(MiniPascalGrammarParser.StringtypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPascalGrammarParser#stringtype}.
	 * @param ctx the parse tree
	 */
	void exitStringtype(MiniPascalGrammarParser.StringtypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPascalGrammarParser#variableDeclarationPart}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclarationPart(MiniPascalGrammarParser.VariableDeclarationPartContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPascalGrammarParser#variableDeclarationPart}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclarationPart(MiniPascalGrammarParser.VariableDeclarationPartContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPascalGrammarParser#variableDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclaration(MiniPascalGrammarParser.VariableDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPascalGrammarParser#variableDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclaration(MiniPascalGrammarParser.VariableDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPascalGrammarParser#procedureAndFunctionDeclarationPart}.
	 * @param ctx the parse tree
	 */
	void enterProcedureAndFunctionDeclarationPart(MiniPascalGrammarParser.ProcedureAndFunctionDeclarationPartContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPascalGrammarParser#procedureAndFunctionDeclarationPart}.
	 * @param ctx the parse tree
	 */
	void exitProcedureAndFunctionDeclarationPart(MiniPascalGrammarParser.ProcedureAndFunctionDeclarationPartContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPascalGrammarParser#procedureOrFunctionDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterProcedureOrFunctionDeclaration(MiniPascalGrammarParser.ProcedureOrFunctionDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPascalGrammarParser#procedureOrFunctionDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitProcedureOrFunctionDeclaration(MiniPascalGrammarParser.ProcedureOrFunctionDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPascalGrammarParser#formalParameterList}.
	 * @param ctx the parse tree
	 */
	void enterFormalParameterList(MiniPascalGrammarParser.FormalParameterListContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPascalGrammarParser#formalParameterList}.
	 * @param ctx the parse tree
	 */
	void exitFormalParameterList(MiniPascalGrammarParser.FormalParameterListContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPascalGrammarParser#formalParameterSection}.
	 * @param ctx the parse tree
	 */
	void enterFormalParameterSection(MiniPascalGrammarParser.FormalParameterSectionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPascalGrammarParser#formalParameterSection}.
	 * @param ctx the parse tree
	 */
	void exitFormalParameterSection(MiniPascalGrammarParser.FormalParameterSectionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPascalGrammarParser#parameterGroup}.
	 * @param ctx the parse tree
	 */
	void enterParameterGroup(MiniPascalGrammarParser.ParameterGroupContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPascalGrammarParser#parameterGroup}.
	 * @param ctx the parse tree
	 */
	void exitParameterGroup(MiniPascalGrammarParser.ParameterGroupContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPascalGrammarParser#identifierList}.
	 * @param ctx the parse tree
	 */
	void enterIdentifierList(MiniPascalGrammarParser.IdentifierListContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPascalGrammarParser#identifierList}.
	 * @param ctx the parse tree
	 */
	void exitIdentifierList(MiniPascalGrammarParser.IdentifierListContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPascalGrammarParser#constList}.
	 * @param ctx the parse tree
	 */
	void enterConstList(MiniPascalGrammarParser.ConstListContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPascalGrammarParser#constList}.
	 * @param ctx the parse tree
	 */
	void exitConstList(MiniPascalGrammarParser.ConstListContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPascalGrammarParser#functionDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDeclaration(MiniPascalGrammarParser.FunctionDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPascalGrammarParser#functionDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDeclaration(MiniPascalGrammarParser.FunctionDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPascalGrammarParser#procedureDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterProcedureDeclaration(MiniPascalGrammarParser.ProcedureDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPascalGrammarParser#procedureDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitProcedureDeclaration(MiniPascalGrammarParser.ProcedureDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPascalGrammarParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(MiniPascalGrammarParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPascalGrammarParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(MiniPascalGrammarParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPascalGrammarParser#writeStatement}.
	 * @param ctx the parse tree
	 */
	void enterWriteStatement(MiniPascalGrammarParser.WriteStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPascalGrammarParser#writeStatement}.
	 * @param ctx the parse tree
	 */
	void exitWriteStatement(MiniPascalGrammarParser.WriteStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPascalGrammarParser#write}.
	 * @param ctx the parse tree
	 */
	void enterWrite(MiniPascalGrammarParser.WriteContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPascalGrammarParser#write}.
	 * @param ctx the parse tree
	 */
	void exitWrite(MiniPascalGrammarParser.WriteContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPascalGrammarParser#readWriteVarValue}.
	 * @param ctx the parse tree
	 */
	void enterReadWriteVarValue(MiniPascalGrammarParser.ReadWriteVarValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPascalGrammarParser#readWriteVarValue}.
	 * @param ctx the parse tree
	 */
	void exitReadWriteVarValue(MiniPascalGrammarParser.ReadWriteVarValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPascalGrammarParser#readStatement}.
	 * @param ctx the parse tree
	 */
	void enterReadStatement(MiniPascalGrammarParser.ReadStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPascalGrammarParser#readStatement}.
	 * @param ctx the parse tree
	 */
	void exitReadStatement(MiniPascalGrammarParser.ReadStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPascalGrammarParser#read}.
	 * @param ctx the parse tree
	 */
	void enterRead(MiniPascalGrammarParser.ReadContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPascalGrammarParser#read}.
	 * @param ctx the parse tree
	 */
	void exitRead(MiniPascalGrammarParser.ReadContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPascalGrammarParser#readParam}.
	 * @param ctx the parse tree
	 */
	void enterReadParam(MiniPascalGrammarParser.ReadParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPascalGrammarParser#readParam}.
	 * @param ctx the parse tree
	 */
	void exitReadParam(MiniPascalGrammarParser.ReadParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPascalGrammarParser#unlabelledStatement}.
	 * @param ctx the parse tree
	 */
	void enterUnlabelledStatement(MiniPascalGrammarParser.UnlabelledStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPascalGrammarParser#unlabelledStatement}.
	 * @param ctx the parse tree
	 */
	void exitUnlabelledStatement(MiniPascalGrammarParser.UnlabelledStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPascalGrammarParser#simpleStatement}.
	 * @param ctx the parse tree
	 */
	void enterSimpleStatement(MiniPascalGrammarParser.SimpleStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPascalGrammarParser#simpleStatement}.
	 * @param ctx the parse tree
	 */
	void exitSimpleStatement(MiniPascalGrammarParser.SimpleStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPascalGrammarParser#assignmentStatement}.
	 * @param ctx the parse tree
	 */
	void enterAssignmentStatement(MiniPascalGrammarParser.AssignmentStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPascalGrammarParser#assignmentStatement}.
	 * @param ctx the parse tree
	 */
	void exitAssignmentStatement(MiniPascalGrammarParser.AssignmentStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPascalGrammarParser#variable}.
	 * @param ctx the parse tree
	 */
	void enterVariable(MiniPascalGrammarParser.VariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPascalGrammarParser#variable}.
	 * @param ctx the parse tree
	 */
	void exitVariable(MiniPascalGrammarParser.VariableContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPascalGrammarParser#expressionList}.
	 * @param ctx the parse tree
	 */
	void enterExpressionList(MiniPascalGrammarParser.ExpressionListContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPascalGrammarParser#expressionList}.
	 * @param ctx the parse tree
	 */
	void exitExpressionList(MiniPascalGrammarParser.ExpressionListContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPascalGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(MiniPascalGrammarParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPascalGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(MiniPascalGrammarParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPascalGrammarParser#relationaloperator}.
	 * @param ctx the parse tree
	 */
	void enterRelationaloperator(MiniPascalGrammarParser.RelationaloperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPascalGrammarParser#relationaloperator}.
	 * @param ctx the parse tree
	 */
	void exitRelationaloperator(MiniPascalGrammarParser.RelationaloperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPascalGrammarParser#simpleExpression}.
	 * @param ctx the parse tree
	 */
	void enterSimpleExpression(MiniPascalGrammarParser.SimpleExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPascalGrammarParser#simpleExpression}.
	 * @param ctx the parse tree
	 */
	void exitSimpleExpression(MiniPascalGrammarParser.SimpleExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPascalGrammarParser#additiveoperator}.
	 * @param ctx the parse tree
	 */
	void enterAdditiveoperator(MiniPascalGrammarParser.AdditiveoperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPascalGrammarParser#additiveoperator}.
	 * @param ctx the parse tree
	 */
	void exitAdditiveoperator(MiniPascalGrammarParser.AdditiveoperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPascalGrammarParser#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm(MiniPascalGrammarParser.TermContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPascalGrammarParser#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm(MiniPascalGrammarParser.TermContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPascalGrammarParser#multiplicativeoperator}.
	 * @param ctx the parse tree
	 */
	void enterMultiplicativeoperator(MiniPascalGrammarParser.MultiplicativeoperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPascalGrammarParser#multiplicativeoperator}.
	 * @param ctx the parse tree
	 */
	void exitMultiplicativeoperator(MiniPascalGrammarParser.MultiplicativeoperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPascalGrammarParser#signedFactor}.
	 * @param ctx the parse tree
	 */
	void enterSignedFactor(MiniPascalGrammarParser.SignedFactorContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPascalGrammarParser#signedFactor}.
	 * @param ctx the parse tree
	 */
	void exitSignedFactor(MiniPascalGrammarParser.SignedFactorContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPascalGrammarParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactor(MiniPascalGrammarParser.FactorContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPascalGrammarParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactor(MiniPascalGrammarParser.FactorContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPascalGrammarParser#unsignedConstant}.
	 * @param ctx the parse tree
	 */
	void enterUnsignedConstant(MiniPascalGrammarParser.UnsignedConstantContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPascalGrammarParser#unsignedConstant}.
	 * @param ctx the parse tree
	 */
	void exitUnsignedConstant(MiniPascalGrammarParser.UnsignedConstantContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPascalGrammarParser#functionDesignator}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDesignator(MiniPascalGrammarParser.FunctionDesignatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPascalGrammarParser#functionDesignator}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDesignator(MiniPascalGrammarParser.FunctionDesignatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPascalGrammarParser#parameterList}.
	 * @param ctx the parse tree
	 */
	void enterParameterList(MiniPascalGrammarParser.ParameterListContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPascalGrammarParser#parameterList}.
	 * @param ctx the parse tree
	 */
	void exitParameterList(MiniPascalGrammarParser.ParameterListContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPascalGrammarParser#set_}.
	 * @param ctx the parse tree
	 */
	void enterSet_(MiniPascalGrammarParser.Set_Context ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPascalGrammarParser#set_}.
	 * @param ctx the parse tree
	 */
	void exitSet_(MiniPascalGrammarParser.Set_Context ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPascalGrammarParser#elementList}.
	 * @param ctx the parse tree
	 */
	void enterElementList(MiniPascalGrammarParser.ElementListContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPascalGrammarParser#elementList}.
	 * @param ctx the parse tree
	 */
	void exitElementList(MiniPascalGrammarParser.ElementListContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPascalGrammarParser#element}.
	 * @param ctx the parse tree
	 */
	void enterElement(MiniPascalGrammarParser.ElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPascalGrammarParser#element}.
	 * @param ctx the parse tree
	 */
	void exitElement(MiniPascalGrammarParser.ElementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPascalGrammarParser#actualParameter}.
	 * @param ctx the parse tree
	 */
	void enterActualParameter(MiniPascalGrammarParser.ActualParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPascalGrammarParser#actualParameter}.
	 * @param ctx the parse tree
	 */
	void exitActualParameter(MiniPascalGrammarParser.ActualParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPascalGrammarParser#parameterwidth}.
	 * @param ctx the parse tree
	 */
	void enterParameterwidth(MiniPascalGrammarParser.ParameterwidthContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPascalGrammarParser#parameterwidth}.
	 * @param ctx the parse tree
	 */
	void exitParameterwidth(MiniPascalGrammarParser.ParameterwidthContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPascalGrammarParser#emptyStatement_}.
	 * @param ctx the parse tree
	 */
	void enterEmptyStatement_(MiniPascalGrammarParser.EmptyStatement_Context ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPascalGrammarParser#emptyStatement_}.
	 * @param ctx the parse tree
	 */
	void exitEmptyStatement_(MiniPascalGrammarParser.EmptyStatement_Context ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPascalGrammarParser#structuredStatement}.
	 * @param ctx the parse tree
	 */
	void enterStructuredStatement(MiniPascalGrammarParser.StructuredStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPascalGrammarParser#structuredStatement}.
	 * @param ctx the parse tree
	 */
	void exitStructuredStatement(MiniPascalGrammarParser.StructuredStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPascalGrammarParser#compoundStatement}.
	 * @param ctx the parse tree
	 */
	void enterCompoundStatement(MiniPascalGrammarParser.CompoundStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPascalGrammarParser#compoundStatement}.
	 * @param ctx the parse tree
	 */
	void exitCompoundStatement(MiniPascalGrammarParser.CompoundStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPascalGrammarParser#statements}.
	 * @param ctx the parse tree
	 */
	void enterStatements(MiniPascalGrammarParser.StatementsContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPascalGrammarParser#statements}.
	 * @param ctx the parse tree
	 */
	void exitStatements(MiniPascalGrammarParser.StatementsContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPascalGrammarParser#conditionalStatement}.
	 * @param ctx the parse tree
	 */
	void enterConditionalStatement(MiniPascalGrammarParser.ConditionalStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPascalGrammarParser#conditionalStatement}.
	 * @param ctx the parse tree
	 */
	void exitConditionalStatement(MiniPascalGrammarParser.ConditionalStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPascalGrammarParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(MiniPascalGrammarParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPascalGrammarParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(MiniPascalGrammarParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPascalGrammarParser#repetitiveStatement}.
	 * @param ctx the parse tree
	 */
	void enterRepetitiveStatement(MiniPascalGrammarParser.RepetitiveStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPascalGrammarParser#repetitiveStatement}.
	 * @param ctx the parse tree
	 */
	void exitRepetitiveStatement(MiniPascalGrammarParser.RepetitiveStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPascalGrammarParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void enterWhileStatement(MiniPascalGrammarParser.WhileStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPascalGrammarParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void exitWhileStatement(MiniPascalGrammarParser.WhileStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPascalGrammarParser#repeatStatement}.
	 * @param ctx the parse tree
	 */
	void enterRepeatStatement(MiniPascalGrammarParser.RepeatStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPascalGrammarParser#repeatStatement}.
	 * @param ctx the parse tree
	 */
	void exitRepeatStatement(MiniPascalGrammarParser.RepeatStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPascalGrammarParser#forStatement}.
	 * @param ctx the parse tree
	 */
	void enterForStatement(MiniPascalGrammarParser.ForStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPascalGrammarParser#forStatement}.
	 * @param ctx the parse tree
	 */
	void exitForStatement(MiniPascalGrammarParser.ForStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPascalGrammarParser#forList}.
	 * @param ctx the parse tree
	 */
	void enterForList(MiniPascalGrammarParser.ForListContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPascalGrammarParser#forList}.
	 * @param ctx the parse tree
	 */
	void exitForList(MiniPascalGrammarParser.ForListContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPascalGrammarParser#initialValue}.
	 * @param ctx the parse tree
	 */
	void enterInitialValue(MiniPascalGrammarParser.InitialValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPascalGrammarParser#initialValue}.
	 * @param ctx the parse tree
	 */
	void exitInitialValue(MiniPascalGrammarParser.InitialValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPascalGrammarParser#arrayInitialization}.
	 * @param ctx the parse tree
	 */
	void enterArrayInitialization(MiniPascalGrammarParser.ArrayInitializationContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPascalGrammarParser#arrayInitialization}.
	 * @param ctx the parse tree
	 */
	void exitArrayInitialization(MiniPascalGrammarParser.ArrayInitializationContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPascalGrammarParser#finalValue}.
	 * @param ctx the parse tree
	 */
	void enterFinalValue(MiniPascalGrammarParser.FinalValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPascalGrammarParser#finalValue}.
	 * @param ctx the parse tree
	 */
	void exitFinalValue(MiniPascalGrammarParser.FinalValueContext ctx);
}