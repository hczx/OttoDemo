package instrument;

/**
 * Created by 99165 on 2016/3/14.
 */
public final class Strings {

    private Strings() {
        // No instances.
    }

    public static boolean isBlank(CharSequence string) {
        return (string == null || string.toString().trim().length() == 0);
    }

    /**
     * 若字符串为空返回默认字符串
     *
     * @param string
     * @param defaultString
     * @return
     */
    public static String valueOrDefault(String string, String defaultString) {
        return isBlank(string) ? defaultString : string;
    }

    /**
     * 截取字符串
     *
     * @param string
     * @param length
     * @return
     */
    public static String truncateAt(String string, int length) {
        return string.length() > length ? string.substring(0, length) : string;
    }
}
