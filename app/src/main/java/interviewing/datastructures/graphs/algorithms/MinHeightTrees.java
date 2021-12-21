package interviewing.datastructures.graphs.algorithms;

import interviewing.datastructures.graphs.structure.Graph;
import interviewing.datastructures.graphs.structure.GraphNode;
import interviewing.datastructures.graphs.structure.UndirectedGraph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MinHeightTrees {

    public static Set<Integer> getMinHeightTrees(int numNodes, int[][] edges) {
        Graph<Integer> g = new UndirectedGraph<>();
        List<GraphNode<Integer>> vertices = new ArrayList<>();
        for (int i = 0; i < numNodes; i++) {
            GraphNode<Integer> vertex = new GraphNode<>(i);
            vertices.add(vertex);
            g.addVertex(vertex);
        }
        for (int[] edge : edges) {
            g.addEdge(vertices.get(edge[0]), vertices.get(edge[1]));
        }
        int minPathLength = Integer.MAX_VALUE;
        Set<Integer> res = new HashSet<>();
        for (GraphNode<Integer> vertex : g.vertices()) {
            int longestPath = computeLongestPath(g, vertex);
            if (longestPath < minPathLength) {
                minPathLength = longestPath;
                res.clear();
                res.add(vertex.getData());
            }  else if (longestPath == minPathLength) {
                res.add(vertex.getData());
            }
        }
        return res;
    }

    private static int computeLongestPath(Graph<Integer> g, GraphNode<Integer> vertex) {
        Set<GraphNode<Integer>> seen = new HashSet<>();
        seen.add(vertex);
        return 1 + computeLongestPathHelper(g, vertex, seen);
    }

    private static int computeLongestPathHelper(Graph<Integer> g, GraphNode<Integer> vertex, Set<GraphNode<Integer>> seen) {
        int maxPathLength = 0;
        for (GraphNode<Integer> neighbor : g.getNeighborsOf(vertex)) {
            if (!seen.contains(neighbor)) {
                seen.add(neighbor);
                int pathLength = 1 + computeLongestPathHelper(g, neighbor, seen);
                if (pathLength > maxPathLength) {
                    maxPathLength = pathLength;
                }
            }
        }
        return maxPathLength;
    }
}
