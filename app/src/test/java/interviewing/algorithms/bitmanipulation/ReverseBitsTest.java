package interviewing.algorithms.bitmanipulation;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReverseBitsTest {
    @ParameterizedTest
    @MethodSource("reverseBitsDataProvider")
    public void test(BinaryString input, BinaryString expected) {
        int output = ReverseBits.reverseBits(input.getNumber());
        assertEquals(expected.getNumber(), output);
    }

    private static Stream<Arguments> reverseBitsDataProvider() {
        return Stream.of(
                Arguments.of(new BinaryString("11010101"), new BinaryString("10101011")),
                Arguments.of(new BinaryString("11"), new BinaryString("11")),
                Arguments.of(new BinaryString("10"), new BinaryString("1"))
        );
    }
}