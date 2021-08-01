package sum_to;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import sum_to.interfaces.AimSum;
import sum_to.interfaces.SetCount;

public class AimSumImproved<Type, Accessor extends Function<Type, Double>> extends SetCount<Type, Accessor>
        implements AimSum<Type, Accessor, CountSets> {

    // T(N)=aNb (p law)
    // (b slope) (Nb order of growth)
    // (a scale of process)
    public CountSets count(Type[] a, int b, double aim, Accessor accessor) {
        this.accessor = accessor;
        this.a_len = a.length;
        this.aim = aim;
        this.arr_len = b;

        // n^b makes space complexity too big
        this.sets = new ArrayList<>();
        return new CountSets(this.sets, findWithSets(a, b, 0, 0, 0, new int[b]));
    }

    private int findWithSetsPair(Type[] a, int incremIndex, double delta, int count, int[] arr) {
        Map<Double, List<Integer>> numMap = new HashMap<>();
        for (int j = incremIndex; j < a_len; j++) {
            double temp = aim - (accessor.apply(a[j]) + delta);
            if (numMap.containsKey(temp)) {
                count += addSet(numMap, temp, j, arr);
            }
            addComplement(numMap, a, j);
        }
        return count;
    }

    // TC: O((n-b-2)^b+n)
    protected int findWithSets(Type[] a, int b, int incremIndex, int count, double combinedValue, int[] arr) {
        if (arr_len == 2) {
            return findWithSetsPair(a, 0, 0, count, arr);
        }

        for (int i = incremIndex; i < a_len - (b - 1); i++) {
            arr[arr_len - b] = i;
            double res = accessor.apply(a[i]) + combinedValue;
            if (b > 3) {
                count = findWithSets(a, b - 1, i + 1, count, res, arr);
            } else {
                count = findWithSetsPair(a, i + 1, res, count, arr);
            }
        }
        return count;
    }

    private int addSet(Map<Double, List<Integer>> numMap, double temp, int j, int[] arr) {
        List<Integer> indexCom = numMap.get(temp);
        for (Integer integer : indexCom) {
            arr[arr_len - 2] = integer;
            arr[arr_len - 1] = j;
            sets.add(arr.clone());
        }
        return indexCom.size();
    }

    private void addComplement(Map<Double, List<Integer>> numMap, Type[] a, int j) {
        double res = accessor.apply(a[j]);
        if (numMap.containsKey(res)) {
            numMap.get(res).add(j);
        } else {
            List<Integer> c = new ArrayList<Integer>();
            c.add(j);
            numMap.put(res, c);
        }
    }
}
