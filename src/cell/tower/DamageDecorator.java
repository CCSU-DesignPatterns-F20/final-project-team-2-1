package src.cell.tower;
/**
 * This class extends TowerDecorator and is used 
 * for specifically modifying tower damage.
 */
public class DamageDecorator extends TowerDecorator {

   private double damageIncrease;

   public DamageDecorator(Tower decoratedTower, double damageIncrease) {
      super(decoratedTower);		
      this.damageIncrease = damageIncrease;
   }

   /* Returns modified damage*/
   @Override
   public double getDamage(){
      return this.decoratedTower.getDamage() * this.damageIncrease;
   }
}