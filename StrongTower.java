/**
 * This class implements strong tower
 */

import java.util.Random;
public class StrongTower extends BaseTower {

    public StrongTower(Cell cell){
        super(cell);
        this.damage = 2.0;
    }

    /**
     * This method will shoot enemy when fully realoaded.
     * Strong tower has 10% chance to shoot again
     */
    @Override
    public void attack() {
        if (this.getReloadLeft() <= 0){
            this.shoot();
            Random  r = new Random(); 
            System.out.println("shoot1");
            int roll = r.nextInt();
            double max = .99;
            if (roll < max){
                this.shoot();
                System.out.println("shoot2");
            }
            this.setReloadLeft(this.getSpeed());
        }
        else{
            this.reload();
        }
    }


    /**
     * Draws strong tower as purple box
     */
    @Override
    public void draw(){
        System.out.println("Purple Box on " + position.getLocation());
    }
    
}
