package sum_to;

import java.util.List;

import accessor.Accessor;

public abstract class AimSum<T> {

    public abstract CountSets count(T[] a, int b, double aim, Accessor<T> accessor);

    protected abstract int findWithSets(T[] a, int a_len, int b, double aim, int pIndex, int count,
            double combinedValue, int[] arr, int arr_len, List<int[]> sets);
}
