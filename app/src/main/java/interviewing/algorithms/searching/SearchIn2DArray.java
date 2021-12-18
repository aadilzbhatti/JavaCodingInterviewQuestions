package interviewing.algorithms.searching;

public class SearchIn2DArray {
    public static boolean find(int[][] arr, int val) {
        return findHelper(arr, val, 0, arr.length, 0, arr[0].length);
    }

    private static boolean findHelper(int[][] arr, int val, int startI, int endI, int startJ, int endJ) {
        if (startI > endI || startJ > endJ) {
           return false;
        }
        if (startI == endI && startJ == endJ && arr[startI][startJ] != val) {
            return false;
        }
        int medI = (startI + endI) / 2;
        int medJ = (startJ + endJ) / 2;
        if (arr[medI][medJ] < val) {
            return findHelper(arr, val, startI, medI, medJ + 1, endJ) ||
                    findHelper(arr, val,  medI + 1, endI, medJ + 1, endJ) ||
                    findHelper(arr, val, medI + 1, endI,  startJ, medJ);
        } else if (arr[medI][medJ] > val) {
            return findHelper(arr, val, startI, medI, startJ, medJ);
        } else {
            return true;
        }
    }
}
