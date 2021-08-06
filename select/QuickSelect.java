package select;

import java.util.Comparator;

import misc.RandomUtils;
import select.interfaces.Select;
import sort.QuickSort;

public class QuickSelect<T> extends QuickSort<T> implements Select<T> {

    public T select(T[] arr, Comparator<? super T> d, T k) {
        RandomUtils.shuffle(arr);

        int lo = 0, hi = arr.length - 1;
        while (hi > lo) {
            int j = partition(arr, lo, hi, med(arr, lo, (lo + hi) / 2, hi, d), d);

            if (less(arr[j], k, d))
                lo = j + 1;
            else if (less(k, arr[j], d))
                hi = j - 1;
            else
                return arr[j];
        }
        return d.compare(arr[0], k) == 0 ? arr[0] : null;
    }
}
