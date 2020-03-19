
package assignment2b;

/**
 * Multiplies recursively.
 * 
 * @author Alex Vasil
 */
public class RecursiveMultiplication {
    /**
     * Recursively multiplies any given two numbers with x multiplied by y.
     * 
     * @param x The first integer.
     * @param y The second integer.
     * @return The multiplied number of x and y.
     */
    public static int multiply(int x, int y) {
        if (x == 0 || y == 0)
            return 0;
        
        return x + multiply(x, y - 1);
    }
}
