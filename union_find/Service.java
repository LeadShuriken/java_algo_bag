package union_find;

import utils.StdInReader;

public class Service {
    public static void main(String[] args) {
        StdInReader b = new StdInReader();
        System.out.println("Init N");
        int N = b.readInt();
        // UnionFind uf = new QuickFindUF(N);
        // UnionFind uf = new QuickUnionUF(N);
        QuickUnionImpUF uf = new QuickUnionImpUF(N);
        while (true) {
            try {
                int p = b.readInt();
                int q = b.readInt();
                long start = System.nanoTime();
                if (!uf.connected(p, q)) {
                    uf.union(p, q);
                    System.out.printf("Unioned : %d , %d for %d ms.%n", p, q, System.nanoTime() - start);
                } else {
                    System.out.printf("Connected : %d , %d for %d ms.%n", p, q, System.nanoTime() - start);
                }
                System.out.println(uf.findMax(q));
                System.out.println(uf.findMin(q));
            } catch (Exception e) {
                break;
            }
        }
    }
}
