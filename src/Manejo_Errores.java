import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.Interval;
import org.antlr.v4.runtime.misc.ParseCancellationException;

import java.util.Collections;
import java.util.List;

public class Manejo_Errores extends BaseErrorListener {

    private int errorCount = 0;

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer,
                            Object offendingSymbol,
                            int line, int charPositionInLine,
                            String msg,
                            RecognitionException e)
    {
        errorCount++;

        String errorType = "Sintáctico";

        if (msg.contains("Error léxico")) {
            errorType = "Léxico";
        }
        // Verificar si es un error léxico
        else if (e instanceof LexerNoViableAltException) {
            errorType = "Léxico";
//            msg = "Error léxico: el símbolo '" + offendingSymbol + "' no es válido en esta posición.";
            LexerNoViableAltException lne = (LexerNoViableAltException) e;
            String offendingText = lne.getInputStream().getText(Interval.of(lne.getStartIndex(), lne.getStartIndex()));
            msg = "Error léxico: el símbolo '" + offendingText + "' no es válido en esta posición. ";
        }
        // Verificar si es un error sintáctico
        else if (e instanceof InputMismatchException) {
            errorType = "Sintáctico";
            InputMismatchException ime = (InputMismatchException) e;
            msg = "Error sintáctico: entrada no coincidente. Se esperaba uno de los siguientes tokens: " +
                    ime.getExpectedTokens().toString(recognizer.getVocabulary());
        } else if (e instanceof NoViableAltException) {
            errorType = "Sintáctico";
            msg = "Error sintáctico: no hay alternativa viable en la entrada.";
        } else if (e instanceof FailedPredicateException) {
            errorType = "Sintáctico";
            msg = "Error sintáctico: predicado fallido.";
        } else {
//            errorType = "Sintáctico";
//            msg = "Error sintáctico no reconocido.";
        }

        System.err.println("Error de tipo: " + errorType);
        System.err.println("Línea " + line + " - carácter " + charPositionInLine + ": " + msg);

        underlineError(recognizer, (Token) offendingSymbol, line, charPositionInLine);
    }
//    private String translateErrorMessage(String msg, RecognitionException e, Recognizer<?, ?> recognizer) {
//        if (e instanceof NoViableAltException) {
//            msg = "No hay una alternativa viable en la entrada.";
//        } else if (e instanceof InputMismatchException) {
//            InputMismatchException ime = (InputMismatchException) e;
//            msg = "Entrada no coincidente. Cambielo por alguna de las siguientes opciones: " + ime.getExpectedTokens().toString(recognizer.getVocabulary());
//        } else if (e instanceof FailedPredicateException) {
//            msg = "Predicado fallido.";
//        } else if (e instanceof LexerNoViableAltException) {
//            LexerNoViableAltException lne = (LexerNoViableAltException) e;
//            String offendingText = lne.getInputStream().getText(Interval.of(lne.getStartIndex(), lne.getStartIndex()));
//            msg = "Error léxico: el símbolo '" + offendingText + "' no es válido en esta posición.";
//        } else {
////            System.out.println("holaaaaaaaa" + e.getMessage());
////            msg = "Error de reconocimiento.";
//        }
//        return msg;
//    }

    protected void underlineError(Recognizer recognizer,
                                  Token offendingToken, int line,
                                  int charPositionInLine) {
        if (recognizer.getInputStream() instanceof CommonTokenStream) {
            CommonTokenStream tokens = (CommonTokenStream) recognizer.getInputStream();
            String input = tokens.getTokenSource().getInputStream().toString();
            String[] lines = input.split("\n");
            String errorLine = lines[line - 1];
            System.err.println(errorLine);
            for (int i = 0; i < charPositionInLine; i++) System.err.print(" ");
            int start = offendingToken.getStartIndex();
            int stop = offendingToken.getStopIndex();
            if (start >= 0 && stop >= 0) {
                for (int i = start; i <= stop; i++) System.err.print("^");
            }
            System.err.println();
        } else {
            errorCount++;
//            System.err.println("Error: El input stream no es una instancia de CommonTokenStream.");
        }
    }

//    protected void underlineError(Recognizer recognizer, Token offendingToken, int line, int charPositionInLine) {
//        if (recognizer.getInputStream() instanceof CommonTokenStream) {
//            CommonTokenStream tokens = (CommonTokenStream) recognizer.getInputStream();
//            String input = tokens.getTokenSource().getInputStream().toString();
//            String[] lines = input.split("\n");
//
//            int contextLines = 2;  // Mostrar 2 líneas antes y después del error
//            for (int i = Math.max(0, line - contextLines - 1); i <= Math.min(lines.length - 1, line + contextLines - 1); i++) {
//                System.err.println((i + 1) + ": " + lines[i]);
//            }
//
//            // Subrayar el error
//            for (int i = 0; i < charPositionInLine; i++) System.err.print(" ");
//            int start = offendingToken.getStartIndex();
//            int stop = offendingToken.getStopIndex();
//            if (start >= 0 && stop >= 0) {
//                for (int i = start; i <= stop; i++) System.err.print("^");
//            }
//            System.err.println();
//        }
//    }


    public int getErrorCount() {
        return errorCount;
    }

}
