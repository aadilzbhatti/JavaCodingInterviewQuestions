package interviewing.datastructures.graphs.algorithms;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Collections;
import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinHeightTreesTest {

    @ParameterizedTest
    @MethodSource("minHeightTreesDataProvider")
    public void test(int numNodes, int[][] edges, Set<Integer> expected) {
        Set<Integer> output = MinHeightTrees.getMinHeightTrees(numNodes, edges);
        assertEquals(expected, output);
    }

    private static Stream<Arguments> minHeightTreesDataProvider() {
        return Stream.of(
                Arguments.of(
                        4,
                        new int[][] {
                                new int[] { 1, 0 },
                                new int[] { 1, 2 },
                                new int[] { 1, 3 }
                        },
                        Collections.singleton(1)
                ),
                Arguments.of(
                        6,
                        new int[][] {
                                new int[] { 3, 0 },
                                new int[] { 3, 1 },
                                new int[] { 3, 2 },
                                new int[] { 3, 4 },
                                new int[] { 5, 4 }
                        },
                        Set.of(4, 3)
                )
        );
    }
}