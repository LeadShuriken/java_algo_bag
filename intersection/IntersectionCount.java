package intersection;

import intersection.interfaces.IntArrayIntersection;
import intersection.interfaces.ObjectArrayIntersection;
import sort.QuickSort;
import sort.interfaces.IntArraySort;
import sort.interfaces.ObjectArraySort;

public class IntersectionCount implements IntArrayIntersection, ObjectArrayIntersection {

    public <T extends Comparable<T>> int countIntersection(T[] a, T[] b) {
        ObjectArraySort sr = new QuickSort();
        sr.sort(a);
        sr.sort(b);

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

    public int countIntersection(int[] a, int[] b) {
        IntArraySort sr = new QuickSort();
        sr.sort(a);
        sr.sort(b);

        int i = 0;
        int j = 0;
        int count = 0;

        while (i < a.length && j < b.length) {
            if (a[i] == b[j]) {
                count++;
                i++;
                j++;
            } else if (a[i] < b[j])
                i++;
            else
                j++;
        }
        return count;
    }
}
