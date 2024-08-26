


public class MyVisitor extends MiniPascalGrammarBaseVisitor<Object> {

    @Override
    public Object visitProgram(MiniPascalGrammarParser.ProgramContext ctx) {
//        System.out.println("Archivo Vacío");
//        System.out.println(ctx.getText());
        return visitChildren(ctx);
    }

    @Override
    public Object visitProgramHeading(MiniPascalGrammarParser.ProgramHeadingContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitIdentifier(MiniPascalGrammarParser.IdentifierContext ctx) {
//        System.out.println("Error Here");
        return visitChildren(ctx);
    }

    @Override
    public Object visitBlock(MiniPascalGrammarParser.BlockContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitUsesUnitsPart(MiniPascalGrammarParser.UsesUnitsPartContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitLabelDeclarationPart(MiniPascalGrammarParser.LabelDeclarationPartContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitLabel(MiniPascalGrammarParser.LabelContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitConstantDefinitionPart(MiniPascalGrammarParser.ConstantDefinitionPartContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitConstantDefinition(MiniPascalGrammarParser.ConstantDefinitionContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitConstantChr(MiniPascalGrammarParser.ConstantChrContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitConstant(MiniPascalGrammarParser.ConstantContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitVarType(MiniPascalGrammarParser.VarTypeContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitArrayType(MiniPascalGrammarParser.ArrayTypeContext ctx) {

        System.out.println("declarando array: " + ctx.getParent().getParent().getChild(0).getText());
        return visitChildren(ctx);
    }

    @Override
    public Object visitArrayValue(MiniPascalGrammarParser.ArrayValueContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitIndexRanges(MiniPascalGrammarParser.IndexRangesContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitIndexRange(MiniPascalGrammarParser.IndexRangeContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitStringR_(MiniPascalGrammarParser.StringR_Context ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitCharR_(MiniPascalGrammarParser.CharR_Context ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitIntegerR_(MiniPascalGrammarParser.IntegerR_Context ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitUnsignedNumber(MiniPascalGrammarParser.UnsignedNumberContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitUnsignedInteger(MiniPascalGrammarParser.UnsignedIntegerContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitSign(MiniPascalGrammarParser.SignContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitBool_(MiniPascalGrammarParser.Bool_Context ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitString(MiniPascalGrammarParser.StringContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitBoolean(MiniPascalGrammarParser.BooleanContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitChar(MiniPascalGrammarParser.CharContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitInteger(MiniPascalGrammarParser.IntegerContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitTypeDefinitionPart(MiniPascalGrammarParser.TypeDefinitionPartContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitTypeDefinition(MiniPascalGrammarParser.TypeDefinitionContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitFunctionType(MiniPascalGrammarParser.FunctionTypeContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitType_(MiniPascalGrammarParser.Type_Context ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitSimpleType(MiniPascalGrammarParser.SimpleTypeContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitScalarType(MiniPascalGrammarParser.ScalarTypeContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitSubrangeType(MiniPascalGrammarParser.SubrangeTypeContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitTypeIdentifier(MiniPascalGrammarParser.TypeIdentifierContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitStringtype(MiniPascalGrammarParser.StringtypeContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitTypeList(MiniPascalGrammarParser.TypeListContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitIndexType(MiniPascalGrammarParser.IndexTypeContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitComponentType(MiniPascalGrammarParser.ComponentTypeContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitFixedPart(MiniPascalGrammarParser.FixedPartContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitRecordSection(MiniPascalGrammarParser.RecordSectionContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitTag(MiniPascalGrammarParser.TagContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitBaseType(MiniPascalGrammarParser.BaseTypeContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitVariableDeclarationPart(MiniPascalGrammarParser.VariableDeclarationPartContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitVariableDeclaration(MiniPascalGrammarParser.VariableDeclarationContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitProcedureAndFunctionDeclarationPart(MiniPascalGrammarParser.ProcedureAndFunctionDeclarationPartContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitProcedureOrFunctionDeclaration(MiniPascalGrammarParser.ProcedureOrFunctionDeclarationContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitFormalParameterList(MiniPascalGrammarParser.FormalParameterListContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitFormalParameterSection(MiniPascalGrammarParser.FormalParameterSectionContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitParameterGroup(MiniPascalGrammarParser.ParameterGroupContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitIdentifierList(MiniPascalGrammarParser.IdentifierListContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitConstList(MiniPascalGrammarParser.ConstListContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitFunctionDeclaration(MiniPascalGrammarParser.FunctionDeclarationContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitResultType(MiniPascalGrammarParser.ResultTypeContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitStatement(MiniPascalGrammarParser.StatementContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitWriteStatement(MiniPascalGrammarParser.WriteStatementContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitWrite(MiniPascalGrammarParser.WriteContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitWriteParam2(MiniPascalGrammarParser.WriteParam2Context ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitWriteParam(MiniPascalGrammarParser.WriteParamContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitVarValue(MiniPascalGrammarParser.VarValueContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitReadStatement(MiniPascalGrammarParser.ReadStatementContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitRead(MiniPascalGrammarParser.ReadContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitReadParam(MiniPascalGrammarParser.ReadParamContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitUnlabelledStatement(MiniPascalGrammarParser.UnlabelledStatementContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitSimpleStatement(MiniPascalGrammarParser.SimpleStatementContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitAssignmentStatement(MiniPascalGrammarParser.AssignmentStatementContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitVariable(MiniPascalGrammarParser.VariableContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitExpressionList(MiniPascalGrammarParser.ExpressionListContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitExpression(MiniPascalGrammarParser.ExpressionContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitRelationaloperator(MiniPascalGrammarParser.RelationaloperatorContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitSimpleExpression(MiniPascalGrammarParser.SimpleExpressionContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitAdditiveoperator(MiniPascalGrammarParser.AdditiveoperatorContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitTerm(MiniPascalGrammarParser.TermContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitMultiplicativeoperator(MiniPascalGrammarParser.MultiplicativeoperatorContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitSignedFactor(MiniPascalGrammarParser.SignedFactorContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitFactor(MiniPascalGrammarParser.FactorContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitUnsignedConstant(MiniPascalGrammarParser.UnsignedConstantContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitFunctionDesignator(MiniPascalGrammarParser.FunctionDesignatorContext ctx) {
        System.out.println("Missing un Parentesis");
        return visitChildren(ctx);
    }

    @Override
    public Object visitParameterList(MiniPascalGrammarParser.ParameterListContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitSet_(MiniPascalGrammarParser.Set_Context ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitElementList(MiniPascalGrammarParser.ElementListContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitElement(MiniPascalGrammarParser.ElementContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitActualParameter(MiniPascalGrammarParser.ActualParameterContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitParameterwidth(MiniPascalGrammarParser.ParameterwidthContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitEmptyStatement_(MiniPascalGrammarParser.EmptyStatement_Context ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitStructuredStatement(MiniPascalGrammarParser.StructuredStatementContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitCompoundStatement(MiniPascalGrammarParser.CompoundStatementContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitStatements(MiniPascalGrammarParser.StatementsContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitConditionalStatement(MiniPascalGrammarParser.ConditionalStatementContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitIfStatement(MiniPascalGrammarParser.IfStatementContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitRepetitiveStatement(MiniPascalGrammarParser.RepetitiveStatementContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitWhileStatement(MiniPascalGrammarParser.WhileStatementContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitRepeatStatement(MiniPascalGrammarParser.RepeatStatementContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitForStatement(MiniPascalGrammarParser.ForStatementContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitForList(MiniPascalGrammarParser.ForListContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitInitialValue(MiniPascalGrammarParser.InitialValueContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitFinalValue(MiniPascalGrammarParser.FinalValueContext ctx) {
        return visitChildren(ctx);
    }

}