/**
 * This class specifies the framework for tower.
 * Enemies will additionally contain damage (how much health it can take away from enemy) 
 * and range (how far it can reach enemies) attributes.
 */
public abstract class Tower extends CellObject {
    private double damage;
    private double speed;
    private int range;

    /**
     * This method will inflict damage to enemy
     */
    protected abstract void shoot();

    /**
     * This method will stall the tower before shooting again
     */
    protected abstract void reload();

    /* Returns damage*/
    public abstract double getDamage();

    /* Returns range */
    public abstract int getRange();

    /* Returns speed*/
    public abstract double getSpeed();

    /* sets the damage*/
    public abstract void setDamage(double newDamage);

    /* sets the attack range */
    public abstract void setRange(int newRange);

    /* sets the attack speed */
    public abstract void setSpeed(double newSpeed);

    /**
     * This method will have the tower continously shoot enemies
     */
    public void attack() {
        shoot();
        reload();
    }

    /**
     * Returns hash code
     */
    public int hashCode(){
        int hash = 0;
        hash += (this.damage == null ? Double(this.damage).hashCode():0);
        hash += (this.range == null ? this.range):0);
        hash += (this.speed == null ? this.speed:0);
        hash += (this.position == null ? this.position.hashCode():0);
        return hash;
    }
    
    /**
     * Compare objects based on damage, range, and speed
     * @param Object to compare
     */
    public boolean equals(Object other){
        if (other == null) {return false;}
        else if (this == other) {return true;}
        else if (other instanceof Tower){
            Cell otherObj = (Tower) other;
            if (this.getRange() == otherObj.getRange() && this.getDamage() == otherObj.getDamage() && this.getSpeed() == otherObj.getSpeed()){
                return true;
            }
        }
        else {return false;}
    }

    /**
     * Returns object as string representation.
     */
    public String toString(){
        String returnString = "Tower at: x: " + this.Cell.getX() + " y: " + this.Cell.getY(); 
        returnString = returnString + " Damage: " + this.damage;
        returnString = returnString + " Range: " + this.range;
        returnString = returnString + " Speed: " + this.speed;
        return returnString;
    }
}