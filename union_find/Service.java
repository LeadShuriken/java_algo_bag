package union_find;

import utils.StdInReader;

public class Service {
    public static void main(String[] args) {
        StdInReader b = new StdInReader();
        int N = b.readInt();
        UnionFind uf = new QuickFindUF(N);
        // UnionFind uf = new QuickUnionUF(N);
        // UnionFind uf = new QuickUnionImpUF(N);
        while (true) {
            try {
                int p = b.readInt();
                int q = b.readInt();
                if (!uf.connected(p, q)) {
                    uf.union(p, q);
                    System.out.println(p + " " + q);
                }
            } catch (Exception e) {
                break;
            }
        }
    }
}
