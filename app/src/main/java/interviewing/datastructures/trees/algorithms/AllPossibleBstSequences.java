package interviewing.datastructures.trees.algorithms;

import interviewing.datastructures.trees.structure.BinaryTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class AllPossibleBstSequences {
    public static List<List<Integer>> allPossibleBstSequences(BinaryTree root) {
        if (root == null) {
            return Collections.emptyList();
        }
        if (root.getRightChild() == null && root.getLeftChild() == null) {
            return Collections.singletonList(Collections.singletonList(root.getData()));
        }
        List<List<Integer>> leftSequences = allPossibleBstSequences(root.getLeftChild());
        List<List<Integer>> rightSequences = allPossibleBstSequences(root.getRightChild());
        return getInterleavingsOfMultipleArrays(leftSequences, rightSequences).stream()
                .peek(interleaving -> interleaving.add(0, root.getData()))
                .collect(Collectors.toList());
    }

    public static List<List<Integer>> getInterleavingOfArrays(List<Integer> a1, List<Integer> a2) {
        List<List<Integer>> interleavings = new ArrayList<>();
        getInterleavingHelper(a1, a2, interleavings, new ArrayList<>());
        return interleavings;
    }

    private static void getInterleavingHelper(List<Integer> a1, List<Integer> a2, List<List<Integer>> interleavings,
                                              List<Integer> currInterleaving) {
        if (a1.size() == 0 && a2.size() == 0) {
            if (currInterleaving.size() > 0) {
                interleavings.add(currInterleaving);
            }
            return;
        }

        if (a1.size() > 0) {
            List<Integer> newCurrInterleaving = new ArrayList<>(currInterleaving);
            newCurrInterleaving.add(a1.get(0));
            getInterleavingHelper(a1.subList(1, a1.size()), a2, interleavings, newCurrInterleaving);
        }

        if (a2.size() > 0) {
            List<Integer> newCurrInterleaving = new ArrayList<>(currInterleaving);
            newCurrInterleaving.add(a2.get(0));
            getInterleavingHelper(a1, a2.subList(1, a2.size()), interleavings, newCurrInterleaving);
        }
    }

    private static List<List<Integer>> getInterleavingsOfMultipleArrays(List<List<Integer>> a1, List<List<Integer>> a2) {
       List<List<Integer>> interleavings = new ArrayList<>();
        for (List<Integer> a1List : a1) {
            for (List<Integer> a2List : a2) {
                List<List<Integer>> subInters = getInterleavingOfArrays(a1List, a2List);
                interleavings.addAll(subInters);
            }
        }
        return interleavings;
    }
}
