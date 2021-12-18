package interviewing.datastructures.graphs.structure;

public class UndirectedGraph<T> extends GraphImpl<T> {

    @Override
    public void addEdge(GraphNode<T> u, GraphNode<T> v) {
        addVertex(u);
        addVertex(v);
        addDirectedEdge(u, v, 1);
        addDirectedEdge(v, u, 1);
    }

    public static class Builder<T> {
        private UndirectedGraph<T> instance;

        public Builder() {
            instance = new UndirectedGraph<>();
        }

        public Builder<T> withVertex(GraphNode<T> v) {
            instance.addVertex(v);
            return this;
        }

        public Builder<T> withEdge(GraphNode<T> v1, GraphNode<T> v2) {
            instance.addEdge(v1, v2);
            return this;
        }

        public UndirectedGraph<T> build() {
            return instance;
        }
    }
}
