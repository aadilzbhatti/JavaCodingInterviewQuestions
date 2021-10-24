package interviewing.datastructures.trees;

import java.util.function.Consumer;

public interface BinaryTree {
    int getData();
    BinaryTree getLeftChild();
    BinaryTree getRightChild();
    void setLeftChild(BinaryTree leftChild);
    void setRightChild(BinaryTree rightChild);
    void preOrderTraversal(Consumer<BinaryTree> consumer);
    void inOrderTraversal(Consumer<BinaryTree> consumer);
    void postOrderTraversal(Consumer<BinaryTree> consumer);
    void printTree();
}
