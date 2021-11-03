package interviewing.algorithms.recursion;

public class SpiralArray {

    public static int[][] getSpiralArray(int n) {
        int[][] arr = new int[n][n];
        int counter = 1;
        return spiralHelper(0, n - 1, arr, counter);
    }

    private static int[][] spiralHelper(int left, int right, int[][] arr, int counter) {
        if (left > right) {
            return arr;
        }
        if (left == right) {
            arr[left][right] = counter;
            return arr;
        }
        for (int i = left; i <= right; i++) {
            arr[left][i] = counter++;
        }
        for (int i = left + 1; i <= right; i++) {
            arr[i][right] = counter++;
        }
        for (int i = right - 1; i >= left; i--) {
            arr[right][i] = counter++;
        }
        for (int i = right - 1; i > left; i--) {
            arr[i][left] = counter++;
        }
        return spiralHelper(left + 1, right - 1, arr, counter);
    }
}

