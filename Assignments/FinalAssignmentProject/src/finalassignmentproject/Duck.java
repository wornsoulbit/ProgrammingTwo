
package finalassignmentproject;

/**
 * A Class of a Duck.
 * 
 * @author Alex Vasil
 */
public class Duck extends Pet {
    private int eggs;

    /**
     * Constructor for a Duck with data given from a file.
     * 
     * @param petGeneralData general data as name, age, gender.
     * @param petSpecificData specific data for the cat, e.g. neutered data.
     */
    public Duck(String petGeneralData, String petSpecificData) {
        super(petGeneralData);
        this.eggs = Integer.parseInt(petSpecificData);
    }
    
    /**
     * Default constructor for a Duck.
     * 
     * @param name the name.
     * @param age the age.
     * @param gender the gender.
     * @param eggs how many eggs a duck has.
     */
    public Duck(String name, int age, char gender, int eggs) {
        super(name, age, gender);
        this.eggs = eggs;
    }
    
    /**
     * What a duck does when it talks.
     */
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
    
    /**
     * ToString method, showing the values of the name, age, gender, and how many 
     * eggs it has.
     * 
     * @return a formated string.
     */
    @Override
    public String toString() {
        return super.toString() + " duck with " + eggs + " eggs";
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
        
        final Duck other = (Duck) obj;
        return super.equals(obj) && this.eggs == other.eggs;
    }

    /**
     * Gets the number of eggs.
     * 
     * @return number of eggs.
     */
    public int getEggs() {
        return eggs;
    }
}
