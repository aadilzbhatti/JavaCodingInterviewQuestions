package interviewing.algorithms.sorting;

import interviewing.algorithms.concurrency.ParallelQuicksort;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

class QuicksortTest {

    private ForkJoinPool pool = new ForkJoinPool(10);

    @ParameterizedTest
    @MethodSource("quicksortDataProvider")
    public void testQuicksort(int[] arr) {
        long startTime = System.currentTimeMillis();
        Quicksort.quicksort(arr);
        long totalTime = System.currentTimeMillis() - startTime;
        assertSorted(arr);
//        System.out.println("Quicksort completed of " + arr.length + " elements completed in " + totalTime + "ms");
    }

    @ParameterizedTest
    @MethodSource("quicksortDataProvider")
    public void testParallelQuicksort(int[] arr) {
        long startTime = System.currentTimeMillis();
        pool.invoke(new ParallelQuicksort(arr));
        long totalTime = System.currentTimeMillis() - startTime;
        assertSorted(arr);
//        System.out.println("Parallel quicksort of " + arr.length + " elements completed in " + totalTime + "ms");
    }

    private void assertSorted(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            assertTrue(arr[i] <= arr[i + 1]);
        }
    }

    private static int[] generateRandomArrayOfLength(int n) {
        int[] out = new int[n];
        for (int i = 0; i < n; i++) {
            out[i] = new Random().nextInt();
        }
        return out;
    }

    private static Stream<Arguments> quicksortDataProvider() {
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
                ),
                Arguments.of(
                        generateRandomArrayOfLength(100)
                ),
                Arguments.of(
                        generateRandomArrayOfLength(1000)
                ),
                Arguments.of(
                        generateRandomArrayOfLength(10000)
                )
        );
    }
}