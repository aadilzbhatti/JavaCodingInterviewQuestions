package interviewing.datastructures.graphs.structure;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.function.Consumer;

public class GraphNode<T> {
    public T data;
    public List<GraphNode<T>> children;
    public boolean visited = false;

    public GraphNode(T data) {
        this.data = data;
        children = new ArrayList<>();
    }

    public GraphNode<T> addChild(GraphNode<T> child) {
        children.add(child);
        return this;
    }

    public T getData() {
        return this.data;
    }

    public void breadthFirstSearch(Consumer<GraphNode<T>> consumer) {
        Deque<GraphNode<T>> queue = new ArrayDeque<>();
        queue.add(this);
        while (!queue.isEmpty()) {
            GraphNode<T> curr = queue.pollFirst();
            if (!curr.visited) {
                consumer.accept(curr);
                curr.visited = true;
                queue.addAll(curr.children);
            }
        }
    }

    public void depthFirstSearch(Consumer<GraphNode<T>> consumer) {
        if (!visited) {
            consumer.accept(this);
            visited = true;
            this.children.forEach(graphNode -> graphNode.depthFirstSearch(consumer));
        }
    }

    @Override
    public String toString() {
        return String.valueOf(data);
    }
}
