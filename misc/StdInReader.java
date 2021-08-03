package misc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class StdInReader {

    private StdInReader() {
    }

    public static int readInt() {
        System.out.print("Enter int: ");
        return Integer.parseInt(System.console().readLine());
    }

    public static String readString() {
        System.out.print("Enter string: ");
        return System.console().readLine();
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

    public static void feedString(String readLine, List<String> a) {
        String[] b = readLine.trim().split(" ");
        List<String> copy = new ArrayList<>();
        for (int i = 0; i < b.length; i++) {
            if (!b[i].equals("")) {
                copy.add(b[i]);
            }
        }
        if (copy.size() > 1) {
            a.addAll(copy);
        } else {
            a.add(readLine);
        }
    }

    public static Object[] readArray(boolean fromFile) {
        List<String> a = new ArrayList<>();
        if (fromFile) {
            StdInReader.feedString(StdInReader.readString(), a);
        } else {
            System.out.print("Enter file :");
            try (BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in))) {
                String readLine = "";
                while ((readLine = buffer.readLine()) != null && !readLine.trim().isEmpty()) {
                    StdInReader.feedString(readLine, a);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return a.toArray(new Object[a.size()]);
    }
}
