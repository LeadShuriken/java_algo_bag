package sort;

public class BogoSort extends Sort {
    // TC: O(nn!)
    public void sort(int[] a) {
        while (isSorted(a) == false)
            shuffle(a);
    }

    void shuffle(int[] a) {
        for (int i = 0; i < a.length; i++)
            swap(a, i, (int) (Math.random() * i));
    }

    void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    boolean isSorted(int[] a) {
        for (int i = 1; i < a.length; i++)
            if (a[i] < a[i - 1])
                return false;
        return true;
    }
}
