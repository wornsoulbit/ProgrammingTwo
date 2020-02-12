package MyUtil;

import java.util.Random;

/**
 * Random number generator.
 *
 * @author Alex Vasil
 */
public class RandNumGen {

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
        return rand.nextInt(Math.abs(max - min) + 1) + min;
    }
}


