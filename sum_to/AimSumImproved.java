package sum_to;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import utils.CountSetsPojo;

public class AimSumImproved extends AimSum {
    // TC: O(logn)
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

    // TC: O(n^b-1+logn) (requirement is that the array is sorted ~O(nlogn))
    protected int findWithSetsP(int[] a, int a_len, int b, int aim, int incremIndex, int count, int val, int[] arr,
            int arr_len, List<int[]> sets) {
        int l = incremIndex;
        int r = a_len - 1;

        while (l <= r) {
            if (b > 1) {
                arr[arr_len - b] = l;
                count = findWithSetsP(a, a_len, b - 1, aim, l + 1, count, val + a[l], arr, arr_len, sets);
                l++;
            } else {
                arr[arr_len - b] = r;
                int t = val + a[r];
                if (t == aim) {
                    sets.add(arr.clone());
                    count++;
                    r--;
                } else if (t < aim)
                    l++;
                else
                    r--;
            }
        }

        return count;
    }

    // TC: O(n^b-1+logn) (requirement is that the array is sorted ~O(nlogn))
    protected int findWithSets(int[] a, int a_len, int b, int aim, int incremIndex, int count, int val, int[] arr,
            int arr_len, List<int[]> sets) {

        if (arr_len == 2) {
            Map<Integer, List<Integer>> numMap = new HashMap<>();
            for (int i = incremIndex; i < a_len; i++) {
                int complement = aim - a[i];
                if (numMap.containsKey(complement)) {
                    List<Integer> indexCom = numMap.get(complement);
                    for (Integer integer : indexCom) {
                        arr[0] = a[integer];
                        arr[1] = a[i];
                        sets.add(arr.clone());
                        count++;
                    }
                } else {
                    if (numMap.containsKey(a[i])) {
                        numMap.get(a[i]).add(i);
                    } else {
                        List<Integer> temp = new ArrayList<Integer>();
                        temp.add(i);
                        numMap.put(a[i], temp);
                    }
                }
            }
            return count;
        }

        for (int i = incremIndex; i < a_len - (b - 1); i++) {
            arr[arr_len - b] = i;
            if (b > 3) {
                count = findWithSets(a, a_len, b - 1, aim, i + 1, count, val + a[i], arr, arr_len, sets);
            } else {
                val += a[i];
                int l = i + 1;
                int r = a_len - 1;
                while (l < r) {
                    arr[arr_len - (b - 1)] = l;
                    arr[arr_len - (b - 2)] = r;
                    int t = val + a[l] + a[r];
                    if (t == aim) {
                        sets.add(arr.clone());
                        count++;
                        l++;
                    } else if (t < aim)
                        l++;
                    else
                        r--;
                }
                val -= a[i];
            }
        }
        return count;
    }
}
