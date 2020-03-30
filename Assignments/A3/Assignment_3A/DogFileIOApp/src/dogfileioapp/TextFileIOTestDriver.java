
package dogfileioapp;

import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * Test driver for dogFileIO project.
 * 
 * @author Alex Vasil
 */
public class TextFileIOTestDriver {
    public static void main(String[] args) throws FileNotFoundException {
        String inFileName = "./dog_infile.txt";
        ArrayList<PetDog> dogList = TextFileIO.readTextFileToArrayList(inFileName);
        
        String outFileName = "./dog_outfile.txt";
        TextFileIO.writeArrayListToTextFile(dogList, outFileName);        
    }
}
