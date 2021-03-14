package cookies;

import java.io.*;
import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateChecker {
    public static void dateCheck(String fileName) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File(fileName), true))) {
            Pattern pattern = Pattern.compile("^.+/");
            LocalDate localDate = LocalDate.now();
            int monthDay = localDate.getMonthValue();
            int local;
            String inputLines;
            while ((inputLines = bufferedReader.readLine()) != null) {
                Matcher matcher = pattern.matcher(inputLines);
                while (matcher.find()) {
                    local = Math.abs(monthDay - Integer.parseInt(inputLines.substring(matcher.start(), matcher.end()).replace("/", "")));
                    if ((local > 2)) {
                        bufferedWriter.write(inputLines);
                    }
                }
            }
        }
    }
}
