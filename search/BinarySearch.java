package search;

public class BinarySearch extends Search {

    private <T extends Comparable<T>> int binarySearch(T arr[], int l, int r, T x) {
        if (r >= l) {
            int mid = l + (r - l) / 2;
            int res = arr[mid].compareTo(x);

            if (res == 0)
                return mid;

            if (res > 0)
                return binarySearch(arr, l, mid - 1, x);
            return binarySearch(arr, mid + 1, r, x);
        }
        return -1;
    }

    public <T extends Comparable<T>> int first(T arr[], int l, int r, T key) {
        int ans = -1;

        while (l <= r) {
            int mid = l + (r - l + 1) / 2;
            int res = arr[mid].compareTo(key);

            if (res < 0)
                l = mid + 1;
            else if (res > 0)
                r = mid - 1;
            else if (res == 0) {
                ans = mid;
                r = mid - 1;
            }
        }
        return ans;
    }

    public <T extends Comparable<T>> int last(T arr[], int l, int r, T key) {
        int ans = -1;

        while (l <= r) {
            int mid = l + (r - l + 1) / 2;
            int res = arr[mid].compareTo(key);

            if (res < 0)
                l = mid + 1;
            else if (res > 0)
                r = mid - 1;
            else if (res == 0) {
                ans = mid;
                l = mid + 1;
            }
        }
        return ans;
    }

    public <T extends Comparable<T>> int leastgreater(T arr[], int l, int r, T key) {
        int ans = -1;

        while (l <= r) {
            int mid = l + (r - l + 1) / 2;
            int res = arr[mid].compareTo(key);

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

    public <T extends Comparable<T>> int greatestlesser(T arr[], int l, int r, T key) {
        int ans = -1;

        while (l <= r) {
            int mid = l + (r - l + 1) / 2;
            int res = arr[mid].compareTo(key);

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

    public <T extends Comparable<T>> int search(T[] a, T b) {
        int n = a.length;
        return binarySearch(a, 0, n - 1, b);
    }
}
