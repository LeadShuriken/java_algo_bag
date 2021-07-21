package data_structures;

public class ItemQueue<T> extends ItemIterator<T> {
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
    }

    public T dequeue() {
        T item = first.item;
        first = first.next;
        if (isEmpty())
            last = null;
        return item;
    }
}
