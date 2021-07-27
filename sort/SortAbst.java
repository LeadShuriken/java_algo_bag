package sort;

import java.util.Comparator;

import sort.interfaces.Sort;

public abstract class SortAbst<T> implements Sort<T> {

    protected void swap(T[] a, int i, int j) {
        T temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    protected boolean less(T v, T w, Comparator<? super T> b) {
        return compare(v, w, b) < 0;
    }

    protected int compare(T v, T w, Comparator<? super T> b) {
        return b.compare(v, w);
    }
}
