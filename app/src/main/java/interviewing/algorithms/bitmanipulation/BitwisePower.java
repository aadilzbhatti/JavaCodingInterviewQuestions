package interviewing.algorithms.bitmanipulation;

public class BitwisePower {

    public static int power(int base, int pow) {
        int res = 1;
        while (pow > 0) {
            if ((pow & 1) == 1) {
                res *= base;
            }
            pow >>>= 1;
            base *= base;
        }
        return res;
    }
}
