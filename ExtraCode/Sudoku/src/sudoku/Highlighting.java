
package sudoku;

import java.awt.Color;
import javax.swing.JButton;

/**
 * Highlights rows, columns, and the square for the selected button.
 * 
 * @author Alex Vasil
 */
public class Highlighting {
    
    //Color that highlights all buttons in the selected square, row, and column.
    private static final Color HIGHLIGHT_COLOR = Color.GREEN; 
    //Color that highlights the selected value.
    private static final Color HIGHLIGHT_SAME_VALUE_COLOR = Color.MAGENTA;
    //Color for none-zero numbers that wasn't inputed by the user.
    private static final Color UNHIGHLIGHT_INIT_VALUES_COLOR = Color.WHITE;
    //Color for zero numbers.
    private static final Color UNHIGHLIGHT_BACKGROUND_COLOR = Color.GRAY;
    //Color for user-inputed numbers.
    private static final Color UNHIGHLIGHT_INPUTED_COLOR = Color.CYAN;
    
    /**
     * Highlights the rows, columns, squares.
     * 
     * @param row The rows to be highlighted.
     * @param col The columns to be highlighted.
     * @param jButtons The array of buttons to be highlighted.
     */
    public static void highLightEverything(int row, int col, JButton[][] jButtons) {
        highLightSameSquare(row, col, jButtons);
        highLightSameCol(col, jButtons);
        highLightSameRow(row, jButtons);
    }
    
    /**
     * Highlights all the buttons in the selected square.
     * 
     * @param rowIdx Row index.
     * @param colIdx Column index.
     * @param jButtons The array of buttons to be highlighted.
     */
    public static void highLightSameSquare(int rowIdx, int colIdx, JButton[][] jButtons) {
        int rowStart = (rowIdx / 3) * 3;
        int colStart = (colIdx / 3) * 3;
        
        for (int i = 0; i < 3; i++) 
            for (int j = 0; j < 3; j++)
                jButtons[rowStart + i][colStart + j].setBackground(HIGHLIGHT_COLOR);
    }
    
    /**
     * Highlights all the buttons in the selected row.
     * 
     * @param row The selected row.
     * @param jButtons The array of buttons to be highlighted.
     */
    public static void highLightSameRow(int row, JButton[][] jButtons) {
        for (int i = 0; i < 9; i++) {
            jButtons[row][i].setBackground(HIGHLIGHT_COLOR);
        }
    }
    
    /**
     * Highlights all the buttons in the selected column.
     * 
     * @param col The selected column.
     * @param jButtons The array of buttons to be highlighted.
     */
    public static void highLightSameCol(int col, JButton[][] jButtons) {
        for (int i = 0; i < 9; i++) {
            jButtons[i][col].setBackground(HIGHLIGHT_COLOR);
        }
    }
    
    /**
     * Un-highlights all values from 1-9.
     * 
     * @param jButtons The array of buttons to be highlighted.
     * @param map The original map of numbers.
     */
    public static void unHighLight(JButton[][] jButtons, int[][] map) {
        for (int i = 1; i <= 9; i++)
            unHighLightSameValues(i + "", jButtons, map);
    }    
    
    /**
     * Highlights all of the given values.
     * 
     * @param value The value to be highlight.
     * @param jButtons The array of buttons to be highlighted.
     */
    public static void highLightSameValues(String value, JButton[][] jButtons) {
        for (JButton[] row : jButtons)
            for (JButton button : row)
                if (button.getText().equals(value))
                    button.setBackground(HIGHLIGHT_SAME_VALUE_COLOR);
    }
    
    /**
     * Un-highlights all of the given values.
     * 
     * @param value The value to be un-highlight.
     * @param jButtons The array of buttons to be highlighted.
     * @param map The original map of numbers.
     */
    public static void unHighLightSameValues(String value, JButton[][] jButtons, int[][] map) {
        for (int i = 0; i < jButtons.length; i++) 
            for (int j = 0; j < jButtons[0].length; j++)
                //Checks to see if the button clicked isn't in the map array.
                if (!isInMapArray(i, j, map) && jButtons[i][j].getText().equals(value))
                    jButtons[i][j].setBackground(UNHIGHLIGHT_INIT_VALUES_COLOR);
                //Checks to see if the button clicked is in the map array.
                else if (isInMapArray(i, j, map) && jButtons[i][j].getText().equals(value))
                    jButtons[i][j].setBackground(UNHIGHLIGHT_INPUTED_COLOR);
                else if (jButtons[i][j].getText().equals("0"))
                    jButtons[i][j].setBackground(UNHIGHLIGHT_BACKGROUND_COLOR);
    }
    
    /**
     * Checks to see if a given point is in the original map array.
     * 
     * @param x The x point in the array.
     * @param y The y point in the array.
     * @param map The original map of numbers.
     * @return If its in the map array.
     */
    private static boolean isInMapArray(int x, int y, int[][] map) {
        return map[x][y] == 0;
    }
}
