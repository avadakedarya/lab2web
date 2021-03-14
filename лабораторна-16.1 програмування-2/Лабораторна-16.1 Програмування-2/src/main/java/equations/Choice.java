package equations;

public class Choice {
    public static double choice(String a, String b, String c, String d, String equationName) {
        double aCopy = Double.parseDouble(a); double bCopy = Double.parseDouble(b);
        double cCopy = Double.parseDouble(c); double dCopy = Double.parseDouble(d);
        DataProcessor dataProcessor = null;
        double decision = 0;
        if (equationName.equals("First equation")) {
            dataProcessor = new DataProcessor(new FirstEquation());
        }
        if (equationName.equals("Second equation")) {
            dataProcessor = new DataProcessor(new SecondEquation());
        }
        if (equationName.equals("Third equation")) {
            dataProcessor = new DataProcessor(new ThirdEquation());
        }
        if (dataProcessor != null) {
            decision = dataProcessor.result(aCopy, bCopy, cCopy, dCopy);
        }
        return decision;
    }
}
