package services;

import sort.Sort;
import sort.QuickSort;
import sort.BogoSort;
import utils.StdInReader;

public class SortService {
    public static void main(String[] args) {
        Sort sr = new QuickSort();
        // Sort sr = new BogoSort();
        System.out.println("Init array of ints ..");
        int[] N = StdInReader.readIntArray();

        long start = System.nanoTime();
        sr.sort(N);
        System.out.printf("Array of %d elements sorted in %d ns.%n", N.length, System.nanoTime() - start);
    }
}