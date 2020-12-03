package src.cell.enemy;

import src.cell.Cell;

/**
 * This class implements slow enemy
 */
public class SlowEnemy extends Enemy {

    public SlowEnemy(Cell cell){
        super(cell);
        this.speed = 1;
    }
    
    /**
    * Clones the enemy instance
    */
    @Override
    public SlowEnemy clone(){
        return new SlowEnemy(this.position);
    }

    /**
    * Draws slow enemy as orange box
    */
    @Override
    public void draw() {
        System.out.println("Orange Box on " + this.position.getLocation());
    }

}