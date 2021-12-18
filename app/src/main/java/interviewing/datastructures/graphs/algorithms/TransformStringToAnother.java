package interviewing.datastructures.graphs.algorithms;

import interviewing.datastructures.graphs.structure.Graph;
import interviewing.datastructures.graphs.structure.GraphNode;
import interviewing.datastructures.graphs.structure.UndirectedGraph;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TransformStringToAnother {

    public static int shortestProductionSequence(String s, String t, List<String> dictionary) {
        Map<String, GraphNode<String>> vertices = new HashMap<>();
        Graph<String> g = new UndirectedGraph<>();
        GraphNode<String> startVertex = new GraphNode<>(s);
        GraphNode<String> endVertex = new GraphNode<>(t);
        for (String word : dictionary) {
            if (!word.equals(s) && !word.equals(t)) {
                vertices.put(word, new GraphNode<>(word));
            }
            if (word.equals(s)) {
                vertices.put(word, startVertex);
            }
            if (word.equals(t)) {
                vertices.put(word, endVertex);
            }
        }
        for (int i = 0; i < dictionary.size(); i++) {
            String s1 = dictionary.get(i);
            for (int j = i + 1; j < dictionary.size(); j++) {
                String s2 = dictionary.get(j);
                if (s1.length() == s2.length()) {
                    int diff = 0;
                    for (int k = 0; k < s1.length(); k++) {
                        if (s1.charAt(k) != s2.charAt(k)) {
                            diff++;
                        }
                    }
                    if (diff <= 1) {
                        g.addEdge(vertices.get(s1), vertices.get(s2));
                    }
                }
            }
        }
        Map<GraphNode<String>, Integer> dist = new HashMap<>();
        Deque<GraphNode<String>> queue = new ArrayDeque<>();
        for (GraphNode<String> node : vertices.values()) {
            dist.put(node, Integer.MAX_VALUE);
        }
        dist.put(startVertex, 1);
        queue.add(startVertex);
        while (!queue.isEmpty()) {
            GraphNode<String> v = queue.poll();
            if (!v.visited) {
                v.visited = true;
                for (GraphNode<String> u : g.getNeighborsOf(v)) {
                    if (dist.get(u) > dist.get(v) + 1) {
                        dist.put(u, dist.get(v) + 1);
                    }
                    queue.add(u);
                }
            }
        }
        if (dist.get(endVertex) == Integer.MAX_VALUE) {
            return -1;
        }
        return dist.get(endVertex);
    }
}
