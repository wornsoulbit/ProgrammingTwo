package MyUtil;

import java.util.Random;

/**
 * Random number generator.
 *
 * @author Alex Vasil
 */
public class RandomNumGenerator {

    private static Random rand = new Random();

    /**
     * Random number generator that generates a number between a lower and upper
     * bound inclusively.
     *
     * @param min the lower bound.
     * @param max the upper bound.
     * @return a random number between the lower and upper bound.
     */
    public static int generator(int min, int max) {
        if (min > max) {
            int temp = min;
            min = max;
            max = temp;
        }
        return rand.nextInt(max - min + 1) + min;
    }
}
