package interviewing.datastructures.trees.algorithms;

import interviewing.datastructures.trees.structure.BinaryTree;
import interviewing.datastructures.trees.structure.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NodesByColumnOrderTest {

    @Test
    public void test() {
        BinaryTree root = TreeNode.builder()
                .withRoot(1)
                .withLeftChild(TreeNode.builder()
                        .withRoot(2)
                        .withLeftChild(TreeNode.builder()
                                .withRoot(4)
                                .withLeftChild(new TreeNode(8))
                                .withRightChild(TreeNode.builder()
                                        .withRoot(5)
                                        .withLeftChild(new TreeNode(7))
                                        .withRightChild(new TreeNode(6))
                                        .build())
                                .build())
                        .build())
                .withRightChild(TreeNode.builder()
                        .withRoot(3)
                        .withRightChild(TreeNode.builder()
                                .withRoot(9)
                                .withLeftChild(TreeNode.builder()
                                        .withRoot(10)
                                        .withLeftChild(new TreeNode(14))
                                        .build())
                                .withRightChild(TreeNode.builder()
                                        .withRoot(11)
                                        .withLeftChild(new TreeNode(12))
                                        .withRightChild(new TreeNode(13))
                                        .build())
                                .build())
                        .build())
                .build();

        List<Integer> expectedOutput = Arrays.asList(8, 4, 7, 2, 5, 1, 6, 14, 3, 10, 9, 12, 11, 13);
        List<Integer> output = NodesByColumnOrder.getNodesByColumnOrder(root).stream()
                .map(BinaryTree::getData)
                .collect(Collectors.toList());

        assertEquals(expectedOutput, output);
    }
}