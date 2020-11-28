package src.cell.enemy;

import src.cell.Cell;

/**
 * This class implements fast enemy
 */
public class FastEnemy extends Enemy {

    public FastEnemy(Cell cell){
        super(cell);
        this.speed = 5;
    }

    public FastEnemy(Enemy clone){
        super(clone);
    }


    /**
    * Clones the enemy instance
    */
    @Override
    public FastEnemy clone(){
        return new FastEnemy(this);
    }

    /**
    * Draws fast enemy as red box
    */
    @Override
    public void draw() {
        System.out.println("Red Box on " + this.position.getLocation());
    }

}