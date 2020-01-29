package MyUtil;

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
            System.out.printf("Try again...");
        }
        int x = console.nextInt();
        return x;
    }
    
    /**
     * 
     * @return 
     */
    public int readNonNegativeInt() {
        int x;
        do {
            x = readInt();
            if (x < 0) {
                System.out.println("Error. Expected a non-negative, instead found " + x);
            } 
        } while (x < 0);
        return x;
    }
}
