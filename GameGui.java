import javax.swing.*;

import src.abstractfactory.AbstractFactory;
import src.abstractfactory.EnemyFactory;
import src.board.Board;
import src.board.PathGenerator;
import src.cell.Cell;
import src.cell.enemy.Enemy;
import src.cell.enemy.EnemyPrototype;
import src.cell.tower.Tower;

import java.awt.*;
import java.awt.event.*;

public class GameGui {
    //Frames 
    JFrame gameWindow = new JFrame("Stage 1");
    JFrame uiWindow = new JFrame("Tower Defense Game");

    //Panels
    JPanel uiPanel = new JPanel();
    JPanel gamePanel1 = new JPanel();
    JPanel gameControl = new JPanel();
    JPanel infoPanel = new JPanel();
    JPanel buttonPanel = new JPanel();
    JPanel statPanel = new JPanel();
    JPanel functionPanel = new JPanel();

    //Button + Labels
    JButton startButton = new JButton("Start Game");
    JButton quitButton = new JButton("Exit Game");
    JButton pauseButton = new JButton("Pause Game");
    JButton resumeButton = new JButton("Resume Game");
    JButton buyButton = new JButton("Buy");
    JButton upgradeButton = new JButton("Upgrade");
    JButton sellButton = new JButton("Sell");
    JLabel text = new JLabel("Welcome to the tower defense game");

    //Variables
    private int xCanvas = 600;
    private int yCanvas = 600;
    private int xBox = 10;
    private int yBox = 10;
    Graphics g;

    GameGui() {
        // Button that starts a new frame
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JLabel label = new JLabel();
                label.setFont(new Font("Tahoma", Font.BOLD, 15));

                //Displays the Game
                gamePanel1.setBackground(Color.WHITE);
                gamePanel1.setPreferredSize(new Dimension(1000, 200));

                //Display the game Infomation
                infoPanel.setBackground(Color.white);
                infoPanel.setPreferredSize(new Dimension(100,100));
                infoPanel.setBorder(BorderFactory.createLineBorder(Color.WHITE));
                infoPanel.add(label);
                
                //Buttons for buy, upgrade towers
                buttonPanel.setLayout(new GridLayout(0,1,2,2));
                buttonPanel.setBackground(Color.white);
                buttonPanel.setPreferredSize(new Dimension(100,100));
                buttonPanel.setBorder(BorderFactory.createLineBorder(Color.WHITE));
                buttonPanel.add(buyButton);
                buttonPanel.add(upgradeButton);
                buttonPanel.add(sellButton);

                //Stats of the tower/enemy
                statPanel.setBackground(Color.YELLOW);
                statPanel.setPreferredSize(new Dimension(100,100));
                statPanel.setBorder(BorderFactory.createLineBorder(Color.WHITE));

                //Game functionality buttons
                functionPanel.setLayout(new GridLayout(0,1,2,2));
                functionPanel.setPreferredSize(new Dimension(100,100));
                functionPanel.setBorder(BorderFactory.createLineBorder(Color.WHITE));
                functionPanel.add(pauseButton);
                functionPanel.add(resumeButton);
                functionPanel.add(quitButton);

                //Panel that holds all other Panels
                gameControl.setLayout(new BoxLayout(gameControl, BoxLayout.X_AXIS));
                gameControl.add(infoPanel);
                gameControl.add(buttonPanel);
                gameControl.add(statPanel);
                gameControl.add(functionPanel);
                gameControl.setPreferredSize(new Dimension(1000, 200));

                //Game Window
                gameWindow.getContentPane().add(gamePanel1, "Center");
                gameWindow.add(gameControl, BorderLayout.PAGE_END);
                gameWindow.setSize(xCanvas, yCanvas + 200);
                gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                gameWindow.setVisible(true);
                gameWindow.setResizable(false);

                // for (int i = 0; i < 100; i++) {
                // gamePanel1.add(paintBoardCells(i));
                // }


                // BADDDDDDD
                // var path = PathGenerator.create10by10EasyPath();

                // Board board = new Board.BoardBuilder().setBoardSize(10, 10).setPathCell(path).build();
                //  AbstractFactory<Enemy> enemyFactory = new EnemyFactory();
                // EnemyPrototype enemy1 = enemyFactory.createProduct("slowenemy",board.getCell(2,1));
                // EnemyPrototype enemy2 = enemyFactory.createProduct("fastenemy",board.getCell(0,0));
                // for (int i = 0; i < board.cells.length; i++) {
                //     for (int j = 0; j < board.cells[0].length; j++) {
                //         JPanelObject jpanelCell = new JPanelObject<Cell>();
                //         jpanelCell.object = board.cells[i][j];
                //         jpanelCell.jpanel = new JPanel();
                //         JLabel pathFlag;
                //         var color = ((Cell) jpanelCell.object).draw();
                //         jpanelCell.jpanel.setBackground(color);
                        

                //         jpanelCell.jpanel.setPreferredSize(new Dimension(50, 50));
                //         // jpanelCell.jpanel.add(pathFlag);
                        
                //     }
                // }

                
                // BADDDDDDD

                xCanvas = gamePanel1.getWidth();
                yCanvas = gamePanel1.getHeight();
                uiWindow.dispose();

                // Display x and y coordinate of the cell with mouse click
                gameWindow.addMouseListener(new MouseAdapter() {
                    public void mouseClicked(MouseEvent e) {
                        label.setText("X= " + (e.getX()/getxBox()+1) + ", " + "Y= " + (((e.getY()-10)/getyBox() + 1))
                        );
                    }
                });
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

    public JPanel getJPanel() {
        return gamePanel1;
    }

    public void drawBoard(JPanel board) {
        // gamePanel1.add(board);

        gameWindow.remove(gamePanel1);
        gamePanel1 = board;
        gameWindow.add(gamePanel1);
        gameWindow.revalidate();
        gameWindow.repaint();
        gameWindow.setVisible(true);

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

    // public JPanel paintBoardCells(int cellCount) {
    //     JPanel gamePanelCell = new JPanel();
    //     JLabel squareText = new JLabel("" + cellCount);
    //     gamePanelCell.setBackground(Color.gray);
    //     gamePanelCell.setPreferredSize(new Dimension(50, 50));
    //     gamePanelCell.add(squareText);
    //     // gamePanelPath.setBounds(25+pathLength,25+pathLength,
    //     // gamePanelPath.getPreferredSize().width,
    //     // gamePanelPath.getPreferredSize().height);
    //     return gamePanelCell;
    // }
}
