package interviewing.algorithms.dynamicprogramming;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OneEditApartTest {

    @ParameterizedTest
    @MethodSource("oneEditApartDataProvider")
    public void testOneEditApart(String s1, String s2, boolean isOneEditApart) {
        boolean result = OneEditApart.oneEditApart(s1, s2);
        assertEquals(isOneEditApart, result);
    }

    private static Stream<Arguments> oneEditApartDataProvider() {
        return Stream.of(
                Arguments.of("cat", "dog", false),
                Arguments.of("cat", "cats", true),
                Arguments.of("cat", "cut", true),
                Arguments.of("cat", "cast", true),
                Arguments.of("cat", "at", true),
                Arguments.of("cat", "act", false)
        );
    }
}