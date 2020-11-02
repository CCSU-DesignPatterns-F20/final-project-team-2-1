/**
* This is the Board class that is used to store all the cell
*/
public class Board{
    private Cell [][] cells;

    public Board(int x, int y){
        cells = new Cell [x][y];
        for (int r = 0; r < x; r ++){
            for (int c = 0; c < y; c ++){
                cells[r][c] = new Cell(r, c, false);
            }
        }
    }

    /**
    * This displays the board in the console
    */
    public void displayBoard(){
        for (int r = 0; r < this.cells.length; r ++){
            for (int c = 0; c < this.cells[0].length; c ++){
                System.out.println(cells[r][c].toString());
            }
        }
    }

    /**
    * Access specific cell
    * @param row 
    * @param column
    */
    public Cell getCell(int row, int col){
        return cells[row][col];
    }

    /**
    * This refresh the board in the console
    */
    public void refreshBoard(){

    }
}