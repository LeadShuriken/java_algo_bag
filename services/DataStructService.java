package services;

import java.util.Arrays;

import data_structures.ArrayStack;
import data_structures.ItemStack;
import data_structures.Stack;
import utils.RandomUtils;
import utils.StdInReader;
import utils.TestPojo;

public class DataStructService {
    public static void main(String[] args) {
        final int PUSH = 100;
        final int POP = 8;

        Stack<TestPojo> st = new ItemStack<>();

        int count = 0;
        for (int i = 0; i < PUSH; i++) {
            st.push(new TestPojo(i));
            count++;
        }
        System.out.printf("PUSH pass: %B\n", count == PUSH);

        count = 0;
        for (TestPojo i : st) {
            count += i.getSomeNumber();
        }
        System.out.printf("ITERATE pass: %B\n", count == ((PUSH + 1) * PUSH) / 2 - PUSH);

        count = 0;
        for (int i = 0; i < POP; i++) {
            count += st.pop().getSomeNumber();
        }
        System.out.printf("POP pass: %B\n", count == (((PUSH - 1) + (PUSH - POP)) * POP) / 2);

        count = 0;
        System.out.printf("IS EMPTY pass: %B\n", !st.isEmpty());

        for (TestPojo i : st) {
            count++;
        }
        System.out.printf("PUSH pass: %B\n", count == PUSH - POP);
        System.out.printf("LENGTH pass: %B\n", count == st.length());
    }
}