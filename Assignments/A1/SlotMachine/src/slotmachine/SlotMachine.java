package slotmachine;

import MyUtil.MyScanner;
        
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
    private boolean initIntroFlag; //Checks if the initial intro with the rules has been showned.
    private boolean isGameOver; //Checks to see if the game is over.
    private final int doubleSpinMultiplier = 2;
    private final int tripleSpinMultiplier = 3;
    MyScanner console = new MyScanner();
    
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
        this.initIntroFlag = true;  //Checks to see if the initial introduction 
        //with rules is showned to the player.
        this.isGameOver = false; //Checks to see if the game is ending.
    }

    /**
     * The intro that plays if the player played before.
     */
    private void gameIntro() {
        System.out.printf("Welcome back %s!\n", name);
    }

    /**
     * Introduction to the game.
     */
    private void rulesIntro() {
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
        System.out.println("\nGoodbye, come back soon!");
        System.out.println(toString());
        isGameOver = true;
    }

    /**
     * Starts the game.
     */
    public void play() {
        //Checks to see if endGame is true, if it is, sets to false.
        if (isGameOver) 
            isGameOver = false;
        
        if (initIntroFlag)
            rulesIntro();
        else 
            gameIntro();
        playRound();
    }

    /**
     * Starts a round of slots.
     */
    private void playRound() {
        do {
            checkCredits();
            System.out.println("\nCurrent Deposit credits: " + curCredits);
            System.out.print("How many coins do you want to bet? (0 to quit) ");
            int playerInp = console.readNonNegativeInt();
                
            if (playerInp == 0) {
                quitMessage();
            } else {
                curBet = playerInp;
            }
            
            //Checks to see if the game has ended.
            if (!isGameOver) {
                validateBet();
            }
        } while (!isGameOver);
    }

    /**
     * Allows a user to deposit credits into their account.
     */
    private void depositCredits() {
        System.out.print("Please type the amount of credits you wish to deposit: ");
        int creditsDeposited = console.readNonNegativeInt();
        
        curCredits += creditsDeposited;
        totalDeposit += creditsDeposited;
        
        System.out.printf("Your total credits is now: %d\n", curCredits);
    }

    /**
     * Checks if the player has less than 5 credits or has 0 credits, if they do 
     * prompts the user the options of continue to play, deposit more credits or 
     * the option to quit.
     */
    private void checkCredits() {
        if (curCredits == 0) {
            System.out.println("You have zero credits do you wish to deposit more?");
            System.out.println("Enter 1 to deposit credits, 0 to quit.");
            int playerInp = console.readNonNegativeInt();
            
            if (playerInp == 1) {
                depositCredits();
            } else {
                quitMessage();
            }
            return;
        }
        
        if (curCredits <= 5) {
            System.out.printf("\nYou have %d credits do you wish to deposit more?\n", curCredits);
            System.out.println("Enter 1 to deposit credits, 2 to keep playing, 0 to quit.");
            int playerInp = console.readNonNegativeInt();
            
            switch (playerInp) {
                case 1: 
                    depositCredits();
                    break;
                case 2:
                    break;
                case 0: 
                    quitMessage();
                default:
                    checkCredits();
            }
        }
    }
    
    /**
     * Validates if a bet made is a valid one or not. e.g. a none valid bet is
     * -10, if the player has less credits than is needed to play etc.
     */
    private void validateBet() {
        //Unsuccessful Start. E.g. Invalid bet.
        if (curBet > curCredits || curBet < 0) {
            System.out.printf("Invalid bet, you need %d more credits to play. "
                    + "Do you wish to deposit more credits, try a smaller bet or quit?\n",
                    curBet - curCredits);
            System.out.printf("%s\n%s\n%s\n", "Enter 1 to deposit more credits.",
                    "Enter 2 to try a smaller bet.", "Enter 0 to quit");
            System.out.printf("%s %d\n", "Current Credits:", this.curCredits);
            int playerInp = console.readNonNegativeInt();

            switch (playerInp) {
                case 1:
                    depositCredits();
                    break;
                case 2:
                    break;
                case 0:
                    quitMessage();
                    return;
                default:
                    validateBet();
            }
        } 
        //Successful Start. E.g. Valid bet.
        else {
            System.out.println("\nHere is your lucky spin of the reels...");
            reel.spin();
            totalBets += curBet;
            computeSpinResult();
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
        if (isTriple()) 
            return 2;
        else if (isDouble())
            return 1;
        else 
            return 0;
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
                && !reel.getPayline()[1].equals(reel.getPayline()[2])
                && !reel.getPayline()[0].equals(reel.getPayline()[2]);
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
        if (calculateProfitsLosts() == 0) { //If profits is zero.
            strOut += String.format("%s", "No Lost, No Gain!");
        } else if (calculateProfitsLosts() < 0) { //If profits is less than zero.
            strOut += String.format("Lost %d Credits", Math.abs(calculateProfitsLosts()));
        } else { //If there is a profit made.
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
     * @param obj the object being compared.
     * @return if the two objects are equal to each other.
     */
    @Override
    public boolean equals(Object obj) {
        SlotMachine slotMachine = (SlotMachine) obj;
        
        if (!(obj instanceof SlotMachine))
            return false;
        
        return reel.equals(slotMachine.reel) 
                && name.equals(slotMachine.name)
                && curBet == slotMachine.curBet
                && curCredits == slotMachine.curCredits
                && totalBets == slotMachine.totalBets
                && totalDeposit == slotMachine.totalDeposit
                && totalPayOut == slotMachine.totalPayOut
                && totalSpins == slotMachine.totalSpins
                && initIntroFlag == slotMachine.initIntroFlag
                && isGameOver == slotMachine.isGameOver;
    }
}