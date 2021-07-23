package sort;

import sort.interfaces.IntArraySort;
import sort.interfaces.ObjectArraySort;

public class QuickSort extends SortUtils implements IntArraySort, ObjectArraySort {

    // TC: O(nlogn) => i <= O(n^2)
    public void sort(int[] arr) {
        int n = arr.length;
        quickSort(arr, 0, n - 1);
    }

    public <T extends Comparable<T>> void sort(T[] a) {
        int n = a.length;
        quickSort(a, 0, n - 1);
    }

    int partition(int[] arr, int low, int high) {

        int pivot = arr[high];

        int i = (low - 1);

        for (int j = low; j <= high - 1; j++) {

            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }

    private <T extends Comparable<T>> int partition(T[] arr, int low, int high) {

        T pivot = arr[high];

        int i = (low - 1);

        for (int j = low; j <= high - 1; j++) {

            if (arr[j].compareTo(pivot) < 0) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }

    private void quickSort(int[] arr, int low, int high) {
        if (low < high) {

            int pi = partition(arr, low, high);

            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private <T extends Comparable<T>> void quickSort(T[] arr, int low, int high) {
        if (low < high) {

            int pi = partition(arr, low, high);

            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }
}
