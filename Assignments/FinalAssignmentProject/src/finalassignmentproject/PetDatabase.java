package finalassignmentproject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.Scanner;

/**
 * A database for the pets in the zoo.
 *
 * @author Alex Vasil
 */
public class PetDatabase {

    private String name;
    private ArrayList<Pet> petList;

    /**
     * Constructor for a PetDatabase.
     * 
     * @param mallName name of the database.
     */
    public PetDatabase(String mallName) {
        name = mallName;
        petList = new ArrayList<>();
    }

    /**
     * Adds a pet to database.
     * 
     * @param inputLine the pet data.
     * @throws UnknownPetTypeException unknown pet type exception.
     */
    public void addPet(String inputLine) throws UnknownPetTypeException {
        Pet pet = null;

        try {
            pet = petFactory(inputLine);
        } catch (NumberFormatException ex) {
            System.err.println(ex.getMessage());
            System.err.println("the string representing the number of eggs "
                    + "does not contain a parsable integer.");
            System.err.println("Bad input line: " + inputLine);
            System.err.println("Bad input line ignored\n");
        } catch (UnknownPetTypeException ex) {
            System.err.println(ex.getMessage());
            System.err.println("Pet type can be one of dog, cat or duck, "
                    + "case insensitive");
            System.err.println("Bad input line: " + inputLine);
            System.err.println("Bad input line ignored\n");
        } catch (IllegalArgumentException ex) {
            System.err.println(ex.getMessage());
            System.err.println("The neutered value must be yes or no");
            System.err.println("Bad input line: " + inputLine);
            System.err.println("Bad input line ignored\n");
        }
        if (pet != null) {
            petList.add(pet);
        }
    }

    /**
     * Removes the given pet.
     * 
     * @param id the pet to be removed.
     */
    public void removePet(int id) {
        int petIndex = -1;
        
        for (int i = 0; i < petList.size(); i++) {
            if(petList.get(i).getId() == id) {
                petIndex = i;
                break;
            }
        }
        
        if(petIndex < 0) {
            System.out.println("Error: no pet with ID number " + id);
            return;
        }
        petList.remove(petIndex);
    }

    /**
     * Gets the pet data and returns the type.
     * 
     * @param inputLine the inputted data.
     * @return A new pet.
     * @throws UnknownPetTypeException An unknown pet type.
     */
    private Pet petFactory(String inputLine) throws UnknownPetTypeException {
        Scanner lineScanner = new Scanner(inputLine);
        lineScanner.useDelimiter("\\s*,\\s*");
        
        String petType = "";
        if (lineScanner.hasNext()) {
            petType = lineScanner.next();
            System.out.println("Pet Type: " + petType);
        }
        String petSpecificData = "";
        if (lineScanner.hasNext()) {
            petSpecificData = lineScanner.next();
            System.out.println("Pet Specific Data: " + petSpecificData);
        }
        String petGeneralData = "";
        if (lineScanner.hasNext()) {
            petGeneralData = lineScanner.nextLine();
            System.out.println("Pet General Data: " + petGeneralData);
        }
        lineScanner.close();

        if (petType.equalsIgnoreCase("dog")) {
            return new Dog(petGeneralData, petSpecificData);
        } else if (petType.equalsIgnoreCase("cat")) {
            return new Cat(petGeneralData, petSpecificData);
        } else if (petType.equalsIgnoreCase("duck")) {
            return new Duck(petGeneralData, petSpecificData);
        } else {
            throw new UnknownPetTypeException("Input error: unknown pet type \""
                    + petType + "\"");
        }
    }

    /**
     * Writes all the information in the database to a file.
     * 
     * @param outFileName the name of the outfile with extension.
     * @throws FileNotFoundException if a file isn't found.
     */
    public void writeToFile(String outFileName) throws FileNotFoundException {
        File file = new File(outFileName);
        PrintWriter printWriter = new PrintWriter(file);
        String petSpecificValue = "unknown specifics";

        for (Pet pet : petList) {
            if (pet instanceof Dog) {
                Dog dog = (Dog) pet;
                petSpecificValue = "Dog, " + dog.getBreed();
            } else if (pet instanceof Cat) {
                Cat cat = (Cat) pet;
                petSpecificValue = "Cat, " + (cat.isNeutered() ? "yes" : "no");
            } else if (pet instanceof Duck) {
                Duck duck = (Duck) pet;
                petSpecificValue = "Duck, " + duck.getEggs();
            }
            printWriter.println(petSpecificValue + ", " + pet.getName() + ", "
                    + pet.getAge() + ", " + pet.getGender());
        }
        printWriter.close();
    }

    /**
     * Loads a file, and uses the data in it to add to the database.
     * 
     * @param inFileName the name of the file with the extension.
     */
    public void loadFromFile(String inFileName) {
        File file = new File(inFileName);
        Scanner fileScanner = null;
        try {
            fileScanner = new Scanner(file);
        } catch (FileNotFoundException ex) {
            System.out.println("Could not open the supplied input file: " + inFileName);
            System.out.println("Try again later with a text file named " + inFileName);
            System.out.println(" in the project folder of this project.");
            return;
        }

        petList = new ArrayList<>();

        int lineCounter = 0;
        while (fileScanner.hasNextLine()) {
            ++lineCounter;
            String line = fileScanner.nextLine();
            Pet pet = null;
            try {
                pet = petFactory(line);
            } catch (NumberFormatException ex) {
                System.err.println(ex.getMessage());
                System.err.println("the string representing the number of eggs "
                        + "does not contain a parsable integer.");
                System.err.println("Bad input line: " + line);
                System.err.println("Bad input line number: " + lineCounter);
                System.err.println("Bad input line ignored\n");
            } catch (UnknownPetTypeException ex) {
                System.err.println(ex.getMessage());
                System.err.println("Pet type can be one of dog, cat or duck, "
                        + "case insensitive");
                System.err.println("Bad input line: " + line);
                System.err.println("Bad input line number: " + lineCounter);
                System.err.println("Bad input line ignored\n");
            } catch (IllegalArgumentException ex) {
                System.err.println(ex.getMessage());
                System.err.println("The neutered value must be yes or no");
                System.err.println("Bad input line: " + line);
                System.err.println("Bad input line number: " + lineCounter);
                System.err.println("Bad input line ignored\n");
            }
            if (pet != null) {
                petList.add(pet);
            }
        }
        fileScanner.close();
        System.out.println("Completed processing " + lineCounter + " pet records");
    }

