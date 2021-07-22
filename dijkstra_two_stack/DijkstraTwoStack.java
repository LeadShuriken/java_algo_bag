package dijkstra_two_stack;

import data_structures.interfaces.Stack;

public class DijkstraTwoStack {

    final private Stack<Double> vals;
    final private Stack<Character> ops;

    public DijkstraTwoStack(Stack<Double> vals, Stack<Character> ops) {
        this.ops = ops;
        this.vals = vals;
    }

    public Double evaluateExpession(String st) {

        char[] charSeq = st.toCharArray();
        int N = charSeq.length;

        for (int i = 0; i < N; i++) {
            char b = charSeq[i];
            switch (b) {
                case '(':
                    continue;
                case '+':
                case '-':
                case '/':
                case '*':
                case '^':
                case '%':
                    ops.push(b);
                    break;
                case ')':
                    calculate();
                    break;
                default:
                    if (Character.isDigit(b)) {
                        for (int j = i + 1; j < N; j++) {
                            char c = charSeq[j];
                            if (!Character.isDigit(c) && c != '.' && c != ',') {
                                vals.push(Double.valueOf(st.substring(i, j)));
                                i = j - 1;
                                break;
                            }
                        }
                    }
                    break;
            }
        }
        return vals.pop();
    }

    private Double res(Double l, Double r, Character op) {
        switch (op) {
            case '+':
                return l + r;
            case '-':
                return l - r;
            case '/':
                return l / r;
            case '*':
                return l * r;
            case '^':
                return Math.pow(l, r);
            case '%':
                return l % r;
        }
        return 0d;
    }

    private void calculate() {
        Double r = vals.pop();
        Double l = vals.pop();
        vals.push(res(l, r, ops.pop()));
    }
}
