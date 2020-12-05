package src.cell.enemy;

import src.board.iterator.CellList;
import src.board.iterator.IteratorInterface;
import src.cell.Cell;

/**
 * This class specifies the framework for enemy.
 * Enemies will additionally contain health.
 */
public abstract class Enemy extends EnemyPrototype{

    public Enemy(IteratorInterface cellPathIterator){
        this.health = 10;
        this.cellPathIterator = cellPathIterator;
    }

    public Enemy(Enemy clone){
        this.cellPathIterator = clone.getCellPathIterator().clone();
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
            System.out.printf("Enemy is moving to %s\n", this.position.toString());
            return true;
        }
        return false;
    }

    /**
    * Returns Health
    */
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

    /**
    * Returns Speed
    */
    public double getSpeed(){
        return this.speed;
    }

    /* 
    * Sets the attack speed 
    * @param newSpeed is used to replace previous tower speed value
    */
    public void setSpeed(int newSpeed){
        this.speed = newSpeed;
    }


}