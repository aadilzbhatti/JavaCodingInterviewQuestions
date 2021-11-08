package interviewing.datastructures.trees.algorithms;

import interviewing.datastructures.trees.structure.BinaryTree;

public class PathsWithSum {

    public static int pathsWithSum(BinaryTree root, int sum) {
        return pathsWithSumHelper(root, sum, sum);
    }

    public static int pathsWithSumHelper(BinaryTree root, int sum, int origSum) {
        if (root != null) {
            if (sum - root.getData() == 0) {
                return 1;
            }
            return pathsWithSumHelper(root.getLeftChild(), sum - root.getData(), origSum) +
                    pathsWithSumHelper(root.getRightChild(), sum - root.getData(), origSum) +
                    pathsWithSumHelper(root.getLeftChild(), origSum, origSum) +
                    pathsWithSumHelper(root.getRightChild(), origSum, origSum);
        }
        return 0;
    }
}
