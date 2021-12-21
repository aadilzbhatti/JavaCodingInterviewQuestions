package interviewing.algorithms.bitmanipulation;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BitwiseDivisionTest {


    @ParameterizedTest
    @MethodSource("bitwiseDivisionDataProvider")
    public void test(int dividend, int divisor, int expectedQuotient) {
        int outQuotient = BitwiseDivision.divide(dividend, divisor);
        assertEquals(expectedQuotient, outQuotient);
    }

    private static Stream<Arguments> bitwiseDivisionDataProvider() {
        return Stream.of(
                Arguments.of(33, 19, 1),
                Arguments.of(33, 9, 3),
                Arguments.of(100, 10, 10),
                Arguments.of(100, 5, 20),
                Arguments.of(Integer.MAX_VALUE >> 2, 1, Integer.MAX_VALUE >> 2)
        );
    }
}