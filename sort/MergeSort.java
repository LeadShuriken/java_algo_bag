package sort;

import java.util.Comparator;

public class MergeSort<T> extends SortAbst<T> {

    @SuppressWarnings("unchecked")
    public void sort(T[] a, Comparator<? super T> b) {
        int N = a.length;
        T[] copy = (T[]) new Object[N];
        sort(a, copy, 0, N - 1, b);
    }

    private void sort(T[] a, T[] aux, int lo, int hi, Comparator<? super T> b) {
        if (hi <= lo)
            return;
        int mid = lo + (hi - lo) / 2;
        sort(a, aux, lo, mid, b);
        sort(a, aux, mid + 1, hi, b);
        merge(a, aux, lo, mid, hi, b);
    }

    private void merge(T[] a, T[] aux, int lo, int mid, int hi, Comparator<? super T> b) {
        for (int k = lo; k <= hi; k++)
            aux[k] = a[k];
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid)
                a[k] = aux[j++];
            else if (j > hi)
                a[k] = aux[i++];
            else if (less(aux[j], aux[i], b))
                a[k] = aux[j++];
            else
                a[k] = aux[i++];
        }
    }
}
