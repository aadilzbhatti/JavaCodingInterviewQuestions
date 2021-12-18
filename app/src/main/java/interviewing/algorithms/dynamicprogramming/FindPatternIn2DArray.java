package interviewing.algorithms.dynamicprogramming;

public class FindPatternIn2DArray {

    public static boolean findPatternIn2DArrayRecursive(int[][] arr, int[] pattern) {
        return findPatternRecursiveHelper(arr, 0, 0, pattern, 0);
    }

    private static boolean findPatternRecursiveHelper(int[][] arr, int i, int j, int[] pattern, int k) {
        if (i == arr.length || j == arr[0].length || i < 0 || j < 0) {
            return k == pattern.length;
        }
        if (arr[i][j] == pattern[k]) {
            return findPatternRecursiveHelper(arr, i + 1, j, pattern, k + 1) ||
                    findPatternRecursiveHelper(arr, i, j + 1, pattern, k + 1) ||
                    findPatternRecursiveHelper(arr, i - 1, j, pattern, k + 1) ||
                    findPatternRecursiveHelper(arr, i, j - 1, pattern, k + 1) ||
                    findPatternRecursiveHelper(arr, i + 1, j, pattern, k) ||
                    findPatternRecursiveHelper(arr, i, j + 1, pattern, k) ||
                    findPatternRecursiveHelper(arr, i - 1, j, pattern, k) ||
                    findPatternRecursiveHelper(arr, i, j - 1, pattern, k);
        } else {
            return false;
        }
    }

    public static boolean findPatternLessRecursive(int[][] arr, int[] pattern) {
        boolean[][][] cache = new boolean[arr.length][arr[0].length][pattern.length];
        boolean[][][] visited = new boolean[arr.length][arr[0].length][pattern.length];
        return findPatternLessRecursiveHelper(arr, 0, 0, pattern, 0, cache, visited);
    }

    private static boolean findPatternLessRecursiveHelper(int[][] arr, int i, int j, int[] pattern, int k, boolean[][][] cache, boolean[][][] visited) {
        if (i == arr.length || j == arr[0].length || i < 0 || j < 0) {
            return k == pattern.length;
        }
        if (!visited[i][j][k]) {
            if (arr[i][j] == pattern[k]) {
                cache[i][j][k] = findPatternLessRecursiveHelper(arr, i + 1, j, pattern, k + 1, cache, visited) ||
                        findPatternLessRecursiveHelper(arr, i, j + 1, pattern, k + 1, cache, visited) ||
                        findPatternLessRecursiveHelper(arr, i - 1, j, pattern, k + 1, cache, visited) ||
                        findPatternLessRecursiveHelper(arr, i, j - 1, pattern, k + 1, cache, visited) ||
                        findPatternLessRecursiveHelper(arr, i + 1, j, pattern, k, cache, visited) ||
                        findPatternLessRecursiveHelper(arr, i, j + 1, pattern, k, cache, visited) ||
                        findPatternLessRecursiveHelper(arr, i - 1, j, pattern, k, cache, visited) ||
                        findPatternLessRecursiveHelper(arr, i, j - 1, pattern, k, cache, visited);
            }
            visited[i][j][k] = true;
        }
        return cache[i][j][k];
    }
}
