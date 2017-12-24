import sun.awt.image.ImageWatched;

import java.util.LinkedList;

public class BST {
    BSTNode root = null;

    private void add(int v, BSTNode n) {
        if (v > n.data) {
            if (n.right == null) {
                n.right = new BSTNode(v);
            }
            else {
                add(v, n.right);
            }
        }
        else {
            if (n.left == null) {
                n.left = new BSTNode(v);
            }
            else {
                add(v, n.left);
            }
        }
    }

    public void add(int v) {
        if (root == null) {
            root = new BSTNode(v);
        }
        else {
            add(v, root);
        }
    }

    private int remove(int v, BSTNode n) {
        if (v > n.data) {
            if (n.right != null && n.right.data == v) {
                int r = n.right.data;
                n.right = null;
                return r;
            }
            else {
                return remove(v, n.right);
            }
        }
        else {
            if (n.left != null && n.left.data == v) {
                int r = n.left.data;
                n.left = null;
                return r;
            }
            else {
                return remove(v, n.left);
            }
        }
    }

    public int remove(int v) {
        if (root == null) return -1;
        if (root.data == v) {
            int r = root.data;
            root = null;
            return r;
        }
        else {
            return remove(v, root);
        }
    }

    public void preorder(BSTNode n, LinkedList<Integer> l) {
        l.add(n.data);
        if (n.left != null) preorder(n.left, l);
        if (n.right != null) preorder(n.right, l);
    }

    public void inorder(BSTNode n, LinkedList<Integer> l) {
        if (n.left != null) inorder(n.left, l);
        l.add(n.data);
        if (n.right != null) inorder(n.right, l);
    }

    static public void test() {
        System.out.println();
        System.out.println("BST Test");

        BST b = new BST();
        b.add(3);
        b.add(1);
        b.add(0);
        b.add(2);
        b.add(8);
        b.add(7);
        b.add(12);
        String s = "";
        LinkedList<Integer> l = new LinkedList<Integer>();
        b.inorder(b.root, l);
        for (int i=0;i<l.size();++i) {
            s += "" + l.get(i) + " ";
        }
        System.out.println("InOrder: " + s);

        l = new LinkedList<Integer>();
        b.preorder(b.root, l);
        s = "";
        for (int i=0;i<l.size();++i) {
            s += "" + l.get(i) + " ";
        }
        System.out.println("PreOrder: " + s);
        System.out.println();

    }
}