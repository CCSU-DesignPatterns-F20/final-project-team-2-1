import src.abstractfactory.AbstractFactory;
import src.abstractfactory.EnemyFactory;
import src.board.Board;
import src.board.PathGenerator;
import src.cell.enemy.Enemy;
import src.cell.enemy.EnemyPrototype;

public class Game {
    public static void play(){
        GameGui gamePlay = new GameGui();
        // Creates board and path
        System.out.println("\nCreating The Board");
        var path = PathGenerator.create10by10EasyPath();
      
        Board board = new Board.BoardBuilder().setBoardSize(10, 10).setPathCell(path).build();
        
        gamePlay.setxBox(gamePlay.getxCanvas()/board.getRows());
        gamePlay.setyBox(gamePlay.getyCanvas()/board.getColumns());
        AbstractFactory<Enemy> enemyFactory = new EnemyFactory();
        EnemyPrototype enemy1 = enemyFactory.createProduct("slowenemy",board.getCell(2,1));
        EnemyPrototype enemy2 = enemyFactory.createProduct("fastenemy",board.getCell(0,0));
        gamePlay.drawBoard(board.displayBoard());
        enemy1.move();
        gamePlay.drawBoard(board.displayBoard());
        // gamePlay.drawBox(gamePlay.getJPanel(), 1, 1);
    }
}