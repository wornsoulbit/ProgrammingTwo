package MyUtil;

import java.util.ArrayList;

/**
 * Populates an array.
 *
 * @author Alex Vasil.
 */
public class PopArray {

    /**
     * Populates a String array x with random elements of array y.
     *
     * @param x array to be populated.
     * @param y array to be used for population.
     */
    public static void popArray(String[] x, String[] y) {
        for (int i = 0; i < x.length; i++) {
            x[i] = y[RandNumGen.generator(0, y.length - 1)];
        }
    }

    /**
     * Populates a String arrayList x with arrayList y.
     *
     * @param x arrayList to be populated.
     * @param y arrayList to be used for population.
     * @param size the size of the arrayList.
     */
    public static void popArrayList(ArrayList<String> x, ArrayList<String> y, int size) {
        x.clear();
        for (int i = 0; i < size; i++) {
            x.add(y.get(RandNumGen.generator(0, y.size() - 1)));
        }
    }
}
