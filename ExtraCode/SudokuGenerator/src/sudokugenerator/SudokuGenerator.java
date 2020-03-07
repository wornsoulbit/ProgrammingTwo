package sudokugenerator;

import java.util.Arrays;
import java.util.Random;

/**
 * Generates a random completed sudoku square.
 *
 * @author Alex Vasil
 */
public class SudokuGenerator {

    private int[][] sudokuSqaure = new int[9][9];

    /**
     * Generates a random sudoku square
     */
    public void generateSudokuSquare() {
        Random rand = new Random();

        for (int[] row : sudokuSqaure) {
            int[] pool = new int[9];
            pool = populateSudokuNumberArray(pool);
            for (int j = 0; j < row.length; j++) {
                int randomNum = rand.nextInt(pool.length);
                row[j] = pool[randomNum];
                pool = removeElement(pool, randomNum);
            }
        }
    }

    private boolean isValidSudokuSqaure() {
        return true;
    }
    
    private int[][] squareArray(int rowIndex, int colIndex) {
        int[][] squareArr = new int[3][3];
        return squareArr;
    }
    
    private int[] rowArray(int index) {
        if (index > sudokuSqaure.length || index < 0)
            throw new IllegalArgumentException("Index out of bounds of array");
        
        return Arrays.copyOf(sudokuSqaure[index], sudokuSqaure[index].length);
    }
    
    private int[] colArray(int index) {
        if (index > sudokuSqaure[0].length || index < 0)
            throw new IllegalArgumentException("Index out of bounds of array");
        
        int[] col = new int[9];
        for (int i = 0; i < sudokuSqaure.length; i++) 
            col[i] = sudokuSqaure[index][i];
        return col;
    }
    
    /**
     * Populates an int array with numbers 1-9.
     *
     * @param array Array to be filled.
     * @return An int array with numbers 1-9 in it.
     */
    private int[] populateSudokuNumberArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }
        return array;
    }

    /**
     * Removes an element of an int array at the given index.
     *
     * @param array Array with an element to be removed.
     * @param index Element to be removed.
     * @return New int array without the given index in the list.
     */
    private int[] removeElement(int[] array, int index) {
        int[] newArray = new int[array.length - 1];

        for (int i = 0, k = 0; i < array.length; i++) {
            if (i != index) {
                newArray[k] = array[i];
                k++;
            }
        }

        return newArray;
    }

    /**
     * Adds to a string all the numbers in the array.
     *
     * @return A formated string of all the numbers in the array.
     */
    @Override
    public String toString() {
        String strOut = String.format("");
        for (int[] row : sudokuSqaure) {
            for (int col : row) {
                strOut += String.format("%-3d", col);
            }
            strOut += "\n";
        }
        return strOut;
    }
}
