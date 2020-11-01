/**
 * This class extends TowerDecorator and is used 
 * for specifically modifying tower damage.
 */
public class DamageDecorator extends TowerDecorator {

   public DamageDecorator(Tower decoratedTower) {
      super(decoratedTower);		
   }

    @Override
    public void setDamage(double newDamage){
         decoratedTower.setDamage(damageModifier * newDamage);
    };

   /**
     * Change tower damage based on multiplier
     * if damage is 100 and multiplier is 0.10 (10%) new tower damage will be 110.
     * @param decoratedTower to modify damage
     * @param damageMultiplier is % change to tower damage
     */
   private void changeDamage(Tower decoratedTower, double damageMultiplier){
      System.out.println("Previous Tower damage:" + decoratedTower.getDamage());
      decoratedTower.setDamage(decoratedTower.getDamage()*(1+damageMultiplier));
      System.out.println("New Tower damage:" + decoratedTower.getDamage());
   }
}