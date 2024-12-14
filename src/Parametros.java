public class Parametros {
    private String variable;
    private String tipo;

    public Parametros(String variable, String tipo) {
        this.variable = variable;
        this.tipo = tipo;
    }

    public String getVariable() {
        return variable;
    }

    public void setVariable(String variable) {
        this.variable = variable;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
