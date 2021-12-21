package interviewing.datastructures.graphs.algorithms;

import interviewing.datastructures.graphs.structure.GraphNode;
import interviewing.datastructures.graphs.structure.WeightedEdgeDirectedGraph;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ComputeDivisionQueries {

    public static double[] computeQueries(String[][] equations, double[] weights, String[][] queries) throws Exception {
        WeightedEdgeDirectedGraph<String> g = new WeightedEdgeDirectedGraph<>();
        Map<String, GraphNode<String>> vertices = new HashMap<>();
        for (int i = 0; i < equations.length; i++) {
            GraphNode<String> v1, v2;
            if (!vertices.containsKey(equations[i][0])) {
                v1 = new GraphNode<>(equations[i][0]);
                vertices.put(equations[i][0], v1);
            } else {
                v1 = vertices.get(equations[i][0]);
            }
            if (!vertices.containsKey(equations[i][1])) {
                v2 = new GraphNode<>(equations[i][1]);
                vertices.put(equations[i][1], v2);
            } else {
                v2 = vertices.get(equations[i][1]);
            }
            g.addEdge(v1, v2, weights[i]);
            g.addEdge(v2, v1, 1 / weights[i]);
        }
        double[] res = new double[queries.length];
        for (int i = 0; i < queries.length; i++) {
            String[] query = queries[i];
            res[i] = findPathIfExistsAndCompute(query[0], query[1], g, vertices);
        }
        return res;
    }

    private static double findPathIfExistsAndCompute(String qStart, String qEnd, WeightedEdgeDirectedGraph<String> g,
                                                     Map<String, GraphNode<String>> vertices) throws Exception {
        if (!vertices.containsKey(qStart) || !vertices.containsKey(qEnd)) {
            return -1.0;
        }
        GraphNode<String> start = vertices.get(qStart);
        GraphNode<String> end = vertices.get(qEnd);
        Deque<GraphNode<String>> stack = new ArrayDeque<>();
        Set<GraphNode<String>> seen = new HashSet<>();
        Map<GraphNode<String>, GraphNode<String>> prev = new HashMap<>();
        stack.push(start);
        double res = 1.0;
        while (!stack.isEmpty()) {
            GraphNode<String> vertex = stack.pop();
            if (vertex == end) {
                break;
            }
            for (GraphNode<String> neighbor : g.getNeighborsOf(vertex)) {
                if (!prev.containsKey(neighbor)) {
                    prev.put(neighbor, vertex);
                    stack.push(neighbor);
                }
            }
        }
        GraphNode<String> curr = end;
        while (curr != start) {
            if (curr == null) return -1;
            GraphNode<String> next = prev.get(curr);
            if (next == null) break;
            res *= g.getWeightOfEdgeBetween(next, curr);
            curr = next;
        }
        return res;
    }
}
