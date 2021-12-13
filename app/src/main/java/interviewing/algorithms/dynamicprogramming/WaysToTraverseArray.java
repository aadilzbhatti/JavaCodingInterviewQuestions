package interviewing.algorithms.dynamicprogramming;

public class WaysToTraverseArray {
    public static int numWaysToTraverse2DArrayOfSize(int n) {
        int[][] arr = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == n - 1 && j == n - 1) {
                    arr[i][j] = 1;
                } else {
                    if (i == n - 1) {
                        arr[i][j] = arr[i][j + 1];
                    } else if (j == n - 1) {
                        arr[i][j] = arr[i + 1][j];
                    } else {
                        arr[i][j] = arr[i][j + 1] + arr[i + 1][j];
                    }
                }
            }
        }

        return arr[0][0];
    }
}
