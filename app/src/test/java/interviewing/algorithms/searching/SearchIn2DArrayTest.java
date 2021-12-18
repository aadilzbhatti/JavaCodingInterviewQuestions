package interviewing.algorithms.searching;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SearchIn2DArrayTest {

    @ParameterizedTest
    @MethodSource("searchIn2DArrayDataProvider")
    public void test(int[][] arr, int val, boolean exists) {
        boolean doesExist = SearchIn2DArray.find(arr, val);
        assertEquals(exists, doesExist);
    }

    private static Stream<Arguments> searchIn2DArrayDataProvider() {
        return Stream.of(
                Arguments.of(
                        new int[][] {
                                new int[] { -1, 2, 4, 4, 6 },
                                new int[] { 1, 5, 5, 9, 21 },
                                new int[] { 3, 6, 6, 9, 22 },
                                new int[] { 3, 6, 8, 10, 24 },
                                new int[] { 6, 8, 9, 12, 25 },
                                new int[] { 8, 10, 12, 13, 40 }
                        },
                        7,
                        false
                ),
                Arguments.of(
                        new int[][] {
                                new int[] { -1, 2, 4, 4, 6 },
                                new int[] { 1, 5, 5, 9, 21 },
                                new int[] { 3, 6, 6, 9, 22 },
                                new int[] { 3, 6, 8, 10, 24 },
                                new int[] { 6, 8, 9, 12, 25 },
                                new int[] { 8, 10, 12, 13, 40 }
                        },
                        8,
                        true
                )
        );
    }
}