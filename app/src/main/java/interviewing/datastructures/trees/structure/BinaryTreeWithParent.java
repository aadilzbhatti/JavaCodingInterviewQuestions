package interviewing.datastructures.trees.structure;

public interface BinaryTreeWithParent extends BinaryTree {
    BinaryTreeWithParent getParent();
    void setParent(BinaryTreeWithParent parent);
}
