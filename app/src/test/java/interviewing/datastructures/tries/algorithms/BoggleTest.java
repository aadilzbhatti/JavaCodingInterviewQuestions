package interviewing.datastructures.tries.algorithms;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BoggleTest {

    @ParameterizedTest
    @MethodSource("boggleDataProvider")
    public void test(char[][] board, Set<String> dictionary, Set<String> expected) {
        Set<String> out = Boggle.getBoggleWords(board, dictionary);
        assertEquals(expected, out);
    }

    private static Stream<Arguments> boggleDataProvider() {
        return Stream.of(
                Arguments.of(
                        new char[][] {
                                new char[] { 'm', 's', 'e', 'f' },
                                new char[] { 'r', 'a', 't', 'd' },
                                new char[] { 'l', 'o', 'n', 'e' },
                                new char[] { 'k', 'a', 'f', 'b' }
                        },
                        Set.of("start", "note", "sand", "stoned", "stonedfe"),
                        Set.of("note", "sand", "stoned", "stonedfe")
                )
        );
    }
}