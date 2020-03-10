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

    public Sudoku() {
        sudokuSqaure = new int[9][9];
        while (sudokuSqaure[0][0] == 0) {
            generateSudokuSqaure();
        }
    }
    
    public void generateSudokuSqaure() {
        
        Random rand = new Random();
        
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                ArrayList<Integer> pool = new ArrayList<>(9);
                //Step 1: Initalize the pool with numbers 1-9.
                initPool(pool);
                //Step 2: Update the pool to remove the numbers in the current row.
                updatePool(pool, rowArray(i));
                //Step 3: Update the pool to remove the numbers in the current col.
                updatePool(pool, colArray(i));
                //Step 4: Update the pool to remove the numbers in the current sqaure.
                updatePool(pool, sqaureArray(i, j));
                //Step 5: Add a random number into the sudoku sqaure.
                sudokuSqaure[i][j] = pool.get(rand.nextInt(pool.size()));
            }
        }
    }
    
    private ArrayList<Integer> initPool(ArrayList<Integer> pool) {
        for (int i = 1; i <= 9; i++)
            pool.add(i);
        return pool;
    }
    
    private void updatePool(ArrayList<Integer> pool, int[] array) {
        for (int element : array)
            pool.remove((Integer)element);
    }
    
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
    
    private int[] rowArray(int index) {
        if (index > sudokuSqaure.length || index < 0) {
            throw new IllegalArgumentException("Index out of bounds of array");
        }

        return Arrays.copyOf(sudokuSqaure[index], sudokuSqaure[index].length);
    }

    private int[] colArray(int index) {
        if (index > sudokuSqaure[0].length || index < 0) {
            throw new IllegalArgumentException("Index out of bounds of array");
        }

        int[] col = new int[9];
        for (int i = 0; i < sudokuSqaure.length; i++) {
            col[i] = sudokuSqaure[index][i];
        }
        return col;
    }    
}
