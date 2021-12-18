package interviewing.algorithms.bitmanipulation;

public class PalindromicBitString {

    public static boolean isPalindrome(int n) {
        return ReverseBits.reverseBits(n) == n;
    }
}
