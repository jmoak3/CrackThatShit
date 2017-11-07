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

    static int getCurrentCount(char c, HashMap<Character, Integer> h) {
        if (h.get(c) == null) {
            return 0;
        }
        else {
            return h.get(c);
        }
    }


    static boolean permutesToPalindrome(String s) {
        HashMap<Character, Integer> hash = new HashMap<Character, Integer>();
        for (Character c : s.toCharArray()) {
            int count = getCurrentCount(c, hash);
            hash.put(c, count+1);
        }
        int isOdd = s.length() % 2;
        for (int v : hash.values()) {
            if (isOdd > 0 && v % 2 == 1) isOdd--;
            else if (v%2 == 1) return false;
        }
        return true;
    }

    static boolean isOneAway(String a, String b) {
        int x=0; int y=0;
        if (Math.abs(a.length() - b.length()) > 1) return false;
        int diffs = 0;
        while (x < a.length() && y< b.length()) {
            if (a.charAt(x) != b.charAt(y)) {
                if (++diffs > 1) return false;
                if (a.length() > b.length()) x++;
                else if (a.length() < b.length()) y++;
                else {x++; y++;}
            }
            else {x++; y++;}
        }
        return true;
    }

    static String compress(String s) {
        int x=0; int y=0;
        char curr = ' ';
        int count = 0;
        String compressed = "";
        while (y < s.length()) {
            if (curr != s.charAt(y)) {
                if (count != 0) compressed += ""+count;
                curr = s.charAt(y);
                count = 1;
                compressed += curr;
            }
            else {
                ++count;
            }
            ++y;
        }
        compressed += ""+count;
        if (compressed.length() < s.length()) return compressed;
        else return s;
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

        for (int i=0;i<stringX.length;++i) {

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

        //isPalindrome
        System.out.println("isPalindrome()");
        String[] palindromes = {"racecar",
                "rceer",
                "reeeeer",
                "rcercaa",
                "adsaddddasfa",
                "aa",
                "/\\;;/"};

        for (int i=0;i<palindromes.length;++i) {
            System.out.println("Trying: " + palindromes[i]
                    + " Result: " + permutesToPalindrome(palindromes[i]));
        }

        //isOneAway
        System.out.println("isOneAway()");
        String[] stringA =
               {"kape",
                "kale",
                "mans",
                "malse",
                "malse",
                "aaaa",
                "bbb"};

        String[] stringB =
               {"kaspe",
                "pale",
                "mazn",
                "male",
                "males",
                "aaa",
                "a"};

        for (int i=0;i<stringA.length;++i) {
            System.out.println("Trying: " + stringA[i] + ", " + stringB[i]
                + " Result: " + isOneAway(stringA[i], stringB[i]));
        }


        //compress
        System.out.println("compress()");
        String[] compressed =
               {"racecar",
                "rceer",
                "reeeeer",
                "rcercaa",
                "adsaddddasfa",
                "aa",
                "aaaaaabbeedcsee",
                "dsafawwwwweeesz",
                "eeeexxz",
                "/\\;;/"};

        for (int i=0;i<compressed.length;++i) {
            System.out.println("Trying: " + compressed[i]
                    + " Result: " + compress(compressed[i]));
        }
    }
}
