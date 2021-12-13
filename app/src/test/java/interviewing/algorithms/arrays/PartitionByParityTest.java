package interviewing.algorithms.arrays;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PartitionByParityTest {

    @ParameterizedTest
    @MethodSource("partitionByParityDataProvider")
    public void testPartitionByParity(int[] arr) {
        PartitionByParity.partitionByParity(arr);
        assertPartitionedByParity(arr);
    }

    private void assertPartitionedByParity(int[] arr) {
        int leftmostOdd = arr.length - 1;
        int rightmostEven = 0;
        while (arr[leftmostOdd] % 2 != 0 && leftmostOdd > rightmostEven) {
            leftmostOdd--;
        }
        while (arr[rightmostEven] % 2 == 0 && rightmostEven < leftmostOdd) {
            rightmostEven++;
        }
        assertTrue(leftmostOdd >= rightmostEven);
    }

    private static Stream<Arguments> partitionByParityDataProvider() {
        return Stream.of(
                Arguments.of(
                        new int[] { 3, 5, 4, 2, 1, 6, 8, 7 }
                ),
                Arguments.of(
                        new int[] { 8, 7, 6, 5, 4, 3, 2, 1 }
                ),
                Arguments.of(
                        new int[] { 1, 3, 5, 7, 9, 11, 13, 15}
                ),
                Arguments.of(
                        new int[] { 2, 4, 6, 8, 10, 12, 14, 16}
                )
        );
    }
}
