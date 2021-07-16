package sum_to;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AimSumLogTime extends AimSum {
    // TC: O(logn)
    // T(N)=aNb (p law)
    // (b slope) (Nb order of growth)
    // (a scale of process)
    public CountSetsPojo count(int[] a, int b, int aim) {
        // n^b makes space complexity too big
        Arrays.sort(a);
        List<int[]> sets = new ArrayList<>();
        int count = findWithSets(a, b, aim, 0, 0, 0, new int[b], sets);
        return new CountSetsPojo(sets, count);
    }

    // TC: O(logn) (requirement is that the array is sorted Arrays.sort() ~O(nlogn))
    protected int findWithSets(int[] a, int b, int aim, int incremIndex, int count, int val, int[] arr,
            List<int[]> sets) {
        int l = incremIndex;
        int r = a.length - 1;

        while (l <= r) {
            if (b > 1) {
                arr[arr.length - b] = a[l];
                count = findWithSets(a, b - 1, aim, l + 1, count, val + a[l], arr, sets);
                l++;
            } else {
                arr[arr.length - b] = a[r];
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
}
