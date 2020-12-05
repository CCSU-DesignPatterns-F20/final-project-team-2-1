package src.cell.tower;

import java.util.ArrayList;

import src.board.iterator.IteratorInterface;
import src.cell.Cell;
import src.cell.CellComponent;

/**
 * This class specifies the framework for tower.
 * Enemies will additionally contain damage (how much health it can take away from enemy) 
 * and range (how far it can reach enemies) attributes.
 */
public abstract class Tower extends CellComponent {
    protected double damage;
    protected double speed;
    protected double reloadLeft;
    protected int range;
    protected ArrayList<Cell> rangeCells;

    public Tower(Cell cell){
        super(cell);
    }

    public void setRangeCells(IteratorInterface<Cell> cellPathIterator){
        ArrayList<Cell> newRangeCells = new ArrayList<Cell>();
        while (cellPathIterator.hasNext()){
            Cell cell = cellPathIterator.next();
            if (Math.abs(cell.getX() - this.position.getX()) <= this.range){
                if (Math.abs(cell.getY() - this.position.getY()) <= this.range){
                    newRangeCells.add(cell);
                }
            }
        }
        this.rangeCells = newRangeCells;
    }

    public void printRange(){
        System.out.println(toString());
        for (Cell k:rangeCells){
            if (k.getSubComponents().size() == 0){
                System.out.println("Nothing in Range");
            }
            else{
                System.out.println("I see");
                k.printAllComponenents();
            }
            
        }
    }

    /**
     * This method will have the tower continously shoot enemies
     */
    public abstract void attack();

    /**
     * This method will inflict damage to enemy
     */
    public abstract void shoot();

    /**
     * This method will stall the tower before shooting again
     */
    public abstract void reload();

    /* Returns damage*/
    public abstract double getDamage();

    /* Returns range */
    public abstract int getRange();

    /* Returns speed*/
    public abstract double getSpeed();

    /* Returns reloadLeft*/
    public abstract double getReloadLeft();

    /* sets the damage
    * @param newDamage is used to replace previous tower damage value
    */
    public abstract void setDamage(double newDamage);

    /* sets the attack range 
    * @param newRange is used to replace previous tower range value
    */
    public abstract void setRange(int newRange);

    /* sets the attack speed 
    * @param newSpeed is used to replace previous tower speed value
    */
    public abstract void setSpeed(double newSpeed);

    /* sets the reload time left 
    * @param newReloadLeft is used to replace previous tower reloadLeft value
    */
    public abstract void setReloadLeft(double newReloadLeft);

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
        returnString = returnString + " Damage: " + this.getDamage();
        returnString = returnString + " Range: " + this.getRange();
        returnString = returnString + " Speed: " + this.getSpeed();
        return returnString;
    }

}