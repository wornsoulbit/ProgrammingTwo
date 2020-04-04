
package dogfileioapp;

import java.util.Comparator;

/**
 *
 * @author Alex
 */
public class SortDogsByAge implements Comparator<PetDog> {

    @Override
    public int compare(PetDog dog1, PetDog dog2) {
        int result = dog1.getAge() - dog2.getAge();
        
        if (result != 0) 
            return result;
        
        return dog1.getAge()- dog2.getAge();
    }
    
}
