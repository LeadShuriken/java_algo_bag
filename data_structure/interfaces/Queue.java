package data_structure.interfaces;

public interface Queue<T> extends DataStructure, Iterable<T> {

    public void enqueue(T item);

    public T dequeue();
}
