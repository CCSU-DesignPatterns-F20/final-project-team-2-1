package src.abstractfactory;

import src.board.iterator.CellList;
import src.board.iterator.IteratorInterface;
import src.cell.Cell;
import src.cell.enemy.Enemy;
import src.cell.enemy.FastEnemy;
import src.cell.enemy.SlowEnemy;

/**
 * This class specifies how to create enemies
 */
public class EnemyFactory implements AbstractFactory<Enemy> {

    /**
     * This class will create and return a specific enemy. Slow enemy is default.
     * @param enemy to tell which enemy to create
     * @param cellPath for enemy to move.  
     */
    @Override
    public Enemy createProduct(String enemy, CellList<Cell> cellPath) {
        if (enemy.equalsIgnoreCase("slowenemy"))
            return new SlowEnemy(cellPath);
        else if (enemy.equalsIgnoreCase("fastenemy"))
            return new FastEnemy(cellPath);
        else
            return new SlowEnemy(cellPath);
    }

    /**
     * @param cellObject specifiy the object on the cell
     * @param cell is the cell of the game board.
     * @param pathCellIterator the iterator that iterates through the cell.
     * @return null by default
     */
    @Override
    public Enemy createProduct(String cellObject, Cell cell, IteratorInterface<Cell> pathCellIterator) {
        return null;
    }

}
