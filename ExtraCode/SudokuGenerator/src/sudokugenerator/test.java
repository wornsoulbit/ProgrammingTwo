/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudokugenerator;

/**
 *
 * @author cstuser
 */
public class test {
    public static void main(String[] args) {
        SudokuGenerator s1 = new SudokuGenerator();
        
        s1.generateSudokuSquare();
        System.out.println(s1);
    }
}
