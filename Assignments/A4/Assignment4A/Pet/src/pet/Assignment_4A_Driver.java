
package pet;

import java.util.Random;

/**
 * Test Driver class.
 * 
 * @author Alex Vasil
 */
public class Assignment_4A_Driver {
    
    public static void main(String[] args) {
        Dog fido = new Dog("Daisy", 5, 'f', "pug");
        System.out.println(fido);
        fido.nextAge();
        System.out.println(fido);
        fido.nextAge();
        System.out.println(fido);
        fido.nextAge();
        System.out.println(fido);
        fido.guardHome();
        fido.pant();
        
        boolean spayed = true;
        Cat garfield = new Cat("Garfield", 5, 'm', spayed);
        System.out.println(garfield);
        garfield.nextAge();
        System.out.println(garfield);
        garfield.catchMice();
        garfield.purr();
        
        Duck daffy = new Duck("Daffy", 4, 'F', 5);
        System.out.println(daffy);
        daffy.nextAge();
        System.out.println(daffy);
        daffy.nextAge();
        System.out.println(daffy);
        daffy.layAnEgg();
        System.out.println(daffy);
        daffy.layAnEgg();
        System.out.println(daffy);
        daffy.swim();
        daffy.fly();
        
        Pet p;
        int roll = (new Random()).nextInt(3);        
        
        switch (roll) {
            case 0:
                p = new Dog("Oscar", 10, 'M', "Great Dane");
                break;
            case 1:
                p = new Cat("Sassy", 7, 'F', false);
                break;
            default:
                p = new Duck("Donald Duck", 3, 'm', 5);
                break;
        }
        
        System.out.println("Calling the talk() method polymorphically");
        p.talk();
        System.out.println(p);
    }
}
