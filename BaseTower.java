/**
 * This class specifies the framework for tower template pattern.
 * Strong and weak tower classes will build off of this and provide implementation
 */
public abstract class BaseTower extends Tower{
    public BaseTower(Cell cell){
        super(cell);
        this.speed = 3;
        this.reloadLeft = 0;
    }

    /**
    * This method will inflict damage to enemy
    */
    @Override
    public void shoot() { 
        
    }

    /**
    * This method will stall the tower before shooting again
    */
    @Override
    public void reload() { 
        
    }

    /**
    * Returns hash code
    */
    public int hashCode(){
        int hash = 0;
        hash += (this.damage == 0 ? 0: Double.valueOf(this.damage).hashCode());
        hash += this.range;
        hash += (this.speed == 0 ? 0: Double.valueOf(this.speed).hashCode());
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

    /** 
    * Returns damage
    */
    @Override
    public double getDamage(){
        return this.damage;
    }

    /** 
    * Returns range 
    */
    @Override
    public int getRange(){
        return this.range;
    }

    /**
    * Returns speed
    */
    @Override
    public double getSpeed(){
        return this.speed;
    }

    /** 
    * Returns reloadLeft
    */
    @Override
    public double getReloadLeft(){
        return this.reloadLeft;
    }
    
    /* sets the damage
    * @param newDamage is used to replace previous tower damage value
    */
    @Override
    public void setDamage(double newDamage){
        this.damage = newDamage;
    }

    /* sets the attack range 
    * @param newRange is used to replace previous tower range value
    */
    @Override
    public void setRange(int newRange){
        this.range = newRange;
    }

    /* sets the attack speed 
    * @param newSpeed is used to replace previous tower speed value
    */
    @Override
    public void setSpeed(double newSpeed){
        this.speed = newSpeed;
    }

    /* sets the reload left
    * @param newReloadLeft is used to replace previous tower reload time left
    */
    @Override
    public void setReloadLeft(double newReloadLeft){
        this.reloadLeft = newReloadLeft;
    }

}