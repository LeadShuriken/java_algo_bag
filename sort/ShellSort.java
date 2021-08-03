package sort;

import java.util.Comparator;

import sort.interfaces.SortAbst;

public class ShellSort<T> extends SortAbst<T> {

    public void sort(T[] a, int lo, int hi, Comparator<? super T> b) {
        int h = 1;
        while (h < (hi - lo) / 3)
            h = 3 * h + 1;

        while (h >= 1) {
            for (int i = lo; i < hi; i++)
                for (int j = i; j >= h && less(a[j], a[j - h], b); j -= h)
                    swap(a, j, j - h);
            h = h / 3;
        }
    }
}
