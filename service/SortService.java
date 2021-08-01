package service;

import sort.interfaces.Sort;
import util.RandomUtils;
import util.StdInReader;
import sort.InsertionSort;
import sort.SelectSort;
import sort.ShellSort;
import sort.MergeSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import pojo.Point2D;
import sort.BogoSort;
import sort.BogoSort;
import sort.QuickSort;

public class SortService {
    public static void main(String[] args) {

        Sort<Point2D> sr = new QuickSort<>();

        sr = new InsertionSort<>();
        // sr = new SelectSort<>();
        // sr = new ShellSort<>();
        sr = new MergeSort<>(8, sr);
        // sr = new BogoSort<>();

        // System.out.println("Init array of ints ..");
        // int[] N = StdInReader.readIntArray();

        final int COUNT = 1000;
        final int FLIP = 1;

        final Integer[] ARR = RandomUtils.randIntArray(COUNT, 0, 20);
        final Integer[] ARR_Y = RandomUtils.randIntArray(COUNT, 0, 20);

        Point2D[] N = new Point2D[COUNT];
        for (int i = 0; i < COUNT; i++) {
            N[i] = new Point2D(ARR[i], ARR_Y[i]);
        }

        Point2D[] R = N.clone();

        long start = System.nanoTime();
        for (int i = 0; i < FLIP; i++) {
            sr.sort(N, 0, N.length, Point2D.X_SORT);
            if (!sr.isSorted(N, 0, N.length, Point2D.X_SORT)) {
                System.out.println("Not Sorted");
                return;
            }

            if (!sr.isStable(N, 0, N.length, 0, Arrays.asList(Point2D.X_SORT))) {
                System.out.println("Not Stable");
                return;
            }

            sr.sort(N, 0, N.length, Point2D.Y_SORT);

            if (!sr.isStable(N, 0, N.length, 0, Arrays.asList(Point2D.Y_SORT, Point2D.X_SORT))) {
                System.out.println("Not Stable");
                return;
            }

            N = R.clone();
        }
        System.out.printf("Sort of %d elements sorted in %d ns.%n", N.length, System.nanoTime() - start);

    }
}