package union_find;

import java.util.ArrayList;
import java.util.List;

public class QuickUnionImpUF extends UnionFind {
    private int[] sz;

    public QuickUnionImpUF(int N) {
        super(N);
        sz = new int[N];
    }

    // ABS Path Comp
    // private int root(int i) {
    // List<Integer> temp = new ArrayList<>();
    // while (i != id[i]) {
    // temp.add(i);
    // i = id[i];
    // }
    // for (Integer integer : temp) {
    // id[integer] = i;
    // }
    // return i;
    // }

    private int root(int i) {
        while (i != id[i]) {
            id[i] = id[id[i]];
            i = id[i];
        }
        return i;
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
        if (sz[pid] < sz[qid]) {
            id[pid] = qid;
            sz[qid] += sz[pid];
        } else {
            id[qid] = pid;
            sz[pid] += sz[qid];
        }
    }
}
