package utils;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;

public class TestStringUtils
{
    private static final String LENGTH_MUST_BE_GREATER_THAN_0 = "Length must be greater than 0";
    public static final String[] EMPTY_STRING_ARRAY;
    
    private TestStringUtils() {
    }
    
    public static boolean isNotEmpty(final String str) {
        return !isEmpty(str);
    }
    
    public static boolean isEmpty(final String str) {
        if (str == null) {
            return true;
        }
        for (int ndx = 0; ndx < str.length(); ++ndx) {
            if (str.charAt(ndx) > ' ') {
                return false;
            }
        }
        return true;
    }
    
    public static String trim(final String str) {
        if (str == null) {
            return null;
        }
        return str.trim();
    }
    
    public static String trimToNull(final String str) {
        if (str == null) {
            return null;
        }
        final String strTrimmed = str.trim();
        return strTrimmed.equals("") ? null : strTrimmed;
    }
    
    public static String trimToEmpty(final String str) {
        if (str == null) {
            return "";
        }
        return str.trim();
    }
    
    public static String removeAllSpaces(final String strInArg) {
        String strIn = strInArg;
        if (strIn == null) {
            return null;
        }
        strIn = strIn.trim();
        for (int ndx = -1; (ndx = strIn.indexOf(32)) != -1; strIn = strIn.substring(0, ndx) + strIn.substring(ndx + 1)) {}
        return strIn;
    }
    
    public static String formatInitialCap(final String strInput) {
        String strTempInput = strInput;
        if (strTempInput != null && strTempInput.length() > 0) {
            strTempInput = strTempInput.substring(0, 1).toUpperCase() + strTempInput.substring(1, strTempInput.length()).toLowerCase();
        }
        return strTempInput;
    }
    
    public static String formatInitialLowerCase(final String strInput) {
        String strTempInput = strInput;
        if (strTempInput != null && strTempInput.length() > 0) {
            strTempInput = strTempInput.substring(0, 1).toLowerCase() + strTempInput.substring(1);
        }
        return strTempInput;
    }
    
    @SafeVarargs
    public static <T> String arrayToString(final String strDelim, final T... aT) {
        TestClassUtils.assertNotNullString(strDelim);
        if (aT == null) {
            return null;
        }
        final StringBuilder buff = new StringBuilder();
        boolean bFirst = true;
        for (final T el : aT) {
            if (el != null) {
                if (!bFirst) {
                    buff.append(strDelim);
                }
                else {
                    bFirst = false;
                }
                buff.append(el.toString());
            }
        }
        return buff.toString();
    }
    
    public static String arrayToString(final Object[] aN, final String strDelim) {
        if (aN == null) {
            return null;
        }
        final StringBuilder buff = new StringBuilder();
        boolean bFirst = true;
        for (final Object n : aN) {
            if (!bFirst) {
                buff.append(strDelim);
            }
            else {
                bFirst = false;
            }
            buff.append(String.valueOf(n));
        }
        return buff.toString();
    }
    
    public static String arrayToString(final int[] aN, final String strDelim) {
        if (aN == null) {
            return null;
        }
        final StringBuilder buff = new StringBuilder();
        boolean bFirst = true;
        for (final int n : aN) {
            if (!bFirst) {
                buff.append(strDelim);
            }
            else {
                bFirst = false;
            }
            buff.append(String.valueOf(n));
        }
        return buff.toString();
    }
    
    public static String arrayToString(final Iterable<?> col, final String strDelim) {
        TestClassUtils.assertNotNullString(strDelim);
        if (col == null) {
            return null;
        }
        final StringBuilder strb = new StringBuilder();
        boolean bFirst = true;
        for (final Object el : col) {
            if (!bFirst) {
                strb.append(strDelim);
            }
            else {
                bFirst = false;
            }
            strb.append(el.toString());
        }
        return strb.toString();
    }
    
    public static boolean isNullUIString(final String str) {
        return isEmpty(str) || "null".equals(str);
    }
    
    public static Map<String, String> stringToMap(final String str) {
        return stringToMap(str, false);
    }
    
    public static Map<String, String> stringToLowerCaseMap(final String str) {
        return stringToMap(str, true);
    }
    
    private static Map<String, String> stringToMap(final String str, final boolean bLowerCase) {
        final Map<String, String> map = new HashMap<String, String>();
        final StringTokenizer st = new StringTokenizer(str, ",");
        while (st.hasMoreTokens()) {
            String strToken = st.nextToken();
            if (bLowerCase) {
                strToken = strToken.toLowerCase();
            }
            final String[] astrToken = strToken.split("=");
            map.put(astrToken[0], (astrToken.length > 1) ? astrToken[1] : null);
        }
        return map;
    }
    
    public static String mapToString(final Map<String, String> map) {
        final StringBuilder strb = new StringBuilder();
        for (final Map.Entry<String, String> entry : map.entrySet()) {
            if (strb.length() > 0) {
                strb.append(",");
            }
            strb.append(entry.getKey()).append("=").append((entry.getValue() == null) ? "" : entry.getValue());
        }
        return strb.toString();
    }
    
    public static void replaceAll(final StringBuilder buff, final String strOld, final String strNew) {
        for (int nPos = buff.indexOf(strOld); nPos > -1; nPos = buff.indexOf(strOld)) {
            buff.replace(nPos, nPos + strOld.length(), strNew);
        }
    }
    
