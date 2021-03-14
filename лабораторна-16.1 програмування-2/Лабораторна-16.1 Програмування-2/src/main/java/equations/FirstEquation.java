package equations;

public class FirstEquation implements Equations {
    @Override
    public double equation(double a, double b, double c, double d) {
        return 2 * Math.sin(a) / Math.acos(-2 * b) - Math.sqrt(Math.log(c * Math.abs(2 * d)));
    }
}
