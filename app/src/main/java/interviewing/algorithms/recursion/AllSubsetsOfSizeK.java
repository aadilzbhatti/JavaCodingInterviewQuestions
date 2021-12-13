package interviewing.algorithms.recursion;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class AllSubsetsOfSizeK {

    public static Set<Set<Integer>> getAllSubsetsOfSizeK(int k, int n) {
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i < n + 1; i++) {
            set.add(i);
        }
        return sizeKSubsetsHelper(k, set);
    }

    private static Set<Set<Integer>> sizeKSubsetsHelper(int k, Set<Integer> set) {
        if (k == 0) return Set.of(new HashSet<>());
        Set<Set<Integer>> output = new HashSet<>();
        Set<Integer> removed = new HashSet<>(set);
        for (int i : set) {
            removed.remove(i);
            Set<Set<Integer>> subset = new HashSet<>(sizeKSubsetsHelper(k - 1, removed));
            subset = subset.stream().peek(s -> s.add(i)).collect(Collectors.toSet());
            output.addAll(subset);
        }
        return output;
    }
}
