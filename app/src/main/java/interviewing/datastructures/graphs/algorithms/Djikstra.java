package interviewing.datastructures.graphs.algorithms;

import interviewing.datastructures.graphs.structure.GraphNode;
import interviewing.datastructures.graphs.structure.WeightedEdgeDirectedGraph;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class Djikstra {

    public static <T> double djikstra(WeightedEdgeDirectedGraph<T> g, GraphNode<T> source, GraphNode<T> target, List<GraphNode<T>> outputPath) throws Exception {
        PriorityQueue<GraphNodeWithDistance<T>> pq = new PriorityQueue<>();
        Map<GraphNode<T>, Double> dist = new HashMap<>();
        Map<GraphNode<T>, GraphNode<T>> prev = new HashMap<>();
        dist.put(source, 0.0);
        for (GraphNode<T> v : g.vertices()) {
            if (source != v) {
                dist.put(v, Double.MAX_VALUE);
            }
            pq.add(new GraphNodeWithDistance<>(v, dist.get(v)));
        }
        while (!pq.isEmpty()) {
            GraphNodeWithDistance<T> u = pq.poll();
            Set<GraphNode<T>> neighbors = g.getNeighborsOf(u.node);
            for (GraphNode<T> n : neighbors) {
                double weightOfEdge = g.getWeightOfEdgeBetween(u.node, n);
                double alt = u.distance + weightOfEdge;
                if (alt < dist.get(n) && alt >= 0) {
                    dist.put(n, alt);
                    prev.put(n, u.node);
                    GraphNodeWithDistance<T> nWithDistance = pq.stream()
                            .filter(gnwd -> gnwd.node == n)
                            .findFirst()
                            .orElseThrow(() -> new Exception("Failed to find node " + n + " in priority queue"));
                    pq.remove(nWithDistance);
                    nWithDistance.distance = alt;
                    pq.add(nWithDistance);
                }
            }
        }
        double pathLength = dist.get(target);
        GraphNode<T> u = target;
        if (prev.containsKey(u) || u == source) {
            while (u != null) {
                outputPath.add(0, u);
                u = prev.get(u);
            }
        }
        return pathLength;
    }

    private static class GraphNodeWithDistance<T> implements Comparable<GraphNodeWithDistance<T>> {
        GraphNode<T> node;
        double distance;

        public GraphNodeWithDistance(GraphNode<T> node, double distance) {
            this.node = node;
            this.distance = distance;
        }

        @Override
        public int compareTo(GraphNodeWithDistance graphNodeWithDistance) {
            return Double.compare(this.distance, graphNodeWithDistance.distance);
        }
    }
}
