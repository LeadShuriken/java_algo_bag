package services;

import intersection.IntersectionCount;
import intersection.interfaces.IntArrayIntersection;
import utils.RandomUtils;
import utils.StdInReader;

public class PathScanService {
    public static void main(String[] args) {
        IntArrayIntersection sr = new IntersectionCount();

        // System.out.println("Init array of ints ..");
        // int[] N = StdInReader.readIntArray();

        int[] N = RandomUtils.randIntArray(100, 0, 100);
        int[] X = RandomUtils.randIntArray(100, 0, 100);

        long start = System.nanoTime();
        System.out.printf("%d intersections found in element arrays in %d ns.%n", sr.countIntersection(N, X),
                System.nanoTime() - start);
    }
}