
package finalassignmentproject;

/**
 * A class of a Dog.
 * 
 * @author Alex Vasil
 */
public class Dog extends Pet {
    
    private String breed;

    /**
     * Constructor for a Dog with data given from a file.
     * 
     * @param petGeneralData general data as name, age, gender.
     * @param petSpecificData specific data for the cat, e.g. neutered data.
     */
    public Dog(String petGeneralData, String petSpecificData) {
        super(petGeneralData);
        this.breed = petSpecificData;
    }
    
    /**
     * Default constructor for a Dog.
     * 
     * @param name the name.
     * @param age the age.
     * @param gender the gender.
     * @param breed the breed.
     */
    public Dog(String name,int age, char gender, String breed) {
        super(name, age, gender);
        this.breed = breed;
    }

    /**
     * What a dog does when it talks.
     */
    public void talk() {
        System.out.println("Woof-Woof-Woof");
    }
    
    /**
     * Prints the dog name + is guarding home.
     */
    protected void guardHome() {
        System.out.println(super.getName() + " is guarding home ...");
    }
    
    /**
     * Prints the dog name + is panting.
     */
    protected void pant() {
        System.out.println(super.getName() + " is panting ...");
    }
    
    /**
     * ToString method, showing the values of the name, age, gender, and its breed.
     * 
     * @return a formated string.
     */
    @Override
    public String toString() {
        return super.toString() + " " + breed + " dog";
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
        
        final Dog other = (Dog) obj;
        return super.equals(obj) && this.breed.equals(other.breed);
    }

    /**
     * Gets the breed of the dog.
     * 
     * @return breed of the dog.
     */
    public String getBreed() {
        return breed;
    }
}
