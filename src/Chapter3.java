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

    public static void run() {
        runMinStack();
        runStackStack();
    }
}
