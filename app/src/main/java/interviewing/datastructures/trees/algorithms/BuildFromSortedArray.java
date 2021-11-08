package interviewing.datastructures.trees.algorithms;

import interviewing.datastructures.trees.structure.BinaryTree;
import interviewing.datastructures.trees.structure.TreeNode;

public class BuildFromSortedArray {
    public static BinaryTree buildFromSortedArray(int[] arr) {
        return buildFromSortedArrayHelper(arr, 0, arr.length - 1);
    }

    private static BinaryTree buildFromSortedArrayHelper(int[] arr, int start, int end) {
        if (start > end) {
            return null;
        }
        int medIndex = computeMedianIndex(start, end);
        return TreeNode.builder()
                .withRoot(arr[medIndex])
                .withLeftChild(buildFromSortedArrayHelper(arr, start, medIndex - 1))
                .withRightChild(buildFromSortedArrayHelper(arr, medIndex + 1, end))
                .build();
    }

    private static int computeMedianIndex(int start, int end) {
        while (true) {
            if (end == start + 1 || end == start) {
                return start;
            }
            end--;
            start++;
        }
    }
}
