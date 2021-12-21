package interviewing.datastructures.graphs.algorithms;

import interviewing.datastructures.graphs.structure.GraphNode;
import interviewing.datastructures.graphs.structure.WeightedEdgeDirectedGraph;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DjikstraTest {

    @Test
    public void testDjikstra() throws Exception {
        GraphNode<Integer> g0 = new GraphNode<>(0);
        GraphNode<Integer> g1 = new GraphNode<>(1);
        GraphNode<Integer> g2 = new GraphNode<>(2);
        GraphNode<Integer> g3 = new GraphNode<>(3);
        GraphNode<Integer> g4 = new GraphNode<>(4);
        GraphNode<Integer> g5 = new GraphNode<>(5);
        GraphNode<Integer> g6 = new GraphNode<>(6);
        GraphNode<Integer> g7 = new GraphNode<>(7);
        WeightedEdgeDirectedGraph<Integer> g = new WeightedEdgeDirectedGraph<>() {{
            addEdge(g0, g7, 16);
            addEdge(g0, g2, 26);
            addEdge(g0, g6, 58);
            addEdge(g1, g5, 32);
            addEdge(g1, g7, 19);
            addEdge(g1, g3, 29);
            addEdge(g1, g2, 36);
            addEdge(g2, g3, 17);
            addEdge(g2, g6, 40);
            addEdge(g3, g6, 52);
            addEdge(g4, g0, 38);
            addEdge(g4, g6, 93);
            addEdge(g4, g7, 37);
            addEdge(g5, g7, 28);
            addEdge(g5, g4, 35);
            addEdge(g7, g2, 34);
        }};
                
        List<GraphNode<Integer>> path = new ArrayList<>();
        double pathLength = Djikstra.djikstra(g, g1, g6, path);
        assertEquals(76.0, pathLength);
        assertEquals(Arrays.asList(g1, g2, g6), path);

        List<GraphNode<Integer>> noPath = new ArrayList<>();
        double noPathLength = Djikstra.djikstra(g, g6, g1, noPath);
        assertEquals(Double.MAX_VALUE, noPathLength);
        assertEquals(Collections.emptyList(), noPath);
    }
}