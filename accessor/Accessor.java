package accessor;

public interface Accessor<T> {
    public double value(T a);

    public T obj(double a);
}
