package interviewing.datastructures.trees.algorithms;

import interviewing.datastructures.trees.structure.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SymmetricBinaryTreeTest {

    @ParameterizedTest
    @MethodSource("symmetricBinaryTreeDataProvider")
    public void test(TreeNode root, boolean isSymmetric) {
        boolean out = SymmetricBinaryTree.isSymmetric(root);
        assertEquals(isSymmetric, out);
    }

    private static Stream<Arguments> symmetricBinaryTreeDataProvider() {
        return Stream.of(
                Arguments.of(
                        TreeNode.builder()
                                .withRoot(314)
                                .withLeftChild(TreeNode.builder()
                                        .withRoot(6)
                                        .withLeftChild(new TreeNode(3))
                                        .withRightChild(TreeNode.builder()
                                                .withRoot(2)
                                                .withRightChild(new TreeNode(3))
                                                .build())
                                        .build())
                                .withRightChild(TreeNode.builder()
                                        .withRoot(6)
                                        .withLeftChild(TreeNode.builder()
                                                .withRoot(2)
                                                .withLeftChild(new TreeNode(3))
                                                .build())
                                        .withRightChild(new TreeNode(3))
                                        .build())
                                .build(),
                        true
                ),
                Arguments.of(
                        TreeNode.builder()
                                .withRoot(314)
                                .withLeftChild(TreeNode.builder()
                                        .withRoot(6)
                                        .withLeftChild(new TreeNode(3))
                                        .withRightChild(TreeNode.builder()
                                                .withRoot(2)
                                                .withRightChild(new TreeNode(3))
                                                .build())
                                        .build())
                                .withRightChild(TreeNode.builder()
                                        .withRoot(6)
                                        .withLeftChild(TreeNode.builder()
                                                .withRoot(2)
                                                .build())
                                        .withRightChild(new TreeNode(3))
                                        .build())
                                .build(),
                        false
                )
        );
    }
}