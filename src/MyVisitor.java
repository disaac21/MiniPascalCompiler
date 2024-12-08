import javax.swing.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.*;

public class MyVisitor extends MiniPascalGrammarBaseVisitor<Object> {

    private boolean scanfdeclared = false;
    private int tempCounter = 1;  // Contador de variables temporales
    private int counter = 1;
    ArrayList<Loads> loads = new ArrayList<Loads>();

    public Loads lastLoad(String variable) {
        for (int i = loads.size() - 1; i >= 0; i--) {
//            System.out.println("Variable: " + loads.get(i).getVariable() + " counter: " + loads.get(i).getCounter());
            if (loads.get(i).getVariable().equals(variable)) {
                return loads.get(i);
            }

        }
        return null;
    }


    private String generateTempVariable() {
        return "t" + tempCounter++;  // t1, t2, t3, ...
    }

    private int stringTempCounter = 1;  // Contador de strings globales

    private String generateTempStringVariable() {
        return "@.str" + stringTempCounter++;  // s1, s2, s3, ...
    }

    private int condCounter = 1;  // Contador de condicionales

    private String generateCondVariable() {
        return "cond" + condCounter++;  // t1, t2, t3, ...
    }

    private int labelCounter = 1;  // Contador de etiquetas

    private String generateLabel() {
        return "L" + labelCounter++;  // L1, L2, L3, ...
    }

    private int ifCounter = 1;  // Contador de if

    private String generateIf() {
        return "if" + ifCounter++;  // if1, if2, if3, ...
    }

    ArrayList<ThreeAddressCode> threeAddressCodeList = new ArrayList<>();

