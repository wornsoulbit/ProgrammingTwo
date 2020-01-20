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
    
    public void genNewLine() {
        Random rand = new Random();
        for (int i = 0; i < 3; i++) {
            int num = rand.nextInt(7);
            payline.add(symbolList.get(num));
        }
    }
    
    public void spin() {
        
    }
    
    /**
     * ToString Method
     * @return a formated string.
     */
    @Override
    public String toString() {
        String slot3ReelResults = "";
        slot3ReelResults += String.format("| %s |", payline.get(0));
        slot3ReelResults += String.format(" %s ", payline.get(1));
        slot3ReelResults += String.format("| %s |", payline.get(2));
        return slot3ReelResults;
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
