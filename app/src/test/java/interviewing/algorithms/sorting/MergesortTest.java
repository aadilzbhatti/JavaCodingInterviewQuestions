package interviewing.algorithms.sorting;

import interviewing.algorithms.concurrency.ParallelMergesort;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.concurrent.ExecutionException;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

class MergesortTest {

    @ParameterizedTest
    @MethodSource("mergesortDataProvider")
    public void testMergeSort(int[] arr) {
        long currTime = System.currentTimeMillis();
        int[] res = Mergesort.mergesort(arr);
        long endTime = System.currentTimeMillis();
        assertSorted(res);
//        System.out.println("MergeSort ran in " + (endTime - currTime) + "ms");
    }

    @ParameterizedTest
    @MethodSource("mergesortDataProvider")
    public void testParallelMergeSort(int[] arr) throws ExecutionException, InterruptedException {
        long currTime = System.currentTimeMillis();
        int[] res = ParallelMergesort.mergesort(arr);
        long endTime = System.currentTimeMillis();
        assertSorted(res);
//        System.out.println("Parallel MergeSort ran in " + (endTime - currTime) + "ms");
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