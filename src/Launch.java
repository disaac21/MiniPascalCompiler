import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.PredictionMode;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import java.io.File;

import static org.antlr.v4.runtime.CharStreams.fromFileName;


public class Launch {

    public static void main(String[] args) {

        try {
//             Create a new JFrame (this is optional, just to have a parent for the JFileChooser)
            JFrame frame = new JFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);

            // Get the current working directory (project directory)
            String projectDirectory = System.getProperty("user.dir");

            // Create a JFileChooser instance
            JFileChooser fileChooser = new JFileChooser(projectDirectory);

            // Open the file chooser dialog
            int returnValue = fileChooser.showOpenDialog(frame);
            String filePath = "";
            // Check if the user selected a file
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                // Get the selected file
                File selectedFile = fileChooser.getSelectedFile();

                // Get the path of the selected file and save it in a variable
                filePath = selectedFile.getAbsolutePath();

                // Print the file path to the console
                System.out.println("Selected file path: " + filePath);
            } else {
                System.out.println("No file was selected.");
            }

//             Close the JFrame
            frame.dispose();
            String source = filePath;
//            String source = "C:\\Users\\serli\\Compi 1 Serlio\\Proyecto Daniel\\MiniPascalCompiler\\ejemplo_ingeniero.txt";
//            String source = "C:\\Users\\danie\\Desktop\\MiniPascalCompiler\\src\\test.txt";

            CharStream cs = fromFileName(source);
            MiniPascalGrammarLexer Lexer = new MiniPascalGrammarLexer(cs);
            Lexer.removeErrorListeners();
            Lexer.addErrorListener(new Manejo_Errores());

            CommonTokenStream token = new CommonTokenStream(Lexer);

            MiniPascalGrammarParser parser = new MiniPascalGrammarParser(token);
            parser.removeErrorListeners();
            parser.addErrorListener(new Manejo_Errores());
//            parser.addErrorListener(new DiagnosticErrorListener());
//            parser.setErrorHandler(new CustomErrorStrategy());
            parser.setErrorHandler(new DefaultErrorStrategy());

//            parser.getInterpreter()
//                    .setPredictionMode(PredictionMode.LL_EXACT_AMBIG_DETECTION);


            ParseTree tree = parser.program();

            int errorCount = parser.getErrorListeners().stream()
                    .filter(el -> el instanceof Manejo_Errores)
                    .map(el -> (Manejo_Errores) el)
                    .mapToInt(Manejo_Errores::getErrorCount)
                    .sum();
//            System.err.println("Numero de errores: " + errorCount);

            if (errorCount == 0){
                String verde = "\u001B[32m";
                String reset = "\u001B[0m";

                System.out.println(verde + "Compilado exitosamente" + reset);
                MyVisitor visitor = new MyVisitor();
                visitor.visit(tree);
            }
//            MyVisitor visitor = new MyVisitor();
//            visitor.visit(tree);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}