import java.util.ArrayList;

import src.abstractfactory.AbstractFactory;
import src.abstractfactory.EnemyFactory;
import src.board.Board;
import src.board.PathGenerator;
import src.cell.CellComposite;
import src.cell.enemy.Enemy;
import src.cell.enemy.EnemyPrototype;
import src.cell.enemy.FastEnemy;
import src.cell.enemy.HealthDecorator;
import src.cell.enemy.SlowEnemy;

public class Game {
    public static void play() {
        // Creates board and path
        System.out.println("\nCreating The Board");
        var path = PathGenerator.create10by10EasyPath();
        Board.BoardBuilder boardBuilder = new Board.BoardBuilder().setBoardSize(10, 10).setPathCell(path)
                .setGold(10000).setWaveNum(0).setEnemyHealth(0).setTowerDamage(null);
        Board board = Board.getBoardInstance(boardBuilder);

        GameGui gamePlay = new GameGui(board);

        gamePlay.setxBox(gamePlay.getxCanvas() / board.getRows());
        gamePlay.setyBox(gamePlay.getyCanvas() / board.getColumns());
        AbstractFactory<Enemy> enemyFactory = new EnemyFactory();
        SlowEnemy slowEnemy = new SlowEnemy(board.getPath());
        FastEnemy fastEnemy = new FastEnemy(board.getPath());
        gamePlay.drawBoard(board.displayBoard());
        ArrayList<EnemyPrototype> enemyWave = new ArrayList<EnemyPrototype>();
        var enemies = Board.getBoardInstance().getEnemyList();
        // for (int i=0; i<5; i++){
        // enemyWave.add(fastEnemy.clone());
        // }
        // towers.add(tower);
        // while (board.getHealth() > 0) {
        while (true) {
            try {
                if (!enemyWave.isEmpty()) {
                    enemies.add(enemyWave.get(0));
                    enemyWave.remove(0);
                    Board.getBoardInstance().setWaveNum(Board.getBoardInstance().getWaveNum() + 1);
                }
                for (int i = 0; i < enemies.size(); i++) {
                    // System.out.println("The health of enemy from enemy list is: " +
                    // ((EnemyPrototype)enemies.get(i)).getHealth();
                    ((EnemyPrototype) enemies.get(i)).move();
                    System.out.print("Enemy in enemy list object id is " + System.identityHashCode(enemies.get(i)));
                    if (enemies.get(i).getPosition() != null)
                        System.out.println(("The health of enemy from the cell list is: "
                                + System.identityHashCode(enemies.get(i).getPosition().getSubComponents().get(0))));

                    Board.getBoardInstance().setEnemyHealth(enemies.get(i).getHealth());
                    System.out.println("Enemy health is " + enemies.get(i).getHealth());
                }

                for (var tower : board.getTowerList())
                    tower.attack();

                // System.out.println(enemy.getHealth());
                // System.out.println(enemy.toString());
                gamePlay.drawBoard(board.displayBoard());
                gamePlay.createInfoPanel();
                System.out.println("The size of enemy wave is " + enemyWave.size());
                System.out.println("The size of enemies on board is: " + enemies.size());

                if (enemyWave.isEmpty() && enemies.isEmpty()) {
                    System.out.println("original slow enemy health is " + slowEnemy.getHealth());
                    enemyWave = Board.getBoardInstance().createNewWave();
                    System.out.println("WAVE IS CREATED!!!!");
                }
                Thread.sleep(1000);
                System.out.println("=================================");
                System.out.println("");
                System.out.println("");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // System.out.println("GAME OVER");

        // gamePlay.drawBox(gamePlay.getJPanel(), 1, 1);
    }

}