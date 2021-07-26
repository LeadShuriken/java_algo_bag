package services;

import sort.interfaces.IntArraySort;

import sort.QuickSort;
import sort.SelectSort;
import sort.ShellSort;
import sort.BogoSort;
import sort.InsertionSort;
import utils.RandomUtils;
import utils.StdInReader;

public class SortService {
    public static void main(String[] args) {
        IntArraySort sr = new ShellSort();
        // sr = new SelectSort();
        // sr = new InsertionSort();
        // sr = new ShellSort();
        // sr = new QuickSort();
        // sr = new BogoSort();

        // System.out.println("Init array of ints ..");
        // int[] N = StdInReader.readIntArray();

        long start = System.nanoTime();
        int[] N = RandomUtils.randIntArray(10000, 0, 5000);
        int[] R = N.clone();

        start = System.nanoTime();
        for (int i = 0; i < N.length; i++) {
            sr.sort(N);
            if (!sr.isSorted(N, 0, N.length)) {
                System.out.println("Not Sorted");
            }
            N = R.clone();
        }
        System.out.printf("Sort  of %d elements sorted in %d ns.%n", N.length, System.nanoTime() - start);
    }
}