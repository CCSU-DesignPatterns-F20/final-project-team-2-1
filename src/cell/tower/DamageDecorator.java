package src.cell.tower;
/**
 * This class extends TowerDecorator and is used 
 * for specifically modifying tower damage.
 */
public class DamageDecorator extends TowerDecorator {

   private int damageIncrease;

   public DamageDecorator(Tower decoratedTower, int damageIncrease) {
      super(decoratedTower);		
      this.damageIncrease = damageIncrease;
   }

   /* Returns modified damage*/
   @Override
   public int getDamage(){
      return this.decoratedTower.getDamage() * this.damageIncrease;
   }
}