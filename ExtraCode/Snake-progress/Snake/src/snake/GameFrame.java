/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snake;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.Timer;
import javax.swing.border.LineBorder;

/**
 *
 * @author wangy
 */
public class GameFrame extends javax.swing.JFrame {
    
    private ArrayList<int []> snake;
    private int [] fruit;
    private JLabel [][] cellss;
    private int [][] map;
    private char preDirection;
    private char direction;
    private int delay;
    private int fruitCounter;
    private int level;
    private int [] nextPosition;
    private Timer timer;
    
    private final static int ROW = 10;
    private final static int COL = 10;
    private final static int LEVEL_UP_REQUIREMENT = 3;
    private final static int MAX_LEVEL = 9;
    private final static ImageIcon BLACK_IMG = new ImageIcon("img\\blackImg.png");
    private final static ImageIcon FRUIT_IMG = new ImageIcon("img\\fruitImg.png");
    private final static ImageIcon NORMAL_IMG = new ImageIcon("img\\normalImg.png");
    private final static ImageIcon EAT_IMG = new ImageIcon("img\\eatImg.png");
    private final static ImageIcon LOSS_IMG = new ImageIcon("img\\lossImg.png");
    
    /**
     * Creates new form Snake
     */
    public GameFrame() {
        setLocation((Toolkit.getDefaultToolkit().getScreenSize().width  - getWidth()) / 2, 
                (Toolkit.getDefaultToolkit().getScreenSize().height - getHeight()) / 2);
        System.out.println(getHeight());
        
        initComponents();
        initValues();
        initComponents2();
        
        // update map
        updateMap();
        
        // draw map
        drawMap();
        
        timer = new Timer(delay, taskPerformer);
        timer.start();
        
        setVisible(true);
    }
    
    ActionListener taskPerformer = new ActionListener() {
        // to temporally pause the timer
        boolean pause = false;
        public void actionPerformed(ActionEvent evt) {
            
            if (!pause) {
                emojiLabel.setIcon(NORMAL_IMG);
                switch (direction) {
                    case 'N':
                        nextPosition[0] = snake.get(snake.size() - 1)[0] - 1;
                        nextPosition[1] = snake.get(snake.size() - 1)[1];
                        break;
                    case 'S':
                        nextPosition[0] = snake.get(snake.size() - 1)[0] + 1;
                        nextPosition[1] = snake.get(snake.size() - 1)[1];
                        break;
                    case 'W':
                        nextPosition[0] = snake.get(snake.size() - 1)[0];
                        nextPosition[1] = snake.get(snake.size() - 1)[1] - 1;
                        break;
                    case 'E':
                        nextPosition[0] = snake.get(snake.size() - 1)[0];
                        nextPosition[1] = snake.get(snake.size() - 1)[1] + 1;
                        break;
                }

                // if you input a direction that is the opposite to the current 
                // direction, the key event will be ignored
//                if (snake.size() != 1 && 
//                        nextPosition[0] == snake.get(snake.size() - 2)[0] && nextPosition[1] == snake.get(snake.size() - 2)[1])
//                    return;

                // if loss, ask the user whether to restart the game
                if (lossesGame()) {
                    emojiLabel.setIcon(LOSS_IMG);
                    setEnabled(false);
                    new ContinueFrame(GameFrame.this);
                    pause = true;
                    return;
                }

                updateSnake();
                updateMap();
                drawMap();
                repaint();
            }
        }
    };

    public void initValues() {
        // init direction
        direction = 'E';
        preDirection = 'W';
        
        // init the nextPosition
        nextPosition = new int[2];
        
        // init snake
        snake = new ArrayList<>();
        snake.add(new int[] {0, 0});
        
        // init fruit
        fruit = new int[2];
        generateFruit();
        
        // init map (the logic map)
        map = new int[ROW][COL];
        
        // init cellss (2d array of JLables)
        cellss = new JLabel[ROW][COL];
        
        fruitCounter = 0;
        level = 1;
        delay = 1000;
    }

    public void initComponents2() {
        levelLabel.setText("level " + level);
        fruitLabel.setText("Fruit " + fruitCounter);
        gamePanel.setLayout(new GridLayout(ROW, COL));
        
        //binding a jlable to each cell
        bindJLable();
        
        emojiLabel.setIcon(NORMAL_IMG);
    }
    
    public void generateFruit() {
        do {
            fruit[0] = new Random().nextInt(ROW);
            fruit[1] = new Random().nextInt(COL);
        } while (!isFruitValid());
    }
    
    public void bindJLable() {
        for (int i = 0; i < ROW; i++)
            for (int j = 0; j < COL; j++) {
                cellss[ROW - 1 - i][j] = new JLabel();
                cellss[ROW - 1 - i][j].setBorder(new LineBorder(Color.BLACK));
                gamePanel.add(cellss[ROW - 1 - i][j], ROW - 1 - i, j);
            }
    }
    
