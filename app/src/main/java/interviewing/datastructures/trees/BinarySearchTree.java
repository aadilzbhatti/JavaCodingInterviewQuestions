package interviewing.datastructures.trees;

public class BinarySearchTree {
    private int height;
    private int numNodes;
    private BinarySearchTreeNode root;

    public BinarySearchTree() {
        numNodes = 0;
        height = 0;
    }

    public void insert(int data) {
        if (root == null) {
            root = new BinarySearchTreeNode(data);
        } else {
            root.insert(data);
        }
        numNodes++;
        recomputeHeight();
    }

    public boolean find(int data) {
        if (root == null) return false;
        return root.find(data);
    }

    public void delete(int data) {
        if (root == null) return;
        root.delete(data);
        numNodes--;
        recomputeHeight();
    }

    public int getRandomNode() {
        int steps = (int) (Math.random() * height);
        return getRandomNodeHelper(steps, root);
    }

    private int getRandomNodeHelper(int steps, BinarySearchTreeNode root) {
        if (steps == 0) {
            return root.getData();
        }
        double leftOrRight = Math.random();
        if (leftOrRight < 0.5) {
            return getRandomNodeHelper(steps - 1, (BinarySearchTreeNode) root.getLeftChild());
        } else {
            return getRandomNodeHelper(steps - 1, (BinarySearchTreeNode) root.getRightChild());
        }
    }

    public void printTree() {
        root.printTree();
    }

    private void recomputeHeight() {
        height = (int) Math.ceil(Math.log10(numNodes) / Math.log10(2));
    }

    private static class BinarySearchTreeNode extends TreeNode {

        public BinarySearchTreeNode(int data) {
            super(data);
        }

        public void insert(int data) {
            if (data < this.getData()) {
                if (this.getLeftChild() == null) {
                    this.setLeftChild(new BinarySearchTreeNode(data));
                } else {
                    ((BinarySearchTreeNode) this.getLeftChild()).insert(data);
                }
            } else {
                if (this.getRightChild() == null) {
                    this.setRightChild(new BinarySearchTreeNode(data));
                } else {
                    ((BinarySearchTreeNode) this.getRightChild()).insert(data);
                }
            }
        }

        public boolean find(int data) {
            if (this.getData() == data) {
                return true;
            } else {
                if (data < this.getData()) {
                    if (this.getLeftChild() != null) {
                        return ((BinarySearchTreeNode) this.getLeftChild()).find(data);
                    }
                } else {
                    if (this.getRightChild() != null) {
                        ((BinarySearchTreeNode) this.getRightChild()).find(data);
                    }
                }
            }
            return false;
        }

        public void delete(int data) {
            if (data < this.getData()) {
                if (this.getLeftChild() != null) {
                    if (this.getLeftChild().getData() == data) {
                        BinarySearchTreeNode leftChild = (BinarySearchTreeNode) this.getLeftChild().getLeftChild();
                        BinarySearchTreeNode rightChild = (BinarySearchTreeNode) this.getLeftChild().getRightChild();
                        rightChild.setLeftChild(leftChild);
                        this.setLeftChild(rightChild);
                    } else {
                        ((BinarySearchTreeNode) this.getLeftChild()).delete(data);
                    }
                }
            } else {
                if (this.getRightChild() != null) {
                    if (this.getRightChild().getData() == data) {
                        BinarySearchTreeNode leftChild = (BinarySearchTreeNode) this.getLeftChild().getLeftChild();
                        BinarySearchTreeNode rightChild = (BinarySearchTreeNode) this.getLeftChild().getRightChild();
                        leftChild.setRightChild(rightChild);
                        this.setRightChild(leftChild);
                    } else {
                        ((BinarySearchTreeNode) this.getRightChild()).delete(data);
                    }
                }
            }
        }
    }
}
