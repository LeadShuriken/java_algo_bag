package sort.interfaces;

import java.util.Comparator;

public interface Sort<T> {

    public abstract void sort(T[] a, int lo, int hi, Comparator<? super T> d);

    public default boolean isSorted(T[] a, int b, int c, Comparator<? super T> d) {
        for (int i = b + 1; i < c; i++)
            if (d.compare(a[i], a[i - 1]) < 0)
                return false;
        return true;
    };
}
