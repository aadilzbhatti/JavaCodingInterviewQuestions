package interviewing.algorithms.dynamicprogramming;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FindPatternIn2DArrayTest {

    @ParameterizedTest
    @MethodSource("findPatternDataProvider")
    public void test(int[][] arr, int[] pattern, boolean exists) {
        boolean patternExists = FindPatternIn2DArray.findPatternIn2DArrayRecursive(arr, pattern);
        assertEquals(exists, patternExists);
    }

    @ParameterizedTest
    @MethodSource("findPatternDataProvider")
    public void testFindPatternLessRecursive(int[][] arr, int[] pattern, boolean exists) {
        boolean patternExists = FindPatternIn2DArray.findPatternLessRecursive(arr, pattern);
        assertEquals(exists, patternExists);
    }

    private static Stream<Arguments> findPatternDataProvider () {
        return Stream.of(
                Arguments.of(
                        new int[][] {
                                new int[] { 1, 2, 3 },
                                new int[] { 3, 4, 5 },
                                new int[] { 5, 6, 7 }
                        },
                        new int[] { 1, 3, 4, 6 },
                        true
                ),
                Arguments.of(
                        new int[][] {
                                new int[] { 1, 2, 3 },
                                new int[] { 3, 4, 5 },
                                new int[] { 5, 6, 7 }
                        },
                        new int[] { 1, 2, 3, 4 },
                        false
                ),
                Arguments.of(
                        new int[][] {
                                new int[] { 1, 2, 3 },
                                new int[] { 3, 4, 5 },
                                new int[] { 5, 6, 7 }
                        },
                        new int[] { 1, 3, 5, 6, 4, 2, 3, 5, 7 },
                        true
                ),
                Arguments.of(
                        new int[][] {
                                new int[] { 1, 2, 3 },
                                new int[] { 3, 4, 5 },
                                new int[] { 5, 6, 7 }
                        },
                        new int[] { 1, 3, 5, 6, 4, 2, 3, 5, 8 },
                        false
                )
        );
    }
}