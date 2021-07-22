package data_structures;

public interface Stack<T> extends DataStructure, Iterable<T> {
    public void push(T item);

    public T pop();
}
