package interviewing.datastructures.tries.algorithms;

import interviewing.datastructures.tries.structure.ArrayTrieWithFrequency;

import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class KMaximumOccurringStrings {

    public static Set<String> getKMaximumOccurringStrings(List<String> words, int k) {
        ArrayTrieWithFrequency trie = ArrayTrieWithFrequency.buildTrie(words);
        PriorityQueue<StringWithFrequency> pq = new PriorityQueue<>();
        for (ArrayTrieWithFrequency child : trie.getChildren()) {
            Set<StringWithFrequency> stringsWithFrequency = getStringsWithFrequency(child);
            pq.addAll(stringsWithFrequency);
        }
        Set<String> output = new HashSet<>();
        for (int i = 0; i < k; i++) {
            if (pq.isEmpty()) {
                break;
            }
            output.add(pq.poll().string);
        }
        return output;
    }

    private static Set<StringWithFrequency> getStringsWithFrequency(ArrayTrieWithFrequency trie) {
        Set<StringWithFrequency> output = new HashSet<>();
        getStringsHelper(trie, "", output);
        return output;
    }

    private static void getStringsHelper(ArrayTrieWithFrequency trie, String currWord, Set<StringWithFrequency> output) {
        if (trie == null) return;
        if (trie.isEndOfWord()) {
            output.add(new StringWithFrequency(currWord + trie.getCharacter().toString(), trie.getFrequency()));
        }
        for (ArrayTrieWithFrequency child : trie.getChildren()) {
            String toAdd;
            if (trie.getCharacter() == null) {
                toAdd = "";
            } else {
                toAdd = trie.getCharacter().toString();
            }
            getStringsHelper(child, currWord + toAdd, output);
        }
    }

    private static class StringWithFrequency implements Comparable<StringWithFrequency> {
        String string;
        int frequency;

        public StringWithFrequency(String string, int frequency) {
            this.string = string;
            this.frequency = frequency;
        }

        @Override
        public int compareTo(StringWithFrequency stringWithFrequency) {
            return Integer.compare(stringWithFrequency.frequency, this.frequency);
        }

        @Override
        public String toString() {
            return "(" + string + ", " + frequency + ")";
        }
    }
}
