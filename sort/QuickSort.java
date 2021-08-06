package sort;

import java.util.Comparator;

import misc.RandomUtils;
import sort.interfaces.Sort;
import sort.interfaces.SortAbst;

public class QuickSort<T> extends SortAbst<T> {

    private final Integer CUTOFF;
    private final Sort<T> SORT;

    public QuickSort() {
        CUTOFF = null;
        SORT = null;
    }

    public QuickSort(int cutoff, Sort<T> stableNoneSort) {
        CUTOFF = cutoff;
        SORT = stableNoneSort;
    }

    // TC: O(nlogn) => i <= O(n^2)
    public void sort(T[] a, int lo, int hi, Comparator<? super T> b) {
        RandomUtils.shuffle(a);
        quickSort(a, lo, hi - 1, b);
    }

    protected int partition(T[] arr, int lo, int hi, int pivot, Comparator<? super T> b) {
        int i = lo - 1, j = hi;
        while (i < j) {
            while (less(arr[++i], arr[pivot], b))
                ;
            while (j > 0 && less(arr[pivot], arr[--j], b))
                ;
            if (i >= j)
                break;
            swap(arr, i, j);
        }
        swap(arr, i, hi);
        return i;
    }

    private void quickSort(T[] arr, int lo, int hi, Comparator<? super T> b) {
        if (hi <= lo + CUTOFF) {
            SORT.sort(arr, lo, hi + 1, b);
            return;
        }

        int pi = partition(arr, lo, hi, med(arr, lo, (lo + hi) / 2, hi, b), b);
        quickSort(arr, lo, pi - 1, b);
        quickSort(arr, pi + 1, hi, b);
    }

    protected int med(T[] arr, int left, int center, int right, Comparator<? super T> b) {
        if (less(arr[center], arr[left], b))
            swap(arr, center, left);

        if (less(arr[right], arr[left], b))
            swap(arr, left, right);

        if (less(arr[right], arr[center], b))
            swap(arr, right, center);

        swap(arr, right, center);
        return right;
    }
}
