package interviewing.datastructures.graphs.structure;

public class WeightedEdgeDirectedGraph<T> extends DirectedGraph<T> {

    public void addEdge(GraphNode<T> u, GraphNode<T> v, double weight) {
        addVertex(u);
        addVertex(v);
        addDirectedEdge(u, v, weight);
    }

    public double getWeightOfEdgeBetween(GraphNode<T> u, GraphNode<T> v) throws Exception {
        if (!edgeExistsBetween(u, v)) {
            throw new Exception("No edge exists between " + u + " and " + v);
        }
        return edges.get(u).stream()
                .filter(edge -> edge.getEnd() == v)
                .findFirst()
                .map(GraphEdge::getWeight)
                .get(); // we already asserted the edge exists above
    }

    @Override
    public String toString() {
        return "Vertices: " + edges.keySet() + "\n"
                + "Edges: " + edges;
    }

    public static class Builder<T> {
        private WeightedEdgeDirectedGraph<T> instance;

        Builder() {
            instance = new WeightedEdgeDirectedGraph<>();
        }

        public WeightedEdgeDirectedGraph.Builder<T> withVertex(GraphNode<T> v) {
            instance.addVertex(v);
            return this;
        }

        public WeightedEdgeDirectedGraph.Builder<T> withEdge(GraphNode<T> v1, GraphNode<T> v2, int weight) {
            instance.addEdge(v1, v2, weight);
            return this;
        }

        public WeightedEdgeDirectedGraph<T> build() {
            return instance;
        }
    }
}
