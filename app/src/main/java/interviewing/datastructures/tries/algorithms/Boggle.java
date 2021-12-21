package interviewing.datastructures.tries.algorithms;

import interviewing.datastructures.tries.structure.ArrayTrie;
import interviewing.datastructures.tries.structure.Trie;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Boggle {

    public static Set<String> getBoggleWords(char[][] board, Set<String> dictionary) {
        Trie t = ArrayTrie.buildTrie(dictionary);
        boolean[][] visited = new boolean[board.length][board.length];
        Set<String> output = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                char c = board[i][j];
                if (t.hasChild(c)) {
                    visited[i][j] = true;
                    Set<String> words = search(t.getChild(c), i, j, board, visited);
                    output.addAll(words.stream().map(s -> c + s).collect(Collectors.toSet()));
                }
            }
        }
        return output;
    }

    private static Set<String> search(Trie t, int startI, int startJ, char[][] board, boolean[][] visited) {
        if (startI == board.length || startJ == board.length || startI < 0 || startJ < 0) {
            return Collections.singleton("");
        }
        Set<String> output = new HashSet<>();
        if (t.isEndOfWord()) {
            output.add("");
        }
        if (startI + 1 < board.length && startJ + 1 < board.length) {
            addWordsFromChildIfExists(t, startI + 1, startJ + 1, board, visited, output);
        }
        if (startI + 1 < board.length) {
            addWordsFromChildIfExists(t, startI + 1, startJ, board, visited, output);
        }
        if (startJ + 1 < board.length) {
            addWordsFromChildIfExists(t, startI, startJ + 1, board, visited, output);
        }
        if (startI - 1 >= 0 && startJ - 1 >= 0) {
            addWordsFromChildIfExists(t, startI - 1, startJ - 1, board, visited, output);
        }
        if (startI - 1 >= 0) {
            addWordsFromChildIfExists(t, startI - 1, startJ, board, visited, output);
        }
        if (startJ - 1 >= 0) {
            addWordsFromChildIfExists(t, startI, startJ - 1, board, visited, output);
        }
        if (startI - 1 >= 0 && startJ + 1 < board.length) {
            addWordsFromChildIfExists(t, startI - 1, startJ + 1, board, visited, output);
        }
        if (startI + 1 < board.length && startJ - 1 >= 0) {
            addWordsFromChildIfExists(t, startI + 1, startJ - 1, board, visited, output);
        }
        return output;
    }

    private static void addWordsFromChildIfExists(Trie t, int startI, int startJ, char[][] board, boolean[][] visited, Set<String> output) {
        char c = board[startI][startJ];
        if (t.hasChild(c) && !visited[startI][startJ]) {
            visited[startI][startJ] = true;
            Set<String> words = search(t.getChild(c), startI, startJ, board, visited);
            output.addAll(words.stream().map(s -> c + s).collect(Collectors.toSet()));
            visited[startI][startJ] = false;
        }
    }
}
