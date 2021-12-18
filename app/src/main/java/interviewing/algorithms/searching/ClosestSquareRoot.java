package interviewing.algorithms.searching;

public class ClosestSquareRoot {
    public static int closestSquareRoot(int val) {
        int n = val;
        int lastVal = val;
        int square = n * n;
        while (square > val) {
            lastVal = n;
            n /= 2;
            square = n * n;
        }
        if (n * n == val) return n;
        int currMin = n;
        int currMax = lastVal;
        while (n * n < val && currMax - currMin > 1) {
            int v = (currMax + currMin) / 2;
            if (v * v > val) {
                currMax  = v;
            } else {
                currMin = v;
                n = v;
            }
        }
        return n;
    }
}
