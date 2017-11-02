import java.util.HashMap;

public class Chapter1 {
    static boolean isUnique(String s) {
        int[] alph = new int[127];
        for (int i=0;i<127;++i) alph[i] = 0;
        for (int i=0;i<s.length();++i) {
            int v = s.charAt(i);
            if (alph[v]++ > 1) return false;
        }
        return true;
    }

    static boolean isPermutation(String x, String y) {
        int[] alph = new int[127];
        for (int i=0;i<127;++i) alph[i] = 0;
        for (int i=0;i<y.length();++i) {
            int v = y.charAt(i);
            alph[v]++;
        }
        for (int i=0;i<x.length();++i) {
            int v = x.charAt(i);
            alph[v]--;

            if (alph[v] < 0) return false;
        }
        return true;
    }

    public static void main(String [] args) {
        //isUnique
        System.out.println("isUnique()");
        String[] strings = {"abcxd",
                "abcxa",
                "abacxd",
                "abacxd",
                "DSDAD",
                "/;;;/",
                "/][-_"};

        for (int i=0;i<strings.length;++i) {

            System.out.println("Trying: " + strings[i]
                    + " Result: " + isUnique(strings[i]));
        }

        System.out.println("isPermutation()");
        String[] stringX = {"abcxd",
                "abcxa",
                "abacxd",
                "abacxd",
                "d2rccxv",
                "/;';/",
                "/]]]][-_"};
        String[] stringY = {"adcxb",
                "abhxc",
                "dxcaba",
                "abacxd",
                "1",
                "/;;'/",
                "/][-_]]]"};

        for (int i=0;i<strings.length;++i) {

            System.out.println("Trying: " + stringX[i] + ", " + stringY[i]
                    + " Result: " + isPermutation(stringX[i], stringY[i]));
        }
    }
}
