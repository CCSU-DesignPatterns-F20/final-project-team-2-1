/**
 * This class extends EnemyDecorator and is used 
 * for specifically modifying enemy health.
 */
public class HealthDecorator extends EnemyDecorator {

   public HealthDecorator(Enemy decoratedEnemy) {
      super(decoratedEnemy);		
   }

    @Override
    public void setHealth(double newHealth){
         decoratedEnemy.health = newHealth;
    };

   /**
     * Change enemy health  based on multiplier
     * if health is 100 and multiplier is 0.10 (10%) new enemy health will be 110.
     * @param decoratedEnemy to modify health
     * @param healthMultiplier is % change to enemy health
     */
   private void changeDamage(Enemy decoratedEnemy, double healthMultiplier){
      System.out.println("Previous enemy health:" + decoratedEnemy.getHealth());
      decoratedEnemy.setHealth(decoratedEnemy.getHealth()*(1+damageMultiplier));
      System.out.println("New enemy health:" + decoratedEnemy.getHealth());
   }

}