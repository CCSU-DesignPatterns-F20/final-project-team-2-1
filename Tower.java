public abstract class Tower extends CellObject {
    private double damage;
    private int range;

    protected abstract void shoot();

    protected abstract void reload();

    public void attack() {
        shoot();
        reload();
    }
}