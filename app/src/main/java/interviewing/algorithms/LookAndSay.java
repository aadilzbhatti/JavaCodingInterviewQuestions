package interviewing.algorithms;

public class LookAndSay {

    public static void lookAndSay(int n) {
        int seq = 1;
        String currSeq = "";
        while (seq++ < n) {
            StringBuilder newSeq = new StringBuilder();
            if (currSeq.isEmpty()) {
                currSeq = "1";
                System.out.println(currSeq);
            }
            int i = 0;
            while (i < currSeq.length()) {
                char currChar = currSeq.charAt(i);
                int counter = 0;
                while (currSeq.charAt(i) == currChar) {
                    counter++;
                    i++;
                    if (i == currSeq.length()) break;
                }
                newSeq.append(counter).append(currChar);
            }
            currSeq = newSeq.toString();
            System.out.println(newSeq);
        }
    }
}
