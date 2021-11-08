package interviewing.datastructures.trees.algorithms;

import interviewing.datastructures.trees.structure.BinaryTree;
import interviewing.datastructures.trees.structure.BinaryTreeWithParent;

public class InOrderSuccessor {
    public static BinaryTreeWithParent getInOrderSuccessor(BinaryTreeWithParent root) {
        if (root.getLeftChild() == null && root.getRightChild() == null) {
            if (root.getParent() != null) {
                if (root.getParent().getData() < root.getData()) {
                    BinaryTreeWithParent curr = root.getParent();
                    while (curr != null && curr.getData() < root.getData()) {
                        curr = curr.getParent();
                    }
                    return curr;
                } else {
                    return root.getParent();
                }
            }
            return null;
        } else {
            BinaryTree curr = root.getRightChild();
            while (curr.getLeftChild() != null) {
                curr = curr.getLeftChild();
            }
            return (BinaryTreeWithParent) curr;
        }
    }
}
