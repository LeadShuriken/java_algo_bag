package utils;

import java.util.Random;

public class RandomUtils {
    private RandomUtils() {
    }

    public static int[] randIntArray(int N) {
        Random rd = new Random();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = rd.nextInt();
        }
        return arr;
    }
}
