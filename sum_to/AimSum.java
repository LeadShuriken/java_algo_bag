package sum_to;

import java.util.ArrayList;
import java.util.List;

public class AimSum {
    // TC: O(n^b)
    // T(N)=aNb (p law)
    // (b slope) (Nb order of growth)
    // (a scale of process)
    public int count(int[] a, int b, int aim) {
        return findCount(a, b, aim, 0, 0, 0);
    }

    // TC: O(n^b)
    private int findCount(int[] a, int b, int aim, int lind, int count, int val) {
        for (int i = lind; i < a.length; i++) {
            if (b > 1) {
                count = findCount(a, b - 1, aim, i + 1, count, val + a[i]);
            } else if (val + a[i] == aim) {
                count++;
            }
        }
        return count;
    }

    public CountSetsPojo countWithSets(int[] a, int b, int aim) {
        // n^b makes space complexity too big
        List<int[]> sets = new ArrayList<>();
        int count = findCountWithSets(a, b, aim, 0, 0, 0, new int[b], sets);
        return new CountSetsPojo(sets, count);
    }

    // TC: O(n^b)
    private int findCountWithSets(int[] a, int b, int aim, int lind, int count, int val, int[] arr, List<int[]> sets) {
        for (int i = lind; i < a.length; i++) {
            arr[arr.length - b] = i;
            if (b > 1) {
                count = findCountWithSets(a, b - 1, aim, i + 1, count, val + a[i], arr, sets);
            } else if (val + a[i] == aim) {
                sets.add(arr.clone());
                count++;
            }
        }
        return count;
    }
}
