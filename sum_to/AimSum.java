package sum_to;

import java.util.List;

import utils.CountSetsPojo;

public abstract class AimSum {

    public abstract CountSetsPojo count(int[] a, int b, int aim);

    protected abstract int findWithSets(int[] a, int b, int aim, int pIndex, int count, int combinedValue, int[] arr,
            List<int[]> sets);
}
