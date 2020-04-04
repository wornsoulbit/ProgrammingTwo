
package dogfileioapp;

import java.util.Scanner;

/**
 * Takes a formated String with the dogs name, age, gender and breed. In that order
 * each separated by a comma.
 * 
 * @author Alex Vasil
 */
public class PetDog implements Comparable<PetDog> {
    private String name;
    private String breed;
    private int age;
    private char gender;
    
    @Override
    public int compareTo(PetDog other) {
        int result = this.name.compareTo(other.name);
        
        if (result != 0)
            return result;
        
        if (this.age < other.age)
            return -1;
        else if (this.age > other.age)
            return 1;
        else 
            return 0;
    }
    
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }
    
    
    
}
