package interviewing.datastructures.trees;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.fail;

class TreeQuestionsTest {

    private TreeNode root;

    @BeforeEach
    public void setup() {
        root = new TreeNode(8,
            new TreeNode(4,
                    new TreeNode(2,
                            new TreeNode(1, null, null),
                            new TreeNode(3, null, null)
                    ), new TreeNode(6,
                    new TreeNode(5, null, null),
                    new TreeNode(7, null, null)
            )
            ),
            new TreeNode(12,
                    new TreeNode(10,
                            new TreeNode(9, null, null),
                            new TreeNode(11, null, null)
                    ),
                    new TreeNode(14,
                            new TreeNode(13, null, null),
                            new TreeNode(15, null, null)
                    )
            )
        );
    }

    @Test
    public void testListOfDepths() {
        List<List<BinaryTree>> listOfDepths = TreeQuestions.getListOfDepths(root);
        assertEquals(4, listOfDepths.size());
        assertEquals(1, listOfDepths.get(0).size());
        assertEquals(8, listOfDepths.get(0).get(0).getData());
        assertEquals(2, listOfDepths.get(1).size());
        assertEquals(4, listOfDepths.get(1).get(0).getData());
        assertEquals(12, listOfDepths.get(1).get(1).getData());
        assertEquals(4, listOfDepths.get(2).size());
        assertEquals(8, listOfDepths.get(3).size());
    }

    @ParameterizedTest
    @MethodSource("isBalancedDataProvider")
    public void testTreeIsBalanced(TreeNode root, boolean isBalanced) {
        boolean result = TreeQuestions.isBalanced(root);
        assertEquals(isBalanced, result);
    }

    @ParameterizedTest
    @MethodSource("inOrderSuccessorDataProvider")
    public void testInOrderSuccessor(TreeNodeWithParent root, TreeNodeWithParent successor) {
        BinaryTreeWithParent result = TreeQuestions.getInOrderSuccessor(root);
        assertSame(successor, result);
    }

    @ParameterizedTest
    @MethodSource("firstCommonAncestorDataProvider")
    public void testFirstCommonAncestor(BinaryTree root, BinaryTree n1, BinaryTree n2, BinaryTree fca) {
        BinaryTree result = TreeQuestions.getFirstCommonAncestor(root, n1, n2);
        assertSame(fca, result);
    }

    @ParameterizedTest
    @MethodSource("firstCommonAncestorDataProvider")
    public void testFirstCommonAncestorWithPaths(BinaryTree root, BinaryTree n1, BinaryTree n2, BinaryTree fca) {
        BinaryTree result = TreeQuestions.getFirstCommonAncestorWithPaths(root, n1, n2);
        assertSame(fca, result);
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

    public static Stream<Arguments> inOrderSuccessorDataProvider() {
        TreeNodeWithParent middleNode = new TreeNodeWithParent(4);
        TreeNodeWithParent leafNode = new TreeNodeWithParent(1);
        TreeNodeWithParent leafNodeSuccessor = new TreeNodeWithParent(2,
                leafNode,
                new TreeNodeWithParent(3)
        );
        middleNode.setLeftChild(leafNodeSuccessor);
        TreeNodeWithParent middleNodeSuccessor = new TreeNodeWithParent(5);
        middleNode.setRightChild(new TreeNodeWithParent(6,
                middleNodeSuccessor,
                new TreeNodeWithParent(7)
        ));
        TreeNodeWithParent lastNode = new TreeNodeWithParent(15);
        TreeNodeWithParent rootSuccessor = new TreeNodeWithParent(9);

        BinaryTreeWithParent parentRoot = new TreeNodeWithParent(8,
                middleNode,
                new TreeNodeWithParent(12,
                        new TreeNodeWithParent(10,
                                rootSuccessor,
                                new TreeNodeWithParent(11)
                        ),
                        new TreeNodeWithParent(14,
                                new TreeNodeWithParent(13),
                                lastNode
                        )
                )
        );
        return Stream.of(
                Arguments.of(parentRoot, rootSuccessor),
                Arguments.of(middleNode, middleNodeSuccessor),
                Arguments.of(lastNode, null),
                Arguments.of(leafNode, leafNodeSuccessor)
        );
    }

    public static Stream<Arguments> firstCommonAncestorDataProvider() {
        BinaryTree n1 = new TreeNode(1);
        BinaryTree n2 = new TreeNode(2);
        BinaryTree n3 = new TreeNode(3);
        BinaryTree n4 = new TreeNode(4);
        BinaryTree n5 = new TreeNode(5);
        BinaryTree n6 = new TreeNode(6);
        BinaryTree n7 = new TreeNode(7);
        BinaryTree n8 = new TreeNode(8);
        BinaryTree n9 = new TreeNode(9);
        BinaryTree n10 = new TreeNode(10);
        BinaryTree n11 = new TreeNode(11);
        BinaryTree n12 = new TreeNode(12);
        BinaryTree n13 = new TreeNode(13);
        BinaryTree n14 = new TreeNode(14);
        BinaryTree n15 = new TreeNode(15);

        n8.setLeftChild(n4);
        n8.setRightChild(n12);
        n4.setLeftChild(n2);
        n4.setRightChild(n6);
        n2.setLeftChild(n1);
        n2.setRightChild(n3);
        n6.setLeftChild(n5);
        n6.setRightChild(n7);
        n12.setLeftChild(n10);
        n12.setRightChild(n14);
        n10.setLeftChild(n9);
        n10.setRightChild(n11);
        n14.setLeftChild(n13);
        n14.setRightChild(n15);

        return Stream.of(
                Arguments.of(n8, n1, n6, n4),
                Arguments.of(n8, n1, n15, n8),
                Arguments.of(n8, n15, n10, n12),
                Arguments.of(n8, n1, n9, n8)
        );
    }
}