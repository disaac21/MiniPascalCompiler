import org.antlr.runtime.MissingTokenException;
import org.antlr.runtime.UnwantedTokenException;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.Interval;
import org.antlr.v4.runtime.misc.IntervalSet;
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
        else if (msg.contains("missing")) {
            errorType = "Sintáctico";

            // Get expected tokens from the recognizer
            String expectedTokens = getExpectedTokens(recognizer);

            // Customize the message for a missing token error
            msg = "Falta un token. Se esperaba uno de los siguientes: " + expectedTokens;
        }
        else if (msg.contains("extraneous input")) {
            String extraneousToken = ((Token) offendingSymbol).getText();
            String expectedTokens = getExpectedTokens(recognizer);

            // Personaliza el mensaje para errores de "extraneous input"
            msg = "Token inesperado '" + extraneousToken + "' en línea " + line +
                    ", posición " + charPositionInLine + "." + '\n' +
            "Se esperaba uno de los siguientes tokens: " + expectedTokens;

        }
        // Verificar si es un error léxico
        else if (e instanceof LexerNoViableAltException) {
            errorType = "Léxico";
            LexerNoViableAltException lne = (LexerNoViableAltException) e;
            String offendingText = lne.getInputStream().getText(Interval.of(lne.getStartIndex(), lne.getStartIndex()));
            msg = "Error léxico: el símbolo '" + offendingText + "' no es válido en esa posición. ";

        }
        // Verificar si es un error sintáctico
        else if (e instanceof InputMismatchException) {
            errorType = "Sintáctico";
            InputMismatchException ime = (InputMismatchException) e;
            Token unwantedToken = (Token) offendingSymbol;
            msg = " entrada "+ unwantedToken.getText() + " no coincidente. Se esperaba uno de los siguientes tokens: " +
                    ime.getExpectedTokens().toString(recognizer.getVocabulary());
        } else if (e instanceof NoViableAltException) {
            errorType = "Sintáctico";
            Token unwantedToken = (Token) offendingSymbol;
            msg = " no hay alternativa viable en la entrada \'"+ unwantedToken.getText() +"\' . Se esperaba uno de los siguientes: " +
                    ((NoViableAltException) e).getExpectedTokens().toString(recognizer.getVocabulary());
        } else if (e instanceof FailedPredicateException) {
            errorType = "Sintáctico";
            msg = " predicado fallido.";
        } else {
            errorType = "Sintáctico";
//            msg = "Error sintáctico no reconocido.";
        }

        System.err.println(e);
        System.err.println();
        System.err.println("Error de tipo: " + errorType);
        System.err.println("Línea " + line + " - carácter " + charPositionInLine + ": " + msg);

        underlineError(recognizer, (Token) offendingSymbol, line, charPositionInLine);
    }



    public static int countDigits(int number) {
        // Convert the number to a string
        String numberStr = Integer.toString(number);
        // Return the length of the string
        return numberStr.length();
    }

    protected void underlineError(Recognizer recognizer,
                                  Token offendingToken, int line,
                                  int charPositionInLine) {
        if (recognizer.getInputStream() instanceof CommonTokenStream) {
            CommonTokenStream tokens = (CommonTokenStream) recognizer.getInputStream();
            String input = tokens.getTokenSource().getInputStream().toString();
            String[] lines = input.split("\n");
//            System.err.println(lines.length);
//            System.err.println("ultima " + lines[lines.length-1]);
            String errorLine = lines[line - 1];
            System.err.println();
            System.err.println((line) + ": " + errorLine);

            for (int i = 0; i < charPositionInLine + countDigits(line) + 2; i++) System.err.print(" ");
            int start = offendingToken.getStartIndex();
            int stop = offendingToken.getStopIndex();
            if (start >= 0 && stop >= 0) {
                for (int i = start; i <= stop; i++) System.err.print("^");
            }
            System.err.println();
        } else {
//            errorCount++;
//            System.err.println("Error: El input stream no es una instancia de CommonTokenStream.");
        }
    }

    private String getExpectedTokens(Recognizer<?, ?> recognizer) {
        if (recognizer instanceof Parser) {
            Parser parser = (Parser) recognizer;
            Vocabulary vocab = parser.getVocabulary();
            IntervalSet expectedTokens = parser.getExpectedTokens();
            StringBuilder tokens = new StringBuilder();
            for (int token : expectedTokens.toList()) {
                tokens.append(vocab.getDisplayName(token)).append(", ");
            }
            if (tokens.length() > 0) {
                tokens.setLength(tokens.length() - 2);  // Elimina la coma extra
            }
            return tokens.toString();
        }
        return "";
    }



    public int getErrorCount() {
        return errorCount;
    }

//    protected void underlineError(Recognizer recognizer, Token offendingToken, int line, int charPositionInLine) {
//        if (recognizer.getInputStream() instanceof CommonTokenStream) {
//            CommonTokenStream tokens = (CommonTokenStream) recognizer.getInputStream();
//            String input = tokens.getTokenSource().getInputStream().toString();
//            String[] lines = input.split("\n");
//
//            String errorLine = lines[line - 1];
//            System.err.println((line) + ": " + errorLine);
//
//            // Subrayar el error
//            for (int i = 0; i < charPositionInLine + countDigits(line) + 2; i++) System.err.print(" ");
//            int start = offendingToken.getStartIndex();
//            int stop = offendingToken.getStopIndex();
//            if (start >= 0 && stop >= 0) {
//                for (int i = start; i <= stop; i++) System.err.print("^");
//            }
//            System.err.println();
//            System.err.println();
//        }
//    }
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
