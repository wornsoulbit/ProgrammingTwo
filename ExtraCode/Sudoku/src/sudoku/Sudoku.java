package sudoku;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
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
        while (!isComplete()) {
            generateSudokuSqaure(new int[9][9]);
            solveAttempts++;
        }
    }
    
    /**
     * Takes an uncompleted sudoku square and solves it.
     * 
     * @param uncompletedSudoku The unsolved sudoku array thats to be solved.
     */
    public Sudoku(int[][] uncompletedSudoku) {            
        sudokuSqaure = new int[9][9];
        
        if (!isValidGivenSudokuArray(sudokuSqaure))
            throw new IllegalArgumentException("Invalid sudoku square given");
        
        while (!isComplete()) {
            generateSudokuSqaure(uncompletedSudoku);
            solveAttempts++;
        }
    }
    
    /**
     * Generates and fills a 9x9 array with numbers that is a valid sudoku square.
     * @param array The inputed array to generate/solve a sudoku square.
     * 
     * @return A valid sudoku square.
     */
    private int[][] generateSudokuSqaure(int[][] array) {
        Random rand = new Random();
        for (int i = 0; i < array.length; i++)
            sudokuSqaure[i] = Arrays.copyOf(array[i], array[i].length);
        
        for (int i = 0; i < sudokuSqaure.length; i++) {
            for (int j = 0; j < sudokuSqaure[0].length; j++) {
                if (sudokuSqaure[i][j] != 0) 
                    continue;
                ArrayList<Integer> pool = new ArrayList<>(9);
                //Step 1: Initalize the pool with numbers 1-9.
                initPool(pool);
                //Step 2: Update the pool to remove the numbers in the current row.
                updatePool(pool, getRowArray(i));
                //Step 3: Update the pool to remove the numbers in the current col.
                updatePool(pool, getColArray(j));
                //Step 4: Update the pool to remove the numbers in the current sqaure.
                updatePool(pool, getSquareArray(i, j));
                if (pool.isEmpty())
                    return array;
                //Step 5: Add a random number into the sudoku sqaure if it is zero.
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
    private int[] getSquareArray(int rowIdx, int colIdx) {
        int[] sqaure = new int[9];
        int rowStart = (rowIdx / 3) * 3;
        int colStart = (colIdx / 3) * 3;

        for (int i = 0; i < 3; i++) 
            for (int j = 0; j < 3; j++) {
                sqaure[i * 3 + j] = sudokuSqaure[rowStart + i][colStart + j];
            }

        return sqaure;
    }
    
    /**
     * Gets the row of a sudoku square.
     * 
     * @param index Index of the row that is wanted.
     * @return The row that is desired.
     */
    private int[] getRowArray(int index) {
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
    private int[] getColArray(int index) {
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
     * Checks to see if the given sudoku array is a valid one that can be solved.
     * 
     * @param array Array being check if it can be solved.
     * @return If its a valid array.
     */
    public boolean isValidGivenSudokuArray(int[][] array) {        
        //Checks to see if the length of the array is valid.
        if (array.length != 9)
            return false;
        
        for (int i = 0; i < 9; i++) 
            if (array[i].length != 9)
                return false;
        
        //Checks to see if all the rows in the array have unique numbers.
        for (int i = 0; i < 9; i++) {
            if (!isNumsUnique(convertIntArray(getColArray(i))) 
                    || !isNumsUnique(convertIntArray(getRowArray(i))))
                return false;
        }
        
        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++)
                if (!isNumsUnique(convertIntArray(getSquareArray(i, j))))
                    return false;
        
        return true;
    }
    
    /**
     * Checks to see if the numbers in an Integer array are all unique numbers.
     * 
     * @param nums Array to be checked for uniqueness.
     * @return If all the numbers in the array are unique.
     */
    private boolean isNumsUnique(Integer[] nums) {
        int counter = 0;
        for (Integer num : nums) {
            if (num != 0)
                counter++;
        }
        
        Set<Integer> nums2 = new HashSet(Arrays.asList(nums));
        nums2.remove(0);
        return nums2.size() == counter;
    }
    
    /**
     * Converts an int array into an Integer array.
     * 
     * @param array int array to be converted.
     * @return The converted Integer array.
     */
    private Integer[] convertIntArray(int[] array) {
        Integer[] integerArray = new Integer[9];
        
        for (int i = 0; i < integerArray.length; i++) {
            integerArray[i] = array[i];
        }
        
        return integerArray;
    }
    
    /**
     * Checks to see if the sudoku square is completely filled with none zero numbers.
     */
    private boolean isComplete() {
        for (int[] row : sudokuSqaure)
            for (int elements : row)
                if (elements == 0)
                    return false;
        return true;
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

    /**
     * Gets the completed sudoku square array.
     * 
     * @return The completed sudoku square array.
     */
    public int[][] getSudokuSqaure() {
        int[][] newSudokuArray = new int[9][9];
        System.arraycopy(sudokuSqaure, 0, newSudokuArray, 0, sudokuSqaure.length);
        return newSudokuArray;
    }    
}
