package interviewing.algorithms.bitmanipulation;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GetNextPowerOfTwoTest {

    @ParameterizedTest
    @MethodSource("nextPowerOfTwoDataProvider")
    public void testNextHighestPowerOfTwo(int input, int expected) {
        int out = GetNextPowerOfTwo.getNextHighestPowerOfTwo(new BinaryString(input));
        assertEquals(expected, out);
    }

    @ParameterizedTest
    @MethodSource("nextLowestPowerOfTwoDataProvider")
    public void testNextLowestPowerOfTwo(int input, int expected) {
        int out = GetNextPowerOfTwo.getNextLowestPowerOfTwo(new BinaryString(input));
        assertEquals(expected, out);
    }

    private static Stream<Arguments> nextPowerOfTwoDataProvider() {
        return Stream.of(
                Arguments.of(2, 2),
                Arguments.of(1, 1),
                Arguments.of(10, 16),
                Arguments.of(15, 16),
                Arguments.of(20, 32),
                Arguments.of(32, 32),
                Arguments.of(33, 64),
                Arguments.of(65, 128),
                Arguments.of(128, 128),
                Arguments.of(65535, 65536)
        );
    }

    private static Stream<Arguments> nextLowestPowerOfTwoDataProvider() {
        return Stream.of(
                Arguments.of(2, 2),
                Arguments.of(1, 1),
                Arguments.of(15, 8),
                Arguments.of(16, 16),
                Arguments.of(20, 16),
                Arguments.of(32, 32),
                Arguments.of(31, 16),
                Arguments.of(127, 64),
                Arguments.of(65535, 32768)
        );
    }
}