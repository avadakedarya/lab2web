package equations;

public class SecondEquation implements Equations {
    @Override
    public double equation(double a, double b, double c, double d) {
        return 2 * Math.sqrt(Math.tan(Math.abs(a + c)) + Math.log(b) / Math.pow(c, d));
    }
}
