package interviewing.datastructures.graphs.algorithms;

import interviewing.datastructures.graphs.structure.UndirectedGraph;
import interviewing.datastructures.graphs.structure.GraphNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

class GraphPartitionTest {

    @ParameterizedTest
    @MethodSource("graphPartitionDataProvider")
    public void test(UndirectedGraph<Integer> g, Set<Set<GraphNode<Integer>>> expected) {
        Set<Set<GraphNode<Integer>>> partition = GraphPartition.partition(g);

        if (!expected.isEmpty()) {
            Iterator<Set<GraphNode<Integer>>> expectedIter = expected.iterator();
            Set<GraphNode<Integer>> expectedS1 = expectedIter.next();
            Set<GraphNode<Integer>> expectedS2 = expectedIter.next();
            Iterator<Set<GraphNode<Integer>>> outIter = partition.iterator();
            Set<GraphNode<Integer>> outS1 = outIter.next();
            Set<GraphNode<Integer>> outS2 = outIter.next();

            assertTrue(outS1.containsAll(expectedS1) || outS2.containsAll(expectedS1));
            assertTrue(outS1.containsAll(expectedS2) || outS2.containsAll(expectedS2));
        } else {
            assertTrue(partition.isEmpty());
        }
    }

    private static Stream<Arguments> graphPartitionDataProvider() {
        GraphNode<Integer> g1 = new GraphNode<>(1);
        GraphNode<Integer> g2 = new GraphNode<>(2);
        GraphNode<Integer> g3 = new GraphNode<>(3);
        GraphNode<Integer> g4 = new GraphNode<>(4);
        GraphNode<Integer> g5 = new GraphNode<>(5);
        GraphNode<Integer> g6 = new GraphNode<>(6);
        GraphNode<Integer> g7 = new GraphNode<>(7);
        GraphNode<Integer> g8 = new GraphNode<>(8);
        GraphNode<Integer> g9 = new GraphNode<>(9);
        GraphNode<Integer> g10 = new GraphNode<>(10);
        GraphNode<Integer> g11 = new GraphNode<>(11);
        GraphNode<Integer> g12 = new GraphNode<>(12);
        GraphNode<Integer> g13 = new GraphNode<>(13);
        GraphNode<Integer> g14 = new GraphNode<>(14);
        GraphNode<Integer> g15 = new GraphNode<>(15);
        GraphNode<Integer> g16 = new GraphNode<>(16);
        GraphNode<Integer> g17 = new GraphNode<>(17);
        GraphNode<Integer> g18 = new GraphNode<>(18);
        GraphNode<Integer> g19 = new GraphNode<>(19);
        GraphNode<Integer> g20 = new GraphNode<>(20);
        GraphNode<Integer> g21 = new GraphNode<>(21);
        GraphNode<Integer> g22 = new GraphNode<>(22);
        return Stream.of(
                Arguments.of(
                        new UndirectedGraph<Integer>() {{
                            addEdge(g1, g2);
                            addEdge(g1, g6);
                            addEdge(g2, g3);
                            addEdge(g2, g5);
                            addEdge(g3, g4);
                            addEdge(g4, g5);
                            addEdge(g5, g6);
                        }},
                        Set.of(Set.of(g1, g3, g5), Set.of(g2, g4, g6))
                ),
                Arguments.of(
                        new UndirectedGraph<Integer>() {{
                            addEdge(g1, g2);
                            addEdge(g1, g22);
                            addEdge(g2, g3);
                            addEdge(g2, g20);
                            addEdge(g3, g4);
                            addEdge(g3, g18);
                            addEdge(g4, g5);
                            addEdge(g4, g16);
                            addEdge(g5, g6);
                            addEdge(g6, g7);
                            addEdge(g6, g16);
                            addEdge(g6, g12);
                            addEdge(g7, g8);
                            addEdge(g8, g12);
                            addEdge(g8, g9);
                            addEdge(g9, g10);
                            addEdge(g10, g12);
                            addEdge(g10, g11);
                            addEdge(g11, g13);
                            addEdge(g12, g13);
                            addEdge(g13, g14);
                            addEdge(g14, g15);
                            addEdge(g15, g16);
                            addEdge(g16, g18);
                            addEdge(g15, g17);
                            addEdge(g17, g19);
                            addEdge(g18, g20);
                            addEdge(g20, g22);
                            addEdge(g17, g18);
                            addEdge(g19, g20);
                            addEdge(g19, g21);
                            addEdge(g21, g22);
                        }},
                        Set.of(
                                Set.of(g1, g3, g5, g7, g9, g11, g12, g14, g16, g17, g20),
                                Set.of(g2, g4, g6, g8, g10, g13, g15, g18, g19, g22)
                        )
                ),
                Arguments.of(
                        new UndirectedGraph<Integer>() {{
                            addEdge(g1, g2);
                            addEdge(g1, g6);
                            addEdge(g2, g3);
                            addEdge(g2, g5);
                            addEdge(g3, g4);
                            addEdge(g4, g5);
                            addEdge(g5, g6);
                            addEdge(g3, g1);
                        }},
                        Collections.emptySet()
                )
        );
    }
}