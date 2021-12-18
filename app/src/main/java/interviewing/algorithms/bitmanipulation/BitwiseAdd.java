package interviewing.algorithms.bitmanipulation;

public class BitwiseAdd {

    public static int add(int m, int n) {
        int carry = 0;
        int res = 0;
        int k = 0;
        while (m > 0 || n > 0) {
            int nbit = n & 1;
            int mbit = m & 1;
            int val = mbit ^ nbit ^ carry;
            carry = (carry & mbit) | (carry & nbit) | (mbit & nbit);
            res |= (val << k);
            k++;
            n >>>= 1;
            m >>>= 1;
        }
        if (carry == 1) {
           res |= (1 << k);
        }
        return res;
    }
}
