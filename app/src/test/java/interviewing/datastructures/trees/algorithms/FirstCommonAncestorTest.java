package interviewing.datastructures.trees.algorithms;

import interviewing.datastructures.trees.structure.BinaryTree;
import interviewing.datastructures.trees.structure.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertSame;

class FirstCommonAncestorTest {
    @ParameterizedTest
    @MethodSource("firstCommonAncestorDataProvider")
    public void testFirstCommonAncestor(BinaryTree root, BinaryTree n1, BinaryTree n2, BinaryTree fca) {
        BinaryTree result = FirstCommonAncestor.getFirstCommonAncestor(root, n1, n2);
        assertSame(fca, result);
    }

    @ParameterizedTest
    @MethodSource("firstCommonAncestorDataProvider")
    public void testFirstCommonAncestorWithPaths(BinaryTree root, BinaryTree n1, BinaryTree n2, BinaryTree fca) {
        BinaryTree result = FirstCommonAncestor.getFirstCommonAncestorWithPaths(root, n1, n2);
        assertSame(fca, result);
    }

    @ParameterizedTest
    @MethodSource("firstCommonAncestorDataProvider")
    public void testFirstCommonAncestorRec2(BinaryTree root, BinaryTree n1, BinaryTree n2, BinaryTree fca) {
        BinaryTree result = LowestCommonAncestor.getLowestCommonAncestor(root, n1, n2);
        assertSame(fca, result);
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