package projectmanagement.util;

public class StringUtils {
    private StringUtils(){}
    public static boolean isEmpty(String string){
        return string==null||"".equals(string.trim());
    }

    public static String showValue(String string){
        return isEmpty(string)?"":string.trim();
    }
}
