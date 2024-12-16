import java.util.ArrayList;

public class Binding {
    // Atributos
    private String nombre;
    private String tipo;
    private String scope = "";
    private boolean isFunctionOrProcedure = false;
    private int offset = 0;
    private ArrayList <Parametros> parametros = null;

    // Constructor
    public Binding(String nombre, String tipo, String scope) {
//        System.out.println("entro al constructor de binding");
        this.nombre = nombre;
        this.tipo = tipo;
        this.scope = scope;
    }

    public Binding(String nombre, String tipo, String scope, boolean isFunctionOrProcedure) {
//        System.out.println("entro al constructor de binding");
        this.nombre = nombre;
        this.tipo = tipo;
        this.scope = scope;
        this.isFunctionOrProcedure = isFunctionOrProcedure;
    }

    // Getters y Setters
    public ArrayList<Parametros> getParametros() {
        return parametros;
    }

    public void setParametros(ArrayList<Parametros> parametros) {
        this.parametros = parametros;
    }

    public boolean isFunctionOrProcedure() {
        return isFunctionOrProcedure;
    }

    public void setFunctionOrProcedure(boolean isFunctionOrProcedure) {
        this.isFunctionOrProcedure = isFunctionOrProcedure;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

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

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    // Método toString para imprimir el binding
    @Override
    public String toString() {
        return "Binding { " +
                "nombre='" + nombre + '\'' +
                ", tipo='" + tipo + '\'' +
                ", scope='" + scope + '\'' +
                ", isFunctionOrProcedure=" + isFunctionOrProcedure +
                ", offset=" + offset +
                ", parametros=" + parametros +
                " }";
    }
}
