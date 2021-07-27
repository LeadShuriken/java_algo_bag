package sum_to;

import java.util.List;

import accessor.Accessor;

public class AimSumCount<T> extends AimSum<T> {

    private Accessor<T> accessor;

    // TC: O(n^b)
    // T(N)=aNb (p law)
    // (b slope) (Nb order of growth)
    // (a scale of process)
    public CountSets count(T[] a, int b, double aim, Accessor<T> accessor) {
        this.accessor = accessor;
        return new CountSets(null, findCount(a, b, a.length, aim, 0, 0, 0));
    }

    // TC: O(n^b)
    private long findCount(T[] a, int b, int a_len, double aim, int pIndex, long count, double combinedValue) {
        for (int i = pIndex; i < a_len - (b - 1); i++) {
            double val = accessor.value(a[i]);
            if (b > 1) {
                count = findCount(a, b - 1, a_len, aim, i + 1, count, combinedValue + val);
            } else if (combinedValue + val == aim) {
                count++;
            }
        }
        return count;
    }

    @Override
    protected int findWithSets(T[] a, int a_len, int b, double aim, int pIndex, int count, double combinedValue,
            int[] arr, int arr_len, List<int[]> sets) {
        // TODO Auto-generated method stub
        return 0;
    }
}
