package interviewing.datastructures.trees.structure;

import interviewing.datastructures.tries.structure.ArrayTrie;
import interviewing.datastructures.tries.structure.MapTrie;
import interviewing.datastructures.tries.structure.Trie;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TrieTest {
    @ParameterizedTest
    @MethodSource("trieDataProvider")
    public void testMapTrie(Trie trie) {
        Stream.of("category", "caterpillar", "cat", "dog", "elephant", "eternity", "cattino")
            .forEach(trie::insert);
        Set<String> expectedWordsForPrefix = new HashSet<>(Arrays.asList("category", "caterpillar", "cat", "cattino"));
        assertEquals(expectedWordsForPrefix, new HashSet<>(trie.getWordsForPrefix("cat")));
    }

    private static Stream<Arguments> trieDataProvider() {
        return Stream.of(
                Arguments.of(new MapTrie()),
                Arguments.of(new ArrayTrie())
        );
    }
}