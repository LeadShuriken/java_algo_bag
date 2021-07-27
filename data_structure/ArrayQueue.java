package data_structure;

import data_structure.interfaces.Queue;
import data_structure.iterators.ArrayIterator;

public class ArrayQueue<T> extends ArrayIterator<T> implements Queue<T> {
    private int H = 0;

    public void enqueue(T item) {
        if (N == s.length)
            resize(2 * N);
        s[N++] = item;
    }

    @SuppressWarnings("unchecked")
    private void resize(int capacity) {
        T[] copy = (T[]) new Object[capacity - H];
        N -= H;
        for (int i = 0; i < N; i++) {
            copy[i] = s[H + i];
        }
        s = copy;
        H = 0;
    }

    public T dequeue() {
        T item = s[H];
        if (H == s.length / 4)
            resize(s.length - H);
        else
            s[H++] = null;
        N--;
        return item;
    }
}
