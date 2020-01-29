package slotmachine;

import MyUtil.MyCenteringText;
import MyUtil.PopArray;
import MyUtil.RandNumGen;

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

    /**
     * Default constructor of a Slot3Reel.
     */
    public Slot3Reel() {
        PopArray.popArray(payline, symbolList);
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
        int row = RandNumGen.generator(minLine, maxLine);
        
        for (int i = 0; i < row; i++) {
            strOut += printLine() + "\n";
            PopArray.popArray(payline, symbolList);
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
     * ToString Method
     *
     * @return a formated string.
     */
    @Override
    public String toString() {
        return printLine();
    }

    /**
     * Checks to see if two objects are equal to each other.
     *
     * @param slotReel the object being compared.
     * @return if they are equal to each other.
     */
    public boolean equals(Slot3Reel slotReel) {
        return slotReel.payline == this.payline
                && slotReel.symbolList == this.symbolList;
    }

    /**
     * Getter.
     *
     * @return gets the symbol list.
     */
    public String[] getSymbolList() {
        return symbolList;
    }

    /**
     * Getter.
     *
     * @return gets the payline.
     */
    public String[] getPayline() {
        return payline;
    }

    /**
     * Setter.
     *
     * @param payline sets the values of payline.
     */
    public void setPayline(String[] payline) {
        this.payline = payline;
    }
}
