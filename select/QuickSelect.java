package select;

import java.util.Comparator;

import misc.RandomUtils;
import select.interfaces.Select;
import sort.QuickSort;

public class QuickSelect<T> extends QuickSort<T> implements Select<T> {

    // k-th smallest element in an unordered list ~ O(N)
    public T select(T[] arr, Comparator<? super T> d, int k) {
        RandomUtils.shuffle(arr);

        int lo = 0, hi = arr.length - 1;
        while (hi > lo) {
            int j = partition(arr, lo, hi, med(arr, lo, (lo + hi) / 2, hi, d), d);

            if (j < k)
                lo = j + 1;
            else if (j > k)
                hi = j - 1;
            else
                return arr[k];
        }
        return arr[k];
    }
}
