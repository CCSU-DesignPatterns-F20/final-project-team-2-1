public class EnemyFactory implements AbstractFactory {

    @Override
    public CellObject createProduct(String enemy) {
        if (enemy.equalsIgnoreCase("slowenemy"))
            return new SlowEnemy();
        else if (enemy.equalsIgnoreCase("fastenemy"))
            return new FastEnemy();
        else
            return new SlowEnemy();
    }

}
