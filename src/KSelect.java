import java.util.LinkedList;
import java.util.Random;

public class KSelect {

    static public int kselect(int[] arr, int k) {
        if (arr.length < 1) return 0;
        int min = 0;
        int max = arr.length-1;
        if (min == max) return arr[min];
        Random rand = new Random();
        while (true) {
            int pivotIndex = rand.nextInt(max-min+1) + min;
            pivotIndex = partition(arr, pivotIndex, min, max);

            if (k == pivotIndex) {
                return arr[k];
            }
            else if (k < pivotIndex) {
                max = pivotIndex -1;
            }
            else {
                min = pivotIndex + 1;
            }
        }
    }
    static void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
    static public int partition(int[] arr, int pivotIndex, int min, int max) {
        int pivotValue = arr[pivotIndex];
        swap(arr, pivotIndex, max);
        int startIndex = min;
        for (int i=min;i<max;++i) {
            if (arr[i] < pivotValue) {
                swap(arr, startIndex, i);
                ++startIndex;
            }
        }

        swap(arr, startIndex, max);

        return startIndex;
    }

    static public void test() {
        System.out.println();
        System.out.println("KSelect Test");

        int[][] tests = {
                {},
                {5},
                {7, 6},
                {9, 6, 2, 1, 7, 4, 8},
                {9, 6, 2, 1, 7, 4, 8, 10},
                {1, 4, 1, 111, 0, 2, 564, 2, 8, 5, 7, 9, 4, 2, 3},
        };

        String s = "";
        for (int j=0;j<tests.length;++j) {
            s = "";
            for (int i = 0; i < tests[j].length; ++i) {
                s += "" + tests[j][i] + ",";
            }
            System.out.println("test"+j+": " + s);
            System.out.println("median: " + (kselect(tests[j], (tests[j].length-1)/2) + kselect(tests[j], (tests[j].length)/2))/2.0);
        }
        System.out.println();
        System.out.println();

    }
}
