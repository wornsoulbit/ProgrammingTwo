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
    Random rand = new Random();
    
    public Slot3Reel() {
        genNewLine();
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
     * Generates a new random spin. e.g. | x | y | z |
     */
    public void genNewLine() {
        payline.clear();
        for (int i = 0; i < 3; i++) {
            int num = rand.nextInt(7);
            payline.add(symbolList.get(num));
        }
    }
    
    /**
     * A spin of the slot machine.
     */
    public void spin() {
        String strOut = "";
        //Prints random number of lines between 2 and 8. That doesn't give any payout. 
        int numLines = rand.nextInt(7) + 1;
        for (int i = 0; i <= numLines; i++) {
            strOut += printLine();
            genNewLine();
        }
        strOut += "*******************************************\n";
        //Payline.
        strOut += printLine();
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
        strOut += String.format("%s %-11s %s\n", "|", payline.get(2), "|");
        return strOut;
    }
    
    /**
     * ToString Method
     * @return a formated string.
     */
    @Override
    public String toString() {
        String strOut = "";
        strOut += String.format("%-2s %s %2s", "|", payline.get(0), "|");
        strOut += String.format("%-2s %s %2s", "", payline.get(1), "");
        strOut += String.format("%-2s %s %2s", "|", payline.get(2), "|");
        return strOut;
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
