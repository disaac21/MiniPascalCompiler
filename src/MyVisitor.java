import org.antlr.runtime.BitSet;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Stack;
import javax.swing.JOptionPane;

public class MyVisitor extends MiniPascalGrammarBaseVisitor<Object> {

    private boolean scanfdeclared = false;
    private boolean intformatdeclared = false;
    private boolean charformatdeclared = false;
    private boolean stringformatdeclared = false;
    private static ArrayList<String> ThreeAddressCodeTemp = new ArrayList<>();
    public static ArrayList<ThreeAddressCode> threeAddressCodeList = new ArrayList<ThreeAddressCode>();


    public static final String CYAN = "\u001B[36m";
    public static final String RESET = "\u001B[0m";

    private int tempCounter = 1;  // Contador de variables temporales
    private static int counter = 1;
    private static ArrayList<Loads> loads = new ArrayList<Loads>();

    private static StringBuilder header = new StringBuilder();
    static StringBuilder llvmCode = new StringBuilder();

    public static StringBuilder TACHeader = new StringBuilder();
    public static StringBuilder TACCode = new StringBuilder();

    public static String analyzeString(String input) {
        if (Character.isLetter(input.charAt(0))) {
            for (int i = 0; i < TablaSimbolos.size(); i++) {
                if (TablaSimbolos.get(i).getNombre().equals(input)) {
                    return (TablaSimbolos.get(i).getTipo());
                }
            }
        } else if (input.matches("\\d+")) {
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
        return input;
    }

    public static void llamado_a_funcion(String expression, String variable) {
        JOptionPane.showMessageDialog(null, "Es funcion");
        System.out.println(CYAN + "IS FUNCTION" + RESET);
        String nombre_funcion = expression.substring(0, expression.indexOf("("));
        System.out.println(CYAN + "NOMBRE DE LA FUNCION: " + nombre_funcion + RESET);
        String tipo_funcion = "";
        for (int i = 0; i < TablaSimbolos.size(); i++) {
            if (TablaSimbolos.get(i).getNombre().equals(nombre_funcion)) {
                tipo_funcion = TablaSimbolos.get(i).getTipo();
            }
        }

        String parametros = expression.substring(expression.indexOf("(") + 1, expression.indexOf(")"));
        //                        ArrayList<Parametros> parametrosList = new ArrayList<>();
        String[] paramGroups = parametros.split(","); // sacando los parametros
        StringBuilder mensaje = new StringBuilder();

        mensaje.delete(0, mensaje.length());
        switch (tipo_funcion.toLowerCase()) {
            case "integer":
                mensaje.append("    %" + variable + "_val" + counter + " = call i32 @" + nombre_funcion + "(");
                emit3AC_main(variable + "_val" + counter + " = call integer @" + nombre_funcion + "()");
                break;
            case "boolean":
                mensaje.append("    %" + variable + "_val" + counter + " = call i1 @" + nombre_funcion + "(");
                emit3AC_main(variable + "_val" + counter + " = call boolean @" + nombre_funcion + "()");
                break;
            case "char":
                mensaje.append("    %" + variable + "_val" + counter + " = call i8 @" + nombre_funcion + "(");
                emit3AC_main(variable + "_val" + counter + " = call char @" + nombre_funcion + "()");
                break;
            case "void":
                mensaje.append("    call void @" + nombre_funcion + "(");
                emit_main("call void @" + nombre_funcion + "()");
                break;
        }
//        mensaje.append("    %" + variable + "_val" + counter + " = call i32 @" + nombre_funcion + "(");
        if (!variable.equals("")) {
            loads.add(new Loads(variable, counter, scope_actual));
            counter++;
        }

        for (int i = 0; i < paramGroups.length; i++) {
            System.out.println(CYAN + "PARAMETRO: " + paramGroups[i] + RESET);
            JOptionPane.showMessageDialog(null, "PARAMETRO: " + paramGroups[i]);
            switch (analyzeString(paramGroups[i])) {
                case "integer":
                    if (Character.isLetter(paramGroups[i].charAt(0))) {
                        Loads tempLoad = lastLoad(paramGroups[i]);
                        mensaje.append("i32 " + "%" + tempLoad.getVariable() + "_val" + tempLoad.getCounter());
                        emit3AC_main(tempLoad.getVariable() + "_val" + tempLoad.getCounter() + " = " + "load" + " i32, " + tempLoad.getVariable());
                    } else {
                        mensaje.append("i32 " + paramGroups[i]);
                        emit3AC_main(paramGroups[i] + " = " + "load" + " i32, " + paramGroups[i]);
                    }
//                    mensaje.append("i32 " + paramGroups[i]);
                    break;
                case "char":
                    if (Character.isLetter(paramGroups[i].charAt(0))) {
                        Loads tempLoad = lastLoad(paramGroups[i]);
                        mensaje.append("i8 " + "%" + tempLoad.getVariable() + "_val" + tempLoad.getCounter());
                        emit3AC_main(tempLoad.getVariable() + "_val" + tempLoad.getCounter() + " = " + "load" + " i8, " + tempLoad.getVariable());
                    } else {
                        int caracterascii = paramGroups[i].charAt(1);
                        mensaje.append("i8 " + caracterascii);
                        emit3AC_main(paramGroups[i] + " = " + "load" + " i8, " + caracterascii);
                    }
//                    mensaje.append("i8 " + caracterascii);
                    break;
                case "string":
                    emit_header("@cadena" + counter + " = private constant [" + (paramGroups[i].length() - 1) + " x i8] c\"" + paramGroups[i].substring(1, paramGroups[i].length() - 1) + "\\00\"");
                    emit3AC_header("@cadena" + counter + " = constant" + paramGroups[i].substring(1, paramGroups[i].length() - 1) + " ");
                    emit_main("%ptr_cadena" + counter + " = bitcast [" + (paramGroups[i].length() - 1) + " x i8]* @cadena" + counter + " to i8*");
                    emit3AC_main("%ptr_cadena" + counter + " = " + (paramGroups[i].length() - 1));
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


    public static void generateThreeAddressCode(String expression, String outputFileName, String finalVarName) throws IOException {
        // Eliminar espacios innecesarios
        expression = expression.replaceAll("\\s+", "");
        System.out.println(CYAN + "Expresión: " + expression + RESET);

        // Convertir la expresión a notación postfija (RPN) respetando la precedencia
        String postfix = infixToPostfix(expression);

        JOptionPane.showMessageDialog(null, "Expresion: " + expression + "\nPostfix: " + postfix);
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
                    if (scope_actual.equals("global")) {

                        emit_main(String.format("store i32 %s, i32* %%%s", value, result));


//
//                        ThreeAddressCodeList.add(new ThreeAddressCode("store", "i32", value, result));
//


                    } else
                        emit_header(String.format("store i32 %s, i32* %%%s", value, result));
                } else {
                    if (scope_actual.equals("global")) {
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
                    if (scope_actual.equals("global"))
                        emit_main("%" + tempVar + " = " + llvmOp + " i32 " + op1 + ", " + op2);
                    else
                        emit_header("%" + tempVar + " = " + llvmOp + " i32 " + op1 + ", " + op2);
                } else if (isNumeric(op1)) {
                    if (scope_actual.equals("global"))
                        emit_main("%" + tempVar + " = " + llvmOp + " i32 " + op1 + ", %" + op2);
                    else
                        emit_header("%" + tempVar + " = " + llvmOp + " i32 " + op1 + ", %" + op2);
                } else if (isNumeric(op2)) {
                    if (scope_actual.equals("global"))
                        emit_main("%" + tempVar + " = " + llvmOp + " i32 %" + op1 + ", " + op2);
                    else
                        emit_header("%" + tempVar + " = " + llvmOp + " i32 %" + op1 + ", " + op2);
                } else {
                    if (scope_actual.equals("global"))
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

                if (scope_actual.equals("global"))
                    emit_main(String.format("%%%s = call i32 @%s()\n", tempVar, functionName));
                else
                    emit_header(String.format("%%%s = call i32 @%s()\n", tempVar, functionName));
            }
        }

//            writer.write("\n; Fin del código LLVM\n");
    }


    private static void emit_main(String line) {
        llvmCode.append(line).append("\n");
    }

    private static void emit_header(String line) {
        header.append(line).append("\n");
    }

    private static void emit3AC_main(String line) {
        TACCode.append(line).append("\n");
    }

    private static void emit3AC_header(String line) {
        TACHeader.append(line).append("\n");
    }


    public void writell() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("output.ll"))) {
            System.out.println(CYAN + "\n\n\n\n\n" + header.toString() + RESET);
            writer.write(header.toString());
            writer.write(llvmCode.toString());
            loads.clear();
            TablaSimbolos.clear();
            threeAddressCodeList.clear();
            ThreeAddressCodeTemp.clear();
            header.delete(0, header.length());
            llvmCode.delete(0, llvmCode.length());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void write3ac() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("output3AC.txt"))) {
//            System.out.println(CYAN + "\n\n\n\n\n" + header.toString() + RESET);
            writer.write(TACHeader.toString());
            writer.write(TACCode.toString());
//            loads.clear();
//            TablaSimbolos.clear();
//            threeAddressCodeList.clear();
            ;
//            ThreeAddressCodeTemp.clear();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static ArrayList<Binding> TablaSimbolos = new ArrayList<>();
    private static String scope_actual = "global";

    public void imprimirTablaSimbolos() {
        System.out.println(CYAN + " ------- Tabla de Simbolos ------- ");
        for (Binding binding : TablaSimbolos) {
            System.out.println(binding);
        }
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

        if (valor.contains("(") && valor.contains(")")) {
            String[] parts = valor.split("\\(");
            String functionName = parts[0];
            for (int i = 0; i < TablaSimbolos.size(); i++) {
                if (TablaSimbolos.get(i).getNombre().equals(functionName)) {
                    if (TablaSimbolos.get(i).getTipo().equalsIgnoreCase(tipoEsperado.toLowerCase())) {
                        return true;
                    } else {
                        return false;
                    }
                }
            }
            return false;
        }
        if (valor.equalsIgnoreCase("true") || valor.equalsIgnoreCase("false")) {
            if (tipoEsperado.equalsIgnoreCase("boolean")) {
                return true;
            } else {
                return false;
            }
        }
        if (isNumeric(valor.charAt(0) + "")) {
            if (tipoEsperado.equalsIgnoreCase("integer")) {
                return true;
            } else {
                return false;
            }

        }
        if (valor.charAt(0) == '\'' && valor.charAt(2) == '\'') {
            if (tipoEsperado.equalsIgnoreCase("char")) {
                return true;
            } else {
                return false;
            }
        }
        if (valor.length() >= 4 && valor.charAt(0) == '\'' && valor.charAt(valor.length() - 1) == '\'') {
            if (tipoEsperado.toLowerCase().equals("string")) {
                return true;
            } else {
                return false;
            }
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
        visit(ctx.programHeading());
        emit_main("\ndefine i32 @main() {");
        visit(ctx.block());
        Footer();
        Header(ctx.programHeading());
        return null;
    }

    public Object visitProgramHeading(MiniPascalGrammarParser.ProgramHeadingContext ctx) {
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
        for (MiniPascalGrammarParser.ConstantDefinitionContext varDeclCtx : ctx.constantDefinition()) {
            visit(varDeclCtx);
        }
        return null;
    }

    @Override
    public Object visitConstantDefinition(MiniPascalGrammarParser.ConstantDefinitionContext ctx) {
        MiniPascalGrammarParser.IdentifierContext idCtx = ctx.identifier();
        MiniPascalGrammarParser.ConstantContext typeCtx = ctx.constant();

        String tipo = "";
        if (typeCtx.getText().charAt(0) == '\'' && typeCtx.getText().charAt(2) == '\'') {
            tipo = "char";
        } else if (typeCtx.getText().equals("true") || typeCtx.getText().equals("false")) {
            tipo = "boolean";
        } else if (typeCtx.getText().matches("-?\\d+")) {
            tipo = "integer";
        } else if (typeCtx.getText().charAt(0) == '\'') {
            tipo = "string";
        } else {
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
        return null;
    }

    @Override
    public Object visitArrayType(MiniPascalGrammarParser.ArrayTypeContext ctx) {
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
        return null;
    }

    @Override
    public Object visitCharR_(MiniPascalGrammarParser.CharR_Context ctx) {
        return null;
    }

    @Override
    public Object visitIntegerR_(MiniPascalGrammarParser.IntegerR_Context ctx) {
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
        return null;
    }

    @Override
    public Object visitString(MiniPascalGrammarParser.StringContext ctx) {

        return null;
    }

    @Override
    public Object visitBoolean(MiniPascalGrammarParser.BooleanContext ctx) {

        return null;
    }

    @Override
    public Object visitChar(MiniPascalGrammarParser.CharContext ctx) {

        return null;
    }

    @Override
    public Object visitInteger(MiniPascalGrammarParser.IntegerContext ctx) {

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

        for (MiniPascalGrammarParser.VariableDeclarationContext varDeclCtx : ctx.variableDeclaration()) {
            visit(varDeclCtx);
        }
        return null;
    }

    @Override
    public Object visitVariableDeclaration(MiniPascalGrammarParser.VariableDeclarationContext ctx) {

        MiniPascalGrammarParser.IdentifierListContext idListCtx = ctx.identifierList();
        MiniPascalGrammarParser.TypeIdentifierContext typeCtx = ctx.typeIdentifier();
        MiniPascalGrammarParser.ArrayTypeContext arrayTypeCtx = ctx.arrayType();
        if (idListCtx != null && typeCtx != null) {

            StringBuilder identifiers = new StringBuilder();
            List<MiniPascalGrammarParser.IdentifierContext> idNodes = idListCtx.identifier();
            for (int i = 0; i < idNodes.size(); i++) {
                identifiers.append(idNodes.get(i).getText());
                if (i < idNodes.size() - 1) {
                    identifiers.append(", ");
                }

                Binding binding = new Binding(idNodes.get(i).getText(), typeCtx.getText(), scope_actual);
                if (!encontrarVariable(binding.getNombre())) {
                    TablaSimbolos.add(binding);
                    String variableName = binding.getNombre();
                    String variableType = binding.getTipo();
                    switch (variableType.toLowerCase()) {
                        case "integer":
                            threeAddressCodeList.add(new ThreeAddressCode("alloca", "i32", null, variableName));
                            if (scope_actual.equals("global")) {
                                emit_main("    %" + variableName + " = alloca i32");
                                emit3AC_main(variableName + " = " + "alloca" + " i32");
                            } else {
                                emit_header("    %" + variableName + " = alloca i32");
                                emit3AC_header(variableName + " = " + "alloca" + " i32");
                            }
                            break;
                        case "boolean":
                            threeAddressCodeList.add(new ThreeAddressCode("alloca", "i1", null, variableName));
                            if (scope_actual.equals("global")) {
                                emit_main("    %" + variableName + " = alloca i1");
                                emit3AC_main(variableName + " = " + "alloca" + " i1");
                            } else {
                                emit_header("    %" + variableName + " = alloca i1");
                                emit3AC_header(variableName + " = " + "alloca" + " i1");
                            }
                            break;
                        case "char":
                            threeAddressCodeList.add(new ThreeAddressCode("alloca", "i8", null, variableName));
                            if (scope_actual.equals("global")) {
                                emit_main("    %" + variableName + " = alloca i8");
                                emit3AC_main(variableName + " = " + "alloca" + " i8");
                            } else {
                                emit_header("    %" + variableName + " = alloca i8");
                                emit3AC_header(variableName + " = " + "alloca" + " i8");
                            }
                            break;
                        case "string":
                            threeAddressCodeList.add(new ThreeAddressCode("alloca", "i8*", null, variableName));
                            if (scope_actual.equals("global")) {
                                emit_main("    %" + variableName + " = alloca i8*");
                                emit3AC_main(variableName + " = " + "alloca" + " i8*");
                            } else {
                                emit_header("    %" + variableName + " = alloca i8*");
                                emit3AC_header(variableName + " = " + "alloca" + " i8*");
                            }
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
                    JOptionPane.showMessageDialog(null, "Error: La variable \'" + binding.getNombre() + "\' ya ha sido declarada en el scope \'" + scope_actual + "\'");
//                    System.exit(1);
                    //aca hay que hacer que el programa no siga
                }
            }
        }
        if (idListCtx != null && arrayTypeCtx != null) {

            if (arrayTypeCtx.indexRanges().getText().contains(",")) {

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


            } else {

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
            }
        }
        return null;
    }

    @Override
    public Object visitProcedureAndFunctionDeclarationPart
            (MiniPascalGrammarParser.ProcedureAndFunctionDeclarationPartContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitProcedureOrFunctionDeclaration(MiniPascalGrammarParser.ProcedureOrFunctionDeclarationContext
                                                              ctx) {
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
        }
        return null;
    }

    @Override
    public Object visitIdentifierList(MiniPascalGrammarParser.IdentifierListContext ctx) {
        for (MiniPascalGrammarParser.IdentifierContext ctx2 : ctx.identifier()) {
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

        String functionName = ctx.identifier().getText();
        String returnType = ctx.varType().getText();

        // Agregar la función a la tabla de símbolos


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
        StringBuilder definicionFuncion = new StringBuilder();
        switch (returnType.toLowerCase()) {
            case "integer":
                definicionFuncion.append("define i32 @" + functionName + "(");
                emit3AC_header(functionName + " = " + "define" + " i32");
                break;
            case "boolean":
                definicionFuncion.append("define i1 @" + functionName + "(");
                emit3AC_header(functionName + " = " + "define" + " i1");
                break;
            case "char":
                definicionFuncion.append("define i8 @" + functionName + "(");
                break;
            case "string":
                break;
        }
        for (int i = 0; i < parametrosList.size(); i++) {
            switch (parametrosList.get(i).getTipo().toLowerCase()) {
                case "integer":
                    definicionFuncion.append("i32 %cont_" + parametrosList.get(i).getVariable());
                    emit3AC_header("%cont_" + parametrosList.get(i).getVariable() + " = param i32");
                    if (i < parametrosList.size() - 1) {
                        definicionFuncion.append(", ");
                    }
                    break;
                case "boolean":
                    definicionFuncion.append("i1 %cont_" + parametrosList.get(i).getVariable());
                    emit3AC_header("%cont_" + parametrosList.get(i).getVariable() + " = param i1");
                    if (i < parametrosList.size() - 1) {
                        definicionFuncion.append(", ");
                    }
                    break;
                case "char":
                    definicionFuncion.append("i8 %cont_" + parametrosList.get(i).getVariable());
                    emit3AC_header("%cont_" + parametrosList.get(i).getVariable() + " = param i8");
                    if (i < parametrosList.size() - 1) {
                        definicionFuncion.append(", ");
                    }
                    break;
                case "string":
                    definicionFuncion.append("i8* %cont_" + parametrosList.get(i).getVariable());
                    emit3AC_header("%cont_" + parametrosList.get(i).getVariable() + " = param i8*");
                    if (i < parametrosList.size() - 1) {
                        definicionFuncion.append(", ");
                    }
                    break;
            }
        }
        definicionFuncion.append(") {\n" +
                "entry:\n");
        switch (returnType.toLowerCase()) {
            case "integer":
                definicionFuncion.append("    %" + functionName + " = alloca i32\n");
                break;
            case "boolean":
                definicionFuncion.append("    %" + functionName + " = alloca i1\n");
                break;
            case "char":
                definicionFuncion.append("    %" + functionName + " = alloca i8\n");
                break;

        }


        for (int i = 0; i < parametrosList.size(); i++) {// aca tengo que trabajar
            switch (parametrosList.get(i).getTipo().toLowerCase()) {
                case "integer":
                    definicionFuncion.append("    %" + parametrosList.get(i).getVariable() + " = alloca i32\n");
                    emit3AC_header("%" + parametrosList.get(i).getVariable() + " = alloca i32");
                    definicionFuncion.append("    store i32 %cont_" + parametrosList.get(i).getVariable() + ", i32* %" + parametrosList.get(i).getVariable() + "\n");
                    emit3AC_header("%cont_" + parametrosList.get(i).getVariable() + " = " + "store" + " i32" + " %cont_" + parametrosList.get(i).getVariable());
                    definicionFuncion.append("    %" + parametrosList.get(i).getVariable() + "_val" + counter + " = load i32, i32* %" + parametrosList.get(i).getVariable() + "\n");
                    emit3AC_header("%" + parametrosList.get(i).getVariable() + "_val" + counter + " = " + "load" + " i32");
                    loads.add(new Loads(parametrosList.get(i).getVariable(), counter, scope_actual));
                    counter++;
                    break;
                case "boolean":
                    definicionFuncion.append("    %" + parametrosList.get(i).getVariable() + " = alloca i1\n");
                    definicionFuncion.append("    store i1 %cont_" + parametrosList.get(i).getVariable() + ", i1* %" + parametrosList.get(i).getVariable() + "\n");
                    definicionFuncion.append("    %" + parametrosList.get(i).getVariable() + "_val" + counter + " = load i1, i1* %" + parametrosList.get(i).getVariable() + "\n");
                    loads.add(new Loads(parametrosList.get(i).getVariable(), counter, scope_actual));
                    counter++;
                    break;
                case "char":
                    definicionFuncion.append("    %" + parametrosList.get(i).getVariable() + " = alloca i8\n");
                    definicionFuncion.append("    store i8 %cont_" + parametrosList.get(i).getVariable() + ", i8* %" + parametrosList.get(i).getVariable() + "\n");
                    definicionFuncion.append("    %" + parametrosList.get(i).getVariable() + "_val" + counter + " = load i8, i8* %" + parametrosList.get(i).getVariable() + "\n");
                    loads.add(new Loads(parametrosList.get(i).getVariable(), counter, scope_actual));
                    counter++;
                    break;
                case "string":
                    break;
            }
        }


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
//                for (int j = 0; j < loads.size(); j++) {
//                    if (loads.get(j).getVariable().equals(functionName)) {
//                        emit_header("    ret i32 %" + loads.get(j).getVariable() + "_val" + loads.get(j).getCounter() + "\n}\n");
//                    }
//                }
                Loads tempload1 = lastLoad(functionName);
                emit_header("    ret i32 %" + functionName + "_val" + tempload1.getCounter() + "\n}\n");
//                emit3AC_header(loads.get(j).getVariable() + "_val" + loads.get(j).getCounter() + " = " + "ret" + " i32"); //juntar esta line en el merge
                break;
            case "boolean":
                Loads tempload = lastLoad(functionName);
                emit_header("    ret i1 %" + functionName + "_val" + tempload.getCounter() + "\n}\n");
                emit3AC_header(functionName + "_val" + tempload.getCounter() + " = " + "ret" + " i1");
                break;
            case "char":
                Loads tempload2 = lastLoad(functionName);
                emit_header("    ret i8 %" + functionName + "_val" + tempload2.getCounter() + "\n}\n");
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
        StringBuilder definicionFuncion = new StringBuilder();
        definicionFuncion.append("define void @" + ctx.identifier().getText() + "(");

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


        for (int i = 0; i < parametrosList.size(); i++) {
            switch (parametrosList.get(i).getTipo().toLowerCase()) {
                case "integer":
                    definicionFuncion.append("i32 %cont_" + parametrosList.get(i).getVariable());
                    if (i < parametrosList.size() - 1) {
                        definicionFuncion.append(", ");
                    }
                    break;
                case "boolean":
                    definicionFuncion.append("i1 %cont_" + parametrosList.get(i).getVariable());
                    if (i < parametrosList.size() - 1) {
                        definicionFuncion.append(", ");
                    }
                    break;
                case "char":
                    definicionFuncion.append("i8 %cont_" + parametrosList.get(i).getVariable());
                    if (i < parametrosList.size() - 1) {
                        definicionFuncion.append(", ");
                    }
                    break;
                case "string":
                    definicionFuncion.append("i8* %cont_" + parametrosList.get(i).getVariable());
                    if (i < parametrosList.size() - 1) {
                        definicionFuncion.append(", ");
                    }
                    break;
            }
        }

        definicionFuncion.append(") {\n" +
                "entry:\n");

        for (int i = 0; i < parametrosList.size(); i++) {
            switch (parametrosList.get(i).getTipo().toLowerCase()) {
                case "integer":
                    definicionFuncion.append("    %" + parametrosList.get(i).getVariable() + " = alloca i32\n");
                    definicionFuncion.append("    store i32 %cont_" + parametrosList.get(i).getVariable() + ", i32* %" + parametrosList.get(i).getVariable() + "\n");
                    definicionFuncion.append("    %" + parametrosList.get(i).getVariable() + "_val" + counter + " = load i32, i32* %" + parametrosList.get(i).getVariable() + "\n");
                    loads.add(new Loads(parametrosList.get(i).getVariable(), counter, scope_actual));
                    counter++;
                    break;
                case "boolean":
                    definicionFuncion.append("    %" + parametrosList.get(i).getVariable() + " = alloca i1\n");
                    definicionFuncion.append("    store i1 %cont_" + parametrosList.get(i).getVariable() + ", i1* %" + parametrosList.get(i).getVariable() + "\n");
                    definicionFuncion.append("    %" + parametrosList.get(i).getVariable() + "_val" + counter + " = load i1, i1* %" + parametrosList.get(i).getVariable() + "\n");
                    loads.add(new Loads(parametrosList.get(i).getVariable(), counter, scope_actual));
                    counter++;
                    break;
                case "char":
                    definicionFuncion.append("    %" + parametrosList.get(i).getVariable() + " = alloca i8\n");
                    definicionFuncion.append("    store i8 %cont_" + parametrosList.get(i).getVariable() + ", i8* %" + parametrosList.get(i).getVariable() + "\n");
                    definicionFuncion.append("    %" + parametrosList.get(i).getVariable() + "_val" + counter + " = load i8, i8* %" + parametrosList.get(i).getVariable() + "\n");
                    loads.add(new Loads(parametrosList.get(i).getVariable(), counter, scope_actual));
                    counter++;
                    break;
                case "string":
                    break;
            }
        }


//        llvmCode.insert(0, definicionFuncion.toString());
        emit_header(definicionFuncion.toString());
        int offset_funcion = definicionFuncion.toString().length();

        Binding functionBinding = new Binding(ctx.identifier().getText(), "void", scope_actual, true);
        functionBinding.setOffset(offset_funcion);
        TablaSimbolos.add(functionBinding);
        imprimirTablaSimbolos();

        visit(ctx.block());

        emit_header("    ret void\n}\n");
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
        if (ctx.string() != null) {
            if (ctx.write() == null) {
            } else {
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


                if (!encontrarVariable(variable)) {
                    System.err.println(" Error: La variable '" + variable + "' no está definida en el ámbito '" + scope_actual + "'.");
                    return null;
                } else {
                    // Validar el tipo de la expresión
                    if (tipoVariable != null) {
                        if (!verificarValorNoBooleanForFunctions(variable, tipoVariable)) {
                            System.err.println(" Error: El valor '" + variable + "' no es compatible con el tipo '" + tipoVariable + "' de la variable '" + variable + "'.");
                        } else {


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

                            if (scope_actual.equals("global")) {
                                emit_main("    call void @write_string(i8* getelementptr inbounds ([" + stringLength + " x i8], [" + stringLength + " x i8]* " + currentTempString + ", i32 0, i32 0))");
                                emit3AC_header("call @write_string " + currentTempString);
                            } else {
                                emit_header("    call void @write_string(i8* getelementptr inbounds ([" + stringLength + " x i8], [" + stringLength + " x i8]* " + currentTempString + ", i32 0, i32 0))");
                                emit3AC_main("call @write_string " + currentTempString);
                            }
//                            emit_main("    call void @write_string(i8* getelementptr inbounds ([" + stringLength + " x i8], [" + stringLength + " x i8]* " + currentTempString + ", i32 0, i32 0))");

                            Loads load = lastLoad(variable);
                            if (tipoVariable.toLowerCase().equals("integer")) {
                                for (int i = 0; i < loads.size(); i++) {
                                    System.out.println(CYAN + loads.get(i).getVariable() + " " + loads.get(i).getCounter() + RESET);
                                }
                                threeAddressCodeList.add(new ThreeAddressCode("write", "integer", variable + "_val" + load.getCounter(), null));
//                                emit_main("    call void @write_int(i32 %" + variable + "_val" + load.getCounter() + ")");
                                if (scope_actual.equals("global")) {
                                    emit_main("    call void @write_int(i32 %" + variable + "_val" + load.getCounter() + ")");
                                    emit3AC_main("call @write_int " + variable + "_val" + load.getCounter());
                                } else {
                                    emit_header("    call void @write_int(i32 %" + variable + "_val" + load.getCounter() + ")");
                                    emit3AC_header("call @write_int " + variable + "_val" + load.getCounter());
                                }

                            } else if (tipoVariable.toLowerCase().equals("char")) {
                                threeAddressCodeList.add(new ThreeAddressCode("write", "char", variable + "_val" + load.getCounter(), null));
//                                emit_main("    call void @write_char(i8 %" + variable + "_val" + load.getCounter() + ")");
                                if (scope_actual.equals("global")) {
                                    emit_main("    call void @write_char(i8 %" + variable + "_val" + load.getCounter() + ")");
                                    emit3AC_main("call @write_char " + variable + "_val" + load.getCounter());
                                } else {
                                    emit_header("    call void @write_char(i8 %" + variable + "_val" + load.getCounter() + ")");
                                    emit3AC_header("call @write_char " + variable + "_val" + load.getCounter());
                                }

                            } else if (tipoVariable.toLowerCase().equals("string")) {
                                threeAddressCodeList.add(new ThreeAddressCode("write", "string", variable + "_val" + load.getCounter(), null));
//                                emit_main("    call void @write_string(i8* %" + variable + "_val" + load.getCounter() + ")");
                                if (scope_actual.equals("global")) {
                                    emit_main("%casted_" + currentTempString + " = bitcast i8* " + currentTempString + " to i8*");
                                    emit_main("    call void @write_string(i8* getelementptr inbounds ([" + stringLength + " x i8], [" + stringLength + " x i8]* " + currentTempString + ", i32 0, i32 0))");
                                    emit3AC_main("call @write_string " + variable + "_val" + load.getCounter());
                                } else {
                                    emit_main("%casted_" + currentTempString + " = bitcast i8* " + currentTempString + " to i8*");
                                    emit_header("    call void @write_string(i8* getelementptr inbounds ([" + stringLength + " x i8], [" + stringLength + " x i8]* " + currentTempString + ", i32 0, i32 0))");
                                    emit3AC_header("call @write_string " + variable + "_val" + load.getCounter());
                                }
                            }

                        }
                    } else {
                        System.err.println(" Error: No se pudo determinar el tipo de la variable '" + variable + "'.");
                    }
                }


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

                if (scope_actual.equals("global")) {
                    emit_main("    call void @write_string(i8* getelementptr inbounds ([" + stringLength + " x i8], [" + stringLength + " x i8]* " + currentTempString + ", i32 0, i32 0))");
                    emit3AC_main("call @write_string " + currentTempString);
                } else {
                    emit_header("    call void @write_string(i8* getelementptr inbounds ([" + stringLength + " x i8], [" + stringLength + " x i8]* " + currentTempString + ", i32 0, i32 0))");
                    emit3AC_header("call @write_string " + currentTempString);
                }
//                emit_main("    call void @write_string(i8* getelementptr inbounds ([" + stringLength + " x i8], [" + stringLength + " x i8]* " + currentTempString + ", i32 0, i32 0))");
//                emit3AC_main("call @write_string " + currentTempString);

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


        String variable = ctx.readParam().getText();
        String tipoVariable = "";

        // Obtener el tipo de la variable desde la tabla de símbolos
        for (Binding binding : TablaSimbolos) {
            if (binding.getNombre().equals(variable) && binding.getScope().equals(scope_actual)) {
                tipoVariable = binding.getTipo();
                break;
            }
        }


        if (!encontrarVariable(variable)) {
            System.err.println(" Error: La variable '" + variable + "' no está definida en el ámbito '" + scope_actual + "'.");
            return null;
        } else {
            // Validar el tipo de la expresión
            if (tipoVariable != null) {
                if (!verificarValorNoBooleanForFunctions(variable, tipoVariable)) {
                    System.err.println(" Error: El valor '" + variable + "' no es compatible con el tipo '" + tipoVariable + "' de la variable '" + variable + "'.");
                } else {
                    if (!scanfdeclared) {
//                        llvmCode.insert(0, "\ndeclare i32 @scanf(i8*, ...)\n");
                        emit_header("declare i32 @scanf(i8*, ...)");
                        emit3AC_header("declare @scanf i8*");
                        scanfdeclared = true;

                    }
                    String tipovariable_lowercase = tipoVariable.toLowerCase();
                    switch (tipovariable_lowercase) {
                        case "integer":
                            if (!intformatdeclared) {
//                                llvmCode.insert(0, "@int_format = private constant [3 x i8] c\"%d\\00\"       ; Formato para enteros\n");
                                emit_header("@int_format = private constant [3 x i8] c\"%d\\00\"       ; Formato para enteros");
                                emit3AC_header("@int_format");
                                intformatdeclared = true;
                            }

                            emit_main("    %int_ptr" + counter + " = bitcast i32* %" + variable + " to i8* ;");
                            emit3AC_main("%int_ptr" + counter + " = " + variable + " to i8*");
                            emit_main("    call i32 (i8*, ...) @scanf(i8* bitcast ([3 x i8]* @int_format to i8*), i8* %int_ptr" + counter + ")");
                            emit3AC_main("call @scanf i8*");
                            emit_main("    %" + variable + "_val" + counter + " = load i32, i32* " + "%" + variable);
                            emit3AC_main(variable + "_val" + counter + " = " + "load" + " i32");
                            loads.add(new Loads(variable, counter, scope_actual));
                            counter++;
                            break;
                        case "char":
                            if (!charformatdeclared) {
//                                llvmCode.insert(0, "@char_format = private constant [3 x i8] c\"%c\\00\"      ; Formato para caracteres\n");
                                emit_header("@char_format = private constant [4 x i8] c\" %c\\00\"      ; Formato para caracteres");
                                emit3AC_header("@char_format");
                                charformatdeclared = true;
                            }
                            emit_main("    %char_ptr" + counter + " = bitcast i8* %" + variable + " to i8* ;");
                            emit3AC_main("%char_ptr" + counter + " = " + variable + " to i8*");
                            emit_main("    call i32 (i8*, ...) @scanf(i8* bitcast ([4 x i8]* @char_format to i8*), i8* %char_ptr" + counter + ")");
                            emit3AC_main("call @scanf i8*");
                            emit_main("    %" + variable + "_val" + counter + " = load i8, i8* " + "%" + variable);
                            emit3AC_main(variable + "_val" + counter + " = " + "load" + " i8");
                            loads.add(new Loads(variable, counter, scope_actual));
                            counter++;
                            break;
                        case "string":
                            if (!stringformatdeclared) {
//                                llvmCode.insert(0, "@str_format = private constant [3 x i8] c\"%s\\00\"       ; Formato para cadenas\n" +
//                                        "@buffer = private global [256 x i8] zeroinitializer    ; Buffer para almacenar cadenas\n");
                                emit_header("@str_format = private constant [3 x i8] c\"%s\\00\"       ; Formato para cadenas");
                                emit3AC_header("@str_format");
                                stringformatdeclared = true;
                            }
                            emit_main("    %str_ptr" + counter + " = getelementptr inbounds [256 x i8], [256 x i8]* @buffer, i32 0, i32 0");
                            emit3AC_main("%str_ptr" + counter + " = @buffer");
                            emit_main("    call i32 (i8*, ...) @scanf(i8* bitcast ([3 x i8]* @str_format to i8*), i8* %str_ptr" + counter + ")");
                            emit3AC_main("call @scanf i8*");
                            emit_main("    store i8* %str_ptr" + counter + ", i8** %" + variable);
                            emit3AC_main("store i8* " + " %str_ptr" + counter + ", i8** " + variable);
                            emit_main("    %" + variable + "_val" + counter + " = load i8*, i8** %" + variable);
                            emit3AC_main(variable + "_val" + counter + " = " + "load" + " i8*");
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
        String variable = ctx.variable().getText();
        String expression = ctx.expression().getText();

        if (ctx.expression().simpleExpression().getChildCount() == 1) { // x =: 3*4
            if (ctx.expression().simpleExpression().getChild(0).getChildCount() == 1) {
                System.out.println(CYAN + "CHILD == 1" + RESET);
                // Verificar si la variable está definida en el ámbito actual
            } else {
                // DESGLOSAR OPERACION POR PARTES
                String operacion = ctx.expression().simpleExpression().getChild(0).getText();


                if (operacion.contains("*") || operacion.contains("/") || operacion.contains("+") || operacion.contains("-")) {


                    char[] operators = {'+', '-', '*', '/'};


                    while (operacion.contains("*") || operacion.contains("/") || operacion.contains("+") || operacion.contains("-")) {
                        for (char operator : operators) {
                            // Escape special characters for regex
                            String regexOperator = "\\" + operator;

                            if (operacion.contains(Character.toString(operator))) {
                                String[] parts = operacion.split(regexOperator, 2); // Split into 2 parts only


                                // Continue processing the right side of the expression
                                operacion = parts[1].trim();
                                break; // Restart the cycle for the next part
                            } else {
                            }
                        }
                    }

                    try {
                        generateThreeAddressCode(ctx.expression().simpleExpression().getChild(0).getText(), "output3AC.txt", variable);
                        System.err.println(ThreeAddressCodeTemp);
                        for (int i = 0; i < ThreeAddressCodeTemp.size(); i++) {
                            emit3AC_main(ThreeAddressCodeTemp.get(i));
                        }
                        generateLLVMFrom3AC(ThreeAddressCodeTemp);
                        ThreeAddressCodeTemp.clear();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }

                } else {
                    if (!scope_actual.equals("global")) {
                        System.out.println(CYAN + "ENTRO AL IF" + RESET);
                        String toinsert = "    store i32 " + expression + ", i32 %" + variable + "\n" +
                                "    %" + variable + "_val" + counter + " = load i32, i32* %" + variable + "\n";
                        emit_header(toinsert);
                        emit3AC_header("store i32 " + expression + ", i32 %" + variable);
                        emit3AC_header("%" + variable + "_val" + counter + " = " + "load" + " i32");
                        loads.add(new Loads(variable, counter, scope_actual));
                        counter++;
                    } else {
                        emit_main("    store i32 " + expression + ", i32 %" + variable);

                        emit_main("    %" + variable + "_val" + counter + " = load i32, i32* %" + variable);

                        emit3AC_main("store i32 " + expression + " = i32 %" + variable);
                        emit3AC_main("%" + variable + "_val" + counter + " = " + "load" + " i32");
                        loads.add(new Loads(variable, counter, scope_actual));
                        counter++;
                    }
                }
            }

            // aca continua
            if (!encontrarVariable(variable)) {
                System.err.println(" Error: La variable '" + variable + "' no está definida en el ámbito '" + scope_actual + "'.");
                return null;
            }//chequea que este declarada

            // Obtener el tipo de la variable desde la tabla de símbolos
            String tipoVariable = null;
            for (Binding binding : TablaSimbolos) {
                if (binding.getNombre().equals(variable) && binding.getScope().equals(scope_actual)) {
                    tipoVariable = binding.getTipo();
                    break;
                }
            }


            // Validar el tipo de la expresión
            if (tipoVariable != null) {
                System.out.println("eeeeeeeeeeeeeeeeeee " + expression);
                if (!verificarValor(expression, tipoVariable)) { // Ahora se pasan dos parámetros
                    System.err.println(" Error: El valor '" + expression + "' no es compatible con el tipo '" + tipoVariable + "' de la variable '" + variable + "'.");
                    JOptionPane.showMessageDialog(null, " Error: El valor '" + expression + "' no es compatible con el tipo '" + tipoVariable + "' de la variable '" + variable + "'.");
                } else {
                    System.out.println(CYAN + " paso el test ASIGNANDO EL DE LA VARIABLE: " + variable + " CON EL VALOR: " + expression + RESET);
                    //esto ya es generando el .ll
                    // Generar código LLVM para la asignación

                    JOptionPane.showMessageDialog(null, "LLEGA HASTA ACA" + 1);
                    switch (tipoVariable.toLowerCase()) {
                        case "integer":
                            if (isNumeric(expression)) {
                                threeAddressCodeList.add(new ThreeAddressCode("store", expression, "integer", variable));
                                emit3AC_main(variable + " = " + "store" + " integer" + expression);

                                threeAddressCodeList.add(new ThreeAddressCode("load", variable, "integer", variable + "_val" + counter));
                                emit3AC_main(variable + "_val" + counter + " = " + "load" + " integer");

                                if (!(scope_actual.equals("global"))) {
                                    //                        System.out.println(CYAN + "ENTRO AL IF" + RESET);
                                    String toinsert = "    store i32 " + expression + ", i32* %" + variable + "\n" +
                                            "    %" + variable + "_val" + counter + " = load i32, i32* %" + variable + "\n";
                                    emit_header(toinsert);
                                    emit3AC_header(variable + " = " + "store" + " integer" + expression);
                                    emit3AC_header(variable + "_val" + counter + " = " + "load" + " integer");
                                } else {
                                    emit_main("    store i32 " + expression + ", i32* %" + variable);
                                    emit_main("    %" + variable + "_val" + counter + " = load i32, i32* %" + variable);
                                    emit3AC_main(variable + " = " + "store" + " integer" + expression);

                                    emit3AC_main(variable + "_val" + counter + " = " + "load" + " integer");

                                }
                                loads.add(new Loads(variable, counter, scope_actual));
                                System.out.println(CYAN + "ASIGNANDO EL DE LA VARIABLE: " + variable + " CON EL VALOR: " + expression + RESET);
                                counter++;
                            } else if (isFunction(expression)) {
                                llamado_a_funcion(expression, variable);
                            } else {
                                JOptionPane.showMessageDialog(null, "Es expresion larga");
                            }
                            break;
                        case "boolean":// aca tengo que trabajar
                            switch (expression) {
                                case "true":
                                    threeAddressCodeList.add(new ThreeAddressCode("store", "1", "boolean", variable));
                                    emit3AC_main(variable + " = " + "store" + " boolean" + " 1");
                                    threeAddressCodeList.add(new ThreeAddressCode("load", variable, "boolean", variable + "_val" + counter));
                                    emit3AC_main(variable + "_val" + counter + " = " + "load" + " boolean");
                                    if (!(scope_actual.equals("global"))) {
                                        String toinsert = "    store i1 1, i1* %" + variable + "\n" +
                                                "    %" + variable + "_val" + counter + " = load i1, i1* %" + variable + "\n";
                                        emit_header(toinsert);
                                        emit3AC_header(variable + " = " + "store" + " boolean" + " 1");
                                        emit3AC_header(variable + "_val" + counter + " = " + "load" + " boolean");
                                    } else {
                                        emit_main("    store i1 1, i1* %" + variable);
                                        emit3AC_main(variable + " = " + "store" + " boolean" + " 1");
                                        emit_main("    %" + variable + "_val" + counter + " = load i1, i1* %" + variable);
                                        emit3AC_main(variable + "_val" + counter + " = " + "load" + " boolean");
                                    }
                                    loads.add(new Loads(variable, counter, scope_actual));
                                    counter++;
                                    break;
                                case "false":
                                    threeAddressCodeList.add(new ThreeAddressCode("store", "0", "boolean", variable));
                                    emit3AC_main(variable + " = " + "store" + " boolean" + " 0");
                                    threeAddressCodeList.add(new ThreeAddressCode("load", variable, "boolean", variable + "_val" + counter));
                                    emit3AC_main(variable + "_val" + counter + " = " + "load" + " boolean");
                                    if (!(scope_actual.equals("global"))) {
                                        String toinsert = "    store i1 0, i1* %" + variable + "\n" +
                                                "    %" + variable + "_val" + counter + " = load i1, i1* %" + variable + "\n";
                                        emit_header(toinsert);
                                        emit3AC_header(variable + " = " + "store" + " boolean" + " 0");
                                        emit3AC_header(variable + "_val" + counter + " = " + "load" + " boolean");
                                    } else {
                                        emit_main("    store i1 0, i1* %" + variable);
                                        emit3AC_main(variable + " = " + "store" + " boolean" + " 0");
                                        emit_main("    %" + variable + "_val" + counter + " = load i1, i1* %" + variable);
                                        emit3AC_main(variable + "_val" + counter + " = " + "load" + " boolean");
                                    }
                                    loads.add(new Loads(variable, counter, scope_actual));
                                    counter++;
                                    break;
                                default:
                                    break;
                            }
                            if (isFunction(expression)) {
                                llamado_a_funcion(expression, variable);
                            }
                            break;
                        case "char":
                            if (isFunction(expression)) {
                                llamado_a_funcion(expression, variable);
                            } else {
                                int asciivalue = expression.charAt(1);
                                threeAddressCodeList.add(new ThreeAddressCode("store", "" + asciivalue, "char", variable));
                                emit3AC_main(variable + " = " + "store" + " char" + " " + asciivalue);
                                threeAddressCodeList.add(new ThreeAddressCode("load", variable, "char", variable + "_val" + counter));
                                emit3AC_main(variable + "_val" + counter + " = " + "load" + " char");
                                if (!(scope_actual.equals("global"))) {
                                    emit_header("    store i8 " + asciivalue + ", i8* %" + variable);
                                    emit3AC_header(variable + " = " + "store" + " char" + " " + asciivalue);
                                    emit_header("    %" + variable + "_val" + counter + " = load i8, i8* %" + variable);
                                    emit3AC_header(variable + "_val" + counter + " = " + "load" + " char");
                                } else {
                                    emit_main("    store i8 " + asciivalue + ", i8* %" + variable);
                                    emit3AC_main(variable + " = " + "store" + " char" + " " + asciivalue);
                                    emit_main("    %" + variable + "_val" + counter + " = load i8, i8* %" + variable);
                                    emit3AC_main(variable + "_val" + counter + " = " + "load" + " char");
                                }
//                    emit_main("    store i8 " + asciivalue + ", i8* %" + variable);
//                    emit_main("    %" + variable + "_val" + counter + " = load i8, i8* %" + variable);
                                loads.add(new Loads(variable, counter, scope_actual));
                                counter++;
                            }
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
                            emit3AC_main(variable + " = " + "store" + " string" + " " + currentTempString);
                            threeAddressCodeList.add(new ThreeAddressCode("load", variable, "string", variable + "_val" + counter));
                            emit3AC_main(variable + "_val" + counter + " = " + "load" + " string");
                            if (!(scope_actual.equals("global"))) {
                                emit_header("    store i8* getelementptr inbounds ([" + stringLength + " x i8], [" + stringLength + " x i8]* " + currentTempString + ", i32 0, i32 0), i8** %" + variable);
                                emit_header("    %" + variable + "_val" + counter + " = load i8*, i8** %" + variable);
                                emit3AC_header(variable + " = " + "store" + " string" + " " + currentTempString);
                                emit3AC_header(variable + "_val" + counter + " = " + "load" + " string");
                            } else {
                                emit_main("    store i8* getelementptr inbounds ([" + stringLength + " x i8], [" + stringLength + " x i8]* " + currentTempString + ", i32 0, i32 0), i8** %" + variable);
                                emit_main("    %" + variable + "_val" + counter + " = load i8*, i8** %" + variable);
                                emit3AC_main(variable + " = " + "store" + " string" + " " + currentTempString);
                                emit3AC_main(variable + "_val" + counter + " = " + "load" + " string");
                            }
//                    emit_main("    store i8* getelementptr inbounds ([" + stringLength + " x i8], [" + stringLength + " x i8]* " + currentTempString + ", i32 0, i32 0), i8** %" + variable);
//                    emit_main("    %" + variable + "_val" + counter + " = load i8*, i8** %" + variable);
                            loads.add(new Loads(variable, counter, scope_actual));
                            counter++;
                            break;
                    }
                }
            } else {
                System.err.println(" Error: No se pudo determinar el tipo de la variable '" + variable + "'.");
            }


        } else { //childcount > 1
            String statementText = "";
            for (int i = 0; i < ctx.expression().simpleExpression().getChildCount(); i++) {
                statementText += ctx.expression().simpleExpression().getChild(i).getText() + " ";
            }


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
                                emit3AC_main(variableEnUso + " = " + "store" + " boolean" + " 1");
                                threeAddressCodeList.add(new ThreeAddressCode("load", variableEnUso, "boolean", variableEnUso + "_val" + counter));
                                emit3AC_main(variableEnUso + "_val" + counter + " = " + "load" + " boolean");
                                emit_main("    store i1 1, i1* %" + variableEnUso);
                                emit3AC_main(variableEnUso + " = " + "store" + " boolean" + " 1");
                                emit_main("    %" + variableEnUso + "_val" + counter + " = load i1, i1* %" + variableEnUso);
                                emit3AC_main(variableEnUso + "_val" + counter + " = " + "load" + " boolean");
                                loads.add(new Loads(variableEnUso, counter, scope_actual));
                                counter++;
                                break;
                            case "false":
                                threeAddressCodeList.add(new ThreeAddressCode("store", "0", "boolean", variableEnUso));
                                emit3AC_main(variableEnUso + " = " + "store" + " boolean" + " 0");
                                threeAddressCodeList.add(new ThreeAddressCode("load", variableEnUso, "boolean", variableEnUso + "_val" + counter));
                                emit3AC_main(variableEnUso + "_val" + counter + " = " + "load" + " boolean");
                                emit_main("    store i1 0, i1* %" + variableEnUso);
                                emit3AC_main(variableEnUso + " = " + "store" + " boolean" + " 0");
                                emit_main("    %" + variableEnUso + "_val" + counter + " = load i1, i1* %" + variableEnUso);
                                emit3AC_main(variableEnUso + "_val" + counter + " = " + "load" + " boolean");
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
                        emit3AC_main(variableEnUso + " = " + "store" + " char" + " " + asciivalue);
                        threeAddressCodeList.add(new ThreeAddressCode("load", variableEnUso, "char", variableEnUso + "_val" + counter));
                        emit3AC_main(variableEnUso + "_val" + counter + " = " + "load" + " char");
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
            visit(ctx.factor()); // Visitar el nodo del factor
        } else if (ctx.bool_() != null) {
        }
        return null;
    }

    @Override
    public Object visitUnsignedConstant(MiniPascalGrammarParser.UnsignedConstantContext ctx) {
        if (ctx.unsignedNumber() != null) {
        } else if (ctx.constantChr() != null) {
        } else if (ctx.string() != null) {
        } else if (ctx.NIL() != null) {
        }
        return null;
    }

    @Override
    public Object visitFunctionDesignator(MiniPascalGrammarParser.FunctionDesignatorContext ctx) {
        String nombre_funcion = ctx.identifier().getText();
        if (ctx.parameterList() != null) {
            visit(ctx.parameterList());
        }
        llamado_a_funcion(ctx.getText(), "");

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
        visit(ctx.elementList());
        return null;
    }

    @Override
    public Object visitElementList(MiniPascalGrammarParser.ElementListContext ctx) {
        for (MiniPascalGrammarParser.ElementContext elementCtx : ctx.element()) {
            visit(elementCtx);
        }
        System.out.println();
        return null;
    }

    @Override
    public Object visitElement(MiniPascalGrammarParser.ElementContext ctx) {
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


        String[] expresionSplit = statementText.split(" ");
        String currentCounter = generateCondVariable();

        if (expresionSplit.length == 1) {

            // aca arreglar detalle de cuando solo hay un argumento en el if
            String variable = expresionSplit[0];
            if (encontrarVariableEnLoads(variable)) {

                for (Loads load : loads) {
                    if (load.getVariable().equals(variable)) {
                        if (scope_actual.equals("global")) {
                            threeAddressCodeList.add(new ThreeAddressCode("if", "then" + ifCounter, "else" + ifCounter, currentCounter));
                            emit3AC_main("if " + "then" + ifCounter + " else " + "else" + ifCounter + " goto " + currentCounter);
                            emit_main("    br i1 %" + variable + "_val" + load.getCounter() + ", label %then" + ifCounter + ", label %else" + ifCounter);
                            emit3AC_main("br i1 %" + variable + "_val" + load.getCounter() + ", label %then" + ifCounter + ", label %else" + ifCounter);
                            break;
                        } else {
                            threeAddressCodeList.add(new ThreeAddressCode("if", "then" + ifCounter, "else" + ifCounter, currentCounter));
                            emit3AC_header("if " + "then" + ifCounter + " else " + "else" + ifCounter + " goto " + currentCounter);
                            emit_header("    br i1 %" + variable + "_val" + load.getCounter() + ", label %then" + ifCounter + ", label %else" + ifCounter);
                            emit3AC_header("br i1 %" + variable + "_val" + load.getCounter() + ", label %then" + ifCounter + ", label %else" + ifCounter);
                            break;
                        }
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

                switch (operador) {
                    case ">":
                        for (Loads load : loads) {
                            if (load.getVariable().equals(variable)) {
                                for (Loads load2 : loads) {
                                    if (load2.getVariable().equals(valor)) {
                                        if (scope_actual.equals("global")) {
                                            threeAddressCodeList.add(new ThreeAddressCode(">", variable + "_val" + load.getCounter(), valor + "_val" + load2.getCounter(), currentCounter));
                                            emit3AC_main(currentCounter + " = " + variable + "_val" + load.getCounter() + " > " + valor + "_val" + load2.getCounter());
                                            emit_main("    %" + currentCounter + " = icmp sgt i32 %" + variable + "_val" + load.getCounter() + ", %" + valor + "_val" + load2.getCounter());
                                        } else {
                                            threeAddressCodeList.add(new ThreeAddressCode(">", variable + "_val" + load.getCounter(), valor + "_val" + load2.getCounter(), currentCounter));
                                            emit3AC_header(currentCounter + " = " + variable + "_val" + load.getCounter() + " > " + valor + "_val" + load2.getCounter());
                                            emit_header("    %" + currentCounter + " = icmp sgt i32 %" + variable + "_val" + load.getCounter() + ", %" + valor + "_val" + load2.getCounter());
                                        }
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
                                        if (scope_actual.equals("global")) {
                                            threeAddressCodeList.add(new ThreeAddressCode("<", variable + "_val" + load.getCounter(), valor + "_val" + load2.getCounter(), currentCounter));
                                            emit3AC_main(currentCounter + " = " + variable + "_val" + load.getCounter() + " < " + valor + "_val" + load2.getCounter());
                                            emit_main("    %" + currentCounter + " = icmp slt i32 %" + variable + "_val" + load.getCounter() + ", %" + valor + "_val" + load2.getCounter());
                                        } else {
                                            threeAddressCodeList.add(new ThreeAddressCode("<", variable + "_val" + load.getCounter(), valor + "_val" + load2.getCounter(), currentCounter));
                                            emit3AC_header(currentCounter + " = " + variable + "_val" + load.getCounter() + " < " + valor + "_val" + load2.getCounter());
                                            emit_header("    %" + currentCounter + " = icmp slt i32 %" + variable + "_val" + load.getCounter() + ", %" + valor + "_val" + load2.getCounter());
                                        }
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
                                        if (scope_actual.equals("global")) {
                                            threeAddressCodeList.add(new ThreeAddressCode("==", variable + "_val" + load.getCounter(), valor + "_val" + load2.getCounter(), currentCounter));
                                            emit3AC_main(currentCounter + " = " + variable + "_val" + load.getCounter() + " == " + valor + "_val" + load2.getCounter());
                                            emit_main("    %" + currentCounter + " = icmp eq i32 %" + variable + "_val" + load.getCounter() + ", %" + valor + "_val" + load2.getCounter());
                                        } else {
                                            threeAddressCodeList.add(new ThreeAddressCode("==", variable + "_val" + load.getCounter(), valor + "_val" + load2.getCounter(), currentCounter));
                                            emit3AC_header(currentCounter + " = " + variable + "_val" + load.getCounter() + " == " + valor + "_val" + load2.getCounter());
                                            emit_header("    %" + currentCounter + " = icmp eq i32 %" + variable + "_val" + load.getCounter() + ", %" + valor + "_val" + load2.getCounter());
                                        }
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
                                        if (scope_actual.equals("global")) {
                                            threeAddressCodeList.add(new ThreeAddressCode("!=", variable + "_val" + load.getCounter(), valor + "_val" + load2.getCounter(), currentCounter));
                                            emit3AC_main(currentCounter + " = " + variable + "_val" + load.getCounter() + " <> " + valor + "_val" + load2.getCounter());
                                            emit_main("    %" + currentCounter + " = icmp ne i32 %" + variable + "_val" + load.getCounter() + ", %" + valor + "_val" + load2.getCounter());
                                        } else {
                                            threeAddressCodeList.add(new ThreeAddressCode("!=", variable + "_val" + load.getCounter(), valor + "_val" + load2.getCounter(), currentCounter));
                                            emit3AC_header(currentCounter + " = " + variable + "_val" + load.getCounter() + " <> " + valor + "_val" + load2.getCounter());
                                            emit_header("    %" + currentCounter + " = icmp ne i32 %" + variable + "_val" + load.getCounter() + ", %" + valor + "_val" + load2.getCounter());
                                        }
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
                                        if (scope_actual.equals("global")) {
                                            threeAddressCodeList.add(new ThreeAddressCode(">=", variable + "_val" + load.getCounter(), valor + "_val" + load2.getCounter(), currentCounter));
                                            emit3AC_main(currentCounter + " = " + variable + "_val" + load.getCounter() + " >= " + valor + "_val" + load2.getCounter());
                                            emit_main("    %" + currentCounter + " = icmp sge i32 %" + variable + "_val" + load.getCounter() + ", %" + valor + "_val" + load2.getCounter());
                                        } else {
                                            threeAddressCodeList.add(new ThreeAddressCode(">=", variable + "_val" + load.getCounter(), valor + "_val" + load2.getCounter(), currentCounter));
                                            emit3AC_header(currentCounter + " = " + variable + "_val" + load.getCounter() + " >= " + valor + "_val" + load2.getCounter());
                                            emit_header("    %" + currentCounter + " = icmp sge i32 %" + variable + "_val" + load.getCounter() + ", %" + valor + "_val" + load2.getCounter());
                                        }
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
                                        if (scope_actual.equals("global")) {
                                            threeAddressCodeList.add(new ThreeAddressCode("<=", variable + "_val" + load.getCounter(), valor + "_val" + load2.getCounter(), currentCounter));
                                            emit3AC_main(currentCounter + " = " + variable + "_val" + load.getCounter() + " <= " + valor + "_val" + load2.getCounter());
                                            emit_main("    %" + currentCounter + " = icmp sle i32 %" + variable + "_val" + load.getCounter() + ", %" + valor + "_val" + load2.getCounter());
                                        } else {
                                            threeAddressCodeList.add(new ThreeAddressCode("<=", variable + "_val" + load.getCounter(), valor + "_val" + load2.getCounter(), currentCounter));
                                            emit3AC_header(currentCounter + " = " + variable + "_val" + load.getCounter() + " <= " + valor + "_val" + load2.getCounter());
                                            emit_header("    %" + currentCounter + " = icmp sle i32 %" + variable + "_val" + load.getCounter() + ", %" + valor + "_val" + load2.getCounter());
                                        }
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
                                        if (scope_actual.equals("global")) {
                                            threeAddressCodeList.add(new ThreeAddressCode("and", variable + "_val" + load.getCounter(), valor + "_val" + load2.getCounter(), currentCounter));
                                            emit3AC_main(currentCounter + " = " + variable + "_val" + load.getCounter() + " and " + valor + "_val" + load2.getCounter());
                                            emit_main("    %" + currentCounter + " = and i1 %" + variable + "_val" + load.getCounter() + ", %" + valor + "_val" + load2.getCounter());
                                        } else {
                                            threeAddressCodeList.add(new ThreeAddressCode("and", variable + "_val" + load.getCounter(), valor + "_val" + load2.getCounter(), currentCounter));
                                            emit3AC_header(currentCounter + " = " + variable + "_val" + load.getCounter() + " and " + valor + "_val" + load2.getCounter());
                                            emit_header("    %" + currentCounter + " = and i1 %" + variable + "_val" + load.getCounter() + ", %" + valor + "_val" + load2.getCounter());
                                        }
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
                                        if (scope_actual.equals("global")) {
                                            threeAddressCodeList.add(new ThreeAddressCode("or", variable + "_val" + load.getCounter(), valor + "_val" + load2.getCounter(), currentCounter));
                                            emit3AC_main(currentCounter + " = " + variable + "_val" + load.getCounter() + " or " + valor + "_val" + load2.getCounter());
                                            emit_main("    %" + currentCounter + " = or i1 %" + variable + "_val" + load.getCounter() + ", %" + valor + "_val" + load2.getCounter());
                                        } else {
                                            threeAddressCodeList.add(new ThreeAddressCode("or", variable + "_val" + load.getCounter(), valor + "_val" + load2.getCounter(), currentCounter));
                                            emit3AC_header(currentCounter + " = " + variable + "_val" + load.getCounter() + " or " + valor + "_val" + load2.getCounter());
                                            emit_header("    %" + currentCounter + " = or i1 %" + variable + "_val" + load.getCounter() + ", %" + valor + "_val" + load2.getCounter());
                                        }
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
                                        if (scope_actual.equals("global")) {
                                            threeAddressCodeList.add(new ThreeAddressCode("not", variable + "_val" + load.getCounter(), valor + "_val" + load2.getCounter(), currentCounter));
                                            emit3AC_main(currentCounter + " = " + variable + "_val" + load.getCounter() + " not " + valor + "_val" + load2.getCounter());
                                            emit_main("    %" + currentCounter + " = xor i1 %" + variable + "_val" + load.getCounter() + ", 1");
                                        } else {
                                            threeAddressCodeList.add(new ThreeAddressCode("not", variable + "_val" + load.getCounter(), valor + "_val" + load2.getCounter(), currentCounter));
                                            emit3AC_header(currentCounter + " = " + variable + "_val" + load.getCounter() + " not " + valor + "_val" + load2.getCounter());
                                            emit_header("    %" + currentCounter + " = xor i1 %" + variable + "_val" + load.getCounter() + ", 1");
                                        }
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

                    switch (operador) {
                        case ">":
                            for (Loads load : loads) {
                                if (load.getVariable().equals(variable)) {
                                    if (scope_actual.equals("global")) {
                                        threeAddressCodeList.add(new ThreeAddressCode(">", variable + "_val" + load.getCounter(), valor, currentCounter));
                                        emit3AC_main(currentCounter + " = " + variable + "_val" + load.getCounter() + " > " + valor);
                                        emit_main("    %" + currentCounter + " = icmp sgt i32 %" + variable + "_val" + load.getCounter() + ", " + valor);
                                    } else {
                                        threeAddressCodeList.add(new ThreeAddressCode(">", variable + "_val" + load.getCounter(), valor, currentCounter));
                                        emit3AC_header(currentCounter + " = " + variable + "_val" + load.getCounter() + " > " + valor);
                                        emit_header("    %" + currentCounter + " = icmp sgt i32 %" + variable + "_val" + load.getCounter() + ", " + valor);
                                    }
                                    break;
                                }
                            }
                            break;
                        case "<":
                            for (Loads load : loads) {
                                if (load.getVariable().equals(variable)) {
                                    if (scope_actual.equals("global")) {
                                        threeAddressCodeList.add(new ThreeAddressCode("<", variable + "_val" + load.getCounter(), valor, currentCounter));
                                        emit3AC_main(currentCounter + " = " + variable + "_val" + load.getCounter() + " < " + valor);
                                        emit_main("    %" + currentCounter + " = icmp slt i32 %" + variable + "_val" + load.getCounter() + ", " + valor);
                                    } else {
                                        threeAddressCodeList.add(new ThreeAddressCode("<", variable + "_val" + load.getCounter(), valor, currentCounter));
                                        emit3AC_header(currentCounter + " = " + variable + "_val" + load.getCounter() + " < " + valor);
                                        emit_header("    %" + currentCounter + " = icmp slt i32 %" + variable + "_val" + load.getCounter() + ", " + valor);
                                    }
                                    break;
                                }
                            }
                            break;
                        case "=":
                            for (Loads load : loads) {
                                if (load.getVariable().equals(variable)) {
                                    if (scope_actual.equals("global")) {
                                        threeAddressCodeList.add(new ThreeAddressCode("==", variable + "_val" + load.getCounter(), valor, currentCounter));
                                        emit3AC_main(currentCounter + " = " + variable + "_val" + load.getCounter() + " == " + valor);
                                        emit_main("    %" + currentCounter + " = icmp eq i32 %" + variable + "_val" + load.getCounter() + ", " + valor);
                                    } else {
                                        threeAddressCodeList.add(new ThreeAddressCode("==", variable + "_val" + load.getCounter(), valor, currentCounter));
                                        emit3AC_header(currentCounter + " = " + variable + "_val" + load.getCounter() + " == " + valor);
                                        emit_header("    %" + currentCounter + " = icmp eq i32 %" + variable + "_val" + load.getCounter() + ", " + valor);
                                    }
                                    break;
                                }
                            }
                            break;
                        case "<>":
                            for (Loads load : loads) {
                                if (load.getVariable().equals(variable)) {
                                    if (scope_actual.equals("global")) {
                                        threeAddressCodeList.add(new ThreeAddressCode("!=", variable + "_val" + load.getCounter(), valor, currentCounter));
                                        emit3AC_main(currentCounter + " = " + variable + "_val" + load.getCounter() + " <> " + valor);
                                        emit_main("    %" + currentCounter + " = icmp ne i32 %" + variable + "_val" + load.getCounter() + ", " + valor);
                                    } else {
                                        threeAddressCodeList.add(new ThreeAddressCode("!=", variable + "_val" + load.getCounter(), valor, currentCounter));
                                        emit3AC_header(currentCounter + " = " + variable + "_val" + load.getCounter() + " <> " + valor);
                                        emit_header("    %" + currentCounter + " = icmp ne i32 %" + variable + "_val" + load.getCounter() + ", " + valor);
                                    }
                                    break;
                                }
                            }
                            break;
                        case ">=":
                            for (Loads load : loads) {
                                if (load.getVariable().equals(variable)) {
                                    if (scope_actual.equals("global")) {
                                        threeAddressCodeList.add(new ThreeAddressCode(">=", variable + "_val" + load.getCounter(), valor, currentCounter));
                                        emit3AC_main(currentCounter + " = " + variable + "_val" + load.getCounter() + " >= " + valor);
                                        emit_main("    %" + currentCounter + " = icmp sge i32 %" + variable + "_val" + load.getCounter() + ", " + valor);
                                    } else {
                                        threeAddressCodeList.add(new ThreeAddressCode(">=", variable + "_val" + load.getCounter(), valor, currentCounter));
                                        emit3AC_header(currentCounter + " = " + variable + "_val" + load.getCounter() + " >= " + valor);
                                        emit_header("    %" + currentCounter + " = icmp sge i32 %" + variable + "_val" + load.getCounter() + ", " + valor);
                                    }
                                    break;
                                }
                            }
                            break;
                        case "<=":
                            for (Loads load : loads) {
                                if (load.getVariable().equals(variable)) {
                                    if (scope_actual.equals("global")) {
                                        threeAddressCodeList.add(new ThreeAddressCode("<=", variable + "_val" + load.getCounter(), valor, currentCounter));
                                        emit3AC_main(currentCounter + " = " + variable + "_val" + load.getCounter() + " <= " + valor);
                                        emit_main("    %" + currentCounter + " = icmp sle i32 %" + variable + "_val" + load.getCounter() + ", " + valor);
                                    } else {
                                        threeAddressCodeList.add(new ThreeAddressCode("<=", variable + "_val" + load.getCounter(), valor, currentCounter));
                                        emit3AC_header(currentCounter + " = " + variable + "_val" + load.getCounter() + " <= " + valor);
                                        emit_header("    %" + currentCounter + " = icmp sle i32 %" + variable + "_val" + load.getCounter() + ", " + valor);
                                    }
                                    break;
                                }
                            }
                            break;
                        case "and":
                            for (Loads load : loads) {
                                if (load.getVariable().equals(variable)) {
                                    if (scope_actual.equals("global")) {
                                        threeAddressCodeList.add(new ThreeAddressCode("and", variable + "_val" + load.getCounter(), valor, currentCounter));
                                        emit3AC_main(currentCounter + " = " + variable + "_val" + load.getCounter() + " and " + valor);
                                        emit_main("    %" + currentCounter + " = and i1 %" + variable + "_val" + load.getCounter() + ", " + valor);
                                    } else {
                                        threeAddressCodeList.add(new ThreeAddressCode("and", variable + "_val" + load.getCounter(), valor, currentCounter));
                                        emit3AC_header(currentCounter + " = " + variable + "_val" + load.getCounter() + " and " + valor);
                                        emit_header("    %" + currentCounter + " = and i1 %" + variable + "_val" + load.getCounter() + ", " + valor);
                                    }
                                    break;
                                }
                            }
                            break;
                        case "or":
                            for (Loads load : loads) {
                                if (load.getVariable().equals(variable)) {
                                    if (scope_actual.equals("global")) {
                                        threeAddressCodeList.add(new ThreeAddressCode("or", variable + "_val" + load.getCounter(), valor, currentCounter));
                                        emit3AC_main(currentCounter + " = " + variable + "_val" + load.getCounter() + " or " + valor);
                                        emit_main("    %" + currentCounter + " = or i1 %" + variable + "_val" + load.getCounter() + ", " + valor);
                                    } else {
                                        threeAddressCodeList.add(new ThreeAddressCode("or", variable + "_val" + load.getCounter(), valor, currentCounter));
                                        emit3AC_header(currentCounter + " = " + variable + "_val" + load.getCounter() + " or " + valor);
                                        emit_header("    %" + currentCounter + " = or i1 %" + variable + "_val" + load.getCounter() + ", " + valor);
                                    }
                                    break;
                                }
                            }
                            break;
                        case "not":
                            for (Loads load : loads) {
                                if (load.getVariable().equals(variable)) {
                                    if (scope_actual.equals("global")) {
                                        threeAddressCodeList.add(new ThreeAddressCode("not", variable + "_val" + load.getCounter(), valor, currentCounter));
                                        emit3AC_main(currentCounter + " = " + variable + "_val" + load.getCounter() + " not " + valor);
                                        emit_main("    %" + currentCounter + " = xor i1 %" + variable + "_val" + load.getCounter() + ", 1");
                                    } else {
                                        threeAddressCodeList.add(new ThreeAddressCode("not", variable + "_val" + load.getCounter(), valor, currentCounter));
                                        emit3AC_header(currentCounter + " = " + variable + "_val" + load.getCounter() + " not " + valor);
                                        emit_header("    %" + currentCounter + " = xor i1 %" + variable + "_val" + load.getCounter() + ", 1");
                                    }
                                    break;
                                }
                            }
                            break;
                    }

                } catch (NumberFormatException e) {
                    System.err.println("  Valor: " + valor + " no es una variable definida ni un número.");
                }
            }
            if (scope_actual.equals("global")) {
                threeAddressCodeList.add(new ThreeAddressCode("if", "then" + ifCounter, "else" + ifCounter, currentCounter));
                emit3AC_main("if " + "then" + ifCounter + " else " + "else" + ifCounter + " goto " + currentCounter);
                emit_main("    br i1 %" + currentCounter + ", label %then" + ifCounter + ", label %else" + ifCounter);
            } else {
                threeAddressCodeList.add(new ThreeAddressCode("if", "then" + ifCounter, "else" + ifCounter, currentCounter));
                emit3AC_header("if " + "then" + ifCounter + " else " + "else" + ifCounter + " goto " + currentCounter);
                emit_header("    br i1 %" + currentCounter + ", label %then" + ifCounter + ", label %else" + ifCounter);
            }
        }

        if (scope_actual.equals("global")) {
            threeAddressCodeList.add(new ThreeAddressCode("then", "then" + ifCounter, null, null));
            emit3AC_main("then" + ifCounter + ":");
            emit_main("then" + ifCounter + ":");
            visit(ctx.statement(0));
            threeAddressCodeList.add(new ThreeAddressCode("merge", "merge" + ifCounter, null, null));
            emit3AC_main("merge" + ifCounter + ":");
            emit_main("    br label %merge" + ifCounter);
        } else {
            threeAddressCodeList.add(new ThreeAddressCode("then", "then" + ifCounter, null, null));
            emit3AC_header("then" + ifCounter + ":");
            emit_header("then" + ifCounter + ":");
            visit(ctx.statement(0));
            threeAddressCodeList.add(new ThreeAddressCode("merge", "merge" + ifCounter, null, null));
            emit3AC_header("merge" + ifCounter + ":");
            emit_header("    br label %merge" + ifCounter);
        }

        if (ctx.ELSE() != null) {
            if (scope_actual.equals("global")) {
                threeAddressCodeList.add(new ThreeAddressCode("else", "else" + ifCounter, null, null));
                emit_main("else" + ifCounter + ":");
                visit(ctx.statement(1));
                threeAddressCodeList.add(new ThreeAddressCode("merge", "merge" + ifCounter, null, null));
                emit_main("    br label %merge" + ifCounter);
            } else {
                threeAddressCodeList.add(new ThreeAddressCode("else", "else" + ifCounter, null, null));
                emit_header("else" + ifCounter + ":");
                visit(ctx.statement(1));
                threeAddressCodeList.add(new ThreeAddressCode("merge", "merge" + ifCounter, null, null));
                emit_header("    br label %merge" + ifCounter);
            }
        }

        if (scope_actual.equals("global")) {
            threeAddressCodeList.add(new ThreeAddressCode("merge", "merge" + ifCounter, null, null));
            emit_main("merge" + ifCounter + ":");
            ifCounter++;
        } else {
            threeAddressCodeList.add(new ThreeAddressCode("merge", "merge" + ifCounter, null, null));
            emit_header("merge" + ifCounter + ":");
            ifCounter++;
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
        if (scope_actual.equals("global")) {
            emit_main("br label %while_condition" + whileCounter);
            emit3AC_main(" while br = " + "label" + " while_condition" + whileCounter);
        } else {
            emit_header("br label %while_condition" + whileCounter);
            emit3AC_header(" while br = " + "label" + " while_condition" + whileCounter);
        }
        String[] expresionSplit = statementText.split(" ");
        String currentCounter = generateCondVariable();

        if (scope_actual.equals("global")) {
            emit_main("while_condition" + whileCounter + ":");
            emit3AC_main("while_condition" + whileCounter + ":");
        } else {
            emit_header("while_condition" + whileCounter + ":");
            emit3AC_header("while_condition" + whileCounter + ":");
        }

        if (expresionSplit.length == 1) {

            // aca arreglar detalle de cuando solo hay un argumento en el if
            String variable = expresionSplit[0];
            if (encontrarVariableEnLoads(variable)) {


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
                    if (scope_actual.equals("global")) {
                        String lineToMove = "%" + variable + "_val" + load.getCounter() + " = load i32, i32* %" + variable;
                        emit3AC_main(variable + " = load " + variable + "_val" + load.getCounter());
                        String marker = "while_condition" + whileCounter + ":";
                        emit3AC_main("while_condition" + whileCounter + ":");


                        int lineIndex = llvmCode.indexOf(lineToMove);
                        int markerIndex = llvmCode.indexOf(marker);


                        if (lineIndex != -1 && markerIndex != -1) {
                            // Remove the line from its original position
                            llvmCode.insert(markerIndex + marker.length(), "\n    " + lineToMove + "\n");
                            llvmCode.delete(lineIndex, lineIndex + lineToMove.length());

                            // Insert the line after the marker
                        }

                        break;
                    } else {
                        String lineToMove = "%" + variable + "_val" + load.getCounter() + " = load i32, i32* %" + variable;
                        emit3AC_header(variable + " = load " + variable + "_val" + load.getCounter());
                        String marker = "while_condition" + whileCounter + ":";
                        emit3AC_header("while_condition" + whileCounter + ":");

                        int lineIndex = llvmCode.indexOf(lineToMove);
                        int markerIndex = llvmCode.indexOf(marker);

                        if (lineIndex != -1 && markerIndex != -1) {
                            // Remove the line from its original position
                            llvmCode.insert(markerIndex + marker.length(), "\n    " + lineToMove + "\n");
                            llvmCode.delete(lineIndex, lineIndex + lineToMove.length());

                            // Insert the line after the marker
                        }
                    }
                }
            }


            if (encontrarVariableEnLoads(valor)) {

                switch (operador) {
                    case ">":
                        for (Loads load : loads) {
                            if (load.getVariable().equals(variable)) {
                                for (Loads load2 : loads) {
                                    if (load2.getVariable().equals(valor)) {
                                        threeAddressCodeList.add(new ThreeAddressCode(">", variable + "_val" + load.getCounter(), valor + "_val" + load2.getCounter(), currentCounter));
                                        if (scope_actual.equals("global")) {
                                            emit_main("    %" + currentCounter + " = icmp sgt i32 %" + variable + "_val" + load.getCounter() + ", %" + valor + "_val" + load2.getCounter());
                                            emit3AC_main(currentCounter + " = " + variable + "_val" + load.getCounter() + " > " + valor + "_val" + load2.getCounter());
                                        } else {
                                            emit_header("    %" + currentCounter + " = icmp sgt i32 %" + variable + "_val" + load.getCounter() + ", %" + valor + "_val" + load2.getCounter());
                                            emit3AC_header(currentCounter + " = " + variable + "_val" + load.getCounter() + " > " + valor + "_val" + load2.getCounter());
                                        }
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
                                        if (scope_actual.equals("global")) {
                                            emit_main("    %" + currentCounter + " = icmp slt i32 %" + variable + "_val" + load.getCounter() + ", %" + valor + "_val" + load2.getCounter());
                                            emit3AC_main(currentCounter + " = " + variable + "_val" + load.getCounter() + " < " + valor + "_val" + load2.getCounter());
                                        } else {
                                            emit_header("    %" + currentCounter + " = icmp slt i32 %" + variable + "_val" + load.getCounter() + ", %" + valor + "_val" + load2.getCounter());
                                            emit3AC_header(currentCounter + " = " + variable + "_val" + load.getCounter() + " < " + valor + "_val" + load2.getCounter());
                                        }
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
                                        if (scope_actual.equals("global")) {
                                            emit_main("    %" + currentCounter + " = icmp eq i32 %" + variable + "_val" + load.getCounter() + ", %" + valor + "_val" + load2.getCounter());
                                            emit3AC_main(currentCounter + " = " + variable + "_val" + load.getCounter() + " == " + valor + "_val" + load2.getCounter());
                                        } else {
                                            emit_header("    %" + currentCounter + " = icmp eq i32 %" + variable + "_val" + load.getCounter() + ", %" + valor + "_val" + load2.getCounter());
                                            emit3AC_header(currentCounter + " = " + variable + "_val" + load.getCounter() + " == " + valor + "_val" + load2.getCounter());
                                        }
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
                                        if (scope_actual.equals("global")) {
                                            emit_main("    %" + currentCounter + " = icmp ne i32 %" + variable + "_val" + load.getCounter() + ", %" + valor + "_val" + load2.getCounter());
                                            emit3AC_main(currentCounter + " = " + variable + "_val" + load.getCounter() + " <> " + valor + "_val" + load2.getCounter());
                                        } else {
                                            emit_header("    %" + currentCounter + " = icmp ne i32 %" + variable + "_val" + load.getCounter() + ", %" + valor + "_val" + load2.getCounter());
                                            emit3AC_header(currentCounter + " = " + variable + "_val" + load.getCounter() + " <> " + valor + "_val" + load2.getCounter());
                                        }
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
                                        if (scope_actual.equals("global")) {
                                            emit_main("    %" + currentCounter + " = icmp sge i32 %" + variable + "_val" + load.getCounter() + ", %" + valor + "_val" + load2.getCounter());
                                            emit3AC_main(currentCounter + " = " + variable + "_val" + load.getCounter() + " >= " + valor + "_val" + load2.getCounter());
                                        } else {
                                            emit_header("    %" + currentCounter + " = icmp sge i32 %" + variable + "_val" + load.getCounter() + ", %" + valor + "_val" + load2.getCounter());
                                            emit3AC_header(currentCounter + " = " + variable + "_val" + load.getCounter() + " >= " + valor + "_val" + load2.getCounter());
                                        }
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
                                        if (scope_actual.equals("global")) {
                                            emit_main("    %" + currentCounter + " = icmp sle i32 %" + variable + "_val" + load.getCounter() + ", %" + valor + "_val" + load2.getCounter());
                                            emit3AC_main(currentCounter + " = " + variable + "_val" + load.getCounter() + " <= " + valor + "_val" + load2.getCounter());
                                        } else {
                                            emit_header("    %" + currentCounter + " = icmp sle i32 %" + variable + "_val" + load.getCounter() + ", %" + valor + "_val" + load2.getCounter());
                                            emit3AC_header(currentCounter + " = " + variable + "_val" + load.getCounter() + " <= " + valor + "_val" + load2.getCounter());
                                        }
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
                                        if (scope_actual.equals("global")) {
                                            emit_main("    %" + currentCounter + " = and i1 %" + variable + "_val" + load.getCounter() + ", %" + valor + "_val" + load2.getCounter());
                                            emit3AC_main(currentCounter + " = " + variable + "_val" + load.getCounter() + " and " + valor + "_val" + load2.getCounter());
                                        } else {
                                            emit_header("    %" + currentCounter + " = and i1 %" + variable + "_val" + load.getCounter() + ", %" + valor + "_val" + load2.getCounter());
                                            emit3AC_header(currentCounter + " = " + variable + "_val" + load.getCounter() + " and " + valor + "_val" + load2.getCounter());
                                        }
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
                                        if (scope_actual.equals("global")) {
                                            emit_main("    %" + currentCounter + " = or i1 %" + variable + "_val" + load.getCounter() + ", %" + valor + "_val" + load2.getCounter());
                                            emit3AC_main(currentCounter + " = " + variable + "_val" + load.getCounter() + " or " + valor + "_val" + load2.getCounter());
                                        } else {
                                            emit_header("    %" + currentCounter + " = or i1 %" + variable + "_val" + load.getCounter() + ", %" + valor + "_val" + load2.getCounter());
                                            emit3AC_header(currentCounter + " = " + variable + "_val" + load.getCounter() + " or " + valor + "_val" + load2.getCounter());
                                        }
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
                                        if (scope_actual.equals("global")) {
                                            emit_main("    %" + currentCounter + " = xor i1 %" + variable + "_val" + load.getCounter() + ", 1");
                                            emit3AC_main(currentCounter + " = " + variable + "_val" + load.getCounter() + " not " + valor + "_val" + load2.getCounter());
                                        } else {
                                            emit_header("    %" + currentCounter + " = xor i1 %" + variable + "_val" + load.getCounter() + ", 1");
                                            emit3AC_header(currentCounter + " = " + variable + "_val" + load.getCounter() + " not " + valor + "_val" + load2.getCounter());
                                        }
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

                    switch (operador) {
                        case ">":
                            for (Loads load : loads) {
                                if (load.getVariable().equals(variable)) {
                                    threeAddressCodeList.add(new ThreeAddressCode(">", variable + "_val" + load.getCounter(), valor, currentCounter));
                                    if (scope_actual.equals("global")) {
                                        emit_main("    %" + currentCounter + " = icmp sgt i32 %" + variable + "_val" + load.getCounter() + ", " + valor);
                                        emit3AC_main(currentCounter + " = " + variable + "_val" + load.getCounter() + " > " + valor);
                                    } else {
                                        emit_header("    %" + currentCounter + " = icmp sgt i32 %" + variable + "_val" + load.getCounter() + ", " + valor);
                                        emit3AC_header(currentCounter + " = " + variable + "_val" + load.getCounter() + " > " + valor);
                                    }
                                    break;
                                }
                            }
                            break;
                        case "<":
                            for (Loads load : loads) {
                                if (load.getVariable().equals(variable)) {
                                    threeAddressCodeList.add(new ThreeAddressCode("<", variable + "_val" + load.getCounter(), valor, currentCounter));
                                    if (scope_actual.equals("global")) {
                                        emit_main("    %" + currentCounter + " = icmp slt i32 %" + variable + "_val" + load.getCounter() + ", " + valor);
                                        emit3AC_main(currentCounter + " = " + variable + "_val" + load.getCounter() + " < " + valor);
                                    } else {
                                        emit_header("    %" + currentCounter + " = icmp slt i32 %" + variable + "_val" + load.getCounter() + ", " + valor);
                                        emit3AC_header(currentCounter + " = " + variable + "_val" + load.getCounter() + " < " + valor);
                                    }
                                    break;
                                }
                            }
                            break;
                        case "=":
                            for (Loads load : loads) {
                                if (load.getVariable().equals(variable)) {
                                    threeAddressCodeList.add(new ThreeAddressCode("==", variable + "_val" + load.getCounter(), valor, currentCounter));
                                    if (scope_actual.equals("global")) {
                                        emit_main("    %" + currentCounter + " = icmp eq i32 %" + variable + "_val" + load.getCounter() + ", " + valor);
                                        emit3AC_main(currentCounter + " = " + variable + "_val" + load.getCounter() + " == " + valor);
                                    } else {
                                        emit_header("    %" + currentCounter + " = icmp eq i32 %" + variable + "_val" + load.getCounter() + ", " + valor);
                                        emit3AC_header(currentCounter + " = " + variable + "_val" + load.getCounter() + " == " + valor);
                                    }
                                    break;
                                }
                            }
                            break;
                        case "<>":
                            for (Loads load : loads) {
                                if (load.getVariable().equals(variable)) {
                                    threeAddressCodeList.add(new ThreeAddressCode("!=", variable + "_val" + load.getCounter(), valor, currentCounter));
                                    if (scope_actual.equals("global")) {
                                        emit_main("    %" + currentCounter + " = icmp ne i32 %" + variable + "_val" + load.getCounter() + ", " + valor);
                                        emit3AC_main(currentCounter + " = " + variable + "_val" + load.getCounter() + " <> " + valor);
                                    } else {
                                        emit_header("    %" + currentCounter + " = icmp ne i32 %" + variable + "_val" + load.getCounter() + ", " + valor);
                                        emit3AC_header(currentCounter + " = " + variable + "_val" + load.getCounter() + " <> " + valor);
                                    }
                                    break;
                                }
                            }
                            break;
                        case ">=":
                            for (Loads load : loads) {
                                if (load.getVariable().equals(variable)) {
                                    threeAddressCodeList.add(new ThreeAddressCode(">=", variable + "_val" + load.getCounter(), valor, currentCounter));
                                    if (scope_actual.equals("global")) {
                                        emit_main("    %" + currentCounter + " = icmp sge i32 %" + variable + "_val" + load.getCounter() + ", " + valor);
                                        emit3AC_main(currentCounter + " = " + variable + "_val" + load.getCounter() + " >= " + valor);
                                    } else {
                                        emit_header("    %" + currentCounter + " = icmp sge i32 %" + variable + "_val" + load.getCounter() + ", " + valor);
                                        emit3AC_header(currentCounter + " = " + variable + "_val" + load.getCounter() + " >= " + valor);
                                    }
                                    break;
                                }
                            }
                            break;
                        case "<=":
                            for (Loads load : loads) {
                                if (load.getVariable().equals(variable)) {
                                    threeAddressCodeList.add(new ThreeAddressCode("<=", variable + "_val" + load.getCounter(), valor, currentCounter));
                                    if (scope_actual.equals("global")) {
                                        emit_main("    %" + currentCounter + " = icmp sle i32 %" + variable + "_val" + load.getCounter() + ", " + valor);
                                        emit3AC_main(currentCounter + " = " + variable + "_val" + load.getCounter() + " <= " + valor);
                                    } else {
                                        emit_header("    %" + currentCounter + " = icmp sle i32 %" + variable + "_val" + load.getCounter() + ", " + valor);
                                        emit3AC_header(currentCounter + " = " + variable + "_val" + load.getCounter() + " <= " + valor);
                                    }
                                    break;
                                }
                            }
                            break;
                        case "and":
                            for (Loads load : loads) {
                                if (load.getVariable().equals(variable)) {
                                    threeAddressCodeList.add(new ThreeAddressCode("and", variable + "_val" + load.getCounter(), valor, currentCounter));
                                    if (scope_actual.equals("global")) {
                                        emit_main("    %" + currentCounter + " = and i1 %" + variable + "_val" + load.getCounter() + ", " + valor);
                                        emit3AC_main(currentCounter + " = " + variable + "_val" + load.getCounter() + " and " + valor);
                                    } else {
                                        emit_header("    %" + currentCounter + " = and i1 %" + variable + "_val" + load.getCounter() + ", " + valor);
                                        emit3AC_header(currentCounter + " = " + variable + "_val" + load.getCounter() + " and " + valor);
                                    }
                                    break;
                                }
                            }
                            break;
                        case "or":
                            for (Loads load : loads) {
                                if (load.getVariable().equals(variable)) {
                                    threeAddressCodeList.add(new ThreeAddressCode("or", variable + "_val" + load.getCounter(), valor, currentCounter));
                                    if (scope_actual.equals("global")) {
                                        emit_main("    %" + currentCounter + " = or i1 %" + variable + "_val" + load.getCounter() + ", " + valor);
                                        emit3AC_main(currentCounter + " = " + variable + "_val" + load.getCounter() + " or " + valor);
                                    } else {
                                        emit_header("    %" + currentCounter + " = or i1 %" + variable + "_val" + load.getCounter() + ", " + valor);
                                        emit3AC_header(currentCounter + " = " + variable + "_val" + load.getCounter() + " or " + valor);
                                    }
                                    break;
                                }
                            }
                            break;
                        case "not":
                            for (Loads load : loads) {
                                if (load.getVariable().equals(variable)) {
                                    threeAddressCodeList.add(new ThreeAddressCode("not", variable + "_val" + load.getCounter(), valor, currentCounter));
                                    if (scope_actual.equals("global")) {
                                        emit_main("    %" + currentCounter + " = xor i1 %" + variable + "_val" + load.getCounter() + ", 1");
                                        emit3AC_main(currentCounter + " = " + variable + "_val" + load.getCounter() + " not " + valor);
                                    } else {
                                        emit_header("    %" + currentCounter + " = xor i1 %" + variable + "_val" + load.getCounter() + ", 1");
                                        emit3AC_header(currentCounter + " = " + variable + "_val" + load.getCounter() + " not " + valor);
                                    }
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
            if (scope_actual.equals("global")) {
                emit_main("    br i1 %" + currentCounter + ", label %while_body" + whileCounter + ", label %while_end" + whileCounter);
                emit3AC_main("while br = " + "do" + whileCounter + " else " + "else" + whileCounter + " goto " + currentCounter);
            } else {
                emit_header("    br i1 %" + currentCounter + ", label %while_body" + whileCounter + ", label %while_end" + whileCounter);
                emit3AC_header("while br = " + "do" + whileCounter + " else " + "else" + whileCounter + " goto " + currentCounter);
            }
        }

        threeAddressCodeList.add(new ThreeAddressCode("do", "while_body" + whileCounter, null, null));
        if (scope_actual.equals("global")) {
            emit_main("while_body" + whileCounter + ":");
            emit3AC_main("while_body" + whileCounter + ":");
        } else {
            emit_header("while_body" + whileCounter + ":");
            emit3AC_header("while_body" + whileCounter + ":");
        }

        //while body
//        if (/* condition to recognize another statement */) {
//            String condVar = generateCondVariable();
//            emit("    %" + condVar + " = icmp slt i32 %i_val1, 3");
//            emit("    br i1 %" + condVar + ", label %then" + whileCounter + ", label %else" + whileCounter);
//        }
        visit(ctx.statement());


        if (scope_actual.equals("global")) {
            emit_main("    br label %while_condition" + whileCounter);
            emit3AC_main("while br = " + "label" + " while_condition" + whileCounter);
            threeAddressCodeList.add(new ThreeAddressCode("end", "while_end" + whileCounter, null, null));
            emit_main("while_end" + whileCounter + ":");
            emit3AC_main("while_end" + whileCounter + ":");
            whileCounter++;
            System.out.println();
            return null;
        } else {
            emit_header("    br label %while_condition" + whileCounter);
            emit3AC_header("while br = " + "label" + " while_condition" + whileCounter);
            threeAddressCodeList.add(new ThreeAddressCode("end", "while_end" + whileCounter, null, null));
            emit_header("while_end" + whileCounter + ":");
            emit3AC_header("while_end" + whileCounter + ":");
            whileCounter++;
            System.out.println();
            return null;
        }
    }


    @Override
    public Object visitRepeatStatement(MiniPascalGrammarParser.RepeatStatementContext ctx) {


        String statementText = ctx.statements().getText();
        if (statementText.startsWith("begin") && statementText.endsWith("end")) {
            statementText = statementText.substring(5, statementText.length() - 3).trim();

            String[] statements = statementText.split(";");
            for (String stmt : statements) {
                System.out.println(" " + stmt.trim());
            }
        } else {
        }
        System.out.println();
        return null;
    }

    @Override
    public Object visitForStatement(MiniPascalGrammarParser.ForStatementContext ctx) {


        String statementText = ctx.statement().getText();
        if (statementText.startsWith("begin") && statementText.endsWith("end")) {
            statementText = statementText.substring(5, statementText.length() - 3).trim();

            String[] statements = statementText.split(";");
            for (String stmt : statements) {
                System.out.println(" " + stmt.trim());
            }
        } else {
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