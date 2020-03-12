package inputoutputapp;

import java.util.ArrayList;

/**
 *
 * @author Alex Vasil
 */
public class ArrayListTest {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();
        
        names.add("Jack");
        names.add("Jill");
        names.add("Mary");
        names.add("Ebruh");
        names.add("Chebine");
        names.add("Copaine");
        
        for (int i = 0; i < names.size(); i++)
            System.out.println(names.get(i));
        
        for (String name : names) 
            System.out.println(name);
        
        ArrayList<Integer> numbers = new ArrayList<>();
        
        for (int i = 0; i < 10; i++)  {
            int x = (int)(Math.random() * 101);
            numbers.add(x);
        }
        
        numbers.add(1, 111);
        numbers.add(3, 333);
        numbers.add(5, 555);
        
        for (Integer number : numbers)
            System.out.printf("%3d ", number);
        
        System.out.println("");
    }
}
