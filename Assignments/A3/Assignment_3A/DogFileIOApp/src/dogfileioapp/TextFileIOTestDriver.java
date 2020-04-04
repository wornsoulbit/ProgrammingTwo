
package dogfileioapp;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Test driver for dogFileIO project.
 * 
 * @author Alex Vasil
 */
public class TextFileIOTestDriver {
    public static void main(String[] args) throws FileNotFoundException {
        String inFileName = "./dog_infile.txt";
        ArrayList<PetDog> dogList = TextFileIO.readTextFileToArrayList(inFileName);
        
        //Sort dogList by their name.
        Collections.sort(dogList, new SortDogsByName());
        String outFileName = "./dog_by_name.txt";
        TextFileIO.writeArrayListToTextFile(dogList, outFileName);
        System.out.println("Finished writing to " + outFileName);
        
        //Sort dogList by their breed.
        Collections.sort(dogList, new SortDogsByBreed());
        outFileName = "./dog_by_breed.txt";
        TextFileIO.writeArrayListToTextFile(dogList, outFileName);
        System.out.println("Finished writing to " + outFileName);
        
        //Sort dogList by their age.
        Collections.sort(dogList, new SortDogsByAge());
        outFileName = "./dog_by_age.txt";
        TextFileIO.writeArrayListToTextFile(dogList, outFileName);
        System.out.println("Finished writing to " + outFileName);
        
        //Sort dogList by their name.
        Collections.sort(dogList, new SortDogsByNameAge());
        outFileName = "./dog_by_name_age.txt";
        TextFileIO.writeArrayListToTextFile(dogList, outFileName);
        System.out.println("Finished writing to " + outFileName);
    }
}
