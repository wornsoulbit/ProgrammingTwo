
package finalassignmentproject;

import java.io.FileNotFoundException;
import java.util.Scanner;


/**
 *
 * @author Alex Vasil
 */
public class PettingZooApp {
    
    /**
     * Run file for the application.
     * 
     * @throws UnknownPetTypeException a pet that isn't a cat, dog or duck.
     * @throws FileNotFoundException if a file isn't found.
     */
    public void run() throws UnknownPetTypeException, FileNotFoundException {
        PetDatabase p1 = new PetDatabase("ZooApp");
        Scanner userInput = new Scanner(System.in);

        while (true) {
            printMenu();
            switch (getChoice()) {
                case 1:
                    System.out.println(p1.toString());
                    break;
                case 2:
                    System.out.println("Enter 5 comma-separated values: pet type, specific pet info, name, age, gender: ");
                    String inputPet = userInput.nextLine();
                    p1.addPet(inputPet);
                    break;
                case 3:
                    System.out.println("Enter the ID number of the pet to remove: ");
                    int inputId = userInput.nextInt();
                    p1.removePet(inputId);
                    break;
                case 4:
                    p1.sortByName();
                    break;
                case 5:
                    p1.sortByAge();
                    break;
                case 6:
                    p1.sortByGender();
                    break;
                case 7:
                    System.out.print("Enter input file name: ");
                    String inputFileName = userInput.nextLine();
                    p1.loadFromFile(inputFileName);
                    break;
                case 8:
                    System.out.print("Enter output file name: ");
                    String outputFileName = userInput.nextLine();
                    p1.writeToFile(outputFileName);
                    break;
                case 9:
                    System.out.println("Goodbye!");
                    return;
            }
        }
    }
    
    /**
     * Prints the menu.
     */
    public void printMenu() {
        String strOut = "Choose from these options\n";
        strOut += "------------------------------\n";
        strOut += "1 - Print pet list\n";
        strOut += "2 - Add a new pet record\n";
        strOut += "3 - Remove a pet record\n";
        strOut += "4 - Sort pet list by name\n";
        strOut += "5 - Sort pet list by age\n";
        strOut += "6 - Sort pet list by gender\n";
        strOut += "7 - Load database from file\n";
        strOut += "8 - Save database to file\n";
        strOut += "9 - Quit\n";
        strOut += "Your choice? ";
        System.out.println(strOut);
    }
    
    /**
     * Gets the inputed choice of the user.
     * @return the inputed number.
     */
    public int getChoice() {
        MyScanner console = new MyScanner();
        return console.readNonLessThanOneInt();
    }
    
    /**
     * Run method for the entire application.
     * @param args 
     * @throws UnknownPetTypeException a pet that isn't a cat, dog or duck.
     * @throws FileNotFoundException if a file isn't found.
     */
    public void main(String[] args) throws UnknownPetTypeException, FileNotFoundException {
        run();
    }
}
