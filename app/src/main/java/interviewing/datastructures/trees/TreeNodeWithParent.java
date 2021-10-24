package interviewing.datastructures.trees;

public class TreeNodeWithParent extends TreeNode implements BinaryTreeWithParent {

    private BinaryTreeWithParent parent;

    public TreeNodeWithParent(int data) {
        super(data);
    }

    public TreeNodeWithParent(int data, TreeNodeWithParent left, TreeNodeWithParent right) {
        super(data, left, right);
        left.parent = this;
        right.parent = this;
    }

    @Override
    public void setParent(BinaryTreeWithParent parent) {
        this.parent = parent;
    }

    @Override
    public BinaryTreeWithParent getParent() {
        return parent;
    }

    public static TreeNodeWithParent.Builder builder() {
        return new Builder();
    }

    static class Builder extends TreeNode.Builder {
        private TreeNodeWithParent parent;

        public void withParent(TreeNodeWithParent parent) {
            this.parent = parent;
        }

        @Override
        public TreeNodeWithParent build() {
            BinaryTree res = super.build();
            TreeNodeWithParent output = new TreeNodeWithParent(
                    res.getData(),
                    (TreeNodeWithParent) res.getLeftChild(),
                    (TreeNodeWithParent) res.getRightChild()
            );
            ((TreeNodeWithParent) output.getLeftChild()).setParent(output);
            ((TreeNodeWithParent) output.getRightChild()).setParent(output);
            output.setParent(parent);
            return output;
        }
    }
}
