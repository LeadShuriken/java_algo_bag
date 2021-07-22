package data_structures;

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
