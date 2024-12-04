public class IRVisitors extends MiniPascalGrammarBaseVisitor<Object> {

    public Object visitProgram(MiniPascalGrammarParser.ProgramContext ctx) {
        System.out.println("Programa Nuevoooooo");
        return visitChildren(ctx);
    }

    public Object visitProgramHeading(MiniPascalGrammarParser.ProgramHeadingContext ctx) {
        return visitChildren(ctx);
    }

    public Object visitIdentifier(MiniPascalGrammarParser.IdentifierContext ctx) {
        return visitChildren(ctx);
    }

    public Object visitBlock(MiniPascalGrammarParser.BlockContext ctx) {
        return visitChildren(ctx);
    }

    public Object visitConstantDefinitionPart(MiniPascalGrammarParser.ConstantDefinitionPartContext ctx) {
        return visitChildren(ctx);
    }

    public Object visitConstantDefinition(MiniPascalGrammarParser.ConstantDefinitionContext ctx) {
        return visitChildren(ctx);
    }

    public Object visitConstantChr(MiniPascalGrammarParser.ConstantChrContext ctx) {
        return visitChildren(ctx);
    }

    public Object visitConstant(MiniPascalGrammarParser.ConstantContext ctx) {
        return visitChildren(ctx);
    }

    public Object visitVarType(MiniPascalGrammarParser.VarTypeContext ctx) {
        return visitChildren(ctx);
    }

    public Object visitArrayType(MiniPascalGrammarParser.ArrayTypeContext ctx) {
        return visitChildren(ctx);
    }

    public Object visitArrayOfType(MiniPascalGrammarParser.ArrayOfTypeContext ctx) {
        return visitChildren(ctx);
    }

    public Object visitArrayValue(MiniPascalGrammarParser.ArrayValueContext ctx) {
        return visitChildren(ctx);
    }

    public Object visitIndexRanges(MiniPascalGrammarParser.IndexRangesContext ctx) {
        return visitChildren(ctx);
    }

    public Object visitIndexRange(MiniPascalGrammarParser.IndexRangeContext ctx) {
        return visitChildren(ctx);
    }

    public Object visitStringR_(MiniPascalGrammarParser.StringR_Context ctx) {
        return visitChildren(ctx);
    }

    public Object visitCharR_(MiniPascalGrammarParser.CharR_Context ctx) {
        return visitChildren(ctx);
    }

    public Object visitIntegerR_(MiniPascalGrammarParser.IntegerR_Context ctx) {
        return visitChildren(ctx);
    }

    public Object visitBooleanR_(MiniPascalGrammarParser.BooleanR_Context ctx) {
        return visitChildren(ctx);
    }

    public Object visitUnsignedNumber(MiniPascalGrammarParser.UnsignedNumberContext ctx) {
        return visitChildren(ctx);
    }

    public Object visitUnsignedInteger(MiniPascalGrammarParser.UnsignedIntegerContext ctx) {
        return visitChildren(ctx);
    }

    public Object visitSign(MiniPascalGrammarParser.SignContext ctx) {
        return visitChildren(ctx);
    }

    public Object visitBool_(MiniPascalGrammarParser.Bool_Context ctx) {
        return visitChildren(ctx);
    }

    public Object visitString(MiniPascalGrammarParser.StringContext ctx) {
        return visitChildren(ctx);
    }

    public Object visitBoolean(MiniPascalGrammarParser.BooleanContext ctx) {
        return visitChildren(ctx);
    }

    public Object visitChar(MiniPascalGrammarParser.CharContext ctx) {
        return visitChildren(ctx);
    }

    public Object visitInteger(MiniPascalGrammarParser.IntegerContext ctx) {
        return visitChildren(ctx);
    }

    public Object visitTypeDefinitionPart(MiniPascalGrammarParser.TypeDefinitionPartContext ctx) {
        return visitChildren(ctx);
    }

    public Object visitTypeDefinition(MiniPascalGrammarParser.TypeDefinitionContext ctx) {
        return visitChildren(ctx);
    }

    public Object visitFunctionType(MiniPascalGrammarParser.FunctionTypeContext ctx) {
        return visitChildren(ctx);
    }

    public Object visitType_(MiniPascalGrammarParser.Type_Context ctx) {
        return visitChildren(ctx);
    }

    public Object visitSimpleType(MiniPascalGrammarParser.SimpleTypeContext ctx) {
        return visitChildren(ctx);
    }

    public Object visitSubrangeType(MiniPascalGrammarParser.SubrangeTypeContext ctx) {
        return visitChildren(ctx);
    }

    public Object visitTypeIdentifier(MiniPascalGrammarParser.TypeIdentifierContext ctx) {
        return visitChildren(ctx);
    }

    public Object visitStringtype(MiniPascalGrammarParser.StringtypeContext ctx) {
        return visitChildren(ctx);
    }

    public Object visitVariableDeclarationPart(MiniPascalGrammarParser.VariableDeclarationPartContext ctx) {
        return visitChildren(ctx);
    }

    public Object visitVariableDeclaration(MiniPascalGrammarParser.VariableDeclarationContext ctx) {
        return visitChildren(ctx);
    }

    public Object visitProcedureAndFunctionDeclarationPart(MiniPascalGrammarParser.ProcedureAndFunctionDeclarationPartContext ctx) {
        return visitChildren(ctx);
    }

    public Object visitProcedureOrFunctionDeclaration(MiniPascalGrammarParser.ProcedureOrFunctionDeclarationContext ctx) {
        return visitChildren(ctx);
    }

    public Object visitFormalParameterList(MiniPascalGrammarParser.FormalParameterListContext ctx) {
        return visitChildren(ctx);
    }

    public Object visitFormalParameterSection(MiniPascalGrammarParser.FormalParameterSectionContext ctx) {
        return visitChildren(ctx);
    }

    public Object visitParameterGroup(MiniPascalGrammarParser.ParameterGroupContext ctx) {
        return visitChildren(ctx);
    }

    public Object visitIdentifierList(MiniPascalGrammarParser.IdentifierListContext ctx) {
        return visitChildren(ctx);
    }

    public Object visitConstList(MiniPascalGrammarParser.ConstListContext ctx) {
        return visitChildren(ctx);
    }

    public Object visitFunctionDeclaration(MiniPascalGrammarParser.FunctionDeclarationContext ctx) {
        return visitChildren(ctx);
    }

    public Object visitProcedureDeclaration(MiniPascalGrammarParser.ProcedureDeclarationContext ctx) {
        return visitChildren(ctx);
    }

    public Object visitStatement(MiniPascalGrammarParser.StatementContext ctx) {
        return visitChildren(ctx);
    }

    public Object visitWriteStatement(MiniPascalGrammarParser.WriteStatementContext ctx) {
        return visitChildren(ctx);
    }

    public Object visitWrite(MiniPascalGrammarParser.WriteContext ctx) {
        return visitChildren(ctx);
    }

    public Object visitReadWriteVarValue(MiniPascalGrammarParser.ReadWriteVarValueContext ctx) {
        return visitChildren(ctx);
    }

    public Object visitReadStatement(MiniPascalGrammarParser.ReadStatementContext ctx) {
        return visitChildren(ctx);
    }

    public Object visitRead(MiniPascalGrammarParser.ReadContext ctx) {
        return visitChildren(ctx);
    }

    public Object visitReadParam(MiniPascalGrammarParser.ReadParamContext ctx) {
        return visitChildren(ctx);
    }

    public Object visitUnlabelledStatement(MiniPascalGrammarParser.UnlabelledStatementContext ctx) {
        return visitChildren(ctx);
    }

    public Object visitSimpleStatement(MiniPascalGrammarParser.SimpleStatementContext ctx) {
        return visitChildren(ctx);
    }

    public Object visitAssignmentStatement(MiniPascalGrammarParser.AssignmentStatementContext ctx) {
        return visitChildren(ctx);
    }

    public Object visitVariable(MiniPascalGrammarParser.VariableContext ctx) {
        return visitChildren(ctx);
    }

    public Object visitExpressionList(MiniPascalGrammarParser.ExpressionListContext ctx) {
        return visitChildren(ctx);
    }

    public Object visitExpression(MiniPascalGrammarParser.ExpressionContext ctx) {
        return visitChildren(ctx);
    }

    public Object visitRelationaloperator(MiniPascalGrammarParser.RelationaloperatorContext ctx) {
        return visitChildren(ctx);
    }

    public Object visitSimpleExpression(MiniPascalGrammarParser.SimpleExpressionContext ctx) {
        return visitChildren(ctx);
    }

    public Object visitAdditiveoperator(MiniPascalGrammarParser.AdditiveoperatorContext ctx) {
        return visitChildren(ctx);
    }

    public Object visitTerm(MiniPascalGrammarParser.TermContext ctx) {
        return visitChildren(ctx);
    }

    public Object visitMultiplicativeoperator(MiniPascalGrammarParser.MultiplicativeoperatorContext ctx) {
        return visitChildren(ctx);
    }

    public Object visitSignedFactor(MiniPascalGrammarParser.SignedFactorContext ctx) {
        return visitChildren(ctx);
    }

    public Object visitFactor(MiniPascalGrammarParser.FactorContext ctx) {
        return visitChildren(ctx);
    }

    public Object visitUnsignedConstant(MiniPascalGrammarParser.UnsignedConstantContext ctx) {
        return visitChildren(ctx);
    }

    public Object visitFunctionDesignator(MiniPascalGrammarParser.FunctionDesignatorContext ctx) {
        return visitChildren(ctx);
    }

    public Object visitParameterList(MiniPascalGrammarParser.ParameterListContext ctx) {
        return visitChildren(ctx);
    }

    public Object visitSet_(MiniPascalGrammarParser.Set_Context ctx) {
        return visitChildren(ctx);
    }

    public Object visitElementList(MiniPascalGrammarParser.ElementListContext ctx) {
        return visitChildren(ctx);
    }

    public Object visitElement(MiniPascalGrammarParser.ElementContext ctx) {
        return visitChildren(ctx);
    }

    public Object visitActualParameter(MiniPascalGrammarParser.ActualParameterContext ctx) {
        return visitChildren(ctx);
    }

    public Object visitEmptyStatement_(MiniPascalGrammarParser.EmptyStatement_Context ctx) {
        return visitChildren(ctx);
    }

    public Object visitStructuredStatement(MiniPascalGrammarParser.StructuredStatementContext ctx) {
        return visitChildren(ctx);
    }

    public Object visitCompoundStatement(MiniPascalGrammarParser.CompoundStatementContext ctx) {
        return visitChildren(ctx);
    }

    public Object visitStatements(MiniPascalGrammarParser.StatementsContext ctx) {
        return visitChildren(ctx);
    }

    public Object visitConditionalStatement(MiniPascalGrammarParser.ConditionalStatementContext ctx) {
        return visitChildren(ctx);
    }

    public Object visitIfStatement(MiniPascalGrammarParser.IfStatementContext ctx) {
        return visitChildren(ctx);
    }

    public Object visitRepetitiveStatement(MiniPascalGrammarParser.RepetitiveStatementContext ctx) {
        return visitChildren(ctx);
    }

    public Object visitWhileStatement(MiniPascalGrammarParser.WhileStatementContext ctx) {
        return visitChildren(ctx);
    }

    public Object visitRepeatStatement(MiniPascalGrammarParser.RepeatStatementContext ctx) {
        return visitChildren(ctx);
    }

    public Object visitForStatement(MiniPascalGrammarParser.ForStatementContext ctx) {
        return visitChildren(ctx);
    }

    public Object visitForList(MiniPascalGrammarParser.ForListContext ctx) {
        return visitChildren(ctx);
    }

    public Object visitInitialValue(MiniPascalGrammarParser.InitialValueContext ctx) {
        return visitChildren(ctx);
    }

    public Object visitArrayInitialization(MiniPascalGrammarParser.ArrayInitializationContext ctx) {
        return visitChildren(ctx);
    }

    public Object visitFinalValue(MiniPascalGrammarParser.FinalValueContext ctx) {
        return visitChildren(ctx);
    }

}
