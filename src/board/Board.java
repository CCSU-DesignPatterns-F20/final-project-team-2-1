package src.board;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

import src.abstractfactory.AbstractFactory;
import src.abstractfactory.TowerFactory;
import src.board.iterator.CellList;
import src.cell.Cell;
import src.cell.enemy.EnemyPrototype;
import src.cell.enemy.HealthDecorator;
import src.cell.enemy.SlowEnemy;
import src.cell.tower.DamageDecorator;
import src.cell.tower.Tower;

/**
 * This is the Board class that is used to store all the cells 
 */
public class Board {
    private EnemyPrototype originalEnemy;
    private static Board board = null;
    public final Cell[][] cells;
    private final CellList<Cell> pathCells;
    private int health = 4;
    private List<Tower> towerList;
    private List<EnemyPrototype> enemyList;
    private AbstractFactory<Tower> towerFactory;
    private int gold;
    private int waveNum;
    private double enemyHealth;
    private Tower towerDamage;

    /**
     * Constructs Board using predefined attributes
     * 
     * @param builder attributes
     */
    private Board(BoardBuilder builder) {
        this.cells = builder.cells;
        this.pathCells = builder.pathCells;
        this.towerFactory = new TowerFactory();
        this.towerList = new ArrayList<>();
        this.gold = builder.gold;
        this.waveNum = builder.waveNum;
        this.enemyHealth = builder.enemyHealth;
        this.towerDamage = builder.towerDamage;
        this.enemyList = new ArrayList<>();
        this.originalEnemy = new SlowEnemy(pathCells);
    }

    /**
     * This method is to be called once to create the board
     * @param builder
     * @return the board object 
     */
    public static Board getBoardInstance(BoardBuilder builder) {
        if (board == null)
            board = new Board(builder);
        return board;
    }

    /**
     * To be called whenever needed access to the board
     * @return board if not null other wise return null
     */
    public static Board getBoardInstance() {
        if (board != null)
            return board;
        return null;
    }

    /**
     * @return a new wave of enemies.  
     */
    public ArrayList<EnemyPrototype> createNewWave() {
        ArrayList<EnemyPrototype> newWave = new ArrayList<EnemyPrototype>();
        System.out.println("new wave is approaching");

        //change slowenemy to enemydecorator instance
        originalEnemy = new HealthDecorator(originalEnemy, 2);
        for (int i = 0; i < 4; i++) {
            newWave.add(originalEnemy.clone());
        }
        return newWave;
    }

    /**
     * @return the cell that contains the path
     */
    public CellList<Cell> getPath() {
        return pathCells;
    }

    /**
     * @return the gold amount @
     */
    public int getGold() {
        return this.gold;
    }

    /**
     * @param gold for the amount of gold to start with
     */
    public void setGold(int gold) {
        this.gold = gold;
    }

    /**
     * @return the current wave number 
     */
    public int getWaveNum() {
        return this.waveNum;
    }

    /**
     * @param waveNum for the intial wave number
     */
    public void setWaveNum(int waveNum) {
        this.waveNum = waveNum;
    }

    /**
     * @return the health of the enemy
     */
    public double getEnemyHalth() {
        return this.enemyHealth;
    }

    /**
     * @param d to set the enemy health 
     */
    public void setEnemyHealth(double d){
        this.enemyHealth = d;
    }

    /**
     * @return the enemy that is moving on the cell
     */
    public EnemyPrototype getEnemy(){
        return this.originalEnemy;
    }
    
    /**
     * @return the lives of the gameplay
     */
    public int getHealth() {
        return this.health;
    }

    /**
     * @param health for the number of lives when the game starts
     */
    public void setHealth(int health) {
        this.health = health;
    }

    /**
     * @return the information / Damage of the current tower
     */
    public Tower getTowerDamage(){
        return this.towerDamage;
    }

    /**
     * @param damage to set the damage of the tower
     */
    public void setTowerDamage(Tower damage) {
        this.towerDamage = damage;
    }
    /**
     * @return number of rows
     */
    public int getRows() {
        return cells.length;
    }

    /**
     * 
     * @return numbers of columns
     */
    public int getColumns() {
        return cells[0].length;
    }

    /**
     * @return the enemy list
     */
    public List<EnemyPrototype> getEnemyList() {
        return this.enemyList;
    }
    
    /**
     * @param enemy to be removed
     */
    public void remove(EnemyPrototype enemy) {
        for (int i = 0; i < enemyList.size(); i++) {
            if (enemy.equals(enemyList.get(i))) {
                enemyList.remove(i);
            }
        }
    }

    /**
     * @return the tower list
     */
    public List<Tower> getTowerList() {
        return this.towerList;
    }