    public boolean isFruitValid() {
        for (int [] body : snake)
            if (fruit[0] == body[0] && fruit[1] == body[1])
                return false;
        return true;
    }
    
    public void updateSnake() {
        if (nextPosition[0] == fruit[0] && nextPosition[1] == fruit[1]) {
            fruitCounter++;
            fruitLabel.setText("Fruit " + fruitCounter);
            if (fruitCounter == LEVEL_UP_REQUIREMENT && level <= MAX_LEVEL) {
                fruitCounter = 0;
                fruitLabel.setText("Fruit " + fruitCounter);
                delay -= 100;
                levelLabel.setText("level " + ++level);
                timer.setDelay(delay);
            }
            snake.add(new int[] {nextPosition[0], nextPosition[1]});
            emojiLabel.setIcon(EAT_IMG);
        }

        else {
            for (int i = 0; i < snake.size() - 1; i++)
                snake.set(i, snake.get(i + 1));
            snake.set(snake.size() - 1, new int[] {nextPosition[0], nextPosition[1]});
        }
    }
    
    public void updateMap() {
        // clear the map
        for (int [] nums : map)
            Arrays.fill(nums, 0);
        
        // label the snake as 1
        for (int [] body : snake) {
            if (body[0] == fruit[0] && body[1] == fruit[1]) 
                generateFruit();
            
            map[body[0]][body[1]] = 1;
        }
        
        // label the fruit as 2
        map[fruit[0]][fruit[1]] = 2;
    }
    
    public void drawMap() {
        for (int i = 0; i < ROW; i++) 
            for (int j = 0; j < COL; j++) {
                if (map[i][j] == 1)
                    cellss[i][j].setIcon(BLACK_IMG);
                else if(map[i][j] == 2)
                    cellss[i][j].setIcon(FRUIT_IMG);
                else
                    cellss[i][j].setIcon(null);
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

        jPanel2 = new javax.swing.JPanel();
        headPanel = new javax.swing.JPanel();
        emojiLabel = new javax.swing.JLabel();
        levelLabel = new javax.swing.JLabel();
        fruitLabel = new javax.swing.JLabel();
        gamePanel = new javax.swing.JPanel();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 360, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Snake Game");
        setPreferredSize(new java.awt.Dimension(400, 600));
        setResizable(false);
        setSize(new java.awt.Dimension(400, 600));
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        headPanel.setPreferredSize(new java.awt.Dimension(400, 100));

        levelLabel.setText("Level  ");

        fruitLabel.setText("Fruit ");

        javax.swing.GroupLayout headPanelLayout = new javax.swing.GroupLayout(headPanel);
        headPanel.setLayout(headPanelLayout);
        headPanelLayout.setHorizontalGroup(
            headPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(headPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(levelLabel)
                    .addComponent(fruitLabel))
                .addGap(124, 124, 124)
                .addComponent(emojiLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(190, Short.MAX_VALUE))
        );
        headPanelLayout.setVerticalGroup(
            headPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(headPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(headPanelLayout.createSequentialGroup()
                        .addComponent(levelLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fruitLabel))
                    .addComponent(emojiLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        gamePanel.setPreferredSize(new java.awt.Dimension(400, 400));

        javax.swing.GroupLayout gamePanelLayout = new javax.swing.GroupLayout(gamePanel);
        gamePanel.setLayout(gamePanelLayout);
        gamePanelLayout.setHorizontalGroup(
            gamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        gamePanelLayout.setVerticalGroup(
            gamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(headPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 405, Short.MAX_VALUE)
                    .addComponent(gamePanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 405, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(headPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(gamePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        char newDirection = '\u0000';
        switch (evt.getKeyCode()) {
            case KeyEvent.VK_UP:
                if (direction != 'S')
                    direction = 'N';
                break;
            case KeyEvent.VK_DOWN:
                if (direction != 'N')
                    direction = 'S';
                break;
            case KeyEvent.VK_LEFT:
                if (direction != 'E')
                    direction = 'W';
                break;
            case KeyEvent.VK_RIGHT:
                if (direction != 'W')
                    direction = 'E';
                break;
        }
    }//GEN-LAST:event_formKeyPressed

    public boolean lossesGame() {
        if (nextPosition[0] < 0 || nextPosition[0] >= ROW || nextPosition[1] < 0 || nextPosition[1] >= COL)
            return true;
        
        for (int i = 0; i < snake.size(); i++)
            if (nextPosition[0] == snake.get(i)[0] && nextPosition[1] == snake.get(i)[1])
                return true;
        
        return false;
    }
    
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
            java.util.logging.Logger.getLogger(GameFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GameFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GameFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GameFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GameFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel emojiLabel;
    private javax.swing.JLabel fruitLabel;
    private javax.swing.JPanel gamePanel;
    private javax.swing.JPanel headPanel;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel levelLabel;
    // End of variables declaration//GEN-END:variables
}
