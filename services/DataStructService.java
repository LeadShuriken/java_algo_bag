package services;

import data_structures.ArrayQueue;
import data_structures.ArrayStack;
import data_structures.ItemQueue;
import data_structures.ItemStack;

import data_structures.interfaces.Queue;
import data_structures.interfaces.Stack;
import pojos.TestPojo;

public class DataStructService {
    public static void main(String[] args) {

        System.out.println("------------- STACK ------------");

        final int PUSH = 100;
        final int POP = 10;

        Stack<TestPojo> st = new ItemStack<>();
        st = new ArrayStack<>();

        int count = 0;
        for (int i = 0; i < PUSH; i++) {
            st.push(new TestPojo(i));
            count++;
        }
        System.out.printf("%-25S : %B\n", "PUSH pass", count == PUSH);
        System.out.printf("%-25S : %B\n", "LENGTH pass", count == st.length());

        count = 0;
        for (TestPojo i : st) {
            count += i.getSomeNumber();
        }
        System.out.printf("%-25S : %B\n", "ITERATE pass", count == ((PUSH + 1) * PUSH) / 2 - PUSH);

        count = 0;
        for (int i = 0; i < POP; i++) {
            count += st.pop().getSomeNumber();
        }

        System.out.printf("%-25S : %B\n", "POP pass", count == (((PUSH - 1) + (PUSH - POP)) * POP) / 2);
        System.out.printf("%-25S : %B\n", "IS EMPTY pass", !st.isEmpty());

        while (!st.isEmpty()) {
            st.pop();
        }

        System.out.printf("%-25S : %B\n", "IS EMPTY AF EMP pass", st.isEmpty());
        System.out.printf("%-25S : %B\n", "LENGTH AF EMP pass", 0 == st.length());

        System.out.println("------------- QUEUE ------------");

        Queue<TestPojo> qu = new ItemQueue<>();
        qu = new ArrayQueue<>();

        count = 0;
        for (int i = 0; i < PUSH; i++) {
            qu.enqueue(new TestPojo(i));
            count++;
        }
        System.out.printf("%-25S : %B\n", "PUSH pass", count == PUSH);
        System.out.printf("%-25S : %B\n", "LENGTH pass", count == qu.length());

        count = 0;
        for (TestPojo i : qu) {
            count += i.getSomeNumber();
        }
        System.out.printf("%-25S : %B\n", "ITERATE pass", count == ((PUSH + 1) * PUSH) / 2 - PUSH);

        count = 0;
        for (int i = 0; i < POP; i++) {
            count += qu.dequeue().getSomeNumber();
        }

        System.out.printf("%-25S : %B\n", "POP pass", count == ((POP + 1) * POP) / 2 - POP);
        System.out.printf("%-25S : %B\n", "IS EMPTY pass", !qu.isEmpty());

        while (!qu.isEmpty()) {
            qu.dequeue();
        }

        System.out.printf("%-25S : %B\n", "IS EMPTY AF EMP pass", qu.isEmpty());
        System.out.printf("%-25S : %B\n", "LENGTH AF EMP pass", 0 == qu.length());
    }
}