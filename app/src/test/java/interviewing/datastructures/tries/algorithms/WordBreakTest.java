package interviewing.datastructures.tries.algorithms;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WordBreakTest {

    @ParameterizedTest
    @MethodSource("wordBreakDataProvider")
    public void test(Set<String> dictionary, String word, boolean canBreak) {
        boolean out = WordBreak.canBreakWord(dictionary, word);
        assertEquals(canBreak, out);
    }

    private static Stream<Arguments> wordBreakDataProvider() {
        return Stream.of(
                Arguments.of(
                        Set.of("this", "th", "is", "famous", "Word", "break",
                                "b", "r", "e", "a", "k", "br", "bre", "brea", "ak", "problem"),
                        "Wordbreakproblem",
                        true
                ),
                Arguments.of(
                       Set.of("hello", "new", "world"),
                       "hell",
                       false
                )
        );
    }
}