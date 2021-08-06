package service;

import misc.RandomUtils;
import misc.StdInReader;
import misc.pojo.Point2D;
import select.QuickSelect;
import select.interfaces.Select;

public class SelectService {
    public static void main(String[] args) {

        Select<Point2D> sl = new QuickSelect<>();

        // System.out.println("Init array of ints ..");
        // int[] N = StdInReader.readIntArray();

        final int COUNT = 1000;
        final double LOOKING_FOR = 0;

        Point2D[] N = new Point2D[COUNT];
        boolean isIn = false;

        while (!isIn) {
            final Integer[] ARR = RandomUtils.randIntArray(COUNT, 0, 10000);
            final Integer[] ARR_Y = RandomUtils.randIntArray(COUNT, 0, 10000);

            for (int i = 0; i < COUNT; i++) {
                if (ARR[i] == LOOKING_FOR) {
                    System.out.println(ARR_Y[i]);
                    isIn = true;
                }
                N[i] = new Point2D(ARR[i], ARR_Y[i]);
            }
        }

        long start = System.nanoTime();
        System.out.printf("Select of %s element done in %d ns.%n", sl.select(N, Point2D.X_COMP, new Point2D(0, 10)),
                System.nanoTime() - start);
    }
}