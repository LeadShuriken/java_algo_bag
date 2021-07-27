package sort;

import java.util.Comparator;

public class BogoSort<T> extends SortAbst<T> {
    // TC: O(nn!)
    public void sort(T[] a, Comparator<? super T> b) {
        int N = a.length;
        while (isSorted(a, 0, N, b) == false)
            shuffle(a, 0, N);
    }

    private void shuffle(T[] a, int b, int c) {
        for (int i = b; i < c; i++)
            swap(a, i, (int) (Math.random() * i));
    }
}
