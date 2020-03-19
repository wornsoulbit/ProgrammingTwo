
package sudoku;

import java.awt.Color;
import javax.swing.JButton;

/**
 * Highlights rows, columns, and the square for the selected button.
 * 
 * @author Alex Vasil
 */
public class Highlighting {
    private static JButton[][] buttonss;
    private static int[][] map;
    
    public static void highLightSameSquare(int rowIdx, int colIdx) {
        int rowStart = (rowIdx / 3) * 3;
        int colStart = (colIdx / 3) * 3;
        
        for (int i = 0; i < 3; i++) 
            for (int j = 0; j < 3; j++)
                buttonss[rowStart + i][colStart + j].setBackground(Color.GREEN);
    }
    
    public static void highLightSameRow(int row) {
        for (int i = 0; i < 9; i++) {
            buttonss[row][i].setBackground(Color.GREEN);
        }
    }
    
    public static void highLightSameCol(int col) {
        for (int i = 0; i < 9; i++) {
            buttonss[i][col].setBackground(Color.GREEN);
        }
    }
    
    /**
     * Un-highlights all values from 1-9.
     */
    public static void unHighLight() {
        for (int i = 1; i <= 9; i++)
            unHighLightSameValues(i + "");
    }    
    
    /**
     * Highlights all of the given values.
     * 
     * @param value The value to be highlight.
     */
    public static void highLightSameValues(String value) {
        for (JButton[] row : buttonss)
            for (JButton button : row)
                if (button.getText().equals(value))
                    button.setBackground(Color.MAGENTA);
    }
    
    /**
     * Un-highlights all of the given values.
     * 
     * @param value The value to be un-highlight.
     */
    public static void unHighLightSameValues(String value) {
        for (int i = 0; i < buttonss.length; i++) 
            for (int j = 0; j < buttonss[0].length; j++)
                //Checks to see if the button clicked isn't in the map array.
                if (!isInMapArray(i, j) && buttonss[i][j].getText().equals(value))
                    buttonss[i][j].setBackground(Color.WHITE);
                //Checks to see if the button clicked is in the map array.
                else if (isInMapArray(i, j) && buttonss[i][j].getText().equals(value))
                    buttonss[i][j].setBackground(Color.CYAN);
                else if (buttonss[i][j].getText().equals("0"))
                    buttonss[i][j].setBackground(Color.GRAY);
    }
    
    /**
     * Checks to see if a given point is in the original map array.
     * 
     * @param x The x point in the array.
     * @param y The y point in the array.
     * @return If its in the map array.
     */
    private static boolean isInMapArray(int x, int y) {
        return map[x][y] == 0;
    }
}
