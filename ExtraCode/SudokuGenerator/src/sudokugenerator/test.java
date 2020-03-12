
package sudokugenerator;

/**
 * Test file for sudoku class
 * @author Alex Vasil
 */
public class test {
    public static void main(String[] args) {
        SudokuGenerator s1 = new SudokuGenerator();
        
        int[][] test = 
           {{1,0,0,0,0,0,0,0,0}, {0,2,0,0,0,0,0,0,0}, {0,0,3,0,0,0,0,0,0}, 
            {0,0,0,0,0,0,0,0,0}, {0,0,0,0,0,0,0,0,0}, {0,0,0,0,0,0,0,0,0}, 
            {0,0,0,0,0,0,0,0,0}, {0,0,0,0,0,0,0,0,0}, {0,0,0,0,0,0,0,0,0}};
        SudokuGenerator s2 = new SudokuGenerator();
        
        
        s1.generateSudokuSquare();
        System.out.println(s1);
        
    }
}
