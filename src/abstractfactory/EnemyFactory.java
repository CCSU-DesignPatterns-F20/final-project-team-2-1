package src.abstractfactory;

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
     */
    @Override
    public Enemy createProduct(String enemy, IteratorInterface<Cell> pathCellIterator) {
        if (enemy.equalsIgnoreCase("slowenemy"))
            return new SlowEnemy(pathCellIterator);
        else if (enemy.equalsIgnoreCase("fastenemy"))
            return new FastEnemy(pathCellIterator);
        else
            return new SlowEnemy(pathCellIterator);
    }

    @Override
    public Enemy createProduct(String cellObject, Cell cell) {
        return null;
    }

}
