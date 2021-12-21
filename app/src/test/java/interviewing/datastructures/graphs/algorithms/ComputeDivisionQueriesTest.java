package interviewing.datastructures.graphs.algorithms;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ComputeDivisionQueriesTest {

    @ParameterizedTest
    @MethodSource("computeDivisionQueriesDataProvider")
    public void test(String[][] equations, double[] weights, String[][] queries, double[] expectedOutput) throws Exception {
        double[] out = ComputeDivisionQueries.computeQueries(equations, weights, queries);
        assertArrayEquals(expectedOutput, out);
    }

    private static Stream<Arguments> computeDivisionQueriesDataProvider() {
        return Stream.of(
                Arguments.of(
                        new String[][] {
                                new String[] { "a", "b" },
                                new String[] { "b", "c" }
                        },
                        new double[] { 2.0, 3.0 },
                        new String[][] {
                                new String[] { "a", "c" },
                                new String[] { "b", "a" },
                                new String[] { "a", "e" },
                                new String[] { "a", "a" },
                                new String[] { "x", "x" }
                        },
                        new double[] { 6.0, 0.5, -1.0, 1.0, -1.0 }
                )
        );
    }
}