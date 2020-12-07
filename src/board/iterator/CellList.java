package src.board.iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
/**
 * This class has a list of Objects and Iterator to loop through the list
 */
public class CellList<E> extends LinkedList<E> implements Cloneable {
    /**
     * Gets the Object Iterator  
     * @return the new CellPathIterator
     */
    public IteratorInterface<E> getCellPathIterator() {
        return new CellPathIterator();
    }

    /**
     * Linked List Object Path Iterator implementtation
     */
    private class CellPathIterator implements IteratorInterface<E> {
        private ListIterator<E> listIterator;

        public CellPathIterator() {
            this.listIterator = CellList.this.listIterator();
        }

        /**
         * @return the listIterator
         */
        public ListIterator<E> getListIterator() {
            return this.listIterator;
        }

        /**
         * @return ture if there is more objects in the list
         */
        @Override
        public boolean hasNext() {
            return listIterator.hasNext();
        }

        /**
         * @return the next object in the list
         */
        @Override
        public E next() {
            return listIterator.next();
        }

    }
}
