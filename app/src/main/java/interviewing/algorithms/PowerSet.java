package interviewing.algorithms;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class PowerSet {

    public static Set<Set<Integer>> getPowerSet(Set<Integer> origSet) {
        Set<Set<Integer>> powerSet = new HashSet<>();
        powerSet.add(Collections.emptySet());
        for (int element : origSet) {
            Set<Set<Integer>> newSet = powerSet.stream().map(set -> {
                Set<Integer> newAddition = new HashSet<>(set);
                newAddition.add(element);
                return newAddition;
            }).collect(Collectors.toSet());
            powerSet.addAll(newSet);
        }
        return powerSet;
    }
}
