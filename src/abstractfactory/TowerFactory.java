package src.abstractfactory;

import src.board.iterator.CellList;
import src.board.iterator.IteratorInterface;
import src.cell.Cell;
import src.cell.tower.StrongTower;
import src.cell.tower.Tower;
import src.cell.tower.WeakTower;

/**
 * This class specifies how to create the tower
 */
public class TowerFactory implements AbstractFactory<Tower> {

    /**
     * This class will create and return a specific tower. Weak tower is default.
     * @param cell to tell which tower to create
     */
    @Override
    public Tower createProduct(String tower, Cell cell, IteratorInterface<Cell> cellPathIterator) {
        if (tower.equalsIgnoreCase("strongtower"))
            return new StrongTower(cell, cellPathIterator);
        else if (tower.equalsIgnoreCase("weaktower"))
            return new WeakTower(cell, cellPathIterator);
        else return new WeakTower(cell, cellPathIterator);
    }

    /**
     * This will create the cellObject with the pathCellIterator.
     * @param cellObject is the object on the cell 
     */
    @Override
    public Tower createProduct(String cellObject, CellList<Cell> pathCellIterator) {
        return null;
    }

}
