package interviewing.datastructures.graphs.algorithms;

import interviewing.datastructures.graphs.structure.GraphNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class FindRoute {
    public static <T> boolean routeExists(GraphNode<T> n1, GraphNode<T> n2) {
        Deque<GraphNode<T>> queue = new ArrayDeque<>();
        queue.add(n1);
        while (!queue.isEmpty()) {
            GraphNode<T> curr = queue.pollFirst();
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
