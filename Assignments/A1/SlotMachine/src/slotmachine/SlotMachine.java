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
    private boolean initIntroFlag;
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
        this.totalDeposit = currentCredits;
        this.totalPayOut = 0;
        this.totalSpins = 0;
        this.curCredits = currentCredits;
        this.initIntroFlag = true;  //
    }

    /**
     * The intro that plays if the player played before.
     */
    private void defaultIntro() {
        System.out.printf("Welcome back %s!\n", name);
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
        initIntroFlag = false;
    }

    /**
     * Greeting message telling the player to come back soon.
     */
    private void quitMessage() {
        System.out.println("Goodbye, come back soon!");
        System.out.println(toString());
    }

    /**
     * Starts the game.
     */
    public void play() {
        if (initIntroFlag) 
            intro();
        else 
            defaultIntro();
        playRound();
    }

    /**
     * Starts a round of slots.
     */
    private void playRound() {
        if (curCredits == 0) {
            System.out.println("You have zero credits do you wish to deposit more?");
            System.out.println("Enter 1 to deposit credits, 0 to quit.");
            int playerInp = console.nextInt();
            if (playerInp == 1) {
                depositCredits();
            } else {
                quitMessage();
                return;
            }
        }
        
        System.out.println("Current Deposit credits: " + curCredits);
        System.out.println("How many coins do you want to bet? (0 to quit) ");
        int playerInp = console.nextInt();
        if (playerInp <= 0) {
            quitMessage();
            return;
        } else {
            curBet = playerInp;
        }
        validateBet();
    }

    /**
     * Allows a user to deposit credits into their account.
     */
    private void depositCredits() {
        System.out.print("Please type the amount of credits you wish to deposit: ");
        int creditsDeposited = console.nextInt();
        curCredits += creditsDeposited;
        totalDeposit += creditsDeposited;
        System.out.printf("Your total credits is now: %d\n", curCredits);
        playRound();
    }

    /**
     * Validates if a bet made is a valid one or not. e.g. a none valid bet is
     * -10, if the player has less credits than is needed to play etc.
     */
    private void validateBet() {
        // start unsuccessfully
        if (curBet > curCredits || curBet < 0) {
            System.out.printf("Invalid bet, you need %d more credits to play. "
                    + "Do you wish to deposit more credits, try a smaller bet or quit?\n", 
                    curBet - curCredits);
            System.out.printf("%s\n%s\n%s\n", "Enter 1 to deposit more credits.", 
                    "Enter 2 to try a smaller bet.", "Enter 0 to quit");
            System.out.printf("%s %d\n", "Current Credits:", this.curCredits);
            int playerInp = console.nextInt();
            
            switch (playerInp) {
                case 1:
                    depositCredits();
                    break;
                case 2:
                    playRound();
                    break;
                case 0:
                    quitMessage();
                    return;
                default:
                    validateBet();
            }
        } 
        else {
            System.out.println("Here is your lucky spin of the reels...");
            reel.spin();
            totalBets += curBet;
            computeSpinResult();
            playRound();
        }
    }

    /**
     * Checks the current bet and the spin outcome and rewards according to the
     * payouts.
     *
     * @return the amount of credits according to the amount won.
     */
    private int computeSpinResult() {
        totalSpins++;
        switch (getSpinOutcome()) {
            case 0: //For Zilch
                totalPayOut += 0;
                System.out.printf("You got Zilch! %d credits lost.\n", curBet);
                curCredits -= curBet;
                return 0;
            case 1: //For Double.
                totalPayOut += curBet * doubleSpinMultiplier;
                curCredits += curBet * doubleSpinMultiplier;
                System.out.printf("You got a double! You won %d\n", curBet * doubleSpinMultiplier);
                return curBet * doubleSpinMultiplier;
            case 2: //For Triple.
                totalPayOut += curBet * tripleSpinMultiplier;
                curCredits += curBet * tripleSpinMultiplier;
                System.out.printf("You got a triple! You won %d\n", curBet * tripleSpinMultiplier);
                return this.curBet * tripleSpinMultiplier;
            default:
                return -1;
        }
    }

    /**
     * Checks the outcome of the spin.
     *
     * @return a number that corresponds to a spin result.
     */
    private int getSpinOutcome() {
        return isTriple() ? 2 : isDouble() ? 1 : 0;
    }

    /**
     * Compares if all 3 values in the payline are the same.
     *
     * @return
     */
    private boolean isTriple() {
        return reel.getPayline()[0].equals(reel.getPayline()[0])
                && reel.getPayline()[0].equals(reel.getPayline()[1])
                && reel.getPayline()[0].equals(reel.getPayline()[2]);
    }

    /**
     * Checks to see if there is two of the same values in the payline.
     *
     * @return if there is two of the same values in the payline.
     */
    private boolean isDouble() {
        return reel.getPayline()[1].equals(reel.getPayline()[2])
                || reel.getPayline()[0].equals(reel.getPayline()[2])
                || reel.getPayline()[0].equals(reel.getPayline()[1]);
    }

    /**
     * Checks to see if there is no values that are the same to each other.
     *
     * @return if there is no values equal to another.
     */
    private boolean isZilch() {
        return !reel.getPayline()[1].equals(reel.getPayline()[0])
                || !reel.getPayline()[1].equals(reel.getPayline()[2])
                || !reel.getPayline()[0].equals(reel.getPayline()[2]);
    }

    /**
     * Calculates how much loses/profits there was.
     *
     * @return a number of how much was lost/gained.
     */
    private int calculateProfitsLosts() {
        return curCredits - totalDeposit;
    }

    /**
     * Formats the string for profits/losts.
     *
     * @return the formated string.
     */
    private String formatProfitsLosts() {
        String strOut = "";
        if (calculateProfitsLosts() == 0) {
            strOut += String.format("%s", "No Lost, No Gain!");
        } else if (calculateProfitsLosts() < 0) {
            strOut += String.format("Lost %d Credits", Math.abs(calculateProfitsLosts()));
        } else {
            strOut += String.format("Net Gained %d Credits", calculateProfitsLosts());
        }
        return strOut;
    }

    /**
     * ToString method, listing the player name, current credits, total
     * deposits, total payouts, total bets, total spins, and the gained/lost
     * credits.
     *
     * @return the formated String.
     */
    @Override
    public String toString() {
        String strOut = String.format("%-17s: %s\n", "Name", name);
        strOut += String.format("%-17s: %s\n", "Current Credits", curCredits);
        strOut += String.format("%-17s: %s\n", "Total Deposits", totalDeposit);
        strOut += String.format("%-17s: %s\n", "Total Payouts", totalPayOut);
        strOut += String.format("%-17s: %s\n", "Total Bets", totalBets);
        strOut += String.format("%-17s: %s\n", "Total Spins", totalSpins);
        strOut += String.format("%-17s: %s\n", "Bottom Line", formatProfitsLosts());
        return strOut;
    }

    /**
     * Compares two Objects and sees if they are equal to each other.
     *
     * @param slotMachine
     * @return if the two objs are equal to each other.
     */
    public boolean equals(SlotMachine slotMachine) {
        return slotMachine == this;
    }

    /**
     * Getter.
     *
     * @return a reel.
     */
    public Slot3Reel getReel() {
        return reel;
    }

    /**
     * Setter.
     *
     * @param reel sets the value of a reel
     */
    public void setReel(Slot3Reel reel) {
        this.reel = reel;
    }

    /**
     * Getter.
     *
     * @return a name.
     */
    public String getName() {
        return name;
    }

    /**
     * Setter.
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter.
     *
     * @return a current bet.
     */
    public int getCurrentBet() {
        return curBet;
    }

    /**
     * Setter.
     *
     * @param currentBet
     */
    public void setCurrentBet(int currentBet) {
        this.curBet = currentBet;
    }

    /**
     * Getter.
     *
     * @return a total bet.
     */
    public int getTotalBets() {
        return totalBets;
    }

    /**
     * Setter.
     *
     * @param totalBets
     */
    public void setTotalBets(int totalBets) {
        this.totalBets = totalBets;
    }

    /**
     * Getter.
     *
     * @return total deposit.
     */
    public int getTotalDeposit() {
        return totalDeposit;
    }

    /**
     * Setter.
     *
     * @param totalDeposit
     */
    public void setTotalDeposit(int totalDeposit) {
        this.totalDeposit = totalDeposit;
    }

    /**
     * Getter.
     *
     * @return total payout.
     */
    public int getTotalPayOut() {
        return totalPayOut;
    }

    /**
     * Setter.
     *
     * @param totalPayOut
     */
    public void setTotalPayOut(int totalPayOut) {
        this.totalPayOut = totalPayOut;
    }

    /**
     * Getter.
     *
     * @return total spins.
     */
    public int getTotalSpins() {
        return totalSpins;
    }

    /**
     * Setter.
     *
     * @param totalSpins
     */
    public void setTotalSpins(int totalSpins) {
        this.totalSpins = totalSpins;
    }

    /**
     * Getter.
     *
     * @return current credits.
     */
    public int getCurrentCredits() {
        return curCredits;
    }

    /**
     * Setter.
     *
     * @param currentCredits
     */
    public void setCurrentCredits(int currentCredits) {
        this.curCredits = currentCredits;
    }
}
