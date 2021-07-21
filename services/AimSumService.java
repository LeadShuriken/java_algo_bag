package services;

import java.util.Arrays;

import sort.QuickSort;

import sum_to.AimSum;
import sum_to.AimSumBinarySearch;
import sum_to.AimSumBrute;
import sum_to.AimSumCount;
import sum_to.AimSumImproved;

import utils.CountSetsPojo;
import utils.RandomUtils;
import utils.StdInReader;

public class AimSumService {
    public static void main(String[] args) {
        final int RUN = 1;

        // System.out.println("Init array of ints ..");
        // int[] N = StdInReader.readIntArray();
        // final int[] N = new int[] { 0, -1, 1, 0, 0, 2, -2 };
        final int[] N = RandomUtils.randIntArray(100, -20, 50);
        new QuickSort().sort(N);

        // int B = StdInReader.readInt();
        final int B = 5;

        // System.out.println("Init aim result ..");
        // int C = StdInReader.readInt();
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