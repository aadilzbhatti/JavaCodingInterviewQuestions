package interviewing.datastructures.trees.algorithms;

import interviewing.datastructures.trees.structure.BinaryTree;
import interviewing.datastructures.trees.structure.TreeNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ListOfDepthsTest {

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
        List<List<BinaryTree>> listOfDepths = ListOfDepths.getListOfDepths(root);
        assertEquals(4, listOfDepths.size());
        assertEquals(1, listOfDepths.get(0).size());
        assertEquals(8, listOfDepths.get(0).get(0).getData());
        assertEquals(2, listOfDepths.get(1).size());
        assertEquals(4, listOfDepths.get(1).get(0).getData());
        assertEquals(12, listOfDepths.get(1).get(1).getData());
        assertEquals(4, listOfDepths.get(2).size());
        assertEquals(8, listOfDepths.get(3).size());
    }
}