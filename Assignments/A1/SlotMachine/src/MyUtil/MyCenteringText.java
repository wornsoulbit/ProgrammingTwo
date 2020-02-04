package MyUtil;

/**
 * Centers any text.
 * 
 * @author Alex Vasil
 */
public class MyCenteringText {

    /**
     * Puts x amount of spaces before a word or letter.
     * 
     * @param length the number of spaces.
     * @return string with x amount of spaces.
     */
    public static String spaces(int length) {
        String result = "";
        for (int k = 1; k <= length; k++) {
            result += " ";

        }
        return result;
    }

    /**
     * Centers any text.
     * 
     * @param text text to be centered.
     * @param length the length of the centering of the text.
     * @return the original text, centered.
     */
    public static String center(String text, int length) {
        int total_padding = length - text.length();

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
