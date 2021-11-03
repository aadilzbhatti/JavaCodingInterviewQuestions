package interviewing.algorithms.dynamicprogramming;

public class TripleStep {
    public static int countPossibleStepPatterns(int n) {
        int[] steps = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            steps[i] = 0;
            if (i - 1 >= 0) {
                steps[i] += 1 + steps[i - 1];
            }
            if (i - 2 >= 0) {
                steps[i] += 1 + steps[i - 2];
            }
            if (i - 3 >= 0) {
                steps[i] += 1 + steps[i - 3];
            }
        }
        return steps[n];
    }
}
