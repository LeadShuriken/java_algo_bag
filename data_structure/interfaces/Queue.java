package data_structure.interfaces;

public interface Queue<T> extends DataStructure, Iterable<T> {

    public abstract void enqueue(T item);

    public abstract T dequeue();
}
