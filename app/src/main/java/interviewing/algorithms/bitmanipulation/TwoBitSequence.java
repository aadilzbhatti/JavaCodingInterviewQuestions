package interviewing.algorithms.bitmanipulation;

public class TwoBitSequence {

    public static int getNthElement(int n) {
        int k = 0;
        int exp = 1;
        int res = 0;
        while (k < n) {
            int curr = 0;
            for (int i = 0; i < exp; i++) {
                if (k == n) {
                    return res;
                }
                res = (1 << exp) + (1 << curr);
                curr++;
                k++;
            }
            exp++;
        }
        return res;
    }
}
