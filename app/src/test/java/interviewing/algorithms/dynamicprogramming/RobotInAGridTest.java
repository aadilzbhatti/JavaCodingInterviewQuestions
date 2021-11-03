package interviewing.algorithms.dynamicprogramming;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RobotInAGridTest {

    @ParameterizedTest
    @MethodSource("findPathDataProvider")
    public void testFindPath(int[][] arr, int r, int c, boolean canFind) {
        boolean out = RobotInAGrid.findPath(arr, r, c);
        assertEquals(canFind, out);
    }

    private static Stream<Arguments> findPathDataProvider() {
        return Stream.of(
                Arguments.of(
                        new int[][] {
                                new int[] { 0, 0, 1 },
                                new int[] { 1, 0, 1 },
                                new int[] { 0, 0, 0 }
                        },
                        3,
                        3,
                        true
                ),
                Arguments.of(
                        new int[][] {
                                new int[] { 0, 0, 1 },
                                new int[] { 1, 1, 1 },
                                new int[] { 0, 0, 0 }
                        },
                        3,
                        3,
                        false
                ),
                Arguments.of(
                        new int[][]{
                                new int[] { 0, 1, 0, 1 },
                                new int[] { 0, 1, 0, 1 },
                                new int[] { 0, 1, 1, 1 },
                                new int[] { 0, 0, 0, 0 }
                        },
                        4,
                        4,
                        true
                ),

                Arguments.of(
                        new int[][]{
                                new int[] { 0, 1, 0, 1 },
                                new int[] { 0, 1, 0, 1 },
                                new int[] { 0, 1, 1, 1 },
                                new int[] { 0, 0, 0, 1 }
                        },
                        4,
                        4,
                        false
                ),
                Arguments.of(
                        new int[][] {
                                new int[] { 1, 1, 1 },
                                new int[] { 1, 1, 1 },
                                new int[] { 1, 1, 1 }
                        },
                        3,
                        3,
                        false
                ),
                Arguments.of(
                        new int[][] {
                                new int[] { 0, 0, 0 },
                                new int[] { 0, 0, 0 },
                                new int[] { 0, 0, 0 }
                        },
                        3,
                        3,
                        true
                )
        );
    }
}