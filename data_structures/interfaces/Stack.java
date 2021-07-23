package data_structures.interfaces;

public interface Stack<T> extends DataStructure, Iterable<T> {

    public T peek();

    public void push(T item);

    public T pop();
}
