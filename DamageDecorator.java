public class DamageDecorator extends TowerDecorator {

   public DamageDecorator(Tower decoratedTower) {
      super(decoratedTower);		
   }

    @Override
    public abstract void setDamage(double newDamage){
        decoratedTower.damage = newDamage;
    };

   private void changeDamage(Tower decoratedTower, double damageMultiplier){
      System.out.println("Previous Tower damage:" + decoratedTower.getDamage());
      decoratedTower.setDamage(decoratedTower.getDamage()*(1+damageMultiplier));
      System.out.println("New Tower damage:" + decoratedTower.getDamage());
   }
}