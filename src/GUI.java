
import java.io.BufferedReader;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.DefaultErrorStrategy;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CharStream;

import org.antlr.v4.*;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import static org.antlr.v4.runtime.CharStreams.fromFileName;

public class GUI extends javax.swing.JFrame {

    static File currentFile;

    public GUI() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TextAreaScrollPane = new javax.swing.JScrollPane();
        TextArea = new javax.swing.JTextArea();
        TerminalScrollPane = new javax.swing.JScrollPane();
        Terminal = new javax.swing.JTextArea();
        MenuBar = new javax.swing.JMenuBar();
        FileMenu = new javax.swing.JMenu();
        OpenFileMenuItem = new javax.swing.JMenuItem();
        RunMenu = new javax.swing.JMenu();
        RunFileMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        TextArea.setColumns(20);
        TextArea.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        TextArea.setRows(5);
        TextAreaScrollPane.setViewportView(TextArea);

        Terminal.setColumns(20);
        Terminal.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        Terminal.setRows(5);
        TerminalScrollPane.setViewportView(Terminal);

        FileMenu.setText("File");

        OpenFileMenuItem.setText("Open File");
        OpenFileMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OpenFileMenuItemActionPerformed(evt);
            }
        });
        FileMenu.add(OpenFileMenuItem);

        MenuBar.add(FileMenu);

        RunMenu.setText("Run");

        RunFileMenuItem.setText("Run File");
        RunFileMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RunFileMenuItemActionPerformed(evt);
            }
        });
        RunMenu.add(RunFileMenuItem);

        MenuBar.add(RunMenu);

        setJMenuBar(MenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(135, Short.MAX_VALUE)
                .addComponent(TextAreaScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(415, 415, 415))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(692, Short.MAX_VALUE)
                    .addComponent(TerminalScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TextAreaScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 565, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(TerminalScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 565, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void OpenFileMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OpenFileMenuItemActionPerformed
        showFileContent();
    }//GEN-LAST:event_OpenFileMenuItemActionPerformed

    private void RunFileMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RunFileMenuItemActionPerformed
        procesoCompiUno();
    }//GEN-LAST:event_RunFileMenuItemActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI().setVisible(true);
            }
        });
    }

    public void procesoCompiUno() {
        if (TextArea.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Debe Cargar un Programa");
        } else {
            try {
                Terminal.setText("");

//                String filePath = currentFile.getAbsolutePath(); // Get the path of the selected file and save it in a variable
//
//                System.out.println("Selected file path: " + filePath); // Print the file path to the console
//                Terminal.append("Selected file path: " + filePath + "\n");
//                String source = filePath;

                Manejo_Errores errorListener = new Manejo_Errores(Terminal);
                CharStream cs = CharStreams.fromString(TextArea.getText());
                MiniPascalGrammarLexer Lexer = new MiniPascalGrammarLexer(cs);
                Lexer.removeErrorListeners();
                Lexer.addErrorListener(errorListener);

                CommonTokenStream token = new CommonTokenStream(Lexer);

                MiniPascalGrammarParser parser = new MiniPascalGrammarParser(token);
                parser.removeErrorListeners();
                parser.addErrorListener(errorListener);
                parser.setErrorHandler(new DefaultErrorStrategy());

                ParseTree tree = parser.program();

                System.err.println("Numero de errores: " + errorListener.getErrorCount());
                Terminal.append("Numero de errores: " + errorListener.getErrorCount() + "\n");

                if (errorListener.getErrorCount() == 0) {
                    String verde = "\u001B[32m";
                    String reset = "\u001B[0m";

                    System.out.println(verde + "Compilado exitosamente" + reset);
                    Terminal.append("Compilado exitosamente\n");
                    MyVisitor visitor = new MyVisitor();
                    visitor.visit(tree);

                    IRVisitors irVisitor = new IRVisitors();
                    irVisitor.visit(tree);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void showFileContent() {
        FileReader fr = null;
        BufferedReader br = null;
        TextArea.setText("");

        try {
            String projectDirectory = System.getProperty("user.dir");
            JFileChooser jfc = new JFileChooser(projectDirectory);

            int returnValue = jfc.showOpenDialog(this);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                currentFile = jfc.getSelectedFile();

                fr = new FileReader(currentFile);
                br = new BufferedReader(fr);
                String linea;
                TextArea.setText("");
                while ((linea = br.readLine()) != null) {
                    TextArea.append(linea);
                    TextArea.append("\n");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Seleccione un Archivo.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        if (br != null) {
            try {
                br.close();
            } catch (IOException ex) {
                System.out.println("Buffer Error");
            }
        }
        if (fr != null) {
            try {
                fr.close();
            } catch (IOException ex) {
                System.out.println("Buffer Error");
            }
        }
        TextArea.setEditable(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu FileMenu;
    private javax.swing.JMenuBar MenuBar;
    private javax.swing.JMenuItem OpenFileMenuItem;
    private javax.swing.JMenuItem RunFileMenuItem;
    private javax.swing.JMenu RunMenu;
    private javax.swing.JTextArea Terminal;
    private javax.swing.JScrollPane TerminalScrollPane;
    private javax.swing.JTextArea TextArea;
    private javax.swing.JScrollPane TextAreaScrollPane;
    // End of variables declaration//GEN-END:variables
}
