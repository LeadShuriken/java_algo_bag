package sort;

import sort.interfaces.IntArraySort;

public class InsertionSort extends SortUtils implements IntArraySort {

    public void sort(int[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            for (int j = i; j > 0; j--)
                if (less(a[j], a[j - 1]))
                    swap(a, j, j - 1);
                else
                    break;
        }
    }

    private void printSort(int[] a) {
        int N = a.length;
        System.out.println();
        System.out.print(" j");
        for (int i = 0; i < N; i++) {
            System.out.print("  " + i);
        }
        System.out.println();
        System.out.println("i ");

        for (int i = 0; i < N; i++) {
            System.out.print(i + (i >= 10 ? "  " : "   "));
            for (int j = i; j > 0; j--) {
                if (less(a[j], a[j - 1])) {
                    swap(a, j, j - 1);
                } else {
                    break;
                }
            }
            for (int n = 0; n < N; n++) {
                if (n == i) {
                    System.out.print("x  ");
                } else {
                    System.out.print(a[n] + (a[n] >= 10 ? " " : "  "));
                }
                System.out.print(n >= 10 ? " " : "");
            }
            System.out.println();
        }
        System.out.println();
    }
}
