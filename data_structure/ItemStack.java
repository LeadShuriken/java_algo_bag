package data_structure;

import data_structure.interfaces.Stack;
import data_structure.iterators.ItemIterator;

public class ItemStack<T> extends ItemIterator<T> implements Stack<T> {

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

    public T peek() {
        return first.item;
    }
}
