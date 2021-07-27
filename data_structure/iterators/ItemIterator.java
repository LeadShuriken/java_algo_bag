package data_structure.iterators;

import java.util.Iterator;

public class ItemIterator<T> implements Iterable<T> {
    protected Node last = null;
    protected Node first = null;
    protected int N = 0;

    public boolean isEmpty() {
        return first == null;
    }

    public class Node {
        public T item;
        public Node next;
    }

    public int length() {
        return N;
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
