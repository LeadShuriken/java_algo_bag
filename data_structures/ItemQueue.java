package data_structures;

public class ItemQueue<T> extends ItemIterator<T> implements Queue<T> {
    private Node last;

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
