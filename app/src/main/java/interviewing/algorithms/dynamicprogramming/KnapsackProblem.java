package interviewing.algorithms.dynamicprogramming;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KnapsackProblem {

    public static int computeOptimalValueRecursive(List<Clock> clocks, int maxWeight) {
        return computeOptimalValueRecursiveHelper(clocks, clocks.size() - 1, maxWeight);
    }

    private static int computeOptimalValueRecursiveHelper(List<Clock> clocks, int i, int weight) {
        if (i < 0) return 0;
        Clock clock = clocks.get(i);
        if (clock.weight <= weight) {
            return Math.max(
                    clock.price + computeOptimalValueRecursiveHelper(clocks, i - 1, weight - clock.weight),
                    computeOptimalValueRecursiveHelper(clocks, i - 1, weight)
            );
        } else {
            return computeOptimalValueRecursiveHelper(clocks, i - 1, weight);
        }
    }

    public static int computeOptimalValueLessRecursive(List<Clock> clocks, int maxWeight) {
        Map<Clock, Map<Integer, Integer>> cache = new HashMap<>();
        return computeOptimalValueLessRecursiveHelper(clocks, clocks.size() - 1, maxWeight, cache);
    }

    private static int computeOptimalValueLessRecursiveHelper(List<Clock> clocks, int i, int weight, Map<Clock, Map<Integer, Integer>> cache) {
        if (i < 0) return 0;
        Clock clock = clocks.get(i);
        if (!cache.containsKey(clock)) {
            Map<Integer, Integer> weightValues = new HashMap<>();
            int val = getWeightValue(clocks, i, weight, cache, clock);
            weightValues.put(weight, val);
            cache.put(clock, weightValues);
        } else {
            Map<Integer, Integer> weightValues = cache.get(clock);
            if (!weightValues.containsKey(weight)) {
                int val = getWeightValue(clocks, i, weight, cache, clock);
                weightValues.put(weight, val);
            }
        }
        return cache.get(clock).get(weight);
    }

    private static int getWeightValue(List<Clock> clocks, int i, int weight, Map<Clock, Map<Integer, Integer>> cache, Clock clock) {
        if (clock.weight <= weight) {
            return Math.max(
                    clock.price + computeOptimalValueLessRecursiveHelper(clocks, i - 1, weight - clock.weight, cache),
                    computeOptimalValueLessRecursiveHelper(clocks, i - 1, weight, cache)
            );
        } else {
            return computeOptimalValueLessRecursiveHelper(clocks, i - 1, weight, cache);
        }
    }

    public static class Clock {
        int price;
        int weight;

        public Clock(int price, int weight) {
            this.price = price;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "(" + this.price + ", " + this.weight + ")";
        }
    }
}
