package interviewing.datastructures.trees.algorithms;

import interviewing.datastructures.trees.structure.BinaryTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FirstCommonAncestor {
    public static BinaryTree getFirstCommonAncestor(BinaryTree root, BinaryTree n1, BinaryTree n2) {
        Map<BinaryTree, Map<BinaryTree, Boolean>> subtreeContainsNode = buildSubtreeContainsNodeMap(root, n1, n2);
        return firstCommonAncestorHelper(root, n1, n2, subtreeContainsNode);
    }

    private static BinaryTree firstCommonAncestorHelper(BinaryTree root, BinaryTree n1, BinaryTree n2,
                                                        Map<BinaryTree, Map<BinaryTree, Boolean>> subtreeContainsNode) {
        if (subtreeContainsNode.get(root.getLeftChild()).get(n1) && subtreeContainsNode.get(root.getLeftChild()).get(n2)) {
            BinaryTree fcaLeft = firstCommonAncestorHelper(root.getLeftChild(), n1, n2, subtreeContainsNode);
            if (fcaLeft != null) {
                return fcaLeft;
            }
        }
        if (subtreeContainsNode.get(root.getRightChild()).get(n1) && subtreeContainsNode.get(root.getRightChild()).get(n2)) {
            BinaryTree fcaRight = firstCommonAncestorHelper(root.getRightChild(), n1, n2, subtreeContainsNode);
            if (fcaRight != null) {
                return fcaRight;
            }
        }
        if (subtreeContainsNode.get(root).get(n1) && subtreeContainsNode.get(root).get(n2)) {
            return root;
        }
        return null;
    }

    private static Map<BinaryTree, Map<BinaryTree, Boolean>> buildSubtreeContainsNodeMap(BinaryTree root, BinaryTree n1, BinaryTree n2) {
        Map<BinaryTree, Map<BinaryTree, Boolean>> subtreeContainsNode = new HashMap<>();
        root.postOrderTraversal(binaryTree -> {
            Map<BinaryTree, Boolean> containsNode = subtreeContainsNode.getOrDefault(binaryTree, new HashMap<>());
            if (binaryTree == n1) {
                containsNode.put(n1, true);
                containsNode.put(n2, false);

            } else if (binaryTree == n2) {
                containsNode.put(n2, true);
                containsNode.put(n1, false);

            } else {
                if (binaryTree.getLeftChild() != null && binaryTree.getRightChild() != null) {
                    containsNode.put(n1, subtreeContainsNode.get(binaryTree.getRightChild()).get(n1) || subtreeContainsNode.get(binaryTree.getLeftChild()).get(n1));
                    containsNode.put(n2, subtreeContainsNode.get(binaryTree.getRightChild()).get(n2) || subtreeContainsNode.get(binaryTree.getLeftChild()).get(n2));

                } else if (binaryTree.getRightChild() == null && binaryTree.getLeftChild() != null) {
                    containsNode.put(n1, subtreeContainsNode.get(binaryTree.getLeftChild()).get(n1));
                    containsNode.put(n2, subtreeContainsNode.get(binaryTree.getLeftChild()).get(n2));

                } else if (binaryTree.getRightChild() != null && binaryTree.getLeftChild() == null){
                    containsNode.put(n1, subtreeContainsNode.get(binaryTree.getRightChild()).get(n1));
                    containsNode.put(n2, subtreeContainsNode.get(binaryTree.getRightChild()).get(n2));

                } else {
                    containsNode.put(n2, false);
                    containsNode.put(n1, false);
                }
            }
            subtreeContainsNode.put(binaryTree, containsNode);
        });
        return subtreeContainsNode;
    }

    public static BinaryTree getFirstCommonAncestorWithPaths(BinaryTree root, BinaryTree n1, BinaryTree n2) {
        List<BinaryTree> n1Path = new ArrayList<>();
        List<BinaryTree> n2Path = new ArrayList<>();
        findPath(root, n1, n1Path);
        findPath(root, n2, n2Path);
        int i = 0;
        BinaryTree firstCommonAncestor = null;
        while (i < n1Path.size() && i < n2Path.size()) {
            BinaryTree n1PathNode = n1Path.get(i);
            BinaryTree n2PathNode = n2Path.get(i);
            if (n1PathNode != n2PathNode) {
                break;
            } else {
                firstCommonAncestor = n1PathNode;
                i++;
            }
        }
        return firstCommonAncestor;
    }

    private static boolean findPath(BinaryTree root, BinaryTree nodeToFind, List<BinaryTree> path) {
        if (root == nodeToFind) {
            return true;
        }

        path.add(root);

        if (root.getLeftChild() != null && findPath(root.getLeftChild(), nodeToFind, path)) {
            return true;
        }
        if (root.getRightChild() != null && findPath(root.getRightChild(), nodeToFind, path)) {
            return true;
        }

        path.remove(path.size() - 1);
        return false;
    }
}
