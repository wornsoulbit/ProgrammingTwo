
package quiz1;

/**
 * Checks if an Array of numbers is sorted in descending order.
 * 
 * @author Alex Vasil
 */
public class Quiz1 {
    
    /**
     * Checks to see if an int array is sorted by descending order.
     * 
     * @param array Array being checked if its sorted.
     * @return If the array is sorted.
     */
    public static boolean isSorted(int[] array) {
        boolean isSorted = false;
        
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] >= array[i + 1])
                isSorted = true;
            else 
                return false;
        }
            
            
        return isSorted;
    }
}
