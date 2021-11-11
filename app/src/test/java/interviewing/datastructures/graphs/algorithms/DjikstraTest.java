package interviewing.datastructures.graphs.algorithms;

import interviewing.datastructures.graphs.structure.GraphNode;
import interviewing.datastructures.graphs.structure.WeightedEdgeGraph;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DjikstraTest {

    @Test
    public void testDjikstra() throws Exception {
        GraphNode g0 = new GraphNode(0);
        GraphNode g1 = new GraphNode(1);
        GraphNode g2 = new GraphNode(2);
        GraphNode g3 = new GraphNode(3);
        GraphNode g4 = new GraphNode(4);
        GraphNode g5 = new GraphNode(5);
        GraphNode g6 = new GraphNode(6);
        GraphNode g7 = new GraphNode(7);
        WeightedEdgeGraph g = WeightedEdgeGraph.builder()
                .withEdge(g0, g7, 16)
                .withEdge(g0, g2, 26)
                .withEdge(g0, g6, 58)
                .withEdge(g1, g5, 32)
                .withEdge(g1, g7, 19)
                .withEdge(g1, g3, 29)
                .withEdge(g1, g2, 36)
                .withEdge(g2, g3, 17)
                .withEdge(g2, g6, 40)
                .withEdge(g3, g6, 52)
                .withEdge(g4, g0, 38)
                .withEdge(g4, g6, 93)
                .withEdge(g4, g7, 37)
                .withEdge(g5, g7, 28)
                .withEdge(g5, g4, 35)
                .withEdge(g7, g2, 34)
                .build();
        List<GraphNode> path = new ArrayList<>();
        int pathLength = Djikstra.djikstra(g, g1, g6, path);
        assertEquals(76, pathLength);
        assertEquals(Arrays.asList(g1, g2, g6), path);

        List<GraphNode> noPath = new ArrayList<>();
        int noPathLength = Djikstra.djikstra(g, g6, g1, noPath);
        assertEquals(Integer.MAX_VALUE, noPathLength);
        assertEquals(Collections.emptyList(), noPath);
    }
}