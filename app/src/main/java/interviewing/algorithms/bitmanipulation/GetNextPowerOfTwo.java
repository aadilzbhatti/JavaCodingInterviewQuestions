package interviewing.algorithms.bitmanipulation;

public class GetNextPowerOfTwo {
    public static int getNextHighestPowerOfTwo(BinaryString x) {
        int val = x.getNumber();
        if ((val & (val - 1)) == 0) return val;
        val <<= 1;
        while ((val & (val - 1)) > 0) {
            int mask = val & -val;
            val ^= mask;
        }
        return val;
    }

    public static int getNextLowestPowerOfTwo(BinaryString x) {
        int val = x.getNumber();
        while ((val & (val - 1)) > 0) {
            int mask = val & -val;
            val ^= mask;
        }
        return val;
    }
}
