package sort;

public abstract class SortUtils {

    protected void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    protected <T extends Comparable<T>> void swap(T[] a, int i, int j) {
        T temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    protected <T extends Comparable<T>> boolean less(T v, T w) {
        return v.compareTo(w) < 0;
    }

    protected boolean less(int v, int w) {
        return v < w;
    }

    public boolean isSorted(int[] a, int b, int c) {
        for (int i = b + 1; i < c; i++)
            if (a[i] < a[i - 1])
                return false;
        return true;
    }

    public <T extends Comparable<T>> boolean isSorted(T[] a, int b, int c) {
        for (int i = b + 1; i < c; i++)
            if (a[i].compareTo(a[i - 1]) < 0)
                return false;
        return true;
    }
}