    public void clearOutputFiles() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("output.ll"))) {
            writer.write("");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("output3AC.txt"))) {
            writer.write("");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void generateLLVMFrom3AC() {
        for (ThreeAddressCode instruction : threeAddressCodeList) {
            switch (instruction.operation) {
                case "alloca":
                    emit("%" + instruction.result + " = alloca " + instruction.arg1);
                    break;
                case "=":
                    emit("%" + instruction.result + " = " + instruction.operation + " " + instruction.arg1);
                    break;
                case "store":
                    emit("store " + instruction.arg1 + ", " + instruction.arg2 + " " + instruction.result);
                    break;
                case "call":
                    emit("call " + instruction.arg1);
                    break;
                case "<=":
                    emit("%" + instruction.result + " = icmp sle " + instruction.arg1 + " " + instruction.arg2);
                    break;
                case "if":
                    emit("br i1 " + instruction.arg1 + ", label %" + instruction.arg2 + ", label %" + instruction.result);
                    break;
                case "goto":
                    emit("br label %" + instruction.result);
                    break;
                case "label":
                    emit("%" + instruction.result + ":");
                    break;
                default:
                    // Manejo de otros tipos de operaciones
                    break;
            }
        }
    }


    StringBuilder llvmCode = new StringBuilder();

    private void emit(String line) {
        llvmCode.append(line).append("\n");
    }


    public void writell() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("output.ll"))) {
            writer.write(llvmCode.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    ArrayList<Binding> TablaSimbolos = new ArrayList<>();
    String scope_actual = "global";

    public void imprimirTablaSimbolos() {
        System.out.println(" ------- Tabla de Simbolos ------- ");
        for (Binding binding : TablaSimbolos) {
            System.out.println(binding);
        }
        System.out.println(" --------------------------------- ");
    }

    private boolean encontrarVariable(String variable) {
        for (Binding binding : TablaSimbolos) {
            if (binding.getNombre().equals(variable) && binding.getScope().equals(scope_actual)) {
                return true;
            }
        }
        return false;
    }

    private boolean encontrarVariableEnLoads(String variable) {
        for (Loads load : loads) {
            if (load.getVariable().equals(variable)) {
                return true;
            }
        }
        return false;
    }

    private boolean verificarValor(String valor, String tipoEsperado) {
        // Validación para tipos básicos

        boolean isFunction = false;
        if (valor.contains("(")) {
            valor = valor.substring(0, valor.indexOf("("));
            isFunction = true;
        }

        if (tipoEsperado.equals("integer")) {
            // Expresión que permite números enteros o variables separadas por '+'
            String[] components = valor.split("\\s*(\\+|-|\\*|/|div|mod)\\s*");

//            for (String component : components) {
//                System.out.println("COMPONENTE: " + component);
//            }

            for (String component : components) {
                component = component.trim(); // Eliminar espacios en blanco

                // Verificar si es un número entero
                if (component.matches("-?\\d+")) {
                    continue;
                }

                // Verificar si es una variable definida como tipo 'integer'
                boolean isIntegerVariable = false;
                for (Binding binding : TablaSimbolos) {
                    if (binding.getNombre().equals(component)) {
                        System.out.println("EQUALS COMPONENT");
                        if (isFunction) {
                            if (binding.getScope().equals(scope_actual) || binding.getScope().equals("global") || binding.getScope().equals(binding.getNombre())) {
                                System.out.println("EQUALS SCOPE");
                                if (binding.getTipo().equals("integer")) {
                                    System.out.println("EQUALS TIPO");
                                    isIntegerVariable = true;
                                    break;
                                }
                            }
                        } else {
                            if (binding.getScope().equals(scope_actual)) {
                                System.out.println("EQUALS SCOPE");
                                if (binding.getTipo().equals("integer")) {
                                    System.out.println("EQUALS TIPO");
                                    isIntegerVariable = true;
                                    break;
                                }
                            }
                        }
                    }
                }

                if (!isIntegerVariable) {
                    return false; // Si no es número ni variable válida, la expresión no es válida
                }
            }
            return true; // Todos los componentes son válidos
        } else if (tipoEsperado.equals("boolean")) {
            return valor.equals("true") || valor.equals("false"); // Booleano
        } else if (tipoEsperado.equals("char")) {
            return valor.matches("'[^']'"); // Un único carácter entre comillas simples
        } else if (tipoEsperado.equals("string")) {
            return valor.matches("'[^']*'"); // Cadena entre comillas simples (permite vacías)
        }

        // Tipo no reconocido
        return false;

    }

    private boolean verificarValorNoBooleanForFunctions(String valor, String tipoEsperado) {
        // Validación para tipos básicos
        if (tipoEsperado.equals("integer")) {
            return true;
        } else if (tipoEsperado.equals("char")) {
            return true;
        } else if (tipoEsperado.equals("string")) {
            return true;
        }

        // Tipo no reconocido
        return false;

    }


    @Override
    public Object visitProgram(MiniPascalGrammarParser.ProgramContext ctx) {
        System.out.println("Inicio del Programa:");
        visit(ctx.programHeading());
        System.out.println("\nBloque:");
        emit("\ndefine i32 @main() {");
        visit(ctx.block());
        System.out.println("\nFin del Programa");
        Footer();
        Header(ctx.programHeading());
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

        String previousScope = scope_actual;
        scope_actual = scope_actual;
        visitChildren(ctx);
        scope_actual = previousScope;
        return null;
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

        String tipo = "";
        if (typeCtx.getText().charAt(0) == '\'' && typeCtx.getText().charAt(2) == '\'') {
            System.out.println("   Tipo: char");
            tipo = "char";
        } else if (typeCtx.getText().equals("true") || typeCtx.getText().equals("false")) {
            System.out.println("   Tipo: boolean");
            tipo = "boolean";
        } else if (typeCtx.getText().matches("-?\\d+")) {
            System.out.println("   Tipo: integer");
            tipo = "integer";
        } else if (typeCtx.getText().charAt(0) == '\'') {
            System.out.println("   Tipo: string");
            tipo = "string";
        } else {
            System.out.println("   Tipo Unknown");
            tipo = "error";
        }

        Binding binding = new Binding(idCtx.getText(), tipo, scope_actual);
        if (!encontrarVariable(binding.getNombre())) {
            TablaSimbolos.add(binding);
            imprimirTablaSimbolos();
        } else {
            System.out.println("\u001B[31mError: La variable \'" + binding.getNombre() + "\' ya ha sido declarada en el scope \'" + scope_actual + "\'\u001B[0m");
            System.exit(1);
        }
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
        System.out.println("Tipo Arreglo: " + ctx.getChild(2).getText());
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
                System.out.println("   Identificador: " + idNodes.get(i).getText());
                Binding binding = new Binding(idNodes.get(i).getText(), typeCtx.getText(), scope_actual);
                if (!encontrarVariable(binding.getNombre())) {
                    TablaSimbolos.add(binding);
                    String variableName = binding.getNombre();
                    String variableType = binding.getTipo();
                    switch (variableType) {
                        case "integer":
                            emit("    %" + variableName + " = alloca i32");
                            break;
                        case "boolean":
                            emit("    %" + variableName + " = alloca i1");
                            break;
                        case "char":
                            emit("    %" + variableName + " = alloca i8");
                            break;
                        case "string":
                            emit("    %" + variableName + " = alloca i8*");
                            break;
                    }

                    // Asignar el tipo correspondiente en 3AC
                    //aca va a tocar hacer cambios
                    String tempVar = generateTempVariable(); // Crear variable temporal
                    String operation = "alloca"; // Operación de asignación de memoria
                    threeAddressCodeList.add(new ThreeAddressCode(operation, variableType, null, tempVar)); // Agregar la instrucción
                    imprimirTablaSimbolos();
                } else {
                    System.out.println("\u001B[31mError: La variable \'" + binding.getNombre() + "\' ya ha sido declarada en el scope \'" + scope_actual + "\'\u001B[0m");
                    System.exit(1);
                }
            }
        }
        if (idListCtx != null && arrayTypeCtx != null) {

            if (arrayTypeCtx.indexRanges().getText().contains(",")) {
                System.out.println("   Arreglo de Tipo: " + arrayTypeCtx.getChild(5).getText());
                System.out.println("   Rango: " + arrayTypeCtx.indexRanges().indexRange().get(0).getText().charAt(0) + " a " + arrayTypeCtx.indexRanges().indexRange().get(0).getText().charAt(3) + " y " + arrayTypeCtx.indexRanges().indexRange(1).getText().charAt(0) + " a " + arrayTypeCtx.indexRanges().indexRange(1).getText().charAt(3));
                System.out.println("BIDI");
                System.out.print("   Identificador: ");
                StringBuilder identifiers = new StringBuilder();
                List<MiniPascalGrammarParser.IdentifierContext> idNodes = idListCtx.identifier();

                for (int i = 0; i < idNodes.size(); i++) {
                    identifiers.append(idNodes.get(i).getText());
                    if (i < idNodes.size() - 1) {
                        identifiers.append(", ");
                    }

                    //Agregar el Arreglo
                    Binding binding = new Binding(idNodes.get(i).getText(), arrayTypeCtx.getChild(5).getText(), scope_actual);
                    if (!encontrarVariable(binding.getNombre())) {
                        TablaSimbolos.add(binding);
                        imprimirTablaSimbolos();
                    } else {
                        System.out.println("\u001B[31mError: La variable \'" + binding.getNombre() + "\' ya ha sido declarada en el scope \'" + scope_actual + "\'\u001B[0m");
                        System.exit(1);
                    }

                    //Agrega cada entrada del arreglo
                    int inicio = arrayTypeCtx.indexRanges().indexRange().get(0).getText().charAt(0) - 48;
                    int fin = (int) arrayTypeCtx.indexRanges().indexRange().get(0).getText().charAt(3) - 48;
                    int inicio2 = arrayTypeCtx.indexRanges().indexRange().get(1).getText().charAt(0) - 48;
                    int fin2 = (int) arrayTypeCtx.indexRanges().indexRange().get(1).getText().charAt(3) - 48;

                    for (int j = inicio; j <= fin; j++) {
                        for (int k = inicio2; k <= fin2; k++) {
                            Binding binding2 = new Binding(idNodes.get(i).getText() + "[" + j + "," + k + "]", arrayTypeCtx.getChild(5).getText(), scope_actual);
                            if (!encontrarVariable(binding2.getNombre())) {
                                TablaSimbolos.add(binding2);
                                imprimirTablaSimbolos();
                            } else {
                                System.out.println("\u001B[31mError: La variable \'" + binding2.getNombre() + "\' ya ha sido declarada en el scope \'" + scope_actual + "\'\u001B[0m");
                                System.exit(1);
                            }
                        }
                    }
                }
                System.out.println(identifiers.toString());


            } else {
                System.out.println("   Arreglo de Tipo: " + arrayTypeCtx.getChild(5).getText());
                System.out.println("   Rango: " + arrayTypeCtx.indexRanges().indexRange().get(0).getText().charAt(0) + " a " + arrayTypeCtx.indexRanges().indexRange().get(0).getText().charAt(3));
                System.out.print("   Identificador: ");
                StringBuilder identifiers = new StringBuilder();
                List<MiniPascalGrammarParser.IdentifierContext> idNodes = idListCtx.identifier();
                for (int i = 0; i < idNodes.size(); i++) {
                    identifiers.append(idNodes.get(i).getText());
                    if (i < idNodes.size() - 1) {
                        identifiers.append(", ");
                    }

                    //Agregar el Arreglo
                    Binding binding = new Binding(idNodes.get(i).getText(), arrayTypeCtx.getChild(5).getText(), scope_actual);
                    if (!encontrarVariable(binding.getNombre())) {
                        TablaSimbolos.add(binding);
                        imprimirTablaSimbolos();
                    } else {
                        System.out.println("\u001B[31mError: La variable \'" + binding.getNombre() + "\' ya ha sido declarada en el scope \'" + scope_actual + "\'\u001B[0m");
                        System.exit(1);
                    }

                    //Agrega cada entrada del arreglo
                    int inicio = arrayTypeCtx.indexRanges().indexRange().get(0).getText().charAt(0) - 48;
                    int fin = (int) arrayTypeCtx.indexRanges().indexRange().get(0).getText().charAt(3) - 48;
                    for (int j = inicio; j <= fin; j++) {
                        Binding binding2 = new Binding(idNodes.get(i).getText() + "[" + j + "]", arrayTypeCtx.getChild(5).getText(), scope_actual);
                        if (!encontrarVariable(binding2.getNombre())) {
                            TablaSimbolos.add(binding2);
                            imprimirTablaSimbolos();
                        } else {
                            System.out.println("\u001B[31mError: La variable \'" + binding2.getNombre() + "\' ya ha sido declarada en el scope \'" + scope_actual + "\'\u001B[0m");
                            System.exit(1);
                        }
                    }
                }
                System.out.println(identifiers.toString());
            }
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
        String paramType = ctx.varType().getText();
        for (MiniPascalGrammarParser.IdentifierContext idCtx : ctx.identifierList().identifier()) {
            String paramName = idCtx.getText();
            Binding binding = new Binding(paramName, paramType, scope_actual);
            TablaSimbolos.add(binding);
            System.out.println("Parámetro añadido: " + paramName + " de tipo " + paramType + " en el ámbito " + scope_actual);
        }
        return null;
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
        String previousScope = scope_actual;
        scope_actual = ctx.identifier().getText(); // El nuevo ámbito es el nombre de la función

        System.out.println(" Segmento de Declaracion de Funciones:");
        String functionName = ctx.identifier().getText();
        String returnType = ctx.varType().getText();

        // Agregar la función a la tabla de símbolos
        Binding functionBinding = new Binding(functionName, returnType, scope_actual);
        TablaSimbolos.add(functionBinding);

        System.out.println("  Identificador: " + functionName);
        System.out.println("  Tipo de Return: " + returnType);

        // Procesar parámetros formales
        if (ctx.formalParameterList() != null) {
            visit(ctx.formalParameterList());
        }

        // Procesar el bloque de la función
        System.out.println("  Bloque:");
        visit(ctx.block());
        System.out.println();

        // Restaurar el ámbito anterior
        scope_actual = previousScope;
        return null;
    }


    @Override
    public Object visitProcedureDeclaration(MiniPascalGrammarParser.ProcedureDeclarationContext ctx) {
        String previousScope = scope_actual;
        scope_actual = ctx.identifier().getText();
        System.out.println(" Segmento de Declaracion de Procedimientos:");
        System.out.println("  Identificador: " + ctx.identifier().getText());
        if (ctx.formalParameterList() != null) {
            visit(ctx.formalParameterList());
        }
        System.out.println("   Bloque:");
        visit(ctx.block());
        System.out.println();
        scope_actual = previousScope;
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

                //Proceso de Verificacion
                String variable = ctx.identifier().getText();
                String tipoVariable = "";

                // Obtener el tipo de la variable desde la tabla de símbolos
                for (Binding binding : TablaSimbolos) {
                    if (binding.getNombre().equals(variable) && binding.getScope().equals(scope_actual)) {
                        tipoVariable = binding.getTipo();
                        break;
                    }
                }

                System.out.println("  Variable: " + variable);
                System.out.println("  Tipo de Variable: " + tipoVariable);

                if (!encontrarVariable(variable)) {
                    System.err.println(" Error: La variable '" + variable + "' no está definida en el ámbito '" + scope_actual + "'.");
                    return null;
                } else {
                    // Validar el tipo de la expresión
                    if (tipoVariable != null) {
                        if (!verificarValorNoBooleanForFunctions(variable, tipoVariable)) {
                            System.err.println(" Error: El valor '" + variable + "' no es compatible con el tipo '" + tipoVariable + "' de la variable '" + variable + "'.");
                        } else {
                            System.out.println("  Asignando el valor " + variable + " a la variable '" + variable + "' de tipo '" + tipoVariable + "'.");


                            String strValue = ctx.string().getText();
                            strValue = strValue.substring(1, strValue.length() - 1); // Remove quotes

                            String currentTempString = generateTempStringVariable();
                            int stringLength = strValue.length();
//                            stringLength++;
                            String textToPrepend = "" + currentTempString + " = private constant [" + stringLength + " x i8] c\"" + strValue + "\"\n";

                            llvmCode.insert(0, textToPrepend);

                            emit("    call void @write_string(i8* getelementptr inbounds ([" + stringLength + " x i8], [" + stringLength + " x i8]* " + currentTempString + ", i32 0, i32 0))");

                        }
                    } else {
                        System.err.println(" Error: No se pudo determinar el tipo de la variable '" + variable + "'.");
                    }
                }


                System.out.println("  Identificador: " + ctx.identifier().getText());
            } else {
                visit(ctx.string());
                String strValue = ctx.string().getText();
                strValue = strValue.substring(1, strValue.length() - 1); // Remove quotes

                String currentTempString = generateTempStringVariable();
                int stringLength = strValue.length();
                stringLength++;
                String textToPrepend = "" + currentTempString + " = private constant [" + stringLength + " x i8] c\"" + strValue + "\\00\"\n";

                llvmCode.insert(0, textToPrepend);

                emit("    call void @write_string(i8* getelementptr inbounds ([" + stringLength + " x i8], [" + stringLength + " x i8]* " + currentTempString + ", i32 0, i32 0))");


// Generar código LLVM para la cadena
//                String strValue = ctx.string().getText().substring(1, ctx.string().getText().length() - 1);
//                String llvmString = "@.str = private unnamed_addr constant [" + (strValue.length() + 2) + " x i8] c\"" + strValue + "\\0A\\00\"";
//                emit(llvmString);
//                emit("declare i32 @puts(ptr nocapture) nounwind");
//                emit("define i32 @main() {");
//                emit("    call i32 @puts(ptr @.str)");
//                emit("    ret i32 0");
//                emit("}");
//                emit("!0 = !{i32 42, null, !\"string\"}");
//                emit("!foo = !{!0}");

//                call void @write_int(i32 %num_val)
            }
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

        String variable = ctx.readParam().getText();
        String tipoVariable = "";

        // Obtener el tipo de la variable desde la tabla de símbolos
        for (Binding binding : TablaSimbolos) {
            if (binding.getNombre().equals(variable) && binding.getScope().equals(scope_actual)) {
                tipoVariable = binding.getTipo();
                break;
            }
        }

        System.out.println("  Variable: " + variable);
        System.out.println("  Tipo de Variable: " + tipoVariable);

        if (!encontrarVariable(variable)) {
            System.err.println(" Error: La variable '" + variable + "' no está definida en el ámbito '" + scope_actual + "'.");
            return null;
        } else {
            // Validar el tipo de la expresión
            if (tipoVariable != null) {
                if (!verificarValorNoBooleanForFunctions(variable, tipoVariable)) {
                    System.err.println(" Error: El valor '" + variable + "' no es compatible con el tipo '" + tipoVariable + "' de la variable '" + variable + "'.");
                } else {
                    System.out.println("  Asignando el valor " + variable + " a la variable '" + variable + "' de tipo '" + tipoVariable + "'.");
                    if (!scanfdeclared) {
                        llvmCode.insert(0, "\ndeclare i32 @scanf(i8*, ...)\n");
                        scanfdeclared = true;
                    }
                    switch (tipoVariable) {
                        case "integer":
                            llvmCode.insert(0, "@int_format = private constant [3 x i8] c\"%d\\00\"       ; Formato para enteros\n");

                            emit("    %int_ptr" + counter + " = bitcast i32* %int_var to i8* ;");
                            emit("    call i32 (i8*, ...) @scanf(i8* bitcast ([3 x i8]* @int_format to i8*), i8* %int_ptr" + counter + ")");
                            counter++;
                            break;
                        case "char":
                            llvmCode.insert(0, "@char_format = private constant [3 x i8] c\"%c\\00\"      ; Formato para caracteres\n");
                            break;
                        case "string":
                            llvmCode.insert(0, "@str_format = private constant [3 x i8] c\"%s\\00\"       ; Formato para cadenas\n" +
                                    "@buffer = private global [256 x i8] zeroinitializer    ; Buffer para almacenar cadenas\n");
                            break;
                    }
                }
            } else {
                System.err.println(" Error: No se pudo determinar el tipo de la variable '" + variable + "'.");
            }
        }

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

        // Verificar si la variable está definida en el ámbito actual
        if (!encontrarVariable(variable)) {
            System.err.println(" Error: La variable '" + variable + "' no está definida en el ámbito '" + scope_actual + "'.");
            return null;
        }

        // Obtener el tipo de la variable desde la tabla de símbolos
        String tipoVariable = null;
        for (Binding binding : TablaSimbolos) {
            if (binding.getNombre().equals(variable) && binding.getScope().equals(scope_actual)) {
                tipoVariable = binding.getTipo();
                break;
            }
        }


//        expression = expression.substring(0, expression.indexOf("("));

        // Validar el tipo de la expresión
        if (tipoVariable != null) {
            if (!verificarValor(expression, tipoVariable)) { // Ahora se pasan dos parámetros
                System.err.println(" Error: El valor '" + expression + "' no es compatible con el tipo '" + tipoVariable + "' de la variable '" + variable + "'.");
            } else {
                System.out.println("  Asignando el valor " + expression + " a la variable '" + variable + "' de tipo '" + tipoVariable + "'.");
            }
        } else {
            System.err.println(" Error: No se pudo determinar el tipo de la variable '" + variable + "'.");
        }

        //esto ya es generando el .ll
        // Generar código LLVM para la asignación
        switch (tipoVariable) {
            case "integer":
                emit("    store i32 " + expression + ", i32* %" + variable);
                emit("    %" + variable + "_val" + counter + " = load i32, i32* %" + variable);
                loads.add(new Loads(variable, counter));
                counter++;
                break;
            case "boolean":
                switch (expression) {
                    case "true":
                        emit("    store i1 1, i1* %" + variable);
                        emit("    %" + variable + "_val" + counter + " = load i1, i1* %" + variable);
                        loads.add(new Loads(variable, counter));
                        counter++;
                        break;
                    case "false":
                        emit("    store i1 0, i1* %" + variable);
                        emit("    %" + variable + "_val" + counter + " = load i1, i1* %" + variable);
                        loads.add(new Loads(variable, counter));
                        counter++;
                        break;
                    default:
                        emit("    store i1 " + expression + ", i1* %" + variable);
                        break;
                }
                break;
            case "char":
                int asciivalue = expression.charAt(1);
                emit("    store i8 " + asciivalue + ", i8* %" + variable);
                emit("    %" + variable + "_val" + counter + " = load i8, i8* %" + variable);
                loads.add(new Loads(variable, counter));
                counter++;
                break;
            case "string":

                String currentTempString = generateTempStringVariable();
                int stringLength = expression.length();
                stringLength--;
                String textToPrepend = "" + currentTempString + " = private constant [" + stringLength + " x i8] c\"" + expression.substring(1, expression.length() - 1) + "\\00\"\n";

                llvmCode.insert(0, textToPrepend);

//                emit("    store i8* getelementptr inbounds ([" + stringLength + " x i8], [" + stringLength + " x i8]* " + currentTempString + ", i32 0, i32 0), i8** %" + variable);
                emit("    store i8* getelementptr inbounds ([" + stringLength + " x i8], [" + stringLength + " x i8]* " + currentTempString + ", i32 0, i32 0), i8** %" + variable);
                emit("    %" + variable + "_val" + counter + " = load i8*, i8** %" + variable);
                loads.add(new Loads(variable, counter));
                counter++;
                break;
        }

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

        String statementText = "";
        for (int i = 0; i < ctx.expression().getChildCount(); i++) {
            statementText += ctx.expression().getChild(i).getText() + " ";
        }

        System.out.println("  Condicion: " + statementText);

        String[] expresionSplit = statementText.split(" ");
        String variable = expresionSplit[0];
        String operador = expresionSplit[1];
        String valor = expresionSplit[2];

        String currentCounter = generateCondVariable();


        if (encontrarVariableEnLoads(valor)) {
            System.out.println("  Valor: " + valor + " es una variable definida.");

            switch (operador) {
                case ">":
                    for (Loads load : loads) {
                        if (load.getVariable().equals(variable)) {
                            for (Loads load2 : loads) {
                                if (load2.getVariable().equals(valor)) {
                                    emit("    %" + currentCounter + " = icmp sgt i32 %" + variable + "_val" + load.getCounter() + ", %" + valor + "_val" + load2.getCounter());
                                    break;
                                }
                            }
                        }
                    }
                    break;
                case "<":
                    for (Loads load : loads) {
                        if (load.getVariable().equals(variable)) {
                            for (Loads load2 : loads) {
                                if (load2.getVariable().equals(valor)) {
                                    emit("    %" + currentCounter + " = icmp slt i32 %" + variable + "_val" + load.getCounter() + ", %" + valor + "_val" + load2.getCounter());
                                    break;
                                }
                            }
                        }
                    }
                    break;
            }

        } else {
            try {
                Integer.parseInt(valor);
                System.out.println("  Valor: " + valor + " es un número.");

                switch (operador) {
                    case ">":
                        for (Loads load : loads) {
                            if (load.getVariable().equals(variable)) {
                                emit("    %" + currentCounter + " = icmp sgt i32 %" + variable + "_val" + load.getCounter() + ", " + valor);
                                break;
                            }
                        }
                        break;
                    case "<":
                        for (Loads load : loads) {
                            if (load.getVariable().equals(variable)) {
                                emit("    %" + currentCounter + " = icmp slt i32 %" + variable + "_val" + load.getCounter() + ", " + valor);
                                break;
                            }
                        }
                        break;
                }

            } catch (NumberFormatException e) {
                System.err.println("  Valor: " + valor + " no es una variable definida ni un número.");
            }
        }

        emit("    br i1 %" + currentCounter + ", label %then" + ifCounter + ", label %else" + ifCounter);
        emit("then" + ifCounter + ":");
        visit(ctx.statement(0));
        emit("    br label %merge" + ifCounter);

        System.out.println("  Hacer: " + ctx.statement(0).getText());
        if (ctx.ELSE() != null) {
            System.out.println("  Else: " + ctx.statement(1).getText());
            emit("else" + ifCounter + ":");
            visit(ctx.statement(1));
            emit("    br label %merge" + ifCounter);
        }
        emit("merge" + ifCounter + ":");
        ifCounter++;

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

    public void Header(MiniPascalGrammarParser.ProgramHeadingContext programHeader) {

        String programName = programHeader.identifier().getText();
        String allHeader = "";

        // Start of the program with filename header
        allHeader += "; ModuleID = 'MiniPascal'\n";
        allHeader += "source_filename = \"" + programName + "\"\n";
        allHeader += "target datalayout = \"e-m:e-p270:32:32-p271:32:32-p272:64:64-i64:64-f80:128-n8:16:32:64-S128\"\n";
        allHeader += "target triple = \"x86_64-pc-microsoft-msvc\"\n";

        // Standard library functions + Global declarations
        allHeader += "%struct._IO_FILE = type { i8*, i32, i32, i32, i8*, i8*, i8*, i8*, i8*, i32, i32, i32, i32, i8*, i8*, i8*, i32, i32, i32 }\n";
        allHeader += "@str_fmt = unnamed_addr constant [4 x i8] c\"%d\\0A\\00\"\n";
        allHeader += "@stdin = external global %struct._IO_FILE*\n";
        allHeader += "@double_fmt = private unnamed_addr constant [4 x i8] c\"%f\\0A\\00\"\n";


        llvmCode.insert(0, allHeader);
    }

    public void Footer() {
        // End of the program
        emit("  ret i32 0\n}\n");

        // write_int function for printing integers
        emit("define void @write_int(i32 %num) {");
//        System.out.println("    %buf = alloca [32 x i8], align 1");
//        System.out.println("    %buf_ptr = getelementptr inbounds [32 x i8], [32 x i8]* %buf, i32 0, i32 0");
//        System.out.println("    call i32 (i8*, i8*, ...) @printf(i8* %buf_ptr, i8* getelementptr inbounds ([4 x i8], [4 x i8]* @str_fmt, i32 0, i32 0), i32 %num)");
//        System.out.println("    call i32 @puts(i8* %buf_ptr)");
        emit("    call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @str_fmt, i32 0, i32 0), i32 %num)");
        emit("    ret void");
        emit("}\n");

        // write_string function for printing strings
        emit("define void @write_string(i8* %str) {");
//        System.out.println("    %str_ptr = alloca i8*");
//        System.out.println("    store i8* %str, i8** %str_ptr");
//        System.out.println("    %str_val = load i8*, i8** %str_ptr");
        emit("    call i32 @puts(i8* %str)");
        emit("    ret void");
        emit("}\n");

        // read function for reading input
//        System.out.println("define i32 @read() {");
//        System.out.println("  %buf = alloca [32 x i8], align 1");
//        System.out.println("  %buf_ptr = getelementptr inbounds [32 x i8], [32 x i8]* %buf, i32 0, i32 0");
//        System.out.println("  %stdin_val = load %struct._IO_FILE*, %struct._IO_FILE** @stdin");
//        System.out.println("  %result = call i8* @fgets(i8* %buf_ptr, i32 32, %struct._IO_FILE* %stdin_val)");
//        System.out.println("  %num = call i32 @atoi(i8* %buf_ptr)");
//        System.out.println("  ret i32 %num");
//        System.out.println("}\n");

        // Function declarations for standard library functions
        emit("declare i32 @atoi(i8*)");
        emit("declare i32 @sprintf(i8*, i8*, ...)");
        emit("declare i32 @puts(i8*)");
        emit("declare i8* @fgets(i8*, i32, %struct._IO_FILE*)");
        emit("declare void @exit(i32)\n");

// Footer
        emit("; Function Attrs: noinline nounwind optnone uwtable");
        emit("declare i32 @printf(i8*, ...) #0");
        emit("attributes #0 = { noinline nounwind optnone uwtable \"correctly-rounded-divide-sqrt-fp-math\"=\"false\" \"disable-tail-calls\"=\"false\" \"frame-pointer\"=\"all\" \"less-precise-fpmad\"=\"false\" \"min-legal-vector-width\"=\"0\" \"no-infs-fp-math\"=\"false\" \"no-jump-tables\"=\"false\" \"no-nans-fp-math\"=\"false\" \"no-signed-zeros-fp-math\"=\"false\" \"no-trapping-math\"=\"false\" \"stack-protector-buffer-size\"=\"8\" \"target-cpu\"=\"x86-64\" \"target-features\"=\"+cx8,+fxsr,+mmx,+sse,+sse2,+x87\" \"unsafe-fp-math\"=\"false\" \"use-soft-float\"=\"false\" }");
        emit("!llvm.module.flags = !{!0}\n");
        emit("!llvm.ident = !{!1}");
        emit("!0 = !{i32 1, !\"wchar_size\", i32 4}");
        emit("!1 = !{!\"clang version 10.0.0-4ubuntu1 \"}\n");
    }

}