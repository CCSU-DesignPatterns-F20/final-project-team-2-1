/**
 * This class implements slow enemy
 */
public class SlowEnemy extends Enemy {

    public SlowEnemy(Cell cell){
        super(cell);
        this.speed = 1;
    }

    @Override
    /**
     * Moves the enemy
     */
    public void move() {
        // TODO Auto-generated method stub
        System.out.println("slow enemy move slow");
    }

    @Override
    /**
     * Draws slow enemy as orange box
     */
    public void draw() {
        System.out.println("Orange Box on " + this.position.getLocation());
    }

}