import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.IOException;

import static org.antlr.v4.runtime.CharStreams.fromFileName;

public class Launch {

    public static void main(String[] args) {

        try {
            String source = "test.txt";
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