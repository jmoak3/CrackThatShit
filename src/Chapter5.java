import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

import static java.lang.StrictMath.abs;
import static java.lang.StrictMath.exp;
import static java.lang.StrictMath.max;

public class Chapter5 {

    static public String bitsToString(int b) {
        boolean foundOne = false;
        String s = "";
        for (int i=31;i>=0;--i) {
            String v = (b & (1 << i)) != 0 ? "1" : "0";
            if (v == "1" && !foundOne) foundOne = true;
            if (foundOne) s += v;
        }
        return s;
    }

    static public int insertBits(int n, int m, int i, int j) {
        int left = (~0) << (j+1);
        int right = (1 << i) - 1;
        int mask = left | right;
        return (n & mask) | (m << i);
    }

    static void runInsertBits() {
        System.out.println("InsertBits()");
        int n = 1024;
        int m = 19;
        int expected = 1100;

        int x = insertBits(n,m,2,6);

        System.out.println(bitsToString(n) + " mixed with " + bitsToString(m));
        System.out.println("Makes values: " + (x) + " expected: " + (expected));
        System.out.println("bits:" + bitsToString(x) + " " + bitsToString(expected));

        System.out.println();
    }

    static public String doubleToString(double d) {
        if ( d>=1 || d<0 )
            return "Fuck";
        String s = "";
        while (d > 0) {
            double r = d * 2;
            if (r >= 1) {
                s += "1";
                d = r - 1;
            } else {
                s += "0";
                d = r;
            }
        }
        return s;
    }

    static void runDoubleToString() {
        System.out.println("DoubleToString()");
        double d = 0.625;
        System.out.println(d + " in binary: " + doubleToString(d));

        System.out.println();
    }

    public static void run() {
        System.out.println();
        System.out.println();
        runInsertBits();
        runDoubleToString();
    }
}