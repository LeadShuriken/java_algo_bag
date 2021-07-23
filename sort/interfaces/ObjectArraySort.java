package sort.interfaces;

public interface ObjectArraySort {
    public <T extends Comparable<T>> void sort(T[] a);

    public <T extends Comparable<T>> boolean isSorted(T[] a, int b, int c);
}
