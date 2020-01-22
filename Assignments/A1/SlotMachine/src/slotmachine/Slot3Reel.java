package slotmachine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * Models a set of 3 slot reels. 
 * 
 * @author Alex Vasil
 */
public class Slot3Reel {
    private ArrayList<String> symbolList = new ArrayList<>(Arrays.asList(
            "Melon", "Tangerine", "Apricot", "Fig", "Mandarin", "Pear", "Banana"));
    private ArrayList<String> payline = new ArrayList<>();
    static Random rand = new Random();
    
    /**
     * Default constructor of a Slot3Reel.
     */
    public Slot3Reel() {
        populateNewLine();
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
        return payline.get(k);
    }
    
    /**
     * Generates a random number in between the min and max inclusively.
     * @param min the minimum number.
     * @param max the maximum number.
     * @return a random number between the range of the min and max.
     */
    public static int generate(int min, int max) {
        if (min > max) {
            int temp = min;
            min = max;
            max = temp;
        }
        return rand.nextInt(max - min + 1) + min;
    }
    
    
    /**
     * Populates an arrayList from an existing arrayList.
     */
    public void populateNewLine() {
        payline.clear();
        for (int i = 0; i < 3; i++) {
            payline.add(symbolList.get(generate(0, symbolList.size() - 1)));
        }
    }
    
    /**
     * A spin of the slot machine.
     */
    public void spin() {
        String strOut = "";
        //Prints random number of lines between 2 and 9. That doesn't give any payout.
        for (int i = 1; i <= generate(2, 9); i++) {
            strOut += printLine() + "\n";
            populateNewLine();
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
        strOut += String.format("%s %-11s %s", "|", payline.get(0), "|");
        strOut += String.format("%s %-11s %s", "", payline.get(1), "");
        strOut += String.format("%s %-11s %s", "|", payline.get(2), "|");
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
    
    public ArrayList<String> getSymbolList() {
        return symbolList;
    }

    public ArrayList<String> getPayline() {
        return payline;
    }

    public void setSymbolList(ArrayList<String> symbolList) {
        this.symbolList = symbolList;
    }

    public void setPayline(ArrayList<String> payline) {
        this.payline = payline;
    }
}
