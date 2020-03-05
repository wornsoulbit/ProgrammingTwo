package sudokugenerator;

import java.util.Arrays;
import java.util.Random;

/**
 * Generates a random completed sudoku square.
 * 
 * @author Alex Vasil
 */
public class SudokuGenerator {
    private int[][] sudokuSqaure;
    private final int [] numberRow = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    Random rand = new Random();
    
    public SudokuGenerator() {
        sudokuSqaure = new int[9][9];
    }
    
    public void generateSudokuSqaure() {
        for (int[] row : sudokuSqaure) {
            int[] nums = Arrays.copyOf(numberRow, numberRow.length);
            for (int j = 0; j < row.length; j++) {
                int randomEle = rand.nextInt(nums.length);
                row[j] = nums[randomEle];
                nums = removeElementArray(nums, randomEle);
            }
        }
    }
    
    public int[] removeElementArray(int[] array, int index) {
        int[] newArray = new int[array.length - 1];
        for (int i = 0, k = 0; i < array.length; i++) 
            if (i != index)
                newArray[k++] = array[i];
        return newArray;
    }
    
    public boolean checkSudokuIsValid(int randomNum) {
        for (int i = 0; i < sudokuSqaure.length; i++) {
            for (int j = 0; j < sudokuSqaure[i].length; j++) {
                if (sudokuSqaure[i][j] == randomNum || sudokuSqaure[j][i] == randomNum)
                    return false;
            }
        }
        return true;
    }
    
    @Override
    public String toString() {
        String strOut = String.format("");
        for (int[] row : sudokuSqaure) {
            for (int col : row)
                strOut += String.format("%-3d", col);
            strOut += "\n";
        }
        return strOut;
    }
}
