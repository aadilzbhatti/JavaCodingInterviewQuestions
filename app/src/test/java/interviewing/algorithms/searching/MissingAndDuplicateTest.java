package interviewing.algorithms.searching;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MissingAndDuplicateTest {

    @ParameterizedTest
    @MethodSource("missingAndDuplicateDataProvider")
    public void test(int[] arr, MissingAndDuplicate expected) {
        MissingAndDuplicate out = MissingAndDuplicate.findMissingAndDuplicateElements(arr);
        assertEquals(expected, out);
    }

    private static Stream<Arguments> missingAndDuplicateDataProvider() {
        return Stream.of(
                Arguments.of(
                        new int[] { 0, 1, 2, 3, 3, 5 },
                        new MissingAndDuplicate(4, 3)
                )
        );
    }
}