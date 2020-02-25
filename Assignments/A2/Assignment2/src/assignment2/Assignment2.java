
package assignment2;

import java.util.Arrays;

/**
 *
 * @author Alex Vasil
 */
public class Assignment2 {
    public static void main(String[] args) {
        IntGrid test = new IntGrid(4);
        test.setGrid(4);
        for (int[] test1 : test.grid)
            System.out.println(Arrays.toString(test1));
    }
}
