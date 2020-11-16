import javax.swing.*;

import sun.java2d.loops.DrawRect;

import java.awt.*;
import java.awt.event.*;

public class GameGui{
    JFrame gameWindow = new JFrame("Stage 1");
    JFrame uiWindow = new JFrame("Tower Defense Game");
    JPanel uiPanel = new JPanel();
    JPanel gamePanel1 = new JPanel();
    JPanel gamePanel2 = new JPanel();
    JButton startButton = new JButton("Start Game");
    JButton quitButton = new JButton("Exit Game");
    JButton pauseButton = new JButton("Pause Game");
    JLabel text = new JLabel("Welcome to the tower defense game");
    private int xCanvas = 1200;
    private int yCanvas = 800;
    private int xBox = 10;
    private int yBox = 10;
    Graphics g;


    GameGui(){
        //Button that starts a new frame
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                JLabel label = new JLabel();
                label.setFont(new Font("Tahoma", Font.BOLD, 15));
                gamePanel1.setBackground(Color.cyan);
                gamePanel1.setPreferredSize(new Dimension(1000,200));
                gamePanel2.setBackground(Color.red);
                gamePanel2.add(label);
                gamePanel2.add(pauseButton);
                gamePanel2.add(quitButton);
                gamePanel2.setPreferredSize(new Dimension(1000, 200));
                gameWindow.add(gamePanel1, BorderLayout.CENTER);
                gameWindow.add(gamePanel2, BorderLayout.PAGE_END);
                gameWindow.setSize(1200, 800);
                gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                gameWindow.setVisible(true);
                xCanvas = gamePanel1.getWidth();
                yCanvas = gamePanel1.getHeight();
                uiWindow.dispose();

                //Display x and y coordinate with mouse click
                gameWindow.addMouseListener(new MouseAdapter() {
                    public void mouseClicked(MouseEvent e){
                        label.setText("X = "+ e.getX()+" ; Y = "+e.getY());
                    }
                });  
            }
        });

        //Button that exit the current frame
        quitButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
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

    public JPanel getJPanel(){
        return gamePanel1;
    }

    public void drawBox(Graphics g, int x, int y){
        g.drawRect(x * xBox, y * yBox, xBox, yBox);
    }

    public void setxBox(int length){
        this.xBox = length;
    }

    public void setyBox(int height){
        this.yBox = height;
    }

    public int getxBox(){
        return xBox;
    }

    public int getyBox(){
        return yBox;
    }

    public void setxCanvas(int length){
        this.xCanvas = length;
    }

    public void setyCanvas(int height){
        this.yCanvas = height;
    }
    public int getxCanvas(){
        return xCanvas;
    }

    public int getyCanvas(){
        return yCanvas;
    }
}
