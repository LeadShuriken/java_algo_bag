package sort;

import java.util.Comparator;

public abstract class SortUtils<T> {

    protected void swap(T[] a, int i, int j) {
        T temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    protected boolean less(T v, T w, Comparator<? super T> b) {
        return b.compare(v, w) < 0;
    }


    public boolean isSorted(T[] a, int b, int c, Comparator<? super T> d) {
        for (int i = b + 1; i < c; i++)
            if (d.compare(a[i], a[i - 1]) < 0)
                return false;
        return true;
    }
}
