package service;

import java.util.Arrays;
import java.util.Comparator;

import accessor.Accessor;
import accessor.Point2DAccessor;

import comparator.Point2DComparator;

import pojo.Point2D;
import sort.QuickSort;

import sum_to.AimSum;
import sum_to.AimSumBinarySearch;
import sum_to.AimSumBrute;
import sum_to.AimSumCount;
import sum_to.AimSumImproved;
import sum_to.CountSets;

import util.RandomUtils;

public class AimSumService {
    public static void main(String[] args) {
        final int RUN = 10;
        final int COUNT = 1000;

        final Integer[] N = RandomUtils.randIntArray(COUNT, -20, 50);
        final Point2D[] ARR = new Point2D[COUNT];
        final Accessor<Point2D> ACCESSOR = new Point2DAccessor();
        final Comparator<Point2D> COMPARATOR = new Point2DComparator();

        for (int i = 0; i < COUNT; i++) {
            ARR[i] = new Point2D(N[i], N[i]);
        }

        new QuickSort<Point2D>().sort(ARR, 0, N.length, COMPARATOR);

        final int B = 3;
        final int C = 0;

        AimSum<Point2D> ts = new AimSumCount<>();

        long start = System.nanoTime();
        CountSets res = null;
        for (int i = 0; i < RUN; i++) {
            res = ts.count(ARR, B, C, ACCESSOR);
        }

        System.out.printf("%-25S : %d for %d ns.%n", ts.getClass().getName(), res.getCount(),
                System.nanoTime() - start);

        ts = new AimSumBrute<>();
        start = System.nanoTime();
        for (int i = 0; i < RUN; i++) {
            res = ts.count(ARR, B, C, ACCESSOR);
        }
        System.out.printf("%-25S : %d for %d ns.%n", ts.getClass().getName(), res.getCount(),
                System.nanoTime() - start);
        // for (int[] i : res.getSets()) {
        // System.out.println(Arrays.toString(i));
        // }

        ts = new AimSumImproved<>();
        start = System.nanoTime();
        for (int i = 0; i < RUN; i++) {
            res = ts.count(ARR, B, C, ACCESSOR);
        }
        System.out.printf("%-25S : %d for %d ns.%n", ts.getClass().getName(), res.getCount(),
                System.nanoTime() - start);
        // for (int[] i : res.getSets()) {
        // System.out.println(Arrays.toString(i));
        // }

        ts = new AimSumBinarySearch<>(COMPARATOR);
        start = System.nanoTime();
        for (int i = 0; i < RUN; i++) {
            res = ts.count(ARR, B, C, ACCESSOR);
        }
        System.out.printf("%-25S : %d for %d ns.%n", ts.getClass().getName(), res.getCount(),
                System.nanoTime() - start);
        // for (int[] i : res.getSets()) {
        // System.out.println(Arrays.toString(i));
        // }
    }
}