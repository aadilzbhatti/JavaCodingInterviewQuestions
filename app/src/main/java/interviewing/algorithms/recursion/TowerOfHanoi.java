package interviewing.algorithms.recursion;

import java.util.ArrayDeque;
import java.util.Deque;

public class TowerOfHanoi {

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
