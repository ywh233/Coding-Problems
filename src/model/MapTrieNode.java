package model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by yuwei on 15/9/17.
 * Project: CodingProblems
 */

public class MapTrieNode<T> extends TrieNode<T> {
    private final Map<T, TrieNode<T>> children;

    public MapTrieNode(T value) {
        super(value);
        children = new HashMap<>();
        hasContent = false;
    }

    @Override
    public TrieNode<T> getChild(T value) {
        return children.get(value);
    }

    @Override
    public void setChild(T value, TrieNode<T> child) {
        if (child == null) {
            children.remove(value);
        } else {
            children.put(value, child);
        }
    }

    @Override
    public int countChildren() {
        return children.size();
    }

    public Collection<TrieNode<T>> viewChildrenValues() {
        return children.values();
    }
}