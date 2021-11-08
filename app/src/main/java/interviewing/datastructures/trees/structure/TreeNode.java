package interviewing.datastructures.trees.structure;

import java.util.function.Consumer;

public class TreeNode implements BinaryTree {

    private int data;
    private BinaryTree leftChild;
    private BinaryTree rightChild;

    public TreeNode() { }

    public TreeNode(int data) {
        this.data = data;
    }

    public TreeNode(int data, BinaryTree leftChild, BinaryTree rightChild) {
        this(data);
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public void preOrderTraversal(Consumer<BinaryTree> consumer) {
        consumer.accept(this);
        if (this.getLeftChild() != null) this.getLeftChild().preOrderTraversal(consumer);
        if (this.getRightChild() != null) this.getRightChild().preOrderTraversal(consumer);
    }

    public void inOrderTraversal(Consumer<BinaryTree> consumer) {
        if (this.getLeftChild() != null) this.getLeftChild().inOrderTraversal(consumer);
        consumer.accept(this);
        if (this.getRightChild() != null) this.getRightChild().inOrderTraversal(consumer);
    }

    public void postOrderTraversal(Consumer<BinaryTree> consumer) {
        if (this.getLeftChild() != null) this.getLeftChild().postOrderTraversal(consumer);
        if (this.getRightChild() != null) this.getRightChild().postOrderTraversal(consumer);
        consumer.accept(this);
    }

    @Override
    public int getData() {
        return this.data;
    }

    @Override
    public BinaryTree getLeftChild() {
        return this.leftChild;
    }

    @Override
    public BinaryTree getRightChild() {
        return this.rightChild;
    }

    @Override
    public void setLeftChild(BinaryTree leftChild) {
        this.leftChild = leftChild;
    }

    @Override
    public void setRightChild(BinaryTree rightChild) {
        this.rightChild = rightChild;
    }

    @Override
    public void printTree() {
        printTreeWithDepth(0);
    }

    private void printTreeWithDepth(int depth) {
        if (this.rightChild != null) {
            ((TreeNode) this.rightChild).printTreeWithDepth(depth + 1);
        }
        System.out.println("\t".repeat(Math.max(0, depth)) + data);
        if (this.leftChild != null) {
            ((TreeNode) this.leftChild).printTreeWithDepth(depth + 1);
        }
    }

    @Override
    public String toString() {
        return "" + this.getData();
    }

    public static TreeNode.Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private int data;
        private BinaryTree left;
        private BinaryTree right;

        public Builder() { }

        public Builder withRoot(int data) {
            this.data = data;
            return this;
        }

        public Builder withLeftChild(BinaryTree left) {
            this.left = left;
            return this;
        }

        public Builder withRightChild(BinaryTree right) {
            this.right = right;
            return this;
        }

        public BinaryTree build() {
            return new TreeNode(data, left, right);
        }
    }
}
