/**
 * This class implements weak tower
 */
public class WeakTower extends BaseTower {
    @Override
    protected void shoot() {
        System.out.println("Weak tower shoot slow");
    }

    @Override
    protected void reload() {
        System.out.println("Weak tower reload slow");
    }
}
