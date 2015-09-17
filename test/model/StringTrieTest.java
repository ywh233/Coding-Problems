package model;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class StringTrieTest {
    @Test
    public void test() {
        StringTrie trie = new StringTrie();
        trie.add("app");
        trie.add("api");
        trie.add("apple");
        trie.add("apply");
        trie.add("banana");
        trie.add("band");

        assertEquals(6, trie.size());

        assertTrue(trie.contains("app"));
        assertTrue(trie.contains("api"));
        assertTrue(trie.contains("apple"));
        assertTrue(trie.contains("apply"));
        assertTrue(trie.contains("banana"));
        assertTrue(trie.contains("band"));

        assertFalse(trie.contains("a"));
        assertFalse(trie.contains("ap"));
        assertFalse(trie.contains("appl"));
        assertFalse(trie.contains("b"));
        assertFalse(trie.contains("ban"));
        assertFalse(trie.contains("bando"));
        assertFalse(trie.contains("cat"));
        assertFalse(trie.contains(""));

        List<String> words = trie
                .stream()
                .collect(Collectors.toList());

        assertEquals(6, words.size());
    }
}