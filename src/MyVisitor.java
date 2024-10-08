public class MyVisitor extends MiniPascalGrammarBaseVisitor<Object> {

    @Override
    public Object visitProgram(MiniPascalGrammarParser.ProgramContext ctx) {
        System.out.println("\nComienzo del Programa");
        return visitChildren(ctx);
    }

    @Override
    public Object visitProgramHeading(MiniPascalGrammarParser.ProgramHeadingContext ctx) {
        System.out.println("\nNombre del Programa: " + ctx.getChild(1).getText());
        return visitChildren(ctx);
    }

    @Override
    public Object visitIdentifier(MiniPascalGrammarParser.IdentifierContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitBlock(MiniPascalGrammarParser.BlockContext ctx) {
//        System.out.println("\n\nIniciando un Bloque del Programa");
        return visitChildren(ctx);
    }

    @Override
    public Object visitUsesUnitsPart(MiniPascalGrammarParser.UsesUnitsPartContext ctx) { return visitChildren(ctx); }

    @Override
    public Object visitLabelDeclarationPart(MiniPascalGrammarParser.LabelDeclarationPartContext ctx) {
        System.out.println("\nDeclaración de Labels");
        return visitChildren(ctx);
    }

    @Override
    public Object visitLabel(MiniPascalGrammarParser.LabelContext ctx) { return visitChildren(ctx); }

    @Override
    public Object visitConstantDefinitionPart(MiniPascalGrammarParser.ConstantDefinitionPartContext ctx) {
        System.out.println("\nDefinicion de CONSTs");
        return visitChildren(ctx);
    }

    @Override
    public Object visitConstantDefinition(MiniPascalGrammarParser.ConstantDefinitionContext ctx) {
        System.out.println("Definiendo constante " + ctx.getChild(0).getText() + " con valor: " + ctx.getChild(2).getText());
        return visitChildren(ctx);
    }

    @Override
    public Object visitConstantChr(MiniPascalGrammarParser.ConstantChrContext ctx) { return visitChildren(ctx); }

    @Override
    public Object visitConstant(MiniPascalGrammarParser.ConstantContext ctx) { return visitChildren(ctx);}

    @Override
    public Object visitVarType(MiniPascalGrammarParser.VarTypeContext ctx) { return visitChildren(ctx); }

    @Override
    public Object visitArrayType(MiniPascalGrammarParser.ArrayTypeContext ctx) { return visitChildren(ctx); }

    @Override
    public Object visitArrayValue(MiniPascalGrammarParser.ArrayValueContext ctx) {
        System.out.println("Asignando valores al array");
        return visitChildren(ctx);
    }

    @Override
    public Object visitIndexRanges(MiniPascalGrammarParser.IndexRangesContext ctx) {
        if (ctx.getChildCount() > 1) {
            System.out.print("Rango de Indices " + ctx.getChild(0).getText() + " a " + ctx.getChild(2).getText());
        } else {
            System.out.print("Rango de Indices " + ctx.getChild(0).getText());
        }
        return visitChildren(ctx); }

    @Override
    public Object visitIndexRange(MiniPascalGrammarParser.IndexRangeContext ctx) { return visitChildren(ctx); }

    @Override
    public Object visitStringR_(MiniPascalGrammarParser.StringR_Context ctx) { return visitChildren(ctx); }

    @Override
    public Object visitCharR_(MiniPascalGrammarParser.CharR_Context ctx) { return visitChildren(ctx); }

    @Override
    public Object visitIntegerR_(MiniPascalGrammarParser.IntegerR_Context ctx) { return visitChildren(ctx); }

    @Override
    public Object visitUnsignedNumber(MiniPascalGrammarParser.UnsignedNumberContext ctx) { return visitChildren(ctx); }

    @Override
    public Object visitUnsignedInteger(MiniPascalGrammarParser.UnsignedIntegerContext ctx) { return visitChildren(ctx); }

    @Override
    public Object visitSign(MiniPascalGrammarParser.SignContext ctx) { return visitChildren(ctx); }

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
    public Object visitTypeDefinitionPart(MiniPascalGrammarParser.TypeDefinitionPartContext ctx) { return visitChildren(ctx); }

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
        System.out.println("\nDeclaración de Variables");
        return visitChildren(ctx);
    }

    @Override
    public Object visitVariableDeclaration(MiniPascalGrammarParser.VariableDeclarationContext ctx) {
        if (ctx.getChild(2).getChild(0).getText().contains("array") || ctx.getChild(2).getChild(0).getText().contains("Array")) {
            System.out.print("\nDeclarando variable " + ctx.getChild(0).getText() + " de tipo Array of " + ctx.getChild(2).getChild(0).getChild(5).getText() + " con ");
        } else {
            System.out.print("\nDeclarando variable " + ctx.getChild(0).getText() + " de tipo " + ctx.getChild(2).getText());
        }
        return visitChildren(ctx);
    }

    @Override
    public Object visitProcedureAndFunctionDeclarationPart(MiniPascalGrammarParser.ProcedureAndFunctionDeclarationPartContext ctx) { return visitChildren(ctx); }

    @Override
    public Object visitProcedureOrFunctionDeclaration(MiniPascalGrammarParser.ProcedureOrFunctionDeclarationContext ctx) { return visitChildren(ctx); }

    @Override
    public Object visitFormalParameterList(MiniPascalGrammarParser.FormalParameterListContext ctx) { return visitChildren(ctx); }

    @Override
    public Object visitFormalParameterSection(MiniPascalGrammarParser.FormalParameterSectionContext ctx) { return visitChildren(ctx); }

    @Override
    public Object visitParameterGroup(MiniPascalGrammarParser.ParameterGroupContext ctx) {
        if (ctx.getChildCount() > 1) {
            System.out.println(ctx.getChild(0).getText() + " de tipo " + ctx.getChild(2).getText());
        } else {
            System.out.println("Sin Parametros");
        }
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
        System.out.println("\nDeclaración de Función " + ctx.getChild(1).getText() + " de tipo " + ctx.getChild(4).getText() + " con parametros:");
        return visitChildren(ctx);
    }

    public Object visitProcedureDeclaration(MiniPascalGrammarParser.ProcedureDeclarationContext ctx) {
        System.out.println("\nDeclaración de Procedimiento " + ctx.getChild(1).getText() + " con parametros:");
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
        if (ctx.getChildCount() <= 4) {
            System.out.println("\nUsando Funcion Write para escribir " + ctx.getChild(2).getText());
        } else {
            System.out.print("\nUsando Funcion Write para escribir " + ctx.getChild(2).getText() + " y parametros");
            for (int i = 4; i < ctx.getChildCount()-1; i++) {
                System.out.print(" " + ctx.getChild(i).getText());
            }
        }
        return visitChildren(ctx);
    }

    @Override
    public Object visitWrite(MiniPascalGrammarParser.WriteContext ctx) {
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
        System.out.println("\nUsando Funcion Read para leer la variable: " + ctx.getChild(2).getText());
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
    public Object visitUnlabelledStatement(MiniPascalGrammarParser.UnlabelledStatementContext ctx) { return visitChildren(ctx); }

    @Override
    public Object visitSimpleStatement(MiniPascalGrammarParser.SimpleStatementContext ctx) { return visitChildren(ctx); }

    @Override
    public Object visitAssignmentStatement(MiniPascalGrammarParser.AssignmentStatementContext ctx) {
        System.out.print("\nAsignando valor " + ctx.getChild(2).getText() + " a la variable " + ctx.getChild(0).getText());
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
    public Object visitRelationaloperator(MiniPascalGrammarParser.RelationaloperatorContext ctx) { return visitChildren(ctx); }

    @Override
    public Object visitSimpleExpression(MiniPascalGrammarParser.SimpleExpressionContext ctx) { return visitChildren(ctx); }

    @Override
    public Object visitAdditiveoperator(MiniPascalGrammarParser.AdditiveoperatorContext ctx) { return visitChildren(ctx); }

    @Override
    public Object visitTerm(MiniPascalGrammarParser.TermContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitMultiplicativeoperator(MiniPascalGrammarParser.MultiplicativeoperatorContext ctx) { return visitChildren(ctx); }

    @Override
    public Object visitSignedFactor(MiniPascalGrammarParser.SignedFactorContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitFactor(MiniPascalGrammarParser.FactorContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitUnsignedConstant(MiniPascalGrammarParser.UnsignedConstantContext ctx) { return visitChildren(ctx); }

    @Override
    public Object visitFunctionDesignator(MiniPascalGrammarParser.FunctionDesignatorContext ctx) {
        System.out.print("\nLlamando a la funcion " + ctx.getChild(0).getText() + " con parametros: ");
        return visitChildren(ctx);
    }

    @Override
    public Object visitParameterList(MiniPascalGrammarParser.ParameterListContext ctx) {
        System.out.println(ctx.getText());
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
    public Object visitActualParameter(MiniPascalGrammarParser.ActualParameterContext ctx) { return visitChildren(ctx); }

    @Override
    public Object visitParameterwidth(MiniPascalGrammarParser.ParameterwidthContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitEmptyStatement_(MiniPascalGrammarParser.EmptyStatement_Context ctx) { return visitChildren(ctx); }

    @Override
    public Object visitStructuredStatement(MiniPascalGrammarParser.StructuredStatementContext ctx) { return visitChildren(ctx); }

    @Override
    public Object visitCompoundStatement(MiniPascalGrammarParser.CompoundStatementContext ctx) { return visitChildren(ctx); }

    @Override
    public Object visitStatements(MiniPascalGrammarParser.StatementsContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitConditionalStatement(MiniPascalGrammarParser.ConditionalStatementContext ctx) { return visitChildren(ctx); }

    @Override
    public Object visitIfStatement(MiniPascalGrammarParser.IfStatementContext ctx) {
        System.out.println("\nCiclo If con condición " + ctx.getChild(1).getText());
        System.out.print("Bloque de instrucciones: ");
        System.out.println(ctx.getChild(3).getText());
        if (ctx.getChildCount() > 4) {
            System.out.print("Bloque de instrucciones Else: ");
            System.out.println(ctx.getChild(5).getText());
        }
        return visitChildren(ctx);
    }

    @Override
    public Object visitRepetitiveStatement(MiniPascalGrammarParser.RepetitiveStatementContext ctx) { return visitChildren(ctx); }

    @Override
    public Object visitWhileStatement(MiniPascalGrammarParser.WhileStatementContext ctx) {
        System.out.println("\nCiclo While con condición " + ctx.getChild(1).getText());
        return visitChildren(ctx);
    }

    @Override
    public Object visitRepeatStatement(MiniPascalGrammarParser.RepeatStatementContext ctx) {
        System.out.println("\nCiclo Repeat con condición hasta " + ctx.getChild(3).getText());
        return visitChildren(ctx);
    }

    @Override
    public Object visitForStatement(MiniPascalGrammarParser.ForStatementContext ctx) {
        System.out.print("\nCiclo For con variable " + ctx.getChild(1).getText());
        return visitChildren(ctx);
    }

    @Override
    public Object visitForList(MiniPascalGrammarParser.ForListContext ctx) {
        System.out.println(" desde " + ctx.getChild(0).getText() + " hasta " + ctx.getChild(2).getText());
        return visitChildren(ctx);
    }

    @Override
    public Object visitInitialValue(MiniPascalGrammarParser.InitialValueContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitArrayInitialization(MiniPascalGrammarParser.ArrayInitializationContext ctx) {
        System.out.println("\nInicializando Array con valores: " + ctx.getChild(1).getText());
        return super.visitChildren(ctx);
    }

    @Override
    public Object visitFinalValue(MiniPascalGrammarParser.FinalValueContext ctx) {
        return visitChildren(ctx);
    }

}