package interviewing.datastructures.trees.algorithms;

import interviewing.datastructures.trees.structure.BinarySearchTree;
import interviewing.datastructures.trees.structure.BinaryTreeWithParent;
import interviewing.datastructures.trees.structure.TreeNodeWithParent;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

class InOrderSuccessorTest {
    @ParameterizedTest
    @MethodSource("inOrderSuccessorDataProvider")
    public void testInOrderSuccessor(TreeNodeWithParent root, TreeNodeWithParent successor) {
        BinaryTreeWithParent result = InOrderSuccessor.getInOrderSuccessor(root);
        assertSame(successor, result);
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

    @Test
    public void testInOrderSuccessorForBST() {
        BinarySearchTree tree = new BinarySearchTree() {{
            insert(19);
            insert(7);
            insert(43);
            insert(3);
            insert(11);
            insert(23);
            insert(47);
            insert(2);
            insert(5);
            insert(17);
            insert(13);
            insert(53);
            insert(37);
            insert(29);
            insert(41);
            insert(31);
        }};

        int res = tree.getInOrderSuccessor(23);
        assertEquals(29, res);
    }
}