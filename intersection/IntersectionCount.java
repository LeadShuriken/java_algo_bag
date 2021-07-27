package intersection;

import java.util.Comparator;

import comparator.ComparableComparator;

import sort.interfaces.Sort;
import sort.QuickSort;

public class IntersectionCount {

    public <T extends Comparable<T>> int countIntersection(T[] a, T[] b) {
        Sort<T> sr = new QuickSort<>();
        Comparator<T> comp = new ComparableComparator<>();

        sr.sort(a, 0, a.length, comp);
        sr.sort(b, 0, a.length, comp);

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
