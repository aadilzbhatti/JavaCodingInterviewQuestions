package interviewing.datastructures.graphs.algorithms;

import interviewing.datastructures.graphs.structure.GraphNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class FindRoute {
    public static boolean routeExists(GraphNode n1, GraphNode n2) {
        Deque<GraphNode> queue = new ArrayDeque<>();
        queue.add(n1);
        while (!queue.isEmpty()) {
            GraphNode curr = queue.pollFirst();
            if (curr == n2) {
                return true;
            }
            if (!curr.visited) {
                curr.visited = true;
                queue.addAll(curr.children);
            }
        }
        return false;
    }
}
