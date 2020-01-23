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
    private int totalDeposit;
    private int totalPayOut;
    private int totalSpins;
    private int curCredits;
    private final int doubleSpinMultiplier = 2;
    private final int tripleSpinMultiplier = 3;
    Scanner console = new Scanner(System.in);

    /**
     * Default Constructor of a SlotMachine.
     *
     * @param name the player name.
     * @param currentCredits the amount of credits thats been deposited.
     */
    public SlotMachine(String name, int currentCredits) {
        this.name = name;
        this.curBet = 0;
        this.totalBets = 0;
        this.totalDeposit = 0;
        this.totalPayOut = 0;
        this.totalSpins = 0;
        this.curCredits = currentCredits;
    }

    private void defaultIntro() {
        System.out.printf("Welcome back %s!\n", name);
    }

    /**
     * Starts the game.
     */
    public void play() {
        if (this.totalSpins != 0) {
            defaultIntro();
            readBet();
        } else {
            intro();
            readBet();
        }
    }

    /**
     * Introduction to the game.
     */
    private void intro() {
        System.out.printf("Greetings %s\n", name);
        System.out.printf("Welcome to 3-Reel Slot Machine Game! \n");
        System.out.printf("Each reel is adorned with the following 7 friut names:\n");
        System.out.printf("Orange, Cherry, Lime, Apple, Banana, Peach, Melon\n");

        System.out.printf("\nThere are four possible types of payout combinations:\n");
        System.out.printf("-----------------------------------------------------\n");
        System.out.printf("1) Triple       : all 3 symbols match \n");
        System.out.printf("2) Left-Double  : the left symbol matches either of the other two symbols \n");
        System.out.printf("3) Right-Double : the center and rightmost symbols match \n");
        System.out.printf("4) Zilch         : no matches \n");
        System.out.printf("\nThe Rules: \n");
        System.out.printf("----------\n");

        System.out.printf("1) You will be prompted to enter a bet value.\n");
        System.out.printf("   A bet value is the number of bet coins you want to bet.\n");
        System.out.printf("   If your bet value exceeds your current balance, then\n");
        System.out.printf("   you'll have to deposit enough bet coins to satisfy your bet.\n");
        System.out.printf("2) Enter 0 for a bet to end the game. \n");
        System.out.printf("3) Get a Triple to win 3 times your bet.  \n");
        System.out.printf("4) Get a Left-Double to win 2 times your bet. \n");
        System.out.printf("5) Get a Right-Double to win 1 time your bet. \n");
        System.out.printf("6) Get a Zilch to lose your bet.  \n");
        System.out.printf("\nLet the Fun Begin!\nGood Luck!\n");
    }

    /**
     * Greeting message telling the player to come back soon.
     */
    public void finalGreetingMsg() {
        System.out.println("Goodbye, come back soon!");
        System.out.println(toString());
    }

    /**
     * Reads the current bet and checks if its valid.
     */
    public void readBet() {
        if (curCredits == 0) {
            System.out.println("Do you want to deposit more credits or quit?");
            System.out.println("Press 1 to deposit more credits");
            System.out.println("Press 0 to quit");
            System.out.print("Enter your choice: ");
            int playerInp = console.nextInt();
            switch (playerInp) {
                case 1:
                    depositCredits();
                    break;
                case 0:
                    finalGreetingMsg();
                    return;
            }
        }
        System.out.printf("Credits: %d\n", curCredits);
        System.out.print("How many credits do you wish to bet?: ");
        curBet = console.nextInt();
        validateBet();
    }

    /**
     * Allows a user to deposit credits into their account.
     */
    public void depositCredits() {
        System.out.print("Please type the amount of credits you wish to deposit: ");
        curCredits += console.nextInt();
        System.out.printf("Your total credits is now: %d\n", curCredits);
        readBet();
    }

    /**
     * Validates if a bet made is a valid one or not. e.g. a none valid bet is
     * -10, if the player has less credits than is needed to play etc.
     */
    public void validateBet() {
        if (this.curBet > this.curCredits || this.curBet < 0) {
            System.out.printf("Invalid bet, you need %d more credits to play. Do you wish to deposit more credits or try a smaller bet?\n", curBet - curCredits);
            System.out.printf("%s\n%s\n", "Enter 1 to deposit more money.", "Enter 2 to try a smaller bet.");
            System.out.printf("%s %d\n", "Current Credits:", this.curCredits);
            int playerInp = console.nextInt();
            switch (playerInp) {
                case 1:
                    depositCredits();
                    break;
                case 2:
                    readBet();
                    break;
            }
        } else {
            System.out.println("Here is your lucky spin of the reels...");
            reel.spin();
            totalBets += curBet;
            computeSpinResult();
            readBet();
        }
    }

    /**
     * Checks the current bet and the spin outcome and rewards according to the
     * payouts.
     *
     * @return the amount of credits according to the amount won.
     */
    private int computeSpinResult() {
        int payOuts;
        switch (getSpinOutcome()) {
            case 0: //For Zilch
                this.totalPayOut += 0;
                System.out.printf("You got Zilch! %d credits lost.\n", curBet);
                this.curCredits -= this.curBet;
                totalSpins++;
                return payOuts = 0;
            case 1: //For Double.
                this.totalPayOut += this.curBet * doubleSpinMultiplier;
                this.curCredits += this.curBet * doubleSpinMultiplier;
                System.out.printf("You got a double! You won %d\n", curBet * doubleSpinMultiplier);
                totalSpins++;
                return payOuts = this.curBet * doubleSpinMultiplier;
            case 2: //For Triple.
                this.totalPayOut += this.curBet * tripleSpinMultiplier;
                this.curCredits += this.curBet * tripleSpinMultiplier;
                System.out.printf("You got a triple! You won %d\n", curBet * tripleSpinMultiplier);
                totalSpins++;
                return payOuts = this.curBet * tripleSpinMultiplier;
        }
        return -1;
    }

    /**
     * Checks the outcome of the spin.
     *
     * @return a number that corresponds to a spin result.
     */
    public int getSpinOutcome() {
        int spinOutcome;

        if (!isTriple()) {
            if (!isDouble()) {
                spinOutcome = 0; //For Zilch.
            } else {
                spinOutcome = 1; //For Double.
            }
        } else {
            spinOutcome = 2; //For Triple.
        }
        return spinOutcome;
    }

    /**
     * Compares if all 3 values in the payline are the same.
     *
     * @return
     */
    public boolean isTriple() {
        return reel.getPayline()[0].equals(reel.getPayline()[0])
                && reel.getPayline()[0].equals(reel.getPayline()[1])
                && reel.getPayline()[0].equals(reel.getPayline()[2]);
    }

    /**
     * Checks to see if there is two of the same values in the payline.
     *
     * @return if there is two of the same values in the payline.
     */
    public boolean isDouble() {
        return reel.getPayline()[1].equals(reel.getPayline()[2])
                || reel.getPayline()[0].equals(reel.getPayline()[2]);
    }

    /**
     * Checks to see if there is no values that are the same to each other.
     *
     * @return if there is no values equal to another.
     */
    public boolean isZilch() {
        return !reel.getPayline()[1].equals(reel.getPayline()[0])
                || !reel.getPayline()[1].equals(reel.getPayline()[2])
                || !reel.getPayline()[0].equals(reel.getPayline()[2]);
    }

    @Override
    public String toString() {
        String strOut = String.format("%-20s: %s\n", "Name", name);
        strOut += String.format("%-20s: %s\n", "Current Credits", curCredits);
        strOut += String.format("%-20s: %s\n", "Total Deposits", totalDeposit);
        strOut += String.format("%-20s: %s\n", "Total Payouts", totalPayOut);
        strOut += String.format("%-20s: %s\n", "Total Bets", totalBets);
        strOut += String.format("%-20s: %s\n", "Total Spins", totalSpins);
        strOut += String.format("%-20s: %s\n", "Bottom Line", name);

        return strOut;
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
        return curBet;
    }

    public void setCurrentBet(int currentBet) {
        this.curBet = currentBet;
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
        return curCredits;
    }

    public void setCurrentCredits(int currentCredits) {
        this.curCredits = currentCredits;
    }

    public Scanner getConsole() {
        return console;
    }

    public void setConsole(Scanner console) {
        this.console = console;
    }
}
