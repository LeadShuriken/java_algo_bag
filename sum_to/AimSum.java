package sum_to;

public class AimSum {
    // TC: O(n^3)
    // T(N)=aNb (p. law)
    // (b slope) (Nb order of growth)
    // (a scale of process)
    public int count(int[] a, int b, int aim) {
        return findAim(a, new int[b], -1, 0, aim);
    }

    private int findAim(int[] a, int[] b, int lind, int count, int aim) {
        for (int i = ++lind; i < a.length; i++) {
            b[lind] = a[i];
            if (lind == b.length - 1 && findSum(b) == aim) {
                count++;
            }
            count = findAim(a, b, i, count, aim);
        }
        return count;
    }

    private int findSum(int[] array) {
        int sum = 0;
        for (int value : array) {
            sum += value;
        }
        return sum;
    }
}
