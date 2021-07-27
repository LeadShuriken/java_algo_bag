package sort;

import java.util.Comparator;

public class QuickSort<T> extends SortAbst<T> {

    // TC: O(nlogn) => i <= O(n^2)
    public void sort(T[] a, Comparator<? super T> b) {
        int n = a.length;
        quickSort(a, 0, n - 1, b);
    }

    private int partition(T[] arr, int low, int high, Comparator<? super T> b) {
        T pivot = arr[high];

        int i = (low - 1);

        for (int j = low; j <= high - 1; j++) {
            if (b.compare(arr[j], pivot) < 0) {
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
