package interviewing.algorithms.bitmanipulation;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BitwiseAbsoluteValueTest {

    @ParameterizedTest
    @MethodSource("bitwiseAbsoluteValueDataProvider")
    public void test(int input, int expected) {
        int out = BitwiseAbsoluteValue.abs(input);
        assertEquals(expected, out);
    }

    private static Stream<Arguments> bitwiseAbsoluteValueDataProvider() {
        return Stream.of(
                Arguments.of(-3, 3),
                Arguments.of(3, 3),
                Arguments.of(12712934, 12712934),
                Arguments.of(-12712934, 12712934),
                Arguments.of(-12, 12),
                Arguments.of(12, 12)
        );
    }
}