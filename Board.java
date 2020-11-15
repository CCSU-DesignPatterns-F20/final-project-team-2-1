import Iterator.CellList;
import Iterator.IteratorInterface;

/**
 * This is the Board class that is used to store all the cell
 */
public class Board {
    private final Cell[][] cells;
    private final CellList<Cell> pathCells;

    public Board(BoardBuilder builder) {
        this.cells = builder.cells;
        this.pathCells = builder.pathCells;
    }

    public IteratorInterface<Cell> getPath() {
        return pathCells.getCellPathIterator();
    }

    /**
     * This refresh the board in the console
     */
    public void refreshBoard() {

    }

    /**
     * This will draw all the cells
     */
    public void displayBoard() {
        for (int r = 0; r < this.cells.length; r++) {
            for (int c = 0; c < this.cells[0].length; c++) {
                cells[r][c].draw();
                // System.out.println(cells[r][c].toString());
            }
        }
    }

    public static class BoardBuilder {
        private Cell[][] cells;
        private CellList<Cell> pathCells;

        public BoardBuilder setBoardSize(int x, int y) {

            this.cells = new Cell[x][y];
            for (int r = 0; r < x; r++) {
                for (int c = 0; c < y; c++) {
                    this.cells[r][c] = new Cell(r, c, false);
                }
            }
            return this;
        }

        public BoardBuilder setPathCell(int[][] tobePathCells) {
            this.pathCells = new CellList<Cell>();
            for (int[] cell : tobePathCells) {
                Cell c = this.cells[cell[0]][cell[1]];
                c.setPath(true);
                this.pathCells.add(c);
            }
            return this;
        }

        public Board build() {
            return new Board(this);
        }

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
}