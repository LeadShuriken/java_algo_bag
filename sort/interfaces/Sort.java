package sort.interfaces;

import java.util.Comparator;

public interface Sort<T> {

    public void sort(T[] a, Comparator<? super T> d);

    public boolean isSorted(T[] a, int b, int c, Comparator<? super T> d);
}
