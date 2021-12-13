package interviewing.algorithms.strings;

public class WrapText {

    public static String wrapText(String body, int lineLength) {
        int start = 0;
        int curr = 0;
        int lastSpace = -1;
        int end;
        StringBuilder sb = new StringBuilder();
        while (curr < body.length()) {
            char c = body.charAt(curr);
            if (isWhitespace(c)) {
                lastSpace = curr;
            }
            if (curr - start + 1 == lineLength) {
                end = curr + 1;
                if (curr + 1 == body.length()) {
                    return sb.toString();
                }
                if (!isWhitespace(body.charAt(curr + 1))) {
                    if (lastSpace < 0) {
                        while (curr < body.length() && !isWhitespace(body.charAt(curr))) {
                            curr++;
                        }
                        end = curr;
                    } else {
                        end = lastSpace + 1;
                        curr = lastSpace + 1;
                    }
                }
                sb.append(body, start, end).append("\n");
                start = end;
                lastSpace = -1;
            } else {
                curr++;
            }
        }

        if (curr > start) {
            sb.append(body, start, curr).append("\n");
        }

        return sb.toString();
    }

    private static boolean isWhitespace(char c) {
        return c == ' ' || c == '\t';
    }
}
