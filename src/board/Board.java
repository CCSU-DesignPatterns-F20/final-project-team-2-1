package src.board;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.text.Utilities;

import src.abstractfactory.AbstractFactory;
import src.abstractfactory.TowerFactory;
import src.board.iterator.CellList;
import src.cell.Cell;
import src.cell.enemy.Enemy;
import src.cell.enemy.EnemyPrototype;
import src.cell.enemy.HealthDecorator;
import src.cell.enemy.SlowEnemy;
import src.cell.tower.DamageDecorator;
import src.cell.tower.Tower;

/**
 * This is the Board class that is used to store all the cell
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
     * to be called once to create the board
     * 
     * @param builder
     * @return
     */
    public static Board getBoardInstance(BoardBuilder builder) {
        if (board == null)
            board = new Board(builder);
        return board;
    }

    /**
     * to be called whenever needed access to the board
     * 
     * @return
     * @throws Exception
     */
    public static Board getBoardInstance() {
        if (board != null)
            return board;
        return null;
    }

    public ArrayList<EnemyPrototype> createNewWave() {
        ArrayList<EnemyPrototype> newWave = new ArrayList<EnemyPrototype>();
        System.out.println("new wave is approaching");
        originalEnemy = new HealthDecorator(originalEnemy, 2); // change slowenemy to enemydecorator instance

        for (int i = 0; i < 1; i++) {
            newWave.add(originalEnemy.clone());
        }
        return newWave;
    }

    /**
     * returns the Iterator for the path
     */
    public CellList<Cell> getPath() {
        return pathCells;
    }

    public int getGold() {
        return this.gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getWaveNum() {
        return this.waveNum;
    }

    public void setWaveNum(int waveNum) {
        this.waveNum = waveNum;
    }

    public double getEnemyHalth() {
        return this.enemyHealth;
    }

    public void setEnemyHealth(double d){
        this.enemyHealth = d;
    }

    public EnemyPrototype getEnemy(){
        return this.originalEnemy;
    }
    /**
     * 
     * @return number of rows
     */

    public int getHealth() {
        return this.health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public Tower getTowerDamage(){
        return this.towerDamage;
    }

    public void setTowerDamage(Tower damage) {
        this.towerDamage = damage;
    }
    /**
     * 
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

    public List<EnemyPrototype> getEnemyList() {
        return this.enemyList;
    }

    public void remove(EnemyPrototype enemy) {

        for (int i = 0; i < enemyList.size(); i++) {

            if (enemy.equals(enemyList.get(i))) {
                enemyList.remove(i);

            }
        }
    }

    public List<Tower> getTowerList() {
        return this.towerList;
    }

    /**
     * This will draw all the cells
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
                                    towerList.add(towerFactory.createProduct("weaktower", clickedCell,
                                            pathCells.getCellPathIterator()));
                                    Board.getBoardInstance().setGold(Board.getBoardInstance().getGold() - 100);
                                }
                            } else if (SwingUtilities.isRightMouseButton(e))// double click for strong tower
                            {
                                if (Board.getBoardInstance().getGold() >= 150) {
                                    towerList.add(towerFactory.createProduct("strongtower", clickedCell,
                                            pathCells.getCellPathIterator()));
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
     * 
     * @param row
     * @param col
     */
    public Cell getCell(int row, int col) {
        return cells[row][col];
    }

    /**
     * Sets cell as path
     * 
     * @param row
     * @param col
     */
    public void setPath(int row, int col) {
        this.cells[row][col].setPath(true);
    }

    /**
     * This method returns String of all cells
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

    public static class BoardBuilder {
        private Tower towerDamage;
        private double enemyHealth;
        private Cell[][] cells;
        private CellList<Cell> pathCells;
        private int gold;
        private int waveNum;

        /**
         * Initializes the board using nonPath Cells
         * 
         * @param x of rows
         * @param y of columns
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

        public BoardBuilder setGold(int gold) {
            this.gold = gold;
            return this;
        }

        public BoardBuilder setWaveNum(int waveNum) {
            this.waveNum = waveNum;
            return this;
        }

        public BoardBuilder setEnemyHealth(double enemyHealth) {
            this.enemyHealth = enemyHealth;
            return this;
        }
        
        public BoardBuilder setTowerDamage(Tower damage) {
            this.towerDamage = damage;
            return this;
        }

        /**
         * This method turns Cells to path
         * 
         * @param tobePathCells of int x and y coordinates to choose Cells to be path
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
         * Returns pre-constructed Board
         */
        public Board build() {
            return new Board(this);
        }

		public BoardBuilder setTowerDamage(Object object) {
			return null;
		}
    }
}