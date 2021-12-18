package interviewing.datastructures.graphs.algorithms;

import interviewing.datastructures.graphs.structure.DirectedGraph;
import interviewing.datastructures.graphs.structure.GraphNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

public class TopologicalSortTest {

    @ParameterizedTest
    @MethodSource("topologicalSortDataProvider")
    public void testTopologicalSort(DirectedGraph<Integer> g, boolean containsCycle) {
        try {
            List<GraphNode<Integer>> output = TopologicalSort.topologicalSort(g);
            assertTotalOrdering(g, output);
        } catch (TopologicalSort.CycleException e) {
            if (!containsCycle) {
                fail("A cycle was not expected but was found anyway for graph: " + g);
            }
        }
    }

    private void assertTotalOrdering(DirectedGraph<Integer> g, List<GraphNode<Integer>> resultOrdering)  {
        assertEquals(resultOrdering.size(), resultOrdering.size());
        for (int i = 0; i < resultOrdering.size(); i++) {
            GraphNode<Integer> u = resultOrdering.get(i);
            for (int j = i + 1; j < resultOrdering.size(); j++) {
                GraphNode<Integer> v = resultOrdering.get(j);
                assertTrue(
                        (g.edgeExistsBetween(u, v) && noIncomingEdgesTo(g, v, resultOrdering, j))
                                || (!g.edgeExistsBetween(u, v)));
            }
        }
    }

    // assert incoming edges are not later in the ordering
    private boolean noIncomingEdgesTo(DirectedGraph<Integer> g, GraphNode<Integer> v, List<GraphNode<Integer>> ordering, int index) {
        for (int i = index + 1; i < ordering.size(); i++) {
            GraphNode<Integer> vertex = ordering.get(i);
            if (g.edgeExistsBetween(vertex, v)) {
                return false;
            }
        }
        return true;
    }


    private static Stream<Arguments> topologicalSortDataProvider() {
        GraphNode<Integer> a = new GraphNode<>(1);
        GraphNode<Integer> b = new GraphNode<>(2);
        GraphNode<Integer> c = new GraphNode<>(3);
        GraphNode<Integer> d = new GraphNode<>(4);
        GraphNode<Integer> e = new GraphNode<>(5);
        GraphNode<Integer> f = new GraphNode<>(6);

        return Stream.of(
                Arguments.of(
                        DirectedGraph.<Integer>builder()
                                .withVertex(e)
                                .withEdge(f, a)
                                .withEdge(f, b)
                                .withEdge(d, c)
                                .withEdge(a, d)
                                .withEdge(b, d)
                                .build(),
                        false
                ),
                Arguments.of(
                        DirectedGraph.<Integer>builder()
                                .withEdge(a, b)
                                .withEdge(b, c)
                                .withEdge(c, d)
                                .withEdge(d, e)
                                .withEdge(e, f)
                                .withEdge(f, a)
                                .build(),
                        true
                )
        );
    }
}
