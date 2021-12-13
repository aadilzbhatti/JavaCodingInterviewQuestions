package interviewing.algorithms.strings;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SpreadsheetColumnNameConverterTest {

    @ParameterizedTest
    @MethodSource("spreadsheetColumnNameConverterDataProvider")
    public void test(String columnName, int expectedOutput) {
        int out = SpreadsheetColumnNameConverter.getNumberForColumnName(columnName);
        assertEquals(expectedOutput, out);
    }

    private static Stream<Arguments> spreadsheetColumnNameConverterDataProvider() {
        return Stream.of(
                Arguments.of(
                        "A",
                        1
                ),
                Arguments.of(
                        "AA",
                        27
                ),
                Arguments.of(
                        "D",
                        4
                ),
                Arguments.of(
                        "ZZ",
                        702
                ),
                Arguments.of(
                        "AAA",
                        703
                ),
                Arguments.of(
                        "ABCDEFG",
                        334123303
                )
        );
    }
}