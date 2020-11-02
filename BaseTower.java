/**
 * This class specifies the framework for tower template pattern.
 * Strong and weak tower classes will build off of this and provide implementation
 */
public abstract class BaseTower extends Tower{
    private double damage;
    private double speed;
    private int range;

    public BaseTower(Cell cell){
        super(cell);
        this.speed = 3;
    }

    /**
     * This template method will have the tower continously shoot enemies
     */
     @Override
    public void attack() { 
        shoot();
        reload();
    }


    /**
     * Returns hash code
     */
    public int hashCode(){
        int hash = 0;
        hash += (this.damage == 0 ? 0: Double.valueOf(this.damage).hashCode());
        hash += this.range;
        hash += (this.speed == 0 ? 0: Double.valueOf(this.speed).hashCode());
        hash += (this.position == null ? 0 : this.position.hashCode());
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
            Tower otherObj = (Tower) other;
            if (this.getRange() == otherObj.getRange() && this.getDamage() == otherObj.getDamage() && this.getSpeed() == otherObj.getSpeed()){
                return true;
            }
        }
        return false;
    }

    /**
     * Returns object as string representation.
     */
    public String toString(){
        String returnString = "Tower at: x: " + this.position.getX() + " y: " + this.position.getY(); 
        returnString = returnString + " Damage: " + this.damage;
        returnString = returnString + " Range: " + this.range;
        returnString = returnString + " Speed: " + this.speed;
        return returnString;
    }

    /* Returns damage*/
    public double getDamage(){
        return damage;
    }

    /* Returns range */
    public int getRange(){
        return range;
    }

    /* Returns speed*/
    public double getSpeed(){
        return speed;
    }

    /* sets the damage
    * @param newDamage is used to replace previous tower damage value
    */
    public void setDamage(double newDamage){
        this.damage = newDamage;
    }

    /* sets the attack range 
    * @param newRange is used to replace previous tower range value
    */
    public void setRange(int newRange){

    }

    /* sets the attack speed 
    * @param newSpeed is used to replace previous tower speed value
    */
    public void setSpeed(double newSpeed){
        this.speed = newSpeed;
    }

    /* sets the attack speed 
    * @param newSpeed is used to replace previous tower speed value
    */
    public void changeSpeed(double newSpeed){
        setSpeed(newSpeed);
    }
}