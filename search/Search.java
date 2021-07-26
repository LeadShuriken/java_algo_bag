package search;

public abstract class Search {

    public abstract <T extends Comparable<T>> int search(T[] a, T b);

    public abstract <T extends Comparable<T>> int first(T arr[], int l, int r, T key);

    public abstract <T extends Comparable<T>> int last(T arr[], int l, int r, T key);

    public abstract <T extends Comparable<T>> int leastgreater(T arr[], int l, int r, T key);

    public abstract <T extends Comparable<T>> int greatestlesser(T arr[], int l, int r, T key);
}
