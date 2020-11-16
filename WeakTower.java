/**
 * This class implements weak tower
 */

public class WeakTower extends BaseTower {

    public WeakTower(Cell cell){
        super(cell);
        this.damage = 1;
    }
    
    
    /**
     * This method will shoot enemy when fully realoaded.
     * Strong tower has 10% chance to shoot again
     */
    @Override
    public void shoot() {
        System.out.println("Weak tower shoots");
        this.setReloadLeft(this.getSpeed());
    }
    /**
     * Draws tower as blue box
     */
    @Override
    public void draw(){
        System.out.println("Blue Box on " + position.getLocation());
    }
}
