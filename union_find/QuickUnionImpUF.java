package union_find;

public class QuickUnionImpUF extends UnionFind {

    public QuickUnionImpUF(int N) {
        super(N);
    }

    // TC: O(log*n)
    public int successor(int i) {
        return base[root(++i)];
    }

    // TC: O(log*n)/2
    public int findSetMax(int i) {
        return max[root(i)];
    }

    // TC: O(log*n)/2
    public int findSetMin(int i) {
        return min[root(i)];
    }

    // TC: O(log(n)) - Weighted
    // TC: O(log(n)) - Path Comp
    // TC: O(log*n) - Path Comp + Weighted
    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    // TC: O(log(n)) - Weighted
    // TC: O(log(n)) - Path Comp
    // TC: O(log*n) - Path Comp + Weighted
    public void union(int p, int q) {
        int pid = root(p);
        int qid = root(q);
        if (pid == qid)
            return;
        max[pid] = max[pid] > max[qid] ? max[pid] : max[qid];
        min[pid] = min[pid] < min[qid] ? min[pid] : min[qid];
        if (sz[pid] < sz[qid]) {
            id[pid] = qid;
            sz[qid] += sz[pid];
        } else {
            id[qid] = pid;
            sz[pid] += sz[qid];
            base[pid] = base[qid];
        }
        count--;
    }
}
