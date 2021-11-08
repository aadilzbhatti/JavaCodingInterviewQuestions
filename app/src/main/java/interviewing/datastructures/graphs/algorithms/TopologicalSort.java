package interviewing.datastructures.graphs.algorithms;

import interviewing.datastructures.graphs.structure.Graph;
import interviewing.datastructures.graphs.structure.GraphNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class TopologicalSort {
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
