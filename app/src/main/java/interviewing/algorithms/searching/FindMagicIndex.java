package interviewing.algorithms.searching;

public class FindMagicIndex {
    public static int findMagicIndex(int[] arr) {
        return findMagicIndexHelper(arr, 0, arr.length - 1);
    }

    private static int findMagicIndexHelper(int[] arr, int lo, int hi) {
        if (lo > hi) return -1;
        if (lo == hi) return arr[lo] == lo ? lo : -1;
        int med = (lo + hi) / 2;
        if (arr[med] == med) {
            return med;
        }
        return findMagicIndexHelper(arr, lo, med - 1);
    }
}
