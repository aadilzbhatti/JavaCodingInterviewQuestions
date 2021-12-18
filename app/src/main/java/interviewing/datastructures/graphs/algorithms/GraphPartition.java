package interviewing.datastructures.graphs.algorithms;

import interviewing.datastructures.graphs.structure.GraphNode;
import interviewing.datastructures.graphs.structure.UndirectedGraph;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class GraphPartition {

    public static <T> Set<Set<GraphNode<T>>> partition(UndirectedGraph<T> g) {
        Set<GraphNode<T>> s1 = new HashSet<>();
        Set<GraphNode<T>> s2 = new HashSet<>();
        try {
            for (GraphNode<T> v : g.vertices()) {
                visit(g, v, s1, s2,true, 0, v);
            }
        } catch (PartitionDoesNotExist e) {
            return Collections.emptySet();
        }

        return Set.of(s1, s2);
    }

    private static <T> Void visit(UndirectedGraph<T> g, GraphNode<T> v, Set<GraphNode<T>> s1, Set<GraphNode<T>> s2,
                                  boolean addToOne, int pathLength, GraphNode<T> start) throws PartitionDoesNotExist {

        if (start == v && pathLength % 2 == 1) {
            throw new PartitionDoesNotExist();
        }

        if (!v.visited && (!s1.contains(v) && !s2.contains(v))) {
            v.visited = true;
            for (GraphNode<T> u : g.getNeighborsOf(v)) {
                visit(g, u, s1, s2, !addToOne, pathLength + 1, start);
            }
            v.visited = false;
            if (addToOne) {
                s1.add(v);
            } else {
                s2.add(v);
            }
        }

        return null;
    }

    private static class PartitionDoesNotExist extends Exception {

    }
}
