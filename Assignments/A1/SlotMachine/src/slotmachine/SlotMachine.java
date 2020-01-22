package slotmachine;

import java.util.Scanner;

/**
 * 
 * @author Alex Vasil
 */
public class SlotMachine {
    private Slot3Reel reel = new Slot3Reel();
    private String name;
    private int currentBet;
    private int totalBets;
    private int totalDeposit;
    private int totalPayOut;
    private int totalSpins;
    private int currentCredits;
    private final int doubleSpinMultiplier = 2;
    private final int tripleSpinMultiplier = 3;
    Scanner console = new Scanner(System.in);

    /**
     * Default Constructor of a SlotMachine.
     * @param name the player name.
     * @param currentCredits the amount of credits thats been deposited.
     */
    public SlotMachine(String name, int currentCredits) {
        this.name = name;
        this.currentBet = 0;
        this.totalBets = 0;
        this.totalDeposit = 0;
        this.totalPayOut = 0;
        this.totalSpins = 0;
        this.currentCredits = currentCredits;
    }
    
    /**
     * Starts a game of Slots.
     */
    public void play() {
        if (this.totalSpins == 0 || this.totalBets == 0)
            initIntro();
        else
            defaultIntro();
        
        
    }
    
    private void defaultIntro() {
        System.out.printf("Welcome back %s!", name);
    }
    
    private void initIntro() {
        String intro = "";
        intro += String.format("%s %s\n", "Greetings", name);
        intro += String.format("%s\n", "Welcome to 3-Reel Slot Machine Game!");
        intro += String.format("%s\n", "Each reel is adorned with the following 7 fruit names:");
        intro += String.format("%s\n", "Orange, Cherry, Lime, Apple, Banana, Peach, Melon");
        intro += String.format("%s\n", "");
        intro += String.format("%s\n", "There are four possible types of payout combinations:");
        intro += String.format("%s\n", "");
    }
    
    private void finalGreetingMsg() {
        
    }
    
    private void readBet() {
        
        console.nextInt();
    }
    
    /**
     * Checks if a valid bet was inputed.
     */
    private void validateBet() {
        int choice = -1;
        if (this.currentBet <= this.currentCredits && this.currentBet >= 0) {
            System.out.println("Invalid bet, do you wish to deposit more money or try a smaller bet?");
            System.out.printf("%s\n%s\n", "Enter 1 to deposit more money.", "Enter 2 to try a smaller bet.");
            System.out.printf("%s %d\n", "Current Credits:", this.currentCredits);
            choice = console.nextInt();
        }
        
        switch (choice) {
            case 1:
                //Call deposit function.
                break; 
            case 2:
                //Go back to choosing a bet.
                break;
            default:
                //Catches any other inputs
                break;
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
    private int computeSpinResult() {
        int payOuts;
        switch (getSpinOutcome()) {
            case 0: //For Zilch
                return payOuts = 0;
            case 1: //For Double.
                this.totalPayOut += this.currentBet * doubleSpinMultiplier;
                this.currentCredits += this.currentBet * doubleSpinMultiplier;
                return payOuts = this.currentBet * doubleSpinMultiplier;
            case 2: //For Triple.
                this.totalPayOut += this.currentBet * tripleSpinMultiplier;
                this.currentCredits += this.currentBet * tripleSpinMultiplier;
                return payOuts = this.currentBet * tripleSpinMultiplier;
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
        return "SlotMachine{" + "reel=" + reel + ", name=" + name + ", curBet=" + currentBet + ", totalBets=" + totalBets + ", totalDep=" + totalDeposit + ", totalPayOut=" + totalPayOut + ", totalSpins=" + totalSpins + '}';
    }
    
    public boolean equals(SlotMachine slotMachine) {
        return slotMachine == this;
    }

    public Slot3Reel getReel() {
        return reel;
    }

    public void setReel(Slot3Reel reel) {
        this.reel = reel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCurrentBet() {
        return currentBet;
    }

    public void setCurrentBet(int currentBet) {
        this.currentBet = currentBet;
    }

    public int getTotalBets() {
        return totalBets;
    }

    public void setTotalBets(int totalBets) {
        this.totalBets = totalBets;
    }

    public int getTotalDeposit() {
        return totalDeposit;
    }

    public void setTotalDeposit(int totalDeposit) {
        this.totalDeposit = totalDeposit;
    }

    public int getTotalPayOut() {
        return totalPayOut;
    }

    public void setTotalPayOut(int totalPayOut) {
        this.totalPayOut = totalPayOut;
    }

    public int getTotalSpins() {
        return totalSpins;
    }

    public void setTotalSpins(int totalSpins) {
        this.totalSpins = totalSpins;
    }

    public int getCurrentCredits() {
        return currentCredits;
    }

    public void setCurrentCredits(int currentCredits) {
        this.currentCredits = currentCredits;
    }

    public Scanner getConsole() {
        return console;
    }

    public void setConsole(Scanner console) {
        this.console = console;
    }
}
