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
     */
    @Override
    public void attack() {
        if (this.getReloadLeft() <= 0){
            this.shoot();
            this.setReloadLeft(this.getSpeed());
        }
        else{
            this.reload();
        }
    }

    /**
     * Draws tower as blue box
     */
    @Override
    public void draw(){
        System.out.println("Blue Box on " + position.getLocation());
    }
}
