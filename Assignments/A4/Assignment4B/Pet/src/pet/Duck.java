
package pet;

/**
 * A Class of a Duck.
 * 
 * @author Alex Vasil
 */
public class Duck extends Pet {
    private int eggs;

    public Duck(String petGeneralData, String petSpecificData) {
        super(petGeneralData);
        this.eggs = Integer.parseInt(petSpecificData);
    }
    
    public Duck(String name, int age, char gender, int eggs) {
        super(name, age, gender);
        this.eggs = eggs;
    }
    
    public void talk() {
        System.out.println("Quack-Quack-Quack");
    }
    
    /**
     * Prints the ducks name + just laid an egg.
     */
    protected void layAnEgg() {
        eggs++;
        System.out.println(super.getName() + " just laid an egg ...");
    }
    
    /**
     * Prints the ducks name + is swimming.
     */
    protected void swim() {
        System.out.println(super.getName() + " is swimming ...");
    }
    
    /**
     * Prints the ducks name + is flying.
     */
    protected void fly() {
        System.out.println(super.getName() + " is flying ...");
    }
    
    @Override
    public String toString() {
        return super.toString() + " duck with " + eggs + " eggs";
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        
        final Duck other = (Duck) obj;
        return super.equals(obj) && this.eggs == other.eggs;
    }
    
}
