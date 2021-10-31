package interviewing.datastructures.graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class WeightedEdgeGraph {

    public Map<GraphNode, List<Edge>> edges;

    public WeightedEdgeGraph() {
        edges = new HashMap<>();
    }

    public WeightedEdgeGraph(Map<GraphNode, List<Edge>> edges) {
        this.edges = edges;
    }

    public boolean edgeExistsBetween(GraphNode u, GraphNode v) {
        return edges.getOrDefault(u, Collections.emptyList()).stream()
                .map(edge -> edge.v)
                .anyMatch(vertex -> vertex.equals(v));
    }

    public List<GraphNode> getNeighborsOf(GraphNode u) {
        return edges.getOrDefault(u, Collections.emptyList()).stream()
                .map(edge -> edge.v)
                .collect(Collectors.toList());
    }

    public int getWeightOfEdgeBetween(GraphNode u, GraphNode v) throws Exception {
        if (!edgeExistsBetween(u, v)) {
            throw new Exception("No edge exists between " + u + " and " + v);
        }
        return edges.get(u).stream().filter(edge -> edge.v == v)
                .findFirst()
                .map(edge -> edge.weight)
                .get(); // we already asserted the edge exists above
    }

    @Override
    public String toString() {
        return "Vertices: " + edges.keySet() + "\n"
                + "Edges: " + edges;
    }

    public static WeightedEdgeGraph.Builder builder() {
        return new WeightedEdgeGraph.Builder();
    }

    static class Builder {
        private Map<GraphNode, List<Edge>> edges;

        Builder() {
            edges = new HashMap<>();
        }

        public WeightedEdgeGraph.Builder withVertex(GraphNode v) {
            edges.putIfAbsent(v, new ArrayList<>());
            return this;
        }

        public WeightedEdgeGraph.Builder withEdge(GraphNode v1, GraphNode v2, int weight) {
            withVertex(v1);
            withVertex(v2);
            List<Edge> v1Edges = edges.get(v1);
            v1Edges.add(new Edge(v1, v2, weight));
            return this;
        }

        public WeightedEdgeGraph build() {
            return new WeightedEdgeGraph(edges);
        }
    }

    private static class Edge {
        GraphNode u;
        GraphNode v;
        int weight;

        Edge(GraphNode u, GraphNode v, int weight) {
            this.u = u;
            this.v = v;
            this.weight = weight;
        }
    }
}
