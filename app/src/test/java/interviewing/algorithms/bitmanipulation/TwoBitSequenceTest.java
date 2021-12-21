package interviewing.algorithms.bitmanipulation;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TwoBitSequenceTest {

    @ParameterizedTest
    @MethodSource("twoBitSequenceDataProvider")
    public void test(int n, int expectedVal) {
        int out = TwoBitSequence.getNthElement(n);
        assertEquals(expectedVal, out);
    }

    private static Stream<Arguments> twoBitSequenceDataProvider() {
        return Stream.of(
                Arguments.of(1, 3),
                Arguments.of(2, 5),
                Arguments.of(3, 6),
                Arguments.of(4, 9),
                Arguments.of(5, 10),
                Arguments.of(6, 12),
                Arguments.of(7, 17),
                Arguments.of(8, 18),
                Arguments.of(9, 20),
                Arguments.of(10, 24),
                Arguments.of(11, 33),
                Arguments.of(12, 34),
                Arguments.of(13, 36),
                Arguments.of(14, 40),
                Arguments.of(15, 48)
        );
    }
}