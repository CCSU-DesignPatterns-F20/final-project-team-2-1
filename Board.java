/**
 * This is the Board class that is used to store all the cell
 */
public class Board {
    private final Cell[][] cells;

    public Board(BoardBuilder builder) {
        cells = builder.cell;
    }

    public Board(int x, int y) {
        this.cells = new Cell[x][y];
        for (int r = 0; r < x; r++) {
            for (int c = 0; c < y; c++) {
                this.cells[r][c] = new Cell(r, c, false);
            }
        }

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
        private Cell[][] cell;

        public Board build() {
            return new Board(this);
        }

        /**
         * Initialzes the nonPath Cells
         * 
         * @param number of rows
         * @param number of columns
         */
        public Cell[][] buildCells(int x, int y) {
            cell = new Cell[x][y];
            for (int r = 0; r < x; r++) {
                for (int c = 0; c < y; c++) {
                    cell[r][c] = new Cell(r, c, false);
                }
            }
            return cell;
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