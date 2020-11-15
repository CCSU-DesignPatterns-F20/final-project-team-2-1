package Iterator;

import java.util.LinkedList;
import java.util.ListIterator;

public class CellList<E> extends LinkedList<E> {
    public IteratorInterface<E> getCellPathIterator() {
        return new CellPathIterator();
    }

    private class CellPathIterator implements IteratorInterface<E> {
        private ListIterator<E> listIterator;

        public CellPathIterator() {
            this.listIterator = CellList.this.listIterator();

        }

        @Override
        public boolean hasNext() {
            return listIterator.hasNext();
        }

        @Override
        public E next() {
            return listIterator.next();
        }

    }
}