    public static String conformTrimmedLength(final String str, final int nLen) {
        if (nLen < 1) {
            throw new IllegalArgumentException("Length must be greater than 0");
        }
        if (str == null) {
            return null;
        }
        final String strTrimmed = str.trim();
        if (strTrimmed.length() <= nLen) {
            return strTrimmed;
        }
        return strTrimmed.substring(0, nLen);
    }
    
    public static String conformLength(final String str, final int nLen) {
        if (nLen < 1) {
            throw new IllegalArgumentException("Length must be greater than 0");
        }
        if (str == null) {
            return null;
        }
        if (str.length() <= nLen) {
            return str;
        }
        return str.substring(0, nLen);
    }
    
    public static String enforceLength(final String str, final int nLen) {
        if (nLen < 1) {
            throw new IllegalArgumentException("Length must be greater than 0");
        }
        if (str == null) {
            return null;
        }
        if (str.length() <= nLen) {
            return str;
        }
        enformentException(str, nLen);
        return null;
    }
    
    private static void enformentException(final String str, final int nLen) {
        String strMsg = str;
        if (strMsg.length() > 100) {
            strMsg = strMsg.substring(0, 100) + "...";
        }
        throw new IllegalArgumentException("String " + strMsg + " (length = " + str.length() + ") is longer than constraint (" + nLen + ")");
    }
    
    public static String enforceTrimmedLength(final String str, final int nLen) {
        if (nLen < 1) {
            throw new IllegalArgumentException("Length must be greater than 0");
        }
        if (str == null) {
            return null;
        }
        final String strTrimmed = str.trim();
        if (strTrimmed.length() <= nLen) {
            return strTrimmed;
        }
        enformentException(strTrimmed, nLen);
        return null;
    }
    
    public static Float parseFloat(final String str) {
        if (str == null) {
            return null;
        }
        try {
            return Float.valueOf(str);
        }
        catch (NumberFormatException e) {
            return null;
        }
    }
    
    public static <T> String toCommaSeparatedString(final List<T> lstVals) {
        final StringBuilder buff = new StringBuilder();
        boolean bFirst = true;
        for (final T val : lstVals) {
            if (!bFirst) {
                buff.append(",");
            }
            buff.append(val.toString());
            bFirst = false;
        }
        return buff.toString();
    }
    
    @SafeVarargs
    public static <T, V> String toCommaSeparatedString(final Map<T, V> mapValues, final T... lstKeys) {
        final StringBuilder buff = new StringBuilder();
        boolean bFirst = true;
        for (final T key : lstKeys) {
            if (!bFirst) {
                buff.append(",");
            }
            buff.append(mapValues.get(key).toString());
            bFirst = false;
        }
        return buff.toString();
    }
    
    public static Double parseDouble(final String str) {
        if (str == null) {
            return null;
        }
        try {
            return Double.valueOf(str);
        }
        catch (NumberFormatException e) {
            return null;
        }
    }
    
    public static Integer parseInt(final String str) {
        if (str == null) {
            return null;
        }
        try {
            return Integer.valueOf(str);
        }
        catch (NumberFormatException e) {
            return null;
        }
    }
    
    public static List<String> parseLines(final StringBuilder buff) {
        final List<String> lstLines = new ArrayList<String>();
        int nNewPos;
        for (int nPos = 0; nPos >= 0; nPos = nNewPos + 2) {
            nNewPos = buff.indexOf("\r\n", nPos);
            if (nNewPos < 0) {
                lstLines.add(buff.substring(nPos));
                break;
            }
            lstLines.add(buff.substring(nPos, nNewPos));
        }
        return lstLines;
    }
    
    public static int countNonEmpty(final String... astrArgs) {
        int nCount = 0;
        for (final String str : astrArgs) {
            if (isNotEmpty(str)) {
                ++nCount;
            }
        }
        return nCount;
    }
    
    public static String convertDecimalToWholeNumber(final String strToBeRemoved) {
        return strToBeRemoved.replaceAll("\\.0*$", "");
    }
    
    public static String[] stringToArray(final String strValues) {
        return strValues.split("\\|");
    }
    
    public static String[] stringToArray(final String strValues, final String strdelimiter) {
        if (strdelimiter != null && !strdelimiter.equals("")) {
            return strValues.split(strdelimiter);
        }
        return stringToArray(strValues);
    }
    
    static {
        EMPTY_STRING_ARRAY = new String[0];
    }
    
    public static class MatchExact
    {
        private final String strValue;
        
        public MatchExact(final String str) {
            this.strValue = str;
        }
        
        public boolean passes(final String str) {
            return str == null || this.strValue.equals(str);
        }
    }
    
    public static class MatchTrimmed
    {
        private final String strValue;
        
        public MatchTrimmed(final String str) {
            this.strValue = ((str == null) ? null : str.trim());
        }
        
        public boolean passes(final String str) {
            return this.strValue == null || this.strValue.equals(str.trim());
        }
    }
    
    public static class MatchIgnoreCase
    {
        private final String strValue;
        
        public MatchIgnoreCase(final String str) {
            this.strValue = str;
        }
        
        public boolean passes(final String str) {
            return this.strValue == null || this.strValue.equals(str.trim());
        }
    }
    
    public static class MatchTrimmedIgnoreCase
    {
        private final String strValue;
        
        public MatchTrimmedIgnoreCase(final String str) {
            this.strValue = ((str == null) ? null : str.trim());
        }
        
        public boolean passes(final String str) {
            if (this.strValue == null) {
                return str == null;
            }
            return str != null && this.strValue.equalsIgnoreCase(str.trim());
        }
    }
}
