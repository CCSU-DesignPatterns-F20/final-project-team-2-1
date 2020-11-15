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
    public void shoot() {
        Random  r = new Random(); 
        System.out.println("Strong tower shoots");
        int roll = r.nextInt();
        double max = .10;
        System.out.println(max + " " + roll);
        if (roll < max){
            System.out.println("Strong tower shoots again");
        }
        this.setReloadLeft(this.getSpeed());
    }

    /**
     * Draws strong tower as purple box
     */
    @Override
    public void draw(){
        System.out.println("Purple Box on " + position.getLocation());
    }
    
}
