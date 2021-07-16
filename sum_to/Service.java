package sum_to;

import utils.StdInReader;

public class Service {
    public static void main(String[] args) {
        AimSum ts = new AimSum();
        System.out.println("Init array of ints ..");
        int[] N = StdInReader.readIntArray();

        System.out.println("Init amount of elements to add for result ..");
        int B = StdInReader.readInt();

        System.out.println("Init aim result ..");
        int C = StdInReader.readInt();

        long start = System.nanoTime();
        System.out.printf("Count : %d for %d ns.%n", ts.count(N, B, C), System.nanoTime() - start);
    }
}