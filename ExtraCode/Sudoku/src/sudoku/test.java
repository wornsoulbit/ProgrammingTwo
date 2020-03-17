
package sudoku;

/**
 *
 * @author Alex Vasil
 */
public class test {
    public static void main(String[] args) {
//        Sudoku s1 = new Sudoku();
//        System.out.println(s1);
       
        int[][] randomSqaure = 
           {{0, 0, 3, 0, 7, 0, 0, 0, 5}, {0, 0, 0, 1, 6, 2, 0, 0, 4}, {4, 7, 6, 0, 3, 0, 0, 1, 9},
            {7, 4, 0, 0, 1, 0, 0, 0, 0}, {3, 6, 0, 0, 5, 0, 0, 0, 7}, {5, 0, 1, 6, 8, 7, 0, 0, 2},
            {0, 8, 0, 0, 4, 5, 9, 2, 6}, {0, 3, 0, 0, 0, 0, 8, 5, 0}, {0, 0, 0, 0, 0, 0, 4, 7, 3}};
        
//        Sudoku s2 = new Sudoku(randomSqaure);
//        System.out.println(s2);

        sudokuPanel gamePanel = new sudokuPanel(new Sudoku());

    }
}
