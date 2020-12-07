package src.cell.tower;
/**
 * This class extends TowerDecorator and is used 
 * for specifically modifying tower speed.
 */
public class SpeedDecorator extends TowerDecorator {

   private double speedIncrease;

   /**
     * Initializes a BaseTower with an additional parameter
     * @param Basetower (Strong or Weak Towre)
     * @param Speed Multiplier
     */
   public SpeedDecorator(Tower decoratedTower, double speedIncrease) {
      super(decoratedTower);		
      this.speedIncrease = speedIncrease;
   }

   /* Returns modified speed*/
   @Override
   public double getSpeed(){
      return this.decoratedTower.getSpeed() * this.speedIncrease;
   }
}