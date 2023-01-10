
package utils;
public class TestClassUtils
{
    private TestClassUtils() {
    }
    
    public static void assertNotNull(final Object obj) {
        if (obj == null) {
            throw new NullPointerException("obj is null");
        }
    }
    
    public static void assertNotNullString(final String str) {
        if (str == null) {
            throw new NullPointerException("str is null");
        }
    }
    
    public static void assertNotEmpty(final String str) {
        if (!TestStringUtils.isEmpty(str)) {
            return;
        }
        if (str == null) {
            throw new NullPointerException("str is null");
        }
        throw new IllegalArgumentException("str[" + str + "] is empty");
    }
}
