/**
 * This class specifies the framework for tower template pattern.
 * Strong and weak tower classes will build off of this and provide implementation
 */
public abstract class BaseTower extends Tower{
    private double damage;
    private double speed;
    private int range;

    /**
     * This template method will have the tower continously shoot enemies
     */
     @Override
    public abstract void attack() { 
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