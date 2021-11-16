package interviewing.algorithms.sorting;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class MergeSmallerSortedArrayIntoLargerTest {

    @ParameterizedTest
    @MethodSource("mergeSmallerArrayIntoLargerDataProvider")
    public void testMergeSmallerArrayIntoLarger(int[] larger, int[] smaller, int[] res) {
        MergeSmallerSortedArrayIntoLarger.mergeLargerSortedArrayIntoLarger(larger, smaller);
        assertArrayEquals(larger, res);
    }

    private static Stream<Arguments> mergeSmallerArrayIntoLargerDataProvider() {
        return Stream.of(
                Arguments.of(
                        new int[] { 3, 4, 5, 6, 7, 0, 0, 0, 0 },
                        new int[] { 1, 2, 3, 4 },
                        new int[] { 1, 2, 3, 3, 4, 4, 5, 6, 7 }
                ),
                Arguments.of(
                        new int[] { 19, 0, 0, 0, 0, 0 },
                        new int[] { 14, 15, 16, 17, 18 },
                        new int[] { 14, 15, 16, 17, 18, 19}
                )
        );
    }
}