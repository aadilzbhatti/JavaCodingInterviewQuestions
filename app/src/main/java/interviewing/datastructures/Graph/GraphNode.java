package interviewing.datastructures.Graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.function.Consumer;

public class GraphNode {
    public int data;
    public List<GraphNode> children;
    public boolean visited = false;

    public GraphNode(int data) {
        this.data = data;
        children = new ArrayList<>();
    }

    public GraphNode addChild(GraphNode child) {
        children.add(child);
        return this;
    }

    public int getData() {
        return this.data;
    }

    public void breadthFirstSearch(Consumer<GraphNode> consumer) {
        Deque<GraphNode> queue = new ArrayDeque<>();
        queue.add(this);
        while (!queue.isEmpty()) {
            GraphNode curr = queue.pollFirst();
            if (!curr.visited) {
                consumer.accept(curr);
                curr.visited = true;
                queue.addAll(curr.children);
            }
        }
    }

    public void depthFirstSearch(Consumer<GraphNode> consumer) {
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
