package interviewing.datastructures.trees.algorithms;

import interviewing.datastructures.trees.structure.BinaryTree;
import org.junit.jupiter.api.Test;

import java.util.List;

class GenerateBinaryTreesTest {

    @Test
    public void test() {
        List<BinaryTree> trees = GenerateBinaryTrees.allBinaryTreesOnNNodes(4);
        trees.forEach(tree -> {
//            System.out.println("Another");
//            tree.printTree();
        });
    }
}