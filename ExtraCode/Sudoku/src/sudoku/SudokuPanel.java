
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
import javax.swing.JRadioButton;
import javax.swing.border.LineBorder;

/**
 * Game panel of sudoku game.
 * 
 * @author Alex
 */
public class SudokuPanel extends javax.swing.JFrame {

    private JButton[][] buttonss;
    private int[][] map;
    
    private int distanceX;
    private int distanceY;
    private JButton submitButton;
    private JButton clearButton;
    private JRadioButton enableHighlightingButton;
    private static Sudoku sudoku;
    private final static int ROW = 9;
    private final static int COL = 9;

    /**
     * Creates new form SudokuGamePanel
     *
     * @param sudoku The starting array.
     */
    public SudokuPanel(Sudoku sudoku) {
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
        
        //If there wasn't a given sudoku array it uses the auto generated one.
        if (sudoku.getUncompletedSudoku() == null)
            drawHiddenMap(newSudokuArray);
        //If there was a given sudoku array it uses that and draws the given values.
        else 
            drawMap(sudoku.getUncompletedSudoku());

        setVisible(true);
        System.out.println(sudoku);
    }

    /**
     * Initialize's the values of the game.
     */
    public void initValues() {
        //Init map (the logic map)
        map = new int[ROW][COL];

        //Init button (2d array of JButtons)
        buttonss = new JButton[ROW][COL];
        
        submitButton = new JButton("Submit");
        clearButton = new JButton("Clear");
        enableHighlightingButton = new JRadioButton("Highlighting", false);
    }

    /**
     * Initialize the components to the JFrame.
     */
    public void initComponents2() {
        gamePanel.setLayout(new GridLayout(ROW, COL));
        optionsPanel.setLayout(new GridLayout(3, 1));
        //Binds a JButton to each cell.
        bindJButton();

        for (JButton[] row : buttonss) {
            for (JButton button : row) {
                button.addKeyListener(kl);
                button.addMouseListener(m2);
            }
        }
        
        submitButton.addMouseListener(m1);
        clearButton.addMouseListener(m1);
    }

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
        
        optionsPanel.add(submitButton);
        optionsPanel.add(clearButton);
        optionsPanel.add(enableHighlightingButton);
    }
    
    /**
     * Creates an array thats validated to see if the sudoku square is completed 
     * properly or not.
     */
    private void validateSudoku() {
        int[][] toValidateArray = new int[9][9];
        boolean flag = true;
        
        //Inputs the values from the JButtons into an array to be validated.
        for (int i = 0; i < buttonss.length; i++) {
            for (int j = 0; j < buttonss[0].length; j++) {
                if (Integer.parseInt(buttonss[i][j].getText()) == 0) {
                    flag = false;
                    break;
                }
                toValidateArray[i][j] = Integer.parseInt(buttonss[i][j].getText());
            }
        }
        
        sudoku = new Sudoku();
        
        //Checks to see if the given array is a valid sudoku square aslong as there wasn't 
        //any zeros in the array to be validated.
        if (sudoku.isValidGivenSudokuArray(toValidateArray) && flag) {
            System.out.println("Win");
            setEnabled(false);
            new RestartGameFrame(SudokuPanel.this);
        } else {
            System.out.println("Invalid");
        }
    }
    
    /**
     * Resets the map to the initially what was shown.
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
                if (array[i][j] != 0) {
                    buttonss[i][j].setBackground(Color.WHITE);
                    buttonss[i][j].setText(String.valueOf(array[i][j]));
                    map[i][j] = array[i][j];
                } else {
                    buttonss[i][j].setBackground(Color.GRAY);
                    buttonss[i][j].setText("0");
                    map[i][j] = 0;
                }
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
                    map[i][j] = array[i][j];
                } else {
                    buttonss[i][j].setText("0");
                    buttonss[i][j].setBackground(Color.GRAY);
                    map[i][j] = 0;
                }
            }
        }
    }

    /**
     * Mouse listener for extra buttons that's below the game-play area.
     */
    MouseListener m1 = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {
            
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        /**
         * Logic for the submit and clear buttons.
         * 
         * @param e Mouse event.
         */
        @Override
        public void mouseReleased(MouseEvent e) {            
            //Button for submitting and checking if the square is completed and valid.
            if (e.getComponent().getY() == 0)
                validateSudoku();
            
            //Clears all inputed values and replaces them with the original values.
            if (e.getComponent().getY() == 26)
                drawMap(map);
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            
        }

        @Override
        public void mouseExited(MouseEvent e) {
            
        }
    };
    
    /**
     * Highlights and un-highlights clicked on values.
     */
    MouseListener m2 = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {
            
        }

        /**
         * Highlights the values pressed on.
         * 
         * @param e Mouse event.
         */
        @Override
        public void mousePressed(MouseEvent e) {
            //Only excutes the code if Highlighting button is selected.
            if (enableHighlightingButton.isSelected()) {
                //Gets the location of the component in the button array.
                int xComponent = e.getComponent().getX();
                int yComponent = e.getComponent().getY();
                distanceY = e.getComponent().getHeight(); //The distance in pixels between the components on the x-axis.
                distanceX = e.getComponent().getWidth(); //The distance in pixels between the components on the y-axis.

                //Checks to see if the mouse event was caused by a left click and 
                //makes sure that the clicked JButton text doesn't equal to zero. 
                if (e.getButton() == MouseEvent.BUTTON1 && 
                        !buttonss[yComponent / distanceY][xComponent / distanceX].getText().equals("0"))
                    Highlighting.highLightSameValues(buttonss[yComponent / distanceY][xComponent / distanceX].getText(), buttonss);
                //Highlights the rows, columns and the selected square to what was clicked.
                Highlighting.highLightEverything(yComponent / distanceY, xComponent / distanceX, buttonss);
            }
            
        }

        /**
         * Un-highlights the values previously pressed.
         * 
         * @param e Mouse event.
         */
        @Override
        public void mouseReleased(MouseEvent e) {
            //Unhighlights everything previously highlighted.
            if (e.getButton() == MouseEvent.BUTTON1)
                Highlighting.unHighLight(buttonss, map);
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            
        }

        @Override
        public void mouseExited(MouseEvent e) {
            
        }
    };
    
    /**
     * Input for numbers to be inputed into the selected square as long as the square
     * doesn't have an original value from the start.
     */
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
                    if (buttonss[yComponent / distanceY][xComponent / distanceX].getBackground() != Color.WHITE) {
                        buttonss[yComponent / distanceY][xComponent / distanceX].setText("" + key);
                        buttonss[yComponent / distanceY][xComponent / distanceX].setBackground(Color.CYAN);
                    }
                    
                    break;
            }
        }
    };
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gamePanel = new javax.swing.JPanel();
        optionsPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        gamePanel.setFocusable(false);
        gamePanel.setMinimumSize(new java.awt.Dimension(400, 400));
        gamePanel.setLayout(new java.awt.GridLayout(1, 0));

        javax.swing.GroupLayout optionsPanelLayout = new javax.swing.GroupLayout(optionsPanel);
        optionsPanel.setLayout(optionsPanelLayout);
        optionsPanelLayout.setHorizontalGroup(
            optionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        optionsPanelLayout.setVerticalGroup(
            optionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(gamePanel, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
            .addComponent(optionsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(gamePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(optionsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
            java.util.logging.Logger.getLogger(SudokuPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SudokuPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SudokuPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SudokuPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SudokuPanel(sudoku).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel gamePanel;
    private javax.swing.JPanel optionsPanel;
    // End of variables declaration//GEN-END:variables
}
