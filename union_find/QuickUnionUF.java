package union_find;

public class QuickUnionUF extends UnionFind {

    public QuickUnionUF(int N) {
        super(N);
    }

    private int root(int i) {
        while (i != id[i])
            i = id[i];
        return i;
    }

    // TC: O(n)
    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    // TC: O(n)
    public void union(int p, int q) {
        int pid = root(p);
        int qid = root(q);
        id[pid] = qid;
    }
}
