package interviewing.algorithms.dynamicprogramming;

public class OneEditApart {

    public static boolean oneEditApart(String s1, String s2) {
        int[][] arr = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0 && j == 0) {
                    arr[i][j] = 0;
                } else if (i == 0) {
                    arr[i][j] = j;
                } else if (j == 0) {
                    arr[i][j] = i;
                } else {
                    if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                        arr[i][j] = min(arr[i - 1][j], arr[i][j - 1], arr[i - 1][j - 1]);
                    } else {
                        arr[i][j] = 1 + min(arr[i - 1][j], arr[i][j - 1], arr[i - 1][j - 1]);
                    }
                }
            }
        }

        return arr[s1.length()][s2.length()] == 1;
    }

    private static int min(int a1, int a2, int a3) {
        return Math.min(Math.min(a1, a2), a3);
    }
}
