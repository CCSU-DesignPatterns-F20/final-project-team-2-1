/**
 * This class specifies the framework for enemy.
 * Enemies will additionally contain health.
 */
public abstract class Enemy extends EnemyPrototype{

    private double health;

    public Enemy(Cell cell){
        this.position = cell;
        this.speed = 1;
    }

    /**
     * This method will allow the object to move from current cell to another
     */
    public abstract void move();

    /* This method will be used to clone/create copies of enemy objects */
    public Enemy clone();

    /* Returns speed*/
    public double getSpeed(){
        return speed;
    }

    /* sets the attack speed 
    * @param newSpeed is used to replace previous tower speed value
    */
    public void changeSpeed(double newSpeed){
        this.speed = newSpeed;
    }
}