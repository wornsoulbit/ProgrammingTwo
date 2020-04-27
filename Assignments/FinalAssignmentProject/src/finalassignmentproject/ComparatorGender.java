
package finalassignmentproject;

import java.util.Comparator;

/**
 * Compares two pets genders.
 * 
 * @author Alex Vasil
 */
public class ComparatorGender implements Comparator<Pet>{
    
    /**
     * Compares two pets genders.
     * 
     * @param o1 Pet one.
     * @param o2 Pet two.
     * @return If both genders are the same.
     */
    @Override
    public int compare(Pet o1, Pet o2) {
        int result = o1.getGender() - o2.getGender();
        
        if (result != 0)
            return result;
        
        return o1.getGender() - o2.getGender();
    }
}
