package interviewing.algorithms.dynamicprogramming;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WaysToTraverseArrayTest {

    @ParameterizedTest
    @MethodSource("waysToTraverseArrayDataProvider")
    public void test(int n, int expected) {
        int out = WaysToTraverseArray.numWaysToTraverse2DArrayOfSize(n);
        assertEquals(expected, out);
    }

    private static Stream<Arguments> waysToTraverseArrayDataProvider() {
        return Stream.of(
                Arguments.of(1, 1),
                Arguments.of(2, 2),
                Arguments.of(3, 6),
                Arguments.of(4, 20),
                Arguments.of(5, 70)
        );
    }
}