import org.antlr.v4.runtime.*;
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
//        List<String> stack = ((Parser)recognizer).getRuleInvocationStack();
//        Collections.reverse(stack);
//        System.err.println("rule stack: "+stack);
//        System.out.println(e);
        String errorType = (e == null) ? "Léxico" : "Sintáctico";
        String translatedMsg = translateErrorMessage(msg, e, recognizer);
        System.err.println("Error de tipo: " + errorType);
        System.err.println("linea "+line+" - " + "caracter " +charPositionInLine+" " + translatedMsg);
        underlineError(recognizer,(Token)offendingSymbol,
                line, charPositionInLine);
    }
    private String translateErrorMessage(String msg, RecognitionException e, Recognizer<?, ?> recognizer) {
        if (e instanceof NoViableAltException) {
            msg = "No hay una alternativa viable en la entrada.";
        } else if (e instanceof InputMismatchException) {
            InputMismatchException ime = (InputMismatchException) e;
            msg = "Entrada no coincidente. Cambielo por alguna de las siguientes opciones: " + ime.getExpectedTokens().toString(recognizer.getVocabulary());
        } else if (e instanceof FailedPredicateException) {
            msg = "Predicado fallido.";
        } else if (e instanceof LexerNoViableAltException) {
            msg = "No hay una alternativa viable en el lexer.";
        } else {
            msg = "Error de reconocimiento.";
        }
        return msg;
    }
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
//            System.err.println("Error: El input stream no es una instancia de CommonTokenStream.");
        }
    }

    public int getErrorCount() {
        return errorCount;
    }

}
