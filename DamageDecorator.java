/**
 * This class extends TowerDecorator and is used 
 * for specifically modifying tower damage.
 */
public class DamageDecorator extends TowerDecorator {

   public DamageDecorator(Tower decoratedTower) {
      super(decoratedTower);		
   }

   /**
   * Change tower damage based on multiplier
   * if damage is 100 and multiplier is 0.10 (10%) new tower damage will be 110.
   * @param newDamage is % change to tower damage
   */
   @Override
   public void setDamage( double newDamage){
      System.out.println("Previous Tower damage:" + decoratedTower.getDamage());
      this.decoratedTower.setDamage(decoratedTower.getDamage()*(1+newDamage));
      System.out.println("New Tower damage:" + decoratedTower.getDamage());
   }

}