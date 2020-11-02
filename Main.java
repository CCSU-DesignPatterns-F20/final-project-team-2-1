/**
 * @author XiaoWei Chen, Radoslaw Konopka, Daniel Pobidel, Trung Minh Tri Nguyen
 */

public class Main
{
    public static void main(String args[]){
        System.out.println("Running the game");
        // Creates board
        Board board = new Board(3, 2);
        board.displayBoard();

        System.out.println("Creating enemies and towers");
        CellComponent  tower1 = new StrongTower(board.getCell(0,0));
        CellComponent  tower2 = new WeakTower(board.getCell(0,1));
        CellComponent  enemy1= new SlowEnemy(board.getCell(2,1));
        CellComponent  enemy2= new FastEnemy(board.getCell(1,0));

        CellComposite towersAndEnemies = new CellComposite();
        towersAndEnemies.add(tower1);
        towersAndEnemies.add(tower2);
        towersAndEnemies.add(enemy1);
        towersAndEnemies.add(enemy2);

        towersAndEnemies.printAllComponenents();
        System.out.println("Doubling the speed for all components (excluding cells)");
        towersAndEnemies.changeSpeed(2);
        towersAndEnemies.printAllComponenents();

        System.out.print("Exiting the game");
    }
}