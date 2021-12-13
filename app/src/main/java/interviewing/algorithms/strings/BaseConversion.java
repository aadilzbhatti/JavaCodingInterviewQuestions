package interviewing.algorithms.strings;

import java.util.HashMap;
import java.util.Map;

public class BaseConversion {

    private static final Map<Character, Integer> charIntMap = new HashMap<>() {{
        put('A', 10);
        put('B', 11);
        put('C', 12);
        put('D', 13);
        put('E', 14);
        put('F', 15);
    }};

    private static final Map<Integer, Character> intCharMap = new HashMap<>() {{
        put(10, 'A');
        put(11, 'B');
        put(12, 'C');
        put(13, 'D');
        put(14, 'E');
        put(15, 'F');
    }};

    public static String convertFromBaseToBase(String s, int b1, int b2) {
        int b10Val = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int digit = getDigitFromChar(c);
            b10Val = b10Val * b1 + digit;
        }
        StringBuilder res = new StringBuilder();
        while (b10Val > 0) {
            int nextDigit = b10Val % b2;
            char c = getCharFromDigit(nextDigit);
            res.append(c);
            b10Val /= b2;
        }

        return res.reverse().toString();
    }

    private static int getDigitFromChar(char c) {
        if (charIntMap.containsKey(c)) {
            return charIntMap.get(c);
        }
        return c - '0';
    }

    private static char getCharFromDigit(int digit) {
        if (intCharMap.containsKey(digit)) {
            return intCharMap.get(digit);
        }
        return (char) (digit + '0');
    }
}
