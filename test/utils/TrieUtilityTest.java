package utils;

import model.A2ZTrieNode;
import model.StringTrie;
import model.MapTrieNode;
import model.TrieNode;
import org.junit.Test;

import static org.junit.Assert.*;
import static utils.TrieUtility.addWord;
import static utils.TrieUtility.moveTo;

public class TrieUtilityTest {

    @Test
    public void testMoveTo() throws Exception {
        A2ZTrieNode root = new A2ZTrieNode(null);

        addWord(root, "app");
        addWord(root, "app");
        addWord(root, "api");
        addWord(root, "apple");
        addWord(root, "apply");
        addWord(root, "banana");
        addWord(root, "band");

        assertNull(moveTo(root, "haha"));
        TrieNode<Character> node = moveTo(root, "a");
        assertFalse(node.hasContent);
        node = moveTo(node, "pp");
        assertTrue(node.hasContent);
        assertNull(moveTo(node, "e"));
        node = moveTo(node, "l");
        assertFalse(node.hasContent);
        assertTrue(moveTo(node, "e").hasContent);
        assertTrue(moveTo(node, "y").hasContent);
        assertNull(moveTo(null, "233"));
    }
}