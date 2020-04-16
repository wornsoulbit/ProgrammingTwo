package pet;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Demonstrates exception handling and polymorphism.
 *
 * @author sg
 */
public class ExceptionApplication {

    /**
     * Demonstrates exception handling of both checked and unchecked types;
     * extracts the contents of a given CSV input file line by line, dissecting
     * each line into appropriate values, creating a pet object using the
     * values, and storing the resulting pet object in an array list;
     * Demonstrate polymorphism by printing out the pet objects in the array
     * list.
     *
     * @param args Unused.
     */
    public static void main(String[] args)// notice no throws-statement here
    // for UnknowPetTypeException, even
    // though it is checked (why?)
    {
        // normally, we don't hard code the file name; we do it here for simplicity
        String infileName = "pet_input_file.txt";
        File file = new File(infileName);
        Scanner fileScanner = null;
        try {   // the folowing call can potentinally throw a FileNotFoundException
            fileScanner = new Scanner(file); // try openning file for input
        } catch (FileNotFoundException ex) {
            System.out.println("Could not open the supplied input file: " + infileName);
            System.out.println("Try again later with a text file named " + infileName);
            System.out.println(" in the project folder of this project.");
            return;
        }
        // input file ok and ready to process
        // so, let's first allocate storage for our pet objects
        ArrayList<Pet> petList = new ArrayList<>();

        int lineCounter = 0;
        while (fileScanner.hasNextLine()) // while there is a next line in the file
        {
            ++lineCounter;
            String line = fileScanner.nextLine();     // read a line
            Pet pet = null;
            try {
//     petFactory can potentially throw one of three exceptions (see catch blocks below)
                pet = petFactory(line);
//     if petFactorythrows an exception, the assignement operatiorn is not performed
//     leaving pet equal to null
            } catch (NumberFormatException ex) {
                System.err.println(ex.getMessage());
                System.err.println("the string representing the number of eggs "
                        + "does not contain a parsable integer.");
                System.err.println("Bad input line: " + line);
                System.err.println("Bad input line number: " + lineCounter);
                System.err.println("Bad input line ignored\n");
                //pet remains null
            } catch (UnknownPetTypeException ex) {
                System.err.println(ex.getMessage());
                System.err.println("Pet type can be one of dog, cat or duck, "
                        + "case insensitive");
                System.err.println("Bad input line: " + line);
                System.err.println("Bad input line number: " + lineCounter);
                System.err.println("Bad input line ignored\n");
                //pet remains null
            } catch (IllegalArgumentException ex) {
                System.err.println(ex.getMessage());
                System.err.println("The neutered value must be yes or no");
                System.err.println("Bad input line: " + line);
                System.err.println("Bad input line number: " + lineCounter);
                System.err.println("Bad input line ignored\n");
                //pet remains null
            }
            if (pet != null) // if no exception was thrown
            {
                petList.add(pet);
            }
        }
        fileScanner.close(); // remember to close files when your are done with them
        System.out.println("Completed processing " + lineCounter + " pet records");

        // show off polymorphism
        System.out.println("\nUnsorted list of pets");
        for (Pet pet : petList) {
            System.out.println(pet);
            // at runtime, Dog's toString() is called if pet references a Dog object
            // at runtime, Cat's toString() is called if pet references a Cat object
            // at runtime, Duck's toString() is called if pet references a Duck object
        }

        // sort using our Pet's compareTo() method for ordering of pet objects
        Collections.sort(petList);

        System.out.println("\nSorted list of pets");
        // show off polymorphism
        for (Pet pet : petList) {
            System.out.println(pet);
            // at runtime, Dog's toString() is called if pet references a Dog object
            // at runtime, Cat's toString() is called if pet references a Cat object
            // at runtime, Duck's toString() is called if pet references a Duck object
        }
    }

    /**
     * Extracts the comma separated values from a given input line, creates a
     * Pet object accordingly, and then returns that object.
     *
     * @param inputLine The given input line.
     * @param lineCounter The line number associated with the given input line.
     * @return A Pet object of type Dog, Cat, or Duck.
     * @throws UnknowPetTypeException If input line has unknown pet type.
     * @throws NumberFormatException If number of eggs is not an integer.
     * @throws IllegalArgumentException If neutered value is neither "yes" nor
     * "no"
     */
    public static Pet petFactory(String inputLine) throws
            UnknownPetTypeException // checked, must be declared because
    // we choose not to handle it in this method
    //           ,NumberFormatException,   // unchecked, no need to declare it
    //           ,IllegalArgumentException // unchecked, no need to declare it
    {
        // create a Scanner using inputLine
        Scanner lineScanner = new Scanner(inputLine);
        // Tell lineScanner that inputLine consists of data separated by commas,
        // which are each preceded and followed by zero or more spaces
        lineScanner.useDelimiter("\\s*,\\s*");

        // read the pet type
        String petType = lineScanner.next();
        // read pet specific data: breed for dog, neutered for cat, or eggs for duck
        String petSpecificData = lineScanner.next();
        // read pet general data which is comma separated of the form "name, age, gender"
        String petGeneralData = lineScanner.nextLine();
        lineScanner.close(); // close lineScanner

        // next validiate the pet type
        if (petType.equalsIgnoreCase("dog")) {
            return new Dog(petGeneralData, petSpecificData);
        } else if (petType.equalsIgnoreCase("cat")) {
            return new Cat(petGeneralData, petSpecificData);
        } else if (petType.equalsIgnoreCase("duck")) {
            return new Duck(petGeneralData, petSpecificData);
        } else {  // bad pet type
            throw new UnknownPetTypeException("Input error: unknown pet type \""
                    + petType + "\"");
        }
    }
}
