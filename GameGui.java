import src.abstractfactory.AbstractFactory;
import src.abstractfactory.EnemyFactory;
import src.board.Board;
import src.board.PathGenerator;
import src.cell.Cell;
import src.cell.enemy.Enemy;
import src.cell.enemy.EnemyPrototype;
import src.cell.tower.Tower;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameGui {
    //Create Frames of the UI
    JFrame gameWindow = new JFrame("Stage 1");
    JFrame uiWindow = new JFrame("Tower Defense Game");

    //initializing Panels
    JPanel uiPanel = new JPanel();
    JPanel gamePanel1 = new JPanel();
    JPanel gameControl = new JPanel();
    JPanel infoPanel = new JPanel();
    JPanel buttonPanel = new JPanel();
    JPanel statPanel = new JPanel();
    JPanel functionPanel = new JPanel();

    //initializing Button + Labels
    JButton startButton = new JButton("Start Game");
    JButton quitButton = new JButton("Exit Game");
    JButton pauseButton = new JButton("Pause Game");
    JButton resumeButton = new JButton("Resume Game");
    JButton buyButton = new JButton("Buy");
    JButton upgradeButton = new JButton("Upgrade");
    JButton sellButton = new JButton("Sell");
    JLabel text = new JLabel("Welcome to the tower defense game");
    JLabel goldLabel = new JLabel("GOLD: " );
    JLabel healthLabel = new JLabel("Lives: ");
    JLabel WaveNumLabel = new JLabel("Current Wave: ");
    JLabel EnemyHealth = new JLabel("Enemy's Health: ");
    JLabel TowerDamage = new JLabel();

    //Variables
    private int xCanvas = 600;
    private int yCanvas = 600;
    private int xBox = 10;
    private int yBox = 10;

    private Board board;

    GameGui(Board board) {
        // Button that starts a new frame
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JLabel label = new JLabel();
                label.setFont(new Font("Tahoma", Font.BOLD, 15));

                // Displays the Game
                gamePanel1.setBackground(Color.WHITE);
                gamePanel1.setPreferredSize(new Dimension(1000, 200));

                //Creates the information Panel
                createInfoPanel();

                // Buttons for buy, upgrade towers
                buttonPanel.setLayout(new GridLayout(0, 1, 2, 2));
                buttonPanel.setBackground(Color.white);
                buttonPanel.setPreferredSize(new Dimension(100, 100));
                buttonPanel.setBorder(BorderFactory.createLineBorder(Color.WHITE));
                buttonPanel.add(buyButton);
                buttonPanel.add(upgradeButton);
                buttonPanel.add(sellButton);

                // Game functionality buttons
                functionPanel.setLayout(new GridLayout(0, 1, 2, 2));
                functionPanel.setPreferredSize(new Dimension(100, 100));
                functionPanel.setBorder(BorderFactory.createLineBorder(Color.WHITE));
                functionPanel.add(pauseButton);
                functionPanel.add(resumeButton);
                functionPanel.add(quitButton);

                // Panel that holds all other Panels
                gameControl.setLayout(new BoxLayout(gameControl, BoxLayout.X_AXIS));
                gameControl.add(infoPanel);
                //gameControl.add(statPanel);
                gameControl.add(functionPanel);
                gameControl.setPreferredSize(new Dimension(1000, 200));

                // Game Window
                gameWindow.getContentPane().add(gamePanel1, "Center");
                gameWindow.add(gameControl, BorderLayout.PAGE_END);
                gameWindow.setSize(xCanvas, yCanvas + 200);
                gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                gameWindow.setVisible(true);
                gameWindow.setResizable(false);

                xCanvas = gamePanel1.getWidth();
                yCanvas = gamePanel1.getHeight();
                uiWindow.dispose();

                // Display x and y coordinate of the cell with mouse click
                gameWindow.addMouseListener(new MouseAdapter() {
                    public void mouseClicked(MouseEvent e) {
                        label.setText("X= " + (e.getX() / getxBox() + 1) + ", " + "Y= "
                                + (((e.getY() - 10) / getyBox() + 1)));
                    }
                });
            }
        });

        buyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        // Button that exit the current frame
        quitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                uiWindow.dispose();
                gameWindow.dispose();
            }
        });

        uiPanel.setBorder(BorderFactory.createEmptyBorder(300, 300, 100, 300));
        uiPanel.setLayout(new GridLayout(0, 1));
        uiPanel.add(text);
        uiPanel.add(startButton);
        uiPanel.add(quitButton);

        // set up the frame and display it
        uiWindow.add(uiPanel, BorderLayout.CENTER);
        uiWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        uiWindow.setTitle("Tower Defense Game");
        uiWindow.pack();
        uiWindow.setVisible(true);
    }

    public void createInfoPanel(){
        // Display the game Infomation
        infoPanel.removeAll();
        goldLabel = new JLabel("GOLD: " + board.getBoardInstance().getGold());
        healthLabel = new JLabel("Lives: " + board.getBoardInstance().getHealth());
        WaveNumLabel = new JLabel("Current Wave: " + board.getBoardInstance().getWaveNum());
        EnemyHealth = new JLabel("Enemy's Health: " + board.getBoardInstance().getEnemy().getHealth());
        if(board.getBoardInstance().getTowerDamage() != null){
            TowerDamage = new JLabel(board.getBoardInstance().getTowerDamage().toString());
        }
        infoPanel.setBackground(Color.white);
        infoPanel.setPreferredSize(new Dimension(100, 100));
        infoPanel.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        infoPanel.add(goldLabel);
        infoPanel.add(healthLabel);
        infoPanel.add(WaveNumLabel);
        infoPanel.add(EnemyHealth);
        infoPanel.add(TowerDamage);

        gameControl.revalidate();
        gameControl.repaint();
        gameControl.setVisible(true);
    }

    public JPanel getJPanel() {
        return gamePanel1;
    }

    public void drawBoard(JPanel board) {
        gameWindow.remove(gamePanel1);
        gamePanel1 = board;
        gameWindow.add(gamePanel1);
        gameWindow.revalidate();
        gameWindow.repaint();
        gameWindow.setVisible(true);
    }

    public void drawInfoPage(JPanel infoPage) {
        gameControl.remove(infoPanel);
        infoPanel = infoPage;
        gameControl.add(infoPanel);
        gameControl.revalidate();
        gameControl.repaint();
        gameControl.setVisible(true);
    }

    public void setxBox(int length) {
        this.xBox = length;
    }

    public void setyBox(int height) {
        this.yBox = height;
    }

    public int getxBox() {
        return xBox;
    }

    public int getyBox() {
        return yBox;
    }

    public void setxCanvas(int length) {
        this.xCanvas = length;
    }

    public void setyCanvas(int height) {
        this.yCanvas = height;
    }

    public int getxCanvas() {
        return xCanvas;
    }

    public int getyCanvas() {
        return yCanvas;
    }
}
