/**
 * This class specifies the framework for enemy.
 * Enemies will additionally contain health.
 */
public abstract class EnemyPrototype extends CellComponent implements Cloneable {

    protected double health;
    protected double speed;

    public EnemyPrototype(Cell cell){
        super(cell);
    }

    /**
     * This method will allow the object to move from current cell to another
     */
    public abstract void move();

    /** Returns health */
    public abstract double getHealth();

     /** Returns health */
    public abstract void setHealth(double newHealth);

    /* This method will be used to clone/create copies of enemy objects */
    public abstract EnemyPrototype clone();

    /* Returns speed*/
    public double getSpeed(){
        return speed;
    }

    /* Sets new speed */
    public void setSpeed(double newSpeed){
        this.speed = newSpeed;
    }

    /**
     * Returns hash code
     */
    public int hashCode(){
        int hash = 0;
        hash += (this.health == 0 ? 0: Double.valueOf(this.health).hashCode());
        hash += (this.speed == 0 ? 0: Double.valueOf(this.speed).hashCode());
        hash += (this.position == null ? 0 : this.position.hashCode());
        return hash;
    }
    
    /**
     * Compare objects based on health, speed
     * @param Object to compare
     */
    public boolean equals(Object other){
        if (other == null) {return false;}
        else if (this == other) {return true;}
        else if (other instanceof Enemy){
            Enemy otherObj = (Enemy) other;
            if (this.getHealth() == otherObj.getHealth() &&  this.getSpeed() == otherObj.getSpeed()){
                return true;
            }
        }
        return false;
    }

    /**
     * Returns object as string representation.
     */
    public String toString(){
        String returnString = "Enemy at: x: " + this.position.getX() + " y: " + this.position.getY(); 
        returnString = returnString + " Health: " + this.getHealth();
        returnString = returnString + " Speed: " + this.speed;
        return returnString;
    }

}