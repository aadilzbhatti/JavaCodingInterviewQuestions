package interviewing.algorithms.sorting;

public class MergeSmallerSortedArrayIntoLarger {

    public static void mergeSmallerSortedArrayIntoLarger(int[] a, int[] b) {
        assert a.length > b.length;
        int i = 0;
        int j = 0;
        int offset = 0;
        while (i < a.length && j < b.length) {
            if (a[i] > b[j]) {
                System.arraycopy(a, i, a, i + 1, a.length - b.length - offset);
                a[i] = b[j];
                j++;
            } else {
                offset++;
            }
            i++;
        }
    }
}
