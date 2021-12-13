package interviewing.algorithms.bitmanipulation;

public class EightBitMultiply {
    public static int eightBitMultiply(int n1, int n2) {
        int n1lo = n1 & (2^8 - 1);
        int n2lo = n2 & (2^8 - 1);
        int n1hi = n1 >> 8;
        int n2hi = n2 >> 8;
        int loRes = n1lo * n2lo;
//        int hiRes =
        return 0;
    }
}
