package interviewing.datastructures.tries.algorithms;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ShortestUniquePrefixTest {

    @ParameterizedTest
    @MethodSource("shortestUniquePrefixDataProvider")
    public void test(Set<String> input, Set<String> expectedOutput) {
        Set<String> output = ShortestUniquePrefix.getShortestUniquePrefix(input);
        assertEquals(expectedOutput, output);
    }

    private static Stream<Arguments> shortestUniquePrefixDataProvider() {
        return Stream.of(
                Arguments.of(
                        Set.of("and", "bonfire", "bool", "case", "catch", "char"),
                        Set.of("a", "bon", "boo", "cas", "cat", "ch")
                )
        );
    }
}