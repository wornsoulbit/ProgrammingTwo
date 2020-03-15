
package assignment2b;

import java.util.ArrayList;

/**
 * A class of recursive methods for int[] and arrayList<Integer> for max values, 
 * and contains methods.
 * 
 * @author Alex Vasil
 */
public class IntArrayTools {
    
    /**
     * Finds the maximum value in the array.
     * 
     * @param array Array to be searched.
     * @return The maximum value.
     */
    public static int max(int[] array) {
        return max(array, array.length - 1);
    }
    
    /**
     * Finds the max value of the array recursively.
     * 
     * @param array Array to be searched.
     * @param n Start point.
     * @return The max value of the array.
     */
    private static int max(int[] array, int n) {
        if (n == 0)
            return array[n];
        else 
            return Math.max(array[n], max(array, n - 1));
    }
    
    /**
     * Finds the max value in the arrayList.
     * 
     * @param list The arrayList to be searched.
     * @return The max value of the arrayList
     */
    public static int max(ArrayList<Integer> list) {
        return max(list, list.size() - 1);
    }
    
    /**
     * Finds the max value of the arrayList recursively.
     * 
     * @param list The arrayList to be searched.
     * @param n Start point.
     * @return The max value of the arrayList
     */
    private static int max(ArrayList<Integer> list, int n) {
        if (n == 0)
            return list.get(n);
        else 
            return Math.max(list.get(n), max(list, n - 1));
    }
    
    /**
     * Sees if the arrayList contains the given value.
     * 
     * @param list ArrayList to be searched for the given value.
     * @param value Value to be searched for in the arrayList.
     * @return If the value exists in the arrayList.
     */
    public static boolean contains(ArrayList<Integer> list, int value) {
        return contains(list, value, list.size() - 1);
    }
    
    /**
     * Sees if the arrayList contains the given value.
     * 
     * @param list ArrayList to be searched for the given value.
     * @param value Value to be searched for in the arrayList.
     * @param n Start point.
     * @return If the value exists in the arrayList.
     */
    private static boolean contains(ArrayList<Integer> list, int value, int n) {
        if (n == 0)
            return false;
        else 
            return list.get((Integer) n) == value ? true : contains(list, value, n - 1);
    }
}
