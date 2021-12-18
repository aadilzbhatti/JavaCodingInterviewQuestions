package interviewing.datastructures.trees.algorithms;

import interviewing.datastructures.trees.structure.BinaryTree;

public class SymmetricBinaryTree {

    public static boolean isSymmetric(BinaryTree tree) {
        return isSymmetricHelper(tree.getLeftChild(), tree.getRightChild());
    }

    private static boolean isSymmetricHelper(BinaryTree left, BinaryTree right) {
        if ((left == null && right != null) ||  (left != null && right == null)) {
            return false;
        }
        if (left == null && right == null) {
            return true;
        }
        if (left.getData() != right.getData()) {
            return false;
        }
        return isSymmetricHelper(left.getLeftChild(), right.getRightChild()) &&
                isSymmetricHelper(left.getRightChild(), right.getLeftChild());
    }
}
