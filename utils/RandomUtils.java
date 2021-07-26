package utils;

import java.util.Random;

public class RandomUtils {
    private RandomUtils() {
    }

    public static Integer[] randIntArray(int N, int min, int max) {
        Random rd = new Random();
        Integer[] arr = new Integer[N];
        for (int i = 0; i < N; i++) {
            arr[i] = rd.nextInt((max - min) + 1) + min;
        }
        return arr;
    }

    public static Integer[] randIntArray(int N) {
        Random rd = new Random();
        Integer[] arr = new Integer[N];
        for (int i = 0; i < N; i++) {
            arr[i] = rd.nextInt();
        }
        return arr;
    }

    public static int randomInt(int min, int max) {
        return new Random().nextInt((max - min) + 1) + min;
    }

    public static void shuffle(Object[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int r = (int) (Math.random() * (i + 1));
            Object swap = a[r];
            a[r] = a[i];
            a[i] = swap;
        }
    }

}
