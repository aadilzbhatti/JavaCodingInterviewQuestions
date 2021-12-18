package interviewing.datastructures.trees.algorithms;

import interviewing.datastructures.trees.structure.BinaryTree;
import interviewing.datastructures.trees.structure.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GenerateBinaryTrees {

    public static List<BinaryTree> allBinaryTreesOnNNodes(int n) {
        if (n == 0) {
            return Collections.singletonList(null);
        }
        List<BinaryTree> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<BinaryTree> l1 = allBinaryTreesOnNNodes(i);
            List<BinaryTree> l2 = allBinaryTreesOnNNodes(n - i - 1);
            for (BinaryTree left : l1) {
                for (BinaryTree right : l2) {
                    res.add(TreeNode.builder().withRoot(n).withLeftChild(left).withRightChild(right).build());
                }
            }
        }

        return res;
    }
}
