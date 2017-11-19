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

    static Node reverse(Node head) {
        Node r = new Node(-1);
        Node n = null;
        Node rn = r;
        if (head.next == null) return head;
        while (head.next != null) {
            n = head;
            Node last = n;
            while (n.next != null) {
                last = n;
                n = n.next;
            }
            while (rn.next != null) {
                rn = rn.next;
            }
            rn.next = n;
            last.next = null;
        }
        rn.next.next = head;
        r = r.next;
        return r;
    }

    static void runReverse() {
        System.out.println("reverse()");
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

        n = reverse(n);

        i = n; line = "";
        while (i != null) {
            line += i.data + " ";
            i = i.next;
        }
        System.out.println(line);
    }

    static Node partition(Node head, int x) {
        Node lessHead = new Node(-1);
        Node less = lessHead;
        Node sameHead = new Node(-1);
        Node same = sameHead;
        Node greatHead = new Node(-1);
        Node great = greatHead;
        Node i = head;

        if (i.next == null) return head;
        while (i.next == null) return head;
        while (i != null) {
            if (i.data < x) {
                less.next = i;
                less = less.next;
            }
            else if (i.data == x) {
                same.next = i;
                same = same.next;
            }
            else if (i.data > x) {
                great.next = i;
                great = great.next;
            }
            i = i.next;
        }

        Node newHead = null;
        if (lessHead.next != null)
            newHead = lessHead.next;
        else if (sameHead.next != null)
            newHead = sameHead.next;
        else
            newHead = greatHead.next;

        if (lessHead.next != null && sameHead.next != null) {
            less.next = sameHead.next;
            same.next = null;
        }
        if (sameHead.next != null && greatHead.next != null) {
            same.next = greatHead.next;
            great.next = null;
        }

        return newHead;
    }

    static void runPartition() {
        System.out.println("reverse()");
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

        System.out.println("Partitioning to 2");
        n = partition(n, 2);

        i = n; line = "";
        while (i != null) {
            line += i.data + " ";
            i = i.next;
        }
        System.out.println(line);
    }

    static Node sum(Node x, Node y) {
        Node a = x;
        int mult = 1;
        int sumx = 0;
        while (a != null) {
            sumx += a.data*mult;
            mult *= 10;
            a = a.next;
        }
        Node b = y;
        mult = 1;
        int sumy = 0;
        while (b!=null) {
            sumy += b.data*mult;
            mult*=10;
            b = b.next;
        }
        int s = sumy + sumx;
        if (s == 0) return new Node(0);
        Node n = new Node(-1);
        Node i = n;
        while (s > 0) {
            i.next = new Node(s%10);
            i = i.next;
            s = s / 10;
        }
        n = n.next;
        return n;
    }

    static void runSum() {
        System.out.println("sum()");
        Node x = new Node(1);
        Node i = x;
        i.next = new Node(2); i = i.next;
        i.next = new Node(3); i = i.next;
        Node y = new Node(4);
        i = y;
        i.next = new Node(5); i = i.next;
        i.next = new Node(6); i = i.next;


        i = x; String line = "";
        while (i != null) {
            line += i.data + " ";
            i = i.next;
        }
        System.out.println(line);
        i = y; line = "";
        while (i != null) {
            line += i.data + " ";
            i = i.next;
        }
        System.out.println(line);

        System.out.println("summing those");
        Node r = sum(x, y);

        i = r; line = "";
        while (i != null) {
            line += i.data + " ";
            i = i.next;
        }
        System.out.println(line);
    }

    static boolean isListPalindrome(Node h) {
        Node n = h;
        String s = "";
        while (n!=null) {
            s+= String.valueOf(n.data);
            n=n.next;
        }
        return isStringPalindrome(s);
    }

    static boolean isStringPalindrome(String s) {
        int x=0;int y=s.length()-1;
        while (x<y) {
            if (s.charAt(x) != s.charAt(y))
                return false;
            ++x; --y;
        }
        return true;
    }

    static void runPalindrome() {
        System.out.println("sum()");
        Node x = new Node(1);
        Node i = x;
        i.next = new Node(2); i = i.next;
        i.next = new Node(3); i = i.next;
        i.next = new Node(3); i = i.next;
        i.next = new Node(2); i = i.next;
        i.next = new Node(1); i = i.next;

        Node y = new Node(1);
        i = y;
        i.next = new Node(2); i = i.next;
        i.next = new Node(3); i = i.next;
        i.next = new Node(2); i = i.next;
        i.next = new Node(1); i = i.next;

        Node z = new Node(1);
        i = z;
        i.next = new Node(2); i = i.next;
        i.next = new Node(3); i = i.next;
        i.next = new Node(2); i = i.next;
        i.next = new Node(2); i = i.next;

        i = x; String line = "";
        while (i != null) {
            line += i.data + " ";
            i = i.next;
        }
        System.out.println(line);
        System.out.println("is Palindrome: " + isListPalindrome(x));

        i = y; line = "";
        while (i != null) {
            line += i.data + " ";
            i = i.next;
        }
        System.out.println(line);
        System.out.println("is Palindrome: " + isListPalindrome(y));

        i = z; line = "";
        while (i != null) {
            line += i.data + " ";
            i = i.next;
        }
        System.out.println(line);
        System.out.println("is Palindrome: " + isListPalindrome(z));
    }

    public static void run() {
        runRemoveDuplicates();
        runFindKLast();
        runRemoveMiddle();
        runReverse();
        runPartition();
        runSum();
        runPalindrome();
    }
}
