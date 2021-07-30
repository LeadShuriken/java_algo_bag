package data_structure.interfaces;

public interface Stack<T> extends DataStructure, Iterable<T> {

    public abstract T peek();

    public abstract void push(T item);

    public abstract T pop();
}
