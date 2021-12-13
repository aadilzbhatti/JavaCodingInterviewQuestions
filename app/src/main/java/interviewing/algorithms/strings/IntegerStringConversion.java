package interviewing.algorithms.strings;

public class IntegerStringConversion {
    public static int atoi(String num) throws Exception {
        int start = 0;
        boolean isNegative = false;
        if (num.charAt(0) == '-') {
            isNegative = true;
            start++;
        }
        int res = 0;
        for (int i = start; i < num.length(); i++) {
            char c = num.charAt(i);
            if (!isDigit(c)) {
                throw new Exception("Invalid input: " + num);
            }
            int digit = getDigit(c);
            res = res * 10 + digit;
        }
        if (isNegative) {
            res *= -1;
        }
        return res;
    }

    private static boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }

    private static int getDigit(char c) {
        return c - '0';
    }

    public static String itoa(int num) {
        boolean isNegative = false;
        if (num < 0) {
            isNegative = true;
            num *= -1;
        }
        StringBuilder res = new StringBuilder();
        if (num == 0) return "0";
        while (num > 0) {
            int digit = num % 10;
            res.append(digit);
            num /= 10;
        }
        if (isNegative) {
            res.append("-");
        }
        return res.reverse().toString();
    }
}
