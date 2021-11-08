package interviewing.datastructures.trees.algorithms;

import interviewing.datastructures.trees.structure.BinaryTree;

public class IsSubtree {
    /**
     * Determines if T2 is a subtree of T1
     *
     * @param t1 Parent tree
     * @param t2 Potential subtree
     * @return if T2 is a subtree of T1
     */
    public static boolean isSubtreeOf(BinaryTree t1, BinaryTree t2) {
        if (t1 == null && t2 == null) {
            return true;
        }
        if ((t1 == null && t2 != null) || (t1 != null && t2 == null)) {
            return false;
        }
        if (t1 != t2) {
            return isSubtreeOf(t1.getLeftChild(), t2) || isSubtreeOf(t1.getRightChild(), t2);
        } else {
            return isSubtreeOf(t1.getLeftChild(), t2.getLeftChild()) && isSubtreeOf(t1.getRightChild(), t2.getRightChild());
        }
    }
}
