package finalassignmentproject;

import java.util.Comparator;

/**
 * Compares two pets names.
 * 
 * @author Alex Vasil
 */
public class NameComparator implements Comparator<Pet> {

    /**
     * Compares two pets names.
     * 
     * @param o1 Pet one.
     * @param o2 Pet two.
     * @return If both names are the same.
     */
    @Override
    public int compare(Pet o1, Pet o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
