package interviewing.algorithms.searching;

import java.util.HashSet;
import java.util.Set;

public class MissingAndDuplicate {
    int missingElement;
    int duplicateElement;

    public MissingAndDuplicate(int missingElement, int duplicateElement) {
        this.missingElement = missingElement;
        this.duplicateElement = duplicateElement;
    }

    public static MissingAndDuplicate findMissingAndDuplicateElements(int[] arr) {
        Set<Integer> set = new HashSet<>();
        int res = 0;
        int duplicateElement = -1;
        for (int i = 0; i < arr.length; i++) {
            if (set.contains(arr[i])) {
                duplicateElement = arr[i];
            } else {
                set.add(arr[i]);
            }
            res ^= i;
        }
        for (int element : set) {
            res ^= element;
        }
        int missingElement = res;
        return new MissingAndDuplicate(missingElement, duplicateElement);
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof MissingAndDuplicate)) {
            return false;
        }
        MissingAndDuplicate otherObj = (MissingAndDuplicate) other;
        return (otherObj.missingElement == this.missingElement) &&
                (otherObj.duplicateElement == this.duplicateElement);
    }
}
