package sum_to;

import java.util.function.Function;

import sum_to.interfaces.AimSum;
import sum_to.interfaces.SumCount;

public class AimSumCount<T, R extends Function<T, Double>> extends SumCount<T, R>
        implements AimSum<T, Double, R, Long> {

    // TC: O(n^b)
    // T(N)=aNb (p law)
    // (b slope) (Nb order of growth)
    // (a scale of process)
    public Long count(T[] a, int b, Double aim, R accessor) {
        this.accessor = accessor;
        this.a_len = a.length;
        this.aim = aim;
        return findCount(a, b, 0, 0, 0);
    }

    // TC: O(n^b)
    protected long findCount(T[] a, int b, int pIndex, long count, double combinedValue) {
        for (int i = pIndex; i < a_len - (b - 1); i++) {
            double val = accessor.apply(a[i]);
            if (b > 1) {
                count = findCount(a, b - 1, i + 1, count, combinedValue + val);
            } else if (combinedValue + val == aim) {
                count++;
            }
        }
        return count;
    }
}
