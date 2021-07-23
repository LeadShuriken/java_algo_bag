package sort;

import sort.interfaces.IntArraySort;
import sort.interfaces.ObjectArraySort;

public class BogoSort extends SortUtils implements IntArraySort, ObjectArraySort {
    // TC: O(nn!)
    public void sort(int[] a) {
        int N = a.length;
        while (isSorted(a, 0, N) == false)
            shuffle(a, 0, N);
    }

    public <T extends Comparable<T>> void sort(T[] a) {
        int N = a.length;
        while (isSorted(a, 0, N) == false)
            shuffle(a, 0, N);
    }

    private void shuffle(int[] a, int b, int c) {
        for (int i = b; i < c; i++)
            swap(a, i, (int) (Math.random() * i));
    }

    private <T extends Comparable<T>> void shuffle(T[] a, int b, int c) {
        for (int i = b; i < c; i++)
            swap(a, i, (int) (Math.random() * i));
    }
}
