/**
 * This class extends TowerDecorator and is used 
 * for specifically modifying tower speed.
 */
public class SpeedDecorator extends TowerDecorator {

   public SpeedDecorator(Tower decoratedTower) {
      super(decoratedTower);		
   }

   /**
   * Change tower speed based on multiplier provided
   * if speed is 100 and multiplier is 0.10 (10%) new tower speed will be 110.
   * @param newSpeed is % change to tower attack speed
   */
   @Override
   public void setSpeed(double newSpeed){
      System.out.println("Previous Tower speed:" + decoratedTower.getSpeed());
      this.decoratedTower.setSpeed(decoratedTower.getSpeed()*(1+newSpeed));
      System.out.println("New Tower speed:" + decoratedTower.getSpeed());
   }
}