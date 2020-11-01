/**
 * This class specifies the framework for enemy.
 * Enemies will additionally contain health.
 */
public abstract class Enemy extends CellObject{

    private double health;

    /**
     * This method will allow the object to move from current cell to another
     */
    public abstract void move();

    /**
     * Returns health
     */
    public int getHealth(){
        return this.health;
    }

    /**
     * Returns hash code
     */
    public int hashCode(){
        int hash = 0;
        hash += (this.health == null ? Double(this.health).hashCode():0);
        hash += (this.speed == null ? this.speed:0);
        hash += (this.position == null ? this.position.hashCode():0);
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
            Cell otherObj = (Enemy) other;
            if (this.getHealth() == otherObj.getHealth() &&  this.getSpeed() == otherObj.getSpeed()){
                return true;
            }
        }
        else {return false;}
    }

    /**
     * Returns object as string representation.
     */
    public String toString(){
        String returnString = "Enemy at: x: " + this.Cell.getX() + " y: " + this.Cell.getY(); 
        returnString = returnString + " Health: " + this.health;
        returnString = returnString + " Speed: " + this.speed;
        return returnString;
    }
}