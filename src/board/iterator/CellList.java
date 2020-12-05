package src.board.iterator;
import java.util.LinkedList;
import java.util.ListIterator;
/**
 * This class has a list of Objects and Iterator to loop through the list
 */
public class CellList<E> extends LinkedList<E> {
    /**
     * Gets the Object Iterator  
     */
    public IteratorInterface<E> getCellPathIterator() {
        return new CellPathIterator();
    }
    /**
     * Linked List Object Path Iterator implementtation
     */
    private class CellPathIterator implements IteratorInterface<E> {
        private final ListIterator<E> listIterator;

        public CellPathIterator() {
            this.listIterator = CellList.this.listIterator();

        }

        /**
         * Returns true if there is more Objects in the list
         */
        @Override
        public boolean hasNext() {
            return listIterator.hasNext();
        }

        /**
         * Gets the next Object 
         */
        @Override
        public E next() {
            return listIterator.next();
        }

    }
}
