package services;

import data_structures.ArrayStack;
import data_structures.ItemStack;
import dijkstra_two_stack.DijkstraTwoStack;

public class DijkstraTwoStackService {
    public static void main(String[] args) throws InterruptedException {
        int N = 20;
        String EXP = "(123*((((100 / x) + 1)^2) - (x^2)))".replaceAll("x", "5");
        StringBuilder a = new StringBuilder(EXP);
        for (int i = 0; i < N; i++) {
            // Double overflow diverted
            a.append((i % 2 == 0 ? "+" : "-") + a + ")");
        }

        System.out.println("PASS");
        long start = System.nanoTime();
        System.out.printf("%-10S : %d ns.%n",
                new DijkstraTwoStack(new ItemStack<>(), new ItemStack<>()).evaluateExpession(EXP),
                System.nanoTime() - start);
        start = System.nanoTime();
        System.out.printf("%-10S : %d ns.%n",
                new DijkstraTwoStack(new ArrayStack<>(), new ArrayStack<>()).evaluateExpession(EXP),
                System.nanoTime() - start);
    }
}