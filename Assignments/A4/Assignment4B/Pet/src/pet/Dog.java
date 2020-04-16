
package pet;

/**
 * A class of a dog.
 * 
 * @author Alex Vasil
 */
public class Dog extends Pet {
    
    private String breed;

    public Dog(String petGeneralData, String petSpecificData) {
        super(petGeneralData);
        this.breed = petSpecificData;
    }
    
    public Dog(String name,int age, char gender, String breed) {
        super(name, age, gender);
        this.breed = breed;
    }

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
    
    @Override
    public String toString() {
        return super.toString() + " " + breed + " dog";
    }

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
    
    
}
