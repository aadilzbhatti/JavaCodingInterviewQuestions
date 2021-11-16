package interviewing.datastructures.trees.structure;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TrieTest {
    @Test
    public void testGetWordsForPrefix() {
        Trie t = Trie.buildTrie(new String[] { "category", "caterpillar", "cat", "dog", "elephant", "eternity", "cattino" });
        Set<String> expectedWordsForPrefix = new HashSet<>(Arrays.asList("category", "caterpillar", "cat", "cattino"));
        assertEquals(expectedWordsForPrefix, new HashSet<>(t.getWordsForPrefix("cat")));
    }

}