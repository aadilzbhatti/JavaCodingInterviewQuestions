package interviewing.datastructures.tries.algorithms;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

class LexicographicSortingTest {

    @ParameterizedTest
    @MethodSource("lexicographicSortingDataProvider")
    public void test(List<String> words) {
        List<String> sorted = LexicographicSorting.lexicographicSorting(words);
        assertSorted(sorted);
    }

    private void assertSorted(List<String> words) {
        for (int i = 0; i < words.size() - 1; i++) {
            assertTrue(words.get(i).compareTo(words.get(i + 1)) < 1);
        }
    }

    private static Stream<Arguments> lexicographicSortingDataProvider() {
        return Stream.of(
                Arguments.of(
                        Arrays.asList("alpha", "beta", "andrew", "albert", "camus", "beetles")
                ),
                Arguments.of(
                        Arrays.asList("asdhf", "sakhdf", "aslkjdff", "asd", "cndjfhe", "ergvev", "zeahfhje", "elkjd", "kxjss", "mllorp", "qertcn")
                )
        );
    }
}