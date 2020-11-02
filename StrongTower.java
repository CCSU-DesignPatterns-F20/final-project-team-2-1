/**
 * This class implements strong tower
 */
public class StrongTower extends BaseTower {

    public StrongTower(Cell cell){
        super(cell);
    }

    /**
     * Deals damage to enemy
     */
    @Override
    public void shoot() {
        System.out.println("Strong tower shoot strong");
    }

    /**
     * Waits before shooting again
     */
    @Override
    public void reload() {
        System.out.println("Strong tower reload fast");
    }
    
}
