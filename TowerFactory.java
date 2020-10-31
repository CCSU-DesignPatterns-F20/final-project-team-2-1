public class TowerFactory implements AbstractFactory {

    @Override
    public CellObject createProduct(String tower) {
        if (tower.equalsIgnoreCase("strongtower"))
            return new StrongTower();
        else if (tower.equalsIgnoreCase("weaktower"))
            return new WeakTower();
        else return new WeakTower();
    }

}
