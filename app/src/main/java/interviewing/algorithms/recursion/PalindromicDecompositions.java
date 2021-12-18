package interviewing.algorithms.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PalindromicDecompositions {

    public static List<List<String>> getPalindromicDecompositions(String s) {
        return getDecompsHelper(s, 0, new ArrayList<>());
    }

    private static List<List<String>> getDecompsHelper(String s, int start, List<String> currList) {
        if (start >= s.length()) {
            return Arrays.asList(new ArrayList<>(currList));
        }
        List<List<String>> currDecompSet = new ArrayList<>();
        for (int i = start; i <= s.length(); i++) {
            String substring = s.substring(start, i);
            if (isPalindrome(substring)) {
                currList.add(substring);
                List<List<String>> decomps = getDecompsHelper(s, i, currList);
                currList.remove(substring);
                currDecompSet.addAll(decomps);
            }
        }
        return currDecompSet;
    }

    private static boolean isPalindrome(String s) {
        if (s.isEmpty()) return false;
        for (int k = 0; k < s.length() / 2; k++) {
           if (s.charAt(k) != s.charAt(s.length() - k - 1)) {
               return false;
           }
        }
        return true;
    }
}
