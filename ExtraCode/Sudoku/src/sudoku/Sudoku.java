package sudoku;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * Class of a sudoku.
 *
 * @author Alex Vasil
 */
public class Sudoku {

    private int[][] sudokuSqaure;
    private int solveAttempts; //The amount of attempts was made to solve the current square.
    
    /**
     * Randomly generates a fresh sudoku square from an empty 9x9 array.
     */
    public Sudoku() {
        sudokuSqaure = new int[9][9];
        while (sudokuSqaure[0][0] == 0) {
            generateSudokuSqaure();
            solveAttempts++;
        }
    }
    
    /**
     * Solves a given sudoku square.
     * 
     * @param incompleteSudoku Given sudoku square
     */
    public Sudoku(int[][] incompleteSudoku) {
        
    }
    
    /**
     * Generates and fills a 9x9 array with numbers that is a valid sudoku square.
     * 
     * @return A valid sudoku square.
     */
    private int[][] generateSudokuSqaure() {
        Random rand = new Random();
        
        for (int i = 0; i < sudokuSqaure.length; i++) {
            for (int j = 0; j < sudokuSqaure[0].length; j++) {
                ArrayList<Integer> pool = new ArrayList<>(9);
                //Step 1: Initalize the pool with numbers 1-9.
                initPool(pool);
                //Step 2: Update the pool to remove the numbers in the current row.
                updatePool(pool, rowArray(i));
                //Step 3: Update the pool to remove the numbers in the current col.
                updatePool(pool, colArray(j));
                //Step 4: Update the pool to remove the numbers in the current sqaure.
                updatePool(pool, sqaureArray(i, j));
                if (pool.isEmpty())
                    return sudokuSqaure = new int[9][9];
                //Step 5: Add a random number into the sudoku sqaure.
                sudokuSqaure[i][j] = pool.get(rand.nextInt(pool.size()));
            }
        }
        return sudokuSqaure;
    }
    
    /**
     * Initializes an Integer arrayList with numbers 1-9.
     * 
     * @param pool ArrayList to be filled with 1-9.
     */
    private void initPool(ArrayList<Integer> pool) {
        for (int i = 1; i <= 9; i++)
            pool.add(i);
    }
    
    /**
     * Removes Integer numbers from an arrayList if it's in the arrayList.
     * 
     * @param pool ArrayList of numbers that remains.
     * @param array The array of numbers to be removed from the pool.
     */
    private void updatePool(ArrayList<Integer> pool, int[] array) {
        for (int element : array)
            pool.remove((Integer)element);
    }
    
    /**
     * Gets the array of a sudoku square.
     * 
     * @param rowIdx The position of the row.
     * @param colIdx The position of the column.
     * @return A 1D array of the numbers in the square.
     */
    private int[] sqaureArray(int rowIdx, int colIdx) {
        int[] sqaure = new int[9];
        int rowStart = (rowIdx / 3) * 3;
        int colStart = (colIdx / 3) * 3;
        int counter = 0;
        for (int i = 0; i < 3; i++) 
            for (int j = 0; j < 3; j++) {
                sqaure[counter] = sudokuSqaure[rowStart + i][colStart + j];
                counter++;
            }

        return sqaure;
    }
    
    /**
     * Gets the row of a sudoku square.
     * 
     * @param index Index of the row that is wanted.
     * @return The row that is desired.
     */
    private int[] rowArray(int index) {
        if (index > sudokuSqaure.length || index < 0) {
            throw new IllegalArgumentException("Index out of bounds of array");
        }

        return Arrays.copyOf(sudokuSqaure[index], sudokuSqaure[index].length);
    }

    /**
     * Gets the column of a sudoku square.
     * 
     * @param index Index of the column that is wanted.
     * @return The column that is desired.
     */
    private int[] colArray(int index) {
        if (index > sudokuSqaure[0].length || index < 0) {
            throw new IllegalArgumentException("Index out of bounds of array");
        }

        int[] col = new int[9];
        for (int i = 0; i < sudokuSqaure.length; i++) {
            col[i] = sudokuSqaure[i][index];
        }
        return col;
    }

    /**
     * Formats a string of the numbers in the sudoku square.
     * 
     * @return A formatted sudoku square.
     */
    @Override
    public String toString() {
        String strOut = "";
        
        for (int[] row : sudokuSqaure) {
            strOut += "\n";
            for (int elements : row)
                strOut += String.format("%-3d", elements);
        }
        
        strOut += "\n\nNumber of iterations: " + solveAttempts;
        return strOut;
    }
}
