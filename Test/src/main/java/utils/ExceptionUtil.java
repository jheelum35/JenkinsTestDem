package utils;
import java.io.Writer;
import java.io.PrintWriter;
import java.io.StringWriter;

public class ExceptionUtil
{
    public static String stackTraceToString(final Throwable e) {
        final StringWriter stringWritter = new StringWriter();
        final PrintWriter printWritter = new PrintWriter(stringWritter, true);
        e.printStackTrace(printWritter);
        printWritter.flush();
        stringWritter.flush();
        return stringWritter.toString();
    }
}
