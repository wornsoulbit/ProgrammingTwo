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
    private int validationStep = 0;
    /**
     * Generates a random sudoku square
     */
    private void generateSudokuSquare() {
        Random rand = new Random();
        do {
            sudokuSqaure = new int[9][9];
            for (int[] row : sudokuSqaure) {
                int[] pool = new int[9];
                pool = populateSudokuNumberArray(pool);
                
                if (!isValidSudokuSqaure())
                    break;
                else 
                    validationStep++;
                
                for (int j = 0; j < row.length; j++) {
                    int randomNum = rand.nextInt(pool.length);
                    row[j] = pool[randomNum];
                    pool = removeElement(pool, randomNum);
                }
            }
        } while(!isValidSudokuSqaure());
    }

    private boolean isValidSudokuSqaure() {        
        int[] rowArr1 = rowArray(validationStep);
        int[] rowArr2 = rowArray(validationStep + 1);
            
        for (int i = 0; i < rowArr1.length; i++) {
            if (rowArr1[i] == 0 || rowArr2[i] == 0) {
                validationStep--;
                break;
            }
            
            if (rowArr1[i] == rowArr2[i])
                return false;
        }
        
        return true;
    }
    
    private int[][] squareArray(int rowIndex, int colIndex) {
        int[][] squareArr = new int[3][3];
        int rowStartIndex;
        int colStartIndex;
        switch (rowIndex) {
            case 0:
            case 1:
            case 2:
                rowStartIndex = 0;
                break;
            case 3:
            case 4:
            case 5:
                rowStartIndex = 3;
                break;
            default:
                rowStartIndex = 6;
                break;
        }
        
        switch (colIndex) {
            case 0:
            case 1:
            case 2:
                colStartIndex = 0;
                break;
            case 3:
            case 4:
            case 5:
                colStartIndex = 3;
                break;
            default:
                colStartIndex = 6;
                break;
        }
        
        for (int i = 0; i < squareArr.length; i++) {
            for (int j = 0; j < squareArr[0].length; j++) {
                squareArr[i][j] = sudokuSqaure[i + rowStartIndex][j + colStartIndex];
            }
        }
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
