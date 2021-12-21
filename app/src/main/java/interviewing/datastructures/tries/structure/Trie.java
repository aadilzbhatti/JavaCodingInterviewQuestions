package interviewing.datastructures.tries.structure;

import java.util.Collection;
import java.util.List;

public interface Trie {
    void insert(String word);
    boolean contains(String word);
    Collection<Trie> children();
    Character getCharacter();
    List<String> getWordsForPrefix(String prefix);
    boolean hasChild(char c);
    Trie getChild(char c);
    boolean isEndOfWord();
    void setEndOfWord();
}
