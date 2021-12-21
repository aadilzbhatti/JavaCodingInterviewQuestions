package interviewing.datastructures.tries.algorithms;

import interviewing.datastructures.tries.structure.ArrayTrie;
import interviewing.datastructures.tries.structure.Trie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class LexicographicSorting {
    public static List<String> lexicographicSorting(List<String> words) {
        ArrayTrie t = ArrayTrie.buildTrie(words);
        return getSorted(t);
    }

    private static List<String> getSorted(Trie t) {
        if (t.children().isEmpty()) {
            return Collections.singletonList("" + t.getCharacter());
        }
        List<Trie> childTries = new ArrayList<>(t.children());
        childTries.sort(Comparator.comparingInt(Trie::getCharacter));
        List<String> output = new ArrayList<>();
        for (Trie child : childTries) {
            List<String> sorted = getSorted(child);
            output.addAll(sorted.stream()
                    .map(s -> child.getCharacter() + s)
                    .collect(Collectors.toList()));
        }
        return output;
    }
}
