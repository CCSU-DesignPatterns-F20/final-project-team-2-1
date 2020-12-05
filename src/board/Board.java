package src.board;

import java.awt.Dimension;

import javax.swing.JPanel;

import src.board.iterator.CellList;
import src.board.iterator.IteratorInterface;
import src.cell.Cell;

/**
 * This is the Board class that is used to store all the cell
 */
public class Board extends JPanel {
    public final Cell[][] cells;
    private final CellList<Cell> pathCells;

    /**
     * Constructs Board using predefined attributes
     * 
     * @param predefined attributes
     */
    private Board(BoardBuilder builder) {
        this.cells = builder.cells;
        this.pathCells = builder.pathCells;
    }

    /**
     * returns the Iterator for the path
     */
    public IteratorInterface<Cell> getPath() {
        return pathCells.getCellPathIterator();
    }

    /**
     * This refresh the board in the console
     */
    public void refreshBoard() {

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

    // /**
    //  * This will draw all the cells
    //  */
    // public void displayBoard() {
    //     for (int r = 0; r < this.cells.length; r++) {
    //         for (int c = 0; c < this.cells[0].length; c++) {
    //             cells[r][c].draw();
    //             // System.out.println(cells[r][c].toString());
    //         }
    //     }
    // }

    /**
     * This will draw all the cells
     */
    public JPanel displayBoard() {
        JPanel drawnBoard = new JPanel();
        drawnBoard.setPreferredSize(new Dimension(1000, 200));
        for (int r = 0; r < this.cells.length; r++) {
            for (int c = 0; c < this.cells[0].length; c++) {
                JPanel cellPanel = new JPanel();
                cellPanel.setBackground(cells[r][c].draw());
                cellPanel.setPreferredSize(new Dimension(50, 50));
                drawnBoard.add(cellPanel);
            }
        }
        return drawnBoard;
    }

    /**
     * Access specific cell
     * 
     * @param row
     * @param column
     */
    public Cell getCell(int row, int col) {
        return cells[row][col];
    }

    /**
     * Sets cell as path
     * 
     * @param row
     * @param column
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
        private Cell[][] cells;
        private CellList<Cell> pathCells;

        /**
         * Initializes the board using nonPath Cells
         * 
         * @param number of rows
         * @param number of columns
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
         * This method turns Cells to path
         * 
         * @param list of int x and y coordinates to choose Cells to be path
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

    }
}