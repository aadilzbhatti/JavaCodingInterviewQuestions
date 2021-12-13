package interviewing.algorithms.strings;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WrapTextTest {

    @ParameterizedTest
    @MethodSource("wrapTextDataProvider")
    public void test(String body, int lineLength, String expectedWrapped) {
        String output = WrapText.wrapText(body, lineLength);
        assertEquals(expectedWrapped, output);
    }

    private static Stream<Arguments> wrapTextDataProvider() {
        return Stream.of(
                Arguments.of(
                        "abc de f gh ijkl m no pqrstu",
                        5,
                        "abc \nde f \ngh \nijkl \nm no \npqrstu\n"
                ),
                Arguments.of(
                        "abcdefghijklmnop",
                        5,
                        "abcdefghijklmnop\n"
                ),
                Arguments.of(
                        "abcd fghi jklm nopq",
                        5,
                        "abcd \nfghi \njklm \nnopq\n"
                ),
                Arguments.of(
                        "a b c d e f g h i j k l m n o p q r s t u v w x y z",
                        5,
                        "a b c\n d e \nf g h\n i j \nk l m\n n o \np q r\n s t \nu v w\n x y \nz\n"
                )
        );
    }
}