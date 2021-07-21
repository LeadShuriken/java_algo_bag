package data_structures;

import java.util.Iterator;

public class ItemIterator<T> implements Iterable<T> {

    protected Node first = null;

    protected class Node {
        T item;
        Node next;
    }

    public Iterator<T> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<T> {
        private Node current = first;

        public boolean hasNext() {
            return current != null;
        }

        public void remove() {
            throw new UnsupportedOperationException("Remove operation not supported");
        }

        public T next() {
            T item = current.item;
            current = current.next;
            return item;
        }
    }
}
