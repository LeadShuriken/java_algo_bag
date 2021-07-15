package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StdInReader {

    public static int readInt() {
        System.out.print("Enter int: ");
        return Integer.parseInt(System.console().readLine());
    }

    public static int[] readIntArray() {
        System.out.print("Enter int ar: ");
        String[] a = System.console().readLine().split(" ");
        int size = a.length;
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = Integer.parseInt(a[i]);
        }
        return arr;
    }

    public static Object[] commandLineRead() {
        List<String> a = new ArrayList<>();
        System.out.print("Enter strings: ");
        try (BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in))) {
            String readLine = "";
            while ((readLine = buffer.readLine()) != null && !readLine.trim().isEmpty()) {
                String[] b = readLine.split(" ");
                if (b.length > 1) {
                    a.addAll(Arrays.asList(b));
                } else {
                    a.add(readLine);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Object[] b = new String[a.size()];
        return a.toArray(b);
    }
}
