package interviewing.datastructures.trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TreeQuestions {

    public static BinaryTree buildFromSortedArray(int[] arr) {
        return buildFromSortedArrayHelper(arr, 0, arr.length - 1);
    }

    private static BinaryTree buildFromSortedArrayHelper(int[] arr, int start, int end) {
        if (start > end) {
            return null;
        }
        int medIndex = computeMedianIndex(start, end);
        return TreeNode.builder()
                .withRoot(arr[medIndex])
                .withLeftChild(buildFromSortedArrayHelper(arr, start, medIndex - 1))
                .withRightChild(buildFromSortedArrayHelper(arr, medIndex + 1, end))
                .build();
    }

    private static int computeMedianIndex(int start, int end) {
        while (true) {
            if (end == start + 1 || end == start) {
                return start;
            }
            end--;
            start++;
        }
    }

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

    public static boolean isBalanced(BinaryTree root) {
        return Math.abs(height(root.getLeftChild()) - height(root.getRightChild())) <= 1;
    }

    private static int height(BinaryTree root) {
        if (root == null) return 0;
        return 1 + Math.max(height(root.getLeftChild()), height(root.getRightChild()));
    }

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
