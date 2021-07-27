package services;

import comparator.ComparableComparator;
import pojos.CountSetsPojo;
import sort.QuickSort;

import sum_to.AimSum;
import sum_to.AimSumBinarySearch;
import sum_to.AimSumBrute;
import sum_to.AimSumCount;
import sum_to.AimSumImproved;

import utils.RandomUtils;

public class AimSumService {
    public static void main(String[] args) {
        final int RUN = 10;
        final Integer[] N = RandomUtils.randIntArray(100, -20, 50);

        new QuickSort<Integer>().sort(N, 0, N.length, new ComparableComparator<>());

        final int B = 3;

        final int C = 0;
        AimSum ts = new AimSumCount();
        long start = System.nanoTime();
        CountSetsPojo res = null;
        for (int i = 0; i < RUN; i++) {
            res = ts.count(N, B, C);
        }

        System.out.printf("%-25S : %d for %d ns.%n", ts.getClass().getName(), res.getCount(),
                System.nanoTime() - start);
        // for (int[] i : res.getSets()) {
        // System.out.println(Arrays.toString(i));
        // }

        ts = new AimSumBrute();
        start = System.nanoTime();
        for (int i = 0; i < RUN; i++) {
            res = ts.count(N, B, C);
        }
        System.out.printf("%-25S : %d for %d ns.%n", ts.getClass().getName(), res.getCount(),
                System.nanoTime() - start);
        // for (int[] i : res.getSets()) {
        // System.out.println(Arrays.toString(i));
        // }

        ts = new AimSumImproved();
        start = System.nanoTime();
        for (int i = 0; i < RUN; i++) {
            res = ts.count(N, B, C);
        }
        System.out.printf("%-25S : %d for %d ns.%n", ts.getClass().getName(), res.getCount(),
                System.nanoTime() - start);
        // for (int[] i : res.getSets()) {
        // System.out.println(Arrays.toString(i));
        // }

        ts = new AimSumBinarySearch();
        start = System.nanoTime();
        for (int i = 0; i < RUN; i++) {
            res = ts.count(N, B, C);
        }
        System.out.printf("%-25S : %d for %d ns.%n", ts.getClass().getName(), res.getCount(),
                System.nanoTime() - start);
        // for (int[] i : res.getSets()) {
        // System.out.println(Arrays.toString(i));
        // }
    }
}