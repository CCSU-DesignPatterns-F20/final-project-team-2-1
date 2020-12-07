package src.cell.enemy;

import src.board.iterator.CellList;
import src.cell.Cell;

/**
 * This class specifies the framework for enemy.
 * Enemies will additionally contain health.
 */
public abstract class Enemy extends EnemyPrototype{

    /**
     * Creates enemy
     * @param Path Iterator List
     */
    public Enemy(CellList<Cell> cellPath){
        this.health = 2;
        this.pathCellList = cellPath;
        this.cellPathIterator = this.pathCellList.getCellPathIterator();
    }

    /**
     * Copies attributes from a clone into a new instance
     * @param Enemy to be cloned from
     */
    public Enemy(EnemyPrototype clone){
        this.cellPathIterator = clone.pathCellList.getCellPathIterator();
        this.health = clone.getHealth();
        this.speed = clone.getSpeed();
        this.health = clone.getHealth();
    }

    /**
     * This method will allow the object to move from current cell to another
     */
    public boolean move(){
        if (this.cellPathIterator.hasNext())
        {
            if (this.position != null)
                this.position.remove(this);
            setPosition(this.cellPathIterator.next());

            return true;
        }
        else
        {
            this.removeIfFinishPath();
            return false;
        }
    }

    /**
    * Returns Health
    */
    public double getHealth(){
        return this.health;
    }

    /** 
    * sets the enemy health
    * @param newHealth is used to replace previous tower health value
    */
    public void setHealth(double newHealth){
        this.health = newHealth;
    }

    /**
    * Returns Speed
    */
    public double getSpeed(){
        return this.speed;
    }

    /** 
    * Sets the attack speed 
    * @param newSpeed is used to replace previous tower speed value
    */
    public void setSpeed(int newSpeed){
        this.speed = newSpeed;
    }


}