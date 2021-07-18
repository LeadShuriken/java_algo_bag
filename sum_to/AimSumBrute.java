package sum_to;

import java.util.ArrayList;
import java.util.List;

import utils.CountSetsPojo;

public class AimSumBrute extends AimSum {
    // TC: O(n^b)
    // T(N)=aNb (p law)
    // (b slope) (Nb order of growth)
    // (a scale of process)
    public CountSetsPojo count(int[] a, int b, int aim) {
        // n^b makes space complexity too big
        List<int[]> sets = new ArrayList<>();
        int count = findWithSets(a, a.length, b, aim, 0, 0, 0, new int[b], b, sets);
        return new CountSetsPojo(sets, count);
    }

    // TC: O(n^b) (brute force)
    protected int findWithSets(int[] a, int a_len, int b, int aim, int pIndex, int count, int combinedValue, int[] arr,
            int arr_len, List<int[]> sets) {
        for (int i = pIndex; i < a_len; i++) {
            arr[arr_len - b] = i;
            if (b > 1) {
                count = findWithSets(a, a_len, b - 1, aim, i + 1, count, combinedValue + a[i], arr, arr_len, sets);
            } else if (combinedValue + a[i] == aim) {
                sets.add(arr.clone());
                count++;
            }
        }
        return count;
    }
}
