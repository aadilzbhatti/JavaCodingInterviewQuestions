package interviewing.algorithms.searching;

public class BinarySearch {

    public static int binarySearch(int[] arr, int val) {
        assertSorted(arr);
        return binarySearchHelper(arr, 0, arr.length - 1, val);
    }

    private static int binarySearchHelper(int[] arr, int lo, int hi, int val) {
        if (lo > hi) {
            return -1;
        }
        if (lo == hi) {
            if (arr[lo] == val) return lo;
            return -1;
        }
        int med = (lo + hi) / 2;
        if (val < arr[med]) {
            return binarySearchHelper(arr, lo, med - 1, val);
        } else if (val > arr[med]) {
            return binarySearchHelper(arr, med + 1, hi, val);
        }
        return med;
    }

    private static void assertSorted(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            assert arr[i] <= arr[i + 1];
        }
    }
}