    /**
     * Centers a text.
     * 
     * @param text the text to be centered.
     * @param width the padding.
     * @return text thats centered.
     */
    private static String centerText(String text, int width) {
        if (width < text.length()) {
            return text;
        }

        final String BLANK = " ";
        int totalLeadAndTrailSpaces = width - text.length();
        int leadSpaces = (totalLeadAndTrailSpaces) / 2;
        int trailSpaces = (totalLeadAndTrailSpaces % 2 == 1) ? leadSpaces + 1 : leadSpaces;

        String result = "";

        for (int i = 0; i < leadSpaces; i++) {
            result += BLANK;
        }
        
        result += text;
        
        for (int i = 0; i < trailSpaces; i++) {
            result += BLANK;
        }

        return result;
    }

    /**
     * Gets the name.
     * 
     * @return the name.
     */
    public String getName() {
        return name;
    }

    /**
     * Sorts the pets by name then prints a sorted message.
     */
    public void sortByName() {
        Collections.sort(petList, new NameComparator());
        System.out.println("Database is now sorted by name");
    }

    /**
     * Sorts the pets by age then prints a sorted message.
     */
    public void sortByAge() {
        Collections.sort(petList, new AgeComparator());
        System.out.println("Database is now sorted by age");
    }

    /**
     * Sorts the pets by gender then prints a sorted message.
     */
    public void sortByGender() {
        Collections.sort(petList, new ComparatorGender());
        System.out.println("Database is now sorted by gender");
    }

    /**
     * A formatted string.
     * 
     * @return formatted string.
     */
    @Override
    public String toString() {
        String strOut = String.format("-------------------------------------------------------------------------------------------\n");
        strOut += String.format("%49s", "Quartier Cavendish Petting Zoo\n");
        strOut += String.format("-----------------------------------------------------------------------------------------------\n");
        strOut += String.format("%8s %20s %12s %15s %16s %17s", "ID", "Pet"
                + " Type", "Name", "Age", "Gender", "Specifics\n");
        strOut += String.format("-----------------------------------------------------------------------------------------------\n");
        final int PAD_SPACING = 16;
        for (Pet pet : petList) {
            if (pet instanceof Dog) {
                Dog dog = (Dog) pet;
                strOut += centerText(String.format("%s" ,dog.getId()), PAD_SPACING) 
                        + centerText(String.format("%s" ,"Dog"), PAD_SPACING) 
                        + centerText(String.format("%s" ,dog.getName()), PAD_SPACING) 
                        + centerText(String.format("%s" ,dog.getAge()), PAD_SPACING)
                        + centerText(String.format("%s" ,dog.getGender()), PAD_SPACING)
                        + centerText(String.format("%s" ,dog.getBreed()), PAD_SPACING) 
                        + "\n";
            } else if (pet instanceof Cat) {
                Cat cat = (Cat) pet;
                strOut += centerText(String.format("%s" ,cat.getId()), PAD_SPACING) 
                        + centerText(String.format("%s" ,"Cat"), PAD_SPACING) 
                        + centerText(String.format("%s" ,cat.getName()), PAD_SPACING) 
                        + centerText(String.format("%s" ,cat.getAge()), PAD_SPACING)
                        + centerText(String.format("%s" ,cat.getGender()), PAD_SPACING)
                        + centerText(String.format("%s" ,cat.isNeutered() ? "Neutered" : "Not Neutered"), PAD_SPACING) 
                        + "\n";
            } else if (pet instanceof Duck) {
                Duck duck = (Duck) pet;
                strOut += centerText(String.format("%s" ,duck.getId()), PAD_SPACING) 
                        + centerText(String.format("%s" ,"Duck"), PAD_SPACING) 
                        + centerText(String.format("%s" ,duck.getName()), PAD_SPACING) 
                        + centerText(String.format("%s" ,duck.getAge()), PAD_SPACING)
                        + centerText(String.format("%s" ,duck.getGender()), PAD_SPACING)
                        + centerText(String.format("%s" ,duck.getEggs() + " eggs"), PAD_SPACING) 
                        + "\n";
            } else {
                strOut += centerText(String.format("%s" ,pet.getId()), PAD_SPACING) 
                        + centerText(String.format("%s" ,"Pet"), PAD_SPACING) 
                        + centerText(String.format("%s" ,pet.getName()), PAD_SPACING) 
                        + centerText(String.format("%s" ,pet.getAge()), PAD_SPACING)
                        + centerText(String.format("%s" ,pet.getGender()), PAD_SPACING)
                        + "\n";
            }
        }
        return strOut;
    }

    /**
     * Equals method.
     * 
     * @param obj other object compared to.
     * @return If two objects are equals to each other.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PetDatabase other = (PetDatabase) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.petList, other.petList)) {
            return false;
        }
        return true;
    }

}
