
package assignment2b;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Test driver for various recursive methods.
 * 
 * @author Alex Vasil
 */
public class Recursion {
    public static void main(String[] args) {
        int[] intArray = {-5, 2, 1, 5, 10, 2, 30, 5, 7};
        ArrayList<Integer> numbers = new ArrayList(Arrays.asList(-5, 2, 1, 5, 10, 2, 20, 5, 7));
        //Tests the recursive max method from an int array.
        System.out.println(IntArrayTools.max(intArray));
        //Tests the recursive max method from an integer ArrayList.
        System.out.println(IntArrayTools.max(numbers));
        //Tests the recursive contains method from an integer ArrayList.
        System.out.println(IntArrayTools.contains(numbers, 20));
        
        ArrayList<Character> charArray = new ArrayList(Arrays.asList('a', 'a', 'b', 'c', 'g', 'H'));
        //Tests the recursive how many characters from an Char ArrayList.
        System.out.println(CharArrayTools.howMany(charArray, ' '));
        
        String testStr = "Hello world! Lets hope this works :)";
        //Tests the recursive how many characters from a String.
        System.out.println(CharArrayTools.howMany(testStr, 'l'));
        
        //Tests recursively multiplies two numbers.
        System.out.println(RecursiveMultiplication.multiply(8, 5));
        
        ArrayList<Character> isPalindrome = new ArrayList(Arrays.asList('A', 'b', 'l', 'e',' ', 'e', 'l', 'b', 'A'));
        //Tests the recursive isPalindrome method from an character ArrayList.
        System.out.println(CharArrayTools.isPalindrome(isPalindrome));
    }
}
