package sum_to;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import accessor.Accessor;
import search.BinarySearch;

public class AimSumBinarySearch<T> extends AimSum<T> {

    private BinarySearch<T> search;
    private Accessor<T> accessor;
    private final Comparator<T> comparator;

    public AimSumBinarySearch(Comparator<T> comparator) {
        this.comparator = comparator;
        this.search = new BinarySearch<>();
    }

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

    private int findWithSetsPair(T[] a, int a_len, double aim, int incremIndex, double delta, int count, int[] arr,
            int arr_len, List<int[]> sets) {
        for (int j = incremIndex; j < a_len; j++) {
            T temp = accessor.obj(aim - (accessor.value(a[j]) + delta));
            int l = search.first(a, incremIndex, j - 1, temp, comparator);
            if (l != -1) {
                count += addSet(l, l == j - 1 ? j : search.last(a, l, j - 1, temp, comparator) + 1, arr, arr_len, sets);
            }
        }
        return count;
    }

    // TC: O((n-b-2)^b+n)
    protected int findWithSets(T[] a, int a_len, int b, double aim, int incremIndex, int count, double combinedValue,
            int[] arr, int arr_len, List<int[]> sets) {
        if (arr_len == 2) {
            return findWithSetsPair(a, a_len, aim, 0, 0, count, arr, arr_len, sets);
        }

        for (int i = incremIndex; i < a_len - (b - 1); i++) {
            arr[arr_len - b] = i;
            double res = accessor.value(a[i]) + combinedValue;
            if (b > 3) {
                count = findWithSets(a, a_len, b - 1, aim, i + 1, count, res, arr, arr_len, sets);
            } else {
                count = findWithSetsPair(a, a_len, aim, i + 1, res, count, arr, arr_len, sets);
            }
        }
        return count;
    }

    private int addSet(int l, int j, int[] arr, int arr_len, List<int[]> sets) {
        int size = j - l;
        while (l < j) {
            arr[arr_len - 2] = l;
            arr[arr_len - 1] = j;
            sets.add(arr.clone());
            l++;
        }
        return size;
    }
}
