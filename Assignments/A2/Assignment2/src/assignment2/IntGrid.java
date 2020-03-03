package assignment2;

import java.util.Arrays;

/**
 * Creates a set of 'smart' operations for arrays.
 *
 * @author Alex Vasil
 */
public class IntGrid {

    public int[][] grid;

    public IntGrid(int[][] initialArray) {
        setGrid(initialArray);
    }

    public IntGrid(int size) {
        setGrid(size);
    }

    public IntGrid(int rows, int cols) {
        setGrid(rows, cols);
    }

    public IntGrid(IntGrid ig) {
        grid = new int[ig.grid.length][ig.grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            grid[i] = Arrays.copyOf(ig.grid[i], ig.grid[i].length);
        }
    }

    /**
     * Takes an array, gets the longest row and sets the length of all other
     * rows to the longest, filling blank values with 0s.
     *
     * @param initialArray Array being checked.
     */
    public void setGrid(int[][] initialArray) {
        int arrLength = 0;

        //Gets the longest length of the array.
        for (int[] initArr : initialArray) {
            if (initArr.length > arrLength) {
                arrLength = initArr.length;
            }
        }

        //Sets the longest length of the array.
        grid = new int[initialArray.length][arrLength];
        
        for (int i = 0; i < grid.length; i++) 
            grid[i] = Arrays.copyOf(initialArray[i], arrLength);
    }

    public void setGrid(int size) {
        if (size < 0) {
            throw new IllegalArgumentException("Size of the array can't be less than 0!");
        }

        grid = new int[size][size];
    }

    public void setGrid(int rows, int cols) {
        if (rows < 0 || cols < 0) {
            throw new IllegalArgumentException("rows or cols can't be less than 0!");
        }
        grid = new int[rows][cols];
    }

    /**
     * Sets the value of an array at row r and column c to the specified value.
     *
     * @param r Row r.
     * @param c Col c.
     * @param value Value to be set.
     */
    public void setElement(int r, int c, int value) {
        if (r < 0 || r > grid.length) {
            throw new IllegalArgumentException("r out of bounds of array.");
        }
        if (c < 0 || c > grid[r].length) {
            throw new IllegalArgumentException("c out of bounds of array.");
        }

        grid[r][c] = value;
    }

    /**
     * Gets the value of an int at row r, col c.
     *
     * @param r Row r.
     * @param c Col c.
     * @return Value at Row r, Col c.
     */
    public int getElement(int r, int c) {
        if (r < 0 || r > grid.length) {
            throw new IllegalArgumentException("r out of bounds of array.");
        }
        if (c < 0 || c > grid[r].length) {
            throw new IllegalArgumentException("c out of bounds of array.");
        }

        return grid[r][c];
    }

    public int[] getRow(int k) {
        if (k < 0 || k > grid.length) {
            throw new IllegalArgumentException("k out of bounds of array.");
        }

        return Arrays.copyOf(grid[k], grid[k].length);
    }

    public void setRow(int k, int[] array) {
        if (k < 0 || k > grid.length) {
            throw new IllegalArgumentException("k out of bounds of array.");
        }
        grid[k] = Arrays.copyOf(array, array.length);
    }

    /**
     * Gets the number of rows in the array.
     *
     * @return The number of rows.
     */
    public int numRows() {
        return grid.length;
    }

    /**
     * Gets the number of columns in the array.
     *
     * @return The number of columns.
     */
    public int numColumns() {
        return grid[0].length;
    }

    /**
     * Checks to see if the array is a square.
     *
     * @return If its a square.
     */
    public boolean isSquare() {
        return numRows() == numColumns();
    }

    /**
     * Checks to see if the array is tall.
     *
     * @return If its tall.
     */
    public boolean isTall() {
        return numRows() > numColumns();
    }

    /**
     * Checks to see if the array is wide.
     *
     * @return If its wide.
     */
    public boolean isWide() {
        return numRows() < numColumns();
    }

    /**
     * Returns the max value in the array.
     *
     * @return The max value.
     */
    public int max() {
        int maxNum = grid[0][0];

        for (int[] row : grid) {
            for (int col : row) {
                maxNum = Math.max(maxNum, col);
            }
        }

        return maxNum;
    }

    /**
     * Returns the min value in the array.
     *
     * @return The min value.
     */
    public int min() {
        int minNum = grid[0][0];

        for (int[] row : grid) {
            for (int col : row) {
                minNum = Math.min(minNum, col);
            }
        }

        return minNum;
    }

    /**
     * Gets the sum of all elements in a row of the array.
     *
     * @param row Row to be summed up.
     * @return The sum of the row.
     */
    public int rowSum(int row) {
        if (row < 0 || row > grid.length) {
            throw new IllegalArgumentException("Row is out of bounds of grid.");
        }
        int rowSum = 0;

        for (int col : grid[row]) {
            rowSum += col;
        }

        return rowSum;
    }

