// Generated from C:/Users/serli/Compi 1 Serlio/Proyecto Daniel/MiniPascalCompiler/MiniPascalGrammar.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link MiniPascalGrammarParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface MiniPascalGrammarVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link MiniPascalGrammarParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(MiniPascalGrammarParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPascalGrammarParser#programHeading}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgramHeading(MiniPascalGrammarParser.ProgramHeadingContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPascalGrammarParser#identifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifier(MiniPascalGrammarParser.IdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPascalGrammarParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(MiniPascalGrammarParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPascalGrammarParser#constantDefinitionPart}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstantDefinitionPart(MiniPascalGrammarParser.ConstantDefinitionPartContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPascalGrammarParser#constantDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstantDefinition(MiniPascalGrammarParser.ConstantDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPascalGrammarParser#constantChr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstantChr(MiniPascalGrammarParser.ConstantChrContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPascalGrammarParser#constant}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstant(MiniPascalGrammarParser.ConstantContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPascalGrammarParser#varType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarType(MiniPascalGrammarParser.VarTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPascalGrammarParser#arrayType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayType(MiniPascalGrammarParser.ArrayTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPascalGrammarParser#arrayOfType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayOfType(MiniPascalGrammarParser.ArrayOfTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPascalGrammarParser#arrayValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayValue(MiniPascalGrammarParser.ArrayValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPascalGrammarParser#indexRanges}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexRanges(MiniPascalGrammarParser.IndexRangesContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPascalGrammarParser#indexRange}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexRange(MiniPascalGrammarParser.IndexRangeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPascalGrammarParser#stringR_}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringR_(MiniPascalGrammarParser.StringR_Context ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPascalGrammarParser#charR_}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCharR_(MiniPascalGrammarParser.CharR_Context ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPascalGrammarParser#integerR_}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntegerR_(MiniPascalGrammarParser.IntegerR_Context ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPascalGrammarParser#booleanR_}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanR_(MiniPascalGrammarParser.BooleanR_Context ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPascalGrammarParser#unsignedNumber}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnsignedNumber(MiniPascalGrammarParser.UnsignedNumberContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPascalGrammarParser#unsignedInteger}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnsignedInteger(MiniPascalGrammarParser.UnsignedIntegerContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPascalGrammarParser#sign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSign(MiniPascalGrammarParser.SignContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPascalGrammarParser#bool_}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBool_(MiniPascalGrammarParser.Bool_Context ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPascalGrammarParser#string}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitString(MiniPascalGrammarParser.StringContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPascalGrammarParser#boolean}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolean(MiniPascalGrammarParser.BooleanContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPascalGrammarParser#char}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChar(MiniPascalGrammarParser.CharContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPascalGrammarParser#integer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInteger(MiniPascalGrammarParser.IntegerContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPascalGrammarParser#typeDefinitionPart}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeDefinitionPart(MiniPascalGrammarParser.TypeDefinitionPartContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPascalGrammarParser#typeDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeDefinition(MiniPascalGrammarParser.TypeDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPascalGrammarParser#functionType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionType(MiniPascalGrammarParser.FunctionTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPascalGrammarParser#procedureType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProcedureType(MiniPascalGrammarParser.ProcedureTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPascalGrammarParser#type_}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType_(MiniPascalGrammarParser.Type_Context ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPascalGrammarParser#simpleType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleType(MiniPascalGrammarParser.SimpleTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPascalGrammarParser#scalarType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitScalarType(MiniPascalGrammarParser.ScalarTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPascalGrammarParser#subrangeType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubrangeType(MiniPascalGrammarParser.SubrangeTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPascalGrammarParser#typeIdentifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeIdentifier(MiniPascalGrammarParser.TypeIdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPascalGrammarParser#stringtype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringtype(MiniPascalGrammarParser.StringtypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPascalGrammarParser#typeList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeList(MiniPascalGrammarParser.TypeListContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPascalGrammarParser#indexType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexType(MiniPascalGrammarParser.IndexTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPascalGrammarParser#componentType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComponentType(MiniPascalGrammarParser.ComponentTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPascalGrammarParser#fixedPart}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFixedPart(MiniPascalGrammarParser.FixedPartContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPascalGrammarParser#recordSection}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRecordSection(MiniPascalGrammarParser.RecordSectionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPascalGrammarParser#tag}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTag(MiniPascalGrammarParser.TagContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPascalGrammarParser#baseType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBaseType(MiniPascalGrammarParser.BaseTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPascalGrammarParser#variableDeclarationPart}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclarationPart(MiniPascalGrammarParser.VariableDeclarationPartContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPascalGrammarParser#variableDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclaration(MiniPascalGrammarParser.VariableDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPascalGrammarParser#procedureAndFunctionDeclarationPart}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProcedureAndFunctionDeclarationPart(MiniPascalGrammarParser.ProcedureAndFunctionDeclarationPartContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPascalGrammarParser#procedureOrFunctionDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProcedureOrFunctionDeclaration(MiniPascalGrammarParser.ProcedureOrFunctionDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPascalGrammarParser#formalParameterList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormalParameterList(MiniPascalGrammarParser.FormalParameterListContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPascalGrammarParser#formalParameterSection}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormalParameterSection(MiniPascalGrammarParser.FormalParameterSectionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPascalGrammarParser#parameterGroup}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterGroup(MiniPascalGrammarParser.ParameterGroupContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPascalGrammarParser#identifierList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifierList(MiniPascalGrammarParser.IdentifierListContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPascalGrammarParser#constList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstList(MiniPascalGrammarParser.ConstListContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPascalGrammarParser#functionDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDeclaration(MiniPascalGrammarParser.FunctionDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPascalGrammarParser#procedureDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProcedureDeclaration(MiniPascalGrammarParser.ProcedureDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPascalGrammarParser#resultType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitResultType(MiniPascalGrammarParser.ResultTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPascalGrammarParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(MiniPascalGrammarParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPascalGrammarParser#writeStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWriteStatement(MiniPascalGrammarParser.WriteStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPascalGrammarParser#write}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWrite(MiniPascalGrammarParser.WriteContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPascalGrammarParser#writeParam}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWriteParam(MiniPascalGrammarParser.WriteParamContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPascalGrammarParser#varValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarValue(MiniPascalGrammarParser.VarValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPascalGrammarParser#readWriteVarValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReadWriteVarValue(MiniPascalGrammarParser.ReadWriteVarValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPascalGrammarParser#readStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReadStatement(MiniPascalGrammarParser.ReadStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPascalGrammarParser#read}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRead(MiniPascalGrammarParser.ReadContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPascalGrammarParser#readParam}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReadParam(MiniPascalGrammarParser.ReadParamContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPascalGrammarParser#unlabelledStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnlabelledStatement(MiniPascalGrammarParser.UnlabelledStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPascalGrammarParser#simpleStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleStatement(MiniPascalGrammarParser.SimpleStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPascalGrammarParser#assignmentStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentStatement(MiniPascalGrammarParser.AssignmentStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPascalGrammarParser#variable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable(MiniPascalGrammarParser.VariableContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPascalGrammarParser#expressionList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionList(MiniPascalGrammarParser.ExpressionListContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPascalGrammarParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(MiniPascalGrammarParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPascalGrammarParser#relationaloperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelationaloperator(MiniPascalGrammarParser.RelationaloperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPascalGrammarParser#simpleExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleExpression(MiniPascalGrammarParser.SimpleExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPascalGrammarParser#additiveoperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdditiveoperator(MiniPascalGrammarParser.AdditiveoperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPascalGrammarParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerm(MiniPascalGrammarParser.TermContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPascalGrammarParser#multiplicativeoperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplicativeoperator(MiniPascalGrammarParser.MultiplicativeoperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPascalGrammarParser#signedFactor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSignedFactor(MiniPascalGrammarParser.SignedFactorContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPascalGrammarParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFactor(MiniPascalGrammarParser.FactorContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPascalGrammarParser#unsignedConstant}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnsignedConstant(MiniPascalGrammarParser.UnsignedConstantContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPascalGrammarParser#functionDesignator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDesignator(MiniPascalGrammarParser.FunctionDesignatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPascalGrammarParser#parameterList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterList(MiniPascalGrammarParser.ParameterListContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPascalGrammarParser#set_}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSet_(MiniPascalGrammarParser.Set_Context ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPascalGrammarParser#elementList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElementList(MiniPascalGrammarParser.ElementListContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPascalGrammarParser#element}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElement(MiniPascalGrammarParser.ElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPascalGrammarParser#actualParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitActualParameter(MiniPascalGrammarParser.ActualParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPascalGrammarParser#parameterwidth}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterwidth(MiniPascalGrammarParser.ParameterwidthContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPascalGrammarParser#emptyStatement_}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEmptyStatement_(MiniPascalGrammarParser.EmptyStatement_Context ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPascalGrammarParser#structuredStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStructuredStatement(MiniPascalGrammarParser.StructuredStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPascalGrammarParser#compoundStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompoundStatement(MiniPascalGrammarParser.CompoundStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPascalGrammarParser#statements}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatements(MiniPascalGrammarParser.StatementsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPascalGrammarParser#conditionalStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionalStatement(MiniPascalGrammarParser.ConditionalStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPascalGrammarParser#ifStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatement(MiniPascalGrammarParser.IfStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPascalGrammarParser#repetitiveStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRepetitiveStatement(MiniPascalGrammarParser.RepetitiveStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPascalGrammarParser#whileStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStatement(MiniPascalGrammarParser.WhileStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPascalGrammarParser#repeatStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRepeatStatement(MiniPascalGrammarParser.RepeatStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPascalGrammarParser#forStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForStatement(MiniPascalGrammarParser.ForStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPascalGrammarParser#forList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForList(MiniPascalGrammarParser.ForListContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPascalGrammarParser#initialValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInitialValue(MiniPascalGrammarParser.InitialValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPascalGrammarParser#arrayInitialization}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayInitialization(MiniPascalGrammarParser.ArrayInitializationContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPascalGrammarParser#finalValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFinalValue(MiniPascalGrammarParser.FinalValueContext ctx);
}