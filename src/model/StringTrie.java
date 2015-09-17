package model;

import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by yuwei on 15/9/16.
 * Project: Playground
 */
public class StringTrie extends AbstractCollection<String> {
    private final Trie<Character> trie;

    public StringTrie() {
        trie = new Trie<>();
    }

    @Override
    public Iterator<String> iterator() {
        Iterator<List<Character>> trieIter = trie.iterator();
        return new StringTrieIterator(trieIter);
    }

    @Override
    public int size() {
        return trie.size();
    }

    @Override
    public boolean add(String word) {
        return trie.add(strToList(word));
    }

    @Override
    public boolean contains(Object obj) {
        if (!(obj instanceof String)) {
            return false;
        }
        String word = (String)obj;
        return trie.contains(strToList(word));
    }

    private static String listToString(List<Character> characters) {
        StringBuilder sb = new StringBuilder();
        characters.forEach(sb::append);
        return sb.toString();
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

    private static class StringTrieIterator implements Iterator<String> {
        final Iterator<List<Character>> iter;

        private StringTrieIterator(Iterator<List<Character>> iter) {
            this.iter = iter;
        }

        @Override
        public boolean hasNext() {
            return iter.hasNext();
        }

        @Override
        public String next() {
            List<Character> word = iter.next();
            if (word == null) {
                return null;
            }
            return listToString(word);
        }
    }
}
