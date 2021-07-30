package intersection;

import sort.interfaces.Sort;
import sort.QuickSort;

public class IntersectionCount {

    public <T extends Comparable<T>> int countIntersection(T[] a, T[] b) {
        Sort<T> sr = new QuickSort<>();

        sr.sort(a, 0, a.length, T::compareTo);
        sr.sort(b, 0, a.length, T::compareTo);

        int i = 0;
        int j = 0;
        int count = 0;

        while (i < a.length && j < b.length) {
            if (a[i].compareTo(b[j]) == 0) {
                count++;
                i++;
                j++;
            } else if (a[i].compareTo(b[j]) < 0)
                i++;
            else
                j++;
        }
        return count;
    }
}
