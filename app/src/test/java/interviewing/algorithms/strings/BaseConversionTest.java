package interviewing.algorithms.strings;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BaseConversionTest {

    @ParameterizedTest
    @MethodSource("baseConversionDataProvider")
    public void test(String input, int b1, int b2, String expectedOutput) {
        String out = BaseConversion.convertFromBaseToBase(input, b1, b2);
        assertEquals(expectedOutput, out);
    }

    private static Stream<Arguments> baseConversionDataProvider() {
        return Stream.of(
                Arguments.of(
                        "615",
                        7,
                        13,
                        "1A7"
                ),
                Arguments.of(
                        "14",
                        10,
                        2,
                        "1110"
                ),
                Arguments.of(
                        "FFFF",
                        16,
                        10,
                        "65535"
                )
        );
    }
}