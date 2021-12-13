package interviewing.algorithms.arrays;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class DutchFlagPartitionTest {

    @ParameterizedTest
    @MethodSource("dutchFlagPartitionDataProvider")
    public void test(int[] arr, int pivotIndex, int[] expected) {
        DutchFlagPartition.dutchFlagPartition(arr, pivotIndex);
        assertArrayEquals(expected, arr);
    }

    private static Stream<Arguments> dutchFlagPartitionDataProvider() {
        return Stream.of(
                Arguments.of(
                        new int[] { 3, 4, 2, 3, 2, 4, 2, 3, 4 },
                        3,
                        new int[] { 2, 2, 2, 3, 3, 3, 4, 4, 4 }
                ),
                Arguments.of(
                        new int[] { 0, 1, 2, 0, 2, 1, 1 },
                        3,
                        new int[] { 0, 0, 1, 2, 2, 1, 1 }
                )
        );
    }
}