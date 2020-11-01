/**
 * This class specifies the framework for tower.
 * Enemies will additionally contain damage (how much health it can take away from enemy) 
 * and range (how far it can reach enemies) attributes.
 */
public abstract class Tower extends CellComponent {
    protected double damage;
    protected double speed;
    protected int range;

    /**
     * This method will inflict damage to enemy
     */
    protected abstract void shoot();

    /**
     * This method will stall the tower before shooting again
     */
    protected abstract void reload();

    /* Returns damage*/
    public abstract double getDamage();

    /* Returns range */
    public abstract int getRange();

    /* Returns speed*/
    public abstract double getSpeed();

    /* sets the damage
    * @param newDamage is used to replace previous tower damage value
    */
    public abstract void setDamage(double newDamage);

    /* sets the attack range 
    * @param newRange is used to replace previous tower range value
    */
    public abstract void setRange(int newRange);

    /* sets the attack speed 
    * @param newSpeed is used to replace previous tower speed value
    */
    public abstract void setSpeed(double newSpeed);

    /**
     * This method will have the tower continously shoot enemies
     */
    public abstract void attack();
}