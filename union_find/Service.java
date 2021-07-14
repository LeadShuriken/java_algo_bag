package union_find;

import utils.StdInReader;

public class Service {
    public static void main(String[] args) {
        StdInReader b = new StdInReader();
        System.out.println("Init N ..");
        int N = b.readInt();
        UnionFind uf = new QuickFindUF(N);
        // UnionFind uf = new QuickUnionUF(N);
        // UnionFind uf = new QuickUnionImpUF(N);
        System.out.println("Init Commands ..");
        Service.quickUnionFindWorkflow(uf, b);
        // Service.removeSuccessorWorkflow(uf, b);
    }

    public static void quickUnionFindWorkflow(UnionFind uf, StdInReader b) {
        while (true) {
            try {
                int[] pair = b.readPair();
                int p = pair[0];
                int q = pair[1];
                uf.validate(p);
                uf.validate(q);
                long start = System.nanoTime();
                if (!uf.connected(p, q)) {
                    uf.union(p, q);
                    System.out.printf("Unioned : %d - %d for %d ns.%n", p, q, System.nanoTime() - start);
                } else {
                    System.out.printf("Connected : %d - %d for %d ns.%n", p, q, System.nanoTime() - start);
                }
                System.out.printf("Component Max is: %d%n", uf.findSetMax(q));
                System.out.printf("Component Min is: %d%n", uf.findSetMin(q));
                System.out.printf("Component Depth is: %d%n", uf.getSetDepth(q));
                System.out.println("----------------------");
            } catch (Exception e) {
                break;
            }
        }
    }

    public static void removeSuccessorWorkflow(QuickUnionImpUF uf, StdInReader b) {
        while (true) {
            try {
                int p = b.readInt();
                uf.validate(p);
                long start = System.nanoTime();
                uf.remove(p);
                System.out.printf("Element: %d removed%n", p--);
                System.out.printf("Sucessor of: %d is %d%n", p, uf.successor(p));
                System.out.printf("Done : %d for %d ns.%n", ++p, System.nanoTime() - start);
                System.out.println("----------------------");
            } catch (Exception e) {
                break;
            }
        }
    }
}
