package utils;

public class TestUtils
{
    private TestUtils() {
    }
    
    public static void sleep(final int nMilliSeconds) {
        try {
            Thread.sleep(nMilliSeconds);
        }
        catch (Exception ex) {}
    }
}
