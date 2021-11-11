package interviewing.algorithms.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {

    public static List<List<Integer>> placeQueens(int n) {
        Integer[] queens = new Integer[n];
        List<List<Integer>> out = new ArrayList<>();
        placeQueensHelper(queens, 0, out);
        return out;
    }

    private static void placeQueensHelper(Integer[] queens, int column, List<List<Integer>> out) {
        if (column == queens.length) {
            out.add(Arrays.asList(queens.clone()));
            return;
        }
        for (int i = 0; i < queens.length; i++) {
            boolean isValid = true;
            for (int j = 0; j < column; j++) {
                if (i == queens[j] || Math.abs(i - queens[j]) == Math.abs(column - j)) {
                    isValid = false;
                    break;
                }
            }
            if (isValid) {
                queens[column] = i;
                placeQueensHelper(queens, column + 1, out);
            }
        }
    }
}
