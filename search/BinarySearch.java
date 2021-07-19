package search;

public class BinarySearch extends Search {

    private int binarySearch(int arr[], int l, int r, int x) {
        if (r >= l) {
            int mid = l + (r - l) / 2;
            if (arr[mid] == x)
                return mid;

            if (arr[mid] > x)
                return binarySearch(arr, l, mid - 1, x);
            return binarySearch(arr, mid + 1, r, x);
        }
        return -1;
    }

    public int first(int arr[], int l, int r, int key) {
        int ans = -1;

        while (l <= r) {
            int mid = l + (r - l + 1) / 2;
            int midVal = arr[mid];

            if (midVal < key)
                l = mid + 1;
            else if (midVal > key)
                r = mid - 1;
            else if (midVal == key) {
                ans = mid;
                r = mid - 1;
            }
        }
        return ans;
    }

    public int last(int arr[], int l, int r, int key) {
        int ans = -1;

        while (l <= r) {
            int mid = l + (r - l + 1) / 2;
            int midVal = arr[mid];

            if (midVal < key)
                l = mid + 1;
            else if (midVal > key)
                r = mid - 1;
            else if (midVal == key) {
                ans = mid;
                l = mid + 1;
            }
        }
        return ans;
    }

    public int leastgreater(int arr[], int l, int r, int key) {
        int ans = -1;

        while (l <= r) {
            int mid = l + (r - l + 1) / 2;
            int midVal = arr[mid];

            if (midVal < key)
                l = mid + 1;
            else if (midVal > key) {
                ans = mid;
                r = mid - 1;
            } else if (midVal == key)
                l = mid + 1;

        }
        return ans;
    }

    public int greatestlesser(int arr[], int l, int r, int key) {
        int ans = -1;

        while (l <= r) {
            int mid = l + (r - l + 1) / 2;
            int midVal = arr[mid];

            if (midVal < key) {
                ans = mid;
                l = mid + 1;
            } else if (midVal > key)
                r = mid - 1;
            else if (midVal == key)
                r = mid - 1;
        }
        return ans;
    }

    public int search(int[] a, int b) {
        int n = a.length;
        return binarySearch(a, 0, n - 1, b);
    }
}
