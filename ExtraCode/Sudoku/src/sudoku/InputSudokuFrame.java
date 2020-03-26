/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

/**
 * A class for inputting a sudoku square.
 *
 * @author Alex Vasil
 */
public class InputSudokuFrame extends javax.swing.JFrame {

    private final int ROW = 9;
    private final int COL = 9;

    private int sudokuArray[][];
    private JButton buttons[][];
    private JButton submitButton;
    private JButton clearButton;

    /**
     * Creates new form InputSudokuFrame
     */
    public InputSudokuFrame() {
        initComponents();
        initValues();
        initComponents2();
        
        setTitle("Input Sudoku");
        setVisible(true);
    }

    /**
     * Initializes the data members with default values.
     */
    public void initValues() {
        sudokuArray = new int[ROW][COL];
        buttons = new JButton[ROW][COL];
        submitButton = new JButton("Submit");
        submitButton.setName("submitButton");
        clearButton = new JButton("Clear");
        clearButton.setName("clearButton");
    }

    public void initComponents2() {
        inputSudokuNums.setLayout(new GridLayout(ROW, COL));
        optionsPanel.setLayout(new GridLayout(3, 1));
        bindJButtons();
        
        for (JButton[] row : buttons)
            for (JButton button : row) 
                button.addKeyListener(k1);
        
        optionsPanel.add(submitButton);
        optionsPanel.add(clearButton);
        submitButton.addMouseListener(m1);
        clearButton.addMouseListener(m1);
    }

    public void bindJButtons() {
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                buttons[ROW - 1 - i][j] = new JButton();
                buttons[ROW - 1 - i][j].setBorder(new LineBorder(Color.BLACK));
                inputSudokuNums.add(buttons[ROW - 1 - i][j], ROW - 1 - i, j);
            }
        }
    }
    
    /**
     * KeyListener for inputed numbers 1-9.
     */
    KeyListener k1 = new KeyListener() {

        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {

        }

        @Override
        public void keyReleased(KeyEvent e) {
            char key = e.getKeyChar();
            int distanceY = e.getComponent().getHeight(); //The distance in pixels between the components on the x-axis.
            int distanceX = e.getComponent().getWidth(); //The distance in pixels between the components on the y-axis.

            switch (key) {
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                    //Gets the location of the component in the button array.
                    int xComponent = e.getComponent().getX();
                    int yComponent = e.getComponent().getY();

                    //Sets the value of the button to the value of key, if key is 1-9
                    //and sets the background of the set button to the color of cyan.
                    buttons[yComponent / distanceY][xComponent / distanceX].setText("" + key);
            }
        }
    };

    MouseListener m1 = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {
            
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            if (e.getComponent().getName().equals("submitButton")) {
                //Continues onto the game if its a valid given sudoku square.
                if (isSudokuValid()) { 
                    dispose();
                    new SudokuPanel(new Sudoku(sudokuArray));
                //Asks the user to input a different sudoku.
                } else {
                    System.out.println("Invalid Sudoku given re-enter a new sudoku");
                }
            }
            
            if (e.getComponent().getName().equals("clearButton")) {
                clearInputArea();
            }
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
        
    };
    
    /**
     * Resets the input area to what it originally was.
     */
    private void clearInputArea() {
        for (JButton[] row : buttons) {
            for (int j = 0; j < buttons[0].length; j++) {
                row[j].setText("");
            }
        }
    }
    
    private boolean isSudokuValid() {
        Sudoku s1 = new Sudoku();
        
        //Parses the JButtons text to be stored in the sudokuArray.
        for (int i = 0; i < buttons.length; i++)  {
            for (int j = 0; j < buttons[0].length; j++) {
                if (buttons[i][j].getText().equals("")) {
                    sudokuArray[i][j] = 0;
                } else { 
                    sudokuArray[i][j] = Integer.parseInt(buttons[i][j].getText());
                }
            }
        }
        return s1.isValidGivenSudokuArray(sudokuArray);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        inputSudokuNums = new javax.swing.JPanel();
        optionsPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        inputSudokuNums.setMinimumSize(new java.awt.Dimension(400, 400));
        inputSudokuNums.setPreferredSize(new java.awt.Dimension(400, 400));
        inputSudokuNums.setLayout(new java.awt.GridLayout());

        optionsPanel.setLayout(new java.awt.GridLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(inputSudokuNums, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(optionsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(inputSudokuNums, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(optionsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InputSudokuFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InputSudokuFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InputSudokuFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InputSudokuFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InputSudokuFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel inputSudokuNums;
    private javax.swing.JPanel optionsPanel;
    // End of variables declaration//GEN-END:variables
}
