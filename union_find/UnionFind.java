package union_find;

public abstract class UnionFind {

    protected int[] id;

    // TC: O(n)
    protected UnionFind(int N) {
        id = new int[N];
        for (int i = 0; i < N; i++)
            id[i] = i;
    }

    abstract boolean connected(int p, int q);

    abstract void union(int p, int q);
}
