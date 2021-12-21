package interviewing.datastructures.trees.algorithms;

import interviewing.datastructures.tries.algorithms.LongestCommonPrefix;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LongestCommonPrefixTest {

    @ParameterizedTest
    @MethodSource("longestCommonPrefixDataProvider")
    public void test(String[] words, String expectedLongestPrefix) {
        String longestPrefix = LongestCommonPrefix.longestCommonPrefix(words);
        assertEquals(expectedLongestPrefix, longestPrefix);
    }

    private static Stream<Arguments> longestCommonPrefixDataProvider() {
        return Stream.of(
                Arguments.of(
                        new String[] { "codable", "code", "coder", "coding" },
                        "cod"
                ),
                Arguments.of(
                        new String[] { "coder", "baker", "camper", "baller" },
                        "ba"
                )
        );
    }
}