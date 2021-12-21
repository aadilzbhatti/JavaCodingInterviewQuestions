package interviewing.datastructures.trees.algorithms;

import interviewing.datastructures.trees.structure.BinaryTree;

public class LowestCommonAncestor {

    public static BinaryTree getLowestCommonAncestor(BinaryTree root, BinaryTree n1, BinaryTree n2) {
        if (root == null) return null;
        boolean n1UnderLeft = findNodeUnderRoot(n1, root.getLeftChild());
        boolean n2UnderRight = findNodeUnderRoot(n2, root.getRightChild());
        if (n1UnderLeft && n2UnderRight) {
            return root;
        }
        boolean n1UnderRight = findNodeUnderRoot(n1, root.getRightChild());
        boolean n2UnderLeft = findNodeUnderRoot(n2, root.getLeftChild());
        if (n1UnderRight && n2UnderLeft) {
            return root;
        }
        if (n1UnderLeft && n2UnderLeft) {
            return getLowestCommonAncestor(root.getLeftChild(), n1, n2);
        } else if (n1UnderRight && n2UnderRight) {
            return getLowestCommonAncestor(root.getRightChild(), n1, n2);
        }
        return null;
    }

    private static boolean findNodeUnderRoot(BinaryTree node, BinaryTree root) {
        if (root == null) return false;
        if (root == node) return true;
        return findNodeUnderRoot(node, root.getLeftChild()) || findNodeUnderRoot(node, root.getRightChild());
    }
}
