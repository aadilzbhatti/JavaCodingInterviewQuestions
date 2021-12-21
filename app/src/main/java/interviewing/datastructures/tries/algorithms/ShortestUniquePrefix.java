package interviewing.datastructures.tries.algorithms;

import interviewing.datastructures.tries.structure.ArrayTrieWithFrequency;

import java.util.HashSet;
import java.util.Set;

public class ShortestUniquePrefix {

    public static Set<String> getShortestUniquePrefix(Set<String> words) {
        ArrayTrieWithFrequency trie = ArrayTrieWithFrequency.buildTrie(words);
        Set<String> output = new HashSet<>();
        shortestUniquePrefixHelper(trie, "", output);
        return output;
    }

    private static void shortestUniquePrefixHelper(ArrayTrieWithFrequency trie, String currWord, Set<String> output) {
        if (trie == null) return;
        if (trie.getFrequency() == 1) {
            output.add(currWord + trie.getCharacter().toString());
        } else {
            for (ArrayTrieWithFrequency child : trie.getChildren()) {
                String toAdd;
                if (trie.getCharacter() == null) {
                    toAdd = "";
                } else {
                    toAdd = trie.getCharacter().toString();
                }
                shortestUniquePrefixHelper(child, currWord + toAdd, output);
            }
        }
    }
}
