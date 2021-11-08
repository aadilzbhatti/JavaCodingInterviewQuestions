package interviewing.algorithms.dynamicprogramming;

import java.util.HashSet;
import java.util.Set;

public class AllValidParenCombos {

    public static Set<String> getAllValidParenCombos(int n) {
        Set<String> outputSet = new HashSet<>();
        outputSet.add("()");
        for (int i = 1; i < n; i++) {
            Set<String> toAdd = new HashSet<>();
            for (String parenStr : outputSet) {
                String p1 = "(" + parenStr + ")";
                String p2 = "()" + parenStr;
                String p3 = parenStr + "()";
                toAdd.add(p1);
                toAdd.add(p2);
                toAdd.add(p3);
            }
            outputSet = toAdd;
        }
        return outputSet;
    }
}
