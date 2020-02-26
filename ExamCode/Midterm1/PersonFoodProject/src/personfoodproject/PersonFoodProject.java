
package personfoodproject;

/**
 * Driver for PersonFoodProject.
 * 
 * @author Alex Vasil
 */
public class PersonFoodProject {

    public static void main(String[] args) {
        Person p1 = new Person("Alex Vasil");
        Person p2 = new Person("Jon Snow");
        
        p1.addFavoriteFood(new Food("Cherry", true));
        p1.addFavoriteFood(new Food("Pork", false));
        p1.addFavoriteFood(new Food("Beef", false));
        
        Person p3 = new Person(p1);
        p3.addFavoriteFood(new Food("Blueberry", true));
        p2.addFavoriteFood(new Food("Onion", true));
        p2.addFavoriteFood(new Food("Cabbage", true));
        p2.addFavoriteFood(new Food("Potato", true));
        p2.addFavoriteFood(new Food("Tomato", true));
        
        System.out.println(p1.toString());
        System.out.println(p2.toString());
        System.out.println(p3.toString());

        Food[] favFoods = {new Food("Cherry", true), new Food("Onion", true), new Food("Cabbage", true)};

        Person p4 = new Person("John Snow", favFoods, 3);
        
        System.out.println(p4.toString());
        
    }
    
}
