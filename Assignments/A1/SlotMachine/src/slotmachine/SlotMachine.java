package slotmachine;

import java.util.Scanner;

/**
 * 
 * @author Alex Vasil
 */
public class SlotMachine {
    private Slot3Reel reel = new Slot3Reel();
    private String name;
    private int curBet;
    private int totalBets;
    private int totalDep;
    private int totalPayOut;
    private int totalSpins;
    private int curCredits;
    private final int doubleSpinMultiplier = 2;
    private final int tripleSpinMultiplier = 3;
    Scanner console = new Scanner(System.in);
    
    public SlotMachine(String name, int curBet, int totalBets, int totalDep, int totalPayOut, int totalSpins, int curCredits) {
        this.name = name;
        this.curBet = curBet;
        this.totalBets = totalBets;
        this.totalDep = totalDep;
        this.totalPayOut = totalPayOut;
        this.totalSpins = totalSpins;
        this.curCredits = curCredits;
    }
    
    public void play() {
        
    }
    
    public void intro() {
        String intro = "";
        intro += String.format("%s %s\n", "Greetings", name);
        intro += String.format("%s\n", "Welcome to 3-Reel Slot Machine Game!");
        intro += String.format("%s\n", "Each reel is adorned with the following 7 fruit names:");
        intro += String.format("%s\n", "Orange, Cherry, Lime, Apple, Banana, Peach, Melon");
        intro += String.format("%s\n", "");
        intro += String.format("%s\n", "There are four possible types of payout combinations:");
        intro += String.format("%s\n", "");
    }
    
    public void finalGreetingMsg() {
        
    }
    
    public void readBet() {
        
    }
    
    /**
     * Checks if a valid bet was inputed.
     */
    public void validateBet() {
        if (this.curBet > this.curCredits || this.curBet < 0) {
            
        } else {
            System.out.println("Invalid bet, do you wish to deposit more money or try a smaller bet?");
            System.out.printf("%s\n %s\n", "Enter 1 to deposit more money.", "Enter 2 to try a smaller bet.");
            System.out.printf("%s %d\n", "Current Credits:", this.curCredits);
            console.nextInt();
        }
    }
    
    /**
     * Checks the outcome of the spin.
     * @return a number that corriponds to a spin result.
     */
    public int getSpinOutcome() {
        int spinOutcome;
        
            if (!isTriple()) 
                if (!isDouble()) 
                    spinOutcome = 0; //For Zilch.
                else 
                    spinOutcome = 1; //For Double.
            else 
                spinOutcome = 2; //For Triple.
            
        return spinOutcome;
    }
    
    /**
     * Checks the current bet and the spin outcome and rewards according to the payouts.
     * @return the amount of credits according to the amount won.
     */
    public int computeSpinResult() {
        int payOuts;
        switch (getSpinOutcome()) {
            case 0: //For Zilch
                this.totalPayOut += 0;
                return payOuts = 0;
            case 1: //For Double.
                this.totalPayOut += this.curBet * doubleSpinMultiplier;
                this.curCredits += this.curBet * doubleSpinMultiplier;
                return payOuts = this.curBet * doubleSpinMultiplier;
            case 2: //For Triple.
                this.totalPayOut += this.curBet * tripleSpinMultiplier;
                this.curCredits += this.curBet * tripleSpinMultiplier;
                return payOuts = this.curBet * tripleSpinMultiplier;
        }
        return -1;
    }
    
    /**
     * Compares if all 3 values in the payline are the same.
     * @return 
     */
    public boolean isTriple() {
       return reel.getPayline().get(0).equals(reel.getPayline().get(1)) 
               && reel.getPayline().get(0).equals(reel.getPayline().get(2));
    }
    
    /**
     * Checks to see if there is two of the same values in the payline.
     * @return if there is two of the same values in the payline.
     */
    public boolean isDouble() {
        return reel.getPayline().get(1).equals(reel.getPayline().get(0)) 
                || reel.getPayline().get(1).equals(reel.getPayline().get(2))
                || reel.getPayline().get(0).equals(reel.getPayline().get(2));
    } 
    
    /**
     * Checks to see if there is no values that are the same to each other.
     * @return if there is no values equal to another.
     */
    public boolean isZilch() {
        return !reel.getPayline().get(1).equals(reel.getPayline().get(0)) 
                || !reel.getPayline().get(1).equals(reel.getPayline().get(2)) 
                || !reel.getPayline().get(0).equals(reel.getPayline().get(2));
    }
    
    @Override
    public String toString() {
        return "SlotMachine{" + "reel=" + reel + ", name=" + name + ", curBet=" + curBet + ", totalBets=" + totalBets + ", totalDep=" + totalDep + ", totalPayOut=" + totalPayOut + ", totalSpins=" + totalSpins + '}';
    }
    
    public boolean equals(SlotMachine slotMachine) {
        return slotMachine == this;
    }
    
    public Slot3Reel getReel() {
        return reel;
    }

    public String getName() {
        return name;
    }

    public double getCurBet() {
        return curBet;
    }

    public double getTotalBets() {
        return totalBets;
    }

    public double getTotalDep() {
        return totalDep;
    }

    public double getTotalPayOut() {
        return totalPayOut;
    }

    public int getTotalSpins() {
        return totalSpins;
    }

    public void setReel(Slot3Reel reel) {
        this.reel = reel;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCurBet(int curBet) {
        this.curBet = curBet;
    }

    public void setTotalBets(int totalBets) {
        this.totalBets = totalBets;
    }

    public void setTotalDep(int totalDep) {
        this.totalDep = totalDep;
    }

    public void setTotalPayOut(int totalPayOut) {
        this.totalPayOut = totalPayOut;
    }

    public void setTotalSpins(int totalSpins) {
        this.totalSpins = totalSpins;
    }

    
}
