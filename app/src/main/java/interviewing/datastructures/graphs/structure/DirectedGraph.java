package interviewing.datastructures.graphs.structure;

public class DirectedGraph<T> extends GraphImpl<T> {

    @Override
    public void addEdge(GraphNode<T> u, GraphNode<T> v) {
        addVertex(u);
        addVertex(v);
        addDirectedEdge(u, v, 1);
    }

    protected void addDirectedEdge(GraphNode<T> u, GraphNode<T> v, double weight) {
        edges.get(u).add(new GraphEdge<>(u, v, weight));
    }

    public static <T> Builder<T> builder() {
        return new Builder<>();
    }

    public static class Builder<T> {
        private DirectedGraph<T> instance;

        public Builder() {
            instance = new DirectedGraph<>();
        }

        public Builder<T> withVertex(GraphNode<T> v) {
            instance.addVertex(v);
            return this;
        }

        public Builder<T> withEdge(GraphNode<T> v1, GraphNode<T> v2) {
            instance.addEdge(v1, v2);
            return this;
        }

        public DirectedGraph<T> build() {
            return instance;
        }
    }
}
