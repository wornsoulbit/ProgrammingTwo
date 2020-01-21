package slotmachine;

/**
 * 
 * @author Alex Vasil
 */
public class SlotMachine {
    private Slot3Reel reel = new Slot3Reel();
    private String name;
    private double curBet;
    private double totalBets;
    private double totalDep;
    private double totalPayOut;
    private int totalSpins;

    public SlotMachine() {
        this.name = "Bob";
        this.curBet = 0;
        this.totalBets = 0;
        this.totalDep = 0;
        this.totalPayOut = 0;
        this.totalSpins = 0;
    }
    
    
    
    public void play() {
        
    }
    
    public void intro() {
        String intro = "";
        intro += String.format("%s %s\n", "Greetings", name, "");
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
                || reel.getPayline().get(1).equals(reel.getPayline().get(2));
    } 
    
    /**
     * Checks to see if there is no values that are the same to each other.
     * @return if there is no values equal to another.
     */
    public boolean isZilch() {
        return !reel.getPayline().get(0).equals(reel.getPayline().get(1)) 
                || !reel.getPayline().get(0).equals(reel.getPayline().get(2)) 
                || !reel.getPayline().get(1).equals(reel.getPayline().get(2));
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

    public void setCurBet(double curBet) {
        this.curBet = curBet;
    }

    public void setTotalBets(double totalBets) {
        this.totalBets = totalBets;
    }

    public void setTotalDep(double totalDep) {
        this.totalDep = totalDep;
    }

    public void setTotalPayOut(double totalPayOut) {
        this.totalPayOut = totalPayOut;
    }

    public void setTotalSpins(int totalSpins) {
        this.totalSpins = totalSpins;
    }

    
}
