/**
 * This class implements fast enemy
 */
public class FastEnemy extends Enemy {

    public FastEnemy(Cell cell){
        super(cell);
        this.speed = 5;
    }

    @Override
    /**
     * Regenerate .5% of heath and moves the enemy
     */
    public void move() {
        // TODO Auto-generated method stub
        this.setHealth(this.getHealth() * 1.005);
        System.out.println("fast enemy move fast");
    }

    @Override
    /**
     * Draws fast enemy as red box
     */
    public void draw() {
        System.out.println("Red Box on " + this.position.getLocation());
    }

}