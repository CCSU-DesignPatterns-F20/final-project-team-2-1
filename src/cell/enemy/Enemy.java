package src.cell.enemy;

import src.cell.Cell;

/**
 * This class specifies the framework for enemy.
 * Enemies will additionally contain health.
 */
public abstract class Enemy extends EnemyPrototype{

    public Enemy(Cell cell){
        super(cell);
        this.health = 5;
    }

    public Enemy(Enemy clone){
        super(clone.getPosition());
        this.health = clone.getHealth();
        this.speed = clone.getSpeed();
        this.health = clone.getHealth();
    }

    /**
     * This method will allow the object to move from current cell to another
     */
    public void move(){
        System.out.println("Enemy is moving for ya");
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