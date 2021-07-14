package union_find;

public abstract class UnionFind {

    protected int count;

    protected int[] id;
    protected int[] base;
    protected int[] max;
    protected int[] min;
    protected int[] sz;

    protected int N;

    // TC: O(n)
    protected UnionFind(int N) {
        count = N;
        this.N = N;
        id = new int[N];
        sz = new int[N];
        max = new int[N];
        min = new int[N];
        base = new int[N];
        for (int i = 0; i < N; i++) {
            sz[i] = 1;
            id[i] = i;
            max[i] = i;
            min[i] = i;
            base[i] = i;
        }
    }

    abstract boolean connected(int p, int q);

    abstract void union(int p, int q);

    public int count() {
        return count;
    }

    public void validate(int p) {
        int n = id.length;
        if (p < 0 || p >= n) {
            throw new IllegalArgumentException("Index " + p + " is not invalid.");
        }
    }

    public int findSetMax(int p) {
        int max = id[p];
        for (int i = 0; i < N; i++) {
            if (id[i] == id[p] && i > max) {
                max = i;
            }
        }
        return max;
    }

    public int findSetMin(int p) {
        int min = id[p];
        for (int i = 0; i < N; i++) {
            if (id[i] == id[p] && i < min) {
                min = i;
            }
        }
        return min;
    }

    public int getSetDepth(int i) {
        return sz[root(i)];
    }

    // TC: O(log*n)/2
    protected int root(int i) {
        while (i != id[i]) {
            id[i] = id[id[i]];
            i = id[i];
        }
        return i;
    }

    public void remove(int i) {
        union(i++, i);
    }
}
