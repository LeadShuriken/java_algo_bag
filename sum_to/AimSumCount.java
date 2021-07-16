package sum_to;

public class AimSumCount {
    // TC: O(n^b)
    // T(N)=aNb (p law)
    // (b slope) (Nb order of growth)
    // (a scale of process)
    public int count(int[] a, int b, int aim) {
        return findCount(a, b, aim, 0, 0, 0);
    }

    // TC: O(n^b)
    private int findCount(int[] a, int b, int aim, int pIndex, int count, int combinedValue) {
        for (int i = pIndex; i < a.length; i++) {
            if (b > 1) {
                count = findCount(a, b - 1, aim, i + 1, count, combinedValue + a[i]);
            } else if (combinedValue + a[i] == aim) {
                count++;
            }
        }
        return count;
    }
}
