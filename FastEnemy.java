/**
 * This class implements fast enemy
 */
public class FastEnemy extends Enemy {

    public FastEnemy(Cell cell){
        super(cell);
        this.speed = 5;
    }
    
    /**
    * Regenerate .5% of heath and moves the enemy
    */
    @Override
    public void move() {
        this.setHealth(this.getHealth() * 1.005);
        System.out.println("fast enemy move fast");
    }

    /**
    * Draws fast enemy as red box
    */
    @Override
    public void draw() {
        System.out.println("Red Box on " + this.position.getLocation());
    }

}