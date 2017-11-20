import java.util.HashSet;
import java.util.Stack;

public class Chapter3 {

    static class MinStack {
        Stack<Integer> s = new Stack<Integer>();
        Stack<Integer> m = new Stack<Integer>();
        int min = Integer.MAX_VALUE;

        public int getMin() {return min;}
        public int size() {return s.size();}
        public int peek() {return s.peek();}
        public boolean contains(int n) {return s.contains(n);}
        public int push(int n) {
            if (n <= min) {
                min = n;
                m.push(min);
            }
            return s.push(n);
        }
        public int pop() {
            int n = s.pop();
            if (n==min) {
                m.pop();
                if (m.size() > 0) {
                    min = m.peek();
                }
                else {
                    min = Integer.MAX_VALUE;
                }
            }
            return n;
        }
    }

    static void runMinStack() {
        System.out.println("Min Stack");
        MinStack s = new MinStack();
        s.push(3);
        s.push(5);
        System.out.println("Stack: 5,3");
        System.out.println("Min: " + s.getMin());
        s.push(2);
        s.push(1);
        System.out.println("Stack: 1,2,5,3");
        System.out.println("Min: " + s.getMin());
        s.pop();
        System.out.println("Stack: 2,5,3");
        System.out.println("Min: " + s.getMin());
        s.pop();
        System.out.println("Stack: 5,3");
        System.out.println("Min: " + s.getMin());
        System.out.println();
    }

    static class StackStack {
        Stack<Stack<Integer>> s = new Stack<Stack<Integer>>();
        int size=0;
        int maxSize=3;
        int numStacks = 0;
        public int size() {return size;}
        public int peek() {return s.peek().peek();}
        public int push(int n) {
            if (size==0) {
                s.push(new Stack<Integer>());
                ++numStacks;
            }
            if (s.peek().size() >= maxSize) {
                s.push(new Stack<Integer>());
                ++numStacks;
            }
            s.peek().push(n);
            ++size;
            return n;
        }
        public int pop() {
            if (size==0) {
                return -1;
            }
            if (s.peek().size() == 0) {
                s.pop();
                --numStacks;
            }
            --size;
            return s.peek().pop();
        }
    }

    static void runStackStack() {
        System.out.println("Stack Stack");
        StackStack s = new StackStack();
        s.push(3);
        s.push(5);
        s.push(6);
        s.push(2);
        s.push(1);
        s.push(1);
        s.push(1);
        s.push(1);
        System.out.println("Stack: 1,1,1,1,2,6,5,3");
        System.out.println("numStacks: " + s.numStacks);
        System.out.println("Popping: " + s.pop());
        System.out.println("Popping: " + s.pop());
        System.out.println("Popping: " + s.pop());
        System.out.println("numStacks: " + s.numStacks);
        System.out.println("Popping: " + s.pop());
        System.out.println("Popping: " + s.pop());
        System.out.println("Popping: " + s.pop());
        System.out.println("numStacks: " + s.numStacks);
    }

    static class QStack {
        Stack<Integer> s1 = new Stack<Integer>();
        Stack<Integer> s2 = new Stack<Integer>();
        int size=0;

        public int size() {return size;}
        public int push(int n) {
            ++size;
            return s1.push(n);
        }
        public int pop() {
            if (s2.size() > 0) {
                return s2.pop();
            }
            else {
                while (s1.size() > 0) {
                    s2.push(s1.pop());
                }
                return s2.pop();
            }
        }
    }

    static void runQStack() {
        System.out.println("");
        System.out.println("Q Stack");
        QStack s = new QStack();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
        s.push(6);
        System.out.println("Popping: " + s.pop() + " expecting 1");
        s.push(7);
        System.out.println("Popping: " + s.pop() + " expecting 2");
        System.out.println("Popping: " + s.pop() + " expecting 3");

        System.out.println("Popping: " + s.pop() + " expecting 4");
        System.out.println("Popping: " + s.pop() + " expecting 5");
        s.push(8);
        System.out.println("Popping: " + s.pop() + " expecting 6");
        s.push(9);
        System.out.println("Popping: " + s.pop() + " expecting 7");
        System.out.println("Popping: " + s.pop() + " expecting 8");
        System.out.println("Popping: " + s.pop() + " expecting 9");
    }

    public static void run() {
        runMinStack();
        runStackStack();
        runQStack();
    }
}
