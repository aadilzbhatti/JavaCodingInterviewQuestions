package interviewing.datastructures.graphs.algorithms;

import interviewing.datastructures.graphs.structure.Graph;
import interviewing.datastructures.graphs.structure.GraphNode;
import interviewing.datastructures.graphs.structure.UndirectedGraph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BoardScore {

    /**
     * Given a board represented by an array of strings of the form "W0 T1 R3 D4 H1",
     * compute the score
     */
    public static int getScore(String[] board) {
        Graph<String> g = new UndirectedGraph<>();
        List<List<GraphNode<String>>> vertices = new ArrayList<>();
        for (String row : board) {
            List<GraphNode<String>> rowVertices = new ArrayList<>();
            String[] elements = row.split(" ");
            for (String element : elements) {
                GraphNode<String> vertex  = new GraphNode<>(element);
                g.addVertex(vertex);
                rowVertices.add(vertex);
            }
            vertices.add(rowVertices);
        }
        for (int i = 0; i < vertices.size(); i++) {
            List<GraphNode<String>> rowVertices = vertices.get(i);
            for (int j = 0; j < rowVertices.size(); j++) {
                GraphNode<String> currVertex = rowVertices.get(j);
                if (j < rowVertices.size() - 1) {
                    GraphNode<String> rightVertex = rowVertices.get(j + 1);
                    if (currVertex.getData().charAt(0) == rightVertex.getData().charAt(0)) {
                        g.addEdge(currVertex, rightVertex);
                    }
                }
                if (i < vertices.size() - 1) {
                    GraphNode<String> downVertex = vertices.get(i + 1).get(j);
                    if (currVertex.getData().charAt(0) == downVertex.getData().charAt(0)) {
                        g.addEdge(currVertex, downVertex);
                    }
                }
            }
        }
        Set<GraphNode<String>> processed = new HashSet<>();
        Deque<GraphNode<String>> queue = new ArrayDeque<>();
        int finalScore = 0;
        for (GraphNode<String> vertex : g.vertices()) {
            if (!processed.contains(vertex)) {
                int numTiles = 0;
                int numValues = 0;
                queue.add(vertex);
                while (!queue.isEmpty()) {
                    GraphNode<String> v = queue.poll();
                    if (!processed.contains(v)) {
                        processed.add(v);
                        numTiles++;
                        numValues += (v.getData().charAt(1) - '0');
                        queue.addAll(g.getNeighborsOf(v));
                    }
                }
                finalScore += numTiles * numValues;
            }
        }

        return finalScore;
    }
}
