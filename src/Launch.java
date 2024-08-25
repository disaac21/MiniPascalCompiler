import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import java.io.File;

import static org.antlr.v4.runtime.CharStreams.fromFileName;

public class Launch {

    public static void main(String[] args) {

        try {
            // Create a new JFrame (this is optional, just to have a parent for the JFileChooser)
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

            // Close the JFrame
            String source = filePath;
            frame.dispose();
            CharStream cs = fromFileName(source);
            MiniPascalGrammarLexer Lexer = new MiniPascalGrammarLexer(cs);
            CommonTokenStream token = new CommonTokenStream(Lexer);
            MiniPascalGrammarParser parser = new MiniPascalGrammarParser(token);
            ParseTree tree = parser.program();

            MyVisitor visitor = new MyVisitor();
            visitor.visit(tree);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}