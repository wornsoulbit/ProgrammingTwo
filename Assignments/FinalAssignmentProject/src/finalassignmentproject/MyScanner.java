package finalassignmentproject;

import java.util.Scanner;

/**
 * Scanner.
 * 
 * @author Alex Vasil
 */
public class MyScanner {

    Scanner console = new Scanner(System.in);
    
    /**
     * 
     * @return 
     */
    public int readInt() {
        while (!console.hasNextInt()) {
            String falseInput = console.next();
            System.out.printf("Input error. Expected an interger, found %s\n,", falseInput);
            System.out.printf("Try again... ");
        }
        int x = console.nextInt();
        return x;
    }
    
    /**
     * 
     * @return 
     */
    public int readNonLessThanOneInt() {
        int x;
        do {
            x = readInt();
            if (x < 1 || x > 9) {
                System.out.println("Error. Expected a number not less than 1 or greater than 9, instead found " + x);
            } 
        } while (x < 1 || x > 9);
        return x;
    }
}
