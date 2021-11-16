package interviewing.datastructures.trees.structure;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Trie {
    private Character prefixChar;
    private boolean isEndOfWord;
    private Map<Character, Trie> childTries;

    public Trie() {
        this(null);
    }

    public Trie(Character prefixChar) {
        this.prefixChar = prefixChar;
        this.isEndOfWord = false;
        this.childTries = new HashMap<>();
    }

    public List<String> getWordsForPrefix(String prefix) {
        List<String> output = new ArrayList<>();
        if (prefix.isEmpty()) {
            if (this.isEndOfWord) {
                output.add("");
            }
            if (!this.childTries.isEmpty()) {
                output.addAll(this.childTries.entrySet().stream()
                        .map(kv -> new AbstractMap.SimpleImmutableEntry<>(kv.getKey(), kv.getValue().getWordsForPrefix("")))
                        .map(kv -> kv.getValue().stream()
                                .map(str -> kv.getKey() + str)
                                .collect(Collectors.toList()))
                        .flatMap(Collection::stream)
                        .collect(Collectors.toList())
                );
            }
        } else {
            char prefixChar = prefix.charAt(0);
            output.addAll(this.childTries.get(prefixChar)
                    .getWordsForPrefix(prefix.substring(1)).stream()
                    .map(result -> prefixChar + result)
                    .collect(Collectors.toList())
            );
        }

        return output;
    }

    private void addNewChild(Character c) {
        childTries.putIfAbsent(c, new Trie(c));
    }

    private Trie getChild(Character c) {
        return childTries.get(c);
    }

    private void addWord(String word) {
        if (word.isEmpty()) {
            this.isEndOfWord = true;
        } else {
            this.addNewChild(word.charAt(0));
            this.getChild(word.charAt(0)).addWord(word.substring(1));
        }
    }

    public static Trie buildTrie(String[] words) {
        Trie res = new Trie();

        for (String word : words) {
            res.addWord(word);
        }

        return res;
    }

    @Override
    public String toString() {
        return childTries.toString();
    }
}
