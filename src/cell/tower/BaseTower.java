package src.cell.tower;

import src.board.iterator.IteratorInterface;
import src.cell.Cell;
import src.cell.enemy.EnemyPrototype;

/**
 * This class specifies the framework for tower template pattern.
 * Strong and weak tower classes will build off of this and provide implementation
 */
public abstract class BaseTower extends Tower{

    /**
     * Initialize BaseTower's attributes
     * @param Position for the CellComponent
     * @param Path list
     */
    public BaseTower(Cell cell, IteratorInterface<Cell> cellPathIterator){
        super(cell);
        this.speed = 3;
        this.range = 1;
        this.setRangeCells(cellPathIterator);
        this.reloadLeft = 0;
    }

    /**
     * This method will find an enemy and shoot it 
     */
    @Override
    public void attack() {
        for (Cell cell : this.rangeCells) {
            if (!cell.getSubComponents().isEmpty()) {
                System.out.println("Enemy is found");
                EnemyPrototype enemy = (EnemyPrototype) cell.getSubComponentAtIndex(0);
                this.shoot(enemy);
                enemy.removeIfDead();
                break;
            };
        }
    }

    /**
    * This method will inflict damage to an enemy
    */
    public abstract void shoot(EnemyPrototype enemy);
    
    /**
    * This method will stall the tower before shooting again
    */
    @Override
    public void reload() {}

    /** 
    * Returns damage
    */
    @Override
    public int getDamage(){
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
    
    /** 
    * sets the damage
    * @param newDamage is used to replace previous tower damage value
    */
    @Override
    public void setDamage(int newDamage){
        this.damage = newDamage;
    }

    /** sets the attack range 
    * @param newRange is used to replace previous tower range value
    */
    @Override
    public void setRange(int newRange){
        this.range = newRange;
    }

    /** sets the attack speed 
    * @param newSpeed is used to replace previous tower speed value
    */
    @Override
    public void setSpeed(double newSpeed){
        this.speed = newSpeed;
    }

    /** sets the reload left
    * @param newReloadLeft is used to replace previous tower reload time left
    */
    @Override
    public void setReloadLeft(double newReloadLeft){
        this.reloadLeft = newReloadLeft;
    }

}