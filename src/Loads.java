public class Loads {
    private String variable;
    private int counter;
    private String scope;

    // Constructor
    public Loads(String variable, int counter, String scope) {
        this.variable = variable;
        this.counter = counter;
        this.scope = scope;
    }

    // Getters and Setters

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }


    public String getVariable() {
        return variable;
    }

    public void setVariable(String variable) {
        this.variable = variable;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }
}