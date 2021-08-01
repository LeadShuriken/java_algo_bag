package sum_to;

import java.util.function.Function;

import sum_to.interfaces.AimSum;
import sum_to.interfaces.SumCount;

public class AimSumCount<Type, Accessor extends Function<Type, Double>> extends SumCount<Type, Accessor>
        implements AimSum<Type, Accessor, Integer> {

    // TC: O(n^b)
    // T(N)=aNb (p law)
    // (b slope) (Nb order of growth)
    // (a scale of process)
    public Integer count(Type[] a, int b, double aim, Accessor accessor) {
        this.accessor = accessor;
        this.a_len = a.length;
        this.aim = aim;
        return findCount(a, b, 0, 0, 0);
    }

    // TC: O(n^b)
    protected int findCount(Type[] a, int b, int pIndex, int count, double combinedValue) {
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
