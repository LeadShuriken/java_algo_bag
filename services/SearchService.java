package services;

import comparator.GenericComparator;
import search.BinarySearch;
import search.Search;
import sort.QuickSort;
import utils.RandomUtils;

public class SearchService {
    public static void main(String[] args) {
        // System.out.println("Init array of ints ..");
        // int[] N = StdInReader.readIntArray();
        Integer[] N = RandomUtils.randIntArray(100000);

        Search bs = new BinarySearch();
        int s = N[RandomUtils.randomInt(0, N.length - 1)];

        new QuickSort<Integer>().sort(N, new GenericComparator<>());

        long start = System.nanoTime();
        System.out.printf("Element %d from array of %d elements found in %d ns.%n", bs.search(N, s), N.length,
                System.nanoTime() - start);
    }
}