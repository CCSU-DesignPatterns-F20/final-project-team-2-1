package src.board.iterator;

/**
 * This interface specified needed methods to loop through the list
 */
public interface IteratorInterface<E> {

    /**
     * @return true or false if there is next Object
     */
    public boolean hasNext();

    /**
     * @return the next object
     */
    public E next();
}
