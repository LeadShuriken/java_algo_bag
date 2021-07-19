package services;

import java.util.Arrays;

import sort.QuickSort;
import sum_to.AimSum;
import sum_to.AimSumBrute;
import sum_to.AimSumImproved;
import utils.CountSetsPojo;
import utils.StdInReader;

public class AimSumService {
    public static void main(String[] args) {

        AimSum ts = new AimSumBrute();
        // System.out.println("Init array of ints ..");
        // int[] N = StdInReader.readIntArray();
        int[] N = new int[] { 0, -1, 1, 1, 1, 0, 0 };

        // System.out.println("Init amount of elements to add for result ..");
        // int B = StdInReader.readInt();
        int B = 4;

        // System.out.println("Init aim result ..");
        // int C = StdInReader.readInt();
        int C = 0;
        long start = System.nanoTime();
        CountSetsPojo res = ts.count(N, B, C);
        // for (int i = 0; i < 10000000; i++) {
        // res = ts.count(N, B, C);
        // }
        System.out.printf("Count : %d for %d ns.%n", res.getCount(), System.nanoTime() - start);
        for (int[] i : res.getSets()) {
            System.out.println(Arrays.toString(i));
        }

        ts = new AimSumImproved();
        // new QuickSort().sort(N);

        start = System.nanoTime();
        res = ts.count(N, B, C);
        // for (int i = 0; i < 10000000; i++) {
        // res = ts.count(N, B, C);
        // }
        System.out.printf("Count : %d for %d ns.%n", res.getCount(), System.nanoTime() - start);
        for (int[] i : res.getSets()) {
            System.out.println(Arrays.toString(i));
        }
    }
}