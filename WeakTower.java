/**
 * This class implements weak tower
 */
public class WeakTower extends BaseTower {


    public WeakTower(Cell cell){
        super(cell);
    }
    
    /**
     * Deals damage to enemy
     */
    @Override
    public void shoot() {
        System.out.println("Weak tower shoot slow");
    }

    /**
     * Waits before shooting again
     */
    @Override
    public void reload() {
        System.out.println("Weak tower reload slow");
    }
}
