import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


class ThreeAddressCode {
    String operation; // Operación (e.g., asignación, suma, comparación)
    String arg1;      // Primer operando
    String arg2;      // Segundo operando (opcional)
    String result;    // Resultado de la operación

    public ThreeAddressCode(String operation, String arg1, String arg2, String result) {
        this.operation = operation;
        this.arg1 = arg1;
        this.arg2 = arg2;
        this.result = result;

        writeToFile();
    }

    private void writeToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("output3AC.txt", true))) {
            String line;
            if (arg2 == null) {
                line = result + " = " + operation + " " + arg1;
            } else {
                line = result + " = " + arg1 + " " + operation + " " + arg2;
            }
            writer.write(line);
            writer.newLine();  // Añadir una nueva línea
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public String toString() {
        if (arg2 == null) {
            return result + " = " + operation + " " + arg1;
        } else {
            return result + " = " + arg1 + " " + operation + " " + arg2;
        }
    }
}
