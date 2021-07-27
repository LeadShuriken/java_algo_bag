package sort;

import java.util.Comparator;

public class BogoSort<T> extends SortAbst<T> {
    // TC: O(nn!)
    public void sort(T[] a, int lo, int hi, Comparator<? super T> b) {
        while (isSorted(a, lo, hi, b) == false)
            shuffle(a, lo, hi);
    }

    private void shuffle(T[] a, int b, int c) {
        for (int i = b; i < c; i++)
            swap(a, i, (int) (Math.random() * i));
    }
}
