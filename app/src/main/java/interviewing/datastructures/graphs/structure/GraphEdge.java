package interviewing.datastructures.graphs.structure;

public class GraphEdge<T> {
    private GraphNode<T> start;
    private GraphNode<T> end;
    private double weight;

    public GraphEdge(GraphNode<T> u, GraphNode<T> v, double weight) {
        this.start = u;
        this.end = v;
        this.weight = weight;
    }

    public GraphNode<T> getStart() {
        return start;
    }

    public GraphNode<T> getEnd() {
        return end;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "(" + start + " -> " + end + ")";
    }
}
