/**
 * This class implements tower.
 * Used for decorator pattern to modify tower attributes
 */
public abstract class TowerDecorator extends Tower{
   private final Tower decoratedTower;

   public TowerDecorator(Tower decoratedTower){
        this.decoratedTower = decoratedTower;
    }
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
}