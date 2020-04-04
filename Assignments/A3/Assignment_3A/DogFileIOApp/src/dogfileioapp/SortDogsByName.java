/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dogfileioapp;

import java.util.Comparator;

/**
 *
 * @author Alex
 */
public class SortDogsByName implements Comparator<PetDog> {

    @Override
    public int compare(PetDog dog1, PetDog dog2) {
        return dog1.getName().compareTo(dog2.getName());
    }
    
}
