package model;

/**
 * Created by yuwei on 15/9/17.
 * Project: CodingProblems
 */
public abstract class TrieNode<T> {
    public final T value;
    public boolean hasContent;

    protected TrieNode(T value) {
        this.value = value;
    }

    public abstract TrieNode<T> getChild(T value);
    public abstract void setChild(T value, TrieNode<T> child);
    public abstract int countChildren();

    public boolean isLeaf() {
        return countChildren() == 0;
    }
}
