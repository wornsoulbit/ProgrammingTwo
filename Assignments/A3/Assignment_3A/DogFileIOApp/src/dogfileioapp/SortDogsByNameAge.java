
package dogfileioapp;

import java.util.Comparator;

/**
 *
 * @author Alex Vasil
 */
public class SortDogsByNameAge implements Comparator<PetDog>{

    @Override
    public int compare(PetDog dog1, PetDog dog2) {
        int result = dog1.getName().compareTo(dog2.getName());
        
        if (result != 0) 
            return result;        
        
        return dog1.getAge() - dog2.getAge();
    }
    
}
