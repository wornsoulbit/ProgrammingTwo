
package finalassignmentproject;

import java.util.Comparator;

/**
 * Compares Two pets ages.
 * 
 * @author Alex Vasil
 */
public class AgeComparator implements Comparator<Pet>{
    
    /**
     * Compares two pets ages.
     * 
     * @param o1 Pet one.
     * @param o2 Pet two.
     * @return If both age are the same.
     */
    @Override
    public int compare(Pet o1, Pet o2) {
        int result = o1.getAge() - o2.getAge();
        
        if (result != 0)
            return result;
        
        return o1.getAge() - o2.getAge();
    }
}
