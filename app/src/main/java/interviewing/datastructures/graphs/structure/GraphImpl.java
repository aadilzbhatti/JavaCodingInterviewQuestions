package interviewing.datastructures.graphs.structure;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public abstract class GraphImpl<T> implements Graph<T> {

    protected Map<GraphNode<T>, Set<GraphEdge<T>>> edges;

    public GraphImpl() {
        edges = new HashMap<>();
    }

    @Override
    public abstract void addEdge(GraphNode<T> u, GraphNode<T> v);

    @Override
    public void addVertex(GraphNode<T> v) {
        edges.putIfAbsent(v, new HashSet<>());
    }

    protected void addDirectedEdge(GraphNode<T> u, GraphNode<T> v, int weight) {
        edges.get(u).add(new GraphEdge<>(u, v, weight));
    }

    @Override
    public Set<GraphNode<T>> getNeighborsOf(GraphNode<T> v) {
        return edges.getOrDefault(v, Collections.emptySet()).stream()
                .map(GraphEdge::getEnd)
                .collect(Collectors.toSet());
    }

    @Override
    public boolean edgeExistsBetween(GraphNode<T> u, GraphNode<T> v) {
        return edges.getOrDefault(u, new HashSet<>()).stream()
                .map(GraphEdge::getEnd)
                .anyMatch(vertex -> vertex.equals(v));
    }

    @Override
    public Set<GraphNode<T>> vertices() {
        return edges.keySet();
    }

    @Override
    public String toString() {
        return "Vertices: " + edges.keySet() + "\n"
                + "Edges: " + edges;
    }
}
