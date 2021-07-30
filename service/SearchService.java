package service;

import pojo.Point2D;
import search.BinarySearch;
import search.Search;
import sort.QuickSort;
import util.RandomUtils;

public class SearchService {
    public static void main(String[] args) {
        // System.out.println("Init array of ints ..");
        // int[] N = StdInReader.readIntArray();
        final int COUNT = 1000;

        final Integer[] ARR = RandomUtils.randIntArray(COUNT, -20, 50);

        Point2D[] N = new Point2D[COUNT];
        for (int i = 0; i < COUNT; i++) {
            N[i] = new Point2D(ARR[i], ARR[i]);
        }

        Search<Point2D> bs = new BinarySearch<>();
        Point2D s = N[RandomUtils.randomInt(0, N.length - 1)];

        new QuickSort<Point2D>().sort(N, 0, N.length, Point2D.X_SORT);

        long start = System.nanoTime();
        System.out.printf("Element %d from array of %d elements found in %d ns.%n", bs.search(N, s, Point2D.X_SORT),
                N.length, System.nanoTime() - start);
    }
}