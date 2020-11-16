/**
 * This class implements fast enemy
 */
public class FastEnemy extends Enemy {

    public FastEnemy(Cell cell){
        super(cell);
        this.speed = 5;
    }

    /**
    * Clones the enemy instance
    */
    @Override
    public FastEnemy clone(){
        return new FastEnemy(this.position);
    }

    /**
    * Draws fast enemy as red box
    */
    @Override
    public void draw() {
        System.out.println("Red Box on " + this.position.getLocation());
    }

}