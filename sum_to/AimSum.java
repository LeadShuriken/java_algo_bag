package sum_to;

import java.util.List;

public abstract class AimSum {

    abstract protected CountSetsPojo count(int[] a, int b, int aim);

    abstract protected int findWithSets(int[] a, int b, int aim, int pIndex, int count, int combinedValue, int[] arr,
            List<int[]> sets);
}
