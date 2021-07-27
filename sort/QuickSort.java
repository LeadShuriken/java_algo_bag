package sort;

import java.util.Comparator;

public class QuickSort<T> extends SortAbst<T> {

    // TC: O(nlogn) => i <= O(n^2)
    public void sort(T[] a, int lo, int hi, Comparator<? super T> b) {
        quickSort(a, lo, hi - 1, b);
    }

    private int partition(T[] arr, int low, int high, Comparator<? super T> b) {
        T pivot = arr[high];

        int i = (low - 1);

        for (int j = low; j <= high - 1; j++) {
            if (less(arr[j], pivot, b)) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }

    private void quickSort(T[] arr, int low, int high, Comparator<? super T> b) {
        if (low < high) {

            int pi = partition(arr, low, high, b);

            quickSort(arr, low, pi - 1, b);
            quickSort(arr, pi + 1, high, b);
        }
    }
}
