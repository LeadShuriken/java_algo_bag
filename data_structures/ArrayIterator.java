package data_structures;

import java.util.Iterator;

public class ArrayIterator<T> implements Iterable<T> {

    protected T[] s;
    protected int N = 0;

    public ArrayIterator() {
        s = (T[]) new Object[1];
    }

    public Iterator<T> iterator() {
        return new InnerArrayIterator();
    }

    private class InnerArrayIterator implements Iterator<T> {
        private int current = 0;

        public void remove() {
            throw new UnsupportedOperationException("Remove operation not supported");
        }

        public boolean hasNext() {
            return s.length > current;
        }

        public T next() {
            return s[current++];
        }
    }
}
