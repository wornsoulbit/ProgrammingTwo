package slotmachine;

import MyUtil.PopArray;
import MyUtil.RandNumGen;

/**
 * Models a set of 3 slot reels. 
 * 
 * @author Alex Vasil
 */
public class Slot3Reel {
    private String[] symbolList = {"Melon", "Tangerine", "Apricot", "Fig", "Mandarin", "Pear", "Banana"};
    private String[] payline = new String[3];
    private final int minLines = 2;
    private final int maxLines = 9;
    
    
    /**
     * Default constructor of a Slot3Reel.
     */
    public Slot3Reel() {
        PopArray.popArray(payline, symbolList);
    }

    /**
     * Gets the fruit that's in the payline.
     * @param k a number between [0, 2].
     * @return the fruit type.
     */
    public String get(int k) {
        if (k < 0 || k > 2) {
            throw new IllegalArgumentException("Slot3Reel:get: array index out of bounds");
        }
        return payline[k];
    }
    
    /**
     * A spin of the slot machine.
     */
    public void spin() {
        String strOut = "";
        //Prints random number of lines between 2 and 9. That doesn't give any payout.
        for (int i = 1; i <= RandNumGen.generator(minLines, maxLines); i++) {
            strOut += printLine() + "\n";
            PopArray.popArray(payline, symbolList);
        }
        strOut += "*******************************************\n";
        //Payline.
        strOut += printLine() + "\n";
        System.out.print(strOut);
    }
    
    /**
     * Prints a line of a spin e.g. | x | y | z |
     * @return | x | y | z |
     */
    public String printLine() {
        String strOut = "";
        for (int i = 0; i < payline.length; i++) {
            strOut += String.format("|%-11s", payline[i]);
        }
        strOut += "|";
        return strOut;
    }
    
    /**
     * ToString Method
     * @return a formated string.
     */
    @Override
    public String toString() {
        return printLine();
    }
    
    /**
     * Checks to see if two objects are equal to each other.
     * @param slotReel the object being compared.
     * @return if they are equal to each other.
     */
    public boolean equals(Slot3Reel slotReel) {
        return slotReel == this;
    }

    public String[] getSymbolList() {
        return symbolList;
    }

    public void setSymbolList(String[] symbolList) {
        this.symbolList = symbolList;
    }

    public String[] getPayline() {
        return payline;
    }

    public void setPayline(String[] payline) {
        this.payline = payline;
    }
}
