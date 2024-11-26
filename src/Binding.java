

public class Binding {
    // Atributos
    private String nombre;
    private String tipo;

    // Constructor
    public Binding(String nombre, String tipo) {
        System.out.println("entro al constructor de binding");
        this.nombre = nombre;
        this.tipo = tipo;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    // Método toString para imprimir el binding
    @Override
    public String toString() {
        return "Binding { " +
                "nombre='" + nombre + '\'' +
                ", tipo='" + tipo + '\'' +
                " }";
    }
}
