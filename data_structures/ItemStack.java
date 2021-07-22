package data_structures;

import data_structures.interfaces.Stack;
import data_structures.iterators.ItemIterator;

public class ItemStack<T> extends ItemIterator<T> implements Stack<T> {

    public boolean isEmpty() {
        return first == null;
    }

    public void push(T item) {
        N++;
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
    }

    public T pop() {
        N--;
        T item = first.item;
        first = first.next;
        return item;
    }
}
