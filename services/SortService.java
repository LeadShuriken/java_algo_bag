package services;

import sort.QuickSort;
import sort.SelectSort;
import sort.ShellSort;
import sort.interfaces.Sort;

import java.util.Comparator;

import comparator.GenericComparator;

import sort.InsertionSort;
import sort.BogoSort;
import sort.BogoSort;
import sort.MergeSort;

import utils.RandomUtils;
import utils.StdInReader;

public class SortService {
    public static void main(String[] args) {

        Comparator<Integer> b = new GenericComparator<>();
        Sort<Integer> sr = new QuickSort<>();

        sr = new SelectSort<>();
        sr = new InsertionSort<>();
        sr = new ShellSort<>();
        // sr = new BogoSort<>();
        // sr = new MergeSort<>();

        // System.out.println("Init array of ints ..");
        // int[] N = StdInReader.readIntArray();

        Integer[] N = RandomUtils.randIntArray(100, 0, 1000);
        Integer[] R = N.clone();

        long start = System.nanoTime();
        for (int i = 0; i < N.length; i++) {
            sr.sort(N, b);
            if (!sr.isSorted(N, 0, N.length, b)) {
                System.out.println("Not Sorted");
            }
            N = R.clone();
        }
        System.out.printf("Sort of %d elements sorted in %d ns.%n", N.length, System.nanoTime() - start);
    }
}