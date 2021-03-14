package equations;

public class ThirdEquation implements Equations {
    @Override
    public double equation(double a, double b, double c, double d) {
        return (Math.exp(c) + 2 * Math.log(a)) / Math.sqrt(Math.pow(c, b) * Math.abs(Math.asin(d)));
    }
}
