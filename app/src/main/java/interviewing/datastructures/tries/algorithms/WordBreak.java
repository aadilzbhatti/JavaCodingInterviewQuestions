package interviewing.datastructures.tries.algorithms;

import interviewing.datastructures.tries.structure.MapTrie;
import interviewing.datastructures.tries.structure.Trie;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class WordBreak {

    public static boolean canBreakWord(Set<String> dictionary, String word) {
        Trie t = MapTrie.buildTrie(dictionary);
        List<List<String>> res = decomp(t, word, 0, new ArrayList<>());
        return !res.isEmpty();
    }

    private static List<List<String>> decomp(Trie trie, String s, int start, List<String> currOutput) {
        if (s.length() == start) {
            return List.of(new ArrayList<>(currOutput));
        }
        List<List<String>> res = new ArrayList<>();
        for (int i = start; i < s.length() + 1; i++) {
            String currSubstring = s.substring(start, i);
            if (trie.contains(currSubstring)) {
                currOutput.add(currSubstring);
                List<List<String>> decomps = decomp(trie, s, i, currOutput);
                currOutput.remove(currSubstring);
                res.addAll(decomps);
            }
        }
        return res;
    }
}
