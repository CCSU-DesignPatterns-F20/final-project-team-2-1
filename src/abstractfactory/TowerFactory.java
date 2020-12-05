package src.abstractfactory;

import src.board.iterator.IteratorInterface;
import src.cell.Cell;
import src.cell.tower.StrongTower;
import src.cell.tower.Tower;
import src.cell.tower.WeakTower;

/**
 * This class specifies how to create enemies
 */
public class TowerFactory implements AbstractFactory<Tower> {

    /**
     * This class will create and return a specific tower. Weak tower is default.
     * @param cell to tell which tower to create
     */
    @Override
    public Tower createProduct(String tower, Cell cell) {
        if (tower.equalsIgnoreCase("strongtower"))
            return new StrongTower(cell);
        else if (tower.equalsIgnoreCase("weaktower"))
            return new WeakTower(cell);
        else return new WeakTower(cell);
    }


    @Override
    public Tower createProduct(String cellObject, IteratorInterface<Cell> pathCellIterator) {
        return null;
    }

}
