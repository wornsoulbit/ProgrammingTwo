
package personfoodproject;

import java.util.Arrays;

/**
 * Class of a person.
 * 
 * @author Alex Vasil
 */
public class Person {
   private String name;
   private Food[] favoriteFood;
   private int foodCounter;

   /**
    * Constructor with given and default values.
    * 
    * @param name The name of the person.
    */
    public Person(String name) {
        this.name = name;
        this.favoriteFood = new Food[1];
        this.foodCounter = 0;
    }
    
    /**
     * Constructor with all values given.
     * 
     * @param name The name of the person.
     * @param favoriteFood A list of favorite foods.
     * @param foodCounter The number of foods in favoriteFood.
     */
    public Person (String name, Food[] favoriteFood, int foodCounter) {
        this.name = name;
        this.favoriteFood = favoriteFood;
        this.foodCounter = foodCounter;
    }
    
    /**
     * Copy constructor of a Person.
     * 
     * @param anotherPerson Person being copied.
     */
    public Person(Person anotherPerson) {
        this.name = anotherPerson.name;
        this.favoriteFood = anotherPerson.favoriteFood;
        this.foodCounter = anotherPerson.foodCounter;
    }
    
    /**
     * Adds a favorite food into favoriteFood array.
     * 
     * @param f The food to be added into the list.
     */
    public void addFavoriteFood(Food f) {
        if (foodCounter == favoriteFood.length)
            doubleArrayCapacity();
        
        favoriteFood[foodCounter] = new Food(f);
        foodCounter++;
    }
    
    /**
     * Doubles the capacity of the favoriteFood array.
     */
    private void doubleArrayCapacity() {
        Food[] newFood = new Food[favoriteFood.length * 2];
        System.arraycopy(favoriteFood, 0, newFood, 0, foodCounter);
        favoriteFood = newFood;
    }
    
    /**
     * Checks to see if a person is a vegetarian.
     * @return 
     */
    public boolean isVegetarian() {
        for (Food food : favoriteFood) {
            if (!food.isIsVeg())
                return false;
        }
        return true;
    }

    /**
     * Compares two food objects.
     * 
     * @param obj Object being compared.
     * @return If both objcts are equal and have the same values and type.
     */
    @Override
    public boolean equals(Object obj) {
        Person person = (Person) obj;
        
        if (!(obj instanceof Person))
            return false;
        
        return this.name.equals(person.name) 
                && this.foodCounter == person.foodCounter
                && Arrays.equals(this.favoriteFood, person.favoriteFood);
    }

    @Override
    public String toString() {
        String strOut = String.format("%-15s", name);
        strOut += isVegetarian() ? "(Vegetarian)\n" : "(Not a vegetarian)\n";
        for (int i = 0; i < foodCounter; i++)
            strOut += favoriteFood[i].toString();
        
        return strOut;
    }
    
    /**
     * Gets the name of the person.
     * 
     * @return The name.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the person.
     * 
     * @param name Name to be set.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the person's favorite food.
     * 
     * @return Their favorite food.
     */
    public Food[] getFavoriteFood() {
        return favoriteFood;
    }

    /**
     * 
     * @param favoriteFood 
     */
    public void setFavoriteFood(Food[] favoriteFood) {
        this.favoriteFood = favoriteFood;
    }

    /**
     * Gets the number of food there is in favorite food.
     * 
     * @return The number of food in favorite food.
     */
    public int getFoodCounter() {
        return foodCounter;
    }

    /**
     * Sets the number of food in favorite food.
     * 
     * @param foodCounter the number of food in favorite food.
     */
    public void setFoodCounter(int foodCounter) {
        this.foodCounter = foodCounter;
    }
    
    
}
