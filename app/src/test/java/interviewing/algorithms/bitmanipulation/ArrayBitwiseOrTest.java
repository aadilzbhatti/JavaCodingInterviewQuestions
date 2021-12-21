package interviewing.algorithms.bitmanipulation;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ArrayBitwiseOrTest {

    @ParameterizedTest
    @MethodSource("arrayBitwiseOrDataProvider")
    public void test(int[] arr, int expectedResults) {
        int numResults = ArrayBitwiseOr.numBitwiseOrResults(arr);
        assertEquals(expectedResults, numResults);
    }

    private static Stream<Arguments> arrayBitwiseOrDataProvider() {
        return Stream.of(
                Arguments.of(new int[] { 0 }, 1),
                Arguments.of(new int[] { 1, 1, 2 }, 3),
                Arguments.of(new int[] { 1, 2, 4 }, 6)
        );
    }
}