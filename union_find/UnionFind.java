package union_find;

public abstract class UnionFind {

    protected int count;
    protected int[] id;

    // TC: O(n)
    protected UnionFind(int N) {
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++)
            id[i] = i;
    }

    public int count() {
        return count;
    }

    public void validate(int p) {
        int n = id.length;
        if (p < 0 || p >= n) {
            throw new IllegalArgumentException("Index " + p + " is not invalid.");
        }
    }

    abstract boolean connected(int p, int q);

    abstract void union(int p, int q);
}
