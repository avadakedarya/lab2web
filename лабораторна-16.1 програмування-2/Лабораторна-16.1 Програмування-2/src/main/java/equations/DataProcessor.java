package equations;

public class DataProcessor {
    private final Equations equations;

    protected DataProcessor(Equations equations) {
        this.equations = equations;
    }

    public double result(double a, double b, double c, double d) {
        return equations.equation(a, b, c, d);
    }
}
