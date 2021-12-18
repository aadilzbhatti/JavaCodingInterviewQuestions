package interviewing.datastructures.trees.algorithms;

import interviewing.datastructures.trees.structure.BinaryTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class ListOfDepths {
    public static List<List<BinaryTree>> getListOfDepths(BinaryTree root) {
        List<List<BinaryTree>> output = new ArrayList<>();
        getListOfDepthsHelper(root, output, 0);
        return output;
    }

    private static void getListOfDepthsHelper(BinaryTree root, List<List<BinaryTree>> output, int currDepth) {
        if (root != null) {
            if (output.size() <= currDepth) {
                output.add(new ArrayList<>());
            }
            output.get(currDepth).add(root);
            getListOfDepthsHelper(root.getLeftChild(), output, currDepth + 1);
            getListOfDepthsHelper(root.getRightChild(), output, currDepth + 1);
        }
    }

    public static List<List<BinaryTree>> getListOfDepthsBFS(BinaryTree root) {
        List<List<BinaryTree>> output = new ArrayList<>();
        Deque<BinaryTree> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<BinaryTree> level = new ArrayList<>();
            while (!queue.isEmpty()) {
                level.add(queue.remove());
            }
            for (BinaryTree node : level) {
                if (node.getRightChild() != null) {
                    queue.add(node.getRightChild());
                }
                if (node.getLeftChild() != null) {
                    queue.add(node.getLeftChild());
                }
            }
            output.add(level);
        }
        return output;
    }
}
