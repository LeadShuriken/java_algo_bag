package sum_to;

import java.util.List;

import pojos.CountSetsPojo;

public abstract class AimSum {

    public abstract CountSetsPojo count(Integer[] a, int b, int aim);

    protected abstract int findWithSets(Integer[] a, int a_len, int b, int aim, int pIndex, int count,
            int combinedValue, int[] arr, int arr_len, List<int[]> sets);
}
