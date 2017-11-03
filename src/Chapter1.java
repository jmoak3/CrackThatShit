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
    static void insert20InPlace(Character[] c) {
        boolean foundChar = false;
        int shiftIndex = -1;
        for (int i=c.length-1;i>=0;--i) {
            if (!foundChar && c[i] != ' ') {
                shiftIndex = i;
                foundChar = true;
            }
            else if (foundChar && c[i] == ' ') {
                shiftIndex += 2;
                for (int j=shiftIndex;j>i+2;--j) {
                    c[j] = c[j-2];
                }
                c[i] = '2'; c[i+1] = '0'; c[i+2] = '%';
            }
        }
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

        //Is permutation
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

        //Insert 20%
        System.out.println("insert20%InPlace()");
        String[] insertStrings = {
                "Hello How are yu      ",
                " But   what about the cars              ",
                "",
                "abacxd"};
        for (int i=0;i<insertStrings.length;++i) {
            Character[] array =
                    insertStrings[i].chars().mapToObj(c -> (char)c).toArray(Character[]::new);
            System.out.println("Trying: " + insertStrings[i] + ".");
            insert20InPlace(array);
            String s = "";
            StringBuilder sb = new StringBuilder(array.length);
            for (int j=0;j<array.length;++j) {
                sb.append(array[j]);
            }
            System.out.println("Result:" + sb.toString() +".");
        }
    }
}
