/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Arrays;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

/**
 *
 * @author Alex
 */
public class SudokuGamePanel extends javax.swing.JFrame {

    private JButton[][] buttonss;
    private int[][] map;
    private int distanceX;
    private int distanceY;
    
    private static Sudoku sudoku;
    private final static int ROW = 9;
    private final static int COL = 9;

    /**
     * Creates new form SudokuGamePanel
     *
     * @param sudoku The starting array.
     */
    public SudokuGamePanel(Sudoku sudoku) {
        setLocation((Toolkit.getDefaultToolkit().getScreenSize().width - getWidth()) / 2,
                (Toolkit.getDefaultToolkit().getScreenSize().height - getHeight()) / 2);
        System.out.println(getHeight());
        
        int[][] newSudokuArray = new int[9][9];
        System.arraycopy(sudoku.getSudokuSqaure(), 0, newSudokuArray, 0, sudoku.getSudokuSqaure().length);

        setTitle("Sudoku");
        initComponents();
        initValues();
        initComponents2();

        updateMap();
        drawHiddenMap(newSudokuArray);

        setVisible(true);
        System.out.println(sudoku);
    }

    public void initValues() {
        //Init map (the logic map)
        map = new int[ROW][COL];

        //Init button (2d array of JButtons)
        buttonss = new JButton[ROW][COL];
    }

    /**
     * Initialize the components to the JFrame.
     */
    public void initComponents2() {
        gamePanel.setLayout(new GridLayout(ROW, COL));

        //Binds a JButton to each cell.
        bindJButton();

        for (JButton[] row : buttonss) {
            for (JButton button : row) {
                button.addKeyListener(kl);
//                button.addMouseListener(m1);
            }
        }
    }
    
    MouseListener m1 = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {
            
        }

        @Override
        public void mousePressed(MouseEvent e) {
            distanceY = e.getComponent().getHeight(); //The distance in pixels between the components on the x-axis.
            distanceX = e.getComponent().getWidth(); //The distance in pixels between the components on the y-axis.
            int xComponent = e.getComponent().getX();
            int yComponent = e.getComponent().getY();
//            if (buttonss[yComponent / distanceX][xComponent / distanceY].getBackground() != Color.GRAY)
                
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            
        }

        @Override
        public void mouseExited(MouseEvent e) {
            
        }
    };
    
    KeyListener kl = new KeyListener() {
        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {

        }

        @Override
        public void keyReleased(KeyEvent e) {
            char key = e.getKeyChar();
            distanceY = e.getComponent().getHeight(); //The distance in pixels between the components on the x-axis.
            distanceX = e.getComponent().getWidth(); //The distance in pixels between the components on the y-axis.

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
                    if (buttonss[yComponent / distanceX][xComponent / distanceY].getBackground() != Color.WHITE) {
                        buttonss[yComponent / distanceX][xComponent / distanceY].setText("" + key);
                        buttonss[yComponent / distanceX][xComponent / distanceY].setBackground(Color.CYAN);
                    }
                    
                    break;
            }
        }
    };

    /**
     * Binds each button to each cell on the map.
     */
    public void bindJButton() {
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                buttonss[ROW - 1 - i][j] = new JButton();
                buttonss[ROW - 1 - i][j].setBorder(new LineBorder(Color.BLACK));
                gamePanel.add(buttonss[ROW - 1 - i][j], ROW - 1 - i, j);
            }
        }
    }

    /**
     * Clears the map for a new run.
     */
    public void updateMap() {
        //Clear the map
        for (int[] nums : map) {
            Arrays.fill(nums, 0);
        }
    }

    /**
     * Draws all the values of the given array.
     * 
     * @param array The array to draw.
     */
    public void drawMap(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                buttonss[i][j].setText(String.valueOf(array[i][j]));
            }
        }
    }

    /**
     * Draws random values from the array.
     * 
     * @param array The array to draw.
     */
    public void drawHiddenMap(int[][] array) {
        Random rand = new Random();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                //Randomly chooses what rows to display and sets them to a different color.
                if (rand.nextInt(3) == 0) {
                    buttonss[i][j].setText(String.valueOf(array[i][j]));
                    buttonss[i][j].setBackground(Color.WHITE);
                } else {
                    buttonss[i][j].setText("0");
                    buttonss[i][j].setBackground(Color.GRAY);
                }
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gamePanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        gamePanel.setFocusable(false);
        gamePanel.setMinimumSize(new java.awt.Dimension(400, 400));
        gamePanel.setLayout(new java.awt.GridLayout(1, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(gamePanel, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(gamePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            java.util.logging.Logger.getLogger(SudokuGamePanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SudokuGamePanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SudokuGamePanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SudokuGamePanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SudokuGamePanel(sudoku).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel gamePanel;
    // End of variables declaration//GEN-END:variables
}
