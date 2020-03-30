
package dogfileioapp;

import java.util.Scanner;

/**
 * Takes a formated String with the dogs name, age, gender and breed. In that order
 * each separated by a comma.
 * 
 * @author Alex Vasil
 */
public class PetDog {
    private String name;
    private int age;
    private char gender;
    private String breed;
    
    /**
     * Takes a String and assigns each data member a value.
     * 
     * @param inputLine String being used to fill the data members.
     */
    public PetDog(String inputLine) {
        Scanner lineScanner = new Scanner(inputLine);
        
        lineScanner.useDelimiter("\\s*,\\s*");
        
        this.name = lineScanner.next();
        this.age = lineScanner.nextInt();
        this.gender = lineScanner.next().toUpperCase().charAt(0);
        this.breed = lineScanner.next();
        lineScanner.close();
    }

    /**
     * To-String method that outputs the name, age, gender and breed of the dog.
     * 
     * @return A formated String.
     */
    @Override
    public String toString() {
        return "I'm " + name + ", a " + age + " year old " 
                + ((gender == 'M') ? "male " : "female ") + breed;
    }
    
}
