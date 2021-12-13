package interviewing.datastructures.trees.algorithms;

import interviewing.datastructures.trees.structure.BinaryTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class NodesByColumnOrder {

    public static List<BinaryTree> getNodesByColumnOrder(BinaryTree root) {
        Map<BinaryTree, Integer> nodeToColumn = new HashMap<>();
        Map<Integer, ColumnPriority> columnPriorities = new HashMap<>();

        nodeToColumn.put(root, 0);
        List<BinaryTree> rootColumnList = new ArrayList<>();
        rootColumnList.add(root);
        ColumnPriority rootColumnPriority = new ColumnPriority(rootColumnList, 0);
        columnPriorities.put(0, rootColumnPriority);

        Deque<BinaryTree> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            BinaryTree curr = queue.pollFirst();
            int column = nodeToColumn.get(curr);
            if (curr.getLeftChild() != null) {
                addNodeWithColumnPriority(nodeToColumn, columnPriorities, queue,
                        column - 1, curr.getLeftChild());
            }
            if (curr.getRightChild() != null) {
                addNodeWithColumnPriority(nodeToColumn, columnPriorities, queue,
                        column + 1, curr.getRightChild());
            }
        }

        PriorityQueue<ColumnPriority> pq = new PriorityQueue<>();
        for (Map.Entry<Integer, ColumnPriority> entry : columnPriorities.entrySet()) {
            pq.add(entry.getValue());
        }

        List<BinaryTree> output = new ArrayList<>();
        while (!pq.isEmpty()) {
            output.addAll(pq.poll().nodes);
        }
        return output;
    }

    private static void addNodeWithColumnPriority(Map<BinaryTree, Integer> nodeToColumn,
                                                  Map<Integer, ColumnPriority> columnPriorities,
                                                  Deque<BinaryTree> queue, int column, BinaryTree curr) {

        nodeToColumn.put(curr, column);

        ColumnPriority currColumnPriority = columnPriorities.getOrDefault(column, new ColumnPriority(new ArrayList<>(), column));
        currColumnPriority.nodes.add(curr);
        columnPriorities.put(column, currColumnPriority);

        queue.offer(curr);
    }

    private static class ColumnPriority implements Comparable<ColumnPriority> {

        List<BinaryTree> nodes;
        int column;

        ColumnPriority(List<BinaryTree> nodes, int column) {
            this.nodes = nodes;
            this.column = column;
        }

        @Override
        public int compareTo(ColumnPriority columnPriority) {
            return this.column - columnPriority.column;
        }
    }
}
