package data_structure;

import data_structure.interfaces.Stack;
import data_structure.iterators.ArrayIterator;

public class ArrayStack<T> extends ArrayIterator<T> implements Stack<T> {

    public void push(T item) {
        if (N == s.length)
            resize(2 * N);
        s[N++] = item;
    }

    public T pop() {
        T item = s[--N];
        s[N] = null;
        if (N > 0 && N == s.length / 4)
            resize(s.length / 2);
        return item;
    }

    public T peek() {
        return s[N - 1];
    }

    @SuppressWarnings("unchecked")
    private void resize(int capacity) {
        T[] copy = (T[]) new Object[capacity];
        for (int i = 0; i < N; i++)
            copy[i] = s[i];
        s = copy;
    }
}
