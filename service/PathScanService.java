package service;

import intersection.IntersectionCount;
import misc.RandomUtils;
import misc.StdInReader;

public class PathScanService {
    public static void main(String[] args) {
        IntersectionCount sr = new IntersectionCount();

        // System.out.println("Init array of ints ..");
        // int[] N = StdInReader.readIntArray();

        Integer[] N = RandomUtils.randIntArray(100, 0, 100);
        Integer[] X = RandomUtils.randIntArray(100, 0, 100);

        long start = System.nanoTime();
        System.out.printf("%d intersections found in element arrays in %d ns.%n", sr.countIntersection(N, X),
                System.nanoTime() - start);
    }
}