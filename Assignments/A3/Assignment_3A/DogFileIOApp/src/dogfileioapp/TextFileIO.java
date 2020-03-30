
package dogfileioapp;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Alex Vasil
 */
public class TextFileIO {
    
    /**
     * Reads a text file and adds each dog to the arrayList.
     * 
     * @param fileName The name of the file thats to be read of.
     * @return An arrayList filled with all the dogs in it.
     * @throws FileNotFoundException If file isn't found.
     */
    public static ArrayList<PetDog> readTextFileToArrayList(String fileName) throws FileNotFoundException {
        ArrayList<PetDog> dogList = new ArrayList<>();
        File file = new File(fileName);
        Scanner fileScanner = new Scanner(file);
        
        while (fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine();
            PetDog dog = new PetDog(line);
            dogList.add(dog);
        }
        
        fileScanner.close();
        return dogList;
    }
    
    /**
     * Writes to a given text file, all the information in the arrayList.
     * 
     * @param dogList ArrayList with the information.
     * @param fileName The name of the file.
     * @throws FileNotFoundException If file isn't found.
     */
    public static void writeArrayListToTextFile(ArrayList<PetDog> dogList, String fileName) throws  FileNotFoundException {
        PrintWriter pw = new PrintWriter(fileName);
        for (PetDog dogs : dogList) {
            pw.println(dogs);
        }
        pw.close();
    }
}
