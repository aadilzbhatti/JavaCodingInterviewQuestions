package interviewing.algorithms.searching;

import interviewing.algorithms.searching.BinarySearch;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BinarySearchTest {

    @ParameterizedTest
    @MethodSource("binarySearchDataProvider")
    public void testBinarySearch(int[] arr, int val, int expectedPos) {
        int pos = BinarySearch.binarySearch(arr, val);
        assertEquals(pos, expectedPos);
    }

    private static Stream<Arguments> binarySearchDataProvider() {
        return Stream.of(
                Arguments.of(
                        new int[] { 1, 3, 4, 7, 12, 15, 19 },
                        3,
                        1
                ),
                Arguments.of(
                        new int[] { 1, 3, 4, 7, 12, 15, 19 },
                        15,
                        5
                ),
                Arguments.of(
                        new int[] { 1, 3, 4, 7, 12, 15, 19 },
                        19,
                        6
                ),
                Arguments.of(
                        new int[] { 1, 3, 4, 7, 12, 15, 19 },
                        1,
                        0
                ),
                Arguments.of(
                        new int[] { 1, 3, 4, 7, 12, 15, 19 },
                        31,
                        -1
                )
        );
    }
}