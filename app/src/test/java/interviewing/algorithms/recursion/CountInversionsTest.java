package interviewing.algorithms.recursion;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CountInversionsTest {

    @ParameterizedTest
    @MethodSource("countInversionsDataProvider")
    public void testCountInversions(int[] arr, int expected) {
        int output = CountInversions.countInversions(arr);
        assertEquals(expected, output);
    }

    private static Stream<Arguments> countInversionsDataProvider() {
        return Stream.of(
                Arguments.of(
                        new int[] { 3, 2, 6, 1, 9, 4, 7, 5, 8 },
                        11
                ),
                Arguments.of(
                        new int[] { 9, 8, 7, 6, 5, 4, 3, 2, 1 },
                        36
                ),
                Arguments.of(
                        new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 },
                        0
                ),
                Arguments.of(
                        new int[] { 1, 2, 3, 4, 5, 7, 6, 8, 9},
                        1
                )
        );
    }
}