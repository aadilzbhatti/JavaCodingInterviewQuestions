package interviewing.algorithms.recursion;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
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

    public static Set<Set<Integer>> powerSetRecursive(Set<Integer> origSet) {
        if (origSet.size() == 0) {
            Set<Set<Integer>> ret = new HashSet<>();
            ret.add(origSet);
            return ret;
        }
        Set<Integer> removed = new HashSet<>(origSet);
        int element = origSet.iterator().next();
        removed.remove(element);
        Set<Set<Integer>> powerSet = powerSetRecursive(removed);
        Set<Set<Integer>> ret = new HashSet<>();
        powerSet.forEach(subset -> {
            Set<Integer> added = new HashSet<>(subset);
            added.add(element);
            ret.add(added);
        });
        powerSet.addAll(ret);
        return powerSet;
    }

    public static Set<Set<Integer>> powerSetWithBits(Set<Integer> origSet) {
        int size = 1 << origSet.size();
        Set<Set<Integer>> powerSet = new HashSet<>();
        for (int i = 0; i < size; i++) {
            Set<Integer> sub = new HashSet<>();
            int bits = i;
            Iterator<Integer> iter = origSet.iterator();
            while (iter.hasNext() && bits > 0) {
                if ((bits & 1) == 1) {
                    sub.add(iter.next());
                } else {
                    iter.next();
                }
                bits >>>= 1;
            }
            powerSet.add(sub);
        }
        return powerSet;
    }
}
