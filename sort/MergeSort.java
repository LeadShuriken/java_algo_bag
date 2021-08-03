package sort;

import java.util.Comparator;

import sort.interfaces.Sort;
import sort.interfaces.SortAbst;

public class MergeSort<T> extends SortAbst<T> {

    private final int CUTOFF;
    private final Sort<T> SORT;

    public MergeSort(int cutoff, Sort<T> stableNoneSort) {
        CUTOFF = cutoff;
        SORT = stableNoneSort;
    }

    public void sort(T[] a, int lo, int hi, Comparator<? super T> b) {
        T[] aux = a.clone();
        sort(aux, a, lo, hi - 1, b);
    }

    private void sort(T[] a, T[] aux, int lo, int hi, Comparator<? super T> b) {
        if (hi <= lo + CUTOFF) {
            SORT.sort(aux, lo, hi + 1, b);
            return;
        }
        int mid = lo + (hi - lo) / 2;
        sort(aux, a, lo, mid, b);
        sort(aux, a, mid + 1, hi, b);
        if (!less(a[mid + 1], a[mid], b)) {
            System.arraycopy(a, lo, aux, lo, hi - lo + 1);
            return;
        }
        merge(a, aux, lo, mid, hi, b);
    }

    private void merge(T[] a, T[] aux, int lo, int mid, int hi, Comparator<? super T> b) {
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid)
                aux[k] = a[j++];
            else if (j > hi)
                aux[k] = a[i++];
            else if (less(a[j], a[i], b))
                aux[k] = a[j++];
            else
                aux[k] = a[i++];
        }
    }
}
