package service;

import java.util.Arrays;
import java.util.function.Function;

import misc.Accessor;
import misc.RandomUtils;
import misc.pojo.Point2D;
import sort.InsertionSort;
import sort.QuickSort;
import sum_to.AimSumBinarySearch;
import sum_to.AimSumImproved;
import sum_to.AimSumBrute;

import sum_to.AimSumCount;
import sum_to.CountSets;
import sum_to.interfaces.AimSum;

public class AimSumService {
    public static void main(String[] args) {
        final int RUN = 10;
        final int COUNT = 1000;

        final Integer[] N = RandomUtils.randIntArray(COUNT, -20, 50);
        final Point2D[] ARR = new Point2D[COUNT];

        for (int i = 0; i < COUNT; i++) {
            ARR[i] = new Point2D(N[i], N[i]);
        }

        new QuickSort<Point2D>(20, new InsertionSort<>()).sort(ARR, 0, N.length, Point2D.X_ACCESSOR);

        final int B = 3;
        final double C = 0;

        AimSumCount<Point2D, Function<Point2D, Double>> rs = new AimSumCount<>();

        long start = System.nanoTime();
        long res1 = 0;
        for (int i = 0; i < RUN; i++) {
            res1 = rs.count(ARR, B, C, Point2D::getX);
        }

        System.out.printf("%-25S : %d for %d ns.%n", rs.getClass().getName(), res1, System.nanoTime() - start);

        AimSum<Point2D, Function<Point2D, Double>, CountSets> ts = new AimSumBrute<>();
        CountSets res = null;
        start = System.nanoTime();
        for (int i = 0; i < RUN; i++) {
            res = ts.count(ARR, B, C, Point2D::getX);
        }
        System.out.printf("%-25S : %d for %d ns.%n", ts.getClass().getName(), res.getCount(),
                System.nanoTime() - start);
        // for (int[] i : res.getSets()) {
        // System.out.println(Arrays.toString(i));
        // }

        ts = new AimSumImproved<>();
        start = System.nanoTime();
        for (int i = 0; i < RUN; i++) {
            res = ts.count(ARR, B, C, Point2D::getX);
        }
        System.out.printf("%-25S : %d for %d ns.%n", ts.getClass().getName(), res.getCount(),
                System.nanoTime() - start);
        // for (int[] i : res.getSets()) {
        // System.out.println(Arrays.toString(i));
        // }

        AimSum<Point2D, Accessor<Point2D, Double>, CountSets> fs = new AimSumBinarySearch<>();
        start = System.nanoTime();
        for (int i = 0; i < RUN; i++) {
            res = fs.count(ARR, B, C, Point2D.X_ACCESSOR);
        }
        System.out.printf("%-25S : %d for %d ns.%n", ts.getClass().getName(), res.getCount(),
                System.nanoTime() - start);
        // // for (int[] i : res.getSets()) {
        // // System.out.println(Arrays.toString(i));
        // // }
    }
}