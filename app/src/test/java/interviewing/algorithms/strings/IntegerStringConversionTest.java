package interviewing.algorithms.strings;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class IntegerStringConversionTest {

    @ParameterizedTest
    @MethodSource("integerStringConversionDataProvider")
    public void test(String inputStr, int outputNum) throws Exception {
        int atoiOut = IntegerStringConversion.atoi(inputStr);
        assertEquals(outputNum, atoiOut);
        String itoaOut = IntegerStringConversion.itoa(outputNum);
        assertEquals(inputStr, itoaOut);
    }

    private static Stream<Arguments> integerStringConversionDataProvider() {
        return Stream.of(
                Arguments.of(
                        "123",
                        123
                ),
                Arguments.of(
                        "-1234",
                        -1234
                ),
                Arguments.of(
                        "240",
                        240
                ),
                Arguments.of(
                        "0",
                        0
                ),
                Arguments.of(
                        "983012",
                        983012
                )
        );
    }
}