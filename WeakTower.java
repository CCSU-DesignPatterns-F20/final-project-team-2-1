/**
 * This class implements weak tower
 */
public class WeakTower extends Tower {
    @Override
    protected void shoot() {
        System.out.println("Weak tower shoot slow");
    }

    @Override
    protected void reload() {
        System.out.println("Weak tower reload slow");
    }
}
