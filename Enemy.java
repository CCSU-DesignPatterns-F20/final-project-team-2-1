/**
 * This class specifies the framework for enemy.
 * Enemies will additionally contain health.
 */
public abstract class Enemy extends CellComponent{

    protected double health;
    protected int speed;

    public Enemy(Cell cell){
        super(cell);
        this.health = 5;
    }

    /**
     * This method will allow the object to move from current cell to another
     */
    public abstract void move();

    /**
     * Returns hash code based on health and speed
     */
    public int hashCode(){
        int hash = 0;
        hash += (this.health == 0 ? 0: Double.valueOf(this.health).hashCode());
        hash += (this.speed == 0 ? 0: Double.valueOf(this.speed).hashCode());
        return hash;
    }
    
    /**
     * Compare objects based on health and speed
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
        returnString = returnString + " Health: " + this.health;
        returnString = returnString + " Speed: " + this.speed;
        return returnString;
    }

    /* Returns Health*/
    public double getHealth(){
        return this.health;
    }

    /* 
    * sets the enemy health
    * @param newHealth is used to replace previous tower health value
    */
    public void setHealth(double newHealth){
        this.health = newHealth;
    }

    /* Returns speed*/
    public double getSpeed(){
        return this.speed;
    }

    /* 
    * sets the attack speed 
    * @param newSpeed is used to replace previous tower speed value
    */
    public void setSpeed(int newSpeed){
        this.speed = newSpeed;
    }


}