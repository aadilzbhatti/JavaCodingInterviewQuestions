package interviewing.datastructures.trees.structure;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TreeNodeTest {

    private TreeNode root = new TreeNode(8,
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

    @Test
    public void testPreOrderTraversal() {
        List<BinaryTree> list = new ArrayList<>();
        root.preOrderTraversal(list::add);
        assertEquals(
                Arrays.asList(8, 4, 2, 1, 3, 6, 5, 7, 12, 10, 9, 11, 14, 13, 15),
                list.stream().map(BinaryTree::getData).collect(Collectors.toList())
        );
    }

    @Test
    public void testInOrderTraversal() {
        List<BinaryTree> list = new ArrayList<>();
        root.inOrderTraversal(list::add);
        assertEquals(
                Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15),
                list.stream().map(BinaryTree::getData).collect(Collectors.toList())
        );
    }

    @Test
    public void testPostOrderTraversal() {
        List<BinaryTree> list = new ArrayList<>();
        root.postOrderTraversal(list::add);
        assertEquals(
                Arrays.asList(1, 3, 2, 5, 7, 6, 4, 9, 11, 10, 13, 15, 14, 12, 8),
                list.stream().map(BinaryTree::getData).collect(Collectors.toList())
        );
    }
}