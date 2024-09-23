import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.List;

public class MyVisitor extends MiniPascalGrammarBaseVisitor<Object> {

    @Override
    public Object visitProgram(MiniPascalGrammarParser.ProgramContext ctx) {
        System.out.println("Inicio del Programa:");
        visit(ctx.programHeading());
        System.out.println("\nBloque:");
        visit(ctx.block());
        System.out.println("\nFin del Programa");
        return null;
    }

    public Object visitProgramHeading(MiniPascalGrammarParser.ProgramHeadingContext ctx) {
        System.out.println("Identificador/Nombre del Programa: " + ctx.identifier().getText());
        return null;
    }

    @Override
    public Object visitIdentifier(MiniPascalGrammarParser.IdentifierContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitBlock(MiniPascalGrammarParser.BlockContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitConstantDefinitionPart(MiniPascalGrammarParser.ConstantDefinitionPartContext ctx) {
        System.out.println(" Segmento de Declaracion de Constantes:");
        for (MiniPascalGrammarParser.ConstantDefinitionContext varDeclCtx : ctx.constantDefinition()) {
            visit(varDeclCtx);
        }
        return null;
    }

    @Override
    public Object visitConstantDefinition(MiniPascalGrammarParser.ConstantDefinitionContext ctx) {
        System.out.println("  Declaracion de Constante:");
        MiniPascalGrammarParser.IdentifierContext idCtx = ctx.identifier();
        MiniPascalGrammarParser.ConstantContext typeCtx = ctx.constant();
        System.out.println("   Identificador: " + idCtx.getText());
        System.out.println("   Valor: " + typeCtx.getText());
        return null;
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
        System.out.println("Tipo Var: " + ctx.getText());
        return null;
    }

    @Override
    public Object visitArrayType(MiniPascalGrammarParser.ArrayTypeContext ctx) {
        System.out.println("Tipo Arreglo: " + ctx.getText());
        return null;
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
        System.out.println("Valor del String: " + ctx.getText());
        return null;
    }

    @Override
    public Object visitCharR_(MiniPascalGrammarParser.CharR_Context ctx) {
        System.out.println("Valor del Char: " + ctx.getText());
        return null;
    }

    @Override
    public Object visitIntegerR_(MiniPascalGrammarParser.IntegerR_Context ctx) {
        System.out.println("Valor del Integer: " + ctx.getText());
        return null;
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
        System.out.println("Valor del Boolean: " + ctx.getText());
        return null;
    }

    @Override
    public Object visitString(MiniPascalGrammarParser.StringContext ctx) {
        System.out.println("Valor del String: " + ctx.getText());
        return null;
    }

    @Override
    public Object visitBoolean(MiniPascalGrammarParser.BooleanContext ctx) {
        System.out.println("Valor del Boolean: " + ctx.getText());
        return null;
    }

    @Override
    public Object visitChar(MiniPascalGrammarParser.CharContext ctx) {
        System.out.println("Valor del Char: " + ctx.getText());
        return null;
    }

    @Override
    public Object visitInteger(MiniPascalGrammarParser.IntegerContext ctx) {
        System.out.println("Valor del Integer: " + ctx.getText());
        return null;
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

//    @Override
//    public Object visitScalarType(MiniPascalGrammarParser.ScalarTypeContext ctx) {
//        return visitChildren(ctx);
//    }

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

//    @Override
//    public Object visitTypeList(MiniPascalGrammarParser.TypeListContext ctx) {
//        for (MiniPascalGrammarParser.IndexTypeContext indexTypeCtx : ctx.indexType()) {
//            visit(indexTypeCtx);
//        }
//        return null;
//    }

//    @Override
//    public Object visitIndexType(MiniPascalGrammarParser.IndexTypeContext ctx) {
//        System.out.println("Index Type:");
//        visit(ctx.simpleType());
//        return null;
//    }

//    @Override
//    public Object visitComponentType(MiniPascalGrammarParser.ComponentTypeContext ctx) {
//        System.out.println("Component Type:");
//        visit(ctx.type_());
//        return null;
//    }

//    @Override
//    public Object visitFixedPart(MiniPascalGrammarParser.FixedPartContext ctx) {
//        return visitChildren(ctx);
//    }

//    @Override
//    public Object visitRecordSection(MiniPascalGrammarParser.RecordSectionContext ctx) {
//        return visitChildren(ctx);
//    }

//    @Override
//    public Object visitTag(MiniPascalGrammarParser.TagContext ctx) {
//        return visitChildren(ctx);
//    }

//    @Override
//    public Object visitBaseType(MiniPascalGrammarParser.BaseTypeContext ctx) {
//        return visitChildren(ctx);
//    }

    @Override
    public Object visitVariableDeclarationPart(MiniPascalGrammarParser.VariableDeclarationPartContext ctx) {
        System.out.println(" Segmento de Declaracion de Variables:");
        for (MiniPascalGrammarParser.VariableDeclarationContext varDeclCtx : ctx.variableDeclaration()) {
            visit(varDeclCtx);
        }
        return null;
    }

    @Override
    public Object visitVariableDeclaration(MiniPascalGrammarParser.VariableDeclarationContext ctx) {
        System.out.println("  Declaracion de Variable:");
        MiniPascalGrammarParser.IdentifierListContext idListCtx = ctx.identifierList();
        MiniPascalGrammarParser.TypeIdentifierContext typeCtx = ctx.typeIdentifier();
        MiniPascalGrammarParser.ArrayTypeContext arrayTypeCtx = ctx.arrayType();
        if (idListCtx != null && typeCtx != null) {
            System.out.println("   Tipo: " + typeCtx.getText());
            System.out.print("   Identificador: ");
            StringBuilder identifiers = new StringBuilder();
            List<MiniPascalGrammarParser.IdentifierContext> idNodes = idListCtx.identifier();
            for (int i = 0; i < idNodes.size(); i++) {
                identifiers.append(idNodes.get(i).getText());
                if (i < idNodes.size() - 1) {
                    identifiers.append(", ");
                }
            }
            System.out.println(identifiers.toString());
        }
        if (idListCtx != null && arrayTypeCtx != null) {
            System.out.println("   Arreglo de Tipo: " + arrayTypeCtx.getText());
            System.out.print("   Identificador: ");
            StringBuilder identifiers = new StringBuilder();
            List<MiniPascalGrammarParser.IdentifierContext> idNodes = idListCtx.identifier();
            for (int i = 0; i < idNodes.size(); i++) {
                identifiers.append(idNodes.get(i).getText());
                if (i < idNodes.size() - 1) {
                    identifiers.append(", ");
                }
            }
            System.out.println(identifiers.toString());
        }
        return null;
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
        for (MiniPascalGrammarParser.IdentifierContext ctx2 : ctx.identifier()) {
            System.out.println("Identificador: " + ctx2.getText());
        }
        return null;
    }

    @Override
    public Object visitConstList(MiniPascalGrammarParser.ConstListContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitFunctionDeclaration(MiniPascalGrammarParser.FunctionDeclarationContext ctx) {
        System.out.println(" Segmento de Declaracion de Funciones:");
        System.out.println("  Identificador: " + ctx.identifier().getText());
        System.out.println("  Tipo de Return: " + ctx.varType().getText());
        if (ctx.formalParameterList() != null) {
            System.out.println("  Parametros:");
            visit(ctx.formalParameterList());
        }
        System.out.println("  Bloque:");
        visit(ctx.block());
        System.out.println();
        return null;
    }

    @Override
    public Object visitProcedureDeclaration(MiniPascalGrammarParser.ProcedureDeclarationContext ctx) {
        System.out.println(" Segmento de Declaracion de Procedimientos:");
        System.out.println("  Identificador: " + ctx.identifier().getText());
        if (ctx.formalParameterList() != null) {
            System.out.println("  Procedimiento:");
            visit(ctx.formalParameterList());
        }
        System.out.println("   Bloque:");
        visit(ctx.block());
        System.out.println();
        return null;
    }

//    @Override
//    public Object visitResultType(MiniPascalGrammarParser.ResultTypeContext ctx) {
//        return visitChildren(ctx);
//    }

    @Override
    public Object visitStatement(MiniPascalGrammarParser.StatementContext ctx) {
        visit(ctx.getChild(0));
        return null;
    }

    @Override
    public Object visitWriteStatement(MiniPascalGrammarParser.WriteStatementContext ctx) {
        System.out.println("Funcion Write:");
        if (ctx.string() != null) {
            System.out.print(" Write ");
            if (ctx.write() == null) {
                System.out.print("Sentencia:\n");
            } else {
                System.out.print("Linea:\n");
            }
            if (ctx.identifier() != null) {
                visit(ctx.string());
                System.out.println("  Identificador: " + ctx.identifier().getText());
            } else
                visit(ctx.string());
        } else {
            visit(ctx.emptyStatement_());
        }
        System.out.println();
        return null;
    }

    @Override
    public Object visitWrite(MiniPascalGrammarParser.WriteContext ctx) {
        return visitChildren(ctx);
    }

//    @Override
//    public Object visitWriteParam(MiniPascalGrammarParser.WriteParamContext ctx) {
//        return visitChildren(ctx);
//    }

//    @Override
//    public Object visitVarValue(MiniPascalGrammarParser.VarValueContext ctx) {
//        return visitChildren(ctx);
//    }

    @Override
    public Object visitReadStatement(MiniPascalGrammarParser.ReadStatementContext ctx) {
        System.out.println("Funcion Read:");
        System.out.println(" Parametro: " + ctx.readParam().getText());
        System.out.println();
        return null;
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
        System.out.println(" Segmento de Asignacion de Variables:");
        String variable = ctx.variable().getText();
        String expression = ctx.expression().getText();
        System.out.println("  Asignando el valor " + expression + " a la variable " + variable);
        return null;
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
        visit(ctx.simpleExpression()); // Visitar el nodo de la expresión simple
        if (ctx.relationaloperator() != null) {
            System.out.println("Operador Relacional: " + ctx.relationaloperator().getText());
            visit(ctx.expression()); // Visitar el nodo de la expresión
        }
        return null;
    }

    @Override
    public Object visitRelationaloperator(MiniPascalGrammarParser.RelationaloperatorContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitSimpleExpression(MiniPascalGrammarParser.SimpleExpressionContext ctx) {
        visit(ctx.term()); // Visitar el nodo del término
        if (ctx.additiveoperator() != null) {
            System.out.println("Operador Aditivo: " + ctx.additiveoperator().getText());
            visit(ctx.simpleExpression()); // Visitar el nodo de la expresión simple
        }
        return null;
    }

    @Override
    public Object visitAdditiveoperator(MiniPascalGrammarParser.AdditiveoperatorContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitTerm(MiniPascalGrammarParser.TermContext ctx) {
        visit(ctx.signedFactor());
        if (ctx.multiplicativeoperator() != null) {
            System.out.println("Operador de Multiplicacion: " + ctx.multiplicativeoperator().getText());
            visit(ctx.term()); // Visitar el nodo del término
        }
        return null;
    }

    @Override
    public Object visitMultiplicativeoperator(MiniPascalGrammarParser.MultiplicativeoperatorContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitSignedFactor(MiniPascalGrammarParser.SignedFactorContext ctx) {
        System.out.println("Factor con Signo:" + ctx.getText());
        return null;
    }

    @Override
    public Object visitFactor(MiniPascalGrammarParser.FactorContext ctx) {
        if (ctx.variable() != null) {
            visit(ctx.variable()); // Visitar el nodo de la variable
        } else if (ctx.expression() != null) {
            visit(ctx.expression()); // Visitar el nodo de la expresión
        } else if (ctx.functionDesignator() != null) {
            visit(ctx.functionDesignator()); // Visitar el nodo del designador de función
        } else if (ctx.unsignedConstant() != null) {
            visit(ctx.unsignedConstant()); // Visitar el nodo de la constante no firmada
        } else if (ctx.set_() != null) {
            visit(ctx.set_()); // Visitar el nodo del conjunto
        } else if (ctx.NOT() != null) {
            System.out.println("NOT");
            visit(ctx.factor()); // Visitar el nodo del factor
        } else if (ctx.bool_() != null) {
            System.out.println("Valor de Boolean: " + ctx.bool_().getText());
        }
        return null;
    }

    @Override
    public Object visitUnsignedConstant(MiniPascalGrammarParser.UnsignedConstantContext ctx) {
        if (ctx.unsignedNumber() != null) {
            System.out.println("Numero sin Signo: " + ctx.unsignedNumber().getText());
        } else if (ctx.constantChr() != null) {
            System.out.println("constchar: " + ctx.constantChr().getText());
        } else if (ctx.string() != null) {
            System.out.println("Valor de String: " + ctx.string().getText());
        } else if (ctx.NIL() != null) {
            System.out.println("NIL");
        }
        return null;
    }

    @Override
    public Object visitFunctionDesignator(MiniPascalGrammarParser.FunctionDesignatorContext ctx) {
        System.out.println("Llamado a Funcion:");
        System.out.println(" Identificador: " + ctx.identifier().getText());
        if (ctx.parameterList() != null) {
            System.out.print(" Parametros:");
            visit(ctx.parameterList());
        }
        System.out.println();
        return null;
    }

    @Override
    public Object visitParameterList(MiniPascalGrammarParser.ParameterListContext ctx) {
        for (MiniPascalGrammarParser.ActualParameterContext actualParameterContext : ctx.actualParameter()) {
            visit(actualParameterContext);
        }
        return null;
    }

    @Override
    public Object visitSet_(MiniPascalGrammarParser.Set_Context ctx) {
        System.out.println(" Set:");
        visit(ctx.elementList());
        return null;
    }

    @Override
    public Object visitElementList(MiniPascalGrammarParser.ElementListContext ctx) {
        System.out.println(" Lista de Elementos:");
        for (MiniPascalGrammarParser.ElementContext elementCtx : ctx.element()) {
            visit(elementCtx);
        }
        System.out.println();
        return null;
    }

    @Override
    public Object visitElement(MiniPascalGrammarParser.ElementContext ctx) {
        System.out.println("  Elemento:");
        visit(ctx.expression(0));
        if (ctx.DOUBLE_DOT() != null) {
            visit(ctx.expression(1));
        }
        return null;
    }

    @Override
    public Object visitActualParameter(MiniPascalGrammarParser.ActualParameterContext ctx) {
        return visitChildren(ctx);
    }

//    @Override
//    public Object visitParameterwidth(MiniPascalGrammarParser.ParameterwidthContext ctx) {
//        System.out.println("Parameter Width Expression:");
//        visit(ctx.expression());
//        return null;
//    }

    @Override
    public Object visitEmptyStatement_(MiniPascalGrammarParser.EmptyStatement_Context ctx) {
        System.out.println("Sentencia Vacia");
        return null;
    }

    @Override
    public Object visitStructuredStatement(MiniPascalGrammarParser.StructuredStatementContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitCompoundStatement(MiniPascalGrammarParser.CompoundStatementContext ctx) {
        if (ctx.emptyStatement_() != null) {
            visit(ctx.emptyStatement_());
        } else {
            visit(ctx.statements());
        }
        return null;
    }

    @Override
    public Object visitStatements(MiniPascalGrammarParser.StatementsContext ctx) {
        for (MiniPascalGrammarParser.StatementContext statementCtx : ctx.statement()) {
            visit(statementCtx);
        }
        return null;
    }

    @Override
    public Object visitConditionalStatement(MiniPascalGrammarParser.ConditionalStatementContext ctx) {
        visit(ctx.getChild(0));
        return null;
    }

    @Override
    public Object visitIfStatement(MiniPascalGrammarParser.IfStatementContext ctx) {
        System.out.println(" Caso If:");
        System.out.println("  Condicion: " + ctx.expression().getText());
        System.out.println("  Hacer: " + ctx.statement(0).getText());
        if (ctx.ELSE() != null) {
            System.out.println("  Else: " + ctx.statement(1).getText());
        }
        System.out.println();
        return null;
    }

    @Override
    public Object visitRepetitiveStatement(MiniPascalGrammarParser.RepetitiveStatementContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitWhileStatement(MiniPascalGrammarParser.WhileStatementContext ctx) {
        System.out.println(" Caso While:");
        System.out.println("  Condicion: " + ctx.expression().getText());

        String statementText = ctx.statement().getText();
        if (statementText.startsWith("begin") && statementText.endsWith("end")) {
            statementText = statementText.substring(5, statementText.length() - 3).trim();

            String[] statements = statementText.split(";");
            System.out.println("  Sentencia entre begin ... end:");
            for (String stmt : statements) {
                System.out.println(" " + stmt.trim());
            }
        } else {
            System.out.println("   Sentencia: " + statementText);
        }
        System.out.println();
        return null;
    }


    @Override
    public Object visitRepeatStatement(MiniPascalGrammarParser.RepeatStatementContext ctx) {
        System.out.println(" Caso Repeat:");
        System.out.println("  Limite: " + ctx.expression().getText());

        String statementText = ctx.statements().getText();
        if (statementText.startsWith("begin") && statementText.endsWith("end")) {
            statementText = statementText.substring(5, statementText.length() - 3).trim();

            String[] statements = statementText.split(";");
            System.out.println("  Sentencia entre begin ... end:");
            for (String stmt : statements) {
                System.out.println(" " + stmt.trim());
            }
        } else {
            System.out.println("  Sentencia: " + statementText);
        }
        System.out.println();
        return null;
    }

    @Override
    public Object visitForStatement(MiniPascalGrammarParser.ForStatementContext ctx) {
        System.out.println(" Caso For:");
        System.out.println("  Identificador: " + ctx.identifier().getText());
        System.out.println("  Valor Suelo: " + ctx.forList().initialValue().getText());
        System.out.println("  Valor Techo: " + ctx.forList().finalValue().getText());

        String statementText = ctx.statement().getText();
        if (statementText.startsWith("begin") && statementText.endsWith("end")) {
            statementText = statementText.substring(5, statementText.length() - 3).trim();

            String[] statements = statementText.split(";");
            System.out.println("  Sentencia entre begin ... end:");
            for (String stmt : statements) {
                System.out.println(" " + stmt.trim());
            }
        } else {
            System.out.println("  Sentencia: " + statementText);
        }
        System.out.println();
        return null;
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
    public Object visitArrayInitialization(MiniPascalGrammarParser.ArrayInitializationContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitFinalValue(MiniPascalGrammarParser.FinalValueContext ctx) {
        return visitChildren(ctx);
    }
}