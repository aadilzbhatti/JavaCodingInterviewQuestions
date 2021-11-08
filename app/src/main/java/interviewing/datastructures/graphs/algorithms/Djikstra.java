package interviewing.datastructures.graphs.algorithms;

import interviewing.datastructures.graphs.structure.GraphNode;
import interviewing.datastructures.graphs.structure.WeightedEdgeGraph;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Djikstra {

    public static int djikstra(WeightedEdgeGraph g, GraphNode source, GraphNode target, List<GraphNode> outputPath) throws Exception {
        PriorityQueue<GraphNodeWithDistance> pq = new PriorityQueue<>();
        Map<GraphNode, Integer> dist = new HashMap<>();
        Map<GraphNode, GraphNode> prev = new HashMap<>();
        dist.put(source, 0);
        for (GraphNode v : g.edges.keySet()) {
            if (source != v) {
                dist.put(v, Integer.MAX_VALUE);
            }
            pq.add(new GraphNodeWithDistance(v, dist.get(v)));
        }
        while (!pq.isEmpty()) {
            GraphNodeWithDistance u = pq.poll();
            List<GraphNode> neighbors = g.getNeighborsOf(u.node);
            for (GraphNode n : neighbors) {
                int weightOfEdge = g.getWeightOfEdgeBetween(u.node, n);
                int alt = u.distance + weightOfEdge;
                if (alt < dist.get(n) && alt >= 0) {
                    dist.put(n, alt);
                    prev.put(n, u.node);
                    GraphNodeWithDistance nWithDistance = pq.stream()
                            .filter(gnwd -> gnwd.node == n)
                            .findFirst()
                            .orElseThrow(() -> new Exception("Failed to find node " + n + " in priority queue"));
                    pq.remove(nWithDistance);
                    nWithDistance.distance = alt;
                    pq.add(nWithDistance);
                }
            }
        }
        int pathLength = dist.get(target);
        GraphNode u = target;
        if (prev.containsKey(u) || u == source) {
            while (u != null) {
                outputPath.add(0, u);
                u = prev.get(u);
            }
        }
        return pathLength;
    }

    private static class GraphNodeWithDistance implements Comparable<GraphNodeWithDistance> {
        GraphNode node;
        int distance;

        public GraphNodeWithDistance(GraphNode node, int distance) {
            this.node = node;
            this.distance = distance;
        }

        @Override
        public int compareTo(GraphNodeWithDistance graphNodeWithDistance) {
            return Integer.compare(this.distance, graphNodeWithDistance.distance);
        }
    }
}
