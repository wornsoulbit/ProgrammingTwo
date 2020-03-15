
package assignment2b;

import java.util.ArrayList;

/**
 * 
 * @author Alex Vasil
 */
public class CharArrayTools {
    
    public static int howMany(ArrayList<Character> list, char ch) {
        return howMany(list, ch, list.size() - 1, 0);
    }
    
    private static int howMany(ArrayList<Character> list, char ch, int n, int occurances) {
        if (n == -1)
            return occurances;
        else 
            return list.get((char) n) == ch ? howMany(list, ch, n - 1, occurances + 1) 
                    : howMany(list, ch, n - 1, occurances);
    }
    
    public static int howMany(String str, char ch) {
        return howMany(str, ch, str.length() - 1, 0);
    }

    
    private static int howMany(String str, char ch, int n, int occurances) {
        if (n == -1)
            return occurances;
        else 
            return str.charAt(n) == ch ? howMany(str, ch, n - 1, occurances + 1) 
                    : howMany(str, ch, n - 1, occurances);
    }
    
    public static boolean isPalindrome(ArrayList<Character> list) {
        return isPalindrome(list, list.size() - 1);
    }
    
    private static boolean isPalindrome(ArrayList<Character> list, int n) {
        return false;
    }
}
