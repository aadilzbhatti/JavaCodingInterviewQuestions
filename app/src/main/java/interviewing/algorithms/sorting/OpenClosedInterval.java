package interviewing.algorithms.sorting;

import java.util.ArrayList;
import java.util.List;

public class OpenClosedInterval {
    Endpoint start;
    Endpoint finish;

    public static List<OpenClosedInterval> unionOfIntervals(List<OpenClosedInterval> intervals) {
        if (intervals.size() <= 1) return intervals;
        int med = intervals.size() / 2;
        List<OpenClosedInterval> left = intervals.subList(0, med);
        List<OpenClosedInterval> right = intervals.subList(med, intervals.size());
        left = unionOfIntervals(left);
        right = unionOfIntervals(right);
        return merge(left, right);
    }

    private static List<OpenClosedInterval> merge(List<OpenClosedInterval> left, List<OpenClosedInterval> right) {
        List<OpenClosedInterval> res = new ArrayList<>();
        int i1 = 0;
        int i2 = 0;
        while (i1 < left.size() && i2 < right.size()) {
            ifMergeableThenMerge(left, right, res, i1, i2);
            i1++;
            i2++;
        }
        List<OpenClosedInterval> res2 = new ArrayList<>();
        int i3 = 0;
        while (i1 < left.size() && i3 < res.size()) {
            ifMergeableThenMerge(left, res, res2, i1, i3);
            i1++;
            i3++;
        }
        List<OpenClosedInterval> res3 = new ArrayList<>();
        int i4 = 0;
        int size = res2.size() == 0 ? res.size() : res2.size();
        List<OpenClosedInterval> resToUse = res2.isEmpty() ? res : res2;
        while (i2 < right.size() && i4 < size) {
            ifMergeableThenMerge(right, resToUse, res3, i2, i4);
            i2++;
            i4++;
        }

        return res3.isEmpty() ? (res2.isEmpty() ? res : res2) : res3;
    }

    private static void ifMergeableThenMerge(List<OpenClosedInterval> left, List<OpenClosedInterval> right, List<OpenClosedInterval> res, int i1, int i2) {
        OpenClosedInterval int1 = left.get(i1);
        OpenClosedInterval int2 = right.get(i2);
        if (int1.finish.time < int2.start.time) {
            res.add(int1);
            res.add(int2);
        } else if (int1.start.time > int2.finish.time) {
            res.add(int2);
            res.add(int1);
        } else {
            OpenClosedInterval merged = mergeIntervals(int1, int2);
            res.add(merged);
        }
    }

    private static OpenClosedInterval mergeIntervals(OpenClosedInterval int1, OpenClosedInterval int2) {
        int newStart = -1;
        int newEnd = -1;
        boolean startOpen = false;
        boolean endOpen = false;
        if (int1.start.time < int2.start.time) {
             newStart = int1.start.time;
             if (int1.start.isOpen) {
                 startOpen = true;
             }
        } else {
            if (int1.start.time == int2.start.time) {
                newStart = int1.start.time;
                startOpen = int1.start.isOpen && int2.start.isOpen;
            } else {
                newStart = int2.start.time;
                if (int2.start.isOpen) {
                    startOpen = true;
                }
            }
        }
        if (int1.finish.time > int2.finish.time) {
            newEnd = int1.finish.time;
            if (int1.finish.isOpen) {
                endOpen = true;
            }
        } else {
            if (int1.finish.time == int2.finish.time) {
                newEnd = int1.finish.time;
                endOpen = int1.finish.isOpen && int2.finish.isOpen;
            } else {
                newEnd = int2.finish.time;
                if (int2.finish.isOpen) {
                    endOpen = true;
                }
            }
        }

        return new OpenClosedInterval(
                new Endpoint(newStart, startOpen),
                new Endpoint(newEnd, endOpen)
        );
    }

    public OpenClosedInterval(Endpoint start, Endpoint finish) {
        this.start = start;
        this.finish = finish;
    }


    @Override
    public String toString() {
        String startChar, endChar;
        if (this.start.isOpen) {
            startChar = "(";
        } else {
            startChar = "[";
        }
        if (this.finish.isOpen) {
            endChar = ")";
        } else {
            endChar = "]";
        }
        return startChar + this.start.time + ", " + this.finish.time + endChar;
    }

    public static class Endpoint {
        int time;
        boolean isOpen;

        public Endpoint(int time, boolean isOpen) {
            this.time = time;
            this.isOpen = isOpen;
        }
    }
}
