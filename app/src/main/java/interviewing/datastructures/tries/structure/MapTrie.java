package interviewing.datastructures.tries.structure;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MapTrie extends TrieImpl {
    private Character prefixChar;
    private boolean isEndOfWord;
    private Map<Character, Trie> childTries;

    public MapTrie() {
        this(null);
    }

    public MapTrie(Character prefixChar) {
        this.prefixChar = prefixChar;
        this.isEndOfWord = false;
        this.childTries = new HashMap<>();
    }

    @Override
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

    @Override
    public Collection<Trie> children() {
        return childTries.values();
    }

    @Override
    public Character getCharacter() {
        return prefixChar;
    }

    @Override
    public void insert(String word) {
        if (word.isEmpty()) {
            this.isEndOfWord = true;
        } else {
            this.addNewChild(word.charAt(0));
            this.getChild(word.charAt(0)).insert(word.substring(1));
        }
    }

    @Override
    public boolean contains(String word) {
        if (word.isEmpty()) {
            return this.isEndOfWord;
        }
        if (this.getChild(word.charAt(0)) == null) {
            return false;
        }
        return this.getChild(word.charAt(0)).contains(word.substring(1));
    }

    private void addNewChild(Character c) {
        childTries.putIfAbsent(c, new MapTrie(c));
    }

    @Override
    public boolean hasChild(char c) {
        return childTries.containsKey(c);
    }

    @Override
    public MapTrie getChild(char c) {
        return (MapTrie) childTries.get(c);
    }

    @Override
    public boolean isEndOfWord() {
        return isEndOfWord;
    }

    public static MapTrie buildTrie(Collection<String> words) {
        MapTrie res = new MapTrie();

        for (String word : words) {
            res.insert(word);
        }

        return res;
    }

    @Override
    public String toString() {
        return childTries.toString();
    }
}
