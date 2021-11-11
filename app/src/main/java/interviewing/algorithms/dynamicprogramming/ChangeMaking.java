package interviewing.algorithms.dynamicprogramming;

public class ChangeMaking {

    public static int countWaysToMakeChangeRecursive(int n) {
        int[] denoms = new int[] { 25, 10, 5, 1 };
        return countWaysRecHelper(n, 0, denoms);
    }

    private static int countWaysRecHelper(int n, int denomIdx, int[] denoms) {
        if (n == 0) return 1;
        int ways = 0;
        for (int i = denomIdx; i < denoms.length; i++) {
            if (denoms[i] <= n) {
                ways += countWaysRecHelper(n - denoms[i], i, denoms);
            }
        }
        return ways;
    }

    public static int countWaysToMakeChangeLessRecursive(int n) {
        int[] denoms = new int[] { 25, 10, 5, 1 };
        int[][] arr = new int[n + 1][denoms.length];
        return countWaysToMakeChangeLessRecursive(n, 0, denoms, arr);
    }

    private static int countWaysToMakeChangeLessRecursive(int n, int denomIdx, int[] denoms, int[][] arr) {
        if (n == 0) {
            for (int i = 0; i < denoms.length; i++) {
                arr[0][i] = 1;
            }
        } else if (arr[n][denomIdx] == 0) {
            for (int i = denomIdx; i < denoms.length; i++) {
                if (denoms[i] <= n) {
                    arr[n][denomIdx] += countWaysToMakeChangeLessRecursive(n - denoms[i], i, denoms, arr);
                }
            }
        }

        return arr[n][denomIdx];
    }
}
