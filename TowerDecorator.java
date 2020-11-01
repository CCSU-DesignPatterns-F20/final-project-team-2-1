public abstract class TowerDecorator implements Tower{
   private final Tower decoratedTower;

   /* Returns damage*/
   @Override
    public abstract double getDamage(){
        return decoratedTower.damage;
    };

    /* Returns range */
    @Override
    public abstract int getRange(){
        return decoratedTower.range;
    };

    /* Returns speed*/
    @Override
    public abstract double getSpeed(){
        return decoratedTower.speed;
    };

   public TowerDecorator(Tower decoratedTower){
      this.decoratedTower = decoratedTower;
   }

}