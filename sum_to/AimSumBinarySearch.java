package sum_to;

import java.util.ArrayList;
import java.util.List;

import search.BinarySearch;
import sum_to.interfaces.AimSum;
import sum_to.interfaces.SetCount;
import util.Accessor;

public class AimSumBinarySearch<T, R extends Accessor<T, Double>> extends SetCount<T, R>
        implements AimSum<T, Double, R, CountSets> {

    private BinarySearch<T> search = new BinarySearch<>();

    // T(N)=aNb (p law)
    // (b slope) (Nb order of growth)
    // (a scale of process)
    public CountSets count(T[] a, int b, Double aim, R accessor) {
        this.accessor = accessor;
        this.a_len = a.length;
        this.aim = aim;
        this.arr_len = b;

        // n^b makes space complexity too big
        this.sets = new ArrayList<>();
        return new CountSets(this.sets, findWithSets(a, b, 0, 0, 0, new int[b]));
    }

    private int findWithSetsPair(T[] a, int incremIndex, double delta, int count, int[] arr) {
        for (int j = incremIndex; j < a_len; j++) {
            T temp = accessor.create(aim - (accessor.apply(a[j]) + delta));
            int l = search.first(a, incremIndex, j - 1, temp, accessor);
            if (l != -1) {
                count += addSet(l, l == j - 1 ? j : search.last(a, l, j - 1, temp, accessor) + 1, arr);
            }
        }
        return count;
    }

    // TC: O((n-b-2)^b+n)
    protected int findWithSets(T[] a, int b, int incremIndex, int count, double combinedValue, int[] arr) {
        if (arr_len == 2) {
            return findWithSetsPair(a, 0, 0, count, arr);
        }

        for (int i = incremIndex; i < a_len - (b - 1); i++) {
            arr[arr_len - b] = i;
            double res = accessor.apply(a[i]) + combinedValue;
            if (b > 3) {
                count = findWithSets(a, b - 1, i + 1, count, res, arr);
            } else {
                count = findWithSetsPair(a, i + 1, res, count, arr);
            }
        }
        return count;
    }

    private int addSet(int l, int j, int[] arr) {
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
