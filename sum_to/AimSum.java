package sum_to;

public class AimSum {
    // TC: O(n^3)
    // T(N)=aNb (p law)
    // (b slope) (Nb order of growth)
    // (a scale of process)
    public int count(int[] a, int b, int aim) {
        return findAim(a, b, aim, 0, 0, 0);
    }

    // TC: O(n^3)
    private int findAim(int[] a, int b, int aim, int lind, int count, int val) {
        for (int i = lind; i < a.length; i++) {
            if (b > 1) {
                count = findAim(a, b - 1, aim, i + 1, count, val + a[i]);
            } else if (val + a[i] == aim) {
                count++;
            }
        }
        return count;
    }
}
