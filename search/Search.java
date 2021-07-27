package search;

import java.util.Comparator;

public abstract class Search<T> {

    public abstract int search(T[] a, T b, Comparator<? super T> d);

    public abstract int first(T arr[], int l, int r, T key, Comparator<? super T> d);

    public abstract int last(T arr[], int l, int r, T key, Comparator<? super T> d);

    public abstract int leastgreater(T arr[], int l, int r, T key, Comparator<? super T> d);

    public abstract int greatestlesser(T arr[], int l, int r, T key, Comparator<? super T> d);
}
