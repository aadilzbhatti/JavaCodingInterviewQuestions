package interviewing.datastructures.trees.algorithms;

import interviewing.datastructures.trees.structure.BinaryTree;

public class IsTreeBalanced {
    public static boolean isBalanced(BinaryTree root) {
        return Math.abs(height(root.getLeftChild()) - height(root.getRightChild())) <= 1;
    }

    private static int height(BinaryTree root) {
        if (root == null) return 0;
        return 1 + Math.max(height(root.getLeftChild()), height(root.getRightChild()));
    }
}
