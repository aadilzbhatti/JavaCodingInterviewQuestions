package interviewing.datastructures.tries.structure;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public abstract class TrieImpl implements Trie {
    protected Character key;
    private boolean isEndOfWord;

    public TrieImpl() {
        key = null;
        isEndOfWord = false;
    }

    @Override
    public boolean isEndOfWord() {
        return isEndOfWord;
    }

    @Override
    public void setEndOfWord() {
        isEndOfWord = true;
    }

    private List<String> getWordsForPrefixHelper(String prefix, int offset) {
        List<String> output = new ArrayList<>();
        if (offset == prefix.length()) {
            if (this.isEndOfWord()) {
                output.add("");
            }
            output.addAll(children().stream()
                    .map(trie -> new AbstractMap.SimpleImmutableEntry<>(trie.getCharacter(), trie.getWordsForPrefix("")))
                    .map(kv -> kv.getValue().stream()
                            .map(str -> kv.getKey() + str)
                            .collect(Collectors.toList()))
                    .flatMap(Collection::stream)
                    .collect(Collectors.toList()));
        } else {
            char c = prefix.charAt(offset);
            int pos = c - 'a';
            output.addAll(getChild(c).getWordsForPrefixHelper(prefix, offset + 1).stream()
                    .map(str -> c + str)
                    .collect(Collectors.toList()));
        }
        return output;
    }

    @Override
    public abstract TrieImpl getChild(char c);

    @Override
    public String toString() {
        return ("" + key) + children();
    }
}
