
package assignment2b;

/**
 * Multiplies recursively.
 * 
 * @author Alex Vasil
 */
public class RecursiveMultiplication {
    public static int multiply(int x, int y) {
        if (x == 0 || y == 0)
            return 0;
        
        return x + multiply(x, y - 1);
    }
}
