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
//        String translatedMsg = translateErrorMessage(msg);
        System.err.println("Error de tipo: " + errorType);
        System.err.println("linea "+line+" - " + "caracter " +charPositionInLine+" " + msg);
        underlineError(recognizer,(Token)offendingSymbol,
                line, charPositionInLine);
    }
    private String translateErrorMessage(String msg) {
        // Aquí puedes agregar más traducciones según sea necesario
        if (msg.contains("mismatched input")) {
            msg = msg.replace("mismatched input", "entrada no coincidente");
            msg = msg.replace("expecting", "se esperaba");
        }

        return msg;
    }
    protected void underlineError(Recognizer recognizer,
                                  Token offendingToken, int line,
                                  int charPositionInLine) {
        CommonTokenStream tokens =
                (CommonTokenStream)recognizer.getInputStream();
        String input = tokens.getTokenSource().getInputStream().toString();
        String[] lines = input.split("\n");
        String errorLine = lines[line - 1];
        System.err.println(errorLine);
        for (int i=0; i<charPositionInLine; i++) System.err.print(" ");
        int start = offendingToken.getStartIndex();
        int stop = offendingToken.getStopIndex();
        if ( start>=0 && stop>=0 ) {
            for (int i=start; i<=stop; i++) System.err.print("^");
        }
        System.err.println();
    }

    public int getErrorCount() {
        return errorCount;
    }

}
