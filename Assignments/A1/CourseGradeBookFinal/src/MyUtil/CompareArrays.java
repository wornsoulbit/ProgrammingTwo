
package MyUtil;

/**
 * Various compare arrays methods.
 * 
 * @author Alex Vasil
 */
public class CompareArrays {
   
    /**
     * Compares two char[] arrays to each other and see if they have the same values.
     * 
     * @param x An array.
     * @param y Another array.
     * @return If both arrays have the same values.
     */
    public static boolean compareArray(char[] x, char[] y) {
        if (x.length != y.length)
            return false;
        
        for (int i = 0; i < x.length; i++) {
            if (x[i] != y[i])
                return false;
        }
        
        return true;
    }
    
    /**
     * Compares two int[] arrays to each other and see if they have the same values.
     * 
     * @param x An array.
     * @param y Another array.
     * @return If both arrays have the same values.
     */
    public static boolean compareArray(int[] x, int[] y) {
        if (x.length != y.length)
            return false;
        
        for (int i = 0; i < x.length; i++) {
            if (x[i] != y[i])
                return false;
        }
        
        return true;
    }
    
    /**
     * Compares two double[] arrays to each other and see if they have the same values.
     * 
     * @param x An array.
     * @param y Another array.
     * @return If both arrays have the same values.
     */
    public static boolean compareArray(double[] x, double[] y) {
        if (x.length != y.length)
            return false;
        
        for (int i = 0; i < x.length; i++) {
            if (x[i] != y[i])
                return false;
        }
        
        return true;
    }
    
    /**
     * Compares two String[] arrays to each other and see if they have the same values.
     * 
     * @param x An array.
     * @param y Another array.
     * @return If both arrays have the same values.
     */
    public static boolean compareArray(String[] x, String[] y) {
        if (x.length != y.length)
            return false;
        
        for (int i = 0; i < x.length; i++) {
            if (x[i].equals(y[i]))
                return false;
        }
        
        return true;
    } 
}
