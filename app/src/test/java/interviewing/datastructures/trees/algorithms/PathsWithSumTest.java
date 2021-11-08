package interviewing.datastructures.trees.algorithms;

import interviewing.datastructures.trees.algorithms.PathsWithSum;
import interviewing.datastructures.trees.structure.BinaryTree;
import interviewing.datastructures.trees.structure.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PathsWithSumTest {
    @Test
    public void testPathsWithSum() {
        BinaryTree root = TreeNode.builder()
                .withRoot(1)
                .withLeftChild(TreeNode.builder()
                        .withRoot(3)
                        .withLeftChild(TreeNode.builder()
                                .withRoot(4)
                                .withLeftChild(new TreeNode(1))
                                .build())
                        .withRightChild(TreeNode.builder()
                                .withRoot(-2)
                                .withRightChild(new TreeNode(1))
                                .build())
                        .build())
                .withRightChild(TreeNode.builder()
                        .withRoot(-5)
                        .withLeftChild(new TreeNode(7))
                        .withRightChild(TreeNode.builder()
                                .withRoot(6)
                                .withRightChild(new TreeNode(2))
                                .build())
                        .build())
                .build();

        int pathsWithSum = PathsWithSum.pathsWithSum(root, 3);
        assertEquals(4, pathsWithSum);
    }
}