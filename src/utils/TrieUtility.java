package utils;

import model.A2ZTrieNode;
import model.MapTrieNode;
import model.TrieNode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by yuwei on 15/9/17.
 * Project: CodingProblems
 */
public class TrieUtility {
    public static <T> TrieNode<T> moveTo(TrieNode<T> node, List<T> prefix) {
        if (node == null) {
            return null;
        }
        for (T item : prefix) {
            TrieNode<T> next = node.getChild(item);
            if (next == null) {
                return null;
            }
            node = next;
        }
        return node;
    }

    public static TrieNode<Character> moveTo(TrieNode<Character> node, String prefix) {
        return moveTo(node, strToList(prefix));
    }

    public static <T> void addContentWithMapNode(TrieNode<T> node, List<T> list) {
        for (T cur : list) {
            TrieNode<T> nextNode = node.getChild(cur);
            if (nextNode == null) {
                nextNode = new MapTrieNode<>(cur);
                node.setChild(cur, nextNode);
            }
            node = nextNode;
        }
        node.hasContent = true;
    }

    public static void addWord(TrieNode<Character> node, String word) {
        for (int i = 0; i < word.length(); i++) {
            char cur = word.charAt(i);
            TrieNode<Character> nextNode = node.getChild(cur);
            if (nextNode == null) {
                nextNode = new A2ZTrieNode(cur);
                node.setChild(cur, nextNode);
            }
            node = nextNode;
        }
        node.hasContent = true;
    }

    public static A2ZTrieNode buildA2ZTrie(Collection<String> words) {
        A2ZTrieNode root = new A2ZTrieNode(null);

        for (String word : words) {
            addWord(root, word);
        }

        return root;
    }

    private static List<Character> strToList(String str) {
        char[] array = new char[str.length()];
        str.getChars(0, str.length(), array, 0);
        List<Character> characters = new ArrayList<>(str.length());
        for (char ch : array) {
            characters.add(ch);
        }
        return characters;
    }
}
