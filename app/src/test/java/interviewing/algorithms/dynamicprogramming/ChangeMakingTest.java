package interviewing.algorithms.dynamicprogramming;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ChangeMakingTest {

    @ParameterizedTest
    @MethodSource("changeMakingDataProvider")
    public void testChangeMakingRecursive(int n, int expected) {
        int out = ChangeMaking.countWaysToMakeChangeRecursive(n);
        assertEquals(expected, out);
    }

    @ParameterizedTest
    @MethodSource("changeMakingDataProvider")
    public void testChangeMakingLessRecursive(int n, int expected) {
        int out = ChangeMaking.countWaysToMakeChangeLessRecursive(n);
        assertEquals(expected, out);
    }

    private static Stream<Arguments> changeMakingDataProvider() {
        return Stream.of(
                Arguments.of(
                        12,
                        4
                ),
                Arguments.of(
                        10,
                        4
                ),
                Arguments.of(
                        37,
                        24
                ),
                Arguments.of(
                        25,
                        13
                ),
                Arguments.of(
                        15,
                        6
                ),
                Arguments.of(
                        6,
                        2
                )
        );
    }
}