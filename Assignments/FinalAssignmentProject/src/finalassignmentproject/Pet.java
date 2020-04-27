
package finalassignmentproject;

import java.util.Scanner;

/**
 * A class of a Pet.
 * 
 * @author Alex Vasil
 */
public abstract class Pet implements Comparable<Pet>{
    
    private String name;
    private int age;
    private static int idNumberCounter = 0;
    private int id = ++idNumberCounter;
    private final char gender;
    
    /**
     * Compares two pets to each other.
     * 
     * @param other the pet being compared.
     * @return 
     */
    @Override
    public int compareTo(Pet other) {
        int result = this.getName().compareTo(other.getName());
        
        if (result != 0) 
            return result;
        
        return this.getAge() - other.getAge();
    }
    
    /**
     * Pet from a file.
     * 
     * @param inputLine the file with the data.
     */
    public Pet(String inputLine) {
        Scanner lineScanner = new Scanner(inputLine);
        
        lineScanner.useDelimiter("\\s*,\\s*");
        
        this.name = lineScanner.next();
        this.age = lineScanner.nextInt();
        this.gender = lineScanner.next().toUpperCase().charAt(0);
        lineScanner.close();
    }
    
    /**
     * Default constructor of a pet.
     * 
     * @param name the name.
     * @param age the age.
     * @param gender the gender.
     */
    public Pet(String name, int age, char gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }
    /**
     * Talk method for the pets.
     */
    public abstract void talk();
    
    /**
     * Increments the age of the pet by 1.
     * 
     * @return the new age added by 1.
     */
    protected int nextAge() {
        age = this.age++;
        return this.age++;
    }
    
    /**
     * ToString method, showing the values of the name, age, gender.
     * 
     * @return a formated string.
     */
    @Override
    public String toString() {
        char strGender = Character.toUpperCase(gender);
        return "I'm " + name + ", a " + age + " year old " + 
                ((strGender == 'M') ? "male" : "female") + " pet";
    }

    /**
     * Default equals method.
     * 
     * @param obj object being compared.
     * @return if both objs are equal.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        
        if (obj == null)
            return false;
        
        if (getClass() != obj.getClass())
            return false;
        
        final Pet other = (Pet) obj;
        if (this.age != other.age)
            return false;
        if (this.gender != other.gender)
            return false;
        if (!this.name.equals(other.name))
            return false;
        return true;
    }

    /**
     * Getter.
     * 
     * @return the name.
     */
    public String getName() {
        return name;
    }
    
    /**
     * Getter.
     * 
     * @return the age.
     */
    public int getAge() {
        return age;
    }

    /**
     * Getter.
     * 
     * @return the id number.
     */
    public int getId() {
        return id;
    }
    
    /**
     * Getter.
     * 
     * @return the gender.
     */
    public char getGender() {
        return gender;
    }
}
