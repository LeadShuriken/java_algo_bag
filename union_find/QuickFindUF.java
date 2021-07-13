package union_find;

public class QuickFindUF extends UnionFind {

    public QuickFindUF(int N) {
        super(N);
    }

    // TC: O(1)
    public boolean connected(int p, int q) {
        return id[p] == id[q];
    }

    // TC: O(n)
    public void union(int p, int q) {
        int pid = id[p];
        int qid = id[q];
        for (int i = 0; i < id.length; i++)
            if (id[i] == pid)
                id[i] = qid;
    }
}
