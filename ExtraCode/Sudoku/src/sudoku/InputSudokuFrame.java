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
    
    private JButton buttons[][];

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
        buttons = new JButton[ROW][COL];
    }

    /**
     * Initializes the components of the GUI.
     */
    public void initComponents2() {
        inputSudokuNums.setLayout(new GridLayout(ROW, COL));
        optionsPanel.setLayout(new GridLayout(3, 1));
        bindJButtons();
        
        for (JButton[] row : buttons)
            for (JButton button : row) 
                button.addKeyListener(k1);        
    }

    private void bindJButtons() {
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
    
    /**
     * Copies the inputed values from the buttons into a new array.
     * 
     * @return An array with the copied inputed values.
     */
    private int[][] copyButtonArray() {
        int array[][] = new int[ROW][COL];
        
        for (int i = 0; i < buttons.length; i++) {
            for (int j = 0; j < buttons[0].length; j++) {
                if (!buttons[i][j].getText().equals(""))
                    array[i][j] = Integer.parseInt(buttons[i][j].getText());
            }
        }
        
        return array;
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
        submitButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        inputSudokuNums.setMinimumSize(new java.awt.Dimension(400, 400));
        inputSudokuNums.setPreferredSize(new java.awt.Dimension(400, 400));
        inputSudokuNums.setLayout(new java.awt.GridLayout(1, 0));

        optionsPanel.setLayout(new java.awt.GridLayout(2, 0));

        submitButton.setText("Submit");
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });
        optionsPanel.add(submitButton);

        clearButton.setText("Clear");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });
        optionsPanel.add(clearButton);

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
                .addComponent(optionsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        clearInputArea();
    }//GEN-LAST:event_clearButtonActionPerformed

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed
        if (Sudoku.isValidGivenSudokuArray(copyButtonArray())) {
            dispose();
            new SudokuPanel(new Sudoku(copyButtonArray()));
        } else {
            System.out.println("Invalid Sudoku given");
        }
    }//GEN-LAST:event_submitButtonActionPerformed

//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(InputSudokuFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(InputSudokuFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(InputSudokuFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(InputSudokuFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new InputSudokuFrame().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton clearButton;
    private javax.swing.JPanel inputSudokuNums;
    private javax.swing.JPanel optionsPanel;
    private javax.swing.JButton submitButton;
    // End of variables declaration//GEN-END:variables
}
