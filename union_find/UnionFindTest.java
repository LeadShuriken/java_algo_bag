package union_find;

import utils.StdInReader;

public class UnionFindTest {
    public static void main(String[] args) {
        StdInReader b = new StdInReader();
        int N = b.readInt();
        QuickFindUF uf = new QuickFindUF(N);
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
