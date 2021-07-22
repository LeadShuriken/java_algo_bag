package data_structures.interfaces;

public interface Queue<T> extends DataStructure, Iterable<T> {

    public void enqueue(T item);

    public T dequeue();
}
