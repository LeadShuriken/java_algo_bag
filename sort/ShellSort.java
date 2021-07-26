package sort;

import sort.interfaces.IntArraySort;

public class ShellSort extends SortUtils implements IntArraySort {

    public void sort(int[] a) {
        int N = a.length;
        int h = 1;
        while (h < N / 3)
            h = 3 * h + 1;

        while (h >= 1) {
            for (int i = 0; i < N; i++)
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h)
                    swap(a, j, j - h);
            h = h / 3;
        }
    }
}
