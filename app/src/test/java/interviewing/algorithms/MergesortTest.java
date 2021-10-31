package interviewing.algorithms;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

class MergesortTest {

    @ParameterizedTest
    @MethodSource("mergesortDataProvider")
    public void testMergeSort(int[] arr) {
        int[] res = Mergesort.mergesort(arr);
        assertSorted(res);
    }

    private void assertSorted(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            assertTrue(arr[i] <= arr[i + 1]);
        }
    }

    private static Stream<Arguments> mergesortDataProvider() {
        return Stream.of(
                Arguments.of(
                        new int[] { 4, 9, 3, 1, 2, 5, 6, 8, 7}
                ),
                Arguments.of(
                        new int[] { 0, 1 }
                ),
                Arguments.of(
                        new int[] { 1, 0 }
                ),
                Arguments.of(
                        new int[] { 9, 8, 7, 6, 5, 4, 3, 2, 1 }
                )
        );
    }
}