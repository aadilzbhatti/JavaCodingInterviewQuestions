package interviewing.algorithms.recursion;

import java.util.ArrayList;
import java.util.List;

public class NQueensAgain {

    public static List<List<Integer>> nQueens(int n) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> queens = new ArrayList<>();
        nQueens(0, n, result, queens);
        return result;
    }

    private static void nQueens(int start, int n, List<List<Integer>> result, List<Integer> queens) {
        if (start == n) {
            result.add(new ArrayList<>(queens));
            return;
        }

        for (int j = 0; j < n; j++) {
            boolean safe = true;
            for (int i = 0; i < start; i++) {
                if (queens.get(i) == j) {
                    safe = false;
                    break;
                }
                if (Math.abs(queens.get(i) - j) == Math.abs(start - i)) {
                    safe = false;
                    break;
                }
            }
            if (safe) {
                queens.add(start, j);
                nQueens(start + 1, n, result, queens);
                queens.remove(start);
            }
        }
    }
}
