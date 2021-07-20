package sum_to;

import java.util.List;

import utils.CountSetsPojo;

public class AimSumCount extends AimSum {
    // TC: O(n^b)
    // T(N)=aNb (p law)
    // (b slope) (Nb order of growth)
    // (a scale of process)
    public CountSetsPojo count(int[] a, int b, int aim) {
        return new CountSetsPojo(null, findCount(a, b, a.length, aim, 0, 0, 0));
    }

    // TC: O(n^b)
    private int findCount(int[] a, int b, int a_len, int aim, int pIndex, int count, int combinedValue) {
        for (int i = pIndex; i < a_len - (b - 1); i++) {
            if (b > 1) {
                count = findCount(a, b - 1, a_len, aim, i + 1, count, combinedValue + a[i]);
            } else if (combinedValue + a[i] == aim) {
                count++;
            }
        }
        return count;
    }

    protected int findWithSets(int[] a, int a_len, int b, int aim, int pIndex, int count, int combinedValue, int[] arr,
            int arr_len, List<int[]> sets) {
        return 0;
    }
}
