package data_structures;

import data_structures.interfaces.Queue;
import data_structures.iterators.ItemIterator;

public class ItemQueue<T> extends ItemIterator<T> implements Queue<T> {


    public boolean isEmpty() {
        return first == null;
    }

    public void enqueue(T item) {
        Node oldlast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty())
            first = last;
        else
            oldlast.next = last;
        N++;
    }

    public T dequeue() {
        T item = first.item;
        first = first.next;
        if (isEmpty())
            last = null;
        N--;
        return item;
    }
}
