package interviewing.datastructures.trees.algorithms;

import interviewing.datastructures.trees.structure.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class IsTreeBalancedTest {
    @ParameterizedTest
    @MethodSource("isBalancedDataProvider")
    public void testTreeIsBalanced(TreeNode root, boolean isBalanced) {
        boolean result = IsTreeBalanced.isBalanced(root);
        assertEquals(isBalanced, result);
    }

    public static Stream<Arguments> isBalancedDataProvider() {
        return Stream.of(
                Arguments.of(
                        new TreeNode(1,
                                new TreeNode(2,
                                        new TreeNode(4),
                                        new TreeNode(5)),
                                new TreeNode(3,
                                        new TreeNode(6),
                                        new TreeNode(7))),
                        true
                ),
                Arguments.of(
                        new TreeNode(1,
                                new TreeNode(2,
                                        TreeNode.builder()
                                                .withRoot(3)
                                                .withLeftChild(new TreeNode(4))
                                                .build(),
                                        new TreeNode(5)),
                                new TreeNode(6)),
                        false
                ),
                Arguments.of(
                        new TreeNode(),
                        true
                ),
                Arguments.of(
                        TreeNode.builder()
                                .withRoot(1)
                                .withLeftChild(TreeNode.builder()
                                        .withRoot(2)
                                        .withLeftChild(TreeNode.builder()
                                                .withRoot(3)
                                                .build())
                                        .build())
                                .build(),
                        false
                )
        );
    }
}