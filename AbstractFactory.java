/**
 * This class defines factory method and provides user with abstract method.
 * It is used to create a CellObject (tower or enemy).
 */
public interface AbstractFactory {
    public CellComponent createProduct(String cellObject, Cell cell);
}
