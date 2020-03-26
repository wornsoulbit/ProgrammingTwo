
package assignment2b;

import java.util.ArrayList;

/**
 * Char array tools done recursively.
 * 
 * @author Alex Vasil
 */
public class CharArrayTools {
    
    /**
     * Checks how many of any given letter is in a char ArrayList.
     * 
     * @param list ArrayList with each character.
     * @param ch The given letter.
     * @return How many occurrences of the given letter is in the arrayList.
     */
    public static int howMany(ArrayList<Character> list, char ch) {
        return howMany(list, ch, list.size() - 1, 0);
    }
    
    /**
     * Checks how many of any given letter is in a char ArrayList recursively.
     * 
     * @param list ArrayList with each character.
     * @param ch The given letter.
     * @param n Start point.
     * @param occurrences The number of occurrences of the given letter.
     * @return The number of occurrences of the given letter.
     */
    private static int howMany(ArrayList<Character> list, char ch, int n, int occurrences) {
        if (n == -1)
            return occurrences;
        else 
            return list.get((char) n) == ch ? howMany(list, ch, n - 1, occurrences + 1) 
                    : howMany(list, ch, n - 1, occurrences);
    }
    
    /**
     * Checks how many of a given character occurs in a given string.
     * 
     * @param str The given string.
     * @param ch The given character.
     * @return The number of occurrences that character occurred in the given string.
     */
    public static int howMany(String str, char ch) {
        return howMany(str, ch, str.length() - 1, 0);
    }
    
    /**
     * Checks how many of a given character occurs in a given string recursively.
     * 
     * @param str The given string.
     * @param ch The given character.
     * @param n Start point.
     * @param occurrences The number of occurrences the given character occurred in the given string.
     * @return The number of occurrences of the given character in the string.
     */
    private static int howMany(String str, char ch, int n, int occurrences) {
        if (n == -1)
            return occurrences;
        else 
            return str.charAt(n) == ch ? howMany(str, ch, n - 1, occurrences + 1) 
                    : howMany(str, ch, n - 1, occurrences);
    }
    
    /**
     * Checks to see if the given char ArrayList is a palindrome or not.
     * 
     * @param list The given list.
     * @return If its a palindrome or not.
     */
    public static boolean isPalindrome(ArrayList<Character> list) {
        return isPalindrome(list, list.size() - 1);
    }
    
    /**
     * Checks to see if the given char ArrayList is a palindrome recursively.
     * 
     * @param list The given list.
     * @param n Start point.
     * @return If the given list is a palindrome or not.
     */
    private static boolean isPalindrome(ArrayList<Character> list, int n) {
        if (n == -1)
            return true;
        
        if (list.get(n).equals(list.get(list.size() - 1 - n)))
            return isPalindrome(list, n - 1);
        else
            return false;
    }
}
