package sum_to;

import java.util.ArrayList;
import java.util.List;

import accessor.Accessor;

public class AimSumBrute<T> extends AimSum<T> {

    private Accessor<T> accessor;

    // TC: O(n^b)
    // T(N)=aNb (p law)
    // (b slope) (Nb order of growth)
    // (a scale of process)
    public CountSets count(T[] a, int b, double aim, Accessor<T> accessor) {
        // n^b makes space complexity too big

        this.accessor = accessor;
        List<int[]> sets = new ArrayList<>();

        int count = findWithSets(a, a.length, b, aim, 0, 0, 0, new int[b], b, sets);
        return new CountSets(sets, count);
    }

    // TC: O((n-b)^b) (brute force)
    protected int findWithSets(T[] a, int a_len, int b, double aim, int pIndex, int count, double combinedValue,
            int[] arr, int arr_len, List<int[]> sets) {
        for (int i = pIndex; i < a_len - (b - 1); i++) {
            arr[arr_len - b] = i;
            double val = accessor.value(a[i]);
            if (b > 1) {
                count = findWithSets(a, a_len, b - 1, aim, i + 1, count, combinedValue + val, arr, arr_len, sets);
            } else if (combinedValue + val == aim) {
                sets.add(arr.clone());
                count++;
            }
        }
        return count;
    }
}
