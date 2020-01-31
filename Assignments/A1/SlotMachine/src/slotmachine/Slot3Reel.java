package slotmachine;

import MyUtil.MyCenteringText;
import java.util.Random;

/**
 * Models a set of 3 slot reels.
 *
 * @author Alex Vasil
 */
public class Slot3Reel {

    private final String[] symbolList = {"Orange", "Cherry", "Lime", "Apple", "Banana", "Peach", "Melon"};
    private final int minLine = 2;
    private final int maxLine = 9;

    private String[] payline = new String[3];
    private Random rand = new Random();

    /**
     * Default constructor of a Slot3Reel.
     */
    public Slot3Reel() {
        populatePayline();
    }

    /**
     * Gets the fruit that's in the payline.
     *
     * @param k a number between [0, 2].
     * @return the fruit type.
     */
    public String get(int k) {
        if (k < 0 || k > payline.length - 1) {
            throw new IllegalArgumentException("Slot3Reel:get: array index out of bounds");
        }

        return payline[k];
    }

    /**
     * A spin of the slot machine.
     */
    public void spin() {
        String strOut = "";
        //Creates between 2 and 9 dummy lines.
        int row = generateInt(minLine, maxLine);

        for (int i = 0; i < row; i++) {
            strOut += printLine() + "\n";
            populatePayline();
        }

        strOut += "****************************************\n";
        //Payline.
        strOut += printLine();
        strOut += "\n****************************************\n";
        System.out.println(strOut);
    }

    /**
     * Prints a line of a spin e.g. | x | y | z |
     *
     * @return | x | y | z |
     */
    private String printLine() {
        String strOut = "";
        for (int i = 0; i < payline.length; i++) {
            strOut += String.format("|" + MyCenteringText.center(payline[i], 12));
        }
        strOut += "|";
        return strOut;
    }

    /**
     * Populates the payline with random values from the symbol list.
     */
    private void populatePayline() {
        for (int i = 0; i < payline.length; i++) {
            payline[i] = symbolList[symbolList.length - 1];
        }
    }

    /**
     * Generates a random number between the min number and max number
     * inclusively.
     *
     * @param min the minimum number.
     * @param max the maximum number.
     * @return a number between the range of min and max inclusively.
     */
    private int generateInt(int min, int max) {
        return rand.nextInt(Math.abs(max - min) + 1) + min;
    }

    /**
     * ToString method that prints an array.
     *
     * @return a formated string.
     */
    @Override
    public String toString() {
        return printLine();
    }

    /**
     * Compares two Objects and sees if they are equal to each other.
     *
     * @param obj the object being compared.
     * @return if the two objects are equal to each other.
     */
    @Override
    public boolean equals(Object obj) {
        Slot3Reel slot3Reel = (Slot3Reel) obj;

        if (!(obj instanceof Slot3Reel)) {
            return false;
        }

        for (int i = 0; i < payline.length; i++) {
            if (payline[i].equals(slot3Reel.payline[i])) {
                return true;
            }
        }
        return true;
    }

    /**
     * Getter.
     *
     * @return gets the symbol list.
     */
    public String[] getSymbolList() {
        String[] readSymbolList = symbolList;
        return readSymbolList;
    }

    /**
     * Getter.
     *
     * @return gets the payline.
     */
    public String[] getPayline() {
        String[] readPayline = payline;
        return readPayline;
    }
}