    /**
     * This will draw all the cells, and display the board
     * Towers can be added by mouse click, Left click -> weak tower, right click -> strong tower
     * Gold will be deducted from purchashing towers
     * @return the drawnBoard
     */
    public JPanel displayBoard() {
        JPanel drawnBoard = new JPanel();
        drawnBoard.setPreferredSize(new Dimension(1000, 200));
        for (int r = 0; r < this.cells.length; r++) {
            for (int c = 0; c < this.cells[0].length; c++) {
                JPanel cell = new JPanel();
                int finalR = r; // to be used in anonymous class
                int finalC = c;// to be used in anonymous class
                cell.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        // if (state == "playing") return;
                        var clickedCell = cells[finalR][finalC];
                        if (clickedCell.isPath())
                            return; // prevent adding tower to path
                        if (clickedCell.getSubComponents().size() > 0) { // will upgrade tower
                            Tower tobeSearchedTower = (Tower) clickedCell.getSubComponentAtIndex(0);
                            Tower decoratedTower = new DamageDecorator(tobeSearchedTower, 2);
                            Board.getBoardInstance().setTowerDamage(decoratedTower);
                            // replace tower in towerList by decoratedTower
                            for (int i = 0; i < towerList.size(); i++) {
                                if (towerList.get(i).equals(tobeSearchedTower)) {

                                    towerList.set(i, decoratedTower);
                                    Board.getBoardInstance().setTowerDamage(decoratedTower);
                                }
                            }
                            // replacing the first item
                            clickedCell.remove(tobeSearchedTower);

                            if (Board.getBoardInstance().getGold() >= 75)
                                Board.getBoardInstance().setGold(Board.getBoardInstance().getGold() - 75);
                        } else { // will add tower
                            if (SwingUtilities.isLeftMouseButton(e)) // 1 click for weak tower
                            {
                                if (Board.getBoardInstance().getGold() >= 100) {
                                    Tower tower = towerFactory.createProduct("weaktower", clickedCell,
                                    pathCells.getCellPathIterator());
                                    towerList.add(tower);
                                    Board.getBoardInstance().setTowerDamage(tower);
                                    Board.getBoardInstance().setGold(Board.getBoardInstance().getGold() - 100);
                                }
                            } else if (SwingUtilities.isRightMouseButton(e))// double click for strong tower
                            {
                                if (Board.getBoardInstance().getGold() >= 150) {
                                    Tower tower = towerFactory.createProduct("strongtower", clickedCell,
                                    pathCells.getCellPathIterator());
                                    towerList.add(tower);
                                    Board.getBoardInstance().setTowerDamage(tower);
                                    Board.getBoardInstance().setGold(Board.getBoardInstance().getGold() - 150);
                                }
                            }
                        }
                    }
                });

                cell.setBackground(cells[r][c].draw());
                JLabel enemyNum = new JLabel(cells[r][c].getSubComponents().size() + "");
                cell.add(enemyNum);
                cell.setPreferredSize(new Dimension(50, 50));
                drawnBoard.add(cell);
            }
        }
        return drawnBoard;
    }

    /**
     * Access specific cells
     * @param row
     * @param col
     * @return the cell with specific row and colum
     */
    public Cell getCell(int row, int col) {
        return cells[row][col];
    }

    /**
     * Sets cell as path
     * @param row
     * @param col
     */
    public void setPath(int row, int col) {
        this.cells[row][col].setPath(true);
    }

    /**
     * @return String of all cells
     */
    public String toString() {
        String allCells = "Cells: \n";
        for (int r = 0; r < this.cells.length; r++) {
            for (int c = 0; c < this.cells[0].length; c++) {
                allCells += this.cells[r][c].toString() + '\n';
            }
        }
        return allCells;
    }

    /**
     * Nested class
     */
    public static class BoardBuilder {
        private Tower towerDamage;
        private double enemyHealth;
        private Cell[][] cells;
        private CellList<Cell> pathCells;
        private int gold;
        private int waveNum;

        /**
         * Initializes the board using nonPath Cells
         * @param x of rows
         * @param y of columns
         * @return the cell
         */
        public BoardBuilder setBoardSize(int x, int y) {

            this.cells = new Cell[x][y];
            for (int r = 0; r < x; r++) {
                for (int c = 0; c < y; c++) {
                    this.cells[r][c] = new Cell(r, c, false);
                }
            }
            return this;
        }

        /**
         * @param gold
         * @return 
         */
        public BoardBuilder setGold(int gold) {
            this.gold = gold;
            return this;
        }

        /**
         * @param waveNum
         * @return
         */
        public BoardBuilder setWaveNum(int waveNum) {
            this.waveNum = waveNum;
            return this;
        }

        /**
         * @param enemyHealth
         * @return
         */
        public BoardBuilder setEnemyHealth(double enemyHealth) {
            this.enemyHealth = enemyHealth;
            return this;
        }
        
        /**
         * @param damage
         * @return
         */
        public BoardBuilder setTowerDamage(Tower damage) {
            this.towerDamage = damage;
            return this;
        }

        /**
         * This method turns Cells to path
         * @param tobePathCells of int x and y coordinates to choose Cells to be path
         * @return the path 
         */
        public BoardBuilder setPathCell(int[][] tobePathCells) {
            this.pathCells = new CellList<Cell>();
            for (int[] cell : tobePathCells) {
                Cell c = this.cells[cell[0]][cell[1]];
                c.setPath(true);
                this.pathCells.add(c);
            }
            return this;
        }

        /**
         * @return pre-constructed Board
         */
        public Board build() {
            return new Board(this);
        }

        /** 
         * This sets the damage of the tower at the intial state
         * @param object
         * @return null by default
         */
		public BoardBuilder setTowerDamage(Object object) {
			return null;
		}
    }
}