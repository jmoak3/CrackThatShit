import java.util.HashSet;

public class Chapter2 {
    private static class Node {
        Node(int d) {data = d; next = null;}
        int data;
        Node next;
    }

    static void removeDuplicates(Node head) {
        HashSet<Integer> hs = new HashSet<Integer>();
        Node n = head;
        if (n != null && n.next != null) {
            hs.add(n.data);
            while (n!=null && n.next != null) {
                if (!hs.add(n.next.data))
                    n.next = n.next.next;
                n = n.next;
            }
        }
    }

    static void runRemoveDuplicates() {
        System.out.println("removeDuplicates()");
        Node n = new Node(2);
        Node i = n;
        i.next = new Node(1); i = i.next;
        i.next = new Node(2); i = i.next;
        i.next = new Node(7); i = i.next;
        i.next = new Node(4); i = i.next;
        i.next = new Node(1); i = i.next;

        i = n; String line = "";
        while (i != null) {
            line += i.data + " ";
            i = i.next;
        }
        System.out.println(line);
        removeDuplicates(n);
        i = n; line = "";
        while (i != null) {
            line += i.data + " ";
            i = i.next;
        }
        System.out.println(line);
    }

    static Node findKLast(Node head, int k) {
        Node p1 = head; Node p2 = head;
        if (head == null) return null;
        for (int i=0;i<k-1;++i) {
            p2 = p2.next;
            if (p2==null) return null;
        }

        while (p2.next != null) {
            p2 = p2.next;
            p1 = p1.next;
        }
        return p1;
    }


    static void runFindKLast() {
        System.out.println("findKLast()");
        Node n = new Node(2);
        Node i = n;
        i.next = new Node(1); i = i.next;
        i.next = new Node(2); i = i.next;
        i.next = new Node(7); i = i.next;
        i.next = new Node(4); i = i.next;
        i.next = new Node(1); i = i.next;

        i = n; String line = "";
        while (i != null) {
            line += i.data + " ";
            i = i.next;
        }
        System.out.println(line);
        Node l3 = findKLast(n, 3);
        Node l4 = findKLast(n, 4);
        Node l2 = findKLast(n, 2);
        Node l6 = findKLast(n, 6);
        Node l7 = findKLast(n, 7);
        line = "3rd last " + l3.data + " "
                + "4th last " + l4.data + " "
                + "2th last " + l2.data + " "
                + "6th last " + l6.data + " ";
        if (l7 == null) System.out.println("l7 is null");
        System.out.println(line);
    }

    static void removeMiddle(Node mid) {
        Node n = mid;
        while (n.next != null) {
            n.data = n.next.data;
            if (n.next.next == null)
                n.next = null;
            else
                n = n.next;
        }
    }


    static void runRemoveMiddle() {
        System.out.println("removeMiddle()");
        Node n = new Node(2);
        Node i = n;
        i.next = new Node(1); i = i.next;
        i.next = new Node(2); i = i.next;
        i.next = new Node(7); i = i.next;
        i.next = new Node(4); i = i.next;
        i.next = new Node(1); i = i.next;

        i = n; String line = "";
        while (i != null) {
            line += i.data + " ";
            i = i.next;
        }
        System.out.println(line);

        i = n.next.next.next.next;
        System.out.println("Want to remove " + i.data);
        removeMiddle(i);

        i = n; line = "";
        while (i != null) {
            line += i.data + " ";
            i = i.next;
        }
        System.out.println(line);
    }

    public static void run() {
        runRemoveDuplicates();
        runFindKLast();
        runRemoveMiddle();
    }
}
