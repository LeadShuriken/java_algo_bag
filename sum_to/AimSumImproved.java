package sum_to;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import accessor.Accessor;

public class AimSumImproved<T> extends AimSum<T> {

    private Accessor<T> accessor;

    // T(N)=aNb (p law)
    // (b slope) (Nb order of growth)
    // (a scale of process)
    public CountSets count(T[] a, int b, double aim, Accessor<T> accessor) {
        // n^b makes space complexity too big
        List<int[]> sets = new ArrayList<>();

        this.accessor = accessor;
        int count = findWithSets(a, a.length, b, aim, 0, 0, 0, new int[b], b, sets);
        return new CountSets(sets, count);
    }

    private int findWithSetsPair(T[] a, int a_len, double aim, int incremIndex, double delta, int count, int[] arr,
            int arr_len, List<int[]> sets) {
        Map<Double, List<Integer>> numMap = new HashMap<>();
        for (int j = incremIndex; j < a_len; j++) {
            double temp = aim - (accessor.value(a[j]) + delta);
            if (numMap.containsKey(temp)) {
                count += addSet(numMap, temp, j, arr, arr_len, sets);
            }
            addComplement(numMap, a, j);
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

    private int addSet(Map<Double, List<Integer>> numMap, double temp, int j, int[] arr, int arr_len,
            List<int[]> sets) {
        List<Integer> indexCom = numMap.get(temp);
        for (Integer integer : indexCom) {
            arr[arr_len - 2] = integer;
            arr[arr_len - 1] = j;
            sets.add(arr.clone());
        }
        return indexCom.size();
    }

    private void addComplement(Map<Double, List<Integer>> numMap, T[] a, int j) {
        double res = accessor.value(a[j]);
        if (numMap.containsKey(res)) {
            numMap.get(res).add(j);
        } else {
            List<Integer> c = new ArrayList<Integer>();
            c.add(j);
            numMap.put(res, c);
        }
    }
}
