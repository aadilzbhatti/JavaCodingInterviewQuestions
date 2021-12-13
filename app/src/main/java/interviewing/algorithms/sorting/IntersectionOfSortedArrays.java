package interviewing.algorithms.sorting;

import java.util.ArrayList;
import java.util.List;

public class IntersectionOfSortedArrays {

    public static int[] getIntersectionOfSortedArrays(int[] a, int[] b) {
        int i1 = 0;
        int i2 = 0;
        List<Integer> out = new ArrayList<>();
        while (i1 < a.length && i2 < b.length) {
            if (a[i1] < b[i2]) {
                while (i1 < a.length && a[i1] < b[i2]) {
                    i1++;
                }
                if (i1 == a.length) {
                    return fromList(out);
                }
                if (a[i1] == b[i2]) {
                    int val = a[i1];
                    out.add(a[i1]);
                    while (i1 < a.length && a[i1] == val) {
                        i1++;
                    }
                    while (i2 < b.length && b[i2] == val) {
                        i2++;
                    }
                    if (i1 == a.length || i2 == b.length) {
                        return fromList(out);
                    }
                }
            } else if (a[i1] > b[i2]) {
                while (i2 < b.length && a[i1] > b[i2]) {
                    i2++;
                }
                if (i2 == b.length) {
                    return fromList(out);
                }
                if (a[i1] == b[i2]) {
                    int val = a[i1];
                    out.add(a[i1]);
                    while (i1 < a.length && a[i1] == val) {
                        i1++;
                    }
                    while (i2 < b.length && b[i2] == val) {
                        i2++;
                    }
                    if (i1 == a.length || i2 == b.length) {
                        return fromList(out);
                    }
                }
            } else {
                int val = a[i1];
                out.add(a[i1]);
                while (i1 < a.length && a[i1] == val) {
                    i1++;
                }
                while (i2 < b.length && b[i2] == val) {
                    i2++;
                }
                if (i1 == a.length || i2 == b.length) {
                    return fromList(out);
                }
            }
        }

        return fromList(out);
    }

    private static int[] fromList(List<Integer> input) {
        return input.stream().mapToInt(i -> i).toArray();
    }
}
