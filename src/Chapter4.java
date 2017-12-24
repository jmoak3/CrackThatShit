import com.sun.jmx.mbeanserver.NamedObject;
import org.omg.CORBA.INTERNAL;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Chapter4 {

    private static class Node {
        int id = -1;
    }

    static int bfsHelper(Node[] nodes, Queue<Node> q,
                         boolean[][] m,
                         HashSet<Node> marked, HashSet<Node> visited) {
        Node n = q.remove();
        marked.add(n);
        if (visited.contains(n)) return n.id;
        visited.add(n);
        for (int i = 0; i < m[n.id].length; ++i) {
            if (m[n.id][i] && !marked.contains(nodes[i])) {
                q.add(nodes[i]);
                marked.add(nodes[i]);
            }
        }
        return -1;
    }

    static int pathExists(Node[] nodes, int start, int end,
                          boolean[][] m) {
        Queue<Node> sq = new LinkedList<Node>();
        Queue<Node> eq = new LinkedList<Node>();
        sq.add(nodes[start]);
        eq.add(nodes[end]);

        HashSet<Node> sm = new HashSet<Node>();
        HashSet<Node> em = new HashSet<Node>();
        HashSet<Node> visited = new HashSet<Node>();

        while (!sq.isEmpty() || !eq.isEmpty()) {
            if (!sq.isEmpty()) {
                int found = bfsHelper(nodes, sq, m, sm, visited);
                if (found > -1)
                    return found;
            }
            if (!eq.isEmpty()) {
                int found = bfsHelper(nodes, eq, m, em, visited);
                if (found > -1)
                    return found;
            }
        }
        return -1;
    }

    static void runPathExists() {
        System.out.println("Path Exists()");
        boolean[][] m = new boolean[12][12];
        boolean zero[] = {false, true, true, false, false, true,
                false, false, false, false, false, false,};
        m[0] = zero;
        boolean one[] = {true, false, true, false, false, false,
                false, false, false, false, false, false,};
        m[1] = one;
        boolean two[] = {true, true, false, true, false, false,
                false, false, false, false, false, false,};
        m[2] = two;
        boolean three[] = {false, false, true, false, true, false,
                false, false, false, false, false, false,};
        m[3] = three;
        boolean four[] = {false, false, false, true, false, true,
                false, false, false, false, false, false,};
        m[4] = four;
        boolean five[] = {true, false, false, false, true, false,
                true, false, false, false, false, false,};
        m[5] = five;
        boolean six[] = {false, false, false, false, false, true,
                false, false, false, false, false, true,};
        m[6] = six;
        boolean seven[] = {false, false, false, false, false, false,
                false, false, true, false, false, true,};
        m[7] = seven;
        boolean eight[] = {false, false, false, false, false, false,
                false, true, false, false, true, false,};
        m[8] = eight;
        boolean nine[] = {false, false, false, false, false, false,
                false, false, false, false, true, true,};
        m[9] = nine;
        boolean ten[] = {false, false, false, false, false, false,
                false, false, true, true, false, true,};
        m[10] = ten;
        boolean eleven[] = {false, false, false, false, false, false,
                true, true, false, true, true, false,};
        m[11] = eleven;

        Node[] n = new Node[12];
        for (int i = 0; i < n.length; ++i) {
            Node o = new Node();
            o.id = i;
            n[i] = o;
        }

        int result = pathExists(n, 0, 11, m);
        System.out.println("Path Connected at " + result);
        System.out.println();
    }

    static int[] split(int[] arr, int s, int e) {
        int len = e - s;
        if (len == 0) len = 1;
        int[] result = new int[len];
        for (int i = 0; i < len; ++i) {
            result[i] = arr[s + i];
        }
        return result;
    }

    static String makeShortTree(int[] arr) {
        Queue<int[]> q = new LinkedList<int[]>();
        q.add(arr);
        String s = "";
        while (!q.isEmpty()) {
            int[] x = q.remove();
            s += x[x.length / 2] + " ";
            if (x.length > 1) {
                q.add(split(x, 0, x.length / 2));
                if (x.length > 2)
                    q.add(split(x, x.length / 2 + 1, x.length));
            }
        }
        return s;
    }

    static void runMakeShortTree() {
        System.out.println("MakeShortTree()");

        int[] x = {0, 1, 2, 3, 4, 5, 8, 12, 13};
        int[] y = {7, 8, 9, 21};
        int[] z = {1, 3, 4, 5, 6, 7, 8, 9, 21};

        String s;
        s = "";
        for (int i = 0; i < x.length; ++i) {
            s += x[i] + " ";
        }
        System.out.println(s);
        System.out.println("Short Tree: " + makeShortTree(x));

        s = "";
        for (int i = 0; i < y.length; ++i) {
            s += y[i] + " ";
        }
        System.out.println(s);
        System.out.println("Short Tree: " + makeShortTree(y));

        s = "";
        for (int i = 0; i < z.length; ++i) {
            s += z[i] + " ";
        }
        System.out.println(s);
        System.out.println("Short Tree: " + makeShortTree(z));
        System.out.println();
    }

    static void listAtDepth(int v, BSTNode n, int d, LinkedList<Integer> l) {
        if (v == d) {
            l.add(n.data);
        } else {
            if (n.left != null) listAtDepth(v, n.left, d + 1, l);
            if (n.right != null) listAtDepth(v, n.right, d + 1, l);
        }
    }

    static void listAtDepth(int v, BSTNode n, LinkedList<Integer> l) {
        if (n != null)
            listAtDepth(v, n, 0, l);
    }

    static void runListAtDepth() {
        System.out.println("ListAtDepth()");
        int[] x = {4, 2, 12, 1, 3, 8, 13, 0, 5};
        BST b = new BST();
        for (int i = 0; i < x.length; ++i) {
            b.add(x[i]);
        }

        String s = "";
        LinkedList<Integer> l = new LinkedList<Integer>();
        b.inorder(b.root, l);
        for (int i = 0; i < l.size(); ++i) {
            s += "" + l.get(i) + " ";
        }
        System.out.println("InOrder: " + s);
        s = "";
        l = new LinkedList<Integer>();
        b.preorder(b.root, l);
        for (int i = 0; i < l.size(); ++i) {
            s += "" + l.get(i) + " ";
        }
        System.out.println("PreOrder: " + s);

        l = new LinkedList<Integer>();
        listAtDepth(2, b.root, 0, l);
        s = "";
        for (int i = 0; i < l.size(); ++i) {
            s += "" + l.get(i) + " ";
        }
        System.out.println("Depth " + 2 + ": " + s);

        System.out.println();
    }


    public static void run() {
        runPathExists();
        runMakeShortTree();
        runListAtDepth();
    }
}