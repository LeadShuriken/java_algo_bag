package sum_to;

import java.util.ArrayList;
import java.util.List;

import search.BinarySearch;
import utils.CountSetsPojo;

public class AimSumBinarySearch extends AimSum {

    private BinarySearch s;

    // T(N)=aNb (p law)
    // (b slope) (Nb order of growth)
    // (a scale of process)
    public CountSetsPojo count(int[] a, int b, int aim) {
        // n^b makes space complexity too big
        assert (a.length >= 2);
        s = new BinarySearch();
        List<int[]> sets = new ArrayList<>();
        int count = findWithSets(a, a.length, b, aim, 0, 0, 0, new int[b], b, sets);
        return new CountSetsPojo(sets, count);
    }

    private int findWithSetsPair(int[] a, int a_len, int aim, int incremIndex, int delta, int count, int[] arr,
            int arr_len, List<int[]> sets) {
        for (int j = incremIndex; j < a_len; j++) {
            int temp = aim - (a[j] + delta);
            int l = s.first(a, incremIndex, j - 1, temp);
            if (l != -1) {
                count += addSet(l, l == j - 1 ? j : s.last(a, l, j - 1, temp) + 1, arr, arr_len, sets);
            }
        }
        return count;
    }

    // TC: O((n-b-2)^b+n)
    protected int findWithSets(int[] a, int a_len, int b, int aim, int incremIndex, int count, int val, int[] arr,
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
