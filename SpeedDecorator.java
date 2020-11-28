/**
 * This class extends TowerDecorator and is used 
 * for specifically modifying tower speed.
 */
public class SpeedDecorator extends TowerDecorator {

   private double speedIncrease;

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