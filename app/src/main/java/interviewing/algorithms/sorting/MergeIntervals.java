package interviewing.algorithms.sorting;

import java.util.ArrayList;
import java.util.List;

public class MergeIntervals {

    public static Interval[] mergeIntervals(Interval[] intervals, Interval newInterval) {
        List<Interval> intervalsToMerge = new ArrayList<>();
        for (Interval interval : intervals) {
            boolean b1 = interval.start < newInterval.start && interval.end > newInterval.start; // starts before newInterval has started, ends while newInterval in progress
            boolean b2 = interval.start < newInterval.end && interval.end > newInterval.end; // starts before newInterval starts, ends after newInterval ends
            boolean b3 = interval.start > newInterval.start && interval.end < newInterval.end; // starts after newInterval starts, ends before newInterval ends
            boolean b4 = interval.start < newInterval.start && interval.end > newInterval.end; // starts before newInterval starts, ends after after newInterval endsw
            if (b1 || b2 || b3 || b4) {
                intervalsToMerge.add(interval);
            }
        }
        intervalsToMerge.add(newInterval);
        int minStart = intervals.length;
        int maxEnd = 0;
        for (Interval interval : intervalsToMerge) {
            if (interval.start < minStart) {
                minStart = interval.start;
            }
            if (interval.end > maxEnd) {
                maxEnd = interval.end;
            }
        }
        intervalsToMerge.remove(newInterval);
        boolean added = false;
        Interval[] output = new Interval[intervals.length - intervalsToMerge.size() + 1];
        int i = 0;
        for (Interval interval : intervals) {
            if (intervalsToMerge.contains(interval)) {
                if (!added) {
                    if (minStart < interval.start) {
                        output[i++] = new Interval(minStart, maxEnd);
                        added = true;
                    }
                }
            } else {
                output[i++] = interval;
            }
        }
        return output;
    }

    static class Interval {
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "(" + start + ", " + end + ")";
        }
    }
}
