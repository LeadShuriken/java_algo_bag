package sum_to;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import utils.CountSetsPojo;

public class AimSumImproved extends AimSum {

    // T(N)=aNb (p law)
    // (b slope) (Nb order of growth)
    // (a scale of process)
    public CountSetsPojo count(int[] a, int b, int aim) {
        // n^b makes space complexity too big
        assert (a.length >= 2);
        List<int[]> sets = new ArrayList<>();
        int count = findWithSets(a, a.length, b, aim, 0, 0, 0, new int[b], b, sets);
        return new CountSetsPojo(sets, count);
    }

    // TC: O(n^b-2+n) (requirement is that the array is sorted ~O(nlogn))
    protected int findWithSets(int[] a, int a_len, int b, int aim, int incremIndex, int count, int val, int[] arr,
            int arr_len, List<int[]> sets) {

        if (arr_len == 2) {
            Map<Integer, List<Integer>> numMap = new HashMap<>();
            for (int i = 0; i < a_len; ++i) {
                int temp = aim - a[i];
                if (numMap.containsKey(temp)) {
                    count += addSet(numMap, temp, i, arr, arr_len, sets);
                }
                addComplement(numMap, a, i);
            }
            return count;
        }

        for (int i = incremIndex; i < a_len - 2; i++) {
            arr[arr_len - b] = i;
            if (b > 3) {
                count = findWithSets(a, a_len, b - 1, aim, i + 1, count, val + a[i], arr, arr_len, sets);
            } else {
                Map<Integer, List<Integer>> numMap = new HashMap<>();
                for (int j = i + 1; j < a_len; ++j) {
                    int temp = aim - (a[j] + a[i] + val);
                    if (numMap.containsKey(temp)) {
                        count += addSet(numMap, temp, j, arr, arr_len, sets);
                    }
                    addComplement(numMap, a, j);
                }
            }
        }
        return count;
    }

    private int addSet(Map<Integer, List<Integer>> numMap, int temp, int j, int[] arr, int arr_len, List<int[]> sets) {
        List<Integer> indexCom = numMap.get(temp);
        int count = 0;
        for (Integer integer : indexCom) {
            arr[arr_len - 2] = integer;
            arr[arr_len - 1] = j;
            sets.add(arr.clone());
            count++;
        }
        return count;
    }

    private void addComplement(Map<Integer, List<Integer>> numMap, int[] a, int j) {
        if (numMap.containsKey(a[j])) {
            numMap.get(a[j]).add(j);
        } else {
            List<Integer> c = new ArrayList<Integer>();
            c.add(j);
            numMap.put(a[j], c);
        }
    }
}
