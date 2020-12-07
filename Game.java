import java.util.ArrayList;

import src.board.Board;
import src.board.PathGenerator;
import src.cell.enemy.EnemyPrototype;

public class Game {
    public static void play() {
        // Creates board and path
        System.out.println("\nCreating The Board");
        var path = PathGenerator.create10by10EasyPath();
        Board.BoardBuilder boardBuilder = new Board.BoardBuilder().setBoardSize(10, 10).setPathCell(path)
                .setGold(10000).setWaveNum(0).setEnemyHealth(0).setTowerDamage(null);
        Board board = Board.getBoardInstance(boardBuilder);
        GameGui gamePlay = new GameGui(board);
        gamePlay.drawBoard(board.displayBoard());
        ArrayList<EnemyPrototype> enemyWave = new ArrayList<EnemyPrototype>();
        var enemies = Board.getBoardInstance().getEnemyList();
        while (board.getBoardInstance().getHealth() > 0){
            try {
                if (!enemyWave.isEmpty()) {
                    enemies.add(enemyWave.get(0));
                    enemyWave.remove(0);
                }
                for (int i = 0; i < enemies.size(); i++) {
                    enemies.get(i).move();
                }

                gamePlay.drawBoard(board.displayBoard());

                for (var tower : board.getTowerList())
                    tower.attack();

                gamePlay.drawBoard(board.displayBoard());
                gamePlay.createInfoPanel();

                System.out.println("The size of enemy wave is " + enemyWave.size());
                System.out.println("The size of enemies on board is: " + enemies.size());

                if (enemyWave.isEmpty() && enemies.isEmpty()) {
                    enemyWave = Board.getBoardInstance().createNewWave();
                    System.out.println("WAVE IS CREATED!!!!");
                }
                Thread.sleep(1000);
                System.out.println("=================================");
                System.out.println("");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("GAME OVER");
    }

}