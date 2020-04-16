
package pet;

/**
 * A class of a Cat.
 * 
 * @author Alex Vasil
 */
public class Cat extends Pet {
    private boolean neutered;

    public Cat(String name, int age, char gender, boolean neutered) {
        super(name, age, gender);
        this.neutered = neutered;
    }    
    
    public void talk() {
        System.out.println("Meow-Meow-Meow");
    }
    
    /**
     * Prints the cat name + is catching mice.
     */
    protected void catchMice() {
        System.out.println(super.getName() + " is catching mice ...");
    }
    
    /**
     * Prints the dog name + is purring.
     */
    protected void purr() {
        System.out.println(super.getName() + " is purring ...");
    }
    
    @Override
    public String toString() {
        return super.toString() + (neutered ? "" : "not ")+ " neutered cat";
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        
        final Cat other = (Cat) obj;
        return super.equals(obj) && this.neutered == other.neutered;
    }
}
