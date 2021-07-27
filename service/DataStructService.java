package service;

import data_structure.ArrayQueue;
import data_structure.ArrayStack;
import data_structure.ItemQueue;
import data_structure.ItemStack;
import data_structure.interfaces.Queue;
import data_structure.interfaces.Stack;
import pojo.Point2D;

public class DataStructService {
    public static void main(String[] args) {

        System.out.println("------------- STACK ------------");

        final int PUSH = 100;
        final int POP = 10;

        Stack<Point2D> st = new ItemStack<>();
        st = new ArrayStack<>();

        int count = 0;
        for (int i = 0; i < PUSH; i++) {
            st.push(new Point2D(i, i));
            count++;
        }
        System.out.printf("%-25S : %B\n", "PUSH pass", count == PUSH);
        System.out.printf("%-25S : %B\n", "LENGTH pass", count == st.length());

        count = 0;
        for (Point2D i : st) {
            count += i.getX();
        }
        System.out.printf("%-25S : %B\n", "ITERATE pass", count == ((PUSH + 1) * PUSH) / 2 - PUSH);

        count = 0;
        for (int i = 0; i < POP; i++) {
            count += st.pop().getX();
        }

        System.out.printf("%-25S : %B\n", "POP pass", count == (((PUSH - 1) + (PUSH - POP)) * POP) / 2);
        System.out.printf("%-25S : %B\n", "IS EMPTY pass", !st.isEmpty());

        while (!st.isEmpty()) {
            st.pop();
        }

        System.out.printf("%-25S : %B\n", "IS EMPTY AF EMP pass", st.isEmpty());
        System.out.printf("%-25S : %B\n", "LENGTH AF EMP pass", 0 == st.length());

        System.out.println("------------- QUEUE ------------");

        Queue<Point2D> qu = new ItemQueue<>();
        qu = new ArrayQueue<>();

        count = 0;
        for (int i = 0; i < PUSH; i++) {
            qu.enqueue(new Point2D(i, i));
            count++;
        }
        System.out.printf("%-25S : %B\n", "PUSH pass", count == PUSH);
        System.out.printf("%-25S : %B\n", "LENGTH pass", count == qu.length());

        count = 0;
        for (Point2D i : qu) {
            count += i.getX();
        }
        System.out.printf("%-25S : %B\n", "ITERATE pass", count == ((PUSH + 1) * PUSH) / 2 - PUSH);

        count = 0;
        for (int i = 0; i < POP; i++) {
            count += qu.dequeue().getX();
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