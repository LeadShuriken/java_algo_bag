package sum_to;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import pojos.CountSetsPojo;

public class AimSumImproved extends AimSum {

    // T(N)=aNb (p law)
    // (b slope) (Nb order of growth)
    // (a scale of process)
    public CountSetsPojo count(Integer[] a, int b, int aim) {
        // n^b makes space complexity too big
        assert (a.length >= 2);
        List<int[]> sets = new ArrayList<>();
        int count = findWithSets(a, a.length, b, aim, 0, 0, 0, new int[b], b, sets);
        return new CountSetsPojo(sets, count);
    }

    private int findWithSetsPair(Integer[] a, int a_len, int aim, int incremIndex, int delta, int count, int[] arr,
            int arr_len, List<int[]> sets) {
        Map<Integer, List<Integer>> numMap = new HashMap<>();
        for (int j = incremIndex; j < a_len; j++) {
            int temp = aim - (a[j] + delta);
            if (numMap.containsKey(temp)) {
                count += addSet(numMap, temp, j, arr, arr_len, sets);
            }
            addComplement(numMap, a, j);
        }
        return count;
    }

    // TC: O((n-b-2)^b+n)
    protected int findWithSets(Integer[] a, int a_len, int b, int aim, int incremIndex, int count, int val, int[] arr,
            int arr_len, List<int[]> sets) {
        if (arr_len == 2) {
            return findWithSetsPair(a, a_len, aim, 0, 0, count, arr, arr_len, sets);
        }

        for (int i = incremIndex; i < a_len - (b - 1); i++) {
            arr[arr_len - b] = i;
            if (b > 3) {
                count = findWithSets(a, a_len, b - 1, aim, i + 1, count, val + a[i], arr, arr_len, sets);
            } else {
                count = findWithSetsPair(a, a_len, aim, i + 1, a[i] + val, count, arr, arr_len, sets);
            }
        }
        return count;
    }

    private int addSet(Map<Integer, List<Integer>> numMap, int temp, int j, int[] arr, int arr_len, List<int[]> sets) {
        List<Integer> indexCom = numMap.get(temp);
        for (Integer integer : indexCom) {
            arr[arr_len - 2] = integer;
            arr[arr_len - 1] = j;
            sets.add(arr.clone());
        }
        return indexCom.size();
    }

    private void addComplement(Map<Integer, List<Integer>> numMap, Integer[] a, int j) {
        if (numMap.containsKey(a[j])) {
            numMap.get(a[j]).add(j);
        } else {
            List<Integer> c = new ArrayList<Integer>();
            c.add(j);
            numMap.put(a[j], c);
        }
    }
}
