package interviewing.algorithms.stacks;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NormalizePathnamesTest {

    @ParameterizedTest
    @MethodSource("normalizePathnamesDataProvider")
    public void test(String pathname, String expected) {
        String out = NormalizePathnames.normalizePathname(pathname);
        assertEquals(expected, out);
    }

    public static Stream<Arguments> normalizePathnamesDataProvider() {
        return Stream.of(
                Arguments.of("/usr/lib/../bin/gcc", "/usr/bin/gcc"),
                Arguments.of("scripts//./../scripts/awkscripts/././", "scripts/awkscripts")
        );
    }
}