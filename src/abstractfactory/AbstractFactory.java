package src.abstractfactory;

import src.board.iterator.CellList;
import src.board.iterator.IteratorInterface;
import src.cell.Cell;
import src.cell.CellComponent;

/**
 * This interface defines factory methods which provides user with abstract method.
 * It is used to create a CellObject (tower or enemy).
 */
public interface AbstractFactory<T extends CellComponent> {

    /**
     * The abstract method for creating the cellObject
     * @param cellObject
     * @param pathCellIterator
     * @return
     */
    public T createProduct(String cellObject, CellList<Cell> pathCellIterator);

    /**
     * Abstract method for creating the cellObject with specify cell.  
     * @param cellObject
     * @param cell
     * @param pathCellIterator
     * @return
     */
    public T createProduct(String cellObject, Cell cell, IteratorInterface<Cell> pathCellIterator);
}
