package sort.interfaces;

import java.util.Comparator;
import java.util.List;

public interface Sort<T> {

    public abstract void sort(T[] a, int lo, int hi, Comparator<? super T> d);

    public default boolean isSorted(T[] a, int b, int c, Comparator<? super T> d) {
        for (int i = b + 1; i < c; i++)
            if (d.compare(a[i], a[i - 1]) < 0)
                return false;
        return true;
    };

    public default boolean isStable(T[] a, int b, int c, int count, List<Comparator<? super T>> m) {
        Comparator<? super T> x = m.get(0);
        for (int i = b + 1; i < c; i++) {
            int prime = x.compare(a[i], a[i - 1]);
            if (prime < 0) {
                return false;
            } else if (prime == 0) {
                for (int j = 1; j < m.size(); j++) {
                    if (m.get(j).compare(a[i], a[i - 1]) < 0) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
