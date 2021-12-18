package interviewing.datastructures.graphs.algorithms;

import interviewing.datastructures.graphs.structure.Graph;
import interviewing.datastructures.graphs.structure.GraphNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class TopologicalSort {
    public static <T> List<GraphNode<T>> topologicalSort(Graph<T> g) throws CycleException {
        Deque<GraphNode<T>> outputList = new ArrayDeque<>();
        for (GraphNode<T> vertex : g.vertices()) {
            topoSortVisit(g, vertex, outputList);
        }
        return new ArrayList<>(outputList);
    }

    private static <T> Void topoSortVisit(Graph<T> g, GraphNode<T> v, Deque<GraphNode<T>> outputList) throws CycleException {
        if (v.visited) {
            throw new CycleException(v);
        }
        if (outputList.contains(v)) {
            return null;
        }
        v.visited = true;
        for (GraphNode<T> child : g.getNeighborsOf(v)) {
            topoSortVisit(g, child, outputList);
        }
        v.visited = false;
        outputList.addFirst(v);
        return null;
    }

    public static class CycleException extends Exception {
        private static final String CYCLE_EXISTS = "Cycle found in graph at node: ";

        public <T> CycleException(GraphNode<T> vertex) {
            super(CYCLE_EXISTS + vertex.getData());
        }
    }
}
