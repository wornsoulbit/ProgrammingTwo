
package personfoodproject;

/**
 * Class of foods.
 * 
 * @author Alex Vasil
 */
public class Food {
    private String name;
    private boolean isVeg;

    /**
     * Constructor with default values.
     */
    public Food() {
        this.name = "Ice Cream";
        this.isVeg = false;
    }
    
    /**
     * Constructor with given values.
     * 
     * @param name Name of the food.
     * @param isVeg Is it a vegetable.
     */
    public Food(String name, boolean isVeg) {
        this.name = name;
        this.isVeg = isVeg;
    }
    
    /**
     * Copy constructor.
     * 
     * @param anotherFood Object being copied.
     */
    public Food(Food anotherFood) {
        this.name = anotherFood.name;
        this.isVeg = anotherFood.isVeg;
    }

    /**
     * Name getter.
     * 
     * @return The name.
     */
    public String getName() {
        return name;
    }

    /**
     * Name setter.
     * 
     * @param name Sets the name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * isItVeg Getter.
     * 
     * @return If its an vegetable.
     */
    public boolean isIsVeg() {
        return isVeg;
    }

    /**
     * Setter for isVeg.
     * 
     * @param isVeg 
     */
    public void setIsVeg(boolean isVeg) {
        this.isVeg = isVeg;
    }
    
    /**
     * Compares two food objects.
     * 
     * @param obj Object being compared.
     * @return If both objcts are equal and have the same values and type.
     */
    @Override
    public boolean equals(Object obj) {
        Food food = (Food) obj;
        
        if (!(obj instanceof Food))
            return false;
        
        return this.name.equals(food.name) 
                && this.isVeg == food.isVeg;
    }

    /**
     * Default toString method.
     * 
     * @return String with all data members.
     */
    @Override
    public String toString() {
        String strOut = String.format("%-15s", name);
        strOut += isVeg ? "Vegetable\n" : "Non-Vegetable\n";
        return strOut;
    }
}
