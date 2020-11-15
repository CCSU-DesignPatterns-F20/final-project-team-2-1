/**
 * This class implements slow enemy
 */
public class SlowEnemy extends Enemy {

    public SlowEnemy(Cell cell){
        super(cell);
        this.speed = 1;
    }
    
    /**
     * Moves the enemy
     */
    @Override
    public void move() {
        System.out.println("slow enemy move slow");
    }

    /**
    * Draws slow enemy as orange box
    */
    @Override
    public void draw() {
        System.out.println("Orange Box on " + this.position.getLocation());
    }

}