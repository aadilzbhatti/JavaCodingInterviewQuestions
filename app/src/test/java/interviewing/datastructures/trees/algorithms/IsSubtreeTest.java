package interviewing.datastructures.trees.algorithms;

import interviewing.datastructures.trees.algorithms.IsSubtree;
import interviewing.datastructures.trees.structure.BinaryTree;
import interviewing.datastructures.trees.structure.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IsSubtreeTest {
    @Test
    public void testIsSubtree() {
        BinaryTree subtree = new TreeNode(12,
                new TreeNode(10,
                        new TreeNode(9, null, null),
                        new TreeNode(11, null, null)
                ),
                new TreeNode(14,
                        new TreeNode(13, null, null),
                        new TreeNode(15, null, null)
                )
        );
        BinaryTree root = new TreeNode(8,
                new TreeNode(4,
                        new TreeNode(2,
                                new TreeNode(1, null, null),
                                new TreeNode(3, null, null)
                        ),
                        new TreeNode(6,
                                new TreeNode(5, null, null),
                                new TreeNode(7, null, null)
                        )
                ),
                subtree
        );

        assertTrue(IsSubtree.isSubtreeOf(root, subtree));
        assertFalse(IsSubtree.isSubtreeOf(subtree, root));
    }

}