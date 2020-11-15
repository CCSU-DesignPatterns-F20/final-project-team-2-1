/**
 * This class extends EnemyDecorator and is used 
 * for specifically modifying enemy health.
 */
public class HealthDecorator extends EnemyDecorator {

   public HealthDecorator(EnemyPrototype decoratedEnemy) {
      super(decoratedEnemy);
   }

   /* This method will be used to clone/create copies of enemy objects */
   @Override
   public HealthDecorator clone(){
      return new HealthDecorator(decoratedEnemy.clone());
   }

   /**
     * Change enemy health  based on multiplier
     * if health is 100 and multiplier is 0.10 (10%) new enemy health will be 110.
     * @param decoratedEnemy to modify health
     * @param healthMultiplier is % change to enemy health
     */
   public void changeHealth(double healthMultiplier){
      System.out.println("Previous enemy health:" + decoratedEnemy.getHealth());
      decoratedEnemy.setHealth(this.decoratedEnemy.getHealth()*(1+healthMultiplier));
      System.out.println("New enemy health:" + decoratedEnemy.getHealth());
   }

}