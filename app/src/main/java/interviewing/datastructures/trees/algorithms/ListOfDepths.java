package interviewing.datastructures.trees.algorithms;

import interviewing.datastructures.trees.structure.BinaryTree;

import java.util.ArrayList;
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
}
