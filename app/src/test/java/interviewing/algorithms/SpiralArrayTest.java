package interviewing.algorithms;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

class SpiralArrayTest {

    @ParameterizedTest
    @MethodSource("spiralArrayDataProvider")
    public void testSpiralArray(int n, int[][] outputArr) {
        int[][] result = SpiralArray.getSpiralArray(n);
        assertTrue(Arrays.deepEquals(outputArr, result));
    }

    private static Stream<Arguments> spiralArrayDataProvider() {
        return Stream.of(
                Arguments.of(
                        4,
                        new int[][] {
                                {1,  2,  3,  4},
                                {12, 13, 14, 5},
                                {11, 16, 15, 6},
                                {10, 9,  8,  7}
                        }
                ),
                Arguments.of(
                        3,
                        new int[][]{
                                {1, 2, 3},
                                {8, 9, 4},
                                {7, 6, 5}
                        }
                ),
                Arguments.of(
                        5,
                        new int[][] {
                                {1,  2,  3,  4,  5},
                                {16, 17, 18, 19, 6},
                                {15, 24, 25, 20, 7},
                                {14, 23, 22, 21, 8},
                                {13, 12, 11, 10, 9}
                        }
                )
        );
    }
}