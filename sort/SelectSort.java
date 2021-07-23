package sort;

import sort.interfaces.ObjectArraySort;

public class SelectSort extends SortUtils implements ObjectArraySort {

    public <T extends Comparable<T>> void sort(T[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = i + 1; j < N; j++)
                if (less(a[j], a[min]))
                    min = j;
            swap(a, i, min);
        }
    }

    private <T extends Comparable<T>> boolean less(T v, T w) {
        return v.compareTo(w) < 0;
    }
}
