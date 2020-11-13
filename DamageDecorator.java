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
         decoratedTower.damage = newDamage;
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

    /* sets the attack speed 
    * @param newSpeed is used to replace previous tower speed value
    */
    public void setSpeed(double newSpeed){

    }

     /**
     * This method will stall the tower before shooting again
     */
    protected void reload(){
       
    }



}