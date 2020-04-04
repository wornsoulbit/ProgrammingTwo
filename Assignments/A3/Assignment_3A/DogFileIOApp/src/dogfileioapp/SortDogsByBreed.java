
package dogfileioapp;

import java.util.Comparator;

/**
 *
 * @author Alex Vasil
 */
public class SortDogsByBreed implements Comparator<PetDog> {

    @Override
    public int compare(PetDog dog1, PetDog dog2) {
        return dog1.getBreed().compareTo(dog2.getBreed());
    }
    
}
