/**
 * This class specifies how to create enemies
 */
public class EnemyFactory implements AbstractFactory {

    /**
     * This class will create and return a specific enemy. Slow enemy is default.
     * @param String to tell which enemy to create
     */
    @Override
    public CellComponent createProduct(String enemy) {
        if (enemy.equalsIgnoreCase("slowenemy"))
            return new SlowEnemy();
        else if (enemy.equalsIgnoreCase("fastenemy"))
            return new FastEnemy();
        else
            return new SlowEnemy();
    }

}
