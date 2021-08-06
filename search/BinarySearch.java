package search;

import java.util.Comparator;

public class BinarySearch<T> extends Search<T> {

    private int binarySearch(T arr[], int l, int r, T x, Comparator<? super T> d) {
        if (r >= l) {
            int mid = l + (r - l) / 2;
            int res = d.compare(arr[mid], x);

            if (res == 0)
                return mid;

            if (res > 0)
                return binarySearch(arr, l, mid - 1, x, d);
            return binarySearch(arr, mid + 1, r, x, d);
        }
        return -1;
    }

    public int first(T arr[], int l, int r, T key, Comparator<? super T> d) {
        int ans = -1;

        while (l <= r) {
            int mid = (l + r) / 2;
            int res = d.compare(arr[mid], key);

            if (res == 0) {
                ans = mid;
                r = mid - 1;
            } else if (res > 0)
                r = mid - 1;
            else {
                l = mid + 1;
            }
        }
        return ans;
    }

    public int last(T arr[], int l, int r, T key, Comparator<? super T> d) {
        int ans = -1;

        while (l <= r) {
            int mid = (l + r) / 2;
            int res = d.compare(arr[mid], key);

            if (res == 0) {
                ans = mid;
                l = mid + 1;
            } else if (res > 0)
                r = mid - 1;
            else
                l = mid + 1;
        }
        return ans;
    }

    public int leastgreater(T arr[], int l, int r, T key, Comparator<? super T> d) {
        int ans = -1;

        while (l <= r) {
            int mid = l + (r - l + 1) / 2;
            int res = d.compare(arr[mid], key);

            if (res < 0)
                l = mid + 1;
            else if (res > 0) {
                ans = mid;
                r = mid - 1;
            } else if (res == 0)
                l = mid + 1;

        }
        return ans;
    }

    public int greatestlesser(T arr[], int l, int r, T key, Comparator<? super T> d) {
        int ans = -1;

        while (l <= r) {
            int mid = l + (r - l + 1) / 2;
            int res = d.compare(arr[mid], key);

            if (res < 0) {
                ans = mid;
                l = mid + 1;
            } else if (res > 0)
                r = mid - 1;
            else if (res == 0)
                r = mid - 1;
        }
        return ans;
    }

    public int search(T[] a, T b, Comparator<? super T> d) {
        int n = a.length;
        return binarySearch(a, 0, n - 1, b, d);
    }
}
