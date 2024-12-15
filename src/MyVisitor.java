import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MyVisitor extends MiniPascalGrammarBaseVisitor<Object> {

    private boolean scanfdeclared = false;
    private boolean intformatdeclared = false;
    private boolean charformatdeclared = false;
    private boolean stringformatdeclared = false;
    private static ArrayList<String> ThreeAddressCodeTemp = new ArrayList<>();

    public static final String CYAN = "\u001B[36m";
    public static final String RESET = "\u001B[0m";

    private int tempCounter = 1;  // Contador de variables temporales
    private static int counter = 1;
    private static ArrayList<Loads> loads = new ArrayList<Loads>();

    private StringBuilder header = new StringBuilder();
    StringBuilder llvmCode = new StringBuilder();

    public String analyzeString(String input) {
        if (input.matches("\\d+")) {
            return "integer";
        } else if (input.matches("'(.)'")) {
            return "char";
        } else if (input.matches("'([^']*)'")) {
            return "string";
        } else if (input.equals("true") || input.equals("false")) {
            return "boolean";
        } else {
            return "unknown";
        }
    }

//    private static boolean isFunction(){
//
//    }


    public static void generateThreeAddressCode(String expression, String outputFileName, String finalVarName) throws IOException {
        System.out.println(CYAN + "Expresión: " + expression + RESET);
        // Eliminar espacios innecesarios
        expression = expression.replaceAll("\\s+", "");

        // Convertir la expresión a notación postfija (RPN) respetando la precedencia
        String postfix = infixToPostfix(expression);

        // Generar código de tres direcciones y escribirlo al archivo
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName))) {
            generateCodeFromPostfix(postfix, writer, finalVarName);
        }
    }

    private static String infixToPostfix(String expression) {
        StringBuilder postfix = new StringBuilder();
        Stack<Character> operators = new Stack<>();
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            if (Character.isDigit(c) || Character.isLetter(c)) {
                // Leer números, variables o funciones completas
                while (i < expression.length() &&
                        (Character.isLetterOrDigit(expression.charAt(i)) || expression.charAt(i) == '(' || expression.charAt(i) == ',' || expression.charAt(i) == ')')) {
                    postfix.append(expression.charAt(i));
                    i++;
                }
                postfix.append(' ');
                i--;
            } else if (c == '(') {
                operators.push(c);
            } else if (c == ')') {
                while (!operators.isEmpty() && operators.peek() != '(') {
                    postfix.append(operators.pop()).append(' ');
                }
                operators.pop(); // Quitar '('
            } else if (isOperator(c)) {
                while (!operators.isEmpty() && precedence(operators.peek()) >= precedence(c)) {
                    postfix.append(operators.pop()).append(' ');
                }
                operators.push(c);
            }
        }

        // Vaciar operadores restantes
        while (!operators.isEmpty()) {
            postfix.append(operators.pop()).append(' ');
        }

        return postfix.toString().trim();
    }

    private static boolean isOperator(char c) {
        return "+-*/%".indexOf(c) != -1;
    }

    private static int precedence(char operator) {
        return switch (operator) {
            case '+', '-' -> 1;
            case '*', '/', '%' -> 2;
            default -> -1;
        };
    }


    private static void generateCodeFromPostfix(String postfix, BufferedWriter writer, String finalVarName) throws IOException {
        Stack<String> tempStack = new Stack<>();
        String[] tokens = postfix.split("\\s+");

        for (String token : tokens) {
            if (isNumeric(token) || isIdentifier(token)) {
                if (isIdentifier(token)) {
                    Loads tempLoad = lastLoad(token);
                    tempStack.push(tempLoad.getVariable() + "_val" + tempLoad.getCounter());
                } else {
                    tempStack.push(token);
                }
            } else if (isFunction(token)) {
                // Procesar función con parámetros
                String functionName = token.substring(0, token.indexOf('('));
                String paramList = token.substring(token.indexOf('(') + 1, token.indexOf(')'));
                String[] params = paramList.split(",");

                // Generar código para evaluar parámetros
                for (int i = 0; i < params.length; i++) {
                    String param = params[i];
                    writer.write(String.format("param %s", param));
                    writer.newLine();
                    ThreeAddressCodeTemp.add(String.format("param %s", param) + "\n");
                }

                // Generar código para la llamada a la función
                String tempVar = getNextTempVar();
                writer.write(String.format("%s = call %s, %d", tempVar, functionName, params.length));
                writer.newLine();
                ThreeAddressCodeTemp.add(String.format("%s = call %s, %d", tempVar, functionName, params.length) + "\n");

                // Guardar el resultado de la función en el stack
                tempStack.push(tempVar);
            } else {
                // Procesar operación binaria
                String b = tempStack.pop();
                String a = tempStack.pop();

                // Generar código para la operación
                String tempVar = getNextTempVar();
                String instruction = String.format("%s = %s %s %s", tempVar, a, token, b);

                // Escribir la instrucción en el archivo
                writer.write(instruction);
                writer.newLine();
                ThreeAddressCodeTemp.add(instruction + "\n");

                // Guardar el resultado en el stack
                tempStack.push(tempVar);
            }
        }

        // Asignar el último valor al nombre de variable final proporcionado
        String lastTempVar = tempStack.pop();
        writer.write(finalVarName + " = " + lastTempVar);
        writer.newLine();
        ThreeAddressCodeTemp.add(finalVarName + " = " + lastTempVar + "\n");
    }

    private static boolean isNumeric(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");
    }

    private static boolean isIdentifier(String str) {
        return str.matches("[a-zA-Z_][a-zA-Z0-9_]*\\(.*\\)?") || str.matches("[a-zA-Z_][a-zA-Z0-9_]*");
    }

    private static boolean isFunction(String str) {
        return str.matches("[a-zA-Z_][a-zA-Z0-9_]*\\(.*\\)");
    }

    private static String getNextTempVar() {
        return "t" + (counter++);
    }


    public static Loads lastLoad(String variable) {
        for (int i = loads.size() - 1; i >= 0; i--) {
//            System.out.println("Variable: " + loads.get(i).getVariable() + " counter: " + loads.get(i).getCounter());
            if (loads.get(i).getVariable().equals(variable) && loads.get(i).getScope().equals(scope_actual)) {
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

    private int whileCounter = 1;  // Contador de while

    private String generateWhile() {
        return "while" + whileCounter++;  // while1, while2, while3, ...
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

    private static String getLLVMOperator(String operator) {
        return switch (operator) {
            case "+" -> "add";
            case "-" -> "sub";
            case "*" -> "mul";
            case "/" -> "sdiv";
            default -> throw new IllegalArgumentException("Operador no soportado: " + operator);
        };
    }

    public void generateLLVMFrom3AC(ArrayList<String> threeAddressCode) {
        // Escribir el encabezado del archivo LLVM IR

        // Mapa para almacenar variables temporales declaradas
        ArrayList<String> declaredVariables = new ArrayList<>();

        for (String instruction : threeAddressCode) {
            // Dividir la instrucción en sus partes
            String[] parts = instruction.trim().split(" ");

            if (parts.length == 3 && parts[1].equals("=")) {
                // Asignación simple: a = b
                String result = parts[0];
                String value = parts[2];

//                if (!declaredVariables.contains(result)) {
//                    emit(String.format("%%s = alloca i32\n", result));
//                    declaredVariables.add(result);
//                }

                if (isNumeric(value)) {
                    if (scope_actual == "global")
                        emit_main(String.format("store i32 %s, i32* %%%s", value, result));
                    else
                        emit_header(String.format("store i32 %s, i32* %%%s", value, result));
                } else {
                    if (scope_actual == "global") {
                        emit_main("store i32 %" + value + ", i32* %" + result);
//                        emit_main(String.format("%%%s = load i32, i32* %%%s", result + "_val" + counter, result));
                        emit_main("    %" + result + "_val" + counter + " = load i32, i32* %" + result);
                        Loads tempload = new Loads(result, counter, scope_actual);
                        loads.add(tempload);
                        System.out.println(CYAN + "Variable: " + tempload.getVariable() + " counter: " + tempload.getCounter() + RESET);
                        counter++;
                    } else {
                        emit_header("store i32 %" + value + ", i32* %" + result);
                        emit_header(String.format("%%%s = load i32, i32* %%%s", result + "_val" + counter, result));
                        loads.add(new Loads(result, counter, scope_actual));
                        counter++;
                    }

                }

            } else if (parts.length == 5 && parts[3].matches("[+\\-*/]") && parts[1].equals("=")) {
                // Operación binaria: t1 = a + b
                String tempVar = parts[0];
                String op1 = parts[2];
                String operator = parts[3];
                String op2 = parts[4];

//                if (!declaredVariables.contains(tempVar)) {
//                    emit(String.format("%%%s = alloca i32\n", tempVar));
//                    declaredVariables.add(tempVar);
//                }

                // LLVM equivalente para operadores
                String llvmOp = getLLVMOperator(operator);
                System.err.println("op2: " + op2 + " op1: " + op1);
                if (isNumeric(op1) && isNumeric(op2)) {
                    if (scope_actual == "global")
                        emit_main("%" + tempVar + " = " + llvmOp + " i32 " + op1 + ", " + op2);
                    else
                        emit_header("%" + tempVar + " = " + llvmOp + " i32 " + op1 + ", " + op2);
                } else if (isNumeric(op1)) {
                    if (scope_actual == "global")
                        emit_main("%" + tempVar + " = " + llvmOp + " i32 " + op1 + ", %" + op2);
                    else
                        emit_header("%" + tempVar + " = " + llvmOp + " i32 " + op1 + ", %" + op2);
                } else if (isNumeric(op2)) {
                    if (scope_actual == "global")
                        emit_main("%" + tempVar + " = " + llvmOp + " i32 %" + op1 + ", " + op2);
                    else
                        emit_header("%" + tempVar + " = " + llvmOp + " i32 %" + op1 + ", " + op2);
                } else {
                    if (scope_actual == "global")
                        emit_main("%" + tempVar + " = " + llvmOp + " i32 %" + op1 + ", %" + op2);
                    else
                        emit_header("%" + tempVar + " = " + llvmOp + " i32 %" + op1 + ", %" + op2);
                }

//                emit(String.format("%%%s = %s i32 %%%s, %%%s", tempVar, llvmOp, op1, op2));
            } else if (instruction.contains("call")) {
                // Llamada a función: t1 = call func, n
                String[] callParts = instruction.split("call ");
                String[] callDetails = callParts[1].split(", ");
                String tempVar = callDetails[0].trim();
                String functionName = callDetails[1].trim();

                if (scope_actual == "global")
                    emit_main(String.format("%%%s = call i32 @%s()\n", tempVar, functionName));
                else
                    emit_header(String.format("%%%s = call i32 @%s()\n", tempVar, functionName));
            }
        }

//            writer.write("\n; Fin del código LLVM\n");
    }


    private void emit_main(String line) {
        llvmCode.append(line).append("\n");
    }

    private void emit_header(String line) {
        header.append(line).append("\n");
    }


    public void writell() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("output.ll"))) {
            System.out.println("llvmcode -----------------------------------");
            System.out.println("\n\n\n\n\n" + llvmCode.toString());
            System.out.println("header -----------------------------------");
            System.out.println(CYAN + "\n\n\n\n\n" + header.toString() + RESET);
            writer.write(header.toString());
            writer.write(llvmCode.toString());
            loads.clear();
            TablaSimbolos.clear();
            threeAddressCodeList.clear();;
            ThreeAddressCodeTemp.clear();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    ArrayList<Binding> TablaSimbolos = new ArrayList<>();
    private static String scope_actual = "global";

    public void imprimirTablaSimbolos() {
        System.out.println(CYAN + " ------- Tabla de Simbolos ------- ");
        for (Binding binding : TablaSimbolos) {
            System.out.println(binding);
        }
        System.out.println(" --------------------------------- " + RESET);
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

        if (tipoEsperado.toLowerCase().equals("integer")) {
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
        } else if (tipoEsperado.toLowerCase().equals("boolean")) {
            return valor.equals("true") || valor.equals("false"); // Booleano
        } else if (tipoEsperado.toLowerCase().equals("char")) {
            return valor.matches("'[^']'"); // Un único carácter entre comillas simples
        } else if (tipoEsperado.toLowerCase().equals("string")) {
            return valor.matches("'[^']*'"); // Cadena entre comillas simples (permite vacías)
        }

        // Tipo no reconocido
        return false;

    }

    private boolean verificarValorNoBooleanForFunctions(String valor, String tipoEsperado) {
        // Validación para tipos básicos
        if (tipoEsperado.toLowerCase().equals("integer")) {
            return true;
        } else if (tipoEsperado.toLowerCase().equals("char")) {
            return true;
        } else if (tipoEsperado.toLowerCase().equals("string")) {
            return true;
        }

        // Tipo no reconocido
        return false;

    }


    @Override
    public Object visitProgram(MiniPascalGrammarParser.ProgramContext ctx) {
//        try {
//            generateThreeAddressCode("3 + funcion(variable1, variable2, variable3) - 9 + 10 * 4 / 7 + variable * 4", "output3AC.txt", "variable_final");
//            for (int i = 0; i < ThreeAddressCodeTemp.size(); i++) {
//                System.err.println(ThreeAddressCodeTemp.get(i));
//            }
//            ThreeAddressCodeTemp.clear();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
        System.out.println("Inicio del Programa:");
        visit(ctx.programHeading());
        System.out.println("\nBloque:");
        emit_main("\ndefine i32 @main() {");
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
        System.out.println(CYAN + "Scope Actual: " + scope_actual + RESET);
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
                    switch (variableType.toLowerCase()) {
                        case "integer":
                            threeAddressCodeList.add(new ThreeAddressCode("alloca", "i32", null, variableName));
                            if (scope_actual == "global")
                                emit_main("    %" + variableName + " = alloca i32");
                            else
                                emit_header("    %" + variableName + " = alloca i32");
                            break;
                        case "boolean":
                            threeAddressCodeList.add(new ThreeAddressCode("alloca", "i1", null, variableName));
                            if (scope_actual == "global")
                                emit_main("    %" + variableName + " = alloca i1");
                            else
                                emit_header("    %" + variableName + " = alloca i1");
                            break;
                        case "char":
                            threeAddressCodeList.add(new ThreeAddressCode("alloca", "i8", null, variableName));
                            if (scope_actual == "global")
                                emit_main("    %" + variableName + " = alloca i8");
                            else
                                emit_header("    %" + variableName + " = alloca i8");
                            break;
                        case "string":
                            threeAddressCodeList.add(new ThreeAddressCode("alloca", "i8*", null, variableName));
                            if (scope_actual == "global")
                                emit_main("    %" + variableName + " = alloca i8*");
                            else
                                emit_header("    %" + variableName + " = alloca i8*");
                            break;
                    }

                    // Asignar el tipo correspondiente en 3AC
                    //aca va a tocar hacer cambios
//                    String tempVar = generateTempVariable(); // Crear variable temporal
//                    String operation = "alloca"; // Operación de asignación de memoria
//                    threeAddressCodeList.add(new ThreeAddressCode(operation, variableType, null, tempVar)); // Agregar la instrucción
                    imprimirTablaSimbolos();
                } else {
                    System.out.println("\u001B[31mError: La variable \'" + binding.getNombre() + "\' ya ha sido declarada en el scope \'" + scope_actual + "\'\u001B[0m");
//                    System.exit(1);
                    //aca hay que hacer que el programa no siga
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

        System.out.println("  Identificador: " + functionName);
        System.out.println("  Tipo de Return: " + returnType);

        // Procesar parámetros formales
        if (ctx.formalParameterList() != null) {
            visit(ctx.formalParameterList());
        }

        String parametros = ctx.formalParameterList().getText().substring(1, ctx.formalParameterList().getText().length() - 1);
        ArrayList<Parametros> parametrosList = new ArrayList<>();
        String[] paramGroups = parametros.split(";");

        for (String group : paramGroups) {
            String[] parts = group.split(":");
            String[] variables = parts[0].split(",");
            String tipo = parts[1].trim();

            for (String variable : variables) {
                parametrosList.add(new Parametros(variable.trim(), tipo));
            }
        }
        for (int i = 0; i < parametrosList.size(); i++) {
            System.out.println(CYAN + "  Parametro: " + parametrosList.get(i).getVariable() + " de tipo " + parametrosList.get(i).getTipo() + RESET);
        }


        // Procesar el bloque de la función
        System.out.println("  Bloque:");
        StringBuilder definicionFuncion = new StringBuilder();
        switch (returnType.toLowerCase()) {
            case "integer":
                definicionFuncion.append("define i32 @" + functionName + "(");
                break;
            case "boolean":
                break;
            case "char":
                break;
            case "string":
                break;
        }
        for (int i = 0; i < parametrosList.size(); i++) {
            switch (parametrosList.get(i).getTipo().toLowerCase()) {
                case "integer":
                    definicionFuncion.append("i32 %" + parametrosList.get(i).getVariable());
                    if (i < parametrosList.size() - 1) {
                        definicionFuncion.append(", ");
                    }
                    break;
                case "boolean":
                    definicionFuncion.append("i1 %" + parametrosList.get(i).getVariable());
                    if (i < parametrosList.size() - 1) {
                        definicionFuncion.append(", ");
                    }
                    break;
                case "char":
                    definicionFuncion.append("i8 %" + parametrosList.get(i).getVariable());
                    if (i < parametrosList.size() - 1) {
                        definicionFuncion.append(", ");
                    }
                    break;
                case "string":
                    definicionFuncion.append("i8* %" + parametrosList.get(i).getVariable());
                    if (i < parametrosList.size() - 1) {
                        definicionFuncion.append(", ");
                    }
                    break;
            }
        }
        definicionFuncion.append(") {\n" +
                "entry:\n");
        definicionFuncion.append("    %" + functionName + " = alloca i32\n");


//        llvmCode.insert(0, definicionFuncion.toString());
        emit_header(definicionFuncion.toString());
        int offset_funcion = definicionFuncion.toString().length();

        Binding functionBinding = new Binding(functionName, returnType, scope_actual, true);
        functionBinding.setOffset(offset_funcion);
        TablaSimbolos.add(functionBinding);
        imprimirTablaSimbolos();

        visit(ctx.block());

        int nuevo_para_final = functionBinding.getOffset();

        switch (returnType.toLowerCase()) {
            case "integer":
                for (int j = 0; j < loads.size(); j++) {
                    if (loads.get(j).getVariable().equals(functionName)) {
                        emit_header("    ret i32 %" + loads.get(j).getVariable() + "_val" + loads.get(j).getCounter() + "\n}\n");
                    }
                }
                break;
            case "boolean":
                break;
            case "char":
                break;
            case "string":
                break;
        }

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
                            stringLength++;
                            String textToPrepend = "" + currentTempString + " = private constant [" + stringLength + " x i8] c\"" + strValue + "\\00\"\n";

//                            llvmCode.insert(0, textToPrepend);
                            header.insert(0, textToPrepend);
//                            emit_header(textToPrepend);

                            // 3AC for write('texto', variable)
                            threeAddressCodeList.add(new ThreeAddressCode("string", strValue, null, currentTempString));
                            threeAddressCodeList.add(new ThreeAddressCode("write", currentTempString, null, null));
//                            threeAddressCodeList.add(new ThreeAddressCode("write", variable, null, null));

                            emit_main("    call void @write_string(i8* getelementptr inbounds ([" + stringLength + " x i8], [" + stringLength + " x i8]* " + currentTempString + ", i32 0, i32 0))");

                            Loads load = lastLoad(variable);
                            if (tipoVariable.toLowerCase().equals("integer")) {
                                for (int i = 0; i < loads.size(); i++) {
                                    System.out.println(CYAN + loads.get(i).getVariable() + " " + loads.get(i).getCounter() + RESET);
                                }
                                threeAddressCodeList.add(new ThreeAddressCode("write", "integer", variable + "_val" + load.getCounter(), null));
                                emit_main("    call void @write_int(i32 %" + variable + "_val" + load.getCounter() + ")");
                            } else if (tipoVariable.toLowerCase().equals("char")) {
                                threeAddressCodeList.add(new ThreeAddressCode("write", "char", variable + "_val" + load.getCounter(), null));
                                emit_main("    call void @write_char(i8 %" + variable + "_val" + load.getCounter() + ")");
                            } else if (tipoVariable.toLowerCase().equals("string")) {
                                threeAddressCodeList.add(new ThreeAddressCode("write", "string", variable + "_val" + load.getCounter(), null));
                                emit_main("    call void @write_string(i8* %" + variable + "_val" + load.getCounter() + ")");
                            }

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

//                llvmCode.insert(0, textToPrepend);
//                emit_header(textToPrepend);
                header.insert(0, textToPrepend);


                // 3AC for write('texto')
                threeAddressCodeList.add(new ThreeAddressCode("string", strValue, null, currentTempString));
                threeAddressCodeList.add(new ThreeAddressCode("write", currentTempString, null, null));

                emit_main("    call void @write_string(i8* getelementptr inbounds ([" + stringLength + " x i8], [" + stringLength + " x i8]* " + currentTempString + ", i32 0, i32 0))");

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
        System.out.println("  Tipo de Variable: " + tipoVariable + ".");

        if (!encontrarVariable(variable)) {
            System.err.println(" Error: La variable '" + variable + "' no está definida en el ámbito '" + scope_actual + "'.");
            return null;
        } else {
            // Validar el tipo de la expresión
            if (tipoVariable != null) {
                if (!verificarValorNoBooleanForFunctions(variable, tipoVariable)) {
                    System.err.println(" Error: El valor '" + variable + "' no es compatible con el tipo '" + tipoVariable + "' de la variable '" + variable + "'.");
                } else {
                    System.out.println("  Asignando el valor a la variable '" + variable + "' de tipo '" + tipoVariable + "'.");
                    if (!scanfdeclared) {
//                        llvmCode.insert(0, "\ndeclare i32 @scanf(i8*, ...)\n");
                        emit_header("declare i32 @scanf(i8*, ...)");
                        scanfdeclared = true;

                    }
                    String tipovariable_lowercase = tipoVariable.toLowerCase();
                    System.out.println("  Tipo de Variable lowercase: " + tipovariable_lowercase + ".");
                    switch (tipovariable_lowercase) {
                        case "integer":
                            System.out.println("ENTROOOOOOO");
                            if (!intformatdeclared) {
//                                llvmCode.insert(0, "@int_format = private constant [3 x i8] c\"%d\\00\"       ; Formato para enteros\n");
                                emit_header("@int_format = private constant [3 x i8] c\"%d\\00\"       ; Formato para enteros");
                                intformatdeclared = true;
                            }

                            emit_main("    %int_ptr" + counter + " = bitcast i32* %" + variable + " to i8* ;");
                            emit_main("    call i32 (i8*, ...) @scanf(i8* bitcast ([3 x i8]* @int_format to i8*), i8* %int_ptr" + counter + ")");
                            emit_main("    %" + variable + "_val" + counter + " = load i32, i32* " + "%" + variable);
                            loads.add(new Loads(variable, counter, scope_actual));
                            counter++;
                            break;
                        case "char":
                            if (!charformatdeclared) {
//                                llvmCode.insert(0, "@char_format = private constant [3 x i8] c\"%c\\00\"      ; Formato para caracteres\n");
                                emit_header("@char_format = private constant [4 x i8] c\" %c\\00\"      ; Formato para caracteres");
                                charformatdeclared = true;
                            }
                            emit_main("    %char_ptr" + counter + " = bitcast i8* %" + variable + " to i8* ;");
                            emit_main("    call i32 (i8*, ...) @scanf(i8* bitcast ([4 x i8]* @char_format to i8*), i8* %char_ptr" + counter + ")");
                            emit_main("    %" + variable + "_val" + counter + " = load i8, i8* " + "%" + variable);
                            loads.add(new Loads(variable, counter, scope_actual));
                            counter++;
                            break;
                        case "string":
                            if (!stringformatdeclared) {
//                                llvmCode.insert(0, "@str_format = private constant [3 x i8] c\"%s\\00\"       ; Formato para cadenas\n" +
//                                        "@buffer = private global [256 x i8] zeroinitializer    ; Buffer para almacenar cadenas\n");
                                emit_header("@str_format = private constant [3 x i8] c\"%s\\00\"       ; Formato para cadenas");
                                stringformatdeclared = true;
                            }
                            emit_main("    %str_ptr" + counter + " = getelementptr inbounds [256 x i8], [256 x i8]* @buffer, i32 0, i32 0");
                            emit_main("    call i32 (i8*, ...) @scanf(i8* bitcast ([3 x i8]* @str_format to i8*), i8* %str_ptr" + counter + ")");
                            emit_main("    store i8* %str_ptr" + counter + ", i8** %" + variable);
                            emit_main("    %" + variable + "_val" + counter + " = load i8*, i8** %" + variable);
                            loads.add(new Loads(variable, counter, scope_actual));
                            counter++;
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
        System.out.println("expresion: " + expression);

        if (ctx.expression().simpleExpression().getChildCount() == 1) { // x =: 3*4
            System.out.println(CYAN + "CHILD == 1" + RESET);
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


            switch (tipoVariable.toLowerCase()) {
                case "integer":
                    if (isNumeric(expression)) {
                        threeAddressCodeList.add(new ThreeAddressCode("store", expression, "integer", variable));
                        threeAddressCodeList.add(new ThreeAddressCode("load", variable, "integer", variable + "_val" + counter));
                        if (scope_actual != "global") {
                            //                        System.out.println(CYAN + "ENTRO AL IF" + RESET);
                            String toinsert = "    store i32 " + expression + ", i32* %" + variable + "\n" +
                                    "    %" + variable + "_val" + counter + " = load i32, i32* %" + variable + "\n";
                            emit_header(toinsert);
                        } else {
                            emit_main("    store i32 " + expression + ", i32* %" + variable);
                            emit_main("    %" + variable + "_val" + counter + " = load i32, i32* %" + variable);
                        }
                        loads.add(new Loads(variable, counter, scope_actual));
                        System.out.println(CYAN + "ASIGNANDO EL DE LA VARIABLE: " + variable + " CON EL VALOR: " + expression + RESET);
                        counter++;
                    } else if (isFunction(expression)) {
                        System.out.println(CYAN + "IS FUNCTION" + RESET);
                        String nombre_funcion = expression.substring(0, expression.indexOf("("));
                        System.out.println(CYAN + "NOMBRE DE LA FUNCION: " + nombre_funcion + RESET);
                        String tipo_funcion = "";
                        for (int i = 0; i < TablaSimbolos.size(); i++) {
                            if (TablaSimbolos.get(i).getNombre().equals(nombre_funcion)) {
                                tipo_funcion = TablaSimbolos.get(i).getTipo();
                            }
                        }
                        switch (tipo_funcion.toLowerCase()) {
                            case "integer":
                                String parametros = expression.substring(expression.indexOf("(") + 1, expression.indexOf(")"));
                                //                        ArrayList<Parametros> parametrosList = new ArrayList<>();
                                String[] paramGroups = parametros.split(","); // sacando los parametros
                                StringBuilder mensaje = new StringBuilder();

                                mensaje.delete(0, mensaje.length());
                                mensaje.append("    %" + variable + "_val" + counter + " = call i32 @" + nombre_funcion + "(");
                                loads.add(new Loads(variable, counter, scope_actual));
                                counter++;

                                for (int i = 0; i < paramGroups.length; i++) {
                                    System.out.println(CYAN + "PARAMETRO: " + paramGroups[i] + RESET);
                                    switch (analyzeString(paramGroups[i])) {
                                        case "integer":
                                            mensaje.append("i32 " + paramGroups[i]);
                                            break;
                                        case "char":
                                            int caracterascii = paramGroups[i].charAt(1);
                                            mensaje.append("i8 " + caracterascii);
                                            break;
                                        case "string":
                                            emit_header("@cadena" + counter + " = private constant [" + (paramGroups[i].length() - 1) + " x i8] c\"" + paramGroups[i].substring(1, paramGroups[i].length() - 1) + "\\00\"");
                                            emit_main("%ptr_cadena" + counter +" = bitcast [" + (paramGroups[i].length() - 1) + " x i8]* @cadena" + counter + " to i8*");
                                            mensaje.append("i8* " + "%ptr_cadena" + counter);
                                            counter++;
                                            break;
                                    }
                                    if (i < paramGroups.length - 1) {
                                        mensaje.append(", ");
                                    }
                                }

                                switch (scope_actual) {
                                    case "global":
                                        emit_main(mensaje.toString() + ")");
                                        break;
                                    default:
                                        emit_header(mensaje.toString() + ")");
                                        break;
                                }
                        }

                    }
                    break;
                case "boolean":
                    switch (expression) {
                        case "true":
                            threeAddressCodeList.add(new ThreeAddressCode("store", "1", "boolean", variable));
                            threeAddressCodeList.add(new ThreeAddressCode("load", variable, "boolean", variable + "_val" + counter));
                            if (scope_actual != "global") {
                                String toinsert = "    store i1 1, i1* %" + variable + "\n" +
                                        "    %" + variable + "_val" + counter + " = load i1, i1* %" + variable + "\n";
                                emit_header(toinsert);
                            } else {
                                emit_main("    store i1 1, i1* %" + variable);
                                emit_main("    %" + variable + "_val" + counter + " = load i1, i1* %" + variable);
                            }
                            loads.add(new Loads(variable, counter, scope_actual));
                            counter++;
                            break;
                        case "false":
                            threeAddressCodeList.add(new ThreeAddressCode("store", "0", "boolean", variable));
                            threeAddressCodeList.add(new ThreeAddressCode("load", variable, "boolean", variable + "_val" + counter));
                            if (scope_actual != "global") {
                                String toinsert = "    store i1 0, i1* %" + variable + "\n" +
                                        "    %" + variable + "_val" + counter + " = load i1, i1* %" + variable + "\n";
                                emit_header(toinsert);
                            } else {
                                emit_main("    store i1 0, i1* %" + variable);
                                emit_main("    %" + variable + "_val" + counter + " = load i1, i1* %" + variable);
                            }
                            loads.add(new Loads(variable, counter, scope_actual));
                            counter++;
                            break;
                        default:
                            emit_main("    store i1 " + expression + ", i1* %" + variable);
                            break;
                    }
                    break;
                case "char":
                    int asciivalue = expression.charAt(1);
                    threeAddressCodeList.add(new ThreeAddressCode("store", "" + asciivalue, "char", variable));
                    threeAddressCodeList.add(new ThreeAddressCode("load", variable, "char", variable + "_val" + counter));
                    if (scope_actual != "global") {
                        emit_header("    store i8 " + asciivalue + ", i8* %" + variable);
                        emit_header("    %" + variable + "_val" + counter + " = load i8, i8* %" + variable);
                    } else {
                        emit_main("    store i8 " + asciivalue + ", i8* %" + variable);
                        emit_main("    %" + variable + "_val" + counter + " = load i8, i8* %" + variable);
                    }
//                    emit_main("    store i8 " + asciivalue + ", i8* %" + variable);
//                    emit_main("    %" + variable + "_val" + counter + " = load i8, i8* %" + variable);
                    loads.add(new Loads(variable, counter, scope_actual));
                    counter++;
                    break;
                case "string":

                    String currentTempString = generateTempStringVariable();
                    int stringLength = expression.length();
//                    stringLength--;
                    String textToPrepend = "" + currentTempString + " = private constant [" + stringLength + " x i8] c\"" + expression.substring(1, expression.length() - 1) + "\\00\"\n";

//                    llvmCode.insert(0, textToPrepend);
                    emit_header(textToPrepend);
//                emit("    store i8* getelementptr inbounds ([" + stringLength + " x i8], [" + stringLength + " x i8]* " + currentTempString + ", i32 0, i32 0), i8** %" + variable);
                    threeAddressCodeList.add(new ThreeAddressCode("store", currentTempString, "string", variable));
                    threeAddressCodeList.add(new ThreeAddressCode("load", variable, "string", variable + "_val" + counter));
                    if (scope_actual != "global") {
                        emit_header("    store i8* getelementptr inbounds ([" + stringLength + " x i8], [" + stringLength + " x i8]* " + currentTempString + ", i32 0, i32 0), i8** %" + variable);
                        emit_header("    %" + variable + "_val" + counter + " = load i8*, i8** %" + variable);
                    } else {
                        emit_main("    store i8* getelementptr inbounds ([" + stringLength + " x i8], [" + stringLength + " x i8]* " + currentTempString + ", i32 0, i32 0), i8** %" + variable);
                        emit_main("    %" + variable + "_val" + counter + " = load i8*, i8** %" + variable);
                    }
//                    emit_main("    store i8* getelementptr inbounds ([" + stringLength + " x i8], [" + stringLength + " x i8]* " + currentTempString + ", i32 0, i32 0), i8** %" + variable);
//                    emit_main("    %" + variable + "_val" + counter + " = load i8*, i8** %" + variable);
                    loads.add(new Loads(variable, counter, scope_actual));
                    counter++;
                    break;
            }

        } else { //childcount > 1
            String statementText = "";
            for (int i = 0; i < ctx.expression().simpleExpression().getChildCount(); i++) {
                statementText += ctx.expression().simpleExpression().getChild(i).getText() + " ";
            }


            System.out.println("  Asignacion Operacion: " + statementText);

            String[] expresionSplit = statementText.split(" ");
            String currentCounter = generateCondVariable();

            String variableEnUso = expresionSplit[0];
            String operador = expresionSplit[1];
            String valor = expresionSplit[2];

            // Verificar si la variable está definida en el ámbito actual
            if (!encontrarVariable(variable)) {
                System.err.println(" Error: La variable '" + variableEnUso + "' no está definida en el ámbito '" + scope_actual + "'.");
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

            // Validar el tipo de la expresión
            System.err.println("tipo de variable: " + tipoVariable);
            if (tipoVariable != null) {
                System.out.println(CYAN + expression + RESET);
//                if (!verificarValor(valor, tipoVariable)) { // Ahora se pasan dos parámetros
//                    System.err.println(" Error: El valor '" + valor + "' no es compatible con el tipo '" + tipoVariable + "' de la variable '" + variableEnUso + "'.");
//                } else {
                System.out.println("  Asignando el valor " + valor + " a la variable '" + variableEnUso + "' de tipo '" + tipoVariable + "'.");
                System.err.println("viendo si aca es el error");
                // Generar código LLVM para la asignación
                switch (tipoVariable.toLowerCase()) {
                    case "integer":
                        try {
                            generateThreeAddressCode(expression, "output3AC.txt", variable);
                            System.err.println(ThreeAddressCodeTemp);
                            generateLLVMFrom3AC(ThreeAddressCodeTemp);
                            ThreeAddressCodeTemp.clear();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
//                            loads.add(new Loads(variable, counter, scope_actual));
//                            for (int i = 0; i < loads.size(); i++) {
//                                System.err.println(loads.get(i).getVariable() + " " + loads.get(i).getCounter() + " " + loads.get(i).getScope());
//                            }
//                            counter++;
                        break;
                    case "boolean":
                        switch (valor) {
                            case "true":
                                threeAddressCodeList.add(new ThreeAddressCode("store", "1", "boolean", variableEnUso));
                                threeAddressCodeList.add(new ThreeAddressCode("load", variableEnUso, "boolean", variableEnUso + "_val" + counter));
                                emit_main("    store i1 1, i1* %" + variableEnUso);
                                emit_main("    %" + variableEnUso + "_val" + counter + " = load i1, i1* %" + variableEnUso);
                                loads.add(new Loads(variableEnUso, counter, scope_actual));
                                counter++;
                                break;
                            case "false":
                                threeAddressCodeList.add(new ThreeAddressCode("store", "0", "boolean", variableEnUso));
                                threeAddressCodeList.add(new ThreeAddressCode("load", variableEnUso, "boolean", variableEnUso + "_val" + counter));
                                emit_main("    store i1 0, i1* %" + variableEnUso);
                                emit_main("    %" + variableEnUso + "_val" + counter + " = load i1, i1* %" + variableEnUso);
                                loads.add(new Loads(variableEnUso, counter, scope_actual));
                                counter++;
                                break;
                            default:
                                emit_main("    store i1 " + valor + ", i1* %" + variableEnUso);
                                break;
                        }
                        break;
                    case "char":
                        int asciivalue = valor.charAt(1);
                        threeAddressCodeList.add(new ThreeAddressCode("store", "" + asciivalue, "char", variableEnUso));
                        threeAddressCodeList.add(new ThreeAddressCode("load", variableEnUso, "char", variableEnUso + "_val" + counter));

//                    }
                }
            } else {
                System.err.println(" Error: No se pudo determinar el tipo de la variable '" + variableEnUso + "'.");
            }
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
        if (ctx.relationaloperator() != null) {
            System.out.println("Operador Relacional: " + ctx.relationaloperator().getText());
            visit(ctx.expression()); // Visitar el nodo de la expresión
        }
        visit(ctx.simpleExpression()); // Visitar el nodo de la expresión simple
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
        if (ctx.expression().getChildCount() == 1) {
            for (int i = 0; i < ctx.expression().getChild(0).getChildCount(); i++) {
                statementText += ctx.expression().getChild(0).getChild(i).getText() + " ";
            }
        } else {
            for (int i = 0; i < ctx.expression().getChildCount(); i++) {
                statementText += ctx.expression().getChild(i).getText() + " ";
            }
        }

        System.out.println("  Condicion: " + statementText);

        String[] expresionSplit = statementText.split(" ");
        String currentCounter = generateCondVariable();

        if (expresionSplit.length == 1) {

            // aca arreglar detalle de cuando solo hay un argumento en el if
            String variable = expresionSplit[0];
            if (encontrarVariableEnLoads(variable)) {
                System.out.println("  Valor: " + variable + " es una variable definida.");

                for (Loads load : loads) {
                    if (load.getVariable().equals(variable)) {
                        threeAddressCodeList.add(new ThreeAddressCode("if", "then" + ifCounter, "else" + ifCounter, currentCounter));
                        emit_main("    br i1 %" + variable + "_val" + load.getCounter() + ", label %then" + ifCounter + ", label %else" + ifCounter);
                        break;
                    }
                }
            } else {
                System.err.println(" Error: La variable '" + variable + "' no está definida en el ámbito '" + scope_actual + "'.");
            }

        } else {

            String variable = expresionSplit[0];
            String operador = expresionSplit[1];
            String valor = expresionSplit[2];

            if (encontrarVariableEnLoads(valor)) {
                System.out.println("  Valor: " + valor + " es una variable definida.");

                switch (operador) {
                    case ">":
                        for (Loads load : loads) {
                            if (load.getVariable().equals(variable)) {
                                for (Loads load2 : loads) {
                                    if (load2.getVariable().equals(valor)) {
                                        threeAddressCodeList.add(new ThreeAddressCode(">", variable + "_val" + load.getCounter(), valor + "_val" + load2.getCounter(), currentCounter));
                                        emit_main("    %" + currentCounter + " = icmp sgt i32 %" + variable + "_val" + load.getCounter() + ", %" + valor + "_val" + load2.getCounter());
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
                                        threeAddressCodeList.add(new ThreeAddressCode("<", variable + "_val" + load.getCounter(), valor + "_val" + load2.getCounter(), currentCounter));
                                        emit_main("    %" + currentCounter + " = icmp slt i32 %" + variable + "_val" + load.getCounter() + ", %" + valor + "_val" + load2.getCounter());
                                        break;
                                    }
                                }
                            }
                        }
                        break;
                    case "=":
                        for (Loads load : loads) {
                            if (load.getVariable().equals(variable)) {
                                for (Loads load2 : loads) {
                                    if (load2.getVariable().equals(valor)) {
                                        threeAddressCodeList.add(new ThreeAddressCode("==", variable + "_val" + load.getCounter(), valor + "_val" + load2.getCounter(), currentCounter));
                                        emit_main("    %" + currentCounter + " = icmp eq i32 %" + variable + "_val" + load.getCounter() + ", %" + valor + "_val" + load2.getCounter());
                                        break;
                                    }
                                }
                            }
                        }
                        break;
                    case "<>":
                        for (Loads load : loads) {
                            if (load.getVariable().equals(variable)) {
                                for (Loads load2 : loads) {
                                    if (load2.getVariable().equals(valor)) {
                                        threeAddressCodeList.add(new ThreeAddressCode("!=", variable + "_val" + load.getCounter(), valor + "_val" + load2.getCounter(), currentCounter));
                                        emit_main("    %" + currentCounter + " = icmp ne i32 %" + variable + "_val" + load.getCounter() + ", %" + valor + "_val" + load2.getCounter());
                                        break;
                                    }
                                }
                            }
                        }
                        break;
                    case ">=":
                        for (Loads load : loads) {
                            if (load.getVariable().equals(variable)) {
                                for (Loads load2 : loads) {
                                    if (load2.getVariable().equals(valor)) {
                                        threeAddressCodeList.add(new ThreeAddressCode(">=", variable + "_val" + load.getCounter(), valor + "_val" + load2.getCounter(), currentCounter));
                                        emit_main("    %" + currentCounter + " = icmp sge i32 %" + variable + "_val" + load.getCounter() + ", %" + valor + "_val" + load2.getCounter());
                                        break;
                                    }
                                }
                            }
                        }
                        break;
                    case "<=":
                        for (Loads load : loads) {
                            if (load.getVariable().equals(variable)) {
                                for (Loads load2 : loads) {
                                    if (load2.getVariable().equals(valor)) {
                                        threeAddressCodeList.add(new ThreeAddressCode("<=", variable + "_val" + load.getCounter(), valor + "_val" + load2.getCounter(), currentCounter));
                                        emit_main("    %" + currentCounter + " = icmp sle i32 %" + variable + "_val" + load.getCounter() + ", %" + valor + "_val" + load2.getCounter());
                                        break;
                                    }
                                }
                            }
                        }
                        break;
                    case "and":
                        for (Loads load : loads) {
                            if (load.getVariable().equals(variable)) {
                                for (Loads load2 : loads) {
                                    if (load2.getVariable().equals(valor)) {
                                        threeAddressCodeList.add(new ThreeAddressCode("and", variable + "_val" + load.getCounter(), valor + "_val" + load2.getCounter(), currentCounter));
                                        emit_main("    %" + currentCounter + " = and i1 %" + variable + "_val" + load.getCounter() + ", %" + valor + "_val" + load2.getCounter());
                                        break;
                                    }
                                }
                            }
                        }
                        break;
                    case "or":
                        for (Loads load : loads) {
                            if (load.getVariable().equals(variable)) {
                                for (Loads load2 : loads) {
                                    if (load2.getVariable().equals(valor)) {
                                        threeAddressCodeList.add(new ThreeAddressCode("or", variable + "_val" + load.getCounter(), valor + "_val" + load2.getCounter(), currentCounter));
                                        emit_main("    %" + currentCounter + " = or i1 %" + variable + "_val" + load.getCounter() + ", %" + valor + "_val" + load2.getCounter());
                                        break;
                                    }
                                }
                            }
                        }
                        break;
                    case "not":
                        for (Loads load : loads) {
                            if (load.getVariable().equals(variable)) {
                                for (Loads load2 : loads) {
                                    if (load2.getVariable().equals(valor)) {
                                        threeAddressCodeList.add(new ThreeAddressCode("not", variable + "_val" + load.getCounter(), valor + "_val" + load2.getCounter(), currentCounter));
                                        emit_main("    %" + currentCounter + " = xor i1 %" + variable + "_val" + load.getCounter() + ", 1");
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
                                    threeAddressCodeList.add(new ThreeAddressCode(">", variable + "_val" + load.getCounter(), valor, currentCounter));
                                    emit_main("    %" + currentCounter + " = icmp sgt i32 %" + variable + "_val" + load.getCounter() + ", " + valor);
                                    break;
                                }
                            }
                            break;
                        case "<":
                            for (Loads load : loads) {
                                if (load.getVariable().equals(variable)) {
                                    threeAddressCodeList.add(new ThreeAddressCode("<", variable + "_val" + load.getCounter(), valor, currentCounter));
                                    emit_main("    %" + currentCounter + " = icmp slt i32 %" + variable + "_val" + load.getCounter() + ", " + valor);
                                    break;
                                }
                            }
                            break;
                        case "=":
                            for (Loads load : loads) {
                                if (load.getVariable().equals(variable)) {
                                    threeAddressCodeList.add(new ThreeAddressCode("==", variable + "_val" + load.getCounter(), valor, currentCounter));
                                    emit_main("    %" + currentCounter + " = icmp eq i32 %" + variable + "_val" + load.getCounter() + ", " + valor);
                                    break;
                                }
                            }
                            break;
                        case "<>":
                            for (Loads load : loads) {
                                if (load.getVariable().equals(variable)) {
                                    threeAddressCodeList.add(new ThreeAddressCode("!=", variable + "_val" + load.getCounter(), valor, currentCounter));
                                    emit_main("    %" + currentCounter + " = icmp ne i32 %" + variable + "_val" + load.getCounter() + ", " + valor);
                                    break;
                                }
                            }
                            break;
                        case ">=":
                            for (Loads load : loads) {
                                if (load.getVariable().equals(variable)) {
                                    threeAddressCodeList.add(new ThreeAddressCode(">=", variable + "_val" + load.getCounter(), valor, currentCounter));
                                    emit_main("    %" + currentCounter + " = icmp sge i32 %" + variable + "_val" + load.getCounter() + ", " + valor);
                                    break;
                                }
                            }
                            break;
                        case "<=":
                            for (Loads load : loads) {
                                if (load.getVariable().equals(variable)) {
                                    threeAddressCodeList.add(new ThreeAddressCode("<=", variable + "_val" + load.getCounter(), valor, currentCounter));
                                    emit_main("    %" + currentCounter + " = icmp sle i32 %" + variable + "_val" + load.getCounter() + ", " + valor);
                                    break;
                                }
                            }
                            break;
                        case "and":
                            for (Loads load : loads) {
                                if (load.getVariable().equals(variable)) {
                                    threeAddressCodeList.add(new ThreeAddressCode("and", variable + "_val" + load.getCounter(), valor, currentCounter));
                                    emit_main("    %" + currentCounter + " = and i1 %" + variable + "_val" + load.getCounter() + ", " + valor);
                                    break;
                                }
                            }
                            break;
                        case "or":
                            for (Loads load : loads) {
                                if (load.getVariable().equals(variable)) {
                                    threeAddressCodeList.add(new ThreeAddressCode("or", variable + "_val" + load.getCounter(), valor, currentCounter));
                                    emit_main("    %" + currentCounter + " = or i1 %" + variable + "_val" + load.getCounter() + ", " + valor);
                                    break;
                                }
                            }
                            break;
                        case "not":
                            for (Loads load : loads) {
                                if (load.getVariable().equals(variable)) {
                                    threeAddressCodeList.add(new ThreeAddressCode("not", variable + "_val" + load.getCounter(), valor, currentCounter));
                                    emit_main("    %" + currentCounter + " = xor i1 %" + variable + "_val" + load.getCounter() + ", 1");
                                    break;
                                }
                            }
                            break;
                    }

                } catch (NumberFormatException e) {
                    System.err.println("  Valor: " + valor + " no es una variable definida ni un número.");
                }
            }
            threeAddressCodeList.add(new ThreeAddressCode("if", "then" + ifCounter, "else" + ifCounter, currentCounter));
            emit_main("    br i1 %" + currentCounter + ", label %then" + ifCounter + ", label %else" + ifCounter);
        }

        threeAddressCodeList.add(new ThreeAddressCode("then", "then" + ifCounter, null, null));
        emit_main("then" + ifCounter + ":");
        visit(ctx.statement(0));
        threeAddressCodeList.add(new ThreeAddressCode("merge", "merge" + ifCounter, null, null));
        emit_main("    br label %merge" + ifCounter);

        System.out.println("  Hacer: " + ctx.statement(0).getText());
        if (ctx.ELSE() != null) {
            System.out.println("  Else: " + ctx.statement(1).getText());
            threeAddressCodeList.add(new ThreeAddressCode("else", "else" + ifCounter, null, null));
            emit_main("else" + ifCounter + ":");
            visit(ctx.statement(1));
            threeAddressCodeList.add(new ThreeAddressCode("merge", "merge" + ifCounter, null, null));
            emit_main("    br label %merge" + ifCounter);
        }
        threeAddressCodeList.add(new ThreeAddressCode("merge", "merge" + ifCounter, null, null));
        emit_main("merge" + ifCounter + ":");
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

        String statementText = "";
        if (ctx.expression().getChildCount() == 1) {
            for (int i = 0; i < ctx.expression().getChild(0).getChildCount(); i++) {
                statementText += ctx.expression().getChild(0).getChild(i).getText() + " ";
            }
        } else {
            for (int i = 0; i < ctx.expression().getChildCount(); i++) {
                statementText += ctx.expression().getChild(i).getText() + " ";
            }
        }

        threeAddressCodeList.add(new ThreeAddressCode("while", "label", "while_condition" + whileCounter, "br"));
        emit_main("br label %while_condition" + whileCounter);
        System.out.println("  Condicion: " + statementText);

        String[] expresionSplit = statementText.split(" ");
        String currentCounter = generateCondVariable();

        emit_main("while_condition" + whileCounter + ":");

        if (expresionSplit.length == 1) {

            // aca arreglar detalle de cuando solo hay un argumento en el if
            String variable = expresionSplit[0];
            if (encontrarVariableEnLoads(variable)) {
                System.out.println("  Valor: " + variable + " es una variable definida.");


            } else {
                System.err.println(" Error: La variable '" + variable + "' no está definida en el ámbito '" + scope_actual + "'.");
            }

        } else {

            String variable = expresionSplit[0];
            String operador = expresionSplit[1];
            String valor = expresionSplit[2];

            //mover linea del load a dentro del while aca
            for (Loads load : loads) {
                if (load.getVariable().equals(variable)) {
                    String lineToMove = "%" + variable + "_val" + load.getCounter() + " = load i32, i32* %" + variable;
                    String marker = "while_condition" + whileCounter + ":";

                    System.out.println("Line to move: " + lineToMove);
                    System.out.println("Marker: " + marker);

                    int lineIndex = llvmCode.indexOf(lineToMove);
                    int markerIndex = llvmCode.indexOf(marker);

                    System.out.println("Line index: " + lineIndex);
                    System.out.println("Marker index: " + markerIndex);

                    if (lineIndex != -1 && markerIndex != -1) {
                        // Remove the line from its original position
                        llvmCode.insert(markerIndex + marker.length(), "\n    " + lineToMove + "\n");
                        llvmCode.delete(lineIndex, lineIndex + lineToMove.length());

                        // Insert the line after the marker
                    } else {
                        System.out.println("Line or marker not found.");
                    }

                    break;
                }
            }


            if (encontrarVariableEnLoads(valor)) {
                System.out.println("  Valor: " + valor + " es una variable definida.");

                switch (operador) {
                    case ">":
                        for (Loads load : loads) {
                            if (load.getVariable().equals(variable)) {
                                for (Loads load2 : loads) {
                                    if (load2.getVariable().equals(valor)) {
                                        threeAddressCodeList.add(new ThreeAddressCode(">", variable + "_val" + load.getCounter(), valor + "_val" + load2.getCounter(), currentCounter));
                                        emit_main("    %" + currentCounter + " = icmp sgt i32 %" + variable + "_val" + load.getCounter() + ", %" + valor + "_val" + load2.getCounter());
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
                                        threeAddressCodeList.add(new ThreeAddressCode("<", variable + "_val" + load.getCounter(), valor + "_val" + load2.getCounter(), currentCounter));
                                        emit_main("    %" + currentCounter + " = icmp slt i32 %" + variable + "_val" + load.getCounter() + ", %" + valor + "_val" + load2.getCounter());
                                        break;
                                    }
                                }
                            }
                        }
                        break;
                    case "=":
                        for (Loads load : loads) {
                            if (load.getVariable().equals(variable)) {
                                for (Loads load2 : loads) {
                                    if (load2.getVariable().equals(valor)) {
                                        threeAddressCodeList.add(new ThreeAddressCode("==", variable + "_val" + load.getCounter(), valor + "_val" + load2.getCounter(), currentCounter));
                                        emit_main("    %" + currentCounter + " = icmp eq i32 %" + variable + "_val" + load.getCounter() + ", %" + valor + "_val" + load2.getCounter());
                                        break;
                                    }
                                }
                            }
                        }
                        break;
                    case "<>":
                        for (Loads load : loads) {
                            if (load.getVariable().equals(variable)) {
                                for (Loads load2 : loads) {
                                    if (load2.getVariable().equals(valor)) {
                                        threeAddressCodeList.add(new ThreeAddressCode("!=", variable + "_val" + load.getCounter(), valor + "_val" + load2.getCounter(), currentCounter));
                                        emit_main("    %" + currentCounter + " = icmp ne i32 %" + variable + "_val" + load.getCounter() + ", %" + valor + "_val" + load2.getCounter());
                                        break;
                                    }
                                }
                            }
                        }
                        break;
                    case ">=":
                        for (Loads load : loads) {
                            if (load.getVariable().equals(variable)) {
                                for (Loads load2 : loads) {
                                    if (load2.getVariable().equals(valor)) {
                                        threeAddressCodeList.add(new ThreeAddressCode(">=", variable + "_val" + load.getCounter(), valor + "_val" + load2.getCounter(), currentCounter));
                                        emit_main("    %" + currentCounter + " = icmp sge i32 %" + variable + "_val" + load.getCounter() + ", %" + valor + "_val" + load2.getCounter());
                                        break;
                                    }
                                }
                            }
                        }
                        break;
                    case "<=":
                        for (Loads load : loads) {
                            if (load.getVariable().equals(variable)) {
                                for (Loads load2 : loads) {
                                    if (load2.getVariable().equals(valor)) {
                                        threeAddressCodeList.add(new ThreeAddressCode("<=", variable + "_val" + load.getCounter(), valor + "_val" + load2.getCounter(), currentCounter));
                                        emit_main("    %" + currentCounter + " = icmp sle i32 %" + variable + "_val" + load.getCounter() + ", %" + valor + "_val" + load2.getCounter());
                                        break;
                                    }
                                }
                            }
                        }
                        break;
                    case "and":
                        for (Loads load : loads) {
                            if (load.getVariable().equals(variable)) {
                                for (Loads load2 : loads) {
                                    if (load2.getVariable().equals(valor)) {
                                        threeAddressCodeList.add(new ThreeAddressCode("and", variable + "_val" + load.getCounter(), valor + "_val" + load2.getCounter(), currentCounter));
                                        emit_main("    %" + currentCounter + " = and i1 %" + variable + "_val" + load.getCounter() + ", %" + valor + "_val" + load2.getCounter());
                                        break;
                                    }
                                }
                            }
                        }
                        break;
                    case "or":
                        for (Loads load : loads) {
                            if (load.getVariable().equals(variable)) {
                                for (Loads load2 : loads) {
                                    if (load2.getVariable().equals(valor)) {
                                        threeAddressCodeList.add(new ThreeAddressCode("or", variable + "_val" + load.getCounter(), valor + "_val" + load2.getCounter(), currentCounter));
                                        emit_main("    %" + currentCounter + " = or i1 %" + variable + "_val" + load.getCounter() + ", %" + valor + "_val" + load2.getCounter());
                                        break;
                                    }
                                }
                            }
                        }
                        break;
                    case "not":
                        for (Loads load : loads) {
                            if (load.getVariable().equals(variable)) {
                                for (Loads load2 : loads) {
                                    if (load2.getVariable().equals(valor)) {
                                        threeAddressCodeList.add(new ThreeAddressCode("not", variable + "_val" + load.getCounter(), valor + "_val" + load2.getCounter(), currentCounter));
                                        emit_main("    %" + currentCounter + " = xor i1 %" + variable + "_val" + load.getCounter() + ", 1");
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
                                    threeAddressCodeList.add(new ThreeAddressCode(">", variable + "_val" + load.getCounter(), valor, currentCounter));
                                    emit_main("    %" + currentCounter + " = icmp sgt i32 %" + variable + "_val" + load.getCounter() + ", " + valor);
                                    break;
                                }
                            }
                            break;
                        case "<":
                            for (Loads load : loads) {
                                if (load.getVariable().equals(variable)) {
                                    threeAddressCodeList.add(new ThreeAddressCode("<", variable + "_val" + load.getCounter(), valor, currentCounter));
                                    emit_main("    %" + currentCounter + " = icmp slt i32 %" + variable + "_val" + load.getCounter() + ", " + valor);
                                    break;
                                }
                            }
                            break;
                        case "=":
                            for (Loads load : loads) {
                                if (load.getVariable().equals(variable)) {
                                    threeAddressCodeList.add(new ThreeAddressCode("==", variable + "_val" + load.getCounter(), valor, currentCounter));
                                    emit_main("    %" + currentCounter + " = icmp eq i32 %" + variable + "_val" + load.getCounter() + ", " + valor);
                                    break;
                                }
                            }
                            break;
                        case "<>":
                            for (Loads load : loads) {
                                if (load.getVariable().equals(variable)) {
                                    threeAddressCodeList.add(new ThreeAddressCode("!=", variable + "_val" + load.getCounter(), valor, currentCounter));
                                    emit_main("    %" + currentCounter + " = icmp ne i32 %" + variable + "_val" + load.getCounter() + ", " + valor);
                                    break;
                                }
                            }
                            break;
                        case ">=":
                            for (Loads load : loads) {
                                if (load.getVariable().equals(variable)) {
                                    threeAddressCodeList.add(new ThreeAddressCode(">=", variable + "_val" + load.getCounter(), valor, currentCounter));
                                    emit_main("    %" + currentCounter + " = icmp sge i32 %" + variable + "_val" + load.getCounter() + ", " + valor);
                                    break;
                                }
                            }
                            break;
                        case "<=":
                            for (Loads load : loads) {
                                if (load.getVariable().equals(variable)) {
                                    threeAddressCodeList.add(new ThreeAddressCode("<=", variable + "_val" + load.getCounter(), valor, currentCounter));
                                    emit_main("    %" + currentCounter + " = icmp sle i32 %" + variable + "_val" + load.getCounter() + ", " + valor);
                                    break;
                                }
                            }
                            break;
                        case "and":
                            for (Loads load : loads) {
                                if (load.getVariable().equals(variable)) {
                                    threeAddressCodeList.add(new ThreeAddressCode("and", variable + "_val" + load.getCounter(), valor, currentCounter));
                                    emit_main("    %" + currentCounter + " = and i1 %" + variable + "_val" + load.getCounter() + ", " + valor);
                                    break;
                                }
                            }
                            break;
                        case "or":
                            for (Loads load : loads) {
                                if (load.getVariable().equals(variable)) {
                                    threeAddressCodeList.add(new ThreeAddressCode("or", variable + "_val" + load.getCounter(), valor, currentCounter));
                                    emit_main("    %" + currentCounter + " = or i1 %" + variable + "_val" + load.getCounter() + ", " + valor);
                                    break;
                                }
                            }
                            break;
                        case "not":
                            for (Loads load : loads) {
                                if (load.getVariable().equals(variable)) {
                                    threeAddressCodeList.add(new ThreeAddressCode("not", variable + "_val" + load.getCounter(), valor, currentCounter));
                                    emit_main("    %" + currentCounter + " = xor i1 %" + variable + "_val" + load.getCounter() + ", 1");
                                    break;
                                }
                            }
                            break;
                    }

                } catch (NumberFormatException e) {
                    System.err.println("  Valor: " + valor + " no es una variable definida ni un número.");
                }
            }
            threeAddressCodeList.add(new ThreeAddressCode("while", "do" + whileCounter, "else" + whileCounter, currentCounter));
            emit_main("    br i1 %" + currentCounter + ", label %while_body" + whileCounter + ", label %while_end" + whileCounter);
        }

        threeAddressCodeList.add(new ThreeAddressCode("do", "while_body" + whileCounter, null, null));
        emit_main("while_body" + whileCounter + ":");

        //while body
//        if (/* condition to recognize another statement */) {
//            String condVar = generateCondVariable();
//            emit("    %" + condVar + " = icmp slt i32 %i_val1, 3");
//            emit("    br i1 %" + condVar + ", label %then" + whileCounter + ", label %else" + whileCounter);
//        }
        visit(ctx.statement());


        emit_main("    br label %while_condition" + whileCounter);
        threeAddressCodeList.add(new ThreeAddressCode("end", "while_end" + whileCounter, null, null));
        emit_main("while_end" + whileCounter + ":");
        whileCounter++;
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
        allHeader += "@buffer = global [256 x i8] zeroinitializer\n@str_fmt = unnamed_addr constant [4 x i8] c\"%d\\0A\\00\"\n";
        allHeader += "@stdin = external global %struct._IO_FILE*\n";
        allHeader += "@double_fmt = private unnamed_addr constant [4 x i8] c\"%f\\0A\\00\"\n";
        allHeader += "@char_fmt = private unnamed_addr constant [4 x i8] c\"%c\\0A\\00\"\n";


//        llvmCode.insert(0, allHeader);
//        emit_header(allHeader);
        header.insert(0, allHeader);
    }


    public void Footer() {
        // End of the program
        emit_main("  ret i32 0\n}\n");

        // write_int function for printing integers
        emit_main("define void @write_int(i32 %num) {");
//        System.out.println("    %buf = alloca [32 x i8], align 1");
//        System.out.println("    %buf_ptr = getelementptr inbounds [32 x i8], [32 x i8]* %buf, i32 0, i32 0");
//        System.out.println("    call i32 (i8*, i8*, ...) @printf(i8* %buf_ptr, i8* getelementptr inbounds ([4 x i8], [4 x i8]* @str_fmt, i32 0, i32 0), i32 %num)");
//        System.out.println("    call i32 @puts(i8* %buf_ptr)");
        emit_main("    call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @str_fmt, i32 0, i32 0), i32 %num)");
        emit_main("    ret void");
        emit_main("}\n");

        // write_char function for printing single chars
        emit_main("define void @write_char(i8 %char) {");
        emit_main("    call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @char_fmt, i32 0, i32 0), i8 %char)");
        emit_main("    ret void");
        emit_main("}");


        // write_string function for printing strings
        emit_main("define void @write_string(i8* %str) {");
//        System.out.println("    %str_ptr = alloca i8*");
//        System.out.println("    store i8* %str, i8** %str_ptr");
//        System.out.println("    %str_val = load i8*, i8** %str_ptr");
        emit_main("    call i32 @puts(i8* %str)");
        emit_main("    ret void");
        emit_main("}\n");

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
        emit_main("declare i32 @atoi(i8*)");
        emit_main("declare i32 @sprintf(i8*, i8*, ...)");
        emit_main("declare i32 @puts(i8*)");
        emit_main("declare i8* @fgets(i8*, i32, %struct._IO_FILE*)");
        emit_main("declare void @exit(i32)\n");

// Footer
        emit_main("; Function Attrs: noinline nounwind optnone uwtable");
        emit_main("declare i32 @printf(i8*, ...) #0");
        emit_main("attributes #0 = { noinline nounwind optnone uwtable \"correctly-rounded-divide-sqrt-fp-math\"=\"false\" \"disable-tail-calls\"=\"false\" \"frame-pointer\"=\"all\" \"less-precise-fpmad\"=\"false\" \"min-legal-vector-width\"=\"0\" \"no-infs-fp-math\"=\"false\" \"no-jump-tables\"=\"false\" \"no-nans-fp-math\"=\"false\" \"no-signed-zeros-fp-math\"=\"false\" \"no-trapping-math\"=\"false\" \"stack-protector-buffer-size\"=\"8\" \"target-cpu\"=\"x86-64\" \"target-features\"=\"+cx8,+fxsr,+mmx,+sse,+sse2,+x87\" \"unsafe-fp-math\"=\"false\" \"use-soft-float\"=\"false\" }");
        emit_main("!llvm.module.flags = !{!0}\n");
        emit_main("!llvm.ident = !{!1}");
        emit_main("!0 = !{i32 1, !\"wchar_size\", i32 4}");
        emit_main("!1 = !{!\"clang version 10.0.0-4ubuntu1 \"}\n");
    }


}