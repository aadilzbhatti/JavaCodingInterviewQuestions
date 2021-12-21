package interviewing.algorithms.bitmanipulation;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BitwisePowerTest {

    @ParameterizedTest
    @MethodSource("bitwisePowerDataProvider")
    public void test(int base, int exp, int expected) {
        int out = BitwisePower.power(base, exp);
        assertEquals(expected, out);
    }

    private static Stream<Arguments> bitwisePowerDataProvider() {
        return Stream.of(
                Arguments.of(2, 4, 16),
                Arguments.of(3, 4, 81),
                Arguments.of(2, 6, 64),
                Arguments.of(1, 10, 1),
                Arguments.of(2, 31, Integer.MIN_VALUE),
                Arguments.of(5, 0, 1),
                Arguments.of(-3, 3, -27),
                Arguments.of(4, 3, 64),
                Arguments.of(4, 4, 256),
                Arguments.of(3, 10, 59049)
        );
    }
}