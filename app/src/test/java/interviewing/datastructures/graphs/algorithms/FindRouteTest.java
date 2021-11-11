package interviewing.datastructures.graphs.algorithms;

import interviewing.datastructures.graphs.structure.GraphNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FindRouteTest {

    @ParameterizedTest
    @MethodSource("routeExistsDataProvider")
    public void testRouteExists(GraphNode n1, GraphNode n2, boolean result) {
        assertEquals(result, FindRoute.routeExists(n1, n2));
    }

    private static Stream<Arguments> routeExistsDataProvider() {
        GraphNode rootNode = new GraphNode(0);
        GraphNode foundNode = new GraphNode(1);
        GraphNode n0 = new GraphNode(0);
        GraphNode n1 = new GraphNode(1);
        GraphNode n2 = new GraphNode(2);
        GraphNode n3 = new GraphNode(3);
        GraphNode n4 = new GraphNode(4);
        GraphNode n5 = new GraphNode(5);

        return Stream.of(
                Arguments.of(
                        rootNode.addChild(n0
                                .addChild(n1
                                        .addChild(n3))
                                .addChild(n5))
                                .addChild(n4
                                        .addChild(foundNode
                                                .addChild(n2)))
                                .addChild(n3
                                        .addChild(n5)
                                        .addChild(n4))
                                .addChild(n2),
                        foundNode,
                        true
                ),
                Arguments.of(
                        rootNode.addChild(n0
                                .addChild(n1
                                        .addChild(n3))
                                .addChild(n5))
                                .addChild(n4
                                        .addChild(n2))
                                .addChild(n3
                                        .addChild(n5)
                                        .addChild(n4))
                                .addChild(n2),
                        foundNode,
                        false
                )
        );
    }
}
