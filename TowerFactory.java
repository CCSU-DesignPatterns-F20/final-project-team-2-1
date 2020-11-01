/**
 * This class specifies how to create enemies
 */
public class TowerFactory implements AbstractFactory {

    /**
     * This class will create and return a specific tower. Weak tower is default.
     * @param String to tell which tower to create
     */
    @Override
    public CellComponent createProduct(String tower) {
        if (tower.equalsIgnoreCase("strongtower"))
            return new StrongTower();
        else if (tower.equalsIgnoreCase("weaktower"))
            return new WeakTower();
        else return new WeakTower();
    }

}
