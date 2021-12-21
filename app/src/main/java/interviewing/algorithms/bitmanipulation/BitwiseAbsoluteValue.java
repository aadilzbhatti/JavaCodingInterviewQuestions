package interviewing.algorithms.bitmanipulation;

public class BitwiseAbsoluteValue {

    public static int abs(int x) {
        int lessThanZero = x < 0 ? 1 : 0;
        int geThanZero = x >= 0 ? 1 : 0;
        return (-lessThanZero & (~x + 1)) ^ (x & -geThanZero);
    }
}
