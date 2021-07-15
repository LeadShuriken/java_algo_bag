package union_find;

import utils.StdInReader;

public class Service {
    public static void main(String[] args) {
        System.out.println("Init N ..");
        int N = StdInReader.readInt();
        UnionFind uf = new QuickFindUF(N);
        // UnionFind uf = new QuickUnionUF(N);
        // UnionFind uf = new QuickUnionImpUF(N);
        System.out.println("Init Commands ..");
        Service.quickUnionFindWorkflow(uf);
        // Service.removeSuccessorWorkflow(uf, b);
    }

    public static void quickUnionFindWorkflow(UnionFind uf) {
        while (true) {
            try {
                int[] pair = StdInReader.readIntArray();
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

    public static void removeSuccessorWorkflow(QuickUnionImpUF uf) {
        while (true) {
            try {
                int p = StdInReader.readInt();
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
