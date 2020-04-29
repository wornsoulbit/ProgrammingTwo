package finalassignmentproject;

/**
 * A class of a Cat.
 *
 * @author Alex Vasil
 */
public class Cat extends Pet {

    private boolean neutered;

    /**
     * Constructor for a Cat with data given from a file.
     * 
     * @param petGeneralData general data as name, age, gender.
     * @param petSpecificData specific data for the cat, e.g. neutered data.
     */
    public Cat(String petGeneralData, String petSpecificData) {
        super(petGeneralData);
        //Checks to see if the specifiedData has the proper values, if it doesn't
        //it throws an Illegal Argument Exception.
        if (!(petSpecificData.equalsIgnoreCase("yes") || (petSpecificData.equalsIgnoreCase("no"))))  {
            throw new IllegalArgumentException("Bad neutered value " + petSpecificData + ", expected yes or no");
        }
        this.neutered = petSpecificData.equalsIgnoreCase("yes");
    }

    /**
     * Default constructor for a Cat.
     * 
     * @param name the name.
     * @param age the age.
     * @param gender the gender.
     * @param neutered if its neutered or not.
     */
    public Cat(String name, int age, char gender, boolean neutered) {
        super(name, age, gender);
        this.neutered = neutered;
    }

    /**
     * What a cat does when it talks.
     */
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

    /**
     * ToString method, showing the values of the name, age, gender, and if its
     * neutered or not.
     * 
     * @return a formated string.
     */
    @Override
    public String toString() {
        return super.toString() + (neutered ? "" : "not ") + " neutered cat";
    }

    /**
     * Default equals method.
     * 
     * @param obj object being compared.
     * @return if both objs are equal.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }

        final Cat other = (Cat) obj;
        return super.equals(obj) && this.neutered == other.neutered;
    }

    /**
     * Checks if the cat is neutered or not.
     * 
     * @return if the cat is neutered or not.
     */
    public boolean isNeutered() {
        return neutered;
    }
}
