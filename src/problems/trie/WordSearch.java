package problems.trie;

import model.TrieNode;

import java.util.*;

import static utils.TrieUtility.*;

/**
 * Created by yuwei on 15/9/17.
 * Project: CodingProblems
 */
public class WordSearch {
    public static List<String> findWords(char[][] board, String[] words) {
        TrieNode<Character> root = buildA2ZTrie(Arrays.asList(words));

        assert board.length > 0;
        boolean[][] visited = new boolean[board.length][board[0].length];

        Set<String> output = new LinkedHashSet<>();

        for (int i = 0; i < board.length; i++) {
            char[] row = board[i];
            for (int j = 0; j < row.length; j++) {
                getIn(board, visited, root, i, j, "", output);
            }
        }

        return new ArrayList<>(output);
    }

    private static void findWords(char[][] board, boolean[][] visited,
                                  int i, int j, TrieNode<Character> node,
                                  String prefix,
                                  Set<String> output) {
        if (node.hasContent) {
            output.add(prefix);
        }
        visited[i][j] = true;

        if (i > 0 && !visited[i-1][j]) {
            getIn(board, visited, node, i-1, j, prefix, output);
        }

        if (i < board.length - 1 && !visited[i+1][j]) {
            getIn(board, visited, node, i+1, j, prefix, output);
        }

        if (j > 0 && !visited[i][j-1]) {
            getIn(board, visited, node, i, j-1, prefix, output);
        }

        if (j < board[i].length - 1 && !visited[i][j+1]) {
            getIn(board, visited, node, i, j+1, prefix, output);
        }

        visited[i][j] = false;
    }

    private static void getIn(char[][] board, boolean[][] visited,
                              TrieNode<Character> node, int i, int j,
                              String prefix,
                              Set<String> output) {
        TrieNode<Character> nextNode = node.getChild(board[i][j]);
        if (nextNode != null) {
            findWords(board, visited, i, j, nextNode, prefix + nextNode.value, output);
        }
    }
}
