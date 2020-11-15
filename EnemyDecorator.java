/**
 * This class implements enemy.
 * Used for decorator pattern to modify enemy attributes
 */
public abstract class EnemyDecorator extends EnemyPrototype{
   protected final Enemy decoratedEnemy;

   public EnemyDecorator(Enemy decoratedEnemy){
        this.decoratedEnemy = decoratedEnemy;
    }

   /* Returns health*/
   @Override
    public double getHealth(){
        return decoratedEnemy.health;
    };
}