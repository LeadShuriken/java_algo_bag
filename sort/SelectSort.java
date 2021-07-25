package sort;

import sort.interfaces.IntArraySort;

public class SelectSort extends SortUtils implements IntArraySort {

    public void sort(int[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = i + 1; j < N; j++)
                if (less(a[j], a[min]))
                    min = j;
            swap(a, i, min);
        }
    }

    private void printSort(int[] a) {
        int N = a.length;
        System.out.println();
        System.out.print("i ");
        for (int i = 0; i < N; i++) {
            System.out.print("  " + i);
        }
        System.out.println("   m");
        System.out.println();
        for (int i = 0; i < N; i++) {
            System.out.print(i + (i >= 10 ? "  " : "   "));
            int min = i;

            for (int x = 0; x < N; x++) {
                if (x == i) {
                    System.out.print("x  ");
                } else {
                    System.out.print(a[x] + (a[x] >= 10 ? " " : "  "));
                }
                System.out.print(x >= 10 ? " " : "");
            }

            for (int j = i + 1; j < N; j++) {
                if (less(a[j], a[min])) {
                    min = j;
                }
            }
            System.out.println(" " + min);
            swap(a, i, min);
        }
        System.out.println();
    }
}
