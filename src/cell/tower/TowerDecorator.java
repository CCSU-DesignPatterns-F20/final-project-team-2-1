package src.cell.tower;

import java.awt.Color;

import src.cell.enemy.EnemyPrototype;
/**
 * This class implements tower.
 * Used for decorator pattern to modify tower attributes
 */
public abstract class TowerDecorator extends Tower{
   protected final Tower decoratedTower;

   public TowerDecorator(Tower decoratedTower){
        super(decoratedTower.getPosition());
        this.decoratedTower = decoratedTower;
    }

    /**
     * This method will have the tower continously shoot enemies
     */
    @Override
    public void attack(){
        this.decoratedTower.attack();
    }

    /**
     * This method will inflict damage to enemy
     */
    @Override
    public void shoot(EnemyPrototype enemy){
        this.decoratedTower.shoot(enemy);
    }

    /**
     * This method will stall the tower before shooting again
     */
    @Override
    public void reload(){
        this.decoratedTower.reload();
    }

    /* Returns damage*/
    @Override
    public int getDamage(){
        return this.decoratedTower.getDamage();
    }

    /* Returns range */
    @Override
    public int getRange(){
        return this.decoratedTower.getRange();
    };

    /* Returns speed*/
    @Override
    public double getSpeed(){
        return this.decoratedTower.getSpeed();
    };

    /* Returns reloadLeft*/
    @Override
    public double getReloadLeft(){
        return this.decoratedTower.getReloadLeft();
    }

    /* sets the damage
    * @param newDamage is used to replace previous tower damage value
    */
    @Override
    public void setDamage(int newDamage){
        this.decoratedTower.setDamage(newDamage);
    }

    /* sets the attack range 
    * @param newRange is used to replace previous tower range value
    */
    @Override
    public void setRange(int newRange){
        this.decoratedTower.setRange(newRange);
    }

    /* sets the reload time left 
    * @param newReloadLeft is used to replace previous tower reloadLeft value
    */
    @Override
    public void setReloadLeft(double newReloadLeft){
        this.decoratedTower.setReloadLeft(newReloadLeft);
    }

    /* sets the attack speed 
    * @param newSpeed is used to replace previous tower speed value
    */
    public void setSpeed(double newSpeed){
        this.decoratedTower.setSpeed(newSpeed);
    }
    /**
     * Draws enemy according to its type
     */
    @Override
    public Color draw() {
        return this.decoratedTower.draw();
    }

    /**
    * Returns hash code
    */
//    public int hashCode(){
//        return this.decoratedTower.hashCode();
//    }
    
    /**
    * Compare objects based on enemy's equals implemention
    * @param Object to compare
    */
//    public boolean equals(Object other){
//        return this.decoratedTower.equals(other);
//    }

}