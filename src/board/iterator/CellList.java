package src.board.iterator;
import java.util.LinkedList;
import java.util.ListIterator;
/**
 * This class has a list of Objects and Iterator to loop through the list
 */
public class CellList<E> extends LinkedList<E> implements Cloneable {
    /**
     * Gets the Object Iterator  
     */
    public IteratorInterface<E> getCellPathIterator() {
        return new CellPathIterator();
    }

    /**
     * Linked List Object Path Iterator implementtation
     */
    private class CellPathIterator implements IteratorInterface<E>, Cloneable {
        private ListIterator<E> listIterator;

        public CellPathIterator() {
            this.listIterator = CellList.this.listIterator();
        }

        public CellPathIterator(CellPathIterator clone) {
            // copy the cell list
            // create new iterator from that copy
            // get access to the outer class instance because it is the list
            // then call clone() on the outer class instance. Because a list is cloneable in Java
            // then create new iterator from that clone
            CellList cloneList = (CellList) CellList.this.clone(); // this is clone of list
            ListIterator<E> cloneIterator = cloneList.listIterator();
            this.listIterator = cloneIterator;
        }

        public ListIterator<E> getListIterator() {
            return this.listIterator;
        }

        public IteratorInterface<E> clone() {
            return new CellPathIterator(this);
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
