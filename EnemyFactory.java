/**
 * This class specifies how to create enemies
 */
public class EnemyFactory implements AbstractFactory<Enemy> {

    /**
     * This class will create and return a specific enemy. Slow enemy is default.
     * @param String to tell which enemy to create
     */
    @Override
    public Enemy createProduct(String enemy, Cell cell) {
        if (enemy.equalsIgnoreCase("slowenemy"))
            return new SlowEnemy(cell);
        else if (enemy.equalsIgnoreCase("fastenemy"))
            return new FastEnemy(cell);
        else
            return new SlowEnemy(cell);
    }

}
