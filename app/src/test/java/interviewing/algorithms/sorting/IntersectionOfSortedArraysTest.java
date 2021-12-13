package interviewing.algorithms.sorting;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class IntersectionOfSortedArraysTest {
    @ParameterizedTest
    @MethodSource("intersectionOfSortedArraysDataProvider")
    public void test(int[] a, int[] b, int[] expected) {
        int[] out = IntersectionOfSortedArrays.getIntersectionOfSortedArrays(a, b);
        assertArrayEquals(expected, out);
    }

    private static Stream<Arguments> intersectionOfSortedArraysDataProvider() {
        return Stream.of(
                Arguments.of(
                        new int[] { 2, 3, 3, 5, 5, 6, 7, 7, 8, 12 },
                        new int[] { 5, 5, 6, 8, 8, 9, 10, 10 },
                        new int[] { 5, 6, 8}
                ),
                Arguments.of(
                        new int[] { 1, 1, 2, 2, 3, 3, 4, 5, 6, 7, 8 },
                        new int[] { 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 5, 6, 6, 7, 8, 8 },
                        new int[] { 1, 2, 3, 4, 5, 6, 7, 8}
                ),
                Arguments.of(
                        new int[] { 1, 2, 3, 4},
                        new int[] { 5, 6, 7, 8},
                        new int[] {}
                ),
                Arguments.of(
                        new int[] { 1, 1, 1, 1, 1, 1 },
                        new int[] { 1, 1, 1, 1 },
                        new int[] { 1 }
                )
        );
    }
}