package interviewing.datastructures.tries.algorithms;

import interviewing.datastructures.tries.structure.ArrayTrie;
import interviewing.datastructures.tries.structure.Trie;

import java.util.Arrays;

public class LongestCommonPrefix {

    public static String longestCommonPrefix(String[] words) {
        Trie t = ArrayTrie.buildTrie(Arrays.asList(words));
        String longestPrefix = null;
        int maxLength = Integer.MIN_VALUE;
        for (Trie child : t.children()) {
            String prefix = getLongestPrefix(child);
            if (prefix.length() > maxLength) {
                maxLength = prefix.length();
                longestPrefix = prefix;
            }
        }
        return longestPrefix;
    }

    private static String getLongestPrefix(Trie t) {
        if (t.children().size() > 1 || t.children().isEmpty()) {
            return "" + t.getCharacter();
        }
        return "" + t.getCharacter() + getLongestPrefix(t.children().iterator().next());
    }
}
