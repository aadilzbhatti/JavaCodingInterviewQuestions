package interviewing.datastructures.graphs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GraphNodeTest {
    private GraphNode root;

    @BeforeEach
    public void setup() {
        root = new GraphNode(0);
        GraphNode n1 = new GraphNode(1);
        GraphNode n2 = new GraphNode(2);
        GraphNode n3 = new GraphNode(3);
        GraphNode n4 = new GraphNode(4);
        GraphNode n5 = new GraphNode(5);

        root.addChild(n1);
        root.addChild(n4);
        root.addChild(n5);
        n1.addChild(n3);
        n1.addChild(n4);
        n3.addChild(n2);
        n3.addChild(n4);
        n2.addChild(n1);
    }

    @Test
    public void testBreadthFirstSearch() {
        List<GraphNode> nodes = new ArrayList<>();
        root.breadthFirstSearch(nodes::add);

        assertEquals(
                Arrays.asList(0, 1, 4, 5, 3, 2),
                nodes.stream().map(GraphNode::getData).collect(Collectors.toList())
        );
    }

    @Test
    public void testDepthFirstSearch() {
        List<GraphNode> nodes = new ArrayList<>();
        root.depthFirstSearch(nodes::add);

        assertEquals(
                Arrays.asList(0, 1, 3, 2, 4, 5),
                nodes.stream().map(GraphNode::getData).collect(Collectors.toList())
        );
    }
}