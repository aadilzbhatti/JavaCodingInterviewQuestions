package interviewing.datastructures.trees;

public interface BinaryTreeWithParent extends BinaryTree {
    BinaryTreeWithParent getParent();
    void setParent(BinaryTreeWithParent parent);
}
