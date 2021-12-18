package interviewing.algorithms.bitmanipulation;

public class ReverseBits {

    public static int reverseBits(int n) {
        int res = 0;
        while (n > 0) {
            int lsb = n & 1;
            res = (res << 1) | lsb;
            n >>>= 1;
        }
        return res;
    }
}
