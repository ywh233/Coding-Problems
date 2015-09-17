package model;

/**
 * Created by yuwei on 15/9/17.
 * Project: CodingProblems
 */
public class A2ZTrieNode extends TrieNode<Character> {
    private static final int ARRAY_SIZE = 26;
    private final TrieNode<Character>[] children;
    private int count;

    public A2ZTrieNode(Character value) {
        super(value);
        children = new A2ZTrieNode[ARRAY_SIZE];
        count = 0;
    }

    @Override
    public TrieNode<Character> getChild(Character letter) {
        return children[validateLetter(letter)];
    }

    @Override
    public void setChild(Character letter, TrieNode<Character> node) {
        int index = validateLetter(letter);
        if (node != null && children[index] == null) {
            count++;
        } else if (node == null && children[index] != null) {
            count--;
        }
        children[index] = node;
    }

    @Override
    public int countChildren() {
        return count;
    }

    private static int validateLetter(char letter) {
        letter = Character.toLowerCase(letter);
        if (letter < 'a' || letter > 'z') {
            throw new IllegalArgumentException("Letter must be between a/A and z/Z");
        }
        return letter - 'a';
    }
}
