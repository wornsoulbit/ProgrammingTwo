
package inputoutputapp;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author Alex Vasil
 */
public class IOProcessing {
    //Reads the student records from the input file, computes the average for each
    //student record and then write the result to a file named output.txt.
    public static void main(String[] args) throws FileNotFoundException {
        //Prepare to read from the file.
        //Step 1: Create a file object
        
        String inputFileName = "C:\\Users\\cstuser\\Desktop\\ProgrammingTwo\\ExtraCode\\InputOutputApp\\IO_Files\\student_grades.txt";
        String outputFileName = "C:\\Users\\cstuser\\Desktop\\ProgrammingTwo\\ExtraCode\\InputOutputApp\\IO_Files\\output.txt";
        File file = new File(inputFileName);
        //Step 2: Check that the input file exists.
        if (!file.exists()) {
            System.out.println("Error: couldn't open given file" + inputFileName);
            System.exit(1);
        }
        //Step 3: Create a scanner object attached to input file.
        Scanner fileReader = new Scanner(file);
        
        //Prepare output file.
        PrintWriter pw = new PrintWriter(new File(outputFileName));
        
        
        while (fileReader.hasNextLine()) {
            String line = fileReader.nextLine();
            double average = computeAverage(line);
            System.out.printf("%s  %6.2f\n", line, average);
            pw.printf("%s  %6.2f\n", line, average);
        }
        
        pw.close();
        fileReader.close();
    }
    
    private static double computeAverage(String line) {
        int[] grades = new int[9];
        Scanner strReader = new Scanner(line);
        int sum = 0;
        int score;
        
        for (int i = 0; i < grades.length; i++) {
            score = strReader.nextInt();
            sum += score;
        }
        
        char letter = strReader.next().charAt(0);
        long id = strReader.nextLong();
        String name = strReader.nextLine();
        
        double average = (double) sum / grades.length;
        return average;
    }
}
