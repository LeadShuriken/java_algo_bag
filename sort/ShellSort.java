package sort;

import java.util.Comparator;

import sort.interfaces.Sort;

public class ShellSort<T> extends SortUtils<T> implements Sort<T> {

    public void sort(T[] a, Comparator<? super T> b) {
        int N = a.length;
        int h = 1;
        while (h < N / 3)
            h = 3 * h + 1;

        while (h >= 1) {
            for (int i = 0; i < N; i++)
                for (int j = i; j >= h && less(a[j], a[j - h], b); j -= h)
                    swap(a, j, j - h);
            h = h / 3;
        }
    }
}
