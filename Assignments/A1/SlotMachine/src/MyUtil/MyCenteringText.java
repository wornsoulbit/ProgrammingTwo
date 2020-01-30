package MyUtil;

/**
 * Centers any text.
 * 
 * @author Alex Vasil
 */
public class MyCenteringText {

    public static String spaces(int length) {
        String result = "";
        for (int k = 1; k <= length; k++) {
            result += " ";

        }
        return result;
    }

    public static String center(String text, int len) {
        int total_padding = len - text.length();

        if (total_padding < 0) {
            return text;
        }
        int left_padding = total_padding / 2;
        int right_padding = left_padding;
        if (total_padding % 2 == 1) {
            right_padding++;
        }
        String result = spaces(left_padding) + text + spaces(right_padding);
        return result;

    }
}
