/**
 * This class extends TowerDecorator and is used 
 * for specifically modifying tower speed.
 */
public class SpeedDecorator extends TowerDecorator {

   public SpeedDecorator(Tower decoratedTower) {
      super(decoratedTower);		
   }

    @Override
    public void setSpeed(double newSpeed){
        decoratedTower.speed = newSpeed;
    };

     /**
     * Change tower speed based on multiplier provided
     * if speed is 100 and multiplier is 0.10 (10%) new tower speed will be 110.
     * @param decoratedTower to modify speed
     * @param speedMultiplier is % change to tower attack speed
     */
   private void changeSpeed(Tower decoratedTower, double speedMultiplier){
      System.out.println("Previous Tower speed:" + decoratedTower.getSpeed());
      decoratedTower.setSpeed(decoratedTower.getSpeed()*(1+speedMultiplier));
      System.out.println("New Tower speed:" + decoratedTower.getSpeed());
   }

     /**
     * This method will inflict damage to enemy
     */
    protected void shoot(){

   }

    /* sets the attack range 
   * @param newRange is used to replace previous tower range value
   */
   public void setRange(int newRange){

   }

   /**
    * This method will have the tower continously shoot enemies
    */
   public void attack(){

   }

    /**
    * This method will stall the tower before shooting again
    */
   protected void reload(){
      
   }

    /* sets the damage
    * @param newDamage is used to replace previous tower damage value
    */
    public void setDamage(double newDamage){

    }
}