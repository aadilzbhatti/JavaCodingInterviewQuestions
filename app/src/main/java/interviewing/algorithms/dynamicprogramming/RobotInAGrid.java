package interviewing.algorithms.dynamicprogramming;

public class RobotInAGrid {

    public static boolean findPath(int[][] arr, int r, int c) {
        boolean[][] find = new boolean[r][c];
        find[r - 1][c - 1] = arr[r - 1][c - 1] == 0;
        if (!find[r - 1][c - 1]) return false;
        for (int i = r - 1; i >= 0; i--) {
            for (int j = c - 1; j >= 0; j--) {
                if (arr[i][j] == 0) {
                    if (i != r - 1 || j != c - 1) {
                        if (i + 1 == r) {
                            find[i][j] = find[i][j + 1];
                        } else if (j + 1 == c) {
                            find[i][j] = find[i + 1][j];
                        } else {
                            find[i][j] = find[i][j + 1] || find[i + 1][j];
                        }
                    }
                } else {
                    find[i][j] = false;
                }
            }
        }
        return find[0][0];
    }
}