    /**
     * Gets the sum of all elements in a column of the array.
     *
     * @param column Column to be summed up.
     * @return The sum of the column.
     */
    public int columnSum(int column) {
        if (column < 0 || column > grid[0].length) {
            throw new IllegalArgumentException("Column is out of bounds of grid.");
        }
        int colSum = 0;

        for (int[] row : grid) {
            colSum += row[column];
        }

        return colSum;
    }

    /**
     * Gets the sum of all elements on the major diagonal.
     *
     * @return The sum of all elements on the major diagonal.
     */
    public int majorDiagonalSums() {
        int sum = 0;

        for (int i = 0; i < Math.min(grid.length, grid[0].length); i++) {
            sum += grid[i][i];
        }

        if (grid.length < grid[0].length)
            for (int[] row : grid)
                sum += row[grid[0].length - grid.length];
        else if (grid.length > grid[0].length) 
            for (int i = 0; i < grid[0].length; i++) 
                sum += grid[grid.length - grid[0].length][i];

        return sum;
    }

    /**
     * Gets the sum of all elements on the minor diagonal.
     *
     * @return The sum of all elements on the minor diagonal.
     */
    public int minorDiagonalSums() {
        int sum = 0;

        for (int i = 0; i < Math.min(grid.length, grid[0].length); i++) {
            sum += grid[i][grid.length - 1 - i];
        }

        if (grid.length < grid[0].length)
            for (int[] row : grid)
                sum += row[grid[0].length - grid.length];
        else if (grid.length > grid[0].length) 
            for (int i = 0; i < grid[0].length; i++) 
                sum += grid[grid.length - grid[0].length][i];

        return sum;
    }

    /**
     * Returns the sums of all the rows in an array.
     *
     * @return Array of sums of all elements.
     */
    public int[] allRowSums() {
        int[] rowSums = new int[grid.length];

        for (int i = 0; i < grid.length; i++) {
            rowSums[i] = rowSum(i);
        }

        return rowSums;
    }

    /**
     * Returns the sums of all the columns in an array.
     *
     * @return Array of sums of all elements.
     */
    public int[] allColumnSums() {
        int[] rowSums = new int[grid[0].length];

        for (int i = 0; i < grid[0].length; i++) {
            rowSums[i] = columnSum(i);
        }

        return rowSums;
    }

    /**
     * Swaps rows r1 and r2 with each other.
     *
     * @param r1 Row 1.
     * @param r2 Row 2.
     */
    public void swapRows(int r1, int r2) {
        if (r1 < 0 || r1 > grid.length || r2 < 0 || r2 > grid.length) {
            throw new IllegalArgumentException("Row is out of bounds of grid.");
        }

        int[] temp = Arrays.copyOf(grid[r1], grid[r1].length);
        grid[r1] = grid[r2];
        grid[r2] = temp;
    }

    /**
     * Swaps column c1 and c2 with each other.
     *
     * @param c1 Column 1.
     * @param c2 Column 2.
     */
    public void swapColumns(int c1, int c2) {
        if (c1 < 0 || c1 > grid.length || c2 < 0 || c2 > grid.length)
            throw new IllegalArgumentException("Columns is out of bounds of grid.");

        int[] temp = new int[grid.length];

        for (int i = 0; i < temp.length; i++)
            temp[i] = grid[i][c1];

        for (int i = 0; i < temp.length; i++)
            grid[i][c1] = grid[i][c2];

        for (int i = 0; i < temp.length; i++)
            grid[i][c2] = temp[i];
    }

    /**
     * Checks to see if the key is in the array.
     *
     * @param key Number to lookup.
     * @return If the number is in the array.
     */
    public boolean lookup(int key) {
        return false;
    }

    public boolean isMagicSquare() {
        int sum = rowSum(0);

        for (int i = 0; i < grid.length; i++)
            if (rowSum(i) != sum)
                return false;

        for (int i = 0; i < grid[0].length; i++)
            if (columnSum(i) != sum)
                return false;
        
        int diagSum = 0;
        for (int i = 0; i < grid.length; i++)
            diagSum += grid[i][i];

        if (diagSum != sum)
            return false;

        diagSum = 0;
        for (int i = 0; i < grid.length; i++)
            diagSum += grid[i][grid[0].length - 1 - i];

        return diagSum == sum;
    }

    public void printGridFeatures() {

    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final IntGrid other = (IntGrid) obj;
        if (!Arrays.deepEquals(this.grid, other.grid)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        String strOut = "Test";
        return strOut;
    }
}
