package interviewing.datastructures.trees.algorithms;

import interviewing.datastructures.trees.algorithms.AllPossibleBstSequences;
import interviewing.datastructures.trees.structure.BinaryTree;
import interviewing.datastructures.trees.structure.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AllPossibleBstSequencesTest {
    @Test
    public void testAllPossibleBstSequences() {
        BinaryTree root = new TreeNode(4,
                new TreeNode(2,
                        new TreeNode(1, null, null),
                        new TreeNode(3, null, null)
                ), new TreeNode(6,
                new TreeNode(5, null, null),
                new TreeNode(7, null, null)
        )
        );

        List<List<Integer>> allPossibleSequences = AllPossibleBstSequences.allPossibleBstSequences(root);
        int origSize = allPossibleSequences.size();
        assertEquals(allPossibleSequences.stream().distinct().count(), origSize);

        BinaryTree root2 = TreeNode.builder()
                .withRoot(2)
                .withRightChild(new TreeNode(3))
                .withLeftChild(new TreeNode(1))
                .build();

        List<List<Integer>> sequences = AllPossibleBstSequences.allPossibleBstSequences(root2);
        assertEquals(Arrays.asList(Arrays.asList(2, 1, 3), Arrays.asList(2, 3, 1)), sequences);
    }
}