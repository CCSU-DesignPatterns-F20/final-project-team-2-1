/**
 * @author XiaoWei Chen, Radoslaw Konopka, Daniel Pobidel, Trung Minh Tri Nguyen
 */

public class Main {
    public static void main(String args[]) {
        System.out.println("Running the game");
        // Creates board
        Board board = new Board(3, 2);
        board.displayBoard();

        System.out.println("\nCreating enemies and towers");
        AbstractFactory towerFactory = new TowerFactory();
        AbstractFactory enemyFactory = new EnemyFactory();
        StrongTower tower1 = (StrongTower) towerFactory.createProduct("strongtower", board.getCell(0, 0));
        CellComponent tower2 = towerFactory.createProduct("weaktower", board.getCell(0, 0));
        CellComponent enemy1 = enemyFactory.createProduct("slowenemy", board.getCell(2, 1));
        CellComponent enemy2 = enemyFactory.createProduct("fastenemy", board.getCell(0, 0));

        tower1.attack();
        CellComposite towersAndEnemies = new CellComposite();
        towersAndEnemies.add(tower1);
        towersAndEnemies.add(tower2);
        towersAndEnemies.add(enemy1);
        towersAndEnemies.add(enemy2);
        System.out.println(tower1.toString());

        System.out.println("\nDrawing all components");
        towersAndEnemies.draw();

        System.out.println("\nDrawing all components on Cell(0,0)");
        board.getCell(0, 0).draw();
        System.out.println("\nDrawing all components on Cell(2,1)");
        board.getCell(2, 1).draw();
        System.out.println("\nDrawing all components on Cell(1,1)");
        board.getCell(1, 1).draw();
        System.out.println("\nDrawing entire Board");
        board.displayBoard();
        // CellComponent tower3 = new StrongTower(board.getCell(0,0));
        // tower3.attack();
        System.out.print("\nExiting the game");
    }
}