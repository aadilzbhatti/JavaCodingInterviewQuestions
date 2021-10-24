package interviewing.datastructures.Graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {

    public Map<GraphNode, List<GraphNode>> edges;

    public Graph() {
        edges = new HashMap<>();
    }

    public Graph(Map<GraphNode, List<GraphNode>> edges) {
        this.edges = edges;
    }

    public boolean edgeExistsBetween(GraphNode u, GraphNode v) {
        return edges.getOrDefault(u, Collections.emptyList()).contains(v);
    }

    @Override
    public String toString() {
        return "Vertices: " + edges.keySet() + "\n"
                + "Edges: " + edges;
    }

    public static Builder builder() {
        return new Builder();
    }

    static class Builder {
        private Map<GraphNode, List<GraphNode>> edges;

        Builder() {
            edges = new HashMap<>();
        }

        public Builder withVertex(GraphNode v) {
            edges.putIfAbsent(v, new ArrayList<>());
            return this;
        }

        public Builder withEdge(GraphNode v1, GraphNode v2) {
            withVertex(v1);
            withVertex(v2);
            List<GraphNode> edgeVertices = edges.get(v1);
            edgeVertices.add(v2);
            return this;
        }

        public Graph build() {
            return new Graph(edges);
        }
    }
}
