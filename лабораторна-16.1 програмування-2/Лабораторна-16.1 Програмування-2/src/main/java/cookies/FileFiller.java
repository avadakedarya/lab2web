package cookies;

import javax.servlet.http.Cookie;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

public class FileFiller {
    public static void fillFile(Cookie[] cookies, String fileName) throws IOException {
        try(PrintWriter printWriter = new PrintWriter(new FileWriter(fileName, true))) {
            LocalDate localDate = LocalDate.now();
            printWriter.print(localDate.getDayOfMonth() + "/" + localDate.getMonth() + "={");
            for (int i = 0; i < cookies.length; i++) {
                if (!("JSESSIONID".equals(cookies[i].getName()) || "equation".equals(cookies[i].getName()))) {
                        printWriter.print(cookies[i].getName() + "=" + cookies[i].getValue());
                }
            }
            printWriter.print("}");
            printWriter.println();
        }
    }
}
