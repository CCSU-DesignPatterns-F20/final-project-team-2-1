import src.abstractfactory.AbstractFactory;
import src.abstractfactory.EnemyFactory;
import src.abstractfactory.TowerFactory;
import src.board.Board;
import src.board.PathGenerator;
import src.cell.CellComposite;
import src.cell.enemy.Enemy;
import src.cell.enemy.EnemyPrototype;
import src.cell.enemy.HealthDecorator;
import src.cell.tower.DamageDecorator;
import src.cell.tower.Tower;

/**
 * @author XiaoWei Chen, Radoslaw Konopka, Daniel Pobidel, Trung Minh Tri Nguyen
 */
public class Main {
    public static void main(String args[]) {
		 Game.play();
		 //GameGui Gui = new GameGui();
        // System.out.println("Running the game");
      
        // // Creates board and path
        // System.out.println("\nCreating The Board");
        // var path = PathGenerator.create10by10EasyPath();
      
        // Board board = new Board.BoardBuilder().setBoardSize(10, 10).setPathCell(path).build();

        // // var iterator = board.getPath();
        // // while (iterator.hasNext()) {
        // //     System.out.printf("path cell is %s %n", iterator.next().toString());
        // // }
        // // board.displayBoard();
        // // System.out.println(board.toString());

        // // Creates towers and enemies based on enemies
        // System.out.println("\nCreating enemies and towers");
        // AbstractFactory<Tower> towerFactory = new TowerFactory();
        // AbstractFactory<Enemy> enemyFactory = new EnemyFactory();
        // Tower tower1 = towerFactory.createProduct("strongtower",board.getCell(0,0));
        // Tower tower2 = towerFactory.createProduct("weaktower",board.getCell(0,0));
        // EnemyPrototype enemy1 = enemyFactory.createProduct("slowenemy",board.getCell(2,1));
        // EnemyPrototype enemy2 = enemyFactory.createProduct("fastenemy",board.getCell(0,0));

        // // Testing Attack
        // tower1.attack();


        // CellComposite towersAndEnemies = new CellComposite();
        // towersAndEnemies.add(tower1);
        // towersAndEnemies.add(tower2);
        // towersAndEnemies.add(enemy1);
        // towersAndEnemies.add(enemy2);
        // System.out.println(tower1.toString());

        // // Draws all enemies and towers
        // System.out.println("\nDrawing all components");
        // towersAndEnemies.draw();

        // // Draws all compenents on specific cells
        // System.out.println("\nDrawing all components on Cell(0,0)");
        // board.getCell(0,0).draw();
        // System.out.println("\nDrawing all components on Cell(2,1)");
        // board.getCell(2,1).draw();
        // System.out.println("\nDrawing all components on Cell(1,1)");
        // board.getCell(1,1).draw();

        // // Testing Tower Decorated
        // System.out.println("\nTower Decorator");
        // System.out.println(tower1.toString());
        // tower1 = new DamageDecorator(tower1, 5);
        // System.out.println(tower1.toString());

        // // Testing Enemy Prototype
        // System.out.println("\nEnemy Prototype");
        // System.out.println(enemy1.toString());
        // enemy1 = new HealthDecorator(enemy1, 1.1);
        // System.out.println(enemy1.toString());
        // enemy1 = new HealthDecorator(enemy1, 1.1);
        // System.out.println(enemy1.toString());

        // System.out.println("\nCloning Enemy");
        // EnemyPrototype enemy3 = enemy1.clone();
        // System.out.println(enemy3.toString());

        // System.out.print("\nExiting the game");

    }
}