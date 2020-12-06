import src.abstractfactory.AbstractFactory;
import src.abstractfactory.EnemyFactory;
import src.board.Board;
import src.board.PathGenerator;
import src.cell.CellComposite;
import src.cell.enemy.Enemy;
import src.cell.enemy.EnemyPrototype;
import src.cell.enemy.SlowEnemy;

public class Game {
    public static void play(){

        // Creates board and path
        System.out.println("\nCreating The Board");
        var path = PathGenerator.create10by10EasyPath();
      
        Board.BoardBuilder boardBuilder = new Board.BoardBuilder().setBoardSize(10, 10).setPathCell(path).setGold(10000);
        Board board = Board.getBoardInstance(boardBuilder);

        GameGui gamePlay = new GameGui(board);
        
        gamePlay.setxBox(gamePlay.getxCanvas()/board.getRows());
        gamePlay.setyBox(gamePlay.getyCanvas()/board.getColumns());
        AbstractFactory<Enemy> enemyFactory = new EnemyFactory();
//        EnemyPrototype enemy1 = enemyFactory.createProduct("slowenemy",board.getCell(2,1));
//        EnemyPrototype enemy2 = enemyFactory.createProduct("fastenemy",board.getCell(0,0));
        SlowEnemy enemy = new SlowEnemy(board.getPath());
//        AbstractFactory<Tower> towerFactory = new TowerFactory();
//        Tower tower = towerFactory.createProduct("weaktower", board.getCell(2,1), board.getPath().getCellPathIterator());
        gamePlay.drawBoard(board.displayBoard());
//        CellComposite towers = new CellComposite();
//        towers.add(towerFactory.createProduct("weaktower", board.getCell(2,2), board.getPath().getCellPathIterator()));
//        towers.add(towerFactory.createProduct("strongtower", board.getCell(1,9), board.getPath().getCellPathIterator()));
        CellComposite enemies = new CellComposite();
        enemies.add(enemy.clone());
        enemies.add(enemy.clone());
        enemies.add(enemy.clone());
        enemies.add(enemy.clone());
        enemies.add(enemy.clone());
        enemies.add(enemy.clone());
//        towers.add(tower);
//        while (board.getHealth() > 0) {
        while (true) {
            try {
                for (int i =0; i<enemies.getSubComponents().size(); i++){
                    ((EnemyPrototype)enemies.getSubComponentAtIndex(i)).move();
                }

                for (var tower : board.getTowerList()) tower.attack();
                
                // System.out.println(enemy.getHealth());
                System.out.println(enemy.toString());
                gamePlay.drawBoard(board.displayBoard());
                gamePlay.createInfoPanel();
                Thread.sleep(2000);
                System.out.println("=================================");
                System.out.println("");
                System.out.println("");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
//        System.out.println("GAME OVER");


        // gamePlay.drawBox(gamePlay.getJPanel(), 1, 1);
    }
}