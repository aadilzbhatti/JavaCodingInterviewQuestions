package interviewing;

public class Quicksort {
    public static void quicksort(int[] arr) {
        quicksortHelper(arr, 0, arr.length - 1);
    }

    private static void quicksortHelper(int[] arr, int lo, int hi) {
        if (lo >= 0 && hi >= 0 && lo < hi) {
            int pivot = partition(arr, lo, hi);
            quicksortHelper(arr, lo, pivot);
            quicksortHelper(arr, pivot + 1, hi);
        }
    }

    private static int partition(int[] arr, int lo, int hi) {
        int l = lo;
        int pivotIndex = (lo + hi) / 2;
        swap(arr, pivotIndex, hi);
        for (int i = lo; i <= hi; i++) {
            if (arr[i] < arr[hi]) {
                swap(arr, i, l);
                l++;
            }
        }
        swap(arr, l, hi);
        return l;
    }

    private static void swap(int[] arr, int start, int end) {
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }
}
