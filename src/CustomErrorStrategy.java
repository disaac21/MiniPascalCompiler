import org.antlr.v4.runtime.InputMismatchException;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.misc.IntervalSet;
import org.antlr.v4.runtime.DefaultErrorStrategy;

public class CustomErrorStrategy extends DefaultErrorStrategy {

    @Override
    public void reportError(Parser recognizer, RecognitionException e) {
        // Personaliza la forma en que se reportan los errores de reconocimiento
        String message = "Error de reconocimiento: " + e.getMessage();
        // Puedes lanzar una excepción o manejar el error según tu preferencia
//        throw new RuntimeException(message, e);
    }

    @Override
    public void recover(Parser recognizer, RecognitionException e) {
        // Personaliza la forma de recuperación ante errores
        String message = "Error en la recuperación: Intentando continuar después del error.";
        System.err.println(message);
        // Llama a la recuperación predeterminada si aún quieres continuar
        super.recover(recognizer, e);
    }

    @Override
    public Token recoverInline(Parser recognizer) throws RecognitionException {
        // Personaliza la recuperación durante un desajuste de tokens
        String message = "Error de desajuste de token: se esperaba uno de los siguientes: " + getExpectedTokens(recognizer).toString(recognizer.getVocabulary())
                + "en linea " + recognizer.getContext().start.getLine()
                + " en la posición " + recognizer.getContext().start.getCharPositionInLine();
        System.err.println(message);
        // Llama al comportamiento predeterminado de recuperación en línea
        return super.recoverInline(recognizer);
    }

    @Override
    public void sync(Parser recognizer) throws RecognitionException {
        // Modifica la sincronización después de un error
        String message = "Sincronización del parser después de un error.";
//        System.err.println(message);
        // Puedes mantener el comportamiento estándar si lo deseas
        super.sync(recognizer);
    }
}
