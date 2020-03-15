
package assignment2b;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Alex Vasil
 */
public class Recursion {
    public static void main(String[] args) {
        int[] intArray = {-5, 2, 1, 5, 10, 2, 30, 5, 7};
        ArrayList<Integer> numbers = new ArrayList(Arrays.asList(-5, 2, 1, 5, 10, 2, 20, 5, 7));
        System.out.println(IntArrayTools.max(intArray));
        System.out.println(IntArrayTools.max(numbers));
        System.out.println(IntArrayTools.contains(numbers, 20));
        
        ArrayList<Character> charArray = new ArrayList(Arrays.asList('a', 'a', 'b', 'c', 'g', 'H'));
        System.out.println(CharArrayTools.howMany(charArray, ' '));
        
        String testStr = "Hello world! Lets hope this works :)";
        
        System.out.println(CharArrayTools.howMany(testStr, 'l'));
        
        System.out.println(RecursiveMultiplication.multiply(100, 4));
    }
}
