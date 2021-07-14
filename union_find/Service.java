package union_find;

import utils.StdInReader;

public class Service {
    public static void main(String[] args) {
        StdInReader b = new StdInReader();
        System.out.println("Init N ..");
        int N = b.readInt();
        // UnionFind uf = new QuickFindUF(N);
        // UnionFind uf = new QuickUnionUF(N);
        QuickUnionImpUF uf = new QuickUnionImpUF(N);
        System.out.println("Init Commands ..");
        while (true) {
            try {
                int p = b.readInt();
                uf.validate(p);
                int q = b.readInt();
                uf.validate(q);
                long start = System.nanoTime();
                if (!uf.connected(p, q)) {
                    uf.union(p, q);
                    System.out.printf("Unioned : %d - %d for %d ns.%n", p, q, System.nanoTime() - start);
                } else {
                    System.out.printf("Connected : %d - %d for %d ns.%n", p, q, System.nanoTime() - start);
                }
                System.out.printf("Component Max is: %d%n", uf.findMax(q));
                System.out.printf("Component Min is: %d%n", uf.findMin(q));
                System.out.printf("Component Depth is: %d%n", uf.getDepth(q));
                System.out.println("----------------------");
            } catch (Exception e) {
                break;
            }
        }
    }
}
