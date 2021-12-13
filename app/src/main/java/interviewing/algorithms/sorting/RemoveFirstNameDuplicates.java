package interviewing.algorithms.sorting;

import java.util.ArrayList;
import java.util.List;

public class RemoveFirstNameDuplicates {

    public static Name[] removeFirstNameDuplicates(Name[] names) {
        if (names.length <= 1) {
            return names;
        }

        int med = names.length / 2;
        Name[] left = new Name[med];
        Name[] right = new Name[names.length - med];
        System.arraycopy(names, 0, left, 0, med);
        System.arraycopy(names, med, right, 0, names.length - med);
        left = removeFirstNameDuplicates(left);
        right = removeFirstNameDuplicates(right);
        return merge(left, right);
    }

    private static Name[] merge(Name[] left, Name[] right) {
        int i1 = 0;
        int i2 = 0;
        List<Name> out = new ArrayList<>();
        while (i1 < left.length && i2 < right.length) {
            if (left[i1].first.equals(right[i2].first)) {
                out.add(left[i1]);
                String first = left[i1].first;
                while (i1 < left.length && left[i1].first.equals(first)) {
                    i1++;
                }
                while (i2 < right.length && right[i2].first.equals(first)) {
                    i2++;
                }
            } else {
                if (left[i1].first.compareTo(right[i2].first) < 0) {
                    out.add(left[i1]);
                    i1++;
                } else {
                    out.add(right[i2]);
                    i2++;
                }
            }
        }
        while (i1 < left.length) {
            out.add(left[i1]);
            i1++;
        }
        while (i2 < right.length) {
            out.add(right[i2]);
            i2++;
        }
        Name[] output = new Name[out.size()];
        out.toArray(output);
        return output;
    }

    public static class Name {
        String first;
        String last;

        public Name(String first, String last) {
            this.first = first;
            this.last = last;
        }

        public String toString() {
            return "(" + first + ", " + last + ")";
        }
    }
}
