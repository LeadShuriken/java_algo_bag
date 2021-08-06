package select.interfaces;

import java.util.Comparator;

public interface Select<T> {
    public T select(T[] arr, Comparator<? super T> d, T k);
}
