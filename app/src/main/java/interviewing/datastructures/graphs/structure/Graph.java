package interviewing.datastructures.graphs.structure;

import java.util.Set;

public interface Graph<T> {
    void addEdge(GraphNode<T> u, GraphNode<T> v);
    void addVertex(GraphNode<T> v);
    Set<GraphNode<T>> getNeighborsOf(GraphNode<T> v);
    boolean edgeExistsBetween(GraphNode<T> u, GraphNode<T> v);
    Set<GraphNode<T>> vertices();
}
