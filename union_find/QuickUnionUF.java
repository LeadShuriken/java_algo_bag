package union_find;

public class QuickUnionUF extends UnionFind {

    public QuickUnionUF(int N) {
        super(N);
    }

    // TC: O(n)
    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    // TC: O(n)
    public void union(int p, int q) {
        int pid = root(p);
        int qid = root(q);
        int newSetSize = sz[q] + sz[p];
        for (int i = 0; i < N; i++) {
            if (id[i] == id[p] || id[i] == id[q]) {
                sz[i] = newSetSize;
            }
        }
        id[pid] = qid;
    }
}
