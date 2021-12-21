package interviewing.algorithms.recursion;

import java.util.ArrayList;
import java.util.List;

public class GrayCode {

    public static List<List<Integer>> grayCode(int n) {
        List<List<Integer>> all = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        int max = (1 << n) - 1;
        compute(max, 0, curr, all);
        return all;
    }

    private static void compute(int max, int lastAddedVal, List<Integer> curr, List<List<Integer>> all) {
        if (curr.size() > max) {
            if (setBitsDifferInOnlyOnePlace(curr.get(curr.size() - 1), curr.get(0))) {
                all.add(new ArrayList<>(curr));
                return;
            }
        }
        for (int i = 0; i <= max; i++) {
            if (!curr.contains(i)) {
                if (i == 0 && curr.size() == 0) {
                    Integer val = i;
                    curr.add(val);
                    compute(max, 0, curr, all);
                    curr.remove(val);
                } else {
                    if (setBitsDifferInOnlyOnePlace(i, lastAddedVal)) {
                        Integer val = i;
                        curr.add(val);
                        compute(max, val, curr, all);
                        curr.remove(val);
                    }
                }
            }
        }
    }

    private static boolean setBitsDifferInOnlyOnePlace(int v1, int v2) {
        int val = v1 ^ v2;
        return numSetBits(val) == 1;
    }

    private static int numSetBits(int val) {
        int nsb = 0;
        while (val > 0) {
            nsb++;
            val &= val - 1;
        }
        return nsb;
    }
}
