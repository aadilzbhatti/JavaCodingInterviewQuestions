package interviewing.algorithms.bitmanipulation;

public class BitwiseDivision {
    public static int divide(int dividend, int divisor) {
        int currDividend = dividend;
        int currDivisor = divisor;
        int q = 0;
        while (currDividend >= currDivisor) {
            int k = 0;
            while (currDivisor <= currDividend) {
                currDivisor <<= 1;
                if (currDivisor <= currDividend) {
                    k++;
                }
            }
            currDividend -= divisor << k;
            currDivisor = divisor;
            q |= 1 << k;
        }
        return q;
    }
}
