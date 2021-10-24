package interviewing.datastructures.Graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class GraphQuestions {

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

    public static List<GraphNode> topologicalSort(Graph g) throws CycleException {
        Deque<GraphNode> outputList = new ArrayDeque<>();
        for (GraphNode vertex : g.edges.keySet()) {
            topoSortVisit(g, vertex, outputList);
        }
        return new ArrayList<>(outputList);
    }

    private static void topoSortVisit(Graph g, GraphNode v, Deque<GraphNode> outputList) throws CycleException {
        if (v.visited) {
            throw new CycleException(v);
        }
        if (outputList.contains(v)) {
            return;
        }
        v.visited = true;
        for (GraphNode child : g.edges.get(v)) {
            topoSortVisit(g, child, outputList);
        }
        v.visited = false;
        outputList.addFirst(v);
    }

    public static class CycleException extends Exception {
        private static final String CYCLE_EXISTS = "Cycle found in graph at node: ";

        public CycleException(GraphNode vertex) {
            super(CYCLE_EXISTS + vertex.getData());
        }
    }
}
