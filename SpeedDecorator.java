public class SpeedDecorator extends TowerDecorator {

   public SpeedDecorator(Tower decoratedTower) {
      super(decoratedTower);		
   }

    @Override
    public abstract void setSpeed(double newSpeed){
        decoratedTower.speed = newSpeed;
    };

   private void changeSpeed(Tower decoratedTower, double speedMultiplier){
      System.out.println("Previous Tower speed:" + decoratedTower.getSpeed());
      decoratedTower.setSpeed(decoratedTower.getSpeed()*(1+speedMultiplier));
      System.out.println("New Tower speed:" + decoratedTower.getSpeed());
   }
}