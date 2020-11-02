/**
 * This class implements tower.
 * Used for decorator pattern to modify tower attributes
 */
public abstract class TowerDecorator extends Tower{
   protected final Tower decoratedTower;

   public TowerDecorator(Tower decoratedTower){
        this.decoratedTower = decoratedTower;
    }
   /* Returns damage*/
   @Override
    public double getDamage(){
        return decoratedTower.damage;
    };

    /* Returns range */
    @Override
    public int getRange(){
        return decoratedTower.range;
    };

    /* Returns speed*/
    @Override
    public double getSpeed(){
        return decoratedTower.speed;
    };
}