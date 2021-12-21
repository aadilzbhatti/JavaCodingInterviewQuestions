package interviewing.algorithms.bitmanipulation;

import java.util.HashSet;
import java.util.Set;

public class ArrayBitwiseOr {

    public static int numBitwiseOrResults(int[] arr) {
        Set<Integer> results = new HashSet<>();
        computeOrResults(arr, 0, results);
        return results.size();
    }

    private static void computeOrResults(int[] arr, int start, Set<Integer> results) {
        if (start == arr.length) {
            return;
        }
        for (int i = start; i < arr.length; i++) {
            int res = computeBitwiseOr(arr, start, i);
            results.add(res);
            computeOrResults(arr, start + 1, results);
        }
    }

    private static int computeBitwiseOr(int[] arr, int start, int end) {
        int res = 0;
        for (int i = start; i <= end; i++) {
            res |= arr[i];
        }
        return res;
    }
}
