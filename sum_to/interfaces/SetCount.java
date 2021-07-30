package sum_to.interfaces;

import java.util.List;

public abstract class SetCount<T, R> {

    protected int a_len;
    protected int arr_len;
    protected double aim;
    protected R accessor;
    protected List<int[]> sets;

    protected abstract int findWithSets(T[] a, int b, int pIndex, int count, double combinedValue, int[] arr);
}
