package interviewing.datastructures.trees.algorithms;

import interviewing.datastructures.trees.structure.BinaryTreeWithParent;
import interviewing.datastructures.trees.structure.TreeNodeWithParent;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

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
}