package interviewing.algorithms.recursion;

import java.util.ArrayDeque;
import java.util.Deque;

public class RecursionQuestions {

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

    public static int recursiveMultiply(int x, int y) {
        assert x >= 0;
        assert y >= 0;
        if (y == 0) return 0;
        return x + recursiveMultiply(x, y - 1);
    }

    public static int towerOfHanoi(int n, Deque<Integer> t3) {
        Deque<Integer> t1 = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            t1.push(i + 1);
        }
        return towerOfHanoiHelper(n, t1, new ArrayDeque<>(), t3);
    }

    private static int towerOfHanoiHelper(int n, Deque<Integer> src, Deque<Integer> temp, Deque<Integer> dest) {
        if (n == 0) {
            return 0;
        }
        int m1 = towerOfHanoiHelper(n - 1, src, dest, temp);
        dest.push(src.pop());
        int m2 = towerOfHanoiHelper(n - 1, temp, src, dest);
        return 1 + m1 + m2;
    }
}
