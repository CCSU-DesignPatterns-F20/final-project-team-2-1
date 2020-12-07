package src.cell.enemy;
import java.awt.Color;
/**
 * This class implements enemy.
 * Used for decorator pattern to modify enemy attributes
 */
public abstract class EnemyDecorator extends EnemyPrototype{
   protected final EnemyPrototype decoratedEnemy;

    /**
    * Creates a new enemy ready to be modified
    * @param Modified Enemy
    */
    public EnemyDecorator(EnemyPrototype decoratedEnemy){
        this.decoratedEnemy = decoratedEnemy;
    }

    /* Returns health*/
    @Override
    public double getHealth(){
        return decoratedEnemy.getHealth();
    };

    /* Returns speed*/
    @Override
    public double getSpeed(){
        return this.decoratedEnemy.getSpeed();
    };

    /* sets the attack speed 
    * @param newSpeed is used to replace previous enemy speed value
    */
    public void setSpeed(double newSpeed){
        this.decoratedEnemy.setSpeed(newSpeed);
    }
    /**
     * Draws enemy according to its type
     */
    @Override
    public Color draw() {
        return this.decoratedEnemy.draw();
    }

    @Override
    /* sets the health of enemy
    * @param newHealth is used to replace health
    */
    public void setHealth(double newHealth){
         this.decoratedEnemy.setHealth(newHealth);
    };

    /**
     * This method will allow the object to move from current cell to another
     */
    public boolean move(){
        return this.decoratedEnemy.move();
    }

}